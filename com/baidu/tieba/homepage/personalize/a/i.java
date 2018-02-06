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
    public BdUniqueId bII;
    private c.a bPd;
    private int cardShowType;
    private v egi;
    private com.baidu.tieba.homepage.personalize.model.e ejT;
    private com.baidu.tieba.card.i ejY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, m mVar) {
        if (view.getId() == this.ejY.getView().getId()) {
            TiebaStatic.log(mVar.N(mVar.bZr));
        } else if (this.ejY.cmk != null && this.ejY.cmk.getBarNameTv() != null && view.getId() == this.ejY.cmk.getBarNameTv().getId()) {
            TiebaStatic.log(mVar.alM());
        } else if (this.ejY.cmX != null && this.ejY.cmX.bey != null && view.getId() == this.ejY.cmX.bey.getId()) {
            TiebaStatic.log(mVar.alM());
        } else if (this.ejY.getHeaderImg() != null && view.getId() == this.ejY.getHeaderImg().getId()) {
            TiebaStatic.log(mVar.O(mVar.bZr));
        } else if (this.ejY.akS() != null && view.getId() == this.ejY.akS().getId()) {
            TiebaStatic.log(mVar.O(mVar.bZr));
        } else if (this.ejY.cmk != null && this.ejY.cmk.getCommentContainer() != null && view.getId() == this.ejY.cmk.getCommentContainer().getId()) {
            TiebaStatic.log(mVar.N(mVar.bZr));
        } else if (this.ejY.cVG != null && view.getId() == this.ejY.cVG.getId()) {
            TiebaStatic.log(mVar.N(mVar.bZr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, m mVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZr.getTid()));
        } else if (view.getId() == this.ejY.getView().getId()) {
            if (mVar.bZr.Ao() != null && mVar.bZr.Ao().channelId > 0) {
                mVar.s("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZr.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", mVar.bZr.getId()));
            TiebaStatic.log(mVar.N(mVar.bZr));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZr.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bPd = null;
        this.cardShowType = 0;
        this.egi = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                r.alt().dk(true);
                if (i.this.ejT != null && mVar != null && mVar.WE() != null && !StringUtils.isNull(mVar.WE().getTid()) && i.this.ejY != null && i.this.ejY.getView() != null) {
                    if (mVar.WE().aQu > 0) {
                        TiebaStatic.log(mVar.N(mVar.WE()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(mVar.WE().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(mVar.WE().getTid(), 0L));
                        i.this.ejT.a(com.baidu.adp.lib.g.b.c(mVar.WE().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.alB(), mVar.alD(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (i.this.mType == m.daq) {
                        i.this.b(view, mVar);
                    } else if (i.this.mType == m.dar) {
                        i.this.c(view, mVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDb();
    }

    private void aDb() {
        m.das = "c10708";
        m.dau = "c10735";
        m.dav = "c10756";
        m.daw = "c10709";
        m.dax = "c10734";
        m.daz = "c11929";
        m.daA = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.ejY = new com.baidu.tieba.card.i(this.mPageContext);
        this.ejY.currentPageType = 2;
        if (this.ejY.cmk != null) {
            this.ejY.cmk.aQE = 2;
        }
        if (this.ejY.cmX != null && this.ejY.cmX.bez != null) {
            this.ejY.cmX.bez.aQE = 2;
        }
        this.ejY.j(this.bII);
        this.ejY.b(this.egi);
        return new d(this.ejY);
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
        if (mVar != null && mVar.bZr != null) {
            mVar.bZr.aQz = this.cardShowType;
        }
        dVar.alY().a(mVar);
        dVar.alY().a(this.bPd);
        if (mVar != null) {
            if (getType() != null && getType() == m.dar) {
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
            aaVar.bDf = mVar.tid;
            if (mVar.WE() != null) {
                aaVar.cZU = String.valueOf(mVar.WE().getFid());
                if (mVar.WE().zF() != null) {
                    aaVar.gwa = mVar.WE().zF().video_md5;
                }
            }
            aaVar.aMB = mVar.getExtra();
            aaVar.mSource = mVar.getSource();
            aaVar.gvZ = mVar.alD();
            aaVar.gvX = mVar.getWeight();
        }
        return aaVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bPd = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ejT = eVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
