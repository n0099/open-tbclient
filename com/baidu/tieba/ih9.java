package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.pb.pb.main.PbLoadPreReplyViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ih9 extends qg9<de9, PbLoadPreReplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public PbLoadPreReplyViewHolder h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ ih9 b;

        public a(ih9 ih9Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ih9Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ih9Var;
            this.a = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.z(1);
                if (this.b.g != null) {
                    this.b.g.onClick(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih9(vl9 vl9Var, BdUniqueId bdUniqueId) {
        super(vl9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((vl9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void z(int i) {
        PbLoadPreReplyViewHolder pbLoadPreReplyViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (pbLoadPreReplyViewHolder = this.h) != null) {
            pbLoadPreReplyViewHolder.b(i);
        }
    }

    @Override // com.baidu.tieba.qg9, com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        y(i, view2, viewGroup, (de9) obj, (PbLoadPreReplyViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: x */
    public PbLoadPreReplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07a1, viewGroup, false);
            inflate.findViewById(R.id.obfuscated_res_0x7f092725).setOnClickListener(new a(this, inflate));
            return new PbLoadPreReplyViewHolder(this.mContext, inflate);
        }
        return (PbLoadPreReplyViewHolder) invokeL.objValue;
    }

    public View y(int i, View view2, ViewGroup viewGroup, de9 de9Var, PbLoadPreReplyViewHolder pbLoadPreReplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, de9Var, pbLoadPreReplyViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) de9Var, (de9) pbLoadPreReplyViewHolder);
            if (pbLoadPreReplyViewHolder != null && de9Var != null) {
                this.h = pbLoadPreReplyViewHolder;
                pbLoadPreReplyViewHolder.c(de9Var.a());
                pbLoadPreReplyViewHolder.a();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
