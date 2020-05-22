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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
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
    private QuickVideoView Xt;
    private bk aee;
    public FrameLayout eAZ;
    private TextView eBa;
    private TbImageView eBb;
    private ImageView eBc;
    private TextView eBd;
    private View eBe;
    private w eBf;
    private View eBg;
    private TextView eBh;
    private int eBi;
    private TbImageView.a eBj;
    private g.b eBk;
    private ViewTreeObserver.OnGlobalLayoutListener eBl;
    private Runnable eBm;
    private Runnable eBn;
    private QuickVideoView.b eBo;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eBi = 1;
        this.eBj = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.eBb != null) {
                    FrsBaseVideoView.this.eBb.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.t(true, 4);
                return true;
            }
        };
        this.eBl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.eAZ != null && FrsBaseVideoView.this.eAZ.getLayoutParams() != null && FrsBaseVideoView.this.eAZ.getVisibility() != 8) {
                    FrsBaseVideoView.this.eAZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.eAZ.getLayoutParams();
                    if (FrsBaseVideoView.this.eAZ.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.eAZ.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.eAZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eBm = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Xt != null && !FrsBaseVideoView.this.Xt.isPlaying()) {
                    FrsBaseVideoView.this.t(true, 1);
                }
            }
        };
        this.eBn = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.t(true, 4);
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.eAZ = (FrameLayout) findViewById(R.id.frame_video);
        this.eAZ.setOnClickListener(this);
        this.eAZ.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.eAZ != null) {
                    FrsBaseVideoView.this.eAZ.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.eBl);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.eAZ != null) {
                    FrsBaseVideoView.this.eAZ.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.eBl);
                }
            }
        });
        this.eBb = (TbImageView) findViewById(R.id.image_video);
        this.eBb.setDefaultErrorResource(0);
        this.eBb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eBb.setEvent(this.eBj);
        this.eBb.setGifIconSupport(false);
        this.eBf = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eBc = (ImageView) findViewById(R.id.image_video_play);
        this.Xt = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Xt.setOnErrorListener(this.eBk);
        this.Xt.setOnSurfaceDestroyedListener(this.eBo);
        this.eBg = findViewById(R.id.auto_video_black_mask);
        this.eBd = (TextView) findViewById(R.id.auto_video_error_tips);
        this.eBe = findViewById(R.id.auto_video_error_background);
        this.eBa = (TextView) findViewById(R.id.text_video_duration);
        this.eBh = (TextView) findViewById(R.id.text_video_play_count);
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
    public void t(boolean z, int i) {
        if (this.eBc != null && this.eBb != null && this.eBg != null && this.eBf != null && this.eBe != null && this.eBd != null) {
            if (z || this.eBi != i) {
                this.eBi = i;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBn);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBm);
                this.eBc.setVisibility(0);
                this.eBb.clearAnimation();
                this.eBb.setVisibility(0);
                this.eBg.setVisibility(0);
                this.eBf.cRl();
                this.eBe.setVisibility(8);
                this.eBd.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.aee == null || this.aee.aQx() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bia() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBm);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBn);
    }

    private void d(VideoInfo videoInfo) {
        bia();
        if (this.eBb != null && this.eAZ != null && this.Xt != null) {
            if (k.aNQ().isShowImages() && this.aee != null && videoInfo != null) {
                this.eAZ.setVisibility(0);
                this.eBb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.eBb.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    t(true, 4);
                }
                this.eBa.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.eBh.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.eAZ.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.eBc, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.eBd, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBa, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBh, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eBe, R.color.common_color_10014);
            if (this.eBd != null) {
                this.eBd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bk bkVar, VideoInfo videoInfo) {
        if (bkVar != null) {
            this.aee = bkVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bia();
        t(true, 1);
        if (this.Xt != null) {
            this.Xt.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.eAZ;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Xt == null) {
            return 0;
        }
        return this.Xt.getCurrentPosition();
    }
}
