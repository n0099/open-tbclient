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
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b {
    private String eFy;
    private TextView eVE;
    private View fDj;
    private TextView fDl;
    private c fDm;
    private List<v> fDn;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fDt;
    private FrsFragment fvH;
    private ViewGroup mRootView;
    private int fDo = -1;
    private boolean fDp = false;
    private c.a fDq = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jQ()) {
                b.this.fvH.showToast(R.string.neterror);
                b.this.fDm.dismiss();
            } else if (vVar == null) {
                b.this.fDm.dismiss();
            } else if (b.this.fDo == vVar.fxy) {
                b.this.fDm.dismiss();
            } else {
                b.this.fDp = true;
                b.this.xf(vVar.name);
                if (b.this.fvH.blM() != null) {
                    b.this.fvH.blM().sz(b.this.fDo);
                    b.this.fDo = vVar.fxy;
                    b.this.fDm.dismiss();
                    if (b.this.fDo != 7) {
                        y.awz();
                        e.cqo();
                    } else {
                        e.cqn();
                    }
                    if (b.this.fvH.blM() != null && b.this.fvH.blR() != null) {
                        b.this.fvH.blM().sy(vVar.fxy);
                        b.this.fvH.blR().startPullRefresh();
                        b.this.fvH.blM().kJ(true);
                        b.this.bpj();
                    }
                }
            }
        }
    };
    private View.OnClickListener fDr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bkY().bkZ()) {
                if (!j.jQ()) {
                    b.this.fvH.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(b.this.fDn)) {
                    b.this.a(b.this.fDn, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eVE != null) {
                Drawable drawable = am.getDrawable(R.drawable.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.eVE.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private b.a fDu = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.jQ()) {
                b.this.fvH.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fDt.bpn(), i);
            if (vVar != null) {
                if (b.this.fDo != vVar.fxy) {
                    b.this.fDp = true;
                    b.this.xf(vVar.name);
                    if (b.this.fvH.blM() != null) {
                        b.this.fvH.blM().sz(b.this.fDo);
                        b.this.fDo = vVar.fxy;
                        bVar.dismiss();
                        if (b.this.fDo != 7) {
                            y.awz();
                            e.cqo();
                        } else {
                            e.cqn();
                        }
                        if (b.this.fvH.blM() != null && b.this.fvH.blR() != null) {
                            b.this.fvH.blM().sy(vVar.fxy);
                            b.this.fvH.blR().startPullRefresh();
                            b.this.fvH.blM().kJ(true);
                            b.this.bpj();
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
        this.eFy = str;
    }

    public TextView bpm() {
        return this.eVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf(String str) {
        this.eVE.setText(str);
    }

    public void rX(int i) {
        this.fDo = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fDm == null) {
            this.fDm = new c(this.fvH.getContext());
            this.fDm.setOnDismissListener(this.mOnDismissListener);
            this.fDm.a(this.fDq);
        }
        this.fDm.setData(list, this.fDo);
        this.fDm.bo(view);
        this.eVE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        an anVar = new an("c11437");
        anVar.P("obj_type", this.fDo);
        anVar.bT("fid", this.eFy);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fvH = frsFragment;
            this.mRootView = relativeLayout;
            this.fDj = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.eVE = (TextView) this.fDj.findViewById(R.id.sort_tab_menu_button);
            this.fDl = (TextView) this.fDj.findViewById(R.id.sort_tab_sort_name);
            this.eVE.setOnClickListener(this.fDr);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eVE != null) {
            am.j(this.eVE, R.color.cp_cont_j);
            am.l(this.eVE, R.color.transparent);
            this.eVE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_common_arrow20_down_n), (Drawable) null);
        }
        am.j(this.fDl, R.color.cp_cont_b);
        am.l(this.fDj, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            bpl();
        } else if (this.fvH != null && this.fvH.blM() != null && this.fvH.blM().bri()) {
            bpk();
            ArrayList arrayList = new ArrayList(list);
            if (!cc(arrayList)) {
                if (!this.fDp) {
                    rY(i);
                    return;
                }
                return;
            }
            this.fDn = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fxy = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fDn.add(vVar);
                }
            }
            if (!this.fDp) {
                rY(i);
            }
        } else {
            bpl();
        }
    }

    private void rY(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fDn.get(0);
            if (vVar3 != null) {
                rX(vVar3.fxy);
                xf(vVar3.name);
                if (this.fvH != null && this.fvH.blM() != null) {
                    this.fvH.blM().sy(vVar3.fxy);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fDn.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fDn.get(i2);
                if (vVar2 == null || vVar2.fxy != i) {
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
                xf(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            v vVar4 = this.fDn.get(0);
            if (vVar4 != null) {
                rX(vVar4.fxy);
                xf(vVar4.name);
                if (this.fvH != null && this.fvH.blM() != null) {
                    this.fvH.blM().sy(vVar4.fxy);
                }
            }
        } else if (vVar != null) {
            rX(vVar.fxy);
            xf(vVar.name);
            if (this.fvH != null && this.fvH.blM() != null) {
                this.fvH.blM().sy(vVar.fxy);
            }
        }
    }

    private boolean cc(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.aa(this.fDn) && com.baidu.tbadk.core.util.v.Z(list) == com.baidu.tbadk.core.util.v.Z(this.fDn)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fDn.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bpk() {
        if (this.eVE != null) {
            this.eVE.setVisibility(0);
        }
    }

    private void bpl() {
        if (this.eVE != null) {
            this.eVE.setVisibility(8);
        }
    }
}
