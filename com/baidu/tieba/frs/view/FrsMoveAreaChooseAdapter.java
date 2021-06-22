package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.a.n0.r.f0.m.c;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public FrsMoveAreaChooseView f15992e;

    /* renamed from: g  reason: collision with root package name */
    public int f15994g;

    /* renamed from: h  reason: collision with root package name */
    public int f15995h = -1;

    /* renamed from: f  reason: collision with root package name */
    public List<FrsTabInfo> f15993f = d.a.o0.r0.a.h().g();

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f15996i = new SparseArray<>();

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TBSpecificationBtn f15997a;

        public a(FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter, View view) {
            super(view);
            this.f15997a = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.f15994g = -1;
        this.f15992e = frsMoveAreaChooseView;
        if (ListUtils.isEmpty(this.f15993f)) {
            return;
        }
        for (int i2 = 0; i2 < this.f15993f.size(); i2++) {
            FrsTabInfo frsTabInfo = this.f15993f.get(i2);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == d.a.o0.r0.a.h().e() || frsTabInfo.tab_type.intValue() == 3)) {
                if (frsTabInfo.tab_id.intValue() == d.a.o0.r0.a.h().e()) {
                    this.f15994g = i2;
                }
                this.f15996i.append(i2, frsTabInfo);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15993f);
    }

    public int m() {
        return this.f15994g;
    }

    public int n() {
        return this.f15995h;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NonNull a aVar, int i2) {
        FrsTabInfo frsTabInfo;
        if (ListUtils.isEmpty(this.f15993f) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.f15993f, i2)) == null) {
            return;
        }
        aVar.f15997a.setTag(Integer.valueOf(i2));
        aVar.f15997a.setText(frsTabInfo.tab_name);
        aVar.f15997a.setOnClickListener(this);
        p(aVar.f15997a, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f15996i.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.f15992e;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.f15992e.getParent() == null) {
                    return;
                }
                if (intValue == this.f15994g) {
                    BdTopToast bdTopToast = new BdTopToast(this.f15992e.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip));
                    bdTopToast.j((ViewGroup) this.f15992e.getParent());
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.f15992e.getContext());
                bdTopToast2.i(false);
                bdTopToast2.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip));
                bdTopToast2.j((ViewGroup) this.f15992e.getParent());
                return;
            }
            this.f15995h = intValue;
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f15992e;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    public final void p(TBSpecificationBtn tBSpecificationBtn, int i2) {
        if (i2 == this.f15995h) {
            c cVar = new c();
            cVar.o(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.k();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.f15996i.get(i2) != null) {
            c cVar2 = new c();
            cVar2.q(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar2);
            tBSpecificationBtn.k();
            tBSpecificationBtn.setUseDisableState(true);
        } else {
            c cVar3 = new c();
            cVar3.q(R.color.CAM_X0105);
            tBSpecificationBtn.setConfig(cVar3);
            tBSpecificationBtn.k();
            tBSpecificationBtn.setUseDisableState(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: q */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }
}
