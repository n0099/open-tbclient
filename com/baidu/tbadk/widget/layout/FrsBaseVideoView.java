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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.x;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private QuickVideoView RF;
    private bh Wd;
    private String bXa;
    public FrameLayout cKE;
    private TextView cKF;
    private TbImageView cKG;
    private ImageView cKH;
    private TextView cKI;
    private View cKJ;
    private x cKK;
    private View cKL;
    private TextView cKM;
    private int cKN;
    private TbImageView.a cKO;
    private g.b cKP;
    private ViewTreeObserver.OnGlobalLayoutListener cKQ;
    private Runnable cKR;
    private Runnable cKS;
    private QuickVideoView.b cKT;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cKN = 1;
        this.cKO = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cKG != null) {
                    FrsBaseVideoView.this.cKG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cKQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cKE != null && FrsBaseVideoView.this.cKE.getLayoutParams() != null && FrsBaseVideoView.this.cKE.getVisibility() != 8) {
                    FrsBaseVideoView.this.cKE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cKE.getLayoutParams();
                    if (FrsBaseVideoView.this.cKE.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cKE.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cKE.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cKR = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.RF != null && !FrsBaseVideoView.this.RF.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cKS = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cKE = (FrameLayout) findViewById(R.id.frame_video);
        this.cKE.setOnClickListener(this);
        this.cKE.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cKE != null) {
                    FrsBaseVideoView.this.cKE.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cKQ);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cKE != null) {
                    FrsBaseVideoView.this.cKE.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cKQ);
                }
            }
        });
        this.cKG = (TbImageView) findViewById(R.id.image_video);
        this.cKG.setDefaultErrorResource(0);
        this.cKG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cKG.setEvent(this.cKO);
        this.cKG.setGifIconSupport(false);
        this.cKK = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cKH = (ImageView) findViewById(R.id.image_video_play);
        this.RF = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.RF.setOnErrorListener(this.cKP);
        this.RF.setOnSurfaceDestroyedListener(this.cKT);
        this.cKL = findViewById(R.id.auto_video_black_mask);
        this.cKI = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cKJ = findViewById(R.id.auto_video_error_background);
        this.cKF = (TextView) findViewById(R.id.text_video_duration);
        this.cKM = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.cKH != null && this.cKG != null && this.cKL != null && this.cKK != null && this.cKJ != null && this.cKI != null) {
            if (z || this.cKN != i) {
                this.cKN = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKS);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKR);
                this.cKH.setVisibility(0);
                this.cKG.clearAnimation();
                this.cKG.setVisibility(0);
                this.cKL.setVisibility(0);
                this.cKK.cfO();
                this.cKJ.setVisibility(8);
                this.cKI.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.Wd == null || this.Wd.aeC() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayG() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKR);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKS);
    }

    private void c(VideoInfo videoInfo) {
        ayG();
        if (this.cKG != null && this.cKE != null && this.RF != null) {
            if (i.ace().aci() && this.Wd != null && videoInfo != null) {
                this.cKE.setVisibility(0);
                this.cKG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cKG.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bXa = videoInfo.video_url;
                if (StringUtils.isNull(this.bXa)) {
                    i(true, 4);
                }
                this.cKF.setText(aq.it(videoInfo.video_duration.intValue() * 1000));
                this.cKM.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.aO(videoInfo.play_count.intValue())));
                return;
            }
            this.cKE.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this, R.drawable.addresslist_item_bg);
            am.c(this.cKH, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cKI, R.color.cp_cont_a);
            am.j(this.cKF, R.color.cp_cont_a);
            am.j(this.cKM, R.color.cp_cont_a);
            am.l(this.cKJ, R.color.common_color_10014);
            if (this.cKI != null) {
                this.cKI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bh bhVar, VideoInfo videoInfo) {
        if (bhVar != null) {
            this.Wd = bhVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        ayG();
        i(true, 1);
        if (this.RF != null) {
            this.RF.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cKE;
    }

    public String getPlayUrl() {
        return this.bXa;
    }

    public int getCurrentPosition() {
        if (this.RF == null) {
            return 0;
        }
        return this.RF.getCurrentPosition();
    }
}
