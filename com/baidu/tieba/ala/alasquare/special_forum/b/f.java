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
    private TextView gfR;
    private TbCyberVideoView gqV;
    private ImageView gzr;
    private VideoInfo gzs;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bTe();
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
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gqZ));
        this.gqV = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gqV.setOnPreparedListener(this.ety);
        this.gqV.setOnErrorListener(this.etz);
        this.gqV.setOnSurfaceDestroyedListener(this.fMW);
        this.gqV.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bTe();
            }
        });
        this.gqV.setStageType(null);
        this.gzr = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.akg = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.akg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.akg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfR = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.gzl.gxx)) {
                    bf.bua().a(f.this.mTbPageContext, new String[]{f.this.gzl.gxx}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12909", f.this.gzl.gxz, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.gzl.fVe) && this.gzl.fVe.get(0) != null) {
            this.gzs = this.gzl.fVe.get(0).bph();
            this.tid = this.gzl.fVe.get(0).getId();
        }
        if (this.gzs != null) {
            this.akg.startLoad(this.gzs.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.gzl.fVe.get(0).bpz())) {
                title = this.gzl.fVe.get(0).bpz().toString();
            } else {
                title = this.gzl.fVe.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.gfR.setText(title);
            }
            this.mVideoUrl = this.gzs.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12908", this.gzl.gxz, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTe() {
        com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12910", this.gzl.gxz, 2, this.tid);
        this.akg.setVisibility(8);
        this.gzr.setVisibility(8);
        if (this.gqV != null) {
            this.gqV.setVolume(0.0f, 0.0f);
            try {
                this.gqV.start();
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
        return (aVar == null || 2 != aVar.gxy || TextUtils.isEmpty(aVar.gxv)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTd() {
        super.bTd();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gqZ;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.gfR, (int) R.color.CAM_X0111);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.gqV == null || this.gqV.isPlaying()) {
            this.gzr.setVisibility(0);
            this.gqV.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gqV == null || !this.gqV.isPlaying()) {
            this.gzr.setVisibility(8);
            this.gqV.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gqV != null && !this.gqV.isPlaying()) {
            this.akg.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ai.aI(1, this.mVideoUrl)) {
                this.gqV.setVideoPath(this.mVideoUrl);
                this.gqV.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gqV != null) {
            this.gqV.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gqV != null) {
            this.gqV.stopPlayback();
            this.gqV.dCl();
            this.gqV = null;
        }
    }
}
