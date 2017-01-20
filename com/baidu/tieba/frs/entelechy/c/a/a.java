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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup UR;
    private FrsActivity bMj;
    private TextView bMk;
    private List<bt> bMl;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bMm;
    private int bMn = -1;
    private boolean bMo = false;
    private View.OnClickListener bMp = new b(this);
    private c.b bMq = new c(this);
    private String bjT;

    public void setFid(String str) {
        this.bjT = str;
    }

    public TextView aas() {
        return this.bMk;
    }

    public void iS(String str) {
        this.bMk.setText(str);
    }

    public int aat() {
        return this.bMn;
    }

    /* renamed from: if  reason: not valid java name */
    public void m14if(int i) {
        this.bMn = i;
    }

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bMj = frsActivity;
            this.UR = viewGroup;
            this.bMk = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int e = k.e(frsActivity.getActivity(), r.f.ds30);
            this.bMk.setPadding(e, 0, e, 0);
            this.bMk.setGravity(17);
            this.bMk.setTextSize(0, k.e(frsActivity.getActivity(), r.f.ds28));
            this.bMk.setCompoundDrawablePadding(k.e(frsActivity.getActivity(), r.f.ds20));
            this.bMk.setLayoutParams(layoutParams);
            this.bMk.setOnClickListener(this.bMp);
            this.UR.addView(this.bMk);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bMk != null) {
            ap.i((View) this.bMk, r.e.cp_cont_c);
            ap.k(this.bMk, r.e.cp_bg_line_d);
            this.bMk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(r.g.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void h(List<FrsTabInfo> list, int i) {
        if (w.s(list)) {
            aav();
        } else if (this.bMj != null && this.bMj.Xy() != null && this.bMj.Xy().abV()) {
            aau();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!au(arrayList)) {
                if (!this.bMo) {
                    ig(i);
                    return;
                }
                return;
            }
            this.bMl = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bt btVar = new bt();
                    btVar.bIQ = frsTabInfo.tab_id.intValue();
                    btVar.name = frsTabInfo.tab_name;
                    this.bMl.add(btVar);
                }
            }
            if (!this.bMo) {
                ig(i);
            }
        } else {
            aav();
        }
    }

    private void ig(int i) {
        bt btVar;
        boolean z;
        bt btVar2 = null;
        if (i <= 0) {
            bt btVar3 = this.bMl.get(0);
            if (btVar3 != null) {
                m14if(btVar3.bIQ);
                iS(btVar3.name);
                if (this.bMj != null && this.bMj.Xy() != null) {
                    this.bMj.Xy().it(btVar3.bIQ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bMl.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                btVar = btVar2;
                z = false;
                break;
            }
            btVar2 = this.bMl.get(i2);
            if (btVar2 == null || btVar2.bIQ != i) {
                i2++;
            } else {
                btVar = btVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                iS(TbadkCoreApplication.m9getInst().getResources().getString(r.l.attention_users_thread));
                return;
            }
            bt btVar4 = this.bMl.get(0);
            if (btVar4 != null) {
                m14if(btVar4.bIQ);
                iS(btVar4.name);
                if (this.bMj != null && this.bMj.Xy() != null) {
                    this.bMj.Xy().it(btVar4.bIQ);
                }
            }
        } else if (btVar != null) {
            m14if(btVar.bIQ);
            iS(btVar.name);
            if (this.bMj != null && this.bMj.Xy() != null) {
                this.bMj.Xy().it(btVar.bIQ);
            }
        }
    }

    private boolean au(List<FrsTabInfo> list) {
        if (!w.s(this.bMl) && w.r(list) == w.r(this.bMl)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bMl.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void aau() {
        if (this.bMk != null) {
            this.bMk.setVisibility(0);
        }
    }

    public void aav() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }
}
