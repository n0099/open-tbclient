package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Op;
    private FrsCommonTabFragment fBJ;
    private com.baidu.tieba.frs.entelechy.a.d fBK;
    private com.baidu.tieba.frs.entelechy.a.d fBL;
    private v fBM;
    private z fBN;
    private z fBO;
    private boolean fBP;
    private l fza;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fBQ = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).aZR()) && a.this.mAdapters != null) {
                        ((y) aVar).a(a.this.fBJ.getPageContext(), a.this.fBJ.getUniqueId());
                        if (a.this.fBP) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Op = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fBJ = frsCommonTabFragment;
        this.fBQ.setPriority(1);
        this.fBQ.setSelfListener(true);
        this.fBJ.registerListener(this.fBQ);
        this.fBK = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.bJo, this.fBJ.getUniqueId());
        this.fBK.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fBL = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.bJB, this.fBJ.getUniqueId());
        this.fBL.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fBM = new v(frsCommonTabFragment.getPageContext(), bh.bJG, this.fBJ.getUniqueId());
        this.fBN = new z(frsCommonTabFragment.getPageContext(), bh.bJC, this.fBJ.getUniqueId());
        this.fBN.fBW = this.fBJ.fBW;
        this.fBO = new z(frsCommonTabFragment.getPageContext(), bh.bJH, this.fBJ.getUniqueId());
        this.fBO.fBW = this.fBJ.fBW;
        this.fza = new l(frsCommonTabFragment.getPageContext(), m.fxi);
        this.mAdapters.add(this.fBK);
        this.mAdapters.add(this.fBL);
        this.mAdapters.add(this.fBM);
        this.mAdapters.add(this.fBN);
        this.mAdapters.add(this.fBO);
        this.mAdapters.add(this.fza);
        if (frsCommonTabFragment.tabId == 89) {
            this.fBP = true;
            this.fBK.setFrom("c13010");
            this.fBL.setFrom("c13010");
            this.fBM.setFrom("c13010");
            this.fBN.setFrom("c13010");
            this.fBO.setFrom("c13010");
            sm("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        boJ();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Op.setData(arrayList);
    }

    private void boJ() {
        if (this.fBJ != null && !com.baidu.tbadk.core.util.v.aa(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bph() != null) {
                        dVar.bph().fPr = this.fBJ.fBV;
                        dVar.bph().fPt = this.fBJ.forumId;
                        dVar.bph().fPu = this.fBJ.tabId;
                        if (this.fBJ.tabId == 502) {
                            dVar.bph().fPw = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Op.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void sm(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).sm(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void kv(boolean z) {
        if (this.fBK != null) {
            this.fBK.kx(z);
        }
        if (this.fBL != null) {
            this.fBL.kx(z);
        }
        if (this.fBN != null) {
            this.fBN.kx(z);
        }
        if (this.fBO != null) {
            this.fBO.kx(z);
        }
    }
}
