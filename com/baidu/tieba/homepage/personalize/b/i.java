package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private cd bWu;
    private com.baidu.tieba.homepage.personalize.c.f cGr;
    private com.baidu.tieba.card.af cGu;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWu = new j(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public a a(ViewGroup viewGroup) {
        this.cGu = new com.baidu.tieba.card.af(this.GM);
        this.cGu.j(this.aYW);
        return new a(this.cGu);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, a aVar) {
        if (oVar != null) {
            oVar.gj(i + 1);
        }
        aVar.cGw.a(b(oVar));
        aVar.cGw.a(oVar);
        aVar.cGw.setOnSubCardOnClickListenner(this.bWu);
        if (oVar.bbU != null && oVar.bbU.getTid() != null) {
            cb.Oj().a(new ax("c11003").ab("tid", oVar.bbU.getTid()));
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.card.af cGw;

        public a(com.baidu.tieba.card.af afVar) {
            super(afVar.getView());
            this.cGw = afVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean Jr() {
            if (this.cGw == null) {
                return false;
            }
            return this.cGw.Jr();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cGw == null) {
                return false;
            }
            return this.cGw.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Js() {
            if (this.cGw != null) {
                this.cGw.Js();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cGw != null) {
                this.cGw.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cGw == null) {
                return null;
            }
            return this.cGw.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cGw == null) {
                return null;
            }
            return this.cGw.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cGw == null) {
                return 0;
            }
            return this.cGw.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cGr = fVar;
    }
}
