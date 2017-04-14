package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private BdTypeListView aPE;
    private TbPageContext<?> ajT;
    private List<com.baidu.adp.widget.ListView.a> bRT;
    private com.baidu.adp.widget.ListView.a bVA;
    private com.baidu.adp.widget.ListView.a bVz;
    private com.baidu.adp.widget.ListView.a cyA;
    private com.baidu.adp.widget.ListView.a cyB;
    private m cyC;
    private s cyD;
    private g cyE;
    private k cyF;
    private q cyG;
    private com.baidu.tieba.homepage.alalivelist.a.d cyH;
    private com.baidu.tieba.homepage.alalivelist.a.f cyI;
    private d cyJ;
    private b cyK;
    private com.baidu.tieba.homepage.mygod.a.c cyL;
    private com.baidu.tieba.homepage.mygod.a.e cyM;
    private boolean cyN;
    private boolean cyO;
    private com.baidu.tieba.homepage.mygod.a.a cyP;
    private List<com.baidu.adp.widget.ListView.v> cyx;
    private a cyy;
    private ac cyz;
    private CustomMessageListener bSb = new ae(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amU = new af(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new ag(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ah(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cyw = new ArrayList();

    public ad(Context context, BdTypeListView bdTypeListView) {
        this.aPE = bdTypeListView;
        this.ajT = (TbPageContext) com.baidu.adp.base.k.Z(context);
        br(context);
        bdTypeListView.addAdapters(this.cyw);
    }

    public void eY(boolean z) {
        this.cyN = z;
        if (!com.baidu.tbadk.core.util.x.q(this.bRT)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRT) {
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

    private void br(Context context) {
        this.cyy = new a(this.ajT);
        this.cyz = new ac(this.ajT);
        this.bVz = com.baidu.tieba.recapp.v.aZP().b(this.ajT, AdvertAppInfo.TL);
        this.bVA = com.baidu.tieba.recapp.v.aZP().b(this.ajT, AdvertAppInfo.TM);
        this.cyA = com.baidu.tieba.recapp.v.aZP().b(this.ajT, AdvertAppInfo.TO);
        this.cyB = com.baidu.tieba.recapp.v.aZP().b(this.ajT, AdvertAppInfo.TP);
        this.cyC = new m(this.ajT, com.baidu.tieba.card.data.n.TYPE);
        this.cyD = new s(this.ajT, com.baidu.tieba.card.data.p.bvn);
        this.cyK = new b(this.ajT, com.baidu.tieba.card.data.o.TYPE);
        this.cyE = new g(this.ajT, com.baidu.tieba.card.data.n.bvg);
        this.cyF = new k(this.ajT, com.baidu.tieba.card.data.p.bvo);
        this.cyL = new com.baidu.tieba.homepage.mygod.a.c(this.ajT, com.baidu.tieba.card.data.f.TYPE);
        this.cyM = new com.baidu.tieba.homepage.mygod.a.e(this.ajT, com.baidu.tieba.card.data.g.TYPE);
        this.cyG = new q(this.ajT);
        this.cyP = new com.baidu.tieba.homepage.mygod.a.a(this.ajT, com.baidu.tieba.homepage.mygod.data.a.cwj);
        this.cyH = new com.baidu.tieba.homepage.alalivelist.a.d(this.ajT, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cyI = new com.baidu.tieba.homepage.alalivelist.a.f(this.ajT, com.baidu.tieba.homepage.alalivelist.view.h.TYPE);
        this.cyJ = new d(this.ajT, com.baidu.tieba.card.data.m.TYPE);
        this.cyw.add(this.cyy);
        this.cyw.add(this.cyz);
        this.cyw.add(this.bVz);
        this.cyw.add(this.bVA);
        this.cyw.add(this.cyA);
        this.cyw.add(this.cyB);
        this.cyw.add(this.cyD);
        this.cyw.add(this.cyC);
        this.cyw.add(this.cyK);
        this.cyw.add(new com.baidu.tieba.homepage.mygod.a.b(this.ajT.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cwo));
        this.cyw.add(this.cyP);
        this.cyw.add(this.cyL);
        this.cyw.add(this.cyM);
        this.cyw.add(this.cyE);
        this.cyw.add(this.cyF);
        this.cyw.add(new y(this.ajT.getPageActivity()));
        this.cyw.add(new v(this.ajT.getPageActivity()));
        this.cyw.add(this.cyG);
        this.cyw.add(new com.baidu.tieba.homepage.personalize.c.c(this.ajT, com.baidu.tieba.homepage.personalize.c.e.TYPE));
        this.cyw.add(this.cyH);
        this.cyw.add(this.cyI);
        this.cyw.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ajT, com.baidu.tieba.homepage.alalivelist.a.c.ctj));
        this.cyw.add(this.cyJ);
        abn();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.f fVar) {
        this.cyC.a(fVar);
        this.cyD.a(fVar);
        this.cyE.a(fVar);
        this.cyF.a(fVar);
    }

    public void bc(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        this.aPE.setData(list);
        this.cyx = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cyy.onChangeSkinType(i);
        this.cyG.jS(i);
    }

    public void notifyDataSetChanged() {
        if (this.aPE != null && (this.aPE.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aPE.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cyC != null) {
            this.cyC.setFromCDN(z);
        }
        if (this.cyE != null) {
            this.cyE.setFromCDN(z);
        }
        if (this.bVA != null && (this.bVA instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bVA).setIsFromCDN(z);
        }
        if (this.cyB != null && (this.cyB instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.cyB).setIsFromCDN(z);
        }
        if (this.cyA != null && (this.cyA instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.cyA).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cyL != null) {
            this.cyL.baI = bdUniqueId;
        }
        if (this.cyM != null) {
            this.cyM.baI = bdUniqueId;
        }
        if (this.cyC != null) {
            this.cyC.baI = bdUniqueId;
        }
        if (this.cyD != null) {
            this.cyD.baI = bdUniqueId;
        }
        if (this.cyK != null) {
            this.cyK.baI = bdUniqueId;
        }
        if (this.cyy != null) {
            this.cyy.setPageUniqueId(bdUniqueId);
        }
        if (this.cyE != null) {
            this.cyE.baI = bdUniqueId;
        }
        if (this.cyF != null) {
            this.cyF.baI = bdUniqueId;
        }
        if (this.cyG != null) {
            this.cyG.baI = bdUniqueId;
        }
        if (this.cyP != null) {
            this.cyP.baI = bdUniqueId;
        }
        if (this.cyH != null) {
            this.cyH.baI = bdUniqueId;
        }
        if (this.cyI != null) {
            this.cyI.baI = bdUniqueId;
        }
        if (this.cyJ != null) {
            this.cyJ.baI = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bRT)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRT) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.amU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.amU);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cyO) {
            this.bSb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        if (this.cyx != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cyx) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void abn() {
        this.cyO = abo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abo() {
        if (this.bRT == null || this.bRT.size() <= 0) {
            this.bRT = new ArrayList();
            ArrayList<BdUniqueId> bhu = com.baidu.tieba.tbadkCore.t.bhu();
            if (bhu == null || bhu.size() <= 0) {
                return false;
            }
            int size = bhu.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.azs().a(this.ajT, bhu.get(i), 2);
                if (this.cyN) {
                    a.setBusinessType(3);
                }
                if (this.cyC != null && this.cyC.baI != null) {
                    a.setUniqueId(this.cyC.baI);
                }
                this.bRT.add(a);
            }
            this.aPE.addAdapters(this.bRT);
            return true;
        }
        return true;
    }

    public void a(o.a aVar) {
        if (this.cyC != null) {
            this.cyC.setEventCallback(aVar);
        }
        if (this.cyK != null) {
            this.cyK.setEventCallback(aVar);
        }
        if (this.cyD != null) {
            this.cyD.setEventCallback(aVar);
        }
        if (this.cyJ != null) {
            this.cyJ.setEventCallback(aVar);
        }
    }
}
