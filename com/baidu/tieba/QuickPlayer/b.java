package com.baidu.tieba.QuickPlayer;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.tieba.QuickPlayer.c;
/* loaded from: classes.dex */
public interface b extends IInterface {
    boolean IR() throws RemoteException;

    void a(Uri uri, Surface surface) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void ch(boolean z) throws RemoteException;

    int getCurrentPosition() throws RemoteException;

    int getDuration() throws RemoteException;

    int getVideoHeight() throws RemoteException;

    int getVideoWidth() throws RemoteException;

    boolean isLooping() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void pause() throws RemoteException;

    void release() throws RemoteException;

    void seekTo(int i) throws RemoteException;

    void setLooping(boolean z) throws RemoteException;

    void setVolume(float f, float f2) throws RemoteException;

    void start() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
        }

        public static b b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0049a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    ch(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    Uri uri = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                    Surface surface = parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null;
                    a(uri, surface);
                    parcel2.writeNoException();
                    if (surface != null) {
                        parcel2.writeInt(1);
                        surface.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    release();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    start();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    int duration = getDuration();
                    parcel2.writeNoException();
                    parcel2.writeInt(duration);
                    return true;
                case 7:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    int currentPosition = getCurrentPosition();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentPosition);
                    return true;
                case 8:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    seekTo(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    boolean isPlaying = isPlaying();
                    parcel2.writeNoException();
                    parcel2.writeInt(isPlaying ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    int videoWidth = getVideoWidth();
                    parcel2.writeNoException();
                    parcel2.writeInt(videoWidth);
                    return true;
                case 11:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    int videoHeight = getVideoHeight();
                    parcel2.writeNoException();
                    parcel2.writeInt(videoHeight);
                    return true;
                case 12:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    setVolume(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    setLooping(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    boolean isLooping = isLooping();
                    parcel2.writeNoException();
                    parcel2.writeInt(isLooping ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    a(c.a.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    boolean IR = IR();
                    parcel2.writeNoException();
                    parcel2.writeInt(IR ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.baidu.tieba.QuickPlayer.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0049a implements b {
            private IBinder mRemote;

            C0049a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void ch(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void a(Uri uri, Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        surface.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void start() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public int getDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public int getCurrentPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void seekTo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public int getVideoWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public int getVideoHeight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void setVolume(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void setLooping(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public boolean isLooping() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public void a(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.b
            public boolean IR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.tieba.QuickPlayer.IQuickMediaPlayer");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
