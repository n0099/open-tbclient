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
    private TextView eAY;
    private String ekN;
    private View fhQ;
    private FrsNewAreaFragment fhR;
    private TextView fhS;
    private c fhT;
    private List<v> fhU;
    private int fhV = -1;
    private boolean fhW = false;
    private c.a fhX = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.kM()) {
                a.this.fhR.showToast(d.j.neterror);
                a.this.fhT.dismiss();
            } else if (vVar == null) {
                a.this.fhT.dismiss();
            } else if (a.this.fhV == vVar.fcn) {
                a.this.fhT.dismiss();
            } else {
                a.this.fhW = true;
                a.this.vh(vVar.name);
                if (a.this.fhR.bhT() != null) {
                    a.this.fhV = vVar.fcn;
                    a.this.fhT.dismiss();
                    if (a.this.fhV != 7) {
                        y.aql();
                        e.cfo();
                    } else {
                        e.cfn();
                    }
                    if (a.this.fhR.bhT() != null && a.this.fhR.bhU() != null) {
                        a.this.fhR.bhT().qY(vVar.fcn);
                        a.this.fhR.bhU().startPullRefresh();
                        a.this.bfM();
                    }
                }
            }
        }
    };
    private View.OnClickListener fhY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bbD().bbE()) {
                if (!j.kM()) {
                    a.this.fhR.showToast(d.j.neterror);
                } else if (!com.baidu.tbadk.core.util.v.T(a.this.fhU)) {
                    a.this.a(a.this.fhU, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.eAY != null) {
                Drawable drawable = al.getDrawable(d.f.icon_common_arrow20_down_n);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                a.this.eAY.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };

    public void setFid(String str) {
        this.ekN = str;
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
            this.fhT = new c(this.fhR.getContext());
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

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.fhR = frsNewAreaFragment;
            this.fhQ = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(d.h.frs_sort_tab_layout, relativeLayout);
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
        } else if (this.fhR != null && this.fhR.bhT() != null) {
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
                if (this.fhR != null && this.fhR.bhT() != null) {
                    this.fhR.bhT().qY(vVar3.fcn);
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
                if (this.fhR != null && this.fhR.bhT() != null) {
                    this.fhR.bhT().qY(vVar4.fcn);
                }
            }
        } else if (vVar != null) {
            qx(vVar.fcn);
            vh(vVar.name);
            if (this.fhR != null && this.fhR.bhT() != null) {
                this.fhR.bhT().qY(vVar.fcn);
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
