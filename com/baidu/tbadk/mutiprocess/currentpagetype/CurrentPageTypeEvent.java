package com.baidu.tbadk.mutiprocess.currentpagetype;

import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CurrentPageTypeEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CurrentPageTypeHelper.PageType currentPageType;

    public CurrentPageTypeEvent(CurrentPageTypeHelper.PageType pageType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentPageType = pageType;
        setType(3);
    }
}
