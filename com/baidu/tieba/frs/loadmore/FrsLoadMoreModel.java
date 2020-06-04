package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.f;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int gmt;
    private final ArrayList<o> hGA;
    private final ArrayList<String> hGB;
    private final ArrayList<o> hGC;
    private boolean hGD;
    private c.a hGE;
    private final com.baidu.adp.framework.listener.a hGF;
    private final com.baidu.tieba.frs.loadmore.a hGx;
    private boolean hGy;
    private long hGz;
    private k hoL;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void an(ArrayList<o> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.hGy = false;
        this.hGz = 0L;
        this.hGA = new ArrayList<>();
        this.hGB = new ArrayList<>();
        this.hGC = new ArrayList<>();
        this.mPn = 1;
        this.gmt = -1;
        this.hGD = false;
        this.mPageType = 1;
        this.hGF = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.hGx != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.hGx.onFailed(FrsLoadMoreModel.this.hGx.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.hGx.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.hGx.onFailed(FrsLoadMoreModel.this.hGx.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bVu = FrsLoadMoreModel.this.hGx.bVu();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bVu != null) {
                                bVu.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hGx.an(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hGx instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hGx).esg = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bVu != null) {
                                bVu.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hGx.an(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hGx instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hGx).esg = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.hGx.getForumName()) && q.cUC().cUw() != null) {
                            q.cUC().cUw().f(FrsLoadMoreModel.this.hGx.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.hGx = aVar;
        setUniqueId(this.hGx.getUniqueId());
        this.hoL = kVar;
        this.hGF.getHttpMessageListener().setSelfListener(true);
        this.hGF.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hGF);
    }

    public int bUU() {
        return this.gmt;
    }

    public void setHasMore(int i) {
        this.gmt = i;
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

    public void nB(boolean z) {
        this.hGD = z;
    }

    public void registerListener() {
        registerListener(this.hGF);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cw = cw(list);
        if (!TextUtils.isEmpty(cw)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cw);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bgO(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.hGz = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.cUC().cUw() != null) {
            loadMoreRequestMessage.setLoadCount(q.cUC().cUw().aR(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.hGy) {
            this.hGy = true;
            if (m.bfJ().bfK() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hGz)) != null) {
                iVar.bfG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.hGy) {
            this.hGy = true;
            if (m.bfJ().bfK() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hGz)) != null) {
                iVar.bfG();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.bfJ().bfK() && (this.hGx instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.hGz;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.hGx).esg, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.esp = currentTimeMillis;
                iVar.io(true);
            }
        }
    }

    private String cw(List<Long> list) {
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
        this.hGA.clear();
        this.hGB.clear();
        this.hGC.clear();
        this.gmt = -1;
        this.mPn = 1;
    }

    public boolean cx(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<o> a(boolean z, boolean z2, boolean z3, ArrayList<o> arrayList, f fVar) {
        if (z3) {
            this.hGA.clear();
            this.hGB.clear();
            this.hGC.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<o> it = this.hGA.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next instanceof bj) {
                bk bkVar = ((bj) next).dEA;
                if (bkVar.getTid() != null) {
                    hashSet.add(bkVar.getTid());
                }
            } else if (next instanceof bk) {
                bk bkVar2 = (bk) next;
                if (bkVar2.getTid() != null) {
                    hashSet.add(bkVar2.getTid());
                }
            }
        }
        ArrayList<o> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.isEmpty(arrayList)) {
            Iterator<o> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                o next2 = it2.next();
                if (next2 instanceof bj) {
                    bk bkVar3 = ((bj) next2).dEA;
                    bkVar3.vC(this.hGx.getForumName());
                    if (this.hGx != null && this.hGx.bVu() != null && this.hGx.bVu().getForum() != null) {
                        if (!StringUtils.isNull(this.hGx.bVu().getForum().getFirst_class())) {
                            bkVar3.vH(this.hGx.bVu().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hGx.bVu().getForum().getSecond_class())) {
                            bkVar3.vI(this.hGx.bVu().getForum().getSecond_class());
                        }
                    }
                    if (bkVar3.aQW()) {
                        if (!hashSet.contains(bkVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bj) next2).dEA.tid)) {
                                arrayList3.add(((bj) next2).dEA.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bj) next2).dEA.tid)) {
                            arrayList3.add(((bj) next2).dEA.tid);
                        }
                    }
                } else if (next2 instanceof bk) {
                    bk bkVar4 = (bk) next2;
                    bkVar4.vC(this.hGx.getForumName());
                    if (this.hGx != null && this.hGx.bVu() != null && this.hGx.bVu().getForum() != null) {
                        if (!StringUtils.isNull(this.hGx.bVu().getForum().getFirst_class())) {
                            bkVar4.vH(this.hGx.bVu().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hGx.bVu().getForum().getSecond_class())) {
                            bkVar4.vI(this.hGx.bVu().getForum().getSecond_class());
                        }
                    }
                    if (bkVar4.aQW()) {
                        if (!hashSet.contains(bkVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bkVar4.tid)) {
                                arrayList3.add(bkVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bkVar4.tid)) {
                            arrayList3.add(bkVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.hoL != null) {
            this.hoL.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bVu = this.hGx.bVu();
        if (this.hGD && bVu != null && (this.hGx instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<o> arrayList4 = new ArrayList<>(this.hGA);
            arrayList4.addAll(this.hGC);
            bVu.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.hGx, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.hGA.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.hGA.add(arrayList2.get(i));
            } else {
                this.hGC.add(arrayList2.get(i));
            }
        }
        ArrayList<o> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.hGA);
        arrayList5.addAll(this.hGC);
        if (this.hGx instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.hGx, this.hGx.bVu(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<o> cam() {
        int i;
        int size = this.hGC.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.hGC.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.hGC.remove(0);
            }
        }
        ArrayList<o> arrayList = new ArrayList<>();
        arrayList.addAll(this.hGA);
        arrayList.addAll(this.hGC);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.hGE = aVar;
    }

    public void can() {
        int i;
        ArrayList<o> arrayList;
        int size = this.hGC.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.hGA);
        if (size > frsMaxCache && this.hGC.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<o> arrayList2 = new ArrayList<>();
                arrayList2.add(this.hGC.remove(0));
                if (this.hGx == null || this.hGx.bVu() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.hGx.bVu().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.hGE != null) {
                            this.hGE.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(o oVar) {
        if (oVar != null) {
            if (this.hGA != null) {
                this.hGA.remove(oVar);
            }
            if (this.hGC != null) {
                this.hGC.remove(oVar);
            }
        }
    }

    public void EZ(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.hGA)) {
                e(this.hGA, str);
            }
            if (!v.isEmpty(this.hGC)) {
                e(this.hGC, str);
            }
        }
    }

    private void e(ArrayList<o> arrayList, String str) {
        Iterator<o> it = arrayList.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bjW() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bjW()).dAu)) {
                    it.remove();
                }
            }
        }
    }
}
