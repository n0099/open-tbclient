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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.m;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private TbCyberVideoView abI;
    private bz ahu;
    private CyberPlayerManager.OnErrorListener eyu;
    public FrameLayout fRF;
    private TextView fRG;
    private TbImageView fRH;
    private ImageView fRI;
    private TextView fRJ;
    private View fRK;
    private m fRL;
    private View fRM;
    private TextView fRN;
    private int fRO;
    private TbImageView.b fRP;
    private ViewTreeObserver.OnGlobalLayoutListener fRQ;
    private Runnable fRR;
    private Runnable fRS;
    private TbCyberVideoView.a fRT;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fRO = 1;
        this.fRP = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fRH != null) {
                    FrsBaseVideoView.this.fRH.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.fRQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fRF != null && FrsBaseVideoView.this.fRF.getLayoutParams() != null && FrsBaseVideoView.this.fRF.getVisibility() != 8) {
                    FrsBaseVideoView.this.fRF.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fRF.getLayoutParams();
                    if (FrsBaseVideoView.this.fRF.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fRF.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fRF.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fRR = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.abI != null && !FrsBaseVideoView.this.abI.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fRS = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fRF = (FrameLayout) findViewById(R.id.frame_video);
        this.fRF.setOnClickListener(this);
        this.fRF.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fRF != null) {
                    FrsBaseVideoView.this.fRF.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fRQ);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fRF != null) {
                    FrsBaseVideoView.this.fRF.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fRQ);
                }
            }
        });
        this.fRH = (TbImageView) findViewById(R.id.image_video);
        this.fRH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fRH.setEvent(this.fRP);
        this.fRH.setGifIconSupport(false);
        this.fRL = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fRI = (ImageView) findViewById(R.id.image_video_play);
        this.abI = new TbCyberVideoView(getContext());
        this.abI.setStageType("2003");
        bGO();
        this.abI.setOnErrorListener(this.eyu);
        this.abI.setOnSurfaceDestroyedListener(this.fRT);
        this.fRM = findViewById(R.id.auto_video_black_mask);
        this.fRJ = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fRK = findViewById(R.id.auto_video_error_background);
        this.fRG = (TextView) findViewById(R.id.text_video_duration);
        this.fRN = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bGO() {
        if (this.abI != null && this.abI.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fRF.addView(this.abI.getView(), 0);
            this.abI.getView().setLayoutParams(layoutParams);
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
        if (this.fRI != null && this.fRH != null && this.fRM != null && this.fRL != null && this.fRK != null && this.fRJ != null) {
            if (z || this.fRO != i) {
                this.fRO = i;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRS);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRR);
                this.fRI.setVisibility(0);
                this.fRH.clearAnimation();
                this.fRH.setVisibility(0);
                this.fRM.setVisibility(0);
                this.fRL.dxU();
                this.fRK.setVisibility(8);
                this.fRJ.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.ahu == null || this.ahu.bnx() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bGP() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRR);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fRS);
    }

    private void d(VideoInfo videoInfo) {
        bGP();
        if (this.fRH != null && this.fRF != null && this.abI != null) {
            if (k.bkB().isShowImages() && this.ahu != null && videoInfo != null) {
                this.fRF.setVisibility(0);
                this.fRH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fRH.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.fRG.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fRN.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fRF.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.fRI, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.fRJ, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRG, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRN, R.color.CAM_X0101);
            ao.setBackgroundColor(this.fRK, R.color.common_color_10014);
            if (this.fRJ != null) {
                this.fRJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bz bzVar, VideoInfo videoInfo) {
        if (bzVar != null) {
            this.ahu = bzVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bGP();
        v(true, 1);
        if (this.abI != null) {
            this.abI.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fRF;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abI == null) {
            return 0;
        }
        return this.abI.getCurrentPosition();
    }
}
