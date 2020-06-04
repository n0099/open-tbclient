package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class ab {
    private List<com.baidu.adp.widget.ListView.a> hFU;
    private com.baidu.adp.widget.ListView.t ieB;
    private List<com.baidu.adp.widget.ListView.o> ieC;
    private b ieD;
    private z ieE;
    private d ieF;
    private o ieG;
    private x ieH;
    private k ieI;
    private l ieJ;
    private m ieK;
    private r ieL;
    private j ieM;
    private i ieN;
    private h ieO;
    private y ieP;
    private g ieQ;
    private n ieR;
    private c ieS;
    private v ieT;
    private u ieU;
    private w ieV;
    private t ieW;
    private o ieX;
    private p ieY;
    private q ieZ;
    private s ifa;
    private e ifb;
    private com.baidu.adp.widget.ListView.a ifc;
    private com.baidu.adp.widget.ListView.a ifd;
    private com.baidu.adp.widget.ListView.a ife;
    private com.baidu.adp.widget.ListView.a iff;
    private com.baidu.adp.widget.ListView.a ifg;
    private com.baidu.adp.widget.ListView.a ifh;
    private com.baidu.adp.widget.ListView.a ifi;
    private boolean ifj;
    private boolean ifk;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hFW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cgs();
                if (ab.this.ieC != null) {
                    ab.this.bE(ab.this.ieC);
                }
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.aB(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dEi = true;
                ab.this.aB(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dEi = false;
                ab.this.aB(bVar);
            }
        }
    };
    private CustomMessageListener gEk = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Fm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Fm = ab.this.Fm(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Fm));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> hXb = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.t tVar) {
        this.ieB = tVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eK(context);
        a(tVar);
        tVar.addAdapters(this.hXb);
    }

    private void eK(Context context) {
        this.ieD = new b(this.mPageContext);
        this.ieE = new z(this.mPageContext);
        this.ieF = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.ifK);
        this.ieG = new o(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ieH = new x(this.mPageContext, com.baidu.tieba.card.data.k.gHF);
        this.ieI = new k(this.mPageContext, com.baidu.tieba.card.data.k.gHM);
        this.ieJ = new l(this.mPageContext, com.baidu.tieba.card.data.k.gHG);
        this.ieK = new m(this.mPageContext, com.baidu.tieba.card.data.k.gHN);
        this.ieL = new r(this.mPageContext, com.baidu.tieba.card.data.k.gHL);
        this.ieM = new j(this.mPageContext, com.baidu.tieba.card.data.k.gHH);
        this.ieN = new i(this.mPageContext, com.baidu.tieba.card.data.k.gHI);
        this.ieO = new h(this.mPageContext, com.baidu.tieba.card.data.k.gHJ);
        this.ieP = new y(this.mPageContext, com.baidu.tieba.card.data.l.dEV);
        this.ieR = new n(this.mPageContext, com.baidu.tieba.card.data.k.dET);
        this.ieS = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ieT = new v(this.mPageContext, com.baidu.tieba.card.data.k.dEZ);
        this.ieU = new u(this.mPageContext, com.baidu.tieba.card.data.k.dFa);
        this.ieV = new w(this.mPageContext, com.baidu.tieba.card.data.k.dFc);
        this.ieW = new t(this.mPageContext, com.baidu.tieba.card.data.k.dFb);
        this.ieX = new o(this.mPageContext, com.baidu.tieba.card.data.k.gHE);
        this.ieY = new p(this.mPageContext, com.baidu.tieba.card.data.k.dFg);
        this.ieZ = new q(this.mPageContext, com.baidu.tieba.card.data.k.dFh);
        this.ifa = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.iiw);
        this.ifb = new e(this.mPageContext, com.baidu.tieba.card.data.e.gHh);
        this.ieQ = new g(this.mPageContext, com.baidu.tieba.card.data.k.gHK);
        this.hXb.add(this.ieD);
        this.hXb.add(this.ieE);
        this.hXb.add(this.ieF);
        this.hXb.add(this.ieG);
        this.hXb.add(this.ieH);
        this.hXb.add(this.ieI);
        this.hXb.add(this.ieJ);
        this.hXb.add(this.ieK);
        this.hXb.add(this.ieL);
        this.hXb.add(this.ieM);
        this.hXb.add(this.ieN);
        this.hXb.add(this.ieO);
        this.hXb.add(this.ieP);
        this.hXb.add(this.ieR);
        this.hXb.add(this.ieX);
        this.hXb.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.hXb.add(this.ieS);
        this.hXb.add(this.ieT);
        this.hXb.add(this.ieU);
        this.hXb.add(this.ieW);
        this.hXb.add(this.ieV);
        this.hXb.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.hXb.add(this.ieY);
        this.hXb.add(this.ieZ);
        this.hXb.add(this.ifa);
        this.hXb.add(this.ifb);
        this.hXb.add(this.ieQ);
        cgr();
        cgq();
        zL("page_recommend");
    }

    private void cgq() {
        if (!bk.dFk.get()) {
            AdvertAppInfo.dAs.set(false);
            return;
        }
        this.ifc = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAj);
        this.ifd = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAm);
        this.ife = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAn);
        this.iff = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAo);
        this.ifg = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAp);
        this.ifh = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAr);
        this.ifi = com.baidu.tieba.recapp.q.cUC().c(this.mPageContext, AdvertAppInfo.dAq);
        this.hXb.add(this.ifc);
        this.hXb.add(this.ifd);
        this.hXb.add(this.ife);
        this.hXb.add(this.iff);
        this.hXb.add(this.ifg);
        this.hXb.add(this.ifh);
        this.hXb.add(this.ifi);
        AdvertAppInfo.dAs.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ieG.a(eVar);
        this.ieH.a(eVar);
        this.ieI.a(eVar);
        this.ieK.a(eVar);
        this.ieL.a(eVar);
        this.ieM.a(eVar);
        this.ieN.a(eVar);
        this.ieO.a(eVar);
        this.ieP.a(eVar);
        this.ieQ.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.t tVar) {
        this.ieH.a(tVar);
        this.ieI.a(tVar);
        this.ieJ.a(tVar);
        this.ieK.a(tVar);
        this.ieL.a(tVar);
        this.ieM.a(tVar);
        this.ieN.a(tVar);
        this.ieO.a(tVar);
        this.ieQ.a(tVar);
        this.ieP.a(tVar);
        this.ifb.a(tVar);
        this.ieU.a(tVar);
        this.ieU.a(tVar);
        this.ieW.a(tVar);
    }

    public void k(List<com.baidu.adp.widget.ListView.o> list, int i) {
        com.baidu.tieba.tbadkCore.t.s(list, 2);
        ViewGroup listView = this.ieB.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top2 = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).oV();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top2);
                ((BdRecyclerView) listView).oW();
            }
        }
        this.ieB.setData(list);
        this.ieC = list;
    }

    public void bE(List<com.baidu.adp.widget.ListView.o> list) {
        com.baidu.tieba.tbadkCore.t.s(list, 2);
        this.ieB.setData(list);
        this.ieC = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ieD.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.ieB != null) {
            this.ieB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ieG != null) {
            this.ieG.setFromCDN(z);
            this.ieX.setFromCDN(z);
            this.ieR.setFromCDN(z);
            this.ieT.setFromCDN(z);
        }
        if (this.ieK != null) {
            this.ieK.setFromCDN(z);
        }
        if (this.ieQ != null) {
            this.ieQ.setFromCDN(z);
        }
        if (this.ifd != null && (this.ifd instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.ifd).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ieF != null) {
            this.ieF.setPageUniqueId(bdUniqueId);
        }
        if (this.ieG != null) {
            this.ieG.epM = bdUniqueId;
        }
        if (this.ieH != null) {
            this.ieH.epM = bdUniqueId;
        }
        if (this.ieI != null) {
            this.ieI.epM = bdUniqueId;
        }
        if (this.ieJ != null) {
            this.ieJ.epM = bdUniqueId;
        }
        if (this.ieK != null) {
            this.ieK.epM = bdUniqueId;
        }
        if (this.ieL != null) {
            this.ieL.epM = bdUniqueId;
        }
        if (this.ieM != null) {
            this.ieM.epM = bdUniqueId;
        }
        if (this.ieN != null) {
            this.ieN.epM = bdUniqueId;
        }
        if (this.ieO != null) {
            this.ieO.epM = bdUniqueId;
        }
        if (this.ieR != null) {
            this.ieR.epM = bdUniqueId;
        }
        if (this.ieP != null) {
            this.ieP.epM = bdUniqueId;
        }
        if (this.ieD != null) {
            this.ieD.setPageUniqueId(bdUniqueId);
        }
        if (this.ieS != null) {
            this.ieS.epM = bdUniqueId;
        }
        if (this.ieT != null) {
            this.ieT.epM = bdUniqueId;
        }
        if (this.ieU != null) {
            this.ieU.epM = bdUniqueId;
        }
        if (this.ieW != null) {
            this.ieW.epM = bdUniqueId;
        }
        if (this.ieV != null) {
            this.ieV.epM = bdUniqueId;
        }
        if (this.ieX != null) {
            this.ieX.epM = bdUniqueId;
        }
        if (this.ieY != null) {
            this.ieY.epM = bdUniqueId;
        }
        if (this.ieZ != null) {
            this.ieZ.epM = bdUniqueId;
        }
        if (this.ifa != null) {
            this.ifa.epM = bdUniqueId;
        }
        if (this.ifb != null) {
            this.ifb.epM = bdUniqueId;
        }
        if (this.ieQ != null) {
            this.ieQ.epM = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hFU)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hFU) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dNP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dNP);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.gEk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gEk);
        if (!this.ifk) {
            this.hFW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hFW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ieC != null) {
            Iterator<com.baidu.adp.widget.ListView.o> it = this.ieC.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.o next = it.next();
                if ((next instanceof ICardInfo) && ((ICardInfo) next).responseAttention(obj)) {
                    z = true;
                }
                z2 = z;
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void cgr() {
        this.ifk = cgs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgs() {
        if (this.hFU == null || this.hFU.size() <= 0) {
            this.hFU = new ArrayList();
            ArrayList<BdUniqueId> dda = com.baidu.tieba.tbadkCore.t.dda();
            if (dda == null || dda.size() <= 0) {
                return false;
            }
            int size = dda.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cuO().a(this.mPageContext, dda.get(i), 2);
                if (this.ifj) {
                    a.setBusinessType(3);
                }
                if (this.ieG != null && this.ieG.epM != null) {
                    a.setUniqueId(this.ieG.epM);
                }
                this.hFU.add(a);
            }
            this.ieB.addAdapters(this.hFU);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.hXb) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ieG != null) {
            this.ieG.setEventCallback(aVar);
        }
        if (this.ieL != null) {
            this.ieL.setEventCallback(aVar);
        }
        if (this.ieJ != null) {
            this.ieJ.setEventCallback(aVar);
        }
        if (this.ieR != null) {
            this.ieR.setEventCallback(aVar);
        }
        if (this.ieS != null) {
            this.ieS.setEventCallback(aVar);
        }
        if (this.ieT != null) {
            this.ieT.setEventCallback(aVar);
        }
        if (this.ieU != null) {
            this.ieU.setEventCallback(aVar);
        }
        if (this.ieW != null) {
            this.ieW.setEventCallback(aVar);
        }
        if (this.ieV != null) {
            this.ieV.setEventCallback(aVar);
        }
        if (this.ieX != null) {
            this.ieX.setEventCallback(aVar);
        }
        if (this.ieY != null) {
            this.ieY.setEventCallback(aVar);
        }
        if (this.ieZ != null) {
            this.ieZ.setEventCallback(aVar);
        }
        if (this.ifa != null) {
            this.ifa.setEventCallback(aVar);
        }
        if (this.ifb != null) {
            this.ifb.setEventCallback(aVar);
        }
    }

    private void zL(String str) {
        if (this.hXb != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hXb) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.o oVar) {
        AdvertAppInfo advertAppInfo;
        return oVar != null && (oVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) oVar).gHg) != null && advertAppInfo.aOy() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Fm(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.ieC == null || this.ieC.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.ieC.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.ieC.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.ieC.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.ieC.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.ieC.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.ieC.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.ieC.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.ieC.get(i4)) != null && lVar.dEA != null && str.equals(lVar.dEA.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.ieC.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aM(i6 - i >= -1 ? i6 - i : -1);
        bVar.aN(i7);
        bVar.aO(i2);
        return bVar;
    }

    public void onPause() {
        if (this.ieP != null) {
            this.ieP.onPause();
        }
    }

    public void onResume() {
        if (this.ieP != null) {
            this.ieP.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.o> getDataList() {
        return this.ieC;
    }
}
