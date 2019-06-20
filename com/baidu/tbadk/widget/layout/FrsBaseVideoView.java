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
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.x;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class FrsBaseVideoView extends LinearLayout implements View.OnClickListener {
    private QuickVideoView Ro;
    private bg VJ;
    private String bVa;
    private Runnable cIA;
    private Runnable cIB;
    private QuickVideoView.b cIC;
    public FrameLayout cIn;
    private TextView cIo;
    private TbImageView cIp;
    private ImageView cIq;
    private TextView cIr;
    private View cIs;
    private x cIt;
    private View cIu;
    private TextView cIv;
    private int cIw;
    private TbImageView.a cIx;
    private g.b cIy;
    private ViewTreeObserver.OnGlobalLayoutListener cIz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cIw = 1;
        this.cIx = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cIp != null) {
                    FrsBaseVideoView.this.cIp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cIz = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cIn != null && FrsBaseVideoView.this.cIn.getLayoutParams() != null && FrsBaseVideoView.this.cIn.getVisibility() != 8) {
                    FrsBaseVideoView.this.cIn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cIn.getLayoutParams();
                    if (FrsBaseVideoView.this.cIn.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cIn.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cIn.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cIA = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Ro != null && !FrsBaseVideoView.this.Ro.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cIB = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cIn = (FrameLayout) findViewById(R.id.frame_video);
        this.cIn.setOnClickListener(this);
        this.cIn.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cIn != null) {
                    FrsBaseVideoView.this.cIn.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cIz);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cIn != null) {
                    FrsBaseVideoView.this.cIn.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cIz);
                }
            }
        });
        this.cIp = (TbImageView) findViewById(R.id.image_video);
        this.cIp.setDefaultErrorResource(0);
        this.cIp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cIp.setEvent(this.cIx);
        this.cIp.setGifIconSupport(false);
        this.cIt = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cIq = (ImageView) findViewById(R.id.image_video_play);
        this.Ro = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Ro.setOnErrorListener(this.cIy);
        this.Ro.setOnSurfaceDestroyedListener(this.cIC);
        this.cIu = findViewById(R.id.auto_video_black_mask);
        this.cIr = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cIs = findViewById(R.id.auto_video_error_background);
        this.cIo = (TextView) findViewById(R.id.text_video_duration);
        this.cIv = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.cIq != null && this.cIp != null && this.cIu != null && this.cIt != null && this.cIs != null && this.cIr != null) {
            if (z || this.cIw != i) {
                this.cIw = i;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIB);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
                this.cIq.setVisibility(0);
                this.cIp.clearAnimation();
                this.cIp.setVisibility(0);
                this.cIu.setVisibility(0);
                this.cIt.cbS();
                this.cIs.setVisibility(8);
                this.cIr.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.VJ == null || this.VJ.adv() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void axg() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIB);
    }

    private void c(VideoInfo videoInfo) {
        axg();
        if (this.cIp != null && this.cIn != null && this.Ro != null) {
            if (i.abb().abf() && this.VJ != null && videoInfo != null) {
                this.cIn.setVisibility(0);
                this.cIp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cIp.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bVa = videoInfo.video_url;
                if (StringUtils.isNull(this.bVa)) {
                    i(true, 4);
                }
                this.cIo.setText(ap.im(videoInfo.video_duration.intValue() * 1000));
                this.cIv.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), ap.aN(videoInfo.play_count.intValue())));
                return;
            }
            this.cIn.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this, R.drawable.addresslist_item_bg);
            al.c(this.cIq, (int) R.drawable.btn_icon_play_video_n);
            al.j(this.cIr, R.color.cp_btn_a);
            al.j(this.cIo, R.color.cp_btn_a);
            al.j(this.cIv, R.color.cp_btn_a);
            al.l(this.cIs, R.color.common_color_10014);
            if (this.cIr != null) {
                this.cIr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bg bgVar, VideoInfo videoInfo) {
        if (bgVar != null) {
            this.VJ = bgVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        axg();
        i(true, 1);
        if (this.Ro != null) {
            this.Ro.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cIn;
    }

    public String getPlayUrl() {
        return this.bVa;
    }

    public int getCurrentPosition() {
        if (this.Ro == null) {
            return 0;
        }
        return this.Ro.getCurrentPosition();
    }
}
