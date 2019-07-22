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
public class w {
    private List<com.baidu.adp.widget.ListView.a> fLh;
    private u gjA;
    private k gjB;
    private r gjC;
    private g gjD;
    private h gjE;
    private o gjF;
    private f gjG;
    private e gjH;
    private d gjI;
    private s gjJ;
    private j gjK;
    private t gjL;
    private l gjM;
    private b gjN;
    private q gjO;
    private k gjP;
    private t gjQ;
    private i gjR;
    private m gjS;
    private n gjT;
    private p gjU;
    private com.baidu.adp.widget.ListView.a gjV;
    private com.baidu.adp.widget.ListView.a gjW;
    private com.baidu.adp.widget.ListView.a gjX;
    private com.baidu.adp.widget.ListView.a gjY;
    private com.baidu.adp.widget.ListView.a gjZ;
    private com.baidu.adp.widget.ListView.r gjx;
    private List<com.baidu.adp.widget.ListView.m> gjy;
    private a gjz;
    private com.baidu.adp.widget.ListView.a gka;
    private com.baidu.adp.widget.ListView.a gkb;
    private boolean gkc;
    private boolean gkd;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fLj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.bwV();
                if (w.this.gjy != null) {
                    w.this.aF(w.this.gjy);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.w.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Hs) {
                w.this.at(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.w.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bIP = true;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.w.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bIP = false;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener eCx = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b xK;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (xK = w.this.xK(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, xK));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gbx = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gjx = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dE(context);
        b(rVar);
        rVar.addAdapters(this.gbx);
    }

    private void dE(Context context) {
        this.gjz = new a(this.mPageContext);
        this.gjA = new u(this.mPageContext);
        this.gjB = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gjC = new r(this.mPageContext, com.baidu.tieba.card.data.k.eFU);
        this.gjD = new g(this.mPageContext, com.baidu.tieba.card.data.k.eFZ);
        this.gjE = new h(this.mPageContext, com.baidu.tieba.card.data.k.eGa);
        this.gjF = new o(this.mPageContext, com.baidu.tieba.card.data.k.eGb);
        this.gjG = new f(this.mPageContext, com.baidu.tieba.card.data.k.eFV);
        this.gjH = new e(this.mPageContext, com.baidu.tieba.card.data.k.eFX);
        this.gjI = new d(this.mPageContext, com.baidu.tieba.card.data.k.eFY);
        this.gjJ = new s(this.mPageContext, com.baidu.tieba.card.data.l.bJx);
        this.gjK = new j(this.mPageContext, com.baidu.tieba.card.data.k.bJv);
        this.gjL = new t(this.mPageContext, com.baidu.tieba.card.data.l.eGh);
        this.gjM = new l(this.mPageContext);
        this.gjN = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gjO = new q(this.mPageContext, com.baidu.tieba.card.data.k.bJB);
        this.gjP = new k(this.mPageContext, com.baidu.tieba.card.data.k.eFS);
        this.gjQ = new t(this.mPageContext, com.baidu.tieba.card.data.l.eGi);
        this.gjR = new i(this.mPageContext, com.baidu.tieba.card.data.k.eFT);
        this.gjS = new m(this.mPageContext, com.baidu.tieba.card.data.k.bJF);
        this.gjT = new n(this.mPageContext, com.baidu.tieba.card.data.k.bJG);
        this.gjU = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.gna);
        this.gbx.add(this.gjz);
        this.gbx.add(this.gjA);
        this.gbx.add(this.gjL);
        this.gbx.add(this.gjB);
        this.gbx.add(this.gjC);
        this.gbx.add(this.gjD);
        this.gbx.add(this.gjE);
        this.gbx.add(this.gjF);
        this.gbx.add(this.gjG);
        this.gbx.add(this.gjH);
        this.gbx.add(this.gjI);
        this.gbx.add(this.gjJ);
        this.gbx.add(this.gjK);
        this.gbx.add(this.gjM);
        this.gbx.add(this.gjP);
        this.gbx.add(this.gjQ);
        this.gbx.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gbx.add(this.gjN);
        this.gbx.add(this.gjO);
        this.gbx.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.gbx.add(this.gjR);
        this.gbx.add(this.gjS);
        this.gbx.add(this.gjT);
        this.gbx.add(this.gjU);
        bwU();
        bwT();
        sm("page_recommend");
    }

