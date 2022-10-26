package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.TaskInfo;
/* loaded from: classes3.dex */
public class bu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public String g;
    public int h;
    public int i;
    public String j;

    public bu4() {
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

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b + "";
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c + "";
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d + "";
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
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
            return this.h;
        }
        return invokeV.intValue;
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, jSONObject) != null) || jSONObject == null) {
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
            this.g = jSONObject.optString("thread_img");
            String optString = jSONObject.optString("thread_img_size");
            if (optString != null && optString.length() > 0) {
                String[] split = optString.split(",");
                if (split.length > 1) {
                    this.h = Integer.valueOf(split[0]).intValue();
                    this.i = Integer.valueOf(split[1]).intValue();
                }
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

    public void l(TaskInfo taskInfo) {
        long j;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, taskInfo) != null) || taskInfo == null) {
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
        this.g = taskInfo.thread_img;
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
        String str2 = taskInfo.thread_img_size;
        if (str2 != null) {
            try {
                String[] split = str2.split(",");
                this.h = eh.e(split[0], 1);
                this.i = eh.e(split[1], 1);
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
        this.j = taskInfo.obj_id;
    }
}
