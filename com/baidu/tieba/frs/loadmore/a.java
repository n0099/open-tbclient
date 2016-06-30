package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean awp;
    private FrsActivity bET;
    private final com.baidu.adp.framework.listener.a bMA;
    public boolean bMw;
    public int bMx;
    private ArrayList<v> bMy;
    private ArrayList<v> bMz;
    private boolean bPC;
    private long bPD;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.awp = false;
        this.bMw = false;
        this.bMx = 0;
        this.bPC = false;
        this.bPD = 0L;
        this.bMy = new ArrayList<>();
        this.bMz = new ArrayList<>();
        this.bMA = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bET = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bMA);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bMw = true;
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
            sendMessage(loadMoreRequestMessage);
            this.awp = true;
            this.bPD = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bPC) {
            this.bPC = true;
            if (aa.EW().EX() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bPD)) != null) {
                vVar.ER();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bPC) {
            this.bPC = true;
            if (aa.EW().EX() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bPD)) != null) {
                vVar.ER();
            }
        }
    }

    private String as(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bMw = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bMx != 0) {
            if (this.bMx != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bMw = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bMw = true;
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
        this.bMx = 0;
        this.bMw = false;
        this.bMy.clear();
        this.bMz.clear();
    }

    public boolean at(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bMx == 2 || this.bMw) ? false : true;
        }
        this.bMw = true;
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
            this.bMy.clear();
            this.bMz.clear();
        }
        int wF = TbadkCoreApplication.m9getInst().getListItemRule().wF() - this.bMy.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wF) {
                this.bMy.add(arrayList.get(i));
            } else {
                this.bMz.add(arrayList.get(i));
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bMy);
        arrayList2.addAll(this.bMz);
        a(fVar, arrayList, arrayList2);
        return arrayList2;
    }

    private void a(f fVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && y.s(list) > 0 && y.s(list2) > 0) {
            for (int i : f.eXf) {
                v vVar = (v) y.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    fVar.bg(i, indexOf);
                }
            }
        }
    }

    public ArrayList<v> YJ() {
        int i;
        int size = this.bMz.size() + 30;
        int wE = TbadkCoreApplication.m9getInst().getListItemRule().wE();
        if (size > wE && this.bMz.size() > (i = size - wE)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bMz.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bMy);
        arrayList.addAll(this.bMz);
        return arrayList;
    }
}
