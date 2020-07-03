package com.baidu.tieba.enterForum.data;

import com.baidu.tbadk.core.util.ar;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class j {
    private int hbS;
    private String tabCode;
    private String tabName;

    public j(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            this.tabCode = frsTabInfo.tab_code;
            this.tabName = frsTabInfo.tab_name;
            this.hbS = frsTabInfo.tab_version.intValue();
        }
    }

    public int bRw() {
        return this.hbS;
    }

    public String bRx() {
        return this.tabCode;
    }

    public String getTabName() {
        return this.tabName;
    }

    public boolean a(j jVar) {
        return jVar != null && ar.equals(this.tabCode, jVar.tabCode) && ar.equals(this.tabName, jVar.tabName);
    }
}
