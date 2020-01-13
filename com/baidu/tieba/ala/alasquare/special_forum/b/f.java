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
/* loaded from: classes2.dex */
public class f extends a {
    private TbImageView Mu;
    private g.b dIa;
    private QuickVideoView.b dIe;
    private g.f dQX;
    private TextView ecE;
    private QuickVideoView egS;
    private ImageView eoW;
    private VideoInfo eoX;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dQX = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.egX));
        this.egS = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.egS.setOnPreparedListener(this.dQX);
        this.egS.setOnErrorListener(this.dIa);
        this.egS.setOnSurfaceDestroyedListener(this.dIe);
        this.egS.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.eoW = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.Mu = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.Mu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.Mu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ecE = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.eoQ.emY)) {
                    ba.aEt().a(f.this.mTbPageContext, new String[]{f.this.eoQ.emY}, true);
                    com.baidu.tieba.ala.alasquare.c.a.baG().c("c12909", f.this.eoQ.ena, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.eoQ.dOX) && this.eoQ.dOX.get(0) != null) {
            this.eoX = this.eoQ.dOX.get(0).aAo();
            this.tid = this.eoQ.dOX.get(0).getId();
        }
        if (this.eoX != null) {
            this.Mu.startLoad(this.eoX.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.eoQ.dOX.get(0).aAE())) {
                title = this.eoQ.dOX.get(0).aAE().toString();
            } else {
                title = this.eoQ.dOX.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.ecE.setText(title);
            }
            this.mVideoUrl = this.eoX.video_url;
            com.baidu.tieba.ala.alasquare.c.a.baG().c("c12908", this.eoQ.ena, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.baG().c("c12910", this.eoQ.ena, 2, this.tid);
        this.Mu.setVisibility(8);
        this.eoW.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.egS.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hK(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.emZ || TextUtils.isEmpty(aVar.emW)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bbe() {
        super.bbe();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.egX;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.ecE, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.egS == null || this.egS.isPlaying()) {
            this.eoW.setVisibility(0);
            this.egS.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.egS == null || !this.egS.isPlaying()) {
            this.eoW.setVisibility(8);
            this.egS.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.egS != null && !this.egS.isPlaying()) {
            this.Mu.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.W(1, this.mVideoUrl)) {
                this.egS.setVideoPath(this.mVideoUrl);
                this.egS.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.egS != null) {
            this.egS.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.egS != null) {
            this.egS.stopPlayback();
            this.egS.setOnPreparedListener(null);
            this.egS.setOnErrorListener(null);
            this.egS.setOnSurfaceDestroyedListener(null);
            if (this.egS.getParent() != null) {
                ((ViewGroup) this.egS.getParent()).removeView(this.egS);
            }
            this.egS = null;
        }
    }
}
