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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private String eAC;
    private TextView eQE;
    private FrsFragment fqJ;
    private View fyn;
    private TextView fyp;
    private c fyq;
    private List<v> fyr;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fyx;
    private ViewGroup mRootView;
    private int fys = -1;
    private boolean fyt = false;
    private c.a fyu = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jG()) {
                b.this.fqJ.showToast(R.string.neterror);
                b.this.fyq.dismiss();
            } else if (vVar == null) {
                b.this.fyq.dismiss();
            } else if (b.this.fys == vVar.fsC) {
                b.this.fyq.dismiss();
            } else {
                b.this.fyt = true;
                b.this.wB(vVar.name);
                if (b.this.fqJ.bjK() != null) {
                    b.this.fqJ.bjK().sh(b.this.fys);
                    b.this.fys = vVar.fsC;
                    b.this.fyq.dismiss();
                    if (b.this.fys != 7) {
                        y.avq();
                        e.cnu();
                    } else {
                        e.cnt();
                    }
                    if (b.this.fqJ.bjK() != null && b.this.fqJ.bjP() != null) {
                        b.this.fqJ.bjK().sg(vVar.fsC);
                        b.this.fqJ.bjP().startPullRefresh();
                        b.this.fqJ.bjK().ky(true);
                        b.this.bni();
                    }
                }
            }
        }
    };
    private View.OnClickListener fyv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.biW().biX()) {
                if (!j.jG()) {
                    b.this.fqJ.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(b.this.fyr)) {
                    b.this.a(b.this.fyr, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eQE != null) {
                Drawable drawable = al.getDrawable(R.drawable.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.eQE.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private b.a fyy = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.jG()) {
                b.this.fqJ.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fyx.bnm(), i);
            if (vVar != null) {
                if (b.this.fys != vVar.fsC) {
                    b.this.fyt = true;
                    b.this.wB(vVar.name);
                    if (b.this.fqJ.bjK() != null) {
                        b.this.fqJ.bjK().sh(b.this.fys);
                        b.this.fys = vVar.fsC;
                        bVar.dismiss();
                        if (b.this.fys != 7) {
                            y.avq();
                            e.cnu();
                        } else {
                            e.cnt();
                        }
                        if (b.this.fqJ.bjK() != null && b.this.fqJ.bjP() != null) {
                            b.this.fqJ.bjK().sg(vVar.fsC);
                            b.this.fqJ.bjP().startPullRefresh();
                            b.this.fqJ.bjK().ky(true);
                            b.this.bni();
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
        this.eAC = str;
    }

    public TextView bnl() {
        return this.eQE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB(String str) {
        this.eQE.setText(str);
    }

    public void rF(int i) {
        this.fys = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fyq == null) {
            this.fyq = new c(this.fqJ.getContext());
            this.fyq.setOnDismissListener(this.mOnDismissListener);
            this.fyq.a(this.fyu);
        }
        this.fyq.setData(list, this.fys);
        this.fyq.bm(view);
        this.eQE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bni() {
        am amVar = new am("c11437");
        amVar.P("obj_type", this.fys);
        amVar.bT("fid", this.eAC);
        TiebaStatic.log(amVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fqJ = frsFragment;
            this.mRootView = relativeLayout;
            this.fyn = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.eQE = (TextView) this.fyn.findViewById(R.id.sort_tab_menu_button);
            this.fyp = (TextView) this.fyn.findViewById(R.id.sort_tab_sort_name);
            this.eQE.setOnClickListener(this.fyv);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eQE != null) {
            al.j(this.eQE, R.color.cp_cont_j);
            al.l(this.eQE, R.color.transparent);
            this.eQE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_common_arrow20_down_n), (Drawable) null);
        }
        al.j(this.fyp, R.color.cp_cont_b);
        al.l(this.fyn, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            bnk();
        } else if (this.fqJ != null && this.fqJ.bjK() != null && this.fqJ.bjK().bpf()) {
            bnj();
            ArrayList arrayList = new ArrayList(list);
            if (!cb(arrayList)) {
                if (!this.fyt) {
                    rG(i);
                    return;
                }
                return;
            }
            this.fyr = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fsC = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fyr.add(vVar);
                }
            }
            if (!this.fyt) {
                rG(i);
            }
        } else {
            bnk();
        }
    }

    private void rG(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fyr.get(0);
            if (vVar3 != null) {
                rF(vVar3.fsC);
                wB(vVar3.name);
                if (this.fqJ != null && this.fqJ.bjK() != null) {
                    this.fqJ.bjK().sg(vVar3.fsC);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fyr.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fyr.get(i2);
                if (vVar2 == null || vVar2.fsC != i) {
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
                wB(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            v vVar4 = this.fyr.get(0);
            if (vVar4 != null) {
                rF(vVar4.fsC);
                wB(vVar4.name);
                if (this.fqJ != null && this.fqJ.bjK() != null) {
                    this.fqJ.bjK().sg(vVar4.fsC);
                }
            }
        } else if (vVar != null) {
            rF(vVar.fsC);
            wB(vVar.name);
            if (this.fqJ != null && this.fqJ.bjK() != null) {
                this.fqJ.bjK().sg(vVar.fsC);
            }
        }
    }

    private boolean cb(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.aa(this.fyr) && com.baidu.tbadk.core.util.v.Z(list) == com.baidu.tbadk.core.util.v.Z(this.fyr)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fyr.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bnj() {
        if (this.eQE != null) {
            this.eQE.setVisibility(0);
        }
    }

    private void bnk() {
        if (this.eQE != null) {
            this.eQE.setVisibility(8);
        }
    }
}
