package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.p.i;
import com.baidu.tbadk.util.y;
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
/* loaded from: classes4.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int egI;
    private final com.baidu.tieba.frs.loadmore.a fLI;
    private boolean fLJ;
    private long fLK;
    private final ArrayList<m> fLL;
    private final ArrayList<String> fLM;
    private final ArrayList<m> fLN;
    private boolean fLO;
    private c.a fLP;
    private final com.baidu.adp.framework.listener.a fLQ;
    private k fvk;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void V(ArrayList<m> arrayList);

        void wC(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fLJ = false;
        this.fLK = 0L;
        this.fLL = new ArrayList<>();
        this.fLM = new ArrayList<>();
        this.fLN = new ArrayList<>();
        this.mPn = 1;
        this.egI = -1;
        this.fLO = false;
        this.mPageType = 1;
        this.fLQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fLI != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fLI.wC(FrsLoadMoreModel.this.fLI.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fLI.wC(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fLI.wC(FrsLoadMoreModel.this.fLI.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bmo = FrsLoadMoreModel.this.fLI.bmo();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bmo != null) {
                                bmo.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fLI.V(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fLI instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fLI).czV = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bmo != null) {
                                bmo.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fLI.V(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fLI instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fLI).czV = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fLI.getForumName()) && r.chD().chx() != null) {
                            r.chD().chx().g(FrsLoadMoreModel.this.fLI.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fLI = aVar;
        setUniqueId(this.fLI.getUniqueId());
        this.fvk = kVar;
        this.fLQ.getHttpMessageListener().setSelfListener(true);
        this.fLQ.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fLQ);
    }

    public int blS() {
        return this.egI;
    }

    public void setHasMore(int i) {
        this.egI = i;
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

    public void kI(boolean z) {
        this.fLO = z;
    }

    public void registerListener() {
        registerListener(this.fLQ);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.aa(list)) {
            this.loadingDone = true;
            return;
        }
        String ci = ci(list);
        if (!TextUtils.isEmpty(ci)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ci);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(y.awy(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fLK = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.chD().chx() != null) {
            loadMoreRequestMessage.setLoadCount(r.chD().chx().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fLJ) {
            this.fLJ = true;
            if (com.baidu.tbadk.p.m.avt().avu() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fLK)) != null) {
                iVar.avq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fLJ) {
            this.fLJ = true;
            if (com.baidu.tbadk.p.m.avt().avu() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fLK)) != null) {
                iVar.avq();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avt().avu() && (this.fLI instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fLK;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fLI).czV, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cAe = currentTimeMillis;
                iVar.fE(true);
            }
        }
    }

    private String ci(List<Long> list) {
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
        this.fLL.clear();
        this.fLM.clear();
        this.fLN.clear();
        this.egI = -1;
        this.mPn = 1;
    }

    public boolean cj(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fLL.clear();
            this.fLM.clear();
            this.fLN.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fLL.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bf) {
                bg bgVar = ((bf) next).threadData;
                if (bgVar.getTid() != null) {
                    hashSet.add(bgVar.getTid());
                }
            } else if (next instanceof bg) {
                bg bgVar2 = (bg) next;
                if (bgVar2.getTid() != null) {
                    hashSet.add(bgVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bf) {
                    bg bgVar3 = ((bf) next2).threadData;
                    bgVar3.mz(this.fLI.getForumName());
                    if (bgVar3.aeU()) {
                        if (!hashSet.contains(bgVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bf) next2).threadData.tid)) {
                                arrayList3.add(((bf) next2).threadData.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bf) next2).threadData.tid)) {
                            arrayList3.add(((bf) next2).threadData.tid);
                        }
                    }
                } else if (next2 instanceof bg) {
                    bg bgVar4 = (bg) next2;
                    bgVar4.mz(this.fLI.getForumName());
                    if (bgVar4.aeU()) {
                        if (!hashSet.contains(bgVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bgVar4.tid)) {
                                arrayList3.add(bgVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bgVar4.tid)) {
                            arrayList3.add(bgVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.fvk != null) {
            this.fvk.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bmo = this.fLI.bmo();
        if (this.fLO && bmo != null && (this.fLI instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.fLL);
            arrayList4.addAll(this.fLN);
            bmo.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.fLI, true, arrayList2, arrayList4, z2);
        }
        int amy = TbadkCoreApplication.getInst().getListItemRule().amy() - this.fLL.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < amy) {
                this.fLL.add(arrayList2.get(i));
            } else {
                this.fLN.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.fLL);
        arrayList5.addAll(this.fLN);
        if (this.fLI instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fLI, this.fLI.bmo(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bqX() {
        int i;
        int size = this.fLN.size() + 30;
        int amx = TbadkCoreApplication.getInst().getListItemRule().amx() * 3;
        if (size > amx && this.fLN.size() > (i = size - amx)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fLN.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fLL);
        arrayList.addAll(this.fLN);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fLP = aVar;
    }

    public void bqY() {
        int i;
        int size = this.fLN.size() + 30;
        int amx = TbadkCoreApplication.getInst().getListItemRule().amx() * 3;
        int Z = v.Z(this.fLL);
        if (size > amx && this.fLN.size() > (i = size - amx)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fLN.remove(0);
                if (this.fLP != null) {
                    this.fLP.removeItem(Z);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fLL != null) {
                this.fLL.remove(mVar);
            }
            if (this.fLN != null) {
                this.fLN.remove(mVar);
            }
        }
    }

    public void xv(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.aa(this.fLL)) {
                c(this.fLL, str);
            }
            if (!v.aa(this.fLN)) {
                c(this.fLN, str);
            }
        }
    }

    private void c(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aAx() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAx()).bET)) {
                    it.remove();
                }
            }
        }
    }
}
