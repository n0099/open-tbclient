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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup Wh;
    private String aRN;
    private FrsActivity cai;
    private TextView caj;
    private List<bw> cak;
    private com.baidu.tieba.frs.entelechy.c.a.a.a cal;
    private int cam = -1;
    private boolean can = false;
    private View.OnClickListener cao = new b(this);
    private c.b cap = new c(this);

    public void setFid(String str) {
        this.aRN = str;
    }

    public TextView aeU() {
        return this.caj;
    }

    public void kb(String str) {
        this.caj.setText(str);
    }

    public int aeV() {
        return this.cam;
    }

    public void ii(int i) {
        this.cam = i;
    }

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.cai = frsActivity;
            this.Wh = viewGroup;
            this.caj = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int e = k.e(frsActivity.getActivity(), r.e.ds30);
            this.caj.setPadding(e, 0, e, 0);
            this.caj.setGravity(17);
            this.caj.setTextSize(0, k.e(frsActivity.getActivity(), r.e.ds28));
            this.caj.setCompoundDrawablePadding(k.e(frsActivity.getActivity(), r.e.ds20));
            this.caj.setLayoutParams(layoutParams);
            this.caj.setOnClickListener(this.cao);
            this.Wh.addView(this.caj);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.caj != null) {
            at.j((View) this.caj, r.d.cp_cont_c);
            at.l(this.caj, r.d.cp_bg_line_d);
            this.caj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(r.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (x.t(list)) {
            aeX();
        } else if (this.cai != null && this.cai.abS() != null && this.cai.abS().agt()) {
            aeW();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ay(arrayList)) {
                if (!this.can) {
                    ij(i);
                    return;
                }
                return;
            }
            this.cak = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bw bwVar = new bw();
                    bwVar.bVo = frsTabInfo.tab_id.intValue();
                    bwVar.name = frsTabInfo.tab_name;
                    this.cak.add(bwVar);
                }
            }
            if (!this.can) {
                ij(i);
            }
        } else {
            aeX();
        }
    }

    private void ij(int i) {
        bw bwVar;
        boolean z;
        bw bwVar2 = null;
        if (i <= 0) {
            bw bwVar3 = this.cak.get(0);
            if (bwVar3 != null) {
                ii(bwVar3.bVo);
                kb(bwVar3.name);
                if (this.cai != null && this.cai.abS() != null) {
                    this.cai.abS().iw(bwVar3.bVo);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.cak.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bwVar = bwVar2;
                z = false;
                break;
            }
            bwVar2 = this.cak.get(i2);
            if (bwVar2 == null || bwVar2.bVo != i) {
                i2++;
            } else {
                bwVar = bwVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                kb(TbadkCoreApplication.m9getInst().getResources().getString(r.j.attention_users_thread));
                return;
            }
            bw bwVar4 = this.cak.get(0);
            if (bwVar4 != null) {
                ii(bwVar4.bVo);
                kb(bwVar4.name);
                if (this.cai != null && this.cai.abS() != null) {
                    this.cai.abS().iw(bwVar4.bVo);
                }
            }
        } else if (bwVar != null) {
            ii(bwVar.bVo);
            kb(bwVar.name);
            if (this.cai != null && this.cai.abS() != null) {
                this.cai.abS().iw(bwVar.bVo);
            }
        }
    }

    private boolean ay(List<FrsTabInfo> list) {
        if (!x.t(this.cak) && x.s(list) == x.s(this.cak)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.cak.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void aeW() {
        if (this.caj != null) {
            this.caj.setVisibility(0);
        }
    }

    public void aeX() {
        if (this.caj != null) {
            this.caj.setVisibility(8);
        }
    }
}
