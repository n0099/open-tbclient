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
    private int dRM;
    private k eZX;
    private final com.baidu.tieba.frs.loadmore.a fqm;
    private boolean fqn;
    private long fqo;
    private final ArrayList<m> fqp;
    private final ArrayList<String> fqq;
    private final ArrayList<m> fqr;
    private c.a fqs;
    private final com.baidu.adp.framework.listener.a fqt;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void R(ArrayList<m> arrayList);

        void uE(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fqn = false;
        this.fqo = 0L;
        this.fqp = new ArrayList<>();
        this.fqq = new ArrayList<>();
        this.fqr = new ArrayList<>();
        this.mPn = 1;
        this.dRM = -1;
        this.mPageType = 1;
        this.fqt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fqm != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fqm.uE(FrsLoadMoreModel.this.fqm.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fqm.uE(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fqm.uE(FrsLoadMoreModel.this.fqm.getPageContext().getString(d.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bcP = FrsLoadMoreModel.this.fqm.bcP();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bcP != null) {
                                bcP.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fqm.R(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fqm instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fqm).cqy = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bcP != null) {
                                bcP.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fqm.R(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fqm instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fqm).cqy = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fqm.getForumName()) && r.bWF().bWz() != null) {
                            r.bWF().bWz().g(FrsLoadMoreModel.this.fqm.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fqm = aVar;
        setUniqueId(this.fqm.getUniqueId());
        this.eZX = kVar;
        this.fqt.getHttpMessageListener().setSelfListener(true);
        this.fqt.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fqt);
    }

    public int bct() {
        return this.dRM;
    }

    public void setHasMore(int i) {
        this.dRM = i;
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
        registerListener(this.fqt);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.T(list)) {
            this.loadingDone = true;
            return;
        }
        String bZ = bZ(list);
        if (!TextUtils.isEmpty(bZ)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bZ);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(y.aqk(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fqo = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bWF().bWz() != null) {
            loadMoreRequestMessage.setLoadCount(r.bWF().bWz().as(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fqn) {
            this.fqn = true;
            if (com.baidu.tbadk.o.m.apg().aph() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fqo)) != null) {
                iVar.apd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fqn) {
            this.fqn = true;
            if (com.baidu.tbadk.o.m.apg().aph() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fqo)) != null) {
                iVar.apd();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apg().aph() && (this.fqm instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fqo;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fqm).cqy, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cqH = currentTimeMillis;
                iVar.fe(true);
            }
        }
    }

    private String bZ(List<Long> list) {
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
        this.fqp.clear();
        this.fqq.clear();
        this.fqr.clear();
        this.dRM = -1;
        this.mPn = 1;
    }

    public boolean ca(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fqp.clear();
            this.fqq.clear();
            this.fqr.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fqp.iterator();
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
                    bgVar3.lk(this.fqm.getForumName());
                    if (bgVar3.Zl()) {
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
                    bgVar4.lk(this.fqm.getForumName());
                    if (bgVar4.Zl()) {
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
        if (this.eZX != null) {
            this.eZX.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int agu = TbadkCoreApplication.getInst().getListItemRule().agu() - this.fqp.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < agu) {
                this.fqp.add(arrayList2.get(i));
            } else {
                this.fqr.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList4 = new ArrayList<>();
        arrayList4.addAll(this.fqp);
        arrayList4.addAll(this.fqr);
        if (this.fqm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fqm, this.fqm.bcP(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList4);
        }
        return arrayList4;
    }

    public ArrayList<m> bhy() {
        int i;
        int size = this.fqr.size() + 30;
        int agt = TbadkCoreApplication.getInst().getListItemRule().agt() * 3;
        if (size > agt && this.fqr.size() > (i = size - agt)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fqr.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fqp);
        arrayList.addAll(this.fqr);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fqs = aVar;
    }

    public void bhz() {
        int i;
        int size = this.fqr.size() + 30;
        int agt = TbadkCoreApplication.getInst().getListItemRule().agt() * 3;
        int S = v.S(this.fqp);
        if (size > agt && this.fqr.size() > (i = size - agt)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fqr.remove(0);
                if (this.fqs != null) {
                    this.fqs.removeItem(S);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fqp != null) {
                this.fqp.remove(mVar);
            }
            if (this.fqr != null) {
                this.fqr.remove(mVar);
            }
        }
    }
}
