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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.x;
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
    private String ePT;
    private View fFb;
    private TextView fFd;
    private c fFe;
    private List<v> fFf;
    private com.baidu.tieba.frs.entelechy.c.a.a.a fFm;
    private TextView fad;
    private FrsFragment fxh;
    private ViewGroup mRootView;
    private int fFg = -1;
    private boolean fFh = false;
    private boolean fFi = false;
    private c.a fFj = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(v vVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.fxh.showToast(R.string.neterror);
                b.this.fFe.dismiss();
                b.this.fFi = false;
            } else if (vVar == null) {
                b.this.fFe.dismiss();
                b.this.fFi = false;
            } else if (b.this.fFg == vVar.fyZ) {
                b.this.fFe.dismiss();
                b.this.fFi = false;
            } else {
                b.this.fFh = true;
                b.this.vX(vVar.name);
                if (b.this.fxh.bjK() != null) {
                    b.this.fxh.bjK().ry(b.this.fFg);
                    b.this.fFg = vVar.fyZ;
                    b.this.fFe.dismiss();
                    b.this.fFi = false;
                    if (b.this.fFg != 7) {
                        x.axQ();
                        e.cpr();
                    } else {
                        e.cpq();
                    }
                    if (b.this.fxh.bjK() != null && b.this.fxh.bjP() != null) {
                        b.this.fxh.bjK().rx(vVar.fyZ);
                        b.this.fxh.bjP().startPullRefresh();
                        b.this.fxh.bjK().kz(true);
                        b.this.bnm();
                    }
                }
            }
        }
    };
    private View.OnClickListener fFk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.biW().biX()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    b.this.fxh.showToast(R.string.neterror);
                } else if (!com.baidu.tbadk.core.util.v.isEmpty(b.this.fFf)) {
                    b.this.a(b.this.fFf, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.fad != null) {
                Drawable a = SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                b.this.fad.setCompoundDrawables(null, null, a, null);
            }
        }
    };
    private b.a fFn = new b.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.b.4
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.fxh.showToast(R.string.neterror);
                bVar.dismiss();
                return;
            }
            v vVar = (v) com.baidu.tbadk.core.util.v.getItem(b.this.fFm.bnr(), i);
            if (vVar != null) {
                if (b.this.fFg != vVar.fyZ) {
                    b.this.fFh = true;
                    b.this.vX(vVar.name);
                    if (b.this.fxh.bjK() != null) {
                        b.this.fxh.bjK().ry(b.this.fFg);
                        b.this.fFg = vVar.fyZ;
                        bVar.dismiss();
                        if (b.this.fFg != 7) {
                            x.axQ();
                            e.cpr();
                        } else {
                            e.cpq();
                        }
                        if (b.this.fxh.bjK() != null && b.this.fxh.bjP() != null) {
                            b.this.fxh.bjK().rx(vVar.fyZ);
                            b.this.fxh.bjP().startPullRefresh();
                            b.this.fxh.bjK().kz(true);
                            b.this.bnm();
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
        this.ePT = str;
    }

    public TextView bnp() {
        return this.fad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vX(String str) {
        this.fad.setText(str);
    }

    public void qW(int i) {
        this.fFg = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, View view) {
        if (this.fFe == null) {
            this.fFe = new c(this.fxh.getContext());
            this.fFe.setOnDismissListener(this.mOnDismissListener);
            this.fFe.a(this.fFj);
        }
        this.fFe.setData(list, this.fFg);
        this.fFe.O(view);
        this.fFi = true;
        this.fad.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnm() {
        an anVar = new an("c11437");
        anVar.O("obj_type", this.fFg);
        anVar.bS("fid", this.ePT);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        if (frsFragment != null && relativeLayout != null) {
            this.fxh = frsFragment;
            this.mRootView = relativeLayout;
            this.fFb = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fad = (TextView) this.fFb.findViewById(R.id.sort_tab_menu_button);
            this.fFd = (TextView) this.fFb.findViewById(R.id.sort_tab_sort_name);
            this.fad.setOnClickListener(this.fFk);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fad != null) {
            am.setViewTextColor(this.fad, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fad, R.color.transparent);
            if (this.fFi) {
                a = SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_up_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_down_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.fad.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.fFd, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.fFb, R.color.cp_bg_line_d);
        if (this.fFe != null && this.fFi) {
            this.fFe.bnq();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            bno();
        } else if (this.fxh != null && this.fxh.bjK() != null && this.fxh.bjK().bpl()) {
            bnn();
            ArrayList arrayList = new ArrayList(list);
            if (!co(arrayList)) {
                if (!this.fFh) {
                    qX(i);
                    return;
                }
                return;
            }
            this.fFf = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    v vVar = new v();
                    vVar.fyZ = frsTabInfo.tab_id.intValue();
                    vVar.name = frsTabInfo.tab_name;
                    this.fFf.add(vVar);
                }
            }
            if (!this.fFh) {
                qX(i);
            }
        } else {
            bno();
        }
    }

    private void qX(int i) {
        v vVar;
        boolean z;
        v vVar2 = null;
        if (i <= 0) {
            v vVar3 = this.fFf.get(0);
            if (vVar3 != null) {
                qW(vVar3.fyZ);
                vX(vVar3.name);
                if (this.fxh != null && this.fxh.bjK() != null) {
                    this.fxh.bjK().rx(vVar3.fyZ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.fFf.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                vVar2 = this.fFf.get(i2);
                if (vVar2 == null || vVar2.fyZ != i) {
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
            v vVar4 = this.fFf.get(0);
            if (vVar4 != null) {
                qW(vVar4.fyZ);
                vX(vVar4.name);
                if (this.fxh != null && this.fxh.bjK() != null) {
                    this.fxh.bjK().rx(vVar4.fyZ);
                }
            }
        } else if (vVar != null) {
            qW(vVar.fyZ);
            vX(vVar.name);
            if (this.fxh != null && this.fxh.bjK() != null) {
                this.fxh.bjK().rx(vVar.fyZ);
            }
        }
    }

    private boolean co(List<FrsTabInfo> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fFf) && com.baidu.tbadk.core.util.v.getCount(list) == com.baidu.tbadk.core.util.v.getCount(this.fFf)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.fFf.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bnn() {
        if (this.fad != null) {
            this.fad.setVisibility(0);
        }
    }

    private void bno() {
        if (this.fad != null) {
            this.fad.setVisibility(8);
        }
    }
}
