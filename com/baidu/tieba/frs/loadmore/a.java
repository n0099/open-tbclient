package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    private FrsActivity aVf;
    public boolean aZP;
    public int aZQ;
    private ArrayList<u> aZR;
    private ArrayList<u> aZS;
    private final com.baidu.adp.framework.listener.a aZT;
    public boolean avC;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.avC = false;
        this.aZP = false;
        this.aZQ = 0;
        this.aZR = new ArrayList<>();
        this.aZS = new ArrayList<>();
        this.aZT = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aVf = frsActivity;
    }

    public void registerListener() {
        registerListener(this.aZT);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.aZP = true;
            return;
        }
        String Y = Y(list);
        if (!TextUtils.isEmpty(Y)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(Y);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.avC = true;
        }
    }

    private String Y(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.aZP = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.aZQ != 0) {
            if (this.aZQ != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.aZP = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.aZP = true;
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
        this.aZQ = 0;
        this.aZP = false;
        this.aZR.clear();
        this.aZS.clear();
    }

    public boolean Z(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.aZQ == 2 || this.aZP) ? false : true;
        }
        this.aZP = true;
        return false;
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.aZR.clear();
            this.aZS.clear();
        }
        int wo = TbadkCoreApplication.m411getInst().getListItemRule().wo() - this.aZR.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wo) {
                this.aZR.add(arrayList.get(i));
            } else {
                this.aZS.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.aZR);
        arrayList2.addAll(this.aZS);
        return arrayList2;
    }

    public ArrayList<u> MM() {
        int i;
        int size = this.aZS.size() + 30;
        int wn = TbadkCoreApplication.m411getInst().getListItemRule().wn();
        if (size > wn && this.aZS.size() > (i = size - wn)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.aZS.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.aZR);
        arrayList.addAll(this.aZS);
        return arrayList;
    }
}
