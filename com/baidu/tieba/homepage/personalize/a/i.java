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
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<n, d<com.baidu.tieba.card.j>> {
    public BdUniqueId bGw;
    private c.a bMO;
    private int cardShowType;
    private v ebB;
    private com.baidu.tieba.homepage.personalize.model.e efm;
    private com.baidu.tieba.card.j efr;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, n nVar) {
        if (view.getId() == this.efr.getView().getId()) {
            TiebaStatic.log(nVar.K(nVar.bXa));
        } else if (this.efr.ciL != null && this.efr.ciL.getBarNameTv() != null && view.getId() == this.efr.ciL.getBarNameTv().getId()) {
            TiebaStatic.log(nVar.akY());
        } else if (this.efr.cSr != null && this.efr.cSr.bcz != null && view.getId() == this.efr.cSr.bcz.getId()) {
            TiebaStatic.log(nVar.akY());
        } else if (this.efr.getHeaderImg() != null && view.getId() == this.efr.getHeaderImg().getId()) {
            TiebaStatic.log(nVar.L(nVar.bXa));
        } else if (this.efr.ake() != null && view.getId() == this.efr.ake().getId()) {
            TiebaStatic.log(nVar.L(nVar.bXa));
        } else if (this.efr.ciL != null && this.efr.ciL.getCommentContainer() != null && view.getId() == this.efr.ciL.getCommentContainer().getId()) {
            TiebaStatic.log(nVar.K(nVar.bXa));
        } else if (this.efr.cSp != null && view.getId() == this.efr.cSp.getId()) {
            TiebaStatic.log(nVar.K(nVar.bXa));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, n nVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", nVar.bXa.getTid()));
        } else if (view.getId() == this.efr.getView().getId()) {
            if (nVar.bXa.zU() != null && nVar.bXa.zU().channelId > 0) {
                nVar.t("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ab("tid", nVar.bXa.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", nVar.bXa.getId()));
            TiebaStatic.log(nVar.K(nVar.bXa));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", nVar.bXa.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMO = null;
        this.cardShowType = 0;
        this.ebB = new v<n>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                s.akF().de(true);
                if (i.this.efm != null && nVar != null && nVar.VK() != null && !StringUtils.isNull(nVar.VK().getTid()) && i.this.efr != null && i.this.efr.getView() != null) {
                    if (nVar.VK().aOX > 0) {
                        TiebaStatic.log(nVar.K(nVar.VK()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bK(com.baidu.adp.lib.g.b.c(nVar.VK().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bJ(com.baidu.adp.lib.g.b.c(nVar.VK().getTid(), 0L));
                        i.this.efm.a(com.baidu.adp.lib.g.b.c(nVar.VK().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.akN(), nVar.akP(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (i.this.mType == n.cXi) {
                        i.this.b(view, nVar);
                    } else if (i.this.mType == n.cXj) {
                        i.this.c(view, nVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBC();
    }

    private void aBC() {
        n.cXk = "c10708";
        n.cXl = "c10735";
        n.cXm = "c10756";
        n.cXn = "c10709";
        n.cXo = "c10734";
        n.cXp = "c11929";
        n.cXq = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.efr = new com.baidu.tieba.card.j(this.mPageContext);
        this.efr.currentPageType = 2;
        if (this.efr.ciL != null) {
            this.efr.ciL.bbP = 2;
        }
        if (this.efr.cSr != null && this.efr.cSr.bcA != null) {
            this.efr.cSr.bcA.bbP = 2;
        }
        this.efr.j(this.bGw);
        this.efr.b(this.ebB);
        return new d(this.efr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, d dVar) {
        if (nVar != null) {
            nVar.lH(i + 1);
            nVar.sourceType = 0;
        }
        dVar.alk().setVideoStatsData(b(nVar));
        if (nVar != null && nVar.bXa != null) {
            nVar.bXa.aPa = this.cardShowType;
        }
        dVar.alk().a(nVar);
        dVar.alk().a(this.bMO);
        if (nVar != null) {
            if (getType() != null && getType() == n.cXj) {
                s.akF().a(nVar.akW());
                ak akVar = new ak("c11003");
                bd VK = nVar.VK();
                if (VK != null) {
                    akVar.ab("tid", VK.getTid());
                    if (VK.yS() != null) {
                        akVar.s("ab_type", VK.yS().hadConcerned() ? 1 : 0);
                    }
                }
                s.akF().a(akVar);
            } else {
                s.akF().a(nVar.akW());
            }
        }
        return dVar.getView();
    }

    private aa b(n nVar) {
        aa aaVar = null;
        if (nVar != null) {
            aaVar = new aa();
            aaVar.mLocate = "1";
            aaVar.bAT = nVar.tid;
            if (nVar.VK() != null) {
                aaVar.cWM = String.valueOf(nVar.VK().getFid());
                if (nVar.VK().zk() != null) {
                    aaVar.gtZ = nVar.VK().zk().video_md5;
                }
            }
            aaVar.aLe = nVar.getExtra();
            aaVar.mSource = nVar.getSource();
            aaVar.gtY = nVar.akP();
            aaVar.gtW = nVar.getWeight();
        }
        return aaVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bMO = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efm = eVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
