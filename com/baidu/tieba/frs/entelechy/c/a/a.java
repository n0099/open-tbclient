package com.baidu.tieba.frs.entelechy.c.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup aat;
    private FrsActivity bVu;
    private TextView bVv;
    private List<bv> bVw;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bVx;
    private String bsM;
    private int bVy = -1;
    private boolean bVz = false;
    private View.OnClickListener bVA = new b(this);
    private c.b bVB = new c(this);

    public void setFid(String str) {
        this.bsM = str;
    }

    public TextView acN() {
        return this.bVv;
    }

    public void iN(String str) {
        this.bVv.setText(str);
    }

    public void ik(int i) {
        this.bVy = i;
    }

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bVu = frsActivity;
            this.aat = viewGroup;
            this.bVv = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int g = k.g(frsActivity.getActivity(), w.f.ds30);
            this.bVv.setPadding(g, 0, g, 0);
            this.bVv.setGravity(17);
            this.bVv.setTextSize(0, k.g(frsActivity.getActivity(), w.f.ds28));
            this.bVv.setCompoundDrawablePadding(k.g(frsActivity.getActivity(), w.f.ds20));
            this.bVv.setLayoutParams(layoutParams);
            this.bVv.setOnClickListener(this.bVA);
            this.aat.addView(this.bVv);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bVv != null) {
            aq.i(this.bVv, w.e.cp_cont_c);
            aq.k(this.bVv, w.e.cp_bg_line_d);
            this.bVv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (x.q(list)) {
            acP();
        } else if (this.bVu != null && this.bVu.ZU() != null && this.bVu.ZU().adN()) {
            acO();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!as(arrayList)) {
                if (!this.bVz) {
                    il(i);
                    return;
                }
                return;
            }
            this.bVw = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bv bvVar = new bv();
                    bvVar.bSf = frsTabInfo.tab_id.intValue();
                    bvVar.name = frsTabInfo.tab_name;
                    this.bVw.add(bvVar);
                }
            }
            if (!this.bVz) {
                il(i);
            }
        } else {
            acP();
        }
    }

    private void il(int i) {
        bv bvVar;
        boolean z;
        bv bvVar2 = null;
        if (i <= 0) {
            bv bvVar3 = this.bVw.get(0);
            if (bvVar3 != null) {
                ik(bvVar3.bSf);
                iN(bvVar3.name);
                if (this.bVu != null && this.bVu.ZU() != null) {
                    this.bVu.ZU().iw(bvVar3.bSf);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bVw.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bvVar = bvVar2;
                z = false;
                break;
            }
            bvVar2 = this.bVw.get(i2);
            if (bvVar2 == null || bvVar2.bSf != i) {
                i2++;
            } else {
                bvVar = bvVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                iN(TbadkCoreApplication.m9getInst().getResources().getString(w.l.attention_users_thread));
                return;
            }
            bv bvVar4 = this.bVw.get(0);
            if (bvVar4 != null) {
                ik(bvVar4.bSf);
                iN(bvVar4.name);
                if (this.bVu != null && this.bVu.ZU() != null) {
                    this.bVu.ZU().iw(bvVar4.bSf);
                }
            }
        } else if (bvVar != null) {
            ik(bvVar.bSf);
            iN(bvVar.name);
            if (this.bVu != null && this.bVu.ZU() != null) {
                this.bVu.ZU().iw(bvVar.bSf);
            }
        }
    }

    private boolean as(List<FrsTabInfo> list) {
        if (!x.q(this.bVw) && x.p(list) == x.p(this.bVw)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bVw.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void acO() {
        if (this.bVv != null) {
            this.bVv.setVisibility(0);
        }
    }

    public void acP() {
        if (this.bVv != null) {
            this.bVv.setVisibility(8);
        }
    }
}
