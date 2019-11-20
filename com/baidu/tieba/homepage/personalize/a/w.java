package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class w {
    private List<com.baidu.adp.widget.ListView.a> fMm;
    private com.baidu.adp.widget.ListView.r gkM;
    private List<com.baidu.adp.widget.ListView.m> gkN;
    private a gkO;
    private u gkP;
    private k gkQ;
    private r gkR;
    private g gkS;
    private h gkT;
    private o gkU;
    private f gkV;
    private e gkW;
    private d gkX;
    private s gkY;
    private j gkZ;
    private t gla;
    private l glb;
    private b glc;
    private q gld;
    private k gle;
    private t glf;
    private i glg;
    private m glh;
    private n gli;
    private p glj;
    private com.baidu.adp.widget.ListView.a glk;
    private com.baidu.adp.widget.ListView.a gll;
    private com.baidu.adp.widget.ListView.a glm;
    private com.baidu.adp.widget.ListView.a gln;
    private com.baidu.adp.widget.ListView.a glo;
    private com.baidu.adp.widget.ListView.a glp;
    private com.baidu.adp.widget.ListView.a glq;
    private boolean glr;
    private boolean gls;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fMo = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.buZ();
                if (w.this.gkN != null) {
                    w.this.aY(w.this.gkN);
                }
            }
        }
    };
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.w.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                w.this.ao(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.w.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cai = true;
                w.this.ao(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.w.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cai = false;
                w.this.ao(bVar);
            }
        }
    };
    private CustomMessageListener eMd = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b wC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (wC = w.this.wC(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, wC));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gcK = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gkM = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dt(context);
        b(rVar);
        rVar.addAdapters(this.gcK);
    }

    private void dt(Context context) {
        this.gkO = new a(this.mPageContext);
        this.gkP = new u(this.mPageContext);
        this.gkQ = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gkR = new r(this.mPageContext, com.baidu.tieba.card.data.k.ePy);
        this.gkS = new g(this.mPageContext, com.baidu.tieba.card.data.k.ePD);
        this.gkT = new h(this.mPageContext, com.baidu.tieba.card.data.k.ePE);
        this.gkU = new o(this.mPageContext, com.baidu.tieba.card.data.k.ePF);
        this.gkV = new f(this.mPageContext, com.baidu.tieba.card.data.k.ePz);
        this.gkW = new e(this.mPageContext, com.baidu.tieba.card.data.k.ePB);
        this.gkX = new d(this.mPageContext, com.baidu.tieba.card.data.k.ePC);
        this.gkY = new s(this.mPageContext, com.baidu.tieba.card.data.l.caR);
        this.gkZ = new j(this.mPageContext, com.baidu.tieba.card.data.k.caP);
        this.gla = new t(this.mPageContext, com.baidu.tieba.card.data.l.ePL);
        this.glb = new l(this.mPageContext);
        this.glc = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gld = new q(this.mPageContext, com.baidu.tieba.card.data.k.caV);
        this.gle = new k(this.mPageContext, com.baidu.tieba.card.data.k.ePw);
        this.glf = new t(this.mPageContext, com.baidu.tieba.card.data.l.ePM);
        this.glg = new i(this.mPageContext, com.baidu.tieba.card.data.k.ePx);
        this.glh = new m(this.mPageContext, com.baidu.tieba.card.data.k.caZ);
        this.gli = new n(this.mPageContext, com.baidu.tieba.card.data.k.cba);
        this.glj = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.gor);
        this.gcK.add(this.gkO);
        this.gcK.add(this.gkP);
        this.gcK.add(this.gla);
        this.gcK.add(this.gkQ);
        this.gcK.add(this.gkR);
        this.gcK.add(this.gkS);
        this.gcK.add(this.gkT);
        this.gcK.add(this.gkU);
        this.gcK.add(this.gkV);
        this.gcK.add(this.gkW);
        this.gcK.add(this.gkX);
        this.gcK.add(this.gkY);
        this.gcK.add(this.gkZ);
        this.gcK.add(this.glb);
        this.gcK.add(this.gle);
        this.gcK.add(this.glf);
        this.gcK.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gcK.add(this.glc);
        this.gcK.add(this.gld);
        this.gcK.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.gcK.add(this.glg);
        this.gcK.add(this.glh);
        this.gcK.add(this.gli);
        this.gcK.add(this.glj);
        buY();
        buX();
        rh("page_recommend");
    }

    private void buX() {
        if (!bh.cbd.get()) {
            AdvertAppInfo.bWr.set(false);
            return;
        }
        this.glk = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWi);
        this.gll = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWl);
        this.glm = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWm);
        this.gln = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWn);
        this.glo = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWo);
        this.glp = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWp);
        this.glq = com.baidu.tieba.recapp.r.cfJ().c(this.mPageContext, AdvertAppInfo.bWq);
        this.gcK.add(this.glk);
        this.gcK.add(this.gll);
        this.gcK.add(this.glm);
        this.gcK.add(this.gln);
        this.gcK.add(this.glo);
        this.gcK.add(this.glp);
        this.gcK.add(this.glq);
        AdvertAppInfo.bWr.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gkQ.a(eVar);
        this.gkR.a(eVar);
        this.gkS.a(eVar);
        this.gkT.a(eVar);
        this.gkU.a(eVar);
        this.gkV.a(eVar);
        this.gkW.a(eVar);
        this.gkX.a(eVar);
        this.gkY.a(eVar);
        this.gla.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gkR.b(rVar);
        this.gkS.b(rVar);
        this.gkT.b(rVar);
        this.gkU.b(rVar);
        this.gkV.b(rVar);
        this.gkW.b(rVar);
        this.gkX.b(rVar);
        this.gkY.b(rVar);
    }

    public void aY(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.n(list, 2);
        this.gkM.setData(list);
        this.gkN = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gkO.onChangeSkinType(i);
        this.glb.tf(i);
    }

    public void notifyDataSetChanged() {
        if (this.gkM != null) {
            this.gkM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gkQ != null) {
            this.gkQ.setFromCDN(z);
            this.gle.setFromCDN(z);
            this.gla.setFromCDN(z);
            this.glf.setFromCDN(z);
            this.gkZ.setFromCDN(z);
            this.gld.setFromCDN(z);
        }
        if (this.gkT != null) {
            this.gkT.setFromCDN(z);
        }
        if (this.gll != null && (this.gll instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gll).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gkQ != null) {
            this.gkQ.cJo = bdUniqueId;
        }
        if (this.gkR != null) {
            this.gkR.cJo = bdUniqueId;
        }
        if (this.gkS != null) {
            this.gkS.cJo = bdUniqueId;
        }
        if (this.gkT != null) {
            this.gkT.cJo = bdUniqueId;
        }
        if (this.gkU != null) {
            this.gkU.cJo = bdUniqueId;
        }
        if (this.gkV != null) {
            this.gkV.cJo = bdUniqueId;
        }
        if (this.gkW != null) {
            this.gkW.cJo = bdUniqueId;
        }
        if (this.gkX != null) {
            this.gkX.cJo = bdUniqueId;
        }
        if (this.gkZ != null) {
            this.gkZ.cJo = bdUniqueId;
        }
        if (this.gla != null) {
            this.gla.cJo = bdUniqueId;
        }
        if (this.gkY != null) {
            this.gkY.cJo = bdUniqueId;
        }
        if (this.gkO != null) {
            this.gkO.setPageUniqueId(bdUniqueId);
        }
        if (this.glb != null) {
            this.glb.cJo = bdUniqueId;
        }
        if (this.glc != null) {
            this.glc.cJo = bdUniqueId;
        }
        if (this.gld != null) {
            this.gld.cJo = bdUniqueId;
        }
        if (this.gle != null) {
            this.gle.cJo = bdUniqueId;
        }
        if (this.glf != null) {
            this.glf.cJo = bdUniqueId;
        }
        if (this.glh != null) {
            this.glh.cJo = bdUniqueId;
        }
        if (this.gli != null) {
            this.gli.cJo = bdUniqueId;
        }
        if (this.glj != null) {
            this.glj.cJo = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fMm)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fMm) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.cji.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cji);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.eMd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eMd);
        if (!this.gls) {
            this.fMo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fMo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gkN != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gkN.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
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

    private void buY() {
        this.gls = buZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buZ() {
        if (this.fMm == null || this.fMm.size() <= 0) {
            this.fMm = new ArrayList();
            ArrayList<BdUniqueId> cnB = com.baidu.tieba.tbadkCore.s.cnB();
            if (cnB == null || cnB.size() <= 0) {
                return false;
            }
            int size = cnB.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bJl().a(this.mPageContext, cnB.get(i), 2);
                if (this.glr) {
                    a.setBusinessType(3);
                }
                if (this.gkQ != null && this.gkQ.cJo != null) {
                    a.setUniqueId(this.gkQ.cJo);
                }
                this.fMm.add(a);
            }
            this.gkM.addAdapters(this.fMm);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gkQ != null) {
            this.gkQ.setEventCallback(aVar);
        }
        if (this.gkR != null) {
            this.gkR.setEventCallback(aVar);
        }
        if (this.gkZ != null) {
            this.gkZ.setEventCallback(aVar);
        }
        if (this.gla != null) {
            this.gla.setEventCallback(aVar);
        }
        if (this.glc != null) {
            this.glc.setEventCallback(aVar);
        }
        if (this.gld != null) {
            this.gld.setEventCallback(aVar);
        }
        if (this.gle != null) {
            this.gle.setEventCallback(aVar);
        }
        if (this.glf != null) {
            this.glf.setEventCallback(aVar);
        }
        if (this.glh != null) {
            this.glh.setEventCallback(aVar);
        }
        if (this.gli != null) {
            this.gli.setEventCallback(aVar);
        }
        if (this.glj != null) {
            this.glj.setEventCallback(aVar);
        }
    }

    private void rh(String str) {
        if (this.gcK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gcK) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).ePb) != null && advertAppInfo.agP() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b wC(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gkN == null || this.gkN.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gkN.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gkN.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gkN.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.gkN.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gkN.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gkN.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gkN.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gkN.get(i4)) != null && lVar.caz != null && str.equals(lVar.caz.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gkN.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.at(i6 - i >= -1 ? i6 - i : -1);
        bVar.au(i7);
        bVar.av(i2);
        return bVar;
    }

    public void onPause() {
        if (this.gla != null) {
            this.gla.onPause();
        }
        if (this.glf != null) {
            this.glf.onPause();
        }
        if (this.gkY != null) {
            this.gkY.onPause();
        }
    }

    public void onResume() {
        if (this.gla != null) {
            this.gla.onResume();
        }
        if (this.glf != null) {
            this.glf.onResume();
        }
        if (this.gkY != null) {
            this.gkY.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gla != null) {
            this.gla.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gkN;
    }
}
