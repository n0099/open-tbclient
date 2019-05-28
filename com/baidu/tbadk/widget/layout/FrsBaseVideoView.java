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
    private QuickVideoView Rp;
    private bg VK;
    private String bUZ;
    private Runnable cIA;
    private QuickVideoView.b cIB;
    public FrameLayout cIm;
    private TextView cIn;
    private TbImageView cIo;
    private ImageView cIp;
    private TextView cIq;
    private View cIr;
    private x cIs;
    private View cIt;
    private TextView cIu;
    private int cIv;
    private TbImageView.a cIw;
    private g.b cIx;
    private ViewTreeObserver.OnGlobalLayoutListener cIy;
    private Runnable cIz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cIv = 1;
        this.cIw = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cIo != null) {
                    FrsBaseVideoView.this.cIo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.i(true, 4);
                return true;
            }
        };
        this.cIy = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cIm != null && FrsBaseVideoView.this.cIm.getLayoutParams() != null && FrsBaseVideoView.this.cIm.getVisibility() != 8) {
                    FrsBaseVideoView.this.cIm.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cIm.getLayoutParams();
                    if (FrsBaseVideoView.this.cIm.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cIm.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cIm.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Rp != null && !FrsBaseVideoView.this.Rp.isPlaying()) {
                    FrsBaseVideoView.this.i(true, 1);
                }
            }
        };
        this.cIA = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.i(true, 4);
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cIm = (FrameLayout) findViewById(R.id.frame_video);
        this.cIm.setOnClickListener(this);
        this.cIm.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cIm != null) {
                    FrsBaseVideoView.this.cIm.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cIy);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cIm != null) {
                    FrsBaseVideoView.this.cIm.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cIy);
                }
            }
        });
        this.cIo = (TbImageView) findViewById(R.id.image_video);
        this.cIo.setDefaultErrorResource(0);
        this.cIo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cIo.setEvent(this.cIw);
        this.cIo.setGifIconSupport(false);
        this.cIs = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cIp = (ImageView) findViewById(R.id.image_video_play);
        this.Rp = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Rp.setOnErrorListener(this.cIx);
        this.Rp.setOnSurfaceDestroyedListener(this.cIB);
        this.cIt = findViewById(R.id.auto_video_black_mask);
        this.cIq = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cIr = findViewById(R.id.auto_video_error_background);
        this.cIn = (TextView) findViewById(R.id.text_video_duration);
        this.cIu = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.cIp != null && this.cIo != null && this.cIt != null && this.cIs != null && this.cIr != null && this.cIq != null) {
            if (z || this.cIv != i) {
                this.cIv = i;
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
                com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIz);
                this.cIp.setVisibility(0);
                this.cIo.clearAnimation();
                this.cIo.setVisibility(0);
                this.cIt.setVisibility(0);
                this.cIs.cbR();
                this.cIr.setVisibility(8);
                this.cIq.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.VK == null || this.VK.adv() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void axg() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIz);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cIA);
    }

    private void c(VideoInfo videoInfo) {
        axg();
        if (this.cIo != null && this.cIm != null && this.Rp != null) {
            if (i.abb().abf() && this.VK != null && videoInfo != null) {
                this.cIm.setVisibility(0);
                this.cIo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cIo.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.bUZ = videoInfo.video_url;
                if (StringUtils.isNull(this.bUZ)) {
                    i(true, 4);
                }
                this.cIn.setText(ap.im(videoInfo.video_duration.intValue() * 1000));
                this.cIu.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), ap.aN(videoInfo.play_count.intValue())));
                return;
            }
            this.cIm.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this, R.drawable.addresslist_item_bg);
            al.c(this.cIp, (int) R.drawable.btn_icon_play_video_n);
            al.j(this.cIq, R.color.cp_btn_a);
            al.j(this.cIn, R.color.cp_btn_a);
            al.j(this.cIu, R.color.cp_btn_a);
            al.l(this.cIr, R.color.common_color_10014);
            if (this.cIq != null) {
                this.cIq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bg bgVar, VideoInfo videoInfo) {
        if (bgVar != null) {
            this.VK = bgVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        axg();
        i(true, 1);
        if (this.Rp != null) {
            this.Rp.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cIm;
    }

    public String getPlayUrl() {
        return this.bUZ;
    }

    public int getCurrentPosition() {
        if (this.Rp == null) {
            return 0;
        }
        return this.Rp.getCurrentPosition();
    }
}
