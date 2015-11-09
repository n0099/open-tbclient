package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.loadmore.LoadMoreRequestMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.e<FrsGoodActivity> {
    private FrsGoodActivity aWx;
    public boolean auq;
    public boolean bai;
    public int baj;
    private ArrayList<com.baidu.adp.widget.ListView.u> bak;
    private ArrayList<com.baidu.adp.widget.ListView.u> bal;
    private final com.baidu.adp.framework.listener.a bam;

    public v(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.auq = false;
        this.bai = false;
        this.baj = 0;
        this.bak = new ArrayList<>();
        this.bal = new ArrayList<>();
        this.bam = new w(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aWx = frsGoodActivity;
    }

    public void registerListener() {
        registerListener(this.bam);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bai = true;
            return;
        }
        String ab = ab(list);
        if (!TextUtils.isEmpty(ab)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ab);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.auq = true;
        }
    }

    private String ab(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bai = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.baj != 0) {
            if (this.baj != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bai = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bai = true;
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
        this.baj = 0;
        this.bai = false;
        this.bak.clear();
        this.bal.clear();
    }

    public boolean ac(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.baj == 2 || this.bai) ? false : true;
        }
        this.bai = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> a(boolean z, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.bak.clear();
            this.bal.clear();
        }
        int wq = TbadkCoreApplication.m411getInst().getListItemRule().wq() - this.bak.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wq) {
                this.bak.add(arrayList.get(i));
            } else {
                this.bal.add(arrayList.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bak);
        arrayList2.addAll(this.bal);
        return arrayList2;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> MZ() {
        int i;
        int size = this.bal.size() + 30;
        int wp = TbadkCoreApplication.m411getInst().getListItemRule().wp();
        if (size > wp && this.bal.size() > (i = size - wp)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bal.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bak);
        arrayList.addAll(this.bal);
        return arrayList;
    }
}
