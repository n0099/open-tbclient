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
import com.repackage.dq4;
import com.repackage.ex4;
import com.repackage.li;
import com.repackage.m47;
import com.repackage.q57;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THREAD_ITEM_MAX_NUM = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public ManagerApplyInfo applyInfo;
    public BzApplySwitch bzApplySwitch;
    public String fromType;
    public boolean isBawuShow;
    public BarEmotionResponseMessage.ForumEmotionData mForumEmotionData;
    public String mForumId;
    public RecommendForumInfo mForumInfo;
    public boolean mIsComplaintShow;
    public boolean mIsHasData;
    public ForumDetailModel mModel;
    public PriManagerApplyInfo mPrivateApplyInfo;
    public List<SimpleThreadInfo> mThreadInfoList;
    public m47 mView;
    public ManagerElectionTab managerElectionTab;

    /* loaded from: classes3.dex */
    public class a implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ ForumDetailActivity b;

        public a(ForumDetailActivity forumDetailActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, dq4Var};
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
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
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
                this.a.mView.r(false);
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
                this.a.mView.r(false);
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
                this.a.mView.r(true);
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
                if (TextUtils.isEmpty(this.b.mForumId)) {
                    return null;
                }
                q57.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.mForumId), this.a);
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
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ForumDetailActivity forumDetailActivity = this.a;
                if (forumDetailActivity.mIsHasData) {
                    return;
                }
                if (z) {
                    forumDetailActivity.mView.j();
                    this.a.mView.u();
                    this.a.mModel.H(this.a.mForumId);
                    return;
                }
                forumDetailActivity.mView.i();
                this.a.mView.v(R.string.obfuscated_res_0x7f0f0f95);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && li.D()) {
                this.a.mView.j();
                this.a.mView.u();
                this.a.mModel.H(this.a.mForumId);
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
        this.isBawuShow = false;
        this.mIsComplaintShow = false;
        this.mIsHasData = false;
    }

    private List<SimpleThreadInfo> filterThreadList(List<SimpleThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list)) == null) {
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

    private void onResult() {
        List<SimpleThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mView.i();
            this.mView.j();
            if (this.mForumInfo == null && ((list = this.mThreadInfoList) == null || list.size() <= 0)) {
                this.mIsHasData = false;
                this.mView.v(R.string.obfuscated_res_0x7f0f0c4c);
                return;
            }
            this.mIsHasData = true;
            this.mThreadInfoList = filterThreadList(this.mThreadInfoList);
            this.mView.n(this.mForumInfo, this.isBawuShow, this.mIsComplaintShow, this.applyInfo, this.mPrivateApplyInfo, this.managerElectionTab, this.bzApplySwitch);
            this.mView.s(this.mThreadInfoList);
        }
    }

    private void requestNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (li.D()) {
                this.mView.u();
                this.mModel.H(this.mForumId);
                this.mModel.G(this.mForumId);
                return;
            }
            this.mView.i();
            this.mView.v(R.string.obfuscated_res_0x7f0f0f95);
            showToast(R.string.obfuscated_res_0x7f0f0c33);
        }
    }

    private void statistics() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String stringExtra = getIntent().getStringExtra("from_type");
            this.fromType = stringExtra;
            if (StringUtils.isNull(stringExtra)) {
                return;
            }
            if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else {
                str = this.fromType.equals(ForumDetailActivityConfig.FromType.BAR.toString()) ? "aio_side_2_sub" : "";
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                this.mModel.subscribeBar(false, this.mForumId);
            } else if (ex4.d().w() && ex4.d().t()) {
                this.mModel.subscribeBar(true, this.mForumId);
            } else {
                dq4 dq4Var = new dq4(getActivity());
                dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f05a5);
                dq4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f11a9), new a(this, dq4Var));
                dq4Var.create(getPageContext());
                dq4Var.show();
                this.mHandler.postDelayed(new b(this), 500L);
            }
        }
    }

    public void clearHistory() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.mForumId)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.mForumId), 4, null, 1)));
        sendMessage(new CustomMessage(2001151, String.valueOf(this.mForumId)));
    }

    public String getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fromType : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        BarEmotionResponseMessage.ForumEmotionData forumEmotionData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 11003 || (forumEmotionData = this.mForumEmotionData) == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.mForumInfo == null) {
                return;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.mForumEmotionData.url + "?forum_id=" + this.mForumInfo.forum_id)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        ManagerElectionTab managerElectionTab;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090316) {
                RecommendForumInfo recommendForumInfo = this.mForumInfo;
                if (recommendForumInfo == null || recommendForumInfo.forum_id == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.mForumInfo.forum_id), this.mForumInfo.forum_name)));
            } else if (id == R.id.obfuscated_res_0x7f09030f) {
                this.mView.t();
            } else if (id == R.id.obfuscated_res_0x7f090313) {
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                    return;
                }
                BarEmotionResponseMessage.ForumEmotionData forumEmotionData = this.mForumEmotionData;
                if (forumEmotionData == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.mForumInfo == null) {
                    return;
                }
                Activity pageActivity = getPageContext().getPageActivity();
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.mForumEmotionData.url + "?forum_id=" + this.mForumInfo.forum_id)));
            } else if (id == R.id.obfuscated_res_0x7f090315) {
                RecommendForumInfo recommendForumInfo2 = this.mForumInfo;
                if (recommendForumInfo2 != null) {
                    if (recommendForumInfo2.is_private_forum.intValue() == 0) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.mForumInfo.forum_name + "&fid=" + this.mForumInfo.forum_id});
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.mForumInfo.forum_id + "&fn=" + this.mForumInfo.forum_name + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f090311) {
                if (this.mForumInfo != null) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.mForumInfo.forum_id + "&nomenu=1"});
                }
            } else if (id == R.id.obfuscated_res_0x7f090318) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_ENTRANCE_DETAIL).eventStat();
                if (this.mForumInfo == null || (managerElectionTab = this.managerElectionTab) == null) {
                    return;
                }
                int intValue = managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.mForumInfo.forum_id.longValue(), 2)));
                } else if (intValue == 5) {
                    if (TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                        li.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02d4);
                    } else {
                        li.O(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                    }
                } else if (intValue != 1 || TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                } else {
                    li.O(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d02a0);
            m47 m47Var = new m47(this);
            this.mView = m47Var;
            m47Var.h().a(new f(this));
            this.mView.q(new g(this));
            this.mModel = new ForumDetailModel(this);
            this.mForumId = getIntent().getStringExtra("forum_id");
            requestNet();
            statistics();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onHttpEmotionResponseMessage(BarEmotionResponseMessage barEmotionResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, barEmotionResponseMessage) == null) || barEmotionResponseMessage == null) {
            return;
        }
        this.mView.m(barEmotionResponseMessage.data);
        this.mForumEmotionData = barEmotionResponseMessage.data;
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onHttpResponsedMessage(ForumDetailHttpResponse forumDetailHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumDetailHttpResponse) == null) {
            this.mForumInfo = forumDetailHttpResponse.getForumInfo();
            this.mThreadInfoList = forumDetailHttpResponse.getThreadInfoList();
            this.isBawuShow = forumDetailHttpResponse.isBawuShow() == 1;
            this.mIsComplaintShow = forumDetailHttpResponse.isComplaintShow();
            this.applyInfo = forumDetailHttpResponse.getApplyInfo();
            this.mPrivateApplyInfo = forumDetailHttpResponse.getPrivateApplyInfo();
            this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
            this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
            onResult();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onNetError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mView.i();
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.obfuscated_res_0x7f0f0c33);
            } else {
                showToast(str);
            }
            if (li.D()) {
                this.mView.v(R.string.obfuscated_res_0x7f0f0c4c);
            } else {
                this.mView.v(R.string.obfuscated_res_0x7f0f0f95);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            this.mView.l();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onSocketResponsedMessage(ForumDetailSocketResponse forumDetailSocketResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, forumDetailSocketResponse) == null) {
            this.mForumInfo = forumDetailSocketResponse.getForumInfo();
            this.mThreadInfoList = forumDetailSocketResponse.getThreadInfoList();
            this.isBawuShow = forumDetailSocketResponse.isBawuShow() == 1;
            this.mIsComplaintShow = forumDetailSocketResponse.isComplaintShow();
            this.applyInfo = forumDetailSocketResponse.getApplyInfo();
            this.mPrivateApplyInfo = forumDetailSocketResponse.getPrivateApplyInfo();
            this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
            this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
            onResult();
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onSubscrib(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f1229);
                saveAcceptNotify(true);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new c(this), 500L);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onUnSubscrib(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                showToast(R.string.obfuscated_res_0x7f0f1229);
                saveAcceptNotify(false);
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
                return;
            }
            this.mHandler.postDelayed(new d(this), 500L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onUserChanged(z);
            requestNet();
        }
    }

    public void saveAcceptNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            new e(this, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void setMsgManageVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mView.o(this.mForumInfo, z);
        }
    }

    public void setSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mView.r(z);
        }
    }

    public void updateLikeAndMsgStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mView.w(this.mForumInfo, z);
        }
    }
}
