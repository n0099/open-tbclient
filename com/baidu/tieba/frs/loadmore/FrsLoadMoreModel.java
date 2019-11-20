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
    private int euS;
    private final com.baidu.tieba.frs.loadmore.a fMO;
    private boolean fMP;
    private long fMQ;
    private final ArrayList<m> fMR;
    private final ArrayList<String> fMS;
    private final ArrayList<m> fMT;
    private boolean fMU;
    private c.a fMV;
    private final com.baidu.adp.framework.listener.a fMW;
    private k fvT;
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
        this.fMP = false;
        this.fMQ = 0L;
        this.fMR = new ArrayList<>();
        this.fMS = new ArrayList<>();
        this.fMT = new ArrayList<>();
        this.mPn = 1;
        this.euS = -1;
        this.fMU = false;
        this.mPageType = 1;
        this.fMW = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fMO != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fMO.onFailed(FrsLoadMoreModel.this.fMO.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fMO.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fMO.onFailed(FrsLoadMoreModel.this.fMO.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bkn = FrsLoadMoreModel.this.fMO.bkn();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bkn != null) {
                                bkn.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fMO.aa(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fMO instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fMO).cLq = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bkn != null) {
                                bkn.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fMO.aa(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fMO instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fMO).cLq = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fMO.getForumName()) && r.cfJ().cfD() != null) {
                            r.cfJ().cfD().f(FrsLoadMoreModel.this.fMO.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fMO = aVar;
        setUniqueId(this.fMO.getUniqueId());
        this.fvT = kVar;
        this.fMW.getHttpMessageListener().setSelfListener(true);
        this.fMW.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fMW);
    }

    public int bjO() {
        return this.euS;
    }

    public void setHasMore(int i) {
        this.euS = i;
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
        this.fMU = z;
    }

    public void registerListener() {
        registerListener(this.fMW);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(x.axN(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fMQ = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.cfJ().cfD() != null) {
            loadMoreRequestMessage.setLoadCount(r.cfJ().cfD().at(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fMP) {
            this.fMP = true;
            if (com.baidu.tbadk.p.m.awL().awM() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fMQ)) != null) {
                iVar.awI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fMP) {
            this.fMP = true;
            if (com.baidu.tbadk.p.m.awL().awM() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fMQ)) != null) {
                iVar.awI();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.awL().awM() && (this.fMO instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fMQ;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fMO).cLq, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cLz = currentTimeMillis;
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
        this.fMR.clear();
        this.fMS.clear();
        this.fMT.clear();
        this.euS = -1;
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
            this.fMR.clear();
            this.fMS.clear();
            this.fMT.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fMR.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bg) {
                bh bhVar = ((bg) next).caz;
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
                    bh bhVar3 = ((bg) next2).caz;
                    bhVar3.mZ(this.fMO.getForumName());
                    if (bhVar3.ajb()) {
                        if (!hashSet.contains(bhVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bg) next2).caz.tid)) {
                                arrayList3.add(((bg) next2).caz.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bg) next2).caz.tid)) {
                            arrayList3.add(((bg) next2).caz.tid);
                        }
                    }
                } else if (next2 instanceof bh) {
                    bh bhVar4 = (bh) next2;
                    bhVar4.mZ(this.fMO.getForumName());
                    if (bhVar4.ajb()) {
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
        if (this.fvT != null) {
            this.fvT.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bkn = this.fMO.bkn();
        if (this.fMU && bkn != null && (this.fMO instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.fMR);
            arrayList4.addAll(this.fMT);
            bkn.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.fMO, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.fMR.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.fMR.add(arrayList2.get(i));
            } else {
                this.fMT.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.fMR);
        arrayList5.addAll(this.fMT);
        if (this.fMO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fMO, this.fMO.bkn(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> boX() {
        int i;
        int size = this.fMT.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.fMT.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fMT.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fMR);
        arrayList.addAll(this.fMT);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fMV = aVar;
    }

    public void boY() {
        int i;
        int size = this.fMT.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.fMR);
        if (size > frsMaxCache && this.fMT.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fMT.remove(0);
                if (this.fMV != null) {
                    this.fMV.removeItem(count);
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.fMR != null) {
                this.fMR.remove(mVar);
            }
            if (this.fMT != null) {
                this.fMT.remove(mVar);
            }
        }
    }

    public void wn(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.fMR)) {
                d(this.fMR, str);
            }
            if (!v.isEmpty(this.fMT)) {
                d(this.fMT, str);
            }
        }
    }

    private void d(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aAV() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAV()).bWt)) {
                    it.remove();
                }
            }
        }
    }
}
