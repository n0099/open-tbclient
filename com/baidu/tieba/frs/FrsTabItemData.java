package com.baidu.tieba.frs;

import java.io.Serializable;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class FrsTabItemData implements Serializable {
    public int isGeneralTab;
    public boolean isSelected;
    public String name;
    public int tabId;

    public FrsTabItemData() {
    }

    public FrsTabItemData(FrsTabInfo frsTabInfo) {
        this.name = frsTabInfo.tab_name;
        this.tabId = frsTabInfo.tab_id.intValue();
        this.isGeneralTab = frsTabInfo.is_general_tab.intValue();
    }
}
