package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.l0.f;
import c.a.t0.s.r.e2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumId;
    public String forumName;
    public c.a.u0.a0.g.c.d frsLiveViewEvent;
    public f.g listPullRefreshListener;
    public AlaFrsStoryLiveGatherModel liveModel;
    public TextView mAllBtn;
    public c.a.u0.a0.g.c.b mLiveView;
    public NavigationBar mNavigationBar;
    public View mStatusBarView;
    public AlaFrsStoryLiveGatherModel.b modelCallback;
    public BdListView.p scrollToBottomListener;
    public c.a.u0.a0.e subCardClickListener;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f42312e;

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
            this.f42312e = alaFrsStoryLiveGatherActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f42312e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f42313e;

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
            this.f42313e = alaFrsStoryLiveGatherActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12551"));
                this.f42313e.sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(this.f42313e.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements AlaFrsStoryLiveGatherModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

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
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.getPageContext() == null || this.a.mLiveView == null) {
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.a;
            alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.mLiveView.g());
            this.a.mLiveView.e();
            this.a.mLiveView.t(this.a.liveModel.K(), this.a.liveModel.Q(), z);
            this.a.mLiveView.o(this.a.liveModel.L());
            if (ListUtils.getCount(this.a.liveModel.K()) == 0) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = this.a;
                alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = this.a;
                alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.mLiveView.g(), this.a.getPageContext().getString(R.string.no_data_text), false);
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity4 = this.a;
            alaFrsStoryLiveGatherActivity4.hideNetRefreshView(alaFrsStoryLiveGatherActivity4.mLiveView.g());
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.a.mLiveView != null) {
                    AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.a;
                    alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.mLiveView.g());
                    this.a.mLiveView.e();
                }
                if (ListUtils.getCount(this.a.liveModel.K()) > 0 && this.a.mLiveView != null) {
                    this.a.showToast(str);
                    return;
                }
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = this.a;
                alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = this.a;
                alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.mLiveView.g(), str, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements c.a.u0.a0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

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
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // c.a.u0.a0.e
        public void a(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.a;
                alaFrsStoryLiveGatherActivity.jumpToLiveRoom(alaFrsStoryLiveGatherActivity.getPageContext(), e2Var);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f42314e;

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
            this.f42314e = alaFrsStoryLiveGatherActivity;
        }

        @Override // c.a.t0.s.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f42314e.liveModel == null) {
                return;
            }
            this.f42314e.liveModel.S();
        }
    }

    /* loaded from: classes12.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity f42315e;

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
            this.f42315e = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean R = this.f42315e.liveModel != null ? this.f42315e.liveModel.R() : false;
                if (this.f42315e.mLiveView != null) {
                    if (R) {
                        this.f42315e.mLiveView.w();
                    } else {
                        this.f42315e.mLiveView.x();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements c.a.u0.a0.g.c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

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
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // c.a.u0.a0.g.c.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.liveModel == null || this.a.liveModel.N() == i2) {
                return;
            }
            this.a.liveModel.setSortType(i2);
            if (this.a.mLiveView != null) {
                this.a.mLiveView.f().startPullRefresh();
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
            new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, n.f(getPageContext().getPageActivity(), R.dimen.ds24), 0);
            this.mAllBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new b(this));
            if (!StringUtils.isNull(this.forumName)) {
                string = this.forumName + " - 直播";
            } else {
                string = getResources().getString(R.string.frs_game_gather_title);
            }
            this.mNavigationBar.setCenterTextTitle(string);
            linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
            SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            c.a.u0.a0.g.c.b bVar = new c.a.u0.a0.g.c.b(getPageContext(), false, false, getUniqueId());
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

    private AlaLiveInfoCoreData parseThreadToLiveCoreData(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, e2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
            alaLiveInfoCoreData.userName = e2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void jumpToLiveRoom(TbPageContext<?> tbPageContext, e2 e2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, e2Var) == null) || tbPageContext == null || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = e2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        TiebaStatic.log(new StatisticItem("c12550").param("obj_param1", e2Var.J().getUserId()));
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (e2 e2Var2 : this.liveModel.M()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(parseThreadToLiveCoreData(e2Var2));
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
            c.a.u0.a0.g.c.b bVar = this.mLiveView;
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
