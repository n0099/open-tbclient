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
import d.b.b.e.p.l;
import d.b.i0.c3.a0;
import d.b.i0.c3.b0;
import d.b.i0.p0.g2.a;
import d.b.i0.p0.g2.b;
import d.b.i0.p0.g2.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ServiceAreaView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f16589e;

    /* renamed from: f  reason: collision with root package name */
    public int f16590f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16591g;

    public ServiceAreaView(@NonNull Context context) {
        super(context);
        this.f16590f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public boolean a() {
        return this.f16591g;
    }

    public void b(int i) {
        b bVar = this.f16589e;
        if (bVar != null) {
            bVar.onChangeSkinType(i);
        }
    }

    public void setData(a0 a0Var, FrsViewData frsViewData) {
        b0 b0Var;
        if (this.f16591g) {
            if (a0Var == null) {
                a0Var = new a0();
                a0Var.f53316b = new ArrayList();
            }
            if (!ListUtils.isEmpty(a0Var.f53316b) && (b0Var = a0Var.f53316b.get(0)) != null && getResources().getString(R.string.hot_user_rank).equals(b0Var.f53319c) && getResources().getString(R.string.hot_user_rank).equals(b0Var.f53318b)) {
                a0Var.f53315a--;
                a0Var.f53316b.remove(0);
            }
            a0Var.f53315a++;
            b0 b0Var2 = new b0();
            b0Var2.f53319c = getResources().getString(R.string.hot_user_rank);
            b0Var2.f53318b = getResources().getString(R.string.hot_user_rank);
            a0Var.f53316b.add(0, b0Var2);
        }
        if (a0Var == null) {
            return;
        }
        int g2 = l.g(getContext(), R.dimen.M_H_X001);
        int g3 = l.g(getContext(), R.dimen.M_H_X001);
        int i = a0Var.f53315a;
        if (i >= 2) {
            this.f16589e = new MultiServiceViewController(getContext());
        } else if (i == 1) {
            this.f16589e = new c(getContext());
            g3 = l.g(getContext(), R.dimen.tbds12);
            g2 = l.g(getContext(), R.dimen.tbds5);
        }
        setPadding(0, g2, 0, g3);
        removeAllViews();
        addView(this.f16589e.getView(), -1, -2);
        this.f16589e.a(a0Var, frsViewData);
        b bVar = this.f16589e;
        if (bVar instanceof a) {
            ((a) bVar).b(this.f16590f);
        }
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHasHotRankList(boolean z) {
        this.f16591g = z;
    }

    public void setThemeFontColor(int i) {
        this.f16590f = i;
        b bVar = this.f16589e;
        if (bVar instanceof a) {
            ((a) bVar).b(i);
        }
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16590f = SkinManager.getColor(R.color.CAM_X0302);
    }

    public ServiceAreaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16590f = SkinManager.getColor(R.color.CAM_X0302);
    }
}
