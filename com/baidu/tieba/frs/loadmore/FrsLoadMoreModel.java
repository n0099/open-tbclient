package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.n.i;
import com.baidu.tbadk.util.aa;
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
/* loaded from: classes9.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int fsc;
    private final com.baidu.tieba.frs.loadmore.a gGm;
    private boolean gGn;
    private long gGo;
    private final ArrayList<m> gGp;
    private final ArrayList<String> gGq;
    private final ArrayList<m> gGr;
    private boolean gGs;
    private c.a gGt;
    private final com.baidu.adp.framework.listener.a gGu;
    private k gpB;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void al(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.gGn = false;
        this.gGo = 0L;
        this.gGp = new ArrayList<>();
        this.gGq = new ArrayList<>();
        this.gGr = new ArrayList<>();
        this.mPn = 1;
        this.fsc = -1;
        this.gGs = false;
        this.mPageType = 1;
        this.gGu = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.gGm != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.gGm.onFailed(FrsLoadMoreModel.this.gGm.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.gGm.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.gGm.onFailed(FrsLoadMoreModel.this.gGm.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bEp = FrsLoadMoreModel.this.gGm.bEp();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bEp != null) {
                                bEp.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gGm.al(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gGm instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gGm).dDE = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bEp != null) {
                                bEp.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gGm.al(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gGm instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gGm).dDE = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.gGm.getForumName()) && r.cCv().cCp() != null) {
                            r.cCv().cCp().g(FrsLoadMoreModel.this.gGm.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.gGm = aVar;
        setUniqueId(this.gGm.getUniqueId());
        this.gpB = kVar;
        this.gGu.getHttpMessageListener().setSelfListener(true);
        this.gGu.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gGu);
    }

    public int bDQ() {
        return this.fsc;
    }

    public void setHasMore(int i) {
        this.fsc = i;
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

    public void lX(boolean z) {
        this.gGs = z;
    }

    public void registerListener() {
        registerListener(this.gGu);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cm = cm(list);
        if (!TextUtils.isEmpty(cm)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cm);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.aSq(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.gGo = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.cCv().cCp() != null) {
            loadMoreRequestMessage.setLoadCount(r.cCv().cCp().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.gGn) {
            this.gGn = true;
            if (com.baidu.tbadk.n.m.aRl().aRm() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gGo)) != null) {
                iVar.aRi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.gGn) {
            this.gGn = true;
            if (com.baidu.tbadk.n.m.aRl().aRm() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gGo)) != null) {
                iVar.aRi();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRl().aRm() && (this.gGm instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.gGo;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.gGm).dDE, false, currentTimeMillis);
            if (iVar != null) {
                iVar.dDN = currentTimeMillis;
                iVar.gT(true);
            }
        }
    }

    private String cm(List<Long> list) {
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
        this.gGp.clear();
        this.gGq.clear();
        this.gGr.clear();
        this.fsc = -1;
        this.mPn = 1;
    }

    public boolean cn(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.gGp.clear();
            this.gGq.clear();
            this.gGr.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.gGp.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).cRf;
                if (bjVar.getTid() != null) {
                    hashSet.add(bjVar.getTid());
                }
            } else if (next instanceof bj) {
                bj bjVar2 = (bj) next;
                if (bjVar2.getTid() != null) {
                    hashSet.add(bjVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.isEmpty(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bi) {
                    bj bjVar3 = ((bi) next2).cRf;
                    bjVar3.sG(this.gGm.getForumName());
                    if (this.gGm != null && this.gGm.bEp() != null && this.gGm.bEp().getForum() != null) {
                        if (!StringUtils.isNull(this.gGm.bEp().getForum().getFirst_class())) {
                            bjVar3.sL(this.gGm.bEp().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gGm.bEp().getForum().getSecond_class())) {
                            bjVar3.sM(this.gGm.bEp().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aCL()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).cRf.tid)) {
                                arrayList3.add(((bi) next2).cRf.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).cRf.tid)) {
                            arrayList3.add(((bi) next2).cRf.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.sG(this.gGm.getForumName());
                    if (this.gGm != null && this.gGm.bEp() != null && this.gGm.bEp().getForum() != null) {
                        if (!StringUtils.isNull(this.gGm.bEp().getForum().getFirst_class())) {
                            bjVar4.sL(this.gGm.bEp().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gGm.bEp().getForum().getSecond_class())) {
                            bjVar4.sM(this.gGm.bEp().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aCL()) {
                        if (!hashSet.contains(bjVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bjVar4.tid)) {
                                arrayList3.add(bjVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bjVar4.tid)) {
                            arrayList3.add(bjVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.gpB != null) {
            this.gpB.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bEp = this.gGm.bEp();
        if (this.gGs && bEp != null && (this.gGm instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.gGp);
            arrayList4.addAll(this.gGr);
            bEp.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.gGm, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.gGp.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.gGp.add(arrayList2.get(i));
            } else {
                this.gGr.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.gGp);
        arrayList5.addAll(this.gGr);
        if (this.gGm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.gGm, this.gGm.bEp(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bIZ() {
        int i;
        int size = this.gGr.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.gGr.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.gGr.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gGp);
        arrayList.addAll(this.gGr);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.gGt = aVar;
    }

    public void bJa() {
        int i;
        ArrayList<m> arrayList;
        int size = this.gGr.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.gGp);
        if (size > frsMaxCache && this.gGr.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                arrayList2.add(this.gGr.remove(0));
                if (this.gGm == null || this.gGm.bEp() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.gGm.bEp().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.gGt != null) {
                            this.gGt.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gGp != null) {
                this.gGp.remove(mVar);
            }
            if (this.gGr != null) {
                this.gGr.remove(mVar);
            }
        }
    }

    public void BC(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.gGp)) {
                e(this.gGp, str);
            }
            if (!v.isEmpty(this.gGr)) {
                e(this.gGr, str);
            }
        }
    }

    private void e(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aVw() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVw()).cMW)) {
                    it.remove();
                }
            }
        }
    }
}
