package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.c.e.p.l;
import d.b.i0.d3.a0;
import d.b.i0.d3.b0;
import d.b.i0.q0.g2.a;
import d.b.i0.q0.g2.b;
import d.b.i0.q0.g2.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ServiceAreaView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f16250e;

    /* renamed from: f  reason: collision with root package name */
    public int f16251f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16252g;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.f16251f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public boolean a() {
        return this.f16252g;
    }

    public void b(int i) {
        b bVar = this.f16250e;
        if (bVar != null) {
            bVar.onChangeSkinType(i);
        }
    }

    public void setData(a0 a0Var, FrsViewData frsViewData) {
        b0 b0Var;
        if (this.f16252g) {
            if (a0Var == null) {
                a0Var = new a0();
                a0Var.f54758b = new ArrayList();
            }
            if (!ListUtils.isEmpty(a0Var.f54758b) && (b0Var = a0Var.f54758b.get(0)) != null && getResources().getString(R.string.hot_user_rank).equals(b0Var.f54761c) && getResources().getString(R.string.hot_user_rank).equals(b0Var.f54760b)) {
                a0Var.f54757a--;
                a0Var.f54758b.remove(0);
            }
            a0Var.f54757a++;
            b0 b0Var2 = new b0();
            b0Var2.f54761c = getResources().getString(R.string.hot_user_rank);
            b0Var2.f54760b = getResources().getString(R.string.hot_user_rank);
            a0Var.f54758b.add(0, b0Var2);
        }
        if (a0Var == null) {
            return;
        }
        int g2 = l.g(getContext(), R.dimen.M_H_X001);
        int g3 = l.g(getContext(), R.dimen.M_H_X001);
        int i = a0Var.f54757a;
        if (i >= 2) {
            this.f16250e = new MultiServiceViewController(getContext());
        } else if (i == 1) {
            this.f16250e = new c(getContext());
            g3 = l.g(getContext(), R.dimen.tbds12);
            g2 = l.g(getContext(), R.dimen.tbds5);
        }
        setPadding(0, g2, 0, g3);
        removeAllViews();
        addView(this.f16250e.getView(), -1, -2);
        this.f16250e.a(a0Var, frsViewData);
        b bVar = this.f16250e;
        if (bVar instanceof a) {
            ((a) bVar).b(this.f16251f);
        }
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHasHotRankList(boolean z) {
        this.f16252g = z;
    }

    public void setThemeFontColor(int i) {
        this.f16251f = i;
        b bVar = this.f16250e;
        if (bVar instanceof a) {
            ((a) bVar).b(i);
        }
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16251f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16251f = SkinManager.getColor(R.color.CAM_X0302);
    }
}
