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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private String avN;
    private bb awf;
    private Runnable bgA;
    private Runnable bgB;
    private QuickVideoView.b bgC;
    public FrameLayout bgl;
    private TextView bgm;
    private TbImageView bgn;
    private ImageView bgo;
    private QuickVideoView bgp;
    private TextView bgq;
    private View bgr;
    private w bgt;
    private View bgu;
    private TextView bgv;
    private int bgw;
    private TbImageView.a bgx;
    private g.b bgy;
    private ViewTreeObserver.OnGlobalLayoutListener bgz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bgw = 1;
        this.bgx = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && FrsBaseVideoView.this.bgn != null) {
                    FrsBaseVideoView.this.bgn.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bgz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.bgl != null && FrsBaseVideoView.this.bgl.getLayoutParams() != null && FrsBaseVideoView.this.bgl.getVisibility() != 8) {
                    FrsBaseVideoView.this.bgl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.bgl.getLayoutParams();
                    if (FrsBaseVideoView.this.bgl.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.bgl.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.bgl.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bgA = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.bgp != null && !FrsBaseVideoView.this.bgp.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bgB = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.base_video_view, this);
        setOrientation(1);
        this.bgl = (FrameLayout) findViewById(e.g.frame_video);
        this.bgl.setOnClickListener(this);
        this.bgl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.bgl != null) {
                    FrsBaseVideoView.this.bgl.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bgz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.bgl != null) {
                    FrsBaseVideoView.this.bgl.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bgz);
                }
            }
        });
        this.bgn = (TbImageView) findViewById(e.g.image_video);
        this.bgn.setDefaultErrorResource(0);
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setEvent(this.bgx);
        this.bgn.setGifIconSupport(false);
        this.bgt = new w((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bgo = (ImageView) findViewById(e.g.image_video_play);
        this.bgp = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.bgp.setOnErrorListener(this.bgy);
        this.bgp.setOnSurfaceDestroyedListener(this.bgC);
        this.bgu = findViewById(e.g.auto_video_black_mask);
        this.bgq = (TextView) findViewById(e.g.auto_video_error_tips);
        this.bgr = findViewById(e.g.auto_video_error_background);
        this.bgm = (TextView) findViewById(e.g.text_video_duration);
        this.bgv = (TextView) findViewById(e.g.text_video_play_count);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i) {
        if (this.bgo != null && this.bgn != null && this.bgu != null && this.bgt != null && this.bgr != null && this.bgq != null) {
            if (z || this.bgw != i) {
                this.bgw = i;
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgB);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
                this.bgo.setVisibility(0);
                this.bgn.clearAnimation();
                this.bgn.setVisibility(0);
                this.bgu.setVisibility(0);
                this.bgt.bnv();
                this.bgr.setVisibility(8);
                this.bgq.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.awf == null || this.awf.wm() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Oz() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgB);
    }

    private void c(VideoInfo videoInfo) {
        Oz();
        if (this.bgn != null && this.bgl != null && this.bgp != null) {
            if (i.uj().un() && this.awf != null && videoInfo != null) {
                this.bgl.setVisibility(0);
                this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bgn.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.avN = videoInfo.video_url;
                if (StringUtils.isNull(this.avN)) {
                    e(true, 4);
                }
                this.bgm.setText(ao.dj(videoInfo.video_duration.intValue() * 1000));
                this.bgv.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.L(videoInfo.play_count.intValue())));
                return;
            }
            this.bgl.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.bgo, e.f.btn_icon_play_video_n);
            al.h(this.bgq, e.d.cp_cont_i);
            al.h(this.bgm, e.d.cp_cont_i);
            al.h(this.bgv, e.d.cp_cont_i);
            al.j(this.bgr, e.d.common_color_10014);
            if (this.bgq != null) {
                this.bgq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.awf = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        Oz();
        e(true, 1);
        if (this.bgp != null) {
            this.bgp.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.bgl;
    }

    public String getPlayUrl() {
        return this.avN;
    }

    public int getCurrentPosition() {
        if (this.bgp == null) {
            return 0;
        }
        return this.bgp.getCurrentPosition();
    }
}
