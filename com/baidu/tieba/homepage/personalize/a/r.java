package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.o, a> {
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private com.baidu.tieba.card.z crE;
    private com.baidu.tieba.homepage.personalize.b.f crw;
    private bx crx;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.crx = new s(this);
        this.Ea = tbPageContext;
        ahg();
    }

    private void ahg() {
        com.baidu.tieba.card.a.o.aVB = "c10708";
        com.baidu.tieba.card.a.o.aVC = "c10735";
        com.baidu.tieba.card.a.o.aVD = "c10756";
        com.baidu.tieba.card.a.o.aVE = "c10709";
        com.baidu.tieba.card.a.o.aVF = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a a(ViewGroup viewGroup) {
        this.crE = new com.baidu.tieba.card.z(this.Ea);
        this.crE.j(this.aSq);
        this.crE.a(this.crx);
        return new a(this.crE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.o oVar, a aVar) {
        if (oVar != null) {
            oVar.fI(i + 1);
        }
        aVar.crG.a(oVar);
        if (oVar != null) {
            bw.Lg().a(oVar.Lv());
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.card.z crG;

        public a(com.baidu.tieba.card.z zVar) {
            super(zVar.getView());
            this.crG = zVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IB() {
            if (this.crG == null) {
                return false;
            }
            return this.crG.IB();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.crG == null) {
                return false;
            }
            return this.crG.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void IA() {
            if (this.crG != null) {
                this.crG.IA();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.crG != null) {
                this.crG.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.crG == null) {
                return null;
            }
            return this.crG.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.crG == null) {
                return null;
            }
            return this.crG.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.crG == null) {
                return 0;
            }
            return this.crG.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.crw = fVar;
    }
}
