package com.baidu.tbadk.live.service;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
class f implements d {
    private IBinder mRemote;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.baidu.tbadk.live.service.d
    public void a(LiveStatusParcelable liveStatusParcelable) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.IRemoteCallback");
            if (liveStatusParcelable != null) {
                obtain.writeInt(1);
                liveStatusParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.d
    public void onLiveErrorEvent(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.IRemoteCallback");
            obtain.writeString(str);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.d
    public void onLivePlayProgressUpdate(String str, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.IRemoteCallback");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.d
    public void onLiveRecordTimeUpdate(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.IRemoteCallback");
            obtain.writeInt(i);
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.d
    public void onLivePlayWarning(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.IRemoteCallback");
            obtain.writeInt(i);
            this.mRemote.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
