package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.s.g0.n.c;
import c.a.r0.d1.c1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes10.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsMoveAreaChooseView f44786e;

    /* renamed from: f  reason: collision with root package name */
    public List<FrsTabInfo> f44787f;

    /* renamed from: g  reason: collision with root package name */
    public int f44788g;

    /* renamed from: h  reason: collision with root package name */
    public int f44789h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f44790i;

    /* loaded from: classes10.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TBSpecificationBtn a;

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
            this.a = (TBSpecificationBtn) view.findViewById(f1.cell_frs_area_choose_name);
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
        this.f44788g = -1;
        this.f44789h = -1;
        this.f44786e = frsMoveAreaChooseView;
        this.f44787f = c.a.r0.d1.a.h().g();
        this.f44790i = new SparseArray<>();
        if (ListUtils.isEmpty(this.f44787f)) {
            return;
        }
        for (int i4 = 0; i4 < this.f44787f.size(); i4++) {
            FrsTabInfo frsTabInfo = this.f44787f.get(i4);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == c.a.r0.d1.a.h().e() || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 100)) {
                if (frsTabInfo.tab_id.intValue() == c.a.r0.d1.a.h().e()) {
                    this.f44788g = i4;
                }
                this.f44790i.append(i4, frsTabInfo);
            }
        }
    }

    public final void a(TBSpecificationBtn tBSpecificationBtn, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tBSpecificationBtn, i2) == null) {
            if (i2 == this.f44789h) {
                c cVar = new c();
                cVar.p(c1.CAM_X0304);
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.changeSkinType();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (this.f44790i.get(i2) != null) {
                c cVar2 = new c();
                cVar2.r(c1.CAM_X0105);
                tBSpecificationBtn.setConfig(cVar2);
                tBSpecificationBtn.changeSkinType();
                tBSpecificationBtn.setUseDisableState(true);
            } else {
                c cVar3 = new c();
                cVar3.r(c1.CAM_X0105);
                tBSpecificationBtn.setConfig(cVar3);
                tBSpecificationBtn.changeSkinType();
                tBSpecificationBtn.setUseDisableState(false);
            }
        }
    }

    public int getCurPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44788g : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f44787f) : invokeV.intValue;
    }

    public int getSelectPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44789h : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f44790i.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.f44786e;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.f44786e.getParent() == null) {
                    return;
                }
                if (intValue == this.f44788g) {
                    new BdTopToast(this.f44786e.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(i1.frs_move_area_move_cur_tip)).show((ViewGroup) this.f44786e.getParent());
                    return;
                } else {
                    new BdTopToast(this.f44786e.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(i1.frs_move_area_move_no_tip)).show((ViewGroup) this.f44786e.getParent());
                    return;
                }
            }
            this.f44789h = intValue;
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f44786e;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.onClick(view);
            }
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull a aVar, int i2) {
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, aVar, i2) == null) || ListUtils.isEmpty(this.f44787f) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.f44787f, i2)) == null) {
            return;
        }
        aVar.a.setTag(Integer.valueOf(i2));
        aVar.a.setText(frsTabInfo.tab_name);
        aVar.a.setOnClickListener(this);
        a(aVar.a, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(g1.cell_frs_area_choose_layout, viewGroup, false)) : (a) invokeLI.objValue;
    }
}
