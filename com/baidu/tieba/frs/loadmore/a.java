package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.ai;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<FrsActivity> {
    private FrsActivity aKd;
    public boolean aNh;
    public int aNi;
    private ArrayList<ai> aNj;
    private ArrayList<ai> aNk;
    private final com.baidu.adp.framework.listener.a aNl;
    public boolean anb;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.anb = false;
        this.aNh = false;
        this.aNi = 0;
        this.aNj = new ArrayList<>();
        this.aNk = new ArrayList<>();
        this.aNl = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aKd = frsActivity;
    }

    public void registerListener() {
        registerListener(this.aNl);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.aNh = true;
            return;
        }
        String U = U(list);
        if (!TextUtils.isEmpty(U)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(U);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.anb = true;
        }
    }

    private String U(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.aNh = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.aNi != 0) {
            if (this.aNi != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.aNh = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.aNh = true;
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

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void resetData() {
        this.aNi = 0;
        this.aNh = false;
        this.aNj.clear();
        this.aNk.clear();
    }

    public boolean V(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.aNi == 2 || this.aNh) ? false : true;
        }
        this.aNh = true;
        return false;
    }

    public ArrayList<ai> a(boolean z, ArrayList<ai> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.aNj.clear();
            this.aNk.clear();
        }
        int uH = TbadkCoreApplication.m411getInst().getListItemRule().uH() - this.aNj.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < uH) {
                this.aNj.add(arrayList.get(i));
            } else {
                this.aNk.add(arrayList.get(i));
            }
        }
        ArrayList<ai> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.aNj);
        arrayList2.addAll(this.aNk);
        return arrayList2;
    }

    public ArrayList<ai> KL() {
        int i;
        int size = this.aNk.size() + 30;
        int uG = TbadkCoreApplication.m411getInst().getListItemRule().uG();
        if (size > uG && this.aNk.size() > (i = size - uG)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.aNk.remove(0);
            }
        }
        ArrayList<ai> arrayList = new ArrayList<>();
        arrayList.addAll(this.aNj);
        arrayList.addAll(this.aNk);
        return arrayList;
    }
}
