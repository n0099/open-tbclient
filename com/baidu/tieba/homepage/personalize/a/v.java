package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class v {
    private r fMA;
    private j fMB;
    private s fMC;
    private l fMD;
    private b fME;
    private p fMF;
    private k fMG;
    private s fMH;
    private i fMI;
    private m fMJ;
    private n fMK;
    private com.baidu.adp.widget.ListView.a fML;
    private com.baidu.adp.widget.ListView.a fMM;
    private com.baidu.adp.widget.ListView.a fMN;
    private com.baidu.adp.widget.ListView.a fMO;
    private com.baidu.adp.widget.ListView.a fMP;
    private com.baidu.adp.widget.ListView.a fMQ;
    private com.baidu.adp.widget.ListView.a fMR;
    private boolean fMS;
    private boolean fMT;
    private com.baidu.adp.widget.ListView.r fMo;
    private List<com.baidu.adp.widget.ListView.m> fMp;
    private a fMq;
    private t fMr;
    private k fMs;
    private q fMt;
    private g fMu;
    private h fMv;
    private o fMw;
    private f fMx;
    private e fMy;
    private d fMz;
    private List<com.baidu.adp.widget.ListView.a> fqa;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fqb = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.v.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                v.this.bmP();
                if (v.this.fMp != null) {
                    v.this.ay(v.this.fMp);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.v.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy) {
                v.this.av(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.v.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bAw = true;
                v.this.av(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.v.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bAw = false;
                v.this.av(bVar);
            }
        }
    };
    private CustomMessageListener eic = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.v.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b vR;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (vR = v.this.vR(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, vR));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> fFN = new ArrayList();

    public v(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.fMo = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        dO(context);
        b(rVar);
        rVar.addAdapters(this.fFN);
    }

    private void dO(Context context) {
        this.fMq = new a(this.mPageContext);
        this.fMr = new t(this.mPageContext);
        this.fMs = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.fMt = new q(this.mPageContext, com.baidu.tieba.card.data.k.elz);
        this.fMu = new g(this.mPageContext, com.baidu.tieba.card.data.k.elE);
        this.fMv = new h(this.mPageContext, com.baidu.tieba.card.data.k.elF);
        this.fMw = new o(this.mPageContext, com.baidu.tieba.card.data.k.elG);
        this.fMx = new f(this.mPageContext, com.baidu.tieba.card.data.k.elA);
        this.fMy = new e(this.mPageContext, com.baidu.tieba.card.data.k.elC);
        this.fMz = new d(this.mPageContext, com.baidu.tieba.card.data.k.elD);
        this.fMA = new r(this.mPageContext, com.baidu.tieba.card.data.l.bBb);
        this.fMB = new j(this.mPageContext, com.baidu.tieba.card.data.k.bAZ);
        this.fMC = new s(this.mPageContext, com.baidu.tieba.card.data.l.elN);
        this.fMD = new l(this.mPageContext);
        this.fME = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.fMF = new p(this.mPageContext, com.baidu.tieba.card.data.k.bBf);
        this.fMG = new k(this.mPageContext, com.baidu.tieba.card.data.k.elx);
        this.fMH = new s(this.mPageContext, com.baidu.tieba.card.data.l.elO);
        this.fMI = new i(this.mPageContext, com.baidu.tieba.card.data.k.ely);
        this.fMJ = new m(this.mPageContext, com.baidu.tieba.card.data.k.bBj);
        this.fMK = new n(this.mPageContext, com.baidu.tieba.card.data.k.bBk);
        this.fFN.add(this.fMq);
        this.fFN.add(this.fMr);
        this.fFN.add(this.fMC);
        this.fFN.add(this.fMs);
        this.fFN.add(this.fMt);
        this.fFN.add(this.fMu);
        this.fFN.add(this.fMv);
        this.fFN.add(this.fMw);
        this.fFN.add(this.fMx);
        this.fFN.add(this.fMy);
        this.fFN.add(this.fMz);
        this.fFN.add(this.fMA);
        this.fFN.add(this.fMB);
        this.fFN.add(this.fMD);
        this.fFN.add(this.fMG);
        this.fFN.add(this.fMH);
        this.fFN.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.fFN.add(this.fME);
        this.fFN.add(this.fMF);
        this.fFN.add(new u(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.fFN.add(this.fMI);
        this.fFN.add(this.fMJ);
        this.fFN.add(this.fMK);
        bmO();
        bmN();
        qN("page_recommend");
    }

    private void bmN() {
        if (!bg.bBm.get()) {
            AdvertAppInfo.bwz.set(false);
            return;
        }
        this.fML = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bwq);
        this.fMM = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bwt);
        this.fMN = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bwu);
        this.fMO = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bwv);
        this.fMP = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bww);
        this.fMQ = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bwx);
        this.fMR = com.baidu.tieba.recapp.r.bWH().c(this.mPageContext, AdvertAppInfo.bwy);
        this.fFN.add(this.fML);
        this.fFN.add(this.fMM);
        this.fFN.add(this.fMN);
        this.fFN.add(this.fMO);
        this.fFN.add(this.fMP);
        this.fFN.add(this.fMQ);
        this.fFN.add(this.fMR);
        AdvertAppInfo.bwz.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fMs.a(eVar);
        this.fMt.a(eVar);
        this.fMu.a(eVar);
        this.fMv.a(eVar);
        this.fMw.a(eVar);
        this.fMx.a(eVar);
        this.fMy.a(eVar);
        this.fMz.a(eVar);
        this.fMA.a(eVar);
        this.fMC.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.fMt.b(rVar);
        this.fMu.b(rVar);
        this.fMv.b(rVar);
        this.fMw.b(rVar);
        this.fMx.b(rVar);
        this.fMy.b(rVar);
        this.fMz.b(rVar);
        this.fMA.b(rVar);
    }

    public void ay(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.fMo.setData(list);
        this.fMp = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.fMq.onChangeSkinType(i);
        this.fMD.sE(i);
    }

    public void notifyDataSetChanged() {
        if (this.fMo != null) {
            this.fMo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.fMs != null) {
            this.fMs.setFromCDN(z);
            this.fMG.setFromCDN(z);
            this.fMC.setFromCDN(z);
            this.fMH.setFromCDN(z);
            this.fMB.setFromCDN(z);
            this.fMF.setFromCDN(z);
        }
        if (this.fMv != null) {
            this.fMv.setFromCDN(z);
        }
        if (this.fMM != null && (this.fMM instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.fMM).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fMs != null) {
            this.fMs.cnX = bdUniqueId;
        }
        if (this.fMt != null) {
            this.fMt.cnX = bdUniqueId;
        }
        if (this.fMu != null) {
            this.fMu.cnX = bdUniqueId;
        }
        if (this.fMv != null) {
            this.fMv.cnX = bdUniqueId;
        }
        if (this.fMw != null) {
            this.fMw.cnX = bdUniqueId;
        }
        if (this.fMx != null) {
            this.fMx.cnX = bdUniqueId;
        }
        if (this.fMy != null) {
            this.fMy.cnX = bdUniqueId;
        }
        if (this.fMz != null) {
            this.fMz.cnX = bdUniqueId;
        }
        if (this.fMB != null) {
            this.fMB.cnX = bdUniqueId;
        }
        if (this.fMC != null) {
            this.fMC.cnX = bdUniqueId;
        }
        if (this.fMA != null) {
            this.fMA.cnX = bdUniqueId;
        }
        if (this.fMq != null) {
            this.fMq.setPageUniqueId(bdUniqueId);
        }
        if (this.fMD != null) {
            this.fMD.cnX = bdUniqueId;
        }
        if (this.fME != null) {
            this.fME.cnX = bdUniqueId;
        }
        if (this.fMF != null) {
            this.fMF.cnX = bdUniqueId;
        }
        if (this.fMG != null) {
            this.fMG.cnX = bdUniqueId;
        }
        if (this.fMH != null) {
            this.fMH.cnX = bdUniqueId;
        }
        if (this.fMJ != null) {
            this.fMJ.cnX = bdUniqueId;
        }
        if (this.fMK != null) {
            this.fMK.cnX = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fqa)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fqa) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.mAttentionListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.eic.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eic);
        if (!this.fMT) {
            this.fqb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fqb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.fMp != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fMp.iterator();
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

    private void bmO() {
        this.fMT = bmP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmP() {
        if (this.fqa == null || this.fqa.size() <= 0) {
            this.fqa = new ArrayList();
            ArrayList<BdUniqueId> cdE = com.baidu.tieba.tbadkCore.q.cdE();
            if (cdE == null || cdE.size() <= 0) {
                return false;
            }
            int size = cdE.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bBm().a(this.mPageContext, cdE.get(i), 2);
                if (this.fMS) {
                    a.setBusinessType(3);
                }
                if (this.fMs != null && this.fMs.cnX != null) {
                    a.setUniqueId(this.fMs.cnX);
                }
                this.fqa.add(a);
            }
            this.fMo.addAdapters(this.fqa);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fMs != null) {
            this.fMs.setEventCallback(aVar);
        }
        if (this.fMt != null) {
            this.fMt.setEventCallback(aVar);
        }
        if (this.fMB != null) {
            this.fMB.setEventCallback(aVar);
        }
        if (this.fMC != null) {
            this.fMC.setEventCallback(aVar);
        }
        if (this.fME != null) {
            this.fME.setEventCallback(aVar);
        }
        if (this.fMF != null) {
            this.fMF.setEventCallback(aVar);
        }
        if (this.fMG != null) {
            this.fMG.setEventCallback(aVar);
        }
        if (this.fMH != null) {
            this.fMH.setEventCallback(aVar);
        }
        if (this.fMJ != null) {
            this.fMJ.setEventCallback(aVar);
        }
        if (this.fMK != null) {
            this.fMK.setEventCallback(aVar);
        }
    }

    private void qN(String str) {
        if (this.fFN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fFN) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qN(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eld) != null && advertAppInfo.Xa() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b vR(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.fMp == null || this.fMp.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.fMp.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.fMp.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.fMp.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.fMp.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.fMp.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.fMp.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.fMp.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.fMp.get(i4)) != null && lVar.cZD != null && str.equals(lVar.cZD.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.fMp.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.bm(i6 - i >= -1 ? i6 - i : -1);
        bVar.bn(i7);
        bVar.bo(i2);
        return bVar;
    }

    public void onPause() {
        if (this.fMC != null) {
            this.fMC.onPause();
        }
        if (this.fMH != null) {
            this.fMH.onPause();
        }
        if (this.fMA != null) {
            this.fMA.onPause();
        }
    }

    public void onResume() {
        if (this.fMC != null) {
            this.fMC.onResume();
        }
        if (this.fMH != null) {
            this.fMH.onResume();
        }
        if (this.fMA != null) {
            this.fMA.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fMC != null) {
            this.fMC.onDestroy();
        }
    }
}
