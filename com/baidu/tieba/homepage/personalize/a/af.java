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
    private com.baidu.tieba.homepage.concern.adapter.ab jJn;
    private m jTA;
    private n jTB;
    private v jTC;
    private o jTD;
    private s jTE;
    private q jTF;
    private k jTG;
    private j jTH;
    private i jTI;
    private ac jTJ;
    private h jTK;
    private p jTL;
    private d jTM;
    private c jTN;
    private z jTO;
    private y jTP;
    private aa jTQ;
    private x jTR;
    private r jTS;
    private t jTT;
    private u jTU;
    private w jTV;
    private f jTW;
    private com.baidu.adp.widget.ListView.a jTX;
    private com.baidu.adp.widget.ListView.a jTY;
    private com.baidu.adp.widget.ListView.a jTZ;
    private com.baidu.adp.widget.ListView.v jTs;
    private List<com.baidu.adp.widget.ListView.q> jTt;
    private b jTu;
    private ad jTv;
    private e jTw;
    private r jTx;
    private ab jTy;
    private l jTz;
    private com.baidu.adp.widget.ListView.a jUa;
    private com.baidu.adp.widget.ListView.a jUb;
    private com.baidu.adp.widget.ListView.a jUc;
    private com.baidu.adp.widget.ListView.a jUd;
    private boolean jUe;
    private boolean jUf;
    private List<com.baidu.adp.widget.ListView.a> jqr;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jqt = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cQh();
                if (af.this.jTt != null) {
                    af.this.cv(af.this.jTt);
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
    private CustomMessageListener ijs = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
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
    private List<com.baidu.adp.widget.ListView.a> jIK = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.jTs = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.J(context);
        fU(context);
        a(vVar);
        vVar.addAdapters(this.jIK);
    }

    private void fU(Context context) {
        this.jTu = new b(this.mPageContext);
        this.jTv = new ad(this.mPageContext);
        this.jTw = new e(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.jUF);
        this.jTx = new r(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jTy = new ab(this.mPageContext, com.baidu.tieba.card.data.k.inp);
        this.jTz = new l(this.mPageContext, com.baidu.tieba.card.data.k.inw);
        this.jTA = new m(this.mPageContext, com.baidu.tieba.card.data.k.eIX);
        this.jTB = new n(this.mPageContext, com.baidu.tieba.card.data.k.inx);
        this.jTC = new v(this.mPageContext, com.baidu.tieba.card.data.k.inv);
        this.jTD = new o(this.mPageContext, com.baidu.tieba.card.data.k.eJj);
        this.jTE = new s(this.mPageContext, com.baidu.tieba.card.data.k.eJl);
        this.jTF = new q(this.mPageContext, com.baidu.tieba.card.data.k.eJm);
        this.jTG = new k(this.mPageContext, com.baidu.tieba.card.data.k.inq);
        this.jTH = new j(this.mPageContext, com.baidu.tieba.card.data.k.inr);
        this.jTI = new i(this.mPageContext, com.baidu.tieba.card.data.k.f4int);
        this.jTJ = new ac(this.mPageContext, com.baidu.tieba.card.data.l.eJq);
        this.jTL = new p(this.mPageContext, com.baidu.tieba.card.data.k.eJo);
        this.jTM = new d(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jTN = new c(this.mPageContext, com.baidu.tieba.card.data.j.imV);
        this.jTO = new z(this.mPageContext, com.baidu.tieba.card.data.k.eJv);
        this.jTP = new y(this.mPageContext, com.baidu.tieba.card.data.k.eJw);
        this.jTQ = new aa(this.mPageContext, com.baidu.tieba.card.data.k.eJy);
        this.jTR = new x(this.mPageContext, com.baidu.tieba.card.data.k.eJx);
        this.jTS = new r(this.mPageContext, com.baidu.tieba.card.data.k.inn);
        this.jTT = new t(this.mPageContext, com.baidu.tieba.card.data.k.eJC);
        this.jTU = new u(this.mPageContext, com.baidu.tieba.card.data.k.eJD);
        this.jTV = new w(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jZd);
        this.jTW = new f(this.mPageContext, com.baidu.tieba.card.data.e.imQ);
        this.jTK = new h(this.mPageContext, com.baidu.tieba.card.data.k.inu);
        this.jJn = new com.baidu.tieba.homepage.concern.adapter.ab(this.mPageContext, com.baidu.tieba.card.data.k.ino, (byte) 3);
        this.jIK.add(this.jTu);
        this.jIK.add(this.jTv);
        this.jIK.add(this.jTw);
        this.jIK.add(this.jTx);
        this.jIK.add(this.jTy);
        this.jIK.add(this.jTz);
        this.jIK.add(this.jTA);
        this.jIK.add(this.jTB);
        this.jIK.add(this.jTC);
        this.jIK.add(this.jTD);
        this.jIK.add(this.jTE);
        this.jIK.add(this.jTF);
        this.jIK.add(this.jTG);
        this.jIK.add(this.jTH);
        this.jIK.add(this.jTI);
        this.jIK.add(this.jTJ);
        this.jIK.add(this.jTL);
        this.jIK.add(this.jTS);
        this.jIK.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.jIK.add(this.jTM);
        this.jIK.add(this.jTN);
        this.jIK.add(this.jTO);
        this.jIK.add(this.jTP);
        this.jIK.add(this.jTR);
        this.jIK.add(this.jTQ);
        this.jIK.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jIK.add(this.jTT);
        this.jIK.add(this.jTU);
        this.jIK.add(this.jTV);
        this.jIK.add(this.jTW);
        this.jIK.add(this.jTK);
        this.jIK.add(this.jJn);
        cQg();
        cNs();
        Fo("page_recommend");
    }

    private void cNs() {
        if (!by.eJG.get()) {
            AdvertAppInfo.eEb.set(false);
            return;
        }
        this.jTX = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDS, "INDEX");
        this.jTY = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDV, "INDEX");
        this.jTZ = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDW, "INDEX");
        this.jUa = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDX, "INDEX");
        this.jUb = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDY, "INDEX");
        this.jUc = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eEa, "INDEX");
        this.jUd = com.baidu.tieba.recapp.r.dFg().a(this.mPageContext, AdvertAppInfo.eDZ, "INDEX");
        this.jIK.add(this.jTX);
        this.jIK.add(this.jTY);
        this.jIK.add(this.jTZ);
        this.jIK.add(this.jUa);
        this.jIK.add(this.jUb);
        this.jIK.add(this.jUc);
        this.jIK.add(this.jUd);
        AdvertAppInfo.eEb.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jTx.a(eVar);
        this.jTy.a(eVar);
        this.jTz.a(eVar);
        this.jTB.a(eVar);
        this.jTC.a(eVar);
        this.jTG.a(eVar);
        this.jTH.a(eVar);
        this.jTI.a(eVar);
        this.jTJ.a(eVar);
        this.jTK.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jTy.a(vVar);
        this.jTz.a(vVar);
        this.jTA.a(vVar);
        this.jTB.a(vVar);
        this.jTC.a(vVar);
        this.jTD.a(vVar);
        this.jTE.a(vVar);
        this.jTF.a(vVar);
        this.jTG.a(vVar);
        this.jTH.a(vVar);
        this.jTI.a(vVar);
        this.jTK.a(vVar);
        this.jTJ.a(vVar);
        this.jTW.a(vVar);
        this.jTP.a(vVar);
        this.jTP.a(vVar);
        this.jTR.a(vVar);
        this.jJn.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.jTs.getListView();
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
        this.jTs.setData(list);
        this.jTt = list;
    }

    public void cv(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.jTs.setData(list);
        this.jTt = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.jTu.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.jTs != null) {
            this.jTs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jTx != null) {
            this.jTx.setFromCDN(z);
            this.jTS.setFromCDN(z);
            this.jTL.setFromCDN(z);
            this.jTO.setFromCDN(z);
        }
        if (this.jTB != null) {
            this.jTB.setFromCDN(z);
        }
        if (this.jTK != null) {
            this.jTK.setFromCDN(z);
        }
        if (this.jTY != null && (this.jTY instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.jTY).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jTw != null) {
            this.jTw.setPageUniqueId(bdUniqueId);
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
        if (this.jTH != null) {
            this.jTH.fzO = bdUniqueId;
        }
        if (this.jTI != null) {
            this.jTI.fzO = bdUniqueId;
        }
        if (this.jTL != null) {
            this.jTL.fzO = bdUniqueId;
        }
        if (this.jTJ != null) {
            this.jTJ.fzO = bdUniqueId;
        }
        if (this.jTu != null) {
            this.jTu.setPageUniqueId(bdUniqueId);
        }
        if (this.jTM != null) {
            this.jTM.fzO = bdUniqueId;
        }
        if (this.jTN != null) {
            this.jTN.fzO = bdUniqueId;
        }
        if (this.jTO != null) {
            this.jTO.fzO = bdUniqueId;
        }
        if (this.jTP != null) {
            this.jTP.fzO = bdUniqueId;
        }
        if (this.jTR != null) {
            this.jTR.fzO = bdUniqueId;
        }
        if (this.jTQ != null) {
            this.jTQ.fzO = bdUniqueId;
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
        if (this.jTV != null) {
            this.jTV.fzO = bdUniqueId;
        }
        if (this.jTW != null) {
            this.jTW.fzO = bdUniqueId;
        }
        if (this.jTK != null) {
            this.jTK.fzO = bdUniqueId;
        }
        if (this.jJn != null) {
            this.jJn.fzO = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jqr)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jqr) {
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
        this.ijs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ijs);
        if (!this.jUf) {
            this.jqt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jqt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.jTt != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.jTt.iterator();
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

    private void cQg() {
        this.jUf = cQh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQh() {
        if (this.jqr == null || this.jqr.size() <= 0) {
            this.jqr = new ArrayList();
            ArrayList<BdUniqueId> dOz = com.baidu.tieba.tbadkCore.v.dOz();
            if (dOz == null || dOz.size() <= 0) {
                return false;
            }
            int size = dOz.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.dfb().a(this.mPageContext, dOz.get(i), 2);
                if (this.jUe) {
                    a2.setBusinessType(3);
                }
                if (this.jTx != null && this.jTx.fzO != null) {
                    a2.setUniqueId(this.jTx.fzO);
                }
                this.jqr.add(a2);
            }
            this.jTs.addAdapters(this.jqr);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jIK) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jTx != null) {
            this.jTx.setEventCallback(aVar);
        }
        if (this.jTC != null) {
            this.jTC.setEventCallback(aVar);
        }
        if (this.jTA != null) {
            this.jTA.setEventCallback(aVar);
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
        if (this.jTO != null) {
            this.jTO.setEventCallback(aVar);
        }
        if (this.jTP != null) {
            this.jTP.setEventCallback(aVar);
        }
        if (this.jTR != null) {
            this.jTR.setEventCallback(aVar);
        }
        if (this.jTQ != null) {
            this.jTQ.setEventCallback(aVar);
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
        if (this.jTV != null) {
            this.jTV.setEventCallback(aVar);
        }
        if (this.jTW != null) {
            this.jTW.setEventCallback(aVar);
        }
    }

    private void Fo(String str) {
        if (this.jIK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jIK) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fo(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).imP) != null && advertAppInfo.bmD() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b LL(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.jTt == null || this.jTt.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.jTt.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.jTt.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.jTt.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.jTt.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.jTt.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.jTt.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.jTt.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.jTt.get(i4)) != null && lVar.eCR != null && str.equals(lVar.eCR.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.jTt.get(i4)).position;
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
        if (this.jTJ != null) {
            this.jTJ.onPause();
        }
    }

    public void onResume() {
        if (this.jTJ != null) {
            this.jTJ.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.jTt;
    }
}
