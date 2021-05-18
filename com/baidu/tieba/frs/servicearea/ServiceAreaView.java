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
import d.a.c.e.p.l;
import d.a.k0.d3.a0;
import d.a.k0.d3.b0;
import d.a.k0.q0.g2.a;
import d.a.k0.q0.g2.b;
import d.a.k0.q0.g2.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ServiceAreaView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f15788e;

    /* renamed from: f  reason: collision with root package name */
    public int f15789f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15790g;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.f15789f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public boolean a() {
        return this.f15790g;
    }

    public void b(int i2) {
        b bVar = this.f15788e;
        if (bVar != null) {
            bVar.onChangeSkinType(i2);
        }
    }

    public void setData(a0 a0Var, FrsViewData frsViewData) {
        b0 b0Var;
        if (this.f15790g) {
            if (a0Var == null) {
                a0Var = new a0();
                a0Var.f53722b = new ArrayList();
            }
            if (!ListUtils.isEmpty(a0Var.f53722b) && (b0Var = a0Var.f53722b.get(0)) != null && getResources().getString(R.string.hot_user_rank).equals(b0Var.f53725c) && getResources().getString(R.string.hot_user_rank).equals(b0Var.f53724b)) {
                a0Var.f53721a--;
                a0Var.f53722b.remove(0);
            }
            a0Var.f53721a++;
            b0 b0Var2 = new b0();
            b0Var2.f53725c = getResources().getString(R.string.hot_user_rank);
            b0Var2.f53724b = getResources().getString(R.string.hot_user_rank);
            a0Var.f53722b.add(0, b0Var2);
        }
        if (a0Var == null) {
            return;
        }
        int g2 = l.g(getContext(), R.dimen.M_H_X001);
        int g3 = l.g(getContext(), R.dimen.M_H_X001);
        int i2 = a0Var.f53721a;
        if (i2 >= 2) {
            this.f15788e = new MultiServiceViewController(getContext());
        } else if (i2 == 1) {
            this.f15788e = new c(getContext());
            g3 = l.g(getContext(), R.dimen.tbds12);
            g2 = l.g(getContext(), R.dimen.tbds5);
        }
        setPadding(0, g2, 0, g3);
        removeAllViews();
        addView(this.f15788e.getView(), -1, -2);
        this.f15788e.a(a0Var, frsViewData);
        b bVar = this.f15788e;
        if (bVar instanceof a) {
            ((a) bVar).b(this.f15789f);
        }
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHasHotRankList(boolean z) {
        this.f15790g = z;
    }

    public void setThemeFontColor(int i2) {
        this.f15789f = i2;
        b bVar = this.f15788e;
        if (bVar instanceof a) {
            ((a) bVar).b(i2);
        }
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15789f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15789f = SkinManager.getColor(R.color.CAM_X0302);
    }
}
