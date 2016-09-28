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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup VJ;
    private String aPG;
    private FrsActivity bWR;
    private TextView bWS;
    private List<cy> bWT;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bWU;
    private int bWV = -1;
    private boolean bWW = false;
    private View.OnClickListener bWX = new b(this);
    private c.b bWY = new c(this);

    public a(FrsActivity frsActivity, ViewGroup viewGroup) {
        if (frsActivity != null && viewGroup != null) {
            this.bWR = frsActivity;
            this.VJ = viewGroup;
            this.bWS = new TextView(frsActivity.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int e = k.e(frsActivity.getActivity(), r.e.ds30);
            this.bWS.setPadding(e, 0, e, 0);
            this.bWS.setGravity(17);
            this.bWS.setTextSize(0, k.e(frsActivity.getActivity(), r.e.ds28));
            this.bWS.setCompoundDrawablePadding(k.e(frsActivity.getActivity(), r.e.ds20));
            this.bWS.setLayoutParams(layoutParams);
            this.bWS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(r.f.icon_frs_arrow_selector), (Drawable) null);
            this.bWS.setOnClickListener(this.bWX);
            this.VJ.addView(this.bWS);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public int adC() {
        return this.bWV;
    }

    public void ii(int i) {
        this.bWV = i;
    }

    public void onChangeSkinType(int i) {
        if (this.bWS != null) {
            av.j((View) this.bWS, r.d.cp_cont_c);
            av.l(this.bWS, r.d.cp_bg_line_d);
            this.bWS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(r.f.icon_frs_arrow_selector), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (y.t(list)) {
            adE();
        } else if (this.bWR != null && this.bWR.abi() != null && this.bWR.abi().afb()) {
            adD();
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
                if (!this.bWW) {
                    ij(i);
                    return;
                }
                return;
            }
            this.bWT = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    cy cyVar = new cy();
                    cyVar.bTi = frsTabInfo.tab_id.intValue();
                    cyVar.name = frsTabInfo.tab_name;
                    this.bWT.add(cyVar);
                }
            }
            if (!this.bWW) {
                ij(i);
            }
        } else {
            adE();
        }
    }

    private void ij(int i) {
        cy cyVar;
        boolean z;
        cy cyVar2 = null;
        if (i <= 0) {
            cy cyVar3 = this.bWT.get(0);
            if (cyVar3 != null) {
                ii(cyVar3.bTi);
                jX(cyVar3.name);
                if (this.bWR != null && this.bWR.abi() != null) {
                    this.bWR.abi().iu(cyVar3.bTi);
                    this.bWR.abi().hY(cyVar3.bTi);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bWT.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cyVar = cyVar2;
                z = false;
                break;
            }
            cyVar2 = this.bWT.get(i2);
            if (cyVar2 == null || cyVar2.bTi != i) {
                i2++;
            } else {
                cyVar = cyVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                jX(TbadkCoreApplication.m9getInst().getResources().getString(r.j.attention_users_thread));
                return;
            }
            cy cyVar4 = this.bWT.get(0);
            if (cyVar4 != null) {
                ii(cyVar4.bTi);
                jX(cyVar4.name);
                if (this.bWR != null && this.bWR.abi() != null) {
                    this.bWR.abi().iu(cyVar4.bTi);
                    this.bWR.abi().hY(cyVar4.bTi);
                }
            }
        } else if (cyVar != null) {
            ii(cyVar.bTi);
            jX(cyVar.name);
            if (this.bWR != null && this.bWR.abi() != null) {
                this.bWR.abi().iu(cyVar.bTi);
                this.bWR.abi().hY(cyVar.bTi);
            }
        }
    }

    private void jX(String str) {
        this.bWS.setText(str);
    }

    private boolean ax(List<FrsTabInfo> list) {
        if (!y.t(this.bWT) && y.s(list) == y.s(this.bWT)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bWT.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void adD() {
        if (this.bWS != null) {
            this.bWS.setVisibility(0);
        }
    }

    public void adE() {
        if (this.bWS != null) {
            this.bWS.setVisibility(8);
        }
    }

    public View adw() {
        return this.bWS;
    }

    public void setFid(String str) {
        this.aPG = str;
    }
}
