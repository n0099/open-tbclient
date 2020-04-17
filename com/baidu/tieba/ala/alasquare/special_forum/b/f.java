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
    private TbImageView afI;
    private TextView eHb;
    private QuickVideoView ePa;
    private ImageView eXm;
    private VideoInfo eXn;
    private g.b emA;
    private QuickVideoView.b emE;
    private g.f evF;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.evF = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.ePf));
        this.ePa = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.ePa.setOnPreparedListener(this.evF);
        this.ePa.setOnErrorListener(this.emA);
        this.ePa.setOnSurfaceDestroyedListener(this.emE);
        this.ePa.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.eXm = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.afI = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.afI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.afI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eHb = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.eXg.eVs)) {
                    ba.aOY().a(f.this.mTbPageContext, new String[]{f.this.eXg.eVs}, true);
                    com.baidu.tieba.ala.alasquare.c.a.blU().c("c12909", f.this.eXg.eVu, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.eXg.etG) && this.eXg.etG.get(0) != null) {
            this.eXn = this.eXg.etG.get(0).aKV();
            this.tid = this.eXg.etG.get(0).getId();
        }
        if (this.eXn != null) {
            this.afI.startLoad(this.eXn.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.eXg.etG.get(0).aLl())) {
                title = this.eXg.etG.get(0).aLl().toString();
            } else {
                title = this.eXg.etG.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.eHb.setText(title);
            }
            this.mVideoUrl = this.eXn.video_url;
            com.baidu.tieba.ala.alasquare.c.a.blU().c("c12908", this.eXg.eVu, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.blU().c("c12910", this.eXg.eVu, 2, this.tid);
        this.afI.setVisibility(8);
        this.eXm.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.ePa.start();
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
        return (aVar == null || 2 != aVar.eVt || TextUtils.isEmpty(aVar.eVq)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bms() {
        super.bms();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.ePf;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.eHb, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.ePa == null || this.ePa.isPlaying()) {
            this.eXm.setVisibility(0);
            this.ePa.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.ePa == null || !this.ePa.isPlaying()) {
            this.eXm.setVisibility(8);
            this.ePa.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.ePa != null && !this.ePa.isPlaying()) {
            this.afI.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.am(1, this.mVideoUrl)) {
                this.ePa.setVideoPath(this.mVideoUrl);
                this.ePa.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ePa != null) {
            this.ePa.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.ePa != null) {
            this.ePa.stopPlayback();
            this.ePa.setOnPreparedListener(null);
            this.ePa.setOnErrorListener(null);
            this.ePa.setOnSurfaceDestroyedListener(null);
            if (this.ePa.getParent() != null) {
                ((ViewGroup) this.ePa.getParent()).removeView(this.ePa);
            }
            this.ePa = null;
        }
    }
}
