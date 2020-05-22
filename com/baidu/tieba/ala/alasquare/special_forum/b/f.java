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
    private g.b eBk;
    private QuickVideoView.b eBo;
    private g.f eKm;
    private TextView eTD;
    private QuickVideoView fbM;
    private ImageView fkb;
    private VideoInfo fkc;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eKm = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.a(gVar);
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fbR));
        this.fbM = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fbM.setOnPreparedListener(this.eKm);
        this.fbM.setOnErrorListener(this.eBk);
        this.fbM.setOnSurfaceDestroyedListener(this.eBo);
        this.fbM.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.a(gVar);
            }
        });
        this.fkb = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.agi = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.agi.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.agi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eTD = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fjV.fig)) {
                    ba.aUZ().a(f.this.mTbPageContext, new String[]{f.this.fjV.fig}, true);
                    com.baidu.tieba.ala.alasquare.c.a.brq().c("c12909", f.this.fjV.fii, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.fjV.eIk) && this.fjV.eIk.get(0) != null) {
            this.fkc = this.fjV.eIk.get(0).aQQ();
            this.tid = this.fjV.eIk.get(0).getId();
        }
        if (this.fkc != null) {
            this.agi.startLoad(this.fkc.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fjV.eIk.get(0).aRi())) {
                title = this.fjV.eIk.get(0).aRi().toString();
            } else {
                title = this.fjV.eIk.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.eTD.setText(title);
            }
            this.mVideoUrl = this.fkc.video_url;
            com.baidu.tieba.ala.alasquare.c.a.brq().c("c12908", this.fjV.fii, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.brq().c("c12910", this.fjV.fii, 2, this.tid);
        this.agi.setVisibility(8);
        this.fkb.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.fbM.start();
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
        return (aVar == null || 2 != aVar.fih || TextUtils.isEmpty(aVar.fie)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brO() {
        super.brO();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fbR;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.eTD, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fbM == null || this.fbM.isPlaying()) {
            this.fkb.setVisibility(0);
            this.fbM.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fbM == null || !this.fbM.isPlaying()) {
            this.fkb.setVisibility(8);
            this.fbM.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fbM != null && !this.fbM.isPlaying()) {
            this.agi.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ag.ar(1, this.mVideoUrl)) {
                this.fbM.setVideoPath(this.mVideoUrl);
                this.fbM.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fbM != null) {
            this.fbM.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fbM != null) {
            this.fbM.stopPlayback();
            this.fbM.setOnPreparedListener(null);
            this.fbM.setOnErrorListener(null);
            this.fbM.setOnSurfaceDestroyedListener(null);
            if (this.fbM.getParent() != null) {
                ((ViewGroup) this.fbM.getParent()).removeView(this.fbM);
            }
            this.fbM = null;
        }
    }
}
