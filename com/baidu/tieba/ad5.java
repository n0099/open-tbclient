package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ad5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;

    public ad5() {
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

    public void a(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        boolean z2 = true;
        if (jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.a = z;
        if (jSONObject.optInt("isActivateNaniApp", 1) != 1) {
            z2 = false;
        }
        this.b = z2;
        this.c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f = jSONObject.optString("downloadNaniTxt", null);
        this.g = jSONObject.optString("showNaniTailTxt", null);
        this.h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
