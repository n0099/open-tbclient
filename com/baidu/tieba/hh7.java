package com.baidu.tieba;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.nu4;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class hh7 {
    public static /* synthetic */ Interceptable $ic;
    public static int o0;
    public static CallStateReceiver p0;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public boolean B;
    public boolean C;
    public boolean D;
    public Animation E;
    public Animation F;
    public n G;
    public int H;
    public GestureDetector I;
    public WindowManager J;
    public View K;
    public View L;
    public TextView M;
    public SeekBar N;
    public ImageView O;
    public ImageView P;
    public AudioManager Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public ra8 V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public TbPageContext<?> a;
    public int a0;
    public SwipeBackLayout.c b;
    public boolean b0;
    public nh7 c;
    public WeakReference<Context> c0;
    public View d;
    public boolean d0;
    public View e;
    public fb8 e0;
    public TbVideoViewContainer f;
    public Runnable f0;
    public View g;
    public Runnable g0;
    public VideoListMediaControllerView h;
    public TbVideoViewContainer.a h0;
    public View i;
    public View.OnClickListener i0;
    public View j;
    public boolean j0;
    public FrameLayout k;
    public Animation.AnimationListener k0;
    public FrameLayout.LayoutParams l;
    public Animation.AnimationListener l0;
    public ImageView m;
    public Runnable m0;
    public ImageView n;
    public CustomMessageListener n0;
    public ImageView o;
    public View p;
    public int q;
    public View r;
    public boolean s;
    public ImageView t;
    public String u;
    public TbImageView v;
    public CyberPlayerManager.OnPreparedListener w;
    public lh7 x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public a(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.C = false;
            }
        }

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
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public b(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(hh7 hh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var, Integer.valueOf(i)};
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
            this.a = hh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public d(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                boolean onTouchEvent = this.a.I.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    hh7 hh7Var = this.a;
                    if (hh7Var.s && hh7Var.B) {
                        if (this.a.R == 1 && this.a.U != 0) {
                            hh7 hh7Var2 = this.a;
                            hh7Var2.P(hh7Var2.U == 1 ? 1000.0f : -1000.0f, false);
                            this.a.U = 0;
                            this.a.T = 0;
                        }
                        if (!this.a.f.getControl().isPlaying() && 8 == this.a.t.getVisibility()) {
                            this.a.t.setVisibility(0);
                        }
                    }
                    this.a.o0();
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements fb8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public e(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // com.baidu.tieba.fb8
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fb8
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.B = false;
                this.a.H = 0;
                hh7 hh7Var = this.a;
                if (hh7Var.s) {
                    hh7Var.o0();
                    this.a.r0();
                    this.a.V();
                } else {
                    hh7Var.p0();
                }
                if (this.a.x != null) {
                    this.a.x.a(this.a.u);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.j.setVisibility(0);
                this.a.g.setVisibility(8);
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048587, this) != null) {
                return;
            }
            gh.a().removeCallbacks(this.a.f0);
            gh.a().post(this.a.f0);
            gh.a().removeCallbacks(this.a.g0);
            if (this.a.f == null || this.a.f.getControl() == null || this.a.h == null) {
                return;
            }
            if (!this.a.b0) {
                hh7 hh7Var = this.a;
                if (!hh7Var.s) {
                    hh7Var.f.getControl().setVolume(0.0f, 0.0f);
                    pi5.e(this.a.c0, false);
                    this.a.h.i(this.a.H, this.a.f.getControl().getDuration());
                    if (this.a.H != 0) {
                        this.a.f.getControl().seekTo(this.a.H);
                    }
                    if (this.a.w == null) {
                        this.a.w.onPrepared();
                        return;
                    }
                    return;
                }
            }
            this.a.f.getControl().setVolume(1.0f, 1.0f);
            pi5.e(this.a.c0, true);
            this.a.h.i(this.a.H, this.a.f.getControl().getDuration());
            if (this.a.H != 0) {
            }
            if (this.a.w == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setStatistic(ab8 ab8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, ab8Var) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public f(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f.getControl().getCurrentPositionSync() > 100) {
                    this.a.B = true;
                    this.a.i.setVisibility(8);
                    this.a.j.setVisibility(8);
                    this.a.g.setVisibility(8);
                    this.a.v.setVisibility(8);
                    this.a.S();
                    if (this.a.p != null) {
                        this.a.p.setVisibility(0);
                    }
                    this.a.h.p();
                    return;
                }
                gh.a().postDelayed(this.a.f0, 20L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public g(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.setVisibility(0);
                this.a.g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public h(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B = false;
                gh.a().removeCallbacks(this.a.f0);
                gh.a().removeCallbacks(this.a.g0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public i(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() != this.a.j.getId()) {
                    if (view2.getId() != this.a.t.getId() && view2.getId() != this.a.n.getId()) {
                        if (view2.getId() != this.a.o.getId()) {
                            if (view2.getId() == this.a.y.getId()) {
                                TiebaStatic.log(new StatisticItem("c11713"));
                                this.a.O0();
                                return;
                            } else if (view2.getId() == this.a.d.getId()) {
                                if (this.a.B || this.a.s) {
                                    this.a.V();
                                    return;
                                }
                                return;
                            } else if (view2.getId() == this.a.m.getId()) {
                                hh7 hh7Var = this.a;
                                if (hh7Var.s) {
                                    return;
                                }
                                if (hh7Var.b0) {
                                    this.a.f.getControl().setVolume(0.0f, 0.0f);
                                    this.a.m.setImageResource(R.drawable.obfuscated_res_0x7f080446);
                                    pi5.e(this.a.c0, false);
                                    this.a.b0 = false;
                                    return;
                                }
                                this.a.f.getControl().setVolume(1.0f, 1.0f);
                                this.a.m.setImageResource(R.drawable.obfuscated_res_0x7f080447);
                                pi5.e(this.a.c0, true);
                                this.a.b0 = true;
                                return;
                            } else {
                                return;
                            }
                        }
                        hh7 hh7Var2 = this.a;
                        if (hh7Var2.s) {
                            SwipeBackLayout.c cVar = hh7Var2.b;
                            if (cVar != null) {
                                cVar.b0();
                            }
                            TiebaStatic.log(new StatisticItem("c11714"));
                        } else {
                            SwipeBackLayout.c cVar2 = hh7Var2.b;
                            if (cVar2 != null) {
                                cVar2.H0();
                            }
                            TiebaStatic.log(new StatisticItem("c11710"));
                        }
                        this.a.O0();
                        return;
                    } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        ej.K(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0c59));
                        return;
                    } else if (!this.a.f.getControl().isPlaying()) {
                        if (this.a.B) {
                            this.a.q0();
                            return;
                        } else {
                            this.a.n0();
                            return;
                        }
                    } else {
                        this.a.m0();
                        return;
                    }
                }
                this.a.n0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public j(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.j0 = true;
                hh7 hh7Var = this.a;
                hh7Var.M0(hh7Var.u);
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public l(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.p == null) {
                return;
            }
            this.a.p.setVisibility(8);
            this.a.D = false;
        }

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
    }

    /* loaded from: classes4.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 a;

        public m(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh7Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                hh7 hh7Var = this.a;
                if (hh7Var.s && hh7Var.B) {
                    if (!this.a.f.getControl().isPlaying() && this.a.t.getVisibility() == 0 && this.a.R == 1) {
                        this.a.t.setVisibility(8);
                    }
                    if (this.a.R == 0) {
                        this.a.D0();
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            this.a.R = 1;
                            hh7 hh7Var2 = this.a;
                            hh7Var2.T = hh7Var2.f.getControl().getCurrentPositionSync();
                            this.a.P(f, true);
                        } else {
                            this.a.R = 2;
                            this.a.Q(f2);
                        }
                    } else if (this.a.R == 1) {
                        this.a.P(f, true);
                    } else if (this.a.R == 2) {
                        this.a.Q(f2);
                    }
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ m(hh7 hh7Var, d dVar) {
            this(hh7Var);
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a();

        void b();
    }

    public hh7(TbPageContext<?> tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.s = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.H = 0;
        this.R = 0;
        this.T = 0;
        this.U = 0;
        this.Y = 0;
        this.b0 = false;
        this.c0 = null;
        this.d0 = true;
        this.e0 = new e(this);
        this.f0 = new f(this);
        this.g0 = new g(this);
        this.h0 = new h(this);
        this.i0 = new i(this);
        this.j0 = false;
        this.k0 = new l(this);
        this.l0 = new a(this);
        this.m0 = new b(this);
        this.n0 = new c(this, 2016503);
        this.a = tbPageContext;
        this.c0 = new WeakReference<>(TbadkCoreApplication.getInst());
        View e0 = e0(tbPageContext);
        this.d = e0;
        if (view2 instanceof FrameLayout) {
            ((FrameLayout) view2).addView(e0);
        }
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.d.findViewById(R.id.obfuscated_res_0x7f0924f7);
        this.f = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.g = this.d.findViewById(R.id.obfuscated_res_0x7f09253b);
        VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.d.findViewById(R.id.obfuscated_res_0x7f0914d6);
        this.h = videoListMediaControllerView;
        videoListMediaControllerView.setPlayer(this.f.getControl());
        this.i = this.d.findViewById(R.id.obfuscated_res_0x7f0903a3);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f09128b);
        this.j = findViewById;
        findViewById.setOnClickListener(this.i0);
        this.k = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090769);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090efc);
        this.n = imageView;
        imageView.setOnClickListener(this.i0);
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090f06);
        this.m = imageView2;
        imageView2.setOnClickListener(this.i0);
        ImageView imageView3 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090554);
        this.o = imageView3;
        imageView3.setOnClickListener(this.i0);
        this.p = this.d.findViewById(R.id.obfuscated_res_0x7f09055c);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091c56);
        this.f.getControl().setOperableVideoContainer(this.e0);
        this.f.getControl().setOnSurfaceDestroyedListener(this.h0);
        ImageView imageView4 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090efa);
        this.t = imageView4;
        imageView4.setOnClickListener(this.i0);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f092588);
        this.v = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.W = ej.k(this.a.getPageActivity());
        this.X = b0(this.a.getPageActivity());
        ImageView imageView5 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090ee0);
        this.y = imageView5;
        imageView5.setOnClickListener(this.i0);
        this.z = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09258a);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f0912ad);
        this.A = findViewById2;
        findViewById2.setVisibility(8);
        this.E = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.obfuscated_res_0x7f010035);
        this.F = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.obfuscated_res_0x7f01002b);
        this.J = (WindowManager) this.a.getPageActivity().getSystemService("window");
        this.I = new GestureDetector(this.a.getPageActivity(), new m(this, null));
        AudioManager audioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.Q = audioManager;
        this.S = audioManager.getStreamMaxVolume(3);
        this.a0 = this.Q.getStreamVolume(3);
        o0 = 100 / this.S;
        this.d.setOnTouchListener(new d(this));
        ra8 ra8Var = new ra8(this.a.getPageActivity());
        this.V = ra8Var;
        ra8Var.j();
        this.Y = ej.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
        if (p0 == null) {
            p0 = new CallStateReceiver();
        }
        p0.register(this.a.getPageActivity());
        this.a.registerListener(this.n0);
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.d0 = z;
        }
    }

    public void B0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.H = i2;
        }
    }

    public void C0(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.d.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.d.setSystemUiVisibility(4);
            } else {
                this.d.setSystemUiVisibility(5894);
            }
        }
    }

    public void E0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.v.K(str, 17, false);
        }
    }

    public void F0(nh7 nh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nh7Var) == null) {
            this.c = nh7Var;
        }
    }

    public void G0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            StringHelper.numberUniformFormat(j2);
        }
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    public void I0(int i2) {
        nh7 nh7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (nh7Var = this.c) == null || i2 == nh7Var.l()) {
            return;
        }
        this.c.w();
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.e.setLayoutParams(layoutParams);
            this.o.setClickable(true);
            this.o.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = false;
                layoutParams2.addRule(11, 0);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f090554);
                int dimension = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f);
                this.m.setPadding((int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070279) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f), dimension);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.h.setVisibility(0);
                this.n.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void M0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            ya8 ya8Var = new ya8();
            ya8Var.e = "ad_feed";
            ya8Var.d = ya8Var.a("ad_feed");
            ya8Var.f = ya8Var.c("1");
            this.f.getControl().setVideoModel(ya8Var);
            this.f.getControl().setVideoPath(str);
            this.f.getControl().start();
            this.g.setVisibility(0);
            this.v.setVisibility(0);
            this.t.setVisibility(8);
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b25);
            this.j.setVisibility(8);
            gh.a().removeCallbacks(this.g0);
            gh.a().postDelayed(this.g0, 60000L);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i2 = this.R;
            if (i2 == 1) {
                if (this.K == null) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0292, (ViewGroup) null);
                    this.K = inflate;
                    this.M = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ecc);
                    this.P = (ImageView) this.K.findViewById(R.id.obfuscated_res_0x7f0902be);
                }
                if (this.K.getParent() == null) {
                    this.J.addView(this.K, X());
                }
            } else if (i2 == 2) {
                if (this.L == null) {
                    View inflate2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0293, (ViewGroup) null);
                    this.L = inflate2;
                    this.O = (ImageView) inflate2.findViewById(R.id.obfuscated_res_0x7f0902c4);
                    this.N = (SeekBar) this.L.findViewById(R.id.obfuscated_res_0x7f091ece);
                }
                if (this.L.getParent() == null) {
                    this.J.addView(this.L, X());
                }
            }
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            gh.a().removeCallbacks(this.f0);
            gh.a().removeCallbacks(this.g0);
            this.f.getControl().stopPlayback();
            this.B = false;
            this.H = 0;
            p0();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.r == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        this.l = layoutParams;
        layoutParams.width = this.r.getWidth();
        this.l.height = this.r.getHeight();
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams2 = this.l;
        layoutParams2.topMargin = iArr[1] - this.q;
        this.d.setLayoutParams(layoutParams2);
    }

    public void O0() {
        ra8 ra8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (ra8Var = this.V) == null) {
            return;
        }
        ra8Var.l();
    }

    public final void P(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (f2 > 0.0f) {
                    this.T -= 1000;
                    this.U = 1;
                } else {
                    this.T += 1000;
                    this.U = 2;
                }
                int i2 = this.T;
                if (i2 < 0) {
                    this.T = 0;
                } else if (i2 > this.f.getControl().getDuration()) {
                    this.T = this.f.getControl().getDuration();
                }
            }
            N();
            String g2 = this.h.g(this.T);
            if (f2 > 0.0f) {
                this.P.setImageResource(R.drawable.obfuscated_res_0x7f08078f);
            } else {
                this.P.setImageResource(R.drawable.obfuscated_res_0x7f08078e);
            }
            if (!StringUtils.isNull(g2)) {
                TextView textView = this.M;
                StringBuilder sb = new StringBuilder();
                sb.append(g2);
                sb.append("/");
                sb.append(this.h.g(this.f.getControl().getDuration()));
                textView.setText(sb);
            }
            this.h.setCurrentDuration(this.T, !z);
        }
    }

    public void P0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
        }
    }

    public final void Q(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            if (!this.f.getControl().isPlaying()) {
                this.R = 0;
                return;
            }
            N();
            int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i6 > 0 && (i5 = this.Z) < 100) {
                this.Z = i5 + 1;
            }
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 < 0 && (i4 = this.Z) > 0) {
                this.Z = i4 - 1;
            }
            if (this.Z % o0 == 0) {
                if (i6 > 0 && (i3 = this.a0) < this.S) {
                    this.a0 = i3 + 1;
                }
                if (i7 < 0 && (i2 = this.a0) > 0) {
                    this.a0 = i2 - 1;
                }
            }
            if (this.a0 > 0) {
                this.O.setImageResource(R.drawable.obfuscated_res_0x7f080a8f);
            } else {
                this.O.setImageResource(R.drawable.obfuscated_res_0x7f080a8e);
            }
            this.Q.setStreamVolume(3, this.a0, 0);
            this.N.setProgress(this.Z);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            S();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.p == null) {
            return;
        }
        gh.a().removeCallbacks(this.m0);
        this.F.setAnimationListener(null);
        this.E.setAnimationListener(null);
        this.p.clearAnimation();
        this.D = false;
        this.C = false;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            N0();
            gh.a().removeCallbacks(this.m0);
            gh.a().removeCallbacks(this.f0);
            gh.a().removeCallbacks(this.g0);
            this.V.k();
            p0.unregister(this.a.getPageActivity());
        }
    }

    public void U() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (view2 = this.p) == null || this.C) {
            return;
        }
        if (this.D || view2.getVisibility() != 0) {
            S();
            this.p.setVisibility(0);
            this.F.setAnimationListener(this.l0);
            this.p.startAnimation(this.F);
            this.C = true;
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            U();
            gh.a().removeCallbacks(this.m0);
            if (this.d0) {
                gh.a().postDelayed(this.m0, 3000L);
            }
        }
    }

    public final void W(BaseFragmentActivity baseFragmentActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, baseFragmentActivity, z) == null) || baseFragmentActivity == null || baseFragmentActivity.getWindow() == null) {
            return;
        }
        if (z) {
            WindowManager.LayoutParams attributes = baseFragmentActivity.getWindow().getAttributes();
            attributes.flags |= 1024;
            baseFragmentActivity.getWindow().setAttributes(attributes);
            baseFragmentActivity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = baseFragmentActivity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        baseFragmentActivity.getWindow().setAttributes(attributes2);
        baseFragmentActivity.getWindow().clearFlags(512);
        this.g.getVisibility();
    }

    public final WindowManager.LayoutParams X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public View Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public View a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public int b0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? ej.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? !this.s : invokeV.booleanValue;
    }

    public ma8 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f.getControl() : (ma8) invokeV.objValue;
    }

    public View e0(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, tbPageContext)) == null) ? LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0182, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public VideoListMediaControllerView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.h : (VideoListMediaControllerView) invokeV.objValue;
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i2) == null) && this.f.getControl().getDuration() - i2 <= 3000 && this.s) {
            S();
            View view2 = this.p;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            if (eh7.c(this.a.getPageActivity())) {
                layoutParams.bottomMargin = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070225) + 0.5f);
            } else {
                layoutParams.bottomMargin = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201) + 0.5f);
            }
            this.e.setLayoutParams(layoutParams);
            this.o.setClickable(false);
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = true;
                int dimension = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f);
                this.m.setPadding((int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070279) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07021d) + 0.5f), dimension);
                layoutParams2.addRule(11);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void j0() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (view2 = this.p) == null || this.D || view2.getVisibility() != 0) {
            return;
        }
        S();
        this.p.setVisibility(0);
        this.E.setAnimationListener(this.k0);
        this.p.startAnimation(this.E);
        this.D = true;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.d.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void l0(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, baseFragmentActivity, configuration) == null) {
            if (configuration.orientation == 2) {
                this.s = true;
                this.m.setVisibility(8);
                this.f.getControl().setVolume(1.0f, 1.0f);
                pi5.e(this.c0, true);
                this.d.setLayoutParams(new FrameLayout.LayoutParams(this.X, this.W));
                W(baseFragmentActivity, true);
                this.A.setVisibility(0);
                t0(true);
                this.k.setVisibility(8);
                n nVar = this.G;
                if (nVar != null) {
                    nVar.a();
                }
                V();
                this.o.setImageResource(R.drawable.obfuscated_res_0x7f080aa0);
                u0(this.Y);
                D0();
                return;
            }
            this.s = false;
            this.m.setVisibility(0);
            if (this.b0) {
                this.f.getControl().setVolume(1.0f, 1.0f);
                pi5.e(this.c0, true);
            } else {
                this.f.getControl().setVolume(0.0f, 0.0f);
                pi5.e(this.c0, false);
            }
            FrameLayout.LayoutParams layoutParams = this.l;
            if (layoutParams != null) {
                this.d.setLayoutParams(layoutParams);
            }
            W(baseFragmentActivity, false);
            this.A.setVisibility(8);
            t0(false);
            this.k.setVisibility(0);
            n nVar2 = this.G;
            if (nVar2 != null) {
                nVar2.b();
            }
            if (!this.B && (view2 = this.p) != null) {
                view2.clearAnimation();
                this.p.setVisibility(4);
            }
            o0();
            this.o.setImageResource(R.drawable.obfuscated_res_0x7f08070e);
            u0(0);
            this.d.setSystemUiVisibility(0);
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f.getControl().pause();
            z0();
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (BdNetTypeUtil.isMobileNet() && !this.j0) {
                nu4 nu4Var = new nu4(this.a.getPageActivity());
                nu4Var.setMessage(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eaa));
                nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new j(this));
                nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new k(this));
                nu4Var.create(this.a).show();
                return;
            }
            M0(this.u);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || this.R == 0) {
            return;
        }
        this.R = 0;
        View view2 = this.K;
        if (view2 != null && view2.getParent() != null) {
            try {
                this.J.removeView(this.K);
            } catch (IllegalArgumentException unused) {
            }
        }
        View view3 = this.L;
        if (view3 == null || view3.getParent() == null) {
            return;
        }
        try {
            this.J.removeView(this.L);
        } catch (IllegalArgumentException unused2) {
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.p == null) {
            return;
        }
        this.i.setVisibility(0);
        this.t.setVisibility(0);
        this.g.setVisibility(8);
        this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b24);
        this.p.setVisibility(4);
        this.j.setVisibility(8);
        this.h.n();
        this.v.setVisibility(0);
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f.getControl().start();
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b25);
            this.v.setVisibility(8);
            this.i.setVisibility(8);
            this.g.setVisibility(8);
            this.h.p();
            this.t.setVisibility(8);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.p == null) {
            return;
        }
        this.i.setVisibility(0);
        this.t.setVisibility(0);
        this.g.setVisibility(8);
        this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b24);
        this.p.setVisibility(0);
        this.j.setVisibility(8);
        this.h.n();
        this.v.setVisibility(0);
    }

    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.q = i2;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (z) {
                this.d.setOnClickListener(this.i0);
            } else {
                this.d.setClickable(false);
            }
        }
    }

    public final void u0(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && (videoListMediaControllerView = this.h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.h.setLayoutParams(layoutParams);
        }
    }

    public void v0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, nVar) == null) {
            this.G = nVar;
        }
    }

    public void w0(lh7 lh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, lh7Var) == null) {
            this.x = lh7Var;
        }
    }

    public void x0(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onPreparedListener) == null) {
            this.w = onPreparedListener;
        }
    }

    public void y0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, view2) == null) {
            this.r = view2;
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.n.setImageResource(R.drawable.obfuscated_res_0x7f080b24);
            this.g.setVisibility(8);
            this.t.setVisibility(0);
        }
    }
}
