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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.p.i;
import com.baidu.tbadk.util.x;
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
    private int eiz;
    private final com.baidu.tieba.frs.loadmore.a fOl;
    private boolean fOm;
    private long fOn;
    private final ArrayList<m> fOo;
    private final ArrayList<String> fOp;
    private final ArrayList<m> fOq;
    private boolean fOr;
    private c.a fOs;
    private final com.baidu.adp.framework.listener.a fOt;
    private k fxw;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes4.dex */
    public interface a {
        void V(ArrayList<m> arrayList);

        void xc(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, k kVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.fOm = false;
        this.fOn = 0L;
        this.fOo = new ArrayList<>();
        this.fOp = new ArrayList<>();
        this.fOq = new ArrayList<>();
        this.mPn = 1;
        this.eiz = -1;
        this.fOr = false;
        this.mPageType = 1;
        this.fOt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.fOl != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.fOl.xc(FrsLoadMoreModel.this.fOl.getPageContext().getString(R.string.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.fOl.xc(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.fOl.xc(FrsLoadMoreModel.this.fOl.getPageContext().getString(R.string.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrsViewData bnj = FrsLoadMoreModel.this.fOl.bnj();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (bnj != null) {
                                bnj.updateLoadMoreBannerListData(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fOl.V(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fOl instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fOl).cAY = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (bnj != null) {
                                bnj.updateLoadMoreBannerListData(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.fOl.V(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.fOl instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.fOl).cAY = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.fOl.getForumName()) && r.ciJ().ciD() != null) {
                            r.ciJ().ciD().g(FrsLoadMoreModel.this.fOl.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.fOl = aVar;
        setUniqueId(this.fOl.getUniqueId());
        this.fxw = kVar;
        this.fOt.getHttpMessageListener().setSelfListener(true);
        this.fOt.getSocketMessageListener().setSelfListener(true);
        registerListener(this.fOt);
    }

    public int bmK() {
        return this.eiz;
    }

    public void setHasMore(int i) {
        this.eiz = i;
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

    public void kL(boolean z) {
        this.fOr = z;
    }

    public void registerListener() {
        registerListener(this.fOt);
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
            loadMoreRequestMessage.setLastClickTid(b.e(x.awM(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.fOn = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.ciJ().ciD() != null) {
            loadMoreRequestMessage.setLoadCount(r.ciJ().ciD().ay(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        i iVar;
        if (!this.fOm) {
            this.fOm = true;
            if (com.baidu.tbadk.p.m.avH().avI() && (iVar = new i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fOn)) != null) {
                iVar.avE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        i iVar;
        if (!this.fOm) {
            this.fOm = true;
            if (com.baidu.tbadk.p.m.avH().avI() && (iVar = new i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.fOn)) != null) {
                iVar.avE();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avH().avI() && (this.fOl instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.fOn;
            i iVar = new i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.fOl).cAY, false, currentTimeMillis);
            if (iVar != null) {
                iVar.cBh = currentTimeMillis;
                iVar.fH(true);
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
        this.fOo.clear();
        this.fOp.clear();
        this.fOq.clear();
        this.eiz = -1;
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
            this.fOo.clear();
            this.fOp.clear();
            this.fOq.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<m> it = this.fOo.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof bg) {
                bh bhVar = ((bg) next).threadData;
                if (bhVar.getTid() != null) {
                    hashSet.add(bhVar.getTid());
                }
            } else if (next instanceof bh) {
                bh bhVar2 = (bh) next;
                if (bhVar2.getTid() != null) {
                    hashSet.add(bhVar2.getTid());
                }
            }
        }
        ArrayList<m> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (!v.aa(arrayList)) {
            Iterator<m> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    bh bhVar3 = ((bg) next2).threadData;
                    bhVar3.mB(this.fOl.getForumName());
                    if (bhVar3.aeZ()) {
                        if (!hashSet.contains(bhVar3.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(((bg) next2).threadData.tid)) {
                                arrayList3.add(((bg) next2).threadData.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(((bg) next2).threadData.tid)) {
                            arrayList3.add(((bg) next2).threadData.tid);
                        }
                    }
                } else if (next2 instanceof bh) {
                    bh bhVar4 = (bh) next2;
                    bhVar4.mB(this.fOl.getForumName());
                    if (bhVar4.aeZ()) {
                        if (!hashSet.contains(bhVar4.getTid())) {
                            arrayList2.add(next2);
                            if (!arrayList3.contains(bhVar4.tid)) {
                                arrayList3.add(bhVar4.tid);
                            }
                        }
                    } else {
                        arrayList2.add(next2);
                        if (!arrayList3.contains(bhVar4.tid)) {
                            arrayList3.add(bhVar4.tid);
                        }
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.fxw != null) {
            this.fxw.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        FrsViewData bnj = this.fOl.bnj();
        if (this.fOr && bnj != null && (this.fOl instanceof com.baidu.tieba.InjectPlugin.a.b)) {
            ArrayList<m> arrayList4 = new ArrayList<>(this.fOo);
            arrayList4.addAll(this.fOq);
            bnj.addRecommendAppToThreadList((com.baidu.tieba.InjectPlugin.a.b) this.fOl, true, arrayList2, arrayList4, z2);
        }
        int amM = TbadkCoreApplication.getInst().getListItemRule().amM() - this.fOo.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < amM) {
                this.fOo.add(arrayList2.get(i));
            } else {
                this.fOq.add(arrayList2.get(i));
            }
        }
        ArrayList<m> arrayList5 = new ArrayList<>();
        arrayList5.addAll(this.fOo);
        arrayList5.addAll(this.fOq);
        if (this.fOl instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.fOl, this.fOl.bnj(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(fVar, arrayList2, arrayList5);
        }
        return arrayList5;
    }

    public ArrayList<m> brV() {
        int i;
        int size = this.fOq.size() + 30;
        int amL = TbadkCoreApplication.getInst().getListItemRule().amL() * 3;
        if (size > amL && this.fOq.size() > (i = size - amL)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fOq.remove(0);
            }
        }
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.addAll(this.fOo);
        arrayList.addAll(this.fOq);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.fOs = aVar;
    }

    public void brW() {
        int i;
        int size = this.fOq.size() + 30;
        int amL = TbadkCoreApplication.getInst().getListItemRule().amL() * 3;
        int Z = v.Z(this.fOo);
        if (size > amL && this.fOq.size() > (i = size - amL)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.fOq.remove(0);
                if (this.fOs != null) {
                    this.fOs.removeItem(Z);
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fOo != null) {
                this.fOo.remove(mVar);
            }
            if (this.fOq != null) {
                this.fOq.remove(mVar);
            }
        }
    }

    public void xV(String str) {
        if (!StringUtils.isNull(str)) {
            if (!v.aa(this.fOo)) {
                c(this.fOo, str);
            }
            if (!v.aa(this.fOq)) {
                c(this.fOq, str);
            }
        }
    }

    private void c(ArrayList<m> arrayList, String str) {
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                com.baidu.tieba.InjectPlugin.a aVar = (com.baidu.tieba.InjectPlugin.a) next;
                if ((aVar.aAN() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) aVar.aAN()).bFs)) {
                    it.remove();
                }
            }
        }
    }
}
