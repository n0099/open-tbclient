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
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup ZN;
    private r bVm;
    private TextView bZf;
    private List<bp> bZg;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bZh;
    private int bZi = -1;
    private boolean bZj = false;
    private View.OnClickListener bZk = new b(this);
    private c.b bZl = new c(this);
    private String bur;

    public void setFid(String str) {
        this.bur = str;
    }

    public TextView abY() {
        return this.bZf;
    }

    public void jc(String str) {
        this.bZf.setText(str);
    }

    public void iy(int i) {
        this.bZi = i;
    }

    public a(r rVar, ViewGroup viewGroup) {
        if (rVar != null && viewGroup != null) {
            this.bVm = rVar;
            this.ZN = viewGroup;
            this.bZf = new TextView(rVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(rVar.getActivity(), w.f.ds82));
            layoutParams.topMargin = k.g(rVar.getActivity(), w.f.ds26);
            int g = k.g(rVar.getActivity(), w.f.ds30);
            this.bZf.setPadding(g, 0, g, 0);
            this.bZf.setGravity(17);
            this.bZf.setTextSize(0, k.g(rVar.getActivity(), w.f.ds28));
            this.bZf.setCompoundDrawablePadding(k.g(rVar.getActivity(), w.f.ds8));
            this.bZf.setLayoutParams(layoutParams);
            this.bZf.setOnClickListener(this.bZk);
            this.ZN.addView(this.bZf);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bZf != null) {
            aq.i(this.bZf, w.e.cp_cont_f);
            aq.k(this.bZf, w.e.transparent);
            this.bZf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_public_down_arrow_gray_n), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (x.r(list)) {
            aca();
        } else if (this.bVm != null && this.bVm.ZY() != null && this.bVm.ZY().acV()) {
            abZ();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ao(arrayList)) {
                if (!this.bZj) {
                    iz(i);
                    return;
                }
                return;
            }
            this.bZg = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bp bpVar = new bp();
                    bpVar.bWI = frsTabInfo.tab_id.intValue();
                    bpVar.name = frsTabInfo.tab_name;
                    this.bZg.add(bpVar);
                }
            }
            if (!this.bZj) {
                iz(i);
            }
        } else {
            aca();
        }
    }

    private void iz(int i) {
        bp bpVar;
        boolean z;
        bp bpVar2 = null;
        if (i <= 0) {
            bp bpVar3 = this.bZg.get(0);
            if (bpVar3 != null) {
                iy(bpVar3.bWI);
                jc(bpVar3.name);
                if (this.bVm != null && this.bVm.ZY() != null) {
                    this.bVm.ZY().iK(bpVar3.bWI);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bZg.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bpVar = bpVar2;
                z = false;
                break;
            }
            bpVar2 = this.bZg.get(i2);
            if (bpVar2 == null || bpVar2.bWI != i) {
                i2++;
            } else {
                bpVar = bpVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                jc(TbadkCoreApplication.m9getInst().getResources().getString(w.l.attention_users_thread));
                return;
            }
            bp bpVar4 = this.bZg.get(0);
            if (bpVar4 != null) {
                iy(bpVar4.bWI);
                jc(bpVar4.name);
                if (this.bVm != null && this.bVm.ZY() != null) {
                    this.bVm.ZY().iK(bpVar4.bWI);
                }
            }
        } else if (bpVar != null) {
            iy(bpVar.bWI);
            jc(bpVar.name);
            if (this.bVm != null && this.bVm.ZY() != null) {
                this.bVm.ZY().iK(bpVar.bWI);
            }
        }
    }

    private boolean ao(List<FrsTabInfo> list) {
        if (!x.r(this.bZg) && x.q(list) == x.q(this.bZg)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bZg.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void abZ() {
        if (this.bZf != null) {
            this.bZf.setVisibility(0);
        }
    }

    public void aca() {
        if (this.bZf != null) {
            this.bZf.setVisibility(8);
        }
    }
}
