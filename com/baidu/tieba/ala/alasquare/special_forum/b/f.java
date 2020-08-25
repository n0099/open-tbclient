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
    private TbImageView ain;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnErrorListener dLI;
    private TbCyberVideoView fDL;
    private ImageView fLY;
    private VideoInfo fLZ;
    private TbCyberVideoView.a fcj;
    private TextView fuo;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bGW();
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fDP));
        this.fDL = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fDL.setOnPreparedListener(this.dLH);
        this.fDL.setOnErrorListener(this.dLI);
        this.fDL.setOnSurfaceDestroyedListener(this.fcj);
        this.fDL.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bGW();
            }
        });
        this.fDL.setStageType(null);
        this.fLY = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ain = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ain.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ain.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fuo = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fLS.fKe)) {
                    be.bju().a(f.this.mTbPageContext, new String[]{f.this.fLS.fKe}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12909", f.this.fLS.fKg, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.fLS.fku) && this.fLS.fku.get(0) != null) {
            this.fLZ = this.fLS.fku.get(0).beW();
            this.tid = this.fLS.fku.get(0).getId();
        }
        if (this.fLZ != null) {
            this.ain.startLoad(this.fLZ.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fLS.fku.get(0).bfo())) {
                title = this.fLS.fku.get(0).bfo().toString();
            } else {
                title = this.fLS.fku.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fuo.setText(title);
            }
            this.mVideoUrl = this.fLZ.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12908", this.fLS.fKg, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGW() {
        com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12910", this.fLS.fKg, 2, this.tid);
        this.ain.setVisibility(8);
        this.fLY.setVisibility(8);
        if (this.fDL != null) {
            this.fDL.setVolume(0.0f, 0.0f);
            try {
                this.fDL.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ky(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.fKf || TextUtils.isEmpty(aVar.fKc)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bGV() {
        super.bGV();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fDP;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fuo, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fDL == null || this.fDL.isPlaying()) {
            this.fLY.setVisibility(0);
            this.fDL.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fDL == null || !this.fDL.isPlaying()) {
            this.fLY.setVisibility(8);
            this.fDL.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fDL != null && !this.fDL.isPlaying()) {
            this.ain.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ah.as(1, this.mVideoUrl)) {
                this.fDL.setVideoPath(this.mVideoUrl);
                this.fDL.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fDL != null) {
            this.fDL.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fDL != null) {
            this.fDL.stopPlayback();
            this.fDL.dko();
            this.fDL = null;
        }
    }
}
