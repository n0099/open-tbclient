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
import com.baidu.tbadk.util.ab;
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
/* loaded from: classes16.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int gRm;
    private k hUC;
    private final com.baidu.tieba.frs.loadmore.a inZ;
    private boolean ioa;
    private long iob;
    private final ArrayList<q> ioc;
    private final ArrayList<String> iod;
    private final ArrayList<q> ioe;
    private boolean iof;
    private c.a iog;
    private final com.baidu.adp.framework.listener.a ioh;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes16.dex */
    public interface a {
        void au(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.ioa = false;
        this.iob = 0L;
        this.ioc = new ArrayList<>();
        this.iod = new ArrayList<>();
        this.ioe = new ArrayList<>();
        this.mPn = 1;
        this.gRm = -1;
        this.iof = false;
        this.mPageType = 1;
        this.ioh = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.inZ != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.inZ.onFailed(FrsLoadMoreModel.this.inZ.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.inZ.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.inZ.onFailed(FrsLoadMoreModel.this.inZ.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cmx = FrsLoadMoreModel.this.inZ.cmx();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cmx != null) {
                                cmx.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.inZ.au(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.inZ instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.inZ).eRX = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cmx != null) {
                                cmx.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.inZ.au(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.inZ instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.inZ).eRX = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.inZ.getForumName()) && r.dnk().dne() != null) {
                            r.dnk().dne().f(FrsLoadMoreModel.this.inZ.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.inZ = aVar;
        setUniqueId(this.inZ.getUniqueId());
        this.hUC = kVar;
        this.ioh.getHttpMessageListener().setSelfListener(true);
        this.ioh.getSocketMessageListener().setSelfListener(true);
        registerListener(this.ioh);
    }

    public int clU() {
        return this.gRm;
    }

    public void setHasMore(int i) {
        this.gRm = i;
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

    public void oY(boolean z) {
        this.iof = z;
    }

    public void registerListener() {
        registerListener(this.ioh);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cN = cN(list);
        if (!TextUtils.isEmpty(cN)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cN);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bvJ(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.iob = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dnk().dne() != null) {
            loadMoreRequestMessage.setLoadCount(r.dnk().dne().aU(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.ioa) {
            this.ioa = true;
            if (m.buo().bup() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.iob)) != null) {
                iVar.bul();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.ioa) {
            this.ioa = true;
            if (m.buo().bup() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.iob)) != null) {
                iVar.bul();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.buo().bup() && (this.inZ instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.iob;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.inZ).eRX, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.eSg = currentTimeMillis;
                iVar.jC(true);
            }
        }
    }

    private String cN(List<Long> list) {
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
        this.ioc.clear();
        this.iod.clear();
        this.ioe.clear();
        this.gRm = -1;
        this.mPn = 1;
    }

    public boolean cO(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.ioc.clear();
            this.iod.clear();
            this.ioe.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.ioc.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bw bwVar = ((bv) next).dUW;
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
                    bw bwVar3 = ((bv) next2).dUW;
                    bwVar3.zo(this.inZ.getForumName());
                    if (this.inZ != null && this.inZ.cmx() != null && this.inZ.cmx().getForum() != null) {
                        if (!StringUtils.isNull(this.inZ.cmx().getForum().getFirst_class())) {
                            bwVar3.zt(this.inZ.cmx().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.inZ.cmx().getForum().getSecond_class())) {
                            bwVar3.zu(this.inZ.cmx().getForum().getSecond_class());
                        }
                    }
                    if (bwVar3.bfc()) {
                        if (!hashSet.contains(bwVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bv) next2).dUW.tid)) {
                                arrayList3.add(((bv) next2).dUW.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bv) next2).dUW.tid)) {
                            arrayList3.add(((bv) next2).dUW.tid);
                        }
                    }
                } else if (next2 instanceof bw) {
                    bw bwVar4 = (bw) next2;
                    bwVar4.zo(this.inZ.getForumName());
                    if (this.inZ != null && this.inZ.cmx() != null && this.inZ.cmx().getForum() != null) {
                        if (!StringUtils.isNull(this.inZ.cmx().getForum().getFirst_class())) {
                            bwVar4.zt(this.inZ.cmx().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.inZ.cmx().getForum().getSecond_class())) {
                            bwVar4.zu(this.inZ.cmx().getForum().getSecond_class());
                        }
                    }
                    if (bwVar4.bfc()) {
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
        if (this.hUC != null) {
            this.hUC.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cmx = this.inZ.cmx();
        if (this.iof && cmx != null && (this.inZ instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.ioc);
            arrayList4.addAll(this.ioe);
            cmx.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.inZ, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.ioc.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.ioc.add(arrayList2.get(i));
            } else {
                this.ioe.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.ioc);
        arrayList5.addAll(this.ioe);
        if (this.inZ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.inZ, this.inZ.cmx(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> crG() {
        int i;
        int size = this.ioe.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.ioe.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ioe.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.ioc);
        arrayList.addAll(this.ioe);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.iog = aVar;
    }

    public void crH() {
        int i;
        ArrayList<q> arrayList;
        int size = this.ioe.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.ioc);
        if (size > frsMaxCache && this.ioe.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.ioe.remove(0));
                if (this.inZ == null || this.inZ.cmx() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.inZ.cmx().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.iog != null) {
                            this.iog.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.ioc != null) {
                this.ioc.remove(qVar);
            }
            if (this.ioe != null) {
                this.ioe.remove(qVar);
            }
        }
    }

    public void IP(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.ioc)) {
                e(this.ioc, str);
            }
            if (!y.isEmpty(this.ioe)) {
                e(this.ioe, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bzp() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bzp()).dWj)) {
                    it.remove();
                }
            }
        }
    }
}
