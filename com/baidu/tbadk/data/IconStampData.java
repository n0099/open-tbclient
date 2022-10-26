package com.baidu.tbadk.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IconStampData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADVANCED_USER_POST = 3;
    public static final int ADVANCED_USER_REPLY = 4;
    public static final int NEW_USER_POST = 1;
    public static final int NEW_USER_REPLY = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String stampText;
    public String stampTitle;
    public int stampType;

    public IconStampData() {
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

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.stampTitle = jSONObject.optString("stamp_title", "");
        this.stampText = jSONObject.optString("stamp_text", "");
        this.stampType = jSONObject.optInt("stamp_type", 1);
    }
}
