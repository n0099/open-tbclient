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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {
    private String eAB;
    private TextView eQD;
    private View fym;
    private FrsNewAreaFragment fyn;
    private TextView fyo;
    private c fyp;
    private List<v> fyq;
    private int fyr = -1;
    private boolean fys = false;
    private c.a fyt = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jG()) {
                a.this.fyn.showToast(R.string.neterror);
                a.this.fyp.dismiss();
            } else if (vVar == null) {
                a.this.fyp.dismiss();
            } else if (a.this.fyr == vVar.fsB) {
                a.this.fyp.dismiss();
            } else {
                a.this.fys = true;
                a.this.wB(vVar.name);
                if (a.this.fyn.bpm() != null) {
                    a.this.fyr = vVar.fsB;
                    a.this.fyp.dismiss();
                    if (a.this.fyr != 7) {
                        y.avq();
                        e.cns();
                    } else {
                        e.cnr();
                    }
                    if (a.this.fyn.bpm() != null && a.this.fyn.bpn() != null) {
                        a.this.fyn.bpm().sg(vVar.fsB);
                        a.this.fyn.bpn().startPullRefresh();
                        a.this.bnf();
                    }
                }
            }
        }
    };
    private View.OnClickListener fyu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.biT().biU()) {
                if (!j.jG()) {
                    a.this.fyn.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(a.this.fyq)) {
                    a.this.a(a.this.fyq, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.eQD != null) {
                Drawable drawable = al.getDrawable(R.drawable.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                a.this.eQD.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    public void setFid(String str) {
        this.eAB = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB(String str) {
        this.eQD.setText(str);
    }

    public void rF(int i) {
        this.fyr = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fyp == null) {
            this.fyp = new c(this.fyn.getContext());
            this.fyp.setOnDismissListener(this.mOnDismissListener);
            this.fyp.a(this.fyt);
        }
        this.fyp.setData(list, this.fyr);
        this.fyp.bm(view);
        this.eQD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnf() {
        am amVar = new am("c11437");
        amVar.P("obj_type", this.fyr);
        amVar.bT("fid", this.eAB);
        TiebaStatic.log(amVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.fyn = frsNewAreaFragment;
            this.fym = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.eQD = (TextView) this.fym.findViewById(R.id.sort_tab_menu_button);
            this.fyo = (TextView) this.fym.findViewById(R.id.sort_tab_sort_name);
            this.eQD.setOnClickListener(this.fyu);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eQD != null) {
            al.j(this.eQD, R.color.cp_cont_j);
            al.l(this.eQD, R.color.transparent);
            this.eQD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_common_arrow20_down_n), (Drawable) null);
        }
        al.j(this.fyo, R.color.cp_cont_b);
        al.l(this.fym, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            bnh();
        } else if (this.fyn != null && this.fyn.bpm() != null) {
            bng();
            ArrayList arrayList = new ArrayList(list);
            if (!cb(arrayList)) {
                if (!this.fys) {
                    rG(i);
                    return;
                }
                return;
            }
            this.fyq = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fsB = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fyq.add(vVar);
                }
            }
            if (!this.fys) {
                rG(i);
            }
        } else {
            bnh();
        }
    }

    private void rG(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fyq.get(0);
            if (vVar3 != null) {
                rF(vVar3.fsB);
                wB(vVar3.name);
                if (this.fyn != null && this.fyn.bpm() != null) {
                    this.fyn.bpm().sg(vVar3.fsB);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fyq.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fyq.get(i2);
                if (vVar2 == null || vVar2.fsB != i) {
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
            v vVar4 = this.fyq.get(0);
            if (vVar4 != null) {
                rF(vVar4.fsB);
                wB(vVar4.name);
                if (this.fyn != null && this.fyn.bpm() != null) {
                    this.fyn.bpm().sg(vVar4.fsB);
                }
            }
        } else if (vVar != null) {
            rF(vVar.fsB);
            wB(vVar.name);
            if (this.fyn != null && this.fyn.bpm() != null) {
                this.fyn.bpm().sg(vVar.fsB);
            }
        }
    }

    private boolean cb(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.aa(this.fyq) && com.baidu.tbadk.core.util.v.Z(list) == com.baidu.tbadk.core.util.v.Z(this.fyq)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fyq.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bng() {
        if (this.eQD != null) {
            this.eQD.setVisibility(0);
        }
    }

    private void bnh() {
        if (this.eQD != null) {
            this.eQD.setVisibility(8);
        }
    }
}
