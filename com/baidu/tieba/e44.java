package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e44 extends ji3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;

    public e44() {
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
        this.k = "";
    }

    @Override // com.baidu.tieba.ji3
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                this.h.put("error_code", this.k);
            } catch (JSONException e) {
                if (ji3.j) {
                    e.printStackTrace();
                }
            }
            if (ji3.j) {
                Log.d("SwanGameAdEvent", "SwanGameAdEvent: mExt=" + this.h + "\t " + Thread.currentThread().getId());
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
