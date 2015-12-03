package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean awu;
    private FrsActivity baC;
    public boolean bgB;
    public int bgC;
    private ArrayList<u> bgD;
    private ArrayList<u> bgE;
    private final com.baidu.adp.framework.listener.a bgF;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.awu = false;
        this.bgB = false;
        this.bgC = 0;
        this.bgD = new ArrayList<>();
        this.bgE = new ArrayList<>();
        this.bgF = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.baC = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bgF);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bgB = true;
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
            this.awu = true;
        }
    }

    private String ah(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bgB = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bgC != 0) {
            if (this.bgC != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bgB = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bgB = true;
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
        this.bgC = 0;
        this.bgB = false;
        this.bgD.clear();
        this.bgE.clear();
    }

    public boolean ai(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bgC == 2 || this.bgB) ? false : true;
        }
        this.bgB = true;
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
            this.bgD.clear();
            this.bgE.clear();
        }
        int xl = TbadkCoreApplication.m411getInst().getListItemRule().xl() - this.bgD.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < xl) {
                this.bgD.add(arrayList.get(i));
            } else {
                this.bgE.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bgD);
        arrayList2.addAll(this.bgE);
        a(eVar, arrayList, arrayList2);
        return arrayList2;
    }

    private void a(com.baidu.tieba.tbadkCore.data.e eVar, List<u> list, List<u> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && y.k(list) > 0 && y.k(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.dzj) {
                u uVar = (u) y.b(list, i);
                if (uVar != null && (indexOf = list2.indexOf(uVar)) >= 0) {
                    eVar.aI(i, indexOf);
                }
            }
        }
    }

    public ArrayList<u> OB() {
        int i;
        int size = this.bgE.size() + 30;
        int xk = TbadkCoreApplication.m411getInst().getListItemRule().xk();
        if (size > xk && this.bgE.size() > (i = size - xk)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bgE.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bgD);
        arrayList.addAll(this.bgE);
        return arrayList;
    }
}
