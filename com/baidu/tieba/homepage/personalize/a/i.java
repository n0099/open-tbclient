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
    public BdUniqueId aSy;
    private c.a aYP;
    private v dof;
    private com.baidu.tieba.homepage.personalize.model.e drO;
    private com.baidu.tieba.card.j drT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, n nVar) {
        if (view.getId() == this.drT.getView().getId()) {
            TiebaStatic.log(nVar.G(nVar.bjE));
        } else if (this.drT.bvI != null && this.drT.bvI.getBarNameTv() != null && view.getId() == this.drT.bvI.getBarNameTv().getId()) {
            TiebaStatic.log(nVar.acq());
        } else if (this.drT.getHeaderImg() != null && view.getId() == this.drT.getHeaderImg().getId()) {
            TiebaStatic.log(nVar.H(nVar.bjE));
        } else if (this.drT.abw() != null && view.getId() == this.drT.abw().getId()) {
            TiebaStatic.log(nVar.H(nVar.bjE));
        } else if (this.drT.bvI != null && this.drT.bvI.getCommentContainer() != null && view.getId() == this.drT.bvI.getCommentContainer().getId()) {
            TiebaStatic.log(nVar.G(nVar.bjE));
        } else if (this.drT.bZf != null && view.getId() == this.drT.bZf.getId()) {
            TiebaStatic.log(nVar.G(nVar.bjE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, n nVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjE.getTid()));
        } else if (view.getId() == this.drT.getView().getId()) {
            if (nVar.bjE.sA() != null && nVar.bjE.sA().channelId > 0) {
                nVar.u("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjE.getTid()));
            TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", nVar.bjE.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjE.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYP = null;
        this.dof = new v<n>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                s.abX().cC(true);
                if (i.this.drO != null && nVar != null && nVar.Ox() != null && !StringUtils.isNull(nVar.Ox().getTid()) && i.this.drT != null && i.this.drT.getView() != null) {
                    if (nVar.Ox().aaA > 0) {
                        TiebaStatic.log(nVar.G(nVar.Ox()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bD(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bC(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L));
                        i.this.drO.a(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.acf(), nVar.ach(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == n.cdY) {
                        i.this.b(view, nVar);
                    } else if (i.this.mType == n.cdZ) {
                        i.this.c(view, nVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        auu();
    }

    private void auu() {
        n.cea = "c10708";
        n.ceb = "c10735";
        n.cec = "c10756";
        n.ced = "c10709";
        n.cee = "c10734";
        n.cef = "c11929";
        n.ceg = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.drT = new com.baidu.tieba.card.j(this.mPageContext);
        this.drT.currentPageType = 2;
        if (this.drT.bvI != null) {
            this.drT.bvI.anO = 2;
        }
        this.drT.k(this.aSy);
        this.drT.b(this.dof);
        return new d(this.drT);
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
        dVar.acC().setVideoStatsData(b(nVar));
        dVar.acC().a(nVar);
        dVar.acC().a(this.aYP);
        if (nVar != null) {
            if (getType() != null && getType() == n.cdZ) {
                s.abX().a(nVar.aco());
                ak akVar = new ak("c11003");
                bd Ox = nVar.Ox();
                if (Ox != null) {
                    akVar.ac("tid", Ox.getTid());
                    if (Ox.rv() != null) {
                        akVar.r("ab_type", Ox.rv().hadConcerned() ? 1 : 0);
                    }
                }
            } else {
                s.abX().a(nVar.aco());
            }
        }
        return dVar.getView();
    }

    private y b(n nVar) {
        y yVar = null;
        if (nVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aMU = nVar.tid;
            if (nVar.Ox() != null) {
                yVar.aAs = String.valueOf(nVar.Ox().getFid());
                if (nVar.Ox().rN() != null) {
                    yVar.fRm = nVar.Ox().rN().video_md5;
                }
            }
            yVar.WF = nVar.getExtra();
            yVar.mSource = nVar.getSource();
            yVar.fRl = nVar.ach();
            yVar.fRj = nVar.getWeight();
        }
        return yVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aYP = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.drO = eVar;
    }
}
