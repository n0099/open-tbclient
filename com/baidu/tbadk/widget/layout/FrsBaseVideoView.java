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
    private String aEO;
    private bb aFg;
    public FrameLayout boN;
    private TextView boO;
    private TbImageView boP;
    private ImageView boQ;
    private QuickVideoView boR;
    private TextView boS;
    private View boT;
    private x boU;
    private View boV;
    private TextView boW;
    private int boX;
    private TbImageView.a boY;
    private g.b boZ;
    private ViewTreeObserver.OnGlobalLayoutListener bpa;
    private Runnable bpb;
    private Runnable bpc;
    private QuickVideoView.b bpd;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.boX = 1;
        this.boY = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && FrsBaseVideoView.this.boP != null) {
                    FrsBaseVideoView.this.boP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bpa = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.boN != null && FrsBaseVideoView.this.boN.getLayoutParams() != null && FrsBaseVideoView.this.boN.getVisibility() != 8) {
                    FrsBaseVideoView.this.boN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.boN.getLayoutParams();
                    if (FrsBaseVideoView.this.boN.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.boN.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.boN.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bpb = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.boR != null && !FrsBaseVideoView.this.boR.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bpc = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.boN = (FrameLayout) findViewById(e.g.frame_video);
        this.boN.setOnClickListener(this);
        this.boN.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.boN != null) {
                    FrsBaseVideoView.this.boN.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bpa);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.boN != null) {
                    FrsBaseVideoView.this.boN.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bpa);
                }
            }
        });
        this.boP = (TbImageView) findViewById(e.g.image_video);
        this.boP.setDefaultErrorResource(0);
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setEvent(this.boY);
        this.boP.setGifIconSupport(false);
        this.boU = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.boQ = (ImageView) findViewById(e.g.image_video_play);
        this.boR = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.boR.setOnErrorListener(this.boZ);
        this.boR.setOnSurfaceDestroyedListener(this.bpd);
        this.boV = findViewById(e.g.auto_video_black_mask);
        this.boS = (TextView) findViewById(e.g.auto_video_error_tips);
        this.boT = findViewById(e.g.auto_video_error_background);
        this.boO = (TextView) findViewById(e.g.text_video_duration);
        this.boW = (TextView) findViewById(e.g.text_video_play_count);
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
        if (this.boQ != null && this.boP != null && this.boV != null && this.boU != null && this.boT != null && this.boS != null) {
            if (z || this.boX != i) {
                this.boX = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpc);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
                this.boQ.setVisibility(0);
                this.boP.clearAnimation();
                this.boP.setVisibility(0);
                this.boV.setVisibility(0);
                this.boU.bsK();
                this.boT.setVisibility(8);
                this.boS.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.aFg == null || this.aFg.zG() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void RM() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpc);
    }

    private void c(VideoInfo videoInfo) {
        RM();
        if (this.boP != null && this.boN != null && this.boR != null) {
            if (i.xE().xI() && this.aFg != null && videoInfo != null) {
                this.boN.setVisibility(0);
                this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boP.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.aEO = videoInfo.video_url;
                if (StringUtils.isNull(this.aEO)) {
                    e(true, 4);
                }
                this.boO.setText(ao.dV(videoInfo.video_duration.intValue() * 1000));
                this.boW.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.X(videoInfo.play_count.intValue())));
                return;
            }
            this.boN.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.boQ, e.f.btn_icon_play_video_n);
            al.h(this.boS, e.d.cp_cont_i);
            al.h(this.boO, e.d.cp_cont_i);
            al.h(this.boW, e.d.cp_cont_i);
            al.j(this.boT, e.d.common_color_10014);
            if (this.boS != null) {
                this.boS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.aFg = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        RM();
        e(true, 1);
        if (this.boR != null) {
            this.boR.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.boN;
    }

    public String getPlayUrl() {
        return this.aEO;
    }

    public int getCurrentPosition() {
        if (this.boR == null) {
            return 0;
        }
        return this.boR.getCurrentPosition();
    }
}
