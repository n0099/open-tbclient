package com.baidu.tieba.frs.dynamic;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private FrsDynamicFragment dmA;
    private BdTypeRecyclerView dmB;
    private i dmC;
    private i dmD;
    private l dmE;
    private p dmF;
    private d dmG;
    private j dmH;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dmI = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.dynamic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof z) && "FrsHottopicDelegateAdapter".equals(((z) aVar).ajj()) && a.this.mAdapters != null) {
                        ((z) aVar).a(a.this.dmA.getPageContext(), a.this.dmA.getUniqueId());
                        ((z) aVar).setFrom("c13010");
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsDynamicFragment, bdTypeRecyclerView);
        this.dmB = bdTypeRecyclerView;
    }

    public void a(FrsDynamicFragment frsDynamicFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dmA = frsDynamicFragment;
        this.dmI.setPriority(1);
        this.dmI.setSelfListener(true);
        this.dmA.registerListener(this.dmI);
        this.dmC = new i(frsDynamicFragment.getPageContext(), bd.ahJ, this.dmA.getUniqueId());
        this.dmC.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dmC.setFrom("c13010");
        this.dmD = new i(frsDynamicFragment.getPageContext(), bd.ahL, this.dmA.getUniqueId());
        this.dmD.setVoiceManager(frsDynamicFragment.getVoiceManager());
        this.dmD.setFrom("c13010");
        this.dmE = new l(frsDynamicFragment.getPageContext(), bd.ahQ, this.dmA.getUniqueId());
        this.dmE.setFrom("c13010");
        this.dmF = new p(frsDynamicFragment.getPageContext(), bd.ahM, this.dmA.getUniqueId());
        this.dmF.setFrom("c13010");
        this.dmG = new d(frsDynamicFragment.getPageContext(), bd.ahR, this.dmA.getUniqueId());
        this.dmG.setFrom("c13010");
        this.dmH = new j(frsDynamicFragment.getPageContext(), k.djW);
        this.mAdapters.add(this.dmC);
        this.mAdapters.add(this.dmD);
        this.mAdapters.add(this.dmE);
        this.mAdapters.add(this.dmF);
        this.mAdapters.add(this.dmG);
        this.mAdapters.add(this.dmH);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        iy("page_frs_dynamic");
    }

    public void setData(ArrayList<h> arrayList) {
        this.dmB.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dmB.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof f)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }

    private void iy(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iy(str);
                }
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof f) {
                ((f) aVar).release();
            }
        }
    }
}
