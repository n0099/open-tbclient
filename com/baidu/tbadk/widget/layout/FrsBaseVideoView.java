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
    private QuickVideoView TD;
    private bg XS;
    private String bNl;
    public FrameLayout cAb;
    private TextView cAc;
    private TbImageView cAd;
    private ImageView cAe;
    private TextView cAf;
    private View cAg;
    private x cAh;
    private View cAi;
    private TextView cAj;
    private int cAk;
    private TbImageView.a cAl;
    private g.b cAm;
    private ViewTreeObserver.OnGlobalLayoutListener cAn;
    private Runnable cAo;
    private Runnable cAp;
    private QuickVideoView.b cAq;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAk = 1;
        this.cAl = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cAd != null) {
                    FrsBaseVideoView.this.cAd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cAn = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cAb != null && FrsBaseVideoView.this.cAb.getLayoutParams() != null && FrsBaseVideoView.this.cAb.getVisibility() != 8) {
                    FrsBaseVideoView.this.cAb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cAb.getLayoutParams();
                    if (FrsBaseVideoView.this.cAb.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cAb.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cAb.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cAo = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.TD != null && !FrsBaseVideoView.this.TD.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cAp = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cAb = (FrameLayout) findViewById(d.g.frame_video);
        this.cAb.setOnClickListener(this);
        this.cAb.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cAb != null) {
                    FrsBaseVideoView.this.cAb.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cAn);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cAb != null) {
                    FrsBaseVideoView.this.cAb.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cAn);
                }
            }
        });
        this.cAd = (TbImageView) findViewById(d.g.image_video);
        this.cAd.setDefaultErrorResource(0);
        this.cAd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAd.setEvent(this.cAl);
        this.cAd.setGifIconSupport(false);
        this.cAh = new x((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.cAe = (ImageView) findViewById(d.g.image_video_play);
        this.TD = (QuickVideoView) findViewById(d.g.texture_video_view);
        this.TD.setOnErrorListener(this.cAm);
        this.TD.setOnSurfaceDestroyedListener(this.cAq);
        this.cAi = findViewById(d.g.auto_video_black_mask);
        this.cAf = (TextView) findViewById(d.g.auto_video_error_tips);
        this.cAg = findViewById(d.g.auto_video_error_background);
        this.cAc = (TextView) findViewById(d.g.text_video_duration);
        this.cAj = (TextView) findViewById(d.g.text_video_play_count);
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
        if (this.cAe != null && this.cAd != null && this.cAi != null && this.cAh != null && this.cAg != null && this.cAf != null) {
            if (z || this.cAk != i) {
                this.cAk = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAp);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAo);
                this.cAe.setVisibility(0);
                this.cAd.clearAnimation();
                this.cAd.setVisibility(0);
                this.cAi.setVisibility(0);
                this.cAh.bTR();
                this.cAg.setVisibility(8);
                this.cAf.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.XS == null || this.XS.YR() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void asd() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAo);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAp);
    }

    private void c(VideoInfo videoInfo) {
        asd();
        if (this.cAd != null && this.cAb != null && this.TD != null) {
            if (i.Wy().WC() && this.XS != null && videoInfo != null) {
                this.cAb.setVisibility(0);
                this.cAd.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAd.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bNl = videoInfo.video_url;
                if (StringUtils.isNull(this.bNl)) {
                    i(true, 4);
                }
                this.cAc.setText(ap.hz(videoInfo.video_duration.intValue() * 1000));
                this.cAj.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(d.j.play_count), ap.az(videoInfo.play_count.intValue())));
                return;
            }
            this.cAb.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this, d.f.addresslist_item_bg);
            al.c(this.cAe, d.f.btn_icon_play_video_n);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAc, d.C0277d.cp_btn_a);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            al.l(this.cAg, d.C0277d.common_color_10014);
            if (this.cAf != null) {
                this.cAf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bg bgVar, VideoInfo videoInfo) {
        if (bgVar != null) {
            this.XS = bgVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        asd();
        i(true, 1);
        if (this.TD != null) {
            this.TD.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cAb;
    }

    public String getPlayUrl() {
        return this.bNl;
    }

    public int getCurrentPosition() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.getCurrentPosition();
    }
}
