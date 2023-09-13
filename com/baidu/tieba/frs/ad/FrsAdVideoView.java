package com.baidu.tieba.frs.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.kz9;
import com.baidu.tieba.oz9;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.pz9;
import com.baidu.tieba.sk7;
import com.baidu.tieba.uz9;
import com.baidu.tieba.x2a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class FrsAdVideoView extends RelativeLayout implements View.OnClickListener, x2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbVideoView b;
    public TbImageView c;
    public LinearLayout d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public FrameLayout i;
    public TBLottieAnimationView j;
    public TBLottieAnimationView k;
    public Context l;
    public WeakReference<Context> m;
    public String n;
    public byte o;
    public long p;
    public int q;
    public sk7.o r;
    public sk7.n s;
    public boolean t;
    public final uz9 u;
    public final Runnable v;

    @Override // com.baidu.tieba.x2a
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x2a
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x2a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public a(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != this.a.j.getAlpha()) {
                    this.a.j.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public b(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.j.playAnimation();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public c(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != this.a.c.getAlpha()) {
                    this.a.c.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ ValueAnimator b;
        public final /* synthetic */ FrsAdVideoView c;

        public d(FrsAdVideoView frsAdVideoView, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView, valueAnimator, valueAnimator2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsAdVideoView;
            this.a = valueAnimator;
            this.b = valueAnimator2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.c.c.setVisibility(8);
                if (this.c.s != null) {
                    this.c.s.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.c.b.setVideoScalingMode(this.c.q);
                this.c.b.start();
                this.c.o = (byte) 0;
                this.a.start();
                this.b.start();
                if (this.c.s != null) {
                    this.c.s.d();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2025988942, "Lcom/baidu/tieba/frs/ad/FrsAdVideoView$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2025988942, "Lcom/baidu/tieba/frs/ad/FrsAdVideoView$e;");
                    return;
                }
            }
            int[] iArr = new int[OnStatusChangedListener.VideoStatus.values().length];
            a = iArr;
            try {
                iArr[OnStatusChangedListener.VideoStatus.VIDEO_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OnStatusChangedListener.VideoStatus.VIDEO_PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OnStatusChangedListener.VideoStatus.VIDEO_PAUSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public f(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.resumeAnimation();
                this.a.j.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.j.cancelAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public g(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                PrintStream printStream = System.out;
                printStream.println("onStatusChange: " + videoStatus);
                int i = e.a[videoStatus.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3 && i != 4) {
                            if (i != 5) {
                                return;
                            }
                            this.a.u(true);
                            return;
                        }
                        this.a.u(false);
                        return;
                    }
                    this.a.p = System.currentTimeMillis();
                    this.a.x();
                    if (this.a.r != null) {
                        this.a.r.V(3);
                        return;
                    }
                    return;
                }
                this.a.b.setVolume(0.0f, 0.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public h(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements uz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        @Override // com.baidu.tieba.uz9
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uz9
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.uz9
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.uz9
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.uz9
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.uz9
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
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
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

        @Override // com.baidu.tieba.uz9
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.uz9
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void setStatistic(pz9 pz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, pz9Var) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.uz9
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }

        public i(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) != null) {
                return invokeIIL.booleanValue;
            }
            this.a.x();
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                if (i != 10012) {
                    return false;
                }
                this.a.t = true;
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public j(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n != null && this.a.b != null && this.a.canPlay()) {
                this.a.startPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public k(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isPlaying()) {
                return;
            }
            this.a.x();
            if (this.a.r != null) {
                this.a.r.V(3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements OnSnapShotFrameListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public l(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener
        public void onSnapShotComplete(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bitmap) != null) || bitmap == null) {
                return;
            }
            this.a.b.pause();
            VideoAudioHelper.muteAudioFocus(this.a.m, false);
            this.a.o = (byte) 2;
            this.a.c.setImageBitmap(Bitmap.createBitmap(bitmap, 5, 0, bitmap.getWidth() - 10, bitmap.getHeight()));
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public m(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (new BigDecimal(floatValue).compareTo(new BigDecimal(this.a.h.getAlpha())) != 0) {
                    this.a.h.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsAdVideoView a;

        public n(FrsAdVideoView frsAdVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsAdVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsAdVideoView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.i.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsAdVideoView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsAdVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setVideoData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            if (!StringUtils.isNull(str2)) {
                this.c.startLoad(str2, 10, false);
            }
            this.n = str;
            this.b.setOperableVideoContainer(this.u);
            oz9 oz9Var = new oz9();
            oz9Var.e = "ad";
            oz9Var.d = oz9Var.a("ad");
            oz9Var.f = oz9Var.c("1");
            this.b.setVideoModel(oz9Var);
            this.b.setVideoPath(str);
            this.b.setVideoStatusChangeListener(new g(this));
            this.b.setOnSurfaceDestroyedListener(new h(this));
            this.b.setIsVolume0(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAdVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = (byte) -1;
        this.p = 0L;
        this.q = 1;
        this.t = false;
        this.u = new i(this);
        this.v = new j(this);
        p(context);
    }

    @Override // com.baidu.tieba.x2a
    public void autoPlay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 <= 0) {
                startPlay();
                return;
            }
            SafeHandler.getInst().removeCallbacks(this.v);
            SafeHandler.getInst().postDelayed(this.v, TimeUnit.SECONDS.toMillis(i2));
        }
    }

    public void setFrsAdVideoStatisticListener(sk7.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, nVar) == null) {
            this.s = nVar;
        }
    }

    public void setStateListener(sk7.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, oVar) == null) {
            this.r = oVar;
        }
    }

    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.q = i2;
            this.b.setVideoScalingMode(i2);
        }
    }

    public void y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            startPlay();
            SafeHandler.getInst().postDelayed(new k(this), j2);
        }
    }

    @Override // com.baidu.tieba.x2a
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.getCurrentPosition();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.x2a
    public int getPlayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.x2a
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.n;
            if (str != null) {
                return str;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x2a
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getPlayStatus() != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x2a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.b.isPlaying()) {
                this.c.setAlpha(1.0f);
                this.c.setVisibility(0);
                return;
            }
            s();
        }
    }

    @Override // com.baidu.tieba.x2a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            x();
            sk7.o oVar = this.r;
            if (oVar != null) {
                oVar.V(3);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2 == this.d) {
                x();
                sk7.o oVar = this.r;
                if (oVar != null) {
                    oVar.V(3);
                }
            } else if (view2 == this.b) {
                sk7.o oVar2 = this.r;
                if (oVar2 != null) {
                    oVar2.onClick(view2);
                }
                sk7.n nVar = this.s;
                if (nVar != null) {
                    nVar.a();
                }
            } else if (view2 == this.c) {
                sk7.o oVar3 = this.r;
                if (oVar3 != null) {
                    oVar3.onClick(view2);
                }
                sk7.n nVar2 = this.s;
                if (nVar2 != null) {
                    nVar2.c();
                }
            }
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.l = context;
            this.m = new WeakReference<>(context.getApplicationContext());
            View inflate = LayoutInflater.from(this.l).inflate(R.layout.obfuscated_res_0x7f0d034c, (ViewGroup) this, true);
            this.a = inflate;
            this.b = (TbVideoView) inflate.findViewById(R.id.obfuscated_res_0x7f090c61);
            this.c = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c59);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c58);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c5b);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5c);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5a);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5d);
            this.j = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5f);
            this.i = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c5e);
            this.k = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f090c60);
            this.c.setPlaceHolder(3);
            this.k.setAnimation(R.raw.lotti_video_loading);
            this.k.setMinFrame(0);
            this.k.setFrame(0);
            this.j.setRepeatMode(1);
            this.j.setRepeatCount(-1);
            this.j.addOnAttachStateChangeListener(new f(this));
            this.b.setOnClickListener(this);
            this.b.setLooping(false);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.b.setStageType("23");
            this.b.setNoBussinessStats();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0101, null);
            EMManager.from(this.f).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.d).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0604);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0619);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.i).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0606);
            EMManager.from(this.i).setBorderColor(R.color.CAM_X0614).setBorderWidth(R.dimen.L_X02);
            SkinManager.setLottieAnimation(this.j, R.raw.obfuscated_res_0x7f110011);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.setStartDelay(1000L);
            ofFloat.addUpdateListener(new m(this));
            ofFloat.addListener(new n(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(200L);
            ofFloat2.setStartDelay(2000L);
            ofFloat2.addUpdateListener(new a(this));
            ofFloat2.addListener(new b(this));
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat3.setDuration(360L);
            ofFloat3.setStartDelay(240L);
            ofFloat3.addUpdateListener(new c(this));
            ofFloat3.addListener(new d(this, ofFloat, ofFloat2));
            ofFloat3.start();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b.stopPlayback();
            if (!this.t) {
                this.c.setAlpha(1.0f);
                this.c.setVisibility(0);
            }
            this.o = (byte) -1;
            VideoAudioHelper.muteAudioFocus(this.m, false);
            this.b.getLayoutParams().width = this.a.getWidth() + 10;
            TbVideoView tbVideoView = this.b;
            tbVideoView.setX(tbVideoView.getX() - 5.0f);
            this.j.cancelAnimation();
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            this.d.setVisibility(8);
            this.g.setVisibility(8);
            u(false);
        }
    }

    public final void s() {
        TbVideoView tbVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (tbVideoView = this.b) != null && (tbVideoView.getPlayer() instanceof kz9)) {
            this.c.setAlpha(1.0f);
            this.c.setVisibility(0);
            ((kz9) this.b.getPlayer()).g(new l(this), 1.0f);
        }
    }

    @Override // com.baidu.tieba.x2a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.n == null || this.o != -1) {
            return;
        }
        if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.p) < TimeUnit.SECONDS.toSeconds(3L)) {
            return;
        }
        this.d.setVisibility(0);
        this.g.setVisibility(0);
        this.c.setVisibility(0);
        q();
        t();
    }

    public final void u(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (this.k.getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                if (z2) {
                    return;
                }
                this.k.setMinFrame(0);
                this.k.setFrame(0);
                this.k.cancelAnimation();
                this.k.setAlpha(1.0f);
                this.k.setVisibility(0);
                this.k.loop(true);
                this.k.setMinAndMaxFrame(14, 80);
                this.k.playAnimation();
            } else if (!z2) {
            } else {
                this.k.setMinFrame(0);
                this.k.setFrame(0);
                this.k.cancelAnimation();
                this.k.setVisibility(8);
            }
        }
    }
}
