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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.view.AudioAnimationView;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.i0.i2.o;
/* loaded from: classes4.dex */
public class AlaVideoContainer extends LinearLayout {
    public Runnable A;
    public TbCyberVideoView.g B;
    public CyberPlayerManager.OnErrorListener C;
    public Runnable D;
    public Runnable E;

    /* renamed from: e  reason: collision with root package name */
    public View f15262e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.x.d0.a f15263f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f15264g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f15265h;
    public View i;
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
    public TbImageView.f x;
    public View.OnClickListener y;
    public CyberPlayerManager.OnPreparedListener z;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || AlaVideoContainer.this.f15265h == null) {
                return;
            }
            AlaVideoContainer.this.f15265h.setDefaultBgResource(0);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == AlaVideoContainer.this.f15262e.getId()) {
                if (j.z()) {
                    if (AlaVideoContainer.this.t != null) {
                        AlaVideoContainer.this.t.onClick(view);
                        return;
                    }
                    return;
                }
                l.I(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements CyberPlayerManager.OnPreparedListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (AlaVideoContainer.this.f15264g != null) {
                AlaVideoContainer.this.f15264g.setLooping(true);
                AlaVideoContainer.this.f15264g.setVolume(0.0f, 0.0f);
            }
            AlaVideoContainer.this.o.g();
            AlaVideoContainer.this.m.setVisibility(8);
            AlaVideoContainer.this.f15265h.setVisibility(8);
            d.b.b.e.m.e.a().postDelayed(AlaVideoContainer.this.A, 3000L);
            d.b.b.e.m.e.a().removeCallbacks(AlaVideoContainer.this.E);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AlaVideoContainer.this.i != null) {
                AlaVideoContainer.this.i.startAnimation(AlaVideoContainer.this.n);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TbCyberVideoView.g {
        public e() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            AlaVideoContainer.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public f() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            d.b.b.e.m.e.a().post(AlaVideoContainer.this.E);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaVideoContainer.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlaVideoContainer.this.p.setVisibility(0);
            AlaVideoContainer.this.m.setVisibility(8);
            d.b.b.e.m.e.a().postDelayed(AlaVideoContainer.this.D, 2000L);
        }
    }

    public AlaVideoContainer(Context context) {
        super(context);
        this.w = 3;
        this.x = new a();
        this.y = new b();
        this.z = new c();
        this.A = new d();
        this.B = new e();
        this.C = new f();
        this.D = new g();
        this.E = new h();
        n();
    }

    public d.b.i0.x.d0.a getController() {
        return this.f15263f;
    }

    public TbCyberVideoView getVideoView() {
        return this.f15264g;
    }

    public View getView() {
        return this.f15262e;
    }

    public void m() {
        TBLottieAnimationView tBLottieAnimationView = this.k;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public void n() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.video_container);
        this.f15262e = findViewById;
        findViewById.setOnClickListener(this.y);
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.f15264g = tbCyberVideoView;
        tbCyberVideoView.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.f15264g.getLayoutParams();
        layoutParams.height = (this.f15264g.getWidth() * 9) / 16;
        this.f15264g.setLayoutParams(layoutParams);
        this.f15264g.setOnPreparedListener(this.z);
        this.f15264g.setOnSurfaceDestroyedListener(this.B);
        this.f15264g.setOnErrorListener(this.C);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.f15265h = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f15265h.setPlaceHolder(3);
        this.f15265h.setEvent(this.x);
        this.f15265h.setGifIconSupport(false);
        this.f15265h.setConrers(15);
        this.f15265h.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f15265h.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.f15265h.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f15265h.setBorderSurroundContent(true);
        this.f15265h.setDrawBorder(true);
        this.i = inflate.findViewById(R.id.layout_title);
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
        this.f15263f = new d.b.i0.x.d0.a(this);
        this.l = (TextView) inflate.findViewById(R.id.play_count);
        o(TbadkCoreApplication.getInst().getSkinType());
    }

    public void o(int i) {
        if (i != this.w) {
            this.w = i;
            TextView textView = this.j;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            }
            SkinManager.setLottieAnimation(this.k, R.raw.ala_play);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.p, R.color.black_alpha80);
            SkinManager.setBackgroundColor(this.f15264g, R.color.black_alpha100);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.r, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }

    public void p() {
        this.f15265h.setVisibility(0);
        this.k.setVisibility(0);
        this.m.setVisibility(8);
        View view = this.i;
        if (view != null) {
            view.clearAnimation();
        }
        this.o.f();
        this.p.setVisibility(8);
        this.r.setVisibility(8);
        d.b.b.e.m.e.a().removeCallbacks(this.A);
        d.b.b.e.m.e.a().removeCallbacks(this.D);
        d.b.b.e.m.e.a().removeCallbacks(this.E);
    }

    public void q() {
        TBLottieAnimationView tBLottieAnimationView = this.k;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.u.setVisibility(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.v.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLivingLogText(int i) {
        this.v.setText(i);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void setPlayCount(String str) {
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setVideoStatsData(o oVar) {
        this.f15264g.setVideoStatData(oVar);
    }

    public void setVideoThumbnail(String str) {
        this.f15265h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.f15265h.W(str, 10, false);
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = 3;
        this.x = new a();
        this.y = new b();
        this.z = new c();
        this.A = new d();
        this.B = new e();
        this.C = new f();
        this.D = new g();
        this.E = new h();
        n();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 3;
        this.x = new a();
        this.y = new b();
        this.z = new c();
        this.A = new d();
        this.B = new e();
        this.C = new f();
        this.D = new g();
        this.E = new h();
        n();
    }
}
