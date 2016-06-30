package com.baidu.tieba.homepage.personalize.a;

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
public class ad {
    private TbPageContext<?> Ea;
    private List<com.baidu.adp.widget.ListView.a> bIY;
    private BdTypeListView cqV;
    private List<com.baidu.adp.widget.ListView.v> csc;
    private c csd;
    private b cse;
    private t csf;
    private ac csg;
    private a csh;
    private l csi;
    private r csj;
    private f csk;
    private j csl;
    private p csm;
    private d csn;
    private com.baidu.tieba.homepage.mygod.a.b cso;
    private com.baidu.tieba.homepage.mygod.a.d csp;
    private boolean csq;
    private CustomMessageListener bJc = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener aex = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> aoT = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.cqV = bdTypeListView;
        this.Ea = (TbPageContext) com.baidu.adp.base.l.s(context);
        this.Ea.registerListener(this.aex);
        this.Ea.registerListener(this.mLikeForumListener);
        this.Ea.registerListener(this.mUnlikeForumListener);
        aB(context);
        bdTypeListView.g(this.aoT);
    }

    public void eF(boolean z) {
        this.csq = z;
        if (!com.baidu.tbadk.core.util.y.t(this.bIY)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bIY) {
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

    private void aB(Context context) {
        this.csd = new c(this.Ea);
        this.cse = new b(this.Ea);
        this.csf = new t(this.Ea);
        this.csg = new ac(this.Ea);
        this.csh = new a(this.Ea);
        this.csi = new l(this.Ea, com.baidu.tieba.card.a.m.Op);
        this.csj = new r(this.Ea, com.baidu.tieba.card.a.o.aVz);
        this.csn = new d(this.Ea, com.baidu.tieba.card.a.n.Op);
        this.csk = new f(this.Ea, com.baidu.tieba.card.a.m.aVs);
        this.csl = new j(this.Ea, com.baidu.tieba.card.a.o.aVA);
        this.cso = new com.baidu.tieba.homepage.mygod.a.b(this.Ea, com.baidu.tieba.card.a.g.Op);
        this.csp = new com.baidu.tieba.homepage.mygod.a.d(this.Ea, com.baidu.tieba.card.a.h.Op);
        this.csm = new p(this.Ea);
        this.aoT.add(this.csd);
        this.aoT.add(this.cse);
        this.aoT.add(this.csf);
        this.aoT.add(this.csg);
        this.aoT.add(this.csh);
        this.aoT.add(this.csj);
        this.aoT.add(this.csi);
        this.aoT.add(this.csn);
        this.aoT.add(new com.baidu.tieba.homepage.mygod.a.a(this.Ea.getPageActivity(), com.baidu.tieba.homepage.mygod.data.a.cqi));
        this.aoT.add(this.cso);
        this.aoT.add(this.csp);
        this.aoT.add(this.csk);
        this.aoT.add(this.csl);
        this.aoT.add(new y(this.Ea.getPageActivity()));
        this.aoT.add(new v(this.Ea.getPageActivity()));
        this.aoT.add(this.csm);
        this.aoT.add(new com.baidu.tieba.homepage.personalize.c.c(this.Ea, com.baidu.tieba.homepage.personalize.c.e.Op));
        XQ();
    }

    public void b(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.csi.a(fVar);
        this.csj.a(fVar);
        this.csk.a(fVar);
        this.csl.a(fVar);
    }

    public void bp(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.w.p(list, 2);
        this.cqV.setData(list);
        this.csc = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.csd.onChangeSkinType(i);
        this.cse.onChangeSkinType(i);
        this.csm.jt(i);
    }

    public void notifyDataSetChanged() {
        if (this.cqV != null && (this.cqV.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.cqV.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.csi != null) {
            this.csi.setFromCDN(z);
        }
        if (this.csk != null) {
            this.csk.setFromCDN(z);
        }
        if (this.csh != null) {
            this.csh.setFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cso != null) {
            this.cso.aSq = bdUniqueId;
        }
        if (this.csp != null) {
            this.csp.aSq = bdUniqueId;
        }
        if (this.csi != null) {
            this.csi.aSq = bdUniqueId;
        }
        if (this.csj != null) {
            this.csj.aSq = bdUniqueId;
        }
        if (this.csn != null) {
            this.csn.aSq = bdUniqueId;
        }
        if (this.csd != null) {
            this.csd.setPageUniqueId(bdUniqueId);
        }
        if (this.cse != null) {
            this.cse.setPageUniqueId(bdUniqueId);
        }
        if (this.csk != null) {
            this.csk.aSq = bdUniqueId;
        }
        if (this.csl != null) {
            this.csl.aSq = bdUniqueId;
        }
        if (this.csm != null) {
            this.csm.aSq = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bIY)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bIY) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Object obj) {
        if (this.csc != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.csc) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void XQ() {
        if (!XR() && this.Ea != null) {
            this.Ea.registerListener(this.bJc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XR() {
        if (this.bIY == null || this.bIY.size() <= 0) {
            this.bIY = new ArrayList();
            ArrayList<BdUniqueId> bbn = com.baidu.tieba.tbadkCore.w.bbn();
            if (bbn == null || bbn.size() <= 0) {
                return false;
            }
            int size = bbn.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aws().a(this.Ea, bbn.get(i), 2);
                if (this.csq) {
                    a.setBusinessType(3);
                }
                if (this.csi != null && this.csi.aSq != null) {
                    a.setUniqueId(this.csi.aSq);
                }
                this.bIY.add(a);
            }
            this.cqV.g(this.bIY);
            return true;
        }
        return true;
    }
}
