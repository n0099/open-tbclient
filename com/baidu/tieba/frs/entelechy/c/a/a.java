package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.util.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private String aAB;
    private ViewGroup abK;
    private f ckn;
    private TextView cow;
    private List<x> cox;
    private com.baidu.tieba.frs.entelechy.c.a.a.a coy;
    private int coz = -1;
    private boolean coA = false;
    private View.OnClickListener coB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!i.hf()) {
                a.this.ckn.showToast(d.l.neterror);
                return;
            }
            if (a.this.coy == null) {
                a.this.coy = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.ckn, a.this.coC);
            }
            a.this.coy.setData(a.this.cox);
            a.this.coy.d(a.this.ckn.getPageContext()).tu();
        }
    };
    private b.InterfaceC0043b coC = new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(b bVar, int i, View view) {
            if (!i.hf()) {
                a.this.ckn.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) u.c(a.this.coy.ahk(), i);
            if (xVar != null) {
                if (a.this.coz != xVar.clK) {
                    a.this.coA = true;
                    a.this.cow.setText(xVar.name);
                    if (a.this.coz == 7) {
                        aj ajVar = new aj("c11437");
                        ajVar.r("obj_locate", xVar.clK);
                        ajVar.aa("fid", a.this.aAB);
                        TiebaStatic.log(ajVar);
                    }
                    if (a.this.ckn.aeU() != null) {
                        a.this.ckn.aeU().jg(a.this.coz);
                        a.this.coz = xVar.clK;
                        bVar.dismiss();
                        if (a.this.coz != 7) {
                            s.Hs();
                            g.btv();
                        } else {
                            g.btu();
                        }
                        if (a.this.ckn.aeU() != null && a.this.ckn.aeZ() != null) {
                            a.this.ckn.aeU().jf(xVar.clK);
                            a.this.ckn.aeZ().startPullRefresh();
                            a.this.ckn.aeU().eX(true);
                            com.baidu.tieba.frs.smartsort.d.aiU().g(a.this.ckn.aeU().getForumName(), xVar.clK, xVar.name);
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
        this.aAB = str;
    }

    public TextView ahh() {
        return this.cow;
    }

    public void kl(String str) {
        this.cow.setText(str);
    }

    public void iU(int i) {
        this.coz = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.ckn = fVar;
            this.abK = viewGroup;
            this.cow = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(fVar.getActivity(), d.f.ds82));
            layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
            int g = k.g(fVar.getActivity(), d.f.ds30);
            this.cow.setPadding(g, 0, g, 0);
            this.cow.setGravity(17);
            this.cow.setTextSize(0, k.g(fVar.getActivity(), d.f.ds28));
            this.cow.setCompoundDrawablePadding(k.g(fVar.getActivity(), d.f.ds8));
            this.cow.setLayoutParams(layoutParams);
            this.cow.setOnClickListener(this.coB);
            this.abK.addView(this.cow);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cow != null) {
            ai.i(this.cow, d.e.cp_cont_f);
            ai.k(this.cow, d.e.transparent);
            this.cow.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (u.v(list)) {
            ahj();
        } else if (this.ckn != null && this.ckn.aeU() != null && this.ckn.aeU().aiz()) {
            ahi();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aI(arrayList)) {
                if (!this.coA) {
                    iV(i);
                    return;
                }
                return;
            }
            this.cox = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.clK = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.cox.add(xVar);
                }
            }
            if (!this.coA) {
                iV(i);
            }
        } else {
            ahj();
        }
    }

    private void iV(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.cox.get(0);
            if (xVar3 != null) {
                iU(xVar3.clK);
                kl(xVar3.name);
                if (this.ckn != null && this.ckn.aeU() != null) {
                    this.ckn.aeU().jf(xVar3.clK);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cox.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.cox.get(i2);
                if (xVar2 == null || xVar2.clK != i) {
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
                kl(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            x xVar4 = this.cox.get(0);
            if (xVar4 != null) {
                iU(xVar4.clK);
                kl(xVar4.name);
                if (this.ckn != null && this.ckn.aeU() != null) {
                    this.ckn.aeU().jf(xVar4.clK);
                }
            }
        } else if (xVar != null) {
            iU(xVar.clK);
            kl(xVar.name);
            if (this.ckn != null && this.ckn.aeU() != null) {
                this.ckn.aeU().jf(xVar.clK);
            }
        }
    }

    private boolean aI(List<FrsTabInfo> list) {
        if (!u.v(this.cox) && u.u(list) == u.u(this.cox)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cox.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ahi() {
        if (this.cow != null) {
            this.cow.setVisibility(0);
        }
    }

    public void ahj() {
        if (this.cow != null) {
            this.cow.setVisibility(8);
        }
    }
}
