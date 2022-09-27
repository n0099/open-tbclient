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
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
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
import com.baidu.tieba.frs.FrsRecommendResMsg;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.gametab.AlaGameTabGetNewNotifyResponsedMessage;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class do6 implements in5, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String W;
    public static final String X;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public tq6 C;
    public HttpMessageListener D;
    public CustomMessageListener E;
    public pb F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public HttpMessageListener J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public Runnable M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public CustomMessageListener R;
    public CustomMessageListener S;
    public CustomMessageListener T;
    public final ItemCardHelper.c U;
    public Runnable V;
    public FrsActivity a;
    public FrsFragment b;
    public FrsTabHostFragment c;
    public zl8 d;
    public di6 e;
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
    public ct6 x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* renamed from: com.baidu.tieba.do6$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0225a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0225a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.d.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.a, "RecommendHistoryPage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof FrsRecommendResMsg)) {
                if (httpResponsedMessage.getError() == 0) {
                    FrsRecommendResMsg frsRecommendResMsg = (FrsRecommendResMsg) httpResponsedMessage;
                    int pushStatus = frsRecommendResMsg.getPushStatus();
                    String pushMsg = frsRecommendResMsg.getPushMsg();
                    if (pushStatus == 1) {
                        ScreenTopToast screenTopToast = new ScreenTopToast(this.a.a);
                        screenTopToast.m(this.a.a.getString(R.string.obfuscated_res_0x7f0f0757));
                        screenTopToast.l(this.a.a.getString(R.string.obfuscated_res_0x7f0f0756));
                        screenTopToast.k(this.a.a.getString(R.string.obfuscated_res_0x7f0f04f2));
                        screenTopToast.j(new View$OnClickListenerC0225a(this));
                        screenTopToast.n((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade));
                        return;
                    }
                    BdTopToast bdTopToast = new BdTopToast(this.a.a);
                    bdTopToast.h(false);
                    bdTopToast.g(pushMsg);
                    bdTopToast.i((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade));
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.a);
                bdTopToast2.h(false);
                bdTopToast2.g(httpResponsedMessage.getErrorString());
                bdTopToast2.i((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        public b(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gh.a().removeCallbacks(this);
                this.a.U();
                gh.a().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.n = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
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

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
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

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ip8)) {
                ip8 ip8Var = (ip8) customResponsedMessage.getData();
                if (this.a.x == null || ip8Var == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.a.x.f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(ip8Var.a));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
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

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof es6) || ((es6) customResponsedMessage.getData()).a == null) {
                this.a.r.removeAllViews();
                this.a.r.setVisibility(8);
                return;
            }
            View view2 = ((es6) customResponsedMessage.getData()).a;
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
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        public i(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.v == null) {
                    do6 do6Var = this.a;
                    do6Var.v = (NavigationBarCoverTip) do6Var.a.findViewById(R.id.obfuscated_res_0x7f091663);
                }
                at6.b(this.a.v, this.a.b, this.a.h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        public j(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                do6 do6Var = this.a;
                boolean D = do6Var.D(do6Var.d.getGameTabInfo());
                if (D && D && this.a.c != null) {
                    this.a.c.e2(this.a.b);
                    this.a.c.b2(this.a.d, this.a.e);
                }
                if (this.a.a.isLoadingViewAttached()) {
                    this.a.a.hideLoadingView(this.a.a.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        public k(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.L = true;
                this.a.O(this.a.b != null ? this.a.b.getArguments() : null);
                if (this.a.a.isLoadingViewAttached()) {
                    this.a.a.hideLoadingView(this.a.a.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.d.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.a, "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.a);
                screenTopToast.m(this.a.a.getString(R.string.obfuscated_res_0x7f0f0750));
                screenTopToast.k(this.a.a.getString(R.string.obfuscated_res_0x7f0f0752));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* loaded from: classes3.dex */
        public class a extends l95 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m c;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = mVar;
            }

            @Override // com.baidu.tieba.l95
            public m95 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.c.a.b.c());
                    bundle.putString("from", this.c.a.b.o3());
                    bundle.putString("forum_id", this.c.a.b.d());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean("can_auto_play_video", this.c.a.d.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", this.c.a.d.needLog == 1);
                    bundle.putBoolean("is_brand_forum", this.c.a.d.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.c.a.d);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    m95 m95Var = new m95();
                    m95Var.a = frsSportsRecommendFragment;
                    m95Var.e = 25;
                    m95Var.i = m95.k;
                    return m95Var;
                }
                return (m95) invokeV.objValue;
            }

            @Override // com.baidu.tieba.l95
            public TbFragmentTabIndicator c(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ee, (ViewGroup) null);
                    this.b = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.b;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.baidu.tieba.l95
            public boolean d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof di6)) {
                if (!ox4.k().h(this.a.k, true)) {
                    gh.a().post(this.a.M);
                }
                ((di6) customResponsedMessage.getData()).a(new a(this));
                this.a.P();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        public o(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade), j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade), 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        public p(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
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

    /* loaded from: classes3.dex */
    public class q implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ q b;

            public a(q qVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = qVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.a == null) {
                    return;
                }
                ow7.a(this.b.a.a.getPageContext(), this.a).show();
            }
        }

        public q(do6 do6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = do6Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                gh.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(do6 do6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = do6Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            zl8 zl8Var;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.f || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                zl8Var = frsPageHttpResponseMessage.getResponseData();
                i = frsPageHttpResponseMessage.getUpdateType();
            } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                zl8Var = fRSPageSocketResponsedMessage.getResponseData();
                i = fRSPageSocketResponsedMessage.getUpdateType();
            } else {
                zl8Var = null;
                i = -1;
            }
            if (zl8Var != null) {
                this.a.f = true;
                this.a.g0(zl8Var, true, i);
                if (zl8Var == null || zl8Var.getForum() == null || StringUtils.isNull(zl8Var.getForum().getId())) {
                    return;
                }
                tq4.b().l("2", zl8Var.getForum().getId());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.f && this.a.d == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zl8)) {
                zl8 zl8Var = (zl8) customResponsedMessage.getData();
                if (zl8Var.getForum() == null || this.a.h == null || !this.a.h.equals(zl8Var.getForum().getName())) {
                    return;
                }
                this.a.g0(zl8Var, false, -1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int J;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (10001 == intValue) {
                J = this.a.J(9);
                if (J == -1) {
                    J = this.a.J(2);
                }
            } else {
                J = this.a.J(intValue);
            }
            if (J == -1 || !this.a.R() || this.a.c == null) {
                return;
            }
            this.a.c.c2(J);
            if (this.a.I(J) != 1) {
                this.a.b.q4(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<ao6> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.c == null) {
                    return;
                }
                for (ao6 ao6Var : newNotifyData) {
                    if (ao6Var != null) {
                        for (int i2 = 0; i2 < this.a.e.f().size(); i2++) {
                            FragmentTabHost.b R1 = this.a.c.R1(i2);
                            if (R1 != null && (i = R1.a) != 1 && i != this.a.c.K1() && R1.a == ao6Var.a() && ao6Var.b() && R1.b.d(String.valueOf(R1.a)) != null) {
                                R1.b.d(String.valueOf(R1.a)).a.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.a, 2000);
                bdTopToast.h(false);
                bdTopToast.g(this.a.a.getString(R.string.obfuscated_res_0x7f0f076f));
                bdTopToast.i((ViewGroup) this.a.a.findViewById(R.id.obfuscated_res_0x7f090ade));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ do6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(do6 do6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {do6Var, Integer.valueOf(i)};
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
            this.a = do6Var;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711326, "Lcom/baidu/tieba/do6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711326, "Lcom/baidu/tieba/do6;");
                return;
            }
        }
        W = FrsFragment.class.getSimpleName();
        X = FrsTabHostFragment.class.getSimpleName();
    }

    public do6(FrsActivity frsActivity) {
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
        this.D = new a(this, CmdConfigHttp.CMD_FRS_RECOMMEND);
        this.E = new l(this, 2921465);
        this.F = new r(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.G = new s(this, 2001615);
        this.H = new t(this, 2921342);
        this.I = new u(this, 2001627);
        this.J = new v(this, 0);
        this.K = new w(this, 2921518);
        this.L = new x(this, 2921641);
        this.M = new b(this);
        this.N = new c(this, 2005016);
        this.O = new d(this, 2921369);
        this.P = new e(this, 2001375);
        this.Q = new f(this, 2001437);
        this.R = new g(this, 2921586);
        this.S = new h(this, 2921590);
        this.T = new n(this, 2001440);
        this.U = new o(this);
        this.V = new p(this);
        this.a = frsActivity;
        this.k = ox4.o("show_game_forem_tab_hot_point");
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.l != this.j && R()) {
                this.c.c2(this.j);
                if (I(this.j) != 1) {
                    this.b.q4(false);
                }
                this.l = this.j;
                l0(this.c.J1(), this.j);
                return;
            }
            this.b.c3();
        }
    }

    public final boolean D(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (R()) {
                return false;
            }
            this.b.L = true;
            i0();
            if (ox4.k().h("frs_game_login_tip", true)) {
                ox4.k().u("frs_login_tip", true);
                ox4.k().u("frs_game_login_tip", false);
            }
            Q(list);
            if (this.b.E3() != null) {
                this.b.E3().W(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final FragmentManager F() {
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

    public FrsFragment G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost H() {
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

    public final int I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            di6 di6Var = this.e;
            if (di6Var != null && i2 < ListUtils.getCount(di6Var.f())) {
                return this.e.f().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            di6 di6Var = this.e;
            if (di6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(di6Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.e.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public TbPageTag K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!R()) {
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

    public zl8 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.d : (zl8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.in5
    public void M(gn5 gn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gn5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof in5) {
                frsFragment.M(gn5Var);
            }
        }
    }

    public void N(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) || (frsActivity = this.a) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d02fc);
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090b1c);
        this.o = frameLayout;
        hv4.d(frameLayout).f(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.a.findViewById(R.id.obfuscated_res_0x7f090bcb);
        this.p = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.p.setHasShadow(false);
        this.r = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090af7);
        this.q = (FRSRefreshButton) this.a.findViewById(R.id.obfuscated_res_0x7f090be8);
        this.s = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090ba5);
        this.a.registerListener(this.O);
        this.F.getHttpMessageListener().setPriority(-1);
        this.F.getSocketMessageListener().setPriority(-1);
        this.a.registerListener(this.G);
        this.I.setSelfListener(true);
        this.a.registerListener(this.I);
        this.H.setSelfListener(true);
        this.a.registerListener(this.H);
        this.a.registerListener(this.N);
        if (bundle == null) {
            this.h = this.a.getIntent().getStringExtra("name");
            this.i = this.a.getIntent().getStringExtra("from");
            this.j = this.a.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.h = bundle.getString("name");
            this.i = bundle.getString("from");
            this.j = bundle.getInt("default_tab_id", 0);
        }
        O(bundle);
        this.C = new tq6(this.a, this.b);
        this.m = new ShareSuccessReplyToServerModel();
        this.a.registerListener(this.F);
        this.a.registerListener(this.D);
        this.a.registerListener(this.E);
        this.a.registerListener(this.K);
        this.a.registerListener(this.R);
        this.a.registerListener(this.L);
        this.S.setPriority(Integer.MAX_VALUE);
        this.S.setSelfListener(true);
        this.a.registerListener(this.S);
    }

    public final void O(Bundle bundle) {
        FragmentManager F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) || (F = F()) == null || F.isDestroyed()) {
            return;
        }
        try {
            FragmentTransaction beginTransaction = F.beginTransaction();
            FrsFragment V = V(bundle);
            V.I4(this.p);
            V.K4(this.q);
            V.J4(this.s);
            beginTransaction.add(R.id.obfuscated_res_0x7f090b1c, V);
            beginTransaction.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void P() {
        FragmentManager F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (F = F()) == null || F.isDestroyed()) {
            return;
        }
        try {
            FragmentTransaction beginTransaction = F.beginTransaction();
            FrsTabHostFragment W2 = W();
            W2.g2(this.p);
            W2.f2(this.q);
            beginTransaction.replace(R.id.obfuscated_res_0x7f090b1c, W2);
            beginTransaction.commitNowAllowingStateLoss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.in5
    public hn5 P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof in5) {
                return frsFragment.P0(i2);
            }
            return null;
        }
        return (hn5) invokeI.objValue;
    }

    public final void Q(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        m mVar = new m(this, 2001616);
        mVar.setPriority(Integer.MAX_VALUE);
        mVar.setSelfListener(true);
        this.a.registerListener(mVar);
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
        this.e = new di6(this.a.getActivity(), arrayList);
        if (G() != null) {
            this.e.j(G().d());
            this.e.k(G().c());
            if (G().O0() != null && G().O0().getForum() != null) {
                ForumData forum = G().O0().getForum();
                this.e.i(forum.getForumGameLabel());
                this.e.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.b;
        frsFragment.L = false;
        new fo6(frsFragment).g(this.e);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.e);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? F().findFragmentById(R.id.obfuscated_res_0x7f090b1c) instanceof FrsTabHostFragment : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ug<TbImageView> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!R()) {
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
        return (ug) invokeV.objValue;
    }

    public final boolean T(NewGodData newGodData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, newGodData)) == null) {
            return (((((System.currentTimeMillis() - ox4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) > ImagesInvalidService.FILE_VALID_TIME ? 1 : (((System.currentTimeMillis() - ox4.k().m("key_new_god_dialog_showed_time", 0L)) + 3000) == ImagesInvalidService.FILE_VALID_TIME ? 0 : -1)) < 0) || newGodData == null || !newGodData.isNewGodInvited()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void U() {
        di6 di6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (di6Var = this.e) == null || TextUtils.isEmpty(di6Var.c())) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021074);
        httpMessage.addParam("forum_id", this.d.getForum().getId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final FrsFragment V(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bundle)) == null) {
            if (this.b == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.b = frsFragment;
                frsFragment.setArguments(bundle);
                this.b.setBaseTag(W);
            }
            FrsFragment frsFragment2 = this.b;
            frsFragment2.L = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    public final FrsTabHostFragment W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.c == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.c = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(X);
                this.c.d2(this.j);
            }
            return this.c;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public void X(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) {
            if (!R()) {
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
                        ed8.g().m(this.a.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem == null || (str = shareItem.x) == null || (shareSuccessReplyToServerModel = this.m) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.z(str, intExtra2, new q(this));
                    }
                } else if (i2 == 13011) {
                    ed8.g().m(this.a.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.c;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.S1() != null) {
                        this.c.S1().o(this.a.getPageContext());
                        return;
                    }
                    FrsFragment frsFragment = this.b;
                    if (frsFragment == null || frsFragment.j1() == null || this.b.j1().Z() == null || this.b.j1().Z().h == null) {
                        return;
                    }
                    this.b.j1().Z().h.o(this.a.getPageContext());
                }
            }
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
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
            h0();
        }
    }

    public void Z() {
        ct6 ct6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.j);
            this.g.removeCallbacksAndMessages(null);
            if (this.a.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.a;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.M != null) {
                gh.a().removeCallbacks(this.M);
            }
            ox4.k().u(this.k, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.m;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.J0() != null) {
                this.b.J0().F0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.v;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.i)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.i)) {
                y75.h().i(false);
            }
            ct6 ct6Var2 = this.x;
            if (ct6Var2 != null) {
                ct6Var2.m();
            }
            zl8 zl8Var = this.d;
            if (zl8Var != null && zl8Var.getForum() != null && (ct6Var = this.x) != null) {
                ct6Var.e(dh.g(this.d.getForum().getId(), 0L));
            }
            gh.a().removeCallbacks(this.V);
            ItemCardHelper.v(null);
        }
    }

    public boolean a0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    FrsFragment frsFragment = this.b;
                    if (frsFragment == null || !frsFragment.isAdded()) {
                        return false;
                    }
                    return this.b.c4(i2, keyEvent);
                }
                return this.a.W0(i2, keyEvent);
            } else if (this.z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                return false;
            } else if (this.A) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                return true;
            } else if (R() && (frsTabHostFragment = this.c) != null && frsTabHostFragment.W1()) {
                this.c.V1();
                UtilHelper.setNavigationBarBackground(this.a, this.c.I1());
                return false;
            } else {
                FrsFragment frsFragment2 = this.b;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    if (this.b.c4(i2, keyEvent)) {
                        return true;
                    }
                    C();
                    return false;
                }
                return this.a.W0(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void b0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, intent) == null) || (frsFragment = this.b) == null) {
            return;
        }
        frsFragment.d4(intent);
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ct6 ct6Var = this.x;
            if (ct6Var != null) {
                ct6Var.n(false);
                this.x.g();
            }
            if (!R()) {
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
            uh5.g().i();
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                gh.a().postDelayed(this.V, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.T);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (!R()) {
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
            n0(this.d);
            ct6 ct6Var = this.x;
            if (ct6Var != null) {
                ct6Var.n(true);
                if (this.x.k()) {
                    this.x.i(null);
                }
            }
            ItemCardHelper.v(this.U);
            MessageManager.getInstance().registerListener(this.T);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                a55.q().w(downloadData);
            }
        }
    }

    public void e0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            bundle.putString("name", this.h);
            bundle.putInt("default_tab_id", this.j);
            bundle.putString("from", this.i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void f0(String str) {
        zl8 zl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || (zl8Var = this.d) == null || zl8Var.getForum() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.d.getForum().getId()).param("obj_type", 2));
    }

    public final void g0(zl8 zl8Var, boolean z, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{zl8Var, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || zl8Var == null || zl8Var.getForum() == null || (frsActivity = this.a) == null || frsActivity.getPageContext() == null) {
            return;
        }
        this.d = zl8Var;
        TbSingleton.getInstance().setFrsResponseData(zl8Var);
        ForumData forum = zl8Var.getForum();
        if (z && forum != null && !TextUtils.isEmpty(forum.getId())) {
            FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
        }
        tq6 tq6Var = this.C;
        if (tq6Var != null) {
            tq6Var.a(z);
            this.C.b();
        }
        if (forum.getIsShowBawuTask() && ox4.k().l("key_bawu_task_toast", 0) == 0 && !this.w) {
            this.w = true;
            gh.a().postDelayed(new i(this), 30000L);
        }
        if (ListUtils.getCount(zl8Var.getGameTabInfo()) > 0) {
            this.g.post(new j(this));
        } else if (R()) {
            this.g.post(new k(this));
        }
        h0();
        m0();
        if (z) {
            if ((!this.y || i2 == 4) && forum.isLike() == 0 && UbsABTestHelper.needShowFrsGuide() && TbadkCoreApplication.isLogin()) {
                ct6 ct6Var = new ct6(this.b, this.d);
                this.x = ct6Var;
                this.a.registerListener(ct6Var.j);
                this.a.registerListener(this.P);
                this.a.registerListener(this.Q);
                if (!this.y) {
                    this.x.j().h(TbadkCoreApplication.getCurrentAccount(), forum.getId(), System.currentTimeMillis());
                    this.y = true;
                }
                this.x.h(forum);
            }
        }
    }

    public final void h0() {
        zl8 zl8Var;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (zl8Var = this.d) == null || (themeColorInfo = zl8Var.getForum().getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
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

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(1021074, this.J);
        }
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.j = i2;
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.l = i2;
        }
    }

    public final void l0(Fragment fragment, int i2) {
        zl8 zl8Var;
        NavigationBar L0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048613, this, fragment, i2) == null) || !(fragment instanceof li6) || (zl8Var = this.d) == null || zl8Var.getForum() == null || (L0 = ((li6) fragment).L0()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.d.getForum().getName(), 5, true, true) + this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f066e));
        L0.setCenterTextTitle(sb.toString());
    }

    public final void m0() {
        zl8 zl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (zl8Var = this.d) == null || zl8Var.getEntelechyTabInfo() == null || this.d.getEntelechyTabInfo().a == null) {
            return;
        }
        if (this.a.getIntent() == null || !FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.getIntent().getStringExtra("from"))) {
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

    public void n0(zl8 zl8Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, zl8Var) == null) || zl8Var == null || zl8Var.getUserData() == null || zl8Var.getUserData().getNewGodData() == null || (frsFragment = this.b) == null || frsFragment.u3()) {
            return;
        }
        if (zl8Var.getForum() != null) {
            uh5.g().j(zl8Var.getForum().getId());
        }
        uh5.g().k(2, zl8Var.getUserData().getNewGodData());
        FrsFragment frsFragment2 = this.b;
        if (frsFragment2 != null) {
            frsFragment2.z4(T(zl8Var.getUserData().getNewGodData()));
            this.b.A4(T(zl8Var.getUserData().getNewGodData()));
        }
    }

    @Override // com.baidu.tieba.in5
    public void o0(int i2, hn5 hn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i2, hn5Var) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment instanceof in5) {
                frsFragment.o0(i2, hn5Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!R()) {
                return this.b.t0();
            }
            FrsTabHostFragment frsTabHostFragment = this.c;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment J1 = frsTabHostFragment.J1();
            if (J1 instanceof VoiceManager.j) {
                return ((VoiceManager.j) J1).t0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }
}
