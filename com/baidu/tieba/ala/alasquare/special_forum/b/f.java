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
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class f extends a {
    private TbImageView akg;
    private CyberPlayerManager.OnPreparedListener ety;
    private CyberPlayerManager.OnErrorListener etz;
    private TbCyberVideoView.a fMW;
    private TextView gfP;
    private TbCyberVideoView gqT;
    private ImageView gzp;
    private VideoInfo gzq;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bTd();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gqX));
        this.gqT = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gqT.setOnPreparedListener(this.ety);
        this.gqT.setOnErrorListener(this.etz);
        this.gqT.setOnSurfaceDestroyedListener(this.fMW);
        this.gqT.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bTd();
            }
        });
        this.gqT.setStageType(null);
        this.gzp = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.akg = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.akg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.akg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfP = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gzj.gxv)) {
                    bf.bua().a(f.this.mTbPageContext, new String[]{f.this.gzj.gxv}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12909", f.this.gzj.gxx, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gzj.fVe) && this.gzj.fVe.get(0) != null) {
            this.gzq = this.gzj.fVe.get(0).bph();
            this.tid = this.gzj.fVe.get(0).getId();
        }
        if (this.gzq != null) {
            this.akg.startLoad(this.gzq.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gzj.fVe.get(0).bpz())) {
                title = this.gzj.fVe.get(0).bpz().toString();
            } else {
                title = this.gzj.fVe.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.gfP.setText(title);
            }
            this.mVideoUrl = this.gzq.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12908", this.gzj.gxx, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTd() {
        com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12910", this.gzj.gxx, 2, this.tid);
        this.akg.setVisibility(8);
        this.gzp.setVisibility(8);
        if (this.gqT != null) {
            this.gqT.setVolume(0.0f, 0.0f);
            try {
                this.gqT.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lX(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.gxw || TextUtils.isEmpty(aVar.gxt)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTc() {
        super.bTc();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gqX;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.gfP, R.color.CAM_X0111);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.gqT == null || this.gqT.isPlaying()) {
            this.gzp.setVisibility(0);
            this.gqT.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gqT == null || !this.gqT.isPlaying()) {
            this.gzp.setVisibility(8);
            this.gqT.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gqT != null && !this.gqT.isPlaying()) {
            this.akg.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ai.aI(1, this.mVideoUrl)) {
                this.gqT.setVideoPath(this.mVideoUrl);
                this.gqT.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gqT != null) {
            this.gqT.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gqT != null) {
            this.gqT.stopPlayback();
            this.gqT.dCk();
            this.gqT = null;
        }
    }
}
