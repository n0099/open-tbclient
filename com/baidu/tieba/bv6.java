package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsForumToolDialogView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.AddBawuPopInfo;
import tbclient.PopInfo;
/* loaded from: classes3.dex */
public class bv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                hw4.r("frsShield");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ bo8 b;

        public b(AlertDialog alertDialog, bo8 bo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog, bo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
            this.b = bo8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.b.getForum() != null) {
                    statisticItem.param("fid", this.b.getForum().getId());
                    statisticItem.param("fname", this.b.getForum().getName());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;

        public c(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                kv4 kv4Var = this.a;
                if (kv4Var != null) {
                    kv4Var.dismiss();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ FrsFragment c;
        public final /* synthetic */ String d;

        public d(kv4 kv4Var, int i, FrsFragment frsFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv4Var, Integer.valueOf(i), frsFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv4Var;
            this.b = i;
            this.c = frsFragment;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                kv4 kv4Var = this.a;
                if (kv4Var != null) {
                    kv4Var.dismiss();
                }
                int i = this.b;
                if (i == 1) {
                    UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{TbConfig.BAWUTEAME_ADDRESS + "?fn=" + this.c.c() + "&fid=" + this.c.k()});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.c.k());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.c.getActivity(), "ForumDetailPage", hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(this.d)) {
                    UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{this.d});
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                hw4.r("frsForumManage");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NavigationBarCoverTip c;

        public f(FrsFragment frsFragment, String str, NavigationBarCoverTip navigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, str, navigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
            this.b = str;
            this.c = navigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem("c13439").eventStat();
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && !TextUtils.isEmpty(frsFragment.k()) && !TextUtils.isEmpty(this.b) && this.a.getActivity() != null) {
                    NavigationBarCoverTip navigationBarCoverTip = this.c;
                    if (navigationBarCoverTip != null) {
                        navigationBarCoverTip.e();
                    }
                    if (qy4.k().l("key_bawu_task_toast", 0) == -1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.a.k() + "&fn=" + this.b + "&noread=" + i});
                }
            }
        }
    }

    public static boolean a(bo8 bo8Var, FrsFragment frsFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bo8Var, frsFragment)) == null) {
            if (bo8Var != null && bo8Var.getUserData() != null && frsFragment != null) {
                int is_manager = bo8Var.getUserData().getIs_manager();
                boolean h = qy4.k().h("key_forum_tool_find_dialog_show", false);
                if (is_manager == 1 && !h) {
                    c(1, frsFragment.getString(R.string.obfuscated_res_0x7f0f06e9), String.valueOf((int) R.drawable.obfuscated_res_0x7f080fab), "", frsFragment);
                    qy4.k().u("key_forum_tool_find_dialog_show", true);
                    if (frsFragment != null) {
                        frsFragment.y4(true);
                    }
                    return true;
                } else if (!h && is_manager == 2) {
                    c(2, frsFragment.getString(R.string.obfuscated_res_0x7f0f06e8), String.valueOf((int) R.drawable.obfuscated_res_0x7f080fab), "", frsFragment);
                    qy4.k().u("key_forum_tool_find_dialog_show", true);
                    if (frsFragment != null) {
                        frsFragment.y4(true);
                    }
                    return true;
                } else {
                    AddBawuPopInfo addBawuPopInfo = bo8Var.bawuPopInfo;
                    if (addBawuPopInfo != null) {
                        c(3, addBawuPopInfo.content, addBawuPopInfo.img_url, addBawuPopInfo.jump_url, frsFragment);
                        if (frsFragment != null) {
                            frsFragment.y4(true);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void b(NavigationBarCoverTip navigationBarCoverTip, FrsFragment frsFragment, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, navigationBarCoverTip, frsFragment, str) == null) && navigationBarCoverTip != null && frsFragment != null && frsFragment.getActivity() != null) {
            View inflate = View.inflate(frsFragment.getActivity(), R.layout.obfuscated_res_0x7f0d0955, null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092716);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f091edb);
            if (TextUtils.isEmpty(str)) {
                textView.setText("吧主您好，本吧考核新制度上线啦");
            } else {
                textView.setText(str + "吧吧主您好，本吧考核新制度上线啦");
            }
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03bb));
            qz4 qz4Var = new qz4();
            qz4Var.s();
            tBSpecificationBtn.setConfig(qz4Var);
            tBSpecificationBtn.k();
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
            tBSpecificationBtn.setOnClickListener(new f(frsFragment, str, navigationBarCoverTip));
            navigationBarCoverTip.n(frsFragment.getActivity(), inflate, 30000);
            new StatisticItem("c13438").eventStat();
            int l = qy4.k().l("key_bawu_task_toast", 0);
            if (l >= 0) {
                qy4.k().w("key_bawu_task_toast", l + 1);
            }
        }
    }

    public static void c(int i, String str, String str2, String str3, FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, str3, frsFragment}) != null) || frsFragment == null) {
            return;
        }
        kv4 kv4Var = new kv4(frsFragment.getActivity());
        kv4Var.setContentViewSize(2);
        kv4Var.setCanceledOnTouchOutside(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(frsFragment.getActivity());
        frsForumToolDialogView.setStartLoadUrl(i, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new c(kv4Var));
        frsForumToolDialogView.setConfirmButtonListener(new d(kv4Var, i, frsFragment, str3));
        kv4Var.setOnDismissListener(new e());
        kv4Var.setContentView(frsForumToolDialogView);
        kv4Var.create(frsFragment.getPageContext()).show();
        hw4.m("frsForumManage");
    }

    public static boolean d(bo8 bo8Var, FrsFragment frsFragment) {
        InterceptResult invokeLL;
        PopInfo popInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bo8Var, frsFragment)) == null) {
            if (frsFragment == null || qy4.k().h(qy4.o("key_frs_shield_thread_dialog"), false) || bo8Var.getUserData() == null || bo8Var.getUserData().getIs_manager() <= 0 || (popInfo = bo8Var.frsMaskPopInfo) == null || popInfo.if_pop.intValue() != 1) {
                return false;
            }
            ImageView imageView = new ImageView(frsFragment.getActivity());
            imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f041b, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(frsFragment.getActivity());
            tBAlertBuilder.u(bo8Var.frsMaskPopInfo.title);
            tBAlertBuilder.o(bo8Var.frsMaskPopInfo.v_title);
            tBAlertBuilder.m(true);
            tBAlertBuilder.i(imageView);
            tBAlertBuilder.r(aVar);
            tBAlertBuilder.h(false);
            AlertDialog w = tBAlertBuilder.w();
            w.setOnDismissListener(new a());
            aVar.a(new b(w, bo8Var));
            qy4.k().u(qy4.o("key_frs_shield_thread_dialog"), true);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (bo8Var.getForum() != null) {
                statisticItem.param("fid", bo8Var.getForum().getId());
                statisticItem.param("fname", bo8Var.getForum().getName());
            }
            TiebaStatic.log(statisticItem);
            if (frsFragment != null) {
                frsFragment.y4(true);
            }
            hw4.m("frsShield");
            return true;
        }
        return invokeLL.booleanValue;
    }
}
