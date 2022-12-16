package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.down.manage.Download;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aw3 extends zv3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629548, "Lcom/baidu/tieba/aw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629548, "Lcom/baidu/tieba/aw3;");
                return;
            }
        }
        d = ok1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw3(Download download) {
        super("onSuccess", 0, g(f(download), ""));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {download};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw3(String str) {
        super("onSuccess", 0, g(null, str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw3(Collection<Download> collection) {
        super("onSuccess", 0, g(e(collection), ""));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public static JSONArray e(Collection<Download> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, collection)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (collection == null) {
                return jSONArray;
            }
            for (Download download : collection) {
                if (download != null) {
                    jSONArray.put(f(download));
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONObject f(Download download) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, download)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (download == null) {
                return jSONObject;
            }
            try {
                jSONObject.put("apkId", new nv3(download).c());
                jSONObject.put("downloadId", download.getId());
                jSONObject.put("packageName", download.getKeyByUser());
                jSONObject.put("url", download.getUrl());
                jSONObject.put("status", download.getState().ordinal());
                jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, download.getCurrentbytes());
                jSONObject.put("total", download.getTotalbytes());
                if (pv3.j(download)) {
                    str = "1";
                } else {
                    str = "0";
                }
                jSONObject.put("fileExist", str);
            } catch (JSONException e) {
                if (d) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String g(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", obj);
                jSONObject.put("message", str);
            } catch (JSONException e) {
                if (d) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }
}
