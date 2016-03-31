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
public class bh {
    private BdTypeListView bcd;
    private FrsActivity blH;
    private ed blI;
    private dg blJ;
    private View.OnClickListener blK;
    private View.OnClickListener blL;
    private dk blM;
    private cg blN;
    private com.baidu.tieba.frs.view.s blO;
    private fh blP;
    private bn blQ;
    private bs blR;
    private bp blS;
    private ej blT;
    private du blU;
    private dr blV;
    private ee blW;
    private ds blX;
    private fj blY;
    private com.baidu.tieba.frs.b.a blZ;
    private com.baidu.tieba.frs.b.c bma;
    private com.baidu.tieba.frs.b.e bmb;
    private com.baidu.tieba.frs.a.a bmc;
    private em bmd;
    private cq bme;
    private dx bmf;
    private fa bmg;
    private dh bmh;
    private final HashMap<Integer, com.baidu.tbadk.core.data.as> bmi;
    private List<com.baidu.adp.widget.ListView.a> bcG = new LinkedList();
    private boolean bjl = false;
    private CustomMessageListener bmk = new bi(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean bml = false;
    private boolean aoe = false;
    private final bw bmj = new bw();

    public bh(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bcd = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bmi = new HashMap<>();
        cw(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.blH = frsActivity;
        this.blM = new dk(frsActivity, com.baidu.tbadk.core.data.as.UW);
        this.blP = new fh(frsActivity, com.baidu.tbadk.core.data.as.UV);
        this.blY = new fj(frsActivity, com.baidu.tbadk.core.data.as.UX);
        this.blQ = new bn(frsActivity, com.baidu.tbadk.core.data.c.RS);
        this.blR = new bs(frsActivity, com.baidu.tbadk.core.data.c.RT);
        this.blS = new bp(frsActivity, com.baidu.tbadk.core.data.c.RU);
        this.blU = new du(frsActivity, com.baidu.tbadk.core.data.ae.Ue);
        this.blV = new dr(frsActivity, com.baidu.tieba.tbadkCore.z.eoi);
        this.blW = new ee(frsActivity, com.baidu.tbadk.core.data.ai.Uj);
        this.blZ = new com.baidu.tieba.frs.b.a(frsActivity, com.baidu.tbadk.core.data.c.RX);
        this.bmb = new com.baidu.tieba.frs.b.e(frsActivity, com.baidu.tbadk.core.data.c.RW);
        this.bma = new com.baidu.tieba.frs.b.c(frsActivity, com.baidu.tbadk.core.data.c.RV);
        this.blT = new ej(frsActivity, com.baidu.tbadk.core.data.am.UI);
        this.bmh = new dh(frsActivity, di.bpm);
        this.blX = new ds(frsActivity, com.baidu.tbadk.core.data.af.Ug);
        this.bmc = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.r.Tk);
        this.bmf = new dx(frsActivity, com.baidu.tbadk.core.data.as.UY);
        this.bmg = new fa(frsActivity, com.baidu.tbadk.core.data.as.UZ);
        this.blN = new cg(frsActivity, com.baidu.tieba.tbadkCore.h.enc);
        this.blO = new com.baidu.tieba.frs.view.s(frsActivity, com.baidu.tieba.card.a.x.aWt);
        this.bmd = new em(frsActivity, com.baidu.tbadk.core.data.as.VN);
        this.bme = new cq(frsActivity, com.baidu.tbadk.core.data.as.VR);
        this.bcG.add(this.blM);
        this.bcG.add(this.blP);
        this.bcG.add(this.blQ);
        this.bcG.add(this.blR);
        this.bcG.add(this.blS);
        this.bcG.add(this.blU);
        this.bcG.add(this.blV);
        this.bcG.add(this.blW);
        this.bcG.add(this.blZ);
        this.bcG.add(this.bmb);
        this.bcG.add(this.bma);
        this.bcG.add(this.blT);
        this.bcG.add(this.bmh);
        this.bcG.add(this.blY);
        this.bcG.add(this.blX);
        this.bcG.add(this.bmf);
        this.bcG.add(this.bmg);
        this.bcG.add(this.bmc);
        this.bcG.add(new es(frsActivity, et.bqK));
        this.bcG.add(this.blN);
        this.bcG.add(this.blO);
        this.bcG.add(this.bmd);
        this.bcG.add(this.bme);
        this.bmk.setPriority(1);
        this.bmk.setSelfListener(true);
        frsActivity.registerListener(this.bmk);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        ah(this.bcG);
        bdTypeListView.g(this.bcG);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
            if (aVar instanceof bx) {
                ((bx) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.bcd.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.bml, this.aoe);
    }

    public int Rl() {
        return this.bcd.getHeaderViewsCount();
    }

    private ArrayList<Integer> C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
            if (uVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bmi != null && !this.bmi.containsValue(uVar)) {
                    this.bmi.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.as) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void cw(boolean z) {
        if (this.bjl != z) {
            this.bjl = z;
            if (this.blM != null) {
                this.blM.cw(z);
            }
            if (this.bmc != null) {
                this.bmc.cw(z);
            }
        }
    }

    public void cC(boolean z) {
        if (this.blJ != null) {
            this.blJ.cC(z);
        }
    }

    public void cD(boolean z) {
        if (this.blI != null) {
            this.blI.cD(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.as> Rm() {
        return this.bmi;
    }

    public void av(String str, String str2) {
        if (this.blW != null) {
            this.blW.av(str, str2);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.blQ != null) {
            this.blQ.l(onClickListener);
        }
        if (this.blR != null) {
            this.blR.l(onClickListener);
        }
        if (this.blS != null) {
            this.blS.l(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.blQ != null) {
            this.blQ.m(onClickListener);
        }
        if (this.blR != null) {
            this.blR.m(onClickListener);
        }
        if (this.blS != null) {
            this.blS.m(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.blQ != null) {
            this.blQ.n(onClickListener);
        }
        if (this.blR != null) {
            this.blR.n(onClickListener);
        }
        if (this.blS != null) {
            this.blS.n(onClickListener);
        }
    }

    public void Rn() {
        if (this.bcd != null && this.bcd.getData() != null && this.bcd.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.bcd.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.as) && ((com.baidu.tbadk.core.data.as) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.as) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.blI != null) {
            this.blI.onChangeSkinType(i);
        }
        if (this.blJ != null) {
            this.blJ.onChangeSkinType(i);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bj bjVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(bjVar);
                }
                if (aVar instanceof dx) {
                    ((bx) aVar).a(bjVar);
                }
            }
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.blK = onClickListener;
        if (this.blI != null) {
            this.blI.o(onClickListener);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.blL = onClickListener;
        if (this.blJ != null) {
            this.blJ.r(onClickListener);
        }
    }

    public int Ro() {
        if (this.blM != null) {
            return this.blM.Ro();
        }
        return 0;
    }

    public int QA() {
        if (this.blM != null) {
            return this.blM.QA();
        }
        return 0;
    }

    public int Rp() {
        if (this.blV != null) {
            return this.blV.Rp();
        }
        return 0;
    }

    public int Rq() {
        if (this.blM != null) {
            return this.blM.Rq();
        }
        return 0;
    }

    public int Rr() {
        if (this.blV != null) {
            return this.blV.Rr();
        }
        return 0;
    }

    public int Rs() {
        if (this.blX != null) {
            return this.blX.Sn();
        }
        return 0;
    }

    public int Rt() {
        if (this.blU != null) {
            return this.blU.Sp();
        }
        return 0;
    }

    public int Ru() {
        if (this.blX != null) {
            return this.blX.Ru();
        }
        return 0;
    }

    public int Rv() {
        if (this.bmc != null) {
            return this.bmc.SZ();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aF(int i) {
        if (this.bcd != null) {
            return this.bcd.aF(i);
        }
        return null;
    }

    public List<com.baidu.adp.widget.ListView.u> getDatas() {
        if (this.bcd != null) {
            return this.bcd.getData();
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.bcG != null && this.bcG.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.as.UV.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bml) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).gH(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(this.bmj);
                }
            }
        }
    }
}
