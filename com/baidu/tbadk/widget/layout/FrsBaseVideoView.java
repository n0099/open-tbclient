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
    private bb aAQ;
    private String aAy;
    public FrameLayout bkB;
    private TextView bkC;
    private TbImageView bkD;
    private ImageView bkE;
    private QuickVideoView bkF;
    private TextView bkG;
    private View bkH;
    private x bkI;
    private View bkJ;
    private TextView bkK;
    private int bkL;
    private TbImageView.a bkM;
    private g.b bkN;
    private ViewTreeObserver.OnGlobalLayoutListener bkO;
    private Runnable bkP;
    private Runnable bkQ;
    private QuickVideoView.b bkR;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bkL = 1;
        this.bkM = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && FrsBaseVideoView.this.bkD != null) {
                    FrsBaseVideoView.this.bkD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bkO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.bkB != null && FrsBaseVideoView.this.bkB.getLayoutParams() != null && FrsBaseVideoView.this.bkB.getVisibility() != 8) {
                    FrsBaseVideoView.this.bkB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.bkB.getLayoutParams();
                    if (FrsBaseVideoView.this.bkB.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.bkB.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.bkB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bkP = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.bkF != null && !FrsBaseVideoView.this.bkF.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bkQ = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.bkB = (FrameLayout) findViewById(e.g.frame_video);
        this.bkB.setOnClickListener(this);
        this.bkB.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.bkB != null) {
                    FrsBaseVideoView.this.bkB.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bkO);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.bkB != null) {
                    FrsBaseVideoView.this.bkB.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bkO);
                }
            }
        });
        this.bkD = (TbImageView) findViewById(e.g.image_video);
        this.bkD.setDefaultErrorResource(0);
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setEvent(this.bkM);
        this.bkD.setGifIconSupport(false);
        this.bkI = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bkE = (ImageView) findViewById(e.g.image_video_play);
        this.bkF = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.bkF.setOnErrorListener(this.bkN);
        this.bkF.setOnSurfaceDestroyedListener(this.bkR);
        this.bkJ = findViewById(e.g.auto_video_black_mask);
        this.bkG = (TextView) findViewById(e.g.auto_video_error_tips);
        this.bkH = findViewById(e.g.auto_video_error_background);
        this.bkC = (TextView) findViewById(e.g.text_video_duration);
        this.bkK = (TextView) findViewById(e.g.text_video_play_count);
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
        if (this.bkE != null && this.bkD != null && this.bkJ != null && this.bkI != null && this.bkH != null && this.bkG != null) {
            if (z || this.bkL != i) {
                this.bkL = i;
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkQ);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
                this.bkE.setVisibility(0);
                this.bkD.clearAnimation();
                this.bkD.setVisibility(0);
                this.bkJ.setVisibility(0);
                this.bkI.bqK();
                this.bkH.setVisibility(8);
                this.bkG.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.aAQ == null || this.aAQ.yv() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Qv() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkQ);
    }

    private void c(VideoInfo videoInfo) {
        Qv();
        if (this.bkD != null && this.bkB != null && this.bkF != null) {
            if (i.ws().ww() && this.aAQ != null && videoInfo != null) {
                this.bkB.setVisibility(0);
                this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bkD.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.aAy = videoInfo.video_url;
                if (StringUtils.isNull(this.aAy)) {
                    e(true, 4);
                }
                this.bkC.setText(ao.dt(videoInfo.video_duration.intValue() * 1000));
                this.bkK.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.N(videoInfo.play_count.intValue())));
                return;
            }
            this.bkB.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.bkE, e.f.btn_icon_play_video_n);
            al.h(this.bkG, e.d.cp_cont_i);
            al.h(this.bkC, e.d.cp_cont_i);
            al.h(this.bkK, e.d.cp_cont_i);
            al.j(this.bkH, e.d.common_color_10014);
            if (this.bkG != null) {
                this.bkG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.aAQ = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        Qv();
        e(true, 1);
        if (this.bkF != null) {
            this.bkF.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.bkB;
    }

    public String getPlayUrl() {
        return this.aAy;
    }

    public int getCurrentPosition() {
        if (this.bkF == null) {
            return 0;
        }
        return this.bkF.getCurrentPosition();
    }
}
