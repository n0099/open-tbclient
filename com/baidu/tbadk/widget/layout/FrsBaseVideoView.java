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
    private QuickVideoView AC;
    private bh Fs;
    private Runnable cTA;
    private Runnable cTB;
    private QuickVideoView.b cTC;
    public FrameLayout cTn;
    private TextView cTo;
    private TbImageView cTp;
    private ImageView cTq;
    private TextView cTr;
    private View cTs;
    private x cTt;
    private View cTu;
    private TextView cTv;
    private int cTw;
    private TbImageView.a cTx;
    private g.b cTy;
    private ViewTreeObserver.OnGlobalLayoutListener cTz;
    private String cln;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cTw = 1;
        this.cTx = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cTp != null) {
                    FrsBaseVideoView.this.cTp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.j(true, 4);
                return true;
            }
        };
        this.cTz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cTn != null && FrsBaseVideoView.this.cTn.getLayoutParams() != null && FrsBaseVideoView.this.cTn.getVisibility() != 8) {
                    FrsBaseVideoView.this.cTn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cTn.getLayoutParams();
                    if (FrsBaseVideoView.this.cTn.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cTn.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cTn.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cTA = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.AC != null && !FrsBaseVideoView.this.AC.isPlaying()) {
                    FrsBaseVideoView.this.j(true, 1);
                }
            }
        };
        this.cTB = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.j(true, 4);
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cTn = (FrameLayout) findViewById(R.id.frame_video);
        this.cTn.setOnClickListener(this);
        this.cTn.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cTn != null) {
                    FrsBaseVideoView.this.cTn.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cTz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cTn != null) {
                    FrsBaseVideoView.this.cTn.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cTz);
                }
            }
        });
        this.cTp = (TbImageView) findViewById(R.id.image_video);
        this.cTp.setDefaultErrorResource(0);
        this.cTp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cTp.setEvent(this.cTx);
        this.cTp.setGifIconSupport(false);
        this.cTt = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cTq = (ImageView) findViewById(R.id.image_video_play);
        this.AC = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.AC.setOnErrorListener(this.cTy);
        this.AC.setOnSurfaceDestroyedListener(this.cTC);
        this.cTu = findViewById(R.id.auto_video_black_mask);
        this.cTr = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cTs = findViewById(R.id.auto_video_error_background);
        this.cTo = (TextView) findViewById(R.id.text_video_duration);
        this.cTv = (TextView) findViewById(R.id.text_video_play_count);
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
    public void j(boolean z, int i) {
        if (this.cTq != null && this.cTp != null && this.cTu != null && this.cTt != null && this.cTs != null && this.cTr != null) {
            if (z || this.cTw != i) {
                this.cTw = i;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTB);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTA);
                this.cTq.setVisibility(0);
                this.cTp.clearAnimation();
                this.cTp.setVisibility(0);
                this.cTu.setVisibility(0);
                this.cTt.ccN();
                this.cTs.setVisibility(8);
                this.cTr.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.Fs == null || this.Fs.aiE() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayQ() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTA);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cTB);
    }

    private void c(VideoInfo videoInfo) {
        ayQ();
        if (this.cTp != null && this.cTn != null && this.AC != null) {
            if (i.ago().isShowImages() && this.Fs != null && videoInfo != null) {
                this.cTn.setVisibility(0);
                this.cTp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cTp.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.cln = videoInfo.video_url;
                if (StringUtils.isNull(this.cln)) {
                    j(true, 4);
                }
                this.cTo.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.cTv.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.cTn.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cTq, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.cTr, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.cTs, R.color.common_color_10014);
            if (this.cTr != null) {
                this.cTr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bh bhVar, VideoInfo videoInfo) {
        if (bhVar != null) {
            this.Fs = bhVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        ayQ();
        j(true, 1);
        if (this.AC != null) {
            this.AC.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cTn;
    }

    public String getPlayUrl() {
        return this.cln;
    }

    public int getCurrentPosition() {
        if (this.AC == null) {
            return 0;
        }
        return this.AC.getCurrentPosition();
    }
}
