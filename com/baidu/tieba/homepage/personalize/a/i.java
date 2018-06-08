package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, c<n>> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private NEGFeedBackView.a bgZ;
    private ab dNe;
    private com.baidu.tieba.homepage.personalize.model.e dQU;
    private n dQZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.dQZ.getView().getId()) {
            TiebaStatic.log(lVar.O(lVar.brC));
        } else if (this.dQZ.bFe != null && this.dQZ.bFe.getBarNameTv() != null && view.getId() == this.dQZ.bFe.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.ajC());
        } else if (this.dQZ.bFT != null && this.dQZ.bFT.axM != null && view.getId() == this.dQZ.bFT.axM.getId()) {
            TiebaStatic.log(lVar.ajC());
        } else if (this.dQZ.getHeaderImg() != null && view.getId() == this.dQZ.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.P(lVar.brC));
        } else if (this.dQZ.aiL() != null && view.getId() == this.dQZ.aiL().getId()) {
            TiebaStatic.log(lVar.P(lVar.brC));
        } else if (this.dQZ.bFe != null && this.dQZ.bFe.getCommentContainer() != null && view.getId() == this.dQZ.bFe.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.O(lVar.brC));
        } else if (this.dQZ.cvM != null && view.getId() == this.dQZ.cvM.getId()) {
            TiebaStatic.log(lVar.O(lVar.brC));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new am("c11004").ah("tid", lVar.brC.getTid()));
        } else if (view.getId() == this.dQZ.getView().getId()) {
            if (lVar.brC.wm() != null && lVar.brC.wm().channelId > 0) {
                lVar.p("c11929", true);
            }
            TiebaStatic.log(new am("c11004").ah("tid", lVar.brC.getTid()));
            TiebaStatic.log(new am("c10806").r("obj_locate", 1).ah("tid", lVar.brC.getId()));
            TiebaStatic.log(lVar.O(lVar.brC));
        } else {
            TiebaStatic.log(new am("c11004").ah("tid", lVar.brC.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgZ = null;
        this.dNe = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.ajh().cG(true);
                if (i.this.dQU != null && lVar != null && lVar.Sz() != null && !StringUtils.isNull(lVar.Sz().getTid()) && i.this.dQZ != null && i.this.dQZ.getView() != null) {
                    if (lVar.Sz().ajN > 0) {
                        TiebaStatic.log(lVar.O(lVar.Sz()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bQ(com.baidu.adp.lib.g.b.c(lVar.Sz().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bP(com.baidu.adp.lib.g.b.c(lVar.Sz().getTid(), 0L));
                        i.this.dQU.a(com.baidu.adp.lib.g.b.c(lVar.Sz().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ajp(), lVar.ajr(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cBN) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cBO) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aCS();
    }

    private void aCS() {
        com.baidu.tieba.card.data.l.cBP = "c10708";
        com.baidu.tieba.card.data.l.cBQ = "c10735";
        com.baidu.tieba.card.data.l.cBR = "c10756";
        com.baidu.tieba.card.data.l.cBS = "c10709";
        com.baidu.tieba.card.data.l.cBT = "c10734";
        com.baidu.tieba.card.data.l.cBU = "c11929";
        com.baidu.tieba.card.data.l.cBV = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dQZ = new n(this.mPageContext);
        this.dQZ.currentPageType = 2;
        if (this.dQZ.bFe != null) {
            this.dQZ.bFe.aka = 2;
        }
        if (this.dQZ.bFT != null && this.dQZ.bFT.axN != null) {
            this.dQZ.bFT.axN.aka = 2;
        }
        this.dQZ.j(this.aQJ);
        this.dQZ.b(this.dNe);
        return new c(this.dQZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.iN(i + 1);
            lVar.sourceType = 0;
        }
        cVar.ajG().setVideoStatsData(b(lVar));
        if (cVar.ajG() instanceof com.baidu.tieba.a.e) {
            cVar.ajG().setPage(this.bER);
        }
        cVar.ajG().a(lVar);
        cVar.ajG().a(this.bgZ);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cBO) {
                v.ajh().a(lVar.ajA());
                am amVar = new am("c11003");
                bd Sz = lVar.Sz();
                if (Sz != null) {
                    amVar.ah("tid", Sz.getTid());
                    if (Sz.vm() != null) {
                        amVar.r("ab_type", Sz.vm().hadConcerned() ? 1 : 0);
                    }
                }
                v.ajh().a(amVar);
            } else {
                v.ajh().a(lVar.ajA());
            }
        }
        return cVar.getView();
    }

    private y b(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aVt = lVar.tid;
            if (lVar.Sz() != null) {
                yVar.cBu = String.valueOf(lVar.Sz().getFid());
                if (lVar.Sz().vD() != null) {
                    yVar.gdf = lVar.Sz().vD().video_md5;
                    yVar.gdh = String.valueOf(lVar.Sz().vD().is_vertical);
                }
            }
            yVar.afO = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.gde = lVar.ajr();
            yVar.gdc = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bgZ = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dQU = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
