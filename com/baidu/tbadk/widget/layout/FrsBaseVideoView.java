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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.x;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private QuickVideoView TC;
    private bg XR;
    private String bNk;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAi;
    private View cAj;
    private x cAk;
    private View cAl;
    private TextView cAm;
    private int cAn;
    private TbImageView.a cAo;
    private g.b cAp;
    private ViewTreeObserver.OnGlobalLayoutListener cAq;
    private Runnable cAr;
    private Runnable cAs;
    private QuickVideoView.b cAt;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAn = 1;
        this.cAo = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cAg != null) {
                    FrsBaseVideoView.this.cAg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cAq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cAe != null && FrsBaseVideoView.this.cAe.getLayoutParams() != null && FrsBaseVideoView.this.cAe.getVisibility() != 8) {
                    FrsBaseVideoView.this.cAe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cAe.getLayoutParams();
                    if (FrsBaseVideoView.this.cAe.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cAe.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cAe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.TC != null && !FrsBaseVideoView.this.TC.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cAs = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.base_video_view, this);
        setOrientation(1);
        this.cAe = (FrameLayout) findViewById(d.g.frame_video);
        this.cAe.setOnClickListener(this);
        this.cAe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cAe != null) {
                    FrsBaseVideoView.this.cAe.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cAq);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cAe != null) {
                    FrsBaseVideoView.this.cAe.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cAq);
                }
            }
        });
        this.cAg = (TbImageView) findViewById(d.g.image_video);
        this.cAg.setDefaultErrorResource(0);
        this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAg.setEvent(this.cAo);
        this.cAg.setGifIconSupport(false);
        this.cAk = new x((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.cAh = (ImageView) findViewById(d.g.image_video_play);
        this.TC = (QuickVideoView) findViewById(d.g.texture_video_view);
        this.TC.setOnErrorListener(this.cAp);
        this.TC.setOnSurfaceDestroyedListener(this.cAt);
        this.cAl = findViewById(d.g.auto_video_black_mask);
        this.cAi = (TextView) findViewById(d.g.auto_video_error_tips);
        this.cAj = findViewById(d.g.auto_video_error_background);
        this.cAf = (TextView) findViewById(d.g.text_video_duration);
        this.cAm = (TextView) findViewById(d.g.text_video_play_count);
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
    public void i(boolean z, int i) {
        if (this.cAh != null && this.cAg != null && this.cAl != null && this.cAk != null && this.cAj != null && this.cAi != null) {
            if (z || this.cAn != i) {
                this.cAn = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
                this.cAh.setVisibility(0);
                this.cAg.clearAnimation();
                this.cAg.setVisibility(0);
                this.cAl.setVisibility(0);
                this.cAk.bTP();
                this.cAj.setVisibility(8);
                this.cAi.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.XR == null || this.XR.YR() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ase() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAs);
    }

    private void c(VideoInfo videoInfo) {
        ase();
        if (this.cAg != null && this.cAe != null && this.TC != null) {
            if (i.Wy().WC() && this.XR != null && videoInfo != null) {
                this.cAe.setVisibility(0);
                this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAg.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bNk = videoInfo.video_url;
                if (StringUtils.isNull(this.bNk)) {
                    i(true, 4);
                }
                this.cAf.setText(ap.hz(videoInfo.video_duration.intValue() * 1000));
                this.cAm.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(d.j.play_count), ap.az(videoInfo.play_count.intValue())));
                return;
            }
            this.cAe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            al.j(this.cAi, d.C0236d.cp_btn_a);
            al.j(this.cAf, d.C0236d.cp_btn_a);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            al.l(this.cAj, d.C0236d.common_color_10014);
            if (this.cAi != null) {
                this.cAi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bg bgVar, VideoInfo videoInfo) {
        if (bgVar != null) {
            this.XR = bgVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        ase();
        i(true, 1);
        if (this.TC != null) {
            this.TC.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cAe;
    }

    public String getPlayUrl() {
        return this.bNk;
    }

    public int getCurrentPosition() {
        if (this.TC == null) {
            return 0;
        }
        return this.TC.getCurrentPosition();
    }
}
