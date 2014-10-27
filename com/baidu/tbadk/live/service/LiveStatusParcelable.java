package com.baidu.tbadk.live.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class LiveStatusParcelable implements Parcelable {
    public static final Parcelable.Creator<LiveStatusParcelable> CREATOR = new m();
    public String errorString;
    public String groupId;
    public int status;
    public String url;

    public LiveStatusParcelable() {
    }

    public LiveStatusParcelable(Parcel parcel) {
        this.groupId = parcel.readString();
        this.status = parcel.readInt();
        this.url = parcel.readString();
        this.errorString = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeInt(this.status);
        parcel.writeString(this.url);
        parcel.writeString(this.errorString);
    }
}
