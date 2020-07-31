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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends a {
    private TbImageView ahd;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnErrorListener dCy;
    private TbCyberVideoView.a eRD;
    private ImageView fAG;
    private VideoInfo fAH;
    private TextView fiS;
    private TbCyberVideoView fsr;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bxX();
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fsv));
        this.fsr = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnErrorListener(this.dCy);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        this.fsr.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bxX();
            }
        });
        this.fAG = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ahd = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ahd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ahd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fiS = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fAA.fyM)) {
                    bd.baV().a(f.this.mTbPageContext, new String[]{f.this.fAA.fyM}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bxy().c("c12909", f.this.fAA.fyO, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!x.isEmpty(this.fAA.eZc) && this.fAA.eZc.get(0) != null) {
            this.fAH = this.fAA.eZc.get(0).aWD();
            this.tid = this.fAA.eZc.get(0).getId();
        }
        if (this.fAH != null) {
            this.ahd.startLoad(this.fAH.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fAA.eZc.get(0).aWV())) {
                title = this.fAA.eZc.get(0).aWV().toString();
            } else {
                title = this.fAA.eZc.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fiS.setText(title);
            }
            this.mVideoUrl = this.fAH.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bxy().c("c12908", this.fAA.fyO, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxX() {
        com.baidu.tieba.ala.alasquare.c.a.bxy().c("c12910", this.fAA.fyO, 2, this.tid);
        this.ahd.setVisibility(8);
        this.fAG.setVisibility(8);
        if (this.fsr != null) {
            this.fsr.setVolume(0.0f, 0.0f);
            try {
                this.fsr.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ka(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.fyN || TextUtils.isEmpty(aVar.fyK)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bxW() {
        super.bxW();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fsv;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.fiS, R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fsr == null || this.fsr.isPlaying()) {
            this.fAG.setVisibility(0);
            this.fsr.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fsr == null || !this.fsr.isPlaying()) {
            this.fAG.setVisibility(8);
            this.fsr.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fsr != null && !this.fsr.isPlaying()) {
            this.ahd.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ag.au(1, this.mVideoUrl)) {
                this.fsr.setVideoPath(this.mVideoUrl);
                this.fsr.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fsr != null) {
            this.fsr.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fsr != null) {
            this.fsr.stopPlayback();
            this.fsr.cZk();
            this.fsr = null;
        }
    }
}
