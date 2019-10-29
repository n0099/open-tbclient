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
    private List<com.baidu.adp.widget.ListView.a> fNd;
    private com.baidu.adp.widget.ListView.r glD;
    private List<com.baidu.adp.widget.ListView.m> glE;
    private a glF;
    private u glG;
    private k glH;
    private r glI;
    private g glJ;
    private h glK;
    private o glL;
    private f glM;
    private e glN;
    private d glO;
    private s glP;
    private j glQ;
    private t glR;
    private l glS;
    private b glT;
    private q glU;
    private k glV;
    private t glW;
    private i glX;
    private m glY;
    private n glZ;
    private p gma;
    private com.baidu.adp.widget.ListView.a gmb;
    private com.baidu.adp.widget.ListView.a gmc;
    private com.baidu.adp.widget.ListView.a gmd;
    private com.baidu.adp.widget.ListView.a gme;
    private com.baidu.adp.widget.ListView.a gmf;
    private com.baidu.adp.widget.ListView.a gmg;
    private com.baidu.adp.widget.ListView.a gmh;
    private boolean gmi;
    private boolean gmj;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fNf = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.w.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                w.this.bvb();
                if (w.this.glE != null) {
                    w.this.aY(w.this.glE);
                }
            }
        }
    };
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.w.2
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
                bVar.caZ = true;
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
                bVar.caZ = false;
                w.this.ao(bVar);
            }
        }
    };
    private CustomMessageListener eMU = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.w.5
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
    private List<com.baidu.adp.widget.ListView.a> gdB = new ArrayList();

    public w(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.glD = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        dt(context);
        b(rVar);
        rVar.addAdapters(this.gdB);
    }

    private void dt(Context context) {
        this.glF = new a(this.mPageContext);
        this.glG = new u(this.mPageContext);
        this.glH = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.glI = new r(this.mPageContext, com.baidu.tieba.card.data.k.eQp);
        this.glJ = new g(this.mPageContext, com.baidu.tieba.card.data.k.eQu);
        this.glK = new h(this.mPageContext, com.baidu.tieba.card.data.k.eQv);
        this.glL = new o(this.mPageContext, com.baidu.tieba.card.data.k.eQw);
        this.glM = new f(this.mPageContext, com.baidu.tieba.card.data.k.eQq);
        this.glN = new e(this.mPageContext, com.baidu.tieba.card.data.k.eQs);
        this.glO = new d(this.mPageContext, com.baidu.tieba.card.data.k.eQt);
        this.glP = new s(this.mPageContext, com.baidu.tieba.card.data.l.cbI);
        this.glQ = new j(this.mPageContext, com.baidu.tieba.card.data.k.cbG);
        this.glR = new t(this.mPageContext, com.baidu.tieba.card.data.l.eQC);
        this.glS = new l(this.mPageContext);
        this.glT = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.glU = new q(this.mPageContext, com.baidu.tieba.card.data.k.cbM);
        this.glV = new k(this.mPageContext, com.baidu.tieba.card.data.k.eQn);
        this.glW = new t(this.mPageContext, com.baidu.tieba.card.data.l.eQD);
        this.glX = new i(this.mPageContext, com.baidu.tieba.card.data.k.eQo);
        this.glY = new m(this.mPageContext, com.baidu.tieba.card.data.k.cbQ);
        this.glZ = new n(this.mPageContext, com.baidu.tieba.card.data.k.cbR);
        this.gma = new p(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.gpi);
        this.gdB.add(this.glF);
        this.gdB.add(this.glG);
        this.gdB.add(this.glR);
        this.gdB.add(this.glH);
        this.gdB.add(this.glI);
        this.gdB.add(this.glJ);
        this.gdB.add(this.glK);
        this.gdB.add(this.glL);
        this.gdB.add(this.glM);
        this.gdB.add(this.glN);
        this.gdB.add(this.glO);
        this.gdB.add(this.glP);
        this.gdB.add(this.glQ);
        this.gdB.add(this.glS);
        this.gdB.add(this.glV);
        this.gdB.add(this.glW);
        this.gdB.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gdB.add(this.glT);
        this.gdB.add(this.glU);
        this.gdB.add(new v(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.gdB.add(this.glX);
        this.gdB.add(this.glY);
        this.gdB.add(this.glZ);
        this.gdB.add(this.gma);
        bva();
        buZ();
        rh("page_recommend");
    }

    private void buZ() {
        if (!bh.cbU.get()) {
            AdvertAppInfo.bXi.set(false);
            return;
        }
        this.gmb = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bWZ);
        this.gmc = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bXc);
        this.gmd = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bXd);
        this.gme = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bXe);
        this.gmf = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bXf);
        this.gmg = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bXg);
        this.gmh = com.baidu.tieba.recapp.r.cfL().c(this.mPageContext, AdvertAppInfo.bXh);
        this.gdB.add(this.gmb);
        this.gdB.add(this.gmc);
        this.gdB.add(this.gmd);
        this.gdB.add(this.gme);
        this.gdB.add(this.gmf);
        this.gdB.add(this.gmg);
        this.gdB.add(this.gmh);
        AdvertAppInfo.bXi.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.glH.a(eVar);
        this.glI.a(eVar);
        this.glJ.a(eVar);
        this.glK.a(eVar);
        this.glL.a(eVar);
        this.glM.a(eVar);
        this.glN.a(eVar);
        this.glO.a(eVar);
        this.glP.a(eVar);
        this.glR.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.glI.b(rVar);
        this.glJ.b(rVar);
        this.glK.b(rVar);
        this.glL.b(rVar);
        this.glM.b(rVar);
        this.glN.b(rVar);
        this.glO.b(rVar);
        this.glP.b(rVar);
    }

    public void aY(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.n(list, 2);
        this.glD.setData(list);
        this.glE = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.glF.onChangeSkinType(i);
        this.glS.tg(i);
    }

    public void notifyDataSetChanged() {
        if (this.glD != null) {
            this.glD.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.glH != null) {
            this.glH.setFromCDN(z);
            this.glV.setFromCDN(z);
            this.glR.setFromCDN(z);
            this.glW.setFromCDN(z);
            this.glQ.setFromCDN(z);
            this.glU.setFromCDN(z);
        }
        if (this.glK != null) {
            this.glK.setFromCDN(z);
        }
        if (this.gmc != null && (this.gmc instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.gmc).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.glH != null) {
            this.glH.cKf = bdUniqueId;
        }
        if (this.glI != null) {
            this.glI.cKf = bdUniqueId;
        }
        if (this.glJ != null) {
            this.glJ.cKf = bdUniqueId;
        }
        if (this.glK != null) {
            this.glK.cKf = bdUniqueId;
        }
        if (this.glL != null) {
            this.glL.cKf = bdUniqueId;
        }
        if (this.glM != null) {
            this.glM.cKf = bdUniqueId;
        }
        if (this.glN != null) {
            this.glN.cKf = bdUniqueId;
        }
        if (this.glO != null) {
            this.glO.cKf = bdUniqueId;
        }
        if (this.glQ != null) {
            this.glQ.cKf = bdUniqueId;
        }
        if (this.glR != null) {
            this.glR.cKf = bdUniqueId;
        }
        if (this.glP != null) {
            this.glP.cKf = bdUniqueId;
        }
        if (this.glF != null) {
            this.glF.setPageUniqueId(bdUniqueId);
        }
        if (this.glS != null) {
            this.glS.cKf = bdUniqueId;
        }
        if (this.glT != null) {
            this.glT.cKf = bdUniqueId;
        }
        if (this.glU != null) {
            this.glU.cKf = bdUniqueId;
        }
        if (this.glV != null) {
            this.glV.cKf = bdUniqueId;
        }
        if (this.glW != null) {
            this.glW.cKf = bdUniqueId;
        }
        if (this.glY != null) {
            this.glY.cKf = bdUniqueId;
        }
        if (this.glZ != null) {
            this.glZ.cKf = bdUniqueId;
        }
        if (this.gma != null) {
            this.gma.cKf = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fNd)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fNd) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.cjZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cjZ);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.eMU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eMU);
        if (!this.gmj) {
            this.fNf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fNf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.glE != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.glE.iterator();
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

    private void bva() {
        this.gmj = bvb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvb() {
        if (this.fNd == null || this.fNd.size() <= 0) {
            this.fNd = new ArrayList();
            ArrayList<BdUniqueId> cnD = com.baidu.tieba.tbadkCore.s.cnD();
            if (cnD == null || cnD.size() <= 0) {
                return false;
            }
            int size = cnD.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bJn().a(this.mPageContext, cnD.get(i), 2);
                if (this.gmi) {
                    a.setBusinessType(3);
                }
                if (this.glH != null && this.glH.cKf != null) {
                    a.setUniqueId(this.glH.cKf);
                }
                this.fNd.add(a);
            }
            this.glD.addAdapters(this.fNd);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.glH != null) {
            this.glH.setEventCallback(aVar);
        }
        if (this.glI != null) {
            this.glI.setEventCallback(aVar);
        }
        if (this.glQ != null) {
            this.glQ.setEventCallback(aVar);
        }
        if (this.glR != null) {
            this.glR.setEventCallback(aVar);
        }
        if (this.glT != null) {
            this.glT.setEventCallback(aVar);
        }
        if (this.glU != null) {
            this.glU.setEventCallback(aVar);
        }
        if (this.glV != null) {
            this.glV.setEventCallback(aVar);
        }
        if (this.glW != null) {
            this.glW.setEventCallback(aVar);
        }
        if (this.glY != null) {
            this.glY.setEventCallback(aVar);
        }
        if (this.glZ != null) {
            this.glZ.setEventCallback(aVar);
        }
        if (this.gma != null) {
            this.gma.setEventCallback(aVar);
        }
    }

    private void rh(String str) {
        if (this.gdB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gdB) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).ePS) != null && advertAppInfo.agR() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b wC(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.glE == null || this.glE.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.glE.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.glE.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.glE.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.glE.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.glE.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.glE.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.glE.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.glE.get(i4)) != null && lVar.cbq != null && str.equals(lVar.cbq.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.glE.get(i4)).position;
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
        if (this.glR != null) {
            this.glR.onPause();
        }
        if (this.glW != null) {
            this.glW.onPause();
        }
        if (this.glP != null) {
            this.glP.onPause();
        }
    }

    public void onResume() {
        if (this.glR != null) {
            this.glR.onResume();
        }
        if (this.glW != null) {
            this.glW.onResume();
        }
        if (this.glP != null) {
            this.glP.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.glR != null) {
            this.glR.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.glE;
    }
}
