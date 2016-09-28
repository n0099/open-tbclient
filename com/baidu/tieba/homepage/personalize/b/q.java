package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private com.baidu.tieba.card.r cGG;
    private com.baidu.tieba.homepage.personalize.c.f cGy;
    private cd cGz;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cGz = new r(this);
        this.GM = tbPageContext;
        amS();
    }

    private void amS() {
        com.baidu.tieba.card.data.o.bct = "c10708";
        com.baidu.tieba.card.data.o.bcu = "c10735";
        com.baidu.tieba.card.data.o.bcv = "c10756";
        com.baidu.tieba.card.data.o.bcw = "c10709";
        com.baidu.tieba.card.data.o.bcx = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public a a(ViewGroup viewGroup) {
        this.cGG = new com.baidu.tieba.card.r(this.GM);
        this.cGG.j(this.aYW);
        this.cGG.setOnSubCardOnClickListenner(this.cGz);
        return new a(this.cGG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, a aVar) {
        if (oVar != null) {
            oVar.gj(i + 1);
        }
        aVar.cGI.a(b(oVar));
        aVar.cGI.onBindDataToView(oVar);
        if (oVar != null) {
            cb.Oj().a(oVar.OA());
        }
        return aVar.getView();
    }

    private com.baidu.tieba.play.ad b(com.baidu.tieba.card.data.o oVar) {
        com.baidu.tieba.play.ad adVar = null;
        if (oVar != null) {
            adVar = new com.baidu.tieba.play.ad();
            adVar.mLocate = "1";
            adVar.aPH = oVar.TB;
            if (oVar.Jv() != null) {
                adVar.aPG = String.valueOf(oVar.Jv().getFid());
            }
        }
        return adVar;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.card.r cGI;

        public a(com.baidu.tieba.card.r rVar) {
            super(rVar.getView());
            this.cGI = rVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean Jr() {
            if (this.cGI == null) {
                return false;
            }
            return this.cGI.Jr();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cGI == null) {
                return false;
            }
            return this.cGI.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Js() {
            if (this.cGI != null) {
                this.cGI.Js();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cGI != null) {
                this.cGI.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cGI == null) {
                return null;
            }
            return this.cGI.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cGI == null) {
                return null;
            }
            return this.cGI.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cGI == null) {
                return 0;
            }
            return this.cGI.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cGy = fVar;
    }
}
