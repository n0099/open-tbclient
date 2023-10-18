package com.baidu.tieba.frs;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
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

    public void parseJson(@NonNull JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.name = jSONObject.optString("name");
            this.tabId = jSONObject.optInt("tab_id");
            this.tabType = jSONObject.optInt("tab_type");
            this.tabCode = jSONObject.optString("tab_code");
            this.isGeneralTab = jSONObject.optInt("is_general_tab");
            boolean z3 = false;
            if (jSONObject.optInt("is_selected") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isSelected = z;
            if (jSONObject.optInt("hide_write_entrance") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.hideWriteEntrance = z2;
            if (jSONObject.optInt("is_no_show_in_publisher") == 1) {
                z3 = true;
            }
            this.isNoShowInPublisher = z3;
        }
    }

    public JSONObject toJsonObject() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.name);
                jSONObject.put("tab_id", this.tabId);
                jSONObject.put("tab_type", this.tabType);
                jSONObject.put("tab_code", this.tabCode);
                jSONObject.put("is_general_tab", this.isGeneralTab);
                int i3 = 1;
                if (this.isSelected) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("is_selected", i);
                if (this.hideWriteEntrance) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("hide_write_entrance", i2);
                if (!this.isNoShowInPublisher) {
                    i3 = 0;
                }
                jSONObject.put("is_no_show_in_publisher", i3);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
