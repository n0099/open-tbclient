package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
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
import com.baidu.tbadk.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {
    private TextView eBq;
    private String ele;
    private FrsFragment faH;
    private View fig;
    private TextView fii;
    private c fij;
    private List<v> fik;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fiq;
    private ViewGroup mRootView;
    private int fil = -1;
    private boolean fim = false;
    private c.a fin = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.kM()) {
                b.this.faH.showToast(d.j.neterror);
                b.this.fij.dismiss();
            } else if (vVar == null) {
                b.this.fij.dismiss();
            } else if (b.this.fil == vVar.fcB) {
                b.this.fij.dismiss();
            } else {
                b.this.fim = true;
                b.this.vj(vVar.name);
                if (b.this.faH.bcp() != null) {
                    b.this.faH.bcp().rd(b.this.fil);
                    b.this.fil = vVar.fcB;
                    b.this.fij.dismiss();
                    if (b.this.fil != 7) {
                        y.aqo();
                        e.cfp();
                    } else {
                        e.cfo();
                    }
                    if (b.this.faH.bcp() != null && b.this.faH.bcu() != null) {
                        b.this.faH.bcp().rc(vVar.fcB);
                        b.this.faH.bcu().startPullRefresh();
                        b.this.faH.bcp().jM(true);
                        b.this.bfO();
                    }
                }
            }
        }
    };
    private View.OnClickListener fio = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bbF().bbG()) {
                if (!j.kM()) {
                    b.this.faH.showToast(d.j.neterror);
                } else if (!com.baidu.tbadk.core.util.v.T(b.this.fik)) {
                    b.this.a(b.this.fik, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eBq != null) {
                Drawable drawable = al.getDrawable(d.f.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.eBq.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private b.InterfaceC0191b fir = new b.InterfaceC0191b() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.kM()) {
                b.this.faH.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fiq.bfS(), i);
            if (vVar != null) {
                if (b.this.fil != vVar.fcB) {
                    b.this.fim = true;
                    b.this.vj(vVar.name);
                    if (b.this.faH.bcp() != null) {
                        b.this.faH.bcp().rd(b.this.fil);
                        b.this.fil = vVar.fcB;
                        bVar.dismiss();
                        if (b.this.fil != 7) {
                            y.aqo();
                            e.cfp();
                        } else {
                            e.cfo();
                        }
                        if (b.this.faH.bcp() != null && b.this.faH.bcu() != null) {
                            b.this.faH.bcp().rc(vVar.fcB);
                            b.this.faH.bcu().startPullRefresh();
                            b.this.faH.bcp().jM(true);
                            b.this.bfO();
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
        this.ele = str;
    }

    public TextView bfR() {
        return this.eBq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(String str) {
        this.eBq.setText(str);
    }

    public void qB(int i) {
        this.fil = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fij == null) {
            this.fij = new c(this.faH.getContext());
            this.fij.setOnDismissListener(this.mOnDismissListener);
            this.fij.a(this.fin);
        }
        this.fij.setData(list, this.fil);
        this.fij.bg(view);
        this.eBq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfO() {
        am amVar = new am("c11437");
        amVar.T("obj_type", this.fil);
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.ele);
        TiebaStatic.log(amVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.faH = frsFragment;
            this.mRootView = relativeLayout;
            this.fig = LayoutInflater.from(frsFragment.getContext()).inflate(d.h.frs_sort_tab_layout, relativeLayout);
            this.eBq = (TextView) this.fig.findViewById(d.g.sort_tab_menu_button);
            this.fii = (TextView) this.fig.findViewById(d.g.sort_tab_sort_name);
            this.eBq.setOnClickListener(this.fio);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eBq != null) {
            al.j(this.eBq, d.C0236d.cp_cont_j);
            al.l(this.eBq, d.C0236d.transparent);
            this.eBq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_n), (Drawable) null);
        }
        al.j(this.fii, d.C0236d.cp_cont_b);
        al.l(this.fig, d.C0236d.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            bfQ();
        } else if (this.faH != null && this.faH.bcp() != null && this.faH.bcp().bhL()) {
            bfP();
            ArrayList arrayList = new ArrayList(list);
            if (!bW(arrayList)) {
                if (!this.fim) {
                    qC(i);
                    return;
                }
                return;
            }
            this.fik = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fcB = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fik.add(vVar);
                }
            }
            if (!this.fim) {
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
            v vVar3 = this.fik.get(0);
            if (vVar3 != null) {
                qB(vVar3.fcB);
                vj(vVar3.name);
                if (this.faH != null && this.faH.bcp() != null) {
                    this.faH.bcp().rc(vVar3.fcB);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fik.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fik.get(i2);
                if (vVar2 == null || vVar2.fcB != i) {
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
                vj(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            v vVar4 = this.fik.get(0);
            if (vVar4 != null) {
                qB(vVar4.fcB);
                vj(vVar4.name);
                if (this.faH != null && this.faH.bcp() != null) {
                    this.faH.bcp().rc(vVar4.fcB);
                }
            }
        } else if (vVar != null) {
            qB(vVar.fcB);
            vj(vVar.name);
            if (this.faH != null && this.faH.bcp() != null) {
                this.faH.bcp().rc(vVar.fcB);
            }
        }
    }

    private boolean bW(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.T(this.fik) && com.baidu.tbadk.core.util.v.S(list) == com.baidu.tbadk.core.util.v.S(this.fik)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fik.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bfP() {
        if (this.eBq != null) {
            this.eBq.setVisibility(0);
        }
    }

    private void bfQ() {
        if (this.eBq != null) {
            this.eBq.setVisibility(8);
        }
    }
}
