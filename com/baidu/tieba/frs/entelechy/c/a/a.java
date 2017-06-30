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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup ZO;
    private String bxM;
    private r cdv;
    private TextView cho;
    private List<bq> chp;
    private com.baidu.tieba.frs.entelechy.c.a.a.a chq;
    private int chr = -1;
    private boolean chs = false;
    private View.OnClickListener cht = new b(this);
    private c.b chu = new c(this);

    public void setFid(String str) {
        this.bxM = str;
    }

    public TextView afQ() {
        return this.cho;
    }

    public void jZ(String str) {
        this.cho.setText(str);
    }

    public void iK(int i) {
        this.chr = i;
    }

    public a(r rVar, ViewGroup viewGroup) {
        if (rVar != null && viewGroup != null) {
            this.cdv = rVar;
            this.ZO = viewGroup;
            this.cho = new TextView(rVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(rVar.getActivity(), w.f.ds82));
            layoutParams.topMargin = k.g(rVar.getActivity(), w.f.ds26);
            int g = k.g(rVar.getActivity(), w.f.ds30);
            this.cho.setPadding(g, 0, g, 0);
            this.cho.setGravity(17);
            this.cho.setTextSize(0, k.g(rVar.getActivity(), w.f.ds28));
            this.cho.setCompoundDrawablePadding(k.g(rVar.getActivity(), w.f.ds8));
            this.cho.setLayoutParams(layoutParams);
            this.cho.setOnClickListener(this.cht);
            this.ZO.addView(this.cho);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cho != null) {
            as.i(this.cho, w.e.cp_cont_f);
            as.k(this.cho, w.e.transparent);
            this.cho.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(w.g.icon_public_down_arrow_gray_n), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (z.t(list)) {
            afS();
        } else if (this.cdv != null && this.cdv.adP() != null && this.cdv.adP().agO()) {
            afR();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ax(arrayList)) {
                if (!this.chs) {
                    iL(i);
                    return;
                }
                return;
            }
            this.chp = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bq bqVar = new bq();
                    bqVar.ceQ = frsTabInfo.tab_id.intValue();
                    bqVar.name = frsTabInfo.tab_name;
                    this.chp.add(bqVar);
                }
            }
            if (!this.chs) {
                iL(i);
            }
        } else {
            afS();
        }
    }

    private void iL(int i) {
        bq bqVar;
        boolean z;
        bq bqVar2 = null;
        if (i <= 0) {
            bq bqVar3 = this.chp.get(0);
            if (bqVar3 != null) {
                iK(bqVar3.ceQ);
                jZ(bqVar3.name);
                if (this.cdv != null && this.cdv.adP() != null) {
                    this.cdv.adP().iW(bqVar3.ceQ);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.chp.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bqVar = bqVar2;
                z = false;
                break;
            }
            bqVar2 = this.chp.get(i2);
            if (bqVar2 == null || bqVar2.ceQ != i) {
                i2++;
            } else {
                bqVar = bqVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                jZ(TbadkCoreApplication.m9getInst().getResources().getString(w.l.attention_users_thread));
                return;
            }
            bq bqVar4 = this.chp.get(0);
            if (bqVar4 != null) {
                iK(bqVar4.ceQ);
                jZ(bqVar4.name);
                if (this.cdv != null && this.cdv.adP() != null) {
                    this.cdv.adP().iW(bqVar4.ceQ);
                }
            }
        } else if (bqVar != null) {
            iK(bqVar.ceQ);
            jZ(bqVar.name);
            if (this.cdv != null && this.cdv.adP() != null) {
                this.cdv.adP().iW(bqVar.ceQ);
            }
        }
    }

    private boolean ax(List<FrsTabInfo> list) {
        if (!z.t(this.chp) && z.s(list) == z.s(this.chp)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.chp.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void afR() {
        if (this.cho != null) {
            this.cho.setVisibility(0);
        }
    }

    public void afS() {
        if (this.cho != null) {
            this.cho.setVisibility(8);
        }
    }
}
