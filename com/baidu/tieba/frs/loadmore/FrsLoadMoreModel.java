package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.p.i;
import com.baidu.tbadk.util.x;
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
    private int evJ;
    private final com.baidu.tieba.frs.loadmore.a fNF;
    private boolean fNG;
    private long fNH;
    private final ArrayList<m> fNI;
    private final ArrayList<String> fNJ;
    private final ArrayList<m> fNK;
    private boolean fNL;
    private c.a fNM;
    private final com.baidu.adp.framework.listener.a fNN;
    private k fwK;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void aa(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fNG = false;
        this.fNH = 0L;
        this.fNI = new ArrayList<>();
        this.fNJ = new ArrayList<>();
        this.fNK = new ArrayList<>();
        this.mPn = 1;
        this.evJ = -1;
        this.fNL = false;
        this.mPageType = 1;
        this.fNN = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fNF != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fNF.onFailed(FrsLoadMoreModel.this.fNF.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fNF.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fNF.onFailed(FrsLoadMoreModel.this.fNF.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bkp = FrsLoadMoreModel.this.fNF.bkp();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bkp != null) {
                                bkp.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fNF.aa(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fNF instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fNF).cMh = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bkp != null) {
                                bkp.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fNF.aa(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fNF instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fNF).cMh = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fNF.getForumName()) && r.cfL().cfF() != null) {
                            r.cfL().cfF().f(FrsLoadMoreModel.this.fNF.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fNF = aVar;
        setUniqueId(this.fNF.getUniqueId());
        this.fwK = kVar;
        this.fNN.getHttpMessageListener().setSelfListener(true);
        this.fNN.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fNN);
    }

    public int bjQ() {
        return this.evJ;
    }

    public void setHasMore(int i) {
        this.evJ = i;
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

    public void ky(boolean z) {
        this.fNL = z;
    }

    public void registerListener() {
        registerListener(this.fNN);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cu = cu(list);
        if (!TextUtils.isEmpty(cu)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cu);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(x.axP(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fNH = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.cfL().cfF() != null) {
            loadMoreRequestMessage.setLoadCount(r.cfL().cfF().at(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fNG) {
            this.fNG = true;
            if (com.baidu.tbadk.p.m.awN().awO() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fNH)) != null) {
                iVar.awK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fNG) {
            this.fNG = true;
            if (com.baidu.tbadk.p.m.awN().awO() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fNH)) != null) {
                iVar.awK();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.awN().awO() && (this.fNF instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fNH;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fNF).cMh, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cMq = currentTimeMillis;
                iVar.fw(true);
            }
        }
    }

    private String cu(List<Long> list) {
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
        this.fNI.clear();
        this.fNJ.clear();
        this.fNK.clear();
        this.evJ = -1;
        this.mPn = 1;
    }

    public boolean cv(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fNI.clear();
            this.fNJ.clear();
            this.fNK.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fNI.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bg) {
                bh bhVar = ((bg) next).cbq;
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
        if (!v.isEmpty(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    bh bhVar3 = ((bg) next2).cbq;
                    bhVar3.mZ(this.fNF.getForumName());
                    if (bhVar3.ajd()) {
                        if (!hashSet.contains(bhVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bg) next2).cbq.tid)) {
                                arrayList3.add(((bg) next2).cbq.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bg) next2).cbq.tid)) {
                            arrayList3.add(((bg) next2).cbq.tid);
                        }
                    }
                } else if (next2 instanceof bh) {
                    bh bhVar4 = (bh) next2;
                    bhVar4.mZ(this.fNF.getForumName());
                    if (bhVar4.ajd()) {
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
        if (this.fwK != null) {
            this.fwK.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bkp = this.fNF.bkp();
        if (this.fNL && bkp != null && (this.fNF instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.fNI);
            arrayList4.addAll(this.fNK);
            bkp.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.fNF, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.fNI.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.fNI.add(arrayList2.get(i));
            } else {
                this.fNK.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.fNI);
        arrayList5.addAll(this.fNK);
        if (this.fNF instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fNF, this.fNF.bkp(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> boZ() {
        int i;
        int size = this.fNK.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.fNK.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fNK.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fNI);
        arrayList.addAll(this.fNK);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fNM = aVar;
    }

    public void bpa() {
        int i;
        int size = this.fNK.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.fNI);
        if (size > frsMaxCache && this.fNK.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fNK.remove(0);
                if (this.fNM != null) {
                    this.fNM.removeItem(count);
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.fNI != null) {
                this.fNI.remove(mVar);
            }
            if (this.fNK != null) {
                this.fNK.remove(mVar);
            }
        }
    }

    public void wn(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.fNI)) {
                c(this.fNI, str);
            }
            if (!v.isEmpty(this.fNK)) {
                c(this.fNK, str);
            }
        }
    }

    private void c(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aAX() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAX()).bXk)) {
                    it.remove();
                }
            }
        }
    }
}
