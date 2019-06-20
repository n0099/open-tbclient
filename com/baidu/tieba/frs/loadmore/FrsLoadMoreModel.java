package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.p.i;
import com.baidu.tbadk.util.y;
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
    private int ecm;
    private final com.baidu.tieba.frs.loadmore.a fGK;
    private boolean fGL;
    private long fGM;
    private final ArrayList<m> fGN;
    private final ArrayList<String> fGO;
    private final ArrayList<m> fGP;
    private boolean fGQ;
    private c.a fGR;
    private final com.baidu.adp.framework.listener.a fGS;
    private k fqm;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void V(ArrayList<m> arrayList);

        void vX(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fGL = false;
        this.fGM = 0L;
        this.fGN = new ArrayList<>();
        this.fGO = new ArrayList<>();
        this.fGP = new ArrayList<>();
        this.mPn = 1;
        this.ecm = -1;
        this.fGQ = false;
        this.mPageType = 1;
        this.fGS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fGK != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fGK.vX(FrsLoadMoreModel.this.fGK.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fGK.vX(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fGK.vX(FrsLoadMoreModel.this.fGK.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bkm = FrsLoadMoreModel.this.fGK.bkm();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bkm != null) {
                                bkm.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fGK.V(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fGK instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fGK).cyF = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bkm != null) {
                                bkm.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fGK.V(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fGK instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fGK).cyF = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fGK.getForumName()) && r.ceM().ceG() != null) {
                            r.ceM().ceG().g(FrsLoadMoreModel.this.fGK.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fGK = aVar;
        setUniqueId(this.fGK.getUniqueId());
        this.fqm = kVar;
        this.fGS.getHttpMessageListener().setSelfListener(true);
        this.fGS.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fGS);
    }

    public int bjQ() {
        return this.ecm;
    }

    public void setHasMore(int i) {
        this.ecm = i;
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
        this.fGQ = z;
    }

    public void registerListener() {
        registerListener(this.fGS);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.aa(list)) {
            this.loadingDone = true;
            return;
        }
        String ch = ch(list);
        if (!TextUtils.isEmpty(ch)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ch);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(y.avp(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fGM = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.ceM().ceG() != null) {
            loadMoreRequestMessage.setLoadCount(r.ceM().ceG().au(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fGL) {
            this.fGL = true;
            if (com.baidu.tbadk.p.m.auk().aul() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fGM)) != null) {
                iVar.auh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fGL) {
            this.fGL = true;
            if (com.baidu.tbadk.p.m.auk().aul() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fGM)) != null) {
                iVar.auh();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.auk().aul() && (this.fGK instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fGM;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fGK).cyF, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cyO = currentTimeMillis;
                iVar.fA(true);
            }
        }
    }

    private String ch(List<Long> list) {
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
        this.fGN.clear();
        this.fGO.clear();
        this.fGP.clear();
        this.ecm = -1;
        this.mPn = 1;
    }

    public boolean ci(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<m> a(boolean z, boolean z2, boolean z3, ArrayList<m> arrayList, f fVar) {
        if (z3) {
            this.fGN.clear();
            this.fGO.clear();
            this.fGP.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fGN.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bf) {
                bg bgVar = ((bf) next).threadData;
                if (bgVar.getTid() != null) {
                    hashSet.add(bgVar.getTid());
                }
            } else if (next instanceof bg) {
                bg bgVar2 = (bg) next;
                if (bgVar2.getTid() != null) {
                    hashSet.add(bgVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bf) {
                    bg bgVar3 = ((bf) next2).threadData;
                    bgVar3.mo(this.fGK.getForumName());
                    if (bgVar3.adS()) {
                        if (!hashSet.contains(bgVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bf) next2).threadData.tid)) {
                                arrayList3.add(((bf) next2).threadData.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bf) next2).threadData.tid)) {
                            arrayList3.add(((bf) next2).threadData.tid);
                        }
                    }
                } else if (next2 instanceof bg) {
                    bg bgVar4 = (bg) next2;
                    bgVar4.mo(this.fGK.getForumName());
                    if (bgVar4.adS()) {
                        if (!hashSet.contains(bgVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bgVar4.tid)) {
                                arrayList3.add(bgVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bgVar4.tid)) {
                            arrayList3.add(bgVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.fqm != null) {
            this.fqm.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bkm = this.fGK.bkm();
        if (this.fGQ && bkm != null && (this.fGK instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.fGN);
            arrayList4.addAll(this.fGP);
            bkm.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.fGK, true, arrayList2, arrayList4, z2);
        }
        int alt = TbadkCoreApplication.getInst().getListItemRule().alt() - this.fGN.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < alt) {
                this.fGN.add(arrayList2.get(i));
            } else {
                this.fGP.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.fGN);
        arrayList5.addAll(this.fGP);
        if (this.fGK instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fGK, this.fGK.bkm(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> boW() {
        int i;
        int size = this.fGP.size() + 30;
        int als = TbadkCoreApplication.getInst().getListItemRule().als() * 3;
        if (size > als && this.fGP.size() > (i = size - als)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fGP.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fGN);
        arrayList.addAll(this.fGP);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fGR = aVar;
    }

    public void boX() {
        int i;
        int size = this.fGP.size() + 30;
        int als = TbadkCoreApplication.getInst().getListItemRule().als() * 3;
        int Z = v.Z(this.fGN);
        if (size > als && this.fGP.size() > (i = size - als)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fGP.remove(0);
                if (this.fGR != null) {
                    this.fGR.removeItem(Z);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fGN != null) {
                this.fGN.remove(mVar);
            }
            if (this.fGP != null) {
                this.fGP.remove(mVar);
            }
        }
    }

    public void wQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.aa(this.fGN)) {
                c(this.fGN, str);
            }
            if (!v.aa(this.fGP)) {
                c(this.fGP, str);
            }
        }
    }

    private void c(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.azj() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.azj()).bDT)) {
                    it.remove();
                }
            }
        }
    }
}
