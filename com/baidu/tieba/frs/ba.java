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
public class ba {
    private BdTypeListView aRs;
    private FrsActivity baC;
    private dr baD;
    private cr baE;
    private View.OnClickListener baF;
    private View.OnClickListener baG;
    private cv baH;
    private bv baI;
    private en baJ;
    private bg baK;
    private bj baL;
    private bh baM;
    private dx baN;
    private dg baO;
    private dd baP;
    private ds baQ;
    private de baR;
    private ep baS;
    private com.baidu.tieba.frs.a.a baT;
    private com.baidu.tieba.frs.a.c baU;
    private com.baidu.tieba.frs.a.e baV;
    private com.baidu.tieba.frs.live.a baW;
    private dm baX;
    private eh baY;
    private cs baZ;
    private final HashMap<Integer, com.baidu.tbadk.core.data.z> bba;
    private List<com.baidu.adp.widget.ListView.a> aRI = new LinkedList();
    private boolean aYl = false;
    private CustomMessageListener bbb = new bb(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean bbc = false;
    private boolean alO = false;

    public ba(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aRs = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bba = new HashMap<>();
        ck(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.baC = frsActivity;
        this.baH = new cv(frsActivity, com.baidu.tbadk.core.data.z.Wc);
        this.baJ = new en(frsActivity, com.baidu.tbadk.core.data.z.Wb);
        this.baS = new ep(frsActivity, com.baidu.tbadk.core.data.z.Wd);
        this.baK = new bg(frsActivity, com.baidu.tbadk.core.data.b.Uf);
        this.baL = new bj(frsActivity, com.baidu.tbadk.core.data.b.Ug);
        this.baM = new bh(frsActivity, com.baidu.tbadk.core.data.b.Uh);
        this.baO = new dg(frsActivity, com.baidu.tbadk.core.data.s.VH);
        this.baP = new dd(frsActivity, com.baidu.tieba.tbadkCore.aa.dyo);
        this.baQ = new ds(frsActivity, com.baidu.tbadk.core.data.u.VL);
        this.baT = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.b.Uk);
        this.baV = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.b.Uj);
        this.baU = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.b.Ui);
        this.baN = new dx(frsActivity, com.baidu.tbadk.core.data.w.VX);
        this.baZ = new cs(frsActivity, ct.bdo);
        this.baR = new de(frsActivity, com.baidu.tbadk.core.data.t.VJ);
        this.baW = new com.baidu.tieba.frs.live.a(frsActivity, com.baidu.tbadk.core.data.k.Vj);
        this.baX = new dm(frsActivity, com.baidu.tbadk.core.data.z.We);
        this.baY = new eh(frsActivity, com.baidu.tbadk.core.data.z.Wf);
        this.baI = new bv(frsActivity, com.baidu.tieba.tbadkCore.i.dxf);
        this.aRI.add(this.baH);
        this.aRI.add(this.baJ);
        this.aRI.add(this.baK);
        this.aRI.add(this.baL);
        this.aRI.add(this.baM);
        this.aRI.add(this.baO);
        this.aRI.add(this.baP);
        this.aRI.add(this.baQ);
        this.aRI.add(this.baT);
        this.aRI.add(this.baV);
        this.aRI.add(this.baU);
        this.aRI.add(this.baN);
        this.aRI.add(this.baZ);
        this.aRI.add(this.baS);
        this.aRI.add(this.baR);
        this.aRI.add(this.baX);
        this.aRI.add(this.baY);
        this.aRI.add(this.baW);
        this.aRI.add(new dz(frsActivity, ea.beD));
        this.aRI.add(this.baI);
        this.bbb.setPriority(1);
        this.bbb.setSelfListener(true);
        frsActivity.registerListener(this.bbb);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.g(this.aRI);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof bm) {
                ((bm) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar, boolean z, boolean z2) {
        a(pVar);
        F(arrayList);
        G(arrayList);
        this.aRs.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        a(arrayList, pVar, this.bbc, this.alO);
    }

    public int Nd() {
        return this.aRs.getHeaderViewsCount();
    }

    private ArrayList<Integer> F(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
                if (this.bba != null && !this.bba.containsValue(uVar)) {
                    this.bba.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.z) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void ck(boolean z) {
        if (this.aYl != z) {
            this.aYl = z;
            if (this.baH != null) {
                this.baH.ck(z);
            }
            if (this.baW != null) {
                this.baW.ck(z);
            }
        }
    }

    public void cp(boolean z) {
        if (this.baE != null) {
            this.baE.cp(z);
        }
    }

    public void cq(boolean z) {
        if (this.baD != null) {
            this.baD.cq(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.z> Ne() {
        return this.bba;
    }

    public void aq(String str, String str2) {
        if (this.baQ != null) {
            this.baQ.aq(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.baK != null) {
            this.baK.h(onClickListener);
        }
        if (this.baL != null) {
            this.baL.h(onClickListener);
        }
        if (this.baM != null) {
            this.baM.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.baK != null) {
            this.baK.i(onClickListener);
        }
        if (this.baL != null) {
            this.baL.i(onClickListener);
        }
        if (this.baM != null) {
            this.baM.i(onClickListener);
        }
    }

    public void Nf() {
        if (this.aRs != null && this.aRs.getData() != null && this.aRs.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aRs.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.z) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.baD != null) {
            this.baD.onChangeSkinType(i);
        }
        if (this.baE != null) {
            this.baE.onChangeSkinType(i);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(pVar);
                }
            }
        }
    }

    public void a(bc bcVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(bcVar);
                }
                if (aVar instanceof dm) {
                    ((bm) aVar).a(bcVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.baF = onClickListener;
        if (this.baD != null) {
            this.baD.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.baG = onClickListener;
        if (this.baE != null) {
            this.baE.m(onClickListener);
        }
    }

    public int Ng() {
        if (this.baH != null) {
            return this.baH.Ng();
        }
        return 0;
    }

    public int Mx() {
        if (this.baH != null) {
            return this.baH.Mx();
        }
        return 0;
    }

    public int Nh() {
        if (this.baP != null) {
            return this.baP.Nh();
        }
        return 0;
    }

    public int Ni() {
        if (this.baH != null) {
            return this.baH.Ni();
        }
        return 0;
    }

    public int Nj() {
        if (this.baP != null) {
            return this.baP.Nj();
        }
        return 0;
    }

    public int Nk() {
        if (this.baR != null) {
            return this.baR.NZ();
        }
        return 0;
    }

    public int Nl() {
        if (this.baO != null) {
            return this.baO.Oa();
        }
        return 0;
    }

    public int Nm() {
        if (this.baR != null) {
            return this.baR.Nm();
        }
        return 0;
    }

    public int Nn() {
        if (this.baW != null) {
            return this.baW.OQ();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aB(int i) {
        if (this.aRs != null) {
            return this.aRs.aB(i);
        }
        return null;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aRI != null && this.aRI.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.z.Wb.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bbc) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).fY(i);
                }
            }
        }
    }
}
