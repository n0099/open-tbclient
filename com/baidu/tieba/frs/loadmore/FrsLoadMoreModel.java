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
/* loaded from: classes21.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int gUU;
    private k ibC;
    public boolean isLoading;
    private final com.baidu.tieba.frs.loadmore.a ivp;
    private boolean ivq;
    private long ivr;
    private final ArrayList<q> ivs;
    private final ArrayList<String> ivt;
    private final ArrayList<q> ivu;
    private boolean ivv;
    private c.a ivw;
    private final com.baidu.adp.framework.listener.a ivx;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes21.dex */
    public interface a {
        void aw(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.ivq = false;
        this.ivr = 0L;
        this.ivs = new ArrayList<>();
        this.ivt = new ArrayList<>();
        this.ivu = new ArrayList<>();
        this.mPn = 1;
        this.gUU = -1;
        this.ivv = false;
        this.mPageType = 1;
        this.ivx = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.ivp != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.ivp.onFailed(FrsLoadMoreModel.this.ivp.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.ivp.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.ivp.onFailed(FrsLoadMoreModel.this.ivp.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cpJ = FrsLoadMoreModel.this.ivp.cpJ();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cpJ != null) {
                                cpJ.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.ivp.aw(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.ivp instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.ivp).eUN = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cpJ != null) {
                                cpJ.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.ivp.aw(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.ivp instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.ivp).eUN = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.ivp.getForumName()) && r.dqU().dqO() != null) {
                            r.dqU().dqO().f(FrsLoadMoreModel.this.ivp.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.ivp = aVar;
        setUniqueId(this.ivp.getUniqueId());
        this.ibC = kVar;
        this.ivx.getHttpMessageListener().setSelfListener(true);
        this.ivx.getSocketMessageListener().setSelfListener(true);
        registerListener(this.ivx);
    }

    public int cpg() {
        return this.gUU;
    }

    public void setHasMore(int i) {
        this.gUU = i;
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

    public void pe(boolean z) {
        this.ivv = z;
    }

    public void registerListener() {
        registerListener(this.ivx);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cT = cT(list);
        if (!TextUtils.isEmpty(cT)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cT);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ac.bwS(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.ivr = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dqU().dqO() != null) {
            loadMoreRequestMessage.setLoadCount(r.dqU().dqO().aU(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.ivq) {
            this.ivq = true;
            if (m.bvs().bvt() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.ivr)) != null) {
                iVar.bvp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.ivq) {
            this.ivq = true;
            if (m.bvs().bvt() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.ivr)) != null) {
                iVar.bvp();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bvs().bvt() && (this.ivp instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.ivr;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.ivp).eUN, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.eUW = currentTimeMillis;
                iVar.jD(true);
            }
        }
    }

    private String cT(List<Long> list) {
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
        this.ivs.clear();
        this.ivt.clear();
        this.ivu.clear();
        this.gUU = -1;
        this.mPn = 1;
    }

    public boolean cU(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.ivs.clear();
            this.ivt.clear();
            this.ivu.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.ivs.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bw bwVar = ((bv) next).dXg;
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
                    bw bwVar3 = ((bv) next2).dXg;
                    bwVar3.zJ(this.ivp.getForumName());
                    if (this.ivp != null && this.ivp.cpJ() != null && this.ivp.cpJ().getForum() != null) {
                        if (!StringUtils.isNull(this.ivp.cpJ().getForum().getFirst_class())) {
                            bwVar3.zO(this.ivp.cpJ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.ivp.cpJ().getForum().getSecond_class())) {
                            bwVar3.zP(this.ivp.cpJ().getForum().getSecond_class());
                        }
                    }
                    if (bwVar3.bfW()) {
                        if (!hashSet.contains(bwVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bv) next2).dXg.tid)) {
                                arrayList3.add(((bv) next2).dXg.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bv) next2).dXg.tid)) {
                            arrayList3.add(((bv) next2).dXg.tid);
                        }
                    }
                } else if (next2 instanceof bw) {
                    bw bwVar4 = (bw) next2;
                    bwVar4.zJ(this.ivp.getForumName());
                    if (this.ivp != null && this.ivp.cpJ() != null && this.ivp.cpJ().getForum() != null) {
                        if (!StringUtils.isNull(this.ivp.cpJ().getForum().getFirst_class())) {
                            bwVar4.zO(this.ivp.cpJ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.ivp.cpJ().getForum().getSecond_class())) {
                            bwVar4.zP(this.ivp.cpJ().getForum().getSecond_class());
                        }
                    }
                    if (bwVar4.bfW()) {
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
        if (this.ibC != null) {
            this.ibC.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cpJ = this.ivp.cpJ();
        if (this.ivv && cpJ != null && (this.ivp instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.ivs);
            arrayList4.addAll(this.ivu);
            cpJ.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.ivp, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.ivs.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.ivs.add(arrayList2.get(i));
            } else {
                this.ivu.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.ivs);
        arrayList5.addAll(this.ivu);
        if (this.ivp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.ivp, this.ivp.cpJ(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cuV() {
        int i;
        int size = this.ivu.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.ivu.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ivu.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.ivs);
        arrayList.addAll(this.ivu);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.ivw = aVar;
    }

    public void cuW() {
        int i;
        ArrayList<q> arrayList;
        int size = this.ivu.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.ivs);
        if (size > frsMaxCache && this.ivu.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.ivu.remove(0));
                if (this.ivp == null || this.ivp.cpJ() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.ivp.cpJ().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.ivw != null) {
                            this.ivw.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.ivs != null) {
                this.ivs.remove(qVar);
            }
            if (this.ivu != null) {
                this.ivu.remove(qVar);
            }
        }
    }

    public void Jn(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.ivs)) {
                e(this.ivs, str);
            }
            if (!y.isEmpty(this.ivu)) {
                e(this.ivu, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bAy() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bAy()).dYt)) {
                    it.remove();
                }
            }
        }
    }
}
