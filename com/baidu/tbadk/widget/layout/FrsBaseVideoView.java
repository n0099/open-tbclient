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
import com.baidu.tbadk.core.data.cb;
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
    private TbCyberVideoView acZ;
    private cb aiB;
    private CyberPlayerManager.OnErrorListener eCc;
    private m fVA;
    private View fVB;
    private TextView fVC;
    private int fVD;
    private TbImageView.b fVE;
    private ViewTreeObserver.OnGlobalLayoutListener fVF;
    private Runnable fVG;
    private Runnable fVH;
    private TbCyberVideoView.a fVI;
    public FrameLayout fVu;
    private TextView fVv;
    private TbImageView fVw;
    private ImageView fVx;
    private TextView fVy;
    private View fVz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fVD = 1;
        this.fVE = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fVw != null) {
                    FrsBaseVideoView.this.fVw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.fVF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fVu != null && FrsBaseVideoView.this.fVu.getLayoutParams() != null && FrsBaseVideoView.this.fVu.getVisibility() != 8) {
                    FrsBaseVideoView.this.fVu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fVu.getLayoutParams();
                    if (FrsBaseVideoView.this.fVu.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fVu.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fVu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fVG = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.acZ != null && !FrsBaseVideoView.this.acZ.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fVH = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fVu = (FrameLayout) findViewById(R.id.frame_video);
        this.fVu.setOnClickListener(this);
        this.fVu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fVu != null) {
                    FrsBaseVideoView.this.fVu.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fVF);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fVu != null) {
                    FrsBaseVideoView.this.fVu.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fVF);
                }
            }
        });
        this.fVw = (TbImageView) findViewById(R.id.image_video);
        this.fVw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fVw.setEvent(this.fVE);
        this.fVw.setGifIconSupport(false);
        this.fVA = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fVx = (ImageView) findViewById(R.id.image_video_play);
        this.acZ = new TbCyberVideoView(getContext());
        this.acZ.setStageType("2003");
        bHm();
        this.acZ.setOnErrorListener(this.eCc);
        this.acZ.setOnSurfaceDestroyedListener(this.fVI);
        this.fVB = findViewById(R.id.auto_video_black_mask);
        this.fVy = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fVz = findViewById(R.id.auto_video_error_background);
        this.fVv = (TextView) findViewById(R.id.text_video_duration);
        this.fVC = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bHm() {
        if (this.acZ != null && this.acZ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fVu.addView(this.acZ.getView(), 0);
            this.acZ.getView().setLayoutParams(layoutParams);
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
        if (this.fVx != null && this.fVw != null && this.fVB != null && this.fVA != null && this.fVz != null && this.fVy != null) {
            if (z || this.fVD != i) {
                this.fVD = i;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVH);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVG);
                this.fVx.setVisibility(0);
                this.fVw.clearAnimation();
                this.fVw.setVisibility(0);
                this.fVB.setVisibility(0);
                this.fVA.dAr();
                this.fVz.setVisibility(8);
                this.fVy.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.aiB == null || this.aiB.bnS() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bHn() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVG);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fVH);
    }

    private void d(VideoInfo videoInfo) {
        bHn();
        if (this.fVw != null && this.fVu != null && this.acZ != null) {
            if (k.bkV().isShowImages() && this.aiB != null && videoInfo != null) {
                this.fVu.setVisibility(0);
                this.fVw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fVw.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.fVv.setText(au.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fVC.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), au.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fVu.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fVx, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fVy, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVv, R.color.CAM_X0101);
            ap.setViewTextColor(this.fVC, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fVz, R.color.common_color_10014);
            if (this.fVy != null) {
                this.fVy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(cb cbVar, VideoInfo videoInfo) {
        if (cbVar != null) {
            this.aiB = cbVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bHn();
        v(true, 1);
        if (this.acZ != null) {
            this.acZ.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fVu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.acZ == null) {
            return 0;
        }
        return this.acZ.getCurrentPosition();
    }
}
