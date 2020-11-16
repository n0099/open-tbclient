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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class af {
    private com.baidu.adp.widget.ListView.v jFN;
    private List<com.baidu.adp.widget.ListView.q> jFO;
    private b jFP;
    private ad jFQ;
    private e jFR;
    private r jFS;
    private ab jFT;
    private l jFU;
    private m jFV;
    private n jFW;
    private v jFX;
    private o jFY;
    private s jFZ;
    private boolean jGA;
    private q jGa;
    private k jGb;
    private j jGc;
    private i jGd;
    private ac jGe;
    private h jGf;
    private p jGg;
    private d jGh;
    private c jGi;
    private z jGj;
    private y jGk;
    private aa jGl;
    private x jGm;
    private r jGn;
    private t jGo;
    private u jGp;
    private w jGq;
    private f jGr;
    private com.baidu.adp.widget.ListView.a jGs;
    private com.baidu.adp.widget.ListView.a jGt;
    private com.baidu.adp.widget.ListView.a jGu;
    private com.baidu.adp.widget.ListView.a jGv;
    private com.baidu.adp.widget.ListView.a jGw;
    private com.baidu.adp.widget.ListView.a jGx;
    private com.baidu.adp.widget.ListView.a jGy;
    private boolean jGz;
    private List<com.baidu.adp.widget.ListView.a> jcM;
    private com.baidu.tieba.homepage.concern.adapter.ab jvL;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jcO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.af.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                af.this.cKS();
                if (af.this.jFO != null) {
                    af.this.cr(af.this.jFO);
                }
            }
        }
    };
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.af.2
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
                bVar.eBr = true;
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
                bVar.eBr = false;
                af.this.aL(bVar);
            }
        }
    };
    private CustomMessageListener hYt = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.af.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b KE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (KE = af.this.KE(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, KE));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jvi = new ArrayList();

    public af(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.jFN = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fo(context);
        a(vVar);
        vVar.addAdapters(this.jvi);
    }

    private void fo(Context context) {
        this.jFP = new b(this.mPageContext);
        this.jFQ = new ad(this.mPageContext);
        this.jFR = new e(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.jHa);
        this.jFS = new r(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jFT = new ab(this.mPageContext, com.baidu.tieba.card.data.k.icq);
        this.jFU = new l(this.mPageContext, com.baidu.tieba.card.data.k.icw);
        this.jFV = new m(this.mPageContext, com.baidu.tieba.card.data.k.eBW);
        this.jFW = new n(this.mPageContext, com.baidu.tieba.card.data.k.icx);
        this.jFX = new v(this.mPageContext, com.baidu.tieba.card.data.k.icv);
        this.jFY = new o(this.mPageContext, com.baidu.tieba.card.data.k.eCi);
        this.jFZ = new s(this.mPageContext, com.baidu.tieba.card.data.k.eCk);
        this.jGa = new q(this.mPageContext, com.baidu.tieba.card.data.k.eCl);
        this.jGb = new k(this.mPageContext, com.baidu.tieba.card.data.k.icr);
        this.jGc = new j(this.mPageContext, com.baidu.tieba.card.data.k.ics);
        this.jGd = new i(this.mPageContext, com.baidu.tieba.card.data.k.ict);
        this.jGe = new ac(this.mPageContext, com.baidu.tieba.card.data.l.eCo);
        this.jGg = new p(this.mPageContext, com.baidu.tieba.card.data.k.eCm);
        this.jGh = new d(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.jGi = new c(this.mPageContext, com.baidu.tieba.card.data.j.ibW);
        this.jGj = new z(this.mPageContext, com.baidu.tieba.card.data.k.eCt);
        this.jGk = new y(this.mPageContext, com.baidu.tieba.card.data.k.eCu);
        this.jGl = new aa(this.mPageContext, com.baidu.tieba.card.data.k.eCw);
        this.jGm = new x(this.mPageContext, com.baidu.tieba.card.data.k.eCv);
        this.jGn = new r(this.mPageContext, com.baidu.tieba.card.data.k.ico);
        this.jGo = new t(this.mPageContext, com.baidu.tieba.card.data.k.eCA);
        this.jGp = new u(this.mPageContext, com.baidu.tieba.card.data.k.eCB);
        this.jGq = new w(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jLy);
        this.jGr = new f(this.mPageContext, com.baidu.tieba.card.data.e.ibR);
        this.jGf = new h(this.mPageContext, com.baidu.tieba.card.data.k.icu);
        this.jvL = new com.baidu.tieba.homepage.concern.adapter.ab(this.mPageContext, com.baidu.tieba.card.data.k.icp, (byte) 3);
        this.jvi.add(this.jFP);
        this.jvi.add(this.jFQ);
        this.jvi.add(this.jFR);
        this.jvi.add(this.jFS);
        this.jvi.add(this.jFT);
        this.jvi.add(this.jFU);
        this.jvi.add(this.jFV);
        this.jvi.add(this.jFW);
        this.jvi.add(this.jFX);
        this.jvi.add(this.jFY);
        this.jvi.add(this.jFZ);
        this.jvi.add(this.jGa);
        this.jvi.add(this.jGb);
        this.jvi.add(this.jGc);
        this.jvi.add(this.jGd);
        this.jvi.add(this.jGe);
        this.jvi.add(this.jGg);
        this.jvi.add(this.jGn);
        this.jvi.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.jvi.add(this.jGh);
        this.jvi.add(this.jGi);
        this.jvi.add(this.jGj);
        this.jvi.add(this.jGk);
        this.jvi.add(this.jGm);
        this.jvi.add(this.jGl);
        this.jvi.add(new ae(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jvi.add(this.jGo);
        this.jvi.add(this.jGp);
        this.jvi.add(this.jGq);
        this.jvi.add(this.jGr);
        this.jvi.add(this.jGf);
        this.jvi.add(this.jvL);
        cKR();
        cKQ();
        EA("page_recommend");
    }

    private void cKQ() {
        if (!bx.eCE.get()) {
            AdvertAppInfo.exa.set(false);
            return;
        }
        this.jGs = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewR);
        this.jGt = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewU);
        this.jGu = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewV);
        this.jGv = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewW);
        this.jGw = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewX);
        this.jGx = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewZ);
        this.jGy = com.baidu.tieba.recapp.q.dzO().c(this.mPageContext, AdvertAppInfo.ewY);
        this.jvi.add(this.jGs);
        this.jvi.add(this.jGt);
        this.jvi.add(this.jGu);
        this.jvi.add(this.jGv);
        this.jvi.add(this.jGw);
        this.jvi.add(this.jGx);
        this.jvi.add(this.jGy);
        AdvertAppInfo.exa.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jFS.a(eVar);
        this.jFT.a(eVar);
        this.jFU.a(eVar);
        this.jFW.a(eVar);
        this.jFX.a(eVar);
        this.jGb.a(eVar);
        this.jGc.a(eVar);
        this.jGd.a(eVar);
        this.jGe.a(eVar);
        this.jGf.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jFT.a(vVar);
        this.jFU.a(vVar);
        this.jFV.a(vVar);
        this.jFW.a(vVar);
        this.jFX.a(vVar);
        this.jFY.a(vVar);
        this.jFZ.a(vVar);
        this.jGa.a(vVar);
        this.jGb.a(vVar);
        this.jGc.a(vVar);
        this.jGd.a(vVar);
        this.jGf.a(vVar);
        this.jGe.a(vVar);
        this.jGr.a(vVar);
        this.jGk.a(vVar);
        this.jGk.a(vVar);
        this.jGm.a(vVar);
        this.jvL.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.x(list, 2);
        ViewGroup listView = this.jFN.getListView();
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
        this.jFN.setData(list);
        this.jFO = list;
    }

    public void cr(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.x(list, 2);
        this.jFN.setData(list);
        this.jFO = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.jFP.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.jFN != null) {
            this.jFN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jFS != null) {
            this.jFS.setFromCDN(z);
            this.jGn.setFromCDN(z);
            this.jGg.setFromCDN(z);
            this.jGj.setFromCDN(z);
        }
        if (this.jFW != null) {
            this.jFW.setFromCDN(z);
        }
        if (this.jGf != null) {
            this.jGf.setFromCDN(z);
        }
        if (this.jGt != null && (this.jGt instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.jGt).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jFR != null) {
            this.jFR.setPageUniqueId(bdUniqueId);
        }
        if (this.jFS != null) {
            this.jFS.fsa = bdUniqueId;
        }
        if (this.jFT != null) {
            this.jFT.fsa = bdUniqueId;
        }
        if (this.jFU != null) {
            this.jFU.fsa = bdUniqueId;
        }
        if (this.jFV != null) {
            this.jFV.fsa = bdUniqueId;
        }
        if (this.jFW != null) {
            this.jFW.fsa = bdUniqueId;
        }
        if (this.jFX != null) {
            this.jFX.fsa = bdUniqueId;
        }
        if (this.jFY != null) {
            this.jFY.fsa = bdUniqueId;
        }
        if (this.jFZ != null) {
            this.jFZ.fsa = bdUniqueId;
        }
        if (this.jGa != null) {
            this.jGa.fsa = bdUniqueId;
        }
        if (this.jGb != null) {
            this.jGb.fsa = bdUniqueId;
        }
        if (this.jGc != null) {
            this.jGc.fsa = bdUniqueId;
        }
        if (this.jGd != null) {
            this.jGd.fsa = bdUniqueId;
        }
        if (this.jGg != null) {
            this.jGg.fsa = bdUniqueId;
        }
        if (this.jGe != null) {
            this.jGe.fsa = bdUniqueId;
        }
        if (this.jFP != null) {
            this.jFP.setPageUniqueId(bdUniqueId);
        }
        if (this.jGh != null) {
            this.jGh.fsa = bdUniqueId;
        }
        if (this.jGi != null) {
            this.jGi.fsa = bdUniqueId;
        }
        if (this.jGj != null) {
            this.jGj.fsa = bdUniqueId;
        }
        if (this.jGk != null) {
            this.jGk.fsa = bdUniqueId;
        }
        if (this.jGm != null) {
            this.jGm.fsa = bdUniqueId;
        }
        if (this.jGl != null) {
            this.jGl.fsa = bdUniqueId;
        }
        if (this.jGn != null) {
            this.jGn.fsa = bdUniqueId;
        }
        if (this.jGo != null) {
            this.jGo.fsa = bdUniqueId;
        }
        if (this.jGp != null) {
            this.jGp.fsa = bdUniqueId;
        }
        if (this.jGq != null) {
            this.jGq.fsa = bdUniqueId;
        }
        if (this.jGr != null) {
            this.jGr.fsa = bdUniqueId;
        }
        if (this.jGf != null) {
            this.jGf.fsa = bdUniqueId;
        }
        if (this.jvL != null) {
            this.jvL.fsa = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jcM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jcM) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.eMu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eMu);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hYt.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hYt);
        if (!this.jGA) {
            this.jcO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jcO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.jFO != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.jFO.iterator();
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

    private void cKR() {
        this.jGA = cKS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKS() {
        if (this.jcM == null || this.jcM.size() <= 0) {
            this.jcM = new ArrayList();
            ArrayList<BdUniqueId> dJh = com.baidu.tieba.tbadkCore.u.dJh();
            if (dJh == null || dJh.size() <= 0) {
                return false;
            }
            int size = dJh.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.cZP().a(this.mPageContext, dJh.get(i), 2);
                if (this.jGz) {
                    a2.setBusinessType(3);
                }
                if (this.jFS != null && this.jFS.fsa != null) {
                    a2.setUniqueId(this.jFS.fsa);
                }
                this.jcM.add(a2);
            }
            this.jFN.addAdapters(this.jcM);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jvi) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jFS != null) {
            this.jFS.setEventCallback(aVar);
        }
        if (this.jFX != null) {
            this.jFX.setEventCallback(aVar);
        }
        if (this.jFV != null) {
            this.jFV.setEventCallback(aVar);
        }
        if (this.jGg != null) {
            this.jGg.setEventCallback(aVar);
        }
        if (this.jGh != null) {
            this.jGh.setEventCallback(aVar);
        }
        if (this.jGi != null) {
            this.jGi.setEventCallback(aVar);
        }
        if (this.jGj != null) {
            this.jGj.setEventCallback(aVar);
        }
        if (this.jGk != null) {
            this.jGk.setEventCallback(aVar);
        }
        if (this.jGm != null) {
            this.jGm.setEventCallback(aVar);
        }
        if (this.jGl != null) {
            this.jGl.setEventCallback(aVar);
        }
        if (this.jGn != null) {
            this.jGn.setEventCallback(aVar);
        }
        if (this.jGo != null) {
            this.jGo.setEventCallback(aVar);
        }
        if (this.jGp != null) {
            this.jGp.setEventCallback(aVar);
        }
        if (this.jGq != null) {
            this.jGq.setEventCallback(aVar);
        }
        if (this.jGr != null) {
            this.jGr.setEventCallback(aVar);
        }
    }

    private void EA(String str) {
        if (this.jvi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jvi) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EA(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).ibQ) != null && advertAppInfo.bjt() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b KE(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.jFO == null || this.jFO.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.jFO.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.jFO.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.jFO.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.jFO.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.jFO.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.jFO.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.jFO.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.jFO.get(i4)) != null && lVar.evQ != null && str.equals(lVar.evQ.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.jFO.get(i4)).position;
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
        if (this.jGe != null) {
            this.jGe.onPause();
        }
    }

    public void onResume() {
        if (this.jGe != null) {
            this.jGe.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.jFO;
    }
}
