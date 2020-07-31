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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
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
    private int gEI;
    private k hHg;
    private final com.baidu.tieba.frs.loadmore.a hZJ;
    private boolean hZK;
    private long hZL;
    private final ArrayList<q> hZM;
    private final ArrayList<String> hZN;
    private final ArrayList<q> hZO;
    private boolean hZP;
    private c.a hZQ;
    private final com.baidu.adp.framework.listener.a hZR;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes16.dex */
    public interface a {
        void ao(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.hZK = false;
        this.hZL = 0L;
        this.hZM = new ArrayList<>();
        this.hZN = new ArrayList<>();
        this.hZO = new ArrayList<>();
        this.mPn = 1;
        this.gEI = -1;
        this.hZP = false;
        this.mPageType = 1;
        this.hZR = new com.baidu.adp.framework.listener.a(1001704, CmdConfigSocket.CMD_FRS_LOAD_MORE) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.hZJ != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.hZJ.onFailed(FrsLoadMoreModel.this.hZJ.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.hZJ.onFailed(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.hZJ.onFailed(FrsLoadMoreModel.this.hZJ.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData cbZ = FrsLoadMoreModel.this.hZJ.cbZ();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (cbZ != null) {
                                cbZ.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hZJ.ao(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hZJ instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hZJ).eHn = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (cbZ != null) {
                                cbZ.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.hZJ.ao(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.hZJ instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.hZJ).eHn = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.hZJ.getForumName()) && r.dca().dbU() != null) {
                            r.dca().dbU().f(FrsLoadMoreModel.this.hZJ.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.hZJ = aVar;
        setUniqueId(this.hZJ.getUniqueId());
        this.hHg = kVar;
        this.hZR.getHttpMessageListener().setSelfListener(true);
        this.hZR.getSocketMessageListener().setSelfListener(true);
        registerListener(this.hZR);
    }

    public int cbx() {
        return this.gEI;
    }

    public void setHasMore(int i) {
        this.gEI = i;
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

    public void os(boolean z) {
        this.hZP = z;
    }

    public void registerListener() {
        registerListener(this.hZR);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || x.isEmpty(list)) {
            this.loadingDone = true;
            return;
        }
        String cL = cL(list);
        if (!TextUtils.isEmpty(cL)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(cL);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.toLong(ab.bmV(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.hZL = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.dca().dbU() != null) {
            loadMoreRequestMessage.setLoadCount(r.dca().dbU().aQ(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.hZK) {
            this.hZK = true;
            if (m.blA().blB() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hZL)) != null) {
                iVar.blx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.hZK) {
            this.hZK = true;
            if (m.blA().blB() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, 0L, 0L, System.currentTimeMillis() - this.hZL)) != null) {
                iVar.blx();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.blA().blB() && (this.hZJ instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.hZL;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.hZJ).eHn, false, 0L, 0L, currentTimeMillis);
            if (iVar != null) {
                iVar.eHw = currentTimeMillis;
                iVar.jc(true);
            }
        }
    }

    private String cL(List<Long> list) {
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
        this.hZM.clear();
        this.hZN.clear();
        this.hZO.clear();
        this.gEI = -1;
        this.mPn = 1;
    }

    public boolean cM(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<q> a(boolean z, boolean z2, boolean z3, ArrayList<q> arrayList, f fVar) {
        if (z3) {
            this.hZM.clear();
            this.hZN.clear();
            this.hZO.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.hZM.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof bu) {
                bv bvVar = ((bu) next).dLK;
                if (bvVar.getTid() != null) {
                    hashSet.add(bvVar.getTid());
                }
            } else if (next instanceof bv) {
                bv bvVar2 = (bv) next;
                if (bvVar2.getTid() != null) {
                    hashSet.add(bvVar2.getTid());
                }
            }
        }
        ArrayList<q> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!x.isEmpty(arrayList)) {
            Iterator<q> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bu) {
                    bv bvVar3 = ((bu) next2).dLK;
                    bvVar3.wZ(this.hZJ.getForumName());
                    if (this.hZJ != null && this.hZJ.cbZ() != null && this.hZJ.cbZ().getForum() != null) {
                        if (!StringUtils.isNull(this.hZJ.cbZ().getForum().getFirst_class())) {
                            bvVar3.xe(this.hZJ.cbZ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hZJ.cbZ().getForum().getSecond_class())) {
                            bvVar3.xf(this.hZJ.cbZ().getForum().getSecond_class());
                        }
                    }
                    if (bvVar3.aWJ()) {
                        if (!hashSet.contains(bvVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bu) next2).dLK.tid)) {
                                arrayList3.add(((bu) next2).dLK.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bu) next2).dLK.tid)) {
                            arrayList3.add(((bu) next2).dLK.tid);
                        }
                    }
                } else if (next2 instanceof bv) {
                    bv bvVar4 = (bv) next2;
                    bvVar4.wZ(this.hZJ.getForumName());
                    if (this.hZJ != null && this.hZJ.cbZ() != null && this.hZJ.cbZ().getForum() != null) {
                        if (!StringUtils.isNull(this.hZJ.cbZ().getForum().getFirst_class())) {
                            bvVar4.xe(this.hZJ.cbZ().getForum().getFirst_class());
                        }
                        if (!StringUtils.isNull(this.hZJ.cbZ().getForum().getSecond_class())) {
                            bvVar4.xf(this.hZJ.cbZ().getForum().getSecond_class());
                        }
                    }
                    if (bvVar4.aWJ()) {
                        if (!hashSet.contains(bvVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bvVar4.tid)) {
                                arrayList3.add(bvVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bvVar4.tid)) {
                            arrayList3.add(bvVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.hHg != null) {
            this.hHg.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData cbZ = this.hZJ.cbZ();
        if (this.hZP && cbZ != null && (this.hZJ instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<q> arrayList4 = new ArrayList<>(this.hZM);
            arrayList4.addAll(this.hZO);
            cbZ.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.hZJ, true, arrayList2, arrayList4, z2);
        }
        int frsPn = TbadkCoreApplication.getInst().getListItemRule().getFrsPn() - this.hZM.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < frsPn) {
                this.hZM.add(arrayList2.get(i));
            } else {
                this.hZO.add(arrayList2.get(i));
            }
        }
        ArrayList<q> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.hZM);
        arrayList5.addAll(this.hZO);
        if (this.hZJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.hZJ, this.hZJ.cbZ(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<q> cha() {
        int i;
        int size = this.hZO.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        if (size > frsMaxCache && this.hZO.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.hZO.remove(0);
            }
        }
        ArrayList<q> arrayList = new ArrayList<>();
        arrayList.addAll(this.hZM);
        arrayList.addAll(this.hZO);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.hZQ = aVar;
    }

    public void chb() {
        int i;
        ArrayList<q> arrayList;
        int size = this.hZO.size() + 30;
        int frsMaxCache = TbadkCoreApplication.getInst().getListItemRule().getFrsMaxCache() * 3;
        int count = x.getCount(this.hZM);
        if (size > frsMaxCache && this.hZO.size() > (i = size - frsMaxCache)) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<q> arrayList2 = new ArrayList<>();
                arrayList2.add(this.hZO.remove(0));
                if (this.hZJ == null || this.hZJ.cbZ() == null) {
                    arrayList = null;
                } else {
                    arrayList = this.hZJ.cbZ().switchThreadDataToThreadCardInfo(arrayList2);
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        if (this.hZQ != null) {
                            this.hZQ.removeItem(count + i3);
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.hZM != null) {
                this.hZM.remove(qVar);
            }
            if (this.hZO != null) {
                this.hZO.remove(qVar);
            }
        }
    }

    public void Gm(String str) {
        if (!StringUtils.isNull(str)) {
            if (!x.isEmpty(this.hZM)) {
                e(this.hZM, str);
            }
            if (!x.isEmpty(this.hZO)) {
                e(this.hZO, str);
            }
        }
    }

    private void e(ArrayList<q> arrayList, String str) {
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.bqq() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.bqq()).dMW)) {
                    it.remove();
                }
            }
        }
    }
}
