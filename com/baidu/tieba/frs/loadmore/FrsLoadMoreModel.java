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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.ac;
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
/* loaded from: classes22.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int hBL;
    private k iIW;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a jcB;
    private boolean jcC;
    private long jcD;
    private final ArrayList<q> jcE;
    private final ArrayList<String> jcF;
    private final ArrayList<q> jcG;
    private boolean jcH;
    private c.a jcI;
    private final com.baidu.adp.framework.listener.a jcJ;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes22.dex */
    public interface a {
        void ax(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.jcC = false;
        this.jcD = 0L;
        this.jcE = new ArrayList<>();
        this.jcF = new ArrayList<>();
        this.jcG = new ArrayList<>();
        this.mPn = 1;
        this.hBL = -1;
        this.jcH = false;
        this.mPageType = 1;
        this.jcJ = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jcB != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jcB.onFailed(FrsLoadMoreModel.this.jcB.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jcB.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jcB.onFailed(FrsLoadMoreModel.this.jcB.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cyP = FrsLoadMoreModel.this.jcB.cyP();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cyP != null) {
                                cyP.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jcB.ax(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jcB instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jcB).fvq = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cyP != null) {
                                cyP.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jcB.ax(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jcB instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jcB).fvq = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jcB.getForumName()) && r.dAo().dAi() != null) {
                            r.dAo().dAi().f(FrsLoadMoreModel.this.jcB.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jcB = aVar;
        setUniqueId(this.jcB.getUniqueId());
        this.iIW = kVar;
        this.jcJ.getHttpMessageListener().setSelfListener(true);
        this.jcJ.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jcJ);
    }

    public int cym() {
        return this.hBL;
    }

    public void setHasMore(int i) {
        this.hBL = i;
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

    public void qk(boolean z) {
        this.jcH = z;
    }

    public void registerListener() {
        registerListener(this.jcJ);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String dn = dn(list);
        if (!TextUtils.isEmpty(dn)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(dn);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ac.bDU(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jcD = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dAo().dAi() != null) {
            loadMoreRequestMessage.setLoadCount(r.dAo().dAi().ba(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.jcC) {
            this.jcC = true;
            if (m.bCu().bCv() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jcD)) != null) {
                iVar.bCr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.jcC) {
            this.jcC = true;
            if (m.bCu().bCv() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jcD)) != null) {
                iVar.bCr();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bCu().bCv() && (this.jcB instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jcD;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jcB).fvq, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.fvz = currentTimeMillis;
                iVar.kx(true);
            }
        }
    }

    private String dn(List<Long> list) {
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
        this.jcE.clear();
        this.jcF.clear();
        this.jcG.clear();
        this.hBL = -1;
        this.mPn = 1;
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m40do(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.jcE.clear();
            this.jcF.clear();
            this.jcG.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.jcE.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bw bwVar = ((bv) next).exA;
                if (bwVar.getTid() != null) {
                    hashSet.add(bwVar.getTid());
                }
            } else if (next instanceof bw) {
                bw bwVar2 = (bw) next;
                if (bwVar2.getTid() != null) {
                    hashSet.add(bwVar2.getTid());
                }
            }
        }
        ArrayList<q> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!y.isEmpty(arrayList)) {
            Iterator<q> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bv) {
                    bw bwVar3 = ((bv) next2).exA;
                    bwVar3.Bc(this.jcB.getForumName());
                    if (this.jcB != null && this.jcB.cyP() != null && this.jcB.cyP().getForum() != null) {
                        if (!StringUtils.isNull(this.jcB.cyP().getForum().getFirst_class())) {
                            bwVar3.Bh(this.jcB.cyP().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jcB.cyP().getForum().getSecond_class())) {
                            bwVar3.Bi(this.jcB.cyP().getForum().getSecond_class());
                        }
                    }
                    if (bwVar3.bmY()) {
                        if (!hashSet.contains(bwVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bv) next2).exA.tid)) {
                                arrayList3.add(((bv) next2).exA.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bv) next2).exA.tid)) {
                            arrayList3.add(((bv) next2).exA.tid);
                        }
                    }
                } else if (next2 instanceof bw) {
                    bw bwVar4 = (bw) next2;
                    bwVar4.Bc(this.jcB.getForumName());
                    if (this.jcB != null && this.jcB.cyP() != null && this.jcB.cyP().getForum() != null) {
                        if (!StringUtils.isNull(this.jcB.cyP().getForum().getFirst_class())) {
                            bwVar4.Bh(this.jcB.cyP().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jcB.cyP().getForum().getSecond_class())) {
                            bwVar4.Bi(this.jcB.cyP().getForum().getSecond_class());
                        }
                    }
                    if (bwVar4.bmY()) {
                        if (!hashSet.contains(bwVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bwVar4.tid)) {
                                arrayList3.add(bwVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bwVar4.tid)) {
                            arrayList3.add(bwVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.iIW != null) {
            this.iIW.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cyP = this.jcB.cyP();
        if (this.jcH && cyP != null && (this.jcB instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.jcE);
            arrayList4.addAll(this.jcG);
            cyP.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jcB, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jcE.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jcE.add(arrayList2.get(i));
            } else {
                this.jcG.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jcE);
        arrayList5.addAll(this.jcG);
        if (this.jcB instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jcB, this.jcB.cyP(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cEa() {
        int i;
        int size = this.jcG.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jcG.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jcG.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jcE);
        arrayList.addAll(this.jcG);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jcI = aVar;
    }

    public void cEb() {
        int i;
        ArrayList<q> arrayList;
        int size = this.jcG.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.jcE);
        if (size > frsMaxCache && this.jcG.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jcG.remove(0));
                if (this.jcB == null || this.jcB.cyP() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jcB.cyP().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jcI != null) {
                            this.jcI.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.jcE != null) {
                this.jcE.remove(qVar);
            }
            if (this.jcG != null) {
                this.jcG.remove(qVar);
            }
        }
    }

    public void KQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.jcE)) {
                e(this.jcE, str);
            }
            if (!y.isEmpty(this.jcG)) {
                e(this.jcG, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bHC() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bHC()).eyO)) {
                    it.remove();
                }
            }
        }
    }
}
