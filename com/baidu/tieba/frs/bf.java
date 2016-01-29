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
public class bf {
    private BdTypeListView aXu;
    private FrsActivity bgW;
    private dw bgX;
    private db bgY;
    private View.OnClickListener bgZ;
    private View.OnClickListener bha;
    private df bhb;
    private ce bhc;
    private com.baidu.tieba.frs.view.r bhd;
    private ey bhe;
    private bl bhf;
    private bq bhg;
    private bn bhh;
    private ec bhi;
    private Cdo bhj;
    private dl bhk;
    private dx bhl;
    private dm bhm;
    private fa bhn;
    private com.baidu.tieba.frs.b.a bho;
    private com.baidu.tieba.frs.b.c bhp;
    private com.baidu.tieba.frs.b.e bhq;
    private com.baidu.tieba.frs.a.a bhr;
    private ee bhs;
    private dr bht;
    private es bhu;
    private dc bhv;
    private final HashMap<Integer, com.baidu.tbadk.core.data.ah> bhw;
    private List<com.baidu.adp.widget.ListView.a> aXX = new LinkedList();
    private boolean bez = false;
    private CustomMessageListener bhy = new bg(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private boolean bhz = false;
    private boolean anN = false;
    private final bu bhx = new bu();

    public bf(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aXu = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bhw = new HashMap<>();
        ck(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bgW = frsActivity;
        this.bhb = new df(frsActivity, com.baidu.tbadk.core.data.ah.WG);
        this.bhe = new ey(frsActivity, com.baidu.tbadk.core.data.ah.WF);
        this.bhn = new fa(frsActivity, com.baidu.tbadk.core.data.ah.WH);
        this.bhf = new bl(frsActivity, com.baidu.tbadk.core.data.c.Um);
        this.bhg = new bq(frsActivity, com.baidu.tbadk.core.data.c.Un);
        this.bhh = new bn(frsActivity, com.baidu.tbadk.core.data.c.Uo);
        this.bhj = new Cdo(frsActivity, com.baidu.tbadk.core.data.w.VW);
        this.bhk = new dl(frsActivity, com.baidu.tieba.tbadkCore.z.dVD);
        this.bhl = new dx(frsActivity, com.baidu.tbadk.core.data.y.Wa);
        this.bho = new com.baidu.tieba.frs.b.a(frsActivity, com.baidu.tbadk.core.data.c.Ur);
        this.bhq = new com.baidu.tieba.frs.b.e(frsActivity, com.baidu.tbadk.core.data.c.Uq);
        this.bhp = new com.baidu.tieba.frs.b.c(frsActivity, com.baidu.tbadk.core.data.c.Up);
        this.bhi = new ec(frsActivity, com.baidu.tbadk.core.data.ab.Wt);
        this.bhv = new dc(frsActivity, dd.bkd);
        this.bhm = new dm(frsActivity, com.baidu.tbadk.core.data.x.VY);
        this.bhr = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.n.Vv);
        this.bht = new dr(frsActivity, com.baidu.tbadk.core.data.ah.WI);
        this.bhu = new es(frsActivity, com.baidu.tbadk.core.data.ah.WJ);
        this.bhc = new ce(frsActivity, com.baidu.tieba.tbadkCore.h.dUB);
        this.bhd = new com.baidu.tieba.frs.view.r(frsActivity, com.baidu.tieba.card.a.u.aSH);
        this.bhs = new ee(frsActivity, com.baidu.tbadk.core.data.ah.Xw);
        this.aXX.add(this.bhb);
        this.aXX.add(this.bhe);
        this.aXX.add(this.bhf);
        this.aXX.add(this.bhg);
        this.aXX.add(this.bhh);
        this.aXX.add(this.bhj);
        this.aXX.add(this.bhk);
        this.aXX.add(this.bhl);
        this.aXX.add(this.bho);
        this.aXX.add(this.bhq);
        this.aXX.add(this.bhp);
        this.aXX.add(this.bhi);
        this.aXX.add(this.bhv);
        this.aXX.add(this.bhn);
        this.aXX.add(this.bhm);
        this.aXX.add(this.bht);
        this.aXX.add(this.bhu);
        this.aXX.add(this.bhr);
        this.aXX.add(new ek(frsActivity, el.bls));
        this.aXX.add(this.bhc);
        this.aXX.add(this.bhd);
        this.aXX.add(this.bhs);
        this.bhy.setPriority(1);
        this.bhy.setSelfListener(true);
        frsActivity.registerListener(this.bhy);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        ad(this.aXX);
        bdTypeListView.g(this.aXX);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof bv) {
                ((bv) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        F(arrayList);
        G(arrayList);
        this.aXu.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.bhz, this.anN);
    }

    public int Pw() {
        return this.aXu.getHeaderViewsCount();
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
            if (uVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bhw != null && !this.bhw.containsValue(uVar)) {
                    this.bhw.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.ah) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void ck(boolean z) {
        if (this.bez != z) {
            this.bez = z;
            if (this.bhb != null) {
                this.bhb.ck(z);
            }
            if (this.bhr != null) {
                this.bhr.ck(z);
            }
        }
    }

    public void cq(boolean z) {
        if (this.bgY != null) {
            this.bgY.cq(z);
        }
    }

    public void cr(boolean z) {
        if (this.bgX != null) {
            this.bgX.cr(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.ah> Px() {
        return this.bhw;
    }

    public void ao(String str, String str2) {
        if (this.bhl != null) {
            this.bhl.ao(str, str2);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.bhf != null) {
            this.bhf.l(onClickListener);
        }
        if (this.bhg != null) {
            this.bhg.l(onClickListener);
        }
        if (this.bhh != null) {
            this.bhh.l(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.bhf != null) {
            this.bhf.m(onClickListener);
        }
        if (this.bhg != null) {
            this.bhg.m(onClickListener);
        }
        if (this.bhh != null) {
            this.bhh.m(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.bhf != null) {
            this.bhf.n(onClickListener);
        }
        if (this.bhg != null) {
            this.bhg.n(onClickListener);
        }
        if (this.bhh != null) {
            this.bhh.n(onClickListener);
        }
    }

    public void Py() {
        if (this.aXu != null && this.aXu.getData() != null && this.aXu.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aXu.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.ah) && ((com.baidu.tbadk.core.data.ah) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.ah) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgX != null) {
            this.bgX.onChangeSkinType(i);
        }
        if (this.bgY != null) {
            this.bgY.onChangeSkinType(i);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bh bhVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(bhVar);
                }
                if (aVar instanceof dr) {
                    ((bv) aVar).a(bhVar);
                }
            }
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.bgZ = onClickListener;
        if (this.bgX != null) {
            this.bgX.o(onClickListener);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.bha = onClickListener;
        if (this.bgY != null) {
            this.bgY.r(onClickListener);
        }
    }

    public int Pz() {
        if (this.bhb != null) {
            return this.bhb.Pz();
        }
        return 0;
    }

    public int OL() {
        if (this.bhb != null) {
            return this.bhb.OL();
        }
        return 0;
    }

    public int PA() {
        if (this.bhk != null) {
            return this.bhk.PA();
        }
        return 0;
    }

    public int PB() {
        if (this.bhb != null) {
            return this.bhb.PB();
        }
        return 0;
    }

    public int PC() {
        if (this.bhk != null) {
            return this.bhk.PC();
        }
        return 0;
    }

    public int PD() {
        if (this.bhm != null) {
            return this.bhm.Qu();
        }
        return 0;
    }

    public int PE() {
        if (this.bhj != null) {
            return this.bhj.Qw();
        }
        return 0;
    }

    public int PF() {
        if (this.bhm != null) {
            return this.bhm.PF();
        }
        return 0;
    }

    public int PG() {
        if (this.bhr != null) {
            return this.bhr.Rm();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aG(int i) {
        if (this.aXu != null) {
            return this.aXu.aG(i);
        }
        return null;
    }

    public List<com.baidu.adp.widget.ListView.u> getDatas() {
        if (this.aXu != null) {
            return this.aXu.getData();
        }
        return null;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aXX != null && this.aXX.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.ah.WF.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bhz) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).gq(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(this.bhx);
                }
            }
        }
    }
}
