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
    private int hjS;
    private final com.baidu.tieba.frs.loadmore.a iKi;
    private boolean iKj;
    private long iKk;
    private final ArrayList<q> iKl;
    private final ArrayList<String> iKm;
    private final ArrayList<q> iKn;
    private boolean iKo;
    private c.a iKp;
    private final com.baidu.adp.framework.listener.a iKq;
    private k iqD;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes22.dex */
    public interface a {
        void aw(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.iKj = false;
        this.iKk = 0L;
        this.iKl = new ArrayList<>();
        this.iKm = new ArrayList<>();
        this.iKn = new ArrayList<>();
        this.mPn = 1;
        this.hjS = -1;
        this.iKo = false;
        this.mPageType = 1;
        this.iKq = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.iKi != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.iKi.onFailed(FrsLoadMoreModel.this.iKi.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.iKi.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.iKi.onFailed(FrsLoadMoreModel.this.iKi.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cth = FrsLoadMoreModel.this.iKi.cth();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cth != null) {
                                cth.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.iKi.aw(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.iKi instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.iKi).fgW = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cth != null) {
                                cth.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.iKi.aw(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.iKi instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.iKi).fgW = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.iKi.getForumName()) && r.duF().duz() != null) {
                            r.duF().duz().f(FrsLoadMoreModel.this.iKi.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.iKi = aVar;
        setUniqueId(this.iKi.getUniqueId());
        this.iqD = kVar;
        this.iKq.getHttpMessageListener().setSelfListener(true);
        this.iKq.getSocketMessageListener().setSelfListener(true);
        registerListener(this.iKq);
    }

    public int csE() {
        return this.hjS;
    }

    public void setHasMore(int i) {
        this.hjS = i;
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

    public void pJ(boolean z) {
        this.iKo = z;
    }

    public void registerListener() {
        registerListener(this.iKq);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cW = cW(list);
        if (!TextUtils.isEmpty(cW)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cW);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ac.bzC(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.iKk = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.duF().duz() != null) {
            loadMoreRequestMessage.setLoadCount(r.duF().duz().aY(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.iKj) {
            this.iKj = true;
            if (m.byc().byd() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.iKk)) != null) {
                iVar.bxZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.iKj) {
            this.iKj = true;
            if (m.byc().byd() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.iKk)) != null) {
                iVar.bxZ();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.byc().byd() && (this.iKi instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.iKk;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.iKi).fgW, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.fhf = currentTimeMillis;
                iVar.kb(true);
            }
        }
    }

    private String cW(List<Long> list) {
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
        this.iKl.clear();
        this.iKm.clear();
        this.iKn.clear();
        this.hjS = -1;
        this.mPn = 1;
    }

    public boolean cX(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.iKl.clear();
            this.iKm.clear();
            this.iKn.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.iKl.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bw bwVar = ((bv) next).eji;
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
                    bw bwVar3 = ((bv) next2).eji;
                    bwVar3.Av(this.iKi.getForumName());
                    if (this.iKi != null && this.iKi.cth() != null && this.iKi.cth().getForum() != null) {
                        if (!StringUtils.isNull(this.iKi.cth().getForum().getFirst_class())) {
                            bwVar3.AA(this.iKi.cth().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.iKi.cth().getForum().getSecond_class())) {
                            bwVar3.AB(this.iKi.cth().getForum().getSecond_class());
                        }
                    }
                    if (bwVar3.biF()) {
                        if (!hashSet.contains(bwVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bv) next2).eji.tid)) {
                                arrayList3.add(((bv) next2).eji.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bv) next2).eji.tid)) {
                            arrayList3.add(((bv) next2).eji.tid);
                        }
                    }
                } else if (next2 instanceof bw) {
                    bw bwVar4 = (bw) next2;
                    bwVar4.Av(this.iKi.getForumName());
                    if (this.iKi != null && this.iKi.cth() != null && this.iKi.cth().getForum() != null) {
                        if (!StringUtils.isNull(this.iKi.cth().getForum().getFirst_class())) {
                            bwVar4.AA(this.iKi.cth().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.iKi.cth().getForum().getSecond_class())) {
                            bwVar4.AB(this.iKi.cth().getForum().getSecond_class());
                        }
                    }
                    if (bwVar4.biF()) {
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
        if (this.iqD != null) {
            this.iqD.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cth = this.iKi.cth();
        if (this.iKo && cth != null && (this.iKi instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.iKl);
            arrayList4.addAll(this.iKn);
            cth.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.iKi, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.iKl.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.iKl.add(arrayList2.get(i));
            } else {
                this.iKn.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.iKl);
        arrayList5.addAll(this.iKn);
        if (this.iKi instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.iKi, this.iKi.cth(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cys() {
        int i;
        int size = this.iKn.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.iKn.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.iKn.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iKl);
        arrayList.addAll(this.iKn);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.iKp = aVar;
    }

    public void cyt() {
        int i;
        ArrayList<q> arrayList;
        int size = this.iKn.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.iKl);
        if (size > frsMaxCache && this.iKn.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.iKn.remove(0));
                if (this.iKi == null || this.iKi.cth() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.iKi.cth().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.iKp != null) {
                            this.iKp.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.iKl != null) {
                this.iKl.remove(qVar);
            }
            if (this.iKn != null) {
                this.iKn.remove(qVar);
            }
        }
    }

    public void Ka(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.iKl)) {
                e(this.iKl, str);
            }
            if (!y.isEmpty(this.iKn)) {
                e(this.iKn, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bDk() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bDk()).ekv)) {
                    it.remove();
                }
            }
        }
    }
}
