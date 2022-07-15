package com.baidu.tieba.im.forum.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.n67;
import com.repackage.pi;
import com.repackage.py4;
import com.repackage.s77;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements ForumDetailModel.f, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n67 a;
    public ForumDetailModel b;
    public RecommendForumInfo c;
    public List<SimpleThreadInfo> d;
    public boolean e;
    public boolean f;
    public BarEmotionResponseMessage.ForumEmotionData g;
    public ManagerApplyInfo h;
    public PriManagerApplyInfo i;
    public ManagerElectionTab j;
    public BzApplySwitch k;
    public String l;
    public boolean m;
    public String n;

    /* loaded from: classes3.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ ForumDetailActivity b;

        public a(ForumDetailActivity forumDetailActivity, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumDetailActivity;
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        public b(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.t(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        public c(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.t(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        public d(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.t(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ForumDetailActivity b;

        public e(ForumDetailActivity forumDetailActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumDetailActivity;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.b.l)) {
                    return null;
                }
                s77.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.l), this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        public f(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumDetailActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ForumDetailActivity forumDetailActivity = this.a;
                if (forumDetailActivity.m) {
                    return;
                }
                if (z) {
                    forumDetailActivity.a.m();
                    this.a.a.w();
                    this.a.b.J(this.a.l);
                    return;
                }
                forumDetailActivity.a.l();
                this.a.a.x(R.string.obfuscated_res_0x7f0f0f9b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumDetailActivity a;

        public g(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && pi.D()) {
                this.a.a.m();
                this.a.a.w();
                this.a.b.J(this.a.l);
            }
        }
    }

    public ForumDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = false;
        this.m = false;
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.l)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.l), 4, null, 1)));
        sendMessage(new CustomMessage(2001151, String.valueOf(this.l)));
    }

    public final List<SimpleThreadInfo> E1(List<SimpleThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (SimpleThreadInfo simpleThreadInfo : list) {
                if (simpleThreadInfo != null) {
                    if (i >= 5) {
                        break;
                    }
                    i++;
                    arrayList.add(simpleThreadInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public String F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void G1() {
        List<SimpleThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.l();
            this.a.m();
            if (this.c == null && ((list = this.d) == null || list.size() <= 0)) {
                this.m = false;
                this.a.x(R.string.obfuscated_res_0x7f0f0c44);
                return;
            }
            this.m = true;
            this.d = E1(this.d);
            this.a.q(this.c, this.e, this.f, this.h, this.i, this.j, this.k);
            this.a.u(this.d);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (pi.D()) {
                this.a.w();
                this.b.J(this.l);
                this.b.I(this.l);
                return;
            }
            this.a.l();
            this.a.x(R.string.obfuscated_res_0x7f0f0f9b);
            showToast(R.string.obfuscated_res_0x7f0f0c2b);
        }
    }

    public void I1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            new e(this, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void J1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.r(this.c, z);
        }
    }

    public void K1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a.t(z);
        }
    }

    public final void L1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String stringExtra = getIntent().getStringExtra("from_type");
            this.n = stringExtra;
            if (StringUtils.isNull(stringExtra)) {
                return;
            }
            if (this.n.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (this.n.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.n.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (this.n.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else {
                str = this.n.equals(ForumDetailActivityConfig.FromType.BAR.toString()) ? "aio_side_2_sub" : "";
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
        }
    }

    public void M1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.y(this.c, z);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void O0(BarEmotionResponseMessage barEmotionResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, barEmotionResponseMessage) == null) || barEmotionResponseMessage == null) {
            return;
        }
        this.a.p(barEmotionResponseMessage.data);
        this.g = barEmotionResponseMessage.data;
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f122f);
                I1(true);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new c(this), 500L);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void S0(ForumDetailSocketResponse forumDetailSocketResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, forumDetailSocketResponse) == null) {
            this.c = forumDetailSocketResponse.getForumInfo();
            this.d = forumDetailSocketResponse.getThreadInfoList();
            this.e = forumDetailSocketResponse.isBawuShow() == 1;
            this.f = forumDetailSocketResponse.isComplaintShow();
            this.h = forumDetailSocketResponse.getApplyInfo();
            this.i = forumDetailSocketResponse.getPrivateApplyInfo();
            this.j = forumDetailSocketResponse.getManagerElectionTab();
            this.k = forumDetailSocketResponse.getBzApplySwitch();
            G1();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a.l();
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.obfuscated_res_0x7f0f0c2b);
            } else {
                showToast(str);
            }
            if (pi.D()) {
                this.a.x(R.string.obfuscated_res_0x7f0f0c44);
            } else {
                this.a.x(R.string.obfuscated_res_0x7f0f0f9b);
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void j0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view2, switchState) == null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                this.b.subscribeBar(false, this.l);
            } else if (py4.d().w() && py4.d().t()) {
                this.b.subscribeBar(true, this.l);
            } else {
                cr4 cr4Var = new cr4(getActivity());
                cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f05a3);
                cr4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f11ad), new a(this, cr4Var));
                cr4Var.create(getPageContext());
                cr4Var.show();
                this.mHandler.postDelayed(new b(this), 500L);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        BarEmotionResponseMessage.ForumEmotionData forumEmotionData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 11003 || (forumEmotionData = this.g) == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.c == null) {
                return;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.g.url + "?forum_id=" + this.c.forum_id)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        ManagerElectionTab managerElectionTab;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09031b) {
                RecommendForumInfo recommendForumInfo = this.c;
                if (recommendForumInfo == null || recommendForumInfo.forum_id == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.c.forum_id), this.c.forum_name)));
            } else if (id == R.id.obfuscated_res_0x7f090314) {
                this.a.v();
            } else if (id == R.id.obfuscated_res_0x7f090318) {
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                    return;
                }
                BarEmotionResponseMessage.ForumEmotionData forumEmotionData = this.g;
                if (forumEmotionData == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.c == null) {
                    return;
                }
                Activity pageActivity = getPageContext().getPageActivity();
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.g.url + "?forum_id=" + this.c.forum_id)));
            } else if (id == R.id.obfuscated_res_0x7f09031a) {
                RecommendForumInfo recommendForumInfo2 = this.c;
                if (recommendForumInfo2 != null) {
                    if (recommendForumInfo2.is_private_forum.intValue() == 0) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawuindex?fn=" + this.c.forum_name + "&fid=" + this.c.forum_id});
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.c.forum_id + "&fn=" + this.c.forum_name + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f090316) {
                if (this.c != null) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.c.forum_id + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f09031d) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_ENTRANCE_DETAIL).eventStat();
                if (this.c == null || (managerElectionTab = this.j) == null) {
                    return;
                }
                int intValue = managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (TextUtils.isEmpty(this.j.new_strategy_link)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.j.new_strategy_link});
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.c.forum_id.longValue(), 2)));
                } else if (intValue == 5) {
                    if (TextUtils.isEmpty(this.j.toast_text)) {
                        pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02d8);
                    } else {
                        pi.O(TbadkCoreApplication.getInst(), this.j.toast_text);
                    }
                } else if (intValue != 1 || TextUtils.isEmpty(this.j.toast_text)) {
                } else {
                    pi.O(TbadkCoreApplication.getInst(), this.j.toast_text);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d029e);
            n67 n67Var = new n67(this);
            this.a = n67Var;
            n67Var.k().a(new f(this));
            this.a.s(new g(this));
            this.b = new ForumDetailModel(this);
            this.l = getIntent().getStringExtra("forum_id");
            H1();
            L1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            this.a.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.onUserChanged(z);
            H1();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void p1(ForumDetailHttpResponse forumDetailHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, forumDetailHttpResponse) == null) {
            this.c = forumDetailHttpResponse.getForumInfo();
            this.d = forumDetailHttpResponse.getThreadInfoList();
            this.e = forumDetailHttpResponse.isBawuShow() == 1;
            this.f = forumDetailHttpResponse.isComplaintShow();
            this.h = forumDetailHttpResponse.getApplyInfo();
            this.i = forumDetailHttpResponse.getPrivateApplyInfo();
            this.j = forumDetailHttpResponse.getManagerElectionTab();
            this.k = forumDetailHttpResponse.getBzApplySwitch();
            G1();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void t1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f122f);
                I1(false);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new d(this), 500L);
        }
    }
}
