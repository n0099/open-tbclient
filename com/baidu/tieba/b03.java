package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.nb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public or3 b;

    /* loaded from: classes5.dex */
    public class a implements nb3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ b03 b;

        public a(b03 b03Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b03Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b03Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.nb3.a
        public void a(nb3 nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nb3Var) == null) {
                b03.d(nb3Var.c(), this.b.a, this.a);
                this.b.b.j();
            }
        }
    }

    public b03(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.startsWith(DownloadConstants.LOCAL_DATA_URI_PREFIX) && !str.startsWith("file://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !e(str)) {
            this.b.e(6, R.string.obfuscated_res_0x7f0f148d);
        }
    }

    public static void d(int i, Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, null, i, activity, str) == null) {
            if (i != 6) {
                if (i != 7) {
                    if (i == 8) {
                        h(activity, str);
                        return;
                    }
                    return;
                }
                f(activity, str);
                return;
            }
            g(activity, str);
        }
    }

    public static void f(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("urls", new JSONArray(new String[]{str}));
                jSONObject.put("type", "0");
                jSONObject.put("index", "0");
            } catch (JSONException e) {
                if (ms1.a) {
                    e.printStackTrace();
                }
            }
            jv2.C().b(activity, jSONObject);
        }
    }

    public static void g(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, activity, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("imageUrl", str);
            jv2.C().f(activity, new JSONObject(hashMap));
        }
    }

    public static void h(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, activity, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("imageUrl", str);
            jv2.C().a(activity, new JSONObject(hashMap));
        }
    }

    public void i(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str) == null) {
            or3 or3Var = this.b;
            if (or3Var != null && or3Var.n()) {
                this.b.j();
            }
            or3 or3Var2 = new or3(view2);
            this.b = or3Var2;
            or3Var2.r(new a(this, str));
            c(str);
            this.b.t();
        }
    }
}
