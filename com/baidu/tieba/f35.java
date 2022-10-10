package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.CustomPushPremissionDialogView;
import com.baidu.tieba.nu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes4.dex */
public class f35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ nu4 c;

        public a(TbPageContext tbPageContext, int[] iArr, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, iArr, nu4Var};
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
            this.c = nu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                f35.e(this.a);
                this.b[0] = 1;
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;
        public final /* synthetic */ nu4 b;

        public b(int[] iArr, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iArr, nu4Var};
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
            this.b = nu4Var;
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

    /* loaded from: classes4.dex */
    public static class c implements DialogInterface.OnDismissListener {
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

    public static nu4 a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, nu4.e eVar, nu4.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, eVar2})) == null) {
            return b(tbPageContext, i >= 0 ? TbadkCoreApplication.getInst().getContext().getString(i) : null, TbadkCoreApplication.getInst().getContext().getString(i2), TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), eVar, eVar2);
        }
        return (nu4) invokeCommon.objValue;
    }

    public static nu4 b(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, nu4.e eVar, nu4.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, str, str2, str3, str4, eVar, eVar2})) == null) {
            if (tbPageContext == null) {
                return null;
            }
            nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
            nu4Var.setTitle(str);
            nu4Var.setMessage(str2);
            nu4Var.setPositiveButton(str3, eVar);
            nu4Var.setNegativeButton(str4, eVar2);
            nu4Var.create(tbPageContext);
            return nu4Var;
        }
        return (nu4) invokeCommon.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
            return !StringUtils.isNull(systemProperty) && dh.e(systemProperty.replace("V", ""), 0) < 10;
        }
        return invokeV.booleanValue;
    }

    public static void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = activity instanceof BaseActivity ? ((BaseActivity) activity).getPageContext() : null;
            if (activity instanceof BaseFragmentActivity) {
                pageContext = ((BaseFragmentActivity) activity).getPageContext();
            }
            if (pageContext != null) {
                e(pageContext);
            }
        }
    }

    public static void e(r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, r9Var) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && !c()) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", r9Var.getPageActivity().getPackageName());
                    intent.putExtra("android.provider.extra.CHANNEL_ID", r9Var.getPageActivity().getApplicationInfo().uid);
                    intent.putExtra("app_package", r9Var.getPageActivity().getPackageName());
                    intent.putExtra("app_uid", r9Var.getPageActivity().getApplicationInfo().uid);
                    r9Var.getPageActivity().startActivity(intent);
                } else {
                    Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
                    intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    intent2.setData(Uri.fromParts("package", r9Var.getPageActivity().getPackageName(), null));
                    r9Var.getPageActivity().startActivity(intent2);
                }
            } catch (Exception unused) {
                Intent intent3 = new Intent();
                intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.setData(Uri.fromParts("package", r9Var.getPageActivity().getPackageName(), null));
                r9Var.getPageActivity().startActivity(intent3);
            }
        }
    }

    public static nu4 f(TbPageContext<?> tbPageContext, nu4.e eVar, nu4.e eVar2, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, tbPageContext, eVar, eVar2, str)) == null) {
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            nu4 create = new nu4(tbPageContext.getPageActivity()).setTitle(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f043e)).setMessage(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f14fa), str)).setPositiveButton(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f026a), eVar).setNegativeButton(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0375), eVar2).create(tbPageContext);
            create.show();
            return create;
        }
        return (nu4) invokeLLLL.objValue;
    }

    public static boolean g(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            boolean z = false;
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return false;
            }
            Date date = new Date(ox4.k().m("push_permission_dialog_scene_cold_start_key", 0L));
            Date date2 = new Date(ox4.k().m("push_permission_dialog_scene_interaction_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i == 0 && TimeHelper.getDayDifference(date3, date2) >= 7 && !TimeHelper.isSameDay(date3, date)) {
                z = true;
            }
            if (i == 1 && TimeHelper.getDayDifference(date3, date) >= 7 && !TimeHelper.isSameDay(date3, date2)) {
                z = true;
            }
            if (z) {
                if (i == 0) {
                    ox4.k().x("push_permission_dialog_scene_interaction_key", currentTimeMillis);
                } else if (i == 1) {
                    ox4.k().x("push_permission_dialog_scene_cold_start_key", currentTimeMillis);
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    public static void h(TbPageContext<?> tbPageContext, boolean[] zArr, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, tbPageContext, zArr, i) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || zArr == null || zArr.length != 2) {
            return;
        }
        i(tbPageContext, i, 0L);
    }

    public static void i(TbPageContext<?> tbPageContext, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{tbPageContext, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            nu4 nu4Var = new nu4(tbPageContext.getPageActivity());
            nu4Var.setCancelable(false);
            nu4Var.setPositiveButton((String) null, (nu4.e) null);
            nu4Var.setNegativeButton((String) null, (nu4.e) null);
            nu4Var.setContentViewSize(4);
            CustomPushPremissionDialogView customPushPremissionDialogView = new CustomPushPremissionDialogView(tbPageContext.getPageActivity());
            nu4Var.setContentView(customPushPremissionDialogView);
            int[] iArr = {-1};
            customPushPremissionDialogView.getPushPermissionDialogConfirmButton().setOnClickListener(new a(tbPageContext, iArr, nu4Var));
            customPushPremissionDialogView.getPushPermissionDialogCancelButton().setOnClickListener(new b(iArr, nu4Var));
            nu4Var.setOnDismissListener(new c(i, iArr));
            if (j > 0) {
                nu4Var.create(tbPageContext).show(j);
            } else {
                nu4Var.create(tbPageContext).show();
            }
            StatisticItem statisticItem = new StatisticItem("c13674");
            statisticItem.param("obj_source", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean j(Context context, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            r15 pushStrategyConfig = TbSingleton.getInstance().getPushStrategyConfig();
            boolean z = false;
            int b2 = (pushStrategyConfig == null || !pushStrategyConfig.d()) ? 0 : pushStrategyConfig.b();
            if (b2 <= 0) {
                b2 = 3;
            }
            if (NotificationManagerCompat.from(context).areNotificationsEnabled() && k25.d().e && k25.d().f) {
                return false;
            }
            Date date = new Date(ox4.k().m("push_permission_dialog_scene_post_success_start_key", 0L));
            Date date2 = new Date(ox4.k().m("push_permission_dialog_scene_all_item_tab_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date3 = new Date(currentTimeMillis);
            if (i == 2 && TimeHelper.getDayDifference(date3, date) >= b2) {
                z = true;
            }
            if (i == 3 || i == 4 || i == 5 || i == 6) {
                long dayDifference = TimeHelper.getDayDifference(date3, date2);
                str = "push_permission_dialog_scene_post_success_start_key";
                if (dayDifference >= b2) {
                    z = true;
                }
            } else {
                str = "push_permission_dialog_scene_post_success_start_key";
            }
            if (z) {
                if (i == 2) {
                    ox4.k().x(str, currentTimeMillis);
                } else if (i == 3 || i == 4 || i == 5 || i == 6) {
                    ox4.k().x("push_permission_dialog_scene_all_item_tab_key", currentTimeMillis);
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }
}
