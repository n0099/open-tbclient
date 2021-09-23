package com.baidu.tieba.im.forum.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes7.dex */
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
    public c.a.r0.k1.i.b.a mView;
    public ManagerElectionTab managerElectionTab;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f53190e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53191f;

        public a(ForumDetailActivity forumDetailActivity, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53191f = forumDetailActivity;
            this.f53190e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53190e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53192e;

        public b(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53192e = forumDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53192e.mView.n(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53193e;

        public c(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53193e = forumDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53193e.mView.n(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53194e;

        public d(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53194e = forumDetailActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53194e.mView.n(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f53195a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53196b;

        public e(ForumDetailActivity forumDetailActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53196b = forumDetailActivity;
            this.f53195a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.f53196b.mForumId)) {
                    return null;
                }
                c.a.r0.k1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f53196b.mForumId), this.f53195a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53197e;

        public f(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53197e = forumDetailActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                ForumDetailActivity forumDetailActivity = this.f53197e;
                if (forumDetailActivity.mIsHasData) {
                    return;
                }
                if (z) {
                    forumDetailActivity.mView.h();
                    this.f53197e.mView.q();
                    this.f53197e.mModel.F(this.f53197e.mForumId);
                    return;
                }
                forumDetailActivity.mView.g();
                this.f53197e.mView.r(R.string.refresh_view_title_text);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f53198e;

        public g(ForumDetailActivity forumDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53198e = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.D()) {
                this.f53198e.mView.h();
                this.f53198e.mView.q();
                this.f53198e.mModel.F(this.f53198e.mForumId);
            }
        }
    }

    public ForumDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = 0;
            for (SimpleThreadInfo simpleThreadInfo : list) {
                if (simpleThreadInfo != null) {
                    if (i2 >= 5) {
                        break;
                    }
                    i2++;
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mView.g();
            this.mView.h();
            if (this.mForumInfo == null && ((list = this.mThreadInfoList) == null || list.size() <= 0)) {
                this.mIsHasData = false;
                this.mView.r(R.string.no_data_common_txt);
                return;
            }
            this.mIsHasData = true;
            this.mThreadInfoList = filterThreadList(this.mThreadInfoList);
            this.mView.k(this.mForumInfo, this.isBawuShow, this.mIsComplaintShow, this.applyInfo, this.mPrivateApplyInfo, this.managerElectionTab, this.bzApplySwitch);
            this.mView.o(this.mThreadInfoList);
        }
    }

    private void requestNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (l.D()) {
                this.mView.q();
                this.mModel.F(this.mForumId);
                this.mModel.E(this.mForumId);
                return;
            }
            this.mView.g();
            this.mView.r(R.string.refresh_view_title_text);
            showToast(R.string.neterror);
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
            TiebaStatic.eventStat(getPageContext().getPageActivity(), str, PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
            if (switchState == BdSwitchView.SwitchState.OFF) {
                this.mModel.subscribeBar(false, this.mForumId);
            } else if (c.a.q0.t.d.d.d().s() && c.a.q0.t.d.d.d().p()) {
                this.mModel.subscribeBar(true, this.mForumId);
            } else {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
                aVar.setMessageId(R.string.error_open_personal_single_alloff);
                aVar.setNegativeButton(getResources().getString(R.string.signallforum_signnow), new a(this, aVar));
                aVar.create(getPageContext());
                aVar.show();
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        BarEmotionResponseMessage.ForumEmotionData forumEmotionData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1 || i2 != 11003 || (forumEmotionData = this.mForumEmotionData) == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.mForumInfo == null) {
                return;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.mForumEmotionData.url + "?forum_id=" + this.mForumInfo.forum_id)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        ManagerElectionTab managerElectionTab;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            int id = view.getId();
            if (id == R.id.bar_info_member_lay) {
                RecommendForumInfo recommendForumInfo = this.mForumInfo;
                if (recommendForumInfo == null || recommendForumInfo.forum_id == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.mForumInfo.forum_id), this.mForumInfo.forum_name)));
            } else if (id == R.id.bar_info_clean_lay) {
                this.mView.p();
            } else if (id == R.id.bar_info_history_lay) {
                sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), c.a.e.e.m.b.e(this.mForumId, 0))));
            } else if (id == R.id.bar_info_emotion_layout) {
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
            } else if (id == R.id.bar_info_manager_lay) {
                RecommendForumInfo recommendForumInfo2 = this.mForumInfo;
                if (recommendForumInfo2 != null) {
                    if (recommendForumInfo2.is_private_forum.intValue() == 0) {
                        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.mForumInfo.forum_name + "&fid=" + this.mForumInfo.forum_id});
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.mForumInfo.forum_id + "&fn=" + this.mForumInfo.forum_name + "&nomenu=1"});
                }
            } else if (id == R.id.bar_info_complaint_lay) {
                if (this.mForumInfo != null) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.mForumInfo.forum_id + "&nomenu=1"});
                }
            } else if (id == R.id.bar_manager_apply_lay) {
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
                        l.L(TbadkCoreApplication.getInst(), R.string.bar_election_finished);
                    } else {
                        l.M(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                    }
                } else if (intValue != 1 || TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                } else {
                    l.M(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.forum_detail_activity);
            c.a.r0.k1.i.b.a aVar = new c.a.r0.k1.i.b.a(this);
            this.mView = aVar;
            aVar.f().addNetworkChangeListener(new f(this));
            this.mView.m(new g(this));
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
        this.mView.j(barEmotionResponseMessage.data);
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
            this.mView.g();
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.neterror);
            } else {
                showToast(str);
            }
            if (l.D()) {
                this.mView.r(R.string.no_data_common_txt);
            } else {
                this.mView.r(R.string.refresh_view_title_text);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            this.mView.i();
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
                showToast(R.string.success);
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
                showToast(R.string.success);
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
            this.mView.l(this.mForumInfo, z);
        }
    }

    public void setSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mView.n(z);
        }
    }

    public void updateLikeAndMsgStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mView.s(this.mForumInfo, z);
        }
    }
}
