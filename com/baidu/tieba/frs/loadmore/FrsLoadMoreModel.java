package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private com.baidu.tieba.funad.a funAdController;
    private int hXl;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a jDp;
    private boolean jDq;
    private long jDr;
    private final ArrayList<n> jDs;
    private final ArrayList<String> jDt;
    private final ArrayList<n> jDu;
    private boolean jDv;
    private c.a jDw;
    private final com.baidu.adp.framework.listener.a jDx;
    private k jgQ;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void az(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.jDq = false;
        this.jDr = 0L;
        this.jDs = new ArrayList<>();
        this.jDt = new ArrayList<>();
        this.jDu = new ArrayList<>();
        this.mPn = 1;
        this.hXl = -1;
        this.jDv = false;
        this.mPageType = 1;
        this.jDx = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jDp != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jDp.onFailed(FrsLoadMoreModel.this.jDp.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jDp.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jDp.onFailed(FrsLoadMoreModel.this.jDp.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cFF = FrsLoadMoreModel.this.jDp.cFF();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cFF != null) {
                                cFF.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jDp.az(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jDp instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jDp).fLQ = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cFF != null) {
                                cFF.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jDp.az(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jDp instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jDp).fLQ = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jDp.getForumName()) && r.dEW().dEQ() != null) {
                            r.dEW().dEQ().f(FrsLoadMoreModel.this.jDp.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jDp = aVar;
        setUniqueId(this.jDp.getUniqueId());
        this.jgQ = kVar;
        this.jDx.getHttpMessageListener().setSelfListener(true);
        this.jDx.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jDx);
    }

    public int cFb() {
        return this.hXl;
    }

    public void setHasMore(int i) {
        this.hXl = i;
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

    public void rm(boolean z) {
        this.jDv = z;
    }

    public void registerListener() {
        registerListener(this.jDx);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || x.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String dE = dE(list);
        if (!TextUtils.isEmpty(dE)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(dE);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(z.bJg(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jDr = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dEW().dEQ() != null) {
            loadMoreRequestMessage.setLoadCount(r.dEW().dEQ().bb(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        h hVar;
        if (!this.jDq) {
            this.jDq = true;
            if (com.baidu.tbadk.n.k.bHG().isSmallFlow() && (hVar = new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jDr)) != null) {
                hVar.bHD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        h hVar;
        if (!this.jDq) {
            this.jDq = true;
            if (com.baidu.tbadk.n.k.bHG().isSmallFlow() && (hVar = new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jDr)) != null) {
                hVar.bHD();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bHG().isSmallFlow() && (this.jDp instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jDr;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jDp).fLQ, false, 0L, 0L, currentTimeMillis);
            if (hVar != null) {
                hVar.fLZ = currentTimeMillis;
                hVar.ln(true);
            }
        }
    }

    private String dE(List<Long> list) {
        if (list == null || list.size() == 0) {
            this.loadingDone = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i = 0;
        if (this.loadIndex == 0) {
            size = 30;
        } else if (this.loadIndex != 1) {
            return "";
        } else {
            i = 30;
        }
        if (size > list.size()) {
            size = list.size();
        }
        if (i >= list.size()) {
            this.loadingDone = true;
            return "";
        }
        for (int i2 = i; i2 < size; i2++) {
            if (i2 == list.size() - 1) {
                this.loadingDone = true;
            }
            Long l = list.get(i2);
            if (l != null) {
                if (i2 == size - 1) {
                    sb.append(l);
                } else {
                    sb.append(l).append(",");
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
        this.jDs.clear();
        this.jDt.clear();
        this.jDu.clear();
        this.hXl = -1;
        this.mPn = 1;
    }

    public boolean dF(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<n> a(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, f fVar) {
        if (z3) {
            this.jDs.clear();
            this.jDt.clear();
            this.jDu.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<n> it = this.jDs.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof by) {
                bz bzVar = ((by) next).eMv;
                if (bzVar.getTid() != null) {
                    hashSet.add(bzVar.getTid());
                }
            } else if (next instanceof bz) {
                bz bzVar2 = (bz) next;
                if (bzVar2.getTid() != null) {
                    hashSet.add(bzVar2.getTid());
                }
            }
        }
        ArrayList<n> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!x.isEmpty(arrayList)) {
            Iterator<n> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof by) {
                    bz bzVar3 = ((by) next2).eMv;
                    bzVar3.Bc(this.jDp.getForumName());
                    if (this.jDp != null && this.jDp.cFF() != null && this.jDp.cFF().getForum() != null) {
                        if (!StringUtils.isNull(this.jDp.cFF().getForum().getFirst_class())) {
                            bzVar3.Bh(this.jDp.cFF().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jDp.cFF().getForum().getSecond_class())) {
                            bzVar3.Bi(this.jDp.cFF().getForum().getSecond_class());
                        }
                    }
                    if (bzVar3.brO()) {
                        if (!hashSet.contains(bzVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((by) next2).eMv.tid)) {
                                arrayList3.add(((by) next2).eMv.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((by) next2).eMv.tid)) {
                            arrayList3.add(((by) next2).eMv.tid);
                        }
                    }
                } else if (next2 instanceof bz) {
                    bz bzVar4 = (bz) next2;
                    bzVar4.Bc(this.jDp.getForumName());
                    if (this.jDp != null && this.jDp.cFF() != null && this.jDp.cFF().getForum() != null) {
                        if (!StringUtils.isNull(this.jDp.cFF().getForum().getFirst_class())) {
                            bzVar4.Bh(this.jDp.cFF().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jDp.cFF().getForum().getSecond_class())) {
                            bzVar4.Bi(this.jDp.cFF().getForum().getSecond_class());
                        }
                    }
                    if (bzVar4.brO()) {
                        if (!hashSet.contains(bzVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bzVar4.tid)) {
                                arrayList3.add(bzVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bzVar4.tid)) {
                            arrayList3.add(bzVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.jgQ != null) {
            this.jgQ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        if (com.baidu.tieba.funad.a.cPr()) {
            if (this.funAdController != null) {
                this.funAdController.q(arrayList2, z3);
            }
        } else if (this.jDp != null) {
            FrsViewData cFF = this.jDp.cFF();
            if (this.jDv && cFF != null && (this.jDp instanceof com.baidu.tieba.InjectPlugin.a.b)) {
                ArrayList<n> arrayList4 = new ArrayList<>(this.jDs);
                arrayList4.addAll(this.jDu);
                cFF.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jDp, true, arrayList2, arrayList4, z2);
            }
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jDs.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jDs.add(arrayList2.get(i));
            } else {
                this.jDu.add(arrayList2.get(i));
            }
        }
        ArrayList<n> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jDs);
        arrayList5.addAll(this.jDu);
        if (this.jDp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.d.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jDp, this.jDp.cFF(), arrayList2, getPn());
            com.baidu.tieba.frs.d.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<n> cLT() {
        int i;
        int size = this.jDu.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jDu.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jDu.remove(0);
            }
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.jDs);
        arrayList.addAll(this.jDu);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jDw = aVar;
    }

    public void cLU() {
        int i;
        ArrayList<n> arrayList;
        int size = this.jDu.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = x.getCount(this.jDs);
        if (size > frsMaxCache && this.jDu.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jDu.remove(0));
                if (this.jDp == null || this.jDp.cFF() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jDp.cFF().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jDw != null) {
                            this.jDw.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(n nVar) {
        if (nVar != null) {
            if (this.jDs != null) {
                this.jDs.remove(nVar);
            }
            if (this.jDu != null) {
                this.jDu.remove(nVar);
            }
        }
    }

    public void Lx(String str) {
        if (!StringUtils.isNull(str)) {
            if (!x.isEmpty(this.jDs)) {
                e(this.jDs, str);
            }
            if (!x.isEmpty(this.jDu)) {
                e(this.jDu, str);
            }
        }
    }

    private void e(ArrayList<n> arrayList, String str) {
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bMO() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bMO()).eNT)) {
                    it.remove();
                }
            }
        }
    }
}
