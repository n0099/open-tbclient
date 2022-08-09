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
import com.repackage.ke6;
import com.repackage.qv4;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes3.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsMoveAreaChooseView a;
    public List<FrsTabInfo> b;
    public int c;
    public int d;
    public SparseArray<FrsTabInfo> e;

    /* loaded from: classes3.dex */
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
            this.a = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f0905aa);
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
        this.b = ke6.h().g();
        this.e = new SparseArray<>();
        if (ListUtils.isEmpty(this.b)) {
            return;
        }
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            FrsTabInfo frsTabInfo = this.b.get(i3);
            if (frsTabInfo != null && (frsTabInfo.is_general_tab.intValue() == 0 || frsTabInfo.tab_id.intValue() == ke6.h().e() || frsTabInfo.tab_type.intValue() == 3 || frsTabInfo.tab_type.intValue() == 102 || frsTabInfo.tab_type.intValue() == 100)) {
                if (frsTabInfo.tab_id.intValue() == ke6.h().e()) {
                    this.c = i3;
                }
                this.e.append(i3, frsTabInfo);
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        FrsTabInfo frsTabInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i) == null) || ListUtils.isEmpty(this.b) || (frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.b, i)) == null) {
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
            if (i == this.d) {
                qv4 qv4Var = new qv4();
                qv4Var.p(R.color.CAM_X0304);
                tBSpecificationBtn.setConfig(qv4Var);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (this.e.get(i) != null) {
                qv4 qv4Var2 = new qv4();
                qv4Var2.r(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(qv4Var2);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(true);
            } else {
                qv4 qv4Var3 = new qv4();
                qv4Var3.r(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(qv4Var3);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ListUtils.getCount(this.b) : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) ? new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01c7, viewGroup, false)) : (a) invokeLI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && (view2.getTag() instanceof Integer)) {
            int intValue = ((Integer) view2.getTag()).intValue();
            if (this.e.get(intValue) != null) {
                FrsMoveAreaChooseView frsMoveAreaChooseView = this.a;
                if (frsMoveAreaChooseView == null || frsMoveAreaChooseView.getContext() == null || this.a.getParent() == null) {
                    return;
                }
                if (intValue == this.c) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.h(false);
                    bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0725));
                    bdTopToast.i((ViewGroup) this.a.getParent());
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0726));
                bdTopToast2.i((ViewGroup) this.a.getParent());
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
}
