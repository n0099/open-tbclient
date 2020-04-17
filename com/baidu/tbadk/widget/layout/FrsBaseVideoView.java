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
    private QuickVideoView Xb;
    private bj adG;
    private g.b emA;
    private ViewTreeObserver.OnGlobalLayoutListener emB;
    private Runnable emC;
    private Runnable emD;
    private QuickVideoView.b emE;
    public FrameLayout emp;
    private TextView emq;
    private TbImageView emr;
    private ImageView ems;
    private TextView emt;
    private View emu;
    private w emv;
    private View emw;
    private TextView emx;
    private int emy;
    private TbImageView.a emz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.emy = 1;
        this.emz = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.emr != null) {
                    FrsBaseVideoView.this.emr.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.q(true, 4);
                return true;
            }
        };
        this.emB = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.emp != null && FrsBaseVideoView.this.emp.getLayoutParams() != null && FrsBaseVideoView.this.emp.getVisibility() != 8) {
                    FrsBaseVideoView.this.emp.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.emp.getLayoutParams();
                    if (FrsBaseVideoView.this.emp.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.emp.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.emp.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.emC = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Xb != null && !FrsBaseVideoView.this.Xb.isPlaying()) {
                    FrsBaseVideoView.this.q(true, 1);
                }
            }
        };
        this.emD = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.q(true, 4);
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.emp = (FrameLayout) findViewById(R.id.frame_video);
        this.emp.setOnClickListener(this);
        this.emp.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.emp != null) {
                    FrsBaseVideoView.this.emp.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.emB);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.emp != null) {
                    FrsBaseVideoView.this.emp.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.emB);
                }
            }
        });
        this.emr = (TbImageView) findViewById(R.id.image_video);
        this.emr.setDefaultErrorResource(0);
        this.emr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.emr.setEvent(this.emz);
        this.emr.setGifIconSupport(false);
        this.emv = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.ems = (ImageView) findViewById(R.id.image_video_play);
        this.Xb = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Xb.setOnErrorListener(this.emA);
        this.Xb.setOnSurfaceDestroyedListener(this.emE);
        this.emw = findViewById(R.id.auto_video_black_mask);
        this.emt = (TextView) findViewById(R.id.auto_video_error_tips);
        this.emu = findViewById(R.id.auto_video_error_background);
        this.emq = (TextView) findViewById(R.id.text_video_duration);
        this.emx = (TextView) findViewById(R.id.text_video_play_count);
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
    public void q(boolean z, int i) {
        if (this.ems != null && this.emr != null && this.emw != null && this.emv != null && this.emu != null && this.emt != null) {
            if (z || this.emy != i) {
                this.emy = i;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emD);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emC);
                this.ems.setVisibility(0);
                this.emr.clearAnimation();
                this.emr.setVisibility(0);
                this.emw.setVisibility(0);
                this.emv.cKo();
                this.emu.setVisibility(8);
                this.emt.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.adG == null || this.adG.aKE() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bbR() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emC);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emD);
    }

    private void d(VideoInfo videoInfo) {
        bbR();
        if (this.emr != null && this.emp != null && this.Xb != null) {
            if (i.aIe().isShowImages() && this.adG != null && videoInfo != null) {
                this.emp.setVisibility(0);
                this.emr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.emr.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    q(true, 4);
                }
                this.emq.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.emx.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.emp.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.ems, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.emt, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emx, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.emu, R.color.common_color_10014);
            if (this.emt != null) {
                this.emt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bj bjVar, VideoInfo videoInfo) {
        if (bjVar != null) {
            this.adG = bjVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bbR();
        q(true, 1);
        if (this.Xb != null) {
            this.Xb.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.emp;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Xb == null) {
            return 0;
        }
        return this.Xb.getCurrentPosition();
    }
}
