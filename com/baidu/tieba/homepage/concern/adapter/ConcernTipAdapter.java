package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.d.o.e.a;
import c.a.p0.q1.d.f.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ConcernTipAdapter extends a<b, ConcernTipViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int i;
    public static int j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f33207b;

        /* renamed from: c  reason: collision with root package name */
        public int f33208c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcernTipViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f33208c = 3;
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0906ae);
            this.f33207b = view.findViewById(R.id.obfuscated_res_0x7f0906ad);
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.f33208c == i) {
                return;
            }
            SkinManager.setBackgroundColor(b(), R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f33207b, R.color.CAM_X0205);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernTipAdapter(Context context) {
        super(context, b.f17196f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i = n.f(context, R.dimen.tbds102);
        j = n.f(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public ConcernTipViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = View.inflate(viewGroup.getContext(), R.layout.obfuscated_res_0x7f0d01fe, null);
            SkinManager.setBackgroundColor(inflate, R.color.CAM_X0205);
            ConcernTipViewHolder concernTipViewHolder = new ConcernTipViewHolder(inflate);
            ViewGroup.LayoutParams u = u(viewGroup);
            u.width = -1;
            u.height = -2;
            inflate.setLayoutParams(u);
            return concernTipViewHolder;
        }
        return (ConcernTipViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, b bVar, ConcernTipViewHolder concernTipViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, concernTipViewHolder})) == null) {
            concernTipViewHolder.a.setText(bVar.f17198b);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.a.getLayoutParams();
            if (bVar.f17199c) {
                layoutParams.height = j;
                concernTipViewHolder.f33207b.setVisibility(0);
            } else if (bVar.f17200d) {
                layoutParams.height = i;
            }
            concernTipViewHolder.a.setLayoutParams(layoutParams);
            concernTipViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            return concernTipViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
