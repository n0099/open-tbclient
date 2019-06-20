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
    private String eAC;
    private TextView eQE;
    private View fyn;
    private FrsNewAreaFragment fyo;
    private TextView fyp;
    private c fyq;
    private List<v> fyr;
    private int fys = -1;
    private boolean fyt = false;
    private c.a fyu = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jG()) {
                a.this.fyo.showToast(R.string.neterror);
                a.this.fyq.dismiss();
            } else if (vVar == null) {
                a.this.fyq.dismiss();
            } else if (a.this.fys == vVar.fsC) {
                a.this.fyq.dismiss();
            } else {
                a.this.fyt = true;
                a.this.wA(vVar.name);
                if (a.this.fyo.bpr() != null) {
                    a.this.fys = vVar.fsC;
                    a.this.fyq.dismiss();
                    if (a.this.fys != 7) {
                        y.avq();
                        e.cnv();
                    } else {
                        e.cnu();
                    }
                    if (a.this.fyo.bpr() != null && a.this.fyo.bps() != null) {
                        a.this.fyo.bpr().sg(vVar.fsC);
                        a.this.fyo.bps().startPullRefresh();
                        a.this.bni();
                    }
                }
            }
        }
    };
    private View.OnClickListener fyv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.biW().biX()) {
                if (!j.jG()) {
                    a.this.fyo.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(a.this.fyr)) {
                    a.this.a(a.this.fyr, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.eQE != null) {
                Drawable drawable = al.getDrawable(R.drawable.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                a.this.eQE.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    public void setFid(String str) {
        this.eAC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA(String str) {
        this.eQE.setText(str);
    }

    public void rF(int i) {
        this.fys = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fyq == null) {
            this.fyq = new c(this.fyo.getContext());
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

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.fyo = frsNewAreaFragment;
            this.fyn = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
        } else if (this.fyo != null && this.fyo.bpr() != null) {
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
                wA(vVar3.name);
                if (this.fyo != null && this.fyo.bpr() != null) {
                    this.fyo.bpr().sg(vVar3.fsC);
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
                wA(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            v vVar4 = this.fyr.get(0);
            if (vVar4 != null) {
                rF(vVar4.fsC);
                wA(vVar4.name);
                if (this.fyo != null && this.fyo.bpr() != null) {
                    this.fyo.bpr().sg(vVar4.fsC);
                }
            }
        } else if (vVar != null) {
            rF(vVar.fsC);
            wA(vVar.name);
            if (this.fyo != null && this.fyo.bpr() != null) {
                this.fyo.bpr().sg(vVar.fsC);
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
