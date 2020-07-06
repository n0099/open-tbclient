package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int gzh;
    private k hBl;
    private final com.baidu.tieba.frs.loadmore.a hTK;
    private boolean hTL;
    private long hTM;
    private final ArrayList<q> hTN;
    private final ArrayList<String> hTO;
    private final ArrayList<q> hTP;
    private boolean hTQ;
    private c.a hTR;
    private final com.baidu.adp.framework.listener.a hTS;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void an(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.hTL = false;
        this.hTM = 0L;
        this.hTN = new ArrayList<>();
        this.hTO = new ArrayList<>();
        this.hTP = new ArrayList<>();
        this.mPn = 1;
        this.gzh = -1;
        this.hTQ = false;
        this.mPageType = 1;
        this.hTS = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.hTK != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.hTK.onFailed(FrsLoadMoreModel.this.hTK.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.hTK.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.hTK.onFailed(FrsLoadMoreModel.this.hTK.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bYC = FrsLoadMoreModel.this.hTK.bYC();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bYC != null) {
                                bYC.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hTK.an(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hTK instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hTK).eAY = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bYC != null) {
                                bYC.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hTK.an(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hTK instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hTK).eAY = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.hTK.getForumName()) && com.baidu.tieba.recapp.q.cYT().cYN() != null) {
                            com.baidu.tieba.recapp.q.cYT().cYN().f(FrsLoadMoreModel.this.hTK.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.hTK = aVar;
        setUniqueId(this.hTK.getUniqueId());
        this.hBl = kVar;
        this.hTS.getHttpMessageListener().setSelfListener(true);
        this.hTS.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hTS);
    }

    public int bYb() {
        return this.gzh;
    }

    public void setHasMore(int i) {
        this.gzh = i;
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

    public void nN(boolean z) {
        this.hTQ = z;
    }

    public void registerListener() {
        registerListener(this.hTS);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || w.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cG = cG(list);
        if (!TextUtils.isEmpty(cG)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cG);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bjc(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.hTM = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (com.baidu.tieba.recapp.q.cYT().cYN() != null) {
            loadMoreRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.cYT().cYN().aT(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.hTL) {
            this.hTL = true;
            if (m.bhP().bhQ() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hTM)) != null) {
                iVar.bhM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.hTL) {
            this.hTL = true;
            if (m.bhP().bhQ() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hTM)) != null) {
                iVar.bhM();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bhP().bhQ() && (this.hTK instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.hTM;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.hTK).eAY, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.eBh = currentTimeMillis;
                iVar.ix(true);
            }
        }
    }

    private String cG(List<Long> list) {
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
        this.hTN.clear();
        this.hTO.clear();
        this.hTP.clear();
        this.gzh = -1;
        this.mPn = 1;
    }

    public boolean cH(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.hTN.clear();
            this.hTO.clear();
            this.hTP.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.hTN.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bt) {
                bu buVar = ((bt) next).dLi;
                if (buVar.getTid() != null) {
                    hashSet.add(buVar.getTid());
                }
            } else if (next instanceof bu) {
                bu buVar2 = (bu) next;
                if (buVar2.getTid() != null) {
                    hashSet.add(buVar2.getTid());
                }
            }
        }
        ArrayList<q> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!w.isEmpty(arrayList)) {
            Iterator<q> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bt) {
                    bu buVar3 = ((bt) next2).dLi;
                    buVar3.vS(this.hTK.getForumName());
                    if (this.hTK != null && this.hTK.bYC() != null && this.hTK.bYC().getForum() != null) {
                        if (!StringUtils.isNull(this.hTK.bYC().getForum().getFirst_class())) {
                            buVar3.vX(this.hTK.bYC().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hTK.bYC().getForum().getSecond_class())) {
                            buVar3.vY(this.hTK.bYC().getForum().getSecond_class());
                        }
                    }
                    if (buVar3.aSN()) {
                        if (!hashSet.contains(buVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bt) next2).dLi.tid)) {
                                arrayList3.add(((bt) next2).dLi.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bt) next2).dLi.tid)) {
                            arrayList3.add(((bt) next2).dLi.tid);
                        }
                    }
                } else if (next2 instanceof bu) {
                    bu buVar4 = (bu) next2;
                    buVar4.vS(this.hTK.getForumName());
                    if (this.hTK != null && this.hTK.bYC() != null && this.hTK.bYC().getForum() != null) {
                        if (!StringUtils.isNull(this.hTK.bYC().getForum().getFirst_class())) {
                            buVar4.vX(this.hTK.bYC().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hTK.bYC().getForum().getSecond_class())) {
                            buVar4.vY(this.hTK.bYC().getForum().getSecond_class());
                        }
                    }
                    if (buVar4.aSN()) {
                        if (!hashSet.contains(buVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(buVar4.tid)) {
                                arrayList3.add(buVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(buVar4.tid)) {
                            arrayList3.add(buVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.hBl != null) {
            this.hBl.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bYC = this.hTK.bYC();
        if (this.hTQ && bYC != null && (this.hTK instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.hTN);
            arrayList4.addAll(this.hTP);
            bYC.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.hTK, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.hTN.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.hTN.add(arrayList2.get(i));
            } else {
                this.hTP.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.hTN);
        arrayList5.addAll(this.hTP);
        if (this.hTK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.hTK, this.hTK.bYC(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cdB() {
        int i;
        int size = this.hTP.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.hTP.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.hTP.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.hTN);
        arrayList.addAll(this.hTP);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.hTR = aVar;
    }

    public void cdC() {
        int i;
        ArrayList<q> arrayList;
        int size = this.hTP.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = w.getCount(this.hTN);
        if (size > frsMaxCache && this.hTP.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.hTP.remove(0));
                if (this.hTK == null || this.hTK.bYC() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.hTK.bYC().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.hTR != null) {
                            this.hTR.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.hTN != null) {
                this.hTN.remove(qVar);
            }
            if (this.hTP != null) {
                this.hTP.remove(qVar);
            }
        }
    }

    public void FA(String str) {
        if (!StringUtils.isNull(str)) {
            if (!w.isEmpty(this.hTN)) {
                e(this.hTN, str);
            }
            if (!w.isEmpty(this.hTP)) {
                e(this.hTP, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bmw() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bmw()).dGL)) {
                    it.remove();
                }
            }
        }
    }
}
