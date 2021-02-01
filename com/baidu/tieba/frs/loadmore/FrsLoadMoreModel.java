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
    private int hWZ;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a jEo;
    private boolean jEp;
    private long jEq;
    private final ArrayList<n> jEr;
    private final ArrayList<String> jEs;
    private final ArrayList<n> jEt;
    private boolean jEu;
    private c.a jEv;
    private final com.baidu.adp.framework.listener.a jEw;
    private k jhP;
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
        this.jEp = false;
        this.jEq = 0L;
        this.jEr = new ArrayList<>();
        this.jEs = new ArrayList<>();
        this.jEt = new ArrayList<>();
        this.mPn = 1;
        this.hWZ = -1;
        this.jEu = false;
        this.mPageType = 1;
        this.jEw = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jEo != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jEo.onFailed(FrsLoadMoreModel.this.jEo.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jEo.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jEo.onFailed(FrsLoadMoreModel.this.jEo.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cCZ = FrsLoadMoreModel.this.jEo.cCZ();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cCZ != null) {
                                cCZ.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jEo.at(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jEo instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jEo).fJu = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cCZ != null) {
                                cCZ.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jEo.at(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jEo instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jEo).fJu = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jEo.getForumName()) && r.dDm().dDg() != null) {
                            r.dDm().dDg().f(FrsLoadMoreModel.this.jEo.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jEo = aVar;
        setUniqueId(this.jEo.getUniqueId());
        this.jhP = kVar;
        this.jEw.getHttpMessageListener().setSelfListener(true);
        this.jEw.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jEw);
    }

    public int cCv() {
        return this.hWZ;
    }

    public void setHasMore(int i) {
        this.hWZ = i;
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
        this.jEu = z;
    }

    public void registerListener() {
        registerListener(this.jEw);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bFH(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setAdFloorInfo(str2);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jEq = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dDm().dDg() != null) {
            loadMoreRequestMessage.setLoadCount(r.dDm().dDg().bb(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        h hVar;
        if (!this.jEp) {
            this.jEp = true;
            if (com.baidu.tbadk.n.k.bEg().isSmallFlow() && (hVar = new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jEq)) != null) {
                hVar.bEd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        h hVar;
        if (!this.jEp) {
            this.jEp = true;
            if (com.baidu.tbadk.n.k.bEg().isSmallFlow() && (hVar = new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jEq)) != null) {
                hVar.bEd();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEg().isSmallFlow() && (this.jEo instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jEq;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jEo).fJu, false, 0L, 0L, currentTimeMillis);
            if (hVar != null) {
                hVar.fJD = currentTimeMillis;
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
        this.jEr.clear();
        this.jEs.clear();
        this.jEt.clear();
        this.hWZ = -1;
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
            this.jEr.clear();
            this.jEs.clear();
            this.jEt.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<n> it = this.jEr.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof ca) {
                cb cbVar = ((ca) next).eJQ;
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
                    cb cbVar3 = ((ca) next2).eJQ;
                    cbVar3.Ai(this.jEo.getForumName());
                    if (this.jEo != null && this.jEo.cCZ() != null && this.jEo.cCZ().getForum() != null) {
                        if (!StringUtils.isNull(this.jEo.cCZ().getForum().getFirst_class())) {
                            cbVar3.An(this.jEo.cCZ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jEo.cCZ().getForum().getSecond_class())) {
                            cbVar3.Ao(this.jEo.cCZ().getForum().getSecond_class());
                        }
                    }
                    if (cbVar3.bon()) {
                        if (!hashSet.contains(cbVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((ca) next2).eJQ.tid)) {
                                arrayList3.add(((ca) next2).eJQ.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((ca) next2).eJQ.tid)) {
                            arrayList3.add(((ca) next2).eJQ.tid);
                        }
                    }
                } else if (next2 instanceof cb) {
                    cb cbVar4 = (cb) next2;
                    cbVar4.Ai(this.jEo.getForumName());
                    if (this.jEo != null && this.jEo.cCZ() != null && this.jEo.cCZ().getForum() != null) {
                        if (!StringUtils.isNull(this.jEo.cCZ().getForum().getFirst_class())) {
                            cbVar4.An(this.jEo.cCZ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jEo.cCZ().getForum().getSecond_class())) {
                            cbVar4.Ao(this.jEo.cCZ().getForum().getSecond_class());
                        }
                    }
                    if (cbVar4.bon()) {
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
        if (this.jhP != null) {
            this.jhP.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        if (com.baidu.tieba.funad.a.cNn()) {
            if (this.funAdController != null) {
                this.funAdController.r(arrayList2, z3);
            }
        } else if (this.jEo != null) {
            FrsViewData cCZ = this.jEo.cCZ();
            if (this.jEu && cCZ != null && (this.jEo instanceof com.baidu.tieba.InjectPlugin.a.b)) {
                ArrayList<n> arrayList4 = new ArrayList<>(this.jEr);
                arrayList4.addAll(this.jEt);
                cCZ.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jEo, true, arrayList2, arrayList4, z2);
            }
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jEr.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jEr.add(arrayList2.get(i));
            } else {
                this.jEt.add(arrayList2.get(i));
            }
        }
        ArrayList<n> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jEr);
        arrayList5.addAll(this.jEt);
        if (this.jEo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.d.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jEo, this.jEo.cCZ(), arrayList2, getPn());
            com.baidu.tieba.frs.d.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<n> cJo() {
        int i;
        int size = this.jEt.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jEt.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jEt.remove(0);
            }
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.addAll(this.jEr);
        arrayList.addAll(this.jEt);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jEv = aVar;
    }

    public void cJp() {
        int i;
        ArrayList<n> arrayList;
        int size = this.jEt.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.jEr);
        if (size > frsMaxCache && this.jEt.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jEt.remove(0));
                if (this.jEo == null || this.jEo.cCZ() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jEo.cCZ().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jEv != null) {
                            this.jEv.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(n nVar) {
        if (nVar != null) {
            if (this.jEr != null) {
                this.jEr.remove(nVar);
            }
            if (this.jEt != null) {
                this.jEt.remove(nVar);
            }
        }
    }

    public void KY(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.jEr)) {
                f(this.jEr, str);
            }
            if (!y.isEmpty(this.jEt)) {
                f(this.jEt, str);
            }
        }
    }

    private void f(ArrayList<n> arrayList, String str) {
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bJq() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bJq()).eLu)) {
                    it.remove();
                }
            }
        }
    }
}
