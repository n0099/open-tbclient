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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.x;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private String aEN;
    private bb aFf;
    public FrameLayout boK;
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private QuickVideoView boO;
    private TextView boP;
    private View boQ;
    private x boR;
    private View boS;
    private TextView boT;
    private int boU;
    private TbImageView.a boV;
    private g.b boW;
    private ViewTreeObserver.OnGlobalLayoutListener boX;
    private Runnable boY;
    private Runnable boZ;
    private QuickVideoView.b bpa;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.boU = 1;
        this.boV = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && FrsBaseVideoView.this.boM != null) {
                    FrsBaseVideoView.this.boM.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.e(true, 4);
                return true;
            }
        };
        this.boX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.boK != null && FrsBaseVideoView.this.boK.getLayoutParams() != null && FrsBaseVideoView.this.boK.getVisibility() != 8) {
                    FrsBaseVideoView.this.boK.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.boK.getLayoutParams();
                    if (FrsBaseVideoView.this.boK.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.boK.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.boK.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.boY = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.boO != null && !FrsBaseVideoView.this.boO.isPlaying()) {
                    FrsBaseVideoView.this.e(true, 1);
                }
            }
        };
        this.boZ = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.e(true, 4);
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                FrsBaseVideoView.this.stopPlay();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.base_video_view, this);
        setOrientation(1);
        this.boK = (FrameLayout) findViewById(e.g.frame_video);
        this.boK.setOnClickListener(this);
        this.boK.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.boK != null) {
                    FrsBaseVideoView.this.boK.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.boX);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.boK != null) {
                    FrsBaseVideoView.this.boK.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.boX);
                }
            }
        });
        this.boM = (TbImageView) findViewById(e.g.image_video);
        this.boM.setDefaultErrorResource(0);
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setEvent(this.boV);
        this.boM.setGifIconSupport(false);
        this.boR = new x((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.boN = (ImageView) findViewById(e.g.image_video_play);
        this.boO = (QuickVideoView) findViewById(e.g.texture_video_view);
        this.boO.setOnErrorListener(this.boW);
        this.boO.setOnSurfaceDestroyedListener(this.bpa);
        this.boS = findViewById(e.g.auto_video_black_mask);
        this.boP = (TextView) findViewById(e.g.auto_video_error_tips);
        this.boQ = findViewById(e.g.auto_video_error_background);
        this.boL = (TextView) findViewById(e.g.text_video_duration);
        this.boT = (TextView) findViewById(e.g.text_video_play_count);
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
    public void e(boolean z, int i) {
        if (this.boN != null && this.boM != null && this.boS != null && this.boR != null && this.boQ != null && this.boP != null) {
            if (z || this.boU != i) {
                this.boU = i;
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boZ);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
                this.boN.setVisibility(0);
                this.boM.clearAnimation();
                this.boM.setVisibility(0);
                this.boS.setVisibility(0);
                this.boR.brZ();
                this.boQ.setVisibility(8);
                this.boP.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.aFf == null || this.aFf.zG() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void RK() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boZ);
    }

    private void c(VideoInfo videoInfo) {
        RK();
        if (this.boM != null && this.boK != null && this.boO != null) {
            if (i.xE().xI() && this.aFf != null && videoInfo != null) {
                this.boK.setVisibility(0);
                this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boM.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.aEN = videoInfo.video_url;
                if (StringUtils.isNull(this.aEN)) {
                    e(true, 4);
                }
                this.boL.setText(ao.dV(videoInfo.video_duration.intValue() * 1000));
                this.boT.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(e.j.play_count), ao.W(videoInfo.play_count.intValue())));
                return;
            }
            this.boK.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            al.h(this.boP, e.d.cp_cont_i);
            al.h(this.boL, e.d.cp_cont_i);
            al.h(this.boT, e.d.cp_cont_i);
            al.j(this.boQ, e.d.common_color_10014);
            if (this.boP != null) {
                this.boP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(e.f.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bb bbVar, VideoInfo videoInfo) {
        if (bbVar != null) {
            this.aFf = bbVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        RK();
        e(true, 1);
        if (this.boO != null) {
            this.boO.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.boK;
    }

    public String getPlayUrl() {
        return this.aEN;
    }

    public int getCurrentPosition() {
        if (this.boO == null) {
            return 0;
        }
        return this.boO.getCurrentPosition();
    }
}
