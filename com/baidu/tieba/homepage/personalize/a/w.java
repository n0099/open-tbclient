package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
    private List<com.baidu.adp.widget.ListView.a> fLV;
    private j gkA;
    private t gkB;
    private l gkC;
    private b gkD;
    private q gkE;
    private k gkF;
    private t gkG;
    private i gkH;
    private m gkI;
    private n gkJ;
    private p gkK;
    private com.baidu.adp.widget.ListView.a gkL;
    private com.baidu.adp.widget.ListView.a gkM;
    private com.baidu.adp.widget.ListView.a gkN;
    private com.baidu.adp.widget.ListView.a gkO;
    private com.baidu.adp.widget.ListView.a gkP;
    private com.baidu.adp.widget.ListView.a gkQ;
    private com.baidu.adp.widget.ListView.a gkR;
    private boolean gkS;
    private boolean gkT;
    private com.baidu.adp.widget.ListView.r gkn;
    private List<com.baidu.adp.widget.ListView.m> gko;
    private a gkp;
    private u gkq;
    private k gkr;
    private r gks;
    private g gkt;
    private h gku;
    private o gkv;
    private f gkw;
    private e gkx;
    private d gky;
    private s gkz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fLX = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.bxj();
                if (w.this.gko != null) {
                    w.this.aF(w.this.gko);
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
                bVar.bIU = true;
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
                bVar.bIU = false;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener eCE = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b xL;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (xL = w.this.xL(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, xL));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gcn = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gkn = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dF(context);
        b(rVar);
        rVar.addAdapters(this.gcn);
    }

    private void dF(Context context) {
        this.gkp = new a(this.mPageContext);
        this.gkq = new u(this.mPageContext);
        this.gkr = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gks = new r(this.mPageContext, com.baidu.tieba.card.data.k.eGb);
        this.gkt = new g(this.mPageContext, com.baidu.tieba.card.data.k.eGg);
        this.gku = new h(this.mPageContext, com.baidu.tieba.card.data.k.eGh);
        this.gkv = new o(this.mPageContext, com.baidu.tieba.card.data.k.eGi);
        this.gkw = new f(this.mPageContext, com.baidu.tieba.card.data.k.eGc);
        this.gkx = new e(this.mPageContext, com.baidu.tieba.card.data.k.eGe);
        this.gky = new d(this.mPageContext, com.baidu.tieba.card.data.k.eGf);
        this.gkz = new s(this.mPageContext, com.baidu.tieba.card.data.l.bJC);
        this.gkA = new j(this.mPageContext, com.baidu.tieba.card.data.k.bJA);
        this.gkB = new t(this.mPageContext, com.baidu.tieba.card.data.l.eGo);
        this.gkC = new l(this.mPageContext);
        this.gkD = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gkE = new q(this.mPageContext, com.baidu.tieba.card.data.k.bJG);
        this.gkF = new k(this.mPageContext, com.baidu.tieba.card.data.k.eFZ);
        this.gkG = new t(this.mPageContext, com.baidu.tieba.card.data.l.eGp);
        this.gkH = new i(this.mPageContext, com.baidu.tieba.card.data.k.eGa);
        this.gkI = new m(this.mPageContext, com.baidu.tieba.card.data.k.bJK);
        this.gkJ = new n(this.mPageContext, com.baidu.tieba.card.data.k.bJL);
        this.gkK = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.gnS);
        this.gcn.add(this.gkp);
        this.gcn.add(this.gkq);
        this.gcn.add(this.gkB);
        this.gcn.add(this.gkr);
        this.gcn.add(this.gks);
        this.gcn.add(this.gkt);
        this.gcn.add(this.gku);
        this.gcn.add(this.gkv);
        this.gcn.add(this.gkw);
        this.gcn.add(this.gkx);
        this.gcn.add(this.gky);
        this.gcn.add(this.gkz);
        this.gcn.add(this.gkA);
        this.gcn.add(this.gkC);
        this.gcn.add(this.gkF);
        this.gcn.add(this.gkG);
        this.gcn.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gcn.add(this.gkD);
        this.gcn.add(this.gkE);
        this.gcn.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.gcn.add(this.gkH);
        this.gcn.add(this.gkI);
        this.gcn.add(this.gkJ);
        this.gcn.add(this.gkK);
        bxi();
        bxh();
        sm("page_recommend");
    }

    private void bxh() {
        if (!bh.bJO.get()) {
            AdvertAppInfo.bES.set(false);
            return;
        }
        this.gkL = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bEJ);
        this.gkM = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bEM);
        this.gkN = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bEN);
        this.gkO = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bEO);
        this.gkP = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bEP);
        this.gkQ = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bEQ);
        this.gkR = com.baidu.tieba.recapp.r.chV().c(this.mPageContext, AdvertAppInfo.bER);
        this.gcn.add(this.gkL);
        this.gcn.add(this.gkM);
        this.gcn.add(this.gkN);
        this.gcn.add(this.gkO);
        this.gcn.add(this.gkP);
        this.gcn.add(this.gkQ);
        this.gcn.add(this.gkR);
        AdvertAppInfo.bES.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gkr.a(eVar);
        this.gks.a(eVar);
        this.gkt.a(eVar);
        this.gku.a(eVar);
        this.gkv.a(eVar);
        this.gkw.a(eVar);
        this.gkx.a(eVar);
        this.gky.a(eVar);
        this.gkz.a(eVar);
        this.gkB.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gks.b(rVar);
        this.gkt.b(rVar);
        this.gku.b(rVar);
        this.gkv.b(rVar);
        this.gkw.b(rVar);
        this.gkx.b(rVar);
        this.gky.b(rVar);
        this.gkz.b(rVar);
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.p(list, 2);
        this.gkn.setData(list);
        this.gko = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gkp.onChangeSkinType(i);
        this.gkC.uh(i);
    }

    public void notifyDataSetChanged() {
        if (this.gkn != null) {
            this.gkn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gkr != null) {
            this.gkr.setFromCDN(z);
            this.gkF.setFromCDN(z);
            this.gkB.setFromCDN(z);
            this.gkG.setFromCDN(z);
            this.gkA.setFromCDN(z);
            this.gkE.setFromCDN(z);
        }
        if (this.gku != null) {
            this.gku.setFromCDN(z);
        }
        if (this.gkM != null && (this.gkM instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gkM).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gkr != null) {
            this.gkr.cxE = bdUniqueId;
        }
        if (this.gks != null) {
            this.gks.cxE = bdUniqueId;
        }
        if (this.gkt != null) {
            this.gkt.cxE = bdUniqueId;
        }
        if (this.gku != null) {
            this.gku.cxE = bdUniqueId;
        }
        if (this.gkv != null) {
            this.gkv.cxE = bdUniqueId;
        }
        if (this.gkw != null) {
            this.gkw.cxE = bdUniqueId;
        }
        if (this.gkx != null) {
            this.gkx.cxE = bdUniqueId;
        }
        if (this.gky != null) {
            this.gky.cxE = bdUniqueId;
        }
        if (this.gkA != null) {
            this.gkA.cxE = bdUniqueId;
        }
        if (this.gkB != null) {
            this.gkB.cxE = bdUniqueId;
        }
        if (this.gkz != null) {
            this.gkz.cxE = bdUniqueId;
        }
        if (this.gkp != null) {
            this.gkp.setPageUniqueId(bdUniqueId);
        }
        if (this.gkC != null) {
            this.gkC.cxE = bdUniqueId;
        }
        if (this.gkD != null) {
            this.gkD.cxE = bdUniqueId;
        }
        if (this.gkE != null) {
            this.gkE.cxE = bdUniqueId;
        }
        if (this.gkF != null) {
            this.gkF.cxE = bdUniqueId;
        }
        if (this.gkG != null) {
            this.gkG.cxE = bdUniqueId;
        }
        if (this.gkI != null) {
            this.gkI.cxE = bdUniqueId;
        }
        if (this.gkJ != null) {
            this.gkJ.cxE = bdUniqueId;
        }
        if (this.gkK != null) {
            this.gkK.cxE = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fLV)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fLV) {
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
        this.eCE.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eCE);
        if (!this.gkT) {
            this.fLX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fLX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gko != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gko.iterator();
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

    private void bxi() {
        this.gkT = bxj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxj() {
        if (this.fLV == null || this.fLV.size() <= 0) {
            this.fLV = new ArrayList();
            ArrayList<BdUniqueId> coY = com.baidu.tieba.tbadkCore.s.coY();
            if (coY == null || coY.size() <= 0) {
                return false;
            }
            int size = coY.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bLR().a(this.mPageContext, coY.get(i), 2);
                if (this.gkS) {
                    a.setBusinessType(3);
                }
                if (this.gkr != null && this.gkr.cxE != null) {
                    a.setUniqueId(this.gkr.cxE);
                }
                this.fLV.add(a);
            }
            this.gkn.addAdapters(this.fLV);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gkr != null) {
            this.gkr.setEventCallback(aVar);
        }
        if (this.gks != null) {
            this.gks.setEventCallback(aVar);
        }
        if (this.gkA != null) {
            this.gkA.setEventCallback(aVar);
        }
        if (this.gkB != null) {
            this.gkB.setEventCallback(aVar);
        }
        if (this.gkD != null) {
            this.gkD.setEventCallback(aVar);
        }
        if (this.gkE != null) {
            this.gkE.setEventCallback(aVar);
        }
        if (this.gkF != null) {
            this.gkF.setEventCallback(aVar);
        }
        if (this.gkG != null) {
            this.gkG.setEventCallback(aVar);
        }
        if (this.gkI != null) {
            this.gkI.setEventCallback(aVar);
        }
        if (this.gkJ != null) {
            this.gkJ.setEventCallback(aVar);
        }
        if (this.gkK != null) {
            this.gkK.setEventCallback(aVar);
        }
    }

    private void sm(String str) {
        if (this.gcn != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gcn) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sm(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eFE) != null && advertAppInfo.acH() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b xL(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gko == null || this.gko.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gko.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gko.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gko.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.gko.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gko.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gko.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gko.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gko.get(i4)) != null && lVar.threadData != null && str.equals(lVar.threadData.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gko.get(i4)).position;
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
        if (this.gkB != null) {
            this.gkB.onPause();
        }
        if (this.gkG != null) {
            this.gkG.onPause();
        }
        if (this.gkz != null) {
            this.gkz.onPause();
        }
    }

    public void onResume() {
        if (this.gkB != null) {
            this.gkB.onResume();
        }
        if (this.gkG != null) {
            this.gkG.onResume();
        }
        if (this.gkz != null) {
            this.gkz.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gkB != null) {
            this.gkB.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gko;
    }
}
