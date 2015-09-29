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
    private FrsActivity aUU;
    public boolean aZE;
    public int aZF;
    private ArrayList<u> aZG;
    private ArrayList<u> aZH;
    private final com.baidu.adp.framework.listener.a aZI;
    public boolean avB;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.avB = false;
        this.aZE = false;
        this.aZF = 0;
        this.aZG = new ArrayList<>();
        this.aZH = new ArrayList<>();
        this.aZI = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aUU = frsActivity;
    }

    public void registerListener() {
        registerListener(this.aZI);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.aZE = true;
            return;
        }
        String Y = Y(list);
        if (!TextUtils.isEmpty(Y)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(Y);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.avB = true;
        }
    }

    private String Y(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.aZE = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.aZF != 0) {
            if (this.aZF != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.aZE = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.aZE = true;
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
        this.aZF = 0;
        this.aZE = false;
        this.aZG.clear();
        this.aZH.clear();
    }

    public boolean Z(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.aZF == 2 || this.aZE) ? false : true;
        }
        this.aZE = true;
        return false;
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.aZG.clear();
            this.aZH.clear();
        }
        int wo = TbadkCoreApplication.m411getInst().getListItemRule().wo() - this.aZG.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wo) {
                this.aZG.add(arrayList.get(i));
            } else {
                this.aZH.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.aZG);
        arrayList2.addAll(this.aZH);
        return arrayList2;
    }

    public ArrayList<u> MM() {
        int i;
        int size = this.aZH.size() + 30;
        int wn = TbadkCoreApplication.m411getInst().getListItemRule().wn();
        if (size > wn && this.aZH.size() > (i = size - wn)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.aZH.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.aZG);
        arrayList.addAll(this.aZH);
        return arrayList;
    }
}
