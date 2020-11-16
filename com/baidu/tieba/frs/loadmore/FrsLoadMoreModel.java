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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.aa;
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
/* loaded from: classes21.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int hBs;
    private k iJK;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a jdo;
    private boolean jdp;
    private long jdq;
    private final ArrayList<q> jdr;
    private final ArrayList<String> jds;
    private final ArrayList<q> jdt;
    private boolean jdu;
    private c.a jdv;
    private final com.baidu.adp.framework.listener.a jdw;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes21.dex */
    public interface a {
        void ay(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.jdp = false;
        this.jdq = 0L;
        this.jdr = new ArrayList<>();
        this.jds = new ArrayList<>();
        this.jdt = new ArrayList<>();
        this.mPn = 1;
        this.hBs = -1;
        this.jdu = false;
        this.mPageType = 1;
        this.jdw = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.jdo != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.jdo.onFailed(FrsLoadMoreModel.this.jdo.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.jdo.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.jdo.onFailed(FrsLoadMoreModel.this.jdo.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cys = FrsLoadMoreModel.this.jdo.cys();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cys != null) {
                                cys.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jdo.ay(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jdo instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jdo).fuA = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cys != null) {
                                cys.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.jdo.ay(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.jdo instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.jdo).fuA = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.jdo.getForumName()) && com.baidu.tieba.recapp.q.dzO().dzI() != null) {
                            com.baidu.tieba.recapp.q.dzO().dzI().f(FrsLoadMoreModel.this.jdo.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.jdo = aVar;
        setUniqueId(this.jdo.getUniqueId());
        this.iJK = kVar;
        this.jdw.getHttpMessageListener().setSelfListener(true);
        this.jdw.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jdw);
    }

    public int cxP() {
        return this.hBs;
    }

    public void setHasMore(int i) {
        this.hBs = i;
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

    public void qn(boolean z) {
        this.jdu = z;
    }

    public void registerListener() {
        registerListener(this.jdw);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.bDl(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.jdq = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (com.baidu.tieba.recapp.q.dzO().dzI() != null) {
            loadMoreRequestMessage.setLoadCount(com.baidu.tieba.recapp.q.dzO().dzI().ba(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.jdp) {
            this.jdp = true;
            if (m.bBK().isSmallFlow() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jdq)) != null) {
                iVar.bBH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.jdp) {
            this.jdp = true;
            if (m.bBK().isSmallFlow() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.jdq)) != null) {
                iVar.bBH();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bBK().isSmallFlow() && (this.jdo instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.jdq;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.jdo).fuA, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.fuJ = currentTimeMillis;
                iVar.ky(true);
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
        this.jdr.clear();
        this.jds.clear();
        this.jdt.clear();
        this.hBs = -1;
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
            this.jdr.clear();
            this.jds.clear();
            this.jdt.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.jdr.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bw) {
                bx bxVar = ((bw) next).evQ;
                if (bxVar.getTid() != null) {
                    hashSet.add(bxVar.getTid());
                }
            } else if (next instanceof bx) {
                bx bxVar2 = (bx) next;
                if (bxVar2.getTid() != null) {
                    hashSet.add(bxVar2.getTid());
                }
            }
        }
        ArrayList<q> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!y.isEmpty(arrayList)) {
            Iterator<q> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    bx bxVar3 = ((bw) next2).evQ;
                    bxVar3.Ax(this.jdo.getForumName());
                    if (this.jdo != null && this.jdo.cys() != null && this.jdo.cys().getForum() != null) {
                        if (!StringUtils.isNull(this.jdo.cys().getForum().getFirst_class())) {
                            bxVar3.AC(this.jdo.cys().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jdo.cys().getForum().getSecond_class())) {
                            bxVar3.AD(this.jdo.cys().getForum().getSecond_class());
                        }
                    }
                    if (bxVar3.bma()) {
                        if (!hashSet.contains(bxVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bw) next2).evQ.tid)) {
                                arrayList3.add(((bw) next2).evQ.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bw) next2).evQ.tid)) {
                            arrayList3.add(((bw) next2).evQ.tid);
                        }
                    }
                } else if (next2 instanceof bx) {
                    bx bxVar4 = (bx) next2;
                    bxVar4.Ax(this.jdo.getForumName());
                    if (this.jdo != null && this.jdo.cys() != null && this.jdo.cys().getForum() != null) {
                        if (!StringUtils.isNull(this.jdo.cys().getForum().getFirst_class())) {
                            bxVar4.AC(this.jdo.cys().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.jdo.cys().getForum().getSecond_class())) {
                            bxVar4.AD(this.jdo.cys().getForum().getSecond_class());
                        }
                    }
                    if (bxVar4.bma()) {
                        if (!hashSet.contains(bxVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bxVar4.tid)) {
                                arrayList3.add(bxVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bxVar4.tid)) {
                            arrayList3.add(bxVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.iJK != null) {
            this.iJK.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cys = this.jdo.cys();
        if (this.jdu && cys != null && (this.jdo instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.jdr);
            arrayList4.addAll(this.jdt);
            cys.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.jdo, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.jdr.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.jdr.add(arrayList2.get(i));
            } else {
                this.jdt.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.jdr);
        arrayList5.addAll(this.jdt);
        if (this.jdo instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.jdo, this.jdo.cys(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cDE() {
        int i;
        int size = this.jdt.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.jdt.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.jdt.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.jdr);
        arrayList.addAll(this.jdt);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.jdv = aVar;
    }

    public void cDF() {
        int i;
        ArrayList<q> arrayList;
        int size = this.jdt.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.jdr);
        if (size > frsMaxCache && this.jdt.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.jdt.remove(0));
                if (this.jdo == null || this.jdo.cys() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.jdo.cys().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.jdv != null) {
                            this.jdv.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.jdr != null) {
                this.jdr.remove(qVar);
            }
            if (this.jdt != null) {
                this.jdt.remove(qVar);
            }
        }
    }

    public void Kr(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.jdr)) {
                e(this.jdr, str);
            }
            if (!y.isEmpty(this.jdt)) {
                e(this.jdt, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bGV() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bGV()).exc)) {
                    it.remove();
                }
            }
        }
    }
}
