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
public class ag {
    private com.baidu.adp.widget.ListView.v jEN;
    private List<com.baidu.adp.widget.ListView.q> jEO;
    private b jEP;
    private ae jEQ;
    private e jER;
    private r jES;
    private ab jET;
    private l jEU;
    private m jEV;
    private n jEW;
    private v jEX;
    private o jEY;
    private s jEZ;
    private boolean jFA;
    private boolean jFB;
    private q jFa;
    private k jFb;
    private j jFc;
    private i jFd;
    private ac jFe;
    private h jFf;
    private p jFg;
    private d jFh;
    private c jFi;
    private z jFj;
    private y jFk;
    private aa jFl;
    private x jFm;
    private r jFn;
    private t jFo;
    private u jFp;
    private w jFq;
    private f jFr;
    private ad jFs;
    private com.baidu.adp.widget.ListView.a jFt;
    private com.baidu.adp.widget.ListView.a jFu;
    private com.baidu.adp.widget.ListView.a jFv;
    private com.baidu.adp.widget.ListView.a jFw;
    private com.baidu.adp.widget.ListView.a jFx;
    private com.baidu.adp.widget.ListView.a jFy;
    private com.baidu.adp.widget.ListView.a jFz;
    private List<com.baidu.adp.widget.ListView.a> jbZ;
    private com.baidu.tieba.homepage.concern.adapter.z jvb;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jcb = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ag.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ag.this.cLm();
                if (ag.this.jEO != null) {
                    ag.this.cr(ag.this.jEO);
                }
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ag.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ag.this.aK(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ag.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eDa = true;
                ag.this.aK(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ag.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eDa = false;
                ag.this.aK(bVar);
            }
        }
    };
    private CustomMessageListener hXT = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ag.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Ld;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Ld = ag.this.Ld(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Ld));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> juB = new ArrayList();

    public ag(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.jEN = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fp(context);
        a(vVar);
        vVar.addAdapters(this.juB);
    }

    private void fp(Context context) {
        this.jEP = new b(this.mPageContext);
        this.jEQ = new ae(this.mPageContext);
        this.jER = new e(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.jGb);
        this.jES = new r(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.jET = new ab(this.mPageContext, com.baidu.tieba.card.data.l.ibz);
        this.jEU = new l(this.mPageContext, com.baidu.tieba.card.data.l.ibF);
        this.jEV = new m(this.mPageContext, com.baidu.tieba.card.data.l.eDE);
        this.jEW = new n(this.mPageContext, com.baidu.tieba.card.data.l.ibG);
        this.jEX = new v(this.mPageContext, com.baidu.tieba.card.data.l.ibE);
        this.jEY = new o(this.mPageContext, com.baidu.tieba.card.data.l.eDQ);
        this.jEZ = new s(this.mPageContext, com.baidu.tieba.card.data.l.eDS);
        this.jFa = new q(this.mPageContext, com.baidu.tieba.card.data.l.eDT);
        this.jFb = new k(this.mPageContext, com.baidu.tieba.card.data.l.ibA);
        this.jFc = new j(this.mPageContext, com.baidu.tieba.card.data.l.ibB);
        this.jFd = new i(this.mPageContext, com.baidu.tieba.card.data.l.ibC);
        this.jFe = new ac(this.mPageContext, com.baidu.tieba.card.data.m.eDW);
        this.jFg = new p(this.mPageContext, com.baidu.tieba.card.data.l.eDU);
        this.jFh = new d(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jFi = new c(this.mPageContext, com.baidu.tieba.card.data.k.ibe);
        this.jFj = new z(this.mPageContext, com.baidu.tieba.card.data.l.eEb);
        this.jFk = new y(this.mPageContext, com.baidu.tieba.card.data.l.eEc);
        this.jFl = new aa(this.mPageContext, com.baidu.tieba.card.data.l.eEe);
        this.jFm = new x(this.mPageContext, com.baidu.tieba.card.data.l.eEd);
        this.jFn = new r(this.mPageContext, com.baidu.tieba.card.data.l.ibx);
        this.jFo = new t(this.mPageContext, com.baidu.tieba.card.data.l.eEi);
        this.jFp = new u(this.mPageContext, com.baidu.tieba.card.data.l.eEj);
        this.jFq = new w(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jKN);
        this.jFr = new f(this.mPageContext, com.baidu.tieba.card.data.f.iaZ);
        this.jFf = new h(this.mPageContext, com.baidu.tieba.card.data.l.ibD);
        this.jFs = new ad(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.jvb = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.l.iby, (byte) 3);
        this.juB.add(this.jEP);
        this.juB.add(this.jEQ);
        this.juB.add(this.jER);
        this.juB.add(this.jES);
        this.juB.add(this.jET);
        this.juB.add(this.jEU);
        this.juB.add(this.jEV);
        this.juB.add(this.jEW);
        this.juB.add(this.jEX);
        this.juB.add(this.jEY);
        this.juB.add(this.jEZ);
        this.juB.add(this.jFa);
        this.juB.add(this.jFb);
        this.juB.add(this.jFc);
        this.juB.add(this.jFd);
        this.juB.add(this.jFe);
        this.juB.add(this.jFg);
        this.juB.add(this.jFn);
        this.juB.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.juB.add(this.jFh);
        this.juB.add(this.jFi);
        this.juB.add(this.jFj);
        this.juB.add(this.jFk);
        this.juB.add(this.jFm);
        this.juB.add(this.jFl);
        this.juB.add(new af(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.juB.add(this.jFo);
        this.juB.add(this.jFp);
        this.juB.add(this.jFq);
        this.juB.add(this.jFr);
        this.juB.add(this.jFf);
        this.juB.add(this.jFs);
        this.juB.add(this.jvb);
        cLl();
        cLk();
        EZ("page_recommend");
    }

    private void cLk() {
        if (!bw.eEm.get()) {
            AdvertAppInfo.eyM.set(false);
            return;
        }
        this.jFt = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyD);
        this.jFu = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyG);
        this.jFv = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyH);
        this.jFw = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyI);
        this.jFx = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyJ);
        this.jFy = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyL);
        this.jFz = com.baidu.tieba.recapp.r.dAo().c(this.mPageContext, AdvertAppInfo.eyK);
        this.juB.add(this.jFt);
        this.juB.add(this.jFu);
        this.juB.add(this.jFv);
        this.juB.add(this.jFw);
        this.juB.add(this.jFx);
        this.juB.add(this.jFy);
        this.juB.add(this.jFz);
        AdvertAppInfo.eyM.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jES.a(eVar);
        this.jET.a(eVar);
        this.jEU.a(eVar);
        this.jEW.a(eVar);
        this.jEX.a(eVar);
        this.jFb.a(eVar);
        this.jFc.a(eVar);
        this.jFd.a(eVar);
        this.jFe.a(eVar);
        this.jFf.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jET.a(vVar);
        this.jEU.a(vVar);
        this.jEV.a(vVar);
        this.jEW.a(vVar);
        this.jEX.a(vVar);
        this.jEY.a(vVar);
        this.jEZ.a(vVar);
        this.jFa.a(vVar);
        this.jFb.a(vVar);
        this.jFc.a(vVar);
        this.jFd.a(vVar);
        this.jFf.a(vVar);
        this.jFe.a(vVar);
        this.jFr.a(vVar);
        this.jFk.a(vVar);
        this.jFk.a(vVar);
        this.jFm.a(vVar);
        this.jvb.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.x(list, 2);
        ViewGroup listView = this.jEN.getListView();
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
        this.jEN.setData(list);
        this.jEO = list;
    }

    public void cr(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.x(list, 2);
        this.jEN.setData(list);
        this.jEO = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.jEP.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.jEN != null) {
            this.jEN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jES != null) {
            this.jES.setFromCDN(z);
            this.jFn.setFromCDN(z);
            this.jFg.setFromCDN(z);
            this.jFj.setFromCDN(z);
        }
        if (this.jEW != null) {
            this.jEW.setFromCDN(z);
        }
        if (this.jFf != null) {
            this.jFf.setFromCDN(z);
        }
        if (this.jFu != null && (this.jFu instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.jFu).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jER != null) {
            this.jER.setPageUniqueId(bdUniqueId);
        }
        if (this.jES != null) {
            this.jES.fsQ = bdUniqueId;
        }
        if (this.jET != null) {
            this.jET.fsQ = bdUniqueId;
        }
        if (this.jEU != null) {
            this.jEU.fsQ = bdUniqueId;
        }
        if (this.jEV != null) {
            this.jEV.fsQ = bdUniqueId;
        }
        if (this.jEW != null) {
            this.jEW.fsQ = bdUniqueId;
        }
        if (this.jEX != null) {
            this.jEX.fsQ = bdUniqueId;
        }
        if (this.jEY != null) {
            this.jEY.fsQ = bdUniqueId;
        }
        if (this.jEZ != null) {
            this.jEZ.fsQ = bdUniqueId;
        }
        if (this.jFa != null) {
            this.jFa.fsQ = bdUniqueId;
        }
        if (this.jFb != null) {
            this.jFb.fsQ = bdUniqueId;
        }
        if (this.jFc != null) {
            this.jFc.fsQ = bdUniqueId;
        }
        if (this.jFd != null) {
            this.jFd.fsQ = bdUniqueId;
        }
        if (this.jFg != null) {
            this.jFg.fsQ = bdUniqueId;
        }
        if (this.jFe != null) {
            this.jFe.fsQ = bdUniqueId;
        }
        if (this.jEP != null) {
            this.jEP.setPageUniqueId(bdUniqueId);
        }
        if (this.jFh != null) {
            this.jFh.fsQ = bdUniqueId;
        }
        if (this.jFi != null) {
            this.jFi.fsQ = bdUniqueId;
        }
        if (this.jFj != null) {
            this.jFj.fsQ = bdUniqueId;
        }
        if (this.jFk != null) {
            this.jFk.fsQ = bdUniqueId;
        }
        if (this.jFm != null) {
            this.jFm.fsQ = bdUniqueId;
        }
        if (this.jFl != null) {
            this.jFl.fsQ = bdUniqueId;
        }
        if (this.jFn != null) {
            this.jFn.fsQ = bdUniqueId;
        }
        if (this.jFo != null) {
            this.jFo.fsQ = bdUniqueId;
        }
        if (this.jFp != null) {
            this.jFp.fsQ = bdUniqueId;
        }
        if (this.jFq != null) {
            this.jFq.fsQ = bdUniqueId;
        }
        if (this.jFr != null) {
            this.jFr.fsQ = bdUniqueId;
        }
        if (this.jFf != null) {
            this.jFf.fsQ = bdUniqueId;
        }
        if (this.jFs != null) {
            this.jFs.fsQ = bdUniqueId;
        }
        if (this.jvb != null) {
            this.jvb.fsQ = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jbZ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jbZ) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.eNv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eNv);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hXT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hXT);
        if (!this.jFB) {
            this.jcb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jcb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.jEO != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.jEO.iterator();
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

    private void cLl() {
        this.jFB = cLm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLm() {
        if (this.jbZ == null || this.jbZ.size() <= 0) {
            this.jbZ = new ArrayList();
            ArrayList<BdUniqueId> dJq = com.baidu.tieba.tbadkCore.u.dJq();
            if (dJq == null || dJq.size() <= 0) {
                return false;
            }
            int size = dJq.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.das().a(this.mPageContext, dJq.get(i), 2);
                if (this.jFA) {
                    a2.setBusinessType(3);
                }
                if (this.jES != null && this.jES.fsQ != null) {
                    a2.setUniqueId(this.jES.fsQ);
                }
                this.jbZ.add(a2);
            }
            this.jEN.addAdapters(this.jbZ);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.juB) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jES != null) {
            this.jES.setEventCallback(aVar);
        }
        if (this.jEX != null) {
            this.jEX.setEventCallback(aVar);
        }
        if (this.jEV != null) {
            this.jEV.setEventCallback(aVar);
        }
        if (this.jFg != null) {
            this.jFg.setEventCallback(aVar);
        }
        if (this.jFh != null) {
            this.jFh.setEventCallback(aVar);
        }
        if (this.jFi != null) {
            this.jFi.setEventCallback(aVar);
        }
        if (this.jFj != null) {
            this.jFj.setEventCallback(aVar);
        }
        if (this.jFk != null) {
            this.jFk.setEventCallback(aVar);
        }
        if (this.jFm != null) {
            this.jFm.setEventCallback(aVar);
        }
        if (this.jFl != null) {
            this.jFl.setEventCallback(aVar);
        }
        if (this.jFn != null) {
            this.jFn.setEventCallback(aVar);
        }
        if (this.jFo != null) {
            this.jFo.setEventCallback(aVar);
        }
        if (this.jFp != null) {
            this.jFp.setEventCallback(aVar);
        }
        if (this.jFq != null) {
            this.jFq.setEventCallback(aVar);
        }
        if (this.jFr != null) {
            this.jFr.setEventCallback(aVar);
        }
        if (this.jFs != null) {
            this.jFs.setEventCallback(aVar);
        }
    }

    private void EZ(String str) {
        if (this.juB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.juB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EZ(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).iaY) != null && advertAppInfo.bkr() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Ld(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.m mVar;
        int i3 = 0;
        if (this.jEO == null || this.jEO.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.jEO.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.jEO.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.jEO.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.jEO.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.jEO.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.jEO.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.jEO.get(i4) instanceof com.baidu.tieba.card.data.m) && (mVar = (com.baidu.tieba.card.data.m) this.jEO.get(i4)) != null && mVar.exA != null && str.equals(mVar.exA.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.m) this.jEO.get(i4)).position;
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
        if (this.jFe != null) {
            this.jFe.onPause();
        }
    }

    public void onResume() {
        if (this.jFe != null) {
            this.jFe.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.jEO;
    }
}
