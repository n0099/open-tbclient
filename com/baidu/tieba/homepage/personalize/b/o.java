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
    private BdTypeListView aSB;
    private TbPageContext<?> ako;
    private List<com.baidu.adp.widget.ListView.f> cSV;
    private a cSW;
    private n cSX;
    private com.baidu.adp.widget.ListView.a cSY;
    private h cSZ;
    private g cTa;
    private j cTb;
    private e cTc;
    private f cTd;
    private i cTe;
    private com.baidu.tieba.homepage.alalivelist.a.c cTf;
    private com.baidu.tieba.homepage.alalivelist.a.d cTg;
    private c cTh;
    private b cTi;
    private boolean cTj;
    private boolean cTk;
    private List<com.baidu.adp.widget.ListView.a> clZ;
    private com.baidu.adp.widget.ListView.a cpI;
    private CustomMessageListener cmi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.b.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.agF();
                if (o.this.cSV != null) {
                    o.this.bo(o.this.cSV);
                }
            }
        }
    };
    private CustomMessageListener aoM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.b.o.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().CB) {
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
                bVar.dQR = true;
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
                bVar.dQR = false;
                o.this.R(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cOk = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aSB = bdTypeListView;
        this.ako = (TbPageContext) com.baidu.adp.base.i.Z(context);
        bm(context);
        bdTypeListView.addAdapters(this.cOk);
    }

    private void bm(Context context) {
        this.cSW = new a(this.ako);
        this.cSX = new n(this.ako);
        this.cpI = r.bhv().c(this.ako, AdvertAppInfo.Td);
        this.cSY = r.bhv().c(this.ako, AdvertAppInfo.Tg);
        this.cSZ = new h(this.ako, com.baidu.tieba.card.data.l.TYPE);
        this.cTa = new g(this.ako, com.baidu.tieba.card.data.l.XF);
        this.cTb = new j(this.ako, com.baidu.tieba.card.data.n.bID);
        this.cTi = new b(this.ako, com.baidu.tieba.card.data.m.TYPE);
        this.cTc = new e(this.ako, com.baidu.tieba.card.data.l.bIw);
        this.cTd = new f(this.ako, com.baidu.tieba.card.data.n.bIE);
        this.cTe = new i(this.ako);
        this.cTf = new com.baidu.tieba.homepage.alalivelist.a.c(this.ako, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.cTg = new com.baidu.tieba.homepage.alalivelist.a.d(this.ako, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cTh = new c(this.ako, com.baidu.tieba.card.data.k.TYPE);
        this.cOk.add(this.cSW);
        this.cOk.add(this.cSX);
        this.cOk.add(this.cpI);
        this.cOk.add(this.cSY);
        this.cOk.add(this.cTb);
        this.cOk.add(this.cSZ);
        this.cOk.add(this.cTa);
        this.cOk.add(this.cTi);
        this.cOk.add(this.cTc);
        this.cOk.add(this.cTd);
        this.cOk.add(new m(this.ako.getPageActivity()));
        this.cOk.add(new l(this.ako.getPageActivity()));
        this.cOk.add(this.cTe);
        this.cOk.add(new com.baidu.tieba.homepage.personalize.c.b(this.ako, com.baidu.tieba.homepage.personalize.c.c.TYPE));
        this.cOk.add(this.cTf);
        this.cOk.add(this.cTg);
        this.cOk.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.ako, com.baidu.tieba.homepage.alalivelist.a.b.cNO));
        this.cOk.add(this.cTh);
        agE();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cSZ.a(eVar);
        this.cTb.a(eVar);
        this.cTc.a(eVar);
        this.cTd.a(eVar);
    }

    public void bo(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.q(list, 2);
        this.aSB.setData(list);
        this.cSV = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cSW.onChangeSkinType(i);
        this.cTe.kH(i);
    }

    public void notifyDataSetChanged() {
        if (this.aSB != null && (this.aSB.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aSB.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cSZ != null) {
            this.cSZ.setFromCDN(z);
        }
        if (this.cTc != null) {
            this.cTc.setFromCDN(z);
        }
        if (this.cSY != null && (this.cSY instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cSY).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cSZ != null) {
            this.cSZ.aNy = bdUniqueId;
        }
        if (this.cTa != null) {
            this.cTa.aNy = bdUniqueId;
        }
        if (this.cTb != null) {
            this.cTb.aNy = bdUniqueId;
        }
        if (this.cTi != null) {
            this.cTi.aNy = bdUniqueId;
        }
        if (this.cSW != null) {
            this.cSW.setPageUniqueId(bdUniqueId);
        }
        if (this.cTc != null) {
            this.cTc.aNy = bdUniqueId;
        }
        if (this.cTd != null) {
            this.cTd.aNy = bdUniqueId;
        }
        if (this.cTe != null) {
            this.cTe.aNy = bdUniqueId;
        }
        if (this.cTf != null) {
            this.cTf.aNy = bdUniqueId;
        }
        if (this.cTg != null) {
            this.cTg.aNy = bdUniqueId;
        }
        if (this.cTh != null) {
            this.cTh.aNy = bdUniqueId;
        }
        if (!u.v(this.clZ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.clZ) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.aoM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aoM);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cTk) {
            this.cmi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cmi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.cSV != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.cSV.iterator();
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

    private void agE() {
        this.cTk = agF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agF() {
        if (this.clZ == null || this.clZ.size() <= 0) {
            this.clZ = new ArrayList();
            ArrayList<BdUniqueId> brB = com.baidu.tieba.tbadkCore.n.brB();
            if (brB == null || brB.size() <= 0) {
                return false;
            }
            int size = brB.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aDx().a(this.ako, brB.get(i), 2);
                if (this.cTj) {
                    a.setBusinessType(3);
                }
                if (this.cSZ != null && this.cSZ.aNy != null) {
                    a.setUniqueId(this.cSZ.aNy);
                }
                this.clZ.add(a);
            }
            this.aSB.addAdapters(this.clZ);
            return true;
        }
        return true;
    }

    public void a(h.a aVar) {
        if (this.cSZ != null) {
            this.cSZ.setEventCallback(aVar);
        }
        if (this.cTa != null) {
            this.cTa.setEventCallback(aVar);
        }
        if (this.cTi != null) {
            this.cTi.setEventCallback(aVar);
        }
        if (this.cTb != null) {
            this.cTb.setEventCallback(aVar);
        }
        if (this.cTh != null) {
            this.cTh.setEventCallback(aVar);
        }
    }
}
