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
    private String aAD;
    private ViewGroup abM;
    private f cla;
    private TextView cpf;
    private List<x> cpg;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cph;
    private int cpi = -1;
    private boolean cpj = false;
    private View.OnClickListener cpk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!i.hf()) {
                a.this.cla.showToast(d.l.neterror);
                return;
            }
            if (a.this.cph == null) {
                a.this.cph = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cla, a.this.cpl);
            }
            a.this.cph.setData(a.this.cpg);
            a.this.cph.d(a.this.cla.getPageContext()).tv();
        }
    };
    private b.InterfaceC0043b cpl = new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(b bVar, int i, View view) {
            if (!i.hf()) {
                a.this.cla.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) u.c(a.this.cph.ahz(), i);
            if (xVar != null) {
                if (a.this.cpi != xVar.cmx) {
                    a.this.cpj = true;
                    a.this.cpf.setText(xVar.name);
                    if (a.this.cpi == 7) {
                        aj ajVar = new aj("c11437");
                        ajVar.r("obj_locate", xVar.cmx);
                        ajVar.aa("fid", a.this.aAD);
                        TiebaStatic.log(ajVar);
                    }
                    if (a.this.cla.afk() != null) {
                        a.this.cla.afk().jq(a.this.cpi);
                        a.this.cpi = xVar.cmx;
                        bVar.dismiss();
                        if (a.this.cpi != 7) {
                            s.Hs();
                            g.btW();
                        } else {
                            g.btV();
                        }
                        if (a.this.cla.afk() != null && a.this.cla.afp() != null) {
                            a.this.cla.afk().jp(xVar.cmx);
                            a.this.cla.afp().startPullRefresh();
                            a.this.cla.afk().fa(true);
                            com.baidu.tieba.frs.smartsort.d.ajv().h(a.this.cla.afk().getForumName(), xVar.cmx, xVar.name);
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
        this.aAD = str;
    }

    public TextView ahw() {
        return this.cpf;
    }

    public void kq(String str) {
        this.cpf.setText(str);
    }

    public void iW(int i) {
        this.cpi = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.cla = fVar;
            this.abM = viewGroup;
            this.cpf = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(TbadkCoreApplication.getInst(), d.f.ds82));
            layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
            int g = k.g(fVar.getActivity(), d.f.ds30);
            this.cpf.setPadding(g, 0, g, 0);
            this.cpf.setGravity(17);
            this.cpf.setTextSize(0, k.g(fVar.getActivity(), d.f.ds28));
            this.cpf.setCompoundDrawablePadding(k.g(fVar.getActivity(), d.f.ds8));
            this.cpf.setLayoutParams(layoutParams);
            this.cpf.setOnClickListener(this.cpk);
            this.abM.addView(this.cpf);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cpf != null) {
            ai.i(this.cpf, d.e.cp_cont_f);
            ai.k(this.cpf, d.e.transparent);
            this.cpf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (u.v(list)) {
            ahy();
        } else if (this.cla != null && this.cla.afk() != null && this.cla.afk().aja()) {
            ahx();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aI(arrayList)) {
                if (!this.cpj) {
                    iX(i);
                    return;
                }
                return;
            }
            this.cpg = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.cmx = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.cpg.add(xVar);
                }
            }
            if (!this.cpj) {
                iX(i);
            }
        } else {
            ahy();
        }
    }

    private void iX(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.cpg.get(0);
            if (xVar3 != null) {
                iW(xVar3.cmx);
                kq(xVar3.name);
                if (this.cla != null && this.cla.afk() != null) {
                    this.cla.afk().jp(xVar3.cmx);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cpg.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.cpg.get(i2);
                if (xVar2 == null || xVar2.cmx != i) {
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
                kq(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            x xVar4 = this.cpg.get(0);
            if (xVar4 != null) {
                iW(xVar4.cmx);
                kq(xVar4.name);
                if (this.cla != null && this.cla.afk() != null) {
                    this.cla.afk().jp(xVar4.cmx);
                }
            }
        } else if (xVar != null) {
            iW(xVar.cmx);
            kq(xVar.name);
            if (this.cla != null && this.cla.afk() != null) {
                this.cla.afk().jp(xVar.cmx);
            }
        }
    }

    private boolean aI(List<FrsTabInfo> list) {
        if (!u.v(this.cpg) && u.u(list) == u.u(this.cpg)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cpg.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ahx() {
        if (this.cpf != null) {
            this.cpf.setVisibility(0);
        }
    }

    public void ahy() {
        if (this.cpf != null) {
            this.cpf.setVisibility(8);
        }
    }
}
