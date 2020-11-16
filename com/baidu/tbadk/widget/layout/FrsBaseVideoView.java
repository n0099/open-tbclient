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
import com.baidu.tbadk.core.data.bx;
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
    private TbCyberVideoView aae;
    private bx agB;
    private CyberPlayerManager.OnErrorListener emx;
    public FrameLayout fEW;
    private TextView fEX;
    private TbImageView fEY;
    private ImageView fEZ;
    private TextView fFa;
    private View fFb;
    private m fFc;
    private View fFd;
    private TextView fFe;
    private int fFf;
    private TbImageView.a fFg;
    private ViewTreeObserver.OnGlobalLayoutListener fFh;
    private Runnable fFi;
    private Runnable fFj;
    private TbCyberVideoView.a fFk;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fFf = 1;
        this.fFg = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fEY != null) {
                    FrsBaseVideoView.this.fEY.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.w(true, 4);
                return true;
            }
        };
        this.fFh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fEW != null && FrsBaseVideoView.this.fEW.getLayoutParams() != null && FrsBaseVideoView.this.fEW.getVisibility() != 8) {
                    FrsBaseVideoView.this.fEW.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fEW.getLayoutParams();
                    if (FrsBaseVideoView.this.fEW.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fEW.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fEW.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fFi = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.aae != null && !FrsBaseVideoView.this.aae.isPlaying()) {
                    FrsBaseVideoView.this.w(true, 1);
                }
            }
        };
        this.fFj = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.w(true, 4);
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fEW = (FrameLayout) findViewById(R.id.frame_video);
        this.fEW.setOnClickListener(this);
        this.fEW.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fEW != null) {
                    FrsBaseVideoView.this.fEW.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fFh);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fEW != null) {
                    FrsBaseVideoView.this.fEW.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fFh);
                }
            }
        });
        this.fEY = (TbImageView) findViewById(R.id.image_video);
        this.fEY.setDefaultErrorResource(0);
        this.fEY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fEY.setEvent(this.fFg);
        this.fEY.setGifIconSupport(false);
        this.fFc = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fEZ = (ImageView) findViewById(R.id.image_video_play);
        this.aae = new TbCyberVideoView(getContext());
        this.aae.setStageType("2003");
        bEK();
        this.aae.setOnErrorListener(this.emx);
        this.aae.setOnSurfaceDestroyedListener(this.fFk);
        this.fFd = findViewById(R.id.auto_video_black_mask);
        this.fFa = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fFb = findViewById(R.id.auto_video_error_background);
        this.fEX = (TextView) findViewById(R.id.text_video_duration);
        this.fFe = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bEK() {
        if (this.aae != null && this.aae.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fEW.addView(this.aae.getView(), 0);
            this.aae.getView().setLayoutParams(layoutParams);
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
        if (this.fEZ != null && this.fEY != null && this.fFd != null && this.fFc != null && this.fFb != null && this.fFa != null) {
            if (z || this.fFf != i) {
                this.fFf = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFj);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFi);
                this.fEZ.setVisibility(0);
                this.fEY.clearAnimation();
                this.fEY.setVisibility(0);
                this.fFd.setVisibility(0);
                this.fFc.dwD();
                this.fFb.setVisibility(8);
                this.fFa.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.agB == null || this.agB.blC() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bEL() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFi);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFj);
    }

    private void d(VideoInfo videoInfo) {
        bEL();
        if (this.fEY != null && this.fEW != null && this.aae != null) {
            if (k.biL().isShowImages() && this.agB != null && videoInfo != null) {
                this.fEW.setVisibility(0);
                this.fEY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fEY.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                }
                this.fEX.setText(au.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fFe.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), au.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fEW.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fEZ, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fFa, R.color.CAM_X0101);
            ap.setViewTextColor(this.fEX, R.color.CAM_X0101);
            ap.setViewTextColor(this.fFe, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fFb, R.color.common_color_10014);
            if (this.fFa != null) {
                this.fFa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bx bxVar, VideoInfo videoInfo) {
        if (bxVar != null) {
            this.agB = bxVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bEL();
        w(true, 1);
        if (this.aae != null) {
            this.aae.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fEW;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.aae == null) {
            return 0;
        }
        return this.aae.getCurrentPosition();
    }
}
