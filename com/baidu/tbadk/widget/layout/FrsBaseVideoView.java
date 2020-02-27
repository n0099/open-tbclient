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
    public FrameLayout dLU;
    private TextView dLV;
    private TbImageView dLW;
    private ImageView dLX;
    private TextView dLY;
    private View dLZ;
    private w dMa;
    private View dMb;
    private TextView dMc;
    private int dMd;
    private TbImageView.a dMe;
    private g.b dMf;
    private ViewTreeObserver.OnGlobalLayoutListener dMg;
    private Runnable dMh;
    private Runnable dMi;
    private QuickVideoView.b dMj;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMd = 1;
        this.dMe = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.dLW != null) {
                    FrsBaseVideoView.this.dLW.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.p(true, 4);
                return true;
            }
        };
        this.dMg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.dLU != null && FrsBaseVideoView.this.dLU.getLayoutParams() != null && FrsBaseVideoView.this.dLU.getVisibility() != 8) {
                    FrsBaseVideoView.this.dLU.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.dLU.getLayoutParams();
                    if (FrsBaseVideoView.this.dLU.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.dLU.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.dLU.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dMh = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.DI != null && !FrsBaseVideoView.this.DI.isPlaying()) {
                    FrsBaseVideoView.this.p(true, 1);
                }
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.p(true, 4);
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.dLU = (FrameLayout) findViewById(R.id.frame_video);
        this.dLU.setOnClickListener(this);
        this.dLU.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.dLU != null) {
                    FrsBaseVideoView.this.dLU.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.dMg);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.dLU != null) {
                    FrsBaseVideoView.this.dLU.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.dMg);
                }
            }
        });
        this.dLW = (TbImageView) findViewById(R.id.image_video);
        this.dLW.setDefaultErrorResource(0);
        this.dLW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dLW.setEvent(this.dMe);
        this.dLW.setGifIconSupport(false);
        this.dMa = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dLX = (ImageView) findViewById(R.id.image_video_play);
        this.DI = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.DI.setOnErrorListener(this.dMf);
        this.DI.setOnSurfaceDestroyedListener(this.dMj);
        this.dMb = findViewById(R.id.auto_video_black_mask);
        this.dLY = (TextView) findViewById(R.id.auto_video_error_tips);
        this.dLZ = findViewById(R.id.auto_video_error_background);
        this.dLV = (TextView) findViewById(R.id.text_video_duration);
        this.dMc = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.dLX != null && this.dLW != null && this.dMb != null && this.dMa != null && this.dLZ != null && this.dLY != null) {
            if (z || this.dMd != i) {
                this.dMd = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMh);
                this.dLX.setVisibility(0);
                this.dLW.clearAnimation();
                this.dLW.setVisibility(0);
                this.dMb.setVisibility(0);
                this.dMa.czn();
                this.dLZ.setVisibility(8);
                this.dLY.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.KJ == null || this.KJ.aCm() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aTA() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMh);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dMi);
    }

    private void d(VideoInfo videoInfo) {
        aTA();
        if (this.dLW != null && this.dLU != null && this.DI != null) {
            if (i.azM().isShowImages() && this.KJ != null && videoInfo != null) {
                this.dLU.setVisibility(0);
                this.dLW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dLW.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    p(true, 4);
                }
                this.dLV.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.dMc.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.dLU.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dLX, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dLY, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dLV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dMc, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dLZ, R.color.common_color_10014);
            if (this.dLY != null) {
                this.dLY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        aTA();
        p(true, 1);
        if (this.DI != null) {
            this.DI.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.dLU;
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
