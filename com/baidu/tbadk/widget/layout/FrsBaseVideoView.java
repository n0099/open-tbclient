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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.j0.r.k;
import d.a.j0.r.q.a2;
import d.a.k0.j2.m;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f13236e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13237f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13238g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f13239h;

    /* renamed from: i  reason: collision with root package name */
    public TbCyberVideoView f13240i;
    public TextView j;
    public View k;
    public m l;
    public a2 m;
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
    public TbCyberVideoView.g y;

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout = FrsBaseVideoView.this.f13236e;
            if (frameLayout != null) {
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.v);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout = FrsBaseVideoView.this.f13236e;
            if (frameLayout != null) {
                frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.v);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || FrsBaseVideoView.this.f13238g == null) {
                return;
            }
            FrsBaseVideoView.this.f13238g.setDefaultBgResource(0);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            FrsBaseVideoView.this.l(true, 4);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout = FrsBaseVideoView.this.f13236e;
            if (frameLayout == null || frameLayout.getLayoutParams() == null || FrsBaseVideoView.this.f13236e.getVisibility() == 8) {
                return;
            }
            FrsBaseVideoView.this.f13236e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.f13236e.getLayoutParams();
            if (FrsBaseVideoView.this.f13236e.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (FrsBaseVideoView.this.f13236e.getWidth() * 0.5625d);
            FrsBaseVideoView.this.f13236e.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrsBaseVideoView.this.f13240i == null || FrsBaseVideoView.this.f13240i.isPlaying()) {
                return;
            }
            FrsBaseVideoView.this.l(true, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrsBaseVideoView.this.l(true, 4);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TbCyberVideoView.g {
        public g() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            FrsBaseVideoView.this.stopPlay();
        }
    }

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public final void e(VideoInfo videoInfo) {
        j();
        if (this.f13238g == null || this.f13236e == null || this.f13240i == null) {
            return;
        }
        if (k.c().g() && this.m != null && videoInfo != null) {
            this.f13236e.setVisibility(0);
            this.f13238g.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f13238g.V(videoInfo.thumbnail_url, 10, false);
            stopPlay();
            String str = videoInfo.video_url;
            this.r = str;
            if (StringUtils.isNull(str)) {
                l(true, 4);
            }
            this.f13237f.setText(StringHelper.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
            this.o.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(videoInfo.play_count.intValue())));
            return;
        }
        this.f13236e.setVisibility(8);
    }

    public final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.base_video_view, this);
        setOrientation(1);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_video);
        this.f13236e = frameLayout;
        frameLayout.setOnClickListener(this);
        this.f13236e.addOnAttachStateChangeListener(new a());
        TbImageView tbImageView = (TbImageView) findViewById(R.id.image_video);
        this.f13238g = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.f13238g.setEvent(this.t);
        this.f13238g.setGifIconSupport(false);
        this.l = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.f13239h = (ImageView) findViewById(R.id.image_video_play);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.f13240i = tbCyberVideoView;
        tbCyberVideoView.setStageType("2003");
        k();
        this.f13240i.setOnErrorListener(this.u);
        this.f13240i.setOnSurfaceDestroyedListener(this.y);
        this.n = findViewById(R.id.auto_video_black_mask);
        this.j = (TextView) findViewById(R.id.auto_video_error_tips);
        this.k = findViewById(R.id.auto_video_error_background);
        this.f13237f = (TextView) findViewById(R.id.text_video_duration);
        this.o = (TextView) findViewById(R.id.text_video_play_count);
    }

    public void g(a2 a2Var, VideoInfo videoInfo) {
        if (a2Var == null) {
            return;
        }
        this.m = a2Var;
        i(videoInfo);
    }

    public int getCurrentPosition() {
        TbCyberVideoView tbCyberVideoView = this.f13240i;
        if (tbCyberVideoView == null) {
            return 0;
        }
        return tbCyberVideoView.getCurrentPosition();
    }

    public String getPlayUrl() {
        return this.r;
    }

    public View getVideoContainer() {
        return this.f13236e;
    }

    public void h(int i2) {
        if (this.p != i2) {
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            SkinManager.setImageResource(this.f13239h, R.drawable.btn_icon_play_video_n);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f13237f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.k, R.color.common_color_10014);
            if (this.j != null) {
                this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.p = i2;
        }
    }

    public final void i(VideoInfo videoInfo) {
        a2 a2Var = this.m;
        if (a2Var != null && a2Var.T() != null) {
            setVisibility(0);
            e(videoInfo);
            h(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        setVisibility(8);
    }

    public final void j() {
        d.a.c.e.m.e.a().removeCallbacks(this.w);
        d.a.c.e.m.e.a().removeCallbacks(this.x);
    }

    public final void k() {
        TbCyberVideoView tbCyberVideoView = this.f13240i;
        if (tbCyberVideoView == null || tbCyberVideoView.getParent() != null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f13236e.addView(this.f13240i.getView(), 0);
        this.f13240i.getView().setLayoutParams(layoutParams);
    }

    public final void l(boolean z, int i2) {
        if (this.f13239h == null || this.f13238g == null || this.n == null || this.l == null || this.k == null || this.j == null) {
            return;
        }
        if (z || this.q != i2) {
            this.q = i2;
            d.a.c.e.m.e.a().removeCallbacks(this.x);
            d.a.c.e.m.e.a().removeCallbacks(this.w);
            this.f13239h.setVisibility(0);
            this.f13238g.clearAnimation();
            this.f13238g.setVisibility(0);
            this.n.setVisibility(0);
            this.l.b();
            this.k.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.s;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void stopPlay() {
        j();
        l(true, 1);
        TbCyberVideoView tbCyberVideoView = this.f13240i;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 3;
        this.q = 1;
        this.t = new b();
        this.u = new c();
        this.v = new d();
        this.w = new e();
        this.x = new f();
        this.y = new g();
        f();
    }
}
