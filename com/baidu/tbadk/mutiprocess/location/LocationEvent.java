package com.baidu.tbadk.mutiprocess.location;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LocationEvent extends SerializableEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_GET_LOC_FROM_SOCKET = 1;
    public static final int TYPE_SELECT_LOC = 2;
    public static final int TYPE_SEND_SOCKET_MSG = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int errorCode;
    public String errorMsg;
    public int eventType;
    public boolean isShowLocation;
    public String lat;
    public String lng;
    public String locAddr;
    public String locName;
    public String locSn;
    public LocationData locationData;
    public boolean needRefresh;

    public LocationEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
