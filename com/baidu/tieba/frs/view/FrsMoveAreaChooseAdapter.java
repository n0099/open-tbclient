package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.f0.n.c;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsMoveAreaChooseView f16225e;

    /* renamed from: f  reason: collision with root package name */
    public List<FrsTabInfo> f16226f;

    /* renamed from: g  reason: collision with root package name */
    public int f16227g;

    /* renamed from: h  reason: collision with root package name */
    public int f16228h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f16229i;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TBSpecificationBtn f16230a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsMoveAreaChooseAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16230a = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
        }
    }

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsMoveAreaChooseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16227g = -1;
        this.f16228h = -1;
        this.f16225e = frsMoveAreaChooseView;
        this.f16226f = d.a.q0.u0.a.h().g();
        this.f16229i = new SparseArray<>();
        if (ListUtils.isEmpty(this.f16226f)) {
            return;
        }
        for (int i4 = 0; i4 < this.f16226f.size(); i4++) {
            FrsTabInfo frsTabInfo = this.f16226f.get(i4);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == d.a.q0.u0.a.h().e() || frsTabInfo.tab_type.intValue() == 3)) {
                if (frsTabInfo.tab_id.intValue() == d.a.q0.u0.a.h().e()) {
                    this.f16227g = i4;
                }
                this.f16229i.append(i4, frsTabInfo);
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16227g : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16228h : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull a aVar, int i2) {
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) || ListUtils.isEmpty(this.f16226f) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.f16226f, i2)) == null) {
            return;
        }
        aVar.f16230a.setTag(Integer.valueOf(i2));
        aVar.f16230a.setText(frsTabInfo.tab_name);
        aVar.f16230a.setOnClickListener(this);
        g(aVar.f16230a, i2);
    }

    public final void g(TBSpecificationBtn tBSpecificationBtn, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tBSpecificationBtn, i2) == null) {
            if (i2 == this.f16228h) {
                c cVar = new c();
                cVar.o(R.color.CAM_X0304);
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (this.f16229i.get(i2) != null) {
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
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f16226f) : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false)) : (a) invokeLI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f16229i.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.f16225e;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.f16225e.getParent() == null) {
                    return;
                }
                if (intValue == this.f16227g) {
                    BdTopToast bdTopToast = new BdTopToast(this.f16225e.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip));
                    bdTopToast.j((ViewGroup) this.f16225e.getParent());
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.f16225e.getContext());
                bdTopToast2.i(false);
                bdTopToast2.h(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip));
                bdTopToast2.j((ViewGroup) this.f16225e.getParent());
                return;
            }
            this.f16228h = intValue;
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f16225e;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.onClick(view);
            }
            notifyDataSetChanged();
        }
    }
}
