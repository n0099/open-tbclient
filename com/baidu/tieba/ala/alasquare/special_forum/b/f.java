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
    private TbImageView ajc;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnErrorListener ein;
    private TextView fSh;
    private TbCyberVideoView.a fzS;
    private TbCyberVideoView gdn;
    private ImageView glM;
    private VideoInfo glN;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bNz();
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gdr));
        this.gdn = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gdn.setOnPreparedListener(this.eim);
        this.gdn.setOnErrorListener(this.ein);
        this.gdn.setOnSurfaceDestroyedListener(this.fzS);
        this.gdn.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bNz();
            }
        });
        this.gdn.setStageType(null);
        this.glM = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajc = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fSh = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.glG.gjS)) {
                    be.boR().a(f.this.mTbPageContext, new String[]{f.this.glG.gjS}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12909", f.this.glG.gjU, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.glG.fIa) && this.glG.fIa.get(0) != null) {
            this.glN = this.glG.fIa.get(0).bks();
            this.tid = this.glG.fIa.get(0).getId();
        }
        if (this.glN != null) {
            this.ajc.startLoad(this.glN.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.glG.fIa.get(0).bkK())) {
                title = this.glG.fIa.get(0).bkK().toString();
            } else {
                title = this.glG.fIa.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fSh.setText(title);
            }
            this.mVideoUrl = this.glN.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12908", this.glG.gjU, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNz() {
        com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12910", this.glG.gjU, 2, this.tid);
        this.ajc.setVisibility(8);
        this.glM.setVisibility(8);
        if (this.gdn != null) {
            this.gdn.setVolume(0.0f, 0.0f);
            try {
                this.gdn.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ls(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.gjT || TextUtils.isEmpty(aVar.gjQ)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bNy() {
        super.bNy();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gdr;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fSh, R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.gdn == null || this.gdn.isPlaying()) {
            this.glM.setVisibility(0);
            this.gdn.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gdn == null || !this.gdn.isPlaying()) {
            this.glM.setVisibility(8);
            this.gdn.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gdn != null && !this.gdn.isPlaying()) {
            this.ajc.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ai.aG(1, this.mVideoUrl)) {
                this.gdn.setVideoPath(this.mVideoUrl);
                this.gdn.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gdn != null) {
            this.gdn.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gdn != null) {
            this.gdn.stopPlayback();
            this.gdn.duQ();
            this.gdn = null;
        }
    }
}
