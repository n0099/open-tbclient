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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class f extends a {
    private TbImageView akY;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnErrorListener eCc;
    private TbCyberVideoView.a fVI;
    private TbCyberVideoView gBU;
    private ImageView gKv;
    private VideoInfo gKw;
    private View mContentView;
    private TextView mTitleTv;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bSH();
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gBY));
        this.gBU = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnErrorListener(this.eCc);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        this.gBU.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bSH();
            }
        });
        this.gBU.setStageType(null);
        this.gKv = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.akY = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.akY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.akY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTitleTv = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gKp.gIB)) {
                    bf.bsY().a(f.this.mTbPageContext, new String[]{f.this.gKp.gIB}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12909", f.this.gKp.gID, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gKp.gdY) && this.gKp.gdY.get(0) != null) {
            this.gKw = this.gKp.gdY.get(0).boj();
            this.tid = this.gKp.gdY.get(0).getId();
        }
        if (this.gKw != null) {
            this.akY.startLoad(this.gKw.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gKp.gdY.get(0).boB())) {
                title = this.gKp.gdY.get(0).boB().toString();
            } else {
                title = this.gKp.gdY.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.mTitleTv.setText(title);
            }
            this.mVideoUrl = this.gKw.video_url;
            com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12908", this.gKp.gID, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSH() {
        com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12910", this.gKp.gID, 2, this.tid);
        this.akY.setVisibility(8);
        this.gKv.setVisibility(8);
        if (this.gBU != null) {
            this.gBU.setVolume(0.0f, 0.0f);
            try {
                this.gBU.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mu(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.gIC || TextUtils.isEmpty(aVar.gIz)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSG() {
        super.bSG();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gBY;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.mTitleTv, R.color.CAM_X0111);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.gBU == null || this.gBU.isPlaying()) {
            this.gKv.setVisibility(0);
            this.gBU.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gBU == null || !this.gBU.isPlaying()) {
            this.gKv.setVisibility(8);
            this.gBU.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gBU != null && !this.gBU.isPlaying()) {
            this.akY.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ak.aP(1, this.mVideoUrl)) {
                this.gBU.setVideoPath(this.mVideoUrl);
                this.gBU.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gBU != null) {
            this.gBU.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gBU != null) {
            this.gBU.stopPlayback();
            this.gBU.dAG();
            this.gBU = null;
        }
    }
}
