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
import com.baidu.tieba.recapp.q;
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
    private int fXj;
    private k gZG;
    private final com.baidu.tieba.frs.loadmore.a hqP;
    private boolean hqQ;
    private long hqR;
    private final ArrayList<m> hqS;
    private final ArrayList<String> hqT;
    private final ArrayList<m> hqU;
    private boolean hqV;
    private c.a hqW;
    private final com.baidu.adp.framework.listener.a hqX;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void an(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.hqQ = false;
        this.hqR = 0L;
        this.hqS = new ArrayList<>();
        this.hqT = new ArrayList<>();
        this.hqU = new ArrayList<>();
        this.mPn = 1;
        this.fXj = -1;
        this.hqV = false;
        this.mPageType = 1;
        this.hqX = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.hqP != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.hqP.onFailed(FrsLoadMoreModel.this.hqP.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.hqP.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.hqP.onFailed(FrsLoadMoreModel.this.hqP.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bOY = FrsLoadMoreModel.this.hqP.bOY();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bOY != null) {
                                bOY.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hqP.an(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hqP instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hqP).edO = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bOY != null) {
                                bOY.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hqP.an(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hqP instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hqP).edO = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.hqP.getForumName()) && q.cNo().cNi() != null) {
                            q.cNo().cNi().f(FrsLoadMoreModel.this.hqP.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.hqP = aVar;
        setUniqueId(this.hqP.getUniqueId());
        this.gZG = kVar;
        this.hqX.getHttpMessageListener().setSelfListener(true);
        this.hqX.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hqX);
    }

    public int bOy() {
        return this.fXj;
    }

    public void setHasMore(int i) {
        this.fXj = i;
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

    public void ng(boolean z) {
        this.hqV = z;
    }

    public void registerListener() {
        registerListener(this.hqX);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cy = cy(list);
        if (!TextUtils.isEmpty(cy)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cy);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.baE(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.hqR = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.cNo().cNi() != null) {
            loadMoreRequestMessage.setLoadCount(q.cNo().cNi().aE(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.hqQ) {
            this.hqQ = true;
            if (com.baidu.tbadk.n.m.aZA().aZB() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hqR)) != null) {
                iVar.aZx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.hqQ) {
            this.hqQ = true;
            if (com.baidu.tbadk.n.m.aZA().aZB() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hqR)) != null) {
                iVar.aZx();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aZA().aZB() && (this.hqP instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.hqR;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.hqP).edO, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.edX = currentTimeMillis;
                iVar.hS(true);
            }
        }
    }

    private String cy(List<Long> list) {
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
        this.hqS.clear();
        this.hqT.clear();
        this.hqU.clear();
        this.fXj = -1;
        this.mPn = 1;
    }

    public boolean cz(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.hqS.clear();
            this.hqT.clear();
            this.hqU.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.hqS.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).dqA;
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
                    bj bjVar3 = ((bi) next2).dqA;
                    bjVar3.tT(this.hqP.getForumName());
                    if (this.hqP != null && this.hqP.bOY() != null && this.hqP.bOY().getForum() != null) {
                        if (!StringUtils.isNull(this.hqP.bOY().getForum().getFirst_class())) {
                            bjVar3.tY(this.hqP.bOY().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hqP.bOY().getForum().getSecond_class())) {
                            bjVar3.tZ(this.hqP.bOY().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aLb()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).dqA.tid)) {
                                arrayList3.add(((bi) next2).dqA.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).dqA.tid)) {
                            arrayList3.add(((bi) next2).dqA.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.tT(this.hqP.getForumName());
                    if (this.hqP != null && this.hqP.bOY() != null && this.hqP.bOY().getForum() != null) {
                        if (!StringUtils.isNull(this.hqP.bOY().getForum().getFirst_class())) {
                            bjVar4.tY(this.hqP.bOY().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hqP.bOY().getForum().getSecond_class())) {
                            bjVar4.tZ(this.hqP.bOY().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aLb()) {
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
        if (this.gZG != null) {
            this.gZG.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bOY = this.hqP.bOY();
        if (this.hqV && bOY != null && (this.hqP instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.hqS);
            arrayList4.addAll(this.hqU);
            bOY.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.hqP, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.hqS.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.hqS.add(arrayList2.get(i));
            } else {
                this.hqU.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.hqS);
        arrayList5.addAll(this.hqU);
        if (this.hqP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.hqP, this.hqP.bOY(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bTJ() {
        int i;
        int size = this.hqU.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.hqU.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.hqU.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.hqS);
        arrayList.addAll(this.hqU);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.hqW = aVar;
    }

    public void bTK() {
        int i;
        ArrayList<m> arrayList;
        int size = this.hqU.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.hqS);
        if (size > frsMaxCache && this.hqU.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                arrayList2.add(this.hqU.remove(0));
                if (this.hqP == null || this.hqP.bOY() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.hqP.bOY().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.hqW != null) {
                            this.hqW.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.hqS != null) {
                this.hqS.remove(mVar);
            }
            if (this.hqU != null) {
                this.hqU.remove(mVar);
            }
        }
    }

    public void Dn(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.hqS)) {
                e(this.hqS, str);
            }
            if (!v.isEmpty(this.hqU)) {
                e(this.hqU, str);
            }
        }
    }

    private void e(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bdL() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bdL()).dmo)) {
                    it.remove();
                }
            }
        }
    }
}
