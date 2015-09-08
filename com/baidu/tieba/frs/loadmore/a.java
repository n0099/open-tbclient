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
    private FrsActivity aVM;
    public boolean aZL;
    public int aZM;
    private ArrayList<u> aZN;
    private ArrayList<u> aZO;
    private final com.baidu.adp.framework.listener.a aZP;
    public boolean axc;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.axc = false;
        this.aZL = false;
        this.aZM = 0;
        this.aZN = new ArrayList<>();
        this.aZO = new ArrayList<>();
        this.aZP = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.aVM = frsActivity;
    }

    public void registerListener() {
        registerListener(this.aZP);
    }

    public void a(long j, List<Long> list) {
        if (j == 0 || list == null || list.size() == 0) {
            this.aZL = true;
            return;
        }
        String X = X(list);
        if (!TextUtils.isEmpty(X)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(X);
            loadMoreRequestMessage.setNeedAbstract(0);
            sendMessage(loadMoreRequestMessage);
            this.axc = true;
        }
    }

    private String X(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.aZL = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.aZM != 0) {
            if (this.aZM != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.aZL = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.aZL = true;
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
        this.aZM = 0;
        this.aZL = false;
        this.aZN.clear();
        this.aZO.clear();
    }

    public boolean Y(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.aZM == 2 || this.aZL) ? false : true;
        }
        this.aZL = true;
        return false;
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.aZN.clear();
            this.aZO.clear();
        }
        int wE = TbadkCoreApplication.m411getInst().getListItemRule().wE() - this.aZN.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < wE) {
                this.aZN.add(arrayList.get(i));
            } else {
                this.aZO.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.aZN);
        arrayList2.addAll(this.aZO);
        return arrayList2;
    }

    public ArrayList<u> MN() {
        int i;
        int size = this.aZO.size() + 30;
        int wD = TbadkCoreApplication.m411getInst().getListItemRule().wD();
        if (size > wD && this.aZO.size() > (i = size - wD)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.aZO.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.aZN);
        arrayList.addAll(this.aZO);
        return arrayList;
    }
}
