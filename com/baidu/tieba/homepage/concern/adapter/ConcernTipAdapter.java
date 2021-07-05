package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import d.a.c.e.p.l;
import d.a.c.k.e.a;
import d.a.s0.e1.c.f.b;
/* loaded from: classes5.dex */
public class ConcernTipAdapter extends a<b, ConcernTipViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static int m;
    public static int n;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f16462a;

        /* renamed from: b  reason: collision with root package name */
        public View f16463b;

        /* renamed from: c  reason: collision with root package name */
        public int f16464c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcernTipViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f16464c = 3;
            this.f16462a = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.f16463b = view.findViewById(R.id.concern_tip_top_line);
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f16464c == i2) {
                return;
            }
            SkinManager.setBackgroundColor(a(), R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f16462a, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f16463b, R.color.CAM_X0205);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernTipAdapter(Context context) {
        super(context, b.j);
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
        m = l.g(context, R.dimen.tbds102);
        n = l.g(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public ConcernTipViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
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
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, b bVar, ConcernTipViewHolder concernTipViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, concernTipViewHolder})) == null) {
            concernTipViewHolder.f16462a.setText(bVar.f58459f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.f16462a.getLayoutParams();
            if (bVar.f58460g) {
                layoutParams.height = n;
                concernTipViewHolder.f16463b.setVisibility(0);
            } else if (bVar.f58461h) {
                layoutParams.height = m;
            }
            concernTipViewHolder.f16462a.setLayoutParams(layoutParams);
            concernTipViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
            return concernTipViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
