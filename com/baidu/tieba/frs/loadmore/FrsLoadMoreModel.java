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
/* loaded from: classes9.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int fsO;
    private final ArrayList<String> gHA;
    private final ArrayList<m> gHB;
    private boolean gHC;
    private c.a gHD;
    private final com.baidu.adp.framework.listener.a gHE;
    private final com.baidu.tieba.frs.loadmore.a gHw;
    private boolean gHx;
    private long gHy;
    private final ArrayList<m> gHz;
    private k gqy;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void al(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.gHx = false;
        this.gHy = 0L;
        this.gHz = new ArrayList<>();
        this.gHA = new ArrayList<>();
        this.gHB = new ArrayList<>();
        this.mPn = 1;
        this.fsO = -1;
        this.gHC = false;
        this.mPageType = 1;
        this.gHE = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.gHw != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.gHw.onFailed(FrsLoadMoreModel.this.gHw.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.gHw.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.gHw.onFailed(FrsLoadMoreModel.this.gHw.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bEz = FrsLoadMoreModel.this.gHw.bEz();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bEz != null) {
                                bEz.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gHw.al(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gHw instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gHw).dEh = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bEz != null) {
                                bEz.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gHw.al(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gHw instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gHw).dEh = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.gHw.getForumName()) && r.cCQ().cCK() != null) {
                            r.cCQ().cCK().f(FrsLoadMoreModel.this.gHw.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.gHw = aVar;
        setUniqueId(this.gHw.getUniqueId());
        this.gqy = kVar;
        this.gHE.getHttpMessageListener().setSelfListener(true);
        this.gHE.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gHE);
    }

    public int bDZ() {
        return this.fsO;
    }

    public void setHasMore(int i) {
        this.fsO = i;
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

    public void mc(boolean z) {
        this.gHC = z;
    }

    public void registerListener() {
        registerListener(this.gHE);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cm = cm(list);
        if (!TextUtils.isEmpty(cm)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cm);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.aSv(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.gHy = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.cCQ().cCK() != null) {
            loadMoreRequestMessage.setLoadCount(r.cCQ().cCK().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.gHx) {
            this.gHx = true;
            if (com.baidu.tbadk.n.m.aRq().aRr() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.gHy)) != null) {
                iVar.aRn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.gHx) {
            this.gHx = true;
            if (com.baidu.tbadk.n.m.aRq().aRr() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.gHy)) != null) {
                iVar.aRn();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRq().aRr() && (this.gHw instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.gHy;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.gHw).dEh, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.dEq = currentTimeMillis;
                iVar.gU(true);
            }
        }
    }

    private String cm(List<Long> list) {
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
        this.gHz.clear();
        this.gHA.clear();
        this.gHB.clear();
        this.fsO = -1;
        this.mPn = 1;
    }

    public boolean cn(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.gHz.clear();
            this.gHA.clear();
            this.gHB.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.gHz.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).cRt;
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
                    bj bjVar3 = ((bi) next2).cRt;
                    bjVar3.sF(this.gHw.getForumName());
                    if (this.gHw != null && this.gHw.bEz() != null && this.gHw.bEz().getForum() != null) {
                        if (!StringUtils.isNull(this.gHw.bEz().getForum().getFirst_class())) {
                            bjVar3.sK(this.gHw.bEz().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gHw.bEz().getForum().getSecond_class())) {
                            bjVar3.sL(this.gHw.bEz().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aCO()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).cRt.tid)) {
                                arrayList3.add(((bi) next2).cRt.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).cRt.tid)) {
                            arrayList3.add(((bi) next2).cRt.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.sF(this.gHw.getForumName());
                    if (this.gHw != null && this.gHw.bEz() != null && this.gHw.bEz().getForum() != null) {
                        if (!StringUtils.isNull(this.gHw.bEz().getForum().getFirst_class())) {
                            bjVar4.sK(this.gHw.bEz().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gHw.bEz().getForum().getSecond_class())) {
                            bjVar4.sL(this.gHw.bEz().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aCO()) {
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
        if (this.gqy != null) {
            this.gqy.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bEz = this.gHw.bEz();
        if (this.gHC && bEz != null && (this.gHw instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.gHz);
            arrayList4.addAll(this.gHB);
            bEz.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.gHw, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.gHz.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.gHz.add(arrayList2.get(i));
            } else {
                this.gHB.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.gHz);
        arrayList5.addAll(this.gHB);
        if (this.gHw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.gHw, this.gHw.bEz(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bJm() {
        int i;
        int size = this.gHB.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.gHB.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.gHB.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gHz);
        arrayList.addAll(this.gHB);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.gHD = aVar;
    }

    public void bJn() {
        int i;
        ArrayList<m> arrayList;
        int size = this.gHB.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.gHz);
        if (size > frsMaxCache && this.gHB.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                arrayList2.add(this.gHB.remove(0));
                if (this.gHw == null || this.gHw.bEz() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.gHw.bEz().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.gHD != null) {
                            this.gHD.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gHz != null) {
                this.gHz.remove(mVar);
            }
            if (this.gHB != null) {
                this.gHB.remove(mVar);
            }
        }
    }

    public void BC(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.gHz)) {
                e(this.gHz, str);
            }
            if (!v.isEmpty(this.gHB)) {
                e(this.gHB, str);
            }
        }
    }

    private void e(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aVB() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVB()).cNk)) {
                    it.remove();
                }
            }
        }
    }
}
