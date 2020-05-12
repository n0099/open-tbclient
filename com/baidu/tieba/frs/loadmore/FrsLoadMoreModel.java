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
    private int fXo;
    private k gZM;
    private final com.baidu.tieba.frs.loadmore.a hqV;
    private boolean hqW;
    private long hqX;
    private final ArrayList<m> hqY;
    private final ArrayList<String> hqZ;
    private final ArrayList<m> hra;
    private boolean hrb;
    private c.a hrc;
    private final com.baidu.adp.framework.listener.a hrd;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes9.dex */
    public interface a {
        void an(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.hqW = false;
        this.hqX = 0L;
        this.hqY = new ArrayList<>();
        this.hqZ = new ArrayList<>();
        this.hra = new ArrayList<>();
        this.mPn = 1;
        this.fXo = -1;
        this.hrb = false;
        this.mPageType = 1;
        this.hrd = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.hqV != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.hqV.onFailed(FrsLoadMoreModel.this.hqV.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.hqV.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.hqV.onFailed(FrsLoadMoreModel.this.hqV.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bOX = FrsLoadMoreModel.this.hqV.bOX();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bOX != null) {
                                bOX.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hqV.an(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hqV instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hqV).edT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bOX != null) {
                                bOX.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hqV.an(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hqV instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hqV).edT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.hqV.getForumName()) && q.cNm().cNg() != null) {
                            q.cNm().cNg().f(FrsLoadMoreModel.this.hqV.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.hqV = aVar;
        setUniqueId(this.hqV.getUniqueId());
        this.gZM = kVar;
        this.hrd.getHttpMessageListener().setSelfListener(true);
        this.hrd.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hrd);
    }

    public int bOx() {
        return this.fXo;
    }

    public void setHasMore(int i) {
        this.fXo = i;
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

    public void ng(boolean z) {
        this.hrb = z;
    }

    public void registerListener() {
        registerListener(this.hrd);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cy = cy(list);
        if (!TextUtils.isEmpty(cy)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cy);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(aa.baC(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.hqX = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.cNm().cNg() != null) {
            loadMoreRequestMessage.setLoadCount(q.cNm().cNg().aE(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.hqW) {
            this.hqW = true;
            if (com.baidu.tbadk.n.m.aZy().aZz() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hqX)) != null) {
                iVar.aZv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.hqW) {
            this.hqW = true;
            if (com.baidu.tbadk.n.m.aZy().aZz() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hqX)) != null) {
                iVar.aZv();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aZy().aZz() && (this.hqV instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.hqX;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.hqV).edT, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.eec = currentTimeMillis;
                iVar.hS(true);
            }
        }
    }

    private String cy(List<Long> list) {
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
        this.hqY.clear();
        this.hqZ.clear();
        this.hra.clear();
        this.fXo = -1;
        this.mPn = 1;
    }

    public boolean cz(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.hqY.clear();
            this.hqZ.clear();
            this.hra.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.hqY.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bi) {
                bj bjVar = ((bi) next).dqE;
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
                    bj bjVar3 = ((bi) next2).dqE;
                    bjVar3.tW(this.hqV.getForumName());
                    if (this.hqV != null && this.hqV.bOX() != null && this.hqV.bOX().getForum() != null) {
                        if (!StringUtils.isNull(this.hqV.bOX().getForum().getFirst_class())) {
                            bjVar3.ub(this.hqV.bOX().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hqV.bOX().getForum().getSecond_class())) {
                            bjVar3.uc(this.hqV.bOX().getForum().getSecond_class());
                        }
                    }
                    if (bjVar3.aKZ()) {
                        if (!hashSet.contains(bjVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bi) next2).dqE.tid)) {
                                arrayList3.add(((bi) next2).dqE.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bi) next2).dqE.tid)) {
                            arrayList3.add(((bi) next2).dqE.tid);
                        }
                    }
                } else if (next2 instanceof bj) {
                    bj bjVar4 = (bj) next2;
                    bjVar4.tW(this.hqV.getForumName());
                    if (this.hqV != null && this.hqV.bOX() != null && this.hqV.bOX().getForum() != null) {
                        if (!StringUtils.isNull(this.hqV.bOX().getForum().getFirst_class())) {
                            bjVar4.ub(this.hqV.bOX().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hqV.bOX().getForum().getSecond_class())) {
                            bjVar4.uc(this.hqV.bOX().getForum().getSecond_class());
                        }
                    }
                    if (bjVar4.aKZ()) {
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
        if (this.gZM != null) {
            this.gZM.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bOX = this.hqV.bOX();
        if (this.hrb && bOX != null && (this.hqV instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.hqY);
            arrayList4.addAll(this.hra);
            bOX.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.hqV, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.hqY.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.hqY.add(arrayList2.get(i));
            } else {
                this.hra.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.hqY);
        arrayList5.addAll(this.hra);
        if (this.hqV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.hqV, this.hqV.bOX(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> bTI() {
        int i;
        int size = this.hra.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.hra.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.hra.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.hqY);
        arrayList.addAll(this.hra);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.hrc = aVar;
    }

    public void bTJ() {
        int i;
        ArrayList<m> arrayList;
        int size = this.hra.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = v.getCount(this.hqY);
        if (size > frsMaxCache && this.hra.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                arrayList2.add(this.hra.remove(0));
                if (this.hqV == null || this.hqV.bOX() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.hqV.bOX().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.hrc != null) {
                            this.hrc.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.hqY != null) {
                this.hqY.remove(mVar);
            }
            if (this.hra != null) {
                this.hra.remove(mVar);
            }
        }
    }

    public void Dq(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.isEmpty(this.hqY)) {
                e(this.hqY, str);
            }
            if (!v.isEmpty(this.hra)) {
                e(this.hra, str);
            }
        }
    }

    private void e(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bdJ() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bdJ()).dms)) {
                    it.remove();
                }
            }
        }
    }
}
