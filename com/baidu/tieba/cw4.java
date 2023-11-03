package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskUpdateListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes5.dex */
public class cw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public String e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public bz4 j;

    public cw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 1;
        this.i = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("activity_type");
            this.b = jSONObject.optInt("status");
            this.c = jSONObject.optInt(DiskUpdateListener.BEGIN_TIME);
            this.d = jSONObject.optInt("end_time");
            this.e = jSONObject.optString("url");
            this.f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!qd.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.h = JavaTypesHelper.toInt(split[0], 1);
                this.i = JavaTypesHelper.toInt(split[1], 1);
            }
            if (this.h <= 0) {
                this.h = 1;
            }
            if (this.i <= 0) {
                this.i = 1;
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void i(ActInfo actInfo) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, actInfo) != null) || actInfo == null) {
            return;
        }
        Integer num = actInfo.activity_type;
        int i5 = -1;
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        this.a = i;
        Integer num2 = actInfo.status;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = -1;
        }
        this.b = i2;
        Integer num3 = actInfo.begin_time;
        if (num3 != null) {
            i3 = num3.intValue();
        } else {
            i3 = -1;
        }
        this.c = i3;
        Integer num4 = actInfo.end_time;
        if (num4 != null) {
            i4 = num4.intValue();
        } else {
            i4 = -1;
        }
        this.d = i4;
        this.e = actInfo.url;
        Integer num5 = actInfo.total_num;
        if (num5 != null) {
            i5 = num5.intValue();
        }
        this.f = i5;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!qd.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.h = JavaTypesHelper.toInt(split[0], 1);
                this.i = JavaTypesHelper.toInt(split[1], 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.h <= 0) {
            this.h = 1;
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        bz4 bz4Var = new bz4();
        this.j = bz4Var;
        bz4Var.a(actInfo.lottery_senior);
    }
}
