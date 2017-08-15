package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private BdTypeListView aTO;
    private b cWA;
    private boolean cWB;
    private boolean cWC;
    private List<com.baidu.adp.widget.ListView.f> cWn;
    private a cWo;
    private n cWp;
    private com.baidu.adp.widget.ListView.a cWq;
    private h cWr;
    private g cWs;
    private j cWt;
    private e cWu;
    private f cWv;
    private i cWw;
    private com.baidu.tieba.homepage.alalivelist.a.c cWx;
    private com.baidu.tieba.homepage.alalivelist.a.d cWy;
    private c cWz;
    private List<com.baidu.adp.widget.ListView.a> cnU;
    private com.baidu.adp.widget.ListView.a crC;
    private TbPageContext<?> oV;
    private CustomMessageListener coc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.b.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.ahh();
                if (o.this.cWn != null) {
                    o.this.br(o.this.cWn);
                }
            }
        }
    };
    private CustomMessageListener aqh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.b.o.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ec) {
                o.this.R(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.b.o.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dUe = true;
                o.this.R(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.b.o.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dUe = false;
                o.this.R(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cRC = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aTO = bdTypeListView;
        this.oV = (TbPageContext) com.baidu.adp.base.i.aa(context);
        bm(context);
        bdTypeListView.addAdapters(this.cRC);
    }

    private void bm(Context context) {
        this.cWo = new a(this.oV);
        this.cWp = new n(this.oV);
        this.crC = r.bil().c(this.oV, AdvertAppInfo.UE);
        this.cWq = r.bil().c(this.oV, AdvertAppInfo.UH);
        this.cWr = new h(this.oV, com.baidu.tieba.card.data.l.TYPE);
        this.cWs = new g(this.oV, com.baidu.tieba.card.data.l.Zd);
        this.cWt = new j(this.oV, com.baidu.tieba.card.data.n.bKw);
        this.cWA = new b(this.oV, com.baidu.tieba.card.data.m.TYPE);
        this.cWu = new e(this.oV, com.baidu.tieba.card.data.l.bKp);
        this.cWv = new f(this.oV, com.baidu.tieba.card.data.n.bKx);
        this.cWw = new i(this.oV);
        this.cWx = new com.baidu.tieba.homepage.alalivelist.a.c(this.oV, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.cWy = new com.baidu.tieba.homepage.alalivelist.a.d(this.oV, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cWz = new c(this.oV, com.baidu.tieba.card.data.k.TYPE);
        this.cRC.add(this.cWo);
        this.cRC.add(this.cWp);
        this.cRC.add(this.crC);
        this.cRC.add(this.cWq);
        this.cRC.add(this.cWt);
        this.cRC.add(this.cWr);
        this.cRC.add(this.cWs);
        this.cRC.add(this.cWA);
        this.cRC.add(this.cWu);
        this.cRC.add(this.cWv);
        this.cRC.add(new m(this.oV.getPageActivity()));
        this.cRC.add(new l(this.oV.getPageActivity()));
        this.cRC.add(this.cWw);
        this.cRC.add(new com.baidu.tieba.homepage.personalize.c.b(this.oV, com.baidu.tieba.homepage.personalize.c.c.TYPE));
        this.cRC.add(this.cWx);
        this.cRC.add(this.cWy);
        this.cRC.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.oV, com.baidu.tieba.homepage.alalivelist.a.b.cRg));
        this.cRC.add(this.cWz);
        ahg();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cWr.a(eVar);
        this.cWt.a(eVar);
        this.cWu.a(eVar);
        this.cWv.a(eVar);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.q(list, 2);
        this.aTO.setData(list);
        this.cWn = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cWo.onChangeSkinType(i);
        this.cWw.kR(i);
    }

    public void notifyDataSetChanged() {
        if (this.aTO != null && (this.aTO.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTO.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cWr != null) {
            this.cWr.setFromCDN(z);
        }
        if (this.cWu != null) {
            this.cWu.setFromCDN(z);
        }
        if (this.cWq != null && (this.cWq instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cWq).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cWr != null) {
            this.cWr.aON = bdUniqueId;
        }
        if (this.cWs != null) {
            this.cWs.aON = bdUniqueId;
        }
        if (this.cWt != null) {
            this.cWt.aON = bdUniqueId;
        }
        if (this.cWA != null) {
            this.cWA.aON = bdUniqueId;
        }
        if (this.cWo != null) {
            this.cWo.setPageUniqueId(bdUniqueId);
        }
        if (this.cWu != null) {
            this.cWu.aON = bdUniqueId;
        }
        if (this.cWv != null) {
            this.cWv.aON = bdUniqueId;
        }
        if (this.cWw != null) {
            this.cWw.aON = bdUniqueId;
        }
        if (this.cWx != null) {
            this.cWx.aON = bdUniqueId;
        }
        if (this.cWy != null) {
            this.cWy.aON = bdUniqueId;
        }
        if (this.cWz != null) {
            this.cWz.aON = bdUniqueId;
        }
        if (!u.v(this.cnU)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cnU) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.aqh.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aqh);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cWC) {
            this.coc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.coc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.cWn != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.cWn.iterator();
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

    private void ahg() {
        this.cWC = ahh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahh() {
        if (this.cnU == null || this.cnU.size() <= 0) {
            this.cnU = new ArrayList();
            ArrayList<BdUniqueId> bsq = com.baidu.tieba.tbadkCore.n.bsq();
            if (bsq == null || bsq.size() <= 0) {
                return false;
            }
            int size = bsq.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEp().a(this.oV, bsq.get(i), 2);
                if (this.cWB) {
                    a.setBusinessType(3);
                }
                if (this.cWr != null && this.cWr.aON != null) {
                    a.setUniqueId(this.cWr.aON);
                }
                this.cnU.add(a);
            }
            this.aTO.addAdapters(this.cnU);
            return true;
        }
        return true;
    }

    public void a(h.a aVar) {
        if (this.cWr != null) {
            this.cWr.setEventCallback(aVar);
        }
        if (this.cWs != null) {
            this.cWs.setEventCallback(aVar);
        }
        if (this.cWA != null) {
            this.cWA.setEventCallback(aVar);
        }
        if (this.cWt != null) {
            this.cWt.setEventCallback(aVar);
        }
        if (this.cWz != null) {
            this.cWz.setEventCallback(aVar);
        }
    }
}
