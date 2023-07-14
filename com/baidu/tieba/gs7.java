package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class gs7 extends ln<mba, FrsLikeRecommendHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThemeColorInfo a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mba a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ int c;
        public final /* synthetic */ gs7 d;

        public a(gs7 gs7Var, mba mbaVar, ViewGroup viewGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs7Var, mbaVar, viewGroup, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gs7Var;
            this.a = mbaVar;
            this.b = viewGroup;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.d.getOnAdapterItemClickListener() != null) {
                this.d.getOnAdapterItemClickListener().b(view2, this.a, mba.e, this.b, this.c, view2.getId());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gs7(@NonNull Context context) {
        super(context, mba.e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: s */
    public FrsLikeRecommendHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new FrsLikeRecommendHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d037d, viewGroup, false), this.a);
        }
        return (FrsLikeRecommendHolder) invokeL.objValue;
    }

    public void u(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, themeColorInfo) == null) {
            this.a = themeColorInfo;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mba mbaVar, FrsLikeRecommendHolder frsLikeRecommendHolder) {
        t(i, view2, viewGroup, mbaVar, frsLikeRecommendHolder);
        return view2;
    }

    public View t(int i, View view2, ViewGroup viewGroup, mba mbaVar, FrsLikeRecommendHolder frsLikeRecommendHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mbaVar, frsLikeRecommendHolder})) == null) {
            if (mbaVar != null && frsLikeRecommendHolder != null) {
                frsLikeRecommendHolder.b(mbaVar);
                frsLikeRecommendHolder.d(new a(this, mbaVar, viewGroup, i));
                frsLikeRecommendHolder.c();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
