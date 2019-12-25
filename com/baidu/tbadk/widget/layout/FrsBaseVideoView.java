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
    private QuickVideoView Di;
    private bj Ki;
    public FrameLayout dHG;
    private TextView dHH;
    private TbImageView dHI;
    private ImageView dHJ;
    private TextView dHK;
    private View dHL;
    private w dHM;
    private View dHN;
    private TextView dHO;
    private int dHP;
    private TbImageView.a dHQ;
    private g.b dHR;
    private ViewTreeObserver.OnGlobalLayoutListener dHS;
    private Runnable dHT;
    private Runnable dHU;
    private QuickVideoView.b dHV;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private String mVideoUrl;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHP = 1;
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.dHI != null) {
                    FrsBaseVideoView.this.dHI.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.n(true, 4);
                return true;
            }
        };
        this.dHS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.dHG != null && FrsBaseVideoView.this.dHG.getLayoutParams() != null && FrsBaseVideoView.this.dHG.getVisibility() != 8) {
                    FrsBaseVideoView.this.dHG.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.dHG.getLayoutParams();
                    if (FrsBaseVideoView.this.dHG.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.dHG.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.dHG.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.dHT = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Di != null && !FrsBaseVideoView.this.Di.isPlaying()) {
                    FrsBaseVideoView.this.n(true, 1);
                }
            }
        };
        this.dHU = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.n(true, 4);
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.dHG = (FrameLayout) findViewById(R.id.frame_video);
        this.dHG.setOnClickListener(this);
        this.dHG.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.dHG != null) {
                    FrsBaseVideoView.this.dHG.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.dHS);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.dHG != null) {
                    FrsBaseVideoView.this.dHG.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.dHS);
                }
            }
        });
        this.dHI = (TbImageView) findViewById(R.id.image_video);
        this.dHI.setDefaultErrorResource(0);
        this.dHI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dHI.setEvent(this.dHQ);
        this.dHI.setGifIconSupport(false);
        this.dHM = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dHJ = (ImageView) findViewById(R.id.image_video_play);
        this.Di = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Di.setOnErrorListener(this.dHR);
        this.Di.setOnSurfaceDestroyedListener(this.dHV);
        this.dHN = findViewById(R.id.auto_video_black_mask);
        this.dHK = (TextView) findViewById(R.id.auto_video_error_tips);
        this.dHL = findViewById(R.id.auto_video_error_background);
        this.dHH = (TextView) findViewById(R.id.text_video_duration);
        this.dHO = (TextView) findViewById(R.id.text_video_play_count);
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
    public void n(boolean z, int i) {
        if (this.dHJ != null && this.dHI != null && this.dHN != null && this.dHM != null && this.dHL != null && this.dHK != null) {
            if (z || this.dHP != i) {
                this.dHP = i;
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHU);
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHT);
                this.dHJ.setVisibility(0);
                this.dHI.clearAnimation();
                this.dHI.setVisibility(0);
                this.dHN.setVisibility(0);
                this.dHM.cwK();
                this.dHL.setVisibility(8);
                this.dHK.setVisibility(8);
            }
        }
    }

    private void c(VideoInfo videoInfo) {
        if (this.Ki == null || this.Ki.azE() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        d(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aQQ() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHT);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dHU);
    }

    private void d(VideoInfo videoInfo) {
        aQQ();
        if (this.dHI != null && this.dHG != null && this.Di != null) {
            if (i.axf().isShowImages() && this.Ki != null && videoInfo != null) {
                this.dHG.setVisibility(0);
                this.dHI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.dHI.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.mVideoUrl = videoInfo.video_url;
                if (StringUtils.isNull(this.mVideoUrl)) {
                    n(true, 4);
                }
                this.dHH.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.dHO.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.dHG.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.dHJ, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.dHK, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dHO, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.dHL, R.color.common_color_10014);
            if (this.dHK != null) {
                this.dHK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bj bjVar, VideoInfo videoInfo) {
        if (bjVar != null) {
            this.Ki = bjVar;
            c(videoInfo);
        }
    }

    public void stopPlay() {
        aQQ();
        n(true, 1);
        if (this.Di != null) {
            this.Di.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.dHG;
    }

    public String getPlayUrl() {
        return this.mVideoUrl;
    }

    public int getCurrentPosition() {
        if (this.Di == null) {
            return 0;
        }
        return this.Di.getCurrentPosition();
    }
}
