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
    private TbCyberVideoView abD;
    private cb ahi;
    private CyberPlayerManager.OnErrorListener eAB;
    public FrameLayout fTU;
    private TextView fTV;
    private TbImageView fTW;
    private ImageView fTX;
    private TextView fTY;
    private View fTZ;
    private m fUa;
    private View fUb;
    private TextView fUc;
    private int fUd;
    private TbImageView.b fUe;
    private ViewTreeObserver.OnGlobalLayoutListener fUf;
    private Runnable fUg;
    private Runnable fUh;
    private TbCyberVideoView.a fUi;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fUd = 1;
        this.fUe = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fTW != null) {
                    FrsBaseVideoView.this.fTW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.fUf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fTU != null && FrsBaseVideoView.this.fTU.getLayoutParams() != null && FrsBaseVideoView.this.fTU.getVisibility() != 8) {
                    FrsBaseVideoView.this.fTU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fTU.getLayoutParams();
                    if (FrsBaseVideoView.this.fTU.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fTU.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fTU.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.abD != null && !FrsBaseVideoView.this.abD.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fUh = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fTU = (FrameLayout) findViewById(R.id.frame_video);
        this.fTU.setOnClickListener(this);
        this.fTU.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fTU != null) {
                    FrsBaseVideoView.this.fTU.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fUf);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fTU != null) {
                    FrsBaseVideoView.this.fTU.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fUf);
                }
            }
        });
        this.fTW = (TbImageView) findViewById(R.id.image_video);
        this.fTW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fTW.setEvent(this.fUe);
        this.fTW.setGifIconSupport(false);
        this.fUa = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fTX = (ImageView) findViewById(R.id.image_video_play);
        this.abD = new TbCyberVideoView(getContext());
        this.abD.setStageType("2003");
        bHi();
        this.abD.setOnErrorListener(this.eAB);
        this.abD.setOnSurfaceDestroyedListener(this.fUi);
        this.fUb = findViewById(R.id.auto_video_black_mask);
        this.fTY = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fTZ = findViewById(R.id.auto_video_error_background);
        this.fTV = (TextView) findViewById(R.id.text_video_duration);
        this.fUc = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bHi() {
        if (this.abD != null && this.abD.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fTU.addView(this.abD.getView(), 0);
            this.abD.getView().setLayoutParams(layoutParams);
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
        if (this.fTX != null && this.fTW != null && this.fUb != null && this.fUa != null && this.fTZ != null && this.fTY != null) {
            if (z || this.fUd != i) {
                this.fUd = i;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
                this.fTX.setVisibility(0);
                this.fTW.clearAnimation();
                this.fTW.setVisibility(0);
                this.fUb.setVisibility(0);
                this.fUa.dAc();
                this.fTZ.setVisibility(8);
                this.fTY.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.ahi == null || this.ahi.bnQ() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bHj() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUg);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fUh);
    }

    private void d(VideoInfo videoInfo) {
        bHj();
        if (this.fTW != null && this.fTU != null && this.abD != null) {
            if (k.bkT().isShowImages() && this.ahi != null && videoInfo != null) {
                this.fTU.setVisibility(0);
                this.fTW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fTW.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.fTV.setText(au.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fUc.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), au.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fTU.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fTX, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fTY, R.color.CAM_X0101);
            ap.setViewTextColor(this.fTV, R.color.CAM_X0101);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
            ap.setBackgroundColor(this.fTZ, R.color.common_color_10014);
            if (this.fTY != null) {
                this.fTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(cb cbVar, VideoInfo videoInfo) {
        if (cbVar != null) {
            this.ahi = cbVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bHj();
        v(true, 1);
        if (this.abD != null) {
            this.abD.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fTU;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abD == null) {
            return 0;
        }
        return this.abD.getCurrentPosition();
    }
}
