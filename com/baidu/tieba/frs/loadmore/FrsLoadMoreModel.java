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
import com.baidu.tbadk.p.i;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
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
    private int ecl;
    private final com.baidu.tieba.frs.loadmore.a fGH;
    private boolean fGI;
    private long fGJ;
    private final ArrayList<m> fGK;
    private final ArrayList<String> fGL;
    private final ArrayList<m> fGM;
    private c.a fGN;
    private final com.baidu.adp.framework.listener.a fGO;
    private k fql;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void V(ArrayList<m> arrayList);

        void vY(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fGI = false;
        this.fGJ = 0L;
        this.fGK = new ArrayList<>();
        this.fGL = new ArrayList<>();
        this.fGM = new ArrayList<>();
        this.mPn = 1;
        this.ecl = -1;
        this.mPageType = 1;
        this.fGO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fGH != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fGH.vY(FrsLoadMoreModel.this.fGH.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fGH.vY(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fGH.vY(FrsLoadMoreModel.this.fGH.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bkj = FrsLoadMoreModel.this.fGH.bkj();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bkj != null) {
                                bkj.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fGH.V(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fGH instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fGH).cyE = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bkj != null) {
                                bkj.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fGH.V(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fGH instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fGH).cyE = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fGH.getForumName()) && r.ceJ().ceD() != null) {
                            r.ceJ().ceD().g(FrsLoadMoreModel.this.fGH.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fGH = aVar;
        setUniqueId(this.fGH.getUniqueId());
        this.fql = kVar;
        this.fGO.getHttpMessageListener().setSelfListener(true);
        this.fGO.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fGO);
    }

    public int bjN() {
        return this.ecl;
    }

    public void setHasMore(int i) {
        this.ecl = i;
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
        registerListener(this.fGO);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.aa(list)) {
            this.loadingDone = true;
            return;
        }
        String ch = ch(list);
        if (!TextUtils.isEmpty(ch)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ch);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(y.avp(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fGJ = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.ceJ().ceD() != null) {
            loadMoreRequestMessage.setLoadCount(r.ceJ().ceD().au(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fGI) {
            this.fGI = true;
            if (com.baidu.tbadk.p.m.auk().aul() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fGJ)) != null) {
                iVar.auh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fGI) {
            this.fGI = true;
            if (com.baidu.tbadk.p.m.auk().aul() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fGJ)) != null) {
                iVar.auh();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.auk().aul() && (this.fGH instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fGJ;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fGH).cyE, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cyN = currentTimeMillis;
                iVar.fA(true);
            }
        }
    }

    private String ch(List<Long> list) {
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
        this.fGK.clear();
        this.fGL.clear();
        this.fGM.clear();
        this.ecl = -1;
        this.mPn = 1;
    }

    public boolean ci(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fGK.clear();
            this.fGL.clear();
            this.fGM.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fGK.iterator();
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
        if (!v.aa(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bf) {
                    bg bgVar3 = ((bf) next2).threadData;
                    bgVar3.mp(this.fGH.getForumName());
                    if (bgVar3.adS()) {
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
                    bgVar4.mp(this.fGH.getForumName());
                    if (bgVar4.adS()) {
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
        if (this.fql != null) {
            this.fql.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int alt = TbadkCoreApplication.getInst().getListItemRule().alt() - this.fGK.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < alt) {
                this.fGK.add(arrayList2.get(i));
            } else {
                this.fGM.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList4 = new ArrayList<>();
        arrayList4.addAll(this.fGK);
        arrayList4.addAll(this.fGM);
        if (this.fGH instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fGH, this.fGH.bkj(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList4);
        }
        return arrayList4;
    }

    public ArrayList<m> boR() {
        int i;
        int size = this.fGM.size() + 30;
        int als = TbadkCoreApplication.getInst().getListItemRule().als() * 3;
        if (size > als && this.fGM.size() > (i = size - als)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fGM.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fGK);
        arrayList.addAll(this.fGM);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fGN = aVar;
    }

    public void boS() {
        int i;
        int size = this.fGM.size() + 30;
        int als = TbadkCoreApplication.getInst().getListItemRule().als() * 3;
        int Z = v.Z(this.fGK);
        if (size > als && this.fGM.size() > (i = size - als)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fGM.remove(0);
                if (this.fGN != null) {
                    this.fGN.removeItem(Z);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fGK != null) {
                this.fGK.remove(mVar);
            }
            if (this.fGM != null) {
                this.fGM.remove(mVar);
            }
        }
    }
}
