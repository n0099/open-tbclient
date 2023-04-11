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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
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
import com.baidu.tbadk.core.util.MemberPayStatistic;
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
import com.baidu.tieba.c05;
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
import com.baidu.tieba.h79;
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
/* loaded from: classes4.dex */
public class g87 extends mj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A0;
    public boolean A1;
    public ArrayList<TbImageView> B0;
    public MessageRedDotView B1;
    public o67 C0;
    public FrsViewData C1;
    public boolean D0;
    public FrsBannerHeaderView D1;
    public View E0;
    public FrsGroupChatSignGuideView E1;
    public View F0;
    public HeaderComponentNoHeaderController F1;
    public boolean G0;
    public CustomMessageListener G1;
    public LinearLayout H0;
    public CustomMessageListener H1;
    public View I0;
    public CustomMessageListener I1;
    public View J0;
    public CustomMessageListener J1;
    public View K0;
    public CustomMessageListener K1;
    public View L0;
    public View M0;
    public TbImageView N0;
    public TextView O0;
    public ImageView P0;
    public TBLottieAnimationView Q0;
    public TbImageView R0;
    public boolean S0;
    public TextView T0;
    public final View U0;
    public final HeadImageView V0;
    public final TextView W0;
    public final View X0;
    public final ImageView Y0;
    public final TextView Z0;
    public HotRankEntryView a1;
    public List<hn> b1;
    public ak6 c1;
    public int d1;
    public long e1;
    public ScheduledExecutorService f1;
    public boolean g1;
    public boolean h1;
    public boolean i1;
    public CountDownTimer j1;
    public boolean k1;
    @NonNull
    public final gf7 l1;
    @NonNull
    public final kf7 m1;
    public TbVideoView n1;
    public TbImageView o1;
    public View p1;
    public View q1;
    public TBLottieAnimationView r1;
    public TextView s1;
    public TBLottieAnimationView t1;
    public View u1;
    public View v1;
    public View w1;
    public RelativeLayout x0;
    public View x1;
    public TextView y0;
    public FrsHeaderVideoImageShadeView y1;
    public TextView z0;
    public boolean z1;

    @Override // com.baidu.tieba.mj7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ g87 b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

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
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.G != null) {
                    if (this.a.b.G.getVisibility() == 8) {
                        this.a.b.G.setVisibility(0);
                        this.a.b.G.setText(this.a.a);
                        if (this.a.b.I != null) {
                            g87 g87Var = this.a.b;
                            g87Var.I1(g87Var.I.activity_msg, this.a.b.I.countdown_time.intValue());
                        }
                    } else if (this.a.b.G.getVisibility() == 0) {
                        this.a.b.o1();
                    }
                }
            }
        }

        public i(g87 g87Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g87Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ g87 c;

        public a(g87 g87Var, mx4 mx4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, mx4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g87Var;
            this.a = mx4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.q1.getVisibility() == 0) {
                    this.c.n1.start();
                    return;
                }
                hi7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    fi7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ g87 c;

        public b(g87 g87Var, mx4 mx4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, mx4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g87Var;
            this.a = mx4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                hi7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    fi7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ g87 c;

        public c(g87 g87Var, mx4 mx4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, mx4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g87Var;
            this.a = mx4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null && !ru5.a(this.c.a.getPageActivity(), this.a.f()) && !TextUtils.isEmpty(this.a.e())) {
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
                    fi7.d(this.b, 1, this.c.b.getUniqueId());
                }
                hi7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g87 g87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        public e(g87 g87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g87Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.h0, "exp_acce", 2);
                memberPayActivityConfig.setSceneId("4004001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        public f(g87 g87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g87Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                lg.d(this.a.O, this.a.a.getPageActivity());
                this.a.b.c = false;
                it4.x(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0633), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        public g(g87 g87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g87Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    lg.c(this.a.O);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ g87 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g87 g87Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = g87Var;
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
            if (this.b.S != null && !this.b.j()) {
                this.b.S.s(this.b.H, this.b.C1());
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

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(g87 g87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Integer.valueOf(i)};
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
            this.a = g87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof nw4)) {
                nw4 nw4Var = (nw4) customResponsedMessage.getData();
                this.a.J1(nw4Var);
                this.a.w1(nw4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(g87 g87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Integer.valueOf(i)};
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
            this.a = g87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && qi7.m(this.a.C1)) {
                this.a.H1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(g87 g87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Integer.valueOf(i)};
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
            this.a = g87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (qi7.m(this.a.C1) && this.a.n1.getVisibility() == 0) {
                        this.a.H1();
                    }
                    this.a.A1 = false;
                } else if (intValue == 2 && qi7.m(this.a.C1)) {
                    if (!this.a.A1) {
                        g87 g87Var = this.a;
                        g87Var.J(g87Var.C1.getForum(), this.a.C1);
                    }
                    this.a.A1 = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(g87 g87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Integer.valueOf(i)};
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
            this.a = g87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.z1 = true;
                if (intValue == 1) {
                    if (!FrsFragment.x2 && qi7.m(this.a.C1)) {
                        g87 g87Var = this.a;
                        g87Var.J(g87Var.C1.getForum(), this.a.C1);
                    }
                } else if (intValue == 2) {
                    if (qi7.m(this.a.C1)) {
                        g87 g87Var2 = this.a;
                        g87Var2.J(g87Var2.C1.getForum(), this.a.C1);
                    }
                } else if (intValue == 3) {
                    g87 g87Var3 = this.a;
                    g87Var3.J(g87Var3.C1.getForum(), this.a.C1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(g87 g87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, Integer.valueOf(i)};
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
            this.a = g87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            g87 g87Var = this.a;
            g87Var.g2(g87Var.C1);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRankInfoData a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ g87 c;

        public o(g87 g87Var, FrsGameRankInfoData frsGameRankInfoData, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, frsGameRankInfoData, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g87Var;
            this.a = frsGameRankInfoData;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null) {
                UrlManager.getInstance().dealOneLink(this.c.a, new String[]{this.a.rankLink});
                this.c.Q0.pauseAnimation();
                this.c.Q0.setFrame(Cea708Decoder.COMMAND_DSW);
                this.c.f2(this.b, this.a, "c15056");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements o67 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g87 a;

        public p(g87 g87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g87Var;
        }

        @Override // com.baidu.tieba.o67
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                pi7.d(this.a.b, this.a.C1, threadData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ g87 c;

        public q(g87 g87Var, mx4 mx4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, mx4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g87Var;
            this.a = mx4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.o1.setVisibility(8);
                    this.c.q1.setVisibility(8);
                    this.c.x1();
                    this.c.W1(this.a, 0);
                    fi7.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.H1();
                    fi7.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.H1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.c2();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements h79.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx4 a;
        public final /* synthetic */ g87 b;

        public r(g87 g87Var, mx4 mx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, mx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g87Var;
            this.a = mx4Var;
        }

        @Override // com.baidu.tieba.h79.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.W1(this.a, i2);
        }
    }

    public g87(FrsFragment frsFragment, String str, String str2, int i2) {
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
        this.G0 = false;
        this.d1 = -1;
        this.e1 = 1000L;
        this.k1 = false;
        this.l1 = ff7.a();
        this.G1 = new j(this, 2921679);
        this.H1 = new k(this, 2921681);
        this.I1 = new l(this, 2921680);
        this.J1 = new m(this, 2921682);
        this.K1 = new n(this, 2921721);
        this.B0 = new ArrayList<>();
        this.h0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        ii.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        ii.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        ii.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024e);
        this.V = str;
        this.W = str2;
        View r1 = r1();
        this.d = r1;
        this.l1.c(frsFragment, r1);
        this.m1 = this.l1.e();
        this.x0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090772);
        this.v = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090e88);
        this.w = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090e8b);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090e89);
        this.x = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.x.setDefaultBgResource(R.color.transparent);
        this.x.setDefaultResource(R.drawable.obfuscated_res_0x7f080fc1);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f090ea9);
        this.n1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f09273c);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f092736);
        this.o1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.o1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080fc1);
        this.o1.setDefaultResource(R.drawable.obfuscated_res_0x7f080fc1);
        this.o1.setPlaceHolder(2);
        this.p1 = this.d.findViewById(R.id.obfuscated_res_0x7f09273b);
        this.q1 = this.d.findViewById(R.id.obfuscated_res_0x7f09273a);
        this.r1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f092739);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cfa);
        this.U = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090c8b);
        ff7.d(this.E0, this.F0);
        this.u1 = ff7.b(this.d);
        this.v1 = this.d.findViewById(R.id.obfuscated_res_0x7f090e8a);
        this.w1 = this.d.findViewById(R.id.obfuscated_res_0x7f09157d);
        this.s1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09261a);
        this.t1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0915c7);
        this.x1 = this.d.findViewById(R.id.obfuscated_res_0x7f092737);
        this.y1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f092735);
        this.H0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0913df);
        int l2 = this.l1.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090ea3);
        this.I0 = findViewById;
        findViewById.setVisibility(l2);
        this.J0 = this.d.findViewById(R.id.obfuscated_res_0x7f092019);
        this.K0 = this.d.findViewById(R.id.obfuscated_res_0x7f090324);
        this.y = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f09201b);
        this.z = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090bdd);
        this.F = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092815);
        this.B = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090d23);
        this.L0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d1a);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f090d1b);
        this.D = this.d.findViewById(R.id.obfuscated_res_0x7f09201f);
        this.E = this.d.findViewById(R.id.obfuscated_res_0x7f09201e);
        this.h = (List) this.l1.a(LogicField.LIKE_BTN);
        this.i = (List) this.l1.a(LogicField.SIGN_BTN);
        this.N = (ImageView) q1().a(LogicField.SPEED_ICON);
        this.y0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091669);
        this.z0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091bcc);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091458);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091450);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0915ce);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0915cd);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09166e);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091bd2);
        this.n = (TextView) this.d.findViewById(R.id.forum_name);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090464);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090c68);
        this.P = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.P.setPageId(this.b.getUniqueId());
        this.P.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02ef));
        this.P.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.P.setShowOval(true);
        this.P.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091d52);
        this.B1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.B1.setEnterForumStyle(true);
        this.B1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f091451);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090e6f);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09188a);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090e79);
        this.u = this.d.findViewById(R.id.obfuscated_res_0x7f090e7a);
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cb5);
        this.W0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb6);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb7);
        this.V0 = headImageView;
        headImageView.setIsRound(true);
        this.V0.setDrawBorder(true);
        this.V0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.V0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cb4);
        this.Y0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb3);
        this.Z0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb2);
        WebPManager.setPureDrawable(this.Y0, R.drawable.obfuscated_res_0x7f080835, R.color.CAM_X0101, null);
        this.K = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d036c, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d033a, (ViewGroup) null);
        this.a1 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090c66);
        this.m.setVisibility(8);
        this.G = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907af);
        this.r0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090e94);
        this.M0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d7f);
        TbImageView tbImageView3 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d7e);
        this.N0 = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.N0.setConrers(15);
        this.N0.setRadiusById(R.string.J_X05);
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090d82);
        this.O0 = textView;
        textView.getPaint().setStrokeWidth(0.5f);
        this.O0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.P0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d80);
        this.Q0 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090d81);
        this.R0 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d7d);
        this.Q0.setImageAssetsFolder("lottie_frs_game_rank_guide");
        this.Q0.setAnimation(R.raw.lottie_frs_game_rank_guide);
        this.Q0.setRepeatMode(1);
        this.Q0.setMinAndMaxFrame(57, Cea708Decoder.COMMAND_DSW);
        this.D1 = (FrsBannerHeaderView) this.d.findViewById(R.id.obfuscated_res_0x7f090bf4);
        this.E1 = (FrsGroupChatSignGuideView) this.d.findViewById(R.id.obfuscated_res_0x7f090c47);
        MessageManager.getInstance().registerListener(this.G1);
        MessageManager.getInstance().registerListener(this.H1);
        MessageManager.getInstance().registerListener(this.I1);
        MessageManager.getInstance().registerListener(this.J1);
        MessageManager.getInstance().registerListener(this.K1);
    }

    public void L1(c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, c05Var) == null) {
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new d(this));
        }
    }

    public void M1(c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, c05Var) == null) {
            c05Var.setPositiveButton(R.string.open_now, new e(this));
        }
    }

    @Override // com.baidu.tieba.mj7
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.l1.g(z);
        }
    }

    public final boolean y1(mx4 mx4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, mx4Var)) == null) {
            if (mx4Var == null || StringUtils.isNull(mx4Var.c()) || StringUtils.isNull(mx4Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.mj7
    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            super.z(z);
            n77 n77Var = this.A;
            if (n77Var != null) {
                n77Var.k(z);
            }
        }
    }

    public final void I1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048591, this, str, j2) == null) {
            this.H = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.f1 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new i(this, str), j2, TimeUnit.SECONDS);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            n77 n77Var = this.A;
            if (n77Var != null) {
                n77Var.l();
            }
            if (FrsFragment.x2 && qi7.m(this.C1)) {
                FrsFragment.x2 = false;
                J(this.C1.getForum(), this.C1);
            }
        }
    }

    public final boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null && serviceAreaView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int l2 = ii.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.n1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    public final boolean C1() {
        InterceptResult invokeV;
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.i0 && this.j0 && (fx4Var = this.k0) != null && !TextUtils.isEmpty(fx4Var.c())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mj7
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.B.i(this.d1);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void F() {
        FrsViewData frsViewData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.b != null && (frsViewData = this.C1) != null) {
            List<hn> showTopThreadList = frsViewData.getShowTopThreadList();
            if (showTopThreadList.size() > 2) {
                z = true;
            } else {
                z = false;
            }
            this.G0 = z;
            Y1(showTopThreadList, this.C1.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.mj7
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            zi7 zi7Var = this.S;
            if (zi7Var != null) {
                zi7Var.q(this.e0);
            }
            v1(true);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            zi7 zi7Var = this.S;
            if (zi7Var != null) {
                zi7Var.s(this.H, C1());
            }
            v1(false);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.o1.setVisibility(0);
            W1(null, -1);
            x1();
            TbVideoView tbVideoView = this.n1;
            if (tbVideoView != null) {
                tbVideoView.Q();
            }
            this.n1.setVisibility(8);
        }
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.P.N(this.A0, 10, false);
        }
    }

    public void P1() {
        yi7 yi7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (yi7Var = this.T) != null) {
            yi7Var.n();
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.D1.setVisibility(8);
            this.E.setVisibility(8);
            this.I0.setVisibility(this.l1.l(LogicField.ROUND_CORNER_STYLE));
        }
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.A0);
            this.a0.getMedias().add(mediaData);
        }
    }

    public final String Z1() {
        InterceptResult invokeV;
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (!this.i0 && this.j0 && (fx4Var = this.k0) != null) {
                return fx4Var.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.h0 != 0) {
                SkinManager.setImageResource(this.N, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.N, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.mj7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.l1.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.mj7
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            SignActivityInfo signActivityInfo = this.I;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public SignActivityInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.I;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public void p() {
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (ak6Var = this.c1) != null) {
            ak6Var.d();
            this.d1 = -1;
        }
    }

    @NonNull
    public gf7 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.l1;
        }
        return (gf7) invokeV.objValue;
    }

    public View r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0360, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.D0;
        }
        return invokeV.booleanValue;
    }

    public final LinearGradientView t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.R3() != null) {
                View D = this.b.R3().D();
                if (D instanceof LinearGradientView) {
                    return (LinearGradientView) D;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mj7
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final void x1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (tBLottieAnimationView = this.r1) != null) {
            tBLottieAnimationView.setVisibility(8);
            if (this.r1.isAnimating()) {
                this.r1.cancelAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.mj7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            super.y();
            if (qi7.m(this.C1)) {
                H1();
            }
            n77 n77Var = this.A;
            if (n77Var != null) {
                n77Var.j();
            }
        }
    }

    public final boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            FrsTopView frsTopView = this.B;
            if (frsTopView != null && frsTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mj7
    public void D(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.o0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.o0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0a9b);
                if (f2 >= 1.0f) {
                    i2 = this.b0;
                } else {
                    i2 = this.b0 + 1;
                }
                FrsViewData a1 = this.b.a1();
                if (a1 != null && a1.getForum() != null) {
                    a1.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b43, Integer.valueOf(i2)));
            } else {
                this.l1.d(this.b0, this.X);
                this.j.setText(this.X);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b43, Integer.valueOf(this.b0)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, s1(this.b0)));
            if (this.o0) {
                if (f2 >= 1.0f) {
                    Z(this.k, this.q0, f2);
                } else {
                    X(this.k, this.q0, f2);
                }
            } else {
                Z(this.k, this.q0, f2);
            }
            this.q0 = f2;
        }
    }

    public final void l1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (relativeLayout = this.v) != null && relativeLayout.getLayoutParams() != null) {
            if (this.a1.getVisibility() == 0) {
                g2 = ii.g(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = ii.g(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.a1.getLayoutParams()).topMargin = (ii.g(this.a.getPageActivity(), R.dimen.tbds226) + ii.u(this.a.getPageActivity())) - ii.g(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                g2 = ii.g(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.D0) {
                g2 -= ii.g(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.D0) {
                if (qi7.m(this.C1)) {
                    g2 = V1(z, z2);
                } else {
                    g2 = O1(z, z2);
                }
            }
            if (this.M0.getVisibility() == 0 || this.D1.getVisibility() == 0) {
                g2 += ii.g(this.a.getPageActivity(), R.dimen.tbds125);
            }
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            if (layoutParams.height != g2) {
                layoutParams.height = g2;
                this.v.setLayoutParams(layoutParams);
            }
        }
    }

    public final void D1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, frsViewData) == null) {
            if (frsViewData == null) {
                Q1();
                return;
            }
            FrsBannerHeaderData frsBannerHeaderData = frsViewData.frsBannerHeaderData;
            if (frsBannerHeaderData == null) {
                Q1();
                return;
            }
            this.D1.setData(frsBannerHeaderData);
            if (frsViewData.getForum() != null) {
                this.D1.setForumInfo(frsViewData.getForum().getId(), frsViewData.getForum().getName());
            }
            View view2 = this.E;
            if (this.y.getVisibility() == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.I0.setVisibility(8);
            this.D1.setVisibility(0);
        }
    }

    public final void g2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.B1.setVisibility(0);
                    this.B1.f(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.B1.setVisibility(8);
                return;
            }
            this.B1.setVisibility(8);
        }
    }

    public final int[] s1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
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

    public final void w1(nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048640, this, nw4Var) == null) && nw4Var != null && nw4Var.b() != 0.0f) {
            float d2 = nw4Var.d() / ((nw4Var.b() * 40.0f) / 70.0f);
            float d3 = nw4Var.d() / nw4Var.b();
            this.s1.setAlpha(d2);
            this.t1.setAlpha(d2);
            this.u1.setAlpha(1.0f - d2);
            float f2 = 1.0f - d3;
            this.v1.setAlpha(f2);
            this.p1.setAlpha(f2);
        }
    }

    public final void E1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && (frsViewData = this.C1) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && (themeElement = themeColorInfo.day) != null && themeColorInfo.night != null && (themeElement2 = themeColorInfo.dark) != null) {
            if (i2 == 4) {
                themeElement = themeElement2;
            }
            this.m1.b(themeElement);
            this.l1.b(themeElement);
            if (!this.D0) {
                LinearGradientView t1 = t1();
                LinearGradientView linearGradientView = this.w;
                if (linearGradientView != null && t1 != null) {
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
                serviceAreaView.setThemeFontColor(ne8.b(themeElement.common_color));
            }
            if (this.B != null) {
                this.B.setUrlAndColor(forum.getTopIcon(), ne8.b(themeElement.common_color));
            }
        }
    }

    public final void J1(nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, nw4Var) != null) || nw4Var == null) {
            return;
        }
        if (!nw4Var.e()) {
            if (this.s1.getVisibility() != 8) {
                this.s1.setVisibility(8);
            }
            if (this.t1.getVisibility() != 8) {
                this.t1.setVisibility(8);
                if (this.t1.isAnimating()) {
                    this.t1.cancelAnimation();
                }
            }
        } else if (nw4Var.d() < nw4Var.b()) {
            this.s1.setText(R.string.surprise_in_drop_down);
            T1();
        } else if (nw4Var.d() < nw4Var.c()) {
            this.s1.setText(R.string.surprise_continue_drop_down);
            T1();
        } else {
            this.s1.setText(R.string.surprise_when_release_hand);
            this.t1.setVisibility(4);
            if (this.t1.isAnimating()) {
                this.t1.cancelAnimation();
            }
        }
    }

    public final void X1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.W0.setText(str);
                    this.V0.N(forumData.getManagers().get(0).portrait, 12, false);
                    this.U0.setVisibility(0);
                } else {
                    this.U0.setVisibility(8);
                }
                if (this.X0.getVisibility() == 0) {
                    this.X0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.U0.getVisibility() == 0) {
                this.U0.setVisibility(8);
            }
            if (this.X0.getVisibility() == 8) {
                this.X0.setVisibility(0);
            }
        }
    }

    public final void v1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048638, this, z) == null) && this.E1 != null) {
            String Z1 = Z1();
            if (!z && !TextUtils.isEmpty(Z1)) {
                this.E1.d(Z1);
                if (this.k0 != null) {
                    TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 1).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.W).param("fname", this.V).param("room_id", this.k0.a()));
                    return;
                }
                return;
            }
            this.E1.a();
        }
    }

    public final void F1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        FrsGameRankInfoData frsGameRankInfoData = frsViewData.frsGameRankInfoData;
        if (frsGameRankInfoData == null) {
            this.M0.setVisibility(8);
            this.E.setVisibility(8);
            this.I0.setVisibility(this.l1.l(LogicField.ROUND_CORNER_STYLE));
            this.P.setUseStrokeColorInt(false);
            this.R0.setVisibility(8);
            this.Q0.pauseAnimation();
            return;
        }
        this.M0.setVisibility(0);
        View view2 = this.E;
        if (this.y.getVisibility() == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        f2(frsViewData, frsGameRankInfoData, "c15055");
        this.I0.setVisibility(8);
        int b2 = ne8.b(frsGameRankInfoData.rankColor);
        if (ne8.a(b2)) {
            this.P.setUseStrokeColorInt(false);
        } else {
            this.P.setStrokeColorInt(b2);
            this.P.setUseStrokeColorInt(true);
        }
        if (!this.Q0.isAnimating() && !this.S0) {
            int i3 = frsGameRankInfoData.showType;
            if (i3 < 0) {
                this.Q0.setRepeatCount(-1);
                this.Q0.u();
                this.S0 = true;
            } else if (i3 > 0) {
                this.Q0.setRepeatCount(i3);
                this.Q0.u();
                this.S0 = true;
            } else {
                this.Q0.setFrame(Cea708Decoder.COMMAND_DSW);
            }
        }
        this.N0.N(frsGameRankInfoData.icon, 10, false);
        if (TextUtils.isEmpty(frsGameRankInfoData.rankIcon)) {
            this.R0.setVisibility(8);
        } else {
            this.R0.setVisibility(0);
            this.R0.N(frsGameRankInfoData.rankIcon, 10, false);
        }
        this.O0.setText(frsGameRankInfoData.rankName + "#" + frsGameRankInfoData.rankScore);
        this.M0.setOnClickListener(new o(this, frsGameRankInfoData, frsViewData));
    }

    public final void p1(ck9 ck9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, ck9Var) == null) && ck9Var != null && this.C1 != null && !this.k1) {
            this.k1 = true;
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (ck9Var.getType() != 1) {
                if (ck9Var.getType() == 2) {
                    i2 = 7;
                } else if (ck9Var.getType() == 3) {
                    i2 = 8;
                } else if (ck9Var.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", ck9Var.c());
            ForumData forum = this.C1.getForum();
            if (forum != null) {
                statisticItem.param("fid", forum.getId());
                statisticItem.param("fname", forum.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
            }
            if (ck9Var.getType() == 1) {
                statisticItem.param("tid", ck9Var.m());
                statisticItem.param("thread_type", ck9Var.n());
            }
            if (StringUtils.isNull(ck9Var.q())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (YYLiveUtil.isYYLiveLink(ck9Var.p())) {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            } else {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean a2 = a2();
            this.D0 = a2;
            this.l1.f(a2);
            if (this.D0) {
                this.w.setVisibility(8);
                if (qi7.m(this.C1)) {
                    this.E0.setVisibility(4);
                } else {
                    this.E0.setVisibility(0);
                }
                this.F0.setVisibility(0);
            } else {
                this.E0.setVisibility(8);
                this.F0.setVisibility(8);
                this.w.setVisibility(0);
                this.x.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.c0));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.d0));
            }
            this.l1.i(this.c0, this.d0);
            this.l1.d(this.b0, this.X);
            ArrayList<vw4> arrayList = this.R;
            if (arrayList != null && arrayList.size() > 0) {
                this.V = UtilHelper.getFixedText(this.V, 7);
            } else if (this.p0) {
                this.V = UtilHelper.getFixedText(this.V, 6);
            }
            String f0 = e57.f0(this.V);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(f0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(f0);
            }
            this.l1.j(this.A0, f0);
            K1();
            F();
            E1(TbadkCoreApplication.getInst().getSkinType());
            N1();
            FrsViewData frsViewData = this.C1;
            if (frsViewData.frsBannerHeaderData != null) {
                D1(frsViewData);
            } else {
                F1(frsViewData);
            }
            m1();
        }
    }

    public final void N1() {
        FrsViewData frsViewData;
        View f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.a != null && (frsViewData = this.C1) != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                List<LiveFuseForumData> list = this.C1.liveFuseForumDataList;
                if (list.size() == 1 && list.get(0).type.intValue() == 7 && list.get(0).novel != null) {
                    HeaderComponentNoHeaderController headerComponentNoHeaderController = new HeaderComponentNoHeaderController(this.a, list.get(0));
                    this.F1 = headerComponentNoHeaderController;
                    f2 = headerComponentNoHeaderController.e();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    f2.setLayoutParams(layoutParams);
                    this.F1.h();
                } else {
                    this.s0 = new nc7(this.a, list);
                    if (this.C1.getForum() != null) {
                        this.s0.i(this.C1.getForum().getId(), this.C1.getForum().getName());
                    }
                    f2 = this.s0.f();
                    this.s0.d();
                }
                this.L0.setVisibility(8);
                this.r0.setVisibility(0);
                this.r0.removeAllViews();
                this.r0.addView(f2);
                return;
            }
            this.r0.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void W() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            PopupWindow popupWindow = this.O;
            if (popupWindow == null) {
                this.O = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d084b, (ViewGroup) null);
                this.O.setContentView(contentView);
                GreyUtil.grey(this.O);
                contentView.setOnClickListener(new f(this));
                this.O.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029a));
                this.O.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070307));
                this.O.setBackgroundDrawable(new BitmapDrawable());
                this.O.setOutsideTouchable(true);
                this.O.setTouchInterceptor(new g(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091657), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0920e9), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0922e2), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.N.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.O;
            lg.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.N.getWidth() / 2), iArr[1] + this.N.getWidth());
            this.O.update();
        }
    }

    public final void o1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048628, this) != null) || this.I == null) {
            return;
        }
        CountDownTimer countDownTimer = this.j1;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.j1.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        boolean z3 = true;
        if ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis < 0) {
            z = true;
        } else {
            z = false;
        }
        this.g1 = z;
        if (this.I.activity_time.intValue() - currentTimeMillis <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.h1 = z2;
        if ((this.I.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis > 0) {
            z3 = false;
        }
        this.i1 = z3;
        boolean z4 = this.g1;
        if (z4) {
            this.G.setVisibility(8);
            return;
        }
        if (this.h1 && !z4) {
            e2(this.I.activity_msg, 1000 * ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis), this.e1);
        }
        if (!this.h1 && this.i1) {
            this.G.setVisibility(0);
            this.G.setText(this.I.countdown_msg);
            SignActivityInfo signActivityInfo = this.I;
            I1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (!this.i1) {
            SignActivityInfo signActivityInfo2 = this.I;
            I1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.P.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.a1;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.U0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.X0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.l1.h(onClickListener);
        }
    }

    public final void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            int g2 = ii.g(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.I0.getVisibility() != 0) {
                g2 -= ii.g(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.w1.getLayoutParams()).topMargin = i2 - g2;
        }
    }

    @Override // com.baidu.tieba.mj7
    public void J(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, forumData, frsViewData) != null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.A1 = true;
        if (qi7.m(this.C1)) {
            H1();
        }
        this.V = forumData.getName();
        this.W = forumData.getId();
        this.c0 = forumData.getMember_num();
        this.d0 = forumData.getPost_num();
        forumData.getTag_color();
        this.A0 = forumData.getImage_url();
        this.X = forumData.getLevelName();
        this.b0 = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.e0 = forumData.getSignData().miss_sign_num;
            this.j0 = forumData.getSignData().showGuideToChatRoom;
            this.k0 = forumData.getSignData().chatRoomGuideData;
        }
        this.f0 = forumData.getCurScore();
        this.g0 = forumData.getLevelupScore();
        this.R = forumData.getBadgeData();
        this.Y = forumData.getAccelerateContent();
        this.p0 = forumData.isBrandForum;
        this.C1 = frsViewData;
        if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.V)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.C1;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.C1.getHotUserRankData().hot_user != null && this.C1.getHotUserRankData().hot_user.size() >= 3) {
            this.y.setHasHotRankList(true);
        } else {
            this.y.setHasHotRankList(false);
        }
        int l2 = this.l1.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.C1;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.y.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.y.setVisibility(0);
            this.J0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.y;
            FrsViewData frsViewData4 = this.C1;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.y.setVisibility(8);
            this.J0.setVisibility(8);
        }
        this.a0 = new ThreadData();
        S1();
        G1();
        if (this.C1.getActivityHeadData() != null && this.C1.getActivityHeadData().a() != null) {
            ArrayList<mx4> b2 = this.C1.getActivityHeadData().b();
            mx4 mx4Var = null;
            if (!ListUtils.isEmpty(b2)) {
                mx4Var = b2.get(0);
            }
            this.T0 = ff7.c(this.d, y1(mx4Var));
            if (this.D0 && this.C1.getActivityHeadData().a().h) {
                this.T0.setVisibility(0);
            } else {
                this.T0.setVisibility(8);
            }
        }
        X1(forumData);
        if (frsViewData != null) {
            this.I = frsViewData.mSignActivityInfo;
            o1();
        }
        this.C1 = frsViewData;
        g2(frsViewData);
    }

    public final void Y1(List<hn> list, ck9 ck9Var) {
        ForumData forumData;
        ForumData forumData2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, list, ck9Var) != null) || this.B == null) {
            return;
        }
        this.b1 = list;
        FrsViewData frsViewData = this.C1;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.C1.getVoiceRoomData().a().size() > 0) {
            this.F.setVisibility(0);
            this.F.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.C1.getVoiceRoomData().a())) {
                if (this.C1.getVoiceRoomData().a().size() > 5) {
                    this.F.setShowMore(true);
                } else {
                    this.F.setShowMore(false);
                }
            }
            this.F.a(this.C1.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.F.setVisibility(8);
            }
        }
        UserData userData = null;
        if (ck9Var != null) {
            this.A = new n77(this.a.getPageActivity());
            this.z.setVisibility(0);
            this.z.addView(this.A.f());
            FrsViewData frsViewData2 = this.C1;
            if (frsViewData2 != null) {
                forumData2 = frsViewData2.getForum();
            } else {
                forumData2 = null;
            }
            n77 n77Var = this.A;
            FrsViewData frsViewData3 = this.C1;
            if (frsViewData3 != null && !frsViewData3.isFromCache) {
                z = false;
            } else {
                z = true;
            }
            n77Var.e(forumData2, ck9Var, z);
            p1(ck9Var);
        } else {
            this.z.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.F;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.L0.setVisibility(8);
        } else {
            ViewGroup viewGroup = this.r0;
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                this.L0.setVisibility(8);
            } else {
                this.L0.setVisibility(this.l1.l(LogicField.TOP_DIVIDER));
            }
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.k4()) {
            this.B.setVisibility(0);
            this.B.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.C1;
            if (frsViewData4 != null) {
                forumData = frsViewData4.getForum();
            } else {
                forumData = null;
            }
            FrsViewData frsViewData5 = this.C1;
            if (frsViewData5 != null) {
                userData = frsViewData5.getUserData();
            }
            this.B.setForum(this.W, this.V, forumData, userData, this.b.A3());
            if (list.size() > 0 && (list.get(0) instanceof lk9)) {
                this.d1 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof lk9)) {
                this.d1 = 1;
            } else {
                this.d1 = -1;
            }
            this.B.setDatas(list, ck9Var);
            if (this.C0 == null) {
                this.C0 = new p(this);
            }
            this.B.setStatListener(this.C0);
            return;
        }
        this.B.setVisibility(8);
    }

    public final int O1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int g2 = ii.g(this.a.getPageActivity(), R.dimen.tbds782);
            int u1 = u1(z, z2);
            R1(g2);
            int i2 = g2 + u1;
            this.x.setVisibility(0);
            this.n1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.x.getLayoutParams()).bottomMargin = u1;
            ((RelativeLayout.LayoutParams) this.E0.getLayoutParams()).bottomMargin = u1;
            if (u1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = ii.g(this.a.getPageActivity(), R.dimen.tbds782) - ii.g(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = ii.g(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void b2(FrsViewData frsViewData, mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048616, this, frsViewData, mx4Var) == null) && this.x != null && mx4Var != null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem("c13326");
                statisticItem.param("fid", frsViewData.getForum().getId());
                statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                fi7.e(frsViewData, 1, this.b.getUniqueId());
            }
            this.x.N(mx4Var.d(), 10, false);
            this.x.setOnClickListener(new c(this, mx4Var, frsViewData));
        }
    }

    public final void d2(FrsViewData frsViewData, mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, frsViewData, mx4Var) == null) {
            this.o1.setVisibility(0);
            W1(null, -1);
            this.o1.N(mx4Var.c(), 10, false);
            if (this.n1.getVisibility() != 0) {
                this.n1.setVisibility(0);
            }
            this.n1.setVideoPath(mx4Var.h());
            this.n1.setVolume(0.0f, 0.0f);
            this.n1.setVideoScalingMode(0);
            this.n1.I(true);
            this.n1.setLooping(false);
            this.n1.setVideoStatusChangeListener(new q(this, mx4Var, frsViewData));
            this.n1.getMediaProgressObserver().j(new r(this, mx4Var));
            if (fi7.f()) {
                this.q1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.C1.isFromCache && (this.z1 || (!frsFragment.h4() && !this.b.g4() && !this.b.J3()))) {
                    this.n1.start();
                }
            } else {
                this.q1.setVisibility(0);
            }
            this.o1.setOnClickListener(new a(this, mx4Var, frsViewData));
            this.n1.setOnClickListener(new b(this, mx4Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                fi7.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    public final int u1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<hn> list;
        List<yk9> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                xk9 xk9Var = this.C1.serviceAreaData;
                if (xk9Var != null && (list2 = xk9Var.b) != null && list2.size() == 1) {
                    i2 = 0 + ii.g(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + ii.g(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.b1) != null) {
                i2 += Math.min(list.size(), 2) * ii.g(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.z.getVisibility() == 0) {
                i2 += ii.g(this.a.getPageActivity(), R.dimen.tbds231);
            }
            if (z2 || z || this.z.getVisibility() == 0) {
                return i2 + ii.g(this.a.getPageActivity(), R.dimen.tbds45);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            TextView textView = this.s1;
            if (textView != null && textView.getVisibility() == 8) {
                this.s1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.t1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.t1.getVisibility() == 4) {
                    this.t1.setVisibility(0);
                    if (this.t1.isAnimating()) {
                        this.t1.cancelAnimation();
                    }
                    this.t1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.t1.setRepeatCount(-1);
                    this.t1.playAnimation();
                }
            }
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            int l2 = ii.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.o1.setLayoutParams(layoutParams);
            this.o1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p1.getLayoutParams();
            layoutParams2.width = l2;
            layoutParams2.height = i2;
            this.p1.setLayoutParams(layoutParams2);
        }
    }

    public final void c2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (tBLottieAnimationView = this.r1) != null) {
            if (tBLottieAnimationView.getVisibility() == 8 || this.r1.getVisibility() == 4) {
                this.r1.setVisibility(0);
                if (this.r1.isAnimating()) {
                    this.r1.cancelAnimation();
                }
                this.r1.setAnimation(R.raw.lotti_video_loading);
                this.r1.setRepeatCount(-1);
                this.r1.playAnimation();
            }
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            boolean z1 = z1();
            boolean A1 = A1();
            if (!TextUtils.isEmpty(this.V)) {
                ph7 c2 = oh7.d().c(this.V);
                if (c2 == null) {
                    c2 = new ph7(this.G0, z1);
                } else {
                    c2.d(this.G0);
                    c2.e(z1);
                }
                oh7.d().e(this.V, c2);
            }
            n1(z1, A1);
            l1(z1, A1);
        }
    }

    @Override // com.baidu.tieba.mj7
    @SuppressLint({"ResourceAsColor"})
    public void U(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, view2, z) == null) {
            if (this.h0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
                    View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06b7, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907eb);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09145f);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920f1);
                    SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a52), R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                    c05 c05Var = new c05(this.a.getPageActivity());
                    c05Var.setContentView(inflate);
                    K(textView, textView2);
                    if (!TextUtils.isEmpty(this.Y) && !TextUtils.isEmpty(this.Y.trim())) {
                        textView3.setVisibility(0);
                        textView3.setText(this.Y);
                    } else {
                        textView3.setVisibility(8);
                    }
                    c05Var.setButtonTextColor(R.color.CAM_X0305);
                    L1(c05Var);
                    M1(c05Var);
                    c05Var.create(this.a);
                    c05Var.show();
                    return;
                }
                return;
            }
            this.c.removeCallbacks(this.u0);
            if (this.J == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.J = popupWindow;
                popupWindow.setContentView(this.K);
                GreyUtil.grey(this.J);
                this.J.setBackgroundDrawable(new BitmapDrawable());
                this.J.setOutsideTouchable(true);
                this.J.setFocusable(true);
                this.J.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027e));
                this.J.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a));
            }
            this.L = (TextView) this.K.findViewById(R.id.obfuscated_res_0x7f0907ea);
            this.M = (TextView) this.K.findViewById(R.id.obfuscated_res_0x7f09145e);
            SkinManager.setBackgroundResource(this.K.findViewById(R.id.obfuscated_res_0x7f090a4f), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.K.findViewById(R.id.obfuscated_res_0x7f090a4e), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.L, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.M, R.color.CAM_X0111, 1);
            K(this.L, this.M);
            if (this.J.isShowing()) {
                lg.d(this.J, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] - this.J.getHeight() <= 50) {
                lg.d(this.J, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.J;
            lg.m(popupWindow2, this.d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.J.update();
            this.c.postDelayed(this.u0, 2000L);
        }
    }

    public final int V1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int B1 = B1();
            U1();
            int u1 = u1(z, z2);
            this.x1.setVisibility(0);
            this.y1.setVisibility(0);
            int g2 = ii.g(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = u1 + B1 + g2;
            this.x.setVisibility(8);
            this.n1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (B1 - ii.g(this.a.getPageActivity(), R.dimen.tbds282)) + g2;
            R1(B1 + g2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void n1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b.R3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H0.getLayoutParams();
        if (!z && !z2) {
            this.H0.setVisibility(0);
            this.J0.setVisibility(8);
            this.K0.setVisibility(this.l1.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = ii.g(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.H0.setVisibility(0);
            this.J0.setVisibility(this.l1.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = ii.g(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.R3().t(z, z2);
    }

    public final void W1(mx4 mx4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, mx4Var, i2) == null) {
            if (i2 == -1) {
                b2 = fi7.c(this.C1);
            } else {
                b2 = fi7.b(mx4Var, i2);
            }
            if (!StringUtils.isNull(b2)) {
                int b3 = ne8.b(b2);
                this.y1.setGradientColors(0, b3);
                this.x1.setBackgroundColor(b3);
            }
        }
    }

    public final boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            FrsViewData frsViewData = this.C1;
            if (frsViewData == null) {
                return false;
            }
            mx4 mx4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                mx4Var = new mx4();
                mx4Var.q("");
                mx4Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                mx4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (mx4Var == null) {
                return false;
            }
            if (y1(mx4Var)) {
                d2(frsViewData, mx4Var);
            } else {
                b2(frsViewData, mx4Var);
            }
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(mx4Var.l(), 0));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mj7
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            super.w();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.O;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.O.dismiss();
            }
            p();
            n77 n77Var = this.A;
            if (n77Var != null) {
                n77Var.i();
            }
            CountDownTimer countDownTimer = this.j1;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.j1 = null;
            }
            this.Q0.cancelAnimation();
            this.l1.onDestory();
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.K1);
        }
    }

    @Override // com.baidu.tieba.mj7
    public void c(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.l1.onChangeSkinType(i2);
            hv4 layoutMode = this.a.getLayoutMode();
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
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0805b6);
            q25 d2 = q25.d(this.I0);
            d2.n(1);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.J0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.K0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.L0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.x0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.y0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.z0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.W0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.Z0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            q25 d3 = q25.d(this.s1);
            d3.w(R.color.CAM_X0101);
            d3.B(R.dimen.T_X09);
            q25 d4 = q25.d(this.G);
            d4.C(R.string.F_X01);
            d4.w(R.color.CAM_X0101);
            q25 d5 = q25.d(this.M0);
            d5.n(1);
            d5.o(R.string.J_X07);
            d5.f(R.color.black_alpha40);
            q25 d6 = q25.d(this.O0);
            d6.C(R.string.F_X01);
            d6.w(R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.P0, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            FrsBannerHeaderView frsBannerHeaderView = this.D1;
            if (frsBannerHeaderView != null) {
                frsBannerHeaderView.g();
            }
            BarImageView barImageView = this.P;
            if (barImageView != null) {
                barImageView.setBorderWidth(ii.g(this.a.getPageActivity(), R.dimen.tbds1));
                this.P.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.P.setStrokeColorResId(R.color.CAM_X0201);
                this.P.setPlaceHolder(1);
                this.P.invalidate();
            }
            HeadImageView headImageView = this.V0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.Q;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.w;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.U;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            FrsGroupChatSignGuideView frsGroupChatSignGuideView = this.E1;
            if (frsGroupChatSignGuideView != null) {
                frsGroupChatSignGuideView.c();
            }
            Iterator<TbImageView> it = this.B0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            a0();
            N(this.n0 ? 1 : 0);
            P1();
            E1(i2);
            l1(z1(), A1());
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.B;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            n77 n77Var = this.A;
            if (n77Var != null) {
                n77Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.a1;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            nc7 nc7Var = this.s0;
            if (nc7Var != null) {
                nc7Var.h();
            }
            HeaderComponentNoHeaderController headerComponentNoHeaderController = this.F1;
            if (headerComponentNoHeaderController != null) {
                headerComponentNoHeaderController.g();
            }
        }
    }

    public final void e2(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.H = true;
            this.j1 = new h(this, j2, j3, str).start();
            if (this.S != null && !j()) {
                this.S.s(this.H, C1());
            }
        }
    }

    public final void f2(FrsViewData frsViewData, FrsGameRankInfoData frsGameRankInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048622, this, frsViewData, frsGameRankInfoData, str) == null) && frsGameRankInfoData != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.itemInfo != null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("fname", frsViewData.getForum().getName());
            statisticItem.param("obj_id", frsViewData.itemInfo.id.intValue());
            statisticItem.param("obj_name", frsViewData.itemInfo.name);
            statisticItem.param("obj_param1", frsGameRankInfoData.rankName);
            TiebaStatic.log(statisticItem);
        }
    }
}
