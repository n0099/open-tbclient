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
    private QuickVideoView Dn;
    private bj Kn;
    public FrameLayout dHP;
    private TextView dHQ;
    private TbImageView dHR;
    private ImageView dHS;
    private TextView dHT;
    private View dHU;
    private w dHV;
    private View dHW;
    private TextView dHX;
    private int dHY;
    private TbImageView.a dHZ;
    private g.b dIa;
    private ViewTreeObserver.OnGlobalLayoutListener dIb;
    private Runnable dIc;
    private Runnable dId;
    private QuickVideoView.b dIe;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHY = 1;
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.dHR != null) {
                    FrsBaseVideoView.this.dHR.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.o(true, 4);
                return true;
            }
        };
        this.dIb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.dHP != null && FrsBaseVideoView.this.dHP.getLayoutParams() != null && FrsBaseVideoView.this.dHP.getVisibility() != 8) {
                    FrsBaseVideoView.this.dHP.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.dHP.getLayoutParams();
                    if (FrsBaseVideoView.this.dHP.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.dHP.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.dHP.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dIc = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Dn != null && !FrsBaseVideoView.this.Dn.isPlaying()) {
                    FrsBaseVideoView.this.o(true, 1);
                }
            }
        };
        this.dId = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.o(true, 4);
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.dHP = (FrameLayout) findViewById(R.id.frame_video);
        this.dHP.setOnClickListener(this);
        this.dHP.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.dHP != null) {
                    FrsBaseVideoView.this.dHP.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.dIb);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.dHP != null) {
                    FrsBaseVideoView.this.dHP.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.dIb);
                }
            }
        });
        this.dHR = (TbImageView) findViewById(R.id.image_video);
        this.dHR.setDefaultErrorResource(0);
        this.dHR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dHR.setEvent(this.dHZ);
        this.dHR.setGifIconSupport(false);
        this.dHV = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dHS = (ImageView) findViewById(R.id.image_video_play);
        this.Dn = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Dn.setOnErrorListener(this.dIa);
        this.Dn.setOnSurfaceDestroyedListener(this.dIe);
        this.dHW = findViewById(R.id.auto_video_black_mask);
        this.dHT = (TextView) findViewById(R.id.auto_video_error_tips);
        this.dHU = findViewById(R.id.auto_video_error_background);
        this.dHQ = (TextView) findViewById(R.id.text_video_duration);
        this.dHX = (TextView) findViewById(R.id.text_video_play_count);
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
    public void o(boolean z, int i) {
        if (this.dHS != null && this.dHR != null && this.dHW != null && this.dHV != null && this.dHU != null && this.dHT != null) {
            if (z || this.dHY != i) {
                this.dHY = i;
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dId);
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dIc);
                this.dHS.setVisibility(0);
                this.dHR.clearAnimation();
                this.dHR.setVisibility(0);
                this.dHW.setVisibility(0);
                this.dHV.cxT();
                this.dHU.setVisibility(8);
                this.dHT.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.Kn == null || this.Kn.azX() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aRj() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dIc);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dId);
    }

    private void d(VideoInfo videoInfo) {
        aRj();
        if (this.dHR != null && this.dHP != null && this.Dn != null) {
            if (i.axy().isShowImages() && this.Kn != null && videoInfo != null) {
                this.dHP.setVisibility(0);
                this.dHR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dHR.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    o(true, 4);
                }
                this.dHQ.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.dHX.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.dHP.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHS, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dHT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHQ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHX, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dHU, R.color.common_color_10014);
            if (this.dHT != null) {
                this.dHT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bj bjVar, VideoInfo videoInfo) {
        if (bjVar != null) {
            this.Kn = bjVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        aRj();
        o(true, 1);
        if (this.Dn != null) {
            this.Dn.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.dHP;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Dn == null) {
            return 0;
        }
        return this.Dn.getCurrentPosition();
    }
}
