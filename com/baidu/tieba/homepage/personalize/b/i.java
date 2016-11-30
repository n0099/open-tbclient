package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.play.ax;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, a> {
    private TbPageContext<?> GO;
    private bz bZL;
    public BdUniqueId bcf;
    private com.baidu.tieba.homepage.personalize.c.f cLC;
    private com.baidu.tieba.card.af cLF;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZL = new j(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a a(ViewGroup viewGroup) {
        this.cLF = new com.baidu.tieba.card.af(this.GO);
        this.cLF.j(this.bcf);
        return new a(this.cLF);
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
        }
        return axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, a aVar) {
        if (oVar != null) {
            oVar.gk(i + 1);
        }
        aVar.cLH.a(b(oVar));
        aVar.cLH.a(oVar);
        aVar.cLH.setOnSubCardOnClickListenner(this.bZL);
        if (oVar.beS != null && oVar.beS.getTid() != null) {
            bx.Pl().a(new av("c11003").ab("tid", oVar.beS.getTid()));
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.s {
        public com.baidu.tieba.card.af cLH;

        public a(com.baidu.tieba.card.af afVar) {
            super(afVar.getView());
            this.cLH = afVar;
        }

        @Override // com.baidu.tieba.play.s
        public boolean JS() {
            if (this.cLH == null) {
                return false;
            }
            return this.cLH.JS();
        }

        @Override // com.baidu.tieba.play.s
        public boolean isPlaying() {
            if (this.cLH == null) {
                return false;
            }
            return this.cLH.isPlaying();
        }

        @Override // com.baidu.tieba.play.s
        public void JT() {
            if (this.cLH != null) {
                this.cLH.JT();
            }
        }

        @Override // com.baidu.tieba.play.s
        public void stopPlay() {
            if (this.cLH != null) {
                this.cLH.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.s
        public View getVideoContainer() {
            if (this.cLH == null) {
                return null;
            }
            return this.cLH.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.s
        public String getPlayUrl() {
            if (this.cLH == null) {
                return null;
            }
            return this.cLH.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.s
        public int getCurrentPosition() {
            if (this.cLH == null) {
                return 0;
            }
            return this.cLH.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cLC = fVar;
    }
}
