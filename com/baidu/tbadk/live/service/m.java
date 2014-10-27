package com.baidu.tbadk.live.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class m implements Parcelable.Creator<LiveStatusParcelable> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: f */
    public LiveStatusParcelable createFromParcel(Parcel parcel) {
        return new LiveStatusParcelable(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: cX */
    public LiveStatusParcelable[] newArray(int i) {
        return new LiveStatusParcelable[i];
    }
}
