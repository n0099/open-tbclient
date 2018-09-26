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
/* loaded from: classes2.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dAa;
    private com.baidu.adp.widget.ListView.a dIN;
    private m efR;
    private List<com.baidu.adp.widget.ListView.h> efS;
    private a efT;
    private j efU;
    private f efV;
    private e efW;
    private i efX;
    private g efY;
    private b efZ;
    private h ega;
    private f egb;
    private i egc;
    private d egd;
    private com.baidu.adp.widget.ListView.a ege;
    private com.baidu.adp.widget.ListView.a egf;
    private com.baidu.adp.widget.ListView.a egg;
    private com.baidu.adp.widget.ListView.a egh;
    private com.baidu.adp.widget.ListView.a egi;
    private com.baidu.adp.widget.ListView.a egj;
    private boolean egk;
    private boolean egl;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dAj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.azk();
                if (l.this.efS != null) {
                    l.this.aj(l.this.efS);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().IM) {
                l.this.ab(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.l.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.ajP = true;
                l.this.ab(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.l.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.ajP = false;
                l.this.ab(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dZJ = new ArrayList();

    public l(Context context, m mVar) {
        this.efR = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        cg(context);
        mVar.addAdapters(this.dZJ);
    }

    private void cg(Context context) {
        this.efT = new a(this.mPageContext);
        this.efU = new j(this.mPageContext);
        this.efV = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.efW = new e(this.mPageContext, com.baidu.tieba.card.data.k.ajY);
        this.efX = new i(this.mPageContext, com.baidu.tieba.card.data.l.cIb);
        this.efY = new g(this.mPageContext);
        this.efZ = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ega = new h(this.mPageContext, com.baidu.tieba.card.data.k.ake);
        this.egb = new f(this.mPageContext, com.baidu.tieba.card.data.k.cHX);
        this.egc = new i(this.mPageContext, com.baidu.tieba.card.data.l.cIc);
        this.egd = new d(this.mPageContext, com.baidu.tieba.card.data.k.cHY);
        this.dZJ.add(this.efT);
        this.dZJ.add(this.efU);
        this.dZJ.add(this.efX);
        this.dZJ.add(this.efV);
        this.dZJ.add(this.efW);
        this.dZJ.add(this.efY);
        this.dZJ.add(this.egb);
        this.dZJ.add(this.egc);
        this.dZJ.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dZJ.add(this.efZ);
        this.dZJ.add(this.ega);
        this.dZJ.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.dZJ.add(this.egd);
        azj();
        aGK();
        jd("page_recommend");
    }

    private void aGK() {
        if (!bb.akj.get()) {
            AdvertAppInfo.agc.set(false);
            return;
        }
        this.dIN = r.bpV().c(this.mPageContext, AdvertAppInfo.afT);
        this.ege = r.bpV().c(this.mPageContext, AdvertAppInfo.afW);
        this.egf = r.bpV().c(this.mPageContext, AdvertAppInfo.afX);
        this.egg = r.bpV().c(this.mPageContext, AdvertAppInfo.afY);
        this.egh = r.bpV().c(this.mPageContext, AdvertAppInfo.afZ);
        this.egi = r.bpV().c(this.mPageContext, AdvertAppInfo.aga);
        this.egj = r.bpV().c(this.mPageContext, AdvertAppInfo.agb);
        this.dZJ.add(this.dIN);
        this.dZJ.add(this.ege);
        this.dZJ.add(this.egf);
        this.dZJ.add(this.egg);
        this.dZJ.add(this.egh);
        this.dZJ.add(this.egi);
        this.dZJ.add(this.egj);
        AdvertAppInfo.agc.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efV.a(eVar);
        this.efX.a(eVar);
    }

    public void aj(List<com.baidu.adp.widget.ListView.h> list) {
        q.p(list, 2);
        this.efR.setData(list);
        this.efS = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.efT.onChangeSkinType(i);
        this.efY.nx(i);
    }

    public void notifyDataSetChanged() {
        if (this.efR != null) {
            this.efR.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.efV != null) {
            this.efV.setFromCDN(z);
        }
        if (this.ege != null && (this.ege instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ege).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.efV != null) {
            this.efV.aUU = bdUniqueId;
        }
        if (this.efW != null) {
            this.efW.aUU = bdUniqueId;
        }
        if (this.efX != null) {
            this.efX.aUU = bdUniqueId;
        }
        if (this.efT != null) {
            this.efT.setPageUniqueId(bdUniqueId);
        }
        if (this.efY != null) {
            this.efY.aUU = bdUniqueId;
        }
        if (this.efZ != null) {
            this.efZ.aUU = bdUniqueId;
        }
        if (this.ega != null) {
            this.ega.aUU = bdUniqueId;
        }
        if (this.egb != null) {
            this.egb.aUU = bdUniqueId;
        }
        if (this.egc != null) {
            this.egc.aUU = bdUniqueId;
        }
        if (!v.z(this.dAa)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dAa) {
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
        if (!this.egl) {
            this.dAj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dAj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.efS != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.efS.iterator();
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

    private void azj() {
        this.egl = azk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azk() {
        if (this.dAa == null || this.dAa.size() <= 0) {
            this.dAa = new ArrayList();
            ArrayList<BdUniqueId> bxZ = q.bxZ();
            if (bxZ == null || bxZ.size() <= 0) {
                return false;
            }
            int size = bxZ.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aUT().a(this.mPageContext, bxZ.get(i), 2);
                if (this.egk) {
                    a.setBusinessType(3);
                }
                if (this.efV != null && this.efV.aUU != null) {
                    a.setUniqueId(this.efV.aUU);
                }
                this.dAa.add(a);
            }
            this.efR.addAdapters(this.dAa);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.efV != null) {
            this.efV.setEventCallback(aVar);
        }
        if (this.efW != null) {
            this.efW.setEventCallback(aVar);
        }
        if (this.efX != null) {
            this.efX.setEventCallback(aVar);
        }
        if (this.efZ != null) {
            this.efZ.setEventCallback(aVar);
        }
        if (this.ega != null) {
            this.ega.setEventCallback(aVar);
        }
        if (this.egb != null) {
            this.egb.setEventCallback(aVar);
        }
        if (this.egc != null) {
            this.egc.setEventCallback(aVar);
        }
    }

    private void jd(String str) {
        if (this.dZJ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dZJ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jd(str);
                }
            }
        }
    }
}
