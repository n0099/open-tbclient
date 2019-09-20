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
    private List<com.baidu.adp.widget.ListView.a> fNK;
    private m gmA;
    private n gmB;
    private p gmC;
    private com.baidu.adp.widget.ListView.a gmD;
    private com.baidu.adp.widget.ListView.a gmE;
    private com.baidu.adp.widget.ListView.a gmF;
    private com.baidu.adp.widget.ListView.a gmG;
    private com.baidu.adp.widget.ListView.a gmH;
    private com.baidu.adp.widget.ListView.a gmI;
    private com.baidu.adp.widget.ListView.a gmJ;
    private boolean gmK;
    private boolean gmL;
    private com.baidu.adp.widget.ListView.r gmf;
    private List<com.baidu.adp.widget.ListView.m> gmg;
    private a gmh;
    private u gmi;
    private k gmj;
    private r gmk;
    private g gml;
    private h gmm;
    private o gmn;
    private f gmo;
    private e gmp;
    private d gmq;
    private s gmr;
    private j gms;
    private t gmt;
    private l gmu;
    private b gmv;
    private q gmw;
    private k gmx;
    private t gmy;
    private i gmz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fNM = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.bxX();
                if (w.this.gmg != null) {
                    w.this.aF(w.this.gmg);
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
                bVar.bJs = true;
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
                bVar.bJs = false;
                w.this.at(bVar);
            }
        }
    };
    private CustomMessageListener eEn = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b yk;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (yk = w.this.yk(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, yk));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gee = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gmf = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dG(context);
        b(rVar);
        rVar.addAdapters(this.gee);
    }

    private void dG(Context context) {
        this.gmh = new a(this.mPageContext);
        this.gmi = new u(this.mPageContext);
        this.gmj = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gmk = new r(this.mPageContext, com.baidu.tieba.card.data.k.eHK);
        this.gml = new g(this.mPageContext, com.baidu.tieba.card.data.k.eHP);
        this.gmm = new h(this.mPageContext, com.baidu.tieba.card.data.k.eHQ);
        this.gmn = new o(this.mPageContext, com.baidu.tieba.card.data.k.eHR);
        this.gmo = new f(this.mPageContext, com.baidu.tieba.card.data.k.eHL);
        this.gmp = new e(this.mPageContext, com.baidu.tieba.card.data.k.eHN);
        this.gmq = new d(this.mPageContext, com.baidu.tieba.card.data.k.eHO);
        this.gmr = new s(this.mPageContext, com.baidu.tieba.card.data.l.bKa);
        this.gms = new j(this.mPageContext, com.baidu.tieba.card.data.k.bJY);
        this.gmt = new t(this.mPageContext, com.baidu.tieba.card.data.l.eHX);
        this.gmu = new l(this.mPageContext);
        this.gmv = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gmw = new q(this.mPageContext, com.baidu.tieba.card.data.k.bKe);
        this.gmx = new k(this.mPageContext, com.baidu.tieba.card.data.k.eHI);
        this.gmy = new t(this.mPageContext, com.baidu.tieba.card.data.l.eHY);
        this.gmz = new i(this.mPageContext, com.baidu.tieba.card.data.k.eHJ);
        this.gmA = new m(this.mPageContext, com.baidu.tieba.card.data.k.bKi);
        this.gmB = new n(this.mPageContext, com.baidu.tieba.card.data.k.bKj);
        this.gmC = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.gpJ);
        this.gee.add(this.gmh);
        this.gee.add(this.gmi);
        this.gee.add(this.gmt);
        this.gee.add(this.gmj);
        this.gee.add(this.gmk);
        this.gee.add(this.gml);
        this.gee.add(this.gmm);
        this.gee.add(this.gmn);
        this.gee.add(this.gmo);
        this.gee.add(this.gmp);
        this.gee.add(this.gmq);
        this.gee.add(this.gmr);
        this.gee.add(this.gms);
        this.gee.add(this.gmu);
        this.gee.add(this.gmx);
        this.gee.add(this.gmy);
        this.gee.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gee.add(this.gmv);
        this.gee.add(this.gmw);
        this.gee.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.gee.add(this.gmz);
        this.gee.add(this.gmA);
        this.gee.add(this.gmB);
        this.gee.add(this.gmC);
        bxW();
        bxV();
        sy("page_recommend");
    }

    private void bxV() {
        if (!bh.bKm.get()) {
            AdvertAppInfo.bFq.set(false);
            return;
        }
        this.gmD = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFh);
        this.gmE = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFk);
        this.gmF = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFl);
        this.gmG = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFm);
        this.gmH = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFn);
        this.gmI = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFo);
        this.gmJ = com.baidu.tieba.recapp.r.ciJ().c(this.mPageContext, AdvertAppInfo.bFp);
        this.gee.add(this.gmD);
        this.gee.add(this.gmE);
        this.gee.add(this.gmF);
        this.gee.add(this.gmG);
        this.gee.add(this.gmH);
        this.gee.add(this.gmI);
        this.gee.add(this.gmJ);
        AdvertAppInfo.bFq.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gmj.a(eVar);
        this.gmk.a(eVar);
        this.gml.a(eVar);
        this.gmm.a(eVar);
        this.gmn.a(eVar);
        this.gmo.a(eVar);
        this.gmp.a(eVar);
        this.gmq.a(eVar);
        this.gmr.a(eVar);
        this.gmt.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gmk.b(rVar);
        this.gml.b(rVar);
        this.gmm.b(rVar);
        this.gmn.b(rVar);
        this.gmo.b(rVar);
        this.gmp.b(rVar);
        this.gmq.b(rVar);
        this.gmr.b(rVar);
    }

    public void aF(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.p(list, 2);
        this.gmf.setData(list);
        this.gmg = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gmh.onChangeSkinType(i);
        this.gmu.ul(i);
    }

    public void notifyDataSetChanged() {
        if (this.gmf != null) {
            this.gmf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gmj != null) {
            this.gmj.setFromCDN(z);
            this.gmx.setFromCDN(z);
            this.gmt.setFromCDN(z);
            this.gmy.setFromCDN(z);
            this.gms.setFromCDN(z);
            this.gmw.setFromCDN(z);
        }
        if (this.gmm != null) {
            this.gmm.setFromCDN(z);
        }
        if (this.gmE != null && (this.gmE instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gmE).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gmj != null) {
            this.gmj.cyA = bdUniqueId;
        }
        if (this.gmk != null) {
            this.gmk.cyA = bdUniqueId;
        }
        if (this.gml != null) {
            this.gml.cyA = bdUniqueId;
        }
        if (this.gmm != null) {
            this.gmm.cyA = bdUniqueId;
        }
        if (this.gmn != null) {
            this.gmn.cyA = bdUniqueId;
        }
        if (this.gmo != null) {
            this.gmo.cyA = bdUniqueId;
        }
        if (this.gmp != null) {
            this.gmp.cyA = bdUniqueId;
        }
        if (this.gmq != null) {
            this.gmq.cyA = bdUniqueId;
        }
        if (this.gms != null) {
            this.gms.cyA = bdUniqueId;
        }
        if (this.gmt != null) {
            this.gmt.cyA = bdUniqueId;
        }
        if (this.gmr != null) {
            this.gmr.cyA = bdUniqueId;
        }
        if (this.gmh != null) {
            this.gmh.setPageUniqueId(bdUniqueId);
        }
        if (this.gmu != null) {
            this.gmu.cyA = bdUniqueId;
        }
        if (this.gmv != null) {
            this.gmv.cyA = bdUniqueId;
        }
        if (this.gmw != null) {
            this.gmw.cyA = bdUniqueId;
        }
        if (this.gmx != null) {
            this.gmx.cyA = bdUniqueId;
        }
        if (this.gmy != null) {
            this.gmy.cyA = bdUniqueId;
        }
        if (this.gmA != null) {
            this.gmA.cyA = bdUniqueId;
        }
        if (this.gmB != null) {
            this.gmB.cyA = bdUniqueId;
        }
        if (this.gmC != null) {
            this.gmC.cyA = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fNK)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fNK) {
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
        this.eEn.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eEn);
        if (!this.gmL) {
            this.fNM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fNM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gmg != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gmg.iterator();
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

    private void bxW() {
        this.gmL = bxX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxX() {
        if (this.fNK == null || this.fNK.size() <= 0) {
            this.fNK = new ArrayList();
            ArrayList<BdUniqueId> cpM = com.baidu.tieba.tbadkCore.s.cpM();
            if (cpM == null || cpM.size() <= 0) {
                return false;
            }
            int size = cpM.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bME().a(this.mPageContext, cpM.get(i), 2);
                if (this.gmK) {
                    a.setBusinessType(3);
                }
                if (this.gmj != null && this.gmj.cyA != null) {
                    a.setUniqueId(this.gmj.cyA);
                }
                this.fNK.add(a);
            }
            this.gmf.addAdapters(this.fNK);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gmj != null) {
            this.gmj.setEventCallback(aVar);
        }
        if (this.gmk != null) {
            this.gmk.setEventCallback(aVar);
        }
        if (this.gms != null) {
            this.gms.setEventCallback(aVar);
        }
        if (this.gmt != null) {
            this.gmt.setEventCallback(aVar);
        }
        if (this.gmv != null) {
            this.gmv.setEventCallback(aVar);
        }
        if (this.gmw != null) {
            this.gmw.setEventCallback(aVar);
        }
        if (this.gmx != null) {
            this.gmx.setEventCallback(aVar);
        }
        if (this.gmy != null) {
            this.gmy.setEventCallback(aVar);
        }
        if (this.gmA != null) {
            this.gmA.setEventCallback(aVar);
        }
        if (this.gmB != null) {
            this.gmB.setEventCallback(aVar);
        }
        if (this.gmC != null) {
            this.gmC.setEventCallback(aVar);
        }
    }

    private void sy(String str) {
        if (this.gee != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gee) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sy(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).eHn) != null && advertAppInfo.acL() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b yk(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gmg == null || this.gmg.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gmg.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gmg.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.gmg.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.gmg.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gmg.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gmg.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gmg.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gmg.get(i4)) != null && lVar.threadData != null && str.equals(lVar.threadData.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gmg.get(i4)).position;
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
        if (this.gmt != null) {
            this.gmt.onPause();
        }
        if (this.gmy != null) {
            this.gmy.onPause();
        }
        if (this.gmr != null) {
            this.gmr.onPause();
        }
    }

    public void onResume() {
        if (this.gmt != null) {
            this.gmt.onResume();
        }
        if (this.gmy != null) {
            this.gmy.onResume();
        }
        if (this.gmr != null) {
            this.gmr.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gmt != null) {
            this.gmt.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gmg;
    }
}
