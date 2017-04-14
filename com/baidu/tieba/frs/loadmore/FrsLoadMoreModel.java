package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.mc.x;
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
    private x bNx;
    private FrsActivity bOf;
    private final ArrayList<v> bVL;
    private final ArrayList<v> bVM;
    private final com.baidu.adp.framework.listener.a bVN;
    private boolean bXE;
    private long bXF;
    private int biU;
    private int buQ;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mSortType;

    public FrsLoadMoreModel(FrsActivity frsActivity, x xVar) {
        super(frsActivity.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.bXE = false;
        this.bXF = 0L;
        this.bVL = new ArrayList<>();
        this.bVM = new ArrayList<>();
        this.buQ = 1;
        this.biU = -1;
        this.bVN = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bOf = frsActivity;
        this.bNx = xVar;
        this.bVN.getHttpMessageListener().setSelfListener(true);
        this.bVN.getSocketMessageListener().setSelfListener(true);
        this.bOf.registerListener(this.bVN);
    }

    public int Zb() {
        return this.biU;
    }

    public void setHasMore(int i) {
        this.biU = i;
    }

    public int getPn() {
        return this.buQ;
    }

    public void setPn(int i) {
        this.buQ = i;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || com.baidu.tbadk.core.util.x.q(list)) {
            this.loadingDone = true;
            return;
        }
        String as = as(list);
        if (!TextUtils.isEmpty(as)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(as);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(r.Hs(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.bXF = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.bXE) {
            this.bXE = true;
            if (aa.GG().GH() && (vVar = new com.baidu.tbadk.j.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bXF)) != null) {
                vVar.GB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.bXE) {
            this.bXE = true;
            if (aa.GG().GH() && (vVar = new com.baidu.tbadk.j.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bXF)) != null) {
                vVar.GB();
            }
        }
    }

    private String as(List<Long> list) {
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
        this.bVL.clear();
        this.bVM.clear();
        this.biU = -1;
        this.buQ = 1;
    }

    public boolean at(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, e eVar) {
        if (z3) {
            this.bVL.clear();
            this.bVM.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bVL.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bi) {
                bi biVar = (bi) next;
                if (biVar.getTid() != null) {
                    hashSet.add(biVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bi) {
                    bi biVar2 = (bi) next2;
                    if (biVar2.sL()) {
                        if (!hashSet.contains(biVar2.getTid())) {
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
        if (this.bNx != null) {
            this.bNx.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int yC = TbadkCoreApplication.m9getInst().getListItemRule().yC() - this.bVL.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yC) {
                this.bVL.add(arrayList2.get(i));
            } else {
                this.bVM.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bVL);
        arrayList3.addAll(this.bVM);
        com.baidu.tieba.frs.f.a.a(this.bOf.getPageContext(), this.bOf.YT(), arrayList2, getPn());
        com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> acq() {
        int i;
        int size = this.bVM.size() + 30;
        int yB = TbadkCoreApplication.m9getInst().getListItemRule().yB();
        if (size > yB && this.bVM.size() > (i = size - yB)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bVM.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bVL);
        arrayList.addAll(this.bVM);
        return arrayList;
    }
}
