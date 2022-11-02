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
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.FrsHeaderVideoImageShadeView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.hc8;
import com.baidu.tieba.iv4;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.AdapterLinearLayout;
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
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class bm6 extends vv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A0;
    public CustomMessageListener A1;
    public View B0;
    public CustomMessageListener B1;
    public boolean C0;
    public CustomMessageListener C1;
    public LinearLayout D0;
    public CustomMessageListener D1;
    public View E0;
    public View F0;
    public View G0;
    public View H0;
    public View I0;
    public TbImageView J0;
    public TextView K0;
    public ImageView L0;
    public TBLottieAnimationView M0;
    public TbImageView N0;
    public boolean O0;
    public TextView P0;
    public final View Q0;
    public final HeadImageView R0;
    public final TextView S0;
    public final View T0;
    public final ImageView U0;
    public final TextView V0;
    public HotRankEntryView W0;
    public List<wn> X0;
    public p56 Y0;
    public int Z0;
    public long a1;
    public ScheduledExecutorService b1;
    public boolean c1;
    public boolean d1;
    public boolean e1;
    public CountDownTimer f1;
    public boolean g1;
    @NonNull
    public final zs6 h1;
    @NonNull
    public final dt6 i1;
    public TbVideoView j1;
    public TbImageView k1;
    public View l1;
    public View m1;
    public TBLottieAnimationView n1;
    public TextView o1;
    public TBLottieAnimationView p1;
    public View q1;
    public View r1;
    public View s1;
    public RelativeLayout t0;
    public View t1;
    public TextView u0;
    public FrsHeaderVideoImageShadeView u1;
    public TextView v0;
    public boolean v1;
    public String w0;
    public boolean w1;
    public ArrayList<TbImageView> x0;
    public MessageRedDotView x1;
    public jk6 y0;
    public FrsViewData y1;
    public boolean z0;
    public CustomMessageListener z1;

    @Override // com.baidu.tieba.vv6
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bm6 b;

        /* loaded from: classes3.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.F != null) {
                    if (this.a.b.F.getVisibility() == 8) {
                        this.a.b.F.setVisibility(0);
                        this.a.b.F.setText(this.a.a);
                        if (this.a.b.H != null) {
                            bm6 bm6Var = this.a.b;
                            bm6Var.D1(bm6Var.H.activity_msg, this.a.b.H.countdown_time.intValue());
                        }
                    } else if (this.a.b.F.getVisibility() == 0) {
                        this.a.b.m1();
                    }
                }
            }
        }

        public i(bm6 bm6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bm6Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bm6 c;

        public a(bm6 bm6Var, ts4 ts4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, ts4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bm6Var;
            this.a = ts4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.m1.getVisibility() == 0) {
                    this.c.j1.start();
                    return;
                }
                vu6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    tu6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bm6 c;

        public b(bm6 bm6Var, ts4 ts4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, ts4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bm6Var;
            this.a = ts4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vu6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    tu6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bm6 c;

        public c(bm6 bm6Var, ts4 ts4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, ts4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bm6Var;
            this.a = ts4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null && !dm5.a(this.c.a.getPageActivity(), this.a.f()) && !TextUtils.isEmpty(this.a.e())) {
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
                    tu6.d(this.b, 1, this.c.b.getUniqueId());
                }
                vu6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(bm6 bm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        public e(bm6 bm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm6Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.g0, "exp_acce", 2);
                memberPayActivityConfig.setSceneId("4004001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        public f(bm6 bm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                bh.d(this.a.N, this.a.a.getPageActivity());
                this.a.b.c = false;
                rp4.s(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f05f9), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        public g(bm6 bm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    bh.c(this.a.N);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bm6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(bm6 bm6Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = bm6Var;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.G = false;
            if (this.b.F != null) {
                this.b.F.setVisibility(8);
            }
            if (this.b.R != null && !this.b.i()) {
                this.b.R.s(this.b.G);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b.F != null) {
                this.b.F.setVisibility(0);
                EMTextView eMTextView = this.b.F;
                eMTextView.setText(this.a + (j / 1000) + "s");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(bm6 bm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, Integer.valueOf(i)};
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
            this.a = bm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vr4)) {
                vr4 vr4Var = (vr4) customResponsedMessage.getData();
                this.a.E1(vr4Var);
                this.a.t1(vr4Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(bm6 bm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, Integer.valueOf(i)};
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
            this.a = bm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && dv6.m(this.a.y1)) {
                this.a.C1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(bm6 bm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, Integer.valueOf(i)};
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
            this.a = bm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (dv6.m(this.a.y1) && this.a.j1.getVisibility() == 0) {
                        this.a.C1();
                    }
                    this.a.w1 = false;
                } else if (intValue == 2 && dv6.m(this.a.y1)) {
                    if (!this.a.w1) {
                        bm6 bm6Var = this.a;
                        bm6Var.H(bm6Var.y1.getForum(), this.a.y1);
                    }
                    this.a.w1 = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(bm6 bm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, Integer.valueOf(i)};
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
            this.a = bm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.v1 = true;
                if (intValue == 1) {
                    if (!FrsFragment.p2 && dv6.m(this.a.y1)) {
                        bm6 bm6Var = this.a;
                        bm6Var.H(bm6Var.y1.getForum(), this.a.y1);
                    }
                } else if (intValue == 2) {
                    if (dv6.m(this.a.y1)) {
                        bm6 bm6Var2 = this.a;
                        bm6Var2.H(bm6Var2.y1.getForum(), this.a.y1);
                    }
                } else if (intValue == 3) {
                    bm6 bm6Var3 = this.a;
                    bm6Var3.H(bm6Var3.y1.getForum(), this.a.y1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(bm6 bm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, Integer.valueOf(i)};
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
            this.a = bm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            bm6 bm6Var = this.a;
            bm6Var.Z1(bm6Var.y1);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRankInfoData a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bm6 c;

        public o(bm6 bm6Var, FrsGameRankInfoData frsGameRankInfoData, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, frsGameRankInfoData, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bm6Var;
            this.a = frsGameRankInfoData;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null) {
                UrlManager.getInstance().dealOneLink(this.c.a, new String[]{this.a.rankLink});
                this.c.M0.pauseAnimation();
                this.c.M0.setFrame(Cea708Decoder.COMMAND_DSW);
                this.c.Y1(this.b, this.a, "c15056");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements jk6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm6 a;

        public p(bm6 bm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm6Var;
        }

        @Override // com.baidu.tieba.jk6
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                cv6.d(this.a.b, this.a.y1, threadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ bm6 c;

        public q(bm6 bm6Var, ts4 ts4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, ts4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bm6Var;
            this.a = ts4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.k1.setVisibility(8);
                    this.c.m1.setVisibility(8);
                    this.c.u1();
                    this.c.Q1(this.a, 0);
                    tu6.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.C1();
                    tu6.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.C1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.V1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements hc8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts4 a;
        public final /* synthetic */ bm6 b;

        public r(bm6 bm6Var, ts4 ts4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm6Var, ts4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bm6Var;
            this.a = ts4Var;
        }

        @Override // com.baidu.tieba.hc8.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.Q1(this.a, i2);
        }
    }

    public bm6(FrsFragment frsFragment, String str, String str2, int i2) {
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
        this.C0 = false;
        this.Z0 = -1;
        this.a1 = 1000L;
        this.g1 = false;
        this.h1 = ys6.a();
        this.z1 = new j(this, 2921679);
        this.A1 = new k(this, 2921681);
        this.B1 = new l(this, 2921680);
        this.C1 = new m(this, 2921682);
        this.D1 = new n(this, 2921721);
        this.x0 = new ArrayList<>();
        this.g0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        xi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        xi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        xi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024d);
        this.U = str;
        this.V = str2;
        View p1 = p1();
        this.d = p1;
        this.h1.c(frsFragment, p1);
        this.i1 = this.h1.e();
        this.t0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0906ea);
        this.u = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d64);
        this.v = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090d67);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d65);
        this.w = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.w.setDefaultBgResource(R.color.transparent);
        this.w.setDefaultResource(R.drawable.obfuscated_res_0x7f080f67);
        this.A0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d82);
        this.j1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f092574);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09256e);
        this.k1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.k1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f67);
        this.k1.setDefaultResource(R.drawable.obfuscated_res_0x7f080f67);
        this.k1.setPlaceHolder(2);
        this.l1 = this.d.findViewById(R.id.obfuscated_res_0x7f092573);
        this.m1 = this.d.findViewById(R.id.obfuscated_res_0x7f092572);
        this.n1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f092571);
        this.B0 = this.d.findViewById(R.id.obfuscated_res_0x7f090c0f);
        this.T = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ba0);
        ys6.d(this.A0, this.B0);
        this.q1 = ys6.b(this.d);
        this.r1 = this.d.findViewById(R.id.obfuscated_res_0x7f090d66);
        this.s1 = this.d.findViewById(R.id.obfuscated_res_0x7f09143d);
        this.o1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092469);
        this.p1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f091488);
        this.t1 = this.d.findViewById(R.id.obfuscated_res_0x7f09256f);
        this.u1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f09256d);
        this.D0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0912a2);
        int l2 = this.h1.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090d7d);
        this.E0 = findViewById;
        findViewById.setVisibility(l2);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f091ead);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f09032f);
        this.x = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f091eae);
        this.y = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090afc);
        this.E = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092652);
        this.A = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090c38);
        this.H0 = this.d.findViewById(R.id.obfuscated_res_0x7f090c2f);
        this.B = this.d.findViewById(R.id.obfuscated_res_0x7f090c30);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f091eb2);
        this.D = this.d.findViewById(R.id.obfuscated_res_0x7f091eb1);
        this.h = (List) this.h1.a(LogicField.LIKE_BTN);
        this.i = (List) this.h1.a(LogicField.SIGN_BTN);
        this.M = (ImageView) o1().a(LogicField.SPEED_ICON);
        this.u0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091521);
        this.v0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091a82);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09131b);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091313);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09148f);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09148e);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091526);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091a88);
        this.n = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090aab);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09041f);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b7d);
        this.O = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.O.setPageId(this.b.getUniqueId());
        this.O.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02e7));
        this.O.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.O.setShowOval(true);
        this.O.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091c01);
        this.x1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.x1.setEnterForumStyle(true);
        this.x1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f091314);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d4d);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091730);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d56);
        this.Q0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bca);
        this.S0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090bcb);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090bcc);
        this.R0 = headImageView;
        headImageView.setIsRound(true);
        this.R0.setDrawBorder(true);
        this.R0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.R0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.T0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bc9);
        this.U0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090bc8);
        this.V0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090bc7);
        WebPManager.setPureDrawable(this.U0, R.drawable.obfuscated_res_0x7f0807f6, R.color.CAM_X0101, null);
        this.J = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d034d, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d031b, (ViewGroup) null);
        this.W0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090b7b);
        this.m.setVisibility(8);
        new nu6(this.a);
        this.F = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f09071e);
        this.n0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090d70);
        this.I0 = this.d.findViewById(R.id.obfuscated_res_0x7f090c94);
        TbImageView tbImageView3 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090c93);
        this.J0 = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.J0.setConrers(15);
        this.J0.setRadiusById(R.string.J_X05);
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090c97);
        this.K0 = textView;
        textView.getPaint().setStrokeWidth(0.5f);
        this.K0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.L0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090c95);
        this.M0 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090c96);
        this.N0 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090c92);
        this.M0.setImageAssetsFolder("lottie_frs_game_rank_guide");
        this.M0.setAnimation(R.raw.obfuscated_res_0x7f11003d);
        this.M0.setRepeatMode(1);
        this.M0.setMinAndMaxFrame(57, Cea708Decoder.COMMAND_DSW);
        MessageManager.getInstance().registerListener(this.z1);
        MessageManager.getInstance().registerListener(this.A1);
        MessageManager.getInstance().registerListener(this.B1);
        MessageManager.getInstance().registerListener(this.C1);
        MessageManager.getInstance().registerListener(this.D1);
    }

    public void G1(iv4 iv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iv4Var) == null) {
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(this));
        }
    }

    public void H1(iv4 iv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iv4Var) == null) {
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3b, new e(this));
        }
    }

    @Override // com.baidu.tieba.vv6
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.h1.g(z);
        }
    }

    public final boolean v1(ts4 ts4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, ts4Var)) == null) {
            if (ts4Var == null || StringUtils.isNull(ts4Var.c()) || StringUtils.isNull(ts4Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vv6
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            super.x(z);
            il6 il6Var = this.z;
            if (il6Var != null) {
                il6Var.k(z);
            }
        }
    }

    public final void D1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048582, this, str, j2) == null) {
            this.G = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.b1 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new i(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public final void A1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        FrsGameRankInfoData frsGameRankInfoData = frsViewData.frsGameRankInfoData;
        if (frsGameRankInfoData == null) {
            this.I0.setVisibility(8);
            this.D.setVisibility(8);
            this.E0.setVisibility(this.h1.l(LogicField.ROUND_CORNER_STYLE));
            this.O.setUseStrokeColorInt(false);
            this.N0.setVisibility(8);
            this.M0.pauseAnimation();
            return;
        }
        this.I0.setVisibility(0);
        View view2 = this.D;
        if (this.x.getVisibility() == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        Y1(frsViewData, frsGameRankInfoData, "c15055");
        this.E0.setVisibility(8);
        int b2 = wi7.b(frsGameRankInfoData.rankColor);
        if (wi7.a(b2)) {
            this.O.setUseStrokeColorInt(false);
        } else {
            this.O.setStrokeColorInt(b2);
            this.O.setUseStrokeColorInt(true);
        }
        if (!this.M0.isAnimating() && !this.O0) {
            int i3 = frsGameRankInfoData.showType;
            if (i3 < 0) {
                this.M0.setRepeatCount(-1);
                this.M0.o();
                this.O0 = true;
            } else if (i3 > 0) {
                this.M0.setRepeatCount(i3);
                this.M0.o();
                this.O0 = true;
            } else {
                this.M0.setFrame(Cea708Decoder.COMMAND_DSW);
            }
        }
        this.J0.K(frsGameRankInfoData.icon, 10, false);
        if (TextUtils.isEmpty(frsGameRankInfoData.rankIcon)) {
            this.N0.setVisibility(8);
        } else {
            this.N0.setVisibility(0);
            this.N0.K(frsGameRankInfoData.rankIcon, 10, false);
        }
        this.K0.setText(frsGameRankInfoData.rankName + "#" + frsGameRankInfoData.rankScore);
        this.I0.setOnClickListener(new o(this, frsGameRankInfoData, frsViewData));
    }

    public final void n1(kn8 kn8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, kn8Var) == null) && kn8Var != null && this.y1 != null && !this.g1) {
            this.g1 = true;
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (kn8Var.getType() != 1) {
                if (kn8Var.getType() == 2) {
                    i2 = 7;
                } else if (kn8Var.getType() == 3) {
                    i2 = 8;
                } else if (kn8Var.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", kn8Var.c());
            ForumData forum = this.y1.getForum();
            if (forum != null) {
                statisticItem.param("fid", forum.getId());
                statisticItem.param("fname", forum.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
            }
            if (kn8Var.getType() == 1) {
                statisticItem.param("tid", kn8Var.m());
                statisticItem.param("thread_type", kn8Var.n());
            }
            if (StringUtils.isNull(kn8Var.q())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (YYLiveUtil.isYYLiveLink(kn8Var.p())) {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            } else {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.vv6
    public void B(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.k0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.k0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0a08);
                if (f2 >= 1.0f) {
                    i2 = this.a0;
                } else {
                    i2 = this.a0 + 1;
                }
                FrsViewData O0 = this.b.O0();
                if (O0 != null && O0.getForum() != null) {
                    O0.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ab0, Integer.valueOf(i2)));
            } else {
                this.h1.d(this.a0, this.W);
                this.j.setText(this.W);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ab0, Integer.valueOf(this.a0)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, q1(this.a0)));
            if (this.k0) {
                if (f2 >= 1.0f) {
                    Y(this.k, this.m0, f2);
                } else {
                    W(this.k, this.m0, f2);
                }
            } else {
                Y(this.k, this.m0, f2);
            }
            this.m0 = f2;
        }
    }

    public final void j1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (relativeLayout = this.u) != null && relativeLayout.getLayoutParams() != null) {
            if (this.W0.getVisibility() == 0) {
                g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.W0.getLayoutParams()).topMargin = (xi.g(this.a.getPageActivity(), R.dimen.tbds226) + xi.u(this.a.getPageActivity())) - xi.g(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds650);
            }
            if (!z && !z2 && !this.z0) {
                g2 -= xi.g(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.z0) {
                if (dv6.m(this.y1)) {
                    g2 = P1(z, z2);
                } else {
                    g2 = J1(z, z2);
                }
            }
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams.height != g2) {
                layoutParams.height = g2;
                this.u.setLayoutParams(layoutParams);
            }
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean T1 = T1();
            this.z0 = T1;
            this.h1.f(T1);
            if (this.z0) {
                this.v.setVisibility(8);
                if (dv6.m(this.y1)) {
                    this.A0.setVisibility(4);
                } else {
                    this.A0.setVisibility(0);
                }
                this.B0.setVisibility(0);
            } else {
                this.A0.setVisibility(8);
                this.B0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.b0));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.c0));
            }
            this.h1.i(this.b0, this.c0);
            this.h1.d(this.a0, this.W);
            ArrayList<ds4> arrayList = this.Q;
            if (arrayList != null && arrayList.size() > 0) {
                this.U = UtilHelper.getFixedText(this.U, 7);
            } else if (this.l0) {
                this.U = UtilHelper.getFixedText(this.U, 6);
            }
            String d0 = aj6.d0(this.U);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(d0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(d0);
            }
            this.h1.j(this.w0, d0);
            F1();
            D();
            z1(TbadkCoreApplication.getInst().getSkinType());
            I1();
            A1(this.y1);
            k1();
        }
    }

    @Override // com.baidu.tieba.vv6
    public void T() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.Z0 != -1 && (frsViewData = this.y1) != null && frsViewData.forumRule != null && frsViewData.getUserData() != null && this.A != null) {
            if (this.y1.getUserData().getIs_manager() == 1) {
                if (this.y1.forumRule.has_forum_rule.intValue() != 1 && this.y1.forumRule.audit_status.intValue() == 0) {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f0781);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f0782);
                str = "key_forum_rule_first_show_frs";
            }
            View view2 = null;
            if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
                if (this.Z0 < adapterLinearLayout.getChildCount()) {
                    view2 = adapterLinearLayout.getChildAt(this.Z0);
                }
            }
            if (this.Y0 == null && view2 != null) {
                p56 p56Var = new p56(this.a, view2);
                this.Y0 = p56Var;
                p56Var.L(R.drawable.obfuscated_res_0x7f0802f5);
                this.Y0.o(16);
                this.Y0.x(true);
                this.Y0.P(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                this.Y0.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                this.Y0.M(true);
                this.Y0.n(4000);
                if (!this.Y0.i() && !this.b.w3()) {
                    this.Y0.S(string, str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.vv6
    public void V() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            PopupWindow popupWindow = this.N;
            if (popupWindow == null) {
                this.N = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07f8, (ViewGroup) null);
                this.N.setContentView(contentView);
                contentView.setOnClickListener(new f(this));
                this.N.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070299));
                this.N.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070306));
                this.N.setBackgroundDrawable(new BitmapDrawable());
                this.N.setOutsideTouchable(true);
                this.N.setTouchInterceptor(new g(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091510), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091f74), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f092145), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.M.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.N;
            bh.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.M.getWidth() / 2), iArr[1] + this.M.getWidth());
            this.N.update();
        }
    }

    public final void m1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.H == null) {
            return;
        }
        CountDownTimer countDownTimer = this.f1;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f1.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        boolean z3 = true;
        if ((this.H.activity_time.intValue() + this.H.activity_duration.intValue()) - currentTimeMillis < 0) {
            z = true;
        } else {
            z = false;
        }
        this.c1 = z;
        if (this.H.activity_time.intValue() - currentTimeMillis <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.d1 = z2;
        if ((this.H.activity_time.intValue() - this.H.countdown_time.intValue()) - currentTimeMillis > 0) {
            z3 = false;
        }
        this.e1 = z3;
        boolean z4 = this.c1;
        if (z4) {
            this.F.setVisibility(8);
            return;
        }
        if (this.d1 && !z4) {
            X1(this.H.activity_msg, 1000 * ((this.H.activity_time.intValue() + this.H.activity_duration.intValue()) - currentTimeMillis), this.a1);
        }
        if (!this.d1 && this.e1) {
            this.F.setVisibility(0);
            this.F.setText(this.H.countdown_msg);
            SignActivityInfo signActivityInfo = this.H;
            D1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (!this.e1) {
            SignActivityInfo signActivityInfo2 = this.H;
            D1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.H.countdown_time.intValue()) - currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.vv6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.A.i(this.Z0);
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k1.setVisibility(0);
            Q1(null, -1);
            u1();
            TbVideoView tbVideoView = this.j1;
            if (tbVideoView != null) {
                tbVideoView.Q();
            }
            this.j1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.vv6
    public void D() {
        FrsViewData frsViewData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null && (frsViewData = this.y1) != null) {
            List<wn> showTopThreadList = frsViewData.getShowTopThreadList();
            if (showTopThreadList.size() > 2) {
                z = true;
            } else {
                z = false;
            }
            this.C0 = z;
            S1(showTopThreadList, this.y1.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.vv6
    public void E() {
        mv6 mv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (mv6Var = this.R) != null) {
            mv6Var.q(this.d0);
        }
    }

    @Override // com.baidu.tieba.vv6
    public void F() {
        mv6 mv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mv6Var = this.R) != null) {
            mv6Var.s(this.G);
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.O.K(this.w0, 10, false);
        }
    }

    public void K1() {
        lv6 lv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (lv6Var = this.S) != null) {
            lv6Var.n();
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.w0);
            this.Z.getMedias().add(mediaData);
        }
    }

    @Override // com.baidu.tieba.vv6
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.g0 != 0) {
                SkinManager.setImageResource(this.M, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.M, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.vv6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.h1.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.vv6
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            SignActivityInfo signActivityInfo = this.H;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vv6
    public SignActivityInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.H;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vv6
    public void n() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (p56Var = this.Y0) != null) {
            p56Var.h();
            this.Z0 = -1;
        }
    }

    @NonNull
    public zs6 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.h1;
        }
        return (zs6) invokeV.objValue;
    }

    public View p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0341, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vv6
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.z0;
        }
        return invokeV.booleanValue;
    }

    public final LinearGradientView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.E3() != null) {
                View E = this.b.E3().E();
                if (E instanceof LinearGradientView) {
                    return (LinearGradientView) E;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vv6
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public final void u1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (tBLottieAnimationView = this.n1) != null) {
            tBLottieAnimationView.setVisibility(8);
            if (this.n1.isAnimating()) {
                this.n1.cancelAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.vv6
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.w();
            if (dv6.m(this.y1)) {
                C1();
            }
            il6 il6Var = this.z;
            if (il6Var != null) {
                il6Var.j();
            }
        }
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            FrsTopView frsTopView = this.A;
            if (frsTopView != null && frsTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null && serviceAreaView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vv6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            il6 il6Var = this.z;
            if (il6Var != null) {
                il6Var.l();
            }
            if (FrsFragment.p2 && dv6.m(this.y1)) {
                FrsFragment.p2 = false;
                H(this.y1.getForum(), this.y1);
            }
        }
    }

    public final int y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            int l2 = xi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.j1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    public final void E1(vr4 vr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vr4Var) != null) || vr4Var == null) {
            return;
        }
        if (!vr4Var.e()) {
            if (this.o1.getVisibility() != 8) {
                this.o1.setVisibility(8);
            }
            if (this.p1.getVisibility() != 8) {
                this.p1.setVisibility(8);
                if (this.p1.isAnimating()) {
                    this.p1.cancelAnimation();
                }
            }
        } else if (vr4Var.d() < vr4Var.b()) {
            this.o1.setText(R.string.obfuscated_res_0x7f0f127e);
            N1();
        } else if (vr4Var.d() < vr4Var.c()) {
            this.o1.setText(R.string.obfuscated_res_0x7f0f127d);
            N1();
        } else {
            this.o1.setText(R.string.obfuscated_res_0x7f0f127f);
            this.p1.setVisibility(4);
            if (this.p1.isAnimating()) {
                this.p1.cancelAnimation();
            }
        }
    }

    public final void R1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.S0.setText(str);
                    this.R0.K(forumData.getManagers().get(0).portrait, 12, false);
                    this.Q0.setVisibility(0);
                } else {
                    this.Q0.setVisibility(8);
                }
                if (this.T0.getVisibility() == 0) {
                    this.T0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.Q0.getVisibility() == 0) {
                this.Q0.setVisibility(8);
            }
            if (this.T0.getVisibility() == 8) {
                this.T0.setVisibility(0);
            }
        }
    }

    public final void z1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048642, this, i2) == null) && (frsViewData = this.y1) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && (themeElement = themeColorInfo.day) != null && (themeElement2 = themeColorInfo.night) != null && (themeElement3 = themeColorInfo.dark) != null) {
            if (i2 == 4) {
                themeElement = themeElement3;
            } else if (i2 == 1) {
                themeElement = themeElement2;
            }
            this.i1.b(themeElement);
            this.h1.b(themeElement);
            if (!this.z0) {
                LinearGradientView r1 = r1();
                LinearGradientView linearGradientView = this.v;
                if (linearGradientView != null && r1 != null) {
                    ThemeElement themeElement4 = themeColorInfo.day;
                    String str = themeElement4.light_color;
                    String str2 = themeElement4.dark_color;
                    ThemeElement themeElement5 = themeColorInfo.night;
                    String str3 = themeElement5.light_color;
                    String str4 = themeElement5.dark_color;
                    ThemeElement themeElement6 = themeColorInfo.dark;
                    linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
                }
                TbImageView tbImageView = this.w;
                if (tbImageView != null) {
                    tbImageView.K(themeElement.pattern_image, 10, false);
                }
            }
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.setThemeFontColor(wi7.b(themeElement.common_color));
            }
            if (this.A != null) {
                this.A.setUrlAndColor(forum.getTopIcon(), wi7.b(themeElement.common_color));
            }
        }
    }

    @Override // com.baidu.tieba.vv6
    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.O.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.W0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.Q0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.T0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.h1.h(onClickListener);
        }
    }

    public final void L1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.E0.getVisibility() != 0) {
                g2 -= xi.g(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.s1.getLayoutParams()).topMargin = i2 - g2;
        }
    }

    @Override // com.baidu.tieba.vv6
    public void H(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, forumData, frsViewData) != null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.w1 = true;
        if (dv6.m(this.y1)) {
            C1();
        }
        this.U = forumData.getName();
        this.V = forumData.getId();
        this.b0 = forumData.getMember_num();
        this.c0 = forumData.getPost_num();
        forumData.getTag_color();
        this.w0 = forumData.getImage_url();
        this.W = forumData.getLevelName();
        this.a0 = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.d0 = forumData.getSignData().miss_sign_num;
        }
        this.e0 = forumData.getCurScore();
        this.f0 = forumData.getLevelupScore();
        this.Q = forumData.getBadgeData();
        this.X = forumData.getAccelerateContent();
        this.l0 = forumData.isBrandForum;
        this.y1 = frsViewData;
        if (!StringUtils.isNull(this.V) && !StringUtils.isNull(this.U)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.y1;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.y1.getHotUserRankData().hot_user != null && this.y1.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        int l2 = this.h1.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.y1;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.x.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.x.setVisibility(0);
            this.F0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.y1;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.F0.setVisibility(8);
        }
        this.Z = new ThreadData();
        M1();
        B1();
        if (this.y1.getActivityHeadData() != null && this.y1.getActivityHeadData().a() != null) {
            ArrayList<ts4> b2 = this.y1.getActivityHeadData().b();
            ts4 ts4Var = null;
            if (!ListUtils.isEmpty(b2)) {
                ts4Var = b2.get(0);
            }
            this.P0 = ys6.c(this.d, v1(ts4Var));
            if (this.z0 && this.y1.getActivityHeadData().a().h) {
                this.P0.setVisibility(0);
            } else {
                this.P0.setVisibility(8);
            }
        }
        R1(forumData);
        if (frsViewData != null) {
            this.H = frsViewData.mSignActivityInfo;
            m1();
        }
        this.y1 = frsViewData;
        Z1(frsViewData);
    }

    public final void S1(List<wn> list, kn8 kn8Var) {
        ForumData forumData;
        ForumData forumData2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048602, this, list, kn8Var) != null) || this.A == null) {
            return;
        }
        this.X0 = list;
        FrsViewData frsViewData = this.y1;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.y1.getVoiceRoomData().a().size() > 0) {
            this.E.setVisibility(0);
            this.E.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.y1.getVoiceRoomData().a())) {
                if (this.y1.getVoiceRoomData().a().size() > 5) {
                    this.E.setShowMore(true);
                } else {
                    this.E.setShowMore(false);
                }
            }
            this.E.a(this.y1.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.E;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.E.setVisibility(8);
            }
        }
        UserData userData = null;
        if (kn8Var != null) {
            this.z = new il6(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.f());
            FrsViewData frsViewData2 = this.y1;
            if (frsViewData2 != null) {
                forumData2 = frsViewData2.getForum();
            } else {
                forumData2 = null;
            }
            il6 il6Var = this.z;
            FrsViewData frsViewData3 = this.y1;
            if (frsViewData3 != null && !frsViewData3.isFromCache) {
                z = false;
            } else {
                z = true;
            }
            il6Var.e(forumData2, kn8Var, z);
            n1(kn8Var);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.E;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.H0.setVisibility(8);
        } else {
            this.H0.setVisibility(this.h1.l(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.V3()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.y1;
            if (frsViewData4 != null) {
                forumData = frsViewData4.getForum();
            } else {
                forumData = null;
            }
            FrsViewData frsViewData5 = this.y1;
            if (frsViewData5 != null) {
                userData = frsViewData5.getUserData();
            }
            this.A.setForum(this.V, this.U, forumData, userData, this.b.o3());
            if (list.size() > 0 && (list.get(0) instanceof tn8)) {
                this.Z0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof tn8)) {
                this.Z0 = 1;
            } else {
                this.Z0 = -1;
            }
            this.A.setDatas(list, kn8Var);
            if (this.y0 == null) {
                this.y0 = new p(this);
            }
            this.A.setStatListener(this.y0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final void I1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.a != null && (frsViewData = this.y1) != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                this.o0 = new fq6(this.a, this.y1.liveFuseForumDataList);
                if (this.y1.getForum() != null) {
                    this.o0.i(this.y1.getForum().getId(), this.y1.getForum().getName());
                }
                View f2 = this.o0.f();
                this.H0.setVisibility(8);
                this.n0.setVisibility(0);
                this.n0.removeAllViews();
                this.n0.addView(f2);
                this.o0.d();
                return;
            }
            this.n0.setVisibility(8);
        }
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            FrsViewData frsViewData = this.y1;
            if (frsViewData == null) {
                return false;
            }
            ts4 ts4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                ts4Var = new ts4();
                ts4Var.q("");
                ts4Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                ts4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (ts4Var == null) {
                return false;
            }
            if (v1(ts4Var)) {
                W1(frsViewData, ts4Var);
            } else {
                U1(frsViewData, ts4Var);
            }
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ts4Var.l(), 0));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vv6
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.u();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.N;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.N.dismiss();
            }
            n();
            il6 il6Var = this.z;
            if (il6Var != null) {
                il6Var.i();
            }
            CountDownTimer countDownTimer = this.f1;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f1 = null;
            }
            this.M0.cancelAnimation();
            this.h1.onDestory();
            MessageManager.getInstance().unRegisterListener(this.z1);
            MessageManager.getInstance().unRegisterListener(this.A1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
        }
    }

    public final int J1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds782);
            int s1 = s1(z, z2);
            L1(g2);
            int i2 = g2 + s1;
            this.w.setVisibility(0);
            this.j1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = s1;
            ((RelativeLayout.LayoutParams) this.A0.getLayoutParams()).bottomMargin = s1;
            if (s1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds782) - xi.g(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void U1(FrsViewData frsViewData, ts4 ts4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, frsViewData, ts4Var) == null) && this.w != null && ts4Var != null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem("c13326");
                statisticItem.param("fid", frsViewData.getForum().getId());
                statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                tu6.e(frsViewData, 1, this.b.getUniqueId());
            }
            this.w.K(ts4Var.d(), 10, false);
            this.w.setOnClickListener(new c(this, ts4Var, frsViewData));
        }
    }

    public final void W1(FrsViewData frsViewData, ts4 ts4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, frsViewData, ts4Var) == null) {
            this.k1.setVisibility(0);
            Q1(null, -1);
            this.k1.K(ts4Var.c(), 10, false);
            if (this.j1.getVisibility() != 0) {
                this.j1.setVisibility(0);
            }
            this.j1.setVideoPath(ts4Var.h());
            this.j1.setVolume(0.0f, 0.0f);
            this.j1.setVideoScalingMode(0);
            this.j1.I(true);
            this.j1.setLooping(false);
            this.j1.setVideoStatusChangeListener(new q(this, ts4Var, frsViewData));
            this.j1.getMediaProgressObserver().j(new r(this, ts4Var));
            if (tu6.f()) {
                this.m1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.y1.isFromCache && (this.v1 || (!frsFragment.S3() && !this.b.R3() && !this.b.x3()))) {
                    this.j1.start();
                }
            } else {
                this.m1.setVisibility(0);
            }
            this.k1.setOnClickListener(new a(this, ts4Var, frsViewData));
            this.j1.setOnClickListener(new b(this, ts4Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                tu6.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    public final int s1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<wn> list;
        List<go8> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                fo8 fo8Var = this.y1.serviceAreaData;
                if (fo8Var != null && (list2 = fo8Var.b) != null && list2.size() == 1) {
                    i2 = 0 + xi.g(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + xi.g(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.X0) != null) {
                i2 += Math.min(list.size(), 2) * xi.g(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += xi.g(this.a.getPageActivity(), R.dimen.tbds231);
            }
            if (z2 || z || this.y.getVisibility() == 0) {
                return i2 + xi.g(this.a.getPageActivity(), R.dimen.tbds45);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            TextView textView = this.o1;
            if (textView != null && textView.getVisibility() == 8) {
                this.o1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.p1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.p1.getVisibility() == 4) {
                    this.p1.setVisibility(0);
                    if (this.p1.isAnimating()) {
                        this.p1.cancelAnimation();
                    }
                    this.p1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.p1.setRepeatCount(-1);
                    this.p1.playAnimation();
                }
            }
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int l2 = xi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.k1.setLayoutParams(layoutParams);
            this.k1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l1.getLayoutParams();
            layoutParams2.width = l2;
            layoutParams2.height = i2;
            this.l1.setLayoutParams(layoutParams2);
        }
    }

    public final void V1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (tBLottieAnimationView = this.n1) != null) {
            if (tBLottieAnimationView.getVisibility() == 8 || this.n1.getVisibility() == 4) {
                this.n1.setVisibility(0);
                if (this.n1.isAnimating()) {
                    this.n1.cancelAnimation();
                }
                this.n1.setAnimation(R.raw.obfuscated_res_0x7f11001b);
                this.n1.setRepeatCount(-1);
                this.n1.playAnimation();
            }
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            boolean w1 = w1();
            boolean x1 = x1();
            if (!TextUtils.isEmpty(this.U)) {
                gu6 c2 = fu6.d().c(this.U);
                if (c2 == null) {
                    c2 = new gu6(this.C0, w1);
                } else {
                    c2.d(this.C0);
                    c2.e(w1);
                }
                fu6.d().e(this.U, c2);
            }
            l1(w1, x1);
            j1(w1, x1);
        }
    }

    public final int P1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int y1 = y1();
            O1();
            int s1 = s1(z, z2);
            this.t1.setVisibility(0);
            this.u1.setVisibility(0);
            int g2 = xi.g(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = s1 + y1 + g2;
            this.w.setVisibility(8);
            this.j1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (y1 - xi.g(this.a.getPageActivity(), R.dimen.tbds282)) + g2;
            L1(y1 + g2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void l1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b.E3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D0.getLayoutParams();
        if (!z && !z2) {
            this.D0.setVisibility(0);
            this.F0.setVisibility(8);
            this.G0.setVisibility(this.h1.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.D0.setVisibility(0);
            this.F0.setVisibility(this.h1.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.E3().u(z, z2);
    }

    public final void Q1(ts4 ts4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, ts4Var, i2) == null) {
            if (i2 == -1) {
                b2 = tu6.c(this.y1);
            } else {
                b2 = tu6.b(ts4Var, i2);
            }
            if (!StringUtils.isNull(b2)) {
                int b3 = wi7.b(b2);
                this.u1.setGradientColors(0, b3);
                this.t1.setBackgroundColor(b3);
            }
        }
    }

    @Override // com.baidu.tieba.vv6
    @SuppressLint({"ResourceAsColor"})
    public void S(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, view2, z) == null) {
            if (this.g0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
                    View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0677, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090756);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091322);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f7c);
                    SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09097e), R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                    iv4 iv4Var = new iv4(this.a.getPageActivity());
                    iv4Var.setContentView(inflate);
                    I(textView, textView2);
                    if (!TextUtils.isEmpty(this.X) && !TextUtils.isEmpty(this.X.trim())) {
                        textView3.setVisibility(0);
                        textView3.setText(this.X);
                    } else {
                        textView3.setVisibility(8);
                    }
                    iv4Var.setButtonTextColor(R.color.CAM_X0305);
                    G1(iv4Var);
                    H1(iv4Var);
                    iv4Var.create(this.a);
                    iv4Var.show();
                    return;
                }
                return;
            }
            this.c.removeCallbacks(this.q0);
            if (this.I == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.I = popupWindow;
                popupWindow.setContentView(this.J);
                this.I.setBackgroundDrawable(new BitmapDrawable());
                this.I.setOutsideTouchable(true);
                this.I.setFocusable(true);
                this.I.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027d));
                this.I.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a));
            }
            this.K = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f090755);
            this.L = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f091321);
            SkinManager.setBackgroundResource(this.J.findViewById(R.id.obfuscated_res_0x7f09097b), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.J.findViewById(R.id.obfuscated_res_0x7f09097a), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.K, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.L, R.color.CAM_X0111, 1);
            I(this.K, this.L);
            if (this.I.isShowing()) {
                bh.d(this.I, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] - this.I.getHeight() <= 50) {
                bh.d(this.I, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.I;
            bh.m(popupWindow2, this.d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.I.update();
            this.c.postDelayed(this.q0, 2000L);
        }
    }

    public final void X1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.G = true;
            this.f1 = new h(this, j2, j3, str).start();
            if (this.R != null && !i()) {
                this.R.s(this.G);
            }
        }
    }

    public final void Y1(FrsViewData frsViewData, FrsGameRankInfoData frsGameRankInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048611, this, frsViewData, frsGameRankInfoData, str) == null) && frsGameRankInfoData != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.itemInfo != null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("fname", frsViewData.getForum().getName());
            statisticItem.param("obj_id", frsViewData.itemInfo.id.intValue());
            statisticItem.param("obj_name", frsViewData.itemInfo.name);
            statisticItem.param("obj_param1", frsGameRankInfoData.rankName);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Z1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.x1.setVisibility(0);
                    this.x1.f(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.x1.setVisibility(8);
                return;
            }
            this.x1.setVisibility(8);
        }
    }

    public final int[] q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
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

    public final void t1(vr4 vr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, vr4Var) == null) && vr4Var != null && vr4Var.b() != 0.0f) {
            float d2 = vr4Var.d() / ((vr4Var.b() * 40.0f) / 70.0f);
            float d3 = vr4Var.d() / vr4Var.b();
            this.o1.setAlpha(d2);
            this.p1.setAlpha(d2);
            this.q1.setAlpha(1.0f - d2);
            float f2 = 1.0f - d3;
            this.r1.setAlpha(f2);
            this.l1.setAlpha(f2);
        }
    }

    @Override // com.baidu.tieba.vv6
    public void c(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.h1.onChangeSkinType(i2);
            qq4 layoutMode = this.a.getLayoutMode();
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.d);
            this.a.getLayoutMode().k(this.J);
            this.a.getLayoutMode().k(this.m);
            SkinManager.setBackgroundResource(this.J, R.drawable.icon_frs_experience_number);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f080590);
            kw4 d2 = kw4.d(this.E0);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.F0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.G0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.H0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.n0, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.u0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.v0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.S0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.V0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            kw4 d3 = kw4.d(this.o1);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X09);
            kw4 d4 = kw4.d(this.F);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0101);
            kw4 d5 = kw4.d(this.I0);
            d5.m(1);
            d5.n(R.string.J_X07);
            d5.f(R.color.black_alpha40);
            kw4 d6 = kw4.d(this.K0);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.L0, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            BarImageView barImageView = this.O;
            if (barImageView != null) {
                barImageView.setBorderWidth(xi.g(this.a.getPageActivity(), R.dimen.tbds1));
                this.O.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.O.setStrokeColorResId(R.color.CAM_X0201);
                this.O.setPlaceHolder(1);
                this.O.invalidate();
            }
            HeadImageView headImageView = this.R0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.P;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.T;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            Iterator<TbImageView> it = this.x0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            Z();
            L(this.j0 ? 1 : 0);
            K1();
            z1(i2);
            j1(w1(), x1());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            il6 il6Var = this.z;
            if (il6Var != null) {
                il6Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.W0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.E;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            fq6 fq6Var = this.o0;
            if (fq6Var != null) {
                fq6Var.h();
            }
        }
    }
}
