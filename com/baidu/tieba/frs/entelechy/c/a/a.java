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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup VB;
    private String aRe;
    private FrsActivity bFS;
    private TextView bFT;
    private List<bv> bFU;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bFV;
    private int bFW = -1;
    private boolean bFX = false;
    private View.OnClickListener bFY = new b(this);
    private c.b bFZ = new c(this);

    public void setFid(String str) {
        this.aRe = str;
    }

    public TextView Zp() {
        return this.bFT;
    }

    public void iF(String str) {
        this.bFT.setText(str);
    }

    public int Zq() {
        return this.bFW;
    }

    public void hs(int i) {
        this.bFW = i;
    }

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bFS = frsActivity;
            this.VB = viewGroup;
            this.bFT = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int e = k.e(frsActivity.getActivity(), r.e.ds30);
            this.bFT.setPadding(e, 0, e, 0);
            this.bFT.setGravity(17);
            this.bFT.setTextSize(0, k.e(frsActivity.getActivity(), r.e.ds28));
            this.bFT.setCompoundDrawablePadding(k.e(frsActivity.getActivity(), r.e.ds20));
            this.bFT.setLayoutParams(layoutParams);
            this.bFT.setOnClickListener(this.bFY);
            this.VB.addView(this.bFT);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bFT != null) {
            ar.j((View) this.bFT, r.d.cp_cont_c);
            ar.l(this.bFT, r.d.cp_bg_line_d);
            this.bFT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(r.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void h(List<FrsTabInfo> list, int i) {
        if (x.t(list)) {
            Zs();
        } else if (this.bFS != null && this.bFS.Wh() != null && this.bFS.Wh().aaP()) {
            Zr();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!aq(arrayList)) {
                if (!this.bFX) {
                    ht(i);
                    return;
                }
                return;
            }
            this.bFU = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bv bvVar = new bv();
                    bvVar.bBw = frsTabInfo.tab_id.intValue();
                    bvVar.name = frsTabInfo.tab_name;
                    this.bFU.add(bvVar);
                }
            }
            if (!this.bFX) {
                ht(i);
            }
        } else {
            Zs();
        }
    }

    private void ht(int i) {
        bv bvVar;
        boolean z;
        bv bvVar2 = null;
        if (i <= 0) {
            bv bvVar3 = this.bFU.get(0);
            if (bvVar3 != null) {
                hs(bvVar3.bBw);
                iF(bvVar3.name);
                if (this.bFS != null && this.bFS.Wh() != null) {
                    this.bFS.Wh().hG(bvVar3.bBw);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bFU.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bvVar = bvVar2;
                z = false;
                break;
            }
            bvVar2 = this.bFU.get(i2);
            if (bvVar2 == null || bvVar2.bBw != i) {
                i2++;
            } else {
                bvVar = bvVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                iF(TbadkCoreApplication.m9getInst().getResources().getString(r.j.attention_users_thread));
                return;
            }
            bv bvVar4 = this.bFU.get(0);
            if (bvVar4 != null) {
                hs(bvVar4.bBw);
                iF(bvVar4.name);
                if (this.bFS != null && this.bFS.Wh() != null) {
                    this.bFS.Wh().hG(bvVar4.bBw);
                }
            }
        } else if (bvVar != null) {
            hs(bvVar.bBw);
            iF(bvVar.name);
            if (this.bFS != null && this.bFS.Wh() != null) {
                this.bFS.Wh().hG(bvVar.bBw);
            }
        }
    }

    private boolean aq(List<FrsTabInfo> list) {
        if (!x.t(this.bFU) && x.s(list) == x.s(this.bFU)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bFU.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void Zr() {
        if (this.bFT != null) {
            this.bFT.setVisibility(0);
        }
    }

    public void Zs() {
        if (this.bFT != null) {
            this.bFT.setVisibility(8);
        }
    }
}
