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
    private TbCyberVideoView ZH;
    private bw agf;
    private CyberPlayerManager.OnErrorListener dNP;
    public FrameLayout feS;
    private TextView feT;
    private TbImageView feU;
    private ImageView feV;
    private TextView feW;
    private View feX;
    private m feY;
    private View feZ;
    private TextView ffa;
    private int ffb;
    private TbImageView.a ffc;
    private ViewTreeObserver.OnGlobalLayoutListener ffd;
    private Runnable ffe;
    private Runnable fff;
    private TbCyberVideoView.a ffg;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ffb = 1;
        this.ffc = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.feU != null) {
                    FrsBaseVideoView.this.feU.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.ffd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.feS != null && FrsBaseVideoView.this.feS.getLayoutParams() != null && FrsBaseVideoView.this.feS.getVisibility() != 8) {
                    FrsBaseVideoView.this.feS.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.feS.getLayoutParams();
                    if (FrsBaseVideoView.this.feS.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.feS.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.feS.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.ffe = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.ZH != null && !FrsBaseVideoView.this.ZH.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.fff = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.feS = (FrameLayout) findViewById(R.id.frame_video);
        this.feS.setOnClickListener(this);
        this.feS.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.feS != null) {
                    FrsBaseVideoView.this.feS.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.ffd);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.feS != null) {
                    FrsBaseVideoView.this.feS.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.ffd);
                }
            }
        });
        this.feU = (TbImageView) findViewById(R.id.image_video);
        this.feU.setDefaultErrorResource(0);
        this.feU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.feU.setEvent(this.ffc);
        this.feU.setGifIconSupport(false);
        this.feY = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.feV = (ImageView) findViewById(R.id.image_video_play);
        this.ZH = new TbCyberVideoView(getContext());
        this.ZH.setStageType("2003");
        byp();
        this.ZH.setOnErrorListener(this.dNP);
        this.ZH.setOnSurfaceDestroyedListener(this.ffg);
        this.feZ = findViewById(R.id.auto_video_black_mask);
        this.feW = (TextView) findViewById(R.id.auto_video_error_tips);
        this.feX = findViewById(R.id.auto_video_error_background);
        this.feT = (TextView) findViewById(R.id.text_video_duration);
        this.ffa = (TextView) findViewById(R.id.text_video_play_count);
    }

    private void byp() {
        if (this.ZH != null && this.ZH.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.feS.addView(this.ZH.getView(), 0);
            this.ZH.getView().setLayoutParams(layoutParams);
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
        if (this.feV != null && this.feU != null && this.feZ != null && this.feY != null && this.feX != null && this.feW != null) {
            if (z || this.ffb != i) {
                this.ffb = i;
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fff);
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ffe);
                this.feV.setVisibility(0);
                this.feU.clearAnimation();
                this.feU.setVisibility(0);
                this.feZ.setVisibility(0);
                this.feY.dnJ();
                this.feX.setVisibility(8);
                this.feW.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.agf == null || this.agf.bfy() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void byq() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ffe);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fff);
    }

    private void d(VideoInfo videoInfo) {
        byq();
        if (this.feU != null && this.feS != null && this.ZH != null) {
            if (k.bcG().isShowImages() && this.agf != null && videoInfo != null) {
                this.feS.setVisibility(0);
                this.feU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.feU.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.feT.setText(at.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.ffa.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), at.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.feS.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            ap.setImageResource(this.feV, R.drawable.btn_icon_play_video_n);
            ap.setViewTextColor(this.feW, R.color.cp_cont_a);
            ap.setViewTextColor(this.feT, R.color.cp_cont_a);
            ap.setViewTextColor(this.ffa, R.color.cp_cont_a);
            ap.setBackgroundColor(this.feX, R.color.common_color_10014);
            if (this.feW != null) {
                this.feW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bw bwVar, VideoInfo videoInfo) {
        if (bwVar != null) {
            this.agf = bwVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        byq();
        v(true, 1);
        if (this.ZH != null) {
            this.ZH.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.feS;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.ZH == null) {
            return 0;
        }
        return this.ZH.getCurrentPosition();
    }
}
