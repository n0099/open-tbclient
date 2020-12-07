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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class af {
    private com.baidu.tieba.homepage.concern.adapter.ab jJl;
    private v jTA;
    private o jTB;
    private s jTC;
    private q jTD;
    private k jTE;
    private j jTF;
    private i jTG;
    private ac jTH;
    private h jTI;
    private p jTJ;
    private d jTK;
    private c jTL;
    private z jTM;
    private y jTN;
    private aa jTO;
    private x jTP;
    private r jTQ;
    private t jTR;
    private u jTS;
    private w jTT;
    private f jTU;
    private com.baidu.adp.widget.ListView.a jTV;
    private com.baidu.adp.widget.ListView.a jTW;
    private com.baidu.adp.widget.ListView.a jTX;
    private com.baidu.adp.widget.ListView.a jTY;
    private com.baidu.adp.widget.ListView.a jTZ;
    private com.baidu.adp.widget.ListView.v jTq;
    private List<com.baidu.adp.widget.ListView.q> jTr;
    private b jTs;
    private ad jTt;
    private e jTu;
    private r jTv;
    private ab jTw;
    private l jTx;
    private m jTy;
    private n jTz;
    private com.baidu.adp.widget.ListView.a jUa;
    private com.baidu.adp.widget.ListView.a jUb;
    private boolean jUc;
    private boolean jUd;
    private List<com.baidu.adp.widget.ListView.a> jqp;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jqr = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cQg();
                if (af.this.jTr != null) {
                    af.this.cv(af.this.jTr);
                }
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                af.this.aL(updateAttentionMessage.getData());
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
                bVar.eIr = true;
                af.this.aL(bVar);
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
                bVar.eIr = false;
                af.this.aL(bVar);
            }
        }
    };
    private CustomMessageListener ijq = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b LL;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (LL = af.this.LL(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, LL));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jII = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.jTq = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.J(context);
        fU(context);
        a(vVar);
        vVar.addAdapters(this.jII);
    }

    private void fU(Context context) {
        this.jTs = new b(this.mPageContext);
        this.jTt = new ad(this.mPageContext);
        this.jTu = new e(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.jUD);
        this.jTv = new r(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jTw = new ab(this.mPageContext, com.baidu.tieba.card.data.k.inn);
        this.jTx = new l(this.mPageContext, com.baidu.tieba.card.data.k.inu);
        this.jTy = new m(this.mPageContext, com.baidu.tieba.card.data.k.eIX);
        this.jTz = new n(this.mPageContext, com.baidu.tieba.card.data.k.inv);
        this.jTA = new v(this.mPageContext, com.baidu.tieba.card.data.k.f4int);
        this.jTB = new o(this.mPageContext, com.baidu.tieba.card.data.k.eJj);
        this.jTC = new s(this.mPageContext, com.baidu.tieba.card.data.k.eJl);
        this.jTD = new q(this.mPageContext, com.baidu.tieba.card.data.k.eJm);
        this.jTE = new k(this.mPageContext, com.baidu.tieba.card.data.k.ino);
        this.jTF = new j(this.mPageContext, com.baidu.tieba.card.data.k.inp);
        this.jTG = new i(this.mPageContext, com.baidu.tieba.card.data.k.inq);
        this.jTH = new ac(this.mPageContext, com.baidu.tieba.card.data.l.eJq);
        this.jTJ = new p(this.mPageContext, com.baidu.tieba.card.data.k.eJo);
        this.jTK = new d(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jTL = new c(this.mPageContext, com.baidu.tieba.card.data.j.imT);
        this.jTM = new z(this.mPageContext, com.baidu.tieba.card.data.k.eJv);
        this.jTN = new y(this.mPageContext, com.baidu.tieba.card.data.k.eJw);
        this.jTO = new aa(this.mPageContext, com.baidu.tieba.card.data.k.eJy);
        this.jTP = new x(this.mPageContext, com.baidu.tieba.card.data.k.eJx);
        this.jTQ = new r(this.mPageContext, com.baidu.tieba.card.data.k.inl);
        this.jTR = new t(this.mPageContext, com.baidu.tieba.card.data.k.eJC);
        this.jTS = new u(this.mPageContext, com.baidu.tieba.card.data.k.eJD);
        this.jTT = new w(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jZb);
        this.jTU = new f(this.mPageContext, com.baidu.tieba.card.data.e.imO);
        this.jTI = new h(this.mPageContext, com.baidu.tieba.card.data.k.inr);
        this.jJl = new com.baidu.tieba.homepage.concern.adapter.ab(this.mPageContext, com.baidu.tieba.card.data.k.inm, (byte) 3);
        this.jII.add(this.jTs);
        this.jII.add(this.jTt);
        this.jII.add(this.jTu);
        this.jII.add(this.jTv);
        this.jII.add(this.jTw);
        this.jII.add(this.jTx);
        this.jII.add(this.jTy);
        this.jII.add(this.jTz);
        this.jII.add(this.jTA);
        this.jII.add(this.jTB);
        this.jII.add(this.jTC);
        this.jII.add(this.jTD);
        this.jII.add(this.jTE);
        this.jII.add(this.jTF);
        this.jII.add(this.jTG);
        this.jII.add(this.jTH);
        this.jII.add(this.jTJ);
        this.jII.add(this.jTQ);
        this.jII.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.jII.add(this.jTK);
        this.jII.add(this.jTL);
        this.jII.add(this.jTM);
        this.jII.add(this.jTN);
        this.jII.add(this.jTP);
        this.jII.add(this.jTO);
        this.jII.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jII.add(this.jTR);
        this.jII.add(this.jTS);
        this.jII.add(this.jTT);
        this.jII.add(this.jTU);
        this.jII.add(this.jTI);
        this.jII.add(this.jJl);
        cQf();
        cNr();
        Fo("page_recommend");
    }

    private void cNr() {
        if (!by.eJG.get()) {
            AdvertAppInfo.eEb.set(false);
            return;
        }
        this.jTV = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDS, "INDEX");
        this.jTW = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDV, "INDEX");
        this.jTX = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDW, "INDEX");
        this.jTY = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDX, "INDEX");
        this.jTZ = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDY, "INDEX");
        this.jUa = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eEa, "INDEX");
        this.jUb = com.baidu.tieba.recapp.r.dFf().a(this.mPageContext, AdvertAppInfo.eDZ, "INDEX");
        this.jII.add(this.jTV);
        this.jII.add(this.jTW);
        this.jII.add(this.jTX);
        this.jII.add(this.jTY);
        this.jII.add(this.jTZ);
        this.jII.add(this.jUa);
        this.jII.add(this.jUb);
        AdvertAppInfo.eEb.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jTv.a(eVar);
        this.jTw.a(eVar);
        this.jTx.a(eVar);
        this.jTz.a(eVar);
        this.jTA.a(eVar);
        this.jTE.a(eVar);
        this.jTF.a(eVar);
        this.jTG.a(eVar);
        this.jTH.a(eVar);
        this.jTI.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jTw.a(vVar);
        this.jTx.a(vVar);
        this.jTy.a(vVar);
        this.jTz.a(vVar);
        this.jTA.a(vVar);
        this.jTB.a(vVar);
        this.jTC.a(vVar);
        this.jTD.a(vVar);
        this.jTE.a(vVar);
        this.jTF.a(vVar);
        this.jTG.a(vVar);
        this.jTI.a(vVar);
        this.jTH.a(vVar);
        this.jTU.a(vVar);
        this.jTN.a(vVar);
        this.jTN.a(vVar);
        this.jTP.a(vVar);
        this.jJl.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.jTq.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).qT();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).qU();
            }
        }
        this.jTq.setData(list);
        this.jTr = list;
    }

    public void cv(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.jTq.setData(list);
        this.jTr = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.jTs.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.jTq != null) {
            this.jTq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jTv != null) {
            this.jTv.setFromCDN(z);
            this.jTQ.setFromCDN(z);
            this.jTJ.setFromCDN(z);
            this.jTM.setFromCDN(z);
        }
        if (this.jTz != null) {
            this.jTz.setFromCDN(z);
        }
        if (this.jTI != null) {
            this.jTI.setFromCDN(z);
        }
        if (this.jTW != null && (this.jTW instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.jTW).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jTu != null) {
            this.jTu.setPageUniqueId(bdUniqueId);
        }
        if (this.jTv != null) {
            this.jTv.fzO = bdUniqueId;
        }
        if (this.jTw != null) {
            this.jTw.fzO = bdUniqueId;
        }
        if (this.jTx != null) {
            this.jTx.fzO = bdUniqueId;
        }
        if (this.jTy != null) {
            this.jTy.fzO = bdUniqueId;
        }
        if (this.jTz != null) {
            this.jTz.fzO = bdUniqueId;
        }
        if (this.jTA != null) {
            this.jTA.fzO = bdUniqueId;
        }
        if (this.jTB != null) {
            this.jTB.fzO = bdUniqueId;
        }
        if (this.jTC != null) {
            this.jTC.fzO = bdUniqueId;
        }
        if (this.jTD != null) {
            this.jTD.fzO = bdUniqueId;
        }
        if (this.jTE != null) {
            this.jTE.fzO = bdUniqueId;
        }
        if (this.jTF != null) {
            this.jTF.fzO = bdUniqueId;
        }
        if (this.jTG != null) {
            this.jTG.fzO = bdUniqueId;
        }
        if (this.jTJ != null) {
            this.jTJ.fzO = bdUniqueId;
        }
        if (this.jTH != null) {
            this.jTH.fzO = bdUniqueId;
        }
        if (this.jTs != null) {
            this.jTs.setPageUniqueId(bdUniqueId);
        }
        if (this.jTK != null) {
            this.jTK.fzO = bdUniqueId;
        }
        if (this.jTL != null) {
            this.jTL.fzO = bdUniqueId;
        }
        if (this.jTM != null) {
            this.jTM.fzO = bdUniqueId;
        }
        if (this.jTN != null) {
            this.jTN.fzO = bdUniqueId;
        }
        if (this.jTP != null) {
            this.jTP.fzO = bdUniqueId;
        }
        if (this.jTO != null) {
            this.jTO.fzO = bdUniqueId;
        }
        if (this.jTQ != null) {
            this.jTQ.fzO = bdUniqueId;
        }
        if (this.jTR != null) {
            this.jTR.fzO = bdUniqueId;
        }
        if (this.jTS != null) {
            this.jTS.fzO = bdUniqueId;
        }
        if (this.jTT != null) {
            this.jTT.fzO = bdUniqueId;
        }
        if (this.jTU != null) {
            this.jTU.fzO = bdUniqueId;
        }
        if (this.jTI != null) {
            this.jTI.fzO = bdUniqueId;
        }
        if (this.jJl != null) {
            this.jJl.fzO = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jqp)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jqp) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.eTG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eTG);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.ijq.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ijq);
        if (!this.jUd) {
            this.jqr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jqr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.jTr != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.jTr.iterator();
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

    private void cQf() {
        this.jUd = cQg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQg() {
        if (this.jqp == null || this.jqp.size() <= 0) {
            this.jqp = new ArrayList();
            ArrayList<BdUniqueId> dOy = com.baidu.tieba.tbadkCore.v.dOy();
            if (dOy == null || dOy.size() <= 0) {
                return false;
            }
            int size = dOy.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.dfa().a(this.mPageContext, dOy.get(i), 2);
                if (this.jUc) {
                    a2.setBusinessType(3);
                }
                if (this.jTv != null && this.jTv.fzO != null) {
                    a2.setUniqueId(this.jTv.fzO);
                }
                this.jqp.add(a2);
            }
            this.jTq.addAdapters(this.jqp);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jII) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jTv != null) {
            this.jTv.setEventCallback(aVar);
        }
        if (this.jTA != null) {
            this.jTA.setEventCallback(aVar);
        }
        if (this.jTy != null) {
            this.jTy.setEventCallback(aVar);
        }
        if (this.jTJ != null) {
            this.jTJ.setEventCallback(aVar);
        }
        if (this.jTK != null) {
            this.jTK.setEventCallback(aVar);
        }
        if (this.jTL != null) {
            this.jTL.setEventCallback(aVar);
        }
        if (this.jTM != null) {
            this.jTM.setEventCallback(aVar);
        }
        if (this.jTN != null) {
            this.jTN.setEventCallback(aVar);
        }
        if (this.jTP != null) {
            this.jTP.setEventCallback(aVar);
        }
        if (this.jTO != null) {
            this.jTO.setEventCallback(aVar);
        }
        if (this.jTQ != null) {
            this.jTQ.setEventCallback(aVar);
        }
        if (this.jTR != null) {
            this.jTR.setEventCallback(aVar);
        }
        if (this.jTS != null) {
            this.jTS.setEventCallback(aVar);
        }
        if (this.jTT != null) {
            this.jTT.setEventCallback(aVar);
        }
        if (this.jTU != null) {
            this.jTU.setEventCallback(aVar);
        }
    }

    private void Fo(String str) {
        if (this.jII != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jII) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fo(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).imN) != null && advertAppInfo.bmD() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b LL(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.jTr == null || this.jTr.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.jTr.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.jTr.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.jTr.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.jTr.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.jTr.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.jTr.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.jTr.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.jTr.get(i4)) != null && lVar.eCR != null && str.equals(lVar.eCR.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.jTr.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.bf(i6 - i >= -1 ? i6 - i : -1);
        bVar.bg(i7);
        bVar.bh(i2);
        return bVar;
    }

    public void onPause() {
        if (this.jTH != null) {
            this.jTH.onPause();
        }
    }

    public void onResume() {
        if (this.jTH != null) {
            this.jTH.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.jTr;
    }
}
