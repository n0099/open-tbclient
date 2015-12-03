package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.loadmore.LoadMoreRequestMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.e<FrsGoodActivity> {
    public boolean awu;
    private FrsGoodActivity bcs;
    public boolean bgB;
    public int bgC;
    private ArrayList<com.baidu.adp.widget.ListView.u> bgD;
    private ArrayList<com.baidu.adp.widget.ListView.u> bgE;
    private final com.baidu.adp.framework.listener.a bgF;

    public v(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.awu = false;
        this.bgB = false;
        this.bgC = 0;
        this.bgD = new ArrayList<>();
        this.bgE = new ArrayList<>();
        this.bgF = new w(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bcs = frsGoodActivity;
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

    public ArrayList<com.baidu.adp.widget.ListView.u> a(boolean z, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bgD);
        arrayList2.addAll(this.bgE);
        return arrayList2;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> OB() {
        int i;
        int size = this.bgE.size() + 30;
        int xk = TbadkCoreApplication.m411getInst().getListItemRule().xk();
        if (size > xk && this.bgE.size() > (i = size - xk)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bgE.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bgD);
        arrayList.addAll(this.bgE);
        return arrayList;
    }
}
