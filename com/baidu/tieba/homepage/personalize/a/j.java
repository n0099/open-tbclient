package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.o, a> {
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private bx bJH;
    private com.baidu.tieba.homepage.personalize.b.f crp;
    private al crs;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJH = new k(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a a(ViewGroup viewGroup) {
        this.crs = new al(this.Ea);
        this.crs.j(this.aSq);
        return new a(this.crs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.o oVar, a aVar) {
        if (oVar != null) {
            oVar.fI(i + 1);
        }
        aVar.cru.a(oVar);
        aVar.cru.a(this.bJH);
        if (oVar.aVc != null && oVar.aVc.getTid() != null) {
            bw.Lg().a(new ay("c11003").ab("tid", oVar.aVc.getTid()));
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public al cru;

        public a(al alVar) {
            super(alVar.getView());
            this.cru = alVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean IB() {
            if (this.cru == null) {
                return false;
            }
            return this.cru.IB();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cru == null) {
                return false;
            }
            return this.cru.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void IA() {
            if (this.cru != null) {
                this.cru.IA();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cru != null) {
                this.cru.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cru == null) {
                return null;
            }
            return this.cru.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cru == null) {
                return null;
            }
            return this.cru.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cru == null) {
                return 0;
            }
            return this.cru.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.crp = fVar;
    }
}
