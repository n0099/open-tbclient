package com.baidu.tieba.forum.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.v55;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.z67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsMoveAreaChooseAdapter extends RecyclerView.Adapter<a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsMoveAreaChooseView a;
    public List<z67> b;
    public int c;
    public int d;

    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TBSpecificationBtn a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.a = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f09069e);
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
        this.b = new ArrayList();
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

    @Nullable
    public z67 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<z67> list = this.b;
            if (list != null) {
                for (z67 z67Var : list) {
                    if (z67Var.b() == this.c) {
                        return z67Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (z67) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        z67 z67Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, aVar, i) != null) || ListUtils.isEmpty(this.b) || (z67Var = (z67) ListUtils.getItem(this.b, i)) == null) {
            return;
        }
        aVar.a.setTag(z67Var);
        aVar.a.setText(z67Var.c());
        aVar.a.setOnClickListener(this);
        o(aVar.a, z67Var);
    }

    public final void o(TBSpecificationBtn tBSpecificationBtn, z67 z67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tBSpecificationBtn, z67Var) == null) {
            if (z67Var.b() == this.c) {
                v55 v55Var = new v55();
                v55Var.r(R.color.CAM_X0304);
                tBSpecificationBtn.setConfig(v55Var);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(false);
            } else if (!z67Var.a()) {
                v55 v55Var2 = new v55();
                v55Var2.t(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(v55Var2);
                tBSpecificationBtn.k();
                tBSpecificationBtn.setUseDisableState(true);
            } else {
                v55 v55Var3 = new v55();
                v55Var3.t(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(v55Var3);
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
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01fa, viewGroup, false));
        }
        return (a) invokeLI.objValue;
    }

    public void q(List<z67> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, list, i) == null) {
            this.c = -1;
            this.b.clear();
            if (list != null && list.size() > 0) {
                this.b.addAll(list);
            }
            this.d = i;
            notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || !(view2.getTag() instanceof z67)) {
            return;
        }
        z67 z67Var = (z67) view2.getTag();
        if (!z67Var.a()) {
            FrsMoveAreaChooseView frsMoveAreaChooseView = this.a;
            if (frsMoveAreaChooseView != null && frsMoveAreaChooseView.getContext() != null && (this.a.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                Context context = this.a.getContext();
                if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && (window.getDecorView() instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) window.getDecorView();
                }
                if (z67Var.b() == this.d) {
                    new BdTopToast(this.a.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0860)).show(viewGroup);
                    return;
                } else {
                    new BdTopToast(this.a.getContext()).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0861)).show(viewGroup);
                    return;
                }
            }
            return;
        }
        this.c = z67Var.b();
        FrsMoveAreaChooseView frsMoveAreaChooseView2 = this.a;
        if (frsMoveAreaChooseView2 != null) {
            frsMoveAreaChooseView2.onClick(view2);
        }
        notifyDataSetChanged();
    }
}
