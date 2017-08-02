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
    private ViewGroup aan;
    private String azk;
    private f cjg;
    private TextView cnk;
    private List<x> cnl;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cnm;
    private int cnn = -1;
    private boolean cno = false;
    private View.OnClickListener cnp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!i.gV()) {
                a.this.cjg.showToast(d.l.neterror);
                return;
            }
            if (a.this.cnm == null) {
                a.this.cnm = new com.baidu.tieba.frs.entelechy.c.a.a.a(a.this.cjg, a.this.cnq);
            }
            a.this.cnm.setData(a.this.cnl);
            a.this.cnm.d(a.this.cjg.getPageContext()).tk();
        }
    };
    private b.InterfaceC0043b cnq = new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
        public void a(b bVar, int i, View view) {
            if (!i.gV()) {
                a.this.cjg.showToast(d.l.neterror);
                bVar.dismiss();
                return;
            }
            x xVar = (x) u.c(a.this.cnm.ahd(), i);
            if (xVar != null) {
                if (a.this.cnn != xVar.ckC) {
                    a.this.cno = true;
                    a.this.cnk.setText(xVar.name);
                    if (a.this.cnn == 7) {
                        aj ajVar = new aj("c11437");
                        ajVar.r("obj_locate", xVar.ckC);
                        ajVar.aa("fid", a.this.azk);
                        TiebaStatic.log(ajVar);
                    }
                    if (a.this.cjg.aeP() != null) {
                        a.this.cjg.aeP().jg(a.this.cnn);
                        a.this.cnn = xVar.ckC;
                        bVar.dismiss();
                        if (a.this.cnn != 7) {
                            s.Hk();
                            g.bto();
                        } else {
                            g.btn();
                        }
                        if (a.this.cjg.aeP() != null && a.this.cjg.aeU() != null) {
                            a.this.cjg.aeP().jf(xVar.ckC);
                            a.this.cjg.aeU().startPullRefresh();
                            a.this.cjg.aeP().eX(true);
                            com.baidu.tieba.frs.smartsort.d.aiI().g(a.this.cjg.aeP().getForumName(), xVar.ckC, xVar.name);
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
        this.azk = str;
    }

    public TextView aha() {
        return this.cnk;
    }

    public void kh(String str) {
        this.cnk.setText(str);
    }

    public void iU(int i) {
        this.cnn = i;
    }

    public a(f fVar, ViewGroup viewGroup) {
        if (fVar != null && viewGroup != null) {
            this.cjg = fVar;
            this.aan = viewGroup;
            this.cnk = new TextView(fVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(fVar.getActivity(), d.f.ds82));
            layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
            int g = k.g(fVar.getActivity(), d.f.ds30);
            this.cnk.setPadding(g, 0, g, 0);
            this.cnk.setGravity(17);
            this.cnk.setTextSize(0, k.g(fVar.getActivity(), d.f.ds28));
            this.cnk.setCompoundDrawablePadding(k.g(fVar.getActivity(), d.f.ds8));
            this.cnk.setLayoutParams(layoutParams);
            this.cnk.setOnClickListener(this.cnp);
            this.aan.addView(this.cnk);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cnk != null) {
            ai.i(this.cnk, d.e.cp_cont_f);
            ai.k(this.cnk, d.e.transparent);
            this.cnk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_arrow_gray_down), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (u.v(list)) {
            ahc();
        } else if (this.cjg != null && this.cjg.aeP() != null && this.cjg.aeP().ain()) {
            ahb();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aI(arrayList)) {
                if (!this.cno) {
                    iV(i);
                    return;
                }
                return;
            }
            this.cnl = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    x xVar = new x();
                    xVar.ckC = frsTabInfo.tab_id.intValue();
                    xVar.name = frsTabInfo.tab_name;
                    this.cnl.add(xVar);
                }
            }
            if (!this.cno) {
                iV(i);
            }
        } else {
            ahc();
        }
    }

    private void iV(int i) {
        x xVar;
        boolean z;
        x xVar2 = null;
        if (i <= 0) {
            x xVar3 = this.cnl.get(0);
            if (xVar3 != null) {
                iU(xVar3.ckC);
                kh(xVar3.name);
                if (this.cjg != null && this.cjg.aeP() != null) {
                    this.cjg.aeP().jf(xVar3.ckC);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cnl.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                xVar2 = this.cnl.get(i2);
                if (xVar2 == null || xVar2.ckC != i) {
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
                kh(TbadkCoreApplication.getInst().getResources().getString(d.l.attention_users_thread));
                return;
            }
            x xVar4 = this.cnl.get(0);
            if (xVar4 != null) {
                iU(xVar4.ckC);
                kh(xVar4.name);
                if (this.cjg != null && this.cjg.aeP() != null) {
                    this.cjg.aeP().jf(xVar4.ckC);
                }
            }
        } else if (xVar != null) {
            iU(xVar.ckC);
            kh(xVar.name);
            if (this.cjg != null && this.cjg.aeP() != null) {
                this.cjg.aeP().jf(xVar.ckC);
            }
        }
    }

    private boolean aI(List<FrsTabInfo> list) {
        if (!u.v(this.cnl) && u.u(list) == u.u(this.cnl)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cnl.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void ahb() {
        if (this.cnk != null) {
            this.cnk.setVisibility(0);
        }
    }

    public void ahc() {
        if (this.cnk != null) {
            this.cnk.setVisibility(8);
        }
    }
}
