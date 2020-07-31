package com.baidu.tieba.enterForum.data;

import com.baidu.tbadk.core.util.as;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class i {
    private int hhy;
    private String tabCode;
    private String tabName;

    public i(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            this.tabCode = frsTabInfo.tab_code;
            this.tabName = frsTabInfo.tab_name;
            this.hhy = frsTabInfo.tab_version.intValue();
        }
    }

    public int bUJ() {
        return this.hhy;
    }

    public String bUK() {
        return this.tabCode;
    }

    public String getTabName() {
        return this.tabName;
    }

    public boolean a(i iVar) {
        return iVar != null && as.equals(this.tabCode, iVar.tabCode) && as.equals(this.tabName, iVar.tabName);
    }
}
