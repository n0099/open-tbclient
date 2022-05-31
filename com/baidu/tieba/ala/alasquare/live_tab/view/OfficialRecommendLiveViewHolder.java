package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ro5;
/* loaded from: classes3.dex */
public class OfficialRecommendLiveViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ro5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialRecommendLiveViewHolder(ro5 ro5Var) {
        super(ro5Var.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ro5Var};
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
        this.a = ro5Var;
    }
}
