package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes6.dex */
public class i38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
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
                YunDialogManager.unMarkShowingDialogName("frsShield");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ ForumData b;

        public b(AlertDialog alertDialog, ForumData forumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog, forumData};
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
            this.b = forumData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_CANCEL);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                ForumData forumData = this.b;
                if (forumData != null) {
                    statisticItem.param("fid", forumData.getId());
                    statisticItem.param("fname", this.b.getName());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;

        public c(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zz4 zz4Var = this.a;
                if (zz4Var != null) {
                    zz4Var.dismiss();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;

        public d(zz4 zz4Var, int i, String str, String str2, Activity activity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz4Var, Integer.valueOf(i), str, str2, activity, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz4Var;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = activity;
            this.f = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zz4 zz4Var = this.a;
                if (zz4Var != null) {
                    zz4Var.dismiss();
                }
                int i = this.b;
                if (i == 1) {
                    UrlManager.getInstance().dealOneLink(TbadkCoreApplication.getInst().getCurrentPageContext(this.e), new String[]{TbConfig.BAWUTEAME_ADDRESS + "?fn=" + this.c + "&fid=" + this.d});
                } else if (i == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("forum_id", this.d);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.e, "ForumDetailPage", hashMap)));
                } else if (i == 3 && !TextUtils.isEmpty(this.f)) {
                    UrlManager.getInstance().dealOneLink(TbadkCoreApplication.getInst().getCurrentPageContext(this.e), new String[]{this.f});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnDismissListener {
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
                YunDialogManager.unMarkShowingDialogName("frsForumManage");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
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
                if (frsFragment != null && !TextUtils.isEmpty(frsFragment.w()) && !TextUtils.isEmpty(this.b) && this.a.getActivity() != null) {
                    NavigationBarCoverTip navigationBarCoverTip = this.c;
                    if (navigationBarCoverTip != null) {
                        navigationBarCoverTip.b();
                    }
                    if (SharedPrefHelper.getInstance().getInt("key_bawu_task_toast", 0) == -1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + this.a.w() + "&fn=" + this.b + "&noread=" + i});
                }
            }
        }
    }

    public static boolean a(b25 b25Var, Context context) {
        InterceptResult invokeLL;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, b25Var, context)) == null) {
            if (b25Var != null && context != null) {
                UserData K1 = b25Var.K1();
                ForumData U0 = b25Var.U0();
                AddBawuPopInfo j0 = b25Var.j0();
                if (K1 != null) {
                    i = K1.getIs_manager();
                } else {
                    i = 0;
                }
                if (U0 == null) {
                    str = "";
                    str2 = str;
                } else {
                    String name = U0.getName();
                    str2 = U0.getId();
                    str = name;
                }
                boolean z = SharedPrefHelper.getInstance().getBoolean("key_forum_tool_find_dialog_show", false);
                if (i == 1 && !z) {
                    c(1, context.getString(R.string.obfuscated_res_0x7f0f07f7), String.valueOf((int) R.drawable.obfuscated_res_0x7f081243), "", str, str2);
                    SharedPrefHelper.getInstance().putBoolean("key_forum_tool_find_dialog_show", true);
                    b25Var.G1(true);
                    return true;
                } else if (!z && i == 2) {
                    c(2, context.getString(R.string.obfuscated_res_0x7f0f07f6), String.valueOf((int) R.drawable.obfuscated_res_0x7f081243), "", str, str2);
                    SharedPrefHelper.getInstance().putBoolean("key_forum_tool_find_dialog_show", true);
                    b25Var.G1(true);
                    return true;
                } else if (j0 != null) {
                    c(3, j0.content, j0.img_url, j0.jump_url, str, str2);
                    b25Var.G1(true);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void b(NavigationBarCoverTip navigationBarCoverTip, FrsFragment frsFragment, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, navigationBarCoverTip, frsFragment, str) == null) && navigationBarCoverTip != null && frsFragment != null && frsFragment.getActivity() != null) {
            View inflate = View.inflate(frsFragment.getActivity(), R.layout.write_thread_share_guide, null);
            TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.share_icon);
            if (TextUtils.isEmpty(str)) {
                textView.setText("吧主您好，本吧考核新制度上线啦");
            } else {
                textView.setText(str + "吧吧主您好，本吧考核新制度上线啦");
            }
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
            v55 v55Var = new v55();
            v55Var.u();
            tBSpecificationBtn.setConfig(v55Var);
            tBSpecificationBtn.k();
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
            tBSpecificationBtn.setOnClickListener(new f(frsFragment, str, navigationBarCoverTip));
            navigationBarCoverTip.k(frsFragment.getActivity(), inflate, 30000);
            new StatisticItem("c13438").eventStat();
            int i = SharedPrefHelper.getInstance().getInt("key_bawu_task_toast", 0);
            if (i >= 0) {
                SharedPrefHelper.getInstance().putInt("key_bawu_task_toast", i + 1);
            }
        }
    }

    public static void c(int i, String str, String str2, String str3, String str4, String str5) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), str, str2, str3, str4, str5}) != null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        zz4 zz4Var = new zz4(currentActivity);
        zz4Var.setContentViewSize(2);
        zz4Var.setCanceledOnTouchOutside(false);
        FrsForumToolDialogView frsForumToolDialogView = new FrsForumToolDialogView(currentActivity);
        frsForumToolDialogView.setStartLoadUrl(i, str2);
        frsForumToolDialogView.setContent(str);
        frsForumToolDialogView.setCancleButtonListener(new c(zz4Var));
        frsForumToolDialogView.setConfirmButtonListener(new d(zz4Var, i, str4, str5, currentActivity, str3));
        zz4Var.setOnDismissListener(new e());
        zz4Var.setContentView(frsForumToolDialogView);
        zz4Var.create(TbadkCoreApplication.getInst().getCurrentPageContext(currentActivity)).show();
        YunDialogManager.markShowingDialogName("frsForumManage");
    }

    public static boolean d(b25 b25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b25Var)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null && b25Var != null) {
                UserData K1 = b25Var.K1();
                PopInfo x1 = b25Var.x1();
                ForumData U0 = b25Var.U0();
                if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_frs_shield_thread_dialog"), false) && K1 != null && K1.getIs_manager() > 0 && x1 != null && x1.if_pop.intValue() == 1) {
                    ImageView imageView = new ImageView(currentActivity);
                    imageView.setImageResource(SkinManager.getResourceId(R.drawable.pic_frs_popup_shield));
                    TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0493, TBAlertConfig.OperateBtnStyle.MAIN);
                    AlertDialog show = new TBAlertBuilder(currentActivity).setTitleStr(x1.title).setDescStr(x1.v_title).setDescLightStyle(true).setCustomContentView(imageView).setOperateBtn(operateBtnConfig).setCancelable(false).show();
                    show.setOnDismissListener(new a());
                    operateBtnConfig.setListener(new b(show, U0));
                    SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_frs_shield_thread_dialog"), true);
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BAWU_TIP_DIALOG_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (U0 != null) {
                        statisticItem.param("fid", U0.getId());
                        statisticItem.param("fname", U0.getName());
                    }
                    TiebaStatic.log(statisticItem);
                    b25Var.G1(true);
                    YunDialogManager.markShowingDialogName("frsShield");
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
