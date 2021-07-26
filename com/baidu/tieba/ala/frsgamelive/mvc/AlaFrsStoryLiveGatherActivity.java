package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumId;
    public String forumName;
    public d.a.q0.v.e.c.d frsLiveViewEvent;
    public f.g listPullRefreshListener;
    public AlaFrsStoryLiveGatherModel liveModel;
    public TextView mAllBtn;
    public d.a.q0.v.e.c.b mLiveView;
    public NavigationBar mNavigationBar;
    public View mStatusBarView;
    public AlaFrsStoryLiveGatherModel.b modelCallback;
    public BdListView.p scrollToBottomListener;
    public d.a.q0.v.c subCardClickListener;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14261e;

        public a(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14261e = alaFrsStoryLiveGatherActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14261e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14262e;

        public b(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14262e = alaFrsStoryLiveGatherActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12551"));
                this.f14262e.sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(this.f14262e.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaFrsStoryLiveGatherModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14263a;

        public c(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14263a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14263a.getPageContext() == null || this.f14263a.mLiveView == null) {
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.f14263a;
            alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.mLiveView.g());
            this.f14263a.mLiveView.e();
            this.f14263a.mLiveView.t(this.f14263a.liveModel.K(), this.f14263a.liveModel.Q(), z);
            this.f14263a.mLiveView.o(this.f14263a.liveModel.L());
            if (ListUtils.getCount(this.f14263a.liveModel.K()) == 0) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = this.f14263a;
                alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = this.f14263a;
                alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.mLiveView.g(), this.f14263a.getPageContext().getString(R.string.no_data_text), false);
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity4 = this.f14263a;
            alaFrsStoryLiveGatherActivity4.hideNetRefreshView(alaFrsStoryLiveGatherActivity4.mLiveView.g());
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.f14263a.mLiveView != null) {
                    AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.f14263a;
                    alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.mLiveView.g());
                    this.f14263a.mLiveView.e();
                }
                if (ListUtils.getCount(this.f14263a.liveModel.K()) > 0 && this.f14263a.mLiveView != null) {
                    this.f14263a.showToast(str);
                    return;
                }
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = this.f14263a;
                alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = this.f14263a;
                alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.mLiveView.g(), str, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.q0.v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14264a;

        public d(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14264a = alaFrsStoryLiveGatherActivity;
        }

        @Override // d.a.q0.v.c
        public void a(b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.f14264a;
                alaFrsStoryLiveGatherActivity.jumpToLiveRoom(alaFrsStoryLiveGatherActivity.getPageContext(), b2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14265e;

        public e(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14265e = alaFrsStoryLiveGatherActivity;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14265e.liveModel == null) {
                return;
            }
            this.f14265e.liveModel.S();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14266e;

        public f(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14266e = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean R = this.f14266e.liveModel != null ? this.f14266e.liveModel.R() : false;
                if (this.f14266e.mLiveView != null) {
                    if (R) {
                        this.f14266e.mLiveView.w();
                    } else {
                        this.f14266e.mLiveView.x();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.q0.v.e.c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f14267a;

        public g(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14267a = alaFrsStoryLiveGatherActivity;
        }

        @Override // d.a.q0.v.e.c.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f14267a.liveModel == null || this.f14267a.liveModel.N() == i2) {
                return;
            }
            this.f14267a.liveModel.setSortType(i2);
            if (this.f14267a.mLiveView != null) {
                this.f14267a.mLiveView.f().F();
            }
        }
    }

    public AlaFrsStoryLiveGatherActivity() {
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
        this.modelCallback = new c(this);
        this.subCardClickListener = new d(this);
        this.listPullRefreshListener = new e(this);
        this.scrollToBottomListener = new f(this);
        this.frsLiveViewEvent = new g(this);
    }

    private void initModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = new AlaFrsStoryLiveGatherModel(getPageContext());
            this.liveModel = alaFrsStoryLiveGatherModel;
            alaFrsStoryLiveGatherModel.T(this.modelCallback);
            this.liveModel.setForumId(this.forumId);
            this.liveModel.S();
        }
    }

    private View onCreateView() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(1);
            this.mStatusBarView = new View(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.height = UtilHelper.getStatusBarHeight();
            }
            linearLayout.addView(this.mStatusBarView, layoutParams);
            NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
            this.mNavigationBar = navigationBar;
            navigationBar.setStatusBarVisibility(8);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0);
            this.mAllBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new b(this));
            if (!StringUtils.isNull(this.forumName)) {
                string = this.forumName + " - 直播";
            } else {
                string = getResources().getString(R.string.frs_game_gather_title);
            }
            this.mNavigationBar.setCenterTextTitle(string);
            linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
            SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            d.a.q0.v.e.c.b bVar = new d.a.q0.v.e.c.b(getPageContext(), false, false, getUniqueId());
            this.mLiveView = bVar;
            bVar.j();
            this.mLiveView.p(1);
            this.mLiveView.q(this.subCardClickListener);
            this.mLiveView.s(this.listPullRefreshListener);
            this.mLiveView.u(this.scrollToBottomListener);
            this.mLiveView.r(this.frsLiveViewEvent);
            linearLayout.addView(this.mLiveView.g(), new LinearLayout.LayoutParams(-1, -1));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return linearLayout;
        }
        return (View) invokeV.objValue;
    }

    private AlaLiveInfoCoreData parseThreadToLiveCoreData(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, b2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
            alaLiveInfoCoreData.userName = b2Var.H().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void jumpToLiveRoom(TbPageContext<?> tbPageContext, b2 b2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, b2Var) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.h1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        TiebaStatic.log(new StatisticItem("c12550").param("obj_param1", b2Var.H().getUserId()));
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (b2 b2Var2 : this.liveModel.M()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(parseThreadToLiveCoreData(b2Var2));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            }
            View view = this.mStatusBarView;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.common_color_10274);
            }
            TextView textView = this.mAllBtn;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            }
            d.a.q0.v.e.c.b bVar = this.mLiveView;
            if (bVar != null) {
                bVar.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.forumId = bundle.getString("forum_id");
                this.forumName = bundle.getString("forum_name");
            } else if (getIntent() != null) {
                this.forumId = getIntent().getStringExtra("forum_id");
                this.forumName = getIntent().getStringExtra("forum_name");
            } else {
                finish();
                return;
            }
            if (StringUtils.isNull(this.forumId)) {
                finish();
            }
            setContentView(onCreateView());
            initModel();
        }
    }
}
