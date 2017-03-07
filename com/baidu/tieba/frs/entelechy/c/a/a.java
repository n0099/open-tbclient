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
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup aac;
    private FrsActivity bTp;
    private TextView bTq;
    private List<bt> bTr;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bTs;
    private int bTt = -1;
    private boolean bTu = false;
    private View.OnClickListener bTv = new b(this);
    private c.b bTw = new c(this);
    private String bqC;

    public void setFid(String str) {
        this.bqC = str;
    }

    public TextView abp() {
        return this.bTq;
    }

    public void iI(String str) {
        this.bTq.setText(str);
    }

    public int abq() {
        return this.bTt;
    }

    public void ib(int i) {
        this.bTt = i;
    }

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bTp = frsActivity;
            this.aac = viewGroup;
            this.bTq = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int g = k.g(frsActivity.getActivity(), w.f.ds30);
            this.bTq.setPadding(g, 0, g, 0);
            this.bTq.setGravity(17);
            this.bTq.setTextSize(0, k.g(frsActivity.getActivity(), w.f.ds28));
            this.bTq.setCompoundDrawablePadding(k.g(frsActivity.getActivity(), w.f.ds20));
            this.bTq.setLayoutParams(layoutParams);
            this.bTq.setOnClickListener(this.bTv);
            this.aac.addView(this.bTq);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bTq != null) {
            aq.i((View) this.bTq, w.e.cp_cont_c);
            aq.k(this.bTq, w.e.cp_bg_line_d);
            this.bTq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (x.q(list)) {
            abs();
        } else if (this.bTp != null && this.bTp.Yx() != null && this.bTp.Yx().acS()) {
            abr();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ar(arrayList)) {
                if (!this.bTu) {
                    ic(i);
                    return;
                }
                return;
            }
            this.bTr = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bt btVar = new bt();
                    btVar.bPZ = frsTabInfo.tab_id.intValue();
                    btVar.name = frsTabInfo.tab_name;
                    this.bTr.add(btVar);
                }
            }
            if (!this.bTu) {
                ic(i);
            }
        } else {
            abs();
        }
    }

    private void ic(int i) {
        bt btVar;
        boolean z;
        bt btVar2 = null;
        if (i <= 0) {
            bt btVar3 = this.bTr.get(0);
            if (btVar3 != null) {
                ib(btVar3.bPZ);
                iI(btVar3.name);
                if (this.bTp != null && this.bTp.Yx() != null) {
                    this.bTp.Yx().ip(btVar3.bPZ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bTr.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                btVar = btVar2;
                z = false;
                break;
            }
            btVar2 = this.bTr.get(i2);
            if (btVar2 == null || btVar2.bPZ != i) {
                i2++;
            } else {
                btVar = btVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                iI(TbadkCoreApplication.m9getInst().getResources().getString(w.l.attention_users_thread));
                return;
            }
            bt btVar4 = this.bTr.get(0);
            if (btVar4 != null) {
                ib(btVar4.bPZ);
                iI(btVar4.name);
                if (this.bTp != null && this.bTp.Yx() != null) {
                    this.bTp.Yx().ip(btVar4.bPZ);
                }
            }
        } else if (btVar != null) {
            ib(btVar.bPZ);
            iI(btVar.name);
            if (this.bTp != null && this.bTp.Yx() != null) {
                this.bTp.Yx().ip(btVar.bPZ);
            }
        }
    }

    private boolean ar(List<FrsTabInfo> list) {
        if (!x.q(this.bTr) && x.p(list) == x.p(this.bTr)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bTr.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void abr() {
        if (this.bTq != null) {
            this.bTq.setVisibility(0);
        }
    }

    public void abs() {
        if (this.bTq != null) {
            this.bTq.setVisibility(8);
        }
    }
}
