package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dp;
import com.baidu.tieba.frs.dv;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.eh;
import com.baidu.tieba.frs.ej;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.ey;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements v {
    private FrsActivity bjB;
    private cm boA;
    private i boB;
    private g boC;
    private g boD;
    private dc boE;
    private com.baidu.tieba.frs.g.a boF;
    private com.baidu.tieba.frs.b.a boG;
    private com.baidu.tieba.frs.a.a boH;
    private final HashMap<Integer, ax> boI;
    private BdExpandListView bof;
    private q bog;
    private l boh;
    private cf boi;
    private com.baidu.tieba.frs.view.s boj;
    private ey bok;
    private bm bol;
    private b bom;
    private a bon;
    private ee boo;
    private e bop;
    private dm boq;
    private dv bor;
    private dn bos;
    private u bot;
    private p bou;
    private com.baidu.tieba.frs.d.a bov;
    private com.baidu.tieba.frs.d.c bow;
    private com.baidu.tieba.frs.d.e box;
    private com.baidu.tieba.frs.c.a boy;
    private eh boz;
    private List<com.baidu.adp.widget.ListView.a> bei = new LinkedList();
    private boolean bfl = false;
    private CustomMessageListener boJ = new d(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private final bv biy = new bv();

    public c(FrsActivity frsActivity, BdExpandListView bdExpandListView, boolean z) {
        this.bof = bdExpandListView;
        a(frsActivity, bdExpandListView);
        this.boI = new HashMap<>();
        cG(z);
    }

    public void a(FrsActivity frsActivity, BdExpandListView bdExpandListView) {
        this.bjB = frsActivity;
        this.bog = new q(frsActivity.getPageContext(), ax.TYPE_NORMAL);
        this.boh = new l(frsActivity.getPageContext(), ax.PU);
        this.bok = new ey(frsActivity, ax.PT);
        this.bot = new u(frsActivity.getPageContext(), ax.PV);
        this.bou = new p(frsActivity.getPageContext(), ax.PW);
        this.bol = new bm(frsActivity, com.baidu.tbadk.core.data.c.MG, false);
        this.bom = new b(frsActivity, com.baidu.tbadk.core.data.c.MH);
        this.bon = new a(frsActivity, com.baidu.tbadk.core.data.c.MI);
        this.bop = new e(frsActivity.getPageContext(), ag.OY);
        this.boq = new dm(frsActivity, aa.erz, false);
        this.bor = new dv(frsActivity, am.Pi);
        this.bov = new com.baidu.tieba.frs.d.a(frsActivity, com.baidu.tbadk.core.data.c.ML);
        this.box = new com.baidu.tieba.frs.d.e(frsActivity, com.baidu.tbadk.core.data.c.MK);
        this.bow = new com.baidu.tieba.frs.d.c(frsActivity, com.baidu.tbadk.core.data.c.MJ);
        this.boE = new dc(frsActivity, dd.bkD);
        this.bos = new dn(frsActivity, ah.Pc);
        this.boy = new com.baidu.tieba.frs.c.a(frsActivity, com.baidu.tbadk.core.data.r.NY);
        this.boC = new g(frsActivity.getPageContext(), ax.PX);
        this.boD = new g(frsActivity.getPageContext(), ax.PY);
        this.boi = new cf(frsActivity, com.baidu.tieba.tbadkCore.h.eqr, true);
        this.boj = new com.baidu.tieba.frs.view.s(frsActivity, com.baidu.tieba.card.a.p.aSn, true);
        this.boz = new eh(frsActivity, ax.QO, false);
        this.boA = new cm(frsActivity, ax.QU);
        this.boF = new com.baidu.tieba.frs.g.a(frsActivity, ax.PZ);
        this.boB = new i(frsActivity, ax.QN);
        this.boG = new com.baidu.tieba.frs.b.a(frsActivity, x.OC);
        this.boH = new com.baidu.tieba.frs.a.a(frsActivity, aj.erN);
        this.bei.add(this.bog);
        this.bei.add(this.boh);
        this.bei.add(this.bok);
        this.bei.add(this.bol);
        this.bei.add(this.bom);
        this.bei.add(this.bon);
        this.bei.add(this.bop);
        this.bei.add(this.boq);
        this.bei.add(this.bor);
        this.bei.add(this.bov);
        this.bei.add(this.box);
        this.bei.add(this.bow);
        this.bei.add(this.boo);
        this.bei.add(this.boE);
        this.bei.add(this.bot);
        this.bei.add(this.bou);
        this.bei.add(this.bos);
        this.bei.add(this.boC);
        this.bei.add(this.boD);
        this.bei.add(this.boy);
        this.bei.add(new ej(frsActivity, ek.blX));
        this.bei.add(this.boi);
        this.bei.add(this.boj);
        this.bei.add(this.boz);
        this.bei.add(this.boA);
        this.bei.add(this.boF);
        this.bei.add(this.boB);
        this.bei.add(this.boG);
        this.bei.add(this.boH);
        this.boJ.setPriority(1);
        this.boJ.setSelfListener(true);
        frsActivity.registerListener(this.boJ);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        af(this.bei);
        bdExpandListView.g(this.bei);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
            if (aVar instanceof bw) {
                ((bw) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(oVar);
        com.baidu.tieba.tbadkCore.v.ao(arrayList);
        C(arrayList);
        D(arrayList);
        this.bof.setData(arrayList);
    }

    private ArrayList<Integer> C(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (vVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.boI != null && !this.boI.containsValue(vVar)) {
                    this.boI.put(Integer.valueOf(i2), (ax) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void cG(boolean z) {
        if (this.bfl != z) {
            this.bfl = z;
            if (this.boy != null) {
                this.boy.cG(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public HashMap<Integer, ax> Sv() {
        return this.boI;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void av(String str, String str2) {
        if (this.bor != null) {
            this.bor.av(str, str2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void l(View.OnClickListener onClickListener) {
        if (this.bol != null) {
            this.bol.l(onClickListener);
        }
        if (this.bom != null) {
            this.bom.l(onClickListener);
        }
        if (this.bon != null) {
            this.bon.l(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void m(View.OnClickListener onClickListener) {
        if (this.bol != null) {
            this.bol.m(onClickListener);
        }
        if (this.bom != null) {
            this.bom.m(onClickListener);
        }
        if (this.bon != null) {
            this.bon.m(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void n(View.OnClickListener onClickListener) {
        if (this.bol != null) {
            this.bol.n(onClickListener);
        }
        if (this.bom != null) {
            this.bom.n(onClickListener);
        }
        if (this.bon != null) {
            this.bon.n(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void Sw() {
        if (this.bof != null && this.bof.getData() != null && this.bof.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.bof.getData()) {
                if ((vVar instanceof ax) && ((ax) vVar).getIs_top() != 0) {
                    ((ax) vVar).parser_title();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void notifyDataSetChanged() {
        if (this.bof.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bof.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void setFromCDN(boolean z) {
        if (this.bei != null && this.bei.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
                if (aVar instanceof bw) {
                    ((bw) aVar).setFromCDN(z);
                }
            }
            if (this.bog != null) {
                this.bog.setFromCDN(z);
            }
            if (this.boh != null) {
                this.boh.setFromCDN(z);
            }
            if (this.boC != null) {
                this.boC.setFromCDN(z);
            }
            if (this.boD != null) {
                this.boD.setFromCDN(z);
            }
            if (this.bom != null) {
                this.bom.setFromCDN(z);
            }
            if (this.bon != null) {
                this.bon.setFromCDN(z);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bei != null && this.bei.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
                if (aVar instanceof bw) {
                    ((bw) aVar).a(oVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void a(bi biVar) {
        if (this.bei != null && this.bei.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
                if (aVar instanceof bw) {
                    ((bw) aVar).a(biVar);
                }
                if (aVar instanceof dp) {
                    ((bw) aVar).a(biVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Rt() {
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Pz() {
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Rv() {
        if (this.boq != null) {
            return this.boq.Rv();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Ru() {
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Rw() {
        if (this.boq != null) {
            return this.boq.Rw();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Sx() {
        if (this.bos != null) {
            return this.bos.Rx();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Sy() {
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Ry() {
        if (this.bos != null) {
            return this.bos.Ry();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public int Sz() {
        if (this.boy != null) {
            return this.boy.Tl();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void a(w wVar) {
        if (this.bei != null && this.bei.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
                if (aVar instanceof bw) {
                    ((bw) aVar).a(wVar);
                } else if ((aVar instanceof q) || (aVar instanceof e) || (aVar instanceof l) || (aVar instanceof g) || (aVar instanceof i) || (aVar instanceof u)) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bei != null && this.bei.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
                if (aVar instanceof bw) {
                    ((bw) aVar).a(xVar);
                } else if ((aVar instanceof q) || (aVar instanceof e) || (aVar instanceof g) || (aVar instanceof i) || (aVar instanceof l)) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public com.baidu.adp.widget.ListView.v as(int i) {
        if (this.bof != null) {
            return this.bof.as(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.v
    public List<com.baidu.adp.widget.ListView.v> getDatas() {
        if (this.bof != null) {
            return this.bof.getData();
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.bei != null && this.bei.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != ax.PT.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bei) {
                if (aVar instanceof bw) {
                    ((bw) aVar).gm(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bw) {
                    ((bw) aVar).a(this.biy);
                }
            }
        }
    }
}
