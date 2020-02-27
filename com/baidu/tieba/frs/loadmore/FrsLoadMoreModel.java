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
    private int fsb;
    private final com.baidu.tieba.frs.loadmore.a gGk;
    private boolean gGl;
    private long gGm;
    private final ArrayList<m> gGn;
    private final ArrayList<String> gGo;
    private final ArrayList<m> gGp;
    private boolean gGq;
    private c.a gGr;
    private final com.baidu.adp.framework.listener.a gGs;
    private k gpz;
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
        this.gGl = false;
        this.gGm = 0L;
        this.gGn = new ArrayList<>();
        this.gGo = new ArrayList<>();
        this.gGp = new ArrayList<>();
        this.mPn = 1;
        this.fsb = -1;
        this.gGq = false;
        this.mPageType = 1;
        this.gGs = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.gGk != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.gGk.onFailed(FrsLoadMoreModel.this.gGk.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.gGk.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.gGk.onFailed(FrsLoadMoreModel.this.gGk.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bEn = FrsLoadMoreModel.this.gGk.bEn();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bEn != null) {
                                bEn.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gGk.al(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gGk instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gGk).dDD = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bEn != null) {
                                bEn.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.gGk.al(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.gGk instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.gGk).dDD = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.gGk.getForumName()) && r.cCt().cCn() != null) {
                            r.cCt().cCn().g(FrsLoadMoreModel.this.gGk.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.gGk = aVar;
        setUniqueId(this.gGk.getUniqueId());
        this.gpz = kVar;
        this.gGs.getHttpMessageListener().setSelfListener(true);
        this.gGs.getSocketMessageListener().setSelfListener(true);
        registerListener(this.gGs);
    }

    public int bDO() {
        return this.fsb;
    }

    public void setHasMore(int i) {
        this.fsb = i;
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
        this.gGq = z;
    }

    public void registerListener() {
        registerListener(this.gGs);
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
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.aSo(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.gGm = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.cCt().cCn() != null) {
            loadMoreRequestMessage.setLoadCount(r.cCt().cCn().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.gGl) {
            this.gGl = true;
            if (com.baidu.tbadk.n.m.aRj().aRk() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gGm)) != null) {
                iVar.aRg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.gGl) {
            this.gGl = true;
            if (com.baidu.tbadk.n.m.aRj().aRk() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.gGm)) != null) {
                iVar.aRg();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRj().aRk() && (this.gGk instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.gGm;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.gGk).dDD, false, currentTimeMillis);
            if (iVar != null) {
                iVar.dDM = currentTimeMillis;
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
        this.gGn.clear();
        this.gGo.clear();
        this.gGp.clear();
        this.fsb = -1;
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
            this.gGn.clear();
            this.gGo.clear();
            this.gGp.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.gGn.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).cRe;
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
                    bj bjVar3 = ((bi) next2).cRe;
                    bjVar3.sG(this.gGk.getForumName());
                    if (this.gGk != null && this.gGk.bEn() != null && this.gGk.bEn().getForum() != null) {
                        if (!StringUtils.isNull(this.gGk.bEn().getForum().getFirst_class())) {
                            bjVar3.sL(this.gGk.bEn().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gGk.bEn().getForum().getSecond_class())) {
                            bjVar3.sM(this.gGk.bEn().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aCJ()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).cRe.tid)) {
                                arrayList3.add(((bi) next2).cRe.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).cRe.tid)) {
                            arrayList3.add(((bi) next2).cRe.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.sG(this.gGk.getForumName());
                    if (this.gGk != null && this.gGk.bEn() != null && this.gGk.bEn().getForum() != null) {
                        if (!StringUtils.isNull(this.gGk.bEn().getForum().getFirst_class())) {
                            bjVar4.sL(this.gGk.bEn().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.gGk.bEn().getForum().getSecond_class())) {
                            bjVar4.sM(this.gGk.bEn().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aCJ()) {
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
        if (this.gpz != null) {
            this.gpz.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bEn = this.gGk.bEn();
        if (this.gGq && bEn != null && (this.gGk instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.gGn);
            arrayList4.addAll(this.gGp);
            bEn.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.gGk, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.gGn.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.gGn.add(arrayList2.get(i));
            } else {
                this.gGp.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.gGn);
        arrayList5.addAll(this.gGp);
        if (this.gGk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.gGk, this.gGk.bEn(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bIX() {
        int i;
        int size = this.gGp.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.gGp.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.gGp.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.gGn);
        arrayList.addAll(this.gGp);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.gGr = aVar;
    }

    public void bIY() {
        int i;
        ArrayList<m> arrayList;
        int size = this.gGp.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.gGn);
        if (size > frsMaxCache && this.gGp.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                arrayList2.add(this.gGp.remove(0));
                if (this.gGk == null || this.gGk.bEn() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.gGk.bEn().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.gGr != null) {
                            this.gGr.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gGn != null) {
                this.gGn.remove(mVar);
            }
            if (this.gGp != null) {
                this.gGp.remove(mVar);
            }
        }
    }

    public void BC(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.gGn)) {
                e(this.gGn, str);
            }
            if (!v.isEmpty(this.gGp)) {
                e(this.gGp, str);
            }
        }
    }

    private void e(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aVu() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aVu()).cMV)) {
                    it.remove();
                }
            }
        }
    }
}
