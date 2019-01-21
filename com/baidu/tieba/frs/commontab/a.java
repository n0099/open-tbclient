package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView bRZ;
    private l dPJ;
    private FrsCommonTabFragment dSa;
    private i dSb;
    private i dSc;
    private com.baidu.tieba.frs.entelechy.a.l dSd;
    private p dSe;
    private com.baidu.tieba.frs.entelechy.a.d dSf;
    private boolean dSg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dSh = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).aqR()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dSa.getPageContext(), a.this.dSa.getUniqueId());
                        if (a.this.dSg) {
                            ((aa) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsCommonTabFragment, bdTypeRecyclerView);
        this.bRZ = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dSa = frsCommonTabFragment;
        this.dSh.setPriority(1);
        this.dSh.setSelfListener(true);
        this.dSa.registerListener(this.dSh);
        this.dSb = new i(frsCommonTabFragment.getPageContext(), bb.atJ, this.dSa.getUniqueId());
        this.dSb.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dSc = new i(frsCommonTabFragment.getPageContext(), bb.atL, this.dSa.getUniqueId());
        this.dSc.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dSd = new com.baidu.tieba.frs.entelechy.a.l(frsCommonTabFragment.getPageContext(), bb.atQ, this.dSa.getUniqueId());
        this.dSe = new p(frsCommonTabFragment.getPageContext(), bb.atM, this.dSa.getUniqueId());
        this.dSe.dSm = this.dSa.dSm;
        this.dSf = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.atR, this.dSa.getUniqueId());
        this.dSf.dSm = this.dSa.dSm;
        this.dPJ = new l(frsCommonTabFragment.getPageContext(), m.dOe);
        this.mAdapters.add(this.dSb);
        this.mAdapters.add(this.dSc);
        this.mAdapters.add(this.dSd);
        this.mAdapters.add(this.dSe);
        this.mAdapters.add(this.dSf);
        this.mAdapters.add(this.dPJ);
        if (frsCommonTabFragment.tabId == 89) {
            this.dSg = true;
            this.dSb.setFrom("c13010");
            this.dSc.setFrom("c13010");
            this.dSd.setFrom("c13010");
            this.dSe.setFrom("c13010");
            this.dSf.setFrom("c13010");
            kb("page_frs_dynamic");
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        aEt();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRZ.setData(arrayList);
    }

    private void aEt() {
        if (this.dSa != null && !v.I(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.d) {
                    com.baidu.tieba.frs.e.d dVar = (com.baidu.tieba.frs.e.d) aVar;
                    if (dVar.aFf() != null) {
                        dVar.aFf().eeK = this.dSa.dSl;
                        dVar.aFf().eeM = this.dSa.forumId;
                        dVar.aFf().eeN = this.dSa.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bRZ.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    private void kb(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).kb(str);
                }
            }
        }
    }
}
