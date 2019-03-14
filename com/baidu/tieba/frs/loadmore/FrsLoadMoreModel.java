package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.i;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int dSu;
    private k fak;
    private final com.baidu.tieba.frs.loadmore.a fqA;
    private boolean fqB;
    private long fqC;
    private final ArrayList<m> fqD;
    private final ArrayList<String> fqE;
    private final ArrayList<m> fqF;
    private c.a fqG;
    private final com.baidu.adp.framework.listener.a fqH;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void R(ArrayList<m> arrayList);

        void uF(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fqB = false;
        this.fqC = 0L;
        this.fqD = new ArrayList<>();
        this.fqE = new ArrayList<>();
        this.fqF = new ArrayList<>();
        this.mPn = 1;
        this.dSu = -1;
        this.mPageType = 1;
        this.fqH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fqA != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fqA.uF(FrsLoadMoreModel.this.fqA.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fqA.uF(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fqA.uF(FrsLoadMoreModel.this.fqA.getPageContext().getString(d.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bcR = FrsLoadMoreModel.this.fqA.bcR();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bcR != null) {
                                bcR.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fqA.R(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fqA instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fqA).cqv = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bcR != null) {
                                bcR.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fqA.R(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fqA instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fqA).cqv = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fqA.getForumName()) && r.bWJ().bWD() != null) {
                            r.bWJ().bWD().g(FrsLoadMoreModel.this.fqA.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fqA = aVar;
        setUniqueId(this.fqA.getUniqueId());
        this.fak = kVar;
        this.fqH.getHttpMessageListener().setSelfListener(true);
        this.fqH.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fqH);
    }

    public int bcv() {
        return this.dSu;
    }

    public void setHasMore(int i) {
        this.dSu = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void setPageType(int i) {
        this.mPageType = i;
    }

    public void registerListener() {
        registerListener(this.fqH);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.T(list)) {
            this.loadingDone = true;
            return;
        }
        String cc = cc(list);
        if (!TextUtils.isEmpty(cc)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cc);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(y.aqn(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fqC = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bWJ().bWD() != null) {
            loadMoreRequestMessage.setLoadCount(r.bWJ().bWD().as(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fqB) {
            this.fqB = true;
            if (com.baidu.tbadk.o.m.apk().apl() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fqC)) != null) {
                iVar.apg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fqB) {
            this.fqB = true;
            if (com.baidu.tbadk.o.m.apk().apl() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fqC)) != null) {
                iVar.apg();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apk().apl() && (this.fqA instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fqC;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fqA).cqv, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cqE = currentTimeMillis;
                iVar.fe(true);
            }
        }
    }

    private String cc(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.loadingDone = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.loadIndex != 0) {
            if (this.loadIndex != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.loadingDone = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.loadingDone = true;
            }
            Long l = list.get(i3);
            if (l != null) {
                if (i3 == i - 1) {
                    sb.append(l);
                } else {
                    sb.append(l).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void resetData() {
        this.loadIndex = 0;
        this.loadingDone = false;
        this.fqD.clear();
        this.fqE.clear();
        this.fqF.clear();
        this.dSu = -1;
        this.mPn = 1;
    }

    public boolean cd(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fqD.clear();
            this.fqE.clear();
            this.fqF.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fqD.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bf) {
                bg bgVar = ((bf) next).threadData;
                if (bgVar.getTid() != null) {
                    hashSet.add(bgVar.getTid());
                }
            } else if (next instanceof bg) {
                bg bgVar2 = (bg) next;
                if (bgVar2.getTid() != null) {
                    hashSet.add(bgVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.T(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bf) {
                    bg bgVar3 = ((bf) next2).threadData;
                    bgVar3.lj(this.fqA.getForumName());
                    if (bgVar3.Zo()) {
                        if (!hashSet.contains(bgVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bf) next2).threadData.tid)) {
                                arrayList3.add(((bf) next2).threadData.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bf) next2).threadData.tid)) {
                            arrayList3.add(((bf) next2).threadData.tid);
                        }
                    }
                } else if (next2 instanceof bg) {
                    bg bgVar4 = (bg) next2;
                    bgVar4.lj(this.fqA.getForumName());
                    if (bgVar4.Zo()) {
                        if (!hashSet.contains(bgVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bgVar4.tid)) {
                                arrayList3.add(bgVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bgVar4.tid)) {
                            arrayList3.add(bgVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.fak != null) {
            this.fak.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int agx = TbadkCoreApplication.getInst().getListItemRule().agx() - this.fqD.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < agx) {
                this.fqD.add(arrayList2.get(i));
            } else {
                this.fqF.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList4 = new ArrayList<>();
        arrayList4.addAll(this.fqD);
        arrayList4.addAll(this.fqF);
        if (this.fqA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fqA, this.fqA.bcR(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList4);
        }
        return arrayList4;
    }

    public ArrayList<m> bhA() {
        int i;
        int size = this.fqF.size() + 30;
        int agw = TbadkCoreApplication.getInst().getListItemRule().agw() * 3;
        if (size > agw && this.fqF.size() > (i = size - agw)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fqF.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fqD);
        arrayList.addAll(this.fqF);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fqG = aVar;
    }

    public void bhB() {
        int i;
        int size = this.fqF.size() + 30;
        int agw = TbadkCoreApplication.getInst().getListItemRule().agw() * 3;
        int S = v.S(this.fqD);
        if (size > agw && this.fqF.size() > (i = size - agw)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fqF.remove(0);
                if (this.fqG != null) {
                    this.fqG.removeItem(S);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fqD != null) {
                this.fqD.remove(mVar);
            }
            if (this.fqF != null) {
                this.fqF.remove(mVar);
            }
        }
    }
}
