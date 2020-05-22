package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.ab;
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
    private int gmi;
    private final com.baidu.tieba.frs.loadmore.a hFK;
    private boolean hFL;
    private long hFM;
    private final ArrayList<o> hFN;
    private final ArrayList<String> hFO;
    private final ArrayList<o> hFP;
    private boolean hFQ;
    private c.a hFR;
    private final com.baidu.adp.framework.listener.a hFS;
    private k hoA;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void an(ArrayList<o> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.hFL = false;
        this.hFM = 0L;
        this.hFN = new ArrayList<>();
        this.hFO = new ArrayList<>();
        this.hFP = new ArrayList<>();
        this.mPn = 1;
        this.gmi = -1;
        this.hFQ = false;
        this.mPageType = 1;
        this.hFS = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.hFK != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.hFK.onFailed(FrsLoadMoreModel.this.hFK.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.hFK.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.hFK.onFailed(FrsLoadMoreModel.this.hFK.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bVs = FrsLoadMoreModel.this.hFK.bVs();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bVs != null) {
                                bVs.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hFK.an(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hFK instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hFK).esg = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bVs != null) {
                                bVs.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hFK.an(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hFK instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hFK).esg = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.hFK.getForumName()) && q.cUm().cUg() != null) {
                            q.cUm().cUg().f(FrsLoadMoreModel.this.hFK.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.hFK = aVar;
        setUniqueId(this.hFK.getUniqueId());
        this.hoA = kVar;
        this.hFS.getHttpMessageListener().setSelfListener(true);
        this.hFS.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hFS);
    }

    public int bUS() {
        return this.gmi;
    }

    public void setHasMore(int i) {
        this.gmi = i;
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

    public void nB(boolean z) {
        this.hFQ = z;
    }

    public void registerListener() {
        registerListener(this.hFS);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cv = cv(list);
        if (!TextUtils.isEmpty(cv)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cv);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bgN(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.hFM = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.cUm().cUg() != null) {
            loadMoreRequestMessage.setLoadCount(q.cUm().cUg().aR(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.hFL) {
            this.hFL = true;
            if (m.bfI().bfJ() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hFM)) != null) {
                iVar.bfF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.hFL) {
            this.hFL = true;
            if (m.bfI().bfJ() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hFM)) != null) {
                iVar.bfF();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bfI().bfJ() && (this.hFK instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.hFM;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.hFK).esg, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.esp = currentTimeMillis;
                iVar.io(true);
            }
        }
    }

    private String cv(List<Long> list) {
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
        this.hFN.clear();
        this.hFO.clear();
        this.hFP.clear();
        this.gmi = -1;
        this.mPn = 1;
    }

    public boolean cw(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<o> a(boolean z, boolean z2, boolean z3, ArrayList<o> arrayList, f fVar) {
        if (z3) {
            this.hFN.clear();
            this.hFO.clear();
            this.hFP.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<o> it = this.hFN.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next instanceof bj) {
                bk bkVar = ((bj) next).dEA;
                if (bkVar.getTid() != null) {
                    hashSet.add(bkVar.getTid());
                }
            } else if (next instanceof bk) {
                bk bkVar2 = (bk) next;
                if (bkVar2.getTid() != null) {
                    hashSet.add(bkVar2.getTid());
                }
            }
        }
        ArrayList<o> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.isEmpty(arrayList)) {
            Iterator<o> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                o next2 = it2.next();
                if (next2 instanceof bj) {
                    bk bkVar3 = ((bj) next2).dEA;
                    bkVar3.vC(this.hFK.getForumName());
                    if (this.hFK != null && this.hFK.bVs() != null && this.hFK.bVs().getForum() != null) {
                        if (!StringUtils.isNull(this.hFK.bVs().getForum().getFirst_class())) {
                            bkVar3.vH(this.hFK.bVs().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hFK.bVs().getForum().getSecond_class())) {
                            bkVar3.vI(this.hFK.bVs().getForum().getSecond_class());
                        }
                    }
                    if (bkVar3.aQW()) {
                        if (!hashSet.contains(bkVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bj) next2).dEA.tid)) {
                                arrayList3.add(((bj) next2).dEA.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bj) next2).dEA.tid)) {
                            arrayList3.add(((bj) next2).dEA.tid);
                        }
                    }
                } else if (next2 instanceof bk) {
                    bk bkVar4 = (bk) next2;
                    bkVar4.vC(this.hFK.getForumName());
                    if (this.hFK != null && this.hFK.bVs() != null && this.hFK.bVs().getForum() != null) {
                        if (!StringUtils.isNull(this.hFK.bVs().getForum().getFirst_class())) {
                            bkVar4.vH(this.hFK.bVs().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hFK.bVs().getForum().getSecond_class())) {
                            bkVar4.vI(this.hFK.bVs().getForum().getSecond_class());
                        }
                    }
                    if (bkVar4.aQW()) {
                        if (!hashSet.contains(bkVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bkVar4.tid)) {
                                arrayList3.add(bkVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bkVar4.tid)) {
                            arrayList3.add(bkVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.hoA != null) {
            this.hoA.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bVs = this.hFK.bVs();
        if (this.hFQ && bVs != null && (this.hFK instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<o> arrayList4 = new ArrayList<>(this.hFN);
            arrayList4.addAll(this.hFP);
            bVs.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.hFK, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.hFN.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.hFN.add(arrayList2.get(i));
            } else {
                this.hFP.add(arrayList2.get(i));
            }
        }
        ArrayList<o> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.hFN);
        arrayList5.addAll(this.hFP);
        if (this.hFK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.hFK, this.hFK.bVs(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<o> cae() {
        int i;
        int size = this.hFP.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.hFP.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.hFP.remove(0);
            }
        }
        ArrayList<o> arrayList = new ArrayList<>();
        arrayList.addAll(this.hFN);
        arrayList.addAll(this.hFP);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.hFR = aVar;
    }

    public void caf() {
        int i;
        ArrayList<o> arrayList;
        int size = this.hFP.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.hFN);
        if (size > frsMaxCache && this.hFP.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<o> arrayList2 = new ArrayList<>();
                arrayList2.add(this.hFP.remove(0));
                if (this.hFK == null || this.hFK.bVs() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.hFK.bVs().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.hFR != null) {
                            this.hFR.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(o oVar) {
        if (oVar != null) {
            if (this.hFN != null) {
                this.hFN.remove(oVar);
            }
            if (this.hFP != null) {
                this.hFP.remove(oVar);
            }
        }
    }

    public void EZ(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.hFN)) {
                e(this.hFN, str);
            }
            if (!v.isEmpty(this.hFP)) {
                e(this.hFP, str);
            }
        }
    }

    private void e(ArrayList<o> arrayList, String str) {
        Iterator<o> it = arrayList.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bjU() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bjU()).dAu)) {
                    it.remove();
                }
            }
        }
    }
}
