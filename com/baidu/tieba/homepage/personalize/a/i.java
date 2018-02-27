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
    public BdUniqueId bIv;
    private c.a bOQ;
    private int cardShowType;
    private v efW;
    private com.baidu.tieba.homepage.personalize.model.e ejH;
    private com.baidu.tieba.card.i ejM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, m mVar) {
        if (view.getId() == this.ejM.getView().getId()) {
            TiebaStatic.log(mVar.N(mVar.bZf));
        } else if (this.ejM.clX != null && this.ejM.clX.getBarNameTv() != null && view.getId() == this.ejM.clX.getBarNameTv().getId()) {
            TiebaStatic.log(mVar.alL());
        } else if (this.ejM.cmL != null && this.ejM.cmL.bel != null && view.getId() == this.ejM.cmL.bel.getId()) {
            TiebaStatic.log(mVar.alL());
        } else if (this.ejM.getHeaderImg() != null && view.getId() == this.ejM.getHeaderImg().getId()) {
            TiebaStatic.log(mVar.O(mVar.bZf));
        } else if (this.ejM.akR() != null && view.getId() == this.ejM.akR().getId()) {
            TiebaStatic.log(mVar.O(mVar.bZf));
        } else if (this.ejM.clX != null && this.ejM.clX.getCommentContainer() != null && view.getId() == this.ejM.clX.getCommentContainer().getId()) {
            TiebaStatic.log(mVar.N(mVar.bZf));
        } else if (this.ejM.cVu != null && view.getId() == this.ejM.cVu.getId()) {
            TiebaStatic.log(mVar.N(mVar.bZf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, m mVar) {
        if (view instanceof TbImageView) {
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZf.getTid()));
        } else if (view.getId() == this.ejM.getView().getId()) {
            if (mVar.bZf.Ao() != null && mVar.bZf.Ao().channelId > 0) {
                mVar.r("c11929", true);
            }
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZf.getTid()));
            TiebaStatic.log(new ak("c10806").s("obj_locate", 1).ab("tid", mVar.bZf.getId()));
            TiebaStatic.log(mVar.N(mVar.bZf));
        } else {
            TiebaStatic.log(new ak("c11004").ab("tid", mVar.bZf.getTid()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOQ = null;
        this.cardShowType = 0;
        this.efW = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                r.als().dk(true);
                if (i.this.ejH != null && mVar != null && mVar.WD() != null && !StringUtils.isNull(mVar.WD().getTid()) && i.this.ejM != null && i.this.ejM.getView() != null) {
                    if (mVar.WD().aQj > 0) {
                        TiebaStatic.log(mVar.N(mVar.WD()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.g.bM(com.baidu.adp.lib.g.b.c(mVar.WD().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.g.bL(com.baidu.adp.lib.g.b.c(mVar.WD().getTid(), 0L));
                        i.this.ejH.a(com.baidu.adp.lib.g.b.c(mVar.WD().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.alA(), mVar.alC(), com.baidu.adp.lib.g.b.h((String) view.getTag(), 1));
                    }
                    if (i.this.mType == m.dae) {
                        i.this.b(view, mVar);
                    } else if (i.this.mType == m.daf) {
                        i.this.c(view, mVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDa();
    }

    private void aDa() {
        m.dag = "c10708";
        m.dah = "c10735";
        m.dai = "c10756";
        m.daj = "c10709";
        m.dak = "c10734";
        m.dal = "c11929";
        m.dam = "c11928";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public d onCreateViewHolder(ViewGroup viewGroup) {
        this.ejM = new com.baidu.tieba.card.i(this.mPageContext);
        this.ejM.currentPageType = 2;
        if (this.ejM.clX != null) {
            this.ejM.clX.aQt = 2;
        }
        if (this.ejM.cmL != null && this.ejM.cmL.bem != null) {
            this.ejM.cmL.bem.aQt = 2;
        }
        this.ejM.j(this.bIv);
        this.ejM.b(this.efW);
        return new d(this.ejM);
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
        dVar.alX().setVideoStatsData(b(mVar));
        if (mVar != null && mVar.bZf != null) {
            mVar.bZf.aQo = this.cardShowType;
        }
        dVar.alX().a(mVar);
        dVar.alX().a(this.bOQ);
        if (mVar != null) {
            if (getType() != null && getType() == m.daf) {
                r.als().a(mVar.alJ());
                ak akVar = new ak("c11003");
                bd WD = mVar.WD();
                if (WD != null) {
                    akVar.ab("tid", WD.getTid());
                    if (WD.zn() != null) {
                        akVar.s("ab_type", WD.zn().hadConcerned() ? 1 : 0);
                    }
                }
                r.als().a(akVar);
            } else {
                r.als().a(mVar.alJ());
            }
        }
        return dVar.getView();
    }

    private aa b(m mVar) {
        aa aaVar = null;
        if (mVar != null) {
            aaVar = new aa();
            aaVar.mLocate = "1";
            aaVar.bCS = mVar.tid;
            if (mVar.WD() != null) {
                aaVar.cZI = String.valueOf(mVar.WD().getFid());
                if (mVar.WD().zF() != null) {
                    aaVar.gvP = mVar.WD().zF().video_md5;
                }
            }
            aaVar.aMq = mVar.getExtra();
            aaVar.mSource = mVar.getSource();
            aaVar.gvO = mVar.alC();
            aaVar.gvM = mVar.getWeight();
        }
        return aaVar;
    }

    public void setEventCallback(c.a aVar) {
        this.bOQ = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ejH = eVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
