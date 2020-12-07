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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.h;
import com.baidu.tbadk.n.l;
import com.baidu.tbadk.util.aa;
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
/* loaded from: classes22.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int hKX;
    private k iUC;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a jqR;
    private boolean jqS;
    private long jqT;
    private final ArrayList<q> jqU;
    private final ArrayList<String> jqV;
    private final ArrayList<q> jqW;
    private boolean jqX;
    private c.a jqY;
    private final com.baidu.adp.framework.listener.a jqZ;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes22.dex */
    public interface a {
        void az(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.jqS = false;
        this.jqT = 0L;
        this.jqU = new ArrayList<>();
        this.jqV = new ArrayList<>();
        this.jqW = new ArrayList<>();
        this.mPn = 1;
        this.hKX = -1;
        this.jqX = false;
        this.mPageType = 1;
        this.jqZ = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jqR != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jqR.onFailed(FrsLoadMoreModel.this.jqR.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jqR.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jqR.onFailed(FrsLoadMoreModel.this.jqR.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cCJ = FrsLoadMoreModel.this.jqR.cCJ();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cCJ != null) {
                                cCJ.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jqR.az(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jqR instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jqR).fCl = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cCJ != null) {
                                cCJ.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jqR.az(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jqR instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jqR).fCl = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jqR.getForumName()) && r.dFf().dEZ() != null) {
                            r.dFf().dEZ().f(FrsLoadMoreModel.this.jqR.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jqR = aVar;
        setUniqueId(this.jqR.getUniqueId());
        this.iUC = kVar;
        this.jqZ.getHttpMessageListener().setSelfListener(true);
        this.jqZ.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jqZ);
    }

    public int cCf() {
        return this.hKX;
    }

    public void setHasMore(int i) {
        this.hKX = i;
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

    public void qO(boolean z) {
        this.jqX = z;
    }

    public void registerListener() {
        registerListener(this.jqZ);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String dw = dw(list);
        if (!TextUtils.isEmpty(dw)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(dw);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.bGM(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jqT = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dFf().dEZ() != null) {
            loadMoreRequestMessage.setLoadCount(r.dFf().dEZ().bb(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        h hVar;
        if (!this.jqS) {
            this.jqS = true;
            if (l.bFl().isSmallFlow() && (hVar = new h(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jqT)) != null) {
                hVar.bFi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        h hVar;
        if (!this.jqS) {
            this.jqS = true;
            if (l.bFl().isSmallFlow() && (hVar = new h(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jqT)) != null) {
                hVar.bFi();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (l.bFl().isSmallFlow() && (this.jqR instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jqT;
            h hVar = new h(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jqR).fCl, false, 0L, 0L, currentTimeMillis);
            if (hVar != null) {
                hVar.fCu = currentTimeMillis;
                hVar.kR(true);
            }
        }
    }

    private String dw(List<Long> list) {
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
        this.jqU.clear();
        this.jqV.clear();
        this.jqW.clear();
        this.hKX = -1;
        this.mPn = 1;
    }

    public boolean dx(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.jqU.clear();
            this.jqV.clear();
            this.jqW.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.jqU.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bx) {
                by byVar = ((bx) next).eCR;
                if (byVar.getTid() != null) {
                    hashSet.add(byVar.getTid());
                }
            } else if (next instanceof by) {
                by byVar2 = (by) next;
                if (byVar2.getTid() != null) {
                    hashSet.add(byVar2.getTid());
                }
            }
        }
        ArrayList<q> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!y.isEmpty(arrayList)) {
            Iterator<q> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bx) {
                    by byVar3 = ((bx) next2).eCR;
                    byVar3.Be(this.jqR.getForumName());
                    if (this.jqR != null && this.jqR.cCJ() != null && this.jqR.cCJ().getForum() != null) {
                        if (!StringUtils.isNull(this.jqR.cCJ().getForum().getFirst_class())) {
                            byVar3.Bj(this.jqR.cCJ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jqR.cCJ().getForum().getSecond_class())) {
                            byVar3.Bk(this.jqR.cCJ().getForum().getSecond_class());
                        }
                    }
                    if (byVar3.bpn()) {
                        if (!hashSet.contains(byVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bx) next2).eCR.tid)) {
                                arrayList3.add(((bx) next2).eCR.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bx) next2).eCR.tid)) {
                            arrayList3.add(((bx) next2).eCR.tid);
                        }
                    }
                } else if (next2 instanceof by) {
                    by byVar4 = (by) next2;
                    byVar4.Be(this.jqR.getForumName());
                    if (this.jqR != null && this.jqR.cCJ() != null && this.jqR.cCJ().getForum() != null) {
                        if (!StringUtils.isNull(this.jqR.cCJ().getForum().getFirst_class())) {
                            byVar4.Bj(this.jqR.cCJ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jqR.cCJ().getForum().getSecond_class())) {
                            byVar4.Bk(this.jqR.cCJ().getForum().getSecond_class());
                        }
                    }
                    if (byVar4.bpn()) {
                        if (!hashSet.contains(byVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(byVar4.tid)) {
                                arrayList3.add(byVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(byVar4.tid)) {
                            arrayList3.add(byVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.iUC != null) {
            this.iUC.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cCJ = this.jqR.cCJ();
        if (this.jqX && cCJ != null && (this.jqR instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.jqU);
            arrayList4.addAll(this.jqW);
            cCJ.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jqR, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jqU.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jqU.add(arrayList2.get(i));
            } else {
                this.jqW.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jqU);
        arrayList5.addAll(this.jqW);
        if (this.jqR instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jqR, this.jqR.cCJ(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cIR() {
        int i;
        int size = this.jqW.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jqW.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jqW.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jqU);
        arrayList.addAll(this.jqW);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jqY = aVar;
    }

    public void cIS() {
        int i;
        ArrayList<q> arrayList;
        int size = this.jqW.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.jqU);
        if (size > frsMaxCache && this.jqW.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jqW.remove(0));
                if (this.jqR == null || this.jqR.cCJ() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jqR.cCJ().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jqY != null) {
                            this.jqY.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.jqU != null) {
                this.jqU.remove(qVar);
            }
            if (this.jqW != null) {
                this.jqW.remove(qVar);
            }
        }
    }

    public void Ly(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.jqU)) {
                e(this.jqU, str);
            }
            if (!y.isEmpty(this.jqW)) {
                e(this.jqW, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bKv() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bKv()).eEd)) {
                    it.remove();
                }
            }
        }
    }
}
