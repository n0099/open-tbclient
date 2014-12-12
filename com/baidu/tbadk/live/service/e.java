package com.baidu.tbadk.live.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class e extends Binder implements d {
    public e() {
        attachInterface(this, "com.baidu.tbadk.live.service.IRemoteCallback");
    }

    public static d c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.tbadk.live.service.IRemoteCallback");
        if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
            return (d) queryLocalInterface;
        }
        return new f(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        LiveStatusParcelable liveStatusParcelable;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.baidu.tbadk.live.service.IRemoteCallback");
                if (parcel.readInt() != 0) {
                    liveStatusParcelable = LiveStatusParcelable.CREATOR.createFromParcel(parcel);
                } else {
                    liveStatusParcelable = null;
                }
                a(liveStatusParcelable);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.baidu.tbadk.live.service.IRemoteCallback");
                onLiveErrorEvent(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.baidu.tbadk.live.service.IRemoteCallback");
                onLivePlayProgressUpdate(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.baidu.tbadk.live.service.IRemoteCallback");
                onLiveRecordTimeUpdate(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.baidu.tbadk.live.service.IRemoteCallback");
                onLivePlayWarning(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.baidu.tbadk.live.service.IRemoteCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
