package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean avz;
    private FrsActivity bjB;
    public boolean bqQ;
    public int bqR;
    private ArrayList<v> bqS;
    private ArrayList<v> bqT;
    private final com.baidu.adp.framework.listener.a bqU;
    private boolean brZ;
    private long bsa;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.avz = false;
        this.bqQ = false;
        this.bqR = 0;
        this.brZ = false;
        this.bsa = 0L;
        this.bqS = new ArrayList<>();
        this.bqT = new ArrayList<>();
        this.bqU = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bjB = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bqU);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bqQ = true;
            return;
        }
        String ah = ah(list);
        if (!TextUtils.isEmpty(ah)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ah);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            sendMessage(loadMoreRequestMessage);
            this.avz = true;
            this.bsa = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        if (!this.brZ) {
            this.brZ = true;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eM(1000);
            vVar.axN = true;
            vVar.axK = false;
            vVar.isSuccess = loadMoreResponseSocketMessage.hasError() ? false : true;
            vVar.axy = loadMoreResponseSocketMessage.performanceData.gv;
            vVar.axz = loadMoreResponseSocketMessage.performanceData.gw;
            vVar.axA = loadMoreResponseSocketMessage.performanceData.gx;
            vVar.eD = loadMoreResponseSocketMessage.performanceData.gy;
            vVar.eE = loadMoreResponseSocketMessage.performanceData.gz;
            vVar.axB = loadMoreResponseSocketMessage.performanceData.gA;
            vVar.axC = loadMoreResponseSocketMessage.performanceData.gB;
            vVar.axD = loadMoreResponseSocketMessage.performanceData.gC;
            vVar.axD += loadMoreResponseSocketMessage.getProcessTime() - loadMoreResponseSocketMessage.getStartTime();
            vVar.axI = loadMoreResponseSocketMessage.getDownSize();
            vVar.errCode = loadMoreResponseSocketMessage.getError();
            vVar.axJ = 0L;
            vVar.axF = System.currentTimeMillis() - this.bsa;
            vVar.sequenceID = loadMoreResponseSocketMessage.sequenceID;
            vVar.EH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        if (!this.brZ) {
            this.brZ = true;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eM(1000);
            vVar.axN = true;
            vVar.axK = true;
            vVar.isSuccess = loadMoreHttpResponseMessage.hasError() ? false : true;
            vVar.axy = loadMoreHttpResponseMessage.performanceData.gv;
            vVar.axz = loadMoreHttpResponseMessage.performanceData.gw;
            vVar.axA = loadMoreHttpResponseMessage.performanceData.gx;
            vVar.eD = loadMoreHttpResponseMessage.performanceData.gy;
            vVar.eE = loadMoreHttpResponseMessage.performanceData.gz;
            vVar.axB = loadMoreHttpResponseMessage.performanceData.gA;
            vVar.axC = loadMoreHttpResponseMessage.performanceData.gB;
            vVar.axD = loadMoreHttpResponseMessage.performanceData.gC;
            vVar.axD += loadMoreHttpResponseMessage.getProcessTime() - loadMoreHttpResponseMessage.getStartTime();
            vVar.axL = loadMoreHttpResponseMessage.performanceData.gF;
            vVar.axM = loadMoreHttpResponseMessage.performanceData.gG;
            vVar.axI = 0L;
            vVar.errCode = loadMoreHttpResponseMessage.getError();
            vVar.axJ = loadMoreHttpResponseMessage.getDownSize();
            vVar.axF = System.currentTimeMillis() - this.bsa;
            vVar.axO = loadMoreHttpResponseMessage.getOrginalMessage().getClientLogID();
            vVar.EH();
        }
    }

    private String ah(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bqQ = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bqR != 0) {
            if (this.bqR != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bqQ = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bqQ = true;
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
        this.bqR = 0;
        this.bqQ = false;
        this.bqS.clear();
        this.bqT.clear();
    }

    public boolean ai(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bqR == 2 || this.bqQ) ? false : true;
        }
        this.bqQ = true;
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
            this.bqS.clear();
            this.bqT.clear();
        }
        int wB = TbadkCoreApplication.m11getInst().getListItemRule().wB() - this.bqS.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wB) {
                this.bqS.add(arrayList.get(i));
            } else {
                this.bqT.add(arrayList.get(i));
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bqS);
        arrayList2.addAll(this.bqT);
        a(fVar, arrayList, arrayList2);
        return arrayList2;
    }

    private void a(f fVar, List<v> list, List<v> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && y.r(list) > 0 && y.r(list2) > 0) {
            for (int i : f.esr) {
                v vVar = (v) y.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    fVar.aY(i, indexOf);
                }
            }
        }
    }

    public ArrayList<v> SW() {
        int i;
        int size = this.bqT.size() + 30;
        int wA = TbadkCoreApplication.m11getInst().getListItemRule().wA();
        if (size > wA && this.bqT.size() > (i = size - wA)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bqT.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bqS);
        arrayList.addAll(this.bqT);
        return arrayList;
    }
}
