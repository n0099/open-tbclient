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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private bb atE;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private QuickVideoView bcU;
    private TextView bcV;
    private View bcW;
    private w bcX;
    private View bcY;
    private TextView bcZ;
    private int bda;
    private String bdb;
    private TbImageView.a bdc;
    private g.b bdd;
    private ViewTreeObserver.OnGlobalLayoutListener bde;
    private Runnable bdf;
    private Runnable bdg;
    private QuickVideoView.b bdh;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bda = 1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && FrsBaseVideoView.this.bcS != null) {
                    FrsBaseVideoView.this.bcS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.bde = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.bcQ != null && FrsBaseVideoView.this.bcQ.getLayoutParams() != null && FrsBaseVideoView.this.bcQ.getVisibility() != 8) {
                    FrsBaseVideoView.this.bcQ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.bcQ.getLayoutParams();
                    if (FrsBaseVideoView.this.bcQ.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.bcQ.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.bcQ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.bcU != null && !FrsBaseVideoView.this.bcU.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.bdg = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(f.h.base_video_view, this);
        setOrientation(1);
        this.bcQ = (FrameLayout) findViewById(f.g.frame_video);
        this.bcQ.setOnClickListener(this);
        this.bcQ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.bcQ != null) {
                    FrsBaseVideoView.this.bcQ.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.bde);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.bcQ != null) {
                    FrsBaseVideoView.this.bcQ.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.bde);
                }
            }
        });
        this.bcS = (TbImageView) findViewById(f.g.image_video);
        this.bcS.setDefaultErrorResource(0);
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setEvent(this.bdc);
        this.bcS.setGifIconSupport(false);
        this.bcX = new w((ViewGroup) findViewById(f.g.auto_video_loading_container));
        this.bcT = (ImageView) findViewById(f.g.image_video_play);
        this.bcU = (QuickVideoView) findViewById(f.g.texture_video_view);
        this.bcU.setOnErrorListener(this.bdd);
        this.bcU.setOnSurfaceDestroyedListener(this.bdh);
        this.bcY = findViewById(f.g.auto_video_black_mask);
        this.bcV = (TextView) findViewById(f.g.auto_video_error_tips);
        this.bcW = findViewById(f.g.auto_video_error_background);
        this.bcR = (TextView) findViewById(f.g.text_video_duration);
        this.bcZ = (TextView) findViewById(f.g.text_video_play_count);
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
        if (this.bcT != null && this.bcS != null && this.bcY != null && this.bcX != null && this.bcW != null && this.bcV != null) {
            if (z || this.bda != i) {
                this.bda = i;
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
                com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
                this.bcT.setVisibility(0);
                this.bcS.clearAnimation();
                this.bcS.setVisibility(0);
                this.bcY.setVisibility(0);
                this.bcX.bkP();
                this.bcW.setVisibility(8);
                this.bcV.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.atE == null || this.atE.vj() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void Ng() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdf);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bdg);
    }

    private void c(VideoInfo videoInfo) {
        Ng();
        if (this.bcS != null && this.bcQ != null && this.bcU != null) {
            if (i.td().tj() && this.atE != null && videoInfo != null) {
                this.bcQ.setVisibility(0);
                this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                this.bcS.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bdb = videoInfo.video_url;
                if (StringUtils.isNull(this.bdb)) {
                    e(true, 4);
                }
                this.bcR.setText(ap.da(videoInfo.video_duration.intValue() * 1000));
                this.bcZ.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(f.j.play_count), ap.H(videoInfo.play_count.intValue())));
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this, f.C0146f.addresslist_item_bg);
            am.c(this.bcT, f.C0146f.btn_icon_play_video_n);
            am.h(this.bcV, f.d.cp_cont_i);
            am.h(this.bcR, f.d.cp_cont_i);
            am.h(this.bcZ, f.d.cp_cont_i);
            am.j(this.bcW, f.d.common_color_10014);
            if (this.bcV != null) {
                this.bcV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(f.C0146f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.atE = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        Ng();
        e(true, 1);
        if (this.bcU != null) {
            this.bcU.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.bcQ;
    }

    public String getPlayUrl() {
        return this.bdb;
    }

    public int getCurrentPosition() {
        if (this.bcU == null) {
            return 0;
        }
        return this.bcU.getCurrentPosition();
    }
}
