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
    public FrameLayout dMi;
    private TextView dMj;
    private TbImageView dMk;
    private ImageView dMl;
    private TextView dMm;
    private View dMn;
    private w dMo;
    private View dMp;
    private TextView dMq;
    private int dMr;
    private TbImageView.a dMs;
    private g.b dMt;
    private ViewTreeObserver.OnGlobalLayoutListener dMu;
    private Runnable dMv;
    private Runnable dMw;
    private QuickVideoView.b dMx;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMr = 1;
        this.dMs = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.dMk != null) {
                    FrsBaseVideoView.this.dMk.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.p(true, 4);
                return true;
            }
        };
        this.dMu = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.dMi != null && FrsBaseVideoView.this.dMi.getLayoutParams() != null && FrsBaseVideoView.this.dMi.getVisibility() != 8) {
                    FrsBaseVideoView.this.dMi.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.dMi.getLayoutParams();
                    if (FrsBaseVideoView.this.dMi.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.dMi.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.dMi.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dMv = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.DI != null && !FrsBaseVideoView.this.DI.isPlaying()) {
                    FrsBaseVideoView.this.p(true, 1);
                }
            }
        };
        this.dMw = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.p(true, 4);
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.dMi = (FrameLayout) findViewById(R.id.frame_video);
        this.dMi.setOnClickListener(this);
        this.dMi.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.dMi != null) {
                    FrsBaseVideoView.this.dMi.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.dMu);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.dMi != null) {
                    FrsBaseVideoView.this.dMi.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.dMu);
                }
            }
        });
        this.dMk = (TbImageView) findViewById(R.id.image_video);
        this.dMk.setDefaultErrorResource(0);
        this.dMk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dMk.setEvent(this.dMs);
        this.dMk.setGifIconSupport(false);
        this.dMo = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dMl = (ImageView) findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.DI.setOnErrorListener(this.dMt);
        this.DI.setOnSurfaceDestroyedListener(this.dMx);
        this.dMp = findViewById(R.id.auto_video_black_mask);
        this.dMm = (TextView) findViewById(R.id.auto_video_error_tips);
        this.dMn = findViewById(R.id.auto_video_error_background);
        this.dMj = (TextView) findViewById(R.id.text_video_duration);
        this.dMq = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.dMl != null && this.dMk != null && this.dMp != null && this.dMo != null && this.dMn != null && this.dMm != null) {
            if (z || this.dMr != i) {
                this.dMr = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMw);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMv);
                this.dMl.setVisibility(0);
                this.dMk.clearAnimation();
                this.dMk.setVisibility(0);
                this.dMp.setVisibility(0);
                this.dMo.czq();
                this.dMn.setVisibility(8);
                this.dMm.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.KJ == null || this.KJ.aCo() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aTD() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMv);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMw);
    }

    private void d(VideoInfo videoInfo) {
        aTD();
        if (this.dMk != null && this.dMi != null && this.DI != null) {
            if (i.azO().isShowImages() && this.KJ != null && videoInfo != null) {
                this.dMi.setVisibility(0);
                this.dMk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dMk.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                }
                this.dMj.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.dMq.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.dMi.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dMl, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dMm, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMq, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMn, R.color.common_color_10014);
            if (this.dMm != null) {
                this.dMm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        aTD();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.dMi;
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
