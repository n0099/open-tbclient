package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean aAl;
    private FrsActivity bRp;
    private ArrayList<v> bZA;
    private ArrayList<v> bZB;
    private final com.baidu.adp.framework.listener.a bZC;
    public boolean bZy;
    public int bZz;
    private boolean ccB;
    private long ccC;
    private int mSortType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aAl = false;
        this.bZy = false;
        this.bZz = 0;
        this.ccB = false;
        this.ccC = 0L;
        this.bZA = new ArrayList<>();
        this.bZB = new ArrayList<>();
        this.bZC = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bRp = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bZC);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bZy = true;
            return;
        }
        String ay = ay(list);
        if (!TextUtils.isEmpty(ay)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ay);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(com.baidu.adp.lib.h.b.c(s.He(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.aAl = true;
            this.ccC = System.currentTimeMillis();
        }
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.ccB) {
            this.ccB = true;
            if (aa.Gp().Gq() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.ccC)) != null) {
                vVar.Gk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.ccB) {
            this.ccB = true;
            if (aa.Gp().Gq() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.ccC)) != null) {
                vVar.Gk();
            }
        }
    }

    private String ay(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bZy = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bZz != 0) {
            if (this.bZz != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bZy = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bZy = true;
            }
            Long l = list.get(i3);
            if (l != null) {
                if (i3 == i - 1) {
                    sb.append(l);
                } else {
                    sb.append(l + ",");
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
        this.bZz = 0;
        this.bZy = false;
        this.bZA.clear();
        this.bZB.clear();
    }

    public boolean az(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bZz == 2 || this.bZy) ? false : true;
        }
        this.bZy = true;
        return false;
    }

    public ArrayList<v> a(boolean z, ArrayList<v> arrayList) {
        return a(z, arrayList, (f) null);
    }

    public ArrayList<v> a(boolean z, ArrayList<v> arrayList, f fVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.bZA.clear();
            this.bZB.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bZA.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bg) {
                bg bgVar = (bg) next;
                if (bgVar.getTid() != null) {
                    hashSet.add(bgVar.getTid());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<v> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            v next2 = it2.next();
            if (next2 instanceof bg) {
                bg bgVar2 = (bg) next2;
                if (bgVar2.rW()) {
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
        int xP = TbadkCoreApplication.m9getInst().getListItemRule().xP() - this.bZA.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xP) {
                this.bZA.add((v) arrayList2.get(i));
            } else {
                this.bZB.add((v) arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bZA);
        arrayList3.addAll(this.bZB);
        a(fVar, arrayList2, arrayList3);
        return arrayList3;
    }

    private void a(f fVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && y.s(list) > 0 && y.s(list2) > 0) {
            for (int i : f.fsb) {
                v vVar = (v) y.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    fVar.bo(i, indexOf);
                }
            }
        }
    }

    public ArrayList<v> adQ() {
        int i;
        int size = this.bZB.size() + 30;
        int xO = TbadkCoreApplication.m9getInst().getListItemRule().xO();
        if (size > xO && this.bZB.size() > (i = size - xO)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bZB.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bZA);
        arrayList.addAll(this.bZB);
        return arrayList;
    }
}
