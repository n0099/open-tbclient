package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {
    private TextView eBm;
    private String ela;
    private View fif;
    private FrsNewAreaFragment fig;
    private TextView fih;
    private c fii;
    private List<v> fij;
    private int fik = -1;
    private boolean fil = false;
    private c.a fim = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.kM()) {
                a.this.fig.showToast(d.j.neterror);
                a.this.fii.dismiss();
            } else if (vVar == null) {
                a.this.fii.dismiss();
            } else if (a.this.fik == vVar.fcA) {
                a.this.fii.dismiss();
            } else {
                a.this.fil = true;
                a.this.vi(vVar.name);
                if (a.this.fig.bhV() != null) {
                    a.this.fik = vVar.fcA;
                    a.this.fii.dismiss();
                    if (a.this.fik != 7) {
                        y.aqo();
                        e.cfs();
                    } else {
                        e.cfr();
                    }
                    if (a.this.fig.bhV() != null && a.this.fig.bhW() != null) {
                        a.this.fig.bhV().rc(vVar.fcA);
                        a.this.fig.bhW().startPullRefresh();
                        a.this.bfO();
                    }
                }
            }
        }
    };
    private View.OnClickListener fin = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bbF().bbG()) {
                if (!j.kM()) {
                    a.this.fig.showToast(d.j.neterror);
                } else if (!com.baidu.tbadk.core.util.v.T(a.this.fij)) {
                    a.this.a(a.this.fij, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.eBm != null) {
                Drawable drawable = al.getDrawable(d.f.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                a.this.eBm.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    public void setFid(String str) {
        this.ela = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(String str) {
        this.eBm.setText(str);
    }

    public void qB(int i) {
        this.fik = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fii == null) {
            this.fii = new c(this.fig.getContext());
            this.fii.setOnDismissListener(this.mOnDismissListener);
            this.fii.a(this.fim);
        }
        this.fii.setData(list, this.fik);
        this.fii.bg(view);
        this.eBm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfO() {
        am amVar = new am("c11437");
        amVar.T("obj_type", this.fik);
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.ela);
        TiebaStatic.log(amVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.fig = frsNewAreaFragment;
            this.fif = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(d.h.frs_sort_tab_layout, relativeLayout);
            this.eBm = (TextView) this.fif.findViewById(d.g.sort_tab_menu_button);
            this.fih = (TextView) this.fif.findViewById(d.g.sort_tab_sort_name);
            this.eBm.setOnClickListener(this.fin);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eBm != null) {
            al.j(this.eBm, d.C0277d.cp_cont_j);
            al.l(this.eBm, d.C0277d.transparent);
            this.eBm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_n), (Drawable) null);
        }
        al.j(this.fih, d.C0277d.cp_cont_b);
        al.l(this.fif, d.C0277d.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            bfQ();
        } else if (this.fig != null && this.fig.bhV() != null) {
            bfP();
            ArrayList arrayList = new ArrayList(list);
            if (!bW(arrayList)) {
                if (!this.fil) {
                    qC(i);
                    return;
                }
                return;
            }
            this.fij = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fcA = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fij.add(vVar);
                }
            }
            if (!this.fil) {
                qC(i);
            }
        } else {
            bfQ();
        }
    }

    private void qC(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fij.get(0);
            if (vVar3 != null) {
                qB(vVar3.fcA);
                vi(vVar3.name);
                if (this.fig != null && this.fig.bhV() != null) {
                    this.fig.bhV().rc(vVar3.fcA);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fij.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fij.get(i2);
                if (vVar2 == null || vVar2.fcA != i) {
                    i2++;
                } else {
                    vVar = vVar2;
                    z = true;
                    break;
                }
            } else {
                vVar = vVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                vi(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            v vVar4 = this.fij.get(0);
            if (vVar4 != null) {
                qB(vVar4.fcA);
                vi(vVar4.name);
                if (this.fig != null && this.fig.bhV() != null) {
                    this.fig.bhV().rc(vVar4.fcA);
                }
            }
        } else if (vVar != null) {
            qB(vVar.fcA);
            vi(vVar.name);
            if (this.fig != null && this.fig.bhV() != null) {
                this.fig.bhV().rc(vVar.fcA);
            }
        }
    }

    private boolean bW(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.T(this.fij) && com.baidu.tbadk.core.util.v.S(list) == com.baidu.tbadk.core.util.v.S(this.fij)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fij.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bfP() {
        if (this.eBm != null) {
            this.eBm.setVisibility(0);
        }
    }

    private void bfQ() {
        if (this.eBm != null) {
            this.eBm.setVisibility(8);
        }
    }
}
