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
    private int hvO;
    private k iCZ;
    private final com.baidu.tieba.frs.loadmore.a iWE;
    private boolean iWF;
    private long iWG;
    private final ArrayList<q> iWH;
    private final ArrayList<String> iWI;
    private final ArrayList<q> iWJ;
    private boolean iWK;
    private c.a iWL;
    private final com.baidu.adp.framework.listener.a iWM;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes22.dex */
    public interface a {
        void ax(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.iWF = false;
        this.iWG = 0L;
        this.iWH = new ArrayList<>();
        this.iWI = new ArrayList<>();
        this.iWJ = new ArrayList<>();
        this.mPn = 1;
        this.hvO = -1;
        this.iWK = false;
        this.mPageType = 1;
        this.iWM = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.iWE != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.iWE.onFailed(FrsLoadMoreModel.this.iWE.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.iWE.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.iWE.onFailed(FrsLoadMoreModel.this.iWE.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cwo = FrsLoadMoreModel.this.iWE.cwo();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cwo != null) {
                                cwo.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.iWE.ax(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.iWE instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.iWE).fpw = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cwo != null) {
                                cwo.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.iWE.ax(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.iWE instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.iWE).fpw = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.iWE.getForumName()) && r.dxM().dxG() != null) {
                            r.dxM().dxG().f(FrsLoadMoreModel.this.iWE.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.iWE = aVar;
        setUniqueId(this.iWE.getUniqueId());
        this.iCZ = kVar;
        this.iWM.getHttpMessageListener().setSelfListener(true);
        this.iWM.getSocketMessageListener().setSelfListener(true);
        registerListener(this.iWM);
    }

    public int cvL() {
        return this.hvO;
    }

    public void setHasMore(int i) {
        this.hvO = i;
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

    public void qb(boolean z) {
        this.iWK = z;
    }

    public void registerListener() {
        registerListener(this.iWM);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || y.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String df = df(list);
        if (!TextUtils.isEmpty(df)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(df);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ac.bBv(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.iWG = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dxM().dxG() != null) {
            loadMoreRequestMessage.setLoadCount(r.dxM().dxG().ba(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.iWF) {
            this.iWF = true;
            if (m.bzV().bzW() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.iWG)) != null) {
                iVar.bzS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.iWF) {
            this.iWF = true;
            if (m.bzV().bzW() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.iWG)) != null) {
                iVar.bzS();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bzV().bzW() && (this.iWE instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.iWG;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.iWE).fpw, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.fpF = currentTimeMillis;
                iVar.ko(true);
            }
        }
    }

    private String df(List<Long> list) {
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
        this.iWH.clear();
        this.iWI.clear();
        this.iWJ.clear();
        this.hvO = -1;
        this.mPn = 1;
    }

    public boolean dg(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.iWH.clear();
            this.iWI.clear();
            this.iWJ.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.iWH.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bv) {
                bw bwVar = ((bv) next).erH;
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
                    bw bwVar3 = ((bv) next2).erH;
                    bwVar3.AO(this.iWE.getForumName());
                    if (this.iWE != null && this.iWE.cwo() != null && this.iWE.cwo().getForum() != null) {
                        if (!StringUtils.isNull(this.iWE.cwo().getForum().getFirst_class())) {
                            bwVar3.AT(this.iWE.cwo().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.iWE.cwo().getForum().getSecond_class())) {
                            bwVar3.AU(this.iWE.cwo().getForum().getSecond_class());
                        }
                    }
                    if (bwVar3.bky()) {
                        if (!hashSet.contains(bwVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bv) next2).erH.tid)) {
                                arrayList3.add(((bv) next2).erH.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bv) next2).erH.tid)) {
                            arrayList3.add(((bv) next2).erH.tid);
                        }
                    }
                } else if (next2 instanceof bw) {
                    bw bwVar4 = (bw) next2;
                    bwVar4.AO(this.iWE.getForumName());
                    if (this.iWE != null && this.iWE.cwo() != null && this.iWE.cwo().getForum() != null) {
                        if (!StringUtils.isNull(this.iWE.cwo().getForum().getFirst_class())) {
                            bwVar4.AT(this.iWE.cwo().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.iWE.cwo().getForum().getSecond_class())) {
                            bwVar4.AU(this.iWE.cwo().getForum().getSecond_class());
                        }
                    }
                    if (bwVar4.bky()) {
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
        if (this.iCZ != null) {
            this.iCZ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cwo = this.iWE.cwo();
        if (this.iWK && cwo != null && (this.iWE instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.iWH);
            arrayList4.addAll(this.iWJ);
            cwo.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.iWE, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.iWH.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.iWH.add(arrayList2.get(i));
            } else {
                this.iWJ.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.iWH);
        arrayList5.addAll(this.iWJ);
        if (this.iWE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.iWE, this.iWE.cwo(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cBz() {
        int i;
        int size = this.iWJ.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.iWJ.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.iWJ.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.iWH);
        arrayList.addAll(this.iWJ);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.iWL = aVar;
    }

    public void cBA() {
        int i;
        ArrayList<q> arrayList;
        int size = this.iWJ.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = y.getCount(this.iWH);
        if (size > frsMaxCache && this.iWJ.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.iWJ.remove(0));
                if (this.iWE == null || this.iWE.cwo() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.iWE.cwo().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.iWL != null) {
                            this.iWL.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.iWH != null) {
                this.iWH.remove(qVar);
            }
            if (this.iWJ != null) {
                this.iWJ.remove(qVar);
            }
        }
    }

    public void Kz(String str) {
        if (!StringUtils.isNull(str)) {
            if (!y.isEmpty(this.iWH)) {
                e(this.iWH, str);
            }
            if (!y.isEmpty(this.iWJ)) {
                e(this.iWJ, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bFd() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bFd()).esU)) {
                    it.remove();
                }
            }
        }
    }
}
