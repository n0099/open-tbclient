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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class f extends a {
    private TbImageView MX;
    private g.b dMJ;
    private QuickVideoView.b dMN;
    private g.f dVG;
    private TextView ehl;
    private QuickVideoView elA;
    private ImageView etR;
    private VideoInfo etS;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dVG = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.elF));
        this.elA = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.elA.setOnPreparedListener(this.dVG);
        this.elA.setOnErrorListener(this.dMJ);
        this.elA.setOnSurfaceDestroyedListener(this.dMN);
        this.elA.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.etR = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.MX = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.MX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.MX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ehl = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.etL.erW)) {
                    ba.aGK().a(f.this.mTbPageContext, new String[]{f.this.etL.erW}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12909", f.this.etL.erY, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.etL.dTH) && this.etL.dTH.get(0) != null) {
            this.etS = this.etL.dTH.get(0).aCI();
            this.tid = this.etL.dTH.get(0).getId();
        }
        if (this.etS != null) {
            this.MX.startLoad(this.etS.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.etL.dTH.get(0).aCY())) {
                title = this.etL.dTH.get(0).aCY().toString();
            } else {
                title = this.etL.dTH.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.ehl.setText(title);
            }
            this.mVideoUrl = this.etS.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12908", this.etL.erY, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12910", this.etL.erY, 2, this.tid);
        this.MX.setVisibility(8);
        this.etR.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.elA.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hS(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.erX || TextUtils.isEmpty(aVar.erU)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdB() {
        super.bdB();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.elF;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.ehl, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.elA == null || this.elA.isPlaying()) {
            this.etR.setVisibility(0);
            this.elA.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.elA == null || !this.elA.isPlaying()) {
            this.etR.setVisibility(8);
            this.elA.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.elA != null && !this.elA.isPlaying()) {
            this.MX.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.X(1, this.mVideoUrl)) {
                this.elA.setVideoPath(this.mVideoUrl);
                this.elA.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.elA != null) {
            this.elA.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.elA != null) {
            this.elA.stopPlayback();
            this.elA.setOnPreparedListener(null);
            this.elA.setOnErrorListener(null);
            this.elA.setOnSurfaceDestroyedListener(null);
            if (this.elA.getParent() != null) {
                ((ViewGroup) this.elA.getParent()).removeView(this.elA);
            }
            this.elA = null;
        }
    }
}
