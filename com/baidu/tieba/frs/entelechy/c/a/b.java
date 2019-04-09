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
    private TextView eAY;
    private String ekN;
    private FrsFragment fat;
    private View fhQ;
    private TextView fhS;
    private c fhT;
    private List<v> fhU;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fia;
    private ViewGroup mRootView;
    private int fhV = -1;
    private boolean fhW = false;
    private c.a fhX = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.kM()) {
                b.this.fat.showToast(d.j.neterror);
                b.this.fhT.dismiss();
            } else if (vVar == null) {
                b.this.fhT.dismiss();
            } else if (b.this.fhV == vVar.fcn) {
                b.this.fhT.dismiss();
            } else {
                b.this.fhW = true;
                b.this.vh(vVar.name);
                if (b.this.fat.bcn() != null) {
                    b.this.fat.bcn().qZ(b.this.fhV);
                    b.this.fhV = vVar.fcn;
                    b.this.fhT.dismiss();
                    if (b.this.fhV != 7) {
                        y.aql();
                        e.cfo();
                    } else {
                        e.cfn();
                    }
                    if (b.this.fat.bcn() != null && b.this.fat.bcs() != null) {
                        b.this.fat.bcn().qY(vVar.fcn);
                        b.this.fat.bcs().startPullRefresh();
                        b.this.fat.bcn().jM(true);
                        b.this.bfM();
                    }
                }
            }
        }
    };
    private View.OnClickListener fhY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bbD().bbE()) {
                if (!j.kM()) {
                    b.this.fat.showToast(d.j.neterror);
                } else if (!com.baidu.tbadk.core.util.v.T(b.this.fhU)) {
                    b.this.a(b.this.fhU, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.eAY != null) {
                Drawable drawable = al.getDrawable(d.f.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                b.this.eAY.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private b.InterfaceC0225b fib = new b.InterfaceC0225b() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.kM()) {
                b.this.fat.showToast(d.j.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.c(b.this.fia.bfQ(), i);
            if (vVar != null) {
                if (b.this.fhV != vVar.fcn) {
                    b.this.fhW = true;
                    b.this.vh(vVar.name);
                    if (b.this.fat.bcn() != null) {
                        b.this.fat.bcn().qZ(b.this.fhV);
                        b.this.fhV = vVar.fcn;
                        bVar.dismiss();
                        if (b.this.fhV != 7) {
                            y.aql();
                            e.cfo();
                        } else {
                            e.cfn();
                        }
                        if (b.this.fat.bcn() != null && b.this.fat.bcs() != null) {
                            b.this.fat.bcn().qY(vVar.fcn);
                            b.this.fat.bcs().startPullRefresh();
                            b.this.fat.bcn().jM(true);
                            b.this.bfM();
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
        this.ekN = str;
    }

    public TextView bfP() {
        return this.eAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(String str) {
        this.eAY.setText(str);
    }

    public void qx(int i) {
        this.fhV = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fhT == null) {
            this.fhT = new c(this.fat.getContext());
            this.fhT.setOnDismissListener(this.mOnDismissListener);
            this.fhT.a(this.fhX);
        }
        this.fhT.setData(list, this.fhV);
        this.fhT.bg(view);
        this.eAY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_h), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfM() {
        am amVar = new am("c11437");
        amVar.T("obj_type", this.fhV);
        amVar.bJ(ImageViewerConfig.FORUM_ID, this.ekN);
        TiebaStatic.log(amVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fat = frsFragment;
            this.mRootView = relativeLayout;
            this.fhQ = LayoutInflater.from(frsFragment.getContext()).inflate(d.h.frs_sort_tab_layout, relativeLayout);
            this.eAY = (TextView) this.fhQ.findViewById(d.g.sort_tab_menu_button);
            this.fhS = (TextView) this.fhQ.findViewById(d.g.sort_tab_sort_name);
            this.eAY.setOnClickListener(this.fhY);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.eAY != null) {
            al.j(this.eAY, d.C0277d.cp_cont_j);
            al.l(this.eAY, d.C0277d.transparent);
            this.eAY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_common_arrow20_down_n), (Drawable) null);
        }
        al.j(this.fhS, d.C0277d.cp_cont_b);
        al.l(this.fhQ, d.C0277d.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            bfO();
        } else if (this.fat != null && this.fat.bcn() != null && this.fat.bcn().bhJ()) {
            bfN();
            ArrayList arrayList = new ArrayList(list);
            if (!bT(arrayList)) {
                if (!this.fhW) {
                    qy(i);
                    return;
                }
                return;
            }
            this.fhU = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fcn = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fhU.add(vVar);
                }
            }
            if (!this.fhW) {
                qy(i);
            }
        } else {
            bfO();
        }
    }

    private void qy(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fhU.get(0);
            if (vVar3 != null) {
                qx(vVar3.fcn);
                vh(vVar3.name);
                if (this.fat != null && this.fat.bcn() != null) {
                    this.fat.bcn().qY(vVar3.fcn);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fhU.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fhU.get(i2);
                if (vVar2 == null || vVar2.fcn != i) {
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
                vh(TbadkCoreApplication.getInst().getResources().getString(d.j.attention_users_thread));
                return;
            }
            v vVar4 = this.fhU.get(0);
            if (vVar4 != null) {
                qx(vVar4.fcn);
                vh(vVar4.name);
                if (this.fat != null && this.fat.bcn() != null) {
                    this.fat.bcn().qY(vVar4.fcn);
                }
            }
        } else if (vVar != null) {
            qx(vVar.fcn);
            vh(vVar.name);
            if (this.fat != null && this.fat.bcn() != null) {
                this.fat.bcn().qY(vVar.fcn);
            }
        }
    }

    private boolean bT(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.T(this.fhU) && com.baidu.tbadk.core.util.v.S(list) == com.baidu.tbadk.core.util.v.S(this.fhU)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fhU.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bfN() {
        if (this.eAY != null) {
            this.eAY.setVisibility(0);
        }
    }

    private void bfO() {
        if (this.eAY != null) {
            this.eAY.setVisibility(8);
        }
    }
}
