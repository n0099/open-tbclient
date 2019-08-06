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
    private QuickVideoView RG;
    private bh We;
    private String bWh;
    public FrameLayout cJO;
    private TextView cJP;
    private TbImageView cJQ;
    private ImageView cJR;
    private TextView cJS;
    private View cJT;
    private x cJU;
    private View cJV;
    private TextView cJW;
    private int cJX;
    private TbImageView.a cJY;
    private g.b cJZ;
    private ViewTreeObserver.OnGlobalLayoutListener cKa;
    private Runnable cKb;
    private Runnable cKc;
    private QuickVideoView.b cKd;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cJX = 1;
        this.cJY = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cJQ != null) {
                    FrsBaseVideoView.this.cJQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cKa = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cJO != null && FrsBaseVideoView.this.cJO.getLayoutParams() != null && FrsBaseVideoView.this.cJO.getVisibility() != 8) {
                    FrsBaseVideoView.this.cJO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cJO.getLayoutParams();
                    if (FrsBaseVideoView.this.cJO.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cJO.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cJO.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cKb = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.RG != null && !FrsBaseVideoView.this.RG.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cKc = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cJO = (FrameLayout) findViewById(R.id.frame_video);
        this.cJO.setOnClickListener(this);
        this.cJO.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cJO != null) {
                    FrsBaseVideoView.this.cJO.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cKa);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cJO != null) {
                    FrsBaseVideoView.this.cJO.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cKa);
                }
            }
        });
        this.cJQ = (TbImageView) findViewById(R.id.image_video);
        this.cJQ.setDefaultErrorResource(0);
        this.cJQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cJQ.setEvent(this.cJY);
        this.cJQ.setGifIconSupport(false);
        this.cJU = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cJR = (ImageView) findViewById(R.id.image_video_play);
        this.RG = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.RG.setOnErrorListener(this.cJZ);
        this.RG.setOnSurfaceDestroyedListener(this.cKd);
        this.cJV = findViewById(R.id.auto_video_black_mask);
        this.cJS = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cJT = findViewById(R.id.auto_video_error_background);
        this.cJP = (TextView) findViewById(R.id.text_video_duration);
        this.cJW = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.cJR != null && this.cJQ != null && this.cJV != null && this.cJU != null && this.cJT != null && this.cJS != null) {
            if (z || this.cJX != i) {
                this.cJX = i;
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKc);
                com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKb);
                this.cJR.setVisibility(0);
                this.cJQ.clearAnimation();
                this.cJQ.setVisibility(0);
                this.cJV.setVisibility(0);
                this.cJU.cfa();
                this.cJT.setVisibility(8);
                this.cJS.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.We == null || this.We.aey() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayu() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKb);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cKc);
    }

    private void c(VideoInfo videoInfo) {
        ayu();
        if (this.cJQ != null && this.cJO != null && this.RG != null) {
            if (i.aca().ace() && this.We != null && videoInfo != null) {
                this.cJO.setVisibility(0);
                this.cJQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cJQ.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bWh = videoInfo.video_url;
                if (StringUtils.isNull(this.bWh)) {
                    i(true, 4);
                }
                this.cJP.setText(aq.is(videoInfo.video_duration.intValue() * 1000));
                this.cJW.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.aO(videoInfo.play_count.intValue())));
                return;
            }
            this.cJO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this, R.drawable.addresslist_item_bg);
            am.c(this.cJR, (int) R.drawable.btn_icon_play_video_n);
            am.j(this.cJS, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            am.j(this.cJW, R.color.cp_btn_a);
            am.l(this.cJT, R.color.common_color_10014);
            if (this.cJS != null) {
                this.cJS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bh bhVar, VideoInfo videoInfo) {
        if (bhVar != null) {
            this.We = bhVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        ayu();
        i(true, 1);
        if (this.RG != null) {
            this.RG.cey();
        }
    }

    public View getVideoContainer() {
        return this.cJO;
    }

    public String getPlayUrl() {
        return this.bWh;
    }

    public int getCurrentPosition() {
        if (this.RG == null) {
            return 0;
        }
        return this.RG.getCurrentPosition();
    }
}
