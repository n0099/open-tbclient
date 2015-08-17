package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.loadmore.LoadMoreRequestMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.e<FrsGoodActivity> {
    private FrsGoodActivity aWu;
    public boolean aZs;
    public int aZt;
    private ArrayList<com.baidu.adp.widget.ListView.u> aZu;
    private ArrayList<com.baidu.adp.widget.ListView.u> aZv;
    private final com.baidu.adp.framework.listener.a aZw;
    public boolean avu;

    public v(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.avu = false;
        this.aZs = false;
        this.aZt = 0;
        this.aZu = new ArrayList<>();
        this.aZv = new ArrayList<>();
        this.aZw = new w(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aWu = frsGoodActivity;
    }

    public void registerListener() {
        registerListener(this.aZw);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.aZs = true;
            return;
        }
        String X = X(list);
        if (!TextUtils.isEmpty(X)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(X);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.avu = true;
        }
    }

    private String X(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.aZs = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.aZt != 0) {
            if (this.aZt != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.aZs = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.aZs = true;
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
        this.aZt = 0;
        this.aZs = false;
        this.aZu.clear();
        this.aZv.clear();
    }

    public boolean Y(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.aZt == 2 || this.aZs) ? false : true;
        }
        this.aZs = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> a(boolean z, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.aZu.clear();
            this.aZv.clear();
        }
        int wy = TbadkCoreApplication.m411getInst().getListItemRule().wy() - this.aZu.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wy) {
                this.aZu.add(arrayList.get(i));
            } else {
                this.aZv.add(arrayList.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.aZu);
        arrayList2.addAll(this.aZv);
        return arrayList2;
    }

    public ArrayList<com.baidu.adp.widget.ListView.u> MN() {
        int i;
        int size = this.aZv.size() + 30;
        int wx = TbadkCoreApplication.m411getInst().getListItemRule().wx();
        if (size > wx && this.aZv.size() > (i = size - wx)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.aZv.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
        arrayList.addAll(this.aZu);
        arrayList.addAll(this.aZv);
        return arrayList;
    }
}
