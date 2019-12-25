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
    private TbImageView Mp;
    private g.b dHR;
    private QuickVideoView.b dHV;
    private g.f dQO;
    private TextView ecv;
    private QuickVideoView egI;
    private ImageView enI;
    private VideoInfo enJ;
    private View mContentView;
    private String mVideoUrl;
    private String tid;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dQO = new g.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                f.this.c(gVar);
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                return true;
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.3
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.mContentView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.egN));
        this.egI = (QuickVideoView) this.mContentView.findViewById(R.id.video_view);
        this.egI.setOnPreparedListener(this.dQO);
        this.egI.setOnErrorListener(this.dHR);
        this.egI.setOnSurfaceDestroyedListener(this.dHV);
        this.egI.setOnCompletionListener(new g.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.4
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                f.this.c(gVar);
            }
        });
        this.enI = (ImageView) this.mContentView.findViewById(R.id.video_play_btn);
        this.Mp = (TbImageView) this.mContentView.findViewById(R.id.video_cover_img);
        this.Mp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.Mp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ecv = (TextView) this.mContentView.findViewById(R.id.video_title);
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(f.this.enC.emb)) {
                    ba.aEa().a(f.this.mTbPageContext, new String[]{f.this.enC.emb}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bal().c("c12909", f.this.enC.emd, 2, f.this.tid);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        String title;
        super.a(aVar);
        if (!v.isEmpty(this.enC.dOP) && this.enC.dOP.get(0) != null) {
            this.enJ = this.enC.dOP.get(0).azV();
            this.tid = this.enC.dOP.get(0).getId();
        }
        if (this.enJ != null) {
            this.Mp.startLoad(this.enJ.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.enC.dOP.get(0).aAl())) {
                title = this.enC.dOP.get(0).aAl().toString();
            } else {
                title = this.enC.dOP.get(0).getTitle();
            }
            if (!TextUtils.isEmpty(title)) {
                this.ecv.setText(title);
            }
            this.mVideoUrl = this.enJ.video_url;
            com.baidu.tieba.ala.alasquare.c.a.bal().c("c12908", this.enC.emd, 2, this.tid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        com.baidu.tieba.ala.alasquare.c.a.bal().c("c12910", this.enC.emd, 2, this.tid);
        this.Mp.setVisibility(8);
        this.enI.setVisibility(8);
        if (gVar != null) {
            gVar.setVolume(0.0f, 0.0f);
            try {
                this.egI.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hF(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 2 != aVar.emc || TextUtils.isEmpty(aVar.elZ)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void baJ() {
        super.baJ();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        layoutParams.width = this.mScreenWidth;
        layoutParams.height = this.egN;
        this.mContentView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.ecv, (int) R.color.cp_cont_g);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        if (this.egI == null || this.egI.isPlaying()) {
            this.enI.setVisibility(0);
            this.egI.pause();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        if (this.egI == null || !this.egI.isPlaying()) {
            this.enI.setVisibility(8);
            this.egI.start();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (this.egI != null && !this.egI.isPlaying()) {
            this.Mp.setVisibility(0);
            if (!TextUtils.isEmpty(this.mVideoUrl) && af.U(1, this.mVideoUrl)) {
                this.egI.setVideoPath(this.mVideoUrl);
                this.egI.setLooping(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.egI != null) {
            this.egI.stopPlayback();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        if (this.egI != null) {
            this.egI.stopPlayback();
            this.egI.setOnPreparedListener(null);
            this.egI.setOnErrorListener(null);
            this.egI.setOnSurfaceDestroyedListener(null);
            if (this.egI.getParent() != null) {
                ((ViewGroup) this.egI.getParent()).removeView(this.egI);
            }
            this.egI = null;
        }
    }
}
