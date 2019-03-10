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
    private TextView eBq;
    private String ele;
    private View fig;
    private FrsNewAreaFragment fih;
    private TextView fii;
    private c fij;
    private List<v> fik;
    private int fil = -1;
    private boolean fim = false;
    private c.a fin = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.kM()) {
                a.this.fih.showToast(d.j.neterror);
                a.this.fij.dismiss();
            } else if (vVar == null) {
                a.this.fij.dismiss();
            } else if (a.this.fil == vVar.fcB) {
                a.this.fij.dismiss();
            } else {
                a.this.fim = true;
                a.this.vk(vVar.name);
                if (a.this.fih.bhW() != null) {
                    a.this.fil = vVar.fcB;
                    a.this.fij.dismiss();
                    if (a.this.fil != 7) {
                        y.aqp();
                        e.cfq();
                    } else {
                        e.cfp();
                    }
                    if (a.this.fih.bhW() != null && a.this.fih.bhX() != null) {
                        a.this.fih.bhW().rc(vVar.fcB);
                        a.this.fih.bhX().startPullRefresh();
                        a.this.bfP();
                    }
                }
            }
        }
    };
    private View.OnClickListener fio = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bbG().bbH()) {
                if (!j.kM()) {
                    a.this.fih.showToast(d.j.neterror);
                } else if (!com.baidu.tbadk.core.util.v.T(a.this.fik)) {
                    a.this.a(a.this.fik, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.eBq != null) {
                Drawable drawable = al.getDrawable(d.f.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                a.this.eBq.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    public void setFid(String str) {
        this.ele = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk(String str) {
        this.eBq.setText(str);
    }

    public void qB(int i) {
        this.fil = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fij == null) {
            this.fij = new c(this.fih.getContext());
            this.fij.setOnDismissListener(this.mOnDismissListener);
            this.fij.a(this.fin);
        }
        this.fij.setData(list, this.fil);
        this.fij.bg(view);
        this.eBq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfP() {
        am amVar = new am("c11437");
        amVar.T("obj_type", this.fil);
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.ele);
        TiebaStatic.log(amVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.fih = frsNewAreaFragment;
            this.fig = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(d.h.frs_sort_tab_layout, relativeLayout);
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
            bfR();
        } else if (this.fih != null && this.fih.bhW() != null) {
            bfQ();
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
            bfR();
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
                vk(vVar3.name);
                if (this.fih != null && this.fih.bhW() != null) {
                    this.fih.bhW().rc(vVar3.fcB);
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
                vk(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            v vVar4 = this.fik.get(0);
            if (vVar4 != null) {
                qB(vVar4.fcB);
                vk(vVar4.name);
                if (this.fih != null && this.fih.bhW() != null) {
                    this.fih.bhW().rc(vVar4.fcB);
                }
            }
        } else if (vVar != null) {
            qB(vVar.fcB);
            vk(vVar.name);
            if (this.fih != null && this.fih.bhW() != null) {
                this.fih.bhW().rc(vVar.fcB);
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

    private void bfQ() {
        if (this.eBq != null) {
            this.eBq.setVisibility(0);
        }
    }

    private void bfR() {
        if (this.eBq != null) {
            this.eBq.setVisibility(8);
        }
    }
}
