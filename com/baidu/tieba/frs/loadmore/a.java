package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean ayQ;
    private FrsActivity bgW;
    public boolean bnp;
    public int bnq;
    private ArrayList<u> bnr;
    private ArrayList<u> bns;
    private final com.baidu.adp.framework.listener.a bnt;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.ayQ = false;
        this.bnp = false;
        this.bnq = 0;
        this.bnr = new ArrayList<>();
        this.bns = new ArrayList<>();
        this.bnt = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bgW = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bnt);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bnp = true;
            return;
        }
        String af = af(list);
        if (!TextUtils.isEmpty(af)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(af);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            sendMessage(loadMoreRequestMessage);
            this.ayQ = true;
        }
    }

    private String af(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bnp = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bnq != 0) {
            if (this.bnq != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bnp = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bnp = true;
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
        this.bnq = 0;
        this.bnp = false;
        this.bnr.clear();
        this.bns.clear();
    }

    public boolean ag(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bnq == 2 || this.bnp) ? false : true;
        }
        this.bnp = true;
        return false;
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList) {
        return a(z, arrayList, (com.baidu.tieba.tbadkCore.data.e) null);
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.bnr.clear();
            this.bns.clear();
        }
        int yh = TbadkCoreApplication.m411getInst().getListItemRule().yh() - this.bnr.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < yh) {
                this.bnr.add(arrayList.get(i));
            } else {
                this.bns.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bnr);
        arrayList2.addAll(this.bns);
        a(eVar, arrayList, arrayList2);
        return arrayList2;
    }

    private void a(com.baidu.tieba.tbadkCore.data.e eVar, List<u> list, List<u> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && x.o(list) > 0 && x.o(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.dWz) {
                u uVar = (u) x.b(list, i);
                if (uVar != null && (indexOf = list2.indexOf(uVar)) >= 0) {
                    eVar.ba(i, indexOf);
                }
            }
        }
    }

    public ArrayList<u> QW() {
        int i;
        int size = this.bns.size() + 30;
        int yg = TbadkCoreApplication.m411getInst().getListItemRule().yg();
        if (size > yg && this.bns.size() > (i = size - yg)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bns.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bnr);
        arrayList.addAll(this.bns);
        return arrayList;
    }
}
