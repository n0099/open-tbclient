package com.baidu.tieba;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.retrieve.YaLogInitManager;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.log.TbLogManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ti.d().h(SwanKV.LIB_CPP_SHARED, 2);
            YaLogInitManager.getInstance().initYaLog(true, true, true, String.valueOf(10773430L));
            TbLogManager.initTbUbcLog(new gna());
            c();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            String w = o95.p().w("key_ubc_yalog_config", "");
            if (TextUtils.isEmpty(w)) {
                return;
            }
            try {
                ((oza) ServiceManager.getService(oza.a)).a(new JSONObject(w));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            YaLogInitManager.getInstance().initYaLogBaseContext(application);
        }
    }
}
