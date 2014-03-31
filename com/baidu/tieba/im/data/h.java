package com.baidu.tieba.im.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class h implements Parcelable.Creator<RandChatRoomData> {
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RandChatRoomData createFromParcel(Parcel parcel) {
        return new RandChatRoomData(parcel, (byte) 0);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ RandChatRoomData[] newArray(int i) {
        return new RandChatRoomData[i];
    }
}
