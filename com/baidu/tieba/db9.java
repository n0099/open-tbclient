package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ia9;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.operableVideoView.OperableVideoErrorView;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.tieba.play.operableVideoView.OperableVideoShareView;
import com.baidu.tieba.play.operableVideoView.PercentSizeView;
import com.baidu.tieba.play.operableVideoView.VideoGestureView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
public class db9 implements ab9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public float A0;
    public TextView B;
    public int B0;
    public TextView C;
    public boolean C0;
    public SwitchImageView D;
    public boolean D0;
    public SwitchImageView E;
    public View.OnClickListener E0;
    public OperableVideoMediaControllerView F;
    public qd0 F0;
    public OperableVideoNetworkStateTipView G;
    public McnAdInfo G0;
    public OperableVideoShareView H;
    public boolean H0;
    public ImageView I;
    public p I0;
    public View J;
    public long J0;
    public VideoGestureView K;
    public ia9.c K0;
    public View L;
    public CustomMessageListener L0;
    public OperableVideoErrorView M;
    public boolean M0;
    public WeakReference<Context> N;
    public SeekBar.OnSeekBarChangeListener N0;
    public View O;
    public GestureDetector.SimpleOnGestureListener O0;
    public TextView P;
    public View.OnTouchListener P0;
    public TextView Q;
    public TbVideoViewSet.b Q0;
    public Context R;
    public final CustomMessageListener R0;
    public View S;
    public ViewGroup T;
    public BdUniqueId U;
    public boolean V;
    public boolean W;
    public String X;
    public String Y;
    public long Z;
    public int a;
    public ma9 a0;
    public int b;
    public boolean b0;
    public int c;
    public va9 c0;
    public int d;
    public ThreadData d0;
    public int e;
    public String e0;
    public int f;
    public boolean f0;
    public int g;
    public boolean g0;
    public int h;
    public String h0;
    public int i;
    public boolean i0;
    public int j;
    public boolean j0;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float r0;
    public Runnable s;
    public float s0;
    public TbVideoViewContainer t;
    public GestureDetector t0;
    public TbImageView u;
    public int u0;
    public View v;
    public int[] v0;
    public TBLottieAnimationView w;
    public int w0;
    public ImageView x;
    public boolean x0;
    public ImageView y;
    public int y0;
    public PercentSizeView z;
    public int z0;

    /* loaded from: classes4.dex */
    public interface p {
        void a(int i, int i2);
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.ab9
    public void onScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onClickListener) == null) {
        }
    }

    public void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        public a(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                db9 db9Var = this.a;
                db9Var.t0(db9Var.f);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) && seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().P(this.a.Q0);
                }
                this.a.V();
                if (this.a.f0) {
                    StatisticItem param = new StatisticItem("c13355").param("tid", this.a.Y).param("fid", this.a.Z);
                    int i2 = 1;
                    if (this.a.W) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    StatisticItem param2 = param.param("obj_type", i);
                    if (!this.a.b0) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param2.param("obj_locate", i2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public b(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.q = 0;
            db9 db9Var = this.a;
            if (db9Var.b0) {
                db9Var.U((Activity) db9Var.R, true);
            }
            return super.onDown(motionEvent);
        }

        public final void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.y0 == i2 && this.a.z0 == i) {
                    return;
                }
                db9 db9Var = this.a;
                if (db9Var.y0 - i2 <= 0 && i2 >= this.a.r0 / 6.0f) {
                    z = false;
                } else {
                    z = true;
                }
                db9Var.x0 = z;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.T.getLayoutParams();
                if (i2 != this.a.y0) {
                    int i3 = this.a.w0 - i2;
                    int i4 = (int) (i3 * this.a.A0);
                    if (i4 < this.a.B0) {
                        i4 = this.a.B0;
                        i3 = (int) (i4 / this.a.A0);
                    }
                    if (i4 != this.a.B0) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        this.a.T.setLayoutParams(layoutParams);
                    }
                    this.a.y0 = i2;
                    db9 db9Var2 = this.a;
                    db9Var2.T.setTranslationY(db9Var2.y0);
                }
                if (i != this.a.y0) {
                    this.a.z0 = i;
                    db9 db9Var3 = this.a;
                    db9Var3.T.setTranslationX(db9Var3.z0 + ((this.a.s0 - layoutParams.width) / 2.0f));
                }
                this.a.L.setAlpha((layoutParams.width - this.a.B0) / (this.a.s0 - this.a.B0));
                if (this.a.H.getVisibility() == 0) {
                    float f = this.a.r0 / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    this.a.H.setAlpha(f2);
                }
            }
        }

        public final void b(float f) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                if (f > 0.0f) {
                    db9 db9Var = this.a;
                    db9Var.u0 -= 1000;
                    z = true;
                } else {
                    this.a.u0 += 1000;
                    z = false;
                }
                int duration = this.a.t.getControl().getDuration();
                if (this.a.u0 < 0) {
                    this.a.u0 = 0;
                } else if (this.a.u0 > duration) {
                    this.a.u0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.a.u0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.a.K;
                if (videoGestureView != null) {
                    videoGestureView.b(z, str);
                }
                db9 db9Var2 = this.a;
                db9Var2.F.setCurrentDuration(db9Var2.u0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    db9 db9Var = this.a;
                    int i = db9Var.p;
                    int i2 = db9Var.d;
                    if (i != i2 && i != db9Var.e && i != db9Var.n) {
                        if (i == db9Var.f) {
                            db9Var.t0(i2);
                        }
                    } else {
                        db9 db9Var2 = this.a;
                        db9Var2.t0(db9Var2.f);
                        this.a.V();
                    }
                } else {
                    db9 db9Var3 = this.a;
                    int i3 = db9Var3.p;
                    int i4 = db9Var3.g;
                    if (i3 == i4) {
                        db9Var3.t0(db9Var3.h);
                    } else if (i3 == (i4 | 1)) {
                        db9Var3.t0(db9Var3.h | 1);
                    } else {
                        int i5 = db9Var3.h;
                        if (i3 == i5) {
                            db9Var3.t0(i4);
                        } else if (i3 == (i5 | 1)) {
                            db9Var3.t0(i4 | 1);
                        } else {
                            db9Var3.t0(db9Var3.b);
                            this.a.startPlay();
                            this.a.o0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().pause();
                    db9 db9Var = this.a;
                    if (db9Var.p == db9Var.f) {
                        db9Var.t0(db9Var.g);
                    } else {
                        db9Var.t0(db9Var.h);
                    }
                    this.a.y0(R.id.video_pause);
                    return true;
                }
                db9 db9Var2 = this.a;
                int i = db9Var2.p;
                int i2 = db9Var2.g;
                if (i != i2 && i != (i2 | 1)) {
                    int i3 = db9Var2.h;
                    if (i != i3 && i != (i3 | 1)) {
                        return true;
                    }
                    db9 db9Var3 = this.a;
                    db9Var3.t0(db9Var3.d);
                    this.a.t.getControl().P(this.a.Q0);
                    this.a.y0(R.id.video_play);
                    return true;
                }
                db9 db9Var4 = this.a;
                db9Var4.t0(db9Var4.f);
                this.a.V();
                this.a.t.getControl().P(this.a.Q0);
                this.a.y0(R.id.video_play);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (!this.a.h0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                Context context = this.a.R;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.a.R).disableSwipeJustOnce();
                } else {
                    Context context2 = this.a.R;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.a.R).disableSwipeJustOnce();
                    }
                }
                db9 db9Var = this.a;
                if (db9Var.W && db9Var.i0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i3 = this.a.q;
                    if (i3 != 0) {
                        if (i3 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.a.t.getControl().isPlaying()) {
                            this.a.t.getControl().pause();
                            db9 db9Var2 = this.a;
                            db9Var2.t0(db9Var2.l);
                        }
                        this.a.q = 4;
                        db9 db9Var3 = this.a;
                        db9Var3.r = db9Var3.p;
                        db9 db9Var4 = this.a;
                        db9Var4.p = db9Var4.k;
                        db9Var4.w0 = db9Var4.T.getMeasuredHeight();
                        db9 db9Var5 = this.a;
                        db9Var5.A0 = db9Var5.s0 / this.a.w0;
                        db9 db9Var6 = this.a;
                        db9Var6.B0 = (int) (db9Var6.S.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    db9 db9Var7 = this.a;
                    int i4 = db9Var7.p;
                    boolean z = true;
                    if (i4 == db9Var7.d || i4 == db9Var7.f || i4 == (i = db9Var7.g) || i4 == (i2 = db9Var7.h) || i4 == db9Var7.k || i4 == (i | 1) || i4 == (i2 | 1)) {
                        int i5 = this.a.q;
                        boolean z2 = false;
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 == 3) {
                                        b(f);
                                    }
                                } else {
                                    db9 db9Var8 = this.a;
                                    VideoGestureView videoGestureView = db9Var8.K;
                                    Context context3 = db9Var8.R;
                                    if (f2 <= 0.0f) {
                                        z = false;
                                    }
                                    videoGestureView.a(context3, z);
                                }
                            } else {
                                db9 db9Var9 = this.a;
                                VideoGestureView videoGestureView2 = db9Var9.K;
                                Context context4 = db9Var9.R;
                                int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                                if (i6 <= 0) {
                                    z = false;
                                }
                                videoGestureView2.c(context4, z);
                                if (i6 > 0) {
                                    this.a.onVolumeUp();
                                }
                            }
                        } else {
                            if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                                this.a.q = 3;
                                db9 db9Var10 = this.a;
                                db9Var10.u0 = db9Var10.t.getControl().getCurrentPosition();
                                b(f);
                            } else if (motionEvent.getX() < this.a.T.getWidth() / 2) {
                                this.a.q = 2;
                                db9 db9Var11 = this.a;
                                VideoGestureView videoGestureView3 = db9Var11.K;
                                Context context5 = db9Var11.R;
                                if (f2 > 0.0f) {
                                    z2 = true;
                                }
                                videoGestureView3.a(context5, z2);
                            } else {
                                this.a.q = 1;
                                db9 db9Var12 = this.a;
                                VideoGestureView videoGestureView4 = db9Var12.K;
                                Context context6 = db9Var12.R;
                                if (f2 > 0.0f) {
                                    z2 = true;
                                }
                                videoGestureView4.c(context6, z2);
                            }
                            db9 db9Var13 = this.a;
                            int i7 = db9Var13.p;
                            int i8 = db9Var13.k;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    db9Var13.k = i8 | 1;
                                } else {
                                    db9Var13.k = i8 & (-2);
                                }
                                db9 db9Var14 = this.a;
                                db9Var14.t0(db9Var14.k);
                            }
                        }
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public c(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    db9 db9Var = this.a;
                    if (db9Var.p == db9Var.k) {
                        if (db9Var.q == 4) {
                            this.a.W();
                            this.a.y0 = 0;
                            this.a.z0 = 0;
                        } else {
                            db9 db9Var2 = this.a;
                            db9Var2.p = -1;
                            if (db9Var2.q != 3) {
                                if (this.a.r != -1) {
                                    db9 db9Var3 = this.a;
                                    db9Var3.t0(db9Var3.r);
                                    this.a.r = -1;
                                } else if (this.a.t.getControl().isPlaying()) {
                                    db9 db9Var4 = this.a;
                                    db9Var4.t0(db9Var4.d);
                                } else {
                                    db9 db9Var5 = this.a;
                                    db9Var5.t0(db9Var5.g);
                                }
                            } else {
                                db9 db9Var6 = this.a;
                                db9Var6.F.setCurrentDuration(db9Var6.u0, true);
                                if (this.a.u0 <= this.a.t.getControl().getDuration()) {
                                    if (!this.a.t.getControl().isPlaying()) {
                                        this.a.t.getControl().P(this.a.Q0);
                                    }
                                    db9 db9Var7 = this.a;
                                    db9Var7.t0(db9Var7.d);
                                }
                            }
                        }
                        db9 db9Var8 = this.a;
                        if (db9Var8.f0) {
                            String str = null;
                            if (db9Var8.q == 1) {
                                str = "c13361";
                            } else if (this.a.q == 2) {
                                str = "c13346";
                            } else if (this.a.q == 3) {
                                str = "c13362";
                            }
                            if (!hi.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.a.Y).param("fid", this.a.Z));
                            }
                        }
                        this.a.q = 0;
                        return true;
                    }
                }
                return this.a.t0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public d(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.j0) {
                    db9 db9Var = this.a;
                    db9Var.t0(db9Var.o);
                    this.a.j0 = false;
                } else {
                    db9 db9Var2 = this.a;
                    db9Var2.t0(db9Var2.b);
                }
                this.a.w0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.t.a();
                this.a.v0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(db9 db9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var, Integer.valueOf(i)};
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
            this.a = db9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            this.a.stopPlay();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public f(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                db9 db9Var = this.a;
                db9Var.t0(db9Var.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ia9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public g(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // com.baidu.tieba.ia9.c
        public void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.J0 <= 0) {
                    this.a.J0 = i2;
                }
                if (this.a.j0()) {
                    db9 db9Var = this.a;
                    if (!db9Var.W && !db9Var.b0 && db9Var.H0) {
                        if (pd0.b().a(this.a.G0.jump_url)) {
                            return;
                        }
                        long j = i2;
                        boolean z2 = true;
                        if (j >= this.a.G0.ad_start_time.longValue() * 1000 && j < this.a.G0.ad_end_time.longValue() * 1000) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.a.J0 < (this.a.G0.ad_start_time.longValue() * 1000) + 1000) {
                            z2 = false;
                        }
                        if (this.a.F0 == null) {
                            db9 db9Var2 = this.a;
                            db9Var2.F0 = new qd0(db9Var2.R);
                        }
                        if (z) {
                            if (!this.a.F0.b()) {
                                od0 od0Var = new od0();
                                od0Var.b = this.a.G0.card_title;
                                od0Var.c = this.a.G0.button_title;
                                od0Var.d = this.a.G0.jump_url;
                                od0Var.a = this.a.G0.pic_url;
                                od0Var.f = String.valueOf(this.a.Z);
                                db9 db9Var3 = this.a;
                                od0Var.e = db9Var3.Y;
                                od0Var.g = db9Var3.e0();
                                if (z2) {
                                    this.a.F0.e(od0Var, (ViewGroup) this.a.S);
                                } else {
                                    this.a.F0.d(od0Var, (ViewGroup) this.a.S);
                                }
                            }
                        } else if (this.a.F0.b()) {
                            this.a.F0.a();
                        }
                    }
                }
                if (this.a.I0 != null) {
                    this.a.I0.a(i, i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public h(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public i(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                TbSingleton.getInstance().setVideoCurrentFrame(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        public j(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                TbSingleton.getInstance().setVideoCurrentFrame(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends jt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ db9 b;

        public k(db9 db9Var, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = db9Var;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tieba.jt5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            TbPageContext<?> currentPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                super.onClick(view2);
                if (StringUtils.isNotNull(this.a.app_power) && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.b.R)) != null) {
                    UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{this.a.app_power});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends jt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ db9 b;

        public l(db9 db9Var, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = db9Var;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tieba.jt5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            TbPageContext<?> currentPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                super.onClick(view2);
                if (StringUtils.isNotNull(this.a.app_privacy) && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.b.R)) != null) {
                    UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{this.a.app_privacy});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public m(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.R();
                if (!this.a.V) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db9 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public n(db9 db9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.T.setScaleX(1.0f);
                this.a.T.setScaleY(1.0f);
                this.a.T.setTranslationX(0.0f);
                this.a.T.setTranslationY(0.0f);
                this.a.H.setScaleX(1.0f);
                this.a.H.setScaleY(1.0f);
                this.a.T.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (!this.a.x0) {
                    this.a.X();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<db9> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(int i, db9 db9Var) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), db9Var};
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
            this.a = new WeakReference<>(db9Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            db9 db9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (db9Var = this.a.get()) == null) {
                return;
            }
            db9Var.m0(customResponsedMessage);
        }
    }

    public db9(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3000;
        this.b = 8211;
        this.c = 19;
        this.d = 0;
        this.e = 4;
        this.f = 232;
        this.g = 8416;
        this.h = 0;
        this.i = 513;
        this.j = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256;
        this.k = 2048;
        this.l = 0;
        this.m = 4099;
        this.n = 0;
        this.o = 1;
        this.p = 8211;
        this.q = 0;
        this.r = -1;
        this.s = new f(this);
        this.N = null;
        this.b0 = false;
        this.f0 = true;
        this.g0 = false;
        this.i0 = true;
        this.j0 = false;
        this.v0 = new int[2];
        this.y0 = 0;
        this.z0 = 0;
        this.C0 = false;
        this.D0 = false;
        this.E0 = null;
        this.H0 = false;
        this.J0 = -1L;
        this.K0 = new g(this);
        this.L0 = new o(2921683, this);
        this.N0 = new a(this);
        this.O0 = new b(this);
        this.P0 = new c(this);
        this.Q0 = new d(this);
        this.R0 = new e(this, 2000994);
        if (context != null && view2 != null) {
            this.R = context;
            this.a0 = new ma9((Activity) context);
            this.S = view2;
            this.r0 = ii.j(this.R);
            this.s0 = ii.l(this.R);
            f0();
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.a0.i(true);
            } else {
                this.a0.i(false);
            }
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.a0.j();
            } else {
                this.a0.k();
            }
        }
    }

    @Override // com.baidu.tieba.ab9
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.t.getControl().v(i2);
        }
    }

    public boolean h0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            return this.b0;
        }
        return invokeL.booleanValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.H0 = z;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.D0 = z;
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            this.E0 = onClickListener;
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.e0 = str;
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.h0 = str;
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setStatistic(va9 va9Var) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, va9Var) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getControl() != null) {
            this.c0 = va9Var;
            this.t.getControl().setVideoStatData(va9Var);
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bdUniqueId) == null) {
            this.U = bdUniqueId;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048611, this, i2, i3, obj)) == null) {
            t0(this.m);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048612, this, i2, i3, obj)) == null) {
            if (i2 == 3 || i2 == 904) {
                x0();
            }
            if (i2 == 701) {
                this.i0 = true;
                w0();
                return false;
            } else if (i2 == 702) {
                x0();
                return false;
            } else {
                return false;
            }
        }
        return invokeIIL.booleanValue;
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.V = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.t.getControl().Q();
            this.F.n();
            t0(this.b);
            MessageManager.getInstance().unRegisterListener(this.R0);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.F.p();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.w.animate().alpha(0.0f).setDuration(200L).setListener(new m(this)).start();
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                return;
            }
            this.t.getControl().setVolume(1.0f, 1.0f);
            this.D.setState(0);
            nj5.b().l(true);
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.D0) {
                return false;
            }
            if (UbsABTestHelper.isVideoTabAutoPlay() && "video_tab".equals(this.e0)) {
                return BdNetTypeUtil.isMobileNet();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.G;
            if (operableVideoNetworkStateTipView == null || !operableVideoNetworkStateTipView.d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && !this.g0) {
            int i2 = this.p;
            if (i2 != this.g && (i2 != this.h || this.t.getControl().isPlaying())) {
                if (this.p == this.i) {
                    A0();
                    t0(this.i);
                    return;
                }
                A0();
                return;
            }
            A0();
            t0(this.g);
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.M0 && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                this.M0 = false;
                jg.a().post(new j(this));
                return;
            }
            this.M0 = false;
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.p;
            if (i2 == this.e || i2 == this.n) {
                t0(this.d);
            }
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            jg.a().removeCallbacks(this.s);
            jg.a().postDelayed(this.s, this.a);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Y(true);
        }
    }

    @Override // com.baidu.tieba.ab9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.t.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ab9
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.T;
        }
        return (View) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.W && this.b0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ab9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ab9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (!this.V && !this.t.getControl().isPlaying()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.G0 != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            jg.a().removeCallbacks(this.s);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.X);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.U);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.ab9
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.b0) {
                W();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            t0(this.i);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.T.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.T.setSystemUiVisibility(4);
            } else {
                this.T.setSystemUiVisibility(5894);
            }
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            t0(this.n);
            this.F.p();
            c0();
        }
    }

    public void z0() {
        va9 va9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (va9Var = this.c0) != null) {
            va9 b2 = va9Var.b();
            b2.a = this.e0;
            ka9.e(b2.m, "", "1", b2, this.t.getControl().getPcdnState());
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.W && !"video_tab".equals(this.e0)) {
                this.f = 104;
                this.g = 8290;
            } else {
                this.f = 232;
                this.g = 8418;
            }
            if (this.b0) {
                this.b |= 1024;
                this.o |= 8192;
                this.d |= 1024;
                this.e |= 1024;
                this.n |= 1024;
                this.f |= 1024;
                this.g |= 1024;
                this.h |= 1024;
                this.i |= 1024;
                this.j |= 1024;
                this.p |= 1024;
                return;
            }
            this.b &= -1025;
            this.o &= -1025;
            this.d &= -1025;
            this.e &= -1025;
            this.n &= -1025;
            this.f &= -1025;
            this.g &= -1025;
            this.h &= -1025;
            this.i &= -1025;
            this.j &= -1025;
            this.p &= -1025;
        }
    }

    public void T() {
        float dimension;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.G.a(this.W, this.b0);
            this.H.e(this.W, this.b0);
            Context context = this.R;
            if (context != null && context.getResources() != null) {
                if (this.W) {
                    dimension = this.R.getResources().getDimension(R.dimen.tbds44);
                } else if (this.b0) {
                    dimension = this.R.getResources().getDimension(R.dimen.tbds78);
                } else {
                    dimension = this.R.getResources().getDimension(R.dimen.tbds44);
                }
                int i3 = (int) dimension;
                if ("video_tab".equals(this.e0)) {
                    i2 = 0;
                } else {
                    i2 = i3;
                }
                this.A.setPadding(0, 0, i2, 0);
                SwitchImageView switchImageView = this.E;
                switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i3, 0);
                this.D.setPadding(i3, 0, 0, 0);
            }
        }
    }

    public void v0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.T.addView(this.t, 0);
            this.t.setLayoutParams(layoutParams);
            this.F.setPlayer(this.t.getControl());
            this.t.getControl().setContinuePlayEnable(true);
            this.t.getControl().setOperableVideoContainer(this);
            this.t.getControl().setOnSurfaceDestroyedListener(this);
            this.t.getControl().setVideoStatData(this.c0);
            this.t.getControl().setThreadDataForStatistic(this.d0);
            this.t.getControl().getMediaProgressObserver().j(this.K0);
        }
    }

    public final void U(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, activity, z) == null) && activity != null && activity.getWindow() != null) {
            if (this.W && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                ViewGroup viewGroup = this.T;
                if (viewGroup == null) {
                    return;
                }
                if (z) {
                    viewGroup.setPadding(0, ii.u((Activity) this.R), 0, 0);
                } else {
                    viewGroup.setPadding(0, 0, 0, 0);
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                u0();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.T.setSystemUiVisibility(0);
            }
        }
    }

    public final void W() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.W) {
                X();
            } else if (this.p == this.k) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new n(this));
                if (!this.x0) {
                    float width = this.S.getWidth() / this.T.getWidth();
                    float height = this.S.getHeight() / this.T.getHeight();
                    this.T.setPivotX(0.0f);
                    this.T.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.T, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.T, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.T;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.v0[0]);
                    ViewGroup viewGroup2 = this.T;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.v0[1]);
                    View view2 = this.L;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view2, Key.ALPHA, view2.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, Key.ALPHA, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.s0 / this.T.getWidth();
                    float height2 = this.w0 / this.T.getHeight();
                    this.T.setPivotX(0.0f);
                    this.T.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.T, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.T, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.T;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.T;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, Key.ALPHA, operableVideoShareView2.getAlpha(), 1.0f);
                    objectAnimator = ofFloat10;
                    objectAnimator2 = null;
                }
                if (objectAnimator2 != null) {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                } else {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                }
                animatorSet.start();
                int i2 = this.r;
                if (i2 != -1) {
                    this.p = i2;
                    this.r = -1;
                    if (i2 != this.l && i2 != this.f && i2 != this.d) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        this.t.getControl().P(this.Q0);
                        t0(this.d);
                    }
                }
            } else {
                X();
            }
        }
    }

    public void Y(boolean z) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.S != null && this.T != null && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getControl() != null) {
            Context context = this.R;
            if (context != null) {
                ii.z(context, this.S);
            }
            int i2 = 1;
            if (this.b0) {
                if (this.L.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.L.getParent()).removeView(this.L);
                }
                if ((this.T.getParent() instanceof ViewGroup) && (this.S instanceof ViewGroup)) {
                    this.b0 = false;
                    this.g0 = true;
                    ((ViewGroup) this.T.getParent()).removeView(this.T);
                    ((ViewGroup) this.S).addView(this.T);
                    this.g0 = false;
                    U((Activity) this.R, this.b0);
                }
                if (!this.W && z) {
                    this.a0.l();
                }
            } else {
                if (this.R != null) {
                    if (!this.W && z) {
                        this.a0.l();
                    }
                    if (this.R instanceof Activity) {
                        this.T.getLocationOnScreen(this.v0);
                        View findViewById = ((Activity) this.R).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.g0 = true;
                                ((ViewGroup) this.S).removeAllViews();
                                if (this.L == null) {
                                    View view2 = new View(this.R);
                                    this.L = view2;
                                    view2.setClickable(true);
                                    this.L.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                    this.L.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.L.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.L.getParent()).removeView(this.L);
                                }
                                this.L.setAlpha(1.0f);
                                ViewGroup viewGroup = (ViewGroup) childAt;
                                viewGroup.addView(this.L);
                                viewGroup.addView(this.T);
                                this.g0 = false;
                                this.b0 = true;
                                U((Activity) this.R, true);
                                qd0 qd0Var = this.F0;
                                if (qd0Var != null && qd0Var.b()) {
                                    this.F0.a();
                                }
                            }
                        }
                    }
                }
                if (this.f0) {
                    StatisticItem param = new StatisticItem("c13360").param("tid", this.Y).param("fid", this.Z);
                    if (!this.W) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param.param("obj_type", i2));
                }
            }
            S();
            T();
            if (this.t.getControl().isPlaying()) {
                t0(this.d);
            } else {
                t0(this.p);
            }
            this.E.n();
            l0(this.b0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        y0(id);
        if (id == R.id.video_mute) {
            Z();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            int i5 = 1;
            int i6 = 2;
            if (id == R.id.video_replay) {
                t0(this.b);
                startPlay();
                if (this.f0) {
                    StatisticItem param = new StatisticItem("c13345").param("tid", this.Y).param("fid", this.Z);
                    if (this.W) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    StatisticItem param2 = param.param("obj_type", i4);
                    if (!this.b0) {
                        i5 = 2;
                    }
                    TiebaStatic.log(param2.param("obj_locate", i5));
                }
                o0();
            } else if (id == R.id.video_play) {
                int i7 = this.p;
                if (i7 != this.b && i7 != this.c && i7 != this.o) {
                    t0(this.f);
                    V();
                    this.t.getControl().P(this.Q0);
                } else {
                    startPlay();
                }
                if (this.f0) {
                    StatisticItem param3 = new StatisticItem("c13344").param("tid", this.Y).param("fid", this.Z);
                    if (this.W) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param4 = param3.param("obj_type", i3);
                    if (this.b0) {
                        i6 = 1;
                    }
                    TiebaStatic.log(param4.param("obj_source", i6).param("obj_locate", 1));
                }
                o0();
            } else if (id == R.id.video_pause) {
                t0(this.g);
                n0();
                this.t.getControl().pause();
                if (this.f0) {
                    StatisticItem param5 = new StatisticItem("c13344").param("tid", this.Y).param("fid", this.Z);
                    if (this.W) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    StatisticItem param6 = param5.param("obj_type", i2);
                    if (!this.b0) {
                        i5 = 2;
                    }
                    TiebaStatic.log(param6.param("obj_source", i5).param("obj_locate", 2));
                }
            } else if (id == R.id.obfuscated_res_0x7f091b82) {
                t0(this.b);
                startPlay();
            } else if (id == R.id.obfuscated_res_0x7f091db3) {
                t0(this.b);
                startPlay();
            }
        } else {
            W();
        }
    }

    @Override // com.baidu.tieba.ab9
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.J0 = -1L;
            qd0 qd0Var = this.F0;
            if (qd0Var != null) {
                qd0Var.c();
            }
            if (StringHelper.equals(this.X, threadData.getThreadVideoInfo().video_url)) {
                return;
            }
            stopPlay();
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.W = z;
            this.X = threadData.getThreadVideoInfo().video_url;
            this.Y = threadData.getTid();
            threadData.getThreadVideoInfo().video_length.intValue();
            threadData.getThreadVideoInfo().video_duration.intValue();
            this.Z = threadData.getFid();
            this.G0 = threadData.getThreadVideoInfo().mcn_ad_card;
            S();
            T();
            t0(this.b);
            int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
            this.F.j(intValue);
            this.F.setPlayer(this.t.getControl());
            this.C.setText(StringHelper.stringForVideoTime(intValue));
            this.A.setText(String.format(this.R.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
            this.G.setVideoLength(threadData.getThreadVideoInfo().video_length.intValue());
            this.G.setVideoDuration(threadData.getThreadVideoInfo().video_duration.intValue());
            this.G.setTid(this.Y);
            this.d0 = threadData;
            this.t.getControl().setThreadDataForStatistic(threadData);
            this.B.setVisibility(8);
            this.u.setPlaceHolder(3);
            this.u.setImageBitmap(null);
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                this.u.N(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            } else if (!hi.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.u.N(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.u.N(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
            this.H.setShareData(threadData);
            s0(threadData);
            p0(threadData);
        }
    }

    public void t0(int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            n0();
            if (this.p == this.k) {
                this.r = i2;
                return;
            }
            this.p = i2;
            TbImageView tbImageView = this.u;
            int i19 = 0;
            if ((i2 & 1) > 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            tbImageView.setVisibility(i3);
            View view2 = this.v;
            if ((i2 & 2) > 0) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view2.setVisibility(i4);
            if ((i2 & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            this.i0 = z;
            this.w.clearAnimation();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (this.i0) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            tBLottieAnimationView.setVisibility(i5);
            if (!this.i0) {
                this.w.cancelAnimation();
            } else {
                this.w.setAlpha(1.0f);
            }
            ImageView imageView = this.x;
            if ((i2 & 8192) > 0) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            imageView.setVisibility(i6);
            ImageView imageView2 = this.y;
            if ((i2 & 8) > 0) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            imageView2.setVisibility(i7);
            TextView textView = this.A;
            int i20 = i2 & 16;
            if (i20 > 0) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            textView.setVisibility(i8);
            TextView textView2 = this.C;
            if (i20 > 0) {
                i9 = 0;
            } else {
                i9 = 8;
            }
            textView2.setVisibility(i9);
            SwitchImageView switchImageView = this.D;
            if ((i2 & 32) > 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            switchImageView.setVisibility(i10);
            SwitchImageView switchImageView2 = this.E;
            if ((i2 & 64) > 0) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            switchImageView2.setVisibility(i11);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            int i21 = i2 & 128;
            if (i21 > 0) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            operableVideoMediaControllerView.setVisibility(i12);
            PercentSizeView percentSizeView = this.z;
            if (i21 > 0) {
                i13 = 0;
            } else {
                i13 = 8;
            }
            percentSizeView.setVisibility(i13);
            if (this.F.getVisibility() == 0) {
                this.F.p();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.G;
            if ((i2 & 256) > 0) {
                i14 = 0;
            } else {
                i14 = 8;
            }
            operableVideoNetworkStateTipView.setVisibility(i14);
            OperableVideoShareView operableVideoShareView = this.H;
            if ((i2 & 512) > 0) {
                i15 = 0;
            } else {
                i15 = 8;
            }
            operableVideoShareView.setVisibility(i15);
            if (this.H.getVisibility() == 0) {
                this.H.setAlpha(1.0f);
            }
            ImageView imageView3 = this.I;
            int i22 = i2 & 1024;
            if (i22 > 0) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView3.setVisibility(i16);
            View view3 = this.J;
            if (i22 > 0) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            view3.setVisibility(i17);
            VideoGestureView videoGestureView = this.K;
            if ((i2 & 2048) > 0) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            videoGestureView.setVisibility(i18);
            OperableVideoErrorView operableVideoErrorView = this.M;
            if ((i2 & 4096) <= 0) {
                i19 = 8;
            }
            operableVideoErrorView.setVisibility(i19);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                ls5.e(this.N, true);
                nj5.b().l(true);
                this.D.setState(0);
            } else {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                ls5.e(this.N, false);
                nj5.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            g0();
            if (this.V) {
                if (this.b0) {
                    Context context = this.R;
                    if (context instanceof Activity) {
                        U((Activity) context, true);
                    }
                }
                if (this.W) {
                    this.t.getControl().setVideoScalingMode(0);
                } else {
                    this.t.getControl().setVideoScalingMode(2);
                }
                this.t.getControl().P(this.Q0);
            }
        }
    }

    @Override // com.baidu.tieba.ab9
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.t.getControl().isPlaying() && !ls5.c() && !nj5.b().j()) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                this.D.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.i0) {
                this.w.setAlpha(1.0f);
                this.w.setVisibility(0);
                this.x.setVisibility(8);
            } else {
                this.w.setVisibility(8);
                this.x.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null && this.i0) {
                tBLottieAnimationView.loop(true);
                this.w.setMinAndMaxFrame(14, 80);
                this.w.playAnimation();
            }
        }
    }

    public void f0() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (context = this.R) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d0(), (ViewGroup) null);
        this.T = viewGroup;
        View view2 = this.S;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(viewGroup);
        }
        this.N = new WeakReference<>(TbadkCoreApplication.getInst());
        this.u = (TbImageView) this.T.findViewById(R.id.video_thumbnail);
        this.v = this.T.findViewById(R.id.black_mask);
        this.w = (TBLottieAnimationView) this.T.findViewById(R.id.video_loading);
        this.x = (ImageView) this.T.findViewById(R.id.video_play);
        this.z = (PercentSizeView) this.T.findViewById(R.id.video_media_controller_mask);
        this.y = (ImageView) this.T.findViewById(R.id.video_pause);
        this.A = (TextView) this.T.findViewById(R.id.video_play_count);
        this.B = (TextView) this.T.findViewById(R.id.video_play_flag);
        this.C = (TextView) this.T.findViewById(R.id.video_duration);
        this.D = (SwitchImageView) this.T.findViewById(R.id.video_mute);
        this.E = (SwitchImageView) this.T.findViewById(R.id.video_full_screen);
        this.F = (OperableVideoMediaControllerView) this.T.findViewById(R.id.video_media_controller);
        this.G = (OperableVideoNetworkStateTipView) this.T.findViewById(R.id.video_network_state_tip);
        this.H = (OperableVideoShareView) this.T.findViewById(R.id.video_share_view);
        this.J = this.T.findViewById(R.id.video_back_btn_mask);
        this.I = (ImageView) this.T.findViewById(R.id.video_full_screen_back);
        this.K = (VideoGestureView) this.T.findViewById(R.id.video_gesture);
        this.M = (OperableVideoErrorView) this.T.findViewById(R.id.video_error_layout);
        this.O = this.T.findViewById(R.id.bottom_area_layout);
        this.P = (TextView) this.T.findViewById(R.id.policy_info);
        this.Q = (TextView) this.T.findViewById(R.id.ad_label);
        this.H.setVideoContainer(this);
        this.w.addAnimatorListener(new h(this));
        this.w.setAnimation(R.raw.lotti_video_loading);
        this.x.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.x.setOnClickListener(this);
        this.D.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.D.setState(1);
        this.D.setOnClickListener(this);
        this.u.s();
        this.u.setDrawCorner(false);
        this.u.setPlaceHolder(3);
        HomeGroupUbsUIHelper.handleImgMask(this.v);
        this.F.setOnSeekBarChangeListener(this.N0);
        this.z.setHeightPercent(0.583f);
        this.z.setBackgroundResource(R.drawable.video_mask_bg);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.E.setState(0);
        this.E.setOnClickListener(this);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.I.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.R);
        this.t = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        v0();
        this.G.setPlayViewOnClickListener(this);
        this.T.setOnClickListener(null);
        this.T.setOnTouchListener(this.P0);
        this.H.setOnTouchListener(this.P0);
        this.M.setOutOnClickListener(this);
        this.t0 = new GestureDetector(this.R, this.O0);
        t0(this.b);
        g35.d(this.v).t(R.array.Mask_X003);
        g35.d(this.A).A(R.array.S_O_X001);
        g35.d(this.C).A(R.array.S_O_X001);
        View view3 = this.O;
        if (view3 != null) {
            g35.d(view3).t(R.array.Mask_X001);
        }
        if (UbsABTestHelper.isFeedVideoImmersionTransition() && (this.R instanceof BaseFragmentActivity)) {
            MessageManager.getInstance().unRegisterListener(2921683);
            ((BaseFragmentActivity) this.R).registerListener(this.L0);
        }
    }

    public final void m0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, customResponsedMessage) == null) && hi.isEquals(this.X, (String) customResponsedMessage.getData()) && UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
            jg.a().post(new i(this));
        }
    }

    @Override // com.baidu.tieba.ab9
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
            if (z) {
                this.C0 = isPlaying();
                this.w.cancelAnimation();
                int i2 = this.p;
                if (i2 == this.d || i2 == this.e || i2 == this.f || i2 == this.b || i2 == this.n || i2 == this.o || i2 == this.c) {
                    stopPlay();
                }
                int i3 = this.p | 1;
                this.p = i3;
                int i4 = i3 & (-8193);
                this.p = i4;
                t0(i4);
            } else {
                int i5 = this.p;
                if (i5 == this.b || i5 == this.c || i5 == this.o || i5 == this.m) {
                    if (this.C0) {
                        startPlay();
                        o0();
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void p0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, threadData) == null) {
            TextView textView = this.Q;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (threadData != null && !ListUtils.isEmpty(threadData.getRichAbstractList())) {
                for (PbContent pbContent : threadData.getRichAbstractList()) {
                    if (pbContent.tiebaplus_info != null) {
                        if (this.Q != null && threadData.getShowAdSubscript()) {
                            this.Q.setVisibility(0);
                            g35.d(this.Q).w(R.color.CAM_X0619);
                            this.Q.setShadowLayer(UtilHelper.getDimenPixelSize(R.dimen.tbds25), 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds2), SkinManager.getColor(R.color.CAM_X0607));
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void s0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, threadData) == null) {
            TextView textView = this.P;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (threadData != null && !ListUtils.isEmpty(threadData.getRichAbstractList())) {
                for (PbContent pbContent : threadData.getRichAbstractList()) {
                    if (pbContent != null) {
                        TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
                        if (pbContent.type.intValue() == 35 && tiebaPlusInfo != null && this.P != null) {
                            StringBuilder sb = new StringBuilder();
                            if (StringUtils.isNotNull(tiebaPlusInfo.title)) {
                                sb.append(tiebaPlusInfo.title);
                                sb.append(" | ");
                            }
                            if (StringUtils.isNotNull(tiebaPlusInfo.app_version)) {
                                sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.app_version), tiebaPlusInfo.app_version));
                                sb.append(" | ");
                            }
                            if (StringUtils.isNotNull(tiebaPlusInfo.app_company)) {
                                sb.append(tiebaPlusInfo.app_company);
                                sb.append(" | ");
                            }
                            if (sb.length() == 0) {
                                return;
                            }
                            int length = sb.length() - 1;
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.app_permission));
                            int length2 = sb.length();
                            sb.append(" | ");
                            int length3 = sb.length() - 1;
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffa));
                            int length4 = sb.length();
                            SpannableString spannableString = new SpannableString(sb);
                            if (length < 0) {
                                length = 0;
                            }
                            spannableString.setSpan(new k(this, tiebaPlusInfo), length, length2, 17);
                            if (length3 < 0) {
                                length3 = 0;
                            }
                            spannableString.setSpan(new l(this, tiebaPlusInfo), length3, length4, 17);
                            this.P.setVisibility(0);
                            g35.d(this.P).w(R.color.CAM_X0619);
                            this.P.setMovementMethod(LinkMovementMethod.getInstance());
                            this.P.setHintTextColor(0);
                            this.P.setText(spannableString);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ab9
    public void startPlay() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048629, this) != null) || StringUtils.isNull(this.X)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.R0);
        if (k0()) {
            t0(this.j);
            return;
        }
        this.V = true;
        if (this.t.getControl().isPlaying()) {
            return;
        }
        TbVideoViewContainer d2 = TbVideoViewSet.c().d(this.X);
        if (d2 == null) {
            this.t.a();
            if (!StringUtils.isNull(this.t.getControl().getOriginUrl()) || UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.R);
                this.t = tbVideoViewContainer;
                tbVideoViewContainer.getControl().setTryUseViewInSet(true);
            }
            v0();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.t.getControl().setVideoPath(this.X, this.Y);
                this.t.getControl().setStageType(this.h0);
                w0();
                if (this.f0) {
                    z0();
                }
            }
        } else {
            TbVideoViewContainer tbVideoViewContainer2 = this.t;
            if (tbVideoViewContainer2 == d2) {
                tbVideoViewContainer2.a();
                v0();
            } else {
                if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsJumpFromVideoMiddleView().booleanValue())) {
                    this.t.a();
                    this.t = new TbVideoViewContainer(this.R);
                    TbVideoViewSet.c().e(this.X);
                    this.j0 = true;
                    TbSingleton.getInstance().setIsJumpFromVideoMiddleView(false);
                } else {
                    this.t.a();
                    d2.a();
                    this.t = d2;
                }
                this.t.getControl().setTryUseViewInSet(true);
                v0();
                if (TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
            }
            this.t.getControl().G();
            onPrepared();
            x0();
            if (this.f0) {
                z0();
            }
        }
        if (this.f0) {
            StatisticItem param = new StatisticItem("c13357").param("tid", this.Y).param("fid", this.Z);
            int i3 = 2;
            if (this.W) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            StatisticItem param2 = param.param("obj_type", i2);
            if (TbSingleton.getInstance().isVideoCardMute()) {
                i3 = 1;
            }
            TiebaStatic.log(param2.param("obj_source", i3).param("obj_locate", 1));
        }
    }

    @Override // com.baidu.tieba.ab9
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.V = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            if ((this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof pa9)) {
                if (this.t.getControl().isPlaying()) {
                    this.t.getControl().Q();
                } else {
                    this.t.getControl().stopPlayback();
                }
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && this.X != null && (this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof pa9)) {
                this.t.getControl().O();
                if (this.u != null && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
                ((pa9) this.t.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
                TbVideoViewSet.c().e(this.X);
                this.j0 = true;
            }
            this.t.a();
            this.F.n();
            if (this.j0) {
                t0(this.o);
                this.j0 = false;
            } else {
                t0(this.b);
            }
            MessageManager.getInstance().unRegisterListener(this.R0);
        }
    }
}
