package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
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
/* loaded from: classes7.dex */
public class ab {
    private List<com.baidu.adp.widget.ListView.a> gDJ;
    private com.baidu.adp.widget.ListView.r hbJ;
    private List<com.baidu.adp.widget.ListView.m> hbK;
    private a hbL;
    private z hbM;
    private n hbN;
    private w hbO;
    private i hbP;
    private j hbQ;
    private k hbR;
    private q hbS;
    private h hbT;
    private g hbU;
    private f hbV;
    private x hbW;
    private e hbX;
    private m hbY;
    private y hbZ;
    private b hca;
    private u hcb;
    private t hcc;
    private v hcd;
    private s hce;
    private n hcf;
    private y hcg;
    private l hch;
    private o hci;
    private p hcj;
    private r hck;
    private c hcl;
    private com.baidu.adp.widget.ListView.a hcm;
    private com.baidu.adp.widget.ListView.a hcn;
    private com.baidu.adp.widget.ListView.a hco;
    private com.baidu.adp.widget.ListView.a hcp;
    private com.baidu.adp.widget.ListView.a hcq;
    private com.baidu.adp.widget.ListView.a hcr;
    private com.baidu.adp.widget.ListView.a hcs;
    private boolean hct;
    private boolean hcu;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener gDL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.bNv();
                if (ab.this.hbK != null) {
                    ab.this.ac(ab.this.hbK);
                }
            }
        }
    };
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
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
                bVar.cMJ = true;
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
                bVar.cMJ = false;
                ab.this.at(bVar);
            }
        }
    };
    private CustomMessageListener fHd = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b BB;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (BB = ab.this.BB(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, BB));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> gUi = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.hbJ = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ab(context);
        eM(context);
        b(rVar);
        rVar.addAdapters(this.gUi);
    }

    private void eM(Context context) {
        this.hbL = new a(this.mPageContext);
        this.hbM = new z(this.mPageContext);
        this.hbN = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.hbO = new w(this.mPageContext, com.baidu.tieba.card.data.k.fKA);
        this.hbP = new i(this.mPageContext, com.baidu.tieba.card.data.k.fKG);
        this.hbQ = new j(this.mPageContext, com.baidu.tieba.card.data.k.fKH);
        this.hbR = new k(this.mPageContext, com.baidu.tieba.card.data.k.fKI);
        this.hbS = new q(this.mPageContext, com.baidu.tieba.card.data.k.fKJ);
        this.hbT = new h(this.mPageContext, com.baidu.tieba.card.data.k.fKB);
        this.hbU = new g(this.mPageContext, com.baidu.tieba.card.data.k.fKD);
        this.hbV = new f(this.mPageContext, com.baidu.tieba.card.data.k.fKE);
        this.hbW = new x(this.mPageContext, com.baidu.tieba.card.data.l.cNv);
        this.hbY = new m(this.mPageContext, com.baidu.tieba.card.data.k.cNt);
        this.hbZ = new y(this.mPageContext, com.baidu.tieba.card.data.l.fKQ);
        this.hca = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.hcb = new u(this.mPageContext, com.baidu.tieba.card.data.k.cNz);
        this.hcc = new t(this.mPageContext, com.baidu.tieba.card.data.k.cNA);
        this.hcd = new v(this.mPageContext, com.baidu.tieba.card.data.k.cNC);
        this.hce = new s(this.mPageContext, com.baidu.tieba.card.data.k.cNB);
        this.hcf = new n(this.mPageContext, com.baidu.tieba.card.data.k.fKy);
        this.hcg = new y(this.mPageContext, com.baidu.tieba.card.data.l.fKR);
        this.hch = new l(this.mPageContext, com.baidu.tieba.card.data.k.fKz);
        this.hci = new o(this.mPageContext, com.baidu.tieba.card.data.k.cNG);
        this.hcj = new p(this.mPageContext, com.baidu.tieba.card.data.k.cNH);
        this.hck = new r(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.hfv);
        this.hcl = new c(this.mPageContext, com.baidu.tieba.card.data.e.fKb);
        this.hcl.setFrom(0);
        this.hbX = new e(this.mPageContext, com.baidu.tieba.card.data.k.fKF);
        this.gUi.add(this.hbL);
        this.gUi.add(this.hbM);
        this.gUi.add(this.hbZ);
        this.gUi.add(this.hbN);
        this.gUi.add(this.hbO);
        this.gUi.add(this.hbP);
        this.gUi.add(this.hbQ);
        this.gUi.add(this.hbR);
        this.gUi.add(this.hbS);
        this.gUi.add(this.hbT);
        this.gUi.add(this.hbU);
        this.gUi.add(this.hbV);
        this.gUi.add(this.hbW);
        this.gUi.add(this.hbY);
        this.gUi.add(this.hcf);
        this.gUi.add(this.hcg);
        this.gUi.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.gUi.add(this.hca);
        this.gUi.add(this.hcb);
        this.gUi.add(this.hcc);
        this.gUi.add(this.hce);
        this.gUi.add(this.hcd);
        this.gUi.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.TYPE));
        this.gUi.add(this.hch);
        this.gUi.add(this.hci);
        this.gUi.add(this.hcj);
        this.gUi.add(this.hck);
        this.gUi.add(this.hcl);
        this.gUi.add(this.hbX);
        bNu();
        bNt();
        wu("page_recommend");
    }

    private void bNt() {
        if (!bj.cNK.get()) {
            AdvertAppInfo.cIQ.set(false);
            return;
        }
        this.hcm = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIH);
        this.hcn = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIK);
        this.hco = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIL);
        this.hcp = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIM);
        this.hcq = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIN);
        this.hcr = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIO);
        this.hcs = com.baidu.tieba.recapp.r.cAV().c(this.mPageContext, AdvertAppInfo.cIP);
        this.gUi.add(this.hcm);
        this.gUi.add(this.hcn);
        this.gUi.add(this.hco);
        this.gUi.add(this.hcp);
        this.gUi.add(this.hcq);
        this.gUi.add(this.hcr);
        this.gUi.add(this.hcs);
        AdvertAppInfo.cIQ.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hbN.a(eVar);
        this.hbO.a(eVar);
        this.hbP.a(eVar);
        this.hbR.a(eVar);
        this.hbS.a(eVar);
        this.hbT.a(eVar);
        this.hbU.a(eVar);
        this.hbV.a(eVar);
        this.hbW.a(eVar);
        this.hbX.a(eVar);
        this.hbZ.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.hbO.b(rVar);
        this.hbP.b(rVar);
        this.hbQ.b(rVar);
        this.hbR.b(rVar);
        this.hbS.b(rVar);
        this.hbT.b(rVar);
        this.hbU.b(rVar);
        this.hbV.b(rVar);
        this.hbX.b(rVar);
        this.hbW.b(rVar);
        this.hcl.b(rVar);
        this.hcc.b(rVar);
        this.hcc.b(rVar);
        this.hce.b(rVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.m> list, int i) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        ViewGroup listView = this.hbJ.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).jX();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).jY();
            }
        }
        this.hbJ.setData(list);
        this.hbK = list;
    }

    public void ac(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.s.o(list, 2);
        this.hbJ.setData(list);
        this.hbK = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.hbL.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.hbJ != null) {
            this.hbJ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.hbN != null) {
            this.hbN.setFromCDN(z);
            this.hcf.setFromCDN(z);
            this.hbZ.setFromCDN(z);
            this.hcg.setFromCDN(z);
            this.hbY.setFromCDN(z);
            this.hcb.setFromCDN(z);
        }
        if (this.hbR != null) {
            this.hbR.setFromCDN(z);
        }
        if (this.hbX != null) {
            this.hbX.setFromCDN(z);
        }
        if (this.hcn != null && (this.hcn instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hcn).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hbN != null) {
            this.hbN.dxg = bdUniqueId;
        }
        if (this.hbO != null) {
            this.hbO.dxg = bdUniqueId;
        }
        if (this.hbP != null) {
            this.hbP.dxg = bdUniqueId;
        }
        if (this.hbQ != null) {
            this.hbQ.dxg = bdUniqueId;
        }
        if (this.hbR != null) {
            this.hbR.dxg = bdUniqueId;
        }
        if (this.hbS != null) {
            this.hbS.dxg = bdUniqueId;
        }
        if (this.hbT != null) {
            this.hbT.dxg = bdUniqueId;
        }
        if (this.hbU != null) {
            this.hbU.dxg = bdUniqueId;
        }
        if (this.hbV != null) {
            this.hbV.dxg = bdUniqueId;
        }
        if (this.hbY != null) {
            this.hbY.dxg = bdUniqueId;
        }
        if (this.hbZ != null) {
            this.hbZ.dxg = bdUniqueId;
        }
        if (this.hbW != null) {
            this.hbW.dxg = bdUniqueId;
        }
        if (this.hbL != null) {
            this.hbL.setPageUniqueId(bdUniqueId);
        }
        if (this.hca != null) {
            this.hca.dxg = bdUniqueId;
        }
        if (this.hcb != null) {
            this.hcb.dxg = bdUniqueId;
        }
        if (this.hcc != null) {
            this.hcc.dxg = bdUniqueId;
        }
        if (this.hce != null) {
            this.hce.dxg = bdUniqueId;
        }
        if (this.hcd != null) {
            this.hcd.dxg = bdUniqueId;
        }
        if (this.hcf != null) {
            this.hcf.dxg = bdUniqueId;
        }
        if (this.hcg != null) {
            this.hcg.dxg = bdUniqueId;
        }
        if (this.hci != null) {
            this.hci.dxg = bdUniqueId;
        }
        if (this.hcj != null) {
            this.hcj.dxg = bdUniqueId;
        }
        if (this.hck != null) {
            this.hck.dxg = bdUniqueId;
        }
        if (this.hcl != null) {
            this.hcl.dxg = bdUniqueId;
        }
        if (this.hbX != null) {
            this.hbX.dxg = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gDJ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gDJ) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.cWc.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cWc);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.fHd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fHd);
        if (!this.hcu) {
            this.gDL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gDL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.hbK != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hbK.iterator();
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

    private void bNu() {
        this.hcu = bNv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNv() {
        if (this.gDJ == null || this.gDJ.size() <= 0) {
            this.gDJ = new ArrayList();
            ArrayList<BdUniqueId> cIK = com.baidu.tieba.tbadkCore.s.cIK();
            if (cIK == null || cIK.size() <= 0) {
                return false;
            }
            int size = cIK.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cbH().a(this.mPageContext, cIK.get(i), 2);
                if (this.hct) {
                    a.setBusinessType(3);
                }
                if (this.hbN != null && this.hbN.dxg != null) {
                    a.setUniqueId(this.hbN.dxg);
                }
                this.gDJ.add(a);
            }
            this.hbJ.addAdapters(this.gDJ);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hbN != null) {
            this.hbN.setEventCallback(aVar);
        }
        if (this.hbS != null) {
            this.hbS.setEventCallback(aVar);
        }
        if (this.hbQ != null) {
            this.hbQ.setEventCallback(aVar);
        }
        if (this.hbY != null) {
            this.hbY.setEventCallback(aVar);
        }
        if (this.hbZ != null) {
            this.hbZ.setEventCallback(aVar);
        }
        if (this.hca != null) {
            this.hca.setEventCallback(aVar);
        }
        if (this.hcb != null) {
            this.hcb.setEventCallback(aVar);
        }
        if (this.hcc != null) {
            this.hcc.setEventCallback(aVar);
        }
        if (this.hce != null) {
            this.hce.setEventCallback(aVar);
        }
        if (this.hcd != null) {
            this.hcd.setEventCallback(aVar);
        }
        if (this.hcf != null) {
            this.hcf.setEventCallback(aVar);
        }
        if (this.hcg != null) {
            this.hcg.setEventCallback(aVar);
        }
        if (this.hci != null) {
            this.hci.setEventCallback(aVar);
        }
        if (this.hcj != null) {
            this.hcj.setEventCallback(aVar);
        }
        if (this.hck != null) {
            this.hck.setEventCallback(aVar);
        }
        if (this.hcl != null) {
            this.hcl.setEventCallback(aVar);
        }
    }

    private void wu(String str) {
        if (this.gUi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.gUi) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wu(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).fJZ) != null && advertAppInfo.axZ() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b BB(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.hbK == null || this.hbK.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.hbK.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.hbK.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.f ? i3 + 1 : i3;
            if (this.hbK.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.hbK.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.hbK.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.hbK.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.hbK.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.hbK.get(i4)) != null && lVar.cNb != null && str.equals(lVar.cNb.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.hbK.get(i4)).position;
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
        if (this.hbZ != null) {
            this.hbZ.onPause();
        }
        if (this.hcg != null) {
            this.hcg.onPause();
        }
        if (this.hbW != null) {
            this.hbW.onPause();
        }
    }

    public void onResume() {
        if (this.hbZ != null) {
            this.hbZ.onResume();
        }
        if (this.hcg != null) {
            this.hcg.onResume();
        }
        if (this.hbW != null) {
            this.hbW.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hbZ != null) {
            this.hbZ.onDestroy();
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hbK;
    }
}
