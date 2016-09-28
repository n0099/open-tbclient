package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private TbPageContext<?> GM;
    private List<com.baidu.adp.widget.ListView.a> bVL;
    private com.baidu.adp.widget.ListView.a bVu;
    private BdTypeListView cFj;
    private List<com.baidu.adp.widget.ListView.v> cHf;
    private b cHg;
    private a cHh;
    private s cHi;
    private ab cHj;
    private com.baidu.adp.widget.ListView.a cHk;
    private com.baidu.adp.widget.ListView.a cHl;
    private k cHm;
    private q cHn;
    private e cHo;
    private i cHp;
    private o cHq;
    private c cHr;
    private com.baidu.tieba.homepage.mygod.a.c cHs;
    private com.baidu.tieba.homepage.mygod.a.e cHt;
    private boolean cHu;
    private CustomMessageListener bVQ = new ad(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener ahO = new ae(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new af(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ag(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cHe = new ArrayList();

    public ac(Context context, BdTypeListView bdTypeListView) {
        this.cFj = bdTypeListView;
        this.GM = (TbPageContext) com.baidu.adp.base.l.C(context);
        this.GM.registerListener(this.ahO);
        this.GM.registerListener(this.mLikeForumListener);
        this.GM.registerListener(this.mUnlikeForumListener);
        aL(context);
        bdTypeListView.g(this.cHe);
    }

    public void fd(boolean z) {
        this.cHu = z;
        if (!com.baidu.tbadk.core.util.y.t(this.bVL)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bVL) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    if (z) {
                        ((com.baidu.tieba.lego.card.a.a) aVar).setBusinessType(3);
                    } else {
                        ((com.baidu.tieba.lego.card.a.a) aVar).setBusinessType(2);
                    }
                }
            }
        }
    }

    private void aL(Context context) {
        this.cHg = new b(this.GM);
        this.cHh = new a(this.GM);
        this.cHi = new s(this.GM);
        this.cHj = new ab(this.GM);
        this.bVu = com.baidu.tieba.recapp.e.bbV().b(this.GM, com.baidu.tbadk.core.data.b.OV);
        this.cHk = com.baidu.tieba.recapp.e.bbV().b(this.GM, com.baidu.tbadk.core.data.b.OW);
        this.cHl = com.baidu.tieba.recapp.e.bbV().b(this.GM, com.baidu.tbadk.core.data.b.OX);
        this.cHm = new k(this.GM, com.baidu.tieba.card.data.m.Ru);
        this.cHn = new q(this.GM, com.baidu.tieba.card.data.o.bcr);
        this.cHr = new c(this.GM, com.baidu.tieba.card.data.n.Ru);
        this.cHo = new e(this.GM, com.baidu.tieba.card.data.m.bck);
        this.cHp = new i(this.GM, com.baidu.tieba.card.data.o.bcs);
        this.cHs = new com.baidu.tieba.homepage.mygod.a.c(this.GM, com.baidu.tieba.card.data.g.Ru);
        this.cHt = new com.baidu.tieba.homepage.mygod.a.e(this.GM, com.baidu.tieba.card.data.h.Ru);
        this.cHq = new o(this.GM);
        this.cHe.add(this.cHg);
        this.cHe.add(this.cHh);
        this.cHe.add(this.cHi);
        this.cHe.add(this.cHj);
        this.cHe.add(this.bVu);
        this.cHe.add(this.cHk);
        this.cHe.add(this.cHl);
        this.cHe.add(this.cHn);
        this.cHe.add(this.cHm);
        this.cHe.add(this.cHr);
        this.cHe.add(new com.baidu.tieba.homepage.mygod.a.b(this.GM.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cEF));
        this.cHe.add(new com.baidu.tieba.homepage.mygod.a.a(this.GM, com.baidu.tieba.homepage.mygod.data.a.cEA));
        this.cHe.add(this.cHs);
        this.cHe.add(this.cHt);
        this.cHe.add(this.cHo);
        this.cHe.add(this.cHp);
        this.cHe.add(new x(this.GM.getPageActivity()));
        this.cHe.add(new u(this.GM.getPageActivity()));
        this.cHe.add(this.cHq);
        this.cHe.add(new com.baidu.tieba.homepage.personalize.d.c(this.GM, com.baidu.tieba.homepage.personalize.d.e.Ru));
        adj();
    }

    public void b(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cHm.a(fVar);
        this.cHn.a(fVar);
        this.cHo.a(fVar);
        this.cHp.a(fVar);
    }

    public void bv(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.v.s(list, 2);
        this.cFj.setData(list);
        this.cHf = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cHg.onChangeSkinType(i);
        this.cHh.onChangeSkinType(i);
        this.cHq.ki(i);
    }

    public void notifyDataSetChanged() {
        if (this.cFj != null && (this.cFj.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.cFj.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cHm != null) {
            this.cHm.setFromCDN(z);
        }
        if (this.cHo != null) {
            this.cHo.setFromCDN(z);
        }
        if (this.bVu != null && (this.bVu instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bVu).setIsFromCDN(z);
        }
        if (this.cHl != null && (this.cHl instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.cHl).setIsFromCDN(z);
        }
        if (this.cHk != null && (this.cHk instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.cHk).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cHs != null) {
            this.cHs.aYW = bdUniqueId;
        }
        if (this.cHt != null) {
            this.cHt.aYW = bdUniqueId;
        }
        if (this.cHm != null) {
            this.cHm.aYW = bdUniqueId;
        }
        if (this.cHn != null) {
            this.cHn.aYW = bdUniqueId;
        }
        if (this.cHr != null) {
            this.cHr.aYW = bdUniqueId;
        }
        if (this.cHg != null) {
            this.cHg.setPageUniqueId(bdUniqueId);
        }
        if (this.cHh != null) {
            this.cHh.setPageUniqueId(bdUniqueId);
        }
        if (this.cHo != null) {
            this.cHo.aYW = bdUniqueId;
        }
        if (this.cHp != null) {
            this.cHp.aYW = bdUniqueId;
        }
        if (this.cHq != null) {
            this.cHq.aYW = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bVL)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bVL) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Object obj) {
        if (this.cHf != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cHf) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void adj() {
        if (!adk() && this.GM != null) {
            this.GM.registerListener(this.bVQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adk() {
        if (this.bVL == null || this.bVL.size() <= 0) {
            this.bVL = new ArrayList();
            ArrayList<BdUniqueId> biS = com.baidu.tieba.tbadkCore.v.biS();
            if (biS == null || biS.size() <= 0) {
                return false;
            }
            int size = biS.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aCF().a(this.GM, biS.get(i), 2);
                if (this.cHu) {
                    a.setBusinessType(3);
                }
                if (this.cHm != null && this.cHm.aYW != null) {
                    a.setUniqueId(this.cHm.aYW);
                }
                this.bVL.add(a);
            }
            this.cFj.g(this.bVL);
            return true;
        }
        return true;
    }
}
