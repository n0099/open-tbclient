package com.baidu.tbadk.mutiprocess.mission;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MissionEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MESSAGE_ACTIVITY = "onActivity";
    public static final String MESSAGE_CREATE = "onCreate";
    public static final String MESSAGE_DESTROY = "onDestroy";
    public static final String MESSAGE_PAUSE = "onPause";
    public static final String MESSAGE_RESUME = "onResume";
    public static final String MESSAGE_START = "onStart";
    public static final String MESSAGE_STOP = "onStop";
    public static final String MESSAGE_TOUCH = "onTouch";
    public transient /* synthetic */ FieldHolder $fh;
    public String actionType;
    public int pageId;
    public int pageType;
    public long tid;

    public MissionEvent() {
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
