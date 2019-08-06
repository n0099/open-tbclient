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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
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
    private int egP;
    private final ArrayList<String> fMA;
    private final ArrayList<m> fMB;
    private boolean fMC;
    private c.a fMD;
    private final com.baidu.adp.framework.listener.a fME;
    private final com.baidu.tieba.frs.loadmore.a fMw;
    private boolean fMx;
    private long fMy;
    private final ArrayList<m> fMz;
    private k fvJ;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void V(ArrayList<m> arrayList);

        void wD(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fMx = false;
        this.fMy = 0L;
        this.fMz = new ArrayList<>();
        this.fMA = new ArrayList<>();
        this.fMB = new ArrayList<>();
        this.mPn = 1;
        this.egP = -1;
        this.fMC = false;
        this.mPageType = 1;
        this.fME = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fMw != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fMw.wD(FrsLoadMoreModel.this.fMw.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fMw.wD(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fMw.wD(FrsLoadMoreModel.this.fMw.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bmy = FrsLoadMoreModel.this.fMw.bmy();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bmy != null) {
                                bmy.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fMw.V(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fMw instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fMw).cAc = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bmy != null) {
                                bmy.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fMw.V(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fMw instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fMw).cAc = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fMw.getForumName()) && r.chV().chP() != null) {
                            r.chV().chP().g(FrsLoadMoreModel.this.fMw.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fMw = aVar;
        setUniqueId(this.fMw.getUniqueId());
        this.fvJ = kVar;
        this.fME.getHttpMessageListener().setSelfListener(true);
        this.fME.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fME);
    }

    public int blZ() {
        return this.egP;
    }

    public void setHasMore(int i) {
        this.egP = i;
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
        this.fMC = z;
    }

    public void registerListener() {
        registerListener(this.fME);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.aa(list)) {
            this.loadingDone = true;
            return;
        }
        String ch = ch(list);
        if (!TextUtils.isEmpty(ch)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ch);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(y.awA(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fMy = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.chV().chP() != null) {
            loadMoreRequestMessage.setLoadCount(r.chV().chP().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fMx) {
            this.fMx = true;
            if (com.baidu.tbadk.p.m.avv().avw() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fMy)) != null) {
                iVar.avs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fMx) {
            this.fMx = true;
            if (com.baidu.tbadk.p.m.avv().avw() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fMy)) != null) {
                iVar.avs();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avv().avw() && (this.fMw instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fMy;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fMw).cAc, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cAl = currentTimeMillis;
                iVar.fE(true);
            }
        }
    }

    private String ch(List<Long> list) {
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
        this.fMz.clear();
        this.fMA.clear();
        this.fMB.clear();
        this.egP = -1;
        this.mPn = 1;
    }

    public boolean ci(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fMz.clear();
            this.fMA.clear();
            this.fMB.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fMz.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bg) {
                bh bhVar = ((bg) next).threadData;
                if (bhVar.getTid() != null) {
                    hashSet.add(bhVar.getTid());
                }
            } else if (next instanceof bh) {
                bh bhVar2 = (bh) next;
                if (bhVar2.getTid() != null) {
                    hashSet.add(bhVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    bh bhVar3 = ((bg) next2).threadData;
                    bhVar3.mz(this.fMw.getForumName());
                    if (bhVar3.aeV()) {
                        if (!hashSet.contains(bhVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bg) next2).threadData.tid)) {
                                arrayList3.add(((bg) next2).threadData.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bg) next2).threadData.tid)) {
                            arrayList3.add(((bg) next2).threadData.tid);
                        }
                    }
                } else if (next2 instanceof bh) {
                    bh bhVar4 = (bh) next2;
                    bhVar4.mz(this.fMw.getForumName());
                    if (bhVar4.aeV()) {
                        if (!hashSet.contains(bhVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bhVar4.tid)) {
                                arrayList3.add(bhVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bhVar4.tid)) {
                            arrayList3.add(bhVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.fvJ != null) {
            this.fvJ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bmy = this.fMw.bmy();
        if (this.fMC && bmy != null && (this.fMw instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.fMz);
            arrayList4.addAll(this.fMB);
            bmy.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.fMw, true, arrayList2, arrayList4, z2);
        }
        int amA = TbadkCoreApplication.getInst().getListItemRule().amA() - this.fMz.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < amA) {
                this.fMz.add(arrayList2.get(i));
            } else {
                this.fMB.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.fMz);
        arrayList5.addAll(this.fMB);
        if (this.fMw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fMw, this.fMw.bmy(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> brk() {
        int i;
        int size = this.fMB.size() + 30;
        int amz = TbadkCoreApplication.getInst().getListItemRule().amz() * 3;
        if (size > amz && this.fMB.size() > (i = size - amz)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fMB.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fMz);
        arrayList.addAll(this.fMB);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fMD = aVar;
    }

    public void brl() {
        int i;
        int size = this.fMB.size() + 30;
        int amz = TbadkCoreApplication.getInst().getListItemRule().amz() * 3;
        int Z = v.Z(this.fMz);
        if (size > amz && this.fMB.size() > (i = size - amz)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fMB.remove(0);
                if (this.fMD != null) {
                    this.fMD.removeItem(Z);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fMz != null) {
                this.fMz.remove(mVar);
            }
            if (this.fMB != null) {
                this.fMB.remove(mVar);
            }
        }
    }

    public void xw(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.aa(this.fMz)) {
                c(this.fMz, str);
            }
            if (!v.aa(this.fMB)) {
                c(this.fMB, str);
            }
        }
    }

    private void c(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aAz() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAz()).bEU)) {
                    it.remove();
                }
            }
        }
    }
}
