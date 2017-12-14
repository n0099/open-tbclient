package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.k;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int bOj;
    private i cIe;
    private final ArrayList<f> cRM;
    private final ArrayList<f> cRN;
    private final a cRO;
    private final g cXx;
    private boolean cXy;
    private long cXz;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(g gVar, i iVar) {
        super(gVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cXy = false;
        this.cXz = 0L;
        this.cRM = new ArrayList<>();
        this.cRN = new ArrayList<>();
        this.mPn = 1;
        this.bOj = -1;
        this.cRO = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.cXx != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.cXx.lb(FrsLoadMoreModel.this.cXx.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        k alF = FrsLoadMoreModel.this.cXx.alF();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (alF != null) {
                                alF.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cXx.I(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (alF != null) {
                                alF.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cXx.I(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.cXx.getForumName()) && q.blR().blL() != null) {
                            q.blR().blL().f(FrsLoadMoreModel.this.cXx.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.cXx.lb(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.cXx.lb(FrsLoadMoreModel.this.cXx.getPageContext().getString(d.j.neterror));
                    }
                }
            }
        };
        this.cXx = gVar;
        setUniqueId(this.cXx.getUniqueId());
        this.cIe = iVar;
        this.cRO.getHttpMessageListener().setSelfListener(true);
        this.cRO.getSocketMessageListener().setSelfListener(true);
        this.cXx.registerListener(this.cRO);
    }

    public int alp() {
        return this.bOj;
    }

    public void setHasMore(int i) {
        this.bOj = i;
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

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.w(list)) {
            this.loadingDone = true;
            return;
        }
        String bb = bb(list);
        if (!TextUtils.isEmpty(bb)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bb);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(t.Ht(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cXz = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.blR().blL() != null) {
            loadMoreRequestMessage.setLoadCount(q.blR().blL().W(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.cXy) {
            this.cXy = true;
            if (r.GB().GC() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cXz)) != null) {
                mVar.Gw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.cXy) {
            this.cXy = true;
            if (r.GB().GC() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cXz)) != null) {
                mVar.Gw();
            }
        }
    }

    private String bb(List<Long> list) {
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
        this.cRM.clear();
        this.cRN.clear();
        this.bOj = -1;
        this.mPn = 1;
    }

    public boolean bc(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<f> a(boolean z, boolean z2, boolean z3, ArrayList<f> arrayList, e eVar) {
        if (z3) {
            this.cRM.clear();
            this.cRN.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<f> it = this.cRM.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next instanceof bd) {
                bd bdVar = (bd) next;
                if (bdVar.getTid() != null) {
                    hashSet.add(bdVar.getTid());
                }
            }
        }
        ArrayList<f> arrayList2 = new ArrayList<>();
        if (!v.w(arrayList)) {
            Iterator<f> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (next2 instanceof bd) {
                    bd bdVar2 = (bd) next2;
                    bdVar2.cH(this.cXx.getForumName());
                    if (bdVar2.rT()) {
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
        if (this.cIe != null) {
            this.cIe.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int yf = TbadkCoreApplication.getInst().getListItemRule().yf() - this.cRM.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yf) {
                this.cRM.add(arrayList2.get(i));
            } else {
                this.cRN.add(arrayList2.get(i));
            }
        }
        ArrayList<f> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.cRM);
        arrayList3.addAll(this.cRN);
        com.baidu.tieba.frs.f.a.a(this.cXx, this.cXx.alj(), arrayList2, getPn());
        com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<f> aoA() {
        int i;
        int size = this.cRN.size() + 30;
        int ye = TbadkCoreApplication.getInst().getListItemRule().ye();
        if (size > ye && this.cRN.size() > (i = size - ye)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.cRN.remove(0);
            }
        }
        ArrayList<f> arrayList = new ArrayList<>();
        arrayList.addAll(this.cRM);
        arrayList.addAll(this.cRN);
        return arrayList;
    }
}
