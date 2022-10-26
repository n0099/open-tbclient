package com.baidu.tieba;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.CustomFrameLayout;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.sa8;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.xa8;
import com.baidu.tieba.xf;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class b38 {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c T;
    public static sa8.z U;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoWifiTipLayout A;
    public int B;
    public long C;
    public sa8.g0 D;
    public sa8.u E;
    public boolean F;
    public Handler G;
    public PbFullScreenFloatingHuajiAninationView H;
    public PbFullScreenFloatingHuajiAninationView.c I;
    public wf J;
    public Bitmap K;
    public boolean L;
    public boolean M;
    public boolean N;
    public sa8.d0 O;
    public CustomMessageListener P;
    public int Q;
    public Animation.AnimationListener R;
    public CustomMessageListener S;
    public RelativeLayout a;
    public z18 b;
    public CustomFrameLayout c;
    public PbFragment d;
    public sa8.u e;
    public String f;
    public VideoInfo g;
    public sa8 h;
    public kb8 i;
    public z28 j;
    public boolean k;
    public ThreadData l;
    public ThreadData m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public float r;
    public boolean s;
    public boolean t;
    public int u;
    public double v;
    public View w;
    public float x;
    public boolean y;
    public ie0 z;

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements sa8.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.a.B > 0) {
                        b38 b38Var = this.a.a;
                        b38Var.M(b38Var.B);
                        b38 b38Var2 = this.a.a;
                        b38Var2.j0(b38Var2.B);
                        this.a.a.B = 0;
                    }
                    this.a.a.F = true;
                }
            }
        }

        public b(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.sa8.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.a.F = false;
                b38 b38Var = this.a;
                b38Var.B = b38Var.P().getHeight();
            }
        }

        @Override // com.baidu.tieba.sa8.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.a.G.postDelayed(new a(this), 200L);
                this.a.C = -1L;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements xa8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ThreadData c;
        public final /* synthetic */ b38 d;

        public a(b38 b38Var, VideoInfo videoInfo, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var, videoInfo, str, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = b38Var;
            this.a = videoInfo;
            this.b = str;
            this.c = threadData;
        }

        @Override // com.baidu.tieba.xa8.c
        public void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.d.C <= 0) {
                    this.d.C = i2;
                }
                McnAdInfo mcnAdInfo = this.a.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a = he0.b().a(mcnAdInfo.jump_url);
                if (this.d.y && !a && !this.d.o) {
                    boolean z2 = true;
                    if (this.d.C >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long j = i2;
                    if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                        if (!this.d.z.c()) {
                            ge0 ge0Var = new ge0();
                            ge0Var.b = mcnAdInfo.card_title;
                            ge0Var.c = mcnAdInfo.button_title;
                            ge0Var.d = mcnAdInfo.jump_url;
                            ge0Var.a = mcnAdInfo.pic_url;
                            ge0Var.f = this.b;
                            ge0Var.e = this.c.getTid();
                            ge0Var.g = 4;
                            if (z) {
                                this.d.z.f(ge0Var, (ViewGroup) this.d.h.E0());
                            } else {
                                this.d.z.e(ge0Var, (ViewGroup) this.d.h.E0());
                            }
                        }
                    } else if (this.d.z.c()) {
                        this.d.z.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements sa8.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public c(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.sa8.y
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.m != null && !StringUtils.isNull(this.a.m.getId())) {
                this.a.d.s6(this.a.m.getId());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements sa8.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public d(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.sa8.a0
        public void a(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.l != null) {
                b38 b38Var = this.a;
                if (z) {
                    str = "1";
                } else {
                    str = "2";
                }
                b38Var.l0(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public e(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.a.f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements vf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        @Override // com.baidu.tieba.vf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public f(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.vf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.a.d.getActivity());
                if (this.a.K == null) {
                    try {
                        this.a.K = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080f01);
                        imageView.setImageBitmap(this.a.K);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements xf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        @Override // com.baidu.tieba.xf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public g(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.xf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.J = null;
            if (this.a.K != null && !this.a.K.isRecycled()) {
                this.a.K.recycle();
            }
            this.a.K = null;
        }
    }

    /* loaded from: classes3.dex */
    public final class h implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class i implements sa8.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.sa8.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public j(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b38 b38Var = this.a;
                b38Var.j0(b38Var.P().getHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements sa8.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public k(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.sa8.g0
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.d.K() != null && this.a.d.K().S1() != null) {
                PostData j = this.a.d.K().S1().j();
                if (j == null && ListUtils.getCount(this.a.d.K().S1().G()) > 1) {
                    j = (PostData) ListUtils.getItem(this.a.d.K().S1().G(), 0);
                }
                u28.b(this.a.d.K().S1(), j, 1, 1, 4);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public l(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(b38 b38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var, Integer.valueOf(i)};
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
            this.a = b38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null) {
                b38 b38Var = this.a;
                b38Var.b0(b38Var.g);
                this.a.h.q0();
                if (this.a.w != null && this.a.w.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.w.getLayoutParams();
                    layoutParams.height = this.a.u;
                    this.a.w.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public n(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.N(false);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements sa8.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        @Override // com.baidu.tieba.sa8.d0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public o(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.sa8.d0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v >= 1.0d) {
                    if (!this.a.d.checkUpIsLogin()) {
                        return true;
                    }
                    this.a.d.b6();
                    if (this.a.d.K() != null && this.a.d.K().S1() != null && this.a.d.K().S1().T() != null) {
                        iw7 T = this.a.d.K().S1().T();
                        if (this.a.H == null) {
                            this.a.H = new PbFullScreenFloatingHuajiAninationView(this.a.d.getActivity());
                            this.a.H.setFloatingHuajiAninationListener(this.a.I);
                        }
                        this.a.H.f(!T.f());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(b38 b38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var, Integer.valueOf(i)};
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
            this.a = b38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                if (this.a.h != null) {
                    this.a.h.m1();
                }
                if (BdNetTypeUtil.isMobileNet() && this.a.h != null && this.a.h.R0() && this.a.g != null && this.a.g.video_length.intValue() > 0 && this.a.g.video_duration.intValue() > 0) {
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    double intValue = ((this.a.g.video_length.intValue() * (1.0f - ((this.a.h.B0() * 1.0f) / (this.a.g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                    if (intValue >= 0.1d) {
                        fj.N(this.a.d.getPageContext().getPageActivity(), String.format(this.a.d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e28), decimalFormat.format(intValue)));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements sa8.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public q(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // com.baidu.tieba.sa8.e0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, seekBar) != null) {
                return;
            }
            this.a.C = -1L;
        }
    }

    /* loaded from: classes3.dex */
    public class r implements sa8.b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        @Override // com.baidu.tieba.sa8.b0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.sa8.b0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public r(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // com.baidu.tieba.sa8.b0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.d.getListView() != null && this.a.d.getListView().getChildCount() > 0 && this.a.d.getListView().getChildAt(0) == this.a.R()) {
                                this.a.d.getListView().setSelectionFromTop(0, this.a.Q + ((int) (motionEvent.getY() - this.a.x)));
                            }
                        }
                    }
                    this.a.x = 0.0f;
                    this.a.Q = 0;
                } else {
                    this.a.x = motionEvent.getY();
                    if (this.a.d.getListView() != null && this.a.d.getListView().getChildCount() > 0 && this.a.d.getListView().getChildAt(0) == this.a.R()) {
                        b38 b38Var = this.a;
                        b38Var.Q = b38Var.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        public s(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.L = true;
            this.a.A.setVisibility(8);
            this.a.v0();
            TiebaStatic.log("c12618");
        }
    }

    /* loaded from: classes3.dex */
    public class t implements sa8.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ b38 b;

        public t(b38 b38Var, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b38Var;
            this.a = animation;
        }

        @Override // com.baidu.tieba.sa8.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.b.a0() && this.b.b != null) {
                this.a.setAnimationListener(null);
                this.b.b.p().clearAnimation();
                this.b.t0();
                if (z) {
                    this.a.setAnimationListener(this.b.R);
                    this.b.b.p().startAnimation(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.sa8.u
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.a0()) {
                this.b.S();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b38 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public u(b38 b38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b38Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.S();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947594146, "Lcom/baidu/tieba/b38;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947594146, "Lcom/baidu/tieba/b38;");
                return;
            }
        }
        T = new h();
        U = new i();
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.w;
        }
        return (View) invokeV.objValue;
    }

    public void S() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (z18Var = this.b) != null) {
            z18Var.r();
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.v >= 1.0d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (P().getY() >= 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (sa8Var = this.h) != null && this.n) {
            sa8Var.e1();
        }
    }

    public void m0() {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (sa8Var = this.h) != null) {
            sa8Var.c1();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.t = true;
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.b != null) {
            this.b.E(this.d.u0());
        }
    }

    public b38(PbFragment pbFragment, z18 z18Var, VideoInfo videoInfo, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, z18Var, videoInfo, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = null;
        this.g = null;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = 0;
        this.r = 0.0f;
        this.s = false;
        this.t = false;
        this.C = -1L;
        this.D = new k(this);
        this.F = true;
        this.I = new n(this);
        this.M = false;
        this.O = new o(this);
        this.P = new p(this, 2000994);
        this.R = new u(this);
        this.S = new m(this, 2921414);
        this.d = pbFragment;
        this.b = z18Var;
        this.r = fj.f(pbFragment.getActivity(), R.dimen.obfuscated_res_0x7f070283);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.P);
        this.S.setTag(pbFragment.getUniqueId());
        this.S.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.S);
        this.z = new ie0(pbFragment.getActivity());
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (pbFragment = this.d) != null) {
            pbFragment.m5();
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            z18 z18Var = this.b;
            if (z18Var != null) {
                z18Var.w(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.H;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.e(i2);
            }
            z28 z28Var = this.j;
            if (z28Var != null) {
                z28Var.j(i2);
            }
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            sa8 sa8Var = this.h;
            if (sa8Var == null) {
                return false;
            }
            return sa8Var.b1(i2);
        }
        return invokeI.booleanValue;
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            n0(i2);
            Y();
        }
    }

    public void o0(sa8.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, uVar) == null) {
            this.E = uVar;
        }
    }

    public void p0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) {
            this.m = threadData;
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        z28 z28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) && (z28Var = this.j) != null) {
            z28Var.o(onClickListener);
        }
    }

    public void w0(String str) {
        kb8 kb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, str) == null) && (kb8Var = this.i) != null) {
            kb8Var.d = str;
        }
    }

    public void i0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048598, this, absListView, i2) != null) || W()) {
            return;
        }
        this.p = i2;
        if (i2 == 0) {
            new Handler().postDelayed(new j(this), 100L);
        }
        Y();
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i2) != null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        if ((layoutParams.width != -1 || layoutParams.height != -1) && i2 != 0) {
            if (i2 > 0) {
                this.N = false;
                if (this.u != P().getHeight()) {
                    this.c.setLayoutParams(new RelativeLayout.LayoutParams(fj.k(this.d.getActivity()), Math.min(this.u, P().getHeight() + i2)));
                    this.h.q0();
                }
            } else if (fj.k(this.d.getActivity()) * 0.5625d != P().getHeight()) {
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(fj.k(this.d.getActivity()), (int) Math.max(fj.k(this.d.getActivity()) * 0.5625d, P().getHeight() + i2)));
                this.h.q0();
            }
        }
    }

    public final int b0(VideoInfo videoInfo) {
        InterceptResult invokeL;
        int height;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, videoInfo)) == null) {
            if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return fj.k(this.d.getActivity());
            }
            int k2 = fj.k(this.d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.d.getPageContext().getPageActivity());
            if (visibilityRegion.height() <= 0) {
                height = fj.i(this.d.getActivity());
            } else {
                height = visibilityRegion.height();
            }
            int i3 = (int) (k2 * 0.5625d);
            int i4 = 0;
            if (videoInfo != null) {
                i2 = videoInfo.video_width.intValue();
            } else {
                i2 = 0;
            }
            if (videoInfo != null) {
                i4 = videoInfo.video_height.intValue();
            }
            if (i2 > 0) {
                double d2 = (i4 * 1.0d) / i2;
                this.v = d2;
                if (d2 > 0.5625d) {
                    i3 = Math.min((i4 * k2) / i2, height);
                }
            }
            this.u = i3;
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sa8 sa8Var = this.h;
            if (sa8Var != null) {
                sa8Var.v0();
            }
            CustomFrameLayout customFrameLayout = this.c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            z28 z28Var = this.j;
            if (z28Var != null) {
                z28Var.k();
            }
            MessageManager.getInstance().unRegisterListener(this.P);
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.d.getActivity(), R.anim.obfuscated_res_0x7f010035);
            if (this.e == null) {
                this.e = new t(this, loadAnimation);
            }
            o0(this.e);
            UtilHelper.getLightStatusBarHeight();
            fj.f(this.d.getActivity(), R.dimen.obfuscated_res_0x7f070282);
            this.G = new Handler();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (P() == null) {
                return false;
            }
            if (P().getBottom() <= fj.i(P().getContext()) - fj.f(P().getContext(), R.dimen.obfuscated_res_0x7f0702d2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U(VideoInfo videoInfo, ThreadData threadData, String str) {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, threadData, str) == null) && videoInfo != null && (sa8Var = this.h) != null && threadData != null) {
            this.g = videoInfo;
            this.l = threadData;
            this.f = videoInfo.video_url;
            sa8Var.T1();
            kb8 kb8Var = new kb8();
            this.i = kb8Var;
            kb8Var.a = "pb";
            kb8Var.c = threadData.getTid();
            kb8 kb8Var2 = this.i;
            kb8Var2.d = str;
            kb8Var2.e = TbadkCoreApplication.getCurrentAccount();
            if (threadData.isBjh()) {
                if (!StringUtils.isNull(this.d.r1)) {
                    this.i.k = this.d.r1;
                }
                kb8 kb8Var3 = this.i;
                kb8Var3.i = this.d.q1 + "";
            } else {
                this.i.i = this.d.U5();
            }
            mt4 Q5 = this.d.Q5();
            if (Q5 != null) {
                Q5.d(this.i);
            }
            kb8 kb8Var4 = this.i;
            kb8Var4.m = videoInfo.video_md5;
            kb8 b2 = kb8Var4.b();
            b2.a = "6";
            this.C = -1L;
            if (this.h.H0() != null && this.h.H0().getMediaProgressObserver() != null) {
                this.h.H0().getMediaProgressObserver().j(new a(this, videoInfo, str, threadData));
            }
            this.h.H0().setVideoStatData(b2);
            if (this.h.G0()) {
                this.h.q0();
            }
            this.h.o1(this.E);
            this.m = null;
            this.h.J0().setOnDragingListener(T);
            this.h.n1(new b(this));
            this.h.q1(new c(this));
            this.h.s1(new d(this));
            this.h.w1(new e(this));
            this.h.D1(videoInfo.thumbnail_url);
            this.h.H1(this.f, threadData.getTid());
            this.h.h1(str);
            this.h.G1(threadData.getTitle());
            this.h.r1(U);
            this.h.X0();
            this.h.J1();
        }
    }

    public final void V(VideoInfo videoInfo) {
        boolean z;
        NavigationBar navigationBar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08dd, (ViewGroup) null);
            this.a = relativeLayout;
            this.c = (CustomFrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091882);
            int b0 = b0(videoInfo);
            int i2 = 0;
            if (this.u <= (fj.k(this.d.getActivity()) * 0.5625d) + 5.0d) {
                z = true;
            } else {
                z = false;
            }
            this.y = z;
            int intValue = videoInfo.video_width.intValue();
            sa8 sa8Var = new sa8(this.d.getPageContext(), this.c, true);
            this.h = sa8Var;
            sa8Var.z1("2002");
            this.h.I1(this.O);
            this.h.k1(false);
            this.h.E1(this.D);
            this.h.F1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            this.h.y1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.d.getBaseFragmentActivity())) {
                this.h.i1(false);
            }
            this.h.t1(new r(this));
            if (intValue > 0) {
                if (this.v >= 1.0d) {
                    this.h.x1(false, true);
                } else {
                    this.h.x1(true, false);
                }
                if (b0 + this.r > fj.i(this.d.getActivity())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.s = z2;
                if (z2) {
                    if (this.j == null) {
                        this.j = new z28(this.d.getPageContext(), this.c);
                    }
                    this.d.O5().p1();
                    this.k = true;
                }
            }
            u0();
            this.w = new View(this.d.getContext());
            this.w.setLayoutParams(new AbsListView.LayoutParams(-1, this.u));
            z18 z18Var = this.b;
            if (z18Var != null && (navigationBar = z18Var.a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.b.a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.b.a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0912a5);
            this.A = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            ie0 ie0Var = this.z;
            if (ie0Var != null) {
                ie0Var.d();
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.j == null) {
            return;
        }
        if (W()) {
            this.d.O5().p1();
        } else if (this.j.f().getVisibility() == 0) {
            this.d.O5().p1();
            this.k = true;
        } else if (this.k) {
            this.d.O5().F3(false);
            this.k = false;
        }
    }

    public void f0() {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (sa8Var = this.h) == null) {
            return;
        }
        if (sa8Var.R0()) {
            this.n = true;
            this.h.T1();
        } else if (this.h.C0() == 3) {
            this.n = false;
        } else if (this.h.C0() != 0 && this.h.C0() != 1) {
            this.n = false;
            this.h.T1();
        } else {
            this.n = true;
            this.h.T1();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.H;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.g();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && !ux4.k().h("show_video_pb_double_tap_tips", false)) {
            ux4.k().u("show_video_pb_double_tap_tips", true);
            xf xfVar = new xf();
            xfVar.d(true);
            xfVar.i(false);
            xfVar.l(16908290);
            xfVar.c(153);
            xfVar.j(false);
            xfVar.a(new f(this));
            xfVar.h(new g(this));
            wf b2 = xfVar.b();
            this.J = b2;
            b2.p(this.d.getActivity());
        }
    }

    public void d0(Configuration configuration) {
        CustomFrameLayout customFrameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) {
            this.o = false;
            if (this.h != null && (customFrameLayout = this.c) != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                if (configuration.orientation == 2) {
                    ie0 ie0Var = this.z;
                    if (ie0Var != null && ie0Var.c()) {
                        this.z.b();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                    wf wfVar = this.J;
                    if (wfVar != null) {
                        wfVar.d();
                    }
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.o = true;
                    this.c.setLayoutParams(layoutParams);
                    this.d.O5().p1();
                    this.k = true;
                } else {
                    b0(this.g);
                    t0();
                    this.o = false;
                    this.b.C(true);
                }
                this.h.S0(this.d.getPageContext(), configuration);
            }
        }
    }

    public void h0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, absListView, i2) == null) {
            if (absListView != null && absListView.getChildAt(0) != null) {
                View childAt = absListView.getChildAt(0);
                if (childAt == R()) {
                    int bottom = childAt.getBottom() - P().getBottom();
                    M((childAt.getHeight() == 0 || P().getHeight() == 0) ? 0 : 0);
                } else {
                    M((-this.u) + 2);
                }
            }
            if (W() || !this.F) {
                return;
            }
            int i3 = this.p;
            if (i3 == 1) {
                this.M = true;
                j0(P().getHeight());
            } else if (i3 == 2) {
                this.M = true;
                int y = (int) P().getY();
                if (this.q == y) {
                    j0(P().getHeight());
                } else {
                    this.q = y;
                    j0(P().getHeight());
                }
                if (i2 == 0 && this.t) {
                    this.t = false;
                    this.G.postDelayed(new l(this), 100L);
                }
            } else if (i3 == 0) {
                if (this.M || !"nani_midpage".equals(this.d.U5())) {
                    j0(P().getHeight());
                }
            }
        }
    }

    public void k0(PostData postData, ThreadData threadData, iw7 iw7Var) {
        z28 z28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048600, this, postData, threadData, iw7Var) == null) && (z28Var = this.j) != null) {
            z28Var.m(postData, threadData, iw7Var);
        }
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && this.g != null) {
            if ("1".equals(str) || "2".equals(str)) {
                za8.e(this.g.video_md5, "", str, this.i, this.h.H0().getPcdnState());
            }
        }
    }

    public final void n0(int i2) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048603, this, i2) != null) || this.j == null) {
            return;
        }
        ThreadData threadData = this.l;
        if (threadData != null && threadData.isUgcThreadType()) {
            this.j.f().setVisibility(8);
            return;
        }
        if (i2 == 0) {
            i2 = this.u;
        }
        float f3 = this.u - i2;
        float f4 = this.r;
        if (f3 > f4) {
            f2 = 0.0f;
        } else {
            f2 = 1.0f - (f3 / f4);
        }
        if (this.N) {
            f2 = 0.0f;
        }
        if (f2 == 0.0f) {
            this.j.f().setVisibility(8);
        } else {
            this.j.f().setVisibility(0);
        }
        this.j.n(f2);
    }

    public void v0() {
        String tid;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.h != null) {
            if (BdNetTypeUtil.isMobileNet() && !this.L && !rv8.c().d()) {
                this.A.setVisibility(0);
                this.A.setData(this.g);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.f) && (threadData = this.l) != null && threadData.getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.getTid()));
                this.f = this.l.getThreadVideoInfo().video_url;
            }
            sa8 sa8Var = this.h;
            String str = this.f;
            ThreadData threadData2 = this.l;
            if (threadData2 == null) {
                tid = "";
            } else {
                tid = threadData2.getTid();
            }
            sa8Var.M1(str, tid);
            l0("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }
}
