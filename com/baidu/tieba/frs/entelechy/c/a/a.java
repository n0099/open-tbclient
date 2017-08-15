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
    private String aAC;
    private ViewGroup abM;
    private f ckZ;
    private TextView cpe;
    private List<x> cpf;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cpg;
    private int cph = -1;
    private boolean cpi = false;
    private View.OnClickListener cpj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!i.hf()) {
                a.this.ckZ.showToast(d.l.neterror);
                return;
            }
            if (a.this.cpg == null) {
                a.this.cpg = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.ckZ, a.this.cpk);
            }
            a.this.cpg.setData(a.this.cpf);
            a.this.cpg.d(a.this.ckZ.getPageContext()).tu();
        }
    };
    private b.InterfaceC0043b cpk = new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(b bVar, int i, View view) {
            if (!i.hf()) {
                a.this.ckZ.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) u.c(a.this.cpg.ahF(), i);
            if (xVar != null) {
                if (a.this.cph != xVar.cmw) {
                    a.this.cpi = true;
                    a.this.cpe.setText(xVar.name);
                    if (a.this.cph == 7) {
                        aj ajVar = new aj("c11437");
                        ajVar.r("obj_locate", xVar.cmw);
                        ajVar.aa("fid", a.this.aAC);
                        TiebaStatic.log(ajVar);
                    }
                    if (a.this.ckZ.afq() != null) {
                        a.this.ckZ.afq().jq(a.this.cph);
                        a.this.cph = xVar.cmw;
                        bVar.dismiss();
                        if (a.this.cph != 7) {
                            s.Hs();
                            g.bud();
                        } else {
                            g.buc();
                        }
                        if (a.this.ckZ.afq() != null && a.this.ckZ.afv() != null) {
                            a.this.ckZ.afq().jp(xVar.cmw);
                            a.this.ckZ.afv().startPullRefresh();
                            a.this.ckZ.afq().fa(true);
                            com.baidu.tieba.frs.smartsort.d.ajB().g(a.this.ckZ.afq().getForumName(), xVar.cmw, xVar.name);
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
        this.aAC = str;
    }

    public TextView ahC() {
        return this.cpe;
    }

    public void kn(String str) {
        this.cpe.setText(str);
    }

    public void iW(int i) {
        this.cph = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.ckZ = fVar;
            this.abM = viewGroup;
            this.cpe = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(TbadkCoreApplication.getInst(), d.f.ds82));
            layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
            int g = k.g(fVar.getActivity(), d.f.ds30);
            this.cpe.setPadding(g, 0, g, 0);
            this.cpe.setGravity(17);
            this.cpe.setTextSize(0, k.g(fVar.getActivity(), d.f.ds28));
            this.cpe.setCompoundDrawablePadding(k.g(fVar.getActivity(), d.f.ds8));
            this.cpe.setLayoutParams(layoutParams);
            this.cpe.setOnClickListener(this.cpj);
            this.abM.addView(this.cpe);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cpe != null) {
            ai.i(this.cpe, d.e.cp_cont_f);
            ai.k(this.cpe, d.e.transparent);
            this.cpe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (u.v(list)) {
            ahE();
        } else if (this.ckZ != null && this.ckZ.afq() != null && this.ckZ.afq().ajg()) {
            ahD();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aI(arrayList)) {
                if (!this.cpi) {
                    iX(i);
                    return;
                }
                return;
            }
            this.cpf = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.cmw = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.cpf.add(xVar);
                }
            }
            if (!this.cpi) {
                iX(i);
            }
        } else {
            ahE();
        }
    }

    private void iX(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.cpf.get(0);
            if (xVar3 != null) {
                iW(xVar3.cmw);
                kn(xVar3.name);
                if (this.ckZ != null && this.ckZ.afq() != null) {
                    this.ckZ.afq().jp(xVar3.cmw);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cpf.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.cpf.get(i2);
                if (xVar2 == null || xVar2.cmw != i) {
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
                kn(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            x xVar4 = this.cpf.get(0);
            if (xVar4 != null) {
                iW(xVar4.cmw);
                kn(xVar4.name);
                if (this.ckZ != null && this.ckZ.afq() != null) {
                    this.ckZ.afq().jp(xVar4.cmw);
                }
            }
        } else if (xVar != null) {
            iW(xVar.cmw);
            kn(xVar.name);
            if (this.ckZ != null && this.ckZ.afq() != null) {
                this.ckZ.afq().jp(xVar.cmw);
            }
        }
    }

    private boolean aI(List<FrsTabInfo> list) {
        if (!u.v(this.cpf) && u.u(list) == u.u(this.cpf)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cpf.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ahD() {
        if (this.cpe != null) {
            this.cpe.setVisibility(0);
        }
    }

    public void ahE() {
        if (this.cpe != null) {
            this.cpe.setVisibility(8);
        }
    }
}
