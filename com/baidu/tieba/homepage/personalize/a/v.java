package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class v {
    private com.baidu.adp.widget.ListView.a fMA;
    private com.baidu.adp.widget.ListView.a fMB;
    private com.baidu.adp.widget.ListView.a fMC;
    private com.baidu.adp.widget.ListView.a fMD;
    private com.baidu.adp.widget.ListView.a fME;
    private boolean fMF;
    private boolean fMG;
    private com.baidu.adp.widget.ListView.r fMb;
    private List<com.baidu.adp.widget.ListView.m> fMc;
    private a fMd;
    private t fMe;
    private k fMf;
    private q fMg;
    private g fMh;
    private h fMi;
    private o fMj;
    private f fMk;
    private e fMl;
    private d fMm;
    private r fMn;
    private j fMo;
    private s fMp;
    private l fMq;
    private b fMr;
    private p fMs;
    private k fMt;
    private s fMu;
    private i fMv;
    private m fMw;
    private n fMx;
    private com.baidu.adp.widget.ListView.a fMy;
    private com.baidu.adp.widget.ListView.a fMz;
    private List<com.baidu.adp.widget.ListView.a> fpL;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener fpM = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.v.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                v.this.bmL();
                if (v.this.fMc != null) {
                    v.this.ay(v.this.fMc);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.v.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jy) {
                v.this.ar(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.v.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bAB = true;
                v.this.ar(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.v.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.bAB = false;
                v.this.ar(bVar);
            }
        }
    };
    private CustomMessageListener ehK = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.v.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b vO;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (vO = v.this.vO(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, vO));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> fFA = new ArrayList();

    public v(Context context, com.baidu.adp.widget.ListView.r rVar) {
        this.fMb = rVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        dN(context);
        b(rVar);
        rVar.addAdapters(this.fFA);
    }

    private void dN(Context context) {
        this.fMd = new a(this.mPageContext);
        this.fMe = new t(this.mPageContext);
        this.fMf = new k(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.fMg = new q(this.mPageContext, com.baidu.tieba.card.data.k.elh);
        this.fMh = new g(this.mPageContext, com.baidu.tieba.card.data.k.elm);
        this.fMi = new h(this.mPageContext, com.baidu.tieba.card.data.k.eln);
        this.fMj = new o(this.mPageContext, com.baidu.tieba.card.data.k.elo);
        this.fMk = new f(this.mPageContext, com.baidu.tieba.card.data.k.eli);
        this.fMl = new e(this.mPageContext, com.baidu.tieba.card.data.k.elk);
        this.fMm = new d(this.mPageContext, com.baidu.tieba.card.data.k.ell);
        this.fMn = new r(this.mPageContext, com.baidu.tieba.card.data.l.bBg);
        this.fMo = new j(this.mPageContext, com.baidu.tieba.card.data.k.bBe);
        this.fMp = new s(this.mPageContext, com.baidu.tieba.card.data.l.elv);
        this.fMq = new l(this.mPageContext);
        this.fMr = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.fMs = new p(this.mPageContext, com.baidu.tieba.card.data.k.bBk);
        this.fMt = new k(this.mPageContext, com.baidu.tieba.card.data.k.elf);
        this.fMu = new s(this.mPageContext, com.baidu.tieba.card.data.l.elw);
        this.fMv = new i(this.mPageContext, com.baidu.tieba.card.data.k.elg);
        this.fMw = new m(this.mPageContext, com.baidu.tieba.card.data.k.bBo);
        this.fMx = new n(this.mPageContext, com.baidu.tieba.card.data.k.bBp);
        this.fFA.add(this.fMd);
        this.fFA.add(this.fMe);
        this.fFA.add(this.fMp);
        this.fFA.add(this.fMf);
        this.fFA.add(this.fMg);
        this.fFA.add(this.fMh);
        this.fFA.add(this.fMi);
        this.fFA.add(this.fMj);
        this.fFA.add(this.fMk);
        this.fFA.add(this.fMl);
        this.fFA.add(this.fMm);
        this.fFA.add(this.fMn);
        this.fFA.add(this.fMo);
        this.fFA.add(this.fMq);
        this.fFA.add(this.fMt);
        this.fFA.add(this.fMu);
        this.fFA.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.fFA.add(this.fMr);
        this.fFA.add(this.fMs);
        this.fFA.add(new u(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.fFA.add(this.fMv);
        this.fFA.add(this.fMw);
        this.fFA.add(this.fMx);
        bmK();
        bmJ();
        qM("page_recommend");
    }

    private void bmJ() {
        if (!bg.bBr.get()) {
            AdvertAppInfo.bwE.set(false);
            return;
        }
        this.fMy = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwv);
        this.fMz = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwy);
        this.fMA = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwz);
        this.fMB = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwA);
        this.fMC = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwB);
        this.fMD = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwC);
        this.fME = com.baidu.tieba.recapp.r.bWF().c(this.mPageContext, AdvertAppInfo.bwD);
        this.fFA.add(this.fMy);
        this.fFA.add(this.fMz);
        this.fFA.add(this.fMA);
        this.fFA.add(this.fMB);
        this.fFA.add(this.fMC);
        this.fFA.add(this.fMD);
        this.fFA.add(this.fME);
        AdvertAppInfo.bwE.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.fMf.a(eVar);
        this.fMg.a(eVar);
        this.fMh.a(eVar);
        this.fMi.a(eVar);
        this.fMj.a(eVar);
        this.fMk.a(eVar);
        this.fMl.a(eVar);
        this.fMm.a(eVar);
        this.fMn.a(eVar);
        this.fMp.a(eVar);
    }

    private void b(com.baidu.adp.widget.ListView.r rVar) {
        this.fMg.b(rVar);
        this.fMh.b(rVar);
        this.fMi.b(rVar);
        this.fMj.b(rVar);
        this.fMk.b(rVar);
        this.fMl.b(rVar);
        this.fMm.b(rVar);
        this.fMn.b(rVar);
    }

    public void ay(List<com.baidu.adp.widget.ListView.m> list) {
        com.baidu.tieba.tbadkCore.q.p(list, 2);
        this.fMb.setData(list);
        this.fMc = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.fMd.onChangeSkinType(i);
        this.fMq.sA(i);
    }

    public void notifyDataSetChanged() {
        if (this.fMb != null) {
            this.fMb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.fMf != null) {
            this.fMf.setFromCDN(z);
            this.fMt.setFromCDN(z);
            this.fMp.setFromCDN(z);
            this.fMu.setFromCDN(z);
            this.fMo.setFromCDN(z);
            this.fMs.setFromCDN(z);
        }
        if (this.fMi != null) {
            this.fMi.setFromCDN(z);
        }
        if (this.fMz != null && (this.fMz instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.fMz).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fMf != null) {
            this.fMf.cnZ = bdUniqueId;
        }
        if (this.fMg != null) {
            this.fMg.cnZ = bdUniqueId;
        }
        if (this.fMh != null) {
            this.fMh.cnZ = bdUniqueId;
        }
        if (this.fMi != null) {
            this.fMi.cnZ = bdUniqueId;
        }
        if (this.fMj != null) {
            this.fMj.cnZ = bdUniqueId;
        }
        if (this.fMk != null) {
            this.fMk.cnZ = bdUniqueId;
        }
        if (this.fMl != null) {
            this.fMl.cnZ = bdUniqueId;
        }
        if (this.fMm != null) {
            this.fMm.cnZ = bdUniqueId;
        }
        if (this.fMo != null) {
            this.fMo.cnZ = bdUniqueId;
        }
        if (this.fMp != null) {
            this.fMp.cnZ = bdUniqueId;
        }
        if (this.fMn != null) {
            this.fMn.cnZ = bdUniqueId;
        }
        if (this.fMd != null) {
            this.fMd.setPageUniqueId(bdUniqueId);
        }
        if (this.fMq != null) {
            this.fMq.cnZ = bdUniqueId;
        }
        if (this.fMr != null) {
            this.fMr.cnZ = bdUniqueId;
        }
        if (this.fMs != null) {
            this.fMs.cnZ = bdUniqueId;
        }
        if (this.fMt != null) {
            this.fMt.cnZ = bdUniqueId;
        }
        if (this.fMu != null) {
            this.fMu.cnZ = bdUniqueId;
        }
        if (this.fMw != null) {
            this.fMw.cnZ = bdUniqueId;
        }
        if (this.fMx != null) {
            this.fMx.cnZ = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fpL)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fpL) {
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
        this.ehK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ehK);
        if (!this.fMG) {
            this.fpM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fpM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.fMc != null) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fMc.iterator();
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

    private void bmK() {
        this.fMG = bmL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmL() {
        if (this.fpL == null || this.fpL.size() <= 0) {
            this.fpL = new ArrayList();
            ArrayList<BdUniqueId> cdC = com.baidu.tieba.tbadkCore.q.cdC();
            if (cdC == null || cdC.size() <= 0) {
                return false;
            }
            int size = cdC.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bBi().a(this.mPageContext, cdC.get(i), 2);
                if (this.fMF) {
                    a.setBusinessType(3);
                }
                if (this.fMf != null && this.fMf.cnZ != null) {
                    a.setUniqueId(this.fMf.cnZ);
                }
                this.fpL.add(a);
            }
            this.fMb.addAdapters(this.fpL);
            return true;
        }
        return true;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.fMf != null) {
            this.fMf.setEventCallback(aVar);
        }
        if (this.fMg != null) {
            this.fMg.setEventCallback(aVar);
        }
        if (this.fMo != null) {
            this.fMo.setEventCallback(aVar);
        }
        if (this.fMp != null) {
            this.fMp.setEventCallback(aVar);
        }
        if (this.fMr != null) {
            this.fMr.setEventCallback(aVar);
        }
        if (this.fMs != null) {
            this.fMs.setEventCallback(aVar);
        }
        if (this.fMt != null) {
            this.fMt.setEventCallback(aVar);
        }
        if (this.fMu != null) {
            this.fMu.setEventCallback(aVar);
        }
        if (this.fMw != null) {
            this.fMw.setEventCallback(aVar);
        }
        if (this.fMx != null) {
            this.fMx.setEventCallback(aVar);
        }
    }

    private void qM(String str) {
        if (this.fFA != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.fFA) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qM(str);
                }
            }
        }
    }

    private boolean h(com.baidu.adp.widget.ListView.m mVar) {
        AdvertAppInfo advertAppInfo;
        return mVar != null && (mVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) mVar).ekL) != null && advertAppInfo.WX() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b vO(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.fMc == null || this.fMc.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.fMc.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.fMc.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.fMc.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (h(this.fMc.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.fMc.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.fMc.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.fMc.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.fMc.get(i4)) != null && lVar.cZC != null && str.equals(lVar.cZC.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.fMc.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.bl(i6 - i >= -1 ? i6 - i : -1);
        bVar.bm(i7);
        bVar.bn(i2);
        return bVar;
    }

    public void onPause() {
        if (this.fMp != null) {
            this.fMp.onPause();
        }
        if (this.fMu != null) {
            this.fMu.onPause();
        }
        if (this.fMn != null) {
            this.fMn.onPause();
        }
    }

    public void onResume() {
        if (this.fMp != null) {
            this.fMp.onResume();
        }
        if (this.fMu != null) {
            this.fMu.onResume();
        }
        if (this.fMn != null) {
            this.fMn.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fMp != null) {
            this.fMp.onDestroy();
        }
    }
}
