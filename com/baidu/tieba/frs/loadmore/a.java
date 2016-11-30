package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.e.t;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean aAG;
    private t bSO;
    private FrsActivity bTA;
    public boolean ccS;
    public int ccT;
    private final ArrayList<v> ccU;
    private final ArrayList<v> ccV;
    private final com.baidu.adp.framework.listener.a ccW;
    private int ccx;
    private boolean cfY;
    private long cfZ;
    private int mPn;
    private int mSortType;

    public a(FrsActivity frsActivity, t tVar) {
        super(frsActivity.getPageContext());
        this.aAG = false;
        this.ccS = false;
        this.ccT = 0;
        this.cfY = false;
        this.cfZ = 0L;
        this.ccU = new ArrayList<>();
        this.ccV = new ArrayList<>();
        this.mPn = 1;
        this.ccx = -1;
        this.ccW = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bTA = frsActivity;
        this.bSO = tVar;
        this.ccW.ch().setSelfListener(true);
        this.ccW.ci().setSelfListener(true);
        this.bTA.registerListener(this.ccW);
    }

    public int acb() {
        return this.ccx;
    }

    public void setHasMore(int i) {
        this.ccx = i;
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
        if (j == 0 || x.t(list)) {
            this.ccS = true;
            return;
        }
        String az = az(list);
        if (!TextUtils.isEmpty(az)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(az);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(com.baidu.adp.lib.h.b.c(r.Hg(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.aAG = true;
            this.cfZ = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.cfY) {
            this.cfY = true;
            if (aa.Gu().Gv() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cfZ)) != null) {
                vVar.Gp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.cfY) {
            this.cfY = true;
            if (aa.Gu().Gv() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cfZ)) != null) {
                vVar.Gp();
            }
        }
    }

    private String az(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.ccS = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.ccT != 0) {
            if (this.ccT != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.ccS = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.ccS = true;
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void resetData() {
        this.ccT = 0;
        this.ccS = false;
        this.ccU.clear();
        this.ccV.clear();
        this.ccx = -1;
        this.mPn = 1;
    }

    public boolean aA(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.ccT == 2 || this.ccS) ? false : true;
        }
        this.ccS = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, f fVar) {
        if (z3) {
            this.ccU.clear();
            this.ccV.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.ccU.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bk) {
                bk bkVar = (bk) next;
                if (bkVar.getTid() != null) {
                    hashSet.add(bkVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!x.t(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bk) {
                    bk bkVar2 = (bk) next2;
                    if (bkVar2.sk()) {
                        if (!hashSet.contains(bkVar2.getTid())) {
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
        if (this.bSO != null) {
            this.bSO.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int xY = TbadkCoreApplication.m9getInst().getListItemRule().xY() - this.ccU.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xY) {
                this.ccU.add(arrayList2.get(i));
            } else {
                this.ccV.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.ccU);
        arrayList3.addAll(this.ccV);
        com.baidu.tieba.frs.utils.a.a(this.bTA.abS(), arrayList2, getPn());
        com.baidu.tieba.frs.utils.a.a(fVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> afz() {
        int i;
        int size = this.ccV.size() + 30;
        int xX = TbadkCoreApplication.m9getInst().getListItemRule().xX();
        if (size > xX && this.ccV.size() > (i = size - xX)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ccV.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.ccU);
        arrayList.addAll(this.ccV);
        return arrayList;
    }
}
