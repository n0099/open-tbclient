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
    public boolean axY;
    private FrsActivity beB;
    public boolean bks;
    public int bkt;
    private ArrayList<u> bku;
    private ArrayList<u> bkv;
    private final com.baidu.adp.framework.listener.a bkw;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.axY = false;
        this.bks = false;
        this.bkt = 0;
        this.bku = new ArrayList<>();
        this.bkv = new ArrayList<>();
        this.bkw = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.beB = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bkw);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bks = true;
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
            this.axY = true;
        }
    }

    private String ah(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bks = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bkt != 0) {
            if (this.bkt != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bks = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bks = true;
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
        this.bkt = 0;
        this.bks = false;
        this.bku.clear();
        this.bkv.clear();
    }

    public boolean ai(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bkt == 2 || this.bks) ? false : true;
        }
        this.bks = true;
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
            this.bku.clear();
            this.bkv.clear();
        }
        int wU = TbadkCoreApplication.m411getInst().getListItemRule().wU() - this.bku.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wU) {
                this.bku.add(arrayList.get(i));
            } else {
                this.bkv.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bku);
        arrayList2.addAll(this.bkv);
        a(eVar, arrayList, arrayList2);
        return arrayList2;
    }

    private void a(com.baidu.tieba.tbadkCore.data.e eVar, List<u> list, List<u> list2) {
        int[] iArr;
        int indexOf;
        if (eVar != null && y.l(list) > 0 && y.l(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.e.dGD) {
                u uVar = (u) y.b(list, i);
                if (uVar != null && (indexOf = list2.indexOf(uVar)) >= 0) {
                    eVar.aX(i, indexOf);
                }
            }
        }
    }

    public ArrayList<u> OT() {
        int i;
        int size = this.bkv.size() + 30;
        int wT = TbadkCoreApplication.m411getInst().getListItemRule().wT();
        if (size > wT && this.bkv.size() > (i = size - wT)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bkv.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bku);
        arrayList.addAll(this.bkv);
        return arrayList;
    }
}
