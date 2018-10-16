package com.baidu.tieba.QuickPlayer;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener;
import java.util.List;
/* loaded from: classes5.dex */
public interface IQuickMediaPlayer extends IInterface {
    void forceUseSystemMediaPlayer(boolean z) throws RemoteException;

    int getBitRate() throws RemoteException;

    int getCachedPostion() throws RemoteException;

    int getCachedSize() throws RemoteException;

    int getCurrentPosition() throws RemoteException;

    int getDuration() throws RemoteException;

    String getId() throws RemoteException;

    List<String> getMediaIDs() throws RemoteException;

    int getVideoHeight() throws RemoteException;

    int getVideoWidth() throws RemoteException;

    boolean isExistInRemote() throws RemoteException;

    boolean isIjkPlayer() throws RemoteException;

    boolean isLooping() throws RemoteException;

    boolean isPlayerReuse() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void openVideo(Uri uri, Surface surface, String str, boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void release() throws RemoteException;

    void seekTo(int i) throws RemoteException;

    void setDebugParams(String str, String str2) throws RemoteException;

    void setListener(IQuickMediaPlayerListener iQuickMediaPlayerListener) throws RemoteException;

    void setLooping(boolean z) throws RemoteException;

    void setSurface(Surface surface) throws RemoteException;

    void setVolume(float f, float f2) throws RemoteException;

    void start() throws RemoteException;

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IQuickMediaPlayer {
        private static final String DESCRIPTOR = "com.baidu.tieba.QuickPlayer.IQuickMediaPlayer";
        static final int TRANSACTION_forceUseSystemMediaPlayer = 1;
        static final int TRANSACTION_getBitRate = 23;
        static final int TRANSACTION_getCachedPostion = 22;
        static final int TRANSACTION_getCachedSize = 24;
        static final int TRANSACTION_getCurrentPosition = 8;
        static final int TRANSACTION_getDuration = 7;
        static final int TRANSACTION_getId = 19;
        static final int TRANSACTION_getMediaIDs = 18;
        static final int TRANSACTION_getVideoHeight = 12;
        static final int TRANSACTION_getVideoWidth = 11;
        static final int TRANSACTION_isExistInRemote = 17;
        static final int TRANSACTION_isIjkPlayer = 20;
        static final int TRANSACTION_isLooping = 15;
        static final int TRANSACTION_isPlayerReuse = 25;
        static final int TRANSACTION_isPlaying = 10;
        static final int TRANSACTION_openVideo = 2;
        static final int TRANSACTION_pause = 6;
        static final int TRANSACTION_release = 4;
        static final int TRANSACTION_seekTo = 9;
        static final int TRANSACTION_setDebugParams = 21;
        static final int TRANSACTION_setListener = 16;
        static final int TRANSACTION_setLooping = 14;
        static final int TRANSACTION_setSurface = 3;
        static final int TRANSACTION_setVolume = 13;
        static final int TRANSACTION_start = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IQuickMediaPlayer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IQuickMediaPlayer)) {
                return (IQuickMediaPlayer) queryLocalInterface;
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
                    forceUseSystemMediaPlayer(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    Uri uri = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                    Surface surface = parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null;
                    openVideo(uri, surface, parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (surface != null) {
                        parcel2.writeInt(1);
                        surface.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    Surface surface2 = parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null;
                    setSurface(surface2);
                    parcel2.writeNoException();
                    if (surface2 != null) {
                        parcel2.writeInt(1);
                        surface2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    release();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    start();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int duration = getDuration();
                    parcel2.writeNoException();
                    parcel2.writeInt(duration);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentPosition = getCurrentPosition();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentPosition);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekTo(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isPlaying = isPlaying();
                    parcel2.writeNoException();
                    parcel2.writeInt(isPlaying ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int videoWidth = getVideoWidth();
                    parcel2.writeNoException();
                    parcel2.writeInt(videoWidth);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int videoHeight = getVideoHeight();
                    parcel2.writeNoException();
                    parcel2.writeInt(videoHeight);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    setVolume(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLooping(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isLooping = isLooping();
                    parcel2.writeNoException();
                    parcel2.writeInt(isLooping ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    setListener(IQuickMediaPlayerListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isExistInRemote = isExistInRemote();
                    parcel2.writeNoException();
                    parcel2.writeInt(isExistInRemote ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<String> mediaIDs = getMediaIDs();
                    parcel2.writeNoException();
                    parcel2.writeStringList(mediaIDs);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    String id = getId();
                    parcel2.writeNoException();
                    parcel2.writeString(id);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isIjkPlayer = isIjkPlayer();
                    parcel2.writeNoException();
                    parcel2.writeInt(isIjkPlayer ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDebugParams(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    int cachedPostion = getCachedPostion();
                    parcel2.writeNoException();
                    parcel2.writeInt(cachedPostion);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    int bitRate = getBitRate();
                    parcel2.writeNoException();
                    parcel2.writeInt(bitRate);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    int cachedSize = getCachedSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(cachedSize);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isPlayerReuse = isPlayerReuse();
                    parcel2.writeNoException();
                    parcel2.writeInt(isPlayerReuse ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes5.dex */
        private static class Proxy implements IQuickMediaPlayer {
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

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void forceUseSystemMediaPlayer(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void openVideo(Uri uri, Surface surface, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
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

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void setSurface(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        surface.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void start() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getCurrentPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void seekTo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getVideoWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getVideoHeight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void setVolume(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void setLooping(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public boolean isLooping() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void setListener(IQuickMediaPlayerListener iQuickMediaPlayerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iQuickMediaPlayerListener != null ? iQuickMediaPlayerListener.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public boolean isExistInRemote() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public List<String> getMediaIDs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public boolean isIjkPlayer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public void setDebugParams(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getCachedPostion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getBitRate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public int getCachedSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayer
            public boolean isPlayerReuse() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
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
