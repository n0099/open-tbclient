package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.o0.r.l0.n.c;
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
/* loaded from: classes5.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsMoveAreaChooseView a;

    /* renamed from: b  reason: collision with root package name */
    public List<FrsTabInfo> f32948b;

    /* renamed from: c  reason: collision with root package name */
    public int f32949c;

    /* renamed from: d  reason: collision with root package name */
    public int f32950d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f32951e;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f0905b1);
        }
    }

    public FrsMoveAreaChooseAdapter(FrsMoveAreaChooseView frsMoveAreaChooseView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsMoveAreaChooseView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32949c = -1;
        this.f32950d = -1;
        this.a = frsMoveAreaChooseView;
        this.f32948b = c.a.p0.f1.a.h().g();
        this.f32951e = new SparseArray<>();
        if (ListUtils.isEmpty(this.f32948b)) {
            return;
        }
        for (int i3 = 0; i3 < this.f32948b.size(); i3++) {
            FrsTabInfo frsTabInfo = this.f32948b.get(i3);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == c.a.p0.f1.a.h().e() || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 100)) {
                if (frsTabInfo.tab_id.intValue() == c.a.p0.f1.a.h().e()) {
                    this.f32949c = i3;
                }
                this.f32951e.append(i3, frsTabInfo);
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32949c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32950d : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i) == null) || ListUtils.isEmpty(this.f32948b) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.f32948b, i)) == null) {
            return;
        }
        aVar.a.setTag(Integer.valueOf(i));
        aVar.a.setText(frsTabInfo.tab_name);
        aVar.a.setOnClickListener(this);
        g(aVar.a, i);
    }

    public final void g(TBSpecificationBtn tBSpecificationBtn, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tBSpecificationBtn, i) == null) {
            if (i == this.f32950d) {
                c cVar = new c();
                cVar.p(R.color.CAM_X0304);
                tBSpecificationBtn.setConfig(cVar);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (this.f32951e.get(i) != null) {
                c cVar2 = new c();
                cVar2.r(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(cVar2);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(true);
            } else {
                c cVar3 = new c();
                cVar3.r(R.color.CAM_X0105);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.f32948b) : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) ? new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01d2, viewGroup, false)) : (a) invokeLI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f32951e.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.a;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.a.getParent() == null) {
                    return;
                }
                if (intValue == this.f32949c) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0706));
                    bdTopToast.j((ViewGroup) this.a.getParent());
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.i(false);
                bdTopToast2.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0707));
                bdTopToast2.j((ViewGroup) this.a.getParent());
                return;
            }
            this.f32950d = intValue;
            FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.a;
            if (frsMoveAreaChooseView2 != null) {
                frsMoveAreaChooseView2.onClick(view);
            }
            notifyDataSetChanged();
        }
    }
}
