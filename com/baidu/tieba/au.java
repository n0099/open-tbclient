package com.baidu.tieba;

import com.baidu.mapapi.MKGeneralListener;
/* loaded from: classes.dex */
class au implements MKGeneralListener {
    @Override // com.baidu.mapapi.MKGeneralListener
    public void onGetNetworkState(int i) {
        if (i == 2) {
            com.baidu.tieba.util.z.a(getClass().getName(), "onGetNetworkState", "ERROR_NETWORK_CONNECT");
        } else if (i == 3) {
            com.baidu.tieba.util.z.a(getClass().getName(), "onGetNetworkState", "ERROR_NETWORK_DATA");
        }
    }

    @Override // com.baidu.mapapi.MKGeneralListener
    public void onGetPermissionState(int i) {
        if (i == 300) {
            com.baidu.tieba.util.z.a(getClass().getName(), "onGetPermissionState", "bd_map key error");
        }
    }
}
