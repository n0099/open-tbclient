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
    private TbCyberVideoView ZY;
    private bw agx;
    private CyberPlayerManager.OnErrorListener ein;
    public FrameLayout fzE;
    private TextView fzF;
    private TbImageView fzG;
    private ImageView fzH;
    private TextView fzI;
    private View fzJ;
    private m fzK;
    private View fzL;
    private TextView fzM;
    private int fzN;
    private TbImageView.a fzO;
    private ViewTreeObserver.OnGlobalLayoutListener fzP;
    private Runnable fzQ;
    private Runnable fzR;
    private TbCyberVideoView.a fzS;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fzN = 1;
        this.fzO = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fzG != null) {
                    FrsBaseVideoView.this.fzG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.w(true, 4);
                return true;
            }
        };
        this.fzP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fzE != null && FrsBaseVideoView.this.fzE.getLayoutParams() != null && FrsBaseVideoView.this.fzE.getVisibility() != 8) {
                    FrsBaseVideoView.this.fzE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fzE.getLayoutParams();
                    if (FrsBaseVideoView.this.fzE.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fzE.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fzE.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fzQ = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.ZY != null && !FrsBaseVideoView.this.ZY.isPlaying()) {
                    FrsBaseVideoView.this.w(true, 1);
                }
            }
        };
        this.fzR = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.w(true, 4);
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fzE = (FrameLayout) findViewById(R.id.frame_video);
        this.fzE.setOnClickListener(this);
        this.fzE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fzE != null) {
                    FrsBaseVideoView.this.fzE.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fzP);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fzE != null) {
                    FrsBaseVideoView.this.fzE.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fzP);
                }
            }
        });
        this.fzG = (TbImageView) findViewById(R.id.image_video);
        this.fzG.setDefaultErrorResource(0);
        this.fzG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fzG.setEvent(this.fzO);
        this.fzG.setGifIconSupport(false);
        this.fzK = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fzH = (ImageView) findViewById(R.id.image_video_play);
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType("2003");
        bCS();
        this.ZY.setOnErrorListener(this.ein);
        this.ZY.setOnSurfaceDestroyedListener(this.fzS);
        this.fzL = findViewById(R.id.auto_video_black_mask);
        this.fzI = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fzJ = findViewById(R.id.auto_video_error_background);
        this.fzF = (TextView) findViewById(R.id.text_video_duration);
        this.fzM = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bCS() {
        if (this.ZY != null && this.ZY.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fzE.addView(this.ZY.getView(), 0);
            this.ZY.getView().setLayoutParams(layoutParams);
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
        if (this.fzH != null && this.fzG != null && this.fzL != null && this.fzK != null && this.fzJ != null && this.fzI != null) {
            if (z || this.fzN != i) {
                this.fzN = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzR);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzQ);
                this.fzH.setVisibility(0);
                this.fzG.clearAnimation();
                this.fzG.setVisibility(0);
                this.fzL.setVisibility(0);
                this.fzK.duB();
                this.fzJ.setVisibility(8);
                this.fzI.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.agx == null || this.agx.bka() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bCT() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzQ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fzR);
    }

    private void d(VideoInfo videoInfo) {
        bCT();
        if (this.fzG != null && this.fzE != null && this.ZY != null) {
            if (k.bhh().isShowImages() && this.agx != null && videoInfo != null) {
                this.fzE.setVisibility(0);
                this.fzG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fzG.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                }
                this.fzF.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fzM.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fzE.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fzH, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fzI, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzF, R.color.cp_cont_a);
            ap.setViewTextColor(this.fzM, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fzJ, R.color.common_color_10014);
            if (this.fzI != null) {
                this.fzI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bw bwVar, VideoInfo videoInfo) {
        if (bwVar != null) {
            this.agx = bwVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bCT();
        w(true, 1);
        if (this.ZY != null) {
            this.ZY.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fzE;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZY == null) {
            return 0;
        }
        return this.ZY.getCurrentPosition();
    }
}
