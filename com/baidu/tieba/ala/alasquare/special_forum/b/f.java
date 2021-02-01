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
    private ImageView gIy;
    private VideoInfo gIz;
    private TbCyberVideoView gzX;
    private View mContentView;
    private TextView mTitleTv;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bSu();
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
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gAb));
        this.gzX = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnErrorListener(this.eAB);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        this.gzX.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bSu();
            }
        });
        this.gzX.setStageType(null);
        this.gIy = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajG = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTitleTv = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gIs.gGE)) {
                    bf.bsV().a(f.this.mTbPageContext, new String[]{f.this.gIs.gGE}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bRX().c("c12909", f.this.gIs.gGG, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gIs.gcs) && this.gIs.gcs.get(0) != null) {
            this.gIz = this.gIs.gcs.get(0).boh();
            this.tid = this.gIs.gcs.get(0).getId();
        }
        if (this.gIz != null) {
            this.ajG.startLoad(this.gIz.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gIs.gcs.get(0).boz())) {
                title = this.gIs.gcs.get(0).boz().toString();
            } else {
                title = this.gIs.gcs.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.mTitleTv.setText(title);
            }
            this.mVideoUrl = this.gIz.video_url;
            com.baidu.tieba.ala.alasquare.b.a.bRX().c("c12908", this.gIs.gGG, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSu() {
        com.baidu.tieba.ala.alasquare.b.a.bRX().c("c12910", this.gIs.gGG, 2, this.tid);
        this.ajG.setVisibility(8);
        this.gIy.setVisibility(8);
        if (this.gzX != null) {
            this.gzX.setVolume(0.0f, 0.0f);
            try {
                this.gzX.start();
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
        return (aVar == null || 2 != aVar.gGF || TextUtils.isEmpty(aVar.gGC)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSt() {
        super.bSt();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gAb;
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
        if (this.gzX == null || this.gzX.isPlaying()) {
            this.gIy.setVisibility(0);
            this.gzX.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gzX == null || !this.gzX.isPlaying()) {
            this.gIy.setVisibility(8);
            this.gzX.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gzX != null && !this.gzX.isPlaying()) {
            this.ajG.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ak.aP(1, this.mVideoUrl)) {
                this.gzX.setVideoPath(this.mVideoUrl);
                this.gzX.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gzX != null) {
            this.gzX.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gzX != null) {
            this.gzX.stopPlayback();
            this.gzX.dAr();
            this.gzX = null;
        }
    }
}
