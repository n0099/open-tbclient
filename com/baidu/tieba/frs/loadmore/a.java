package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.d.t;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean aAd;
    public int bIA;
    private final ArrayList<v> bIB;
    private final ArrayList<v> bIC;
    private final com.baidu.adp.framework.listener.a bID;
    private int bId;
    public boolean bIz;
    private boolean bLH;
    private long bLI;
    private t byZ;
    private FrsActivity bzH;
    private int mPn;
    private int mSortType;

    public a(FrsActivity frsActivity, t tVar) {
        super(frsActivity.getPageContext());
        this.aAd = false;
        this.bIz = false;
        this.bIA = 0;
        this.bLH = false;
        this.bLI = 0L;
        this.bIB = new ArrayList<>();
        this.bIC = new ArrayList<>();
        this.mPn = 1;
        this.bId = -1;
        this.bID = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bzH = frsActivity;
        this.byZ = tVar;
        this.bID.ch().setSelfListener(true);
        this.bID.ci().setSelfListener(true);
        this.bzH.registerListener(this.bID);
    }

    public int Wp() {
        return this.bId;
    }

    public void setHasMore(int i) {
        this.bId = i;
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
            this.bIz = true;
            return;
        }
        String ar = ar(list);
        if (!TextUtils.isEmpty(ar)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ar);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(com.baidu.adp.lib.h.b.c(r.GC(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.aAd = true;
            this.bLI = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bLH) {
            this.bLH = true;
            if (aa.FU().FV() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bLI)) != null) {
                vVar.FP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bLH) {
            this.bLH = true;
            if (aa.FU().FV() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bLI)) != null) {
                vVar.FP();
            }
        }
    }

    private String ar(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bIz = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bIA != 0) {
            if (this.bIA != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bIz = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bIz = true;
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
        this.bIA = 0;
        this.bIz = false;
        this.bIB.clear();
        this.bIC.clear();
        this.bId = -1;
        this.mPn = 1;
    }

    public boolean as(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bIA == 2 || this.bIz) ? false : true;
        }
        this.bIz = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, f fVar) {
        if (z3) {
            this.bIB.clear();
            this.bIC.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bIB.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bg) {
                bg bgVar = (bg) next;
                if (bgVar.getTid() != null) {
                    hashSet.add(bgVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!x.t(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bg) {
                    bg bgVar2 = (bg) next2;
                    if (bgVar2.sb()) {
                        if (!hashSet.contains(bgVar2.getTid())) {
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
        if (this.byZ != null) {
            this.byZ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int xM = TbadkCoreApplication.m9getInst().getListItemRule().xM() - this.bIB.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xM) {
                this.bIB.add(arrayList2.get(i));
            } else {
                this.bIC.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bIB);
        arrayList3.addAll(this.bIC);
        com.baidu.tieba.frs.utils.a.a(this.bzH.Wh(), arrayList2, getPn());
        com.baidu.tieba.frs.utils.a.a(fVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> ZU() {
        int i;
        int size = this.bIC.size() + 30;
        int xL = TbadkCoreApplication.m9getInst().getListItemRule().xL();
        if (size > xL && this.bIC.size() > (i = size - xL)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bIC.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bIB);
        arrayList.addAll(this.bIC);
        return arrayList;
    }
}
