package com.baidu.tbadk.live.service;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
class c implements a {
    private IBinder mRemote;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(d dVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void b(d dVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getCurrentStatus() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void su() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public String getCurrentGroupId() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public String getCurrentUrl() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str5);
            obtain.writeString(str6);
            this.mRemote.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void pausePublish(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void resumePublish(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void startRecordInPublish(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void stopRecordInPublish(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void o(String str, boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void dC(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void stopPublish(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(14, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void c(String str, String str2, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            this.mRemote.transact(15, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void p(String str, boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void dD(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void dE(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            this.mRemote.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void seekPlayRecord(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeInt(i);
            this.mRemote.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getDurationOfRecord() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(20, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getPositionOfRecord() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(21, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void retryPlay() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(22, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getRecordStatus() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(23, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int whatIsRunning() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(24, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void ax(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(25, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str5);
            obtain.writeString(str6);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeInt(z2 ? 1 : 0);
            this.mRemote.transact(26, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getSignalStrength() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(27, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public int getRecordTime() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            this.mRemote.transact(28, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.baidu.tbadk.live.service.a
    public void setPublisherPaused(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.baidu.tbadk.live.service.ILiveGroupManagerService");
            obtain.writeInt(z ? 1 : 0);
            this.mRemote.transact(29, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
