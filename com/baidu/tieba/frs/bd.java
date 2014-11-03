package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class bd {
    private BdTypeListView aBA;
    private cr aBB;
    private ci aBC;
    private View.OnClickListener aBD;
    private View.OnClickListener aBE;
    private cj aBF;
    private da aBG;
    private bi aBH;
    private bk aBI;
    private bp aBJ;
    private cp aBK;
    private ct aBL;
    private final HashMap<Integer, com.baidu.tbadk.core.data.q> aBN;
    private FrsActivity aBz;
    private List<com.baidu.adp.widget.ListView.a> aBM = new ArrayList();
    private boolean ayY = false;
    private boolean aBO = false;
    private boolean Oc = false;

    public bd(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aBA = bdTypeListView;
        this.aBN = new HashMap<>();
        bL(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aBz = frsActivity;
        this.aBF = new cj(frsActivity, com.baidu.tbadk.core.data.q.Ao);
        this.aBG = new da(frsActivity, com.baidu.tbadk.core.data.q.An);
        this.aBH = new bi(frsActivity, com.baidu.tbadk.core.data.a.zd);
        this.aBI = new bk(frsActivity, com.baidu.tbadk.core.data.a.ze);
        this.aBJ = new bp(frsActivity, com.baidu.tbadk.core.data.i.zN);
        this.aBK = new cp(frsActivity, com.baidu.tieba.data.af.alI);
        this.aBL = new ct(frsActivity, com.baidu.tbadk.core.data.o.Ab);
        this.aBM.add(this.aBF);
        this.aBM.add(this.aBG);
        this.aBM.add(this.aBH);
        this.aBM.add(this.aBI);
        this.aBM.add(this.aBJ);
        this.aBM.add(this.aBK);
        this.aBM.add(this.aBL);
        bdTypeListView.e(this.aBM);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.al> arrayList, b bVar, boolean z, boolean z2) {
        setForumModel(bVar);
        this.Oc = z2;
        bZ(this.Oc);
        this.aBO = z;
        bY(this.aBO);
        s(arrayList);
        t(arrayList);
        this.aBA.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.al> arrayList, b bVar) {
        a(arrayList, bVar, this.aBO, this.Oc);
    }

    private ArrayList<Integer> s(ArrayList<com.baidu.adp.widget.ListView.al> arrayList) {
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
            com.baidu.adp.widget.ListView.al alVar = arrayList.get(i2);
            if (alVar instanceof com.baidu.tbadk.core.data.a) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aBN != null && !this.aBN.containsValue(alVar)) {
                    this.aBN.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.q) alVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bL(boolean z) {
        if (this.ayY != z) {
            this.ayY = z;
            if (this.aBF != null) {
                this.aBF.bL(z);
            }
        }
    }

    public void bW(boolean z) {
        if (this.aBC != null) {
            this.aBC.bW(z);
        }
    }

    public boolean FM() {
        if (this.aBC != null) {
            return this.aBC.FM();
        }
        return false;
    }

    public void bX(boolean z) {
        if (this.aBB != null) {
            this.aBB.bX(z);
        }
    }

    public boolean FN() {
        if (this.aBB != null) {
            return this.aBB.FN();
        }
        return false;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.q> FO() {
        return this.aBN;
    }

    public void ae(String str, String str2) {
        if (this.aBL != null) {
            this.aBL.ae(str, str2);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aBH != null) {
            this.aBH.i(onClickListener);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        if (this.aBH != null) {
            this.aBH.j(onClickListener);
        }
        if (this.aBI != null) {
            this.aBI.j(onClickListener);
        }
    }

    public void FP() {
        if (this.aBA != null && this.aBA.getData() != null && this.aBA.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.al alVar : this.aBA.getData()) {
                if ((alVar instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) alVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.q) alVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aBA.getAdapter() instanceof com.baidu.adp.widget.ListView.j) {
            ((com.baidu.adp.widget.ListView.j) this.aBA.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aBB != null) {
            this.aBB.onChangeSkinType(i);
        }
        if (this.aBC != null) {
            this.aBC.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aBA.getAdapter() instanceof com.baidu.adp.widget.ListView.j) {
            ((com.baidu.adp.widget.ListView.j) this.aBA.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aBM != null && this.aBM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBM) {
                if (aVar instanceof bm) {
                    ((bm) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void setForumModel(b bVar) {
        if (this.aBM != null && this.aBM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBM) {
                if (aVar instanceof bm) {
                    ((bm) aVar).h(bVar);
                }
            }
        }
    }

    public void a(be beVar) {
        if (this.aBM != null && this.aBM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBM) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(beVar);
                }
            }
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aBD = onClickListener;
        if (this.aBB != null) {
            this.aBB.k(onClickListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.aBE = onClickListener;
        if (this.aBC != null) {
            this.aBC.n(onClickListener);
        }
    }

    public int EN() {
        if (this.aBF != null) {
            return this.aBF.EN();
        }
        return 0;
    }

    public int EO() {
        if (this.aBF != null) {
            return this.aBF.EO();
        }
        return 0;
    }

    public int EP() {
        if (this.aBF != null) {
            return this.aBF.EP();
        }
        return 0;
    }

    public int FQ() {
        if (this.aBK != null) {
            return this.aBK.FQ();
        }
        return 0;
    }

    public int FR() {
        if (this.aBK != null) {
            return this.aBK.FR();
        }
        return 0;
    }

    private void bY(boolean z) {
        if (z) {
            if (this.aBB == null) {
                this.aBB = new cr(this.aBz);
                this.aBB.k(this.aBD);
            }
            if (this.aBA != null) {
                this.aBA.setPrePage(this.aBB);
            }
        } else if (this.aBB != null && this.aBA != null) {
            this.aBA.setPrePage(null);
        }
    }

    private void bZ(boolean z) {
        if (z) {
            if (this.aBC == null) {
                this.aBC = new ci(this.aBz);
                this.aBC.n(this.aBE);
            }
            if (this.aBA != null) {
                this.aBA.setNextPage(this.aBC);
            }
        } else if (this.aBC != null && this.aBA != null) {
            this.aBA.setNextPage(null);
        }
    }

    public void a(com.baidu.adp.widget.ListView.am amVar) {
        if (this.aBM != null && this.aBM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBM) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(amVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        if (this.aBM != null && this.aBM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBM) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(anVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.al ai(int i) {
        if (this.aBA != null) {
            return this.aBA.ai(i);
        }
        return null;
    }

    private void t(ArrayList<com.baidu.adp.widget.ListView.al> arrayList) {
        int i;
        if (this.aBM != null && this.aBM.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.al> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().hu().getId() != com.baidu.tbadk.core.data.q.An.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aBO) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aBM) {
                if (aVar instanceof bm) {
                    ((bm) aVar).eI(i);
                }
            }
        }
    }
}
