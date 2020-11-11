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
    private CyberPlayerManager.OnErrorListener eoh;
    private m fFA;
    private View fFB;
    private TextView fFC;
    private int fFD;
    private TbImageView.a fFE;
    private ViewTreeObserver.OnGlobalLayoutListener fFF;
    private Runnable fFG;
    private Runnable fFH;
    private TbCyberVideoView.a fFI;
    public FrameLayout fFu;
    private TextView fFv;
    private TbImageView fFw;
    private ImageView fFx;
    private TextView fFy;
    private View fFz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fFD = 1;
        this.fFE = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.fFw != null) {
                    FrsBaseVideoView.this.fFw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.w(true, 4);
                return true;
            }
        };
        this.fFF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.fFu != null && FrsBaseVideoView.this.fFu.getLayoutParams() != null && FrsBaseVideoView.this.fFu.getVisibility() != 8) {
                    FrsBaseVideoView.this.fFu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.fFu.getLayoutParams();
                    if (FrsBaseVideoView.this.fFu.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.fFu.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.fFu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.fFG = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.ZY != null && !FrsBaseVideoView.this.ZY.isPlaying()) {
                    FrsBaseVideoView.this.w(true, 1);
                }
            }
        };
        this.fFH = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.w(true, 4);
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.fFu = (FrameLayout) findViewById(R.id.frame_video);
        this.fFu.setOnClickListener(this);
        this.fFu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.fFu != null) {
                    FrsBaseVideoView.this.fFu.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.fFF);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.fFu != null) {
                    FrsBaseVideoView.this.fFu.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.fFF);
                }
            }
        });
        this.fFw = (TbImageView) findViewById(R.id.image_video);
        this.fFw.setDefaultErrorResource(0);
        this.fFw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fFw.setEvent(this.fFE);
        this.fFw.setGifIconSupport(false);
        this.fFA = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fFx = (ImageView) findViewById(R.id.image_video_play);
        this.ZY = new TbCyberVideoView(getContext());
        this.ZY.setStageType("2003");
        bFr();
        this.ZY.setOnErrorListener(this.eoh);
        this.ZY.setOnSurfaceDestroyedListener(this.fFI);
        this.fFB = findViewById(R.id.auto_video_black_mask);
        this.fFy = (TextView) findViewById(R.id.auto_video_error_tips);
        this.fFz = findViewById(R.id.auto_video_error_background);
        this.fFv = (TextView) findViewById(R.id.text_video_duration);
        this.fFC = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void bFr() {
        if (this.ZY != null && this.ZY.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fFu.addView(this.ZY.getView(), 0);
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
        if (this.fFx != null && this.fFw != null && this.fFB != null && this.fFA != null && this.fFz != null && this.fFy != null) {
            if (z || this.fFD != i) {
                this.fFD = i;
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFH);
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFG);
                this.fFx.setVisibility(0);
                this.fFw.clearAnimation();
                this.fFw.setVisibility(0);
                this.fFB.setVisibility(0);
                this.fFA.dxd();
                this.fFz.setVisibility(8);
                this.fFy.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.agx == null || this.agx.bmA() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bFs() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFG);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fFH);
    }

    private void d(VideoInfo videoInfo) {
        bFs();
        if (this.fFw != null && this.fFu != null && this.ZY != null) {
            if (k.bjH().isShowImages() && this.agx != null && videoInfo != null) {
                this.fFu.setVisibility(0);
                this.fFw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.fFw.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    w(true, 4);
                }
                this.fFv.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.fFC.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.fFu.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.fFx, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.fFy, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFv, R.color.cp_cont_a);
            ap.setViewTextColor(this.fFC, R.color.cp_cont_a);
            ap.setBackgroundColor(this.fFz, R.color.common_color_10014);
            if (this.fFy != null) {
                this.fFy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        bFs();
        w(true, 1);
        if (this.ZY != null) {
            this.ZY.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.fFu;
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
