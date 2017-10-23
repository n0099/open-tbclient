package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private BdTypeListView aUi;
    private List<com.baidu.adp.widget.ListView.f> cZN;
    private a cZO;
    private n cZP;
    private com.baidu.adp.widget.ListView.a cZQ;
    private h cZR;
    private g cZS;
    private j cZT;
    private e cZU;
    private f cZV;
    private i cZW;
    private com.baidu.tieba.homepage.alalivelist.a.c cZX;
    private com.baidu.tieba.homepage.alalivelist.a.d cZY;
    private c cZZ;
    private List<com.baidu.adp.widget.ListView.a> cvM;
    private com.baidu.adp.widget.ListView.a czD;
    private b daa;
    private boolean dab;
    private boolean dac;
    private TbPageContext<?> mH;
    private CustomMessageListener cvV = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.aiX();
                if (o.this.cZN != null) {
                    o.this.br(o.this.cZN);
                }
            }
        }
    };
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.o.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BZ) {
                o.this.P(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.o.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dXE = true;
                o.this.P(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.o.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dXE = false;
                o.this.P(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cUV = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aUi = bdTypeListView;
        this.mH = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bs(context);
        bdTypeListView.addAdapters(this.cUV);
    }

    private void bs(Context context) {
        this.cZO = new a(this.mH);
        this.cZP = new n(this.mH);
        this.czD = r.bfO().c(this.mH, AdvertAppInfo.TI);
        this.cZQ = r.bfO().c(this.mH, AdvertAppInfo.TL);
        this.cZR = new h(this.mH, com.baidu.tieba.card.data.l.TYPE);
        this.cZS = new g(this.mH, com.baidu.tieba.card.data.l.XX);
        this.cZT = new j(this.mH, com.baidu.tieba.card.data.n.bNz);
        this.daa = new b(this.mH, com.baidu.tieba.card.data.m.TYPE);
        this.cZU = new e(this.mH, com.baidu.tieba.card.data.l.bNs);
        this.cZV = new f(this.mH, com.baidu.tieba.card.data.n.bNA);
        this.cZW = new i(this.mH);
        this.cZX = new com.baidu.tieba.homepage.alalivelist.a.c(this.mH, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.cZY = new com.baidu.tieba.homepage.alalivelist.a.d(this.mH, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cZZ = new c(this.mH, com.baidu.tieba.card.data.k.TYPE);
        this.cUV.add(this.cZO);
        this.cUV.add(this.cZP);
        this.cUV.add(this.czD);
        this.cUV.add(this.cZQ);
        this.cUV.add(this.cZT);
        this.cUV.add(this.cZR);
        this.cUV.add(this.cZS);
        this.cUV.add(this.daa);
        this.cUV.add(this.cZU);
        this.cUV.add(this.cZV);
        this.cUV.add(new m(this.mH.getPageActivity()));
        this.cUV.add(new l(this.mH.getPageActivity()));
        this.cUV.add(this.cZW);
        this.cUV.add(new com.baidu.tieba.homepage.personalize.b.b(this.mH, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.cUV.add(this.cZX);
        this.cUV.add(this.cZY);
        this.cUV.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.mH, com.baidu.tieba.homepage.alalivelist.a.b.cUy));
        this.cUV.add(this.cZZ);
        aiW();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cZR.a(eVar);
        this.cZT.a(eVar);
        this.cZU.a(eVar);
        this.cZV.a(eVar);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.p(list, 2);
        this.aUi.setData(list);
        this.cZN = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cZO.onChangeSkinType(i);
        this.cZW.lf(i);
    }

    public void notifyDataSetChanged() {
        if (this.aUi != null && (this.aUi.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cZR != null) {
            this.cZR.setFromCDN(z);
        }
        if (this.cZU != null) {
            this.cZU.setFromCDN(z);
        }
        if (this.cZQ != null && (this.cZQ instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cZQ).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cZR != null) {
            this.cZR.aPk = bdUniqueId;
        }
        if (this.cZS != null) {
            this.cZS.aPk = bdUniqueId;
        }
        if (this.cZT != null) {
            this.cZT.aPk = bdUniqueId;
        }
        if (this.daa != null) {
            this.daa.aPk = bdUniqueId;
        }
        if (this.cZO != null) {
            this.cZO.setPageUniqueId(bdUniqueId);
        }
        if (this.cZU != null) {
            this.cZU.aPk = bdUniqueId;
        }
        if (this.cZV != null) {
            this.cZV.aPk = bdUniqueId;
        }
        if (this.cZW != null) {
            this.cZW.aPk = bdUniqueId;
        }
        if (this.cZX != null) {
            this.cZX.aPk = bdUniqueId;
        }
        if (this.cZY != null) {
            this.cZY.aPk = bdUniqueId;
        }
        if (this.cZZ != null) {
            this.cZZ.aPk = bdUniqueId;
        }
        if (!v.u(this.cvM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cvM) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.aoH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aoH);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.dac) {
            this.cvV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.cZN != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.cZN.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
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

    private void aiW() {
        this.dac = aiX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiX() {
        if (this.cvM == null || this.cvM.size() <= 0) {
            this.cvM = new ArrayList();
            ArrayList<BdUniqueId> bqz = com.baidu.tieba.tbadkCore.n.bqz();
            if (bqz == null || bqz.size() <= 0) {
                return false;
            }
            int size = bqz.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEU().a(this.mH, bqz.get(i), 2);
                if (this.dab) {
                    a.setBusinessType(3);
                }
                if (this.cZR != null && this.cZR.aPk != null) {
                    a.setUniqueId(this.cZR.aPk);
                }
                this.cvM.add(a);
            }
            this.aUi.addAdapters(this.cvM);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.cZR != null) {
            this.cZR.setEventCallback(aVar);
        }
        if (this.cZS != null) {
            this.cZS.setEventCallback(aVar);
        }
        if (this.daa != null) {
            this.daa.setEventCallback(aVar);
        }
        if (this.cZT != null) {
            this.cZT.setEventCallback(aVar);
        }
        if (this.cZZ != null) {
            this.cZZ.setEventCallback(aVar);
        }
    }
}
