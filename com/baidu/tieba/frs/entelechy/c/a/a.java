package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class a {
    private View bzH;
    private FrsFragment dNc;
    private View dUu;
    private TextView dUv;
    private TextView dUw;
    private List<x> dUx;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dUy;
    private String dbs;
    private ViewGroup mRootView;
    private int dUz = -1;
    private boolean dUA = false;
    private View.OnClickListener dUB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.aBg().aBh()) {
                if (!j.kK()) {
                    a.this.dNc.showToast(e.j.neterror);
                } else if (!v.I(a.this.dUx)) {
                    if (a.this.dUy == null) {
                        a.this.dUy = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dNc, a.this.dUC);
                    }
                    a.this.dUy.setData(a.this.dUx);
                    a.this.dUy.d(a.this.dNc.getPageContext()).BV();
                }
            }
        }
    };
    private b.InterfaceC0158b dUC = new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(b bVar, int i, View view) {
            if (!j.kK()) {
                a.this.dNc.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dUy.aFu(), i);
            if (xVar != null) {
                if (a.this.dUz != xVar.dON) {
                    a.this.dUA = true;
                    a.this.oF(xVar.name);
                    if (a.this.dNc.aBP() != null) {
                        a.this.dNc.aBP().nq(a.this.dUz);
                        a.this.dUz = xVar.dON;
                        bVar.dismiss();
                        if (a.this.dUz != 7) {
                            w.QD();
                            com.baidu.tieba.tbadkCore.util.e.bFQ();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bFP();
                        }
                        if (a.this.dNc.aBP() != null && a.this.dNc.aBU() != null) {
                            a.this.dNc.aBP().np(xVar.dON);
                            a.this.dNc.aBU().startPullRefresh();
                            a.this.dNc.aBP().hr(true);
                            a.this.aFr();
                            return;
                        }
                        return;
                    }
                    return;
                }
                bVar.dismiss();
                return;
            }
            bVar.dismiss();
        }
    };

    public void setFid(String str) {
        this.dbs = str;
    }

    public TextView aFq() {
        return this.dUv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(String str) {
        this.dUw.setText(str);
    }

    public void mO(int i) {
        this.dUz = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFr() {
        am amVar = new am("c11437");
        amVar.y("obj_type", this.dUz);
        amVar.aB(ImageViewerConfig.FORUM_ID, this.dbs);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dNc = frsFragment;
            this.mRootView = relativeLayout;
            this.dUu = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dUv = (TextView) this.dUu.findViewById(e.g.sort_tab_menu_button);
            this.dUw = (TextView) this.dUu.findViewById(e.g.sort_tab_sort_name);
            this.bzH = this.dUu.findViewById(e.g.sort_tab_divider_line);
            this.dUv.setOnClickListener(this.dUB);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dUv != null) {
            al.h(this.dUv, e.d.cp_cont_j);
            al.j(this.dUv, e.d.transparent);
            this.dUv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dUw, e.d.cp_cont_b);
        al.j(this.dUu, e.d.cp_bg_line_d);
        al.j(this.bzH, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.I(list)) {
            aFt();
        } else if (this.dNc != null && this.dNc.aBP() != null && this.dNc.aBP().aHz()) {
            aFs();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bI(arrayList)) {
                if (!this.dUA) {
                    mP(i);
                    return;
                }
                return;
            }
            this.dUx = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dON = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dUx.add(xVar);
                }
            }
            if (!this.dUA) {
                mP(i);
            }
        } else {
            aFt();
        }
    }

    private void mP(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dUx.get(0);
            if (xVar3 != null) {
                mO(xVar3.dON);
                oF(xVar3.name);
                if (this.dNc != null && this.dNc.aBP() != null) {
                    this.dNc.aBP().np(xVar3.dON);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dUx.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dUx.get(i2);
                if (xVar2 == null || xVar2.dON != i) {
                    i2++;
                } else {
                    xVar = xVar2;
                    z = true;
                    break;
                }
            } else {
                xVar = xVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                oF(TbadkCoreApplication.getInst().getResources().getString(e.j.attention_users_thread));
                return;
            }
            x xVar4 = this.dUx.get(0);
            if (xVar4 != null) {
                mO(xVar4.dON);
                oF(xVar4.name);
                if (this.dNc != null && this.dNc.aBP() != null) {
                    this.dNc.aBP().np(xVar4.dON);
                }
            }
        } else if (xVar != null) {
            mO(xVar.dON);
            oF(xVar.name);
            if (this.dNc != null && this.dNc.aBP() != null) {
                this.dNc.aBP().np(xVar.dON);
            }
        }
    }

    private boolean bI(List<FrsTabInfo> list) {
        if (!v.I(this.dUx) && v.H(list) == v.H(this.dUx)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dUx.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void aFs() {
        if (this.dUv != null) {
            this.dUv.setVisibility(0);
        }
    }

    private void aFt() {
        if (this.dUv != null) {
            this.dUv.setVisibility(8);
        }
    }
}
