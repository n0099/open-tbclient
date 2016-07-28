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
    private TbPageContext<?> EA;
    private List<com.baidu.adp.widget.ListView.a> bKC;
    private BdTypeListView ctF;
    private List<com.baidu.adp.widget.ListView.v> cuM;
    private c cuN;
    private b cuO;
    private t cuP;
    private ac cuQ;
    private a cuR;
    private l cuS;
    private r cuT;
    private f cuU;
    private j cuV;
    private p cuW;
    private d cuX;
    private com.baidu.tieba.homepage.mygod.a.b cuY;
    private com.baidu.tieba.homepage.mygod.a.d cuZ;
    private boolean cva;
    private CustomMessageListener bKH = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener afl = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> apJ = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.ctF = bdTypeListView;
        this.EA = (TbPageContext) com.baidu.adp.base.l.s(context);
        this.EA.registerListener(this.afl);
        this.EA.registerListener(this.mLikeForumListener);
        this.EA.registerListener(this.mUnlikeForumListener);
        aB(context);
        bdTypeListView.g(this.apJ);
    }

    public void eG(boolean z) {
        this.cva = z;
        if (!com.baidu.tbadk.core.util.y.t(this.bKC)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bKC) {
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
        this.cuN = new c(this.EA);
        this.cuO = new b(this.EA);
        this.cuP = new t(this.EA);
        this.cuQ = new ac(this.EA);
        this.cuR = new a(this.EA);
        this.cuS = new l(this.EA, com.baidu.tieba.card.a.m.OB);
        this.cuT = new r(this.EA, com.baidu.tieba.card.a.o.aWx);
        this.cuX = new d(this.EA, com.baidu.tieba.card.a.n.OB);
        this.cuU = new f(this.EA, com.baidu.tieba.card.a.m.aWq);
        this.cuV = new j(this.EA, com.baidu.tieba.card.a.o.aWy);
        this.cuY = new com.baidu.tieba.homepage.mygod.a.b(this.EA, com.baidu.tieba.card.a.g.OB);
        this.cuZ = new com.baidu.tieba.homepage.mygod.a.d(this.EA, com.baidu.tieba.card.a.h.OB);
        this.cuW = new p(this.EA);
        this.apJ.add(this.cuN);
        this.apJ.add(this.cuO);
        this.apJ.add(this.cuP);
        this.apJ.add(this.cuQ);
        this.apJ.add(this.cuR);
        this.apJ.add(this.cuT);
        this.apJ.add(this.cuS);
        this.apJ.add(this.cuX);
        this.apJ.add(new com.baidu.tieba.homepage.mygod.a.a(this.EA.getPageActivity(), com.baidu.tieba.homepage.mygod.data.a.csN));
        this.apJ.add(this.cuY);
        this.apJ.add(this.cuZ);
        this.apJ.add(this.cuU);
        this.apJ.add(this.cuV);
        this.apJ.add(new y(this.EA.getPageActivity()));
        this.apJ.add(new v(this.EA.getPageActivity()));
        this.apJ.add(this.cuW);
        this.apJ.add(new com.baidu.tieba.homepage.personalize.c.c(this.EA, com.baidu.tieba.homepage.personalize.c.e.OB));
        Yj();
    }

    public void b(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cuS.a(fVar);
        this.cuT.a(fVar);
        this.cuU.a(fVar);
        this.cuV.a(fVar);
    }

    public void bt(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.w.r(list, 2);
        this.ctF.setData(list);
        this.cuM = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cuN.onChangeSkinType(i);
        this.cuO.onChangeSkinType(i);
        this.cuW.jz(i);
    }

    public void notifyDataSetChanged() {
        if (this.ctF != null && (this.ctF.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.ctF.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cuS != null) {
            this.cuS.setFromCDN(z);
        }
        if (this.cuU != null) {
            this.cuU.setFromCDN(z);
        }
        if (this.cuR != null) {
            this.cuR.setFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cuY != null) {
            this.cuY.aTm = bdUniqueId;
        }
        if (this.cuZ != null) {
            this.cuZ.aTm = bdUniqueId;
        }
        if (this.cuS != null) {
            this.cuS.aTm = bdUniqueId;
        }
        if (this.cuT != null) {
            this.cuT.aTm = bdUniqueId;
        }
        if (this.cuX != null) {
            this.cuX.aTm = bdUniqueId;
        }
        if (this.cuN != null) {
            this.cuN.setPageUniqueId(bdUniqueId);
        }
        if (this.cuO != null) {
            this.cuO.setPageUniqueId(bdUniqueId);
        }
        if (this.cuU != null) {
            this.cuU.aTm = bdUniqueId;
        }
        if (this.cuV != null) {
            this.cuV.aTm = bdUniqueId;
        }
        if (this.cuW != null) {
            this.cuW.aTm = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bKC)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bKC) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(Object obj) {
        if (this.cuM != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cuM) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void Yj() {
        if (!Yk() && this.EA != null) {
            this.EA.registerListener(this.bKH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yk() {
        if (this.bKC == null || this.bKC.size() <= 0) {
            this.bKC = new ArrayList();
            ArrayList<BdUniqueId> beB = com.baidu.tieba.tbadkCore.w.beB();
            if (beB == null || beB.size() <= 0) {
                return false;
            }
            int size = beB.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.axq().a(this.EA, beB.get(i), 2);
                if (this.cva) {
                    a.setBusinessType(3);
                }
                if (this.cuS != null && this.cuS.aTm != null) {
                    a.setUniqueId(this.cuS.aTm);
                }
                this.bKC.add(a);
            }
            this.ctF.g(this.bKC);
            return true;
        }
        return true;
    }
}
