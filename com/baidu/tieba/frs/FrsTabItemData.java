package com.baidu.tieba.frs;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsTabItemData extends OrmObject implements Serializable {
    public int isGeneralTab;
    public boolean isSelected;
    public String name;
    public String tabCode;
    public int tabId;
    public int tabType;

    public FrsTabItemData() {
    }

    public FrsTabItemData(FrsTabInfo frsTabInfo) {
        this.name = frsTabInfo.tab_name;
        this.tabId = frsTabInfo.tab_id.intValue();
        this.tabType = frsTabInfo.tab_type.intValue();
        this.tabCode = frsTabInfo.tab_code;
        this.isGeneralTab = frsTabInfo.is_general_tab.intValue();
    }
}
