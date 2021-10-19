package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.k;
import c.a.q0.s.q.d2;
import c.a.r0.q2.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double VIDEO_HEIGHT_WIDTH_RATIO = 0.5625d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48756e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f48757f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f48758g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f48759h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48760i;

    /* renamed from: j  reason: collision with root package name */
    public View f48761j;
    public m k;
    public d2 l;
    public View m;
    public FrameLayout mFrameVideo;
    public TextView n;
    public int o;
    public int p;
    public String q;
    public View.OnClickListener r;
    public TbImageView.g s;
    public CyberPlayerManager.OnErrorListener t;
    public ViewTreeObserver.OnGlobalLayoutListener u;
    public Runnable v;
    public Runnable w;
    public TbCyberVideoView.h x;

    /* loaded from: classes6.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48762e;

        public a(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48762e = frsBaseVideoView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (frameLayout = this.f48762e.mFrameVideo) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f48762e.u);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (frameLayout = this.f48762e.mFrameVideo) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.f48762e.u);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48763a;

        public b(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48763a = frsBaseVideoView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f48763a.f48757f != null) {
                this.f48763a.f48757f.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48764e;

        public c(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48764e = frsBaseVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f48764e.j(true, 4);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48765e;

        public d(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48765e = frsBaseVideoView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = this.f48765e.mFrameVideo) == null || frameLayout.getLayoutParams() == null || this.f48765e.mFrameVideo.getVisibility() == 8) {
                return;
            }
            this.f48765e.mFrameVideo.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.f48765e.mFrameVideo.getLayoutParams();
            if (this.f48765e.mFrameVideo.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (this.f48765e.mFrameVideo.getWidth() * 0.5625d);
            this.f48765e.mFrameVideo.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48766e;

        public e(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48766e = frsBaseVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48766e.f48759h == null || this.f48766e.f48759h.isPlaying()) {
                return;
            }
            this.f48766e.j(true, 1);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48767e;

        public f(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48767e = frsBaseVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48767e.j(true, 4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f48768e;

        public g(FrsBaseVideoView frsBaseVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsBaseVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48768e = frsBaseVideoView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48768e.stopPlay();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsBaseVideoView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void e(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoInfo) == null) {
            h();
            if (this.f48757f == null || this.mFrameVideo == null || this.f48759h == null) {
                return;
            }
            if (k.c().g() && this.l != null && videoInfo != null) {
                this.mFrameVideo.setVisibility(0);
                this.f48757f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f48757f.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                String str = videoInfo.video_url;
                this.q = str;
                if (StringUtils.isNull(str)) {
                    j(true, 4);
                }
                this.f48756e.setText(StringHelper.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.n.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.mFrameVideo.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.base_video_view, this);
            setOrientation(1);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_video);
            this.mFrameVideo = frameLayout;
            frameLayout.setOnClickListener(this);
            this.mFrameVideo.addOnAttachStateChangeListener(new a(this));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.image_video);
            this.f48757f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f48757f.setEvent(this.s);
            this.f48757f.setGifIconSupport(false);
            this.k = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
            this.f48758g = (ImageView) findViewById(R.id.image_video_play);
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f48759h = tbCyberVideoView;
            tbCyberVideoView.setStageType("2003");
            i();
            this.f48759h.setOnErrorListener(this.t);
            this.f48759h.setOnSurfaceDestroyedListener(this.x);
            this.m = findViewById(R.id.auto_video_black_mask);
            this.f48760i = (TextView) findViewById(R.id.auto_video_error_tips);
            this.f48761j = findViewById(R.id.auto_video_error_background);
            this.f48756e = (TextView) findViewById(R.id.text_video_duration);
            this.n = (TextView) findViewById(R.id.text_video_play_count);
        }
    }

    public final void g(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoInfo) == null) {
            d2 d2Var = this.l;
            if (d2Var != null && d2Var.J() != null) {
                setVisibility(0);
                e(videoInfo);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f48759h;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFrameVideo : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.v);
            c.a.e.e.m.e.a().removeCallbacks(this.w);
        }
    }

    public final void i() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (tbCyberVideoView = this.f48759h) != null && tbCyberVideoView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.mFrameVideo.addView(this.f48759h.getView(), 0);
            this.f48759h.getView().setLayoutParams(layoutParams);
        }
    }

    public final void j(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f48758g == null || this.f48757f == null || this.m == null || this.k == null || this.f48761j == null || this.f48760i == null) {
            return;
        }
        if (z || this.p != i2) {
            this.p = i2;
            c.a.e.e.m.e.a().removeCallbacks(this.w);
            c.a.e.e.m.e.a().removeCallbacks(this.v);
            this.f48758g.setVisibility(0);
            this.f48757f.clearAnimation();
            this.f48757f.setVisibility(0);
            this.m.setVisibility(0);
            this.k.b();
            this.f48761j.setVisibility(8);
            this.f48760i.setVisibility(8);
        }
    }

    public void onBindDataToView(d2 d2Var, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, d2Var, videoInfo) == null) || d2Var == null) {
            return;
        }
        this.l = d2Var;
        g(videoInfo);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.o == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.f48758g, R.drawable.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.f48760i, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f48756e, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f48761j, R.color.common_color_10014);
        if (this.f48760i != null) {
            this.f48760i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        this.o = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || (onClickListener = this.r) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.r = onClickListener;
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h();
            j(true, 1);
            TbCyberVideoView tbCyberVideoView = this.f48759h;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = 3;
        this.p = 1;
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.x = new g(this);
        f();
    }
}
