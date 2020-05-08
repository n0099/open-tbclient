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
    private QuickVideoView Xe;
    private bj adJ;
    private w emA;
    private View emB;
    private TextView emC;
    private int emD;
    private TbImageView.a emE;
    private g.b emF;
    private ViewTreeObserver.OnGlobalLayoutListener emG;
    private Runnable emH;
    private Runnable emI;
    private QuickVideoView.b emJ;
    public FrameLayout emu;
    private TextView emv;
    private TbImageView emw;
    private ImageView emx;
    private TextView emy;
    private View emz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.emD = 1;
        this.emE = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.emw != null) {
                    FrsBaseVideoView.this.emw.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.q(true, 4);
                return true;
            }
        };
        this.emG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.emu != null && FrsBaseVideoView.this.emu.getLayoutParams() != null && FrsBaseVideoView.this.emu.getVisibility() != 8) {
                    FrsBaseVideoView.this.emu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.emu.getLayoutParams();
                    if (FrsBaseVideoView.this.emu.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.emu.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.emu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.emH = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Xe != null && !FrsBaseVideoView.this.Xe.isPlaying()) {
                    FrsBaseVideoView.this.q(true, 1);
                }
            }
        };
        this.emI = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.q(true, 4);
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.emu = (FrameLayout) findViewById(R.id.frame_video);
        this.emu.setOnClickListener(this);
        this.emu.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.emu != null) {
                    FrsBaseVideoView.this.emu.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.emG);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.emu != null) {
                    FrsBaseVideoView.this.emu.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.emG);
                }
            }
        });
        this.emw = (TbImageView) findViewById(R.id.image_video);
        this.emw.setDefaultErrorResource(0);
        this.emw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.emw.setEvent(this.emE);
        this.emw.setGifIconSupport(false);
        this.emA = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.emx = (ImageView) findViewById(R.id.image_video_play);
        this.Xe = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Xe.setOnErrorListener(this.emF);
        this.Xe.setOnSurfaceDestroyedListener(this.emJ);
        this.emB = findViewById(R.id.auto_video_black_mask);
        this.emy = (TextView) findViewById(R.id.auto_video_error_tips);
        this.emz = findViewById(R.id.auto_video_error_background);
        this.emv = (TextView) findViewById(R.id.text_video_duration);
        this.emC = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.emx != null && this.emw != null && this.emB != null && this.emA != null && this.emz != null && this.emy != null) {
            if (z || this.emD != i) {
                this.emD = i;
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emI);
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emH);
                this.emx.setVisibility(0);
                this.emw.clearAnimation();
                this.emw.setVisibility(0);
                this.emB.setVisibility(0);
                this.emA.cKl();
                this.emz.setVisibility(8);
                this.emy.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.adJ == null || this.adJ.aKC() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bbP() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emH);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.emI);
    }

    private void d(VideoInfo videoInfo) {
        bbP();
        if (this.emw != null && this.emu != null && this.Xe != null) {
            if (i.aIc().isShowImages() && this.adJ != null && videoInfo != null) {
                this.emu.setVisibility(0);
                this.emw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.emw.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    q(true, 4);
                }
                this.emv.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.emC.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.emu.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.emx, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.emy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.emC, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.emz, R.color.common_color_10014);
            if (this.emy != null) {
                this.emy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bj bjVar, VideoInfo videoInfo) {
        if (bjVar != null) {
            this.adJ = bjVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        bbP();
        q(true, 1);
        if (this.Xe != null) {
            this.Xe.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.emu;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Xe == null) {
            return 0;
        }
        return this.Xe.getCurrentPosition();
    }
}
