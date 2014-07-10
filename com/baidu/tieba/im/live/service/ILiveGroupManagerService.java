package com.baidu.tieba.im.live.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.tieba.im.live.service.IRemoteCallback;
/* loaded from: classes.dex */
public interface ILiveGroupManagerService extends IInterface {
    void closePublish(String str, boolean z);

    void connectAndPublish(String str, String str2, String str3, String str4, String str5, String str6);

    String getCurrentGroupId();

    int getCurrentStatus();

    String getCurrentUrl();

    int getDurationOfRecord();

    int getPositionOfRecord();

    int getRecordStatus();

    int getRecordTime();

    int getSignalStrength();

    void pausePlay(String str);

    void pausePublish(String str);

    void playOrRecord(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2);

    void registerCallback(IRemoteCallback iRemoteCallback);

    void requestStatusRebroadcast();

    void resumePlay(String str);

    void resumePublish(String str);

    void retryPlay();

    void seekPlayRecord(int i);

    void setPublisherPaused(boolean z);

    void startPlay(String str, String str2, int i);

    void startPublish(String str);

    void startRecordInPublish(String str);

    void stopAnyRunning(boolean z);

    void stopPlay(String str, boolean z);

    void stopPublish(String str);

    void stopRecordInPublish(String str);

    void unregisterCallback(IRemoteCallback iRemoteCallback);

    int whatIsRunning();

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements ILiveGroupManagerService {
        private static final String DESCRIPTOR = "com.baidu.tieba.im.live.service.ILiveGroupManagerService";
        static final int TRANSACTION_closePublish = 12;
        static final int TRANSACTION_connectAndPublish = 7;
        static final int TRANSACTION_getCurrentGroupId = 5;
        static final int TRANSACTION_getCurrentStatus = 3;
        static final int TRANSACTION_getCurrentUrl = 6;
        static final int TRANSACTION_getDurationOfRecord = 20;
        static final int TRANSACTION_getPositionOfRecord = 21;
        static final int TRANSACTION_getRecordStatus = 23;
        static final int TRANSACTION_getRecordTime = 28;
        static final int TRANSACTION_getSignalStrength = 27;
        static final int TRANSACTION_pausePlay = 17;
        static final int TRANSACTION_pausePublish = 8;
        static final int TRANSACTION_playOrRecord = 26;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_requestStatusRebroadcast = 4;
        static final int TRANSACTION_resumePlay = 18;
        static final int TRANSACTION_resumePublish = 9;
        static final int TRANSACTION_retryPlay = 22;
        static final int TRANSACTION_seekPlayRecord = 19;
        static final int TRANSACTION_setPublisherPaused = 29;
        static final int TRANSACTION_startPlay = 15;
        static final int TRANSACTION_startPublish = 13;
        static final int TRANSACTION_startRecordInPublish = 10;
        static final int TRANSACTION_stopAnyRunning = 25;
        static final int TRANSACTION_stopPlay = 16;
        static final int TRANSACTION_stopPublish = 14;
        static final int TRANSACTION_stopRecordInPublish = 11;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_whatIsRunning = 24;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILiveGroupManagerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILiveGroupManagerService)) {
                return (ILiveGroupManagerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentStatus = getCurrentStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentStatus);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestStatusRebroadcast();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String currentGroupId = getCurrentGroupId();
                    parcel2.writeNoException();
                    parcel2.writeString(currentGroupId);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String currentUrl = getCurrentUrl();
                    parcel2.writeNoException();
                    parcel2.writeString(currentUrl);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    connectAndPublish(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    pausePublish(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    resumePublish(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    startRecordInPublish(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopRecordInPublish(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    closePublish(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    startPublish(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopPublish(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    startPlay(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopPlay(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    pausePlay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    resumePlay(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekPlayRecord(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    int durationOfRecord = getDurationOfRecord();
                    parcel2.writeNoException();
                    parcel2.writeInt(durationOfRecord);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    int positionOfRecord = getPositionOfRecord();
                    parcel2.writeNoException();
                    parcel2.writeInt(positionOfRecord);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    retryPlay();
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getRecordStatus /* 23 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int recordStatus = getRecordStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(recordStatus);
                    return true;
                case TRANSACTION_whatIsRunning /* 24 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int whatIsRunning = whatIsRunning();
                    parcel2.writeNoException();
                    parcel2.writeInt(whatIsRunning);
                    return true;
                case TRANSACTION_stopAnyRunning /* 25 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopAnyRunning(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_playOrRecord /* 26 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    playOrRecord(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getSignalStrength /* 27 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int signalStrength = getSignalStrength();
                    parcel2.writeNoException();
                    parcel2.writeInt(signalStrength);
                    return true;
                case TRANSACTION_getRecordTime /* 28 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int recordTime = getRecordTime();
                    parcel2.writeNoException();
                    parcel2.writeInt(recordTime);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPublisherPaused(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes.dex */
        class Proxy implements ILiveGroupManagerService {
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

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void registerCallback(IRemoteCallback iRemoteCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteCallback != null ? iRemoteCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void unregisterCallback(IRemoteCallback iRemoteCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteCallback != null ? iRemoteCallback.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int getCurrentStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void requestStatusRebroadcast() {
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

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public String getCurrentGroupId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public String getCurrentUrl() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void connectAndPublish(String str, String str2, String str3, String str4, String str5, String str6) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void pausePublish(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void resumePublish(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void startRecordInPublish(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void stopRecordInPublish(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void closePublish(String str, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void startPublish(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void stopPublish(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void startPlay(String str, String str2, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void stopPlay(String str, boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void pausePlay(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void resumePlay(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void seekPlayRecord(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int getDurationOfRecord() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int getPositionOfRecord() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void retryPlay() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int getRecordStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRecordStatus, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int whatIsRunning() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_whatIsRunning, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void stopAnyRunning(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_stopAnyRunning, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void playOrRecord(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeString(str6);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_playOrRecord, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int getSignalStrength() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getSignalStrength, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public int getRecordTime() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getRecordTime, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.im.live.service.ILiveGroupManagerService
            public void setPublisherPaused(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
