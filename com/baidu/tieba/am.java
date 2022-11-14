package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.AbstractMap;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class am {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public abstract String a();

    public am() {
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
        this.a = false;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.a) {
            return;
        }
        this.a = true;
        if (TextUtils.isEmpty(a())) {
            return;
        }
        try {
            new JSONObject().put("version", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String a = a();
            if (TextUtils.isEmpty(a)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(j)));
            String str = a + "_download";
            if (i == 0) {
                zl.c(str, arrayList);
            } else {
                zl.b(str, arrayList);
            }
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            String a = a();
            if (TextUtils.isEmpty(a)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(i2)));
            String str = a + "_install";
            if (i == 13) {
                zl.c(str, arrayList);
            } else {
                zl.b(str, arrayList);
            }
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            String a = a();
            if (TextUtils.isEmpty(a)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(i2)));
            String str = a + "_launch";
            if (i == 14) {
                zl.c(str, arrayList);
            } else {
                zl.b(str, arrayList);
            }
        }
    }
}
