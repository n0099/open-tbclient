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
import d.b.h0.r.f0.m.c;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public FrsMoveAreaChooseView f16394e;

    /* renamed from: g  reason: collision with root package name */
    public int f16396g;

    /* renamed from: h  reason: collision with root package name */
    public int f16397h = -1;

    /* renamed from: f  reason: collision with root package name */
    public List<FrsTabInfo> f16395f = d.b.i0.q0.a.h().g();
    public SparseArray<FrsTabInfo> i = new SparseArray<>();

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TBSpecificationBtn f16398a;

        public a(FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter, View view) {
            super(view);
            this.f16398a = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        this.f16396g = -1;
        this.f16394e = frsMoveAreaChooseView;
        if (ListUtils.isEmpty(this.f16395f)) {
            return;
        }
        for (int i = 0; i < this.f16395f.size(); i++) {
            FrsTabInfo frsTabInfo = this.f16395f.get(i);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == d.b.i0.q0.a.h().e() || frsTabInfo.tab_type.intValue() == 3)) {
                if (frsTabInfo.tab_id.intValue() == d.b.i0.q0.a.h().e()) {
                    this.f16396g = i;
                }
                this.i.append(i, frsTabInfo);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f16395f);
    }

    public int m() {
        return this.f16396g;
    }

    public int n() {
        return this.f16397h;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        if (ListUtils.isEmpty(this.f16395f) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.f16395f, i)) == null) {
            return;
        }
        aVar.f16398a.setTag(Integer.valueOf(i));
        aVar.f16398a.setText(frsTabInfo.tab_name);
        aVar.f16398a.setOnClickListener(this);
        p(aVar.f16398a, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.i.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.f16394e;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.f16394e.getParent() == null) {
                    return;
                }
                if (intValue == this.f16396g) {
                    BdTopToast bdTopToast = new BdTopToast(this.f16394e.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip));
                    bdTopToast.j((ViewGroup) this.f16394e.getParent());
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.f16394e.getContext());
                bdTopToast2.i(false);
                bdTopToast2.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip));
                bdTopToast2.j((ViewGroup) this.f16394e.getParent());
                return;
            }
            this.f16397h = intValue;
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f16394e;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    public final void p(TBSpecificationBtn tBSpecificationBtn, int i) {
        if (i == this.f16397h) {
            c cVar = new c();
            cVar.o(R.color.CAM_X0304);
            tBSpecificationBtn.setConfig(cVar);
            tBSpecificationBtn.k();
            tBSpecificationBtn.setUseDisableState(false);
        } else if (this.i.get(i) != null) {
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
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false));
    }
}
