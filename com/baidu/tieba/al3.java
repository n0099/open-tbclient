package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.c23;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class al3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || (bVar = this.a) == null) {
                return;
            }
            bVar.onResult(i == -1);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onResult(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947618977, "Lcom/baidu/tieba/al3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947618977, "Lcom/baidu/tieba/al3;");
                return;
            }
        }
        a = ij1.a;
        b = new String[]{"BLA-AL00", "R7Plus"};
    }

    public static DialogInterface.OnClickListener a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) ? new a(bVar) : (DialogInterface.OnClickListener) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            String packageName = context.getPackageName();
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            context.startActivity(intent);
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (!Arrays.asList(b).contains(Build.MODEL)) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                int i = Build.VERSION.SDK_INT;
                if (i >= 26) {
                    intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                } else if (i >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    intent.putExtra("app_uid", context.getApplicationInfo().uid);
                }
                try {
                    context.startActivity(intent);
                    return;
                } catch (Exception e) {
                    if (a) {
                        Log.e("GuideHelper", "openNotificationSettingPages() Exception:" + e);
                    }
                    c(context);
                    return;
                }
            }
            c(context);
        }
    }

    public static void e(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, bVar) == null) {
            if (!(context instanceof Activity)) {
                if (a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
            } else if (bVar == null) {
            } else {
                DialogInterface.OnClickListener a2 = a(bVar);
                c23.a aVar = new c23.a(context);
                aVar.n(new gi3());
                c23 c = aVar.c();
                aVar.U(R.string.obfuscated_res_0x7f0f125b);
                aVar.x(context.getString(R.string.obfuscated_res_0x7f0f125a));
                aVar.y();
                aVar.J(fm2.M().a());
                aVar.O(R.string.obfuscated_res_0x7f0f125c, a2);
                aVar.B(R.string.obfuscated_res_0x7f0f1259, a2);
                aVar.a();
                c.setCancelable(false);
                c.show();
            }
        }
    }
}
