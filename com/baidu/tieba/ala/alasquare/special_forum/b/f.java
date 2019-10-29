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
    private g.b cUp;
    private QuickVideoView.b cUt;
    private String cmf;
    private TbImageView dDA;
    private TextView dDB;
    private VideoInfo dDC;
    private ImageView dDz;
    private g.f ddL;
    private QuickVideoView dwx;
    private View mContentView;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ddL = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.dwC));
        this.dwx = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.dwx.setOnPreparedListener(this.ddL);
        this.dwx.setOnErrorListener(this.cUp);
        this.dwx.setOnSurfaceDestroyedListener(this.cUt);
        this.dwx.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.dDz = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.dDA = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.dDA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.dDA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dDB = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.dDt.dBU)) {
                    ba.amQ().a(f.this.mTbPageContext, new String[]{f.this.dDt.dBU}, true);
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12909", f.this.dDt.dBW, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.dDt.dbM) && this.dDt.dbM.get(0) != null) {
            this.dDC = this.dDt.dbM.get(0).aiX();
            this.tid = this.dDt.dbM.get(0).getId();
        }
        if (this.dDC != null) {
            this.dDA.startLoad(this.dDC.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.dDt.dbM.get(0).ajm())) {
                title = this.dDt.dbM.get(0).ajm().toString();
            } else {
                title = this.dDt.dbM.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.dDB.setText(title);
            }
            this.cmf = this.dDC.video_url;
            com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12908", this.dDt.dBW, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12910", this.dDt.dBW, 2, this.tid);
        this.dDA.setVisibility(8);
        this.dDz.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.dwx.start();
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
        return (aVar == null || 2 != aVar.dBV || TextUtils.isEmpty(aVar.dBS)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKm() {
        super.aKm();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.dwC;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dDB, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.dwx == null || this.dwx.isPlaying()) {
            this.dDz.setVisibility(0);
            this.dwx.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.dwx == null || !this.dwx.isPlaying()) {
            this.dDz.setVisibility(8);
            this.dwx.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.dwx != null && !this.dwx.isPlaying()) {
            this.dDA.setVisibility(0);
            if (!TextUtils.isEmpty(this.cmf) && ac.N(1, this.cmf)) {
                this.dwx.setVideoPath(this.cmf);
                this.dwx.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.dwx != null) {
            this.dwx.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.dwx != null) {
            this.dwx.stopPlayback();
            this.dwx.setOnPreparedListener(null);
            this.dwx.setOnErrorListener(null);
            this.dwx.setOnSurfaceDestroyedListener(null);
            if (this.dwx.getParent() != null) {
                ((ViewGroup) this.dwx.getParent()).removeView(this.dwx);
            }
            this.dwx = null;
        }
    }
}
