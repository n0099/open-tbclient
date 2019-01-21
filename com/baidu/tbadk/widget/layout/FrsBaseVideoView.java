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
    private bb aFJ;
    private String aFr;
    public FrameLayout bpC;
    private TextView bpD;
    private TbImageView bpE;
    private ImageView bpF;
    private QuickVideoView bpG;
    private TextView bpH;
    private View bpI;
    private x bpJ;
    private View bpK;
    private TextView bpL;
    private int bpM;
    private TbImageView.a bpN;
    private g.b bpO;
    private ViewTreeObserver.OnGlobalLayoutListener bpP;
    private Runnable bpQ;
    private Runnable bpR;
    private QuickVideoView.b bpS;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bpM = 1;
        this.bpN = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && FrsBaseVideoView.this.bpE != null) {
                    FrsBaseVideoView.this.bpE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bpP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.bpC != null && FrsBaseVideoView.this.bpC.getLayoutParams() != null && FrsBaseVideoView.this.bpC.getVisibility() != 8) {
                    FrsBaseVideoView.this.bpC.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.bpC.getLayoutParams();
                    if (FrsBaseVideoView.this.bpC.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.bpC.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.bpC.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.bpG != null && !FrsBaseVideoView.this.bpG.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bpR = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.bpC = (FrameLayout) findViewById(e.g.frame_video);
        this.bpC.setOnClickListener(this);
        this.bpC.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.bpC != null) {
                    FrsBaseVideoView.this.bpC.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bpP);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.bpC != null) {
                    FrsBaseVideoView.this.bpC.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bpP);
                }
            }
        });
        this.bpE = (TbImageView) findViewById(e.g.image_video);
        this.bpE.setDefaultErrorResource(0);
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setEvent(this.bpN);
        this.bpE.setGifIconSupport(false);
        this.bpJ = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bpF = (ImageView) findViewById(e.g.image_video_play);
        this.bpG = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.bpG.setOnErrorListener(this.bpO);
        this.bpG.setOnSurfaceDestroyedListener(this.bpS);
        this.bpK = findViewById(e.g.auto_video_black_mask);
        this.bpH = (TextView) findViewById(e.g.auto_video_error_tips);
        this.bpI = findViewById(e.g.auto_video_error_background);
        this.bpD = (TextView) findViewById(e.g.text_video_duration);
        this.bpL = (TextView) findViewById(e.g.text_video_play_count);
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
        if (this.bpF != null && this.bpE != null && this.bpK != null && this.bpJ != null && this.bpI != null && this.bpH != null) {
            if (z || this.bpM != i) {
                this.bpM = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpR);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
                this.bpF.setVisibility(0);
                this.bpE.clearAnimation();
                this.bpE.setVisibility(0);
                this.bpK.setVisibility(0);
                this.bpJ.btt();
                this.bpI.setVisibility(8);
                this.bpH.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.aFJ == null || this.aFJ.zT() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Si() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpR);
    }

    private void c(VideoInfo videoInfo) {
        Si();
        if (this.bpE != null && this.bpC != null && this.bpG != null) {
            if (i.xR().xV() && this.aFJ != null && videoInfo != null) {
                this.bpC.setVisibility(0);
                this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpE.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.aFr = videoInfo.video_url;
                if (StringUtils.isNull(this.aFr)) {
                    e(true, 4);
                }
                this.bpD.setText(ao.dV(videoInfo.video_duration.intValue() * 1000));
                this.bpL.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.X(videoInfo.play_count.intValue())));
                return;
            }
            this.bpC.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.bpF, e.f.btn_icon_play_video_n);
            al.h(this.bpH, e.d.cp_cont_i);
            al.h(this.bpD, e.d.cp_cont_i);
            al.h(this.bpL, e.d.cp_cont_i);
            al.j(this.bpI, e.d.common_color_10014);
            if (this.bpH != null) {
                this.bpH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.aFJ = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        Si();
        e(true, 1);
        if (this.bpG != null) {
            this.bpG.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.bpC;
    }

    public String getPlayUrl() {
        return this.aFr;
    }

    public int getCurrentPosition() {
        if (this.bpG == null) {
            return 0;
        }
        return this.bpG.getCurrentPosition();
    }
}
