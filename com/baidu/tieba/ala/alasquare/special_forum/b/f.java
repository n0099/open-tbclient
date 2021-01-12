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
/* loaded from: classes9.dex */
public class f extends a {
    private TbImageView ajR;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnErrorListener eyu;
    private TbCyberVideoView.a fRT;
    private ImageView gFO;
    private VideoInfo gFP;
    private TbCyberVideoView gxn;
    private View mContentView;
    private TextView mTitleTv;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bRR();
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gxr));
        this.gxn = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnErrorListener(this.eyu);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        this.gxn.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bRR();
            }
        });
        this.gxn.setStageType(null);
        this.gFO = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajR = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTitleTv = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gFI.gDU)) {
                    be.bsB().a(f.this.mTbPageContext, new String[]{f.this.gFI.gDU}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12909", f.this.gFI.gDW, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!x.isEmpty(this.gFI.gaa) && this.gFI.gaa.get(0) != null) {
            this.gFP = this.gFI.gaa.get(0).bnO();
            this.tid = this.gFI.gaa.get(0).getId();
        }
        if (this.gFP != null) {
            this.ajR.startLoad(this.gFP.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gFI.gaa.get(0).bog())) {
                title = this.gFI.gaa.get(0).bog().toString();
            } else {
                title = this.gFI.gaa.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.mTitleTv.setText(title);
            }
            this.mVideoUrl = this.gFP.video_url;
            com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12908", this.gFI.gDW, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12910", this.gFI.gDW, 2, this.tid);
        this.ajR.setVisibility(8);
        this.gFO.setVisibility(8);
        if (this.gxn != null) {
            this.gxn.setVolume(0.0f, 0.0f);
            try {
                this.gxn.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mq(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.gDV || TextUtils.isEmpty(aVar.gDS)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bRQ() {
        super.bRQ();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gxr;
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
        if (this.gxn == null || this.gxn.isPlaying()) {
            this.gFO.setVisibility(0);
            this.gxn.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gxn == null || !this.gxn.isPlaying()) {
            this.gFO.setVisibility(8);
            this.gxn.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gxn != null && !this.gxn.isPlaying()) {
            this.ajR.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ah.aL(1, this.mVideoUrl)) {
                this.gxn.setVideoPath(this.mVideoUrl);
                this.gxn.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gxn != null) {
            this.gxn.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gxn != null) {
            this.gxn.stopPlayback();
            this.gxn.dyj();
            this.gxn = null;
        }
    }
}
