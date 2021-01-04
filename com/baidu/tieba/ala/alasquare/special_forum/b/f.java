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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes10.dex */
public class f extends a {
    private TbImageView akI;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnErrorListener eDg;
    private TbCyberVideoView.a fWA;
    private TbCyberVideoView gBU;
    private ImageView gKu;
    private VideoInfo gKv;
    private View mContentView;
    private TextView mTitleTv;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bVI();
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
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
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnErrorListener(this.eDg);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        this.gBU.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bVI();
            }
        });
        this.gBU.setStageType(null);
        this.gKu = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.akI = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.akI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.akI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTitleTv = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gKo.gIA)) {
                    be.bwu().a(f.this.mTbPageContext, new String[]{f.this.gKo.gIA}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bVl().c("c12909", f.this.gKo.gIC, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!x.isEmpty(this.gKo.geK) && this.gKo.geK.get(0) != null) {
            this.gKv = this.gKo.geK.get(0).brH();
            this.tid = this.gKo.geK.get(0).getId();
        }
        if (this.gKv != null) {
            this.akI.startLoad(this.gKv.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gKo.geK.get(0).brZ())) {
                title = this.gKo.geK.get(0).brZ().toString();
            } else {
                title = this.gKo.geK.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.mTitleTv.setText(title);
            }
            this.mVideoUrl = this.gKv.video_url;
            com.baidu.tieba.ala.alasquare.b.a.bVl().c("c12908", this.gKo.gIC, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        com.baidu.tieba.ala.alasquare.b.a.bVl().c("c12910", this.gKo.gIC, 2, this.tid);
        this.akI.setVisibility(8);
        this.gKu.setVisibility(8);
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
        return (aVar == null || 2 != aVar.gIB || TextUtils.isEmpty(aVar.gIy)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bVH() {
        super.bVH();
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
        ao.setViewTextColor(this.mTitleTv, R.color.CAM_X0111);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.gBU == null || this.gBU.isPlaying()) {
            this.gKu.setVisibility(0);
            this.gBU.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gBU == null || !this.gBU.isPlaying()) {
            this.gKu.setVisibility(8);
            this.gBU.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gBU != null && !this.gBU.isPlaying()) {
            this.akI.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ah.aK(1, this.mVideoUrl)) {
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
            this.gBU.dCa();
            this.gBU = null;
        }
    }
}
