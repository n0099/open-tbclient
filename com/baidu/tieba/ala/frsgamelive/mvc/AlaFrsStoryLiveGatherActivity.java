package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ad6;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import com.baidu.tieba.f96;
import com.baidu.tieba.i95;
import com.baidu.tieba.yc6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public TextView c;
    public yc6 d;
    public AlaFrsStoryLiveGatherModel e;
    public String f;
    public String g;
    public AlaFrsStoryLiveGatherModel.b h;
    public f96 i;
    public i95.g j;
    public BdListView.p k;
    public ad6 l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

        public a(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

        public b(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12551"));
                this.a.sendMessage(new CustomMessage(2913033, new IntentConfig(this.a.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (this.a.d != null) {
                    AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.a;
                    alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.d.g());
                    this.a.d.e();
                }
                if (ListUtils.getCount(this.a.e.b0()) > 0 && this.a.d != null) {
                    this.a.showToast(str);
                    return;
                }
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = this.a;
                alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037a));
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = this.a;
                alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.d.g(), str, false);
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a.getPageContext() != null && this.a.d != null) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.a;
                alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.d.g());
                this.a.d.e();
                this.a.d.t(this.a.e.b0(), this.a.e.h0(), z);
                this.a.d.o(this.a.e.c0());
                if (ListUtils.getCount(this.a.e.b0()) == 0) {
                    AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = this.a;
                    alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037a));
                    AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = this.a;
                    alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.d.g(), this.a.getPageContext().getString(R.string.no_data_text), false);
                    return;
                }
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity4 = this.a;
                alaFrsStoryLiveGatherActivity4.hideNetRefreshView(alaFrsStoryLiveGatherActivity4.d.g());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f96 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.tieba.f96
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = this.a;
                alaFrsStoryLiveGatherActivity.x1(alaFrsStoryLiveGatherActivity.getPageContext(), threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

        public e(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.e != null) {
                this.a.e.j0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsStoryLiveGatherActivity a;

        public f(AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsStoryLiveGatherActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    z = this.a.e.i0();
                } else {
                    z = false;
                }
                if (this.a.d != null) {
                    if (z) {
                        this.a.d.w();
                    } else {
                        this.a.d.x();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ad6 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsStoryLiveGatherActivity;
        }

        @Override // com.baidu.tieba.ad6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.e != null && this.a.e.e0() != i) {
                this.a.e.setSortType(i);
                if (this.a.d != null) {
                    this.a.d.f().E();
                }
            }
        }
    }

    public AlaFrsStoryLiveGatherActivity() {
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
        this.h = new c(this);
        this.i = new d(this);
        this.j = new e(this);
        this.k = new f(this);
        this.l = new g(this);
    }

    public final AlaLiveInfoCoreData z1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.b;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.b.getBottomLine(), R.color.CAM_X0204);
            }
            View view2 = this.a;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.common_color_10274);
            }
            TextView textView = this.c;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            }
            yc6 yc6Var = this.d;
            if (yc6Var != null) {
                yc6Var.l(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.f = bundle.getString("forum_id");
                this.g = bundle.getString("forum_name");
            } else if (getIntent() != null) {
                this.f = getIntent().getStringExtra("forum_id");
                this.g = getIntent().getStringExtra("forum_name");
            } else {
                finish();
                return;
            }
            if (StringUtils.isNull(this.f)) {
                finish();
            }
            setContentView(y1());
            w1();
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = new AlaFrsStoryLiveGatherModel(getPageContext());
            this.e = alaFrsStoryLiveGatherModel;
            alaFrsStoryLiveGatherModel.k0(this.h);
            this.e.setForumId(this.f);
            this.e.j0();
        }
    }

    public void x1(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, tbPageContext, threadData) == null) && tbPageContext != null && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = threadData.getAuthor().getUserId();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, currentAccount);
                str = currentAccount;
            } else {
                str = "";
                z = false;
            }
            TiebaStatic.log(new StatisticItem("c12550").param("obj_param1", threadData.getAuthor().getUserId()));
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (ThreadData threadData2 : this.e.d0()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(z1(threadData2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
        }
    }

    public final View y1() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(1);
            this.a = new View(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.height = UtilHelper.getStatusBarHeight();
            }
            linearLayout.addView(this.a, layoutParams);
            NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
            this.b = navigationBar;
            navigationBar.setStatusBarVisibility(8);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0);
            this.c = this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f029c), new b(this));
            if (!StringUtils.isNull(this.g)) {
                string = this.g + " - 直播";
            } else {
                string = getResources().getString(R.string.frs_game_gather_title);
            }
            this.b.setCenterTextTitle(string);
            linearLayout.addView(this.b, new LinearLayout.LayoutParams(-1, -2));
            SkinManager.setBackgroundColor(this.b.getBottomLine(), R.color.CAM_X0204);
            yc6 yc6Var = new yc6(getPageContext(), false, false, getUniqueId());
            this.d = yc6Var;
            yc6Var.j();
            this.d.p(1);
            this.d.q(this.i);
            this.d.s(this.j);
            this.d.u(this.k);
            this.d.r(this.l);
            linearLayout.addView(this.d.g(), new LinearLayout.LayoutParams(-1, -1));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return linearLayout;
        }
        return (View) invokeV.objValue;
    }
}
