package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int bXW;
    private i cZq;
    private final com.baidu.tieba.frs.loadmore.a dnO;
    private boolean dnP;
    private long dnQ;
    private final ArrayList<h> dnR;
    private final ArrayList<h> dnS;
    private c.a dnT;
    private final com.baidu.adp.framework.listener.a dnU;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<h> arrayList);

        void lA(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dnP = false;
        this.dnQ = 0L;
        this.dnR = new ArrayList<>();
        this.dnS = new ArrayList<>();
        this.mPn = 1;
        this.bXW = -1;
        this.mPageType = 1;
        this.dnU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dnO != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dnO.lA(FrsLoadMoreModel.this.dnO.getPageContext().getString(d.k.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l apD = FrsLoadMoreModel.this.dnO.apD();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (apD != null) {
                                apD.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dnO.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (apD != null) {
                                apD.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dnO.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dnO.getForumName()) && r.bjk().bje() != null) {
                            r.bjk().bje().f(FrsLoadMoreModel.this.dnO.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dnO.lA(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dnO.lA(FrsLoadMoreModel.this.dnO.getPageContext().getString(d.k.neterror));
                    }
                }
            }
        };
        this.dnO = aVar;
        setUniqueId(this.dnO.getUniqueId());
        this.cZq = iVar;
        this.dnU.getHttpMessageListener().setSelfListener(true);
        this.dnU.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dnU);
    }

    public int apn() {
        return this.bXW;
    }

    public void setHasMore(int i) {
        this.bXW = i;
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

    public void registerListener() {
        registerListener(this.dnU);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.w(list)) {
            this.loadingDone = true;
            return;
        }
        String bq = bq(list);
        if (!TextUtils.isEmpty(bq)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bq);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(t.HN(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dnQ = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bjk().bje() != null) {
            loadMoreRequestMessage.setLoadCount(r.bjk().bje().R(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dnP) {
            this.dnP = true;
            if (p.GY().GZ() && (lVar = new com.baidu.tbadk.k.l(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dnQ)) != null) {
                lVar.GR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dnP) {
            this.dnP = true;
            if (p.GY().GZ() && (lVar = new com.baidu.tbadk.k.l(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dnQ)) != null) {
                lVar.GR();
            }
        }
    }

    private String bq(List<Long> list) {
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
        this.dnR.clear();
        this.dnS.clear();
        this.bXW = -1;
        this.mPn = 1;
    }

    public boolean br(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, e eVar) {
        if (z3) {
            this.dnR.clear();
            this.dnS.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dnR.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof bd) {
                bd bdVar = (bd) next;
                if (bdVar.getTid() != null) {
                    hashSet.add(bdVar.getTid());
                }
            }
        }
        ArrayList<h> arrayList2 = new ArrayList<>();
        if (!v.w(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bd) {
                    bd bdVar2 = (bd) next2;
                    bdVar2.cN(this.dnO.getForumName());
                    if (bdVar2.sl()) {
                        if (!hashSet.contains(bdVar2.getTid())) {
                            arrayList2.add(next2);
                        }
                    } else {
                        arrayList2.add(next2);
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.cZq != null) {
            this.cZq.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int yF = TbadkCoreApplication.getInst().getListItemRule().yF() - this.dnR.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yF) {
                this.dnR.add(arrayList2.get(i));
            } else {
                this.dnS.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dnR);
        arrayList3.addAll(this.dnS);
        if (this.dnO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dnO, this.dnO.apD(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> atW() {
        int i;
        int size = this.dnS.size() + 30;
        int yE = TbadkCoreApplication.getInst().getListItemRule().yE();
        if (size > yE && this.dnS.size() > (i = size - yE)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dnS.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dnR);
        arrayList.addAll(this.dnS);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dnT = aVar;
    }

    public void atX() {
        int i;
        int size = this.dnS.size() + 30;
        int yE = TbadkCoreApplication.getInst().getListItemRule().yE();
        int v = v.v(this.dnR);
        if (size > yE && this.dnS.size() > (i = size - yE)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dnS.remove(0);
                if (this.dnT != null) {
                    this.dnT.removeItem(v);
                }
            }
        }
    }
}
