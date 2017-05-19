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
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    private ViewGroup ZO;
    private r bPw;
    private TextView bTn;
    private List<bo> bTo;
    private com.baidu.tieba.frs.entelechy.c.a.a.a bTp;
    private int bTq = -1;
    private boolean bTr = false;
    private View.OnClickListener bTs = new b(this);
    private c.b bTt = new c(this);
    private String btj;

    public void setFid(String str) {
        this.btj = str;
    }

    public TextView aaU() {
        return this.bTn;
    }

    public void iU(String str) {
        this.bTn.setText(str);
    }

    public void ia(int i) {
        this.bTq = i;
    }

    public a(r rVar, ViewGroup viewGroup) {
        if (rVar != null && viewGroup != null) {
            this.bPw = rVar;
            this.ZO = viewGroup;
            this.bTn = new TextView(rVar.getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(rVar.getActivity(), w.f.ds82));
            layoutParams.topMargin = k.g(rVar.getActivity(), w.f.ds26);
            int g = k.g(rVar.getActivity(), w.f.ds30);
            this.bTn.setPadding(g, 0, g, 0);
            this.bTn.setGravity(17);
            this.bTn.setTextSize(0, k.g(rVar.getActivity(), w.f.ds28));
            this.bTn.setCompoundDrawablePadding(k.g(rVar.getActivity(), w.f.ds8));
            this.bTn.setLayoutParams(layoutParams);
            this.bTn.setOnClickListener(this.bTs);
            this.ZO.addView(this.bTn);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bTn != null) {
            aq.i(this.bTn, w.e.cp_cont_f);
            aq.k(this.bTn, w.e.transparent);
            this.bTn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_public_down_arrow_gray_n), (Drawable) null);
        }
    }

    public void i(List<FrsTabInfo> list, int i) {
        if (x.r(list)) {
            aaW();
        } else if (this.bPw != null && this.bPw.YU() != null && this.bPw.YU().abR()) {
            aaV();
            ArrayList arrayList = new ArrayList(list);
            Iterator<FrsTabInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FrsTabInfo next = it.next();
                if (next != null && next.tab_id.intValue() == 6) {
                    it.remove();
                }
            }
            if (!ao(arrayList)) {
                if (!this.bTr) {
                    ib(i);
                    return;
                }
                return;
            }
            this.bTo = new ArrayList();
            for (FrsTabInfo frsTabInfo : arrayList) {
                if (frsTabInfo != null && frsTabInfo.tab_id != null && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    bo boVar = new bo();
                    boVar.bQR = frsTabInfo.tab_id.intValue();
                    boVar.name = frsTabInfo.tab_name;
                    this.bTo.add(boVar);
                }
            }
            if (!this.bTr) {
                ib(i);
            }
        } else {
            aaW();
        }
    }

    private void ib(int i) {
        bo boVar;
        boolean z;
        bo boVar2 = null;
        if (i <= 0) {
            bo boVar3 = this.bTo.get(0);
            if (boVar3 != null) {
                ia(boVar3.bQR);
                iU(boVar3.name);
                if (this.bPw != null && this.bPw.YU() != null) {
                    this.bPw.YU().im(boVar3.bQR);
                    return;
                }
                return;
            }
            return;
        }
        int size = this.bTo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                boVar = boVar2;
                z = false;
                break;
            }
            boVar2 = this.bTo.get(i2);
            if (boVar2 == null || boVar2.bQR != i) {
                i2++;
            } else {
                boVar = boVar2;
                z = true;
                break;
            }
        }
        if (!z) {
            if (TbadkCoreApplication.isLogin() && i == 6) {
                iU(TbadkCoreApplication.m9getInst().getResources().getString(w.l.attention_users_thread));
                return;
            }
            bo boVar4 = this.bTo.get(0);
            if (boVar4 != null) {
                ia(boVar4.bQR);
                iU(boVar4.name);
                if (this.bPw != null && this.bPw.YU() != null) {
                    this.bPw.YU().im(boVar4.bQR);
                }
            }
        } else if (boVar != null) {
            ia(boVar.bQR);
            iU(boVar.name);
            if (this.bPw != null && this.bPw.YU() != null) {
                this.bPw.YU().im(boVar.bQR);
            }
        }
    }

    private boolean ao(List<FrsTabInfo> list) {
        if (!x.r(this.bTo) && x.q(list) == x.q(this.bTo)) {
            int i = 0;
            while (i < list.size()) {
                i = (list.get(i) != null && this.bTo.get(i) == null) ? i + 1 : i + 1;
            }
            return false;
        }
        return true;
    }

    public void aaV() {
        if (this.bTn != null) {
            this.bTn.setVisibility(0);
        }
    }

    public void aaW() {
        if (this.bTn != null) {
            this.bTn.setVisibility(8);
        }
    }
}
