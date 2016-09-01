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
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup Vz;
    private String ahj;
    private FrsActivity bWX;
    private TextView bWY;
    private List<cy> bWZ;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bXa;
    private int bXb = -1;
    private boolean bXc = false;
    private View.OnClickListener bXd = new b(this);
    private c.b bXe = new c(this);

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bWX = frsActivity;
            this.Vz = viewGroup;
            this.bWY = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int e = k.e(frsActivity.getActivity(), t.e.ds30);
            this.bWY.setPadding(e, 0, e, 0);
            this.bWY.setGravity(17);
            this.bWY.setTextSize(0, k.e(frsActivity.getActivity(), t.e.ds28));
            this.bWY.setCompoundDrawablePadding(k.e(frsActivity.getActivity(), t.e.ds20));
            this.bWY.setLayoutParams(layoutParams);
            this.bWY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(t.f.icon_frs_arrow_selector), (Drawable) null);
            this.bWY.setOnClickListener(this.bXd);
            this.Vz.addView(this.bWY);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public int ado() {
        return this.bXb;
    }

    public void ie(int i) {
        this.bXb = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bWY != null) {
            av.j((View) this.bWY, t.d.cp_cont_c);
            av.l(this.bWY, t.d.cp_bg_line_d);
            this.bWY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(t.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (y.t(list)) {
            adq();
        } else if (this.bWX != null && this.bWX.aaV() != null && this.bWX.aaV().aeN()) {
            adp();
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
            if (!ax(arrayList)) {
                if (!this.bXc) {
                    m14if(i);
                    return;
                }
                return;
            }
            this.bWZ = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    cy cyVar = new cy();
                    cyVar.bTp = frsTabInfo.tab_id.intValue();
                    cyVar.name = frsTabInfo.tab_name;
                    this.bWZ.add(cyVar);
                }
            }
            if (!this.bXc) {
                m14if(i);
            }
        } else {
            adq();
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m14if(int i) {
        cy cyVar;
        boolean z;
        cy cyVar2 = null;
        if (i <= 0) {
            cy cyVar3 = this.bWZ.get(0);
            if (cyVar3 != null) {
                ie(cyVar3.bTp);
                jQ(cyVar3.name);
                if (this.bWX != null && this.bWX.aaV() != null) {
                    this.bWX.aaV().ip(cyVar3.bTp);
                    this.bWX.aaV().hU(cyVar3.bTp);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bWZ.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cyVar = cyVar2;
                z = false;
                break;
            }
            cyVar2 = this.bWZ.get(i2);
            if (cyVar2 == null || cyVar2.bTp != i) {
                i2++;
            } else {
                cyVar = cyVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                jQ(TbadkCoreApplication.m9getInst().getResources().getString(t.j.attention_users_thread));
                return;
            }
            cy cyVar4 = this.bWZ.get(0);
            if (cyVar4 != null) {
                ie(cyVar4.bTp);
                jQ(cyVar4.name);
                if (this.bWX != null && this.bWX.aaV() != null) {
                    this.bWX.aaV().ip(cyVar4.bTp);
                    this.bWX.aaV().hU(cyVar4.bTp);
                }
            }
        } else if (cyVar != null) {
            ie(cyVar.bTp);
            jQ(cyVar.name);
            if (this.bWX != null && this.bWX.aaV() != null) {
                this.bWX.aaV().ip(cyVar.bTp);
                this.bWX.aaV().hU(cyVar.bTp);
            }
        }
    }

    private void jQ(String str) {
        this.bWY.setText(str);
    }

    private boolean ax(List<FrsTabInfo> list) {
        cy cyVar;
        if (!y.t(this.bWZ) && y.s(list) == y.s(this.bWZ)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && (cyVar = this.bWZ.get(i)) != null && cyVar.bTp != cyVar.bTp) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void adp() {
        if (this.bWY != null) {
            this.bWY.setVisibility(0);
        }
    }

    public void adq() {
        if (this.bWY != null) {
            this.bWY.setVisibility(8);
        }
    }

    public View adi() {
        return this.bWY;
    }

    public void hi(String str) {
        this.ahj = str;
    }
}
