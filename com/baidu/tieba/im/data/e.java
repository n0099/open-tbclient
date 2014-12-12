package com.baidu.tieba.im.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class e implements Parcelable.Creator<RandChatRoomData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: g */
    public RandChatRoomData createFromParcel(Parcel parcel) {
        return new RandChatRoomData(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: fD */
    public RandChatRoomData[] newArray(int i) {
        return new RandChatRoomData[i];
    }
}
