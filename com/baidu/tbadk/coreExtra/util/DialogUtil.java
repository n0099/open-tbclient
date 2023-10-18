package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.CustomPushPremissionDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.f85;
import com.baidu.tieba.hz4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.k4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class DialogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PUSH_PERMISSION_DIALOG_DELAY_TIME = 2000;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_AGREE = 4;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_AT = 3;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_COLD_START = 1;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_FANS = 5;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_INTERACTION = 0;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_POST_SUCCESS = 2;
    public static final int PUSH_PERMISSION_DIALOG_SCENE_REPLY = 6;
    public static final int PUSH_PERMISSION_DIALOG_SUBSCRIBE_FRIEND = 7;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ hz4 c;

        public a(TbPageContext tbPageContext, int[] iArr, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, iArr, hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = iArr;
            this.c = hz4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                DialogUtil.jumpSystemNotificationSetting(this.a);
                this.b[0] = 1;
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;
        public final /* synthetic */ hz4 b;

        public b(int[] iArr, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iArr;
            this.b = hz4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a[0] = 2;
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int[] b;

        public c(int i, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), iArr};
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
            this.b = iArr;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                StatisticItem statisticItem = new StatisticItem("c13673");
                statisticItem.param("obj_source", this.a);
                statisticItem.param("obj_type", this.b[0]);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public DialogUtil() {
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

    public static hz4 createAlertDialog(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, hz4.e eVar, hz4.e eVar2) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, eVar2})) == null) {
            if (i >= 0) {
                str = TbadkCoreApplication.getInst().getContext().getString(i);
            } else {
                str = null;
            }
            return createAlertDialog(tbPageContext, str, TbadkCoreApplication.getInst().getContext().getString(i2), TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), eVar, eVar2);
        }
        return (hz4) invokeCommon.objValue;
    }

    public static hz4 createAlertDialog(TbPageContext<?> tbPageContext, String str, String str2, hz4.e eVar, hz4.e eVar2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, str, str2, eVar, eVar2)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
            hz4Var.setTitle(str);
            hz4Var.setMessage(str2);
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, eVar);
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, eVar2);
            hz4Var.create(tbPageContext);
            return hz4Var;
        }
        return (hz4) invokeLLLLL.objValue;
    }

    public static hz4 createAlertDialog(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, hz4.e eVar, hz4.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, str, str2, str3, str4, eVar, eVar2})) == null) {
            if (tbPageContext == null) {
                return null;
            }
            hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
            hz4Var.setTitle(str);
            hz4Var.setMessage(str2);
            hz4Var.setPositiveButton(str3, eVar);
            hz4Var.setNegativeButton(str4, eVar2);
            hz4Var.create(tbPageContext);
            return hz4Var;
        }
        return (hz4) invokeCommon.objValue;
    }

    public static iz4 createListDialog(TbPageContext<?> tbPageContext, int i, CharSequence[] charSequenceArr, iz4.c cVar) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, i, charSequenceArr, cVar)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            iz4 iz4Var = new iz4(tbPageContext.getPageActivity());
            iz4Var.k(i);
            iz4Var.j(charSequenceArr, cVar);
            iz4Var.c(tbPageContext);
            return iz4Var;
        }
        return (iz4) invokeLILL.objValue;
    }

    public static hz4 openPluginForbidden(TbPageContext<?> tbPageContext, int i, hz4.e eVar, hz4.e eVar2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65546, null, tbPageContext, i, eVar, eVar2)) == null) {
            return openPluginForbidden(tbPageContext, i, eVar, eVar2, false);
        }
        return (hz4) invokeLILL.objValue;
    }

    public static iz4 createListDialog(TbPageContext<?> tbPageContext, String str, CharSequence[] charSequenceArr, iz4.c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, tbPageContext, str, charSequenceArr, cVar)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            iz4 iz4Var = new iz4(tbPageContext.getPageActivity());
            iz4Var.l(str);
            iz4Var.j(charSequenceArr, cVar);
            iz4Var.c(tbPageContext);
            return iz4Var;
        }
        return (iz4) invokeLLLL.objValue;
    }

    public static iz4 deleteItem(Context context, iz4.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, cVar)) == null) {
            if (k4.a(context) == null) {
                return null;
            }
            iz4 iz4Var = new iz4(k4.a(context).getPageActivity());
            iz4Var.l(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f2b));
            iz4Var.j(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, cVar);
            iz4Var.c(k4.a(context));
            if (context instanceof Activity) {
                iz4Var.m();
            }
            return iz4Var;
        }
        return (iz4) invokeLL.objValue;
    }

    public static boolean isMIUIUnderV10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
            if (StringUtils.isNull(systemProperty) || JavaTypesHelper.toInt(systemProperty.replace(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ""), 0) >= 10) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void jumpSystemNotificationSetting(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, activity) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && !isMIUIUnderV10()) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
                    intent.putExtra("android.provider.extra.CHANNEL_ID", activity.getApplicationInfo().uid);
                    intent.putExtra("app_package", activity.getPackageName());
                    intent.putExtra("app_uid", activity.getApplicationInfo().uid);
                    activity.startActivity(intent);
                } else {
                    Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
                    intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
                    activity.startActivity(intent2);
                }
            } catch (Exception unused) {
                Intent intent3 = new Intent();
                intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent3);
            }
        }
    }

    public static void jumpSystemNotificationSetting(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, bdPageContext) != null) || bdPageContext == null) {
            return;
        }
        jumpSystemNotificationSetting(bdPageContext.getPageActivity());
    }

    public static hz4 openPluginForbidden(TbPageContext<?> tbPageContext, int i, hz4.e eVar, hz4.e eVar2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{tbPageContext, Integer.valueOf(i), eVar, eVar2, Boolean.valueOf(z)})) == null) {
            if (tbPageContext == null) {
                return null;
            }
            String string = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f13ae);
            String string2 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03d2);
            hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
            hz4Var.setMessage(TbadkCoreApplication.getInst().getContext().getString(i));
            hz4Var.setPositiveButton(string, eVar);
            hz4Var.setNegativeButton(string2, eVar2);
            hz4Var.create(tbPageContext);
            if (z) {
                hz4Var.showNoCheck();
            } else {
                hz4Var.show();
            }
            return hz4Var;
        }
        return (hz4) invokeCommon.objValue;
    }

    public static hz4 openScanResult(Context context, hz4.e eVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, eVar, str)) == null) {
            if (k4.a(context) == null) {
                return null;
            }
            hz4 create = new hz4(k4.a(context).getPageActivity()).setTitle(TbadkCoreApplication.getInst().getContext().getString(R.string.bar_code_result)).setMessage(str).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), eVar).create(k4.a(context));
            if (context instanceof Activity) {
                create.show();
            }
            return create;
        }
        return (hz4) invokeLLL.objValue;
    }

    public static hz4 openScanResultDiscern(Context context, hz4.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, eVar)) == null) {
            if (k4.a(context) == null) {
                return null;
            }
            String string = TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title);
            hz4 create = new hz4(k4.a(context).getPageActivity()).setTitle(string).setMessage(TbadkCoreApplication.getInst().getContext().getString(R.string.msg_album_bug)).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), eVar).create(k4.a(context));
            if (context instanceof Activity) {
                create.show();
            }
            return create;
        }
        return (hz4) invokeLL.objValue;
    }

    public static boolean shouldShowPushPremissionDialog(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, context, i)) == null) {
            boolean z = false;
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            Date date = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_cold_start_key", 0L));
            Date date2 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_interaction_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i == 0 && TimeHelper.getDayDifference(date3, date2) >= 7 && !TimeHelper.isSameDay(date3, date)) {
                z = true;
            }
            if (i == 1 && TimeHelper.getDayDifference(date3, date) >= 7 && !TimeHelper.isSameDay(date3, date2)) {
                z = true;
            }
            if (z) {
                if (i != 0) {
                    if (i == 1) {
                        SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                    }
                } else {
                    SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public static hz4 openUrl(TbPageContext<?> tbPageContext, hz4.e eVar, hz4.e eVar2, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, tbPageContext, eVar, eVar2, str)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            hz4 create = new hz4(tbPageContext.getPageActivity()).setTitle(TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title)).setMessage(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str)).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), eVar).setNegativeButton(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03d2), eVar2).create(tbPageContext);
            create.show();
            return create;
        }
        return (hz4) invokeLLLL.objValue;
    }

    public static void showNotificationPermissionDialog(TbPageContext<?> tbPageContext, boolean[] zArr, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65552, null, tbPageContext, zArr, i) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && zArr != null && zArr.length == 2) {
            showPushPermissionDialog(tbPageContext, i, 0L);
        }
    }

    public static void showPushPermissionDialog(TbPageContext<?> tbPageContext, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{tbPageContext, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            hz4 hz4Var = new hz4(tbPageContext.getPageActivity());
            hz4Var.setCancelable(false);
            hz4Var.setPositiveButton((String) null, (hz4.e) null);
            hz4Var.setNegativeButton((String) null, (hz4.e) null);
            hz4Var.setContentViewSize(4);
            CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
            hz4Var.setContentView(customPushPremissionDialogView);
            int[] iArr = {-1};
            customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new a(tbPageContext, iArr, hz4Var));
            customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new b(iArr, hz4Var));
            hz4Var.setOnDismissListener(new c(i, iArr));
            if (j > 0) {
                hz4Var.create(tbPageContext).show(j);
            } else {
                hz4Var.create(tbPageContext).show();
            }
            StatisticItem statisticItem = new StatisticItem("c13674");
            statisticItem.param("obj_source", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean showPushPermissionDialog(Context context, int i) {
        InterceptResult invokeLI;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, context, i)) == null) {
            f85 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            if (pushStrategyConfig != null && pushStrategyConfig.d()) {
                i2 = pushStrategyConfig.b();
            } else {
                i2 = 0;
            }
            if (i2 <= 0) {
                i2 = 3;
            }
            Date date = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_post_success_start_key", 0L));
            Date date2 = new Date(SharedPrefHelper.getInstance().getLong("push_permission_dialog_scene_all_item_tab_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            boolean z2 = true;
            if (i == 2 && TimeHelper.getDayDifference(date3, date) >= i2) {
                z = true;
            } else {
                z = false;
            }
            if ((i != 3 && i != 4 && i != 5 && i != 6 && i != 7) || TimeHelper.getDayDifference(date3, date2) < i2) {
                z2 = z;
            }
            if (z2) {
                switch (i) {
                    case 2:
                        SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_post_success_start_key", currentTimeMillis);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        SharedPrefHelper.getInstance().putLong("push_permission_dialog_scene_all_item_tab_key", currentTimeMillis);
                        break;
                }
            }
            return z2;
        }
        return invokeLI.booleanValue;
    }
}
