package com.baidu.tieba.card.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.r0.q2.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AlaVideoContainer extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public TbCyberVideoView.h B;
    public CyberPlayerManager.OnErrorListener C;
    public Runnable D;
    public Runnable E;

    /* renamed from: e  reason: collision with root package name */
    public View f48306e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.b0.e0.a f48307f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f48308g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f48309h;

    /* renamed from: i  reason: collision with root package name */
    public View f48310i;
    public TextView j;
    public TBLottieAnimationView k;
    public TextView l;
    public FrameLayout m;
    public Animation n;
    public AudioAnimationView o;
    public View p;
    public TextView q;
    public View r;
    public TextView s;
    public View.OnClickListener t;
    public LinearLayout u;
    public TextView v;
    public int w;
    public TbImageView.g x;
    public View.OnClickListener y;
    public CyberPlayerManager.OnPreparedListener z;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48311a;

        public a(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48311a = alaVideoContainer;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f48311a.f48309h != null) {
                this.f48311a.f48309h.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48312e;

        public b(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48312e = alaVideoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == this.f48312e.f48306e.getId()) {
                if (j.z()) {
                    if (this.f48312e.t != null) {
                        this.f48312e.t.onClick(view);
                        return;
                    }
                    return;
                }
                l.J(this.f48312e.getContext(), this.f48312e.getContext().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48313e;

        public c(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48313e = alaVideoContainer;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48313e.f48308g != null) {
                    this.f48313e.f48308g.setLooping(true);
                    this.f48313e.f48308g.setVolume(0.0f, 0.0f);
                }
                this.f48313e.o.start();
                this.f48313e.m.setVisibility(8);
                this.f48313e.f48309h.setVisibility(8);
                b.a.e.f.m.e.a().postDelayed(this.f48313e.A, 3000L);
                b.a.e.f.m.e.a().removeCallbacks(this.f48313e.E);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48314e;

        public d(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48314e = alaVideoContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48314e.f48310i == null) {
                return;
            }
            this.f48314e.f48310i.startAnimation(this.f48314e.n);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48315e;

        public e(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48315e = alaVideoContainer;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48315e.resetUI();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48316e;

        public f(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48316e = alaVideoContainer;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                b.a.e.f.m.e.a().post(this.f48316e.E);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48317e;

        public g(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48317e = alaVideoContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48317e.resetUI();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaVideoContainer f48318e;

        public h(AlaVideoContainer alaVideoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaVideoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48318e = alaVideoContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48318e.p.setVisibility(0);
                this.f48318e.m.setVisibility(8);
                b.a.e.f.m.e.a().postDelayed(this.f48318e.D, 2000L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVideoContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = 3;
        this.x = new a(this);
        this.y = new b(this);
        this.z = new c(this);
        this.A = new d(this);
        this.B = new e(this);
        this.C = new f(this);
        this.D = new g(this);
        this.E = new h(this);
        init();
    }

    public void cancelPlayAnimation() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tBLottieAnimationView = this.k) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
    }

    public b.a.r0.b0.e0.a getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48307f : (b.a.r0.b0.e0.a) invokeV.objValue;
    }

    public TbCyberVideoView getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48308g : (TbCyberVideoView) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48306e : (View) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
            View findViewById = inflate.findViewById(R.id.video_container);
            this.f48306e = findViewById;
            findViewById.setOnClickListener(this.y);
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
            this.f48308g = tbCyberVideoView;
            tbCyberVideoView.setStageType(null);
            ViewGroup.LayoutParams layoutParams = this.f48308g.getLayoutParams();
            layoutParams.height = (this.f48308g.getWidth() * 9) / 16;
            this.f48308g.setLayoutParams(layoutParams);
            this.f48308g.setOnPreparedListener(this.z);
            this.f48308g.setOnSurfaceDestroyedListener(this.B);
            this.f48308g.setOnErrorListener(this.C);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
            this.f48309h = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f48309h.setPlaceHolder(3);
            this.f48309h.setEvent(this.x);
            this.f48309h.setGifIconSupport(false);
            this.f48309h.setConrers(15);
            this.f48309h.setRadius(l.g(getContext(), R.dimen.tbds10));
            this.f48309h.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.f48309h.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f48309h.setBorderSurroundContent(true);
            this.f48309h.setDrawBorder(true);
            this.f48310i = inflate.findViewById(R.id.layout_title);
            this.j = (TextView) inflate.findViewById(R.id.tv_title);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
            this.k = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.m = (FrameLayout) inflate.findViewById(R.id.layout_loading);
            this.n = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
            AudioAnimationView audioAnimationView = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
            this.o = audioAnimationView;
            audioAnimationView.setCertainColumnCount(4);
            this.o.setColumnColor(R.color.CAM_X0302);
            this.p = inflate.findViewById(R.id.layout_error);
            this.q = (TextView) inflate.findViewById(R.id.video_error_tips);
            this.r = inflate.findViewById(R.id.layout_live_end);
            this.s = (TextView) inflate.findViewById(R.id.video_live_end_tips);
            this.u = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
            this.v = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
            this.f48307f = new b.a.r0.b0.e0.a(this);
            this.l = (TextView) inflate.findViewById(R.id.play_count);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            startPlayAnimation();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == this.w) {
            return;
        }
        this.w = i2;
        TextView textView = this.j;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        }
        SkinManager.setLottieAnimation(this.k, R.raw.ala_play);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.p, R.color.black_alpha80);
        SkinManager.setBackgroundColor(this.f48308g, R.color.black_alpha100);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.r, R.color.black_alpha80);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            cancelPlayAnimation();
        }
    }

    public void resetLiveEndUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48309h.setVisibility(0);
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            View view = this.f48310i;
            if (view != null) {
                view.clearAnimation();
            }
            this.o.resetStartState();
            this.p.setVisibility(8);
            this.r.setVisibility(0);
            b.a.e.f.m.e.a().removeCallbacks(this.A);
            b.a.e.f.m.e.a().removeCallbacks(this.D);
            b.a.e.f.m.e.a().removeCallbacks(this.E);
        }
    }

    public void resetUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f48309h.setVisibility(0);
            this.k.setVisibility(0);
            this.m.setVisibility(8);
            View view = this.f48310i;
            if (view != null) {
                view.clearAnimation();
            }
            this.o.resetStartState();
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            b.a.e.f.m.e.a().removeCallbacks(this.A);
            b.a.e.f.m.e.a().removeCallbacks(this.D);
            b.a.e.f.m.e.a().removeCallbacks(this.E);
        }
    }

    public void setLigvingLogLayoutVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.u.setVisibility(i2);
        }
    }

    public void setLivingLogLeftDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.v.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        }
    }

    public void setLivingLogText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.v.setText(i2);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setPlayCount(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (textView = this.l) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setVideoStatsData(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pVar) == null) {
            this.f48308g.setVideoStatData(pVar);
        }
    }

    public void setVideoThumbnail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f48309h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f48309h.startLoad(str, 10, false);
        }
    }

    public void showLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f48309h.setVisibility(0);
            this.k.setVisibility(8);
            this.m.setVisibility(0);
            b.a.e.f.m.e.a().postDelayed(this.E, 60000L);
        }
    }

    public void startPlayAnimation() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (tBLottieAnimationView = this.k) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
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
        this.w = 3;
        this.x = new a(this);
        this.y = new b(this);
        this.z = new c(this);
        this.A = new d(this);
        this.B = new e(this);
        this.C = new f(this);
        this.D = new g(this);
        this.E = new h(this);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i2) {
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
        this.w = 3;
        this.x = new a(this);
        this.y = new b(this);
        this.z = new c(this);
        this.A = new d(this);
        this.B = new e(this);
        this.C = new f(this);
        this.D = new g(this);
        this.E = new h(this);
        init();
    }
}
