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
/* loaded from: classes5.dex */
public class dr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ View c;
        public final /* synthetic */ ed7 d;

        public a(hz4 hz4Var, BaseFragment baseFragment, View view2, ed7 ed7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz4Var, baseFragment, view2, ed7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz4Var;
            this.b = baseFragment;
            this.c = view2;
            this.d = ed7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            hz4 hz4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (hz4Var = this.a) != null) {
                hz4Var.dismiss();
                dr7.f(this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ ed7 c;

        public b(View view2, BaseFragment baseFragment, ed7 ed7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseFragment, ed7Var};
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
            this.c = ed7Var;
        }

        @Override // com.baidu.tieba.mu4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ag5.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    View view2 = this.a;
                    if (view2 != null) {
                        view2.setVisibility(8);
                        return;
                    }
                    return;
                }
                new BdTopToast(this.b.getContext()).setIcon(false).setContent(this.b.getString(R.string.obfuscated_res_0x7f0f0789)).show(this.c.s0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements mu4 {
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

        @Override // com.baidu.tieba.mu4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                ag5.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                View view2 = this.a;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public static void b(BaseFragment baseFragment, String str, boolean z, View view2, ed7 ed7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2, ed7Var}) == null) && baseFragment != null && ed7Var != null && view2 != null && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(str) && !z) {
            int i = SharedPrefHelper.getInstance().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                SharedPrefHelper.getInstance().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                e(baseFragment, view2, ed7Var);
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    f(baseFragment, view2, ed7Var);
                } else {
                    new BdTopToast(baseFragment.getContext()).setIcon(false).setContent(baseFragment.getString(R.string.obfuscated_res_0x7f0f0789)).show(ed7Var.s0());
                }
            } else {
                f(baseFragment, view2, ed7Var);
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

    public static void e(BaseFragment baseFragment, View view2, ed7 ed7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseFragment, view2, ed7Var) == null) && baseFragment != null && view2 != null && ed7Var != null) {
            hz4 hz4Var = new hz4(baseFragment.getFragmentActivity());
            hz4Var.setContentViewSize(2);
            hz4Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(baseFragment.getContext());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new a(hz4Var, baseFragment, view2, ed7Var));
            hz4Var.setContentView(frsBroadcastCopyGuideDialogView);
            hz4Var.create(baseFragment.getPageContext()).show();
        }
    }

    public static void h(Context context, int i, FrsViewData frsViewData) {
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65543, null, context, i, frsViewData) == null) && TbadkCoreApplication.isLogin() && frsViewData != null && (list = frsViewData.mWindowToast) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                WindowToast windowToast = list.get(i2);
                if (windowToast != null && windowToast.toast_type.intValue() == i) {
                    if (!ad.isEmpty(windowToast.toast_link)) {
                        BrowserHelper.startWebActivity(context, "", WebviewHelper.addParamsForPageTranslucent(windowToast.toast_link), true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void f(BaseFragment baseFragment, View view2, ed7 ed7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, baseFragment, view2, ed7Var) == null) && baseFragment != null && ed7Var != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            ag5.h().m(new xf5(baseFragment.getContext()));
            ag5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (ag5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new b(view2, baseFragment, ed7Var), true);
            }
        }
    }

    public static void g(BaseFragment baseFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, baseFragment, view2) == null) && baseFragment != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            ag5.h().m(new yf5(baseFragment.getContext()));
            ag5.h().n(85, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (ag5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new c(view2), true);
            }
        }
    }

    public static void i(FrsViewData frsViewData, ed7 ed7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, frsViewData, ed7Var) == null) {
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (ed7Var != null && frsViewData.getForum() != null && frsViewData.getForum().getYuleData() != null) {
                    if (frsViewData.getForum().getYuleData() != null && frsViewData.getForum().getYuleData().a()) {
                        TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                        ed7Var.U1(frsViewData.getForum().getYuleData().b());
                        return;
                    }
                    ed7Var.B0();
                }
            } else if (ed7Var != null) {
                ed7Var.B0();
            }
        }
    }
}
