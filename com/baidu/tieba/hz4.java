package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes6.dex */
public class hz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public String n;
    public int o;
    public uz4 p;
    public bz4 q;
    public String r;
    public boolean s;

    public hz4() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b + "";
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public bz4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (bz4) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c + "";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d + "";
        }
        return (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public uz4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.p;
        }
        return (uz4) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public void s(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("forum_name");
            this.b = jSONObject.optLong("forum_id");
            this.c = jSONObject.optLong("task_id");
            this.d = jSONObject.optLong("thread_id");
            jSONObject.optString("bgimg");
            this.e = jSONObject.optLong("start_time");
            this.f = jSONObject.optLong("end_time");
            this.k = jSONObject.optString("thread_img");
            this.o = jSONObject.optInt("card_type");
            this.g = jSONObject.optString("theme_color");
            this.h = jSONObject.optString("top_background_img");
            this.i = jSONObject.optString("webview_url");
            this.j = jSONObject.optString("webview_data");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.l = Integer.valueOf(split[0]).intValue();
                    this.m = Integer.valueOf(split[1]).intValue();
                }
            }
            if (this.l <= 0) {
                this.l = 1;
            }
            if (this.m <= 0) {
                this.m = 1;
            }
            this.n = jSONObject.optString("obj_id");
            this.o = jSONObject.optInt("card_type");
            this.p = uz4.a(jSONObject.optJSONObject("vote_schema"));
            this.q = bz4.n(jSONObject.optJSONObject("reward_card"));
            this.r = jSONObject.optString("wh_rate");
            this.i = jSONObject.optString("webview_url");
            this.j = jSONObject.optString("webview_data");
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void t(TaskInfo taskInfo) {
        long j;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, taskInfo) != null) || taskInfo == null) {
            return;
        }
        this.a = taskInfo.forum_name;
        this.b = taskInfo.forum_id.longValue();
        Long l = taskInfo.task_id;
        long j4 = -1;
        if (l != null) {
            j = l.longValue();
        } else {
            j = -1;
        }
        this.c = j;
        Long l2 = taskInfo.thread_id;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = -1;
        }
        this.d = j2;
        String str = taskInfo.bgimg;
        this.k = taskInfo.thread_img;
        Long l3 = taskInfo.start_time;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = -1;
        }
        this.e = j3;
        Long l4 = taskInfo.end_time;
        if (l4 != null) {
            j4 = l4.longValue();
        }
        this.f = j4;
        this.g = taskInfo.theme_color;
        this.h = taskInfo.top_background_img;
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.l = JavaTypesHelper.toInt(split[0], 1);
                this.m = JavaTypesHelper.toInt(split[1], 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.l <= 0) {
            this.l = 1;
        }
        if (this.m <= 0) {
            this.m = 1;
        }
        this.n = taskInfo.obj_id;
        this.o = taskInfo.card_type.intValue();
        this.p = uz4.b(taskInfo.vote_schema);
        this.q = bz4.o(taskInfo.reward_card);
        this.r = taskInfo.wh_rate;
        this.i = taskInfo.webview_url;
        this.j = taskInfo.webview_data;
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.f = j;
        }
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.e = j;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
        }
    }
}
