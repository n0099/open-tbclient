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
    private TbImageView MW;
    private g.b dMg;
    private QuickVideoView.b dMk;
    private g.f dVd;
    private TextView egI;
    private QuickVideoView ekX;
    private ImageView eti;
    private VideoInfo etj;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dVd = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.elc));
        this.ekX = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.ekX.setOnPreparedListener(this.dVd);
        this.ekX.setOnErrorListener(this.dMg);
        this.ekX.setOnSurfaceDestroyedListener(this.dMk);
        this.ekX.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.eti = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.MW = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.MW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.MW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egI = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.etb.erm)) {
                    ba.aGG().a(f.this.mTbPageContext, new String[]{f.this.etb.erm}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12909", f.this.etb.ero, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.etb.dTe) && this.etb.dTe.get(0) != null) {
            this.etj = this.etb.dTe.get(0).aCF();
            this.tid = this.etb.dTe.get(0).getId();
        }
        if (this.etj != null) {
            this.MW.startLoad(this.etj.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.etb.dTe.get(0).aCV())) {
                title = this.etb.dTe.get(0).aCV().toString();
            } else {
                title = this.etb.dTe.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.egI.setText(title);
            }
            this.mVideoUrl = this.etj.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12908", this.etb.ero, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12910", this.etb.ero, 2, this.tid);
        this.MW.setVisibility(8);
        this.eti.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.ekX.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hR(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.ern || TextUtils.isEmpty(aVar.erk)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdv() {
        super.bdv();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.elc;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.egI, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.ekX == null || this.ekX.isPlaying()) {
            this.eti.setVisibility(0);
            this.ekX.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.ekX == null || !this.ekX.isPlaying()) {
            this.eti.setVisibility(8);
            this.ekX.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.ekX != null && !this.ekX.isPlaying()) {
            this.MW.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.X(1, this.mVideoUrl)) {
                this.ekX.setVideoPath(this.mVideoUrl);
                this.ekX.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ekX != null) {
            this.ekX.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.ekX != null) {
            this.ekX.stopPlayback();
            this.ekX.setOnPreparedListener(null);
            this.ekX.setOnErrorListener(null);
            this.ekX.setOnSurfaceDestroyedListener(null);
            if (this.ekX.getParent() != null) {
                ((ViewGroup) this.ekX.getParent()).removeView(this.ekX);
            }
            this.ekX = null;
        }
    }
}
