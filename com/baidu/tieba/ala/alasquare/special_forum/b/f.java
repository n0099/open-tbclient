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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class f extends a {
    private QuickVideoView.b cTC;
    private g.b cTy;
    private String cln;
    private ImageView dCI;
    private TbImageView dCJ;
    private TextView dCK;
    private VideoInfo dCL;
    private g.f dcT;
    private QuickVideoView dvG;
    private View mContentView;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dcT = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.dvL));
        this.dvG = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.dvG.setOnPreparedListener(this.dcT);
        this.dvG.setOnErrorListener(this.cTy);
        this.dvG.setOnSurfaceDestroyedListener(this.cTC);
        this.dvG.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.dCI = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.dCJ = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.dCJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dCJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dCK = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.dCC.dBd)) {
                    ba.amO().a(f.this.mTbPageContext, new String[]{f.this.dCC.dBd}, true);
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12909", f.this.dCC.dBf, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.dCC.daV) && this.dCC.daV.get(0) != null) {
            this.dCL = this.dCC.daV.get(0).aiV();
            this.tid = this.dCC.daV.get(0).getId();
        }
        if (this.dCL != null) {
            this.dCJ.startLoad(this.dCL.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.dCC.daV.get(0).ajk())) {
                title = this.dCC.daV.get(0).ajk().toString();
            } else {
                title = this.dCC.daV.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.dCK.setText(title);
            }
            this.cln = this.dCL.video_url;
            com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12908", this.dCC.dBf, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12910", this.dCC.dBf, 2, this.tid);
        this.dCJ.setVisibility(8);
        this.dCI.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.dvG.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void gA(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.dBe || TextUtils.isEmpty(aVar.dBb)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKk() {
        super.aKk();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.dvL;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dCK, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.dvG == null || this.dvG.isPlaying()) {
            this.dCI.setVisibility(0);
            this.dvG.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.dvG == null || !this.dvG.isPlaying()) {
            this.dCI.setVisibility(8);
            this.dvG.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.dvG != null && !this.dvG.isPlaying()) {
            this.dCJ.setVisibility(0);
            if (!TextUtils.isEmpty(this.cln) && ac.M(1, this.cln)) {
                this.dvG.setVideoPath(this.cln);
                this.dvG.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.dvG != null) {
            this.dvG.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.dvG != null) {
            this.dvG.stopPlayback();
            this.dvG.setOnPreparedListener(null);
            this.dvG.setOnErrorListener(null);
            this.dvG.setOnSurfaceDestroyedListener(null);
            if (this.dvG.getParent() != null) {
                ((ViewGroup) this.dvG.getParent()).removeView(this.dvG);
            }
            this.dvG = null;
        }
    }
}
