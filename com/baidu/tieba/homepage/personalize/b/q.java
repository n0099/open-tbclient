package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.play.ax;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, a> {
    private TbPageContext<?> GO;
    private o.a afV;
    public BdUniqueId bcf;
    private com.baidu.tieba.homepage.personalize.c.f cLJ;
    private bz cLK;
    private com.baidu.tieba.card.r cLR;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afV = null;
        this.cLK = new r(this);
        this.GO = tbPageContext;
        aoM();
    }

    private void aoM() {
        com.baidu.tieba.card.data.o.bfs = "c10708";
        com.baidu.tieba.card.data.o.bft = "c10735";
        com.baidu.tieba.card.data.o.bfu = "c10756";
        com.baidu.tieba.card.data.o.bfv = "c10709";
        com.baidu.tieba.card.data.o.bfw = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a a(ViewGroup viewGroup) {
        this.cLR = new com.baidu.tieba.card.r(this.GO);
        this.cLR.OZ();
        this.cLR.j(this.bcf);
        this.cLR.setOnSubCardOnClickListenner(this.cLK);
        return new a(this.cLR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, a aVar) {
        if (oVar != null) {
            oVar.gk(i + 1);
            oVar.sourceType = 0;
        }
        aVar.cLT.a(b(oVar));
        aVar.cLT.onBindDataToView(oVar);
        aVar.cLT.a(this.afV);
        if (oVar != null) {
            bx.Pl().a(oVar.PD());
        }
        return aVar.getView();
    }

    private ax b(com.baidu.tieba.card.data.o oVar) {
        ax axVar = null;
        if (oVar != null) {
            axVar = new ax();
            axVar.mLocate = "1";
            axVar.aRO = oVar.TY;
            if (oVar.Jz() != null) {
                axVar.aRN = String.valueOf(oVar.Jz().getFid());
            }
            axVar.mSource = oVar.getSource();
            axVar.fgJ = oVar.Pp();
            axVar.fgK = oVar.getWeight();
        }
        return axVar;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.s {
        public com.baidu.tieba.card.r cLT;

        public a(com.baidu.tieba.card.r rVar) {
            super(rVar.getView());
            this.cLT = rVar;
        }

        @Override // com.baidu.tieba.play.s
        public boolean JS() {
            if (this.cLT == null) {
                return false;
            }
            return this.cLT.JS();
        }

        @Override // com.baidu.tieba.play.s
        public boolean isPlaying() {
            if (this.cLT == null) {
                return false;
            }
            return this.cLT.isPlaying();
        }

        @Override // com.baidu.tieba.play.s
        public void JT() {
            if (this.cLT != null) {
                this.cLT.JT();
            }
        }

        @Override // com.baidu.tieba.play.s
        public void stopPlay() {
            if (this.cLT != null) {
                this.cLT.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.s
        public View getVideoContainer() {
            if (this.cLT == null) {
                return null;
            }
            return this.cLT.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.s
        public String getPlayUrl() {
            if (this.cLT == null) {
                return null;
            }
            return this.cLT.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.s
        public int getCurrentPosition() {
            if (this.cLT == null) {
                return 0;
            }
            return this.cLT.getCurrentPosition();
        }
    }

    public void setEventCallback(o.a aVar) {
        this.afV = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cLJ = fVar;
    }
}
