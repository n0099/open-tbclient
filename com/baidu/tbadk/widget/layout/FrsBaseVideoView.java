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
    public FrameLayout eBk;
    private TextView eBl;
    private TbImageView eBm;
    private ImageView eBn;
    private TextView eBo;
    private View eBp;
    private w eBq;
    private View eBr;
    private TextView eBs;
    private int eBt;
    private TbImageView.a eBu;
    private g.b eBv;
    private ViewTreeObserver.OnGlobalLayoutListener eBw;
    private Runnable eBx;
    private Runnable eBy;
    private QuickVideoView.b eBz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eBt = 1;
        this.eBu = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.eBm != null) {
                    FrsBaseVideoView.this.eBm.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.t(true, 4);
                return true;
            }
        };
        this.eBw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.eBk != null && FrsBaseVideoView.this.eBk.getLayoutParams() != null && FrsBaseVideoView.this.eBk.getVisibility() != 8) {
                    FrsBaseVideoView.this.eBk.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.eBk.getLayoutParams();
                    if (FrsBaseVideoView.this.eBk.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.eBk.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.eBk.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eBx = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Xt != null && !FrsBaseVideoView.this.Xt.isPlaying()) {
                    FrsBaseVideoView.this.t(true, 1);
                }
            }
        };
        this.eBy = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.t(true, 4);
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.eBk = (FrameLayout) findViewById(R.id.frame_video);
        this.eBk.setOnClickListener(this);
        this.eBk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.eBk != null) {
                    FrsBaseVideoView.this.eBk.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.eBw);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.eBk != null) {
                    FrsBaseVideoView.this.eBk.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.eBw);
                }
            }
        });
        this.eBm = (TbImageView) findViewById(R.id.image_video);
        this.eBm.setDefaultErrorResource(0);
        this.eBm.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eBm.setEvent(this.eBu);
        this.eBm.setGifIconSupport(false);
        this.eBq = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eBn = (ImageView) findViewById(R.id.image_video_play);
        this.Xt = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Xt.setOnErrorListener(this.eBv);
        this.Xt.setOnSurfaceDestroyedListener(this.eBz);
        this.eBr = findViewById(R.id.auto_video_black_mask);
        this.eBo = (TextView) findViewById(R.id.auto_video_error_tips);
        this.eBp = findViewById(R.id.auto_video_error_background);
        this.eBl = (TextView) findViewById(R.id.text_video_duration);
        this.eBs = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.eBn != null && this.eBm != null && this.eBr != null && this.eBq != null && this.eBp != null && this.eBo != null) {
            if (z || this.eBt != i) {
                this.eBt = i;
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBy);
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBx);
                this.eBn.setVisibility(0);
                this.eBm.clearAnimation();
                this.eBm.setVisibility(0);
                this.eBr.setVisibility(0);
                this.eBq.cRB();
                this.eBp.setVisibility(8);
                this.eBo.setVisibility(8);
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

    private void bic() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBx);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eBy);
    }

    private void d(VideoInfo videoInfo) {
        bic();
        if (this.eBm != null && this.eBk != null && this.Xt != null) {
            if (k.aNQ().isShowImages() && this.aee != null && videoInfo != null) {
                this.eBk.setVisibility(0);
                this.eBm.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.eBm.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    t(true, 4);
                }
                this.eBl.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.eBs.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.eBk.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.eBn, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.eBo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBl, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eBs, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eBp, R.color.common_color_10014);
            if (this.eBo != null) {
                this.eBo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        bic();
        t(true, 1);
        if (this.Xt != null) {
            this.Xt.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.eBk;
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
