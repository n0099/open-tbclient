package com.baidu.tbadk.live.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public abstract class b extends Binder implements a {
    public b() {
        attachInterface(this, "com.baidu.tbadk.live.service.ILiveGroupManagerService");
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
        if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
            return (a) queryLocalInterface;
        }
        return new c(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                a(e.b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                b(e.b(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int currentStatus = getCurrentStatus();
                parcel2.writeNoException();
                parcel2.writeInt(currentStatus);
                return true;
            case 4:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                sw();
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                String currentGroupId = getCurrentGroupId();
                parcel2.writeNoException();
                parcel2.writeString(currentGroupId);
                return true;
            case 6:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                String currentUrl = getCurrentUrl();
                parcel2.writeNoException();
                parcel2.writeString(currentUrl);
                return true;
            case 7:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                pausePublish(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                resumePublish(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                startRecordInPublish(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                stopRecordInPublish(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                o(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                dC(parcel.readString());
                parcel2.writeNoException();
                return true;
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                stopPublish(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                c(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                p(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                dD(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                dE(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                seekPlayRecord(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int durationOfRecord = getDurationOfRecord();
                parcel2.writeNoException();
                parcel2.writeInt(durationOfRecord);
                return true;
            case 21:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int positionOfRecord = getPositionOfRecord();
                parcel2.writeNoException();
                parcel2.writeInt(positionOfRecord);
                return true;
            case 22:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                retryPlay();
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int recordStatus = getRecordStatus();
                parcel2.writeNoException();
                parcel2.writeInt(recordStatus);
                return true;
            case DealIntentService.CLASS_TYPE_GIFT_INFO /* 24 */:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int whatIsRunning = whatIsRunning();
                parcel2.writeNoException();
                parcel2.writeInt(whatIsRunning);
                return true;
            case DealIntentService.CLASS_TYPE_NATIVE_BUY_TBEAN /* 25 */:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                ax(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 27:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int signalStrength = getSignalStrength();
                parcel2.writeNoException();
                parcel2.writeInt(signalStrength);
                return true;
            case 28:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                int recordTime = getRecordTime();
                parcel2.writeNoException();
                parcel2.writeInt(recordTime);
                return true;
            case 29:
                parcel.enforceInterface("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                setPublisherPaused(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.baidu.tbadk.live.service.ILiveGroupManagerService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
