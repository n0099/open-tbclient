package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.o, a> {
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private bx bLl;
    private com.baidu.tieba.homepage.personalize.b.f ctZ;
    private al cuc;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bLl = new k(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a a(ViewGroup viewGroup) {
        this.cuc = new al(this.EA);
        this.cuc.j(this.aTm);
        return new a(this.cuc);
    }

    private TextureVideoView.c b(com.baidu.tieba.card.a.o oVar) {
        TextureVideoView.c cVar = null;
        if (oVar != null) {
            cVar = new TextureVideoView.c();
            cVar.mLocate = "1";
            cVar.aep = oVar.QK;
            if (oVar.Iw() != null) {
                cVar.aeq = String.valueOf(oVar.Iw().getFid());
            }
        }
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.o oVar, a aVar) {
        if (oVar != null) {
            oVar.fH(i + 1);
        }
        aVar.cue.setVideoStatsData(b(oVar));
        aVar.cue.a(oVar);
        aVar.cue.a(this.bLl);
        if (oVar.aWa != null && oVar.aWa.getTid() != null) {
            bw.Lf().b(new ay("c11003").ab("tid", oVar.aWa.getTid()));
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public al cue;

        public a(al alVar) {
            super(alVar.getView());
            this.cue = alVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IA() {
            if (this.cue == null) {
                return false;
            }
            return this.cue.IA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cue == null) {
                return false;
            }
            return this.cue.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Iz() {
            if (this.cue != null) {
                this.cue.Iz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cue != null) {
                this.cue.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cue == null) {
                return null;
            }
            return this.cue.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cue == null) {
                return null;
            }
            return this.cue.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cue == null) {
                return 0;
            }
            return this.cue.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.ctZ = fVar;
    }
}
