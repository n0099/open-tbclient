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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class f extends a {
    private TbImageView ahm;
    private g.b eLe;
    private QuickVideoView.b eLi;
    private g.f eUJ;
    private TextView fdZ;
    private QuickVideoView fnh;
    private VideoInfo fvA;
    private ImageView fvz;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eUJ = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.a(gVar);
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.fnm));
        this.fnh = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.fnh.setOnPreparedListener(this.eUJ);
        this.fnh.setOnErrorListener(this.eLe);
        this.fnh.setOnSurfaceDestroyedListener(this.eLi);
        this.fnh.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.a(gVar);
            }
        });
        this.fvz = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.ahm = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.ahm.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ahm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fdZ = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.fvt.ftF)) {
                    bc.aWU().a(f.this.mTbPageContext, new String[]{f.this.fvt.ftF}, true);
                    com.baidu.tieba.ala.alasquare.c.a.buo().c("c12909", f.this.fvt.ftH, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!w.isEmpty(this.fvt.eSH) && this.fvt.eSH.get(0) != null) {
            this.fvA = this.fvt.eSH.get(0).aSH();
            this.tid = this.fvt.eSH.get(0).getId();
        }
        if (this.fvA != null) {
            this.ahm.startLoad(this.fvA.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.fvt.eSH.get(0).aSZ())) {
                title = this.fvt.eSH.get(0).aSZ().toString();
            } else {
                title = this.fvt.eSH.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.fdZ.setText(title);
            }
            this.mVideoUrl = this.fvA.video_url;
            com.baidu.tieba.ala.alasquare.c.a.buo().c("c12908", this.fvt.ftH, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.buo().c("c12910", this.fvt.ftH, 2, this.tid);
        this.ahm.setVisibility(8);
        this.fvz.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.fnh.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jw(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.ftG || TextUtils.isEmpty(aVar.ftD)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void buM() {
        super.buM();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.fnm;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        an.setViewTextColor(this.fdZ, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.fnh == null || this.fnh.isPlaying()) {
            this.fvz.setVisibility(0);
            this.fnh.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.fnh == null || !this.fnh.isPlaying()) {
            this.fvz.setVisibility(8);
            this.fnh.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.fnh != null && !this.fnh.isPlaying()) {
            this.ahm.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && ag.at(1, this.mVideoUrl)) {
                this.fnh.setVideoPath(this.mVideoUrl);
                this.fnh.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fnh != null) {
            this.fnh.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.fnh != null) {
            this.fnh.stopPlayback();
            this.fnh.setOnPreparedListener(null);
            this.fnh.setOnErrorListener(null);
            this.fnh.setOnSurfaceDestroyedListener(null);
            if (this.fnh.getParent() != null) {
                ((ViewGroup) this.fnh.getParent()).removeView(this.fnh);
            }
            this.fnh = null;
        }
    }
}
