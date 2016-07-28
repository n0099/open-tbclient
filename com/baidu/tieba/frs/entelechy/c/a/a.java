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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup SJ;
    private String aeq;
    private FrsActivity bLH;
    private TextView bLI;
    private List<dc> bLJ;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bLK;
    private int bLL = -1;
    private boolean bLM = false;
    private View.OnClickListener bLN = new b(this);
    private c.b bLO = new c(this);

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bLH = frsActivity;
            this.SJ = viewGroup;
            this.bLI = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int c = k.c(frsActivity.getActivity(), u.e.ds30);
            this.bLI.setPadding(c, 0, c, 0);
            this.bLI.setGravity(17);
            this.bLI.setTextSize(0, k.c(frsActivity.getActivity(), u.e.ds28));
            this.bLI.setCompoundDrawablePadding(k.c(frsActivity.getActivity(), u.e.ds20));
            this.bLI.setLayoutParams(layoutParams);
            this.bLI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(u.f.icon_frs_arrow_selector), (Drawable) null);
            this.bLI.setOnClickListener(this.bLN);
            this.SJ.addView(this.bLI);
            onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    public int YC() {
        return this.bLL;
    }

    public void hB(int i) {
        this.bLL = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bLI != null) {
            av.j((View) this.bLI, u.d.cp_cont_c);
            av.l(this.bLI, u.d.cp_bg_line_d);
            this.bLI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(u.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (y.t(list)) {
            YE();
        } else if (this.bLH != null && this.bLH.VY() != null && this.bLH.VY().aac()) {
            YD();
            ArrayList arrayList = new ArrayList(list);
            if (arrayList != null) {
                Iterator<FrsTabInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    FrsTabInfo next = it.next();
                    if (next != null && next.tab_id.intValue() == 6) {
                        it.remove();
                    }
                }
            }
            if (!av(arrayList)) {
                if (!this.bLM) {
                    hC(i);
                    return;
                }
                return;
            }
            this.bLJ = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    dc dcVar = new dc();
                    dcVar.bIj = frsTabInfo.tab_id.intValue();
                    dcVar.name = frsTabInfo.tab_name;
                    this.bLJ.add(dcVar);
                }
            }
            if (!this.bLM) {
                hC(i);
            }
        } else {
            YE();
        }
    }

    private void hC(int i) {
        dc dcVar;
        boolean z;
        dc dcVar2 = null;
        if (i <= 0) {
            dc dcVar3 = this.bLJ.get(0);
            if (dcVar3 != null) {
                hB(dcVar3.bIj);
                jh(dcVar3.name);
                if (this.bLH != null && this.bLH.VY() != null) {
                    this.bLH.VY().hM(dcVar3.bIj);
                    this.bLH.VY().hr(dcVar3.bIj);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bLJ.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dcVar = dcVar2;
                z = false;
                break;
            }
            dcVar2 = this.bLJ.get(i2);
            if (dcVar2 == null || dcVar2.bIj != i) {
                i2++;
            } else {
                dcVar = dcVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                jh(TbadkCoreApplication.m10getInst().getResources().getString(u.j.attention_users_thread));
                return;
            }
            dc dcVar4 = this.bLJ.get(0);
            if (dcVar4 != null) {
                hB(dcVar4.bIj);
                jh(dcVar4.name);
                if (this.bLH != null && this.bLH.VY() != null) {
                    this.bLH.VY().hM(dcVar4.bIj);
                    this.bLH.VY().hr(dcVar4.bIj);
                }
            }
        } else if (dcVar != null) {
            hB(dcVar.bIj);
            jh(dcVar.name);
            if (this.bLH != null && this.bLH.VY() != null) {
                this.bLH.VY().hM(dcVar.bIj);
                this.bLH.VY().hr(dcVar.bIj);
            }
        }
    }

    private void jh(String str) {
        this.bLI.setText(str);
    }

    private boolean av(List<FrsTabInfo> list) {
        dc dcVar;
        if (!y.t(this.bLJ) && y.s(list) == y.s(this.bLJ)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && (dcVar = this.bLJ.get(i)) != null && dcVar.bIj != dcVar.bIj) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void YD() {
        if (this.bLI != null) {
            this.bLI.setVisibility(0);
        }
    }

    public void YE() {
        if (this.bLI != null) {
            this.bLI.setVisibility(8);
        }
    }

    public View Yw() {
        return this.bLI;
    }

    public void gF(String str) {
        this.aeq = str;
    }
}
