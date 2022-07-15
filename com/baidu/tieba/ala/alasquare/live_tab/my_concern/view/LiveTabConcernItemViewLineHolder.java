package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gq5;
/* loaded from: classes3.dex */
public class LiveTabConcernItemViewLineHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gq5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveTabConcernItemViewLineHolder(gq5 gq5Var) {
        super(gq5Var.h());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gq5Var};
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
        this.a = gq5Var;
    }
}
