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
/* loaded from: classes3.dex */
public class dy7 extends mx7<dv7, PbLoadPreReplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;
    public PbLoadPreReplyViewHolder h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ dy7 b;

        public a(dy7 dy7Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dy7Var;
            this.a = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.x(1);
                if (this.b.g != null) {
                    this.b.g.onClick(this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy7(f28 f28Var, BdUniqueId bdUniqueId) {
        super(f28Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f28Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f28) objArr2[0], (BdUniqueId) objArr2[1]);
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

    @Override // com.baidu.tieba.mx7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w(i, view2, viewGroup, (dv7) obj, (PbLoadPreReplyViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public PbLoadPreReplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06d6, viewGroup, false);
            inflate.findViewById(R.id.obfuscated_res_0x7f0923bc).setOnClickListener(new a(this, inflate));
            return new PbLoadPreReplyViewHolder(this.mContext, inflate);
        }
        return (PbLoadPreReplyViewHolder) invokeL.objValue;
    }

    public View w(int i, View view2, ViewGroup viewGroup, dv7 dv7Var, PbLoadPreReplyViewHolder pbLoadPreReplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dv7Var, pbLoadPreReplyViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, dv7Var, pbLoadPreReplyViewHolder);
            if (pbLoadPreReplyViewHolder != null && dv7Var != null) {
                this.h = pbLoadPreReplyViewHolder;
                pbLoadPreReplyViewHolder.c(dv7Var.a());
                pbLoadPreReplyViewHolder.a();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void x(int i) {
        PbLoadPreReplyViewHolder pbLoadPreReplyViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (pbLoadPreReplyViewHolder = this.h) == null) {
            return;
        }
        pbLoadPreReplyViewHolder.b(i);
    }
}
