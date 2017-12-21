package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId aSB;
    private c.a aYT;
    private v doj;
    private com.baidu.tieba.homepage.personalize.model.e drS;
    private com.baidu.tieba.card.j drX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, n nVar) {
        if (view.getId() == this.drX.getView().getId()) {
            TiebaStatic.log(nVar.G(nVar.bjI));
        } else if (this.drX.bvM != null && this.drX.bvM.getBarNameTv() != null && view.getId() == this.drX.bvM.getBarNameTv().getId()) {
            TiebaStatic.log(nVar.acp());
        } else if (this.drX.getHeaderImg() != null && view.getId() == this.drX.getHeaderImg().getId()) {
            TiebaStatic.log(nVar.H(nVar.bjI));
        } else if (this.drX.abw() != null && view.getId() == this.drX.abw().getId()) {
            TiebaStatic.log(nVar.H(nVar.bjI));
        } else if (this.drX.bvM != null && this.drX.bvM.getCommentContainer() != null && view.getId() == this.drX.bvM.getCommentContainer().getId()) {
            TiebaStatic.log(nVar.G(nVar.bjI));
        } else if (this.drX.bZj != null && view.getId() == this.drX.bZj.getId()) {
            TiebaStatic.log(nVar.G(nVar.bjI));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, n nVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjI.getTid()));
            TiebaStatic.log(nVar.G(nVar.bjI));
        } else if (view.getId() == this.drX.getView().getId()) {
            if (nVar.bjI.sA() != null && nVar.bjI.sA().channelId > 0) {
                nVar.u("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjI.getTid()));
            TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", nVar.bjI.getId()));
            TiebaStatic.log(nVar.G(nVar.bjI));
        } else {
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjI.getTid()));
            TiebaStatic.log(nVar.G(nVar.bjI));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYT = null;
        this.doj = new v<n>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                s.abW().cC(true);
                if (i.this.drS != null && nVar != null && nVar.Ox() != null && !StringUtils.isNull(nVar.Ox().getTid()) && i.this.drX != null && i.this.drX.getView() != null) {
                    if (nVar.Ox().aaD > 0) {
                        TiebaStatic.log(nVar.G(nVar.Ox()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bD(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bC(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L));
                        i.this.drS.a(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.ace(), nVar.acg(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == n.cec) {
                        i.this.b(view, nVar);
                    } else if (i.this.mType == n.ced) {
                        i.this.c(view, nVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        auu();
    }

    private void auu() {
        n.cee = "c10708";
        n.cef = "c10735";
        n.ceg = "c10756";
        n.ceh = "c10709";
        n.cei = "c10734";
        n.cej = "c11929";
        n.cek = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.drX = new com.baidu.tieba.card.j(this.mPageContext);
        this.drX.currentPageType = 2;
        if (this.drX.bvM != null) {
            this.drX.bvM.anR = 2;
        }
        this.drX.k(this.aSB);
        this.drX.b(this.doj);
        return new d(this.drX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.iG(i + 1);
            nVar.sourceType = 0;
        }
        dVar.acB().setVideoStatsData(b(nVar));
        dVar.acB().a(nVar);
        dVar.acB().a(this.aYT);
        if (nVar != null) {
            if (getType() != null && getType() == n.ced) {
                s.abW().a(nVar.acn());
                ak akVar = new ak("c11003");
                bd Ox = nVar.Ox();
                if (Ox != null) {
                    akVar.ac("tid", Ox.getTid());
                    if (Ox.rv() != null) {
                        akVar.r("ab_type", Ox.rv().hadConcerned() ? 1 : 0);
                    }
                }
            } else {
                s.abW().a(nVar.acn());
            }
        }
        return dVar.getView();
    }

    private y b(n nVar) {
        y yVar = null;
        if (nVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aMX = nVar.tid;
            if (nVar.Ox() != null) {
                yVar.aAv = String.valueOf(nVar.Ox().getFid());
                if (nVar.Ox().rN() != null) {
                    yVar.fRr = nVar.Ox().rN().video_md5;
                }
            }
            yVar.WI = nVar.getExtra();
            yVar.mSource = nVar.getSource();
            yVar.fRq = nVar.acg();
            yVar.fRo = nVar.getWeight();
        }
        return yVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aYT = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.drS = eVar;
    }
}
