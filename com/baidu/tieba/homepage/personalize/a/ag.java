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
    private List<com.baidu.adp.widget.ListView.a> iWc;
    private com.baidu.tieba.homepage.concern.adapter.z jpe;
    private com.baidu.adp.widget.ListView.v jyQ;
    private List<com.baidu.adp.widget.ListView.q> jyR;
    private b jyS;
    private ae jyT;
    private e jyU;
    private r jyV;
    private ab jyW;
    private l jyX;
    private m jyY;
    private n jyZ;
    private com.baidu.adp.widget.ListView.a jzA;
    private com.baidu.adp.widget.ListView.a jzB;
    private com.baidu.adp.widget.ListView.a jzC;
    private boolean jzD;
    private boolean jzE;
    private v jza;
    private o jzb;
    private s jzc;
    private q jzd;
    private k jze;
    private j jzf;
    private i jzg;
    private ac jzh;
    private h jzi;
    private p jzj;
    private d jzk;
    private c jzl;
    private z jzm;
    private y jzn;
    private aa jzo;
    private x jzp;
    private r jzq;
    private t jzr;
    private u jzs;
    private w jzt;
    private f jzu;
    private ad jzv;
    private com.baidu.adp.widget.ListView.a jzw;
    private com.baidu.adp.widget.ListView.a jzx;
    private com.baidu.adp.widget.ListView.a jzy;
    private com.baidu.adp.widget.ListView.a jzz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener iWe = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ag.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ag.this.cIL();
                if (ag.this.jyR != null) {
                    ag.this.ck(ag.this.jyR);
                }
            }
        }
    };
    private CustomMessageListener eHG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ag.2
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
                bVar.exi = true;
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
                bVar.exi = false;
                ag.this.aK(bVar);
            }
        }
    };
    private CustomMessageListener hRW = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ag.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b KM;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (KM = ag.this.KM(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, KM));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> joE = new ArrayList();

    public ag(Context context, com.baidu.adp.widget.ListView.v vVar) {
        this.jyQ = vVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.I(context);
        fp(context);
        a(vVar);
        vVar.addAdapters(this.joE);
    }

    private void fp(Context context) {
        this.jyS = new b(this.mPageContext);
        this.jyT = new ae(this.mPageContext);
        this.jyU = new e(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.jAe);
        this.jyV = new r(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.jyW = new ab(this.mPageContext, com.baidu.tieba.card.data.l.hVC);
        this.jyX = new l(this.mPageContext, com.baidu.tieba.card.data.l.hVI);
        this.jyY = new m(this.mPageContext, com.baidu.tieba.card.data.l.exN);
        this.jyZ = new n(this.mPageContext, com.baidu.tieba.card.data.l.hVJ);
        this.jza = new v(this.mPageContext, com.baidu.tieba.card.data.l.hVH);
        this.jzb = new o(this.mPageContext, com.baidu.tieba.card.data.l.exZ);
        this.jzc = new s(this.mPageContext, com.baidu.tieba.card.data.l.eyb);
        this.jzd = new q(this.mPageContext, com.baidu.tieba.card.data.l.eyc);
        this.jze = new k(this.mPageContext, com.baidu.tieba.card.data.l.hVD);
        this.jzf = new j(this.mPageContext, com.baidu.tieba.card.data.l.hVE);
        this.jzg = new i(this.mPageContext, com.baidu.tieba.card.data.l.hVF);
        this.jzh = new ac(this.mPageContext, com.baidu.tieba.card.data.m.eyg);
        this.jzj = new p(this.mPageContext, com.baidu.tieba.card.data.l.eyd);
        this.jzk = new d(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.jzl = new c(this.mPageContext, com.baidu.tieba.card.data.k.hVh);
        this.jzm = new z(this.mPageContext, com.baidu.tieba.card.data.l.eyl);
        this.jzn = new y(this.mPageContext, com.baidu.tieba.card.data.l.eyn);
        this.jzo = new aa(this.mPageContext, com.baidu.tieba.card.data.l.eyp);
        this.jzp = new x(this.mPageContext, com.baidu.tieba.card.data.l.eyo);
        this.jzq = new r(this.mPageContext, com.baidu.tieba.card.data.l.hVA);
        this.jzr = new t(this.mPageContext, com.baidu.tieba.card.data.l.eyt);
        this.jzs = new u(this.mPageContext, com.baidu.tieba.card.data.l.eyu);
        this.jzt = new w(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.jEP);
        this.jzu = new f(this.mPageContext, com.baidu.tieba.card.data.f.hVc);
        this.jzi = new h(this.mPageContext, com.baidu.tieba.card.data.l.hVG);
        this.jzv = new ad(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE);
        this.jpe = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.l.hVB, (byte) 3);
        this.joE.add(this.jyS);
        this.joE.add(this.jyT);
        this.joE.add(this.jyU);
        this.joE.add(this.jyV);
        this.joE.add(this.jyW);
        this.joE.add(this.jyX);
        this.joE.add(this.jyY);
        this.joE.add(this.jyZ);
        this.joE.add(this.jza);
        this.joE.add(this.jzb);
        this.joE.add(this.jzc);
        this.joE.add(this.jzd);
        this.joE.add(this.jze);
        this.joE.add(this.jzf);
        this.joE.add(this.jzg);
        this.joE.add(this.jzh);
        this.joE.add(this.jzj);
        this.joE.add(this.jzq);
        this.joE.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.joE.add(this.jzk);
        this.joE.add(this.jzl);
        this.joE.add(this.jzm);
        this.joE.add(this.jzn);
        this.joE.add(this.jzp);
        this.joE.add(this.jzo);
        this.joE.add(new af(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.joE.add(this.jzr);
        this.joE.add(this.jzs);
        this.joE.add(this.jzt);
        this.joE.add(this.jzu);
        this.joE.add(this.jzi);
        this.joE.add(this.jzv);
        this.joE.add(this.jpe);
        cIK();
        cIJ();
        EL("page_recommend");
    }

    private void cIJ() {
        if (!bw.eyx.get()) {
            AdvertAppInfo.esS.set(false);
            return;
        }
        this.jzw = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esJ);
        this.jzx = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esM);
        this.jzy = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esN);
        this.jzz = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esO);
        this.jzA = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esP);
        this.jzB = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esR);
        this.jzC = com.baidu.tieba.recapp.r.dxM().c(this.mPageContext, AdvertAppInfo.esQ);
        this.joE.add(this.jzw);
        this.joE.add(this.jzx);
        this.joE.add(this.jzy);
        this.joE.add(this.jzz);
        this.joE.add(this.jzA);
        this.joE.add(this.jzB);
        this.joE.add(this.jzC);
        AdvertAppInfo.esS.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jyV.a(eVar);
        this.jyW.a(eVar);
        this.jyX.a(eVar);
        this.jyZ.a(eVar);
        this.jza.a(eVar);
        this.jze.a(eVar);
        this.jzf.a(eVar);
        this.jzg.a(eVar);
        this.jzh.a(eVar);
        this.jzi.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.v vVar) {
        this.jyW.a(vVar);
        this.jyX.a(vVar);
        this.jyY.a(vVar);
        this.jyZ.a(vVar);
        this.jza.a(vVar);
        this.jzb.a(vVar);
        this.jzc.a(vVar);
        this.jzd.a(vVar);
        this.jze.a(vVar);
        this.jzf.a(vVar);
        this.jzg.a(vVar);
        this.jzi.a(vVar);
        this.jzh.a(vVar);
        this.jzu.a(vVar);
        this.jzn.a(vVar);
        this.jzn.a(vVar);
        this.jzp.a(vVar);
        this.jpe.a(vVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.q> list, int i) {
        com.baidu.tieba.tbadkCore.u.x(list, 2);
        ViewGroup listView = this.jyQ.getListView();
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
        this.jyQ.setData(list);
        this.jyR = list;
    }

    public void ck(List<com.baidu.adp.widget.ListView.q> list) {
        com.baidu.tieba.tbadkCore.u.x(list, 2);
        this.jyQ.setData(list);
        this.jyR = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.jyS.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.jyQ != null) {
            this.jyQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.jyV != null) {
            this.jyV.setFromCDN(z);
            this.jzq.setFromCDN(z);
            this.jzj.setFromCDN(z);
            this.jzm.setFromCDN(z);
        }
        if (this.jyZ != null) {
            this.jyZ.setFromCDN(z);
        }
        if (this.jzi != null) {
            this.jzi.setFromCDN(z);
        }
        if (this.jzx != null && (this.jzx instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.jzx).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jyU != null) {
            this.jyU.setPageUniqueId(bdUniqueId);
        }
        if (this.jyV != null) {
            this.jyV.fmX = bdUniqueId;
        }
        if (this.jyW != null) {
            this.jyW.fmX = bdUniqueId;
        }
        if (this.jyX != null) {
            this.jyX.fmX = bdUniqueId;
        }
        if (this.jyY != null) {
            this.jyY.fmX = bdUniqueId;
        }
        if (this.jyZ != null) {
            this.jyZ.fmX = bdUniqueId;
        }
        if (this.jza != null) {
            this.jza.fmX = bdUniqueId;
        }
        if (this.jzb != null) {
            this.jzb.fmX = bdUniqueId;
        }
        if (this.jzc != null) {
            this.jzc.fmX = bdUniqueId;
        }
        if (this.jzd != null) {
            this.jzd.fmX = bdUniqueId;
        }
        if (this.jze != null) {
            this.jze.fmX = bdUniqueId;
        }
        if (this.jzf != null) {
            this.jzf.fmX = bdUniqueId;
        }
        if (this.jzg != null) {
            this.jzg.fmX = bdUniqueId;
        }
        if (this.jzj != null) {
            this.jzj.fmX = bdUniqueId;
        }
        if (this.jzh != null) {
            this.jzh.fmX = bdUniqueId;
        }
        if (this.jyS != null) {
            this.jyS.setPageUniqueId(bdUniqueId);
        }
        if (this.jzk != null) {
            this.jzk.fmX = bdUniqueId;
        }
        if (this.jzl != null) {
            this.jzl.fmX = bdUniqueId;
        }
        if (this.jzm != null) {
            this.jzm.fmX = bdUniqueId;
        }
        if (this.jzn != null) {
            this.jzn.fmX = bdUniqueId;
        }
        if (this.jzp != null) {
            this.jzp.fmX = bdUniqueId;
        }
        if (this.jzo != null) {
            this.jzo.fmX = bdUniqueId;
        }
        if (this.jzq != null) {
            this.jzq.fmX = bdUniqueId;
        }
        if (this.jzr != null) {
            this.jzr.fmX = bdUniqueId;
        }
        if (this.jzs != null) {
            this.jzs.fmX = bdUniqueId;
        }
        if (this.jzt != null) {
            this.jzt.fmX = bdUniqueId;
        }
        if (this.jzu != null) {
            this.jzu.fmX = bdUniqueId;
        }
        if (this.jzi != null) {
            this.jzi.fmX = bdUniqueId;
        }
        if (this.jzv != null) {
            this.jzv.fmX = bdUniqueId;
        }
        if (this.jpe != null) {
            this.jpe.fmX = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iWc)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.iWc) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.eHG.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eHG);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.hRW.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hRW);
        if (!this.jzE) {
            this.iWe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iWe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.jyR != null) {
            Iterator<com.baidu.adp.widget.ListView.q> it = this.jyR.iterator();
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

    private void cIK() {
        this.jzE = cIL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cIL() {
        if (this.iWc == null || this.iWc.size() <= 0) {
            this.iWc = new ArrayList();
            ArrayList<BdUniqueId> dGO = com.baidu.tieba.tbadkCore.u.dGO();
            if (dGO == null || dGO.size() <= 0) {
                return false;
            }
            int size = dGO.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.cXR().a(this.mPageContext, dGO.get(i), 2);
                if (this.jzD) {
                    a2.setBusinessType(3);
                }
                if (this.jyV != null && this.jyV.fmX != null) {
                    a2.setUniqueId(this.jyV.fmX);
                }
                this.iWc.add(a2);
            }
            this.jyQ.addAdapters(this.iWc);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.joE) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jyV != null) {
            this.jyV.setEventCallback(aVar);
        }
        if (this.jza != null) {
            this.jza.setEventCallback(aVar);
        }
        if (this.jyY != null) {
            this.jyY.setEventCallback(aVar);
        }
        if (this.jzj != null) {
            this.jzj.setEventCallback(aVar);
        }
        if (this.jzk != null) {
            this.jzk.setEventCallback(aVar);
        }
        if (this.jzl != null) {
            this.jzl.setEventCallback(aVar);
        }
        if (this.jzm != null) {
            this.jzm.setEventCallback(aVar);
        }
        if (this.jzn != null) {
            this.jzn.setEventCallback(aVar);
        }
        if (this.jzp != null) {
            this.jzp.setEventCallback(aVar);
        }
        if (this.jzo != null) {
            this.jzo.setEventCallback(aVar);
        }
        if (this.jzq != null) {
            this.jzq.setEventCallback(aVar);
        }
        if (this.jzr != null) {
            this.jzr.setEventCallback(aVar);
        }
        if (this.jzs != null) {
            this.jzs.setEventCallback(aVar);
        }
        if (this.jzt != null) {
            this.jzt.setEventCallback(aVar);
        }
        if (this.jzu != null) {
            this.jzu.setEventCallback(aVar);
        }
        if (this.jzv != null) {
            this.jzv.setEventCallback(aVar);
        }
    }

    private void EL(String str) {
        if (this.joE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.joE) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EL(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.q qVar) {
        AdvertAppInfo advertAppInfo;
        return qVar != null && (qVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) qVar).hVb) != null && advertAppInfo.bhR() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b KM(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.m mVar;
        int i3 = 0;
        if (this.jyR == null || this.jyR.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.jyR.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.jyR.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.h ? i3 + 1 : i3;
            if (this.jyR.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.jyR.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.jyR.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.jyR.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.jyR.get(i4) instanceof com.baidu.tieba.card.data.m) && (mVar = (com.baidu.tieba.card.data.m) this.jyR.get(i4)) != null && mVar.erH != null && str.equals(mVar.erH.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.m) this.jyR.get(i4)).position;
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
        if (this.jzh != null) {
            this.jzh.onPause();
        }
    }

    public void onResume() {
        if (this.jzh != null) {
            this.jzh.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.jyR;
    }
}
