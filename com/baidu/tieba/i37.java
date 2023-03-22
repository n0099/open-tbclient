package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
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
import com.baidu.card.view.BottomCommonTipLayout;
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
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ChatEntranceLoopData;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.dh5;
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
public class i37 implements yv5, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String i0;
    public static final String j0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public x57 D;
    public n87 E;
    public FragmentContainerView F;
    @NonNull
    public final dh5 G;
    public dh5.b H;
    public boolean I;
    public BottomCommonTipLayout J;
    public long K;
    public za L;
    public CustomMessageListener M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public HttpMessageListener P;
    public CustomMessageListener Q;
    public CustomMessageListener R;
    public Runnable S;
    public final CustomMessageListener T;
    public final CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public g87 a;
    public final CustomMessageListener a0;
    public FrsActivity b;
    public CustomMessageListener b0;
    public FrsFragment c;
    public CustomMessageListener c0;
    public FrsTabHostFragment d;
    public CustomMessageListener d0;
    public qa9 e;
    public final CustomMessageListener e0;
    public ex6 f;
    public CustomMessageListener f0;
    public boolean g;
    public final ItemCardHelper.c g0;
    public final Handler h;
    public Runnable h0;
    public String i;
    public String j;
    public int k;
    public String l;
    public int m;
    public ShareSuccessReplyToServerModel n;
    public boolean o;
    public FrameLayout p;
    public OvalActionButton q;
    public FRSRefreshButton r;
    public View s;
    public FrameLayout t;
    public LinearLayout u;
    public boolean v;
    public boolean w;
    public NavigationBarCoverTip x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* loaded from: classes4.dex */
        public class a extends qf5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s c;

            @Override // com.baidu.tieba.qf5
            public boolean d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = sVar;
            }

            @Override // com.baidu.tieba.qf5
            public TbFragmentTabIndicator c(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                    this.b = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.b;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.baidu.tieba.qf5
            public rf5 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.c.a.c.v());
                    bundle.putString("from", this.c.a.c.y3());
                    bundle.putString("forum_id", this.c.a.c.w());
                    bundle.putInt(TiebaStatic.Params.TAB_ID, 503);
                    bundle.putBoolean("can_auto_play_video", this.c.a.e.isFrsVideoAutoPlay);
                    boolean z = true;
                    if (this.c.a.e.needLog != 1) {
                        z = false;
                    }
                    bundle.putBoolean("need_log", z);
                    bundle.putBoolean("is_brand_forum", this.c.a.e.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.c.a.e);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    rf5 rf5Var = new rf5();
                    rf5Var.a = frsSportsRecommendFragment;
                    rf5Var.e = 25;
                    rf5Var.i = rf5.k;
                    return rf5Var;
                }
                return (rf5) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ex6)) {
                if (!m35.m().i(this.a.l, true)) {
                    jg.a().post(this.a.S);
                }
                ((ex6) customResponsedMessage.getData()).a(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

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
            public final /* synthetic */ x b;

            public a(x xVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {xVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = xVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.b != null) {
                    pj8.a(this.b.a.b.getPageContext(), this.a).show();
                }
            }
        }

        public x(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                jg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.f0();
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<f37> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.d == null) {
                    return;
                }
                for (f37 f37Var : newNotifyData) {
                    if (f37Var != null) {
                        for (int i2 = 0; i2 < this.a.f.f().size(); i2++) {
                            FragmentTabHost.c c2 = this.a.d.c2(i2);
                            if (c2 != null && (i = c2.a) != 1 && i != this.a.d.V1() && c2.a == f37Var.a() && f37Var.b() && c2.b.d(String.valueOf(c2.a)) != null) {
                                c2.b.d(String.valueOf(c2.a)).a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public b(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.s != null) {
                this.a.s.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.b, 2000);
                bdTopToast.h(false);
                bdTopToast.g(this.a.b.getString(R.string.frs_top_forum_rules_click_toast));
                bdTopToast.i((ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090bdc));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            this.a.o = true;
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
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
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                this.a.v = aVar.a();
                this.a.w = aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public d0(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jg.a().removeCallbacks(this);
                this.a.n0();
                jg.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.a.z = booleanValue;
                if (booleanValue) {
                    this.a.q.setVisibility(8);
                    this.a.B = false;
                    return;
                }
                this.a.q.setVisibility(0);
                this.a.B = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.L0();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof f77) && ((f77) customResponsedMessage.getData()).a != null) {
                View view2 = ((f77) customResponsedMessage.getData()).a;
                if (view2.getParent() != null) {
                    if (((ViewGroup) view2.getParent()) != this.a.t) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                        this.a.t.removeAllViews();
                        this.a.t.addView(view2);
                    }
                } else {
                    this.a.t.removeAllViews();
                    this.a.t.addView(view2);
                }
                this.a.t.setVisibility(0);
                return;
            }
            this.a.t.removeAllViews();
            this.a.t.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (this.a.c != null && this.a.H != null && this.a.c.P3() != null && this.a.c.P3().B() != null && (this.a.c.P3().B().b instanceof BaseFragment)) {
                    if (num.intValue() == 2 && this.a.H.getState() == 2) {
                        this.a.H.c();
                    } else if (num.intValue() == 0 && this.a.H.getState() == 1) {
                        if (this.a.b == null || this.a.b.u1() == null || !this.a.b.u1().b()) {
                            if (this.a.a != null && this.a.a.h()) {
                                return;
                            }
                            this.a.H.N0();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ChatRoomInfoData chatRoomInfoData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof ChatEntranceLoopData)) {
                ChatEntranceLoopData chatEntranceLoopData = (ChatEntranceLoopData) customResponsedMessage.getData();
                ChatRoomEntranceData entranceData = chatEntranceLoopData.getEntranceData();
                if (this.a.H != null && this.a.H.r1(chatEntranceLoopData.getUniqueId())) {
                    long j = 0;
                    if (this.a.K == 0) {
                        if (entranceData != null && !ListUtils.isEmpty(entranceData.getChatRoomInfoList()) && (chatRoomInfoData = entranceData.getChatRoomInfoList().get(0)) != null) {
                            i37 i37Var = this.a;
                            if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                                j = chatRoomInfoData.getChatroomInfoBasicData().getForumId();
                            }
                            i37Var.K = j;
                            return;
                        }
                        return;
                    }
                    if (entranceData == null || ListUtils.isEmpty(entranceData.getChatRoomInfoList()) || ListUtils.isEmpty(entranceData.getHotRoomList())) {
                        if (!this.a.I && this.a.F.getVisibility() != 8) {
                            this.a.F.setVisibility(8);
                        }
                    } else {
                        this.a.I = true;
                        this.a.T();
                    }
                    if (this.a.C && this.a.I && this.a.Y() != null) {
                        this.a.Y().B4(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003025));
                        this.a.C = false;
                    }
                    this.a.H.u(entranceData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b.b != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    Runnable runnable = this.a.b.b.c;
                    jg.a().removeCallbacks(runnable);
                    jg.a().post(runnable);
                    return;
                }
                jg.a().removeCallbacks(this.a.b.b.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof MemberBroadcastData) && this.a.e != null && this.a.e.isMemberBroadcastForum) {
                MemberBroadcastData memberBroadcastData = (MemberBroadcastData) customResponsedMessage.getData();
                MemberBroadcastHelper memberBroadcastHelper = new MemberBroadcastHelper(memberBroadcastData);
                boolean z3 = true;
                if (this.a.a != null && this.a.a.h()) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.a.b != null && this.a.b.u1() != null) {
                    z2 = this.a.b.u1().b();
                } else {
                    z2 = false;
                }
                z3 = (this.a.H == null || this.a.H.getState() != 2) ? false : false;
                if (this.a.b != null && this.a.b.x1() && memberBroadcastHelper.isMeetFrequency() && !z2 && !z) {
                    if (z3 && this.a.H != null) {
                        this.a.H.c();
                    }
                    this.a.J0(memberBroadcastData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(i37 i37Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = i37Var;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            qa9 qa9Var;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && !this.a.g && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                    qa9Var = frsPageHttpResponseMessage.getResponseData();
                    i = frsPageHttpResponseMessage.getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                    qa9Var = fRSPageSocketResponsedMessage.getResponseData();
                    i = fRSPageSocketResponsedMessage.getUpdateType();
                } else {
                    qa9Var = null;
                    i = -1;
                }
                if (qa9Var == null) {
                    return;
                }
                this.a.g = true;
                this.a.B0(qa9Var, true, i);
                if (qa9Var != null && qa9Var.getForum() != null && !StringUtils.isNull(qa9Var.getForum().getId())) {
                    cw4.b().l("2", qa9Var.getForum().getId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError()) {
                return;
            }
            this.a.g0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public n(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.H != null) {
                this.a.s.setVisibility(8);
                this.a.H.o1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public o(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.x == null) {
                    i37 i37Var = this.a;
                    i37Var.x = (NavigationBarCoverTip) i37Var.b.findViewById(R.id.obfuscated_res_0x7f0917e8);
                }
                a87.b(this.a.x, this.a.c, this.a.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public p(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i37 i37Var = this.a;
                boolean Q = i37Var.Q(i37Var.e.getGameTabInfo());
                if (Q && Q && this.a.d != null) {
                    this.a.d.o2(this.a.c);
                    this.a.d.l2(this.a.e, this.a.f);
                }
                if (this.a.b.isLoadingViewAttached()) {
                    this.a.b.hideLoadingView(this.a.b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public q(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.L = true;
                if (this.a.c != null) {
                    bundle = this.a.c.getArguments();
                } else {
                    bundle = null;
                }
                this.a.j0(bundle);
                if (this.a.b.isLoadingViewAttached()) {
                    this.a.b.hideLoadingView(this.a.b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public r(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.a.V() == 506) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.a.F.clearAnimation();
                    this.a.F.setAlpha(0.0f);
                    this.a.F.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof View)) {
                return;
            }
            ItemCardHelper.l(this.a.b, this.a.b.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090bdc));
        }
    }

    /* loaded from: classes4.dex */
    public class u implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public u(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.b, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090bdc), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.b, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090bdc), j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.g && this.a.e == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qa9)) {
                qa9 qa9Var = (qa9) customResponsedMessage.getData();
                if (qa9Var.getForum() == null || this.a.i == null || !this.a.i.equals(qa9Var.getForum().getName())) {
                    return;
                }
                this.a.B0(qa9Var, false, -1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        public w(i37 i37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i37Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    this.a.b.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.P();
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i37 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(i37 i37Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i37Var, Integer.valueOf(i)};
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
            this.a = i37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int c0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    c0 = this.a.c0(9);
                    if (c0 == -1) {
                        c0 = this.a.c0(2);
                    }
                } else {
                    c0 = this.a.c0(intValue);
                }
                if (c0 != -1 && this.a.m0() && this.a.d != null) {
                    this.a.d.m2(c0);
                    if (this.a.b0(c0) != 1) {
                        this.a.c.A4(false);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802652, "Lcom/baidu/tieba/i37;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802652, "Lcom/baidu/tieba/i37;");
                return;
            }
        }
        i0 = FrsFragment.class.getSimpleName();
        j0 = FrsTabHostFragment.class.getSimpleName();
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            jg.a().postDelayed(new b(this), 700L);
        }
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final FragmentManager X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            FrsActivity frsActivity = this.b;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.Y1();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public qa9 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.e;
        }
        return (qa9) invokeV.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.s.setVisibility(8);
        }
    }

    public final void g0() {
        BottomCommonTipLayout bottomCommonTipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (bottomCommonTipLayout = this.J) != null) {
            bottomCommonTipLayout.l();
        }
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return X().findFragmentById(R.id.obfuscated_res_0x7f090c23) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public final FrsTabHostFragment p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.d == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.d = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(j0);
                this.d.n2(this.k);
            }
            return this.d;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public i37(FrsActivity frsActivity) {
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
        this.g = false;
        this.h = new Handler();
        this.k = 0;
        this.o = false;
        this.y = false;
        this.B = true;
        this.C = true;
        this.G = ch5.a();
        this.I = false;
        this.L = new k(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.M = new v(this, 2001615);
        this.N = new y(this, 2921342);
        this.O = new z(this, 2001627);
        this.P = new a0(this, 0);
        this.Q = new b0(this, 2921518);
        this.R = new c0(this, 2921641);
        this.S = new d0(this);
        this.T = new e0(this, 2921788);
        this.U = new a(this, 2921789);
        this.V = new c(this, 2005016);
        this.W = new d(this, 2921369);
        this.X = new e(this, 2921586);
        this.Y = new f(this, 2921590);
        this.Z = new g(this, 2921761);
        this.a0 = new h(this, 2921763);
        this.b0 = new i(this, 2921764);
        this.c0 = new j(this, 2921774);
        this.d0 = new l(this, 2921775);
        this.e0 = new m(this, 2921769);
        this.f0 = new t(this, 2001440);
        this.g0 = new u(this);
        this.h0 = new w(this);
        this.b = frsActivity;
        this.l = m35.q("show_game_forem_tab_hot_point");
    }

    @Override // com.baidu.tieba.yv5
    public void z0(int i2, xv5 xv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048626, this, i2, xv5Var) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof yv5) {
                frsFragment.z0(i2, xv5Var);
            }
        }
    }

    public void E0(int i2) {
        FragmentContainerView fragmentContainerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (fragmentContainerView = this.F) != null) {
            fragmentContainerView.setVisibility(i2);
        }
    }

    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.k = i2;
        }
    }

    public void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.m = i2;
        }
    }

    @Override // com.baidu.tieba.yv5
    public void S(wv5 wv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, wv5Var) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof yv5) {
                frsFragment.S(wv5Var);
            }
        }
    }

    public void U(MotionEvent motionEvent) {
        dh5.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, motionEvent) == null) && (bVar = this.H) != null) {
            bVar.O0(motionEvent);
        }
    }

    @Override // com.baidu.tieba.yv5
    public xv5 Z0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof yv5) {
                return frsFragment.Z0(i2);
            }
            return null;
        }
        return (xv5) invokeI.objValue;
    }

    public final FrsFragment o0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, bundle)) == null) {
            if (this.c == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.c = frsFragment;
                frsFragment.setArguments(bundle);
                this.c.setBaseTag(i0);
            }
            FrsFragment frsFragment2 = this.c;
            frsFragment2.L = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    public void u0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, intent) == null) && (frsFragment = this.c) != null) {
            frsFragment.n4(intent);
        }
    }

    public void y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            bundle.putString("name", this.i);
            bundle.putInt("default_tab_id", this.k);
            bundle.putString("from", this.j);
        }
    }

    public void A0(String str) {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (qa9Var = this.e) != null && qa9Var.getForum() != null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.e.getForum().getId()).param("obj_type", 2));
        }
    }

    public void I0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) != null) || !this.I) {
            return;
        }
        if (i2 == 506) {
            if (this.F.getVisibility() != 8) {
                this.F.setVisibility(8);
            }
        } else if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
        }
    }

    public final int b0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            ex6 ex6Var = this.f;
            if (ex6Var == null || i2 >= ListUtils.getCount(ex6Var.f())) {
                return -1;
            }
            return this.f.f().get(i2).tab_id.intValue();
        }
        return invokeI.intValue;
    }

    public final int c0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            ex6 ex6Var = this.f;
            if (ex6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(ex6Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void i0(String str) {
        bh5 bh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && this.H == null) {
            dh5 dh5Var = this.G;
            FrsFragment frsFragment = this.c;
            if (frsFragment != null) {
                bh5Var = frsFragment.u3();
            } else {
                bh5Var = null;
            }
            this.H = dh5Var.b(str, bh5Var);
            xo5.a(this.b.getSupportFragmentManager(), R.id.obfuscated_res_0x7f09068c, this.H.d());
        }
    }

    public final void j0(Bundle bundle) {
        FragmentManager X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) && (X = X()) != null && !X.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = X.beginTransaction();
                FrsFragment o0 = o0(bundle);
                o0.U4(this.q);
                o0.W4(this.r);
                o0.V4(this.u);
                beginTransaction.add(R.id.obfuscated_res_0x7f090c23, o0);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void B0(qa9 qa9Var, boolean z2, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{qa9Var, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && qa9Var != null && qa9Var.getForum() != null && (frsActivity = this.b) != null && frsActivity.getPageContext() != null) {
            this.e = qa9Var;
            n87 n87Var = this.E;
            if (n87Var != null) {
                n87Var.c(qa9Var);
            }
            TbSingleton.getInstance().setFrsResponseData(qa9Var);
            ForumData forum = qa9Var.getForum();
            if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
                FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
            }
            x57 x57Var = this.D;
            if (x57Var != null) {
                x57Var.a(z2);
                this.D.b();
            }
            R(forum, qa9Var);
            if (forum.getIsShowBawuTask() && m35.m().n("key_bawu_task_toast", 0) == 0 && !this.y) {
                this.y = true;
                jg.a().postDelayed(new o(this), 30000L);
            }
            if (ListUtils.getCount(qa9Var.getGameTabInfo()) > 0) {
                this.h.post(new p(this));
            } else if (m0()) {
                this.h.post(new q(this));
            }
            C0();
            K0();
            if (forum.isLike() == 0 && TbadkCoreApplication.isLogin() && UbsABTestHelper.isFrsGuideABTest()) {
                g87 g87Var = new g87(this.c, this.e);
                this.a = g87Var;
                this.b.registerListener(g87Var.i);
            }
        }
    }

    public void q0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            if (!m0()) {
                this.c.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.V1()) {
                        this.c.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment U1 = this.d.U1();
                        if (U1 != null) {
                            U1.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        i09.g().m(this.b.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem != null && (str = shareItem.x) != null && (shareSuccessReplyToServerModel = this.n) != null) {
                            shareSuccessReplyToServerModel.R(str, intExtra2, new x(this));
                        }
                    }
                } else if (i2 == 13011) {
                    i09.g().m(this.b.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.d;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.d2() != null) {
                        this.d.d2().c(this.b.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.c;
                    if (frsFragment != null && frsFragment.v1() != null && this.c.v1().c0() != null && this.c.v1().c0().g != null) {
                        this.c.v1().c0().g.c(this.b.getPageContext());
                    }
                }
            }
        }
    }

    public final void C0() {
        qa9 qa9Var;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (qa9Var = this.e) != null && (themeColorInfo = qa9Var.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                themeElement = themeColorInfo.dark;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.q.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921571, themeElement));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.m != this.k && m0()) {
                this.d.m2(this.k);
                if (b0(this.k) != 1) {
                    this.c.A4(false);
                }
                this.m = this.k;
                H0(this.d.U1(), this.k);
                return;
            }
            this.c.n3();
        }
    }

    public final void T() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (V() == 506) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && this.F.getVisibility() != 0) {
                this.F.clearAnimation();
                this.F.setAlpha(0.0f);
                this.F.setVisibility(0);
                this.F.animate().alpha(1.0f).setDuration(700L).setStartDelay(300L).setListener(new r(this));
            }
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (!m0()) {
                this.c.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    Fragment U1 = frsTabHostFragment.U1();
                    if (U1 instanceof BaseFragment) {
                        ((BaseFragment) U1).setPrimary(false);
                    }
                }
            }
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                jg.a().postDelayed(this.h0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.f0);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.b.registerListener(1021074, this.P);
        }
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment != null && frsFragment.P3() != null && this.c.P3().B() != null) {
                return this.c.P3().B().a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public xf<TbImageView> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (!m0()) {
                FrsFragment frsFragment = this.c;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).a0();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment U1 = frsTabHostFragment.U1();
                if (U1 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) U1).a0();
                }
            }
            return null;
        }
        return (xf) invokeV.objValue;
    }

    public TbPageTag d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!m0()) {
                return this.c.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.V1()) {
                    return this.c.getTbPageTag();
                }
                Fragment U1 = this.d.U1();
                if (U1 instanceof BaseFragment) {
                    return ((BaseFragment) U1).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void k0() {
        FragmentManager X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (X = X()) != null && !X.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = X.beginTransaction();
                FrsTabHostFragment p0 = p0();
                p0.q2(this.q);
                p0.p2(this.r);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090c23, p0);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void n0() {
        ex6 ex6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (ex6Var = this.f) != null && !TextUtils.isEmpty(ex6Var.c())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.e.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (!m0()) {
                return this.c.w0();
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment U1 = frsTabHostFragment.U1();
            if (!(U1 instanceof VoiceManager.j)) {
                return null;
            }
            return ((VoiceManager.j) U1).w0();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void H0(Fragment fragment, int i2) {
        qa9 qa9Var;
        NavigationBar T0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, fragment, i2) != null) || !(fragment instanceof nx6) || (qa9Var = this.e) == null || qa9Var.getForum() == null || (T0 = ((nx6) fragment).T0()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.e.getForum().getName(), 5, true, true) + this.b.getActivity().getString(R.string.obfuscated_res_0x7f0f06bd));
        T0.setCenterTextTitle(sb.toString());
    }

    public final void R(ForumData forumData, qa9 qa9Var) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, forumData, qa9Var) == null) && forumData != null && !StringUtils.isNull(forumData.getId())) {
            String name = forumData.getName();
            if (forumData.isLike() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            long g2 = gg.g(forumData.getId(), 0L);
            if (g2 <= 0) {
                return;
            }
            this.K = g2;
            if (qa9Var != null && qa9Var.getUserData() != null && (qa9Var.getUserData().getIs_manager() == 1 || qa9Var.getUserData().getIs_bawu() == 1)) {
                z3 = true;
            } else {
                z3 = false;
            }
            dh5.b bVar = this.H;
            if (bVar != null) {
                bVar.z1(g2, name, z2, z3);
            }
        }
    }

    public final void J0(MemberBroadcastData memberBroadcastData) {
        String id;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, memberBroadcastData) == null) && this.b != null && memberBroadcastData != null) {
            if (this.J == null) {
                this.J = new BottomCommonTipLayout(this.b);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds151);
                layoutParams.gravity = 80;
                this.J.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds203), 0);
                this.J.setLayoutParams(layoutParams);
                ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
                if (viewGroup != null) {
                    viewGroup.addView(this.J);
                }
            }
            qa9 qa9Var = this.e;
            String str = "";
            if (qa9Var != null && qa9Var.getForum() != null && (id = this.e.getForum().getId()) != null) {
                str = id;
            }
            this.J.o(memberBroadcastData, "frs_vip_brd", 1, str);
        }
    }

    public final boolean Q(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (this.b.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.b;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (m0()) {
                return false;
            }
            this.c.L = true;
            D0();
            if (m35.m().i("frs_game_login_tip", true)) {
                m35.m().w("frs_login_tip", true);
                m35.m().w("frs_game_login_tip", false);
            }
            l0(list);
            if (this.c.P3() != null) {
                this.c.P3().V(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void K0() {
        qa9 qa9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (qa9Var = this.e) != null && qa9Var.getEntelechyTabInfo() != null && this.e.getEntelechyTabInfo().a != null) {
            if (this.b.getIntent() != null && FrsActivityConfig.FRS_FROM_ITEM.equals(this.b.getIntent().getStringExtra("from"))) {
                return;
            }
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.e.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
            }
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (!m0()) {
                this.c.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    Fragment U1 = frsTabHostFragment.U1();
                    if (U1 instanceof BaseFragment) {
                        ((BaseFragment) U1).setPrimary(true);
                    }
                }
            }
            g87 g87Var = this.a;
            if (g87Var != null) {
                g87Var.k(true);
                if (this.a.g()) {
                    this.a.e(null);
                }
            }
            if (this.o) {
                this.o = false;
                FrsFragment frsFragment = this.c;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            ItemCardHelper.w(this.g0);
            MessageManager.getInstance().registerListener(this.f0);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                eb5.q().w(downloadData);
            }
        }
    }

    public void h0(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, bundle) != null) || (frsActivity = this.b) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d031a);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090c23);
        this.p = frameLayout;
        n15.d(frameLayout).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.b.findViewById(R.id.obfuscated_res_0x7f090cd3);
        this.q = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.q.setHasShadow(false);
        View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f090e19);
        this.s = findViewById;
        findViewById.setOnClickListener(new n(this));
        this.t = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090bfe);
        this.r = (FRSRefreshButton) this.b.findViewById(R.id.obfuscated_res_0x7f090cf0);
        this.u = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090cad);
        this.F = (FragmentContainerView) this.b.findViewById(R.id.obfuscated_res_0x7f09068c);
        this.b.registerListener(this.W);
        this.L.getHttpMessageListener().setPriority(-1);
        this.L.getSocketMessageListener().setPriority(-1);
        this.b.registerListener(this.M);
        this.O.setSelfListener(true);
        this.b.registerListener(this.O);
        this.N.setSelfListener(true);
        this.b.registerListener(this.N);
        this.b.registerListener(this.V);
        if (bundle == null) {
            this.i = this.b.getIntent().getStringExtra("name");
            this.j = this.b.getIntent().getStringExtra("from");
            this.k = this.b.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.i = bundle.getString("name");
            this.j = bundle.getString("from");
            this.k = bundle.getInt("default_tab_id", 0);
        }
        j0(bundle);
        i0(this.i);
        this.c.Q4(this.H);
        this.D = new x57(this.b, this.c);
        this.n = new ShareSuccessReplyToServerModel();
        this.E = new n87(this.b);
        this.b.registerListener(this.L);
        this.b.registerListener(this.E.c);
        this.b.registerListener(this.E.d);
        this.b.registerListener(this.Q);
        this.b.registerListener(this.X);
        this.b.registerListener(this.R);
        this.b.registerListener(this.Z);
        this.a0.setTag(this.b.getUniqueId());
        this.b.registerListener(this.a0);
        this.b.registerListener(this.b0);
        this.Y.setPriority(Integer.MAX_VALUE);
        this.Y.setSelfListener(true);
        this.b.registerListener(this.Y);
        this.b.registerListener(this.c0);
        this.b.registerListener(this.d0);
        this.b.registerListener(this.e0);
        this.b.registerListener(this.T);
        this.b.registerListener(this.U);
    }

    public final void l0(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        k0();
        s sVar = new s(this, 2001616);
        sVar.setPriority(Integer.MAX_VALUE);
        sVar.setSelfListener(true);
        this.b.registerListener(sVar);
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = list.iterator();
        while (true) {
            boolean z2 = false;
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
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
            }
        }
        this.f = new ex6(this.b.getActivity(), arrayList);
        if (Y() != null) {
            this.f.j(Y().w());
            this.f.k(Y().v());
            if (Y().W0() != null && Y().W0().getForum() != null) {
                ForumData forum = Y().W0().getForum();
                this.f.i(forum.getForumGameLabel());
                this.f.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.c;
        frsFragment.L = false;
        new k37(frsFragment).g(this.f);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.b.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.b);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.b);
            }
            FrsFragment frsFragment = this.c;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            FrsActivity frsActivity = this.b;
            UtilHelper.setNavigationBarBackground(frsActivity, SkinManager.getColor(i2, frsActivity.getResources(), R.color.CAM_X0201), true);
            C0();
            this.G.onChangeSkinType(i2);
            BottomCommonTipLayout bottomCommonTipLayout = this.J;
            if (bottomCommonTipLayout != null) {
                bottomCommonTipLayout.g();
            }
            SkinManager.setBackgroundResource(this.s, R.color.common_color_10050);
        }
    }

    public void s0() {
        g87 g87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.c0);
            MessageManager.getInstance().unRegisterListener(this.d0);
            MessageManager.getInstance().unRegisterListener(this.e0);
            MessageManager.getInstance().unRegisterListener(this.T);
            MessageManager.getInstance().unRegisterListener(this.U);
            this.h.removeCallbacksAndMessages(null);
            if (this.b.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.b;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.S != null) {
                jg.a().removeCallbacks(this.S);
            }
            qa9 qa9Var = this.e;
            if (qa9Var != null && qa9Var.getForum() != null && (g87Var = this.a) != null) {
                g87Var.c(gg.g(this.e.getForum().getId(), 0L));
            }
            m35.m().w(this.l, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.n;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.c;
            if (frsFragment != null && frsFragment.Q0() != null) {
                this.c.Q0().Y0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.x;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.j)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.j)) {
                fe5.h().i(false);
            }
            jg.a().removeCallbacks(this.h0);
            ItemCardHelper.w(null);
            dh5.b bVar = this.H;
            if (bVar != null) {
                bVar.destroy();
            }
            this.G.a(null);
        }
    }

    public boolean t0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048620, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                    return false;
                } else if (this.A) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                    return true;
                } else if (m0() && (frsTabHostFragment = this.d) != null && frsTabHostFragment.g2()) {
                    this.d.f2();
                    UtilHelper.setNavigationBarBackground(this.b, this.d.T1());
                    return false;
                } else {
                    FrsFragment frsFragment = this.c;
                    if (frsFragment != null && frsFragment.isAdded()) {
                        if (this.c.onKeyDown(i2, keyEvent)) {
                            return true;
                        }
                        P();
                        return false;
                    }
                    return this.b.A1(i2, keyEvent);
                }
            } else if (i2 == 24) {
                FrsFragment frsFragment2 = this.c;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    return this.c.onKeyDown(i2, keyEvent);
                }
                return false;
            } else {
                return this.b.A1(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }
}
