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
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends a {
    private TbImageView ajh;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnErrorListener emx;
    private TbCyberVideoView.a fFk;
    private TextView fXE;
    private TbCyberVideoView giK;
    private ImageView grg;
    private VideoInfo grh;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bPs();
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.giO));
        this.giK = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.giK.setOnPreparedListener(this.emw);
        this.giK.setOnErrorListener(this.emx);
        this.giK.setOnSurfaceDestroyedListener(this.fFk);
        this.giK.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bPs();
            }
        });
        this.giK.setStageType(null);
        this.grg = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajh = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajh.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fXE = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gra.gpm)) {
                    bf.bqF().a(f.this.mTbPageContext, new String[]{f.this.gra.gpm}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12909", f.this.gra.gpo, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gra.fNt) && this.gra.fNt.get(0) != null) {
            this.grh = this.gra.fNt.get(0).blU();
            this.tid = this.gra.fNt.get(0).getId();
        }
        if (this.grh != null) {
            this.ajh.startLoad(this.grh.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gra.fNt.get(0).bmm())) {
                title = this.gra.fNt.get(0).bmm().toString();
            } else {
                title = this.gra.fNt.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fXE.setText(title);
            }
            this.mVideoUrl = this.grh.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12908", this.gra.gpo, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPs() {
        com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12910", this.gra.gpo, 2, this.tid);
        this.ajh.setVisibility(8);
        this.grg.setVisibility(8);
        if (this.giK != null) {
            this.giK.setVolume(0.0f, 0.0f);
            try {
                this.giK.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lC(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.gpn || TextUtils.isEmpty(aVar.gpk)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bPr() {
        super.bPr();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.giO;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fXE, R.color.CAM_X0111);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.giK == null || this.giK.isPlaying()) {
            this.grg.setVisibility(0);
            this.giK.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.giK == null || !this.giK.isPlaying()) {
            this.grg.setVisibility(8);
            this.giK.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.giK != null && !this.giK.isPlaying()) {
            this.ajh.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ah.aI(1, this.mVideoUrl)) {
                this.giK.setVideoPath(this.mVideoUrl);
                this.giK.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.giK != null) {
            this.giK.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.giK != null) {
            this.giK.stopPlayback();
            this.giK.dwS();
            this.giK = null;
        }
    }
}
