package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.util.aa;
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
/* loaded from: classes6.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int fmo;
    private final com.baidu.tieba.frs.loadmore.a gBb;
    private boolean gBc;
    private long gBd;
    private final ArrayList<m> gBe;
    private final ArrayList<String> gBf;
    private final ArrayList<m> gBg;
    private boolean gBh;
    private c.a gBi;
    private final com.baidu.adp.framework.listener.a gBj;
    private k gkp;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes6.dex */
    public interface a {
        void al(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.gBc = false;
        this.gBd = 0L;
        this.gBe = new ArrayList<>();
        this.gBf = new ArrayList<>();
        this.gBg = new ArrayList<>();
        this.mPn = 1;
        this.fmo = -1;
        this.gBh = false;
        this.mPageType = 1;
        this.gBj = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.gBb != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.gBb.onFailed(FrsLoadMoreModel.this.gBb.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.gBb.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.gBb.onFailed(FrsLoadMoreModel.this.gBb.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bBI = FrsLoadMoreModel.this.gBb.bBI();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bBI != null) {
                                bBI.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gBb.al(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gBb instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gBb).dzt = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bBI != null) {
                                bBI.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gBb.al(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gBb instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gBb).dzt = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.gBb.getForumName()) && r.czO().czI() != null) {
                            r.czO().czI().g(FrsLoadMoreModel.this.gBb.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.gBb = aVar;
        setUniqueId(this.gBb.getUniqueId());
        this.gkp = kVar;
        this.gBj.getHttpMessageListener().setSelfListener(true);
        this.gBj.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gBj);
    }

    public int bBj() {
        return this.fmo;
    }

    public void setHasMore(int i) {
        this.fmo = i;
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

    public void lK(boolean z) {
        this.gBh = z;
    }

    public void registerListener() {
        registerListener(this.gBj);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cq = cq(list);
        if (!TextUtils.isEmpty(cq)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cq);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.aPE(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.gBd = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.czO().czI() != null) {
            loadMoreRequestMessage.setLoadCount(r.czO().czI().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.gBc) {
            this.gBc = true;
            if (com.baidu.tbadk.n.m.aOA().aOB() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gBd)) != null) {
                iVar.aOx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.gBc) {
            this.gBc = true;
            if (com.baidu.tbadk.n.m.aOA().aOB() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gBd)) != null) {
                iVar.aOx();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aOA().aOB() && (this.gBb instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.gBd;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.gBb).dzt, false, currentTimeMillis);
            if (iVar != null) {
                iVar.dzC = currentTimeMillis;
                iVar.gH(true);
            }
        }
    }

    private String cq(List<Long> list) {
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
        this.gBe.clear();
        this.gBf.clear();
        this.gBg.clear();
        this.fmo = -1;
        this.mPn = 1;
    }

    public boolean cr(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.gBe.clear();
            this.gBf.clear();
            this.gBg.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.gBe.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).cMR;
                if (bjVar.getTid() != null) {
                    hashSet.add(bjVar.getTid());
                }
            } else if (next instanceof bj) {
                bj bjVar2 = (bj) next;
                if (bjVar2.getTid() != null) {
                    hashSet.add(bjVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.isEmpty(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bi) {
                    bj bjVar3 = ((bi) next2).cMR;
                    bjVar3.sm(this.gBb.getForumName());
                    if (this.gBb != null && this.gBb.bBI() != null && this.gBb.bBI().getForum() != null) {
                        if (!StringUtils.isNull(this.gBb.bBI().getForum().getFirst_class())) {
                            bjVar3.ss(this.gBb.bBI().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gBb.bBI().getForum().getSecond_class())) {
                            bjVar3.st(this.gBb.bBI().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aAb()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).cMR.tid)) {
                                arrayList3.add(((bi) next2).cMR.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).cMR.tid)) {
                            arrayList3.add(((bi) next2).cMR.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.sm(this.gBb.getForumName());
                    if (this.gBb != null && this.gBb.bBI() != null && this.gBb.bBI().getForum() != null) {
                        if (!StringUtils.isNull(this.gBb.bBI().getForum().getFirst_class())) {
                            bjVar4.ss(this.gBb.bBI().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gBb.bBI().getForum().getSecond_class())) {
                            bjVar4.st(this.gBb.bBI().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aAb()) {
                        if (!hashSet.contains(bjVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bjVar4.tid)) {
                                arrayList3.add(bjVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bjVar4.tid)) {
                            arrayList3.add(bjVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.gkp != null) {
            this.gkp.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bBI = this.gBb.bBI();
        if (this.gBh && bBI != null && (this.gBb instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.gBe);
            arrayList4.addAll(this.gBg);
            bBI.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.gBb, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.gBe.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.gBe.add(arrayList2.get(i));
            } else {
                this.gBg.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.gBe);
        arrayList5.addAll(this.gBg);
        if (this.gBb instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.gBb, this.gBb.bBI(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bGt() {
        int i;
        int size = this.gBg.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.gBg.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.gBg.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gBe);
        arrayList.addAll(this.gBg);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.gBi = aVar;
    }

    public void bGu() {
        int i;
        int size = this.gBg.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.gBe);
        if (size > frsMaxCache && this.gBg.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.gBg.remove(0);
                if (this.gBi != null) {
                    this.gBi.removeItem(count);
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gBe != null) {
                this.gBe.remove(mVar);
            }
            if (this.gBg != null) {
                this.gBg.remove(mVar);
            }
        }
    }

    public void Bc(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.gBe)) {
                f(this.gBe, str);
            }
            if (!v.isEmpty(this.gBg)) {
                f(this.gBg, str);
            }
        }
    }

    private void f(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aSJ() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aSJ()).cIG)) {
                    it.remove();
                }
            }
        }
    }
}
