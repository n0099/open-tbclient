package com.baidu.tieba.enterForum.data;

import com.baidu.tbadk.core.util.aq;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class o {
    private int gAi;
    private String tabCode;
    private String tabName;

    public o(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            this.tabCode = frsTabInfo.tab_code;
            this.tabName = frsTabInfo.tab_name;
            this.gAi = frsTabInfo.tab_version.intValue();
        }
    }

    public int bHZ() {
        return this.gAi;
    }

    public String bIa() {
        return this.tabCode;
    }

    public String getTabName() {
        return this.tabName;
    }

    public boolean a(o oVar) {
        return oVar != null && aq.equals(this.tabCode, oVar.tabCode) && aq.equals(this.tabName, oVar.tabName);
    }
}
