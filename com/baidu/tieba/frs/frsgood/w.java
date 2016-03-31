package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.loadmore.LoadMoreRequestMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.e<FrsGoodActivity> {
    public boolean azx;
    private FrsGoodActivity bnM;
    public boolean bsm;
    public int bsn;
    private ArrayList<com.baidu.adp.widget.ListView.u> bso;
    private ArrayList<com.baidu.adp.widget.ListView.u> bsp;
    private final com.baidu.adp.framework.listener.a bsq;

    public w(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.azx = false;
        this.bsm = false;
        this.bsn = 0;
        this.bso = new ArrayList<>();
        this.bsp = new ArrayList<>();
        this.bsq = new x(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bnM = frsGoodActivity;
    }

    public void registerListener() {
        registerListener(this.bsq);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bsm = true;
            return;
        }
        String aj = aj(list);
        if (!TextUtils.isEmpty(aj)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(aj);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            sendMessage(loadMoreRequestMessage);
            this.azx = true;
        }
    }

    private String aj(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bsm = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bsn != 0) {
            if (this.bsn != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bsm = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bsm = true;
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
        this.bsn = 0;
        this.bsm = false;
        this.bso.clear();
        this.bsp.clear();
    }

    public boolean ak(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bsn == 2 || this.bsm) ? false : true;
        }
        this.bsm = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> a(boolean z, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.bso.clear();
            this.bsp.clear();
        }
        int yI = TbadkCoreApplication.m411getInst().getListItemRule().yI() - this.bso.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < yI) {
                this.bso.add(arrayList.get(i));
            } else {
                this.bsp.add(arrayList.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bso);
        arrayList2.addAll(this.bsp);
        return arrayList2;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> SK() {
        int i;
        int size = this.bsp.size() + 30;
        int yH = TbadkCoreApplication.m411getInst().getListItemRule().yH();
        if (size > yH && this.bsp.size() > (i = size - yH)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bsp.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bso);
        arrayList.addAll(this.bsp);
        return arrayList;
    }
}
