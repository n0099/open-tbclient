package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsBannerHeaderData;
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.eo9;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.FrsBannerHeaderView;
import com.baidu.tieba.frs.headercomponent.HeaderComponentNoHeaderController;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.FrsGroupChatSignGuideView;
import com.baidu.tieba.frs.view.FrsHeaderVideoImageShadeView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class ah7 extends os7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public CustomMessageListener A1;
    public LinearLayout B0;
    public CustomMessageListener B1;
    public View C0;
    public CustomMessageListener C1;
    public View D0;
    public CustomMessageListener D1;
    public View E0;
    public CustomMessageListener E1;
    public View F0;
    public View G0;
    public TbImageView H0;
    public TextView I0;
    public ImageView J0;
    public TBLottieAnimationView K0;
    public TbImageView L0;
    public boolean M0;
    public TextView N0;
    public final View O0;
    public final HeadImageView P0;
    public final TextView Q0;
    public final View R0;
    public final ImageView S0;
    public final TextView T0;
    public HotRankEntryView U0;
    public List<xn> V0;
    public yr6 W0;
    public int X0;
    public long Y0;
    public ScheduledExecutorService Z0;
    public boolean a1;
    public boolean b1;
    public boolean c1;
    public CountDownTimer d1;
    public boolean e1;
    @NonNull
    public final io7 f1;
    @NonNull
    public final mo7 g1;
    public TbVideoView h1;
    public TbImageView i1;
    public View j1;
    public View k1;
    public TBLottieAnimationView l1;
    public TextView m1;
    public TBLottieAnimationView n1;
    public View o1;
    public View p1;
    public View q1;
    public RelativeLayout r0;
    public View r1;
    public TextView s0;
    public FrsHeaderVideoImageShadeView s1;
    public TextView t0;
    public boolean t1;
    public String u0;
    public boolean u1;
    public ArrayList<TbImageView> v0;
    public MessageRedDotView v1;
    public if7 w0;
    public FrsViewData w1;
    public boolean x0;
    public FrsBannerHeaderView x1;
    public View y0;
    public FrsGroupChatSignGuideView y1;
    public View z0;
    public HeaderComponentNoHeaderController z1;

    @Override // com.baidu.tieba.os7
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ah7 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.G != null) {
                    if (this.a.b.G.getVisibility() == 8) {
                        this.a.b.G.setVisibility(0);
                        this.a.b.G.setText(this.a.a);
                        if (this.a.b.I != null) {
                            ah7 ah7Var = this.a.b;
                            ah7Var.E1(ah7Var.I.activity_msg, this.a.b.I.countdown_time.intValue());
                        }
                    } else if (this.a.b.G.getVisibility() == 0) {
                        this.a.b.k1();
                    }
                }
            }
        }

        public g(ah7 ah7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah7Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ ah7 c;

        public a(ah7 ah7Var, o25 o25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, o25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah7Var;
            this.a = o25Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.k1.getVisibility() == 0) {
                    this.c.h1.start();
                    return;
                }
                jr7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    hr7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ ah7 c;

        public b(ah7 ah7Var, o25 o25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, o25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah7Var;
            this.a = o25Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jr7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    hr7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ ah7 c;

        public c(ah7 ah7Var, o25 o25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, o25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah7Var;
            this.a = o25Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null && !r16.a(this.c.a.getPageActivity(), this.a.f()) && !TextUtils.isEmpty(this.a.e())) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.b.getForum().getId()) && this.b.getActivityHeadData() != null && !TextUtils.isEmpty(this.b.getActivityHeadData().c())) {
                    String id = this.b.getForum().getId();
                    String c = this.b.getActivityHeadData().c();
                    StatisticItem statisticItem = new StatisticItem("c13330");
                    statisticItem.param("fid", id);
                    statisticItem.param("obj_id", c);
                    TiebaStatic.log(statisticItem);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                    }
                    hr7.d(this.b, 1, this.c.b.getUniqueId());
                }
                if (wi.isEquals(TbadkCoreApplication.getInst().getPackageName(), this.a.g()) && !StringUtils.isNull(this.a.i()) && this.c.b.getPageContext() != null) {
                    UrlManager.getInstance().dealOneLink(this.c.b.getPageContext(), new String[]{this.a.i()});
                } else {
                    jr7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        public d(ah7 ah7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                ah.d(this.a.M, this.a.a.getPageActivity());
                this.a.b.c = false;
                ux4.x(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f06df), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        public e(ah7 ah7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    ah.c(this.a.M);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ah7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ah7 ah7Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, Long.valueOf(j), Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah7Var;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.H = false;
            if (this.b.G != null) {
                this.b.G.setVisibility(8);
            }
            if (this.b.Q != null && !this.b.j()) {
                this.b.Q.s(this.b.H, this.b.y1());
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b.G != null) {
                this.b.G.setVisibility(0);
                EMTextView eMTextView = this.b.G;
                eMTextView.setText(this.a + (j / 1000) + "s");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ah7 ah7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, Integer.valueOf(i)};
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
            this.a = ah7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof p15)) {
                p15 p15Var = (p15) customResponsedMessage.getData();
                this.a.F1(p15Var);
                this.a.s1(p15Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ah7 ah7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, Integer.valueOf(i)};
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
            this.a = ah7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && sr7.m(this.a.w1)) {
                this.a.D1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ah7 ah7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, Integer.valueOf(i)};
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
            this.a = ah7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (sr7.m(this.a.w1) && this.a.h1.getVisibility() == 0) {
                        this.a.D1();
                    }
                    this.a.u1 = false;
                } else if (intValue == 2 && sr7.m(this.a.w1)) {
                    if (!this.a.u1) {
                        ah7 ah7Var = this.a;
                        ah7Var.J(ah7Var.w1.getForum(), this.a.w1);
                    }
                    this.a.u1 = false;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ah7 ah7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, Integer.valueOf(i)};
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
            this.a = ah7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.t1 = true;
                if (intValue == 1) {
                    if (!FrsFragment.x2 && sr7.m(this.a.w1)) {
                        ah7 ah7Var = this.a;
                        ah7Var.J(ah7Var.w1.getForum(), this.a.w1);
                    }
                } else if (intValue == 2) {
                    if (sr7.m(this.a.w1)) {
                        ah7 ah7Var2 = this.a;
                        ah7Var2.J(ah7Var2.w1.getForum(), this.a.w1);
                    }
                } else if (intValue == 3) {
                    ah7 ah7Var3 = this.a;
                    ah7Var3.J(ah7Var3.w1.getForum(), this.a.w1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ah7 ah7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, Integer.valueOf(i)};
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
            this.a = ah7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            ah7 ah7Var = this.a;
            ah7Var.b2(ah7Var.w1);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRankInfoData a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ ah7 c;

        public m(ah7 ah7Var, FrsGameRankInfoData frsGameRankInfoData, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, frsGameRankInfoData, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah7Var;
            this.a = frsGameRankInfoData;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null) {
                UrlManager.getInstance().dealOneLink(this.c.a, new String[]{this.a.rankLink});
                this.c.K0.pauseAnimation();
                this.c.K0.setFrame(Cea708Decoder.COMMAND_DSW);
                this.c.a2(this.b, this.a, "c15056");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements if7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah7 a;

        public n(ah7 ah7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah7Var;
        }

        @Override // com.baidu.tieba.if7
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                rr7.d(this.a.b, this.a.w1, threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ ah7 c;

        public o(ah7 ah7Var, o25 o25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, o25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah7Var;
            this.a = o25Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.i1.setVisibility(8);
                    this.c.k1.setVisibility(8);
                    this.c.t1();
                    this.c.Q1(this.a, 0);
                    hr7.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.D1();
                    hr7.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.D1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.X1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements eo9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o25 a;
        public final /* synthetic */ ah7 b;

        public p(ah7 ah7Var, o25 o25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah7Var, o25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah7Var;
            this.a = o25Var;
        }

        @Override // com.baidu.tieba.eo9.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.Q1(this.a, i2);
        }
    }

    public ah7(FrsFragment frsFragment, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A0 = false;
        this.X0 = -1;
        this.Y0 = 1000L;
        this.e1 = false;
        this.f1 = ho7.a();
        this.A1 = new h(this, 2921679);
        this.B1 = new i(this, 2921681);
        this.C1 = new j(this, 2921680);
        this.D1 = new k(this, 2921682);
        this.E1 = new l(this, 2921721);
        this.v0 = new ArrayList<>();
        this.c0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        xi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        xi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        xi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07036f);
        this.f1140T = str;
        this.U = str2;
        View n1 = n1();
        this.d = n1;
        this.f1.c(frsFragment, n1);
        this.g1 = this.f1.e();
        this.r0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0907a1);
        this.v = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ee0);
        this.w = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090ee3);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090ee1);
        this.x = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.x.setDefaultBgResource(R.color.transparent);
        this.x.setDefaultResource(R.drawable.obfuscated_res_0x7f0811a7);
        this.y0 = this.d.findViewById(R.id.obfuscated_res_0x7f090f02);
        this.h1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f09286e);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f092868);
        this.i1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.i1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0811a7);
        this.i1.setDefaultResource(R.drawable.obfuscated_res_0x7f0811a7);
        this.i1.setPlaceHolder(2);
        this.j1 = this.d.findViewById(R.id.obfuscated_res_0x7f09286d);
        this.k1 = this.d.findViewById(R.id.obfuscated_res_0x7f09286c);
        this.l1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09286b);
        this.z0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d47);
        this.S = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cd8);
        ho7.d(this.y0, this.z0);
        this.o1 = ho7.b(this.d);
        this.p1 = this.d.findViewById(R.id.obfuscated_res_0x7f090ee2);
        this.q1 = this.d.findViewById(R.id.obfuscated_res_0x7f091600);
        this.m1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092745);
        this.n1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09164e);
        this.r1 = this.d.findViewById(R.id.obfuscated_res_0x7f092869);
        this.s1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f092867);
        this.B0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091455);
        int l2 = this.f1.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090efc);
        this.C0 = findViewById;
        findViewById.setVisibility(l2);
        this.D0 = this.d.findViewById(R.id.obfuscated_res_0x7f092122);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f090332);
        this.y = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f092124);
        this.z = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090c2a);
        this.F = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092949);
        this.B = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090d70);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d67);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f090d68);
        this.D = this.d.findViewById(R.id.obfuscated_res_0x7f092128);
        this.E = this.d.findViewById(R.id.obfuscated_res_0x7f092127);
        this.h = (List) this.f1.a(LogicField.LIKE_BTN);
        this.i = (List) this.f1.a(LogicField.SIGN_BTN);
        this.L = (ImageView) m1().a(LogicField.SPEED_ICON);
        this.s0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916f3);
        this.t0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091cc1);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0914d0);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0914c8);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091655);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091654);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916f8);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091cc7);
        this.n = (TextView) this.d.findViewById(R.id.forum_name);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09047c);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb5);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0320));
        this.N.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091e4a);
        this.v1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.v1.setEnterForumStyle(true);
        this.v1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f0914c9);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ec5);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09195b);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ed0);
        this.u = this.d.findViewById(R.id.obfuscated_res_0x7f090ed1);
        this.O0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d02);
        this.Q0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090d03);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d04);
        this.P0 = headImageView;
        headImageView.setIsRound(true);
        this.P0.setDrawBorder(true);
        this.P0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.P0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.R0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d01);
        this.S0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d00);
        this.T0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cff);
        WebPManager.setPureDrawable(this.S0, R.drawable.obfuscated_res_0x7f0809b3, R.color.CAM_X0101, null);
        this.K = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d038f, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d035d, (ViewGroup) null);
        this.U0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb3);
        this.m.setVisibility(8);
        this.G = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907df);
        this.m0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090eec);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f090dcc);
        TbImageView tbImageView3 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090dcb);
        this.H0 = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.H0.setConrers(15);
        this.H0.setRadiusById(R.string.J_X05);
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090dcf);
        this.I0 = textView;
        textView.getPaint().setStrokeWidth(0.5f);
        this.I0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.J0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090dcd);
        this.K0 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090dce);
        this.L0 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090dca);
        this.K0.setImageAssetsFolder("lottie_frs_game_rank_guide");
        this.K0.setAnimation(R.raw.lottie_frs_game_rank_guide);
        this.K0.setRepeatMode(1);
        this.K0.setMinAndMaxFrame(57, Cea708Decoder.COMMAND_DSW);
        this.x1 = (FrsBannerHeaderView) this.d.findViewById(R.id.obfuscated_res_0x7f090c41);
        this.y1 = (FrsGroupChatSignGuideView) this.d.findViewById(R.id.obfuscated_res_0x7f090c94);
        MessageManager.getInstance().registerListener(this.A1);
        MessageManager.getInstance().registerListener(this.B1);
        MessageManager.getInstance().registerListener(this.C1);
        MessageManager.getInstance().registerListener(this.D1);
        MessageManager.getInstance().registerListener(this.E1);
    }

    public final boolean u1(o25 o25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, o25Var)) == null) {
            if (o25Var == null || StringUtils.isNull(o25Var.c()) || StringUtils.isNull(o25Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.os7
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.f1.g(z);
        }
    }

    @Override // com.baidu.tieba.os7
    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            super.z(z);
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.k(z);
            }
        }
    }

    public final void E1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j2) == null) {
            this.H = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.Z0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new g(this, str), j2, TimeUnit.SECONDS);
        }
    }

    @Override // com.baidu.tieba.os7
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.l();
            }
            if (FrsFragment.x2 && sr7.m(this.w1)) {
                FrsFragment.x2 = false;
                J(this.w1.getForum(), this.w1);
            }
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i1.setVisibility(0);
            Q1(null, -1);
            t1();
            TbVideoView tbVideoView = this.h1;
            if (tbVideoView != null) {
                tbVideoView.T();
            }
            this.h1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.os7
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.B.i(this.X0);
        }
    }

    @Override // com.baidu.tieba.os7
    public void F() {
        FrsViewData frsViewData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.b != null && (frsViewData = this.w1) != null) {
            List<xn> showTopThreadList = frsViewData.getShowTopThreadList();
            if (showTopThreadList.size() > 2) {
                z = true;
            } else {
                z = false;
            }
            this.A0 = z;
            T1(showTopThreadList, this.w1.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.os7
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            bs7 bs7Var = this.Q;
            if (bs7Var != null) {
                bs7Var.q(this.b0);
            }
            r1(true);
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.N.N(this.u0, 10, false);
        }
    }

    @Override // com.baidu.tieba.os7
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            bs7 bs7Var = this.Q;
            if (bs7Var != null) {
                bs7Var.s(this.H, y1());
            }
            r1(false);
        }
    }

    public void J1() {
        as7 as7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (as7Var = this.R) != null) {
            as7Var.n();
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x1.setVisibility(8);
            this.E.setVisibility(8);
            this.C0.setVisibility(this.f1.l(LogicField.ROUND_CORNER_STYLE));
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.u0);
            this.X.getMedias().add(mediaData);
        }
    }

    public final boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.t1) {
                return true;
            }
            if (!this.b.j4() && !this.b.i4()) {
                return this.b.L3();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String U1() {
        InterceptResult invokeV;
        h25 h25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (!this.d0 && this.e0 && (h25Var = this.f0) != null) {
                return h25Var.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.c0 != 0) {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.os7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f1.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.os7
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SignActivityInfo signActivityInfo = this.I;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os7
    public SignActivityInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.I;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    @NonNull
    public io7 m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.f1;
        }
        return (io7) invokeV.objValue;
    }

    public View n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0383, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os7
    public void p() {
        yr6 yr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (yr6Var = this.W0) != null) {
            yr6Var.h();
            this.X0 = -1;
        }
    }

    public final LinearGradientView p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.T3() != null) {
                View D = this.b.T3().D();
                if (D instanceof LinearGradientView) {
                    return (LinearGradientView) D;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os7
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.x0;
        }
        return invokeV.booleanValue;
    }

    public final void t1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (tBLottieAnimationView = this.l1) != null) {
            tBLottieAnimationView.setVisibility(8);
            if (this.l1.isAnimating()) {
                this.l1.cancelAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.os7
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            FrsTopView frsTopView = this.B;
            if (frsTopView != null && frsTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null && serviceAreaView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int l2 = xi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.h1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.os7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            super.y();
            if (sr7.m(this.w1)) {
                D1();
            }
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.j();
            }
        }
    }

    public final boolean y1() {
        InterceptResult invokeV;
        h25 h25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (!this.d0 && this.e0 && (h25Var = this.f0) != null && !TextUtils.isEmpty(h25Var.c())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (frsViewData = this.w1) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && (themeElement = themeColorInfo.day) != null && themeColorInfo.night != null && (themeElement2 = themeColorInfo.dark) != null) {
            if (i2 == 4) {
                themeElement = themeElement2;
            }
            this.g1.b(themeElement);
            this.f1.b(themeElement);
            if (!this.x0) {
                LinearGradientView p1 = p1();
                LinearGradientView linearGradientView = this.w;
                if (linearGradientView != null && p1 != null) {
                    ThemeElement themeElement3 = themeColorInfo.day;
                    String str = themeElement3.light_color;
                    String str2 = themeElement3.dark_color;
                    ThemeElement themeElement4 = themeColorInfo.night;
                    String str3 = themeElement4.light_color;
                    String str4 = themeElement4.dark_color;
                    ThemeElement themeElement5 = themeColorInfo.dark;
                    linearGradientView.setGradientColor(str, str2, str3, str4, themeElement5.light_color, themeElement5.dark_color);
                }
                TbImageView tbImageView = this.x;
                if (tbImageView != null) {
                    tbImageView.N(themeElement.pattern_image, 10, false);
                }
            }
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.setThemeFontColor(eu8.b(themeElement.common_color));
            }
            if (this.B != null) {
                this.B.setUrlAndColor(forum.getTopIcon(), eu8.b(themeElement.common_color));
            }
        }
    }

    public final void F1(p15 p15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, p15Var) != null) || p15Var == null) {
            return;
        }
        if (!p15Var.e()) {
            if (this.m1.getVisibility() != 8) {
                this.m1.setVisibility(8);
            }
            if (this.n1.getVisibility() != 8) {
                this.n1.setVisibility(8);
                if (this.n1.isAnimating()) {
                    this.n1.cancelAnimation();
                }
            }
        } else if (p15Var.d() < p15Var.b()) {
            this.m1.setText(R.string.surprise_in_drop_down);
            N1();
        } else if (p15Var.d() < p15Var.c()) {
            this.m1.setText(R.string.surprise_continue_drop_down);
            N1();
        } else {
            this.m1.setText(R.string.surprise_when_release_hand);
            this.n1.setVisibility(4);
            if (this.n1.isAnimating()) {
                this.n1.cancelAnimation();
            }
        }
    }

    public final void R1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.Q0.setText(str);
                    this.P0.N(forumData.getManagers().get(0).portrait, 12, false);
                    this.O0.setVisibility(0);
                } else {
                    this.O0.setVisibility(8);
                }
                if (this.R0.getVisibility() == 0) {
                    this.R0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.O0.getVisibility() == 0) {
                this.O0.setVisibility(8);
            }
            if (this.R0.getVisibility() == 8) {
                this.R0.setVisibility(0);
            }
        }
    }

    public final void r1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && this.y1 != null) {
            String U1 = U1();
            if (!z && !TextUtils.isEmpty(U1)) {
                this.y1.d(U1);
                if (this.f0 != null) {
                    TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 1).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.U).param("fname", this.f1140T).param("room_id", this.f0.a()));
                    return;
                }
                return;
            }
            this.y1.a();
        }
    }

    public final void B1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        FrsGameRankInfoData frsGameRankInfoData = frsViewData.frsGameRankInfoData;
        if (frsGameRankInfoData == null) {
            this.G0.setVisibility(8);
            this.E.setVisibility(8);
            this.C0.setVisibility(this.f1.l(LogicField.ROUND_CORNER_STYLE));
            this.N.setUseStrokeColorInt(false);
            this.L0.setVisibility(8);
            this.K0.pauseAnimation();
            return;
        }
        this.G0.setVisibility(0);
        View view2 = this.E;
        if (this.y.getVisibility() == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        a2(frsViewData, frsGameRankInfoData, "c15055");
        this.C0.setVisibility(8);
        int b2 = eu8.b(frsGameRankInfoData.rankColor);
        if (eu8.a(b2)) {
            this.N.setUseStrokeColorInt(false);
        } else {
            this.N.setStrokeColorInt(b2);
            this.N.setUseStrokeColorInt(true);
        }
        if (!this.K0.isAnimating() && !this.M0) {
            int i3 = frsGameRankInfoData.showType;
            if (i3 < 0) {
                this.K0.setRepeatCount(-1);
                this.K0.u();
                this.M0 = true;
            } else if (i3 > 0) {
                this.K0.setRepeatCount(i3);
                this.K0.u();
                this.M0 = true;
            } else {
                this.K0.setFrame(Cea708Decoder.COMMAND_DSW);
            }
        }
        this.H0.N(frsGameRankInfoData.icon, 10, false);
        if (TextUtils.isEmpty(frsGameRankInfoData.rankIcon)) {
            this.L0.setVisibility(8);
        } else {
            this.L0.setVisibility(0);
            this.L0.N(frsGameRankInfoData.rankIcon, 10, false);
        }
        this.I0.setText(frsGameRankInfoData.rankName + "#" + frsGameRankInfoData.rankScore);
        this.G0.setOnClickListener(new m(this, frsGameRankInfoData, frsViewData));
    }

    public final void l1(x2a x2aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, x2aVar) == null) && x2aVar != null && this.w1 != null && !this.e1) {
            this.e1 = true;
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (x2aVar.getType() != 1) {
                if (x2aVar.getType() == 2) {
                    i2 = 7;
                } else if (x2aVar.getType() == 3) {
                    i2 = 8;
                } else if (x2aVar.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", x2aVar.c());
            ForumData forum = this.w1.getForum();
            if (forum != null) {
                statisticItem.param("fid", forum.getId());
                statisticItem.param("fname", forum.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
            }
            if (x2aVar.getType() == 1) {
                statisticItem.param("tid", x2aVar.m());
                statisticItem.param("thread_type", x2aVar.n());
            }
            if (StringUtils.isNull(x2aVar.q())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (YYLiveUtil.isYYLiveLink(x2aVar.p())) {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            } else {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean V1 = V1();
            this.x0 = V1;
            this.f1.f(V1);
            if (this.x0) {
                this.w.setVisibility(8);
                if (sr7.m(this.w1)) {
                    this.y0.setVisibility(4);
                } else {
                    this.y0.setVisibility(0);
                }
                this.z0.setVisibility(0);
            } else {
                this.y0.setVisibility(8);
                this.z0.setVisibility(8);
                this.w.setVisibility(0);
                this.x.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Z));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            this.f1.i(this.Z, this.a0);
            this.f1.d(this.Y, this.V);
            ArrayList<x15> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.f1140T = UtilHelper.getFixedText(this.f1140T, 7);
            } else if (this.k0) {
                this.f1140T = UtilHelper.getFixedText(this.f1140T, 6);
            }
            String f0 = yd7.f0(this.f1140T);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(f0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(f0);
            }
            this.f1.j(this.u0, f0);
            G1();
            F();
            A1(TbadkCoreApplication.getInst().getSkinType());
            H1();
            FrsViewData frsViewData = this.w1;
            if (frsViewData.frsBannerHeaderData != null) {
                z1(frsViewData);
            } else {
                B1(frsViewData);
            }
            i1();
        }
    }

    public final void H1() {
        FrsViewData frsViewData;
        View f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.a != null && (frsViewData = this.w1) != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                List<LiveFuseForumData> list = this.w1.liveFuseForumDataList;
                if (list.size() == 1 && list.get(0).type.intValue() == 7 && list.get(0).novel != null) {
                    HeaderComponentNoHeaderController headerComponentNoHeaderController = new HeaderComponentNoHeaderController(this.a, list.get(0));
                    this.z1 = headerComponentNoHeaderController;
                    f2 = headerComponentNoHeaderController.e();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    f2.setLayoutParams(layoutParams);
                    this.z1.h();
                } else {
                    this.n0 = new ml7(this.a, list);
                    if (this.w1.getForum() != null) {
                        this.n0.i(this.w1.getForum().getId(), this.w1.getForum().getName());
                    }
                    f2 = this.n0.f();
                    this.n0.d();
                }
                this.F0.setVisibility(8);
                this.m0.setVisibility(0);
                this.m0.removeAllViews();
                this.m0.addView(f2);
                return;
            }
            this.m0.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.os7
    public void U() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b7, (ViewGroup) null);
                this.M.setContentView(contentView);
                GreyUtil.grey(this.M);
                contentView.setOnClickListener(new d(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b1));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041a));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new e(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0916e1), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0921fd), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0923fc), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            ah.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public final void k1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.I == null) {
            return;
        }
        CountDownTimer countDownTimer = this.d1;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d1.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        boolean z3 = true;
        if ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis < 0) {
            z = true;
        } else {
            z = false;
        }
        this.a1 = z;
        if (this.I.activity_time.intValue() - currentTimeMillis <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.b1 = z2;
        if ((this.I.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis > 0) {
            z3 = false;
        }
        this.c1 = z3;
        boolean z4 = this.a1;
        if (z4) {
            this.G.setVisibility(8);
            return;
        }
        if (this.b1 && !z4) {
            Z1(this.I.activity_msg, 1000 * ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis), this.Y0);
        }
        if (!this.b1 && this.c1) {
            this.G.setVisibility(0);
            this.G.setText(this.I.countdown_msg);
            SignActivityInfo signActivityInfo = this.I;
            E1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (!this.c1) {
            SignActivityInfo signActivityInfo2 = this.I;
            E1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.os7
    public void D(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.j0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.j0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0b6f);
                if (f2 >= 1.0f) {
                    i2 = this.Y;
                } else {
                    i2 = this.Y + 1;
                }
                FrsViewData c1 = this.b.c1();
                if (c1 != null && c1.getForum() != null) {
                    c1.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c19, Integer.valueOf(i2)));
            } else {
                this.f1.d(this.Y, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c19, Integer.valueOf(this.Y)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, o1(this.Y)));
            if (this.j0) {
                if (f2 >= 1.0f) {
                    X(this.k, this.l0, f2);
                } else {
                    V(this.k, this.l0, f2);
                }
            } else {
                X(this.k, this.l0, f2);
            }
            this.l0 = f2;
        }
    }

    public final void h1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (relativeLayout = this.v) != null && relativeLayout.getLayoutParams() != null) {
            if (this.U0.getVisibility() == 0) {
                g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.U0.getLayoutParams()).topMargin = (xi.g(this.a.getPageActivity(), R.dimen.tbds226) + xi.u(this.a.getPageActivity())) - xi.g(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.x0) {
                g2 -= xi.g(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.x0) {
                if (sr7.m(this.w1)) {
                    g2 = P1(z, z2);
                } else {
                    g2 = I1(z, z2);
                }
            }
            if (this.G0.getVisibility() == 0 || this.x1.getVisibility() == 0) {
                g2 += xi.g(this.a.getPageActivity(), R.dimen.tbds125);
            }
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            if (layoutParams.height != g2) {
                layoutParams.height = g2;
                this.v.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.baidu.tieba.os7
    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.U0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.O0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.R0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.f1.h(onClickListener);
        }
    }

    public final void L1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            int g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.C0.getVisibility() != 0) {
                g2 -= xi.g(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.q1.getLayoutParams()).topMargin = i2 - g2;
        }
    }

    public final int I1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds782);
            int q1 = q1(z, z2);
            L1(g2);
            int i2 = g2 + q1;
            this.x.setVisibility(0);
            this.h1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.x.getLayoutParams()).bottomMargin = q1;
            ((RelativeLayout.LayoutParams) this.y0.getLayoutParams()).bottomMargin = q1;
            if (q1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds782) - xi.g(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void W1(FrsViewData frsViewData, o25 o25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, frsViewData, o25Var) == null) && this.x != null && o25Var != null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem("c13326");
                statisticItem.param("fid", frsViewData.getForum().getId());
                statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                hr7.e(frsViewData, 1, this.b.getUniqueId());
            }
            this.x.N(o25Var.d(), 10, false);
            this.x.setOnClickListener(new c(this, o25Var, frsViewData));
        }
    }

    public final void Y1(FrsViewData frsViewData, o25 o25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, frsViewData, o25Var) == null) {
            this.i1.setVisibility(0);
            Q1(null, -1);
            this.i1.N(o25Var.c(), 10, false);
            if (this.h1.getVisibility() != 0) {
                this.h1.setVisibility(0);
            }
            this.h1.setVideoPath(o25Var.h());
            this.h1.setVolume(0.0f, 0.0f);
            this.h1.setVideoScalingMode(0);
            this.h1.J(true);
            this.h1.setLooping(false);
            this.h1.setVideoStatusChangeListener(new o(this, o25Var, frsViewData));
            this.h1.getMediaProgressObserver().j(new p(this, o25Var));
            if (hr7.f()) {
                this.k1.setVisibility(8);
                if (this.b != null && !this.w1.isFromCache && S1()) {
                    this.h1.start();
                }
            } else {
                this.k1.setVisibility(0);
            }
            this.i1.setOnClickListener(new a(this, o25Var, frsViewData));
            this.h1.setOnClickListener(new b(this, o25Var, frsViewData));
            FrsFragment frsFragment = this.b;
            if (frsFragment != null) {
                hr7.e(frsViewData, 2, frsFragment.getUniqueId());
            }
        }
    }

    public final int q1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<xn> list;
        List<t3a> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                s3a s3aVar = this.w1.serviceAreaData;
                if (s3aVar != null && (list2 = s3aVar.b) != null && list2.size() == 1) {
                    i2 = 0 + xi.g(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + xi.g(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.V0) != null) {
                i2 += Math.min(list.size(), 2) * xi.g(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.z.getVisibility() == 0) {
                i2 += xi.g(this.a.getPageActivity(), R.dimen.tbds231);
            }
            if (z2 || z || this.z.getVisibility() == 0) {
                return i2 + xi.g(this.a.getPageActivity(), R.dimen.tbds45);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.os7
    public void J(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, forumData, frsViewData) != null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.u1 = true;
        if (sr7.m(this.w1)) {
            D1();
        }
        this.f1140T = forumData.getName();
        this.U = forumData.getId();
        this.Z = forumData.getMember_num();
        this.a0 = forumData.getPost_num();
        forumData.getTag_color();
        this.u0 = forumData.getImage_url();
        this.V = forumData.getLevelName();
        this.Y = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.b0 = forumData.getSignData().miss_sign_num;
            this.e0 = forumData.getSignData().showGuideToChatRoom;
            this.f0 = forumData.getSignData().chatRoomGuideData;
        }
        forumData.getCurScore();
        forumData.getLevelupScore();
        this.P = forumData.getBadgeData();
        forumData.getAccelerateContent();
        this.k0 = forumData.isBrandForum;
        this.w1 = frsViewData;
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.f1140T)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.w1;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.w1.getHotUserRankData().hot_user != null && this.w1.getHotUserRankData().hot_user.size() >= 3) {
            this.y.setHasHotRankList(true);
        } else {
            this.y.setHasHotRankList(false);
        }
        int l2 = this.f1.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.w1;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.y.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.y.setVisibility(0);
            this.D0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.y;
            FrsViewData frsViewData4 = this.w1;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.y.setVisibility(8);
            this.D0.setVisibility(8);
        }
        this.X = new ThreadData();
        M1();
        C1();
        if (this.w1.getActivityHeadData() != null && this.w1.getActivityHeadData().a() != null) {
            ArrayList<o25> b2 = this.w1.getActivityHeadData().b();
            o25 o25Var = null;
            if (!ListUtils.isEmpty(b2)) {
                o25Var = b2.get(0);
            }
            this.N0 = ho7.c(this.d, u1(o25Var));
            if (this.x0 && this.w1.getActivityHeadData().a().h) {
                this.N0.setVisibility(0);
            } else {
                this.N0.setVisibility(8);
            }
        }
        R1(forumData);
        if (frsViewData != null) {
            this.I = frsViewData.mSignActivityInfo;
            k1();
        }
        this.w1 = frsViewData;
        b2(frsViewData);
    }

    public final void T1(List<xn> list, x2a x2aVar) {
        ForumData forumData;
        ForumData forumData2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048603, this, list, x2aVar) != null) || this.B == null) {
            return;
        }
        this.V0 = list;
        FrsViewData frsViewData = this.w1;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.w1.getVoiceRoomData().a().size() > 0) {
            this.F.setVisibility(0);
            this.F.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.w1.getVoiceRoomData().a())) {
                if (this.w1.getVoiceRoomData().a().size() > 5) {
                    this.F.setShowMore(true);
                } else {
                    this.F.setShowMore(false);
                }
            }
            this.F.a(this.w1.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.F.setVisibility(8);
            }
        }
        UserData userData = null;
        if (x2aVar != null) {
            this.A = new hg7(this.a.getPageActivity());
            this.z.setVisibility(0);
            this.z.addView(this.A.f());
            FrsViewData frsViewData2 = this.w1;
            if (frsViewData2 != null) {
                forumData2 = frsViewData2.getForum();
            } else {
                forumData2 = null;
            }
            hg7 hg7Var = this.A;
            FrsViewData frsViewData3 = this.w1;
            if (frsViewData3 != null && !frsViewData3.isFromCache) {
                z = false;
            } else {
                z = true;
            }
            hg7Var.e(forumData2, x2aVar, z);
            l1(x2aVar);
        } else {
            this.z.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.F;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.F0.setVisibility(8);
        } else {
            ViewGroup viewGroup = this.m0;
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                this.F0.setVisibility(8);
            } else {
                this.F0.setVisibility(this.f1.l(LogicField.TOP_DIVIDER));
            }
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.m4()) {
            this.B.setVisibility(0);
            this.B.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.w1;
            if (frsViewData4 != null) {
                forumData = frsViewData4.getForum();
            } else {
                forumData = null;
            }
            FrsViewData frsViewData5 = this.w1;
            if (frsViewData5 != null) {
                userData = frsViewData5.getUserData();
            }
            this.B.setForum(this.U, this.f1140T, forumData, userData, this.b.getFrom());
            if (list.size() > 0 && (list.get(0) instanceof g3a)) {
                this.X0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof g3a)) {
                this.X0 = 1;
            } else {
                this.X0 = -1;
            }
            this.B.setDatas(list, x2aVar);
            if (this.w0 == null) {
                this.w0 = new n(this);
            }
            this.B.setStatListener(this.w0);
            return;
        }
        this.B.setVisibility(8);
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TextView textView = this.m1;
            if (textView != null && textView.getVisibility() == 8) {
                this.m1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.n1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.n1.getVisibility() == 4) {
                    this.n1.setVisibility(0);
                    if (this.n1.isAnimating()) {
                        this.n1.cancelAnimation();
                    }
                    this.n1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.n1.setRepeatCount(-1);
                    this.n1.playAnimation();
                }
            }
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            int l2 = xi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.i1.setLayoutParams(layoutParams);
            this.i1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j1.getLayoutParams();
            layoutParams2.width = l2;
            layoutParams2.height = i2;
            this.j1.setLayoutParams(layoutParams2);
        }
    }

    public final void X1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (tBLottieAnimationView = this.l1) != null) {
            if (tBLottieAnimationView.getVisibility() == 8 || this.l1.getVisibility() == 4) {
                this.l1.setVisibility(0);
                if (this.l1.isAnimating()) {
                    this.l1.cancelAnimation();
                }
                this.l1.setAnimation(R.raw.lotti_video_loading);
                this.l1.setRepeatCount(-1);
                this.l1.playAnimation();
            }
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            boolean v1 = v1();
            boolean w1 = w1();
            if (!TextUtils.isEmpty(this.f1140T)) {
                rq7 c2 = qq7.d().c(this.f1140T);
                if (c2 == null) {
                    c2 = new rq7(this.A0, v1);
                } else {
                    c2.d(this.A0);
                    c2.e(v1);
                }
                qq7.d().e(this.f1140T, c2);
            }
            j1(v1, w1);
            h1(v1, w1);
        }
    }

    public final int P1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int x1 = x1();
            O1();
            int q1 = q1(z, z2);
            this.r1.setVisibility(0);
            this.s1.setVisibility(0);
            int g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = q1 + x1 + g2;
            this.x.setVisibility(8);
            this.h1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (x1 - xi.g(this.a.getPageActivity(), R.dimen.tbds282)) + g2;
            L1(x1 + g2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void j1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b.T3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B0.getLayoutParams();
        if (!z && !z2) {
            this.B0.setVisibility(0);
            this.D0.setVisibility(8);
            this.E0.setVisibility(this.f1.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.B0.setVisibility(0);
            this.D0.setVisibility(this.f1.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.T3().t(z, z2);
    }

    public final void Q1(o25 o25Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, o25Var, i2) == null) {
            if (i2 == -1) {
                b2 = hr7.c(this.w1);
            } else {
                b2 = hr7.b(o25Var, i2);
            }
            if (!StringUtils.isNull(b2)) {
                int b3 = eu8.b(b2);
                this.s1.setGradientColors(0, b3);
                this.r1.setBackgroundColor(b3);
            }
        }
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            FrsViewData frsViewData = this.w1;
            if (frsViewData == null) {
                return false;
            }
            o25 o25Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                o25Var = new o25();
                o25Var.q("");
                o25Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                o25Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (o25Var == null) {
                return false;
            }
            if (u1(o25Var)) {
                Y1(frsViewData, o25Var);
            } else {
                W1(frsViewData, o25Var);
            }
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(o25Var.l(), 0));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.os7
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.w();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            p();
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.i();
            }
            CountDownTimer countDownTimer = this.d1;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d1 = null;
            }
            this.K0.cancelAnimation();
            this.f1.onDestory();
            MessageManager.getInstance().unRegisterListener(this.A1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
        }
    }

    public final void Z1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.H = true;
            this.d1 = new f(this, j2, j3, str).start();
            if (this.Q != null && !j()) {
                this.Q.s(this.H, y1());
            }
        }
    }

    public final void a2(FrsViewData frsViewData, FrsGameRankInfoData frsGameRankInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048613, this, frsViewData, frsGameRankInfoData, str) == null) && frsGameRankInfoData != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.itemInfo != null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("fname", frsViewData.getForum().getName());
            statisticItem.param("obj_id", frsViewData.itemInfo.id.intValue());
            statisticItem.param("obj_name", frsViewData.itemInfo.name);
            statisticItem.param("obj_param1", frsGameRankInfoData.rankName);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void b2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.v1.setVisibility(0);
                    this.v1.f(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.v1.setVisibility(8);
                return;
            }
            this.v1.setVisibility(8);
        }
    }

    public final int[] o1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            if (i2 <= 3) {
                return new int[]{-8331843, -10499102};
            }
            if (i2 <= 9) {
                return new int[]{-10499102, -154262};
            }
            if (i2 <= 15) {
                return new int[]{-154262, -148180};
            }
            return new int[]{-148180, -100818};
        }
        return (int[]) invokeI.objValue;
    }

    public final void s1(p15 p15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, p15Var) == null) && p15Var != null && p15Var.b() != 0.0f) {
            float d2 = p15Var.d() / ((p15Var.b() * 40.0f) / 70.0f);
            float d3 = p15Var.d() / p15Var.b();
            this.m1.setAlpha(d2);
            this.n1.setAlpha(d2);
            this.o1.setAlpha(1.0f - d2);
            float f2 = 1.0f - d3;
            this.p1.setAlpha(f2);
            this.j1.setAlpha(f2);
        }
    }

    public final void z1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, frsViewData) == null) {
            if (frsViewData == null) {
                K1();
                return;
            }
            FrsBannerHeaderData frsBannerHeaderData = frsViewData.frsBannerHeaderData;
            if (frsBannerHeaderData == null) {
                K1();
                return;
            }
            this.x1.setData(frsBannerHeaderData);
            if (frsViewData.getForum() != null) {
                this.x1.setForumInfo(frsViewData.getForum().getId(), frsViewData.getForum().getName());
            }
            View view2 = this.E;
            if (this.y.getVisibility() == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.C0.setVisibility(8);
            this.x1.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.os7
    public void c(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.f1.onChangeSkinType(i2);
            h05 layoutMode = this.a.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.d);
            this.a.getLayoutMode().k(this.K);
            this.a.getLayoutMode().k(this.m);
            SkinManager.setBackgroundResource(this.K, R.drawable.icon_frs_experience_number);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0806c3);
            s75 d2 = s75.d(this.C0);
            d2.n(1);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.D0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.F0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.Q0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.T0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            s75 d3 = s75.d(this.m1);
            d3.x(R.color.CAM_X0101);
            d3.C(R.dimen.T_X09);
            s75 d4 = s75.d(this.G);
            d4.D(R.string.F_X01);
            d4.x(R.color.CAM_X0101);
            s75 d5 = s75.d(this.G0);
            d5.n(1);
            d5.o(R.string.J_X07);
            d5.f(R.color.black_alpha40);
            s75 d6 = s75.d(this.I0);
            d6.D(R.string.F_X01);
            d6.x(R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.J0, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            FrsBannerHeaderView frsBannerHeaderView = this.x1;
            if (frsBannerHeaderView != null) {
                frsBannerHeaderView.g();
            }
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(xi.g(this.a.getPageActivity(), R.dimen.tbds1));
                this.N.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.N.setStrokeColorResId(R.color.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.P0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.O;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.w;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            FrsGroupChatSignGuideView frsGroupChatSignGuideView = this.y1;
            if (frsGroupChatSignGuideView != null) {
                frsGroupChatSignGuideView.c();
            }
            Iterator<TbImageView> it = this.v0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            Y();
            M(this.i0 ? 1 : 0);
            J1();
            A1(i2);
            h1(v1(), w1());
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.B;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            hg7 hg7Var = this.A;
            if (hg7Var != null) {
                hg7Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.U0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            ml7 ml7Var = this.n0;
            if (ml7Var != null) {
                ml7Var.h();
            }
            HeaderComponentNoHeaderController headerComponentNoHeaderController = this.z1;
            if (headerComponentNoHeaderController != null) {
                headerComponentNoHeaderController.g();
            }
        }
    }
}
