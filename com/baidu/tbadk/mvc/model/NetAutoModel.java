package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c65;
import com.repackage.d65;
/* loaded from: classes3.dex */
public abstract class NetAutoModel<T extends c65, D extends d65, ActivityType> extends NetModel<T, D, ActivityType> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetAutoModel(TbPageContext<ActivityType> tbPageContext, T t) {
        super(tbPageContext, t, NetModel.NetModelType.TYPE_AUTO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (c65) objArr2[1], (NetModel.NetModelType) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
