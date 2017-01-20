package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private TbPageContext<?> FY;
    private BdTypeListView aJF;
    private List<com.baidu.adp.widget.ListView.a> bKZ;
    private com.baidu.adp.widget.ListView.a bOD;
    private com.baidu.adp.widget.ListView.a bOE;
    private List<com.baidu.adp.widget.ListView.v> cyB;
    private a cyC;
    private ac cyD;
    private com.baidu.adp.widget.ListView.a cyE;
    private com.baidu.adp.widget.ListView.a cyF;
    private m cyG;
    private s cyH;
    private g cyI;
    private k cyJ;
    private q cyK;
    private com.baidu.tieba.homepage.alalivelist.a.d cyL;
    private com.baidu.tieba.homepage.alalivelist.a.f cyM;
    private d cyN;
    private b cyO;
    private com.baidu.tieba.homepage.mygod.a.c cyP;
    private com.baidu.tieba.homepage.mygod.a.e cyQ;
    private boolean cyR;
    private boolean cyS;
    private com.baidu.tieba.homepage.mygod.a.a cyT;
    private CustomMessageListener bLh = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener ahk = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cyA = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.aJF = bdTypeListView;
        this.FY = (TbPageContext) com.baidu.adp.base.k.C(context);
        aZ(context);
        bdTypeListView.addAdapters(this.cyA);
    }

    public void fh(boolean z) {
        this.cyR = z;
        if (!com.baidu.tbadk.core.util.w.s(this.bKZ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bKZ) {
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

    private void aZ(Context context) {
        this.cyC = new a(this.FY);
        this.cyD = new ac(this.FY);
        this.bOD = com.baidu.tieba.recapp.p.aZV().b(this.FY, com.baidu.tbadk.core.data.c.Op);
        this.bOE = com.baidu.tieba.recapp.p.aZV().b(this.FY, com.baidu.tbadk.core.data.c.Oq);
        this.cyE = com.baidu.tieba.recapp.p.aZV().b(this.FY, com.baidu.tbadk.core.data.c.Or);
        this.cyF = com.baidu.tieba.recapp.p.aZV().b(this.FY, com.baidu.tbadk.core.data.c.Os);
        this.cyG = new m(this.FY, com.baidu.tieba.card.data.n.TYPE);
        this.cyH = new s(this.FY, com.baidu.tieba.card.data.p.boz);
        this.cyO = new b(this.FY, com.baidu.tieba.card.data.o.TYPE);
        this.cyI = new g(this.FY, com.baidu.tieba.card.data.n.bos);
        this.cyJ = new k(this.FY, com.baidu.tieba.card.data.p.boA);
        this.cyP = new com.baidu.tieba.homepage.mygod.a.c(this.FY, com.baidu.tieba.card.data.f.TYPE);
        this.cyQ = new com.baidu.tieba.homepage.mygod.a.e(this.FY, com.baidu.tieba.card.data.g.TYPE);
        this.cyK = new q(this.FY);
        this.cyT = new com.baidu.tieba.homepage.mygod.a.a(this.FY, com.baidu.tieba.homepage.mygod.data.a.cwk);
        this.cyL = new com.baidu.tieba.homepage.alalivelist.a.d(this.FY, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cyM = new com.baidu.tieba.homepage.alalivelist.a.f(this.FY, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cyN = new d(this.FY, com.baidu.tieba.card.data.m.TYPE);
        this.cyA.add(this.cyC);
        this.cyA.add(this.cyD);
        this.cyA.add(this.bOD);
        this.cyA.add(this.bOE);
        this.cyA.add(this.cyE);
        this.cyA.add(this.cyF);
        this.cyA.add(this.cyH);
        this.cyA.add(this.cyG);
        this.cyA.add(this.cyO);
        this.cyA.add(new com.baidu.tieba.homepage.mygod.a.b(this.FY.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cwp));
        this.cyA.add(this.cyT);
        this.cyA.add(this.cyP);
        this.cyA.add(this.cyQ);
        this.cyA.add(this.cyI);
        this.cyA.add(this.cyJ);
        this.cyA.add(new y(this.FY.getPageActivity()));
        this.cyA.add(new v(this.FY.getPageActivity()));
        this.cyA.add(this.cyK);
        this.cyA.add(new com.baidu.tieba.homepage.personalize.c.c(this.FY, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.cyA.add(this.cyL);
        this.cyA.add(this.cyM);
        this.cyA.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.FY, com.baidu.tieba.homepage.alalivelist.a.c.ctk));
        this.cyA.add(this.cyN);
        ZS();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cyG.a(fVar);
        this.cyH.a(fVar);
        this.cyI.a(fVar);
        this.cyJ.a(fVar);
    }

    public void bw(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        this.aJF.setData(list);
        this.cyB = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cyC.onChangeSkinType(i);
        this.cyK.kn(i);
    }

    public void notifyDataSetChanged() {
        if (this.aJF != null && (this.aJF.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aJF.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cyG != null) {
            this.cyG.setFromCDN(z);
        }
        if (this.cyI != null) {
            this.cyI.setFromCDN(z);
        }
        if (this.bOE != null && (this.bOE instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.bOE).setIsFromCDN(z);
        }
        if (this.cyF != null && (this.cyF instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.cyF).setIsFromCDN(z);
        }
        if (this.cyE != null && (this.cyE instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.cyE).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cyP != null) {
            this.cyP.aUC = bdUniqueId;
        }
        if (this.cyQ != null) {
            this.cyQ.aUC = bdUniqueId;
        }
        if (this.cyG != null) {
            this.cyG.aUC = bdUniqueId;
        }
        if (this.cyH != null) {
            this.cyH.aUC = bdUniqueId;
        }
        if (this.cyO != null) {
            this.cyO.aUC = bdUniqueId;
        }
        if (this.cyC != null) {
            this.cyC.setPageUniqueId(bdUniqueId);
        }
        if (this.cyI != null) {
            this.cyI.aUC = bdUniqueId;
        }
        if (this.cyJ != null) {
            this.cyJ.aUC = bdUniqueId;
        }
        if (this.cyK != null) {
            this.cyK.aUC = bdUniqueId;
        }
        if (this.cyT != null) {
            this.cyT.aUC = bdUniqueId;
        }
        if (this.cyL != null) {
            this.cyL.aUC = bdUniqueId;
        }
        if (this.cyM != null) {
            this.cyM.aUC = bdUniqueId;
        }
        if (this.cyN != null) {
            this.cyN.aUC = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.w.s(this.bKZ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bKZ) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.ahk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ahk);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cyS) {
            this.bLh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bLh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        if (this.cyB != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cyB) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void ZS() {
        this.cyS = ZT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZT() {
        if (this.bKZ == null || this.bKZ.size() <= 0) {
            this.bKZ = new ArrayList();
            ArrayList<BdUniqueId> bgW = com.baidu.tieba.tbadkCore.t.bgW();
            if (bgW == null || bgW.size() <= 0) {
                return false;
            }
            int size = bgW.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.aAp().a(this.FY, bgW.get(i), 2);
                if (this.cyR) {
                    a.setBusinessType(3);
                }
                if (this.cyG != null && this.cyG.aUC != null) {
                    a.setUniqueId(this.cyG.aUC);
                }
                this.bKZ.add(a);
            }
            this.aJF.addAdapters(this.bKZ);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cyG != null) {
            this.cyG.setEventCallback(aVar);
        }
        if (this.cyO != null) {
            this.cyO.setEventCallback(aVar);
        }
        if (this.cyH != null) {
            this.cyH.setEventCallback(aVar);
        }
    }
}
