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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class dw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ View c;
        public final /* synthetic */ ei7 d;

        public a(p55 p55Var, BaseFragment baseFragment, View view2, ei7 ei7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p55Var, baseFragment, view2, ei7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p55Var;
            this.b = baseFragment;
            this.c = view2;
            this.d = ei7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            p55 p55Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (p55Var = this.a) != null) {
                p55Var.dismiss();
                dw7.f(this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements t05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseFragment b;
        public final /* synthetic */ ei7 c;

        public b(View view2, BaseFragment baseFragment, ei7 ei7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseFragment, ei7Var};
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
            this.c = ei7Var;
        }

        @Override // com.baidu.tieba.t05
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    xl5.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    View view2 = this.a;
                    if (view2 != null) {
                        view2.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.b.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.b.getString(R.string.obfuscated_res_0x7f0f0777));
                bdTopToast.i(this.c.r0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements t05 {
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

        @Override // com.baidu.tieba.t05
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                xl5.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                View view2 = this.a;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public static void b(BaseFragment baseFragment, String str, boolean z, View view2, ei7 ei7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{baseFragment, str, Boolean.valueOf(z), view2, ei7Var}) == null) && baseFragment != null && ei7Var != null && view2 != null && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(str) && !z) {
            int q = da5.p().q("key_forum_broadcast_edit_tip_number", 0);
            if (q < 2) {
                da5.p().F("key_forum_broadcast_edit_tip_number", q + 1);
                e(baseFragment, view2, ei7Var);
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(baseFragment.getContext())) {
                    f(baseFragment, view2, ei7Var);
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(baseFragment.getContext());
                bdTopToast.h(false);
                bdTopToast.g(baseFragment.getString(R.string.obfuscated_res_0x7f0f0777));
                bdTopToast.i(ei7Var.r0());
            } else {
                f(baseFragment, view2, ei7Var);
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
                } else if (Build.VERSION.SDK_INT < 23 || !da5.p().l("key_forum_rule_dialog_show_frs", false)) {
                    g(baseFragment, view2);
                    da5.p().A("key_forum_rule_dialog_show_frs", true);
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

    public static void e(BaseFragment baseFragment, View view2, ei7 ei7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseFragment, view2, ei7Var) == null) && baseFragment != null && view2 != null && ei7Var != null) {
            p55 p55Var = new p55(baseFragment.getFragmentActivity());
            p55Var.setContentViewSize(2);
            p55Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(baseFragment.getContext());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new a(p55Var, baseFragment, view2, ei7Var));
            p55Var.setContentView(frsBroadcastCopyGuideDialogView);
            p55Var.create(baseFragment.getPageContext()).show();
        }
    }

    public static void h(Context context, int i, FrsViewData frsViewData) {
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65543, null, context, i, frsViewData) == null) && TbadkCoreApplication.isLogin() && frsViewData != null && (list = frsViewData.mWindowToast) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                WindowToast windowToast = list.get(i2);
                if (windowToast != null && windowToast.toast_type.intValue() == i) {
                    if (!xi.isEmpty(windowToast.toast_link)) {
                        nx4.v(context, "", pz5.a(windowToast.toast_link), true);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static void f(BaseFragment baseFragment, View view2, ei7 ei7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, baseFragment, view2, ei7Var) == null) && baseFragment != null && ei7Var != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            xl5.h().m(new ul5(baseFragment.getContext()));
            xl5.h().n(85, 0, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (xl5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new b(view2, baseFragment, ei7Var), true);
            }
        }
    }

    public static void g(BaseFragment baseFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, baseFragment, view2) == null) && baseFragment != null && view2 != null && baseFragment.getPageContext() != null && baseFragment.getPageContext().getOrignalPage() != null) {
            xl5.h().m(new vl5(baseFragment.getContext()));
            xl5.h().n(85, 0, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (xl5.h().j()) {
                baseFragment.getPageContext().getOrignalPage().grantWindowPermission(new c(view2), true);
            }
        }
    }

    public static void i(FrsViewData frsViewData, ei7 ei7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, frsViewData, ei7Var) == null) {
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (ei7Var != null && frsViewData.getForum() != null && frsViewData.getForum().getYuleData() != null) {
                    if (frsViewData.getForum().getYuleData() != null && frsViewData.getForum().getYuleData().a()) {
                        TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                        ei7Var.S1(frsViewData.getForum().getYuleData().b());
                        return;
                    }
                    ei7Var.A0();
                }
            } else if (ei7Var != null) {
                ei7Var.A0();
            }
        }
    }
}
