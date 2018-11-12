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
import com.baidu.tieba.play.x;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private bb aBF;
    private String aBn;
    private Runnable blA;
    private Runnable blB;
    private QuickVideoView.b blC;
    public FrameLayout blm;
    private TextView bln;
    private TbImageView blo;
    private ImageView blp;
    private QuickVideoView blq;
    private TextView blr;
    private View bls;
    private x blt;
    private View blu;
    private TextView blv;
    private int blw;
    private TbImageView.a blx;
    private g.b bly;
    private ViewTreeObserver.OnGlobalLayoutListener blz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.blw = 1;
        this.blx = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && FrsBaseVideoView.this.blo != null) {
                    FrsBaseVideoView.this.blo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.blz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.blm != null && FrsBaseVideoView.this.blm.getLayoutParams() != null && FrsBaseVideoView.this.blm.getVisibility() != 8) {
                    FrsBaseVideoView.this.blm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.blm.getLayoutParams();
                    if (FrsBaseVideoView.this.blm.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.blm.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.blm.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.blA = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.blq != null && !FrsBaseVideoView.this.blq.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.blB = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.blm = (FrameLayout) findViewById(e.g.frame_video);
        this.blm.setOnClickListener(this);
        this.blm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.blm != null) {
                    FrsBaseVideoView.this.blm.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.blz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.blm != null) {
                    FrsBaseVideoView.this.blm.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.blz);
                }
            }
        });
        this.blo = (TbImageView) findViewById(e.g.image_video);
        this.blo.setDefaultErrorResource(0);
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setEvent(this.blx);
        this.blo.setGifIconSupport(false);
        this.blt = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.blp = (ImageView) findViewById(e.g.image_video_play);
        this.blq = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.blq.setOnErrorListener(this.bly);
        this.blq.setOnSurfaceDestroyedListener(this.blC);
        this.blu = findViewById(e.g.auto_video_black_mask);
        this.blr = (TextView) findViewById(e.g.auto_video_error_tips);
        this.bls = findViewById(e.g.auto_video_error_background);
        this.bln = (TextView) findViewById(e.g.text_video_duration);
        this.blv = (TextView) findViewById(e.g.text_video_play_count);
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
        if (this.blp != null && this.blo != null && this.blu != null && this.blt != null && this.bls != null && this.blr != null) {
            if (z || this.blw != i) {
                this.blw = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blB);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
                this.blp.setVisibility(0);
                this.blo.clearAnimation();
                this.blo.setVisibility(0);
                this.blu.setVisibility(0);
                this.blt.bqg();
                this.bls.setVisibility(8);
                this.blr.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.aBF == null || this.aBF.yC() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void QE() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blB);
    }

    private void c(VideoInfo videoInfo) {
        QE();
        if (this.blo != null && this.blm != null && this.blq != null) {
            if (i.wA().wE() && this.aBF != null && videoInfo != null) {
                this.blm.setVisibility(0);
                this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.blo.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.aBn = videoInfo.video_url;
                if (StringUtils.isNull(this.aBn)) {
                    e(true, 4);
                }
                this.bln.setText(ao.dH(videoInfo.video_duration.intValue() * 1000));
                this.blv.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.P(videoInfo.play_count.intValue())));
                return;
            }
            this.blm.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.blp, e.f.btn_icon_play_video_n);
            al.h(this.blr, e.d.cp_cont_i);
            al.h(this.bln, e.d.cp_cont_i);
            al.h(this.blv, e.d.cp_cont_i);
            al.j(this.bls, e.d.common_color_10014);
            if (this.blr != null) {
                this.blr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.aBF = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        QE();
        e(true, 1);
        if (this.blq != null) {
            this.blq.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.blm;
    }

    public String getPlayUrl() {
        return this.aBn;
    }

    public int getCurrentPosition() {
        if (this.blq == null) {
            return 0;
        }
        return this.blq.getCurrentPosition();
    }
}
