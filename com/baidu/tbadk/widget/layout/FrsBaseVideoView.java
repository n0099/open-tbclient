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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private QuickVideoView DI;
    private bj KJ;
    private TbImageView dMA;
    private ImageView dMB;
    private TextView dMC;
    private View dMD;
    private w dME;
    private View dMF;
    private TextView dMG;
    private int dMH;
    private TbImageView.a dMI;
    private g.b dMJ;
    private ViewTreeObserver.OnGlobalLayoutListener dMK;
    private Runnable dML;
    private Runnable dMM;
    private QuickVideoView.b dMN;
    public FrameLayout dMy;
    private TextView dMz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMH = 1;
        this.dMI = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.dMA != null) {
                    FrsBaseVideoView.this.dMA.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.p(true, 4);
                return true;
            }
        };
        this.dMK = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.dMy != null && FrsBaseVideoView.this.dMy.getLayoutParams() != null && FrsBaseVideoView.this.dMy.getVisibility() != 8) {
                    FrsBaseVideoView.this.dMy.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.dMy.getLayoutParams();
                    if (FrsBaseVideoView.this.dMy.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.dMy.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.dMy.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dML = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.DI != null && !FrsBaseVideoView.this.DI.isPlaying()) {
                    FrsBaseVideoView.this.p(true, 1);
                }
            }
        };
        this.dMM = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.p(true, 4);
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.base_video_view, this);
        setOrientation(1);
        this.dMy = (FrameLayout) findViewById(R.id.frame_video);
        this.dMy.setOnClickListener(this);
        this.dMy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.dMy != null) {
                    FrsBaseVideoView.this.dMy.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.dMK);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.dMy != null) {
                    FrsBaseVideoView.this.dMy.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.dMK);
                }
            }
        });
        this.dMA = (TbImageView) findViewById(R.id.image_video);
        this.dMA.setDefaultErrorResource(0);
        this.dMA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dMA.setEvent(this.dMI);
        this.dMA.setGifIconSupport(false);
        this.dME = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dMB = (ImageView) findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.DI.setOnErrorListener(this.dMJ);
        this.DI.setOnSurfaceDestroyedListener(this.dMN);
        this.dMF = findViewById(R.id.auto_video_black_mask);
        this.dMC = (TextView) findViewById(R.id.auto_video_error_tips);
        this.dMD = findViewById(R.id.auto_video_error_background);
        this.dMz = (TextView) findViewById(R.id.text_video_duration);
        this.dMG = (TextView) findViewById(R.id.text_video_play_count);
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
    public void p(boolean z, int i) {
        if (this.dMB != null && this.dMA != null && this.dMF != null && this.dME != null && this.dMD != null && this.dMC != null) {
            if (z || this.dMH != i) {
                this.dMH = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMM);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dML);
                this.dMB.setVisibility(0);
                this.dMA.clearAnimation();
                this.dMA.setVisibility(0);
                this.dMF.setVisibility(0);
                this.dME.czJ();
                this.dMD.setVisibility(8);
                this.dMC.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.KJ == null || this.KJ.aCr() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aTH() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dML);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMM);
    }

    private void d(VideoInfo videoInfo) {
        aTH();
        if (this.dMA != null && this.dMy != null && this.DI != null) {
            if (i.azR().isShowImages() && this.KJ != null && videoInfo != null) {
                this.dMy.setVisibility(0);
                this.dMA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dMA.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                }
                this.dMz.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.dMG.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.dMy.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMB, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dMC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMz, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMG, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMD, R.color.common_color_10014);
            if (this.dMC != null) {
                this.dMC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bj bjVar, VideoInfo videoInfo) {
        if (bjVar != null) {
            this.KJ = bjVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        aTH();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.dMy;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.DI == null) {
            return 0;
        }
        return this.DI.getCurrentPosition();
    }
}
