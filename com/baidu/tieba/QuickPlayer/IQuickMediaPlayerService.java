package com.baidu.tieba.QuickPlayer;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayer;
/* loaded from: classes11.dex */
public interface IQuickMediaPlayerService extends IInterface {
    IQuickMediaPlayer createPlayer() throws RemoteException;

    /* loaded from: classes11.dex */
    public static abstract class Stub extends Binder implements IQuickMediaPlayerService {
        private static final String DESCRIPTOR = "com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService";
        static final int TRANSACTION_createPlayer = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQuickMediaPlayerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IQuickMediaPlayerService)) {
                return (IQuickMediaPlayerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    IQuickMediaPlayer createPlayer = createPlayer();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createPlayer != null ? createPlayer.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes11.dex */
        private static class Proxy implements IQuickMediaPlayerService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService
            public IQuickMediaPlayer createPlayer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IQuickMediaPlayer.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
