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
    private g.b dMt;
    private QuickVideoView.b dMx;
    private g.f dVq;
    private TextView egV;
    private QuickVideoView elk;
    private ImageView etv;
    private VideoInfo etw;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dVq = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.elp));
        this.elk = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.elk.setOnPreparedListener(this.dVq);
        this.elk.setOnErrorListener(this.dMt);
        this.elk.setOnSurfaceDestroyedListener(this.dMx);
        this.elk.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.etv = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.MW = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.MW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.MW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egV = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.etp.erA)) {
                    ba.aGG().a(f.this.mTbPageContext, new String[]{f.this.etp.erA}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12909", f.this.etp.erC, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.etp.dTr) && this.etp.dTr.get(0) != null) {
            this.etw = this.etp.dTr.get(0).aCF();
            this.tid = this.etp.dTr.get(0).getId();
        }
        if (this.etw != null) {
            this.MW.startLoad(this.etw.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.etp.dTr.get(0).aCV())) {
                title = this.etp.dTr.get(0).aCV().toString();
            } else {
                title = this.etp.dTr.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.egV.setText(title);
            }
            this.mVideoUrl = this.etw.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12908", this.etp.erC, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12910", this.etp.erC, 2, this.tid);
        this.MW.setVisibility(8);
        this.etv.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.elk.start();
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
        return (aVar == null || 2 != aVar.erB || TextUtils.isEmpty(aVar.ery)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdw() {
        super.bdw();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.elp;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.egV, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.elk == null || this.elk.isPlaying()) {
            this.etv.setVisibility(0);
            this.elk.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.elk == null || !this.elk.isPlaying()) {
            this.etv.setVisibility(8);
            this.elk.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.elk != null && !this.elk.isPlaying()) {
            this.MW.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.X(1, this.mVideoUrl)) {
                this.elk.setVideoPath(this.mVideoUrl);
                this.elk.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.elk != null) {
            this.elk.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.elk != null) {
            this.elk.stopPlayback();
            this.elk.setOnPreparedListener(null);
            this.elk.setOnErrorListener(null);
            this.elk.setOnSurfaceDestroyedListener(null);
            if (this.elk.getParent() != null) {
                ((ViewGroup) this.elk.getParent()).removeView(this.elk);
            }
            this.elk = null;
        }
    }
}
