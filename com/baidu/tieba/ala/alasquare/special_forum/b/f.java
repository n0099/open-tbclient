package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class f extends a {
    private TbImageView agi;
    private g.b eBv;
    private QuickVideoView.b eBz;
    private g.f eKx;
    private TextView eTO;
    private QuickVideoView fbX;
    private ImageView fkm;
    private VideoInfo fkn;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eKx = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.a(gVar);
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fcc));
        this.fbX = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fbX.setOnPreparedListener(this.eKx);
        this.fbX.setOnErrorListener(this.eBv);
        this.fbX.setOnSurfaceDestroyedListener(this.eBz);
        this.fbX.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.a(gVar);
            }
        });
        this.fkm = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.agi = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.agi.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.agi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eTO = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fkg.fir)) {
                    ba.aVa().a(f.this.mTbPageContext, new String[]{f.this.fkg.fir}, true);
                    com.baidu.tieba.ala.alasquare.c.a.brs().c("c12909", f.this.fkg.fit, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.fkg.eIv) && this.fkg.eIv.get(0) != null) {
            this.fkn = this.fkg.eIv.get(0).aQQ();
            this.tid = this.fkg.eIv.get(0).getId();
        }
        if (this.fkn != null) {
            this.agi.startLoad(this.fkn.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fkg.eIv.get(0).aRi())) {
                title = this.fkg.eIv.get(0).aRi().toString();
            } else {
                title = this.fkg.eIv.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.eTO.setText(title);
            }
            this.mVideoUrl = this.fkn.video_url;
            com.baidu.tieba.ala.alasquare.c.a.brs().c("c12908", this.fkg.fit, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.brs().c("c12910", this.fkg.fit, 2, this.tid);
        this.agi.setVisibility(8);
        this.fkm.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.fbX.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jj(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.fis || TextUtils.isEmpty(aVar.fip)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brQ() {
        super.brQ();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fcc;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.eTO, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fbX == null || this.fbX.isPlaying()) {
            this.fkm.setVisibility(0);
            this.fbX.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fbX == null || !this.fbX.isPlaying()) {
            this.fkm.setVisibility(8);
            this.fbX.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fbX != null && !this.fbX.isPlaying()) {
            this.agi.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ag.ar(1, this.mVideoUrl)) {
                this.fbX.setVideoPath(this.mVideoUrl);
                this.fbX.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fbX != null) {
            this.fbX.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fbX != null) {
            this.fbX.stopPlayback();
            this.fbX.setOnPreparedListener(null);
            this.fbX.setOnErrorListener(null);
            this.fbX.setOnSurfaceDestroyedListener(null);
            if (this.fbX.getParent() != null) {
                ((ViewGroup) this.fbX.getParent()).removeView(this.fbX);
            }
            this.fbX = null;
        }
    }
}
