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
    private bb aFI;
    private String aFq;
    public FrameLayout bpB;
    private TextView bpC;
    private TbImageView bpD;
    private ImageView bpE;
    private QuickVideoView bpF;
    private TextView bpG;
    private View bpH;
    private x bpI;
    private View bpJ;
    private TextView bpK;
    private int bpL;
    private TbImageView.a bpM;
    private g.b bpN;
    private ViewTreeObserver.OnGlobalLayoutListener bpO;
    private Runnable bpP;
    private Runnable bpQ;
    private QuickVideoView.b bpR;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bpL = 1;
        this.bpM = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && FrsBaseVideoView.this.bpD != null) {
                    FrsBaseVideoView.this.bpD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bpO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.bpB != null && FrsBaseVideoView.this.bpB.getLayoutParams() != null && FrsBaseVideoView.this.bpB.getVisibility() != 8) {
                    FrsBaseVideoView.this.bpB.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.bpB.getLayoutParams();
                    if (FrsBaseVideoView.this.bpB.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.bpB.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.bpB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bpP = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.bpF != null && !FrsBaseVideoView.this.bpF.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.bpB = (FrameLayout) findViewById(e.g.frame_video);
        this.bpB.setOnClickListener(this);
        this.bpB.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.bpB != null) {
                    FrsBaseVideoView.this.bpB.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bpO);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.bpB != null) {
                    FrsBaseVideoView.this.bpB.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bpO);
                }
            }
        });
        this.bpD = (TbImageView) findViewById(e.g.image_video);
        this.bpD.setDefaultErrorResource(0);
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setEvent(this.bpM);
        this.bpD.setGifIconSupport(false);
        this.bpI = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bpE = (ImageView) findViewById(e.g.image_video_play);
        this.bpF = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.bpF.setOnErrorListener(this.bpN);
        this.bpF.setOnSurfaceDestroyedListener(this.bpR);
        this.bpJ = findViewById(e.g.auto_video_black_mask);
        this.bpG = (TextView) findViewById(e.g.auto_video_error_tips);
        this.bpH = findViewById(e.g.auto_video_error_background);
        this.bpC = (TextView) findViewById(e.g.text_video_duration);
        this.bpK = (TextView) findViewById(e.g.text_video_play_count);
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
        if (this.bpE != null && this.bpD != null && this.bpJ != null && this.bpI != null && this.bpH != null && this.bpG != null) {
            if (z || this.bpL != i) {
                this.bpL = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
                this.bpE.setVisibility(0);
                this.bpD.clearAnimation();
                this.bpD.setVisibility(0);
                this.bpJ.setVisibility(0);
                this.bpI.btt();
                this.bpH.setVisibility(8);
                this.bpG.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.aFI == null || this.aFI.zT() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Si() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
    }

    private void c(VideoInfo videoInfo) {
        Si();
        if (this.bpD != null && this.bpB != null && this.bpF != null) {
            if (i.xR().xV() && this.aFI != null && videoInfo != null) {
                this.bpB.setVisibility(0);
                this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpD.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.aFq = videoInfo.video_url;
                if (StringUtils.isNull(this.aFq)) {
                    e(true, 4);
                }
                this.bpC.setText(ao.dV(videoInfo.video_duration.intValue() * 1000));
                this.bpK.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.X(videoInfo.play_count.intValue())));
                return;
            }
            this.bpB.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.bpE, e.f.btn_icon_play_video_n);
            al.h(this.bpG, e.d.cp_cont_i);
            al.h(this.bpC, e.d.cp_cont_i);
            al.h(this.bpK, e.d.cp_cont_i);
            al.j(this.bpH, e.d.common_color_10014);
            if (this.bpG != null) {
                this.bpG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.aFI = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        Si();
        e(true, 1);
        if (this.bpF != null) {
            this.bpF.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.bpB;
    }

    public String getPlayUrl() {
        return this.aFq;
    }

    public int getCurrentPosition() {
        if (this.bpF == null) {
            return 0;
        }
        return this.bpF.getCurrentPosition();
    }
}
