package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private com.baidu.tieba.homepage.personalize.b.f cFK;
    private cf cFL;
    private com.baidu.tieba.card.t cFS;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cFL = new r(this);
        this.GM = tbPageContext;
        amE();
    }

    private void amE() {
        com.baidu.tieba.card.data.o.bcb = "c10708";
        com.baidu.tieba.card.data.o.bcc = "c10735";
        com.baidu.tieba.card.data.o.bcd = "c10756";
        com.baidu.tieba.card.data.o.bce = "c10709";
        com.baidu.tieba.card.data.o.bcf = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public a a(ViewGroup viewGroup) {
        this.cFS = new com.baidu.tieba.card.t(this.GM);
        this.cFS.j(this.aYu);
        this.cFS.setOnSubCardOnClickListenner(this.cFL);
        return new a(this.cFS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, a aVar) {
        if (oVar != null) {
            oVar.gf(i + 1);
        }
        aVar.cFU.setVideoStatsData(b(oVar));
        aVar.cFU.onBindDataToView(oVar);
        if (oVar != null) {
            cd.NI().b(oVar.NY());
        }
        return aVar.getView();
    }

    private TextureVideoView.c b(com.baidu.tieba.card.data.o oVar) {
        TextureVideoView.c cVar = null;
        if (oVar != null) {
            cVar = new TextureVideoView.c();
            cVar.mLocate = "1";
            cVar.ahi = oVar.Tt;
            if (oVar.Kw() != null) {
                cVar.ahj = String.valueOf(oVar.Kw().getFid());
            }
        }
        return cVar;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public com.baidu.tieba.card.t cFU;

        public a(com.baidu.tieba.card.t tVar) {
            super(tVar.getView());
            this.cFU = tVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean KA() {
            if (this.cFU == null) {
                return false;
            }
            return this.cFU.KA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cFU == null) {
                return false;
            }
            return this.cFU.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Kz() {
            if (this.cFU != null) {
                this.cFU.Kz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cFU != null) {
                this.cFU.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cFU == null) {
                return null;
            }
            return this.cFU.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cFU == null) {
                return null;
            }
            return this.cFU.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cFU == null) {
                return 0;
            }
            return this.cFU.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cFK = fVar;
    }
}
