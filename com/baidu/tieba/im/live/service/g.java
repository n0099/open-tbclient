package com.baidu.tieba.im.live.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class g implements Parcelable.Creator<LiveStatusParcelable> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LiveStatusParcelable createFromParcel(Parcel parcel) {
        return new LiveStatusParcelable(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LiveStatusParcelable[] newArray(int i) {
        return new LiveStatusParcelable[i];
    }
}
