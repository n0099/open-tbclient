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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class af {
    private com.baidu.tieba.homepage.concern.adapter.y iNQ;
    private l iXA;
    private m iXB;
    private u iXC;
    private n iXD;
    private r iXE;
    private p iXF;
    private j iXG;
    private i iXH;
    private h iXI;
    private ab iXJ;
    private g iXK;
    private o iXL;
    private c iXM;
    private y iXN;
    private x iXO;
    private z iXP;
    private w iXQ;
    private q iXR;
    private s iXS;
    private t iXT;
    private v iXU;
    private e iXV;
    private ac iXW;
    private com.baidu.adp.widget.ListView.a iXX;
    private com.baidu.adp.widget.ListView.a iXY;
    private com.baidu.adp.widget.ListView.a iXZ;
    private com.baidu.adp.widget.ListView.v iXs;
    private List<com.baidu.adp.widget.ListView.q> iXt;
    private b iXu;
    private ad iXv;
    private d iXw;
    private q iXx;
    private aa iXy;
    private k iXz;
    private com.baidu.adp.widget.ListView.a iYa;
    private com.baidu.adp.widget.ListView.a iYb;
    private com.baidu.adp.widget.ListView.a iYc;
    private com.baidu.adp.widget.ListView.a iYd;
    private boolean iYe;
    private boolean iYf;
    private List<com.baidu.adp.widget.ListView.a> iuN;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener iuP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cBV();
                if (af.this.iXt != null) {
                    af.this.bX(af.this.iXt);
                }
            }
        }
    };
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                af.this.aG(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.af.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.ecG = true;
                af.this.aG(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.af.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.ecG = false;
                af.this.aG(bVar);
            }
        }
    };
    private CustomMessageListener hqF = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b JA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (JA = af.this.JA(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, JA));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> iNr = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.iXs = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fh(context);
        a(vVar);
        vVar.addAdapters(this.iNr);
    }

    private void fh(Context context) {
        this.iXu = new b(this.mPageContext);
        this.iXv = new ad(this.mPageContext);
        this.iXw = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.iYF);
        this.iXx = new q(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.iXy = new aa(this.mPageContext, com.baidu.tieba.card.data.l.huk);
        this.iXz = new k(this.mPageContext, com.baidu.tieba.card.data.l.huq);
        this.iXA = new l(this.mPageContext, com.baidu.tieba.card.data.l.edk);
        this.iXB = new m(this.mPageContext, com.baidu.tieba.card.data.l.hur);
        this.iXC = new u(this.mPageContext, com.baidu.tieba.card.data.l.hup);
        this.iXD = new n(this.mPageContext, com.baidu.tieba.card.data.l.edw);
        this.iXE = new r(this.mPageContext, com.baidu.tieba.card.data.l.edy);
        this.iXF = new p(this.mPageContext, com.baidu.tieba.card.data.l.edz);
        this.iXG = new j(this.mPageContext, com.baidu.tieba.card.data.l.hul);
        this.iXH = new i(this.mPageContext, com.baidu.tieba.card.data.l.hum);
        this.iXI = new h(this.mPageContext, com.baidu.tieba.card.data.l.hun);
        this.iXJ = new ab(this.mPageContext, com.baidu.tieba.card.data.m.edC);
        this.iXL = new o(this.mPageContext, com.baidu.tieba.card.data.l.edA);
        this.iXM = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.iXN = new y(this.mPageContext, com.baidu.tieba.card.data.l.edG);
        this.iXO = new x(this.mPageContext, com.baidu.tieba.card.data.l.edH);
        this.iXP = new z(this.mPageContext, com.baidu.tieba.card.data.l.edJ);
        this.iXQ = new w(this.mPageContext, com.baidu.tieba.card.data.l.edI);
        this.iXR = new q(this.mPageContext, com.baidu.tieba.card.data.l.hui);
        this.iXS = new s(this.mPageContext, com.baidu.tieba.card.data.l.edN);
        this.iXT = new t(this.mPageContext, com.baidu.tieba.card.data.l.edO);
        this.iXU = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jdq);
        this.iXV = new e(this.mPageContext, com.baidu.tieba.card.data.f.htL);
        this.iXK = new g(this.mPageContext, com.baidu.tieba.card.data.l.huo);
        this.iXW = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.iNQ = new com.baidu.tieba.homepage.concern.adapter.y(this.mPageContext, com.baidu.tieba.card.data.l.huj, (byte) 3);
        this.iNr.add(this.iXu);
        this.iNr.add(this.iXv);
        this.iNr.add(this.iXw);
        this.iNr.add(this.iXx);
        this.iNr.add(this.iXy);
        this.iNr.add(this.iXz);
        this.iNr.add(this.iXA);
        this.iNr.add(this.iXB);
        this.iNr.add(this.iXC);
        this.iNr.add(this.iXD);
        this.iNr.add(this.iXE);
        this.iNr.add(this.iXF);
        this.iNr.add(this.iXG);
        this.iNr.add(this.iXH);
        this.iNr.add(this.iXI);
        this.iNr.add(this.iXJ);
        this.iNr.add(this.iXL);
        this.iNr.add(this.iXR);
        this.iNr.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.iNr.add(this.iXM);
        this.iNr.add(this.iXN);
        this.iNr.add(this.iXO);
        this.iNr.add(this.iXQ);
        this.iNr.add(this.iXP);
        this.iNr.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.iNr.add(this.iXS);
        this.iNr.add(this.iXT);
        this.iNr.add(this.iXU);
        this.iNr.add(this.iXV);
        this.iNr.add(this.iXK);
        this.iNr.add(this.iXW);
        this.iNr.add(this.iNQ);
        cBU();
        cBT();
        DH("page_recommend");
    }

    private void cBT() {
        if (!bw.edR.get()) {
            AdvertAppInfo.dYr.set(false);
            return;
        }
        this.iXX = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYi);
        this.iXY = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYl);
        this.iXZ = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYm);
        this.iYa = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYn);
        this.iYb = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYo);
        this.iYc = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYq);
        this.iYd = com.baidu.tieba.recapp.r.dqU().c(this.mPageContext, AdvertAppInfo.dYp);
        this.iNr.add(this.iXX);
        this.iNr.add(this.iXY);
        this.iNr.add(this.iXZ);
        this.iNr.add(this.iYa);
        this.iNr.add(this.iYb);
        this.iNr.add(this.iYc);
        this.iNr.add(this.iYd);
        AdvertAppInfo.dYr.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iXx.a(eVar);
        this.iXy.a(eVar);
        this.iXz.a(eVar);
        this.iXB.a(eVar);
        this.iXC.a(eVar);
        this.iXG.a(eVar);
        this.iXH.a(eVar);
        this.iXI.a(eVar);
        this.iXJ.a(eVar);
        this.iXK.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.iXy.a(vVar);
        this.iXz.a(vVar);
        this.iXA.a(vVar);
        this.iXB.a(vVar);
        this.iXC.a(vVar);
        this.iXD.a(vVar);
        this.iXE.a(vVar);
        this.iXF.a(vVar);
        this.iXG.a(vVar);
        this.iXH.a(vVar);
        this.iXI.a(vVar);
        this.iXK.a(vVar);
        this.iXJ.a(vVar);
        this.iXV.a(vVar);
        this.iXO.a(vVar);
        this.iXO.a(vVar);
        this.iXQ.a(vVar);
        this.iNQ.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.u(list, 2);
        ViewGroup listView = this.iXs.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).qR();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).qS();
            }
        }
        this.iXs.setData(list);
        this.iXt = list;
    }

    public void bX(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.u(list, 2);
        this.iXs.setData(list);
        this.iXt = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.iXu.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.iXs != null) {
            this.iXs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.iXx != null) {
            this.iXx.setFromCDN(z);
            this.iXR.setFromCDN(z);
            this.iXL.setFromCDN(z);
            this.iXN.setFromCDN(z);
        }
        if (this.iXB != null) {
            this.iXB.setFromCDN(z);
        }
        if (this.iXK != null) {
            this.iXK.setFromCDN(z);
        }
        if (this.iXY != null && (this.iXY instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iXY).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iXw != null) {
            this.iXw.setPageUniqueId(bdUniqueId);
        }
        if (this.iXx != null) {
            this.iXx.eSq = bdUniqueId;
        }
        if (this.iXy != null) {
            this.iXy.eSq = bdUniqueId;
        }
        if (this.iXz != null) {
            this.iXz.eSq = bdUniqueId;
        }
        if (this.iXA != null) {
            this.iXA.eSq = bdUniqueId;
        }
        if (this.iXB != null) {
            this.iXB.eSq = bdUniqueId;
        }
        if (this.iXC != null) {
            this.iXC.eSq = bdUniqueId;
        }
        if (this.iXD != null) {
            this.iXD.eSq = bdUniqueId;
        }
        if (this.iXE != null) {
            this.iXE.eSq = bdUniqueId;
        }
        if (this.iXF != null) {
            this.iXF.eSq = bdUniqueId;
        }
        if (this.iXG != null) {
            this.iXG.eSq = bdUniqueId;
        }
        if (this.iXH != null) {
            this.iXH.eSq = bdUniqueId;
        }
        if (this.iXI != null) {
            this.iXI.eSq = bdUniqueId;
        }
        if (this.iXL != null) {
            this.iXL.eSq = bdUniqueId;
        }
        if (this.iXJ != null) {
            this.iXJ.eSq = bdUniqueId;
        }
        if (this.iXu != null) {
            this.iXu.setPageUniqueId(bdUniqueId);
        }
        if (this.iXM != null) {
            this.iXM.eSq = bdUniqueId;
        }
        if (this.iXN != null) {
            this.iXN.eSq = bdUniqueId;
        }
        if (this.iXO != null) {
            this.iXO.eSq = bdUniqueId;
        }
        if (this.iXQ != null) {
            this.iXQ.eSq = bdUniqueId;
        }
        if (this.iXP != null) {
            this.iXP.eSq = bdUniqueId;
        }
        if (this.iXR != null) {
            this.iXR.eSq = bdUniqueId;
        }
        if (this.iXS != null) {
            this.iXS.eSq = bdUniqueId;
        }
        if (this.iXT != null) {
            this.iXT.eSq = bdUniqueId;
        }
        if (this.iXU != null) {
            this.iXU.eSq = bdUniqueId;
        }
        if (this.iXV != null) {
            this.iXV.eSq = bdUniqueId;
        }
        if (this.iXK != null) {
            this.iXK.eSq = bdUniqueId;
        }
        if (this.iXW != null) {
            this.iXW.eSq = bdUniqueId;
        }
        if (this.iNQ != null) {
            this.iNQ.eSq = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iuN)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iuN) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.ena.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ena);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hqF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hqF);
        if (!this.iYf) {
            this.iuP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iuP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.iXt != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.iXt.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q next = it.next();
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

    private void cBU() {
        this.iYf = cBV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cBV() {
        if (this.iuN == null || this.iuN.size() <= 0) {
            this.iuN = new ArrayList();
            ArrayList<BdUniqueId> dzU = com.baidu.tieba.tbadkCore.u.dzU();
            if (dzU == null || dzU.size() <= 0) {
                return false;
            }
            int size = dzU.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cRa().a(this.mPageContext, dzU.get(i), 2);
                if (this.iYe) {
                    a.setBusinessType(3);
                }
                if (this.iXx != null && this.iXx.eSq != null) {
                    a.setUniqueId(this.iXx.eSq);
                }
                this.iuN.add(a);
            }
            this.iXs.addAdapters(this.iuN);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.iNr) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.iXx != null) {
            this.iXx.setEventCallback(aVar);
        }
        if (this.iXC != null) {
            this.iXC.setEventCallback(aVar);
        }
        if (this.iXA != null) {
            this.iXA.setEventCallback(aVar);
        }
        if (this.iXL != null) {
            this.iXL.setEventCallback(aVar);
        }
        if (this.iXM != null) {
            this.iXM.setEventCallback(aVar);
        }
        if (this.iXN != null) {
            this.iXN.setEventCallback(aVar);
        }
        if (this.iXO != null) {
            this.iXO.setEventCallback(aVar);
        }
        if (this.iXQ != null) {
            this.iXQ.setEventCallback(aVar);
        }
        if (this.iXP != null) {
            this.iXP.setEventCallback(aVar);
        }
        if (this.iXR != null) {
            this.iXR.setEventCallback(aVar);
        }
        if (this.iXS != null) {
            this.iXS.setEventCallback(aVar);
        }
        if (this.iXT != null) {
            this.iXT.setEventCallback(aVar);
        }
        if (this.iXU != null) {
            this.iXU.setEventCallback(aVar);
        }
        if (this.iXV != null) {
            this.iXV.setEventCallback(aVar);
        }
        if (this.iXW != null) {
            this.iXW.setEventCallback(aVar);
        }
    }

    private void DH(String str) {
        if (this.iNr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iNr) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).DH(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).htK) != null && advertAppInfo.bdp() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b JA(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.m mVar;
        int i3 = 0;
        if (this.iXt == null || this.iXt.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.iXt.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.iXt.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.iXt.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.iXt.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.iXt.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.iXt.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.iXt.get(i4) instanceof com.baidu.tieba.card.data.m) && (mVar = (com.baidu.tieba.card.data.m) this.iXt.get(i4)) != null && mVar.dXg != null && str.equals(mVar.dXg.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.m) this.iXt.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.bb(i6 - i >= -1 ? i6 - i : -1);
        bVar.bc(i7);
        bVar.bd(i2);
        return bVar;
    }

    public void onPause() {
        if (this.iXJ != null) {
            this.iXJ.onPause();
        }
    }

    public void onResume() {
        if (this.iXJ != null) {
            this.iXJ.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iXt;
    }
}
