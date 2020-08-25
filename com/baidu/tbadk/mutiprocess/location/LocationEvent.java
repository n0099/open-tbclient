package com.baidu.tbadk.mutiprocess.location;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes2.dex */
public class LocationEvent extends SerializableEvent {
    public static final int TYPE_GET_LOC_FROM_SOCKET = 1;
    public static final int TYPE_SELECT_LOC = 2;
    public static final int TYPE_SEND_SOCKET_MSG = 0;
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
}
