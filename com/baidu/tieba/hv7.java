package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.frs.view.FrsBroadcastCopyGuideDialogView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class hv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ View c;
        public final /* synthetic */ eh7 d;

        public a(s45 s45Var, BaseFragment baseFragment, View view2, eh7 eh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s45Var, baseFragment, view2, eh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
            this.b = baseFragment;
            this.c = view2;
            this.d = eh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            s45 s45Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (s45Var = this.a) != null) {
                s45Var.dismiss();
                hv7.f(this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements zz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ eh7 c;

        public b(View view2, BaseFragment baseFragment, eh7 eh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseFragment, eh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = baseFragment;
            this.c = eh7Var;
        }

        @Override // com.baidu.tieba.zz4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    xk5.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    View view2 = this.a;
                    if (view2 != null) {
                        view2.setVisibility(8);
                        return;
                    }
                    return;
                }
                new BdTopToast(this.b.getContext()).setIcon(false).setContent(this.b.getString(R.string.obfuscated_res_0x7f0f0780)).show(this.c.r0());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements zz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public c(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // com.baidu.tieba.zz4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                xk5.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                View view2 = this.a;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public static void b(BaseFragment baseFragment, String str, boolean z, View view2, eh7 eh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2, eh7Var}) == null) && baseFragment != null && eh7Var != null && view2 != null && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(str) && !z) {
            int i = SharedPrefHelper.getInstance().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                SharedPrefHelper.getInstance().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                e(baseFragment, view2, eh7Var);
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    f(baseFragment, view2, eh7Var);
                } else {
                    new BdTopToast(baseFragment.getContext()).setIcon(false).setContent(baseFragment.getString(R.string.obfuscated_res_0x7f0f0780)).show(eh7Var.r0());
                }
            } else {
                f(baseFragment, view2, eh7Var);
            }
        }
    }

    public static void c(BaseFragment baseFragment, String str, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2}) == null) && baseFragment != null && view2 != null && FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(str) && !z) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    g(baseFragment, view2);
                    return;
                } else if (Build.VERSION.SDK_INT < 23 || !SharedPrefHelper.getInstance().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    g(baseFragment, view2);
                    SharedPrefHelper.getInstance().putBoolean("key_forum_rule_dialog_show_frs", true);
                    return;
                } else {
                    return;
                }
            }
            g(baseFragment, view2);
        }
    }

    public static void d(Activity activity, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, activity, frsViewData) == null) && activity != null && activity.getIntent() != null) {
            String stringExtra = activity.getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                activity.getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(activity);
                achievementActivityConfig.setUrl(stringExtra);
                if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(frsViewData.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
            }
        }
    }

    public static void e(BaseFragment baseFragment, View view2, eh7 eh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseFragment, view2, eh7Var) == null) && baseFragment != null && view2 != null && eh7Var != null) {
            s45 s45Var = new s45(baseFragment.getFragmentActivity());
            s45Var.setContentViewSize(2);
            s45Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(baseFragment.getContext());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new a(s45Var, baseFragment, view2, eh7Var));
            s45Var.setContentView(frsBroadcastCopyGuideDialogView);
            s45Var.create(baseFragment.getPageContext()).show();
        }
    }

    public static void h(Context context, int i, FrsViewData frsViewData) {
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65543, null, context, i, frsViewData) == null) && TbadkCoreApplication.isLogin() && frsViewData != null && (list = frsViewData.mWindowToast) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                WindowToast windowToast = list.get(i2);
                if (windowToast != null && windowToast.toast_type.intValue() == i) {
                    if (!di.isEmpty(windowToast.toast_link)) {
                        BrowserHelper.startWebActivity(context, "", WebviewHelper.addParamsForPageTranslucent(windowToast.toast_link), true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void f(BaseFragment baseFragment, View view2, eh7 eh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, baseFragment, view2, eh7Var) == null) && baseFragment != null && eh7Var != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            xk5.h().m(new uk5(baseFragment.getContext()));
            xk5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (xk5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new b(view2, baseFragment, eh7Var), true);
            }
        }
    }

    public static void g(BaseFragment baseFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, baseFragment, view2) == null) && baseFragment != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            xk5.h().m(new vk5(baseFragment.getContext()));
            xk5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (xk5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new c(view2), true);
            }
        }
    }

    public static void i(FrsViewData frsViewData, eh7 eh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, frsViewData, eh7Var) == null) {
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (eh7Var != null && frsViewData.getForum() != null && frsViewData.getForum().getYuleData() != null) {
                    if (frsViewData.getForum().getYuleData() != null && frsViewData.getForum().getYuleData().a()) {
                        TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                        eh7Var.S1(frsViewData.getForum().getYuleData().b());
                        return;
                    }
                    eh7Var.A0();
                }
            } else if (eh7Var != null) {
                eh7Var.A0();
            }
        }
    }
}
