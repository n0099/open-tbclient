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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.c.a.c;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class a {
    private String emo;
    private TextView fTN;
    private View gyb;
    private FrsNewAreaFragment gyc;
    private TextView gyd;
    private c gye;
    private List<w> gyf;
    private int gyg = -1;
    private boolean gyh = false;
    private boolean gyi = false;
    private c.a gyj = new c.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.1
        @Override // com.baidu.tieba.frs.entelechy.c.a.c.a
        public void a(w wVar) {
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.gyc.showToast(R.string.neterror);
                a.this.gye.dismiss();
                a.this.gyi = false;
            } else if (wVar == null) {
                a.this.gye.dismiss();
                a.this.gyi = false;
            } else if (a.this.gyg == wVar.gse) {
                a.this.gye.dismiss();
                a.this.gyi = false;
            } else {
                a.this.gyh = true;
                a.this.Bn(wVar.name);
                if (a.this.gyc.bJx() != null) {
                    a.this.gyg = wVar.gse;
                    a.this.gye.dismiss();
                    a.this.gyi = false;
                    if (a.this.gyg != 7) {
                        aa.aSs();
                        e.cMc();
                    } else {
                        e.cMb();
                    }
                    if (a.this.gyc.bJx() != null && a.this.gyc.bJy() != null) {
                        a.this.gyc.bJx().tN(wVar.gse);
                        a.this.gyc.bJy().startPullRefresh();
                        a.this.bHp();
                    }
                }
            }
        }
    };
    private View.OnClickListener gyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.frs.a.bCW().bCX()) {
                if (!j.isNetworkAvailableForImmediately()) {
                    a.this.gyc.showToast(R.string.neterror);
                } else if (!v.isEmpty(a.this.gyf)) {
                    a.this.a(a.this.gyf, view);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.entelechy.c.a.a.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.fTN != null) {
                Drawable a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
                if (a != null) {
                    a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
                }
                a.this.fTN.setCompoundDrawables(null, null, a, null);
            }
        }
    };

    public void setFid(String str) {
        this.emo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn(String str) {
        this.fTN.setText(str);
    }

    public void tm(int i) {
        this.gyg = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<w> list, View view) {
        if (this.gye == null) {
            this.gye = new c(this.gyc.getContext());
            this.gye.setOnDismissListener(this.mOnDismissListener);
            this.gye.a(this.gyj);
        }
        this.gye.setData(list, this.gyg);
        this.gye.R(view);
        this.gyi = true;
        this.fTN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHp() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gyg);
        anVar.cy("fid", this.emo);
        TiebaStatic.log(anVar);
    }

    public a(FrsNewAreaFragment frsNewAreaFragment, RelativeLayout relativeLayout) {
        if (frsNewAreaFragment != null && relativeLayout != null) {
            this.gyc = frsNewAreaFragment;
            this.gyb = LayoutInflater.from(frsNewAreaFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.fTN = (TextView) this.gyb.findViewById(R.id.sort_tab_menu_button);
            this.gyd = (TextView) this.gyb.findViewById(R.id.sort_tab_sort_name);
            this.fTN.setOnClickListener(this.gyk);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Drawable a;
        if (this.fTN != null) {
            am.setViewTextColor(this.fTN, (int) R.color.cp_cont_j);
            am.setBackgroundColor(this.fTN, R.color.transparent);
            if (this.gyi) {
                a = SvgManager.aGC().a(R.drawable.icon_pure_fold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
            } else {
                a = SvgManager.aGC().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_c, (SvgManager.SvgResourceStateType) null);
            }
            this.fTN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, a, (Drawable) null);
        }
        am.setViewTextColor(this.gyd, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gyb, R.color.cp_bg_line_d);
        if (this.gye != null && this.gyi) {
            this.gye.bHt();
        }
    }

    public void setData(List<FrsTabInfo> list, int i) {
        if (v.isEmpty(list)) {
            bHr();
        } else if (this.gyc != null && this.gyc.bJx() != null) {
            bHq();
            ArrayList arrayList = new ArrayList(list);
            if (!cg(arrayList)) {
                if (!this.gyh) {
                    tn(i);
                    return;
                }
                return;
            }
            this.gyf = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    w wVar = new w();
                    wVar.gse = frsTabInfo.tab_id.intValue();
                    wVar.name = frsTabInfo.tab_name;
                    this.gyf.add(wVar);
                }
            }
            if (!this.gyh) {
                tn(i);
            }
        } else {
            bHr();
        }
    }

    private void tn(int i) {
        w wVar;
        boolean z;
        w wVar2 = null;
        if (i <= 0) {
            w wVar3 = this.gyf.get(0);
            if (wVar3 != null) {
                tm(wVar3.gse);
                Bn(wVar3.name);
                if (this.gyc != null && this.gyc.bJx() != null) {
                    this.gyc.bJx().tN(wVar3.gse);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.gyf.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                wVar2 = this.gyf.get(i2);
                if (wVar2 == null || wVar2.gse != i) {
                    i2++;
                } else {
                    wVar = wVar2;
                    z = true;
                    break;
                }
            } else {
                wVar = wVar2;
                z = false;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                Bn(TbadkCoreApplication.getInst().getResources().getString(R.string.attention_users_thread));
                return;
            }
            w wVar4 = this.gyf.get(0);
            if (wVar4 != null) {
                tm(wVar4.gse);
                Bn(wVar4.name);
                if (this.gyc != null && this.gyc.bJx() != null) {
                    this.gyc.bJx().tN(wVar4.gse);
                }
            }
        } else if (wVar != null) {
            tm(wVar.gse);
            Bn(wVar.name);
            if (this.gyc != null && this.gyc.bJx() != null) {
                this.gyc.bJx().tN(wVar.gse);
            }
        }
    }

    private boolean cg(List<FrsTabInfo> list) {
        if (!v.isEmpty(this.gyf) && v.getCount(list) == v.getCount(this.gyf)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.gyf.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    private void bHq() {
        if (this.fTN != null) {
            this.fTN.setVisibility(0);
        }
    }

    private void bHr() {
        if (this.fTN != null) {
            this.fTN.setVisibility(8);
        }
    }
}
