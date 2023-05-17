package com.baidu.tieba.frs;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class FrsTabItemData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hideWriteEntrance;
    public int isGeneralTab;
    public boolean isNoShowInPublisher;
    public boolean isSelected;
    public String name;
    public String tabCode;
    public int tabId;
    public int tabType;

    public FrsTabItemData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public FrsTabItemData(FrsTabInfo frsTabInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsTabInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = frsTabInfo.tab_name;
        this.tabId = frsTabInfo.tab_id.intValue();
        this.tabType = frsTabInfo.tab_type.intValue();
        this.tabCode = frsTabInfo.tab_code;
        this.isGeneralTab = frsTabInfo.is_general_tab.intValue();
        if (frsTabInfo.is_no_show_publisher.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hideWriteEntrance = z;
        this.isNoShowInPublisher = frsTabInfo.is_no_show_in_publisher.intValue() == 1;
    }
}
