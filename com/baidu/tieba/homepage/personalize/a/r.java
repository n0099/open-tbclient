package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.o, a> {
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private com.baidu.tieba.homepage.personalize.b.f cug;
    private bx cuh;
    private com.baidu.tieba.card.z cuo;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cuh = new s(this);
        this.EA = tbPageContext;
        ahP();
    }

    private void ahP() {
        com.baidu.tieba.card.a.o.aWz = "c10708";
        com.baidu.tieba.card.a.o.aWA = "c10735";
        com.baidu.tieba.card.a.o.aWB = "c10756";
        com.baidu.tieba.card.a.o.aWC = "c10709";
        com.baidu.tieba.card.a.o.aWD = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a a(ViewGroup viewGroup) {
        this.cuo = new com.baidu.tieba.card.z(this.EA);
        this.cuo.j(this.aTm);
        this.cuo.a(this.cuh);
        return new a(this.cuo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.o oVar, a aVar) {
        if (oVar != null) {
            oVar.fH(i + 1);
        }
        aVar.cuq.setVideoStatsData(b(oVar));
        aVar.cuq.a(oVar);
        if (oVar != null) {
            bw.Lf().b(oVar.Lu());
        }
        return aVar.getView();
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

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.card.z cuq;

        public a(com.baidu.tieba.card.z zVar) {
            super(zVar.getView());
            this.cuq = zVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IA() {
            if (this.cuq == null) {
                return false;
            }
            return this.cuq.IA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cuq == null) {
                return false;
            }
            return this.cuq.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Iz() {
            if (this.cuq != null) {
                this.cuq.Iz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cuq != null) {
                this.cuq.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cuq == null) {
                return null;
            }
            return this.cuq.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cuq == null) {
                return null;
            }
            return this.cuq.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cuq == null) {
                return 0;
            }
            return this.cuq.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cug = fVar;
    }
}
