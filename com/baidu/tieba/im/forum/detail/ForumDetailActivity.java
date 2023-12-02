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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.f05;
import com.baidu.tieba.ia5;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.su8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes6.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements ForumDetailModel.f, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public su8 a;
    public ForumDetailModel b;
    public RecommendForumInfo c;
    public List<SimpleThreadInfo> d;
    public boolean e;
    public boolean f;
    public BarEmotionResponseMessage.ForumEmotionData g;
    public ManagerApplyInfo h;
    public PriManagerApplyInfo i;
    public ManagerElectionTab j;
    public String k;
    public boolean l;
    public String m;

    /* loaded from: classes6.dex */
    public class a implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f05 a;
        public final /* synthetic */ ForumDetailActivity b;

        public a(ForumDetailActivity forumDetailActivity, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, f05Var};
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
            this.a = f05Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.a.J(false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.a.J(false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.a.J(true);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (TextUtils.isEmpty(this.b.k)) {
                    return null;
                }
                OfficialSettingCache.getInstance().saveAcceptNotify(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.k), this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ForumDetailActivity forumDetailActivity = this.a;
                if (!forumDetailActivity.l) {
                    if (z) {
                        forumDetailActivity.a.C();
                        this.a.a.M();
                        this.a.b.X(this.a.k);
                        return;
                    }
                    forumDetailActivity.a.A();
                    this.a.a.N(R.string.refresh_view_title_text);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdUtilHelper.isNetOk()) {
                this.a.a.C();
                this.a.a.M();
                this.a.b.X(this.a.k);
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
        this.l = false;
    }

    public String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            this.a.E();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void O(BarEmotionResponseMessage barEmotionResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, barEmotionResponseMessage) == null) && barEmotionResponseMessage != null) {
            this.a.F(barEmotionResponseMessage.data);
            this.g = barEmotionResponseMessage.data;
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            new e(this, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.a.H(this.c, z);
        }
    }

    public void U0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.a.J(z);
        }
    }

    public void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.a.O(this.c, z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onUserChanged(z);
            R0();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void A(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                this.b.subscribeBar(false, this.k);
            } else if (ia5.e().A() && ia5.e().x()) {
                this.b.subscribeBar(true, this.k);
            } else {
                f05 f05Var = new f05(getActivity());
                f05Var.setMessageId(R.string.error_open_personal_single_alloff);
                f05Var.setNegativeButton(getResources().getString(R.string.signallforum_signnow), new a(this, f05Var));
                f05Var.create(getPageContext());
                f05Var.show();
                this.mHandler.postDelayed(new b(this), 500L);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f14e6);
                S0(false);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new d(this), 500L);
        }
    }

    public final List<SimpleThreadInfo> M0(List<SimpleThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
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

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f14e6);
                S0(true);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new c(this), 500L);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void S(ForumDetailSocketResponse forumDetailSocketResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, forumDetailSocketResponse) == null) {
            this.c = forumDetailSocketResponse.getForumInfo();
            this.d = forumDetailSocketResponse.getThreadInfoList();
            boolean z = true;
            if (forumDetailSocketResponse.isBawuShow() != 1) {
                z = false;
            }
            this.e = z;
            this.f = forumDetailSocketResponse.isComplaintShow();
            this.h = forumDetailSocketResponse.getApplyInfo();
            this.i = forumDetailSocketResponse.getPrivateApplyInfo();
            this.j = forumDetailSocketResponse.getManagerElectionTab();
            Q0();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a.A();
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.obfuscated_res_0x7f0f0e70);
            } else {
                showToast(str);
            }
            if (BdUtilHelper.isNetOk()) {
                this.a.N(R.string.no_data_common_txt);
            } else {
                this.a.N(R.string.refresh_view_title_text);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void u0(ForumDetailHttpResponse forumDetailHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, forumDetailHttpResponse) == null) {
            this.c = forumDetailHttpResponse.getForumInfo();
            this.d = forumDetailHttpResponse.getThreadInfoList();
            boolean z = true;
            if (forumDetailHttpResponse.isBawuShow() != 1) {
                z = false;
            }
            this.e = z;
            this.f = forumDetailHttpResponse.isComplaintShow();
            this.h = forumDetailHttpResponse.getApplyInfo();
            this.i = forumDetailHttpResponse.getPrivateApplyInfo();
            this.j = forumDetailHttpResponse.getManagerElectionTab();
            Q0();
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || TextUtils.isEmpty(this.k)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.ModifyData(String.valueOf(this.k), 4, null, 1)));
        sendMessage(new CustomMessage(2001151, String.valueOf(this.k)));
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (BdUtilHelper.isNetOk()) {
                this.a.M();
                this.b.X(this.k);
                this.b.W(this.k);
                return;
            }
            this.a.A();
            this.a.N(R.string.refresh_view_title_text);
            showToast(R.string.obfuscated_res_0x7f0f0e70);
        }
    }

    public final void Q0() {
        List<SimpleThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.A();
            this.a.C();
            if (this.c == null && ((list = this.d) == null || list.size() <= 0)) {
                this.l = false;
                this.a.N(R.string.no_data_common_txt);
                return;
            }
            this.l = true;
            this.d = M0(this.d);
            this.a.G(this.c, this.e, this.f, this.h, this.i, this.j);
            this.a.K(this.d);
        }
    }

    public final void W0() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String stringExtra = getIntent().getStringExtra("from_type");
            this.m = stringExtra;
            if (StringUtils.isNull(stringExtra)) {
                return;
            }
            if (this.m.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (!this.m.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) && !this.m.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                if (this.m.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                    str = "side_2_sub";
                } else if (this.m.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
                    str = "aio_side_2_sub";
                } else {
                    str = "";
                }
            } else {
                str = "sq_2_sub";
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        BarEmotionResponseMessage.ForumEmotionData forumEmotionData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 11003 && (forumEmotionData = this.g) != null && forumEmotionData.forum_pkg_status == 1 && !TextUtils.isEmpty(forumEmotionData.url) && this.c != null) {
                Activity pageActivity = getPageContext().getPageActivity();
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.g.url + "?forum_id=" + this.c.forum_id)));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        ManagerElectionTab managerElectionTab;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090381) {
                RecommendForumInfo recommendForumInfo = this.c;
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null) {
                    sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.c.forum_id), this.c.forum_name)));
                }
            } else if (id == R.id.obfuscated_res_0x7f09037a) {
                this.a.L();
            } else if (id == R.id.obfuscated_res_0x7f09037e) {
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                    return;
                }
                BarEmotionResponseMessage.ForumEmotionData forumEmotionData = this.g;
                if (forumEmotionData != null && forumEmotionData.forum_pkg_status == 1 && !TextUtils.isEmpty(forumEmotionData.url) && this.c != null) {
                    Activity pageActivity = getPageContext().getPageActivity();
                    sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.g.url + "?forum_id=" + this.c.forum_id)));
                }
            } else if (id == R.id.obfuscated_res_0x7f090380) {
                RecommendForumInfo recommendForumInfo2 = this.c;
                if (recommendForumInfo2 != null) {
                    if (recommendForumInfo2.is_private_forum.intValue() == 0) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{TbConfig.MANAGE_ADDRESS + "?fn=" + this.c.forum_name + "&fid=" + this.c.forum_id});
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/pribawuindex?fid=" + this.c.forum_id + "&fn=" + this.c.forum_name + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f09037c) {
                if (this.c != null) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/pritousu/complainforum?fid=" + this.c.forum_id + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f090384) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_ENTRANCE_DETAIL).eventStat();
                if (this.c != null && (managerElectionTab = this.j) != null) {
                    int intValue = managerElectionTab.new_manager_status.intValue();
                    if (intValue == 2) {
                        if (!TextUtils.isEmpty(this.j.new_strategy_link)) {
                            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.j.new_strategy_link});
                        }
                    } else if (intValue != 3 && intValue != 4) {
                        if (intValue == 5) {
                            if (TextUtils.isEmpty(this.j.toast_text)) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_election_finished);
                            } else {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), this.j.toast_text);
                            }
                        } else if (intValue == 1 && !TextUtils.isEmpty(this.j.toast_text)) {
                            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), this.j.toast_text);
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.c.forum_id.longValue(), 2)));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0307);
            su8 su8Var = new su8(this);
            this.a = su8Var;
            su8Var.z().addNetworkChangeListener(new f(this));
            this.a.I(new g(this));
            this.b = new ForumDetailModel(this);
            this.k = getIntent().getStringExtra("forum_id");
            R0();
            W0();
        }
    }
}
