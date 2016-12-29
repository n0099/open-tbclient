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
public class ab {
    private TbPageContext<?> GO;
    private List<com.baidu.adp.widget.ListView.a> bEG;
    private com.baidu.adp.widget.ListView.a bEp;
    private com.baidu.adp.widget.ListView.a bEq;
    private BdTypeListView cpR;
    private aa crA;
    private com.baidu.adp.widget.ListView.a crB;
    private com.baidu.adp.widget.ListView.a crC;
    private k crD;
    private q crE;
    private e crF;
    private i crG;
    private o crH;
    private b crI;
    private com.baidu.tieba.homepage.mygod.a.c crJ;
    private com.baidu.tieba.homepage.mygod.a.e crK;
    private boolean crL;
    private boolean crM;
    private com.baidu.tieba.homepage.mygod.a.a crN;
    private List<com.baidu.adp.widget.ListView.v> cry;
    private a crz;
    private CustomMessageListener bEO = new ac(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener ahW = new ad(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ae(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new af(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> crx = new ArrayList();

    public ab(Context context, BdTypeListView bdTypeListView) {
        this.cpR = bdTypeListView;
        this.GO = (TbPageContext) com.baidu.adp.base.l.C(context);
        aW(context);
        bdTypeListView.g(this.crx);
    }

    public void fd(boolean z) {
        this.crL = z;
        if (!com.baidu.tbadk.core.util.x.t(this.bEG)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bEG) {
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

    private void aW(Context context) {
        this.crz = new a(this.GO);
        this.crA = new aa(this.GO);
        this.bEp = com.baidu.tieba.recapp.j.aYf().b(this.GO, com.baidu.tbadk.core.data.c.Pe);
        this.bEq = com.baidu.tieba.recapp.j.aYf().b(this.GO, com.baidu.tbadk.core.data.c.Pf);
        this.crB = com.baidu.tieba.recapp.j.aYf().b(this.GO, com.baidu.tbadk.core.data.c.Pg);
        this.crC = com.baidu.tieba.recapp.j.aYf().b(this.GO, com.baidu.tbadk.core.data.c.Ph);
        this.crD = new k(this.GO, com.baidu.tieba.card.data.m.TYPE);
        this.crE = new q(this.GO, com.baidu.tieba.card.data.o.beG);
        this.crI = new b(this.GO, com.baidu.tieba.card.data.n.TYPE);
        this.crF = new e(this.GO, com.baidu.tieba.card.data.m.bey);
        this.crG = new i(this.GO, com.baidu.tieba.card.data.o.beH);
        this.crJ = new com.baidu.tieba.homepage.mygod.a.c(this.GO, com.baidu.tieba.card.data.f.TYPE);
        this.crK = new com.baidu.tieba.homepage.mygod.a.e(this.GO, com.baidu.tieba.card.data.g.TYPE);
        this.crH = new o(this.GO);
        this.crN = new com.baidu.tieba.homepage.mygod.a.a(this.GO, com.baidu.tieba.homepage.mygod.data.a.cpi);
        this.crx.add(this.crz);
        this.crx.add(this.crA);
        this.crx.add(this.bEp);
        this.crx.add(this.bEq);
        this.crx.add(this.crB);
        this.crx.add(this.crC);
        this.crx.add(this.crE);
        this.crx.add(this.crD);
        this.crx.add(this.crI);
        this.crx.add(new com.baidu.tieba.homepage.mygod.a.b(this.GO.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cpn));
        this.crx.add(this.crN);
        this.crx.add(this.crJ);
        this.crx.add(this.crK);
        this.crx.add(this.crF);
        this.crx.add(this.crG);
        this.crx.add(new w(this.GO.getPageActivity()));
        this.crx.add(new t(this.GO.getPageActivity()));
        this.crx.add(this.crH);
        this.crx.add(new com.baidu.tieba.homepage.personalize.d.c(this.GO, com.baidu.tieba.homepage.personalize.d.e.TYPE));
        YQ();
    }

    public void b(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.crD.a(fVar);
        this.crE.a(fVar);
        this.crF.a(fVar);
        this.crG.a(fVar);
    }

    public void bq(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.u.r(list, 2);
        this.cpR.setData(list);
        this.cry = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.crz.onChangeSkinType(i);
        this.crH.jA(i);
    }

    public void notifyDataSetChanged() {
        if (this.cpR != null && (this.cpR.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.cpR.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.crD != null) {
            this.crD.setFromCDN(z);
        }
        if (this.crF != null) {
            this.crF.setFromCDN(z);
        }
        if (this.bEq != null && (this.bEq instanceof com.baidu.tieba.recapp.f)) {
            ((com.baidu.tieba.recapp.f) this.bEq).setIsFromCDN(z);
        }
        if (this.crC != null && (this.crC instanceof com.baidu.tieba.recapp.f)) {
            ((com.baidu.tieba.recapp.f) this.crC).setIsFromCDN(z);
        }
        if (this.crB != null && (this.crB instanceof com.baidu.tieba.recapp.f)) {
            ((com.baidu.tieba.recapp.f) this.crB).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.crJ != null) {
            this.crJ.bbl = bdUniqueId;
        }
        if (this.crK != null) {
            this.crK.bbl = bdUniqueId;
        }
        if (this.crD != null) {
            this.crD.bbl = bdUniqueId;
        }
        if (this.crE != null) {
            this.crE.bbl = bdUniqueId;
        }
        if (this.crI != null) {
            this.crI.bbl = bdUniqueId;
        }
        if (this.crz != null) {
            this.crz.setPageUniqueId(bdUniqueId);
        }
        if (this.crF != null) {
            this.crF.bbl = bdUniqueId;
        }
        if (this.crG != null) {
            this.crG.bbl = bdUniqueId;
        }
        if (this.crH != null) {
            this.crH.bbl = bdUniqueId;
        }
        if (this.crN != null) {
            this.crN.bbl = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bEG)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bEG) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.ahW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ahW);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.crM) {
            this.bEO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bEO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Object obj) {
        if (this.cry != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cry) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void YQ() {
        this.crM = YR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YR() {
        if (this.bEG == null || this.bEG.size() <= 0) {
            this.bEG = new ArrayList();
            ArrayList<BdUniqueId> bfh = com.baidu.tieba.tbadkCore.u.bfh();
            if (bfh == null || bfh.size() <= 0) {
                return false;
            }
            int size = bfh.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.ayu().a(this.GO, bfh.get(i), 2);
                if (this.crL) {
                    a.setBusinessType(3);
                }
                if (this.crD != null && this.crD.bbl != null) {
                    a.setUniqueId(this.crD.bbl);
                }
                this.bEG.add(a);
            }
            this.cpR.g(this.bEG);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.crD != null) {
            this.crD.setEventCallback(aVar);
        }
        if (this.crI != null) {
            this.crI.setEventCallback(aVar);
        }
        if (this.crE != null) {
            this.crE.setEventCallback(aVar);
        }
    }
}
