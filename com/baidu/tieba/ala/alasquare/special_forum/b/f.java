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
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends a {
    private TbImageView ajb;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnErrorListener dZQ;
    private TextView fJM;
    private TbCyberVideoView fTk;
    private TbCyberVideoView.a frv;
    private ImageView gbI;
    private VideoInfo gbJ;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bKX();
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fTo));
        this.fTk = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fTk.setOnPreparedListener(this.dZP);
        this.fTk.setOnErrorListener(this.dZQ);
        this.fTk.setOnSurfaceDestroyedListener(this.frv);
        this.fTk.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bKX();
            }
        });
        this.fTk.setStageType(null);
        this.gbI = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajb = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fJM = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gbC.fZN)) {
                    be.bmY().a(f.this.mTbPageContext, new String[]{f.this.gbC.fZN}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12909", f.this.gbC.fZP, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gbC.fzF) && this.gbC.fzF.get(0) != null) {
            this.gbJ = this.gbC.fzF.get(0).biz();
            this.tid = this.gbC.fzF.get(0).getId();
        }
        if (this.gbJ != null) {
            this.ajb.startLoad(this.gbJ.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gbC.fzF.get(0).biR())) {
                title = this.gbC.fzF.get(0).biR().toString();
            } else {
                title = this.gbC.fzF.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fJM.setText(title);
            }
            this.mVideoUrl = this.gbJ.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12908", this.gbC.fZP, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12910", this.gbC.fZP, 2, this.tid);
        this.ajb.setVisibility(8);
        this.gbI.setVisibility(8);
        if (this.fTk != null) {
            this.fTk.setVolume(0.0f, 0.0f);
            try {
                this.fTk.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void la(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.fZO || TextUtils.isEmpty(aVar.fZL)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bKW() {
        super.bKW();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fTo;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fJM, R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fTk == null || this.fTk.isPlaying()) {
            this.gbI.setVisibility(0);
            this.fTk.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fTk == null || !this.fTk.isPlaying()) {
            this.gbI.setVisibility(8);
            this.fTk.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fTk != null && !this.fTk.isPlaying()) {
            this.ajb.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ai.aE(1, this.mVideoUrl)) {
                this.fTk.setVideoPath(this.mVideoUrl);
                this.fTk.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fTk != null) {
            this.fTk.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fTk != null) {
            this.fTk.stopPlayback();
            this.fTk.drJ();
            this.fTk = null;
        }
    }
}
