package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class bd {
    private BdTypeListView aVi;
    private FrsActivity beB;
    private dr beC;
    private cu beD;
    private View.OnClickListener beE;
    private View.OnClickListener beF;
    private cy beG;
    private by beH;
    private en beI;
    private bj beJ;
    private bm beK;
    private bk beL;
    private dx beM;
    private dj beN;
    private dg beO;
    private ds beP;
    private dh beQ;
    private ep beR;
    private com.baidu.tieba.frs.a.a beS;
    private com.baidu.tieba.frs.a.c beT;
    private com.baidu.tieba.frs.a.e beU;
    private com.baidu.tieba.frs.live.a beV;
    private dm beW;
    private eh beX;
    private cv beY;
    private final HashMap<Integer, com.baidu.tbadk.core.data.z> beZ;
    private List<com.baidu.adp.widget.ListView.a> aVK = new LinkedList();
    private boolean bck = false;
    private CustomMessageListener bfa = new be(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean bfb = false;
    private boolean amU = false;

    public bd(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aVi = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.beZ = new HashMap<>();
        cl(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.beB = frsActivity;
        this.beG = new cy(frsActivity, com.baidu.tbadk.core.data.z.WC);
        this.beI = new en(frsActivity, com.baidu.tbadk.core.data.z.WB);
        this.beR = new ep(frsActivity, com.baidu.tbadk.core.data.z.WD);
        this.beJ = new bj(frsActivity, com.baidu.tbadk.core.data.b.UF);
        this.beK = new bm(frsActivity, com.baidu.tbadk.core.data.b.UG);
        this.beL = new bk(frsActivity, com.baidu.tbadk.core.data.b.UH);
        this.beN = new dj(frsActivity, com.baidu.tbadk.core.data.s.Wh);
        this.beO = new dg(frsActivity, com.baidu.tieba.tbadkCore.aa.dFI);
        this.beP = new ds(frsActivity, com.baidu.tbadk.core.data.u.Wl);
        this.beS = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.b.UK);
        this.beU = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.b.UJ);
        this.beT = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.b.UI);
        this.beM = new dx(frsActivity, com.baidu.tbadk.core.data.w.Wx);
        this.beY = new cv(frsActivity, cw.bho);
        this.beQ = new dh(frsActivity, com.baidu.tbadk.core.data.t.Wj);
        this.beV = new com.baidu.tieba.frs.live.a(frsActivity, com.baidu.tbadk.core.data.k.VJ);
        this.beW = new dm(frsActivity, com.baidu.tbadk.core.data.z.WE);
        this.beX = new eh(frsActivity, com.baidu.tbadk.core.data.z.WF);
        this.beH = new by(frsActivity, com.baidu.tieba.tbadkCore.i.dEG);
        this.aVK.add(this.beG);
        this.aVK.add(this.beI);
        this.aVK.add(this.beJ);
        this.aVK.add(this.beK);
        this.aVK.add(this.beL);
        this.aVK.add(this.beN);
        this.aVK.add(this.beO);
        this.aVK.add(this.beP);
        this.aVK.add(this.beS);
        this.aVK.add(this.beU);
        this.aVK.add(this.beT);
        this.aVK.add(this.beM);
        this.aVK.add(this.beY);
        this.aVK.add(this.beR);
        this.aVK.add(this.beQ);
        this.aVK.add(this.beW);
        this.aVK.add(this.beX);
        this.aVK.add(this.beV);
        this.aVK.add(new dz(frsActivity, ea.bix));
        this.aVK.add(this.beH);
        this.bfa.setPriority(1);
        this.bfa.setSelfListener(true);
        frsActivity.registerListener(this.bfa);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.g(this.aVK);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bp) {
                ((bp) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar, boolean z, boolean z2) {
        a(pVar);
        D(arrayList);
        E(arrayList);
        this.aVi.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        a(arrayList, pVar, this.bfb, this.amU);
    }

    public int Nw() {
        return this.aVi.getHeaderViewsCount();
    }

    private ArrayList<Integer> D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            com.baidu.adp.widget.ListView.u uVar = arrayList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.b) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.beZ != null && !this.beZ.containsValue(uVar)) {
                    this.beZ.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.z) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void cl(boolean z) {
        if (this.bck != z) {
            this.bck = z;
            if (this.beG != null) {
                this.beG.cl(z);
            }
            if (this.beV != null) {
                this.beV.cl(z);
            }
        }
    }

    public void cq(boolean z) {
        if (this.beD != null) {
            this.beD.cq(z);
        }
    }

    public void cr(boolean z) {
        if (this.beC != null) {
            this.beC.cr(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.z> Nx() {
        return this.beZ;
    }

    public void ao(String str, String str2) {
        if (this.beP != null) {
            this.beP.ao(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.beJ != null) {
            this.beJ.h(onClickListener);
        }
        if (this.beK != null) {
            this.beK.h(onClickListener);
        }
        if (this.beL != null) {
            this.beL.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.beJ != null) {
            this.beJ.i(onClickListener);
        }
        if (this.beK != null) {
            this.beK.i(onClickListener);
        }
        if (this.beL != null) {
            this.beL.i(onClickListener);
        }
    }

    public void Ny() {
        if (this.aVi != null && this.aVi.getData() != null && this.aVi.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVi.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.z) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.beC != null) {
            this.beC.onChangeSkinType(i);
        }
        if (this.beD != null) {
            this.beD.onChangeSkinType(i);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(pVar);
                }
            }
        }
    }

    public void a(bf bfVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(bfVar);
                }
                if (aVar instanceof dm) {
                    ((bp) aVar).a(bfVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.beE = onClickListener;
        if (this.beC != null) {
            this.beC.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.beF = onClickListener;
        if (this.beD != null) {
            this.beD.m(onClickListener);
        }
    }

    public int Nz() {
        if (this.beG != null) {
            return this.beG.Nz();
        }
        return 0;
    }

    public int MQ() {
        if (this.beG != null) {
            return this.beG.MQ();
        }
        return 0;
    }

    public int NA() {
        if (this.beO != null) {
            return this.beO.NA();
        }
        return 0;
    }

    public int NB() {
        if (this.beG != null) {
            return this.beG.NB();
        }
        return 0;
    }

    public int NC() {
        if (this.beO != null) {
            return this.beO.NC();
        }
        return 0;
    }

    public int ND() {
        if (this.beQ != null) {
            return this.beQ.Os();
        }
        return 0;
    }

    public int NE() {
        if (this.beN != null) {
            return this.beN.Ou();
        }
        return 0;
    }

    public int NF() {
        if (this.beQ != null) {
            return this.beQ.NF();
        }
        return 0;
    }

    public int NG() {
        if (this.beV != null) {
            return this.beV.Pi();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u au(int i) {
        if (this.aVi != null) {
            return this.aVi.au(i);
        }
        return null;
    }

    private void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVK != null && this.aVK.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.z.WB.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bfb) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).fT(i);
                }
            }
        }
    }
}
