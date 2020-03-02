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
    public FrameLayout dLV;
    private TextView dLW;
    private TbImageView dLX;
    private ImageView dLY;
    private TextView dLZ;
    private View dMa;
    private w dMb;
    private View dMc;
    private TextView dMd;
    private int dMe;
    private TbImageView.a dMf;
    private g.b dMg;
    private ViewTreeObserver.OnGlobalLayoutListener dMh;
    private Runnable dMi;
    private Runnable dMj;
    private QuickVideoView.b dMk;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMe = 1;
        this.dMf = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.dLX != null) {
                    FrsBaseVideoView.this.dLX.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.p(true, 4);
                return true;
            }
        };
        this.dMh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.dLV != null && FrsBaseVideoView.this.dLV.getLayoutParams() != null && FrsBaseVideoView.this.dLV.getVisibility() != 8) {
                    FrsBaseVideoView.this.dLV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.dLV.getLayoutParams();
                    if (FrsBaseVideoView.this.dLV.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.dLV.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.dLV.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.DI != null && !FrsBaseVideoView.this.DI.isPlaying()) {
                    FrsBaseVideoView.this.p(true, 1);
                }
            }
        };
        this.dMj = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.p(true, 4);
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.dLV = (FrameLayout) findViewById(R.id.frame_video);
        this.dLV.setOnClickListener(this);
        this.dLV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.dLV != null) {
                    FrsBaseVideoView.this.dLV.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.dMh);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.dLV != null) {
                    FrsBaseVideoView.this.dLV.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.dMh);
                }
            }
        });
        this.dLX = (TbImageView) findViewById(R.id.image_video);
        this.dLX.setDefaultErrorResource(0);
        this.dLX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dLX.setEvent(this.dMf);
        this.dLX.setGifIconSupport(false);
        this.dMb = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dLY = (ImageView) findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.DI.setOnErrorListener(this.dMg);
        this.DI.setOnSurfaceDestroyedListener(this.dMk);
        this.dMc = findViewById(R.id.auto_video_black_mask);
        this.dLZ = (TextView) findViewById(R.id.auto_video_error_tips);
        this.dMa = findViewById(R.id.auto_video_error_background);
        this.dLW = (TextView) findViewById(R.id.text_video_duration);
        this.dMd = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.dLY != null && this.dLX != null && this.dMc != null && this.dMb != null && this.dMa != null && this.dLZ != null) {
            if (z || this.dMe != i) {
                this.dMe = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMj);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
                this.dLY.setVisibility(0);
                this.dLX.clearAnimation();
                this.dLX.setVisibility(0);
                this.dMc.setVisibility(0);
                this.dMb.czp();
                this.dMa.setVisibility(8);
                this.dLZ.setVisibility(8);
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

    private void aTC() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMj);
    }

    private void d(VideoInfo videoInfo) {
        aTC();
        if (this.dLX != null && this.dLV != null && this.DI != null) {
            if (i.azO().isShowImages() && this.KJ != null && videoInfo != null) {
                this.dLV.setVisibility(0);
                this.dLX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dLX.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                }
                this.dLW.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.dMd.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.dLV.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLY, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dLZ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dLW, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMd, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dMa, R.color.common_color_10014);
            if (this.dLZ != null) {
                this.dLZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        aTC();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.dLV;
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
