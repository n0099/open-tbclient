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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.m;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private TbCyberVideoView YH;
    private bv aeA;
    private CyberPlayerManager.OnErrorListener dCy;
    private ViewTreeObserver.OnGlobalLayoutListener eRA;
    private Runnable eRB;
    private Runnable eRC;
    private TbCyberVideoView.a eRD;
    public FrameLayout eRp;
    private TextView eRq;
    private TbImageView eRr;
    private ImageView eRs;
    private TextView eRt;
    private View eRu;
    private m eRv;
    private View eRw;
    private TextView eRx;
    private int eRy;
    private TbImageView.a eRz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eRy = 1;
        this.eRz = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.eRr != null) {
                    FrsBaseVideoView.this.eRr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.eRA = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.eRp != null && FrsBaseVideoView.this.eRp.getLayoutParams() != null && FrsBaseVideoView.this.eRp.getVisibility() != 8) {
                    FrsBaseVideoView.this.eRp.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.eRp.getLayoutParams();
                    if (FrsBaseVideoView.this.eRp.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.eRp.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.eRp.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eRB = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.YH != null && !FrsBaseVideoView.this.YH.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.eRC = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.eRp = (FrameLayout) findViewById(R.id.frame_video);
        this.eRp.setOnClickListener(this);
        this.eRp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.eRp != null) {
                    FrsBaseVideoView.this.eRp.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.eRA);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.eRp != null) {
                    FrsBaseVideoView.this.eRp.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.eRA);
                }
            }
        });
        this.eRr = (TbImageView) findViewById(R.id.image_video);
        this.eRr.setDefaultErrorResource(0);
        this.eRr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eRr.setEvent(this.eRz);
        this.eRr.setGifIconSupport(false);
        this.eRv = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eRs = (ImageView) findViewById(R.id.image_video_play);
        this.YH = new TbCyberVideoView(getContext());
        bos();
        this.YH.setOnErrorListener(this.dCy);
        this.YH.setOnSurfaceDestroyedListener(this.eRD);
        this.eRw = findViewById(R.id.auto_video_black_mask);
        this.eRt = (TextView) findViewById(R.id.auto_video_error_tips);
        this.eRu = findViewById(R.id.auto_video_error_background);
        this.eRq = (TextView) findViewById(R.id.text_video_duration);
        this.eRx = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bos() {
        if (this.YH != null && this.YH.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.eRp.addView(this.YH.getView(), 0);
            this.YH.getView().setLayoutParams(layoutParams);
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
        if (this.eRs != null && this.eRr != null && this.eRw != null && this.eRv != null && this.eRu != null && this.eRt != null) {
            if (z || this.eRy != i) {
                this.eRy = i;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRC);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRB);
                this.eRs.setVisibility(0);
                this.eRr.clearAnimation();
                this.eRr.setVisibility(0);
                this.eRw.setVisibility(0);
                this.eRv.cYX();
                this.eRu.setVisibility(8);
                this.eRt.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.aeA == null || this.aeA.aWl() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bot() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRB);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eRC);
    }

    private void d(VideoInfo videoInfo) {
        bot();
        if (this.eRr != null && this.eRp != null && this.YH != null) {
            if (k.aTv().isShowImages() && this.aeA != null && videoInfo != null) {
                this.eRp.setVisibility(0);
                this.eRr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.eRr.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.eRq.setText(as.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.eRx.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), as.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.eRp.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.eRs, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.eRt, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRq, R.color.cp_cont_a);
            ao.setViewTextColor(this.eRx, R.color.cp_cont_a);
            ao.setBackgroundColor(this.eRu, R.color.common_color_10014);
            if (this.eRt != null) {
                this.eRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bv bvVar, VideoInfo videoInfo) {
        if (bvVar != null) {
            this.aeA = bvVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bot();
        v(true, 1);
        if (this.YH != null) {
            this.YH.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.eRp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.YH == null) {
            return 0;
        }
        return this.YH.getCurrentPosition();
    }
}
