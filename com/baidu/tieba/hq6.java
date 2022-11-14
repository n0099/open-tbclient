package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.gametab.AlaGameTabGetNewNotifyResponsedMessage;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class hq6 implements ap5, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String V;
    public static final String W;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public us6 C;
    public jv6 D;
    public qb E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public HttpMessageListener I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public Runnable L;
    public CustomMessageListener M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public CustomMessageListener R;
    public CustomMessageListener S;
    public final ItemCardHelper.c T;
    public Runnable U;
    public FrsActivity a;
    public FrsFragment b;
    public FrsTabHostFragment c;
    public ao8 d;
    public gk6 e;
    public boolean f;
    public final Handler g;
    public String h;
    public String i;
    public int j;
    public String k;
    public int l;
    public ShareSuccessReplyToServerModel m;
    public boolean n;
    public FrameLayout o;
    public OvalActionButton p;
    public FRSRefreshButton q;
    public FrameLayout r;
    public LinearLayout s;
    public boolean t;
    public boolean u;
    public NavigationBarCoverTip v;
    public boolean w;
    public cv6 x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* loaded from: classes4.dex */
        public class a extends oa5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i c;

            @Override // com.baidu.tieba.oa5
            public boolean d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = iVar;
            }

            @Override // com.baidu.tieba.oa5
            public TbFragmentTabIndicator c(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02f0, (ViewGroup) null);
                    this.b = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.b;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.baidu.tieba.oa5
            public pa5 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.c.a.b.c());
                    bundle.putString("from", this.c.a.b.o3());
                    bundle.putString("forum_id", this.c.a.b.k());
                    bundle.putInt(TiebaStatic.Params.TAB_ID, 503);
                    bundle.putBoolean("can_auto_play_video", this.c.a.d.isFrsVideoAutoPlay);
                    boolean z = true;
                    if (this.c.a.d.needLog != 1) {
                        z = false;
                    }
                    bundle.putBoolean("need_log", z);
                    bundle.putBoolean("is_brand_forum", this.c.a.d.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.c.a.d);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    pa5 pa5Var = new pa5();
                    pa5Var.a = frsSportsRecommendFragment;
                    pa5Var.e = 25;
                    pa5Var.i = pa5.k;
                    return pa5Var;
                }
                return (pa5) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gk6)) {
                if (!py4.k().h(this.a.k, true)) {
                    ah.a().post(this.a.L);
                }
                ((gk6) customResponsedMessage.getData()).a(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ n b;

            public a(n nVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.a != null) {
                    ty7.a(this.b.a.a.getPageContext(), this.a).show();
                }
            }
        }

        public n(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                ah.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                this.a.t = aVar.a();
                this.a.u = aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && ((Boolean) customResponsedMessage.getData()).booleanValue() && this.a.x != null) {
                this.a.x.i(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof kr8)) {
                kr8 kr8Var = (kr8) customResponsedMessage.getData();
                if (this.a.x != null && kr8Var != null && TbadkCoreApplication.isLogin()) {
                    this.a.x.f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(kr8Var.a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.a.z = booleanValue;
                if (booleanValue) {
                    this.a.p.setVisibility(8);
                    this.a.B = false;
                    return;
                }
                this.a.p.setVisibility(0);
                this.a.B = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof fu6) && ((fu6) customResponsedMessage.getData()).a != null) {
                View view2 = ((fu6) customResponsedMessage.getData()).a;
                if (view2.getParent() != null) {
                    if (((ViewGroup) view2.getParent()) != this.a.r) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                        this.a.r.removeAllViews();
                        this.a.r.addView(view2);
                    }
                } else {
                    this.a.r.removeAllViews();
                    this.a.r.addView(view2);
                }
                this.a.r.setVisibility(0);
                return;
            }
            this.a.r.removeAllViews();
            this.a.r.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        public f(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.v == null) {
                    hq6 hq6Var = this.a;
                    hq6Var.v = (NavigationBarCoverTip) hq6Var.a.findViewById(R.id.obfuscated_res_0x7f09169b);
                }
                av6.b(this.a.v, this.a.b, this.a.h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        public g(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hq6 hq6Var = this.a;
                boolean C = hq6Var.C(hq6Var.d.getGameTabInfo());
                if (C && C && this.a.c != null) {
                    this.a.c.e2(this.a.b);
                    this.a.c.b2(this.a.d, this.a.e);
                }
                if (this.a.a.isLoadingViewAttached()) {
                    this.a.a.hideLoadingView(this.a.a.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        public h(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.L = true;
                if (this.a.b != null) {
                    bundle = this.a.b.getArguments();
                } else {
                    bundle = null;
                }
                this.a.N(bundle);
                if (this.a.a.isLoadingViewAttached()) {
                    this.a.a.hideLoadingView(this.a.a.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof View)) {
                return;
            }
            ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090afc));
        }
    }

    /* loaded from: classes4.dex */
    public class k extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(hq6 hq6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ao8 ao8Var;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && !this.a.f && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                    ao8Var = frsPageHttpResponseMessage.getResponseData();
                    i = frsPageHttpResponseMessage.getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                    ao8Var = fRSPageSocketResponsedMessage.getResponseData();
                    i = fRSPageSocketResponsedMessage.getUpdateType();
                } else {
                    ao8Var = null;
                    i = -1;
                }
                if (ao8Var == null) {
                    return;
                }
                this.a.f = true;
                this.a.e0(ao8Var, true, i);
                if (ao8Var != null && ao8Var.getForum() != null && !StringUtils.isNull(ao8Var.getForum().getId())) {
                    nr4.b().l("2", ao8Var.getForum().getId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        public l(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090afc), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090afc), j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        public m(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    this.a.a.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.f && this.a.d == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao8)) {
                ao8 ao8Var = (ao8) customResponsedMessage.getData();
                if (ao8Var.getForum() == null || this.a.h == null || !this.a.h.equals(ao8Var.getForum().getName())) {
                    return;
                }
                this.a.e0(ao8Var, false, -1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.B();
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int I;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    I = this.a.I(9);
                    if (I == -1) {
                        I = this.a.I(2);
                    }
                } else {
                    I = this.a.I(intValue);
                }
                if (I != -1 && this.a.Q() && this.a.c != null) {
                    this.a.c.c2(I);
                    if (this.a.H(I) != 1) {
                        this.a.b.p4(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<eq6> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.c == null) {
                    return;
                }
                for (eq6 eq6Var : newNotifyData) {
                    if (eq6Var != null) {
                        for (int i2 = 0; i2 < this.a.e.f().size(); i2++) {
                            FragmentTabHost.c R1 = this.a.c.R1(i2);
                            if (R1 != null && (i = R1.a) != 1 && i != this.a.c.K1() && R1.a == eq6Var.a() && eq6Var.b() && R1.b.d(String.valueOf(R1.a)) != null) {
                                R1.b.d(String.valueOf(R1.a)).a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.a, 2000);
                bdTopToast.h(false);
                bdTopToast.g(this.a.a.getString(R.string.obfuscated_res_0x7f0f077f));
                bdTopToast.i((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090afc));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921641) {
                this.a.A = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        public u(hq6 hq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ah.a().removeCallbacks(this);
                this.a.R();
                ah.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(hq6 hq6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq6Var, Integer.valueOf(i)};
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
            this.a = hq6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            this.a.n = true;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832412, "Lcom/baidu/tieba/hq6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832412, "Lcom/baidu/tieba/hq6;");
                return;
            }
        }
        V = FrsFragment.class.getSimpleName();
        W = FrsTabHostFragment.class.getSimpleName();
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final FragmentManager E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsActivity frsActivity = this.a;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.N1();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public ao8 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (ao8) invokeV.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return E().findFragmentById(R.id.obfuscated_res_0x7f090b3a) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public final FrsTabHostFragment U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.c == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.c = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(W);
                this.c.d2(this.j);
            }
            return this.c;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public hq6(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = new Handler();
        this.j = 0;
        this.n = false;
        this.w = false;
        this.B = true;
        this.E = new k(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.F = new o(this, 2001615);
        this.G = new p(this, 2921342);
        this.H = new q(this, 2001627);
        this.I = new r(this, 0);
        this.J = new s(this, 2921518);
        this.K = new t(this, 2921641);
        this.L = new u(this);
        this.M = new v(this, 2005016);
        this.N = new a(this, 2921369);
        this.O = new b(this, 2001375);
        this.P = new c(this, 2001437);
        this.Q = new d(this, 2921586);
        this.R = new e(this, 2921590);
        this.S = new j(this, 2001440);
        this.T = new l(this);
        this.U = new m(this);
        this.a = frsActivity;
        this.k = py4.o("show_game_forem_tab_hot_point");
    }

    public final void P(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        O();
        i iVar = new i(this, 2001616);
        iVar.setPriority(Integer.MAX_VALUE);
        iVar.setSelfListener(true);
        this.a.registerListener(iVar);
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    FrsTabInfo frsTabInfo = (FrsTabInfo) it2.next();
                    if (frsTabInfo != null && frsTabInfo.tab_id == next.tab_id) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(next);
                }
            }
        }
        this.e = new gk6(this.a.getActivity(), arrayList);
        if (F() != null) {
            this.e.j(F().k());
            this.e.k(F().c());
            if (F().O0() != null && F().O0().getForum() != null) {
                ForumData forum = F().O0().getForum();
                this.e.i(forum.getForumGameLabel());
                this.e.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.b;
        frsFragment.L = false;
        new jq6(frsFragment).g(this.e);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.e);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // com.baidu.tieba.ap5
    public void M(yo5 yo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, yo5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof ap5) {
                frsFragment.M(yo5Var);
            }
        }
    }

    @Override // com.baidu.tieba.ap5
    public zo5 P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof ap5) {
                return frsFragment.P0(i2);
            }
            return null;
        }
        return (zo5) invokeI.objValue;
    }

    public final FrsFragment T(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bundle)) == null) {
            if (this.b == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.b = frsFragment;
                frsFragment.setArguments(bundle);
                this.b.setBaseTag(V);
            }
            FrsFragment frsFragment2 = this.b;
            frsFragment2.L = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    public void Z(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, intent) == null) && (frsFragment = this.b) != null) {
            frsFragment.c4(intent);
        }
    }

    public void c0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            bundle.putString("name", this.h);
            bundle.putInt("default_tab_id", this.j);
            bundle.putString("from", this.i);
        }
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.j = i2;
        }
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.l = i2;
        }
    }

    @Override // com.baidu.tieba.ap5
    public void o0(int i2, zo5 zo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i2, zo5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof ap5) {
                frsFragment.o0(i2, zo5Var);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l != this.j && Q()) {
                this.c.c2(this.j);
                if (H(this.j) != 1) {
                    this.b.p4(false);
                }
                this.l = this.j;
                j0(this.c.J1(), this.j);
                return;
            }
            this.b.c3();
        }
    }

    public TbPageTag J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!Q()) {
                return this.b.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.K1()) {
                    return this.b.getTbPageTag();
                }
                Fragment J1 = this.c.J1();
                if (J1 instanceof BaseFragment) {
                    return ((BaseFragment) J1).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void O() {
        FragmentManager E;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (E = E()) != null && !E.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = E.beginTransaction();
                FrsTabHostFragment U = U();
                U.g2(this.p);
                U.f2(this.q);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090b3a, U);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void R() {
        gk6 gk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (gk6Var = this.e) != null && !TextUtils.isEmpty(gk6Var.c())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.d.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public og<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!Q()) {
                FrsFragment frsFragment = this.b;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).S();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment J1 = frsTabHostFragment.J1();
                if (J1 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) J1).S();
                }
            }
            return null;
        }
        return (og) invokeV.objValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(1021074, this.I);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (!Q()) {
                return this.b.s0();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment J1 = frsTabHostFragment.J1();
            if (!(J1 instanceof VoiceManager.j)) {
                return null;
            }
            return ((VoiceManager.j) J1).s0();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final boolean C(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (Q()) {
                return false;
            }
            this.b.L = true;
            g0();
            if (py4.k().h("frs_game_login_tip", true)) {
                py4.k().u("frs_login_tip", true);
                py4.k().u("frs_game_login_tip", false);
            }
            P(list);
            if (this.b.E3() != null) {
                this.b.E3().X(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            gk6 gk6Var = this.e;
            if (gk6Var == null || i2 >= ListUtils.getCount(gk6Var.f())) {
                return -1;
            }
            return this.e.f().get(i2).tab_id.intValue();
        }
        return invokeI.intValue;
    }

    public final int I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            gk6 gk6Var = this.e;
            if (gk6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(gk6Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.e.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void N(Bundle bundle) {
        FragmentManager E;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) && (E = E()) != null && !E.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = E.beginTransaction();
                FrsFragment T = T(bundle);
                T.H4(this.p);
                T.J4(this.q);
                T.I4(this.s);
                beginTransaction.add(R.id.obfuscated_res_0x7f090b3a, T);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d0(String str) {
        ao8 ao8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && (ao8Var = this.d) != null && ao8Var.getForum() != null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.d.getForum().getId()).param("obj_type", 2));
        }
    }

    public void L(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, bundle) != null) || (frsActivity = this.a) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d02fe);
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090b3a);
        this.o = frameLayout;
        pw4.d(frameLayout).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.a.findViewById(R.id.obfuscated_res_0x7f090be9);
        this.p = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.p.setHasShadow(false);
        this.r = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090b15);
        this.q = (FRSRefreshButton) this.a.findViewById(R.id.obfuscated_res_0x7f090c06);
        this.s = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090bc3);
        this.a.registerListener(this.N);
        this.E.getHttpMessageListener().setPriority(-1);
        this.E.getSocketMessageListener().setPriority(-1);
        this.a.registerListener(this.F);
        this.H.setSelfListener(true);
        this.a.registerListener(this.H);
        this.G.setSelfListener(true);
        this.a.registerListener(this.G);
        this.a.registerListener(this.M);
        if (bundle == null) {
            this.h = this.a.getIntent().getStringExtra("name");
            this.i = this.a.getIntent().getStringExtra("from");
            this.j = this.a.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.h = bundle.getString("name");
            this.i = bundle.getString("from");
            this.j = bundle.getInt("default_tab_id", 0);
        }
        N(bundle);
        this.C = new us6(this.a, this.b);
        this.m = new ShareSuccessReplyToServerModel();
        this.D = new jv6(this.a);
        this.a.registerListener(this.E);
        this.a.registerListener(this.D.c);
        this.a.registerListener(this.D.d);
        this.a.registerListener(this.J);
        this.a.registerListener(this.Q);
        this.a.registerListener(this.K);
        this.R.setPriority(Integer.MAX_VALUE);
        this.R.setSelfListener(true);
        this.a.registerListener(this.R);
    }

    public void V(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) {
            if (!Q()) {
                this.b.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.K1()) {
                        this.b.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment J1 = this.c.J1();
                        if (J1 != null) {
                            J1.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        jf8.g().m(this.a.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem != null && (str = shareItem.x) != null && (shareSuccessReplyToServerModel = this.m) != null) {
                            shareSuccessReplyToServerModel.z(str, intExtra2, new n(this));
                        }
                    }
                } else if (i2 == 13011) {
                    jf8.g().m(this.a.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.c;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.S1() != null) {
                        this.c.S1().c(this.a.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.b;
                    if (frsFragment != null && frsFragment.j1() != null && this.b.j1().a0() != null && this.b.j1().a0().h != null) {
                        this.b.j1().a0().h.c(this.a.getPageContext());
                    }
                }
            }
        }
    }

    public final void e0(ao8 ao8Var, boolean z, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{ao8Var, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && ao8Var != null && ao8Var.getForum() != null && (frsActivity = this.a) != null && frsActivity.getPageContext() != null) {
            this.d = ao8Var;
            jv6 jv6Var = this.D;
            if (jv6Var != null) {
                jv6Var.c(ao8Var);
            }
            TbSingleton.getInstance().setFrsResponseData(ao8Var);
            ForumData forum = ao8Var.getForum();
            if (z && forum != null && !TextUtils.isEmpty(forum.getId())) {
                FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
            }
            us6 us6Var = this.C;
            if (us6Var != null) {
                us6Var.a(z);
                this.C.b();
            }
            if (forum.getIsShowBawuTask() && py4.k().l("key_bawu_task_toast", 0) == 0 && !this.w) {
                this.w = true;
                ah.a().postDelayed(new f(this), 30000L);
            }
            if (ListUtils.getCount(ao8Var.getGameTabInfo()) > 0) {
                this.g.post(new g(this));
            } else if (Q()) {
                this.g.post(new h(this));
            }
            f0();
            k0();
            if (z) {
                if ((!this.y || i2 == 4) && forum.isLike() == 0 && UbsABTestHelper.needShowFrsGuide() && TbadkCoreApplication.isLogin()) {
                    cv6 cv6Var = new cv6(this.b, this.d);
                    this.x = cv6Var;
                    this.a.registerListener(cv6Var.j);
                    this.a.registerListener(this.O);
                    this.a.registerListener(this.P);
                    if (!this.y) {
                        this.x.j().h(TbadkCoreApplication.getCurrentAccount(), forum.getId(), System.currentTimeMillis());
                        this.y = true;
                    }
                    this.x.h(forum);
                }
            }
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1 && skinType != 4) {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.a);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            }
            FrsFragment frsFragment = this.b;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            FrsActivity frsActivity = this.a;
            UtilHelper.setNavigationBarBackground(frsActivity, SkinManager.getColor(i2, frsActivity.getResources(), R.color.CAM_X0201), true);
            f0();
        }
    }

    public void X() {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
            this.g.removeCallbacksAndMessages(null);
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.L != null) {
                ah.a().removeCallbacks(this.L);
            }
            py4.k().u(this.k, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.m;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.J0() != null) {
                this.b.J0().G0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.v;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.i)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.i)) {
                b95.h().i(false);
            }
            cv6 cv6Var2 = this.x;
            if (cv6Var2 != null) {
                cv6Var2.m();
            }
            ao8 ao8Var = this.d;
            if (ao8Var != null && ao8Var.getForum() != null && (cv6Var = this.x) != null) {
                cv6Var.e(xg.g(this.d.getForum().getId(), 0L));
            }
            ah.a().removeCallbacks(this.U);
            ItemCardHelper.w(null);
        }
    }

    public boolean Y(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                    return false;
                } else if (this.A) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                    return true;
                } else if (Q() && (frsTabHostFragment = this.c) != null && frsTabHostFragment.W1()) {
                    this.c.V1();
                    UtilHelper.setNavigationBarBackground(this.a, this.c.I1());
                    return false;
                } else {
                    FrsFragment frsFragment = this.b;
                    if (frsFragment != null && frsFragment.isAdded()) {
                        if (this.b.b4(i2, keyEvent)) {
                            return true;
                        }
                        B();
                        return false;
                    }
                    return this.a.Y0(i2, keyEvent);
                }
            } else if (i2 == 24) {
                FrsFragment frsFragment2 = this.b;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    return this.b.b4(i2, keyEvent);
                }
                return false;
            } else {
                return this.a.Y0(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            cv6 cv6Var = this.x;
            if (cv6Var != null) {
                cv6Var.n(false);
                this.x.g();
            }
            if (!Q()) {
                this.b.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    Fragment J1 = frsTabHostFragment.J1();
                    if (J1 instanceof BaseFragment) {
                        ((BaseFragment) J1).setPrimary(false);
                    }
                }
            }
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                ah.a().postDelayed(this.U, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    public final void f0() {
        ao8 ao8Var;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (ao8Var = this.d) != null && (themeColorInfo = ao8Var.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.p.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921571, themeElement));
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (!Q()) {
                this.b.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.c;
                if (frsTabHostFragment != null) {
                    Fragment J1 = frsTabHostFragment.J1();
                    if (J1 instanceof BaseFragment) {
                        ((BaseFragment) J1).setPrimary(true);
                    }
                }
            }
            if (this.n) {
                this.n = false;
                FrsFragment frsFragment = this.b;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            cv6 cv6Var = this.x;
            if (cv6Var != null) {
                cv6Var.n(true);
                if (this.x.k()) {
                    this.x.i(null);
                }
            }
            ItemCardHelper.w(this.T);
            MessageManager.getInstance().registerListener(this.S);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                d65.q().w(downloadData);
            }
        }
    }

    public final void k0() {
        ao8 ao8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (ao8Var = this.d) != null && ao8Var.getEntelechyTabInfo() != null && this.d.getEntelechyTabInfo().a != null) {
            if (this.a.getIntent() != null && FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.getIntent().getStringExtra("from"))) {
                return;
            }
            boolean z = false;
            Iterator<FrsTabInfo> it = this.d.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z = true;
                    break;
                }
            }
            if (!z) {
            }
        }
    }

    public final void j0(Fragment fragment, int i2) {
        ao8 ao8Var;
        NavigationBar L0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048612, this, fragment, i2) != null) || !(fragment instanceof ok6) || (ao8Var = this.d) == null || ao8Var.getForum() == null || (L0 = ((ok6) fragment).L0()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.d.getForum().getName(), 5, true, true) + this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f067b));
        L0.setCenterTextTitle(sb.toString());
    }
}
