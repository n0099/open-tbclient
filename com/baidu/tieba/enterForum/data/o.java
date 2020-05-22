package com.baidu.tieba.enterForum.data;

import com.baidu.tbadk.core.util.aq;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class o {
    private int gOY;
    private String tabCode;
    private String tabName;

    public o(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            this.tabCode = frsTabInfo.tab_code;
            this.tabName = frsTabInfo.tab_name;
            this.gOY = frsTabInfo.tab_version.intValue();
        }
    }

    public int bOr() {
        return this.gOY;
    }

    public String bOs() {
        return this.tabCode;
    }

    public String getTabName() {
        return this.tabName;
    }

    public boolean a(o oVar) {
        return oVar != null && aq.equals(this.tabCode, oVar.tabCode) && aq.equals(this.tabName, oVar.tabName);
    }
}
