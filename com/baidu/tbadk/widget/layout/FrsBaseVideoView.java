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
    private QuickVideoView Be;
    private bh FT;
    public FrameLayout cUe;
    private TextView cUf;
    private TbImageView cUg;
    private ImageView cUh;
    private TextView cUi;
    private View cUj;
    private x cUk;
    private View cUl;
    private TextView cUm;
    private int cUn;
    private TbImageView.a cUo;
    private g.b cUp;
    private ViewTreeObserver.OnGlobalLayoutListener cUq;
    private Runnable cUr;
    private Runnable cUs;
    private QuickVideoView.b cUt;
    private String cmf;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public FrsBaseVideoView(Context context) {
        this(context, null);
    }

    public FrsBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cUn = 1;
        this.cUo = new TbImageView.a() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.2
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && FrsBaseVideoView.this.cUg != null) {
                    FrsBaseVideoView.this.cUg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                FrsBaseVideoView.this.j(true, 4);
                return true;
            }
        };
        this.cUq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (FrsBaseVideoView.this.cUe != null && FrsBaseVideoView.this.cUe.getLayoutParams() != null && FrsBaseVideoView.this.cUe.getVisibility() != 8) {
                    FrsBaseVideoView.this.cUe.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewGroup.LayoutParams layoutParams = FrsBaseVideoView.this.cUe.getLayoutParams();
                    if (FrsBaseVideoView.this.cUe.getWidth() > 0) {
                        layoutParams.height = (int) (FrsBaseVideoView.this.cUe.getWidth() * 0.5625d);
                        FrsBaseVideoView.this.cUe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.cUr = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBaseVideoView.this.Be != null && !FrsBaseVideoView.this.Be.isPlaying()) {
                    FrsBaseVideoView.this.j(true, 1);
                }
            }
        };
        this.cUs = new Runnable() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                FrsBaseVideoView.this.j(true, 4);
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.7
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
        this.cUe = (FrameLayout) findViewById(R.id.frame_video);
        this.cUe.setOnClickListener(this);
        this.cUe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tbadk.widget.layout.FrsBaseVideoView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (FrsBaseVideoView.this.cUe != null) {
                    FrsBaseVideoView.this.cUe.getViewTreeObserver().addOnGlobalLayoutListener(FrsBaseVideoView.this.cUq);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (FrsBaseVideoView.this.cUe != null) {
                    FrsBaseVideoView.this.cUe.getViewTreeObserver().removeGlobalOnLayoutListener(FrsBaseVideoView.this.cUq);
                }
            }
        });
        this.cUg = (TbImageView) findViewById(R.id.image_video);
        this.cUg.setDefaultErrorResource(0);
        this.cUg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cUg.setEvent(this.cUo);
        this.cUg.setGifIconSupport(false);
        this.cUk = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cUh = (ImageView) findViewById(R.id.image_video_play);
        this.Be = (QuickVideoView) findViewById(R.id.texture_video_view);
        this.Be.setOnErrorListener(this.cUp);
        this.Be.setOnSurfaceDestroyedListener(this.cUt);
        this.cUl = findViewById(R.id.auto_video_black_mask);
        this.cUi = (TextView) findViewById(R.id.auto_video_error_tips);
        this.cUj = findViewById(R.id.auto_video_error_background);
        this.cUf = (TextView) findViewById(R.id.text_video_duration);
        this.cUm = (TextView) findViewById(R.id.text_video_play_count);
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
        if (this.cUh != null && this.cUg != null && this.cUl != null && this.cUk != null && this.cUj != null && this.cUi != null) {
            if (z || this.cUn != i) {
                this.cUn = i;
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUs);
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUr);
                this.cUh.setVisibility(0);
                this.cUg.clearAnimation();
                this.cUg.setVisibility(0);
                this.cUl.setVisibility(0);
                this.cUk.ccP();
                this.cUj.setVisibility(8);
                this.cUi.setVisibility(8);
            }
        }
    }

    private void b(VideoInfo videoInfo) {
        if (this.FT == null || this.FT.aiG() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c(videoInfo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ayS() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUr);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cUs);
    }

    private void c(VideoInfo videoInfo) {
        ayS();
        if (this.cUg != null && this.cUe != null && this.Be != null) {
            if (i.agq().isShowImages() && this.FT != null && videoInfo != null) {
                this.cUe.setVisibility(0);
                this.cUg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cUg.startLoad(videoInfo.thumbnail_url, 10, false);
                stopPlay();
                this.cmf = videoInfo.video_url;
                if (StringUtils.isNull(this.cmf)) {
                    j(true, 4);
                }
                this.cUf.setText(aq.stringForVideoTime(videoInfo.video_duration.intValue() * 1000));
                this.cUm.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.play_count), aq.numFormatOverWan(videoInfo.play_count.intValue())));
                return;
            }
            this.cUe.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cUh, R.drawable.btn_icon_play_video_n);
            am.setViewTextColor(this.cUi, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUf, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.cUj, R.color.common_color_10014);
            if (this.cUi != null) {
                this.cUi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public void a(bh bhVar, VideoInfo videoInfo) {
        if (bhVar != null) {
            this.FT = bhVar;
            b(videoInfo);
        }
    }

    public void stopPlay() {
        ayS();
        j(true, 1);
        if (this.Be != null) {
            this.Be.stopPlayback();
        }
    }

    public View getVideoContainer() {
        return this.cUe;
    }

    public String getPlayUrl() {
        return this.cmf;
    }

    public int getCurrentPosition() {
        if (this.Be == null) {
            return 0;
        }
        return this.Be.getCurrentPosition();
    }
}
