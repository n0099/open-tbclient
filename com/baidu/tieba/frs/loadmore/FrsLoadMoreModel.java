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
/* loaded from: classes7.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int fpy;
    private final com.baidu.tieba.frs.loadmore.a gEl;
    private boolean gEm;
    private long gEn;
    private final ArrayList<m> gEo;
    private final ArrayList<String> gEp;
    private final ArrayList<m> gEq;
    private boolean gEr;
    private c.a gEs;
    private final com.baidu.adp.framework.listener.a gEt;
    private k gny;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes7.dex */
    public interface a {
        void al(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.gEm = false;
        this.gEn = 0L;
        this.gEo = new ArrayList<>();
        this.gEp = new ArrayList<>();
        this.gEq = new ArrayList<>();
        this.mPn = 1;
        this.fpy = -1;
        this.gEr = false;
        this.mPageType = 1;
        this.gEt = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.gEl != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.gEl.onFailed(FrsLoadMoreModel.this.gEl.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.gEl.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.gEl.onFailed(FrsLoadMoreModel.this.gEl.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bCK = FrsLoadMoreModel.this.gEl.bCK();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bCK != null) {
                                bCK.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gEl.al(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gEl instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gEl).dzB = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bCK != null) {
                                bCK.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gEl.al(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gEl instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gEl).dzB = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.gEl.getForumName()) && r.cAX().cAR() != null) {
                            r.cAX().cAR().g(FrsLoadMoreModel.this.gEl.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.gEl = aVar;
        setUniqueId(this.gEl.getUniqueId());
        this.gny = kVar;
        this.gEt.getHttpMessageListener().setSelfListener(true);
        this.gEt.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gEt);
    }

    public int bCl() {
        return this.fpy;
    }

    public void setHasMore(int i) {
        this.fpy = i;
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

    public void lV(boolean z) {
        this.gEr = z;
    }

    public void registerListener() {
        registerListener(this.gEt);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.aPX(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.gEn = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.cAX().cAR() != null) {
            loadMoreRequestMessage.setLoadCount(r.cAX().cAR().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.gEm) {
            this.gEm = true;
            if (com.baidu.tbadk.n.m.aOT().aOU() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gEn)) != null) {
                iVar.aOQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.gEm) {
            this.gEm = true;
            if (com.baidu.tbadk.n.m.aOT().aOU() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gEn)) != null) {
                iVar.aOQ();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aOT().aOU() && (this.gEl instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.gEn;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.gEl).dzB, false, currentTimeMillis);
            if (iVar != null) {
                iVar.dzK = currentTimeMillis;
                iVar.gM(true);
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
        this.gEo.clear();
        this.gEp.clear();
        this.gEq.clear();
        this.fpy = -1;
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
            this.gEo.clear();
            this.gEp.clear();
            this.gEq.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.gEo.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).cNb;
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
                    bj bjVar3 = ((bi) next2).cNb;
                    bjVar3.sp(this.gEl.getForumName());
                    if (this.gEl != null && this.gEl.bCK() != null && this.gEl.bCK().getForum() != null) {
                        if (!StringUtils.isNull(this.gEl.bCK().getForum().getFirst_class())) {
                            bjVar3.sv(this.gEl.bCK().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gEl.bCK().getForum().getSecond_class())) {
                            bjVar3.sw(this.gEl.bCK().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aAu()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).cNb.tid)) {
                                arrayList3.add(((bi) next2).cNb.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).cNb.tid)) {
                            arrayList3.add(((bi) next2).cNb.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.sp(this.gEl.getForumName());
                    if (this.gEl != null && this.gEl.bCK() != null && this.gEl.bCK().getForum() != null) {
                        if (!StringUtils.isNull(this.gEl.bCK().getForum().getFirst_class())) {
                            bjVar4.sv(this.gEl.bCK().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gEl.bCK().getForum().getSecond_class())) {
                            bjVar4.sw(this.gEl.bCK().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aAu()) {
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
        if (this.gny != null) {
            this.gny.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bCK = this.gEl.bCK();
        if (this.gEr && bCK != null && (this.gEl instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.gEo);
            arrayList4.addAll(this.gEq);
            bCK.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.gEl, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.gEo.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.gEo.add(arrayList2.get(i));
            } else {
                this.gEq.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.gEo);
        arrayList5.addAll(this.gEq);
        if (this.gEl instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.gEl, this.gEl.bCK(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bHv() {
        int i;
        int size = this.gEq.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.gEq.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.gEq.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gEo);
        arrayList.addAll(this.gEq);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.gEs = aVar;
    }

    public void bHw() {
        int i;
        ArrayList<m> arrayList;
        int size = this.gEq.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.gEo);
        if (size > frsMaxCache && this.gEq.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                arrayList2.add(this.gEq.remove(0));
                if (this.gEl == null || this.gEl.bCK() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.gEl.bCK().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.gEs != null) {
                            this.gEs.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gEo != null) {
                this.gEo.remove(mVar);
            }
            if (this.gEq != null) {
                this.gEq.remove(mVar);
            }
        }
    }

    public void Bm(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.gEo)) {
                e(this.gEo, str);
            }
            if (!v.isEmpty(this.gEq)) {
                e(this.gEq, str);
            }
        }
    }

    private void e(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aTd() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aTd()).cIS)) {
                    it.remove();
                }
            }
        }
    }
}
