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
    private String eAB;
    private TextView eQD;
    private FrsFragment fqI;
    private View fym;
    private TextView fyo;
    private c fyp;
    private List<v> fyq;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fyw;
    private ViewGroup mRootView;
    private int fyr = -1;
    private boolean fys = false;
    private c.a fyt = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.jG()) {
                b.this.fqI.showToast(R.string.neterror);
                b.this.fyp.dismiss();
            } else if (vVar == null) {
                b.this.fyp.dismiss();
            } else if (b.this.fyr == vVar.fsB) {
                b.this.fyp.dismiss();
            } else {
                b.this.fys = true;
                b.this.wB(vVar.name);
                if (b.this.fqI.bjH() != null) {
                    b.this.fqI.bjH().sh(b.this.fyr);
                    b.this.fyr = vVar.fsB;
                    b.this.fyp.dismiss();
                    if (b.this.fyr != 7) {
                        y.avq();
                        e.cns();
                    } else {
                        e.cnr();
                    }
                    if (b.this.fqI.bjH() != null && b.this.fqI.bjM() != null) {
                        b.this.fqI.bjH().sg(vVar.fsB);
                        b.this.fqI.bjM().startPullRefresh();
                        b.this.fqI.bjH().ky(true);
                        b.this.bnf();
                    }
                }
            }
        }
    };
    private View.OnClickListener fyu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.biT().biU()) {
                if (!j.jG()) {
                    b.this.fqI.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.aa(b.this.fyq)) {
                    b.this.a(b.this.fyq, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eQD != null) {
                Drawable drawable = al.getDrawable(R.drawable.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.eQD.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private b.a fyx = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.jG()) {
                b.this.fqI.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fyw.bnj(), i);
            if (vVar != null) {
                if (b.this.fyr != vVar.fsB) {
                    b.this.fys = true;
                    b.this.wB(vVar.name);
                    if (b.this.fqI.bjH() != null) {
                        b.this.fqI.bjH().sh(b.this.fyr);
                        b.this.fyr = vVar.fsB;
                        bVar.dismiss();
                        if (b.this.fyr != 7) {
                            y.avq();
                            e.cns();
                        } else {
                            e.cnr();
                        }
                        if (b.this.fqI.bjH() != null && b.this.fqI.bjM() != null) {
                            b.this.fqI.bjH().sg(vVar.fsB);
                            b.this.fqI.bjM().startPullRefresh();
                            b.this.fqI.bjH().ky(true);
                            b.this.bnf();
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
        this.eAB = str;
    }

    public TextView bni() {
        return this.eQD;
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
            this.fyp = new c(this.fqI.getContext());
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

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fqI = frsFragment;
            this.mRootView = relativeLayout;
            this.fym = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
        } else if (this.fqI != null && this.fqI.bjH() != null && this.fqI.bjH().bpc()) {
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
                if (this.fqI != null && this.fqI.bjH() != null) {
                    this.fqI.bjH().sg(vVar3.fsB);
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
                if (this.fqI != null && this.fqI.bjH() != null) {
                    this.fqI.bjH().sg(vVar4.fsB);
                }
            }
        } else if (vVar != null) {
            rF(vVar.fsB);
            wB(vVar.name);
            if (this.fqI != null && this.fqI.bjH() != null) {
                this.fqI.bjH().sg(vVar.fsB);
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
