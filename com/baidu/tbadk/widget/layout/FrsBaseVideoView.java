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
/* loaded from: classes2.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private TbCyberVideoView Zn;
    private bw afJ;
    private CyberPlayerManager.OnErrorListener dLI;
    public FrameLayout fbV;
    private TextView fbW;
    private TbImageView fbX;
    private ImageView fbY;
    private TextView fbZ;
    private View fca;
    private m fcb;
    private View fcc;
    private TextView fcd;
    private int fce;
    private TbImageView.a fcf;
    private ViewTreeObserver.OnGlobalLayoutListener fcg;
    private Runnable fch;
    private Runnable fci;
    private TbCyberVideoView.a fcj;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fce = 1;
        this.fcf = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fbX != null) {
                    FrsBaseVideoView.this.fbX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.fcg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fbV != null && FrsBaseVideoView.this.fbV.getLayoutParams() != null && FrsBaseVideoView.this.fbV.getVisibility() != 8) {
                    FrsBaseVideoView.this.fbV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fbV.getLayoutParams();
                    if (FrsBaseVideoView.this.fbV.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fbV.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fbV.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fch = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Zn != null && !FrsBaseVideoView.this.Zn.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fci = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fbV = (FrameLayout) findViewById(R.id.frame_video);
        this.fbV.setOnClickListener(this);
        this.fbV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fbV != null) {
                    FrsBaseVideoView.this.fbV.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fcg);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fbV != null) {
                    FrsBaseVideoView.this.fbV.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fcg);
                }
            }
        });
        this.fbX = (TbImageView) findViewById(R.id.image_video);
        this.fbX.setDefaultErrorResource(0);
        this.fbX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fbX.setEvent(this.fcf);
        this.fbX.setGifIconSupport(false);
        this.fcb = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fbY = (ImageView) findViewById(R.id.image_video_play);
        this.Zn = new TbCyberVideoView(getContext());
        this.Zn.setStageType("2003");
        bxf();
        this.Zn.setOnErrorListener(this.dLI);
        this.Zn.setOnSurfaceDestroyedListener(this.fcj);
        this.fcc = findViewById(R.id.auto_video_black_mask);
        this.fbZ = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fca = findViewById(R.id.auto_video_error_background);
        this.fbW = (TextView) findViewById(R.id.text_video_duration);
        this.fcd = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bxf() {
        if (this.Zn != null && this.Zn.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fbV.addView(this.Zn.getView(), 0);
            this.Zn.getView().setLayoutParams(layoutParams);
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
        if (this.fbY != null && this.fbX != null && this.fcc != null && this.fcb != null && this.fca != null && this.fbZ != null) {
            if (z || this.fce != i) {
                this.fce = i;
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fci);
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fch);
                this.fbY.setVisibility(0);
                this.fbX.clearAnimation();
                this.fbX.setVisibility(0);
                this.fcc.setVisibility(0);
                this.fcb.dka();
                this.fca.setVisibility(8);
                this.fbZ.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.afJ == null || this.afJ.beE() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bxg() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fch);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fci);
    }

    private void d(VideoInfo videoInfo) {
        bxg();
        if (this.fbX != null && this.fbV != null && this.Zn != null) {
            if (k.bbM().isShowImages() && this.afJ != null && videoInfo != null) {
                this.fbV.setVisibility(0);
                this.fbX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fbX.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.fbW.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fcd.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fbV.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fbY, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fbZ, R.color.cp_cont_a);
            ap.setViewTextColor(this.fbW, R.color.cp_cont_a);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fca, R.color.common_color_10014);
            if (this.fbZ != null) {
                this.fbZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bw bwVar, VideoInfo videoInfo) {
        if (bwVar != null) {
            this.afJ = bwVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bxg();
        v(true, 1);
        if (this.Zn != null) {
            this.Zn.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fbV;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Zn == null) {
            return 0;
        }
        return this.Zn.getCurrentPosition();
    }
}
