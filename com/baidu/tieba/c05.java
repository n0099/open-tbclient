package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.vr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ DialogInterface.OnCancelListener c;

        public a(int i, Context context, DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = context;
            this.c = onCancelListener;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                c05.d(this.a, this.b);
                vr4Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.c;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(vr4Var.getDialog());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DialogInterface.OnCancelListener a;

        public b(DialogInterface.OnCancelListener onCancelListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onCancelListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onCancelListener;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                vr4Var.dismiss();
                DialogInterface.OnCancelListener onCancelListener = this.a;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(vr4Var.getDialog());
                }
            }
        }
    }

    public static boolean b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            if (i == 3 || i == 2) {
                return lk8.b(context, "com.tencent.mm");
            }
            if (i == 8 || i == 4) {
                return lk8.b(context, "com.tencent.mobileqq");
            }
            if (i == 6) {
                return lk8.b(context, "com.sina.weibo");
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static String c(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, context)) == null) {
            if (i == 3 || i == 2) {
                return String.format(context.getString(R.string.obfuscated_res_0x7f0f0407), context.getString(R.string.obfuscated_res_0x7f0f159e));
            }
            if (i == 8 || i == 4) {
                return String.format(context.getString(R.string.obfuscated_res_0x7f0f0407), context.getString(R.string.obfuscated_res_0x7f0f0f61));
            }
            if (i == 6) {
                return String.format(context.getString(R.string.obfuscated_res_0x7f0f0407), context.getString(R.string.obfuscated_res_0x7f0f11a0));
            }
            return null;
        }
        return (String) invokeIL.objValue;
    }

    public static void d(int i, Context context) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, context) == null) {
            if (i == 3 || i == 2) {
                if (!b(context, i)) {
                    BdToast.b(context.getApplicationContext(), context.getText(R.string.obfuscated_res_0x7f0f116a)).i();
                    return;
                }
                intent = new Intent("android.intent.action.MAIN");
                ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setComponent(componentName);
                context.startActivity(intent);
            } else if (i == 8 || i == 4) {
                if (!b(context, i)) {
                    BdToast.b(context.getApplicationContext(), context.getText(R.string.obfuscated_res_0x7f0f114c)).i();
                    return;
                }
                intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                context.startActivity(intent);
            } else if (i != 6) {
                intent = null;
            } else if (!b(context, i)) {
                BdToast.b(context.getApplicationContext(), context.getText(R.string.obfuscated_res_0x7f0f115b)).i();
                return;
            } else {
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("sinaweibo://splash"));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            if (intent != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void e(ShareItem shareItem, Context context, int i, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, shareItem, context, i, onCancelListener) == null) || shareItem == null || TextUtils.isEmpty(shareItem.v) || TextUtils.isEmpty(shareItem.u) || !(context instanceof Activity)) {
            return;
        }
        gi.a(shareItem.A0);
        Activity activity = (Activity) context;
        vr4 vr4Var = new vr4(activity);
        vr4Var.setTitle(context.getString(R.string.obfuscated_res_0x7f0f0408));
        vr4Var.setMessage(shareItem.A0);
        vr4Var.setAutoNight(false);
        vr4Var.setCancelable(true);
        vr4Var.setTitleShowCenter(true);
        vr4Var.setPositiveButton(c(i, context), new a(i, context, onCancelListener));
        vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new b(onCancelListener)).create(i9.a(activity));
        if (onCancelListener != null) {
            vr4Var.setOnCalcelListener(onCancelListener);
        }
        vr4Var.show();
    }
}
