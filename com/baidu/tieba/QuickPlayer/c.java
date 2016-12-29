package com.baidu.tieba.QuickPlayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface c extends IInterface {
    void IF() throws RemoteException;

    void IG() throws RemoteException;

    void N(int i, int i2) throws RemoteException;

    void O(int i, int i2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
        }

        public static c c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0051a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    IF();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    IG();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    N(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    O(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.baidu.tieba.QuickPlayer.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0051a implements c {
            private IBinder mRemote;

            C0051a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.tieba.QuickPlayer.c
            public void IF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.c
            public void IG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.c
            public void N(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.c
            public void O(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
