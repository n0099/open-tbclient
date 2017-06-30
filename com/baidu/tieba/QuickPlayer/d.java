package com.baidu.tieba.QuickPlayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.b;
/* loaded from: classes.dex */
public interface d extends IInterface {
    b JI() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService");
        }

        public static d d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0055a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService");
                    b JI = JI();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(JI != null ? JI.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.baidu.tieba.QuickPlayer.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0055a implements d {
            private IBinder mRemote;

            C0055a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.tieba.QuickPlayer.d
            public b JI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return b.a.b(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
