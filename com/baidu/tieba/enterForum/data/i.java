package com.baidu.tieba.enterForum.data;

import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class i {
    private int iiV;
    private String tabCode;
    private String tabName;

    public i(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            this.tabCode = frsTabInfo.tab_code;
            this.tabName = frsTabInfo.tab_name;
            this.iiV = frsTabInfo.tab_version.intValue();
        }
    }
}
