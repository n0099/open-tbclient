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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.recapp.s;
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
    private int hYW;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a jGl;
    private boolean jGm;
    private long jGn;
    private final ArrayList<n> jGo;
    private final ArrayList<String> jGp;
    private final ArrayList<n> jGq;
    private boolean jGr;
    private c.a jGs;
    private final com.baidu.adp.framework.listener.a jGt;
    private k jjN;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void at(ArrayList<n> arrayList);

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
        this.jGm = false;
        this.jGn = 0L;
        this.jGo = new ArrayList<>();
        this.jGp = new ArrayList<>();
        this.jGq = new ArrayList<>();
        this.mPn = 1;
        this.hYW = -1;
        this.jGr = false;
        this.mPageType = 1;
        this.jGt = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jGl != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jGl.onFailed(FrsLoadMoreModel.this.jGl.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jGl.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jGl.onFailed(FrsLoadMoreModel.this.jGl.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cDm = FrsLoadMoreModel.this.jGl.cDm();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cDm != null) {
                                cDm.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jGl.at(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jGl instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jGl).fKU = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cDm != null) {
                                cDm.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jGl.at(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jGl instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jGl).fKU = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jGl.getForumName()) && s.dDB().dDv() != null) {
                            s.dDB().dDv().f(FrsLoadMoreModel.this.jGl.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jGl = aVar;
        setUniqueId(this.jGl.getUniqueId());
        this.jjN = kVar;
        this.jGt.getHttpMessageListener().setSelfListener(true);
        this.jGt.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jGt);
    }

    public int cCI() {
        return this.hYW;
    }

    public void setHasMore(int i) {
        this.hYW = i;
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

    public void rs(boolean z) {
        this.jGr = z;
    }

    public void registerListener() {
        registerListener(this.jGt);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z, String str2) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String dz = dz(list);
        if (!TextUtils.isEmpty(dz)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(dz);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bFL(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setAdFloorInfo(str2);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jGn = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (s.dDB().dDv() != null) {
            loadMoreRequestMessage.setLoadCount(s.dDB().dDv().bb(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        h hVar;
        if (!this.jGm) {
            this.jGm = true;
            if (com.baidu.tbadk.n.k.bEk().isSmallFlow() && (hVar = new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jGn)) != null) {
                hVar.bEh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        h hVar;
        if (!this.jGm) {
            this.jGm = true;
            if (com.baidu.tbadk.n.k.bEk().isSmallFlow() && (hVar = new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jGn)) != null) {
                hVar.bEh();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEk().isSmallFlow() && (this.jGl instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jGn;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jGl).fKU, false, 0L, 0L, currentTimeMillis);
            if (hVar != null) {
                hVar.fLd = currentTimeMillis;
                hVar.lm(true);
            }
        }
    }

    private String dz(List<Long> list) {
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
        this.jGo.clear();
        this.jGp.clear();
        this.jGq.clear();
        this.hYW = -1;
        this.mPn = 1;
    }

    public boolean dA(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<n> a(boolean z, boolean z2, boolean z3, ArrayList<n> arrayList, f fVar) {
        if (z3) {
            this.jGo.clear();
            this.jGp.clear();
            this.jGq.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<n> it = this.jGo.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof ca) {
                cb cbVar = ((ca) next).eLr;
                if (cbVar.getTid() != null) {
                    hashSet.add(cbVar.getTid());
                }
            } else if (next instanceof cb) {
                cb cbVar2 = (cb) next;
                if (cbVar2.getTid() != null) {
                    hashSet.add(cbVar2.getTid());
                }
            }
        }
        ArrayList<n> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!y.isEmpty(arrayList)) {
            Iterator<n> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof ca) {
                    cb cbVar3 = ((ca) next2).eLr;
                    cbVar3.Ap(this.jGl.getForumName());
                    if (this.jGl != null && this.jGl.cDm() != null && this.jGl.cDm().getForum() != null) {
                        if (!StringUtils.isNull(this.jGl.cDm().getForum().getFirst_class())) {
                            cbVar3.Au(this.jGl.cDm().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jGl.cDm().getForum().getSecond_class())) {
                            cbVar3.Av(this.jGl.cDm().getForum().getSecond_class());
                        }
                    }
                    if (cbVar3.bop()) {
                        if (!hashSet.contains(cbVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((ca) next2).eLr.tid)) {
                                arrayList3.add(((ca) next2).eLr.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((ca) next2).eLr.tid)) {
                            arrayList3.add(((ca) next2).eLr.tid);
                        }
                    }
                } else if (next2 instanceof cb) {
                    cb cbVar4 = (cb) next2;
                    cbVar4.Ap(this.jGl.getForumName());
                    if (this.jGl != null && this.jGl.cDm() != null && this.jGl.cDm().getForum() != null) {
                        if (!StringUtils.isNull(this.jGl.cDm().getForum().getFirst_class())) {
                            cbVar4.Au(this.jGl.cDm().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jGl.cDm().getForum().getSecond_class())) {
                            cbVar4.Av(this.jGl.cDm().getForum().getSecond_class());
                        }
                    }
                    if (cbVar4.bop()) {
                        if (!hashSet.contains(cbVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(cbVar4.tid)) {
                                arrayList3.add(cbVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(cbVar4.tid)) {
                            arrayList3.add(cbVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.jjN != null) {
            this.jjN.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        if (com.baidu.tieba.funad.a.cNC()) {
            if (this.funAdController != null) {
                this.funAdController.r(arrayList2, z3);
            }
        } else if (this.jGl != null) {
            FrsViewData cDm = this.jGl.cDm();
            if (this.jGr && cDm != null && (this.jGl instanceof com.baidu.tieba.InjectPlugin.a.b)) {
                ArrayList<n> arrayList4 = new ArrayList<>(this.jGo);
                arrayList4.addAll(this.jGq);
                cDm.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jGl, true, arrayList2, arrayList4, z2);
            }
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jGo.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jGo.add(arrayList2.get(i));
            } else {
                this.jGq.add(arrayList2.get(i));
            }
        }
        ArrayList<n> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jGo);
        arrayList5.addAll(this.jGq);
        if (this.jGl instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.d.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jGl, this.jGl.cDm(), arrayList2, getPn());
            com.baidu.tieba.frs.d.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<n> cJB() {
        int i;
        int size = this.jGq.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jGq.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jGq.remove(0);
            }
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.jGo);
        arrayList.addAll(this.jGq);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jGs = aVar;
    }

    public void cJC() {
        int i;
        ArrayList<n> arrayList;
        int size = this.jGq.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.jGo);
        if (size > frsMaxCache && this.jGq.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jGq.remove(0));
                if (this.jGl == null || this.jGl.cDm() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jGl.cDm().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jGs != null) {
                            this.jGs.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(n nVar) {
        if (nVar != null) {
            if (this.jGo != null) {
                this.jGo.remove(nVar);
            }
            if (this.jGq != null) {
                this.jGq.remove(nVar);
            }
        }
    }

    public void Li(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.jGo)) {
                f(this.jGo, str);
            }
            if (!y.isEmpty(this.jGq)) {
                f(this.jGq, str);
            }
        }
    }

    private void f(ArrayList<n> arrayList, String str) {
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bJz() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJz()).eMU)) {
                    it.remove();
                }
            }
        }
    }
}
