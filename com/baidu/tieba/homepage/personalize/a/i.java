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
    public BdUniqueId aSv;
    private c.a aYN;
    private v dmZ;
    private com.baidu.tieba.homepage.personalize.model.e dqJ;
    private com.baidu.tieba.card.j dqO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, n nVar) {
        if (view.getId() == this.dqO.getView().getId()) {
            TiebaStatic.log(nVar.E(nVar.bjD));
        } else if (this.dqO.bvH != null && this.dqO.bvH.getBarNameTv() != null && view.getId() == this.dqO.bvH.getBarNameTv().getId()) {
            TiebaStatic.log(nVar.acg());
        } else if (this.dqO.getHeaderImg() != null && view.getId() == this.dqO.getHeaderImg().getId()) {
            TiebaStatic.log(nVar.F(nVar.bjD));
        } else if (this.dqO.abv() != null && view.getId() == this.dqO.abv().getId()) {
            TiebaStatic.log(nVar.F(nVar.bjD));
        } else if (this.dqO.bvH != null && this.dqO.bvH.getCommentContainer() != null && view.getId() == this.dqO.bvH.getCommentContainer().getId()) {
            TiebaStatic.log(nVar.E(nVar.bjD));
        } else if (this.dqO.bZb != null && view.getId() == this.dqO.bZb.getId()) {
            TiebaStatic.log(nVar.E(nVar.bjD));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, n nVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjD.getTid()));
        } else if (view.getId() == this.dqO.getView().getId()) {
            if (nVar.bjD.sC() != null && nVar.bjD.sC().channelId > 0) {
                nVar.t("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjD.getTid()));
            TiebaStatic.log(new ak("c10806").r("obj_locate", 1).ac("tid", nVar.bjD.getId()));
        } else {
            TiebaStatic.log(new ak("c11004").ac("tid", nVar.bjD.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYN = null;
        this.dmZ = new v<n>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                s.abU().cB(true);
                if (i.this.dqJ != null && nVar != null && nVar.Ox() != null && !StringUtils.isNull(nVar.Ox().getTid()) && i.this.dqO != null && i.this.dqO.getView() != null) {
                    if (nVar.Ox().aaG > 0) {
                        TiebaStatic.log(nVar.E(nVar.Ox()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bD(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bC(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L));
                        i.this.dqJ.a(com.baidu.adp.lib.g.b.c(nVar.Ox().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.abV(), nVar.abX(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == n.cdK) {
                        i.this.b(view, nVar);
                    } else if (i.this.mType == n.cdL) {
                        i.this.c(view, nVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aul();
    }

    private void aul() {
        n.cdM = "c10708";
        n.cdN = "c10735";
        n.cdO = "c10756";
        n.cdP = "c10709";
        n.cdQ = "c10734";
        n.cdR = "c11929";
        n.cdS = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.dqO = new com.baidu.tieba.card.j(this.mPageContext);
        this.dqO.currentPageType = 2;
        if (this.dqO.bvH != null) {
            this.dqO.bvH.anM = 2;
        }
        this.dqO.k(this.aSv);
        this.dqO.b(this.dmZ);
        return new d(this.dqO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.iE(i + 1);
            nVar.sourceType = 0;
        }
        dVar.acs().setVideoStatsData(b(nVar));
        dVar.acs().a(nVar);
        dVar.acs().a(this.aYN);
        if (nVar != null) {
            if (getType() != null && getType() == n.cdL) {
                s.abU().a(nVar.ace());
                ak akVar = new ak("c11003");
                bd Ox = nVar.Ox();
                if (Ox != null) {
                    akVar.ac("tid", Ox.getTid());
                    if (Ox.rx() != null) {
                        akVar.r("ab_type", Ox.rx().hadConcerned() ? 1 : 0);
                    }
                }
            } else {
                s.abU().a(nVar.ace());
            }
        }
        return dVar.getView();
    }

    private y b(n nVar) {
        y yVar = null;
        if (nVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aMR = nVar.tid;
            if (nVar.Ox() != null) {
                yVar.aAn = String.valueOf(nVar.Ox().getFid());
                if (nVar.Ox().rP() != null) {
                    yVar.fQt = nVar.Ox().rP().video_md5;
                }
            }
            yVar.WL = nVar.getExtra();
            yVar.mSource = nVar.getSource();
            yVar.fQs = nVar.abX();
            yVar.fQq = nVar.getWeight();
        }
        return yVar;
    }

    public void setEventCallback(c.a aVar) {
        this.aYN = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dqJ = eVar;
    }
}
