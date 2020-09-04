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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.m;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private TbCyberVideoView Zp;
    private bw afL;
    private CyberPlayerManager.OnErrorListener dLM;
    public FrameLayout fbZ;
    private TextView fca;
    private TbImageView fcb;
    private ImageView fcc;
    private TextView fcd;
    private View fce;
    private m fcf;
    private View fcg;
    private TextView fch;
    private int fci;
    private TbImageView.a fcj;
    private ViewTreeObserver.OnGlobalLayoutListener fck;
    private Runnable fcl;
    private Runnable fcm;
    private TbCyberVideoView.a fcn;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fci = 1;
        this.fcj = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fcb != null) {
                    FrsBaseVideoView.this.fcb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.fck = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fbZ != null && FrsBaseVideoView.this.fbZ.getLayoutParams() != null && FrsBaseVideoView.this.fbZ.getVisibility() != 8) {
                    FrsBaseVideoView.this.fbZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fbZ.getLayoutParams();
                    if (FrsBaseVideoView.this.fbZ.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fbZ.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fbZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fcl = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Zp != null && !FrsBaseVideoView.this.Zp.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fcm = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.base_video_view, this);
        setOrientation(1);
        this.fbZ = (FrameLayout) findViewById(R.id.frame_video);
        this.fbZ.setOnClickListener(this);
        this.fbZ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fbZ != null) {
                    FrsBaseVideoView.this.fbZ.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fck);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fbZ != null) {
                    FrsBaseVideoView.this.fbZ.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fck);
                }
            }
        });
        this.fcb = (TbImageView) findViewById(R.id.image_video);
        this.fcb.setDefaultErrorResource(0);
        this.fcb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fcb.setEvent(this.fcj);
        this.fcb.setGifIconSupport(false);
        this.fcf = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fcc = (ImageView) findViewById(R.id.image_video_play);
        this.Zp = new TbCyberVideoView(getContext());
        this.Zp.setStageType("2003");
        bxg();
        this.Zp.setOnErrorListener(this.dLM);
        this.Zp.setOnSurfaceDestroyedListener(this.fcn);
        this.fcg = findViewById(R.id.auto_video_black_mask);
        this.fcd = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fce = findViewById(R.id.auto_video_error_background);
        this.fca = (TextView) findViewById(R.id.text_video_duration);
        this.fch = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bxg() {
        if (this.Zp != null && this.Zp.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fbZ.addView(this.Zp.getView(), 0);
            this.Zp.getView().setLayoutParams(layoutParams);
        }
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
    public void v(boolean z, int i) {
        if (this.fcc != null && this.fcb != null && this.fcg != null && this.fcf != null && this.fce != null && this.fcd != null) {
            if (z || this.fci != i) {
                this.fci = i;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcm);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcl);
                this.fcc.setVisibility(0);
                this.fcb.clearAnimation();
                this.fcb.setVisibility(0);
                this.fcg.setVisibility(0);
                this.fcf.dkd();
                this.fce.setVisibility(8);
                this.fcd.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.afL == null || this.afL.beE() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bxh() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcl);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fcm);
    }

    private void d(VideoInfo videoInfo) {
        bxh();
        if (this.fcb != null && this.fbZ != null && this.Zp != null) {
            if (k.bbM().isShowImages() && this.afL != null && videoInfo != null) {
                this.fbZ.setVisibility(0);
                this.fcb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fcb.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.fca.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fch.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fbZ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fcc, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setViewTextColor(this.fca, R.color.cp_cont_a);
            ap.setViewTextColor(this.fch, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fce, R.color.common_color_10014);
            if (this.fcd != null) {
                this.fcd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bw bwVar, VideoInfo videoInfo) {
        if (bwVar != null) {
            this.afL = bwVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bxh();
        v(true, 1);
        if (this.Zp != null) {
            this.Zp.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fbZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Zp == null) {
            return 0;
        }
        return this.Zp.getCurrentPosition();
    }
}
