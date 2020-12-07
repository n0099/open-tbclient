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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.m;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private TbCyberVideoView aaZ;
    private by ahA;
    private CyberPlayerManager.OnErrorListener etz;
    public FrameLayout fMI;
    private TextView fMJ;
    private TbImageView fMK;
    private ImageView fML;
    private TextView fMM;
    private View fMN;
    private m fMO;
    private View fMP;
    private TextView fMQ;
    private int fMR;
    private TbImageView.a fMS;
    private ViewTreeObserver.OnGlobalLayoutListener fMT;
    private Runnable fMU;
    private Runnable fMV;
    private TbCyberVideoView.a fMW;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fMR = 1;
        this.fMS = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fMK != null) {
                    FrsBaseVideoView.this.fMK.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.w(true, 4);
                return true;
            }
        };
        this.fMT = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fMI != null && FrsBaseVideoView.this.fMI.getLayoutParams() != null && FrsBaseVideoView.this.fMI.getVisibility() != 8) {
                    FrsBaseVideoView.this.fMI.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fMI.getLayoutParams();
                    if (FrsBaseVideoView.this.fMI.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fMI.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fMI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.aaZ != null && !FrsBaseVideoView.this.aaZ.isPlaying()) {
                    FrsBaseVideoView.this.w(true, 1);
                }
            }
        };
        this.fMV = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.w(true, 4);
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fMI = (FrameLayout) findViewById(R.id.frame_video);
        this.fMI.setOnClickListener(this);
        this.fMI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fMI != null) {
                    FrsBaseVideoView.this.fMI.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fMT);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fMI != null) {
                    FrsBaseVideoView.this.fMI.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fMT);
                }
            }
        });
        this.fMK = (TbImageView) findViewById(R.id.image_video);
        this.fMK.setDefaultErrorResource(0);
        this.fMK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fMK.setEvent(this.fMS);
        this.fMK.setGifIconSupport(false);
        this.fMO = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fML = (ImageView) findViewById(R.id.image_video_play);
        this.aaZ = new TbCyberVideoView(getContext());
        this.aaZ.setStageType("2003");
        bIl();
        this.aaZ.setOnErrorListener(this.etz);
        this.aaZ.setOnSurfaceDestroyedListener(this.fMW);
        this.fMP = findViewById(R.id.auto_video_black_mask);
        this.fMM = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fMN = findViewById(R.id.auto_video_error_background);
        this.fMJ = (TextView) findViewById(R.id.text_video_duration);
        this.fMQ = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bIl() {
        if (this.aaZ != null && this.aaZ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fMI.addView(this.aaZ.getView(), 0);
            this.aaZ.getView().setLayoutParams(layoutParams);
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
    public void w(boolean z, int i) {
        if (this.fML != null && this.fMK != null && this.fMP != null && this.fMO != null && this.fMN != null && this.fMM != null) {
            if (z || this.fMR != i) {
                this.fMR = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMV);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
                this.fML.setVisibility(0);
                this.fMK.clearAnimation();
                this.fMK.setVisibility(0);
                this.fMP.setVisibility(0);
                this.fMO.dBV();
                this.fMN.setVisibility(8);
                this.fMM.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.ahA == null || this.ahA.boP() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bIm() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMV);
    }

    private void d(VideoInfo videoInfo) {
        bIm();
        if (this.fMK != null && this.fMI != null && this.aaZ != null) {
            if (k.blV().isShowImages() && this.ahA != null && videoInfo != null) {
                this.fMI.setVisibility(0);
                this.fMK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fMK.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                }
                this.fMJ.setText(au.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fMQ.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), au.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fMI.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fML, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fMM, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMJ, R.color.CAM_X0101);
            ap.setViewTextColor(this.fMQ, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fMN, R.color.common_color_10014);
            if (this.fMM != null) {
                this.fMM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(by byVar, VideoInfo videoInfo) {
        if (byVar != null) {
            this.ahA = byVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bIm();
        w(true, 1);
        if (this.aaZ != null) {
            this.aaZ.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fMI;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.aaZ == null) {
            return 0;
        }
        return this.aaZ.getCurrentPosition();
    }
}
