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
import d.a.o0.r.k;
import d.a.o0.r.q.b2;
import d.a.p0.n2.m;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f13393e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13394f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13395g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f13396h;

    /* renamed from: i  reason: collision with root package name */
    public TbCyberVideoView f13397i;
    public TextView j;
    public View k;
    public m l;
    public b2 m;
    public View n;
    public TextView o;
    public int p;
    public int q;
    public String r;
    public View.OnClickListener s;
    public TbImageView.f t;
    public CyberPlayerManager.OnErrorListener u;
    public ViewTreeObserver.OnGlobalLayoutListener v;
    public Runnable w;
    public Runnable x;
    public TbCyberVideoView.h y;

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13398e;

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
            this.f13398e = frsBaseVideoView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (frameLayout = this.f13398e.f13393e) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f13398e.v);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (frameLayout = this.f13398e.f13393e) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.f13398e.v);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13399a;

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
            this.f13399a = frsBaseVideoView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f13399a.f13395g != null) {
                this.f13399a.f13395g.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13400e;

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
            this.f13400e = frsBaseVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f13400e.l(true, 4);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13401e;

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
            this.f13401e = frsBaseVideoView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = this.f13401e.f13393e) == null || frameLayout.getLayoutParams() == null || this.f13401e.f13393e.getVisibility() == 8) {
                return;
            }
            this.f13401e.f13393e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.f13401e.f13393e.getLayoutParams();
            if (this.f13401e.f13393e.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (this.f13401e.f13393e.getWidth() * 0.5625d);
            this.f13401e.f13393e.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13402e;

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
            this.f13402e = frsBaseVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13402e.f13397i == null || this.f13402e.f13397i.isPlaying()) {
                return;
            }
            this.f13402e.l(true, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13403e;

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
            this.f13403e = frsBaseVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13403e.l(true, 4);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsBaseVideoView f13404e;

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
            this.f13404e = frsBaseVideoView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13404e.stopPlay();
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
            j();
            if (this.f13395g == null || this.f13393e == null || this.f13397i == null) {
                return;
            }
            if (k.c().g() && this.m != null && videoInfo != null) {
                this.f13393e.setVisibility(0);
                this.f13395g.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.f13395g.M(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                String str = videoInfo.video_url;
                this.r = str;
                if (StringUtils.isNull(str)) {
                    l(true, 4);
                }
                this.f13394f.setText(StringHelper.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.o.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.f13393e.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.base_video_view, this);
            setOrientation(1);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_video);
            this.f13393e = frameLayout;
            frameLayout.setOnClickListener(this);
            this.f13393e.addOnAttachStateChangeListener(new a(this));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.image_video);
            this.f13395g = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f13395g.setEvent(this.t);
            this.f13395g.setGifIconSupport(false);
            this.l = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
            this.f13396h = (ImageView) findViewById(R.id.image_video_play);
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f13397i = tbCyberVideoView;
            tbCyberVideoView.setStageType("2003");
            k();
            this.f13397i.setOnErrorListener(this.u);
            this.f13397i.setOnSurfaceDestroyedListener(this.y);
            this.n = findViewById(R.id.auto_video_black_mask);
            this.j = (TextView) findViewById(R.id.auto_video_error_tips);
            this.k = findViewById(R.id.auto_video_error_background);
            this.f13394f = (TextView) findViewById(R.id.text_video_duration);
            this.o = (TextView) findViewById(R.id.text_video_play_count);
        }
    }

    public void g(b2 b2Var, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, b2Var, videoInfo) == null) || b2Var == null) {
            return;
        }
        this.m = b2Var;
        i(videoInfo);
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f13397i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13393e : (View) invokeV.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.p == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.f13396h, R.drawable.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f13394f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.k, R.color.common_color_10014);
        if (this.j != null) {
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        this.p = i2;
    }

    public final void i(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoInfo) == null) {
            b2 b2Var = this.m;
            if (b2Var != null && b2Var.H() != null) {
                setVisibility(0);
                e(videoInfo);
                h(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.w);
            d.a.c.e.m.e.a().removeCallbacks(this.x);
        }
    }

    public final void k() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tbCyberVideoView = this.f13397i) != null && tbCyberVideoView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f13393e.addView(this.f13397i.getView(), 0);
            this.f13397i.getView().setLayoutParams(layoutParams);
        }
    }

    public final void l(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f13396h == null || this.f13395g == null || this.n == null || this.l == null || this.k == null || this.j == null) {
            return;
        }
        if (z || this.q != i2) {
            this.q = i2;
            d.a.c.e.m.e.a().removeCallbacks(this.x);
            d.a.c.e.m.e.a().removeCallbacks(this.w);
            this.f13396h.setVisibility(0);
            this.f13395g.clearAnimation();
            this.f13395g.setVisibility(0);
            this.n.setVisibility(0);
            this.l.b();
            this.k.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || (onClickListener = this.s) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            j();
            l(true, 1);
            TbCyberVideoView tbCyberVideoView = this.f13397i;
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
        this.p = 3;
        this.q = 1;
        this.t = new b(this);
        this.u = new c(this);
        this.v = new d(this);
        this.w = new e(this);
        this.x = new f(this);
        this.y = new g(this);
        f();
    }
}
