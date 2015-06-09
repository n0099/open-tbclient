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
    private FrsActivity aMl;
    public boolean aPu;
    public int aPv;
    private ArrayList<ai> aPw;
    private ArrayList<ai> aPx;
    private final com.baidu.adp.framework.listener.a aPy;
    public boolean aoe;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aoe = false;
        this.aPu = false;
        this.aPv = 0;
        this.aPw = new ArrayList<>();
        this.aPx = new ArrayList<>();
        this.aPy = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aMl = frsActivity;
    }

    public void registerListener() {
        registerListener(this.aPy);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.aPu = true;
            return;
        }
        String X = X(list);
        if (!TextUtils.isEmpty(X)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(X);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.aoe = true;
        }
    }

    private String X(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.aPu = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.aPv != 0) {
            if (this.aPv != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.aPu = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.aPu = true;
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
        this.aPv = 0;
        this.aPu = false;
        this.aPw.clear();
        this.aPx.clear();
    }

    public boolean Y(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.aPv == 2 || this.aPu) ? false : true;
        }
        this.aPu = true;
        return false;
    }

    public ArrayList<ai> a(boolean z, ArrayList<ai> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.aPw.clear();
            this.aPx.clear();
        }
        int vr = TbadkCoreApplication.m411getInst().getListItemRule().vr() - this.aPw.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < vr) {
                this.aPw.add(arrayList.get(i));
            } else {
                this.aPx.add(arrayList.get(i));
            }
        }
        ArrayList<ai> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.aPw);
        arrayList2.addAll(this.aPx);
        return arrayList2;
    }

    public ArrayList<ai> LR() {
        int i;
        int size = this.aPx.size() + 30;
        int vq = TbadkCoreApplication.m411getInst().getListItemRule().vq();
        if (size > vq && this.aPx.size() > (i = size - vq)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.aPx.remove(0);
            }
        }
        ArrayList<ai> arrayList = new ArrayList<>();
        arrayList.addAll(this.aPw);
        arrayList.addAll(this.aPx);
        return arrayList;
    }
}
