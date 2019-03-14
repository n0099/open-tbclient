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
    private j fMA;
    private s fMB;
    private l fMC;
    private b fMD;
    private p fME;
    private k fMF;
    private s fMG;
    private i fMH;
    private m fMI;
    private n fMJ;
    private com.baidu.adp.widget.ListView.a fMK;
    private com.baidu.adp.widget.ListView.a fML;
    private com.baidu.adp.widget.ListView.a fMM;
    private com.baidu.adp.widget.ListView.a fMN;
    private com.baidu.adp.widget.ListView.a fMO;
    private com.baidu.adp.widget.ListView.a fMP;
    private com.baidu.adp.widget.ListView.a fMQ;
    private boolean fMR;
    private boolean fMS;
    private com.baidu.adp.widget.ListView.r fMn;
    private List<com.baidu.adp.widget.ListView.m> fMo;
    private a fMp;
    private t fMq;
    private k fMr;
    private q fMs;
    private g fMt;
    private h fMu;
    private o fMv;
    private f fMw;
    private e fMx;
    private d fMy;
    private r fMz;
    private List<com.baidu.adp.widget.ListView.a> fpZ;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fqa = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.v.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                v.this.bmO();
                if (v.this.fMo != null) {
                    v.this.ay(v.this.fMo);
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
                bVar.bAy = true;
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
                bVar.bAy = false;
                v.this.av(bVar);
            }
        }
    };
    private CustomMessageListener ehY = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.v.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b vP;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (vP = v.this.vP(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, vP));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> fFM = new ArrayList();

    public v(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.fMn = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        dN(context);
        b(rVar);
        rVar.addAdapters(this.fFM);
    }

    private void dN(Context context) {
        this.fMp = new a(this.mPageContext);
        this.fMq = new t(this.mPageContext);
        this.fMr = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.fMs = new q(this.mPageContext, com.baidu.tieba.card.data.k.elv);
        this.fMt = new g(this.mPageContext, com.baidu.tieba.card.data.k.elA);
        this.fMu = new h(this.mPageContext, com.baidu.tieba.card.data.k.elB);
        this.fMv = new o(this.mPageContext, com.baidu.tieba.card.data.k.elC);
        this.fMw = new f(this.mPageContext, com.baidu.tieba.card.data.k.elw);
        this.fMx = new e(this.mPageContext, com.baidu.tieba.card.data.k.ely);
        this.fMy = new d(this.mPageContext, com.baidu.tieba.card.data.k.elz);
        this.fMz = new r(this.mPageContext, com.baidu.tieba.card.data.l.bBd);
        this.fMA = new j(this.mPageContext, com.baidu.tieba.card.data.k.bBb);
        this.fMB = new s(this.mPageContext, com.baidu.tieba.card.data.l.elJ);
        this.fMC = new l(this.mPageContext);
        this.fMD = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.fME = new p(this.mPageContext, com.baidu.tieba.card.data.k.bBh);
        this.fMF = new k(this.mPageContext, com.baidu.tieba.card.data.k.elt);
        this.fMG = new s(this.mPageContext, com.baidu.tieba.card.data.l.elK);
        this.fMH = new i(this.mPageContext, com.baidu.tieba.card.data.k.elu);
        this.fMI = new m(this.mPageContext, com.baidu.tieba.card.data.k.bBl);
        this.fMJ = new n(this.mPageContext, com.baidu.tieba.card.data.k.bBm);
        this.fFM.add(this.fMp);
        this.fFM.add(this.fMq);
        this.fFM.add(this.fMB);
        this.fFM.add(this.fMr);
        this.fFM.add(this.fMs);
        this.fFM.add(this.fMt);
        this.fFM.add(this.fMu);
        this.fFM.add(this.fMv);
        this.fFM.add(this.fMw);
        this.fFM.add(this.fMx);
        this.fFM.add(this.fMy);
        this.fFM.add(this.fMz);
        this.fFM.add(this.fMA);
        this.fFM.add(this.fMC);
        this.fFM.add(this.fMF);
        this.fFM.add(this.fMG);
        this.fFM.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.fFM.add(this.fMD);
        this.fFM.add(this.fME);
        this.fFM.add(new u(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.fFM.add(this.fMH);
        this.fFM.add(this.fMI);
        this.fFM.add(this.fMJ);
        bmN();
        bmM();
        qL("page_recommend");
    }

    private void bmM() {
        if (!bg.bBo.get()) {
            AdvertAppInfo.bwB.set(false);
            return;
        }
        this.fMK = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bws);
        this.fML = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bwv);
        this.fMM = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bww);
        this.fMN = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bwx);
        this.fMO = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bwy);
        this.fMP = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bwz);
        this.fMQ = com.baidu.tieba.recapp.r.bWJ().c(this.mPageContext, AdvertAppInfo.bwA);
        this.fFM.add(this.fMK);
        this.fFM.add(this.fML);
        this.fFM.add(this.fMM);
        this.fFM.add(this.fMN);
        this.fFM.add(this.fMO);
        this.fFM.add(this.fMP);
        this.fFM.add(this.fMQ);
        AdvertAppInfo.bwB.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fMr.a(eVar);
        this.fMs.a(eVar);
        this.fMt.a(eVar);
        this.fMu.a(eVar);
        this.fMv.a(eVar);
        this.fMw.a(eVar);
        this.fMx.a(eVar);
        this.fMy.a(eVar);
        this.fMz.a(eVar);
        this.fMB.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.fMs.b(rVar);
        this.fMt.b(rVar);
        this.fMu.b(rVar);
        this.fMv.b(rVar);
        this.fMw.b(rVar);
        this.fMx.b(rVar);
        this.fMy.b(rVar);
        this.fMz.b(rVar);
    }

    public void ay(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.fMn.setData(list);
        this.fMo = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.fMp.onChangeSkinType(i);
        this.fMC.sE(i);
    }

    public void notifyDataSetChanged() {
        if (this.fMn != null) {
            this.fMn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.fMr != null) {
            this.fMr.setFromCDN(z);
            this.fMF.setFromCDN(z);
            this.fMB.setFromCDN(z);
            this.fMG.setFromCDN(z);
            this.fMA.setFromCDN(z);
            this.fME.setFromCDN(z);
        }
        if (this.fMu != null) {
            this.fMu.setFromCDN(z);
        }
        if (this.fML != null && (this.fML instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.fML).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fMr != null) {
            this.fMr.cnX = bdUniqueId;
        }
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
        if (this.fMA != null) {
            this.fMA.cnX = bdUniqueId;
        }
        if (this.fMB != null) {
            this.fMB.cnX = bdUniqueId;
        }
        if (this.fMz != null) {
            this.fMz.cnX = bdUniqueId;
        }
        if (this.fMp != null) {
            this.fMp.setPageUniqueId(bdUniqueId);
        }
        if (this.fMC != null) {
            this.fMC.cnX = bdUniqueId;
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
        if (this.fMI != null) {
            this.fMI.cnX = bdUniqueId;
        }
        if (this.fMJ != null) {
            this.fMJ.cnX = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fpZ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fpZ) {
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
        this.ehY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ehY);
        if (!this.fMS) {
            this.fqa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fqa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.fMo != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fMo.iterator();
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

    private void bmN() {
        this.fMS = bmO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmO() {
        if (this.fpZ == null || this.fpZ.size() <= 0) {
            this.fpZ = new ArrayList();
            ArrayList<BdUniqueId> cdG = com.baidu.tieba.tbadkCore.q.cdG();
            if (cdG == null || cdG.size() <= 0) {
                return false;
            }
            int size = cdG.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bBl().a(this.mPageContext, cdG.get(i), 2);
                if (this.fMR) {
                    a.setBusinessType(3);
                }
                if (this.fMr != null && this.fMr.cnX != null) {
                    a.setUniqueId(this.fMr.cnX);
                }
                this.fpZ.add(a);
            }
            this.fMn.addAdapters(this.fpZ);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fMr != null) {
            this.fMr.setEventCallback(aVar);
        }
        if (this.fMs != null) {
            this.fMs.setEventCallback(aVar);
        }
        if (this.fMA != null) {
            this.fMA.setEventCallback(aVar);
        }
        if (this.fMB != null) {
            this.fMB.setEventCallback(aVar);
        }
        if (this.fMD != null) {
            this.fMD.setEventCallback(aVar);
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
        if (this.fMI != null) {
            this.fMI.setEventCallback(aVar);
        }
        if (this.fMJ != null) {
            this.fMJ.setEventCallback(aVar);
        }
    }

    private void qL(String str) {
        if (this.fFM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fFM) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qL(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).ekZ) != null && advertAppInfo.Xa() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b vP(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.fMo == null || this.fMo.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.fMo.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.fMo.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.fMo.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.fMo.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.fMo.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.fMo.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.fMo.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.fMo.get(i4)) != null && lVar.cZz != null && str.equals(lVar.cZz.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.fMo.get(i4)).position;
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
        if (this.fMB != null) {
            this.fMB.onPause();
        }
        if (this.fMG != null) {
            this.fMG.onPause();
        }
        if (this.fMz != null) {
            this.fMz.onPause();
        }
    }

    public void onResume() {
        if (this.fMB != null) {
            this.fMB.onResume();
        }
        if (this.fMG != null) {
            this.fMG.onResume();
        }
        if (this.fMz != null) {
            this.fMz.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fMB != null) {
            this.fMB.onDestroy();
        }
    }
}
