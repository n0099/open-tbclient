package com.baidu.tieba.ala.livecard.holder;

import android.view.View;
import com.baidu.card.AutoLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nt5;
/* loaded from: classes3.dex */
public class FrsPageAlaVideoHolder extends AutoLiveViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nt5 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPageAlaVideoHolder(nt5 nt5Var) {
        super(nt5Var.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nt5Var};
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
        this.b = nt5Var;
        this.a = nt5Var.P();
    }
}
