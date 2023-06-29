package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.compact.AlaLiveAttentionCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eq6 extends d87<AlaLiveAttentionCardView, r37> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq6() {
        super("ala_live_attention");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.d87, com.baidu.tieba.s87
    @NonNull
    public View a(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            AlaLiveAttentionCardView alaLiveAttentionCardView = new AlaLiveAttentionCardView(viewGroup.getContext());
            aa7.i(alaLiveAttentionCardView, Integer.valueOf(aa7.e() * 2));
            return alaLiveAttentionCardView;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s87
    /* renamed from: e */
    public void b(@NonNull AlaLiveAttentionCardView alaLiveAttentionCardView, @NonNull r37 r37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, alaLiveAttentionCardView, r37Var) == null) {
            Object obj = r37Var.a().a;
            if (obj instanceof uo6) {
                alaLiveAttentionCardView.setVisibility(0);
                alaLiveAttentionCardView.update((uo6) obj);
                return;
            }
            alaLiveAttentionCardView.setVisibility(8);
        }
    }
}
