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
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, d<com.baidu.tieba.card.i>> {
    public BdUniqueId bIy;
    private c.a bOT;
    private int cardShowType;
    private v egm;
    private com.baidu.tieba.homepage.personalize.model.e ejX;
    private com.baidu.tieba.card.i ekc;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, m mVar) {
        if (view.getId() == this.ekc.getView().getId()) {
            TiebaStatic.log(mVar.N(mVar.bZi));
        } else if (this.ekc.cma != null && this.ekc.cma.getBarNameTv() != null && view.getId() == this.ekc.cma.getBarNameTv().getId()) {
            TiebaStatic.log(mVar.alM());
        } else if (this.ekc.cmO != null && this.ekc.cmO.beo != null && view.getId() == this.ekc.cmO.beo.getId()) {
            TiebaStatic.log(mVar.alM());
        } else if (this.ekc.getHeaderImg() != null && view.getId() == this.ekc.getHeaderImg().getId()) {
            TiebaStatic.log(mVar.O(mVar.bZi));
        } else if (this.ekc.akS() != null && view.getId() == this.ekc.akS().getId()) {
            TiebaStatic.log(mVar.O(mVar.bZi));
        } else if (this.ekc.cma != null && this.ekc.cma.getCommentContainer() != null && view.getId() == this.ekc.cma.getCommentContainer().getId()) {
            TiebaStatic.log(mVar.N(mVar.bZi));
        } else if (this.ekc.cVx != null && view.getId() == this.ekc.cVx.getId()) {
            TiebaStatic.log(mVar.N(mVar.bZi));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, m mVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZi.getTid()));
        } else if (view.getId() == this.ekc.getView().getId()) {
            if (mVar.bZi.Ao() != null && mVar.bZi.Ao().channelId > 0) {
                mVar.r("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZi.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", mVar.bZi.getId()));
            TiebaStatic.log(mVar.N(mVar.bZi));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZi.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOT = null;
        this.cardShowType = 0;
        this.egm = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                r.alt().dk(true);
                if (i.this.ejX != null && mVar != null && mVar.WE() != null && !StringUtils.isNull(mVar.WE().getTid()) && i.this.ekc != null && i.this.ekc.getView() != null) {
                    if (mVar.WE().aQk > 0) {
                        TiebaStatic.log(mVar.N(mVar.WE()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(mVar.WE().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(mVar.WE().getTid(), 0L));
                        i.this.ejX.a(com.baidu.adp.lib.g.b.c(mVar.WE().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.alB(), mVar.alD(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (i.this.mType == m.dah) {
                        i.this.b(view, mVar);
                    } else if (i.this.mType == m.dai) {
                        i.this.c(view, mVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDb();
    }

    private void aDb() {
        m.daj = "c10708";
        m.dak = "c10735";
        m.dal = "c10756";
        m.dam = "c10709";
        m.dan = "c10734";
        m.dao = "c11929";
        m.dap = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.ekc = new com.baidu.tieba.card.i(this.mPageContext);
        this.ekc.currentPageType = 2;
        if (this.ekc.cma != null) {
            this.ekc.cma.aQv = 2;
        }
        if (this.ekc.cmO != null && this.ekc.cmO.bep != null) {
            this.ekc.cmO.bep.aQv = 2;
        }
        this.ekc.j(this.bIy);
        this.ekc.b(this.egm);
        return new d(this.ekc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, d dVar) {
        if (mVar != null) {
            mVar.lD(i + 1);
            mVar.sourceType = 0;
        }
        dVar.alY().setVideoStatsData(b(mVar));
        if (mVar != null && mVar.bZi != null) {
            mVar.bZi.aQp = this.cardShowType;
        }
        dVar.alY().a(mVar);
        dVar.alY().a(this.bOT);
        if (mVar != null) {
            if (getType() != null && getType() == m.dai) {
                r.alt().a(mVar.alK());
                ak akVar = new ak("c11003");
                bd WE = mVar.WE();
                if (WE != null) {
                    akVar.ab("tid", WE.getTid());
                    if (WE.zn() != null) {
                        akVar.s("ab_type", WE.zn().hadConcerned() ? 1 : 0);
                    }
                }
                r.alt().a(akVar);
            } else {
                r.alt().a(mVar.alK());
            }
        }
        return dVar.getView();
    }

    private aa b(m mVar) {
        aa aaVar = null;
        if (mVar != null) {
            aaVar = new aa();
            aaVar.mLocate = "1";
            aaVar.bCV = mVar.tid;
            if (mVar.WE() != null) {
                aaVar.cZL = String.valueOf(mVar.WE().getFid());
                if (mVar.WE().zF() != null) {
                    aaVar.gwf = mVar.WE().zF().video_md5;
                }
            }
            aaVar.aMr = mVar.getExtra();
            aaVar.mSource = mVar.getSource();
            aaVar.gwe = mVar.alD();
            aaVar.gwc = mVar.getWeight();
        }
        return aaVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bOT = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ejX = eVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
