package com.baidu.tbadk.mutiprocess.share;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ShareEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FROM_DUXIAOMAN = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int channel;
    public String extLiveInfo;
    public int from;
    public int status;
    public String tid;

    public ShareEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(1);
    }
}
