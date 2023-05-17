package com.baidu.tieba.ala.alasquare;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BottomCommonTipLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ForumUserLiveActiivtyConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYYSubFragment;
import com.baidu.tieba.f66;
import com.baidu.tieba.p45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumUserLiveActivity extends BaseFragmentActivity implements f66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public View b;
    public LiveTabYYSubFragment c;
    public String d;
    public String e;
    public BottomCommonTipLayout f;
    public boolean g;
    public PollingModel h;
    public CustomMessageListener i;

    @Override // com.baidu.tieba.f66
    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumUserLiveActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumUserLiveActivity forumUserLiveActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumUserLiveActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumUserLiveActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof MemberBroadcastData)) {
                MemberBroadcastData memberBroadcastData = (MemberBroadcastData) customResponsedMessage.getData();
                MemberBroadcastHelper memberBroadcastHelper = new MemberBroadcastHelper(memberBroadcastData);
                if (!this.a.g || !memberBroadcastHelper.isMeetFrequency()) {
                    return;
                }
                this.a.w1(memberBroadcastData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumUserLiveActivity a;

        public b(ForumUserLiveActivity forumUserLiveActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumUserLiveActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumUserLiveActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.a();
            }
        }
    }

    public ForumUserLiveActivity() {
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
        this.i = new a(this, 2921774);
    }

    @Override // com.baidu.tieba.f66
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
            this.g = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            this.g = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.onChangeSkinType(getPageContext(), i);
            p45.d(this.b).f(R.color.CAM_X0202);
            LiveTabYYSubFragment liveTabYYSubFragment = this.c;
            if (liveTabYYSubFragment != null) {
                liveTabYYSubFragment.changeSkinType(i);
            }
            BottomCommonTipLayout bottomCommonTipLayout = this.f;
            if (bottomCommonTipLayout != null) {
                bottomCommonTipLayout.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0305);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091805);
            this.a = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f07a2));
            int i = 2;
            this.c = LiveTabYYSubFragment.X1(false, 2, 4);
            this.b = findViewById(R.id.obfuscated_res_0x7f090792);
            getSupportFragmentManager().beginTransaction().add(R.id.obfuscated_res_0x7f090792, this.c).commitAllowingStateLoss();
            this.e = getIntent().getStringExtra("KEY_FORUM_ID");
            String stringExtra = getIntent().getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
            this.d = getIntent().getStringExtra("from");
            this.c.I1(this.e, stringExtra);
            this.a.post(new b(this));
            StatisticItem param = new StatisticItem("c14703").param("fid", this.e);
            if (TextUtils.equals(ForumUserLiveActiivtyConfig.KEY_FROM_FRS_CARD, this.d)) {
                i = 1;
            }
            TiebaStatic.log(param.param("obj_source", i));
            registerListener(this.i);
            PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
            this.h = pollingModel;
            pollingModel.C0(PollingModel.MEMBER_BROADCAST);
        }
    }

    public final void w1(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, memberBroadcastData) != null) || memberBroadcastData == null) {
            return;
        }
        if (this.f == null) {
            this.f = new BottomCommonTipLayout(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds121);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            layoutParams.gravity = 80;
            this.f.setLayoutParams(layoutParams);
            ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
            if (viewGroup != null) {
                viewGroup.addView(this.f);
            }
        }
        BottomCommonTipLayout bottomCommonTipLayout = this.f;
        String str = this.e;
        if (str == null) {
            str = "";
        }
        bottomCommonTipLayout.o(memberBroadcastData, "frs_list_vip_brd", 2, str);
    }
}
