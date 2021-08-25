package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.s.f0.n.c;
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
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsMoveAreaChooseView f51571e;

    /* renamed from: f  reason: collision with root package name */
    public List<FrsTabInfo> f51572f;

    /* renamed from: g  reason: collision with root package name */
    public int f51573g;

    /* renamed from: h  reason: collision with root package name */
    public int f51574h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f51575i;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TBSpecificationBtn f51576a;

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
            this.f51576a = (TBSpecificationBtn) view.findViewById(R.id.cell_frs_area_choose_name);
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
        this.f51573g = -1;
        this.f51574h = -1;
        this.f51571e = frsMoveAreaChooseView;
        this.f51572f = c.a.q0.v0.a.h().g();
        this.f51575i = new SparseArray<>();
        if (ListUtils.isEmpty(this.f51572f)) {
            return;
        }
        for (int i4 = 0; i4 < this.f51572f.size(); i4++) {
            FrsTabInfo frsTabInfo = this.f51572f.get(i4);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == c.a.q0.v0.a.h().e() || frsTabInfo.tab_type.intValue() == 3)) {
                if (frsTabInfo.tab_id.intValue() == c.a.q0.v0.a.h().e()) {
                    this.f51573g = i4;
                }
                this.f51575i.append(i4, frsTabInfo);
            }
        }
    }

    public final void a(TBSpecificationBtn tBSpecificationBtn, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tBSpecificationBtn, i2) == null) {
            if (i2 == this.f51574h) {
                c cVar = new c();
                cVar.o(R.color.CAM_X0304);
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.changeSkinType();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (this.f51575i.get(i2) != null) {
                c cVar2 = new c();
                cVar2.q(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(cVar2);
                tBSpecificationBtn.changeSkinType();
                tBSpecificationBtn.setUseDisableState(true);
            } else {
                c cVar3 = new c();
                cVar3.q(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(cVar3);
                tBSpecificationBtn.changeSkinType();
                tBSpecificationBtn.setUseDisableState(false);
            }
        }
    }

    public int getCurPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51573g : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f51572f) : invokeV.intValue;
    }

    public int getSelectPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51574h : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f51575i.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.f51571e;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.f51571e.getParent() == null) {
                    return;
                }
                if (intValue == this.f51573g) {
                    new BdTopToast(this.f51571e.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_cur_tip)).show((ViewGroup) this.f51571e.getParent());
                    return;
                } else {
                    new BdTopToast(this.f51571e.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.frs_move_area_move_no_tip)).show((ViewGroup) this.f51571e.getParent());
                    return;
                }
            }
            this.f51574h = intValue;
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.f51571e;
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
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, aVar, i2) == null) || ListUtils.isEmpty(this.f51572f) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.f51572f, i2)) == null) {
            return;
        }
        aVar.f51576a.setTag(Integer.valueOf(i2));
        aVar.f51576a.setText(frsTabInfo.tab_name);
        aVar.f51576a.setOnClickListener(this);
        a(aVar.f51576a, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_frs_area_choose_layout, viewGroup, false)) : (a) invokeLI.objValue;
    }
}
