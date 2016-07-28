package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
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
    public boolean axe;
    private FrsActivity bGh;
    public boolean bOg;
    public int bOh;
    private ArrayList<v> bOi;
    private ArrayList<v> bOj;
    private final com.baidu.adp.framework.listener.a bOk;
    private boolean bRp;
    private long bRq;
    private int mSortType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.axe = false;
        this.bOg = false;
        this.bOh = 0;
        this.bRp = false;
        this.bRq = 0L;
        this.bOi = new ArrayList<>();
        this.bOj = new ArrayList<>();
        this.bOk = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bGh = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bOk);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bOg = true;
            return;
        }
        String aw = aw(list);
        if (!TextUtils.isEmpty(aw)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(aw);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(com.baidu.adp.lib.h.b.c(s.FK(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            sendMessage(loadMoreRequestMessage);
            this.axe = true;
            this.bRq = System.currentTimeMillis();
        }
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bRp) {
            this.bRp = true;
            if (aa.EV().EW() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bRq)) != null) {
                vVar.EQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bRp) {
            this.bRp = true;
            if (aa.EV().EW() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bRq)) != null) {
                vVar.EQ();
            }
        }
    }

    private String aw(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bOg = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bOh != 0) {
            if (this.bOh != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bOg = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bOg = true;
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
        this.bOh = 0;
        this.bOg = false;
        this.bOi.clear();
        this.bOj.clear();
    }

    public boolean ax(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bOh == 2 || this.bOg) ? false : true;
        }
        this.bOg = true;
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
            this.bOi.clear();
            this.bOj.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bOi.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof be) {
                be beVar = (be) next;
                if (beVar.getTid() != null) {
                    hashSet.add(beVar.getTid());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<v> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            v next2 = it2.next();
            if (next2 instanceof be) {
                be beVar2 = (be) next2;
                if (beVar2.qR()) {
                    if (!hashSet.contains(beVar2.getTid())) {
                        arrayList2.add(next2);
                    }
                } else {
                    arrayList2.add(next2);
                }
            } else {
                arrayList2.add(next2);
            }
        }
        int wF = TbadkCoreApplication.m10getInst().getListItemRule().wF() - this.bOi.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < wF) {
                this.bOi.add((v) arrayList2.get(i));
            } else {
                this.bOj.add((v) arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bOi);
        arrayList3.addAll(this.bOj);
        a(fVar, arrayList2, arrayList3);
        return arrayList3;
    }

    private void a(f fVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && y.s(list) > 0 && y.s(list2) > 0) {
            for (int i : f.fkh) {
                v vVar = (v) y.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    fVar.bj(i, indexOf);
                }
            }
        }
    }

    public ArrayList<v> Ze() {
        int i;
        int size = this.bOj.size() + 30;
        int wE = TbadkCoreApplication.m10getInst().getListItemRule().wE();
        if (size > wE && this.bOj.size() > (i = size - wE)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bOj.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bOi);
        arrayList.addAll(this.bOj);
        return arrayList;
    }
}
