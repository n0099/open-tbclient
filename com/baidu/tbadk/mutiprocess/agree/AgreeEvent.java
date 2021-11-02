package com.baidu.tbadk.mutiprocess.agree;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AgreeEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_POST = "isInPost";
    public static final String IS_THREAD = "isInThread";
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeData agreeData;
    public String agreeExtra;

    public AgreeEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(1);
    }
}
