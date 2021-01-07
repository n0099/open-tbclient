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
    private TbCyberVideoView abK;
    private bz aim;
    private CyberPlayerManager.OnErrorListener eDg;
    private TbCyberVideoView.a fWA;
    public FrameLayout fWm;
    private TextView fWn;
    private TbImageView fWo;
    private ImageView fWp;
    private TextView fWq;
    private View fWr;
    private m fWs;
    private View fWt;
    private TextView fWu;
    private int fWv;
    private TbImageView.b fWw;
    private ViewTreeObserver.OnGlobalLayoutListener fWx;
    private Runnable fWy;
    private Runnable fWz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fWv = 1;
        this.fWw = new TbImageView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fWo != null) {
                    FrsBaseVideoView.this.fWo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.fWx = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fWm != null && FrsBaseVideoView.this.fWm.getLayoutParams() != null && FrsBaseVideoView.this.fWm.getVisibility() != 8) {
                    FrsBaseVideoView.this.fWm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fWm.getLayoutParams();
                    if (FrsBaseVideoView.this.fWm.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fWm.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fWm.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fWy = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.abK != null && !FrsBaseVideoView.this.abK.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fWz = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fWm = (FrameLayout) findViewById(R.id.frame_video);
        this.fWm.setOnClickListener(this);
        this.fWm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fWm != null) {
                    FrsBaseVideoView.this.fWm.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fWx);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fWm != null) {
                    FrsBaseVideoView.this.fWm.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fWx);
                }
            }
        });
        this.fWo = (TbImageView) findViewById(R.id.image_video);
        this.fWo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fWo.setEvent(this.fWw);
        this.fWo.setGifIconSupport(false);
        this.fWs = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fWp = (ImageView) findViewById(R.id.image_video_play);
        this.abK = new TbCyberVideoView(getContext());
        this.abK.setStageType("2003");
        bKG();
        this.abK.setOnErrorListener(this.eDg);
        this.abK.setOnSurfaceDestroyedListener(this.fWA);
        this.fWt = findViewById(R.id.auto_video_black_mask);
        this.fWq = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fWr = findViewById(R.id.auto_video_error_background);
        this.fWn = (TextView) findViewById(R.id.text_video_duration);
        this.fWu = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bKG() {
        if (this.abK != null && this.abK.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fWm.addView(this.abK.getView(), 0);
            this.abK.getView().setLayoutParams(layoutParams);
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
        if (this.fWp != null && this.fWo != null && this.fWt != null && this.fWs != null && this.fWr != null && this.fWq != null) {
            if (z || this.fWv != i) {
                this.fWv = i;
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWz);
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWy);
                this.fWp.setVisibility(0);
                this.fWo.clearAnimation();
                this.fWo.setVisibility(0);
                this.fWt.setVisibility(0);
                this.fWs.dBM();
                this.fWr.setVisibility(8);
                this.fWq.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.aim == null || this.aim.brr() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bKH() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWy);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fWz);
    }

    private void d(VideoInfo videoInfo) {
        bKH();
        if (this.fWo != null && this.fWm != null && this.abK != null) {
            if (k.bov().isShowImages() && this.aim != null && videoInfo != null) {
                this.fWm.setVisibility(0);
                this.fWo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fWo.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.fWn.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fWu.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fWm.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ao.setImageResource(this.fWp, R.drawable.btn_icon_play_video_n);
            ao.setViewTextColor(this.fWq, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWn, R.color.CAM_X0101);
            ao.setViewTextColor(this.fWu, R.color.CAM_X0101);
            ao.setBackgroundColor(this.fWr, R.color.common_color_10014);
            if (this.fWq != null) {
                this.fWq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ao.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bz bzVar, VideoInfo videoInfo) {
        if (bzVar != null) {
            this.aim = bzVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bKH();
        v(true, 1);
        if (this.abK != null) {
            this.abK.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fWm;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.abK == null) {
            return 0;
        }
        return this.abK.getCurrentPosition();
    }
}
