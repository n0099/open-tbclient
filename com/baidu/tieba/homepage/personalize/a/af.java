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
/* loaded from: classes22.dex */
public class af {
    private List<com.baidu.adp.widget.ListView.a> iJG;
    private com.baidu.tieba.homepage.concern.adapter.y jcI;
    private m jmA;
    private u jmB;
    private n jmC;
    private r jmD;
    private p jmE;
    private j jmF;
    private i jmG;
    private h jmH;
    private ab jmI;
    private g jmJ;
    private o jmK;
    private c jmL;
    private y jmM;
    private x jmN;
    private z jmO;
    private w jmP;
    private q jmQ;
    private s jmR;
    private t jmS;
    private v jmT;
    private e jmU;
    private ac jmV;
    private com.baidu.adp.widget.ListView.a jmW;
    private com.baidu.adp.widget.ListView.a jmX;
    private com.baidu.adp.widget.ListView.a jmY;
    private com.baidu.adp.widget.ListView.a jmZ;
    private com.baidu.adp.widget.ListView.v jmr;
    private List<com.baidu.adp.widget.ListView.q> jms;
    private b jmt;
    private ad jmu;
    private d jmv;
    private q jmw;
    private aa jmx;
    private k jmy;
    private l jmz;
    private com.baidu.adp.widget.ListView.a jna;
    private com.baidu.adp.widget.ListView.a jnb;
    private com.baidu.adp.widget.ListView.a jnc;
    private boolean jnd;
    private boolean jne;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cFE();
                if (af.this.jms != null) {
                    af.this.ca(af.this.jms);
                }
            }
        }
    };
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                af.this.aJ(updateAttentionMessage.getData());
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
                bVar.eoL = true;
                af.this.aJ(bVar);
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
                bVar.eoL = false;
                af.this.aJ(bVar);
            }
        }
    };
    private CustomMessageListener hFz = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Kn;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Kn = af.this.Kn(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Kn));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jcj = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.jmr = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fo(context);
        a(vVar);
        vVar.addAdapters(this.jcj);
    }

    private void fo(Context context) {
        this.jmt = new b(this.mPageContext);
        this.jmu = new ad(this.mPageContext);
        this.jmv = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.jnE);
        this.jmw = new q(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.jmx = new aa(this.mPageContext, com.baidu.tieba.card.data.l.hJf);
        this.jmy = new k(this.mPageContext, com.baidu.tieba.card.data.l.hJl);
        this.jmz = new l(this.mPageContext, com.baidu.tieba.card.data.l.epp);
        this.jmA = new m(this.mPageContext, com.baidu.tieba.card.data.l.hJm);
        this.jmB = new u(this.mPageContext, com.baidu.tieba.card.data.l.hJk);
        this.jmC = new n(this.mPageContext, com.baidu.tieba.card.data.l.epB);
        this.jmD = new r(this.mPageContext, com.baidu.tieba.card.data.l.epD);
        this.jmE = new p(this.mPageContext, com.baidu.tieba.card.data.l.epE);
        this.jmF = new j(this.mPageContext, com.baidu.tieba.card.data.l.hJg);
        this.jmG = new i(this.mPageContext, com.baidu.tieba.card.data.l.hJh);
        this.jmH = new h(this.mPageContext, com.baidu.tieba.card.data.l.hJi);
        this.jmI = new ab(this.mPageContext, com.baidu.tieba.card.data.m.epH);
        this.jmK = new o(this.mPageContext, com.baidu.tieba.card.data.l.epF);
        this.jmL = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jmM = new y(this.mPageContext, com.baidu.tieba.card.data.l.epL);
        this.jmN = new x(this.mPageContext, com.baidu.tieba.card.data.l.epM);
        this.jmO = new z(this.mPageContext, com.baidu.tieba.card.data.l.epO);
        this.jmP = new w(this.mPageContext, com.baidu.tieba.card.data.l.epN);
        this.jmQ = new q(this.mPageContext, com.baidu.tieba.card.data.l.hJd);
        this.jmR = new s(this.mPageContext, com.baidu.tieba.card.data.l.epS);
        this.jmS = new t(this.mPageContext, com.baidu.tieba.card.data.l.epT);
        this.jmT = new v(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jsp);
        this.jmU = new e(this.mPageContext, com.baidu.tieba.card.data.f.hIF);
        this.jmJ = new g(this.mPageContext, com.baidu.tieba.card.data.l.hJj);
        this.jmV = new ac(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.jcI = new com.baidu.tieba.homepage.concern.adapter.y(this.mPageContext, com.baidu.tieba.card.data.l.hJe, (byte) 3);
        this.jcj.add(this.jmt);
        this.jcj.add(this.jmu);
        this.jcj.add(this.jmv);
        this.jcj.add(this.jmw);
        this.jcj.add(this.jmx);
        this.jcj.add(this.jmy);
        this.jcj.add(this.jmz);
        this.jcj.add(this.jmA);
        this.jcj.add(this.jmB);
        this.jcj.add(this.jmC);
        this.jcj.add(this.jmD);
        this.jcj.add(this.jmE);
        this.jcj.add(this.jmF);
        this.jcj.add(this.jmG);
        this.jcj.add(this.jmH);
        this.jcj.add(this.jmI);
        this.jcj.add(this.jmK);
        this.jcj.add(this.jmQ);
        this.jcj.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.jcj.add(this.jmL);
        this.jcj.add(this.jmM);
        this.jcj.add(this.jmN);
        this.jcj.add(this.jmP);
        this.jcj.add(this.jmO);
        this.jcj.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jcj.add(this.jmR);
        this.jcj.add(this.jmS);
        this.jcj.add(this.jmT);
        this.jcj.add(this.jmU);
        this.jcj.add(this.jmJ);
        this.jcj.add(this.jmV);
        this.jcj.add(this.jcI);
        cFD();
        cFC();
        Es("page_recommend");
    }

    private void cFC() {
        if (!bw.epW.get()) {
            AdvertAppInfo.ekt.set(false);
            return;
        }
        this.jmW = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.ekk);
        this.jmX = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.ekn);
        this.jmY = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.eko);
        this.jmZ = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.ekp);
        this.jna = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.ekq);
        this.jnb = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.eks);
        this.jnc = com.baidu.tieba.recapp.r.duF().c(this.mPageContext, AdvertAppInfo.ekr);
        this.jcj.add(this.jmW);
        this.jcj.add(this.jmX);
        this.jcj.add(this.jmY);
        this.jcj.add(this.jmZ);
        this.jcj.add(this.jna);
        this.jcj.add(this.jnb);
        this.jcj.add(this.jnc);
        AdvertAppInfo.ekt.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jmw.a(eVar);
        this.jmx.a(eVar);
        this.jmy.a(eVar);
        this.jmA.a(eVar);
        this.jmB.a(eVar);
        this.jmF.a(eVar);
        this.jmG.a(eVar);
        this.jmH.a(eVar);
        this.jmI.a(eVar);
        this.jmJ.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jmx.a(vVar);
        this.jmy.a(vVar);
        this.jmz.a(vVar);
        this.jmA.a(vVar);
        this.jmB.a(vVar);
        this.jmC.a(vVar);
        this.jmD.a(vVar);
        this.jmE.a(vVar);
        this.jmF.a(vVar);
        this.jmG.a(vVar);
        this.jmH.a(vVar);
        this.jmJ.a(vVar);
        this.jmI.a(vVar);
        this.jmU.a(vVar);
        this.jmN.a(vVar);
        this.jmN.a(vVar);
        this.jmP.a(vVar);
        this.jcI.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.w(list, 2);
        ViewGroup listView = this.jmr.getListView();
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
        this.jmr.setData(list);
        this.jms = list;
    }

    public void ca(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.w(list, 2);
        this.jmr.setData(list);
        this.jms = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.jmt.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.jmr != null) {
            this.jmr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jmw != null) {
            this.jmw.setFromCDN(z);
            this.jmQ.setFromCDN(z);
            this.jmK.setFromCDN(z);
            this.jmM.setFromCDN(z);
        }
        if (this.jmA != null) {
            this.jmA.setFromCDN(z);
        }
        if (this.jmJ != null) {
            this.jmJ.setFromCDN(z);
        }
        if (this.jmX != null && (this.jmX instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.jmX).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jmv != null) {
            this.jmv.setPageUniqueId(bdUniqueId);
        }
        if (this.jmw != null) {
            this.jmw.fey = bdUniqueId;
        }
        if (this.jmx != null) {
            this.jmx.fey = bdUniqueId;
        }
        if (this.jmy != null) {
            this.jmy.fey = bdUniqueId;
        }
        if (this.jmz != null) {
            this.jmz.fey = bdUniqueId;
        }
        if (this.jmA != null) {
            this.jmA.fey = bdUniqueId;
        }
        if (this.jmB != null) {
            this.jmB.fey = bdUniqueId;
        }
        if (this.jmC != null) {
            this.jmC.fey = bdUniqueId;
        }
        if (this.jmD != null) {
            this.jmD.fey = bdUniqueId;
        }
        if (this.jmE != null) {
            this.jmE.fey = bdUniqueId;
        }
        if (this.jmF != null) {
            this.jmF.fey = bdUniqueId;
        }
        if (this.jmG != null) {
            this.jmG.fey = bdUniqueId;
        }
        if (this.jmH != null) {
            this.jmH.fey = bdUniqueId;
        }
        if (this.jmK != null) {
            this.jmK.fey = bdUniqueId;
        }
        if (this.jmI != null) {
            this.jmI.fey = bdUniqueId;
        }
        if (this.jmt != null) {
            this.jmt.setPageUniqueId(bdUniqueId);
        }
        if (this.jmL != null) {
            this.jmL.fey = bdUniqueId;
        }
        if (this.jmM != null) {
            this.jmM.fey = bdUniqueId;
        }
        if (this.jmN != null) {
            this.jmN.fey = bdUniqueId;
        }
        if (this.jmP != null) {
            this.jmP.fey = bdUniqueId;
        }
        if (this.jmO != null) {
            this.jmO.fey = bdUniqueId;
        }
        if (this.jmQ != null) {
            this.jmQ.fey = bdUniqueId;
        }
        if (this.jmR != null) {
            this.jmR.fey = bdUniqueId;
        }
        if (this.jmS != null) {
            this.jmS.fey = bdUniqueId;
        }
        if (this.jmT != null) {
            this.jmT.fey = bdUniqueId;
        }
        if (this.jmU != null) {
            this.jmU.fey = bdUniqueId;
        }
        if (this.jmJ != null) {
            this.jmJ.fey = bdUniqueId;
        }
        if (this.jmV != null) {
            this.jmV.fey = bdUniqueId;
        }
        if (this.jcI != null) {
            this.jcI.fey = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iJG)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iJG) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.ezk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ezk);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hFz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hFz);
        if (!this.jne) {
            this.iJI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iJI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.jms != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.jms.iterator();
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

    private void cFD() {
        this.jne = cFE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cFE() {
        if (this.iJG == null || this.iJG.size() <= 0) {
            this.iJG = new ArrayList();
            ArrayList<BdUniqueId> dDG = com.baidu.tieba.tbadkCore.u.dDG();
            if (dDG == null || dDG.size() <= 0) {
                return false;
            }
            int size = dDG.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.cUK().a(this.mPageContext, dDG.get(i), 2);
                if (this.jnd) {
                    a2.setBusinessType(3);
                }
                if (this.jmw != null && this.jmw.fey != null) {
                    a2.setUniqueId(this.jmw.fey);
                }
                this.iJG.add(a2);
            }
            this.jmr.addAdapters(this.iJG);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jcj) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jmw != null) {
            this.jmw.setEventCallback(aVar);
        }
        if (this.jmB != null) {
            this.jmB.setEventCallback(aVar);
        }
        if (this.jmz != null) {
            this.jmz.setEventCallback(aVar);
        }
        if (this.jmK != null) {
            this.jmK.setEventCallback(aVar);
        }
        if (this.jmL != null) {
            this.jmL.setEventCallback(aVar);
        }
        if (this.jmM != null) {
            this.jmM.setEventCallback(aVar);
        }
        if (this.jmN != null) {
            this.jmN.setEventCallback(aVar);
        }
        if (this.jmP != null) {
            this.jmP.setEventCallback(aVar);
        }
        if (this.jmO != null) {
            this.jmO.setEventCallback(aVar);
        }
        if (this.jmQ != null) {
            this.jmQ.setEventCallback(aVar);
        }
        if (this.jmR != null) {
            this.jmR.setEventCallback(aVar);
        }
        if (this.jmS != null) {
            this.jmS.setEventCallback(aVar);
        }
        if (this.jmT != null) {
            this.jmT.setEventCallback(aVar);
        }
        if (this.jmU != null) {
            this.jmU.setEventCallback(aVar);
        }
        if (this.jmV != null) {
            this.jmV.setEventCallback(aVar);
        }
    }

    private void Es(String str) {
        if (this.jcj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jcj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Es(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).hIE) != null && advertAppInfo.bfY() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Kn(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.m mVar;
        int i3 = 0;
        if (this.jms == null || this.jms.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.jms.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.jms.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.jms.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.jms.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.jms.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.jms.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.jms.get(i4) instanceof com.baidu.tieba.card.data.m) && (mVar = (com.baidu.tieba.card.data.m) this.jms.get(i4)) != null && mVar.eji != null && str.equals(mVar.eji.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.m) this.jms.get(i4)).position;
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
        if (this.jmI != null) {
            this.jmI.onPause();
        }
    }

    public void onResume() {
        if (this.jmI != null) {
            this.jmI.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.jms;
    }
}
