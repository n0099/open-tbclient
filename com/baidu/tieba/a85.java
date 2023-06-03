package com.baidu.tieba;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes4.dex */
public class a85 {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferences a = null;
    public static boolean b = false;
    public static String c = null;
    public static int d = 0;
    public static String e = null;
    public static int f = 99;
    public static int g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947569067, "Lcom/baidu/tieba/a85;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947569067, "Lcom/baidu/tieba/a85;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            g(TbadkCoreApplication.getInst());
            h();
            int i = 1;
            if (g >= 1) {
                i = 2;
            }
            c("c14483", 0, i);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, null) == null) && g < 0) {
            g = l95.m().n("app_restart_times", 0);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            e = c;
            f = d;
            q();
        }
    }

    public static void b(Context context) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (g < 0) {
                g = context.getSharedPreferences(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, 0).getInt("app_restart_times", 0);
            }
            g(context);
            if (g < 1) {
                i = 1;
            } else {
                i = 2;
            }
            d("c14429", 1, i);
        }
    }

    public static void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j) == null) {
            h();
            int i = 2;
            StatisticItem addParam = new StatisticItem("c14429").addParam("obj_type", 2);
            if (g < 1) {
                i = 1;
            }
            TiebaStatic.log(addParam.addParam("obj_source", i).addParam(TiebaStatic.Params.OBJ_PARAM2, j));
        }
    }

    public static void c(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) {
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void d(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            String str2 = str + "_lastTime";
            long j = a.getLong(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j)));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.putLong(str2, currentTimeMillis);
            edit.commit();
        }
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = "";
            if (f == 99) {
                String c2 = ep5.c();
                if (ui.isEmpty(c2)) {
                    return "";
                }
                return c2;
            }
            if (!StringUtils.isNull(e)) {
                str = e;
            }
            return ui.getUrlEncode(str);
        }
        return (String) invokeV.objValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            h();
            StatisticItem statisticItem = new StatisticItem("c14484");
            int i = 1;
            if (g >= 1) {
                i = 2;
            }
            TiebaStatic.log(statisticItem.addParam("obj_source", i).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
        }
    }

    public static void l() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_type", e85.a().b());
            if (e85.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(addParam.addParam("obj_param1", i).addParam("obj_source", 6));
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            h();
            g(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            p("c14429", edit);
            p("c14483", edit);
            p("c14482", edit);
            a = null;
        }
    }

    public static String f(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (dataString != null && dataString.startsWith(ExceptionHandlerImpl.KEY_CUSTOM)) {
                StringBuilder sb = new StringBuilder();
                sb.append(dataString);
                sb.append(".action.");
                sb.append(intent.getAction());
                if (intent.getCategories() != null) {
                    sb.append("categories.");
                    for (String str : intent.getCategories()) {
                        sb.append(str);
                        sb.append(".");
                    }
                }
                return sb.toString();
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    public static void t(Activity activity) {
        ActivityManager activityManager;
        ActivityManager.AppTask appTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, activity) == null) && activity != null && activity.getClass() != null && Build.VERSION.SDK_INT >= 23 && (activityManager = (ActivityManager) activity.getSystemService("activity")) != null && (appTask = (ActivityManager.AppTask) ListUtils.getItem(activityManager.getAppTasks(), 0)) != null && appTask.getTaskInfo() != null && appTask.getTaskInfo().baseActivity != null && activity.getClass().getName().equals(appTask.getTaskInfo().baseActivity.getClassName())) {
            String f2 = f(appTask.getTaskInfo().baseIntent);
            r(f2, ui.isEmpty(f2));
            v();
        }
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void k(String str, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            h();
            StatisticItem statisticItem = new StatisticItem("c14430");
            int i3 = 2;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem addParam = statisticItem.addParam("obj_type", i);
            if (g < 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_source", i2);
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                i3 = 1;
            }
            TiebaStatic.log(addParam2.addParam("obj_param1", i3).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
        }
    }

    public static void s(AppLaunchInfoFetcher.Type type, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65555, null, type, intent) != null) || f < 99) {
            return;
        }
        if (type == AppLaunchInfoFetcher.Type.BROADCAST) {
            d = 98;
            c = "CallReceiver";
        } else if (type == AppLaunchInfoFetcher.Type.SERVICE) {
            d = 98;
            c = "CallService";
        } else if (type == AppLaunchInfoFetcher.Type.ACTIVITY) {
            if (intent != null) {
                String dataString = intent.getDataString();
                r(dataString, ui.isEmpty(dataString));
            } else {
                u("intent=null", 100);
            }
        } else {
            d = 101;
            c = "START_TYPE_FOR_UNKNOWN";
        }
        v();
    }

    public static void m(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", e85.a().b());
            if (e85.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_param1", i).addParam("obj_source", 8);
            if (e85.a().b() != 3) {
                addParam2.addParam(TiebaStatic.Params.OBJ_PARAM2, e());
            }
            TiebaStatic.log(addParam2);
        }
    }

    public static void n(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", e85.a().b());
            if (e85.a().d()) {
                i = 1;
            } else {
                i = 2;
            }
            StatisticItem addParam2 = addParam.addParam("obj_param1", i).addParam("obj_source", 7);
            if (e85.a().b() != 3) {
                addParam2.addParam(TiebaStatic.Params.OBJ_PARAM2, e());
            }
            TiebaStatic.log(addParam2);
        }
    }

    public static void p(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, str, editor) != null) || (stringSet = a.getStringSet(str, null)) == null) {
            return;
        }
        for (String str2 : stringSet) {
            String[] split = str2.split("_");
            if (split != null) {
                if (split.length == 3) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]));
                } else if (split.length == 4) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]).addParam(TiebaStatic.Params.OBJ_PARAM4, split[3]));
                }
            }
        }
        editor.remove(str).apply();
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("start_type", f + "");
            hashMap.put("start_scheme", e());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65554, null, str, z) == null) {
            c = str;
            d = z ? 1 : 0;
        }
    }

    @Deprecated
    public static void u(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, str, i) == null) {
            int i2 = f;
            if (i2 == 99 || i2 == 100) {
                d = i;
                c = str;
                v();
            }
        }
    }
}