    private void bwT() {
        if (!bg.bJJ.get()) {
            AdvertAppInfo.bER.set(false);
            return;
        }
        this.gjV = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEI);
        this.gjW = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEL);
        this.gjX = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEM);
        this.gjY = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEN);
        this.gjZ = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEO);
        this.gka = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEP);
        this.gkb = com.baidu.tieba.recapp.r.chD().c(this.mPageContext, AdvertAppInfo.bEQ);
        this.gbx.add(this.gjV);
        this.gbx.add(this.gjW);
        this.gbx.add(this.gjX);
        this.gbx.add(this.gjY);
        this.gbx.add(this.gjZ);
        this.gbx.add(this.gka);
        this.gbx.add(this.gkb);
        AdvertAppInfo.bER.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gjB.a(eVar);
        this.gjC.a(eVar);
        this.gjD.a(eVar);
        this.gjE.a(eVar);
        this.gjF.a(eVar);
        this.gjG.a(eVar);
        this.gjH.a(eVar);
        this.gjI.a(eVar);
        this.gjJ.a(eVar);
        this.gjL.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gjC.b(rVar);
        this.gjD.b(rVar);
        this.gjE.b(rVar);
        this.gjF.b(rVar);
        this.gjG.b(rVar);
        this.gjH.b(rVar);
        this.gjI.b(rVar);
        this.gjJ.b(rVar);
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.gjx.setData(list);
        this.gjy = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gjz.onChangeSkinType(i);
        this.gjM.uf(i);
    }

    public void notifyDataSetChanged() {
        if (this.gjx != null) {
            this.gjx.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gjB != null) {
            this.gjB.setFromCDN(z);
            this.gjP.setFromCDN(z);
            this.gjL.setFromCDN(z);
            this.gjQ.setFromCDN(z);
            this.gjK.setFromCDN(z);
            this.gjO.setFromCDN(z);
        }
        if (this.gjE != null) {
            this.gjE.setFromCDN(z);
        }
        if (this.gjW != null && (this.gjW instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gjW).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gjB != null) {
            this.gjB.cxx = bdUniqueId;
        }
        if (this.gjC != null) {
            this.gjC.cxx = bdUniqueId;
        }
        if (this.gjD != null) {
            this.gjD.cxx = bdUniqueId;
        }
        if (this.gjE != null) {
            this.gjE.cxx = bdUniqueId;
        }
        if (this.gjF != null) {
            this.gjF.cxx = bdUniqueId;
        }
        if (this.gjG != null) {
            this.gjG.cxx = bdUniqueId;
        }
        if (this.gjH != null) {
            this.gjH.cxx = bdUniqueId;
        }
        if (this.gjI != null) {
            this.gjI.cxx = bdUniqueId;
        }
        if (this.gjK != null) {
            this.gjK.cxx = bdUniqueId;
        }
        if (this.gjL != null) {
            this.gjL.cxx = bdUniqueId;
        }
        if (this.gjJ != null) {
            this.gjJ.cxx = bdUniqueId;
        }
        if (this.gjz != null) {
            this.gjz.setPageUniqueId(bdUniqueId);
        }
        if (this.gjM != null) {
            this.gjM.cxx = bdUniqueId;
        }
        if (this.gjN != null) {
            this.gjN.cxx = bdUniqueId;
        }
        if (this.gjO != null) {
            this.gjO.cxx = bdUniqueId;
        }
        if (this.gjP != null) {
            this.gjP.cxx = bdUniqueId;
        }
        if (this.gjQ != null) {
            this.gjQ.cxx = bdUniqueId;
        }
        if (this.gjS != null) {
            this.gjS.cxx = bdUniqueId;
        }
        if (this.gjT != null) {
            this.gjT.cxx = bdUniqueId;
        }
        if (this.gjU != null) {
            this.gjU.cxx = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fLh)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fLh) {
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
        this.eCx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eCx);
        if (!this.gkd) {
            this.fLj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gjy != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gjy.iterator();
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

    private void bwU() {
        this.gkd = bwV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwV() {
        if (this.fLh == null || this.fLh.size() <= 0) {
            this.fLh = new ArrayList();
            ArrayList<BdUniqueId> coC = com.baidu.tieba.tbadkCore.q.coC();
            if (coC == null || coC.size() <= 0) {
                return false;
            }
            int size = coC.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bLD().a(this.mPageContext, coC.get(i), 2);
                if (this.gkc) {
                    a.setBusinessType(3);
                }
                if (this.gjB != null && this.gjB.cxx != null) {
                    a.setUniqueId(this.gjB.cxx);
                }
                this.fLh.add(a);
            }
            this.gjx.addAdapters(this.fLh);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gjB != null) {
            this.gjB.setEventCallback(aVar);
        }
        if (this.gjC != null) {
            this.gjC.setEventCallback(aVar);
        }
        if (this.gjK != null) {
            this.gjK.setEventCallback(aVar);
        }
        if (this.gjL != null) {
            this.gjL.setEventCallback(aVar);
        }
        if (this.gjN != null) {
            this.gjN.setEventCallback(aVar);
        }
        if (this.gjO != null) {
            this.gjO.setEventCallback(aVar);
        }
        if (this.gjP != null) {
            this.gjP.setEventCallback(aVar);
        }
        if (this.gjQ != null) {
            this.gjQ.setEventCallback(aVar);
        }
        if (this.gjS != null) {
            this.gjS.setEventCallback(aVar);
        }
        if (this.gjT != null) {
            this.gjT.setEventCallback(aVar);
        }
        if (this.gjU != null) {
            this.gjU.setEventCallback(aVar);
        }
    }

    private void sm(String str) {
        if (this.gbx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gbx) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sm(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eFx) != null && advertAppInfo.acG() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b xK(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gjy == null || this.gjy.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gjy.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gjy.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gjy.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.gjy.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gjy.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gjy.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gjy.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gjy.get(i4)) != null && lVar.threadData != null && str.equals(lVar.threadData.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gjy.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.be(i6 - i >= -1 ? i6 - i : -1);
        bVar.bf(i7);
        bVar.bg(i2);
        return bVar;
    }

    public void onPause() {
        if (this.gjL != null) {
            this.gjL.onPause();
        }
        if (this.gjQ != null) {
            this.gjQ.onPause();
        }
        if (this.gjJ != null) {
            this.gjJ.onPause();
        }
    }

    public void onResume() {
        if (this.gjL != null) {
            this.gjL.onResume();
        }
        if (this.gjQ != null) {
            this.gjQ.onResume();
        }
        if (this.gjJ != null) {
            this.gjJ.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gjL != null) {
            this.gjL.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gjy;
    }
}
