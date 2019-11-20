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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.x;
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
    private String ePc;
    private TextView eZm;
    private View fEk;
    private FrsNewAreaFragment fEl;
    private TextView fEm;
    private c fEn;
    private List<v> fEo;
    private int fEp = -1;
    private boolean fEq = false;
    private boolean fEr = false;
    private c.a fEs = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.fEl.showToast(R.string.neterror);
                a.this.fEn.dismiss();
                a.this.fEr = false;
            } else if (vVar == null) {
                a.this.fEn.dismiss();
                a.this.fEr = false;
            } else if (a.this.fEp == vVar.fyi) {
                a.this.fEn.dismiss();
                a.this.fEr = false;
            } else {
                a.this.fEq = true;
                a.this.vX(vVar.name);
                if (a.this.fEl.bpu() != null) {
                    a.this.fEp = vVar.fyi;
                    a.this.fEn.dismiss();
                    a.this.fEr = false;
                    if (a.this.fEp != 7) {
                        x.axO();
                        e.cpp();
                    } else {
                        e.cpo();
                    }
                    if (a.this.fEl.bpu() != null && a.this.fEl.bpv() != null) {
                        a.this.fEl.bpu().rw(vVar.fyi);
                        a.this.fEl.bpv().startPullRefresh();
                        a.this.bnk();
                    }
                }
            }
        }
    };
    private View.OnClickListener fEt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.biU().biV()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    a.this.fEl.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.isEmpty(a.this.fEo)) {
                    a.this.a(a.this.fEo, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.eZm != null) {
                Drawable a = SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                a.this.eZm.setCompoundDrawables(null, null, a, null);
            }
        }
    };

    public void setFid(String str) {
        this.ePc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vX(String str) {
        this.eZm.setText(str);
    }

    public void qV(int i) {
        this.fEp = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fEn == null) {
            this.fEn = new c(this.fEl.getContext());
            this.fEn.setOnDismissListener(this.mOnDismissListener);
            this.fEn.a(this.fEs);
        }
        this.fEn.setData(list, this.fEp);
        this.fEn.O(view);
        this.fEr = true;
        this.eZm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnk() {
        an anVar = new an("c11437");
        anVar.O("obj_type", this.fEp);
        anVar.bS("fid", this.ePc);
        TiebaStatic.log(anVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.fEl = frsNewAreaFragment;
            this.fEk = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.eZm = (TextView) this.fEk.findViewById(R.id.sort_tab_menu_button);
            this.fEm = (TextView) this.fEk.findViewById(R.id.sort_tab_sort_name);
            this.eZm.setOnClickListener(this.fEt);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.eZm != null) {
            am.setViewTextColor(this.eZm, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.eZm, R.color.transparent);
            if (this.fEr) {
                a = SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.amL().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.eZm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.fEm, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.fEk, R.color.cp_bg_line_d);
        if (this.fEn != null && this.fEr) {
            this.fEn.bno();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            bnm();
        } else if (this.fEl != null && this.fEl.bpu() != null) {
            bnl();
            ArrayList arrayList = new ArrayList(list);
            if (!co(arrayList)) {
                if (!this.fEq) {
                    qW(i);
                    return;
                }
                return;
            }
            this.fEo = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fyi = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fEo.add(vVar);
                }
            }
            if (!this.fEq) {
                qW(i);
            }
        } else {
            bnm();
        }
    }

    private void qW(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fEo.get(0);
            if (vVar3 != null) {
                qV(vVar3.fyi);
                vX(vVar3.name);
                if (this.fEl != null && this.fEl.bpu() != null) {
                    this.fEl.bpu().rw(vVar3.fyi);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fEo.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fEo.get(i2);
                if (vVar2 == null || vVar2.fyi != i) {
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
                vX(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            v vVar4 = this.fEo.get(0);
            if (vVar4 != null) {
                qV(vVar4.fyi);
                vX(vVar4.name);
                if (this.fEl != null && this.fEl.bpu() != null) {
                    this.fEl.bpu().rw(vVar4.fyi);
                }
            }
        } else if (vVar != null) {
            qV(vVar.fyi);
            vX(vVar.name);
            if (this.fEl != null && this.fEl.bpu() != null) {
                this.fEl.bpu().rw(vVar.fyi);
            }
        }
    }

    private boolean co(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fEo) && com.baidu.tbadk.core.util.v.getCount(list) == com.baidu.tbadk.core.util.v.getCount(this.fEo)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fEo.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bnl() {
        if (this.eZm != null) {
            this.eZm.setVisibility(0);
        }
    }

    private void bnm() {
        if (this.eZm != null) {
            this.eZm.setVisibility(8);
        }
    }
}
