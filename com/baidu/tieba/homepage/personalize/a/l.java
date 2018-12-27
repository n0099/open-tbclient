package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dSv;
    private com.baidu.adp.widget.ListView.a ebh;
    private m eyS;
    private List<com.baidu.adp.widget.ListView.h> eyT;
    private a eyU;
    private j eyV;
    private f eyW;
    private e eyX;
    private i eyY;
    private g eyZ;
    private BdUniqueId eyg;
    private b eza;
    private h ezb;
    private f ezc;
    private i ezd;
    private d eze;
    private com.baidu.adp.widget.ListView.a ezf;
    private com.baidu.adp.widget.ListView.a ezg;
    private com.baidu.adp.widget.ListView.a ezh;
    private com.baidu.adp.widget.ListView.a ezi;
    private com.baidu.adp.widget.ListView.a ezj;
    private com.baidu.adp.widget.ListView.a ezk;
    private boolean ezl;
    private boolean ezm;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dSF = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aEz();
                if (l.this.eyT != null) {
                    l.this.ak(l.this.eyT);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jr) {
                l.this.ae(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener dSH = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.homepage.personalize.a.l.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) customResponsedMessage.getData();
            if (dVar != null) {
                AdvertAppInfo aqK = dVar.aqK();
                com.baidu.tieba.q.c.bBT().b(l.this.eyg, com.baidu.tieba.q.a.a(aqK, "a002", "common_click", 1, dVar.daz, true, aqK.apq, null));
            }
        }
    };
    private CustomMessageListener dSI = new CustomMessageListener(2921385) { // from class: com.baidu.tieba.homepage.personalize.a.l.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.card.data.d dVar = (com.baidu.tieba.card.data.d) customResponsedMessage.getData();
            if (dVar != null && dVar.daF != null) {
                AdvertAppInfo aqK = dVar.aqK();
                int i = dVar.daz;
                String str = aqK.apq;
                com.baidu.tieba.q.c.bBT().a(l.this.eyg, str, com.baidu.tieba.q.a.a(aqK, "a002", "common_exp", i, true, str, null));
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.l.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.asY = true;
                l.this.ae(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.l.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.asY = false;
                l.this.ae(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> esI = new ArrayList();

    public l(Context context, m mVar) {
        this.eyS = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        cs(context);
        mVar.addAdapters(this.esI);
    }

    private void cs(Context context) {
        this.eyU = new a(this.mPageContext);
        this.eyV = new j(this.mPageContext);
        this.eyW = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.eyX = new e(this.mPageContext, com.baidu.tieba.card.data.k.ath);
        this.eyY = new i(this.mPageContext, com.baidu.tieba.card.data.l.daZ);
        this.eyZ = new g(this.mPageContext);
        this.eza = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ezb = new h(this.mPageContext, com.baidu.tieba.card.data.k.atn);
        this.ezc = new f(this.mPageContext, com.baidu.tieba.card.data.k.daV);
        this.ezd = new i(this.mPageContext, com.baidu.tieba.card.data.l.dba);
        this.eze = new d(this.mPageContext, com.baidu.tieba.card.data.k.daW);
        this.esI.add(this.eyU);
        this.esI.add(this.eyV);
        this.esI.add(this.eyY);
        this.esI.add(this.eyW);
        this.esI.add(this.eyX);
        this.esI.add(this.eyZ);
        this.esI.add(this.ezc);
        this.esI.add(this.ezd);
        this.esI.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.esI.add(this.eza);
        this.esI.add(this.ezb);
        this.esI.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.esI.add(this.eze);
        aEy();
        aMf();
        jL("page_recommend");
    }

    private void aMf() {
        if (!bb.ats.get()) {
            AdvertAppInfo.apn.set(false);
            return;
        }
        this.ebh = r.bvk().c(this.mPageContext, AdvertAppInfo.ape);
        this.ezf = r.bvk().c(this.mPageContext, AdvertAppInfo.aph);
        this.ezg = r.bvk().c(this.mPageContext, AdvertAppInfo.api);
        this.ezh = r.bvk().c(this.mPageContext, AdvertAppInfo.apj);
        this.ezi = r.bvk().c(this.mPageContext, AdvertAppInfo.apk);
        this.ezj = r.bvk().c(this.mPageContext, AdvertAppInfo.apl);
        this.ezk = r.bvk().c(this.mPageContext, AdvertAppInfo.apm);
        this.esI.add(this.ebh);
        this.esI.add(this.ezf);
        this.esI.add(this.ezg);
        this.esI.add(this.ezh);
        this.esI.add(this.ezi);
        this.esI.add(this.ezj);
        this.esI.add(this.ezk);
        AdvertAppInfo.apn.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eyW.a(eVar);
        this.eyY.a(eVar);
    }

    public void ak(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.eyS.setData(list);
        this.eyT = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.eyU.onChangeSkinType(i);
        this.eyZ.oU(i);
    }

    public void notifyDataSetChanged() {
        if (this.eyS != null) {
            this.eyS.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.eyW != null) {
            this.eyW.setFromCDN(z);
        }
        if (this.ezf != null && (this.ezf instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ezf).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eyg = bdUniqueId;
        if (this.eyW != null) {
            this.eyW.bdH = bdUniqueId;
        }
        if (this.eyX != null) {
            this.eyX.bdH = bdUniqueId;
        }
        if (this.eyY != null) {
            this.eyY.bdH = bdUniqueId;
        }
        if (this.eyU != null) {
            this.eyU.setPageUniqueId(bdUniqueId);
        }
        if (this.eyZ != null) {
            this.eyZ.bdH = bdUniqueId;
        }
        if (this.eza != null) {
            this.eza.bdH = bdUniqueId;
        }
        if (this.ezb != null) {
            this.ezb.bdH = bdUniqueId;
        }
        if (this.ezc != null) {
            this.ezc.bdH = bdUniqueId;
        }
        if (this.ezd != null) {
            this.ezd.bdH = bdUniqueId;
        }
        if (!v.I(this.dSv)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dSv) {
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
        this.dSH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dSH);
        this.dSI.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dSI);
        if (!this.ezm) {
            this.dSF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dSF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.eyT != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.eyT.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
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

    private void aEy() {
        this.ezm = aEz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEz() {
        if (this.dSv == null || this.dSv.size() <= 0) {
            this.dSv = new ArrayList();
            ArrayList<BdUniqueId> bDw = q.bDw();
            if (bDw == null || bDw.size() <= 0) {
                return false;
            }
            int size = bDw.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bai().a(this.mPageContext, bDw.get(i), 2);
                if (this.ezl) {
                    a.setBusinessType(3);
                }
                if (this.eyW != null && this.eyW.bdH != null) {
                    a.setUniqueId(this.eyW.bdH);
                }
                this.dSv.add(a);
            }
            this.eyS.addAdapters(this.dSv);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.eyW != null) {
            this.eyW.setEventCallback(aVar);
        }
        if (this.eyX != null) {
            this.eyX.setEventCallback(aVar);
        }
        if (this.eyY != null) {
            this.eyY.setEventCallback(aVar);
        }
        if (this.eza != null) {
            this.eza.setEventCallback(aVar);
        }
        if (this.ezb != null) {
            this.ezb.setEventCallback(aVar);
        }
        if (this.ezc != null) {
            this.ezc.setEventCallback(aVar);
        }
        if (this.ezd != null) {
            this.ezd.setEventCallback(aVar);
        }
    }

    private void jL(String str) {
        if (this.esI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.esI) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jL(str);
                }
            }
        }
    }
}
