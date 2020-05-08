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
    private TbImageView afL;
    private TextView eHg;
    private QuickVideoView ePf;
    private ImageView eXr;
    private VideoInfo eXs;
    private g.b emF;
    private QuickVideoView.b emJ;
    private g.f evK;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.evK = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.ePk));
        this.ePf = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.ePf.setOnPreparedListener(this.evK);
        this.ePf.setOnErrorListener(this.emF);
        this.ePf.setOnSurfaceDestroyedListener(this.emJ);
        this.ePf.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.eXr = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.afL = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.afL.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.afL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eHg = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.eXl.eVx)) {
                    ba.aOV().a(f.this.mTbPageContext, new String[]{f.this.eXl.eVx}, true);
                    com.baidu.tieba.ala.alasquare.c.a.blS().c("c12909", f.this.eXl.eVz, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.eXl.etL) && this.eXl.etL.get(0) != null) {
            this.eXs = this.eXl.etL.get(0).aKT();
            this.tid = this.eXl.etL.get(0).getId();
        }
        if (this.eXs != null) {
            this.afL.startLoad(this.eXs.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.eXl.etL.get(0).aLj())) {
                title = this.eXl.etL.get(0).aLj().toString();
            } else {
                title = this.eXl.etL.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.eHg.setText(title);
            }
            this.mVideoUrl = this.eXs.video_url;
            com.baidu.tieba.ala.alasquare.c.a.blS().c("c12908", this.eXl.eVz, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.blS().c("c12910", this.eXl.eVz, 2, this.tid);
        this.afL.setVisibility(8);
        this.eXr.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.ePf.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void iR(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.eVy || TextUtils.isEmpty(aVar.eVv)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bmq() {
        super.bmq();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.ePk;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.eHg, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.ePf == null || this.ePf.isPlaying()) {
            this.eXr.setVisibility(0);
            this.ePf.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.ePf == null || !this.ePf.isPlaying()) {
            this.eXr.setVisibility(8);
            this.ePf.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.ePf != null && !this.ePf.isPlaying()) {
            this.afL.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.am(1, this.mVideoUrl)) {
                this.ePf.setVideoPath(this.mVideoUrl);
                this.ePf.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ePf != null) {
            this.ePf.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.ePf != null) {
            this.ePf.stopPlayback();
            this.ePf.setOnPreparedListener(null);
            this.ePf.setOnErrorListener(null);
            this.ePf.setOnSurfaceDestroyedListener(null);
            if (this.ePf.getParent() != null) {
                ((ViewGroup) this.ePf.getParent()).removeView(this.ePf);
            }
            this.ePf = null;
        }
    }
}
