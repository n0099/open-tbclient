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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private bc atZ;
    public FrameLayout bcH;
    private TextView bcI;
    private TbImageView bcJ;
    private ImageView bcK;
    private QuickVideoView bcL;
    private TextView bcM;
    private View bcN;
    private w bcO;
    private View bcP;
    private TextView bcQ;
    private int bcR;
    private String bcS;
    private TbImageView.a bcT;
    private g.b bcU;
    private ViewTreeObserver.OnGlobalLayoutListener bcV;
    private Runnable bcW;
    private Runnable bcX;
    private QuickVideoView.b bcY;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bcR = 1;
        this.bcT = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && FrsBaseVideoView.this.bcJ != null) {
                    FrsBaseVideoView.this.bcJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bcV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.bcH != null && FrsBaseVideoView.this.bcH.getLayoutParams() != null && FrsBaseVideoView.this.bcH.getVisibility() != 8) {
                    FrsBaseVideoView.this.bcH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.bcH.getLayoutParams();
                    if (FrsBaseVideoView.this.bcH.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.bcH.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.bcH.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bcW = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.bcL != null && !FrsBaseVideoView.this.bcL.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bcX = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.base_video_view, this);
        setOrientation(1);
        this.bcH = (FrameLayout) findViewById(d.g.frame_video);
        this.bcH.setOnClickListener(this);
        this.bcH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.bcH != null) {
                    FrsBaseVideoView.this.bcH.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bcV);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.bcH != null) {
                    FrsBaseVideoView.this.bcH.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bcV);
                }
            }
        });
        this.bcJ = (TbImageView) findViewById(d.g.image_video);
        this.bcJ.setDefaultErrorResource(0);
        this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcJ.setEvent(this.bcT);
        this.bcJ.setGifIconSupport(false);
        this.bcO = new w((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.bcK = (ImageView) findViewById(d.g.image_video_play);
        this.bcL = (QuickVideoView) findViewById(d.g.texture_video_view);
        this.bcL.setOnErrorListener(this.bcU);
        this.bcL.setOnSurfaceDestroyedListener(this.bcY);
        this.bcP = findViewById(d.g.auto_video_black_mask);
        this.bcM = (TextView) findViewById(d.g.auto_video_error_tips);
        this.bcN = findViewById(d.g.auto_video_error_background);
        this.bcI = (TextView) findViewById(d.g.text_video_duration);
        this.bcQ = (TextView) findViewById(d.g.text_video_play_count);
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
        if (this.bcK != null && this.bcJ != null && this.bcP != null && this.bcO != null && this.bcN != null && this.bcM != null) {
            if (z || this.bcR != i) {
                this.bcR = i;
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcX);
                com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcW);
                this.bcK.setVisibility(0);
                this.bcJ.clearAnimation();
                this.bcJ.setVisibility(0);
                this.bcP.setVisibility(0);
                this.bcO.bmz();
                this.bcN.setVisibility(8);
                this.bcM.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.atZ == null || this.atZ.vw() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Ng() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcW);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bcX);
    }

    private void c(VideoInfo videoInfo) {
        Ng();
        if (this.bcJ != null && this.bcH != null && this.bcL != null) {
            if (i.tt().tz() && this.atZ != null && videoInfo != null) {
                this.bcH.setVisibility(0);
                this.bcJ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcJ.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bcS = videoInfo.video_url;
                if (StringUtils.isNull(this.bcS)) {
                    e(true, 4);
                }
                this.bcI.setText(ap.cY(videoInfo.video_duration.intValue() * 1000));
                this.bcQ.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(d.k.play_count), ap.F(videoInfo.play_count.intValue())));
                return;
            }
            this.bcH.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this, d.f.addresslist_item_bg);
            am.c(this.bcK, d.f.btn_icon_play_video_n);
            am.h(this.bcM, d.C0142d.cp_cont_i);
            am.h(this.bcI, d.C0142d.cp_cont_i);
            am.h(this.bcQ, d.C0142d.cp_cont_i);
            am.j(this.bcN, d.C0142d.common_color_10014);
            if (this.bcM != null) {
                this.bcM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bc bcVar, VideoInfo videoInfo) {
        if (bcVar != null) {
            this.atZ = bcVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        Ng();
        e(true, 1);
        if (this.bcL != null) {
            this.bcL.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.bcH;
    }

    public String getPlayUrl() {
        return this.bcS;
    }

    public int getCurrentPosition() {
        if (this.bcL == null) {
            return 0;
        }
        return this.bcL.getCurrentPosition();
    }
}
