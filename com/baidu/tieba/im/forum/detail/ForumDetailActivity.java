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
import com.baidu.tieba.fj;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.oa7;
import com.baidu.tieba.pu4;
import com.baidu.tieba.q25;
import com.baidu.tieba.ub7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class ForumDetailActivity extends BaseActivity implements ForumDetailModel.f, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oa7 a;
    public ForumDetailModel b;
    public RecommendForumInfo c;
    public List d;
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

    /* loaded from: classes4.dex */
    public class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ ForumDetailActivity b;

        public a(ForumDetailActivity forumDetailActivity, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, pu4Var};
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
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.a.v(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.a.v(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.a.v(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask {
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
                ub7.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.l), this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ForumDetailActivity forumDetailActivity = this.a;
                if (!forumDetailActivity.m) {
                    if (z) {
                        forumDetailActivity.a.o();
                        this.a.a.y();
                        this.a.b.I(this.a.l);
                        return;
                    }
                    forumDetailActivity.a.n();
                    this.a.a.z(R.string.obfuscated_res_0x7f0f0fec);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && fj.D()) {
                this.a.a.o();
                this.a.a.y();
                this.a.b.I(this.a.l);
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

    public String D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            this.a.q();
        }
    }

    public void G1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            new e(this, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void H1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.t(this.c, z);
        }
    }

    public void I1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.a.v(z);
        }
    }

    public void K1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a.A(this.c, z);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void M0(BarEmotionResponseMessage barEmotionResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, barEmotionResponseMessage) == null) && barEmotionResponseMessage != null) {
            this.a.r(barEmotionResponseMessage.data);
            this.g = barEmotionResponseMessage.data;
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
            F1();
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || TextUtils.isEmpty(this.l)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.l), 4, null, 1)));
        sendMessage(new CustomMessage(2001151, String.valueOf(this.l)));
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (fj.D()) {
                this.a.y();
                this.b.I(this.l);
                this.b.H(this.l);
                return;
            }
            this.a.n();
            this.a.z(R.string.obfuscated_res_0x7f0f0fec);
            showToast(R.string.obfuscated_res_0x7f0f0c68);
        }
    }

    public final List C1(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SimpleThreadInfo simpleThreadInfo = (SimpleThreadInfo) it.next();
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
    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f1252);
                G1(true);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new c(this), 500L);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a.n();
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.obfuscated_res_0x7f0f0c68);
            } else {
                showToast(str);
            }
            if (fj.D()) {
                this.a.z(R.string.obfuscated_res_0x7f0f0c83);
            } else {
                this.a.z(R.string.obfuscated_res_0x7f0f0fec);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f1252);
                G1(false);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new d(this), 500L);
        }
    }

    public final void E1() {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.n();
            this.a.o();
            if (this.c == null && ((list = this.d) == null || list.size() <= 0)) {
                this.m = false;
                this.a.z(R.string.obfuscated_res_0x7f0f0c83);
                return;
            }
            this.m = true;
            this.d = C1(this.d);
            this.a.s(this.c, this.e, this.f, this.h, this.i, this.j, this.k);
            this.a.w(this.d);
        }
    }

    public final void J1() {
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
            } else if (!this.n.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) && !this.n.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                if (this.n.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                    str = "side_2_sub";
                } else if (this.n.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
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

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void Q0(ForumDetailSocketResponse forumDetailSocketResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, forumDetailSocketResponse) == null) {
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
            this.k = forumDetailSocketResponse.getBzApplySwitch();
            E1();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void n1(ForumDetailHttpResponse forumDetailHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, forumDetailHttpResponse) == null) {
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
            this.k = forumDetailHttpResponse.getBzApplySwitch();
            E1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d02a5);
            oa7 oa7Var = new oa7(this);
            this.a = oa7Var;
            oa7Var.m().a(new f(this));
            this.a.u(new g(this));
            this.b = new ForumDetailModel(this);
            this.l = getIntent().getStringExtra("forum_id");
            F1();
            J1();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void i0(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view2, switchState) == null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                this.b.subscribeBar(false, this.l);
            } else if (q25.d().x() && q25.d().u()) {
                this.b.subscribeBar(true, this.l);
            } else {
                pu4 pu4Var = new pu4(getActivity());
                pu4Var.setMessageId(R.string.obfuscated_res_0x7f0f05c2);
                pu4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f11cd), new a(this, pu4Var));
                pu4Var.create(getPageContext());
                pu4Var.show();
                this.mHandler.postDelayed(new b(this), 500L);
            }
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
            if (id == R.id.obfuscated_res_0x7f09033c) {
                RecommendForumInfo recommendForumInfo = this.c;
                if (recommendForumInfo != null && recommendForumInfo.forum_id != null) {
                    sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.c.forum_id), this.c.forum_name)));
                }
            } else if (id == R.id.obfuscated_res_0x7f090335) {
                this.a.x();
            } else if (id == R.id.obfuscated_res_0x7f090339) {
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                    return;
                }
                BarEmotionResponseMessage.ForumEmotionData forumEmotionData = this.g;
                if (forumEmotionData != null && forumEmotionData.forum_pkg_status == 1 && !TextUtils.isEmpty(forumEmotionData.url) && this.c != null) {
                    Activity pageActivity = getPageContext().getPageActivity();
                    sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.g.url + "?forum_id=" + this.c.forum_id)));
                }
            } else if (id == R.id.obfuscated_res_0x7f09033b) {
                RecommendForumInfo recommendForumInfo2 = this.c;
                if (recommendForumInfo2 != null) {
                    if (recommendForumInfo2.is_private_forum.intValue() == 0) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{TbConfig.MANAGE_ADDRESS + "?fn=" + this.c.forum_name + "&fid=" + this.c.forum_id});
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/pribawuindex?fid=" + this.c.forum_id + "&fn=" + this.c.forum_name + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f090337) {
                if (this.c != null) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/pritousu/complainforum?fid=" + this.c.forum_id + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f09033e) {
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
                                fj.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02e1);
                            } else {
                                fj.N(TbadkCoreApplication.getInst(), this.j.toast_text);
                            }
                        } else if (intValue == 1 && !TextUtils.isEmpty(this.j.toast_text)) {
                            fj.N(TbadkCoreApplication.getInst(), this.j.toast_text);
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.c.forum_id.longValue(), 2)));
                    }
                }
            }
        }
    }
}
