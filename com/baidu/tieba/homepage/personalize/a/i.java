package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
import com.baidu.tieba.card.ah;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private cf bWv;
    private com.baidu.tieba.homepage.personalize.b.f cFD;
    private ah cFG;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bWv = new j(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public a a(ViewGroup viewGroup) {
        this.cFG = new ah(this.GM);
        this.cFG.j(this.aYu);
        return new a(this.cFG);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, a aVar) {
        if (oVar != null) {
            oVar.gf(i + 1);
        }
        aVar.cFI.setVideoStatsData(b(oVar));
        aVar.cFI.a(oVar);
        aVar.cFI.setOnSubCardOnClickListenner(this.bWv);
        if (oVar.bbC != null && oVar.bbC.getTid() != null) {
            cd.NI().b(new ay("c11003").ab("tid", oVar.bbC.getTid()));
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements com.baidu.tieba.play.d {
        public ah cFI;

        public a(ah ahVar) {
            super(ahVar.getView());
            this.cFI = ahVar;
        }

        @Override // com.baidu.tieba.play.d
        public boolean KA() {
            if (this.cFI == null) {
                return false;
            }
            return this.cFI.KA();
        }

        @Override // com.baidu.tieba.play.d
        public boolean isPlaying() {
            if (this.cFI == null) {
                return false;
            }
            return this.cFI.isPlaying();
        }

        @Override // com.baidu.tieba.play.d
        public void Kz() {
            if (this.cFI != null) {
                this.cFI.Kz();
            }
        }

        @Override // com.baidu.tieba.play.d
        public void stopPlay() {
            if (this.cFI != null) {
                this.cFI.stopPlay();
            }
        }

        @Override // com.baidu.tieba.play.d
        public View getVideoContainer() {
            if (this.cFI == null) {
                return null;
            }
            return this.cFI.getVideoContainer();
        }

        @Override // com.baidu.tieba.play.d
        public String getPlayUrl() {
            if (this.cFI == null) {
                return null;
            }
            return this.cFI.getPlayUrl();
        }

        @Override // com.baidu.tieba.play.d
        public int getCurrentPosition() {
            if (this.cFI == null) {
                return 0;
            }
            return this.cFI.getCurrentPosition();
        }
    }

    public void a(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cFD = fVar;
    }
}
