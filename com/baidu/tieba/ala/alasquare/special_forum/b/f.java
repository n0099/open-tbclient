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
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnErrorListener eoh;
    private TbCyberVideoView.a fFI;
    private TextView fXX;
    private TbCyberVideoView gjd;
    private VideoInfo grA;
    private ImageView grz;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                f.this.bPZ();
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                return true;
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.gjh));
        this.gjd = (TbCyberVideoView) this.mContentView.findViewById(R.id.video_view);
        this.gjd.setOnPreparedListener(this.eog);
        this.gjd.setOnErrorListener(this.eoh);
        this.gjd.setOnSurfaceDestroyedListener(this.fFI);
        this.gjd.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                f.this.bPZ();
            }
        });
        this.gjd.setStageType(null);
        this.grz = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ajc = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ajc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ajc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fXX = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.grt.gpF)) {
                    be.brr().a(f.this.mTbPageContext, new String[]{f.this.grt.gpF}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bPC().c("c12909", f.this.grt.gpH, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!y.isEmpty(this.grt.fNQ) && this.grt.fNQ.get(0) != null) {
            this.grA = this.grt.fNQ.get(0).bmS();
            this.tid = this.grt.fNQ.get(0).getId();
        }
        if (this.grA != null) {
            this.ajc.startLoad(this.grA.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.grt.fNQ.get(0).bnk())) {
                title = this.grt.fNQ.get(0).bnk().toString();
            } else {
                title = this.grt.fNQ.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fXX.setText(title);
            }
            this.mVideoUrl = this.grA.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bPC().c("c12908", this.grt.gpH, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPZ() {
        com.baidu.tieba.ala.alasquare.c.a.bPC().c("c12910", this.grt.gpH, 2, this.tid);
        this.ajc.setVisibility(8);
        this.grz.setVisibility(8);
        if (this.gjd != null) {
            this.gjd.setVolume(0.0f, 0.0f);
            try {
                this.gjd.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lB(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.gpG || TextUtils.isEmpty(aVar.gpD)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bPY() {
        super.bPY();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.gjh;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fXX, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.gjd == null || this.gjd.isPlaying()) {
            this.grz.setVisibility(0);
            this.gjd.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.gjd == null || !this.gjd.isPlaying()) {
            this.grz.setVisibility(8);
            this.gjd.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.gjd != null && !this.gjd.isPlaying()) {
            this.ajc.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ai.aK(1, this.mVideoUrl)) {
                this.gjd.setVideoPath(this.mVideoUrl);
                this.gjd.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gjd != null) {
            this.gjd.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.gjd != null) {
            this.gjd.stopPlayback();
            this.gjd.dxs();
            this.gjd = null;
        }
    }
}
