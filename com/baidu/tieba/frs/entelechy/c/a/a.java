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
    private ViewGroup aas;
    private FrsActivity bTd;
    private TextView bTe;
    private List<bv> bTf;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bTg;
    private int bTh = -1;
    private boolean bTi = false;
    private View.OnClickListener bTj = new b(this);
    private c.b bTk = new c(this);
    private String bqv;

    public void setFid(String str) {
        this.bqv = str;
    }

    public TextView abM() {
        return this.bTe;
    }

    public void iM(String str) {
        this.bTe.setText(str);
    }

    public void ie(int i) {
        this.bTh = i;
    }

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bTd = frsActivity;
            this.aas = viewGroup;
            this.bTe = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int g = k.g(frsActivity.getActivity(), w.f.ds30);
            this.bTe.setPadding(g, 0, g, 0);
            this.bTe.setGravity(17);
            this.bTe.setTextSize(0, k.g(frsActivity.getActivity(), w.f.ds28));
            this.bTe.setCompoundDrawablePadding(k.g(frsActivity.getActivity(), w.f.ds20));
            this.bTe.setLayoutParams(layoutParams);
            this.bTe.setOnClickListener(this.bTj);
            this.aas.addView(this.bTe);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bTe != null) {
            aq.i(this.bTe, w.e.cp_cont_c);
            aq.k(this.bTe, w.e.cp_bg_line_d);
            this.bTe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (x.q(list)) {
            abO();
        } else if (this.bTd != null && this.bTd.YT() != null && this.bTd.YT().acM()) {
            abN();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ar(arrayList)) {
                if (!this.bTi) {
                    m18if(i);
                    return;
                }
                return;
            }
            this.bTf = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bv bvVar = new bv();
                    bvVar.bPO = frsTabInfo.tab_id.intValue();
                    bvVar.name = frsTabInfo.tab_name;
                    this.bTf.add(bvVar);
                }
            }
            if (!this.bTi) {
                m18if(i);
            }
        } else {
            abO();
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m18if(int i) {
        bv bvVar;
        boolean z;
        bv bvVar2 = null;
        if (i <= 0) {
            bv bvVar3 = this.bTf.get(0);
            if (bvVar3 != null) {
                ie(bvVar3.bPO);
                iM(bvVar3.name);
                if (this.bTd != null && this.bTd.YT() != null) {
                    this.bTd.YT().iq(bvVar3.bPO);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bTf.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bvVar = bvVar2;
                z = false;
                break;
            }
            bvVar2 = this.bTf.get(i2);
            if (bvVar2 == null || bvVar2.bPO != i) {
                i2++;
            } else {
                bvVar = bvVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                iM(TbadkCoreApplication.m9getInst().getResources().getString(w.l.attention_users_thread));
                return;
            }
            bv bvVar4 = this.bTf.get(0);
            if (bvVar4 != null) {
                ie(bvVar4.bPO);
                iM(bvVar4.name);
                if (this.bTd != null && this.bTd.YT() != null) {
                    this.bTd.YT().iq(bvVar4.bPO);
                }
            }
        } else if (bvVar != null) {
            ie(bvVar.bPO);
            iM(bvVar.name);
            if (this.bTd != null && this.bTd.YT() != null) {
                this.bTd.YT().iq(bvVar.bPO);
            }
        }
    }

    private boolean ar(List<FrsTabInfo> list) {
        if (!x.q(this.bTf) && x.p(list) == x.p(this.bTf)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bTf.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void abN() {
        if (this.bTe != null) {
            this.bTe.setVisibility(0);
        }
    }

    public void abO() {
        if (this.bTe != null) {
            this.bTe.setVisibility(8);
        }
    }
}
