package com.baidu.tieba.frs.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.fa5;
import com.baidu.tieba.og7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsMoveAreaChooseView a;
    public List<FrsTabInfo> b;
    public int c;
    public int d;
    public SparseArray<FrsTabInfo> e;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TBSpecificationBtn a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsMoveAreaChooseAdapter, view2};
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
            this.a = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090676);
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
        this.c = -1;
        this.d = -1;
        this.a = frsMoveAreaChooseView;
        this.b = og7.h().g();
        this.e = new SparseArray<>();
        if (!ListUtils.isEmpty(this.b)) {
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                FrsTabInfo frsTabInfo = this.b.get(i3);
                if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == og7.h().e() || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 102 || frsTabInfo.tab_type.intValue() == 100 || TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e7).equals(frsTabInfo.tab_name) || TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e5).equals(frsTabInfo.tab_name))) {
                    if (frsTabInfo.tab_id.intValue() == og7.h().e()) {
                        this.c = i3;
                    }
                    this.e.append(i3, frsTabInfo);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, aVar, i) != null) || ListUtils.isEmpty(this.b) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.b, i)) == null) {
            return;
        }
        aVar.a.setTag(Integer.valueOf(i));
        aVar.a.setText(frsTabInfo.tab_name);
        aVar.a.setOnClickListener(this);
        o(aVar.a, i);
    }

    public final void o(TBSpecificationBtn tBSpecificationBtn, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tBSpecificationBtn, i) == null) {
            if (i == this.d) {
                fa5 fa5Var = new fa5();
                fa5Var.r(R.color.CAM_X0304);
                tBSpecificationBtn.setConfig(fa5Var);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (this.e.get(i) != null) {
                fa5 fa5Var2 = new fa5();
                fa5Var2.t(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(fa5Var2);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(true);
            } else {
                fa5 fa5Var3 = new fa5();
                fa5Var3.t(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(fa5Var3);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01f3, viewGroup, false));
        }
        return (a) invokeLI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || !(view2.getTag() instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) view2.getTag()).intValue();
        if (this.e.get(intValue) != null) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.a;
            if (frsMoveAreaChooseView != null && frsMoveAreaChooseView.getContext() != null && this.a.getParent() != null) {
                if (intValue == this.c) {
                    new BdTopToast(this.a.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0850)).show((ViewGroup) this.a.getParent());
                    return;
                } else {
                    new BdTopToast(this.a.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0851)).show((ViewGroup) this.a.getParent());
                    return;
                }
            }
            return;
        }
        this.d = intValue;
        FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.a;
        if (frsMoveAreaChooseView2 != null) {
            frsMoveAreaChooseView2.onClick(view2);
        }
        notifyDataSetChanged();
    }
}
