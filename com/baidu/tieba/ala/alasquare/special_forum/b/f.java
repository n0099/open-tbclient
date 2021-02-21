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
/* loaded from: classes10.dex */
public class f extends a {
    private TbImageView ajG;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private TbCyberVideoView.a fUi;
    private TbCyberVideoView gAl;
    private ImageView gIM;
    private VideoInfo gIN;
    private View mContentView;
    private TextView mTitleTv;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bSB();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gAp));
        this.gAl = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnErrorListener(this.eAB);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        this.gAl.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bSB();
            }
        });
        this.gAl.setStageType(null);
        this.gIM = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajG = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTitleTv = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gIG.gGS)) {
                    bf.bsV().a(f.this.mTbPageContext, new String[]{f.this.gIG.gGS}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12909", f.this.gIG.gGU, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gIG.gcy) && this.gIG.gcy.get(0) != null) {
            this.gIN = this.gIG.gcy.get(0).boh();
            this.tid = this.gIG.gcy.get(0).getId();
        }
        if (this.gIN != null) {
            this.ajG.startLoad(this.gIN.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gIG.gcy.get(0).boz())) {
                title = this.gIG.gcy.get(0).boz().toString();
            } else {
                title = this.gIG.gcy.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.mTitleTv.setText(title);
            }
            this.mVideoUrl = this.gIN.video_url;
            com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12908", this.gIG.gGU, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSB() {
        com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12910", this.gIG.gGU, 2, this.tid);
        this.ajG.setVisibility(8);
        this.gIM.setVisibility(8);
        if (this.gAl != null) {
            this.gAl.setVolume(0.0f, 0.0f);
            try {
                this.gAl.start();
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
        return (aVar == null || 2 != aVar.gGT || TextUtils.isEmpty(aVar.gGQ)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSA() {
        super.bSA();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gAp;
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
        if (this.gAl == null || this.gAl.isPlaying()) {
            this.gIM.setVisibility(0);
            this.gAl.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gAl == null || !this.gAl.isPlaying()) {
            this.gIM.setVisibility(8);
            this.gAl.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gAl != null && !this.gAl.isPlaying()) {
            this.ajG.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ak.aP(1, this.mVideoUrl)) {
                this.gAl.setVideoPath(this.mVideoUrl);
                this.gAl.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gAl != null) {
            this.gAl.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gAl != null) {
            this.gAl.stopPlayback();
            this.gAl.dAy();
            this.gAl = null;
        }
    }
}
