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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class af {
    private List<com.baidu.adp.widget.ListView.a> hZi;
    private boolean iAA;
    private boolean iAB;
    private r iAa;
    private p iAb;
    private j iAc;
    private i iAd;
    private h iAe;
    private ab iAf;
    private g iAg;
    private o iAh;
    private c iAi;
    private y iAj;
    private x iAk;
    private z iAl;
    private w iAm;
    private q iAn;
    private s iAo;
    private t iAp;
    private v iAq;
    private e iAr;
    private ac iAs;
    private com.baidu.adp.widget.ListView.a iAt;
    private com.baidu.adp.widget.ListView.a iAu;
    private com.baidu.adp.widget.ListView.a iAv;
    private com.baidu.adp.widget.ListView.a iAw;
    private com.baidu.adp.widget.ListView.a iAx;
    private com.baidu.adp.widget.ListView.a iAy;
    private com.baidu.adp.widget.ListView.a iAz;
    private com.baidu.adp.widget.ListView.v izO;
    private List<com.baidu.adp.widget.ListView.q> izP;
    private b izQ;
    private ad izR;
    private d izS;
    private q izT;
    private aa izU;
    private k izV;
    private l izW;
    private m izX;
    private u izY;
    private n izZ;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hZk = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cnu();
                if (af.this.izP != null) {
                    af.this.bR(af.this.izP);
                }
            }
        }
    };
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                af.this.aC(updateAttentionMessage.getData());
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
                bVar.dQY = true;
                af.this.aC(bVar);
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
                bVar.dQY = false;
                af.this.aC(bVar);
            }
        }
    };
    private CustomMessageListener gWF = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Gz;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Gz = af.this.Gz(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Gz));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> irB = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.izO = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eP(context);
        a(vVar);
        vVar.addAdapters(this.irB);
    }

    private void eP(Context context) {
        this.izQ = new b(this.mPageContext);
        this.izR = new ad(this.mPageContext);
        this.izS = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.iBb);
        this.izT = new q(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.izU = new aa(this.mPageContext, com.baidu.tieba.card.data.k.haj);
        this.izV = new k(this.mPageContext, com.baidu.tieba.card.data.k.haq);
        this.izW = new l(this.mPageContext, com.baidu.tieba.card.data.k.hak);
        this.izX = new m(this.mPageContext, com.baidu.tieba.card.data.k.har);
        this.izY = new u(this.mPageContext, com.baidu.tieba.card.data.k.hap);
        this.izZ = new n(this.mPageContext, com.baidu.tieba.card.data.k.dRM);
        this.iAa = new r(this.mPageContext, com.baidu.tieba.card.data.k.dRO);
        this.iAb = new p(this.mPageContext, com.baidu.tieba.card.data.k.dRP);
        this.iAc = new j(this.mPageContext, com.baidu.tieba.card.data.k.hal);
        this.iAd = new i(this.mPageContext, com.baidu.tieba.card.data.k.ham);
        this.iAe = new h(this.mPageContext, com.baidu.tieba.card.data.k.han);
        this.iAf = new ab(this.mPageContext, com.baidu.tieba.card.data.l.dRS);
        this.iAh = new o(this.mPageContext, com.baidu.tieba.card.data.k.dRQ);
        this.iAi = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.iAj = new y(this.mPageContext, com.baidu.tieba.card.data.k.dRW);
        this.iAk = new x(this.mPageContext, com.baidu.tieba.card.data.k.dRX);
        this.iAl = new z(this.mPageContext, com.baidu.tieba.card.data.k.dRZ);
        this.iAm = new w(this.mPageContext, com.baidu.tieba.card.data.k.dRY);
        this.iAn = new q(this.mPageContext, com.baidu.tieba.card.data.k.hai);
        this.iAo = new s(this.mPageContext, com.baidu.tieba.card.data.k.dSd);
        this.iAp = new t(this.mPageContext, com.baidu.tieba.card.data.k.dSe);
        this.iAq = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.iFG);
        this.iAr = new e(this.mPageContext, com.baidu.tieba.card.data.e.gZL);
        this.iAg = new g(this.mPageContext, com.baidu.tieba.card.data.k.hao);
        this.iAs = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.irB.add(this.izQ);
        this.irB.add(this.izR);
        this.irB.add(this.izS);
        this.irB.add(this.izT);
        this.irB.add(this.izU);
        this.irB.add(this.izV);
        this.irB.add(this.izW);
        this.irB.add(this.izX);
        this.irB.add(this.izY);
        this.irB.add(this.izZ);
        this.irB.add(this.iAa);
        this.irB.add(this.iAb);
        this.irB.add(this.iAc);
        this.irB.add(this.iAd);
        this.irB.add(this.iAe);
        this.irB.add(this.iAf);
        this.irB.add(this.iAh);
        this.irB.add(this.iAn);
        this.irB.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.irB.add(this.iAi);
        this.irB.add(this.iAj);
        this.irB.add(this.iAk);
        this.irB.add(this.iAm);
        this.irB.add(this.iAl);
        this.irB.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.irB.add(this.iAo);
        this.irB.add(this.iAp);
        this.irB.add(this.iAq);
        this.irB.add(this.iAr);
        this.irB.add(this.iAg);
        this.irB.add(this.iAs);
        cnt();
        cns();
        AP("page_recommend");
    }

    private void cns() {
        if (!bv.dSh.get()) {
            AdvertAppInfo.dMU.set(false);
            return;
        }
        this.iAt = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dML);
        this.iAu = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMO);
        this.iAv = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMP);
        this.iAw = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMQ);
        this.iAx = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMR);
        this.iAy = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMT);
        this.iAz = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMS);
        this.irB.add(this.iAt);
        this.irB.add(this.iAu);
        this.irB.add(this.iAv);
        this.irB.add(this.iAw);
        this.irB.add(this.iAx);
        this.irB.add(this.iAy);
        this.irB.add(this.iAz);
        AdvertAppInfo.dMU.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.izT.a(eVar);
        this.izU.a(eVar);
        this.izV.a(eVar);
        this.izX.a(eVar);
        this.izY.a(eVar);
        this.iAc.a(eVar);
        this.iAd.a(eVar);
        this.iAe.a(eVar);
        this.iAf.a(eVar);
        this.iAg.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.izU.a(vVar);
        this.izV.a(vVar);
        this.izW.a(vVar);
        this.izX.a(vVar);
        this.izY.a(vVar);
        this.izZ.a(vVar);
        this.iAa.a(vVar);
        this.iAb.a(vVar);
        this.iAc.a(vVar);
        this.iAd.a(vVar);
        this.iAe.a(vVar);
        this.iAg.a(vVar);
        this.iAf.a(vVar);
        this.iAr.a(vVar);
        this.iAk.a(vVar);
        this.iAk.a(vVar);
        this.iAm.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        ViewGroup listView = this.izO.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).pn();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).po();
            }
        }
        this.izO.setData(list);
        this.izP = list;
    }

    public void bR(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        this.izO.setData(list);
        this.izP = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.izQ.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.izO != null) {
            this.izO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.izT != null) {
            this.izT.setFromCDN(z);
            this.iAn.setFromCDN(z);
            this.iAh.setFromCDN(z);
            this.iAj.setFromCDN(z);
        }
        if (this.izX != null) {
            this.izX.setFromCDN(z);
        }
        if (this.iAg != null) {
            this.iAg.setFromCDN(z);
        }
        if (this.iAu != null && (this.iAu instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iAu).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.izS != null) {
            this.izS.setPageUniqueId(bdUniqueId);
        }
        if (this.izT != null) {
            this.izT.eEU = bdUniqueId;
        }
        if (this.izU != null) {
            this.izU.eEU = bdUniqueId;
        }
        if (this.izV != null) {
            this.izV.eEU = bdUniqueId;
        }
        if (this.izW != null) {
            this.izW.eEU = bdUniqueId;
        }
        if (this.izX != null) {
            this.izX.eEU = bdUniqueId;
        }
        if (this.izY != null) {
            this.izY.eEU = bdUniqueId;
        }
        if (this.izZ != null) {
            this.izZ.eEU = bdUniqueId;
        }
        if (this.iAa != null) {
            this.iAa.eEU = bdUniqueId;
        }
        if (this.iAb != null) {
            this.iAb.eEU = bdUniqueId;
        }
        if (this.iAc != null) {
            this.iAc.eEU = bdUniqueId;
        }
        if (this.iAd != null) {
            this.iAd.eEU = bdUniqueId;
        }
        if (this.iAe != null) {
            this.iAe.eEU = bdUniqueId;
        }
        if (this.iAh != null) {
            this.iAh.eEU = bdUniqueId;
        }
        if (this.iAf != null) {
            this.iAf.eEU = bdUniqueId;
        }
        if (this.izQ != null) {
            this.izQ.setPageUniqueId(bdUniqueId);
        }
        if (this.iAi != null) {
            this.iAi.eEU = bdUniqueId;
        }
        if (this.iAj != null) {
            this.iAj.eEU = bdUniqueId;
        }
        if (this.iAk != null) {
            this.iAk.eEU = bdUniqueId;
        }
        if (this.iAm != null) {
            this.iAm.eEU = bdUniqueId;
        }
        if (this.iAl != null) {
            this.iAl.eEU = bdUniqueId;
        }
        if (this.iAn != null) {
            this.iAn.eEU = bdUniqueId;
        }
        if (this.iAo != null) {
            this.iAo.eEU = bdUniqueId;
        }
        if (this.iAp != null) {
            this.iAp.eEU = bdUniqueId;
        }
        if (this.iAq != null) {
            this.iAq.eEU = bdUniqueId;
        }
        if (this.iAr != null) {
            this.iAr.eEU = bdUniqueId;
        }
        if (this.iAg != null) {
            this.iAg.eEU = bdUniqueId;
        }
        if (this.iAs != null) {
            this.iAs.eEU = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.hZi)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hZi) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.eaY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eaY);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.gWF.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gWF);
        if (!this.iAB) {
            this.hZk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hZk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.izP != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.izP.iterator();
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

    private void cnt() {
        this.iAB = cnu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnu() {
        if (this.hZi == null || this.hZi.size() <= 0) {
            this.hZi = new ArrayList();
            ArrayList<BdUniqueId> dkz = com.baidu.tieba.tbadkCore.t.dkz();
            if (dkz == null || dkz.size() <= 0) {
                return false;
            }
            int size = dkz.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cCC().a(this.mPageContext, dkz.get(i), 2);
                if (this.iAA) {
                    a.setBusinessType(3);
                }
                if (this.izT != null && this.izT.eEU != null) {
                    a.setUniqueId(this.izT.eEU);
                }
                this.hZi.add(a);
            }
            this.izO.addAdapters(this.hZi);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.irB) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.izT != null) {
            this.izT.setEventCallback(aVar);
        }
        if (this.izY != null) {
            this.izY.setEventCallback(aVar);
        }
        if (this.izW != null) {
            this.izW.setEventCallback(aVar);
        }
        if (this.iAh != null) {
            this.iAh.setEventCallback(aVar);
        }
        if (this.iAi != null) {
            this.iAi.setEventCallback(aVar);
        }
        if (this.iAj != null) {
            this.iAj.setEventCallback(aVar);
        }
        if (this.iAk != null) {
            this.iAk.setEventCallback(aVar);
        }
        if (this.iAm != null) {
            this.iAm.setEventCallback(aVar);
        }
        if (this.iAl != null) {
            this.iAl.setEventCallback(aVar);
        }
        if (this.iAn != null) {
            this.iAn.setEventCallback(aVar);
        }
        if (this.iAo != null) {
            this.iAo.setEventCallback(aVar);
        }
        if (this.iAp != null) {
            this.iAp.setEventCallback(aVar);
        }
        if (this.iAq != null) {
            this.iAq.setEventCallback(aVar);
        }
        if (this.iAr != null) {
            this.iAr.setEventCallback(aVar);
        }
        if (this.iAs != null) {
            this.iAs.setEventCallback(aVar);
        }
    }

    private void AP(String str) {
        if (this.irB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.irB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).AP(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).gZK) != null && advertAppInfo.aUe() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Gz(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.izP == null || this.izP.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.izP.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.izP.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.izP.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.izP.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.izP.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.izP.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.izP.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.izP.get(i4)) != null && lVar.dLK != null && str.equals(lVar.dLK.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.izP.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aU(i6 - i >= -1 ? i6 - i : -1);
        bVar.aV(i7);
        bVar.aW(i2);
        return bVar;
    }

    public void onPause() {
        if (this.iAf != null) {
            this.iAf.onPause();
        }
    }

    public void onResume() {
        if (this.iAf != null) {
            this.iAf.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.izP;
    }
}
