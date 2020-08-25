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
    private int gRi;
    private k hUw;
    private final com.baidu.tieba.frs.loadmore.a inT;
    private boolean inU;
    private long inV;
    private final ArrayList<q> inW;
    private final ArrayList<String> inX;
    private final ArrayList<q> inY;
    private boolean inZ;
    private c.a ioa;
    private final com.baidu.adp.framework.listener.a iob;
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
        this.inU = false;
        this.inV = 0L;
        this.inW = new ArrayList<>();
        this.inX = new ArrayList<>();
        this.inY = new ArrayList<>();
        this.mPn = 1;
        this.gRi = -1;
        this.inZ = false;
        this.mPageType = 1;
        this.iob = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.inT != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.inT.onFailed(FrsLoadMoreModel.this.inT.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.inT.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.inT.onFailed(FrsLoadMoreModel.this.inT.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cmw = FrsLoadMoreModel.this.inT.cmw();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cmw != null) {
                                cmw.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.inT.au(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.inT instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.inT).eRT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cmw != null) {
                                cmw.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.inT.au(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.inT instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.inT).eRT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.inT.getForumName()) && r.dnh().dnb() != null) {
                            r.dnh().dnb().f(FrsLoadMoreModel.this.inT.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.inT = aVar;
        setUniqueId(this.inT.getUniqueId());
        this.hUw = kVar;
        this.iob.getHttpMessageListener().setSelfListener(true);
        this.iob.getSocketMessageListener().setSelfListener(true);
        registerListener(this.iob);
    }

    public int clT() {
        return this.gRi;
    }

    public void setHasMore(int i) {
        this.gRi = i;
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

    public void oW(boolean z) {
        this.inZ = z;
    }

    public void registerListener() {
        registerListener(this.iob);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bvI(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.inV = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dnh().dnb() != null) {
            loadMoreRequestMessage.setLoadCount(r.dnh().dnb().aU(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.inU) {
            this.inU = true;
            if (m.bun().buo() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.inV)) != null) {
                iVar.buk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.inU) {
            this.inU = true;
            if (m.bun().buo() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.inV)) != null) {
                iVar.buk();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bun().buo() && (this.inT instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.inV;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.inT).eRT, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.eSc = currentTimeMillis;
                iVar.jA(true);
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
        this.inW.clear();
        this.inX.clear();
        this.inY.clear();
        this.gRi = -1;
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
            this.inW.clear();
            this.inX.clear();
            this.inY.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.inW.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bw bwVar = ((bv) next).dUS;
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
                    bw bwVar3 = ((bv) next2).dUS;
                    bwVar3.zn(this.inT.getForumName());
                    if (this.inT != null && this.inT.cmw() != null && this.inT.cmw().getForum() != null) {
                        if (!StringUtils.isNull(this.inT.cmw().getForum().getFirst_class())) {
                            bwVar3.zs(this.inT.cmw().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.inT.cmw().getForum().getSecond_class())) {
                            bwVar3.zt(this.inT.cmw().getForum().getSecond_class());
                        }
                    }
                    if (bwVar3.bfc()) {
                        if (!hashSet.contains(bwVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bv) next2).dUS.tid)) {
                                arrayList3.add(((bv) next2).dUS.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bv) next2).dUS.tid)) {
                            arrayList3.add(((bv) next2).dUS.tid);
                        }
                    }
                } else if (next2 instanceof bw) {
                    bw bwVar4 = (bw) next2;
                    bwVar4.zn(this.inT.getForumName());
                    if (this.inT != null && this.inT.cmw() != null && this.inT.cmw().getForum() != null) {
                        if (!StringUtils.isNull(this.inT.cmw().getForum().getFirst_class())) {
                            bwVar4.zs(this.inT.cmw().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.inT.cmw().getForum().getSecond_class())) {
                            bwVar4.zt(this.inT.cmw().getForum().getSecond_class());
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
        if (this.hUw != null) {
            this.hUw.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cmw = this.inT.cmw();
        if (this.inZ && cmw != null && (this.inT instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.inW);
            arrayList4.addAll(this.inY);
            cmw.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.inT, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.inW.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.inW.add(arrayList2.get(i));
            } else {
                this.inY.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.inW);
        arrayList5.addAll(this.inY);
        if (this.inT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.inT, this.inT.cmw(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> crF() {
        int i;
        int size = this.inY.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.inY.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.inY.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.inW);
        arrayList.addAll(this.inY);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.ioa = aVar;
    }

    public void crG() {
        int i;
        ArrayList<q> arrayList;
        int size = this.inY.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.inW);
        if (size > frsMaxCache && this.inY.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.inY.remove(0));
                if (this.inT == null || this.inT.cmw() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.inT.cmw().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.ioa != null) {
                            this.ioa.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.inW != null) {
                this.inW.remove(qVar);
            }
            if (this.inY != null) {
                this.inY.remove(qVar);
            }
        }
    }

    public void IO(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.inW)) {
                e(this.inW, str);
            }
            if (!y.isEmpty(this.inY)) {
                e(this.inY, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bzo() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bzo()).dWf)) {
                    it.remove();
                }
            }
        }
    }
}
