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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class a {
    private View byP;
    private String cXO;
    private FrsFragment dJE;
    private View dQW;
    private TextView dQX;
    private TextView dQY;
    private List<x> dQZ;
    private com.baidu.tieba.frs.entelechy.c.a.a.a dRa;
    private int dRb = -1;
    private boolean dRc = false;
    private View.OnClickListener dRd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.azU().azV()) {
                if (!j.kK()) {
                    a.this.dJE.showToast(e.j.neterror);
                } else if (!v.I(a.this.dQZ)) {
                    if (a.this.dRa == null) {
                        a.this.dRa = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.dJE, a.this.dRe);
                    }
                    a.this.dRa.setData(a.this.dQZ);
                    a.this.dRa.d(a.this.dJE.getPageContext()).BI();
                }
            }
        }
    };
    private b.InterfaceC0158b dRe = new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(b bVar, int i, View view) {
            if (!j.kK()) {
                a.this.dJE.showToast(e.j.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) v.d(a.this.dRa.aEi(), i);
            if (xVar != null) {
                if (a.this.dRb != xVar.dLp) {
                    a.this.dRc = true;
                    a.this.ol(xVar.name);
                    if (a.this.dJE.aAD() != null) {
                        a.this.dJE.aAD().nc(a.this.dRb);
                        a.this.dRb = xVar.dLp;
                        bVar.dismiss();
                        if (a.this.dRb != 7) {
                            com.baidu.tbadk.util.v.Qg();
                            com.baidu.tieba.tbadkCore.util.e.bEq();
                        } else {
                            com.baidu.tieba.tbadkCore.util.e.bEp();
                        }
                        if (a.this.dJE.aAD() != null && a.this.dJE.aAI() != null) {
                            a.this.dJE.aAD().nb(xVar.dLp);
                            a.this.dJE.aAI().startPullRefresh();
                            a.this.dJE.aAD().hl(true);
                            a.this.aEf();
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
    private ViewGroup mRootView;

    public void setFid(String str) {
        this.cXO = str;
    }

    public TextView aEe() {
        return this.dQX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(String str) {
        this.dQY.setText(str);
    }

    public void mA(int i) {
        this.dRb = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        am amVar = new am("c11437");
        amVar.x("obj_type", this.dRb);
        amVar.aA(ImageViewerConfig.FORUM_ID, this.cXO);
        TiebaStatic.log(amVar);
    }

    public a(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.dJE = frsFragment;
            this.mRootView = relativeLayout;
            this.dQW = LayoutInflater.from(frsFragment.getContext()).inflate(e.h.frs_sort_tab_layout, relativeLayout);
            this.dQX = (TextView) this.dQW.findViewById(e.g.sort_tab_menu_button);
            this.dQY = (TextView) this.dQW.findViewById(e.g.sort_tab_sort_name);
            this.byP = this.dQW.findViewById(e.g.sort_tab_divider_line);
            this.dQX.setOnClickListener(this.dRd);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.dQX != null) {
            al.h(this.dQX, e.d.cp_cont_j);
            al.j(this.dQX, e.d.transparent);
            this.dQX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_arrow_gray_down), (Drawable) null);
        }
        al.h(this.dQY, e.d.cp_cont_b);
        al.j(this.dQW, e.d.cp_bg_line_d);
        al.j(this.byP, e.d.cp_bg_line_e);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.I(list)) {
            aEh();
        } else if (this.dJE != null && this.dJE.aAD() != null && this.dJE.aAD().aGn()) {
            aEg();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!bG(arrayList)) {
                if (!this.dRc) {
                    mB(i);
                    return;
                }
                return;
            }
            this.dQZ = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.dLp = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.dQZ.add(xVar);
                }
            }
            if (!this.dRc) {
                mB(i);
            }
        } else {
            aEh();
        }
    }

    private void mB(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.dQZ.get(0);
            if (xVar3 != null) {
                mA(xVar3.dLp);
                ol(xVar3.name);
                if (this.dJE != null && this.dJE.aAD() != null) {
                    this.dJE.aAD().nb(xVar3.dLp);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.dQZ.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.dQZ.get(i2);
                if (xVar2 == null || xVar2.dLp != i) {
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
                ol(TbadkCoreApplication.getInst().getResources().getString(e.j.attention_users_thread));
                return;
            }
            x xVar4 = this.dQZ.get(0);
            if (xVar4 != null) {
                mA(xVar4.dLp);
                ol(xVar4.name);
                if (this.dJE != null && this.dJE.aAD() != null) {
                    this.dJE.aAD().nb(xVar4.dLp);
                }
            }
        } else if (xVar != null) {
            mA(xVar.dLp);
            ol(xVar.name);
            if (this.dJE != null && this.dJE.aAD() != null) {
                this.dJE.aAD().nb(xVar.dLp);
            }
        }
    }

    private boolean bG(List<FrsTabInfo> list) {
        if (!v.I(this.dQZ) && v.H(list) == v.H(this.dQZ)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.dQZ.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void aEg() {
        if (this.dQX != null) {
            this.dQX.setVisibility(0);
        }
    }

    private void aEh() {
        if (this.dQX != null) {
            this.dQX.setVisibility(8);
        }
    }
}
