package com.baidu.tbadk.plugins;

import android.content.Context;
import android.location.Address;
/* loaded from: classes.dex */
public interface BdLocationSdkPlugin {
    public static final String BAIDU_PROVIDER = "baidu_provider";
    public static final int LOC_ALL_OFF = 3;
    public static final int LOC_GPS_OFF = 1;
    public static final int LOC_NET_OFF = 2;
    public static final int LOC_OK = 0;
    public static final int LOC_OUT_TIME = 4;
    public static final int LOC_UNKONWN_ERROR = 5;

    /* loaded from: classes.dex */
    public interface LocationCallBack {
        void OnLocationGeted(int i, String str, Address address);
    }

    void destroy();

    Address getAddress(boolean z);

    Address getAddress(boolean z, LocationCallBack locationCallBack);

    Address getOfflineAddress(boolean z);

    Address getOfflineAddress(boolean z, LocationCallBack locationCallBack);

    void initial(Context context, String str);

    void initial(Context context, String str, boolean z);

    void removeLocation(LocationCallBack locationCallBack);

    void setBaiduOn(boolean z);

    void setTimeExpiration(long j);

    void setTimeOut(long j);
}
