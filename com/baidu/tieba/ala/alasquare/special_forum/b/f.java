package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends a {
    private TbImageView aip;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnErrorListener dLM;
    private TbCyberVideoView fDP;
    private ImageView fMc;
    private VideoInfo fMd;
    private TbCyberVideoView.a fcn;
    private TextView fus;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bGX();
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fDT));
        this.fDP = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fDP.setOnPreparedListener(this.dLL);
        this.fDP.setOnErrorListener(this.dLM);
        this.fDP.setOnSurfaceDestroyedListener(this.fcn);
        this.fDP.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bGX();
            }
        });
        this.fDP.setStageType(null);
        this.fMc = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.aip = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.aip.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.aip.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fus = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fLW.fKi)) {
                    be.bju().a(f.this.mTbPageContext, new String[]{f.this.fLW.fKi}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12909", f.this.fLW.fKk, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.fLW.fky) && this.fLW.fky.get(0) != null) {
            this.fMd = this.fLW.fky.get(0).beW();
            this.tid = this.fLW.fky.get(0).getId();
        }
        if (this.fMd != null) {
            this.aip.startLoad(this.fMd.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fLW.fky.get(0).bfo())) {
                title = this.fLW.fky.get(0).bfo().toString();
            } else {
                title = this.fLW.fky.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fus.setText(title);
            }
            this.mVideoUrl = this.fMd.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12908", this.fLW.fKk, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGX() {
        com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12910", this.fLW.fKk, 2, this.tid);
        this.aip.setVisibility(8);
        this.fMc.setVisibility(8);
        if (this.fDP != null) {
            this.fDP.setVolume(0.0f, 0.0f);
            try {
                this.fDP.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kA(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.fKj || TextUtils.isEmpty(aVar.fKg)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bGW() {
        super.bGW();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fDT;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fus, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fDP == null || this.fDP.isPlaying()) {
            this.fMc.setVisibility(0);
            this.fDP.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fDP == null || !this.fDP.isPlaying()) {
            this.fMc.setVisibility(8);
            this.fDP.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fDP != null && !this.fDP.isPlaying()) {
            this.aip.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ah.as(1, this.mVideoUrl)) {
                this.fDP.setVideoPath(this.mVideoUrl);
                this.fDP.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fDP != null) {
            this.fDP.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fDP != null) {
            this.fDP.stopPlayback();
            this.fDP.dkr();
            this.fDP = null;
        }
    }
}
