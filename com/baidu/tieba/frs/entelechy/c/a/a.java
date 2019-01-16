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
    private View bzG;
    private FrsFragment dNb;
    private View dUt;
    private TextView dUu;
    private TextView dUv;
    private List<x> dUw;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dUx;
    private String dbr;
    private ViewGroup mRootView;
    private int dUy = -1;
    private boolean dUz = false;
    private View.OnClickListener dUA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.aBg().aBh()) {
                if (!j.kK()) {
                    a.this.dNb.showToast(e.j.neterror);
                } else if (!v.I(a.this.dUw)) {
                    if (a.this.dUx == null) {
                        a.this.dUx = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dNb, a.this.dUB);
                    }
                    a.this.dUx.setData(a.this.dUw);
                    a.this.dUx.d(a.this.dNb.getPageContext()).BV();
                }
            }
        }
    };
    private b.InterfaceC0158b dUB = new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(b bVar, int i, View view) {
            if (!j.kK()) {
                a.this.dNb.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dUx.aFu(), i);
            if (xVar != null) {
                if (a.this.dUy != xVar.dOM) {
                    a.this.dUz = true;
                    a.this.oF(xVar.name);
                    if (a.this.dNb.aBP() != null) {
                        a.this.dNb.aBP().nq(a.this.dUy);
                        a.this.dUy = xVar.dOM;
                        bVar.dismiss();
                        if (a.this.dUy != 7) {
                            w.QD();
                            com.baidu.tieba.tbadkCore.util.e.bFQ();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bFP();
                        }
                        if (a.this.dNb.aBP() != null && a.this.dNb.aBU() != null) {
                            a.this.dNb.aBP().np(xVar.dOM);
                            a.this.dNb.aBU().startPullRefresh();
                            a.this.dNb.aBP().hr(true);
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
        this.dbr = str;
    }

    public TextView aFq() {
        return this.dUu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(String str) {
        this.dUv.setText(str);
    }

    public void mO(int i) {
        this.dUy = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFr() {
        am amVar = new am("c11437");
        amVar.y("obj_type", this.dUy);
        amVar.aB(ImageViewerConfig.FORUM_ID, this.dbr);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dNb = frsFragment;
            this.mRootView = relativeLayout;
            this.dUt = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dUu = (TextView) this.dUt.findViewById(e.g.sort_tab_menu_button);
            this.dUv = (TextView) this.dUt.findViewById(e.g.sort_tab_sort_name);
            this.bzG = this.dUt.findViewById(e.g.sort_tab_divider_line);
            this.dUu.setOnClickListener(this.dUA);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dUu != null) {
            al.h(this.dUu, e.d.cp_cont_j);
            al.j(this.dUu, e.d.transparent);
            this.dUu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dUv, e.d.cp_cont_b);
        al.j(this.dUt, e.d.cp_bg_line_d);
        al.j(this.bzG, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.I(list)) {
            aFt();
        } else if (this.dNb != null && this.dNb.aBP() != null && this.dNb.aBP().aHz()) {
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
                if (!this.dUz) {
                    mP(i);
                    return;
                }
                return;
            }
            this.dUw = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dOM = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dUw.add(xVar);
                }
            }
            if (!this.dUz) {
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
            x xVar3 = this.dUw.get(0);
            if (xVar3 != null) {
                mO(xVar3.dOM);
                oF(xVar3.name);
                if (this.dNb != null && this.dNb.aBP() != null) {
                    this.dNb.aBP().np(xVar3.dOM);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dUw.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dUw.get(i2);
                if (xVar2 == null || xVar2.dOM != i) {
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
            x xVar4 = this.dUw.get(0);
            if (xVar4 != null) {
                mO(xVar4.dOM);
                oF(xVar4.name);
                if (this.dNb != null && this.dNb.aBP() != null) {
                    this.dNb.aBP().np(xVar4.dOM);
                }
            }
        } else if (xVar != null) {
            mO(xVar.dOM);
            oF(xVar.name);
            if (this.dNb != null && this.dNb.aBP() != null) {
                this.dNb.aBP().np(xVar.dOM);
            }
        }
    }

    private boolean bI(List<FrsTabInfo> list) {
        if (!v.I(this.dUw) && v.H(list) == v.H(this.dUw)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dUw.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void aFs() {
        if (this.dUu != null) {
            this.dUu.setVisibility(0);
        }
    }

    private void aFt() {
        if (this.dUu != null) {
            this.dUu.setVisibility(8);
        }
    }
}
