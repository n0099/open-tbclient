package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, c<n>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bHB;
    private NEGFeedBackView.a biW;
    private ad dTj;
    private com.baidu.tieba.homepage.personalize.model.e dYn;
    private n dYs;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == this.dYs.getView().getId()) {
            TiebaStatic.log(lVar.S(lVar.btJ));
        } else if (this.dYs.bHO != null && this.dYs.bHO.getBarNameTv() != null && view.getId() == this.dYs.bHO.getBarNameTv().getId()) {
            TiebaStatic.log(lVar.ajv());
        } else if (this.dYs.bIC != null && this.dYs.bIC.ayq != null && view.getId() == this.dYs.bIC.ayq.getId()) {
            TiebaStatic.log(lVar.ajv());
        } else if (this.dYs.getHeaderImg() != null && view.getId() == this.dYs.getHeaderImg().getId()) {
            TiebaStatic.log(lVar.T(lVar.btJ));
        } else if (this.dYs.aiC() != null && view.getId() == this.dYs.aiC().getId()) {
            TiebaStatic.log(lVar.T(lVar.btJ));
        } else if (this.dYs.bHO != null && this.dYs.bHO.getCommentContainer() != null && view.getId() == this.dYs.bHO.getCommentContainer().getId()) {
            TiebaStatic.log(lVar.S(lVar.btJ));
        } else if (this.dYs.cwv != null && view.getId() == this.dYs.cwv.getId()) {
            TiebaStatic.log(lVar.S(lVar.btJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, com.baidu.tieba.card.data.l lVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new an("c11004").af("tid", lVar.btJ.getTid()));
        } else if (view.getId() == this.dYs.getView().getId()) {
            if (lVar.btJ.wl() != null && lVar.btJ.wl().channelId > 0) {
                lVar.o("c11929", true);
            }
            TiebaStatic.log(new an("c11004").af("tid", lVar.btJ.getTid()));
            TiebaStatic.log(new an("c10806").r("obj_locate", 1).af("tid", lVar.btJ.getId()));
            TiebaStatic.log(lVar.S(lVar.btJ));
        } else {
            TiebaStatic.log(new an("c11004").af("tid", lVar.btJ.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.biW = null;
        this.dTj = new ad<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                v.aiY().cK(true);
                if (i.this.dYn != null && lVar != null && lVar.Td() != null && !StringUtils.isNull(lVar.Td().getTid()) && i.this.dYs != null && i.this.dYs.getView() != null) {
                    if (lVar.Td().ajF > 0) {
                        TiebaStatic.log(lVar.S(lVar.Td()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.e.bR(com.baidu.adp.lib.g.b.c(lVar.Td().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.e.bQ(com.baidu.adp.lib.g.b.c(lVar.Td().getTid(), 0L));
                        i.this.dYn.a(com.baidu.adp.lib.g.b.c(lVar.Td().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.aji(), lVar.ajk(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (i.this.mType == com.baidu.tieba.card.data.l.cCn) {
                        i.this.b(view, lVar);
                    } else if (i.this.mType == com.baidu.tieba.card.data.l.cCo) {
                        i.this.c(view, lVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aEx();
    }

    private void aEx() {
        com.baidu.tieba.card.data.l.cCp = "c10708";
        com.baidu.tieba.card.data.l.cCq = "c10735";
        com.baidu.tieba.card.data.l.cCr = "c10709";
        com.baidu.tieba.card.data.l.cCs = "c10734";
        com.baidu.tieba.card.data.l.cCt = "c11929";
        com.baidu.tieba.card.data.l.cCu = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        this.dYs = new n(this.mPageContext);
        this.dYs.currentPageType = 2;
        if (this.dYs.bHO != null) {
            this.dYs.bHO.ajY = 2;
        }
        if (this.dYs.bIC != null && this.dYs.bIC.ayr != null) {
            this.dYs.bIC.ayr.ajY = 2;
        }
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.n() { // from class: com.baidu.tieba.homepage.personalize.a.i.2
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                n ajz;
                if ((view.getTag() instanceof c) && (ajz = ((c) view.getTag()).ajz()) != null) {
                    ajz.onClick(ajz.getView());
                }
            }
        });
        this.dYs.j(this.aRF);
        this.dYs.b(this.dTj);
        return new c(this.dYs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, c cVar) {
        if (lVar != null) {
            lVar.iX(i + 1);
            lVar.sourceType = 0;
        }
        cVar.ajz().setVideoStatsData(b(lVar));
        if (cVar.ajz() instanceof com.baidu.tieba.a.e) {
            cVar.ajz().setPage(this.bHB);
        }
        cVar.ajz().a(lVar);
        cVar.ajz().a(this.biW);
        if (lVar != null) {
            if (getType() != null && getType() == com.baidu.tieba.card.data.l.cCo) {
                v.aiY().a(lVar.ajt());
                an anVar = new an("c11003");
                bb Td = lVar.Td();
                if (Td != null) {
                    anVar.af("tid", Td.getTid());
                    if (Td.vk() != null) {
                        anVar.r("ab_type", Td.vk().hadConcerned() ? 1 : 0);
                    }
                }
                v.aiY().a(anVar);
            } else {
                v.aiY().a(lVar.ajt());
            }
        }
        return cVar.getView();
    }

    private y b(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.aWq = lVar.tid;
            if (lVar.Td() != null) {
                yVar.cBU = String.valueOf(lVar.Td().getFid());
                if (lVar.Td().vC() != null) {
                    yVar.ghG = lVar.Td().vC().video_md5;
                    yVar.ghI = String.valueOf(lVar.Td().vC().is_vertical);
                }
            }
            yVar.afx = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.ghF = lVar.ajk();
            yVar.ghD = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
        }
        return yVar;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.biW = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dYn = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
