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
    private int hSE;
    public boolean isLoading;
    private k jcj;
    private final com.baidu.tieba.frs.loadmore.a jyJ;
    private boolean jyK;
    private long jyL;
    private final ArrayList<n> jyM;
    private final ArrayList<String> jyN;
    private final ArrayList<n> jyO;
    private boolean jyP;
    private c.a jyQ;
    private final com.baidu.adp.framework.listener.a jyR;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void au(ArrayList<n> arrayList);

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
        this.jyK = false;
        this.jyL = 0L;
        this.jyM = new ArrayList<>();
        this.jyN = new ArrayList<>();
        this.jyO = new ArrayList<>();
        this.mPn = 1;
        this.hSE = -1;
        this.jyP = false;
        this.mPageType = 1;
        this.jyR = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jyJ != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jyJ.onFailed(FrsLoadMoreModel.this.jyJ.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jyJ.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jyJ.onFailed(FrsLoadMoreModel.this.jyJ.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cBN = FrsLoadMoreModel.this.jyJ.cBN();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cBN != null) {
                                cBN.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jyJ.au(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jyJ instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jyJ).fHj = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cBN != null) {
                                cBN.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jyJ.au(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jyJ instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jyJ).fHj = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jyJ.getForumName()) && r.dBe().dAY() != null) {
                            r.dBe().dAY().f(FrsLoadMoreModel.this.jyJ.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jyJ = aVar;
        setUniqueId(this.jyJ.getUniqueId());
        this.jcj = kVar;
        this.jyR.getHttpMessageListener().setSelfListener(true);
        this.jyR.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jyR);
    }

    public int cBj() {
        return this.hSE;
    }

    public void setHasMore(int i) {
        this.hSE = i;
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

    public void ri(boolean z) {
        this.jyP = z;
    }

    public void registerListener() {
        registerListener(this.jyR);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(z.bFo(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jyL = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dBe().dAY() != null) {
            loadMoreRequestMessage.setLoadCount(r.dBe().dAY().bb(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        h hVar;
        if (!this.jyK) {
            this.jyK = true;
            if (com.baidu.tbadk.n.k.bDO().isSmallFlow() && (hVar = new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jyL)) != null) {
                hVar.bDL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        h hVar;
        if (!this.jyK) {
            this.jyK = true;
            if (com.baidu.tbadk.n.k.bDO().isSmallFlow() && (hVar = new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jyL)) != null) {
                hVar.bDL();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bDO().isSmallFlow() && (this.jyJ instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jyL;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jyJ).fHj, false, 0L, 0L, currentTimeMillis);
            if (hVar != null) {
                hVar.fHs = currentTimeMillis;
                hVar.lj(true);
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
        this.jyM.clear();
        this.jyN.clear();
        this.jyO.clear();
        this.hSE = -1;
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
            this.jyM.clear();
            this.jyN.clear();
            this.jyO.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<n> it = this.jyM.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof by) {
                bz bzVar = ((by) next).eHK;
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
                    bz bzVar3 = ((by) next2).eHK;
                    bzVar3.zR(this.jyJ.getForumName());
                    if (this.jyJ != null && this.jyJ.cBN() != null && this.jyJ.cBN().getForum() != null) {
                        if (!StringUtils.isNull(this.jyJ.cBN().getForum().getFirst_class())) {
                            bzVar3.zW(this.jyJ.cBN().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jyJ.cBN().getForum().getSecond_class())) {
                            bzVar3.zX(this.jyJ.cBN().getForum().getSecond_class());
                        }
                    }
                    if (bzVar3.bnU()) {
                        if (!hashSet.contains(bzVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((by) next2).eHK.tid)) {
                                arrayList3.add(((by) next2).eHK.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((by) next2).eHK.tid)) {
                            arrayList3.add(((by) next2).eHK.tid);
                        }
                    }
                } else if (next2 instanceof bz) {
                    bz bzVar4 = (bz) next2;
                    bzVar4.zR(this.jyJ.getForumName());
                    if (this.jyJ != null && this.jyJ.cBN() != null && this.jyJ.cBN().getForum() != null) {
                        if (!StringUtils.isNull(this.jyJ.cBN().getForum().getFirst_class())) {
                            bzVar4.zW(this.jyJ.cBN().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jyJ.cBN().getForum().getSecond_class())) {
                            bzVar4.zX(this.jyJ.cBN().getForum().getSecond_class());
                        }
                    }
                    if (bzVar4.bnU()) {
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
        if (this.jcj != null) {
            this.jcj.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        if (com.baidu.tieba.funad.a.cLz()) {
            if (this.funAdController != null) {
                this.funAdController.q(arrayList2, z3);
            }
        } else if (this.jyJ != null) {
            FrsViewData cBN = this.jyJ.cBN();
            if (this.jyP && cBN != null && (this.jyJ instanceof com.baidu.tieba.InjectPlugin.a.b)) {
                ArrayList<n> arrayList4 = new ArrayList<>(this.jyM);
                arrayList4.addAll(this.jyO);
                cBN.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jyJ, true, arrayList2, arrayList4, z2);
            }
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jyM.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jyM.add(arrayList2.get(i));
            } else {
                this.jyO.add(arrayList2.get(i));
            }
        }
        ArrayList<n> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jyM);
        arrayList5.addAll(this.jyO);
        if (this.jyJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.d.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jyJ, this.jyJ.cBN(), arrayList2, getPn());
            com.baidu.tieba.frs.d.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<n> cIb() {
        int i;
        int size = this.jyO.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jyO.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jyO.remove(0);
            }
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.jyM);
        arrayList.addAll(this.jyO);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jyQ = aVar;
    }

    public void cIc() {
        int i;
        ArrayList<n> arrayList;
        int size = this.jyO.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = x.getCount(this.jyM);
        if (size > frsMaxCache && this.jyO.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jyO.remove(0));
                if (this.jyJ == null || this.jyJ.cBN() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jyJ.cBN().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jyQ != null) {
                            this.jyQ.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(n nVar) {
        if (nVar != null) {
            if (this.jyM != null) {
                this.jyM.remove(nVar);
            }
            if (this.jyO != null) {
                this.jyO.remove(nVar);
            }
        }
    }

    public void Kn(String str) {
        if (!StringUtils.isNull(str)) {
            if (!x.isEmpty(this.jyM)) {
                e(this.jyM, str);
            }
            if (!x.isEmpty(this.jyO)) {
                e(this.jyO, str);
            }
        }
    }

    private void e(ArrayList<n> arrayList, String str) {
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bIW() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bIW()).eJi)) {
                    it.remove();
                }
            }
        }
    }
}
