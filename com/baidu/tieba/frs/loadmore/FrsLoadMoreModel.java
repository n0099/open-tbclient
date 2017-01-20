package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.mc.s;
import com.baidu.tieba.tbadkCore.data.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLoadMoreModel extends BdBaseModel<FrsActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private s bGz;
    private FrsActivity bHh;
    private final ArrayList<v> bOP;
    private final ArrayList<v> bOQ;
    private final com.baidu.adp.framework.listener.a bOR;
    private boolean bRX;
    private long bRY;
    private int bco;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(FrsActivity frsActivity, s sVar) {
        super(frsActivity.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.bRX = false;
        this.bRY = 0L;
        this.bOP = new ArrayList<>();
        this.bOQ = new ArrayList<>();
        this.mPn = 1;
        this.bco = -1;
        this.bOR = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bHh = frsActivity;
        this.bGz = sVar;
        this.bOR.getHttpMessageListener().setSelfListener(true);
        this.bOR.getSocketMessageListener().setSelfListener(true);
        this.bHh.registerListener(this.bOR);
    }

    public int XG() {
        return this.bco;
    }

    public void setHasMore(int i) {
        this.bco = i;
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
        if (j == 0 || w.s(list)) {
            this.loadingDone = true;
            return;
        }
        String av = av(list);
        if (!TextUtils.isEmpty(av)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(av);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(r.Gu(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.bRY = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bRX) {
            this.bRX = true;
            if (aa.FO().FP() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bRY)) != null) {
                vVar.FJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bRX) {
            this.bRX = true;
            if (aa.FO().FP() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bRY)) != null) {
                vVar.FJ();
            }
        }
    }

    private String av(List<Long> list) {
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
                    sb.append(l).append(",");
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
        this.bOP.clear();
        this.bOQ.clear();
        this.bco = -1;
        this.mPn = 1;
    }

    public boolean aw(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, e eVar) {
        if (z3) {
            this.bOP.clear();
            this.bOQ.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bOP.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bh) {
                bh bhVar = (bh) next;
                if (bhVar.getTid() != null) {
                    hashSet.add(bhVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!w.s(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bh) {
                    bh bhVar2 = (bh) next2;
                    if (bhVar2.rT()) {
                        if (!hashSet.contains(bhVar2.getTid())) {
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
        if (this.bGz != null) {
            this.bGz.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int xI = TbadkCoreApplication.m9getInst().getListItemRule().xI() - this.bOP.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xI) {
                this.bOP.add(arrayList2.get(i));
            } else {
                this.bOQ.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bOP);
        arrayList3.addAll(this.bOQ);
        com.baidu.tieba.frs.utils.a.a(this.bHh.getPageContext(), this.bHh.Xy(), arrayList2, getPn());
        com.baidu.tieba.frs.utils.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> aaX() {
        int i;
        int size = this.bOQ.size() + 30;
        int xH = TbadkCoreApplication.m9getInst().getListItemRule().xH();
        if (size > xH && this.bOQ.size() > (i = size - xH)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bOQ.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bOP);
        arrayList.addAll(this.bOQ);
        return arrayList;
    }
}
