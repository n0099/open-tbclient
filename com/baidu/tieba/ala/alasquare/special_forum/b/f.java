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
    private TbImageView aiJ;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnErrorListener dNP;
    private TbCyberVideoView fHb;
    private ImageView fPq;
    private VideoInfo fPr;
    private TbCyberVideoView.a ffg;
    private TextView fxD;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bIn();
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fHf));
        this.fHb = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fHb.setOnPreparedListener(this.dNO);
        this.fHb.setOnErrorListener(this.dNP);
        this.fHb.setOnSurfaceDestroyedListener(this.ffg);
        this.fHb.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bIn();
            }
        });
        this.fHb.setStageType(null);
        this.fPq = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.aiJ = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.aiJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.aiJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fxD = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fPk.fNw)) {
                    be.bkp().a(f.this.mTbPageContext, new String[]{f.this.fPk.fNw}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12909", f.this.fPk.fNy, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.fPk.fnr) && this.fPk.fnr.get(0) != null) {
            this.fPr = this.fPk.fnr.get(0).bfQ();
            this.tid = this.fPk.fnr.get(0).getId();
        }
        if (this.fPr != null) {
            this.aiJ.startLoad(this.fPr.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fPk.fnr.get(0).bgi())) {
                title = this.fPk.fnr.get(0).bgi().toString();
            } else {
                title = this.fPk.fnr.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fxD.setText(title);
            }
            this.mVideoUrl = this.fPr.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12908", this.fPk.fNy, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12910", this.fPk.fNy, 2, this.tid);
        this.aiJ.setVisibility(8);
        this.fPq.setVisibility(8);
        if (this.fHb != null) {
            this.fHb.setVolume(0.0f, 0.0f);
            try {
                this.fHb.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kC(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.fNx || TextUtils.isEmpty(aVar.fNu)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bIm() {
        super.bIm();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fHf;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fxD, R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fHb == null || this.fHb.isPlaying()) {
            this.fPq.setVisibility(0);
            this.fHb.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fHb == null || !this.fHb.isPlaying()) {
            this.fPq.setVisibility(8);
            this.fHb.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fHb != null && !this.fHb.isPlaying()) {
            this.aiJ.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ai.at(1, this.mVideoUrl)) {
                this.fHb.setVideoPath(this.mVideoUrl);
                this.fHb.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fHb != null) {
            this.fHb.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fHb != null) {
            this.fHb.stopPlayback();
            this.fHb.dnY();
            this.fHb = null;
        }
    }
}
