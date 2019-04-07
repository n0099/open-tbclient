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
    private String bNn;
    public FrameLayout cAd;
    private TextView cAe;
    private TbImageView cAf;
    private ImageView cAg;
    private TextView cAh;
    private View cAi;
    private x cAj;
    private View cAk;
    private TextView cAl;
    private int cAm;
    private TbImageView.a cAn;
    private g.b cAo;
    private ViewTreeObserver.OnGlobalLayoutListener cAp;
    private Runnable cAq;
    private Runnable cAr;
    private QuickVideoView.b cAs;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAm = 1;
        this.cAn = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cAf != null) {
                    FrsBaseVideoView.this.cAf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cAp = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cAd != null && FrsBaseVideoView.this.cAd.getLayoutParams() != null && FrsBaseVideoView.this.cAd.getVisibility() != 8) {
                    FrsBaseVideoView.this.cAd.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cAd.getLayoutParams();
                    if (FrsBaseVideoView.this.cAd.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cAd.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cAd.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cAq = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.TD != null && !FrsBaseVideoView.this.TD.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cAd = (FrameLayout) findViewById(d.g.frame_video);
        this.cAd.setOnClickListener(this);
        this.cAd.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cAd != null) {
                    FrsBaseVideoView.this.cAd.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cAp);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cAd != null) {
                    FrsBaseVideoView.this.cAd.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cAp);
                }
            }
        });
        this.cAf = (TbImageView) findViewById(d.g.image_video);
        this.cAf.setDefaultErrorResource(0);
        this.cAf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAf.setEvent(this.cAn);
        this.cAf.setGifIconSupport(false);
        this.cAj = new x((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.cAg = (ImageView) findViewById(d.g.image_video_play);
        this.TD = (QuickVideoView) findViewById(d.g.texture_video_view);
        this.TD.setOnErrorListener(this.cAo);
        this.TD.setOnSurfaceDestroyedListener(this.cAs);
        this.cAk = findViewById(d.g.auto_video_black_mask);
        this.cAh = (TextView) findViewById(d.g.auto_video_error_tips);
        this.cAi = findViewById(d.g.auto_video_error_background);
        this.cAe = (TextView) findViewById(d.g.text_video_duration);
        this.cAl = (TextView) findViewById(d.g.text_video_play_count);
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
        if (this.cAg != null && this.cAf != null && this.cAk != null && this.cAj != null && this.cAi != null && this.cAh != null) {
            if (z || this.cAm != i) {
                this.cAm = i;
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
                com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAq);
                this.cAg.setVisibility(0);
                this.cAf.clearAnimation();
                this.cAf.setVisibility(0);
                this.cAk.setVisibility(0);
                this.cAj.bTN();
                this.cAi.setVisibility(8);
                this.cAh.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.XS == null || this.XS.YO() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void asa() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAq);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cAr);
    }

    private void c(VideoInfo videoInfo) {
        asa();
        if (this.cAf != null && this.cAd != null && this.TD != null) {
            if (i.Wv().Wz() && this.XS != null && videoInfo != null) {
                this.cAd.setVisibility(0);
                this.cAf.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAf.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bNn = videoInfo.video_url;
                if (StringUtils.isNull(this.bNn)) {
                    i(true, 4);
                }
                this.cAe.setText(ap.hy(videoInfo.video_duration.intValue() * 1000));
                this.cAl.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(d.j.play_count), ap.az(videoInfo.play_count.intValue())));
                return;
            }
            this.cAd.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this, d.f.addresslist_item_bg);
            al.c(this.cAg, d.f.btn_icon_play_video_n);
            al.j(this.cAh, d.C0277d.cp_btn_a);
            al.j(this.cAe, d.C0277d.cp_btn_a);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            al.l(this.cAi, d.C0277d.common_color_10014);
            if (this.cAh != null) {
                this.cAh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        asa();
        i(true, 1);
        if (this.TD != null) {
            this.TD.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cAd;
    }

    public String getPlayUrl() {
        return this.bNn;
    }

    public int getCurrentPosition() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.getCurrentPosition();
    }
}
