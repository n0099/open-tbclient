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
    private g.b dMf;
    private QuickVideoView.b dMj;
    private g.f dVc;
    private TextView egH;
    private QuickVideoView ekW;
    private ImageView eth;
    private VideoInfo eti;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dVc = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.elb));
        this.ekW = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.ekW.setOnPreparedListener(this.dVc);
        this.ekW.setOnErrorListener(this.dMf);
        this.ekW.setOnSurfaceDestroyedListener(this.dMj);
        this.ekW.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.eth = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.MW = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.MW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.MW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egH = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.eta.erl)) {
                    ba.aGE().a(f.this.mTbPageContext, new String[]{f.this.eta.erl}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12909", f.this.eta.ern, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.eta.dTd) && this.eta.dTd.get(0) != null) {
            this.eti = this.eta.dTd.get(0).aCD();
            this.tid = this.eta.dTd.get(0).getId();
        }
        if (this.eti != null) {
            this.MW.startLoad(this.eti.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.eta.dTd.get(0).aCT())) {
                title = this.eta.dTd.get(0).aCT().toString();
            } else {
                title = this.eta.dTd.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.egH.setText(title);
            }
            this.mVideoUrl = this.eti.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12908", this.eta.ern, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12910", this.eta.ern, 2, this.tid);
        this.MW.setVisibility(8);
        this.eth.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.ekW.start();
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
        return (aVar == null || 2 != aVar.erm || TextUtils.isEmpty(aVar.erj)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdt() {
        super.bdt();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.elb;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.egH, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.ekW == null || this.ekW.isPlaying()) {
            this.eth.setVisibility(0);
            this.ekW.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.ekW == null || !this.ekW.isPlaying()) {
            this.eth.setVisibility(8);
            this.ekW.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.ekW != null && !this.ekW.isPlaying()) {
            this.MW.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.X(1, this.mVideoUrl)) {
                this.ekW.setVideoPath(this.mVideoUrl);
                this.ekW.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ekW != null) {
            this.ekW.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.ekW != null) {
            this.ekW.stopPlayback();
            this.ekW.setOnPreparedListener(null);
            this.ekW.setOnErrorListener(null);
            this.ekW.setOnSurfaceDestroyedListener(null);
            if (this.ekW.getParent() != null) {
                ((ViewGroup) this.ekW.getParent()).removeView(this.ekW);
            }
            this.ekW = null;
        }
    }
}
