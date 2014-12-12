package com.baidu.tbadk.live.service;

import android.os.IInterface;
/* loaded from: classes.dex */
public interface d extends IInterface {
    void a(LiveStatusParcelable liveStatusParcelable);

    void onLiveErrorEvent(String str);

    void onLivePlayProgressUpdate(String str, int i, int i2);

    void onLivePlayWarning(int i);

    void onLiveRecordTimeUpdate(int i);
}
