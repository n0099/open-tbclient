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
    private String eFF;
    private TextView eVL;
    private View fDX;
    private TextView fDZ;
    private c fEa;
    private List<v> fEb;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fEh;
    private FrsFragment fwg;
    private ViewGroup mRootView;
    private int fEc = -1;
    private boolean fEd = false;
    private c.a fEe = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jQ()) {
                b.this.fwg.showToast(R.string.neterror);
                b.this.fEa.dismiss();
            } else if (vVar == null) {
                b.this.fEa.dismiss();
            } else if (b.this.fEc == vVar.fxX) {
                b.this.fEa.dismiss();
            } else {
                b.this.fEd = true;
                b.this.xg(vVar.name);
                if (b.this.fwg.blT() != null) {
                    b.this.fwg.blT().sB(b.this.fEc);
                    b.this.fEc = vVar.fxX;
                    b.this.fEa.dismiss();
                    if (b.this.fEc != 7) {
                        y.awB();
                        e.cqK();
                    } else {
                        e.cqJ();
                    }
                    if (b.this.fwg.blT() != null && b.this.fwg.blY() != null) {
                        b.this.fwg.blT().sA(vVar.fxX);
                        b.this.fwg.blY().startPullRefresh();
                        b.this.fwg.blT().kJ(true);
                        b.this.bpw();
                    }
                }
            }
        }
    };
    private View.OnClickListener fEf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.blf().blg()) {
                if (!j.jQ()) {
                    b.this.fwg.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(b.this.fEb)) {
                    b.this.a(b.this.fEb, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eVL != null) {
                Drawable drawable = am.getDrawable(R.drawable.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.eVL.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private b.a fEi = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.jQ()) {
                b.this.fwg.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fEh.bpA(), i);
            if (vVar != null) {
                if (b.this.fEc != vVar.fxX) {
                    b.this.fEd = true;
                    b.this.xg(vVar.name);
                    if (b.this.fwg.blT() != null) {
                        b.this.fwg.blT().sB(b.this.fEc);
                        b.this.fEc = vVar.fxX;
                        bVar.dismiss();
                        if (b.this.fEc != 7) {
                            y.awB();
                            e.cqK();
                        } else {
                            e.cqJ();
                        }
                        if (b.this.fwg.blT() != null && b.this.fwg.blY() != null) {
                            b.this.fwg.blT().sA(vVar.fxX);
                            b.this.fwg.blY().startPullRefresh();
                            b.this.fwg.blT().kJ(true);
                            b.this.bpw();
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
        this.eFF = str;
    }

    public TextView bpz() {
        return this.eVL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(String str) {
        this.eVL.setText(str);
    }

    public void rZ(int i) {
        this.fEc = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fEa == null) {
            this.fEa = new c(this.fwg.getContext());
            this.fEa.setOnDismissListener(this.mOnDismissListener);
            this.fEa.a(this.fEe);
        }
        this.fEa.setData(list, this.fEc);
        this.fEa.bo(view);
        this.eVL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpw() {
        an anVar = new an("c11437");
        anVar.P("obj_type", this.fEc);
        anVar.bT("fid", this.eFF);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fwg = frsFragment;
            this.mRootView = relativeLayout;
            this.fDX = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.eVL = (TextView) this.fDX.findViewById(R.id.sort_tab_menu_button);
            this.fDZ = (TextView) this.fDX.findViewById(R.id.sort_tab_sort_name);
            this.eVL.setOnClickListener(this.fEf);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eVL != null) {
            am.j(this.eVL, R.color.cp_cont_j);
            am.l(this.eVL, R.color.transparent);
            this.eVL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_common_arrow20_down_n), (Drawable) null);
        }
        am.j(this.fDZ, R.color.cp_cont_b);
        am.l(this.fDX, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            bpy();
        } else if (this.fwg != null && this.fwg.blT() != null && this.fwg.blT().brv()) {
            bpx();
            ArrayList arrayList = new ArrayList(list);
            if (!cb(arrayList)) {
                if (!this.fEd) {
                    sa(i);
                    return;
                }
                return;
            }
            this.fEb = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fxX = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fEb.add(vVar);
                }
            }
            if (!this.fEd) {
                sa(i);
            }
        } else {
            bpy();
        }
    }

    private void sa(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fEb.get(0);
            if (vVar3 != null) {
                rZ(vVar3.fxX);
                xg(vVar3.name);
                if (this.fwg != null && this.fwg.blT() != null) {
                    this.fwg.blT().sA(vVar3.fxX);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fEb.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fEb.get(i2);
                if (vVar2 == null || vVar2.fxX != i) {
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
                xg(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            v vVar4 = this.fEb.get(0);
            if (vVar4 != null) {
                rZ(vVar4.fxX);
                xg(vVar4.name);
                if (this.fwg != null && this.fwg.blT() != null) {
                    this.fwg.blT().sA(vVar4.fxX);
                }
            }
        } else if (vVar != null) {
            rZ(vVar.fxX);
            xg(vVar.name);
            if (this.fwg != null && this.fwg.blT() != null) {
                this.fwg.blT().sA(vVar.fxX);
            }
        }
    }

    private boolean cb(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.aa(this.fEb) && com.baidu.tbadk.core.util.v.Z(list) == com.baidu.tbadk.core.util.v.Z(this.fEb)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fEb.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bpx() {
        if (this.eVL != null) {
            this.eVL.setVisibility(0);
        }
    }

    private void bpy() {
        if (this.eVL != null) {
            this.eVL.setVisibility(8);
        }
    }
}
