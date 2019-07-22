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
    private QuickVideoView RG;
    private bg We;
    private String bWb;
    public FrameLayout cJH;
    private TextView cJI;
    private TbImageView cJJ;
    private ImageView cJK;
    private TextView cJL;
    private View cJM;
    private x cJN;
    private View cJO;
    private TextView cJP;
    private int cJQ;
    private TbImageView.a cJR;
    private g.b cJS;
    private ViewTreeObserver.OnGlobalLayoutListener cJT;
    private Runnable cJU;
    private Runnable cJV;
    private QuickVideoView.b cJW;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cJQ = 1;
        this.cJR = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cJJ != null) {
                    FrsBaseVideoView.this.cJJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cJT = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cJH != null && FrsBaseVideoView.this.cJH.getLayoutParams() != null && FrsBaseVideoView.this.cJH.getVisibility() != 8) {
                    FrsBaseVideoView.this.cJH.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cJH.getLayoutParams();
                    if (FrsBaseVideoView.this.cJH.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cJH.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cJH.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cJU = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.RG != null && !FrsBaseVideoView.this.RG.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cJV = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cJH = (FrameLayout) findViewById(R.id.frame_video);
        this.cJH.setOnClickListener(this);
        this.cJH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cJH != null) {
                    FrsBaseVideoView.this.cJH.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cJT);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cJH != null) {
                    FrsBaseVideoView.this.cJH.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cJT);
                }
            }
        });
        this.cJJ = (TbImageView) findViewById(R.id.image_video);
        this.cJJ.setDefaultErrorResource(0);
        this.cJJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cJJ.setEvent(this.cJR);
        this.cJJ.setGifIconSupport(false);
        this.cJN = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cJK = (ImageView) findViewById(R.id.image_video_play);
        this.RG = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.RG.setOnErrorListener(this.cJS);
        this.RG.setOnSurfaceDestroyedListener(this.cJW);
        this.cJO = findViewById(R.id.auto_video_black_mask);
        this.cJL = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cJM = findViewById(R.id.auto_video_error_background);
        this.cJI = (TextView) findViewById(R.id.text_video_duration);
        this.cJP = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.cJK != null && this.cJJ != null && this.cJO != null && this.cJN != null && this.cJM != null && this.cJL != null) {
            if (z || this.cJQ != i) {
                this.cJQ = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJV);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJU);
                this.cJK.setVisibility(0);
                this.cJJ.clearAnimation();
                this.cJJ.setVisibility(0);
                this.cJO.setVisibility(0);
                this.cJN.ceI();
                this.cJM.setVisibility(8);
                this.cJL.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.We == null || this.We.aex() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ays() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJU);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cJV);
    }

    private void c(VideoInfo videoInfo) {
        ays();
        if (this.cJJ != null && this.cJH != null && this.RG != null) {
            if (i.aca().ace() && this.We != null && videoInfo != null) {
                this.cJH.setVisibility(0);
                this.cJJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cJJ.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bWb = videoInfo.video_url;
                if (StringUtils.isNull(this.bWb)) {
                    i(true, 4);
                }
                this.cJI.setText(aq.is(videoInfo.video_duration.intValue() * 1000));
                this.cJP.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.aO(videoInfo.play_count.intValue())));
                return;
            }
            this.cJH.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this, R.drawable.addresslist_item_bg);
            am.c(this.cJK, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cJL, R.color.cp_btn_a);
            am.j(this.cJI, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            am.l(this.cJM, R.color.common_color_10014);
            if (this.cJL != null) {
                this.cJL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bg bgVar, VideoInfo videoInfo) {
        if (bgVar != null) {
            this.We = bgVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        ays();
        i(true, 1);
        if (this.RG != null) {
            this.RG.ceg();
        }
    }

    public View getVideoContainer() {
        return this.cJH;
    }

    public String getPlayUrl() {
        return this.bWb;
    }

    public int getCurrentPosition() {
        if (this.RG == null) {
            return 0;
        }
        return this.RG.getCurrentPosition();
    }
}
