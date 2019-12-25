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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ab {
    private List<com.baidu.adp.widget.ListView.a> gAz;
    private m gYA;
    private y gYB;
    private b gYC;
    private u gYD;
    private t gYE;
    private v gYF;
    private s gYG;
    private n gYH;
    private y gYI;
    private l gYJ;
    private o gYK;
    private p gYL;
    private r gYM;
    private c gYN;
    private com.baidu.adp.widget.ListView.a gYO;
    private com.baidu.adp.widget.ListView.a gYP;
    private com.baidu.adp.widget.ListView.a gYQ;
    private com.baidu.adp.widget.ListView.a gYR;
    private com.baidu.adp.widget.ListView.a gYS;
    private com.baidu.adp.widget.ListView.a gYT;
    private com.baidu.adp.widget.ListView.a gYU;
    private boolean gYV;
    private boolean gYW;
    private com.baidu.adp.widget.ListView.r gYl;
    private List<com.baidu.adp.widget.ListView.m> gYm;
    private a gYn;
    private z gYo;
    private n gYp;
    private w gYq;
    private i gYr;
    private j gYs;
    private k gYt;
    private q gYu;
    private h gYv;
    private g gYw;
    private f gYx;
    private x gYy;
    private e gYz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener gAB = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.bMn();
                if (ab.this.gYm != null) {
                    ab.this.ad(ab.this.gYm);
                }
            }
        }
    };
    private CustomMessageListener cVS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.at(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cMz = true;
                ab.this.at(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.cMz = false;
                ab.this.at(bVar);
            }
        }
    };
    private CustomMessageListener fDT = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Br;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Br = ab.this.Br(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Br));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gQO = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.gYl = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eM(context);
        b(rVar);
        rVar.addAdapters(this.gQO);
    }

    private void eM(Context context) {
        this.gYn = new a(this.mPageContext);
        this.gYo = new z(this.mPageContext);
        this.gYp = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.gYq = new w(this.mPageContext, com.baidu.tieba.card.data.k.fHq);
        this.gYr = new i(this.mPageContext, com.baidu.tieba.card.data.k.fHw);
        this.gYs = new j(this.mPageContext, com.baidu.tieba.card.data.k.fHx);
        this.gYt = new k(this.mPageContext, com.baidu.tieba.card.data.k.fHy);
        this.gYu = new q(this.mPageContext, com.baidu.tieba.card.data.k.fHz);
        this.gYv = new h(this.mPageContext, com.baidu.tieba.card.data.k.fHr);
        this.gYw = new g(this.mPageContext, com.baidu.tieba.card.data.k.fHt);
        this.gYx = new f(this.mPageContext, com.baidu.tieba.card.data.k.fHu);
        this.gYy = new x(this.mPageContext, com.baidu.tieba.card.data.l.cNl);
        this.gYA = new m(this.mPageContext, com.baidu.tieba.card.data.k.cNj);
        this.gYB = new y(this.mPageContext, com.baidu.tieba.card.data.l.fHG);
        this.gYC = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.gYD = new u(this.mPageContext, com.baidu.tieba.card.data.k.cNp);
        this.gYE = new t(this.mPageContext, com.baidu.tieba.card.data.k.cNq);
        this.gYF = new v(this.mPageContext, com.baidu.tieba.card.data.k.cNs);
        this.gYG = new s(this.mPageContext, com.baidu.tieba.card.data.k.cNr);
        this.gYH = new n(this.mPageContext, com.baidu.tieba.card.data.k.fHo);
        this.gYI = new y(this.mPageContext, com.baidu.tieba.card.data.l.fHH);
        this.gYJ = new l(this.mPageContext, com.baidu.tieba.card.data.k.fHp);
        this.gYK = new o(this.mPageContext, com.baidu.tieba.card.data.k.cNw);
        this.gYL = new p(this.mPageContext, com.baidu.tieba.card.data.k.cNx);
        this.gYM = new r(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hbS);
        this.gYN = new c(this.mPageContext, com.baidu.tieba.card.data.e.fGR);
        this.gYN.setFrom(0);
        this.gYz = new e(this.mPageContext, com.baidu.tieba.card.data.k.fHv);
        this.gQO.add(this.gYn);
        this.gQO.add(this.gYo);
        this.gQO.add(this.gYB);
        this.gQO.add(this.gYp);
        this.gQO.add(this.gYq);
        this.gQO.add(this.gYr);
        this.gQO.add(this.gYs);
        this.gQO.add(this.gYt);
        this.gQO.add(this.gYu);
        this.gQO.add(this.gYv);
        this.gQO.add(this.gYw);
        this.gQO.add(this.gYx);
        this.gQO.add(this.gYy);
        this.gQO.add(this.gYA);
        this.gQO.add(this.gYH);
        this.gQO.add(this.gYI);
        this.gQO.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gQO.add(this.gYC);
        this.gQO.add(this.gYD);
        this.gQO.add(this.gYE);
        this.gQO.add(this.gYG);
        this.gQO.add(this.gYF);
        this.gQO.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.TYPE));
        this.gQO.add(this.gYJ);
        this.gQO.add(this.gYK);
        this.gQO.add(this.gYL);
        this.gQO.add(this.gYM);
        this.gQO.add(this.gYN);
        this.gQO.add(this.gYz);
        bMm();
        bMl();
        wq("page_recommend");
    }

    private void bMl() {
        if (!bj.cNA.get()) {
            AdvertAppInfo.cIE.set(false);
            return;
        }
        this.gYO = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cIv);
        this.gYP = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cIy);
        this.gYQ = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cIz);
        this.gYR = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cIA);
        this.gYS = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cIB);
        this.gYT = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cIC);
        this.gYU = com.baidu.tieba.recapp.r.czO().c(this.mPageContext, AdvertAppInfo.cID);
        this.gQO.add(this.gYO);
        this.gQO.add(this.gYP);
        this.gQO.add(this.gYQ);
        this.gQO.add(this.gYR);
        this.gQO.add(this.gYS);
        this.gQO.add(this.gYT);
        this.gQO.add(this.gYU);
        AdvertAppInfo.cIE.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gYp.a(eVar);
        this.gYq.a(eVar);
        this.gYr.a(eVar);
        this.gYt.a(eVar);
        this.gYu.a(eVar);
        this.gYv.a(eVar);
        this.gYw.a(eVar);
        this.gYx.a(eVar);
        this.gYy.a(eVar);
        this.gYz.a(eVar);
        this.gYB.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.gYq.b(rVar);
        this.gYr.b(rVar);
        this.gYs.b(rVar);
        this.gYt.b(rVar);
        this.gYu.b(rVar);
        this.gYv.b(rVar);
        this.gYw.b(rVar);
        this.gYx.b(rVar);
        this.gYz.b(rVar);
        this.gYy.b(rVar);
        this.gYN.b(rVar);
        this.gYE.b(rVar);
        this.gYE.b(rVar);
        this.gYG.b(rVar);
    }

    public void ad(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.n(list, 2);
        this.gYl.setData(list);
        this.gYm = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.gYn.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.gYl != null) {
            this.gYl.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.gYp != null) {
            this.gYp.setFromCDN(z);
            this.gYH.setFromCDN(z);
            this.gYB.setFromCDN(z);
            this.gYI.setFromCDN(z);
            this.gYA.setFromCDN(z);
            this.gYD.setFromCDN(z);
        }
        if (this.gYt != null) {
            this.gYt.setFromCDN(z);
        }
        if (this.gYz != null) {
            this.gYz.setFromCDN(z);
        }
        if (this.gYP != null && (this.gYP instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gYP).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gYp != null) {
            this.gYp.dwY = bdUniqueId;
        }
        if (this.gYq != null) {
            this.gYq.dwY = bdUniqueId;
        }
        if (this.gYr != null) {
            this.gYr.dwY = bdUniqueId;
        }
        if (this.gYs != null) {
            this.gYs.dwY = bdUniqueId;
        }
        if (this.gYt != null) {
            this.gYt.dwY = bdUniqueId;
        }
        if (this.gYu != null) {
            this.gYu.dwY = bdUniqueId;
        }
        if (this.gYv != null) {
            this.gYv.dwY = bdUniqueId;
        }
        if (this.gYw != null) {
            this.gYw.dwY = bdUniqueId;
        }
        if (this.gYx != null) {
            this.gYx.dwY = bdUniqueId;
        }
        if (this.gYA != null) {
            this.gYA.dwY = bdUniqueId;
        }
        if (this.gYB != null) {
            this.gYB.dwY = bdUniqueId;
        }
        if (this.gYy != null) {
            this.gYy.dwY = bdUniqueId;
        }
        if (this.gYn != null) {
            this.gYn.setPageUniqueId(bdUniqueId);
        }
        if (this.gYC != null) {
            this.gYC.dwY = bdUniqueId;
        }
        if (this.gYD != null) {
            this.gYD.dwY = bdUniqueId;
        }
        if (this.gYE != null) {
            this.gYE.dwY = bdUniqueId;
        }
        if (this.gYG != null) {
            this.gYG.dwY = bdUniqueId;
        }
        if (this.gYF != null) {
            this.gYF.dwY = bdUniqueId;
        }
        if (this.gYH != null) {
            this.gYH.dwY = bdUniqueId;
        }
        if (this.gYI != null) {
            this.gYI.dwY = bdUniqueId;
        }
        if (this.gYK != null) {
            this.gYK.dwY = bdUniqueId;
        }
        if (this.gYL != null) {
            this.gYL.dwY = bdUniqueId;
        }
        if (this.gYM != null) {
            this.gYM.dwY = bdUniqueId;
        }
        if (this.gYN != null) {
            this.gYN.dwY = bdUniqueId;
        }
        if (this.gYz != null) {
            this.gYz.dwY = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gAz)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gAz) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.cVS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cVS);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.fDT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fDT);
        if (!this.gYW) {
            this.gAB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gAB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.gYm != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gYm.iterator();
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

    private void bMm() {
        this.gYW = bMn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMn() {
        if (this.gAz == null || this.gAz.size() <= 0) {
            this.gAz = new ArrayList();
            ArrayList<BdUniqueId> cHG = com.baidu.tieba.tbadkCore.s.cHG();
            if (cHG == null || cHG.size() <= 0) {
                return false;
            }
            int size = cHG.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cay().a(this.mPageContext, cHG.get(i), 2);
                if (this.gYV) {
                    a.setBusinessType(3);
                }
                if (this.gYp != null && this.gYp.dwY != null) {
                    a.setUniqueId(this.gYp.dwY);
                }
                this.gAz.add(a);
            }
            this.gYl.addAdapters(this.gAz);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gYp != null) {
            this.gYp.setEventCallback(aVar);
        }
        if (this.gYu != null) {
            this.gYu.setEventCallback(aVar);
        }
        if (this.gYs != null) {
            this.gYs.setEventCallback(aVar);
        }
        if (this.gYA != null) {
            this.gYA.setEventCallback(aVar);
        }
        if (this.gYB != null) {
            this.gYB.setEventCallback(aVar);
        }
        if (this.gYC != null) {
            this.gYC.setEventCallback(aVar);
        }
        if (this.gYD != null) {
            this.gYD.setEventCallback(aVar);
        }
        if (this.gYE != null) {
            this.gYE.setEventCallback(aVar);
        }
        if (this.gYG != null) {
            this.gYG.setEventCallback(aVar);
        }
        if (this.gYF != null) {
            this.gYF.setEventCallback(aVar);
        }
        if (this.gYH != null) {
            this.gYH.setEventCallback(aVar);
        }
        if (this.gYI != null) {
            this.gYI.setEventCallback(aVar);
        }
        if (this.gYK != null) {
            this.gYK.setEventCallback(aVar);
        }
        if (this.gYL != null) {
            this.gYL.setEventCallback(aVar);
        }
        if (this.gYM != null) {
            this.gYM.setEventCallback(aVar);
        }
        if (this.gYN != null) {
            this.gYN.setEventCallback(aVar);
        }
    }

    private void wq(String str) {
        if (this.gQO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gQO) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wq(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).fGP) != null && advertAppInfo.axG() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Br(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.gYm == null || this.gYm.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.gYm.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.gYm.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.f ? i3 + 1 : i3;
            if (this.gYm.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.gYm.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.gYm.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.gYm.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.gYm.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.gYm.get(i4)) != null && lVar.cMR != null && str.equals(lVar.cMR.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.gYm.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aw(i6 - i >= -1 ? i6 - i : -1);
        bVar.ax(i7);
        bVar.ay(i2);
        return bVar;
    }

    public void onPause() {
        if (this.gYB != null) {
            this.gYB.onPause();
        }
        if (this.gYI != null) {
            this.gYI.onPause();
        }
        if (this.gYy != null) {
            this.gYy.onPause();
        }
    }

    public void onResume() {
        if (this.gYB != null) {
            this.gYB.onResume();
        }
        if (this.gYI != null) {
            this.gYI.onResume();
        }
        if (this.gYy != null) {
            this.gYy.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.gYB != null) {
            this.gYB.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gYm;
    }
}
