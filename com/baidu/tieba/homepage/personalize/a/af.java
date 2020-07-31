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
    private List<com.baidu.adp.widget.ListView.a> hZg;
    private j iAa;
    private i iAb;
    private h iAc;
    private ab iAd;
    private g iAe;
    private o iAf;
    private c iAg;
    private y iAh;
    private x iAi;
    private z iAj;
    private w iAk;
    private q iAl;
    private s iAm;
    private t iAn;
    private v iAo;
    private e iAp;
    private ac iAq;
    private com.baidu.adp.widget.ListView.a iAr;
    private com.baidu.adp.widget.ListView.a iAs;
    private com.baidu.adp.widget.ListView.a iAt;
    private com.baidu.adp.widget.ListView.a iAu;
    private com.baidu.adp.widget.ListView.a iAv;
    private com.baidu.adp.widget.ListView.a iAw;
    private com.baidu.adp.widget.ListView.a iAx;
    private boolean iAy;
    private boolean iAz;
    private com.baidu.adp.widget.ListView.v izM;
    private List<com.baidu.adp.widget.ListView.q> izN;
    private b izO;
    private ad izP;
    private d izQ;
    private q izR;
    private aa izS;
    private k izT;
    private l izU;
    private m izV;
    private u izW;
    private n izX;
    private r izY;
    private p izZ;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hZi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cnu();
                if (af.this.izN != null) {
                    af.this.bR(af.this.izN);
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
    private List<com.baidu.adp.widget.ListView.a> irz = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.izM = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eP(context);
        a(vVar);
        vVar.addAdapters(this.irz);
    }

    private void eP(Context context) {
        this.izO = new b(this.mPageContext);
        this.izP = new ad(this.mPageContext);
        this.izQ = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.iAZ);
        this.izR = new q(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.izS = new aa(this.mPageContext, com.baidu.tieba.card.data.k.haj);
        this.izT = new k(this.mPageContext, com.baidu.tieba.card.data.k.haq);
        this.izU = new l(this.mPageContext, com.baidu.tieba.card.data.k.hak);
        this.izV = new m(this.mPageContext, com.baidu.tieba.card.data.k.har);
        this.izW = new u(this.mPageContext, com.baidu.tieba.card.data.k.hap);
        this.izX = new n(this.mPageContext, com.baidu.tieba.card.data.k.dRM);
        this.izY = new r(this.mPageContext, com.baidu.tieba.card.data.k.dRO);
        this.izZ = new p(this.mPageContext, com.baidu.tieba.card.data.k.dRP);
        this.iAa = new j(this.mPageContext, com.baidu.tieba.card.data.k.hal);
        this.iAb = new i(this.mPageContext, com.baidu.tieba.card.data.k.ham);
        this.iAc = new h(this.mPageContext, com.baidu.tieba.card.data.k.han);
        this.iAd = new ab(this.mPageContext, com.baidu.tieba.card.data.l.dRS);
        this.iAf = new o(this.mPageContext, com.baidu.tieba.card.data.k.dRQ);
        this.iAg = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.iAh = new y(this.mPageContext, com.baidu.tieba.card.data.k.dRW);
        this.iAi = new x(this.mPageContext, com.baidu.tieba.card.data.k.dRX);
        this.iAj = new z(this.mPageContext, com.baidu.tieba.card.data.k.dRZ);
        this.iAk = new w(this.mPageContext, com.baidu.tieba.card.data.k.dRY);
        this.iAl = new q(this.mPageContext, com.baidu.tieba.card.data.k.hai);
        this.iAm = new s(this.mPageContext, com.baidu.tieba.card.data.k.dSd);
        this.iAn = new t(this.mPageContext, com.baidu.tieba.card.data.k.dSe);
        this.iAo = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.iFE);
        this.iAp = new e(this.mPageContext, com.baidu.tieba.card.data.e.gZL);
        this.iAe = new g(this.mPageContext, com.baidu.tieba.card.data.k.hao);
        this.iAq = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.irz.add(this.izO);
        this.irz.add(this.izP);
        this.irz.add(this.izQ);
        this.irz.add(this.izR);
        this.irz.add(this.izS);
        this.irz.add(this.izT);
        this.irz.add(this.izU);
        this.irz.add(this.izV);
        this.irz.add(this.izW);
        this.irz.add(this.izX);
        this.irz.add(this.izY);
        this.irz.add(this.izZ);
        this.irz.add(this.iAa);
        this.irz.add(this.iAb);
        this.irz.add(this.iAc);
        this.irz.add(this.iAd);
        this.irz.add(this.iAf);
        this.irz.add(this.iAl);
        this.irz.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.irz.add(this.iAg);
        this.irz.add(this.iAh);
        this.irz.add(this.iAi);
        this.irz.add(this.iAk);
        this.irz.add(this.iAj);
        this.irz.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.irz.add(this.iAm);
        this.irz.add(this.iAn);
        this.irz.add(this.iAo);
        this.irz.add(this.iAp);
        this.irz.add(this.iAe);
        this.irz.add(this.iAq);
        cnt();
        cns();
        AP("page_recommend");
    }

    private void cns() {
        if (!bv.dSh.get()) {
            AdvertAppInfo.dMU.set(false);
            return;
        }
        this.iAr = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dML);
        this.iAs = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMO);
        this.iAt = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMP);
        this.iAu = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMQ);
        this.iAv = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMR);
        this.iAw = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMT);
        this.iAx = com.baidu.tieba.recapp.r.dca().c(this.mPageContext, AdvertAppInfo.dMS);
        this.irz.add(this.iAr);
        this.irz.add(this.iAs);
        this.irz.add(this.iAt);
        this.irz.add(this.iAu);
        this.irz.add(this.iAv);
        this.irz.add(this.iAw);
        this.irz.add(this.iAx);
        AdvertAppInfo.dMU.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.izR.a(eVar);
        this.izS.a(eVar);
        this.izT.a(eVar);
        this.izV.a(eVar);
        this.izW.a(eVar);
        this.iAa.a(eVar);
        this.iAb.a(eVar);
        this.iAc.a(eVar);
        this.iAd.a(eVar);
        this.iAe.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.izS.a(vVar);
        this.izT.a(vVar);
        this.izU.a(vVar);
        this.izV.a(vVar);
        this.izW.a(vVar);
        this.izX.a(vVar);
        this.izY.a(vVar);
        this.izZ.a(vVar);
        this.iAa.a(vVar);
        this.iAb.a(vVar);
        this.iAc.a(vVar);
        this.iAe.a(vVar);
        this.iAd.a(vVar);
        this.iAp.a(vVar);
        this.iAi.a(vVar);
        this.iAi.a(vVar);
        this.iAk.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        ViewGroup listView = this.izM.getListView();
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
        this.izM.setData(list);
        this.izN = list;
    }

    public void bR(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.t.r(list, 2);
        this.izM.setData(list);
        this.izN = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.izO.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.izM != null) {
            this.izM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.izR != null) {
            this.izR.setFromCDN(z);
            this.iAl.setFromCDN(z);
            this.iAf.setFromCDN(z);
            this.iAh.setFromCDN(z);
        }
        if (this.izV != null) {
            this.izV.setFromCDN(z);
        }
        if (this.iAe != null) {
            this.iAe.setFromCDN(z);
        }
        if (this.iAs != null && (this.iAs instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iAs).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.izQ != null) {
            this.izQ.setPageUniqueId(bdUniqueId);
        }
        if (this.izR != null) {
            this.izR.eEU = bdUniqueId;
        }
        if (this.izS != null) {
            this.izS.eEU = bdUniqueId;
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
        if (this.iAf != null) {
            this.iAf.eEU = bdUniqueId;
        }
        if (this.iAd != null) {
            this.iAd.eEU = bdUniqueId;
        }
        if (this.izO != null) {
            this.izO.setPageUniqueId(bdUniqueId);
        }
        if (this.iAg != null) {
            this.iAg.eEU = bdUniqueId;
        }
        if (this.iAh != null) {
            this.iAh.eEU = bdUniqueId;
        }
        if (this.iAi != null) {
            this.iAi.eEU = bdUniqueId;
        }
        if (this.iAk != null) {
            this.iAk.eEU = bdUniqueId;
        }
        if (this.iAj != null) {
            this.iAj.eEU = bdUniqueId;
        }
        if (this.iAl != null) {
            this.iAl.eEU = bdUniqueId;
        }
        if (this.iAm != null) {
            this.iAm.eEU = bdUniqueId;
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
        if (this.iAe != null) {
            this.iAe.eEU = bdUniqueId;
        }
        if (this.iAq != null) {
            this.iAq.eEU = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.hZg)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hZg) {
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
        if (!this.iAz) {
            this.hZi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hZi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.izN != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.izN.iterator();
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
        this.iAz = cnu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnu() {
        if (this.hZg == null || this.hZg.size() <= 0) {
            this.hZg = new ArrayList();
            ArrayList<BdUniqueId> dky = com.baidu.tieba.tbadkCore.t.dky();
            if (dky == null || dky.size() <= 0) {
                return false;
            }
            int size = dky.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cCC().a(this.mPageContext, dky.get(i), 2);
                if (this.iAy) {
                    a.setBusinessType(3);
                }
                if (this.izR != null && this.izR.eEU != null) {
                    a.setUniqueId(this.izR.eEU);
                }
                this.hZg.add(a);
            }
            this.izM.addAdapters(this.hZg);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.irz) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.izR != null) {
            this.izR.setEventCallback(aVar);
        }
        if (this.izW != null) {
            this.izW.setEventCallback(aVar);
        }
        if (this.izU != null) {
            this.izU.setEventCallback(aVar);
        }
        if (this.iAf != null) {
            this.iAf.setEventCallback(aVar);
        }
        if (this.iAg != null) {
            this.iAg.setEventCallback(aVar);
        }
        if (this.iAh != null) {
            this.iAh.setEventCallback(aVar);
        }
        if (this.iAi != null) {
            this.iAi.setEventCallback(aVar);
        }
        if (this.iAk != null) {
            this.iAk.setEventCallback(aVar);
        }
        if (this.iAj != null) {
            this.iAj.setEventCallback(aVar);
        }
        if (this.iAl != null) {
            this.iAl.setEventCallback(aVar);
        }
        if (this.iAm != null) {
            this.iAm.setEventCallback(aVar);
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
    }

    private void AP(String str) {
        if (this.irz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.irz) {
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
        if (this.izN == null || this.izN.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.izN.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.izN.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.izN.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.izN.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.izN.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.izN.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.izN.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.izN.get(i4)) != null && lVar.dLK != null && str.equals(lVar.dLK.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.izN.get(i4)).position;
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
        if (this.iAd != null) {
            this.iAd.onPause();
        }
    }

    public void onResume() {
        if (this.iAd != null) {
            this.iAd.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.izN;
    }
}
