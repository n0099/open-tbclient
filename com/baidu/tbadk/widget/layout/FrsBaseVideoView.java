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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.w;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private QuickVideoView XX;
    private bu aeK;
    public FrameLayout eKT;
    private TextView eKU;
    private TbImageView eKV;
    private ImageView eKW;
    private TextView eKX;
    private View eKY;
    private w eKZ;
    private View eLa;
    private TextView eLb;
    private int eLc;
    private TbImageView.a eLd;
    private g.b eLe;
    private ViewTreeObserver.OnGlobalLayoutListener eLf;
    private Runnable eLg;
    private Runnable eLh;
    private QuickVideoView.b eLi;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eLc = 1;
        this.eLd = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.eKV != null) {
                    FrsBaseVideoView.this.eKV.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.v(true, 4);
                return true;
            }
        };
        this.eLf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.eKT != null && FrsBaseVideoView.this.eKT.getLayoutParams() != null && FrsBaseVideoView.this.eKT.getVisibility() != 8) {
                    FrsBaseVideoView.this.eKT.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.eKT.getLayoutParams();
                    if (FrsBaseVideoView.this.eKT.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.eKT.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.eKT.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.eLg = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.XX != null && !FrsBaseVideoView.this.XX.isPlaying()) {
                    FrsBaseVideoView.this.v(true, 1);
                }
            }
        };
        this.eLh = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.v(true, 4);
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.eKT = (FrameLayout) findViewById(R.id.frame_video);
        this.eKT.setOnClickListener(this);
        this.eKT.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.eKT != null) {
                    FrsBaseVideoView.this.eKT.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.eLf);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.eKT != null) {
                    FrsBaseVideoView.this.eKT.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.eLf);
                }
            }
        });
        this.eKV = (TbImageView) findViewById(R.id.image_video);
        this.eKV.setDefaultErrorResource(0);
        this.eKV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eKV.setEvent(this.eLd);
        this.eKV.setGifIconSupport(false);
        this.eKZ = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.eKW = (ImageView) findViewById(R.id.image_video_play);
        this.XX = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.XX.setOnErrorListener(this.eLe);
        this.XX.setOnSurfaceDestroyedListener(this.eLi);
        this.eLa = findViewById(R.id.auto_video_black_mask);
        this.eKX = (TextView) findViewById(R.id.auto_video_error_tips);
        this.eKY = findViewById(R.id.auto_video_error_background);
        this.eKU = (TextView) findViewById(R.id.text_video_duration);
        this.eLb = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.eKW != null && this.eKV != null && this.eLa != null && this.eKZ != null && this.eKY != null && this.eKX != null) {
            if (z || this.eLc != i) {
                this.eLc = i;
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLh);
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLg);
                this.eKW.setVisibility(0);
                this.eKV.clearAnimation();
                this.eKV.setVisibility(0);
                this.eLa.setVisibility(0);
                this.eKZ.cVS();
                this.eKY.setVisibility(8);
                this.eKX.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.aeK == null || this.aeK.aSp() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bky() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLg);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eLh);
    }

    private void d(VideoInfo videoInfo) {
        bky();
        if (this.eKV != null && this.eKT != null && this.XX != null) {
            if (k.aPA().isShowImages() && this.aeK != null && videoInfo != null) {
                this.eKT.setVisibility(0);
                this.eKV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.eKV.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    v(true, 4);
                }
                this.eKU.setText(ar.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.eLb.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), ar.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.eKT.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            an.setImageResource(this.eKW, R.drawable.btn_icon_play_video_n);
            an.setViewTextColor(this.eKX, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.eKU, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.eLb, (int) R.color.cp_cont_a);
            an.setBackgroundColor(this.eKY, R.color.common_color_10014);
            if (this.eKX != null) {
                this.eKX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bu buVar, VideoInfo videoInfo) {
        if (buVar != null) {
            this.aeK = buVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bky();
        v(true, 1);
        if (this.XX != null) {
            this.XX.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.eKT;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.XX == null) {
            return 0;
        }
        return this.XX.getCurrentPosition();
    }
}
