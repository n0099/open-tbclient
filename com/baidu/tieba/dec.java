package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.adc;
import com.baidu.tieba.sdc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.NetRequestStatusInfo;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class dec extends cec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger A;
    public AtomicInteger B;
    public AtomicInteger C;
    public Object D;
    public zcc E;
    public Executor F;
    public boolean G;
    public sdc.e H;
    public int c;
    public String d;
    public Handler e;
    public sdc f;
    public WeakReference<ncc> g;
    public WeakReference<kcc> h;
    public WeakReference<ucc> i;
    public WeakReference<tcc> j;
    public WeakReference<qcc> k;
    public WeakReference<occ> l;
    public WeakReference<rcc> m;
    public WeakReference<mcc> n;
    public WeakReference<icc> o;
    public WeakReference<hcc> p;
    public WeakReference<adc.c> q;
    public WeakReference<pcc> r;
    public WeakReference<scc> s;
    public WeakReference<xcc> t;
    public WeakReference<lcc> u;
    public WeakReference<wcc> v;
    public AtomicInteger w;
    public AtomicInteger x;
    public AtomicInteger y;
    public AtomicInteger z;

    /* loaded from: classes5.dex */
    public class b implements sdc.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dec a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Message a;
            public final /* synthetic */ b b;

            public a(b bVar, Message message) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, message};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                hcc hccVar;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hccVar = (hcc) this.b.a.p.get()) == null) {
                    return;
                }
                Message message = this.a;
                if (message.what == 69) {
                    hccVar.onSEIAudioOriginalData(this.b.a.a, (byte[]) message.obj, message.arg1);
                }
                Message message2 = this.a;
                if (message2.what == 68) {
                    hccVar.onSEIVideoOriginalData(this.b.a.a, (byte[]) message2.obj, message2.arg1);
                }
                Message message3 = this.a;
                if (message3.what == 67) {
                    hccVar.onSEIAudioExtraInfoV0(this.b.a.a, (ArrayList) message3.obj);
                }
                Message message4 = this.a;
                if (message4.what == 63) {
                    hccVar.onSEIVideoExtraInfo(this.b.a.a, message4.arg1, (ArrayList) message4.obj);
                }
                Message message5 = this.a;
                if (message5.what == 64) {
                    hccVar.onSEIMixVideoExtraInfo(this.b.a.a, message5.arg1, (ArrayList) message5.obj);
                }
                Message message6 = this.a;
                if (message6.what == 66) {
                    hccVar.onSEIAlphaChannelInfo(this.b.a.a, message6.arg1, (ArrayList) message6.obj);
                }
                Message message7 = this.a;
                if (message7.what == 65) {
                    hccVar.onDSEMixAudioExtraInfoV1(this.b.a.a, (ArrayList) message7.obj);
                }
            }
        }

        public b(dec decVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = decVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:107:0x02b6 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x027d A[ADDED_TO_REGION] */
        @Override // com.baidu.tieba.sdc.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Message message) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                c cVar = new c(this.a);
                Object obj = message.obj;
                if (obj instanceof String) {
                    cVar.d = (String) obj;
                }
                int i = message.what;
                cVar.a = i;
                int i2 = 0;
                if (i != 5009) {
                    if (i != 5010) {
                        if (i != 5017) {
                            if (i != 5019) {
                                if (i != 5030) {
                                    if (i != 5040) {
                                        if (i != 5102) {
                                            if (i != 7000) {
                                                switch (i) {
                                                    case 63:
                                                    case 64:
                                                    case 65:
                                                    case 66:
                                                    case 67:
                                                    case 68:
                                                    case 69:
                                                        adc.c cVar2 = (adc.c) this.a.q.get();
                                                        if (cVar2 != null) {
                                                            if (message.what == 67) {
                                                                ArrayList arrayList = (ArrayList) message.obj;
                                                                ArrayList<MixAudioExtraInfo> arrayList2 = new ArrayList<>();
                                                                while (i2 < arrayList.size()) {
                                                                    arrayList2.add(new MixAudioExtraInfo(((Long) arrayList.get(i2)).toString(), -1));
                                                                    i2++;
                                                                }
                                                                cVar2.a(this.a.a, arrayList2);
                                                            }
                                                            if (message.what == 65) {
                                                                cVar2.a(this.a.a, (ArrayList) message.obj);
                                                            }
                                                        }
                                                        if (this.a.F == null) {
                                                            return;
                                                        }
                                                        try {
                                                            this.a.F.execute(new a(this, message));
                                                            return;
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            return;
                                                        }
                                                    default:
                                                        switch (i) {
                                                            case 5000:
                                                                cVar.c = message.arg2;
                                                                this.a.q0(message.arg1, cVar);
                                                                break;
                                                            case 5001:
                                                                cVar.b = message.arg1;
                                                                break;
                                                            case 5002:
                                                                cVar.b = message.arg1;
                                                                this.a.w.set(message.arg1);
                                                                break;
                                                            case 5003:
                                                                if (this.a.w.get() > 0) {
                                                                    this.a.B.set(message.arg1);
                                                                    cVar.b = message.arg1;
                                                                    break;
                                                                }
                                                                break;
                                                            case 5004:
                                                                if (this.a.w.get() > 0) {
                                                                    this.a.x.set(message.arg1);
                                                                    cVar.b = message.arg1;
                                                                    break;
                                                                }
                                                                break;
                                                            case 5005:
                                                                cVar.b = message.arg1;
                                                                this.a.y.set(message.arg1);
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 5013:
                                                                        cVar.b = message.arg1;
                                                                        cVar.c = message.arg2;
                                                                        cVar.f = message.obj;
                                                                        break;
                                                                    case 5014:
                                                                        cVar.f = message.obj;
                                                                        break;
                                                                    case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                                                                        if (this.a.z.get() == message.arg1 && this.a.A.get() == message.arg2) {
                                                                            z = false;
                                                                            break;
                                                                        } else {
                                                                            cVar.b = message.arg1;
                                                                            cVar.c = message.arg2;
                                                                            this.a.z.set(message.arg1);
                                                                            this.a.A.set(message.arg2);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5203 */:
                                                                                break;
                                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY /* 5204 */:
                                                                                cVar.b = message.arg1;
                                                                                cVar.c = message.arg2;
                                                                                cVar.e = System.currentTimeMillis();
                                                                                break;
                                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY /* 5205 */:
                                                                                cVar.b = message.arg1;
                                                                                cVar.c = message.arg2;
                                                                                cVar.f = message.obj;
                                                                                cVar.e = System.currentTimeMillis();
                                                                                TLog.g(this, "first frame again show, going to transmit to mainloop");
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 6000:
                                                                                    case 6001:
                                                                                    case 6002:
                                                                                    case AuthCode.StatusCode.PERMISSION_NOT_EXIST /* 6004 */:
                                                                                        cVar.b = message.arg1;
                                                                                        cVar.c = message.arg2;
                                                                                        break;
                                                                                    case AuthCode.StatusCode.CERT_FINGERPRINT_ERROR /* 6003 */:
                                                                                        cVar.b = message.arg1;
                                                                                        cVar.c = message.arg2;
                                                                                        break;
                                                                                }
                                                                                i2 = 1;
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                        if (this.a.e != null && i2 != 0) {
                                                            synchronized (this) {
                                                                if (this.a.e != null) {
                                                                    if (z) {
                                                                        this.a.e.sendMessageAtFrontOfQueue(Message.obtain(this.a.e, 1, cVar));
                                                                    } else {
                                                                        this.a.e.sendMessage(Message.obtain(this.a.e, 1, cVar));
                                                                    }
                                                                }
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                }
                                            }
                                            cVar.b = System.currentTimeMillis();
                                        } else {
                                            cVar.b = message.arg1;
                                            cVar.c = message.arg2;
                                            cVar.f = message.obj;
                                            cVar.e = System.currentTimeMillis();
                                            TLog.g(this, "first frame show, going to transmit to mainloop");
                                        }
                                        z = true;
                                        i2 = 1;
                                        if (this.a.e != null) {
                                            return;
                                        }
                                        return;
                                    }
                                    cVar.b = message.arg1;
                                } else {
                                    cVar.b = message.arg1;
                                    cVar.c = message.arg2;
                                    cVar.d = (String) message.obj;
                                }
                            } else {
                                cVar.b = message.arg1;
                                cVar.f = message.obj;
                            }
                        } else {
                            synchronized (this) {
                                if (this.a.f != null) {
                                    this.a.f.O0();
                                }
                            }
                            cVar.b = this.a.B.get();
                            cVar.c = this.a.w.get();
                            this.a.B.set(0);
                            this.a.x.set(0);
                        }
                    } else {
                        cVar.b = message.arg1;
                        cVar.c = message.arg2;
                        cVar.f = message.obj;
                    }
                } else {
                    Object obj2 = message.obj;
                    if (obj2 instanceof String) {
                        cVar.b = message.arg1;
                        cVar.d = (String) obj2;
                    }
                }
                z = false;
                i2 = 1;
                if (this.a.e != null) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dec a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                if (message.what == 1) {
                    c cVar = (c) message.obj;
                    int i = cVar.a;
                    if (i == 1) {
                        TLog.g(this, String.format(Locale.getDefault(), "player state stopped(%d)", Integer.valueOf(this.a.c)));
                        this.a.C.set(1);
                        tcc tccVar = (tcc) this.a.j.get();
                        if (tccVar != null) {
                            tccVar.onPlayerStateUpdate(this.a.a, 1, 0);
                        }
                    } else if (i == 5030) {
                        wcc wccVar = (wcc) this.a.v.get();
                        if (wccVar != null) {
                            wccVar.a(this.a.a, (int) cVar.b, cVar.d, (int) cVar.c);
                        } else {
                            TLog.c(this, "OnPlayerUpdatePcdnUrlResultListener is null");
                        }
                    } else if (i == 5040) {
                        TLog.g(this, String.format(Locale.getDefault(), "player play duration:%d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                        ncc nccVar = (ncc) this.a.g.get();
                        if (nccVar != null) {
                            nccVar.onPlayerInfo(this.a.a, 4, cVar.b);
                        }
                    } else if (i == 5102) {
                        TLog.l(this, String.format(Locale.getDefault(), "player first frame show(%d)", Integer.valueOf(((Long) cVar.f).intValue())));
                        mcc mccVar = (mcc) this.a.n.get();
                        if (mccVar != null) {
                            mccVar.onPlayerFirstVideoFrameShow(this.a.a, (int) cVar.b, (int) cVar.c, ((Long) cVar.f).intValue());
                        } else {
                            TLog.c(this, String.format(Locale.getDefault(), "player first frame show : listener is null ", new Object[0]));
                        }
                        lcc lccVar = (lcc) this.a.u.get();
                        if (lccVar != null) {
                            lccVar.a(103, cVar.e, 0L, 0L, null, null);
                        }
                    } else if (i == 7000) {
                        lcc lccVar2 = (lcc) this.a.u.get();
                        TLog.g(this, "on demuxer read header end");
                        if (lccVar2 != null) {
                            lccVar2.a(102, cVar.b, 0L, 0L, null, null);
                        }
                    } else if (i == 5009) {
                        ucc uccVar = (ucc) this.a.i.get();
                        if (uccVar != null) {
                            uccVar.onPlayerStatistics(this.a.a, (int) cVar.b, cVar.d);
                        }
                    } else if (i != 5010) {
                        switch (i) {
                            case 4:
                                TLog.g(this, String.format(Locale.getDefault(), "player state ready(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(4);
                                tcc tccVar2 = (tcc) this.a.j.get();
                                if (tccVar2 != null) {
                                    tccVar2.onPlayerStateUpdate(this.a.a, 4, 0);
                                    break;
                                }
                                break;
                            case 5:
                                TLog.g(this, String.format(Locale.getDefault(), "player state loading(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(5);
                                tcc tccVar3 = (tcc) this.a.j.get();
                                if (tccVar3 != null) {
                                    tccVar3.onPlayerStateUpdate(this.a.a, 5, (int) cVar.c);
                                    break;
                                }
                                break;
                            case 6:
                                TLog.g(this, String.format(Locale.getDefault(), "player state playing(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(6);
                                tcc tccVar4 = (tcc) this.a.j.get();
                                if (tccVar4 != null) {
                                    tccVar4.onPlayerStateUpdate(this.a.a, 6, 0);
                                    break;
                                }
                                break;
                            case 7:
                                TLog.g(this, String.format(Locale.getDefault(), "player state paused(%d)", Integer.valueOf(this.a.c)));
                                this.a.C.set(7);
                                tcc tccVar5 = (tcc) this.a.j.get();
                                if (tccVar5 != null) {
                                    tccVar5.onPlayerStateUpdate(this.a.a, 7, 0);
                                    break;
                                }
                                break;
                            case 8:
                                TLog.g(this, String.format(Locale.getDefault(), "player play end(%d)", Integer.valueOf(this.a.c)));
                                qcc qccVar = (qcc) this.a.k.get();
                                if (qccVar != null) {
                                    qccVar.onPlayerPlayCompletion(this.a.a);
                                }
                                this.a.C.set(8);
                                tcc tccVar6 = (tcc) this.a.j.get();
                                if (tccVar6 != null) {
                                    tccVar6.onPlayerStateUpdate(this.a.a, 8, 0);
                                    break;
                                }
                                break;
                            case 9:
                                TLog.g(this, String.format(Locale.getDefault(), "player state invalid(%d)", Integer.valueOf(this.a.c)));
                                tcc tccVar7 = (tcc) this.a.j.get();
                                if (tccVar7 != null) {
                                    tccVar7.onPlayerStateUpdate(this.a.a, 9, 0);
                                    break;
                                }
                                break;
                            default:
                                switch (i) {
                                    case 5001:
                                        TLog.a(this, String.format(Locale.getDefault(), "player loading (%d)", Long.valueOf(cVar.b)));
                                        occ occVar = (occ) this.a.l.get();
                                        if (occVar != null) {
                                            occVar.a(this.a.a, (int) cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5002:
                                        TLog.g(this, String.format(Locale.getDefault(), "player resource duration:%d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                        ncc nccVar2 = (ncc) this.a.g.get();
                                        if (nccVar2 != null) {
                                            nccVar2.onPlayerInfo(this.a.a, 3, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5003:
                                        rcc rccVar = (rcc) this.a.m.get();
                                        if (rccVar != null) {
                                            rccVar.a(this.a.a, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5004:
                                        TLog.g(this, String.format(Locale.getDefault(), "player cache (%d)", Long.valueOf(cVar.b)));
                                        icc iccVar = (icc) this.a.o.get();
                                        if (iccVar != null) {
                                            iccVar.onPlayerCachePositionUpdate(this.a.a, cVar.b);
                                            break;
                                        }
                                        break;
                                    case 5005:
                                        TLog.g(this, String.format(Locale.getDefault(), "player resource total size: (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                        ncc nccVar3 = (ncc) this.a.g.get();
                                        if (nccVar3 != null) {
                                            nccVar3.onPlayerInfo(this.a.a, 2, cVar.b);
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 5013:
                                                TLog.g(this, String.format(Locale.getDefault(), "player download speed(%d)", Long.valueOf(cVar.b)));
                                                ncc nccVar4 = (ncc) this.a.g.get();
                                                if (nccVar4 != null) {
                                                    nccVar4.onPlayerInfo(this.a.a, 0, cVar.b);
                                                    break;
                                                }
                                                break;
                                            case 5014:
                                                TLog.g(this, String.format(Locale.getDefault(), "player caton times: %d  (%d)", Long.valueOf(cVar.b), Integer.valueOf(this.a.c)));
                                                ncc nccVar5 = (ncc) this.a.g.get();
                                                if (nccVar5 != null) {
                                                    nccVar5.onPlayerInfo(this.a.a, 1, cVar.b);
                                                    break;
                                                }
                                                break;
                                            case SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY /* 5015 */:
                                                TLog.g(this, String.format(Locale.getDefault(), "player resolution  w: %d  h: %d (%d)", Long.valueOf(cVar.b), Long.valueOf(cVar.c), Integer.valueOf(this.a.c)));
                                                ncc nccVar6 = (ncc) this.a.g.get();
                                                if (nccVar6 != null) {
                                                    nccVar6.onPlayerVideoSizeUpdate(this.a.a, (int) cVar.b, (int) cVar.c);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case SpeedStatsStampTable.HOME_VIEW_DISPATCH_DRAW_END_STAMP_KEY /* 5017 */:
                                                        TLog.g(this, String.format(Locale.getDefault(), "player one loop end(%d)", Integer.valueOf(this.a.c)));
                                                        qcc qccVar2 = (qcc) this.a.k.get();
                                                        if (qccVar2 != null) {
                                                            qccVar2.onPlayerPlayCompletionOneLoop(this.a.a);
                                                            break;
                                                        }
                                                        break;
                                                    case 5018:
                                                        icc iccVar2 = (icc) this.a.o.get();
                                                        if (iccVar2 != null) {
                                                            iccVar2.onPlayerCacheWriteToDiskCompleted(this.a.a, cVar.d);
                                                            break;
                                                        }
                                                        break;
                                                    case 5019:
                                                        pcc pccVar = (pcc) this.a.r.get();
                                                        if (pccVar != null) {
                                                            NetRequestStatusInfo netRequestStatusInfo = (NetRequestStatusInfo) cVar.f;
                                                            pccVar.a(this.a.a, (int) cVar.b, netRequestStatusInfo);
                                                            TLog.g(this, String.format(Locale.getDefault(), "player serverIp : %s", netRequestStatusInfo.b));
                                                            break;
                                                        } else {
                                                            TLog.c(this, "OnPlayerNetRequestStatusListener is null");
                                                            break;
                                                        }
                                                    default:
                                                        switch (i) {
                                                            case SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY /* 5200 */:
                                                                Log.i("transvod", "play egl setup fail");
                                                                TLog.c(this, String.format(Locale.getDefault(), "egl setup failed", new Object[0]));
                                                                kcc kccVar = (kcc) this.a.h.get();
                                                                if (kccVar != null) {
                                                                    dec decVar = this.a;
                                                                    kccVar.onPlayerError(decVar.a, decVar.d, SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY, 0);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5201 */:
                                                                xcc xccVar = (xcc) this.a.t.get();
                                                                if (xccVar != null) {
                                                                    xccVar.a(true);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY /* 5202 */:
                                                                xcc xccVar2 = (xcc) this.a.t.get();
                                                                if (xccVar2 != null) {
                                                                    xccVar2.a(false);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY /* 5203 */:
                                                                lcc lccVar3 = (lcc) this.a.u.get();
                                                                TLog.g(this, "onSurfaceStatus create");
                                                                if (lccVar3 != null) {
                                                                    lccVar3.a(100, cVar.b, 0L, 0L, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY /* 5204 */:
                                                                lcc lccVar4 = (lcc) this.a.u.get();
                                                                TLog.g(this, "onSurfaceStatus changed");
                                                                if (lccVar4 != null) {
                                                                    lccVar4.a(101, cVar.b, cVar.c, cVar.e, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            case SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY /* 5205 */:
                                                                TLog.l(this, String.format(Locale.getDefault(), "player first frame again show(%d)", Integer.valueOf(((Long) cVar.f).intValue())));
                                                                lcc lccVar5 = (lcc) this.a.u.get();
                                                                if (lccVar5 != null) {
                                                                    TLog.g(this, String.format(Locale.getDefault(), "OnPlayerExtraInfoListener:(%d)", 104));
                                                                    lccVar5.a(104, cVar.b, cVar.c, cVar.e, null, null);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 6000:
                                                                        scc sccVar = (scc) this.a.s.get();
                                                                        if (sccVar != null) {
                                                                            sccVar.onPlayerReceiveToRenderDelay(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 6001:
                                                                        Log.i("hello", "rendering frameRate " + ((int) cVar.b));
                                                                        scc sccVar2 = (scc) this.a.s.get();
                                                                        if (sccVar2 != null) {
                                                                            sccVar2.onPlayerRenderFramerate(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 6002:
                                                                        scc sccVar3 = (scc) this.a.s.get();
                                                                        if (sccVar3 != null) {
                                                                            sccVar3.onPlayerDecodeType(this.a.a, (int) cVar.b);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.CERT_FINGERPRINT_ERROR /* 6003 */:
                                                                        scc sccVar4 = (scc) this.a.s.get();
                                                                        if (sccVar4 != null) {
                                                                            TLog.g(this, String.format(Locale.getDefault(), "decoder output size %d * %d", Integer.valueOf((int) cVar.b), Integer.valueOf((int) cVar.c)));
                                                                            sccVar4.onPlayerDecodeOuputSize(this.a.a, (int) cVar.b, (int) cVar.c);
                                                                            break;
                                                                        } else {
                                                                            TLog.g(this, "OnPlayerQualityMonitorListener is null");
                                                                            break;
                                                                        }
                                                                    case AuthCode.StatusCode.PERMISSION_NOT_EXIST /* 6004 */:
                                                                        scc sccVar5 = (scc) this.a.s.get();
                                                                        if (sccVar5 != null) {
                                                                            sccVar5.onPlayerDecodeBitrate(this.a.a, (int) cVar.b, (int) cVar.c);
                                                                            Log.i("hello", "videoBitrate " + ((int) cVar.b) + " audioBitrate " + ((int) cVar.c));
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED /* 6005 */:
                                                                        scc sccVar6 = (scc) this.a.s.get();
                                                                        if (sccVar6 != null) {
                                                                            sccVar6.onPlayerVideoStalls(this.a.a, ((int) cVar.b) == 1, (int) cVar.c);
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case AuthCode.StatusCode.PERMISSION_EXPIRED /* 6006 */:
                                                                        scc sccVar7 = (scc) this.a.s.get();
                                                                        if (sccVar7 != null) {
                                                                            sccVar7.onPlayerAudioStalls(this.a.a, ((int) cVar.b) == 1, (int) cVar.c);
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    } else {
                        Log.i("transvod", "player error code " + cVar.b);
                        TLog.c(this, String.format(Locale.getDefault(), "player error code : %d", Long.valueOf(cVar.b)));
                        if (this.a.G) {
                            TLog.c(this, "stop by self");
                            this.a.G();
                        }
                        kcc kccVar2 = (kcc) this.a.h.get();
                        if (kccVar2 != null) {
                            kccVar2.onPlayerError(this.a.a, (String) cVar.f, (int) cVar.b, (int) cVar.c);
                        }
                    }
                    dec decVar2 = this.a;
                    decVar2.b = decVar2.C.get() == 6;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dec decVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = decVar;
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;
        public String d;
        public long e;
        public Object f;
        public final /* synthetic */ dec g;

        public c(dec decVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = decVar;
            this.a = 0;
            this.b = 0L;
            this.c = 0L;
            this.d = null;
            this.e = 0L;
            this.f = null;
        }
    }

    public dec(Context context, zcc zccVar, adc adcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zccVar, adcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new WeakReference<>(null);
        this.h = new WeakReference<>(null);
        this.i = new WeakReference<>(null);
        this.j = new WeakReference<>(null);
        this.k = new WeakReference<>(null);
        this.l = new WeakReference<>(null);
        this.m = new WeakReference<>(null);
        this.n = new WeakReference<>(null);
        this.o = new WeakReference<>(null);
        this.p = new WeakReference<>(null);
        this.q = new WeakReference<>(null);
        this.r = new WeakReference<>(null);
        this.s = new WeakReference<>(null);
        this.t = new WeakReference<>(null);
        this.u = new WeakReference<>(null);
        this.v = new WeakReference<>(null);
        this.w = new AtomicInteger(0);
        this.x = new AtomicInteger(0);
        this.y = new AtomicInteger(0);
        this.z = new AtomicInteger(0);
        this.A = new AtomicInteger(0);
        this.B = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = false;
        this.H = new b(this);
        long currentTimeMillis = System.currentTimeMillis();
        this.a = adcVar;
        this.E = zccVar;
        m0(context.getApplicationContext(), zccVar);
        TLog.l(this, "[transvod] create VodPlayer cost: " + (System.currentTimeMillis() - currentTimeMillis) + " sdkversion: " + j() + " isSubProcess:" + zccVar.m);
    }

    @Override // com.baidu.tieba.cec
    public void A(ncc nccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nccVar) == null) {
            this.g = new WeakReference<>(nccVar);
        }
    }

    public void A0(occ occVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, occVar) == null) {
            this.l = new WeakReference<>(occVar);
        }
    }

    @Override // com.baidu.tieba.cec
    public void B(scc sccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sccVar) == null) {
            this.s = new WeakReference<>(sccVar);
        }
    }

    public void B0(pcc pccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pccVar) == null) {
            this.r = new WeakReference<>(pccVar);
        }
    }

    @Override // com.baidu.tieba.cec
    public void C(tcc tccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tccVar) == null) {
            this.j = new WeakReference<>(tccVar);
        }
    }

    public void C0(qcc qccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qccVar) == null) {
            this.k = new WeakReference<>(qccVar);
        }
    }

    @Override // com.baidu.tieba.cec
    public void D(ucc uccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uccVar) == null) {
            this.i = new WeakReference<>(uccVar);
        }
    }

    public void D0(rcc rccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rccVar) == null) {
            this.m = new WeakReference<>(rccVar);
        }
    }

    public void E0(wcc wccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wccVar) == null) {
            this.v = new WeakReference<>(wccVar);
        }
    }

    public void F0(xcc xccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xccVar) == null) {
            this.t = new WeakReference<>(xccVar);
        }
    }

    public void H0(adc.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.q = new WeakReference<>(cVar);
        }
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.f1(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void s(fcc fccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, fccVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.d = fccVar.k();
                    this.G = fccVar.d();
                    this.f.U0(fccVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void t(fcc fccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fccVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.d = fccVar.k();
                    this.G = fccVar.d();
                    this.f.V0(fccVar);
                }
            }
        }
    }

    public void v0(boolean z) {
        sdc sdcVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (sdcVar = this.f) != null) {
            sdcVar.Y0(z);
        }
    }

    public void w0(boolean z) {
        sdc sdcVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (sdcVar = this.f) != null) {
            sdcVar.Z0(z);
        }
    }

    @Override // com.baidu.tieba.cec
    public void x(icc iccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, iccVar) == null) {
            this.o = new WeakReference<>(iccVar);
        }
    }

    @Override // com.baidu.tieba.cec
    public void y(kcc kccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, kccVar) == null) {
            this.h = new WeakReference<>(kccVar);
        }
    }

    public void y0(gcc gccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, gccVar) == null) {
            pdc.m(gccVar);
        }
    }

    @Override // com.baidu.tieba.cec
    public void z(mcc mccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, mccVar) == null) {
            this.n = new WeakReference<>(mccVar);
        }
    }

    public void z0(lcc lccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, lccVar) == null) {
            this.u = new WeakReference<>(lccVar);
        }
    }

    @Override // com.baidu.tieba.cec
    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            TLog.g(this, this.c + "rotateMode: " + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.e1(i);
                }
            }
        }
    }

    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            TLog.g(this, this.c + "orientateMode: " + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.d1(i);
                }
            }
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            TLog.g(this, this.c + "volume:" + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.g1(i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            TLog.g(this, this.c + "displayMode: " + i + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.W0(i);
                }
            }
        }
    }

    public void u0(odc odcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, odcVar) == null) {
            TLog.g(this, this.c + " setEffectResources " + odc.d(odcVar));
            synchronized (this) {
                if (this.f == null) {
                    return;
                }
                this.f.X0(odcVar);
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            TLog.g(this, this.c + "VodPlay enter.  setNumberOfLoops: " + i);
            synchronized (this) {
                if (this.f != null) {
                    this.f.b1(i);
                }
            }
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            TLog.g(this, this.c + "isSpecialMp4WithAlpha: " + z + " enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.a1(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void F(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            TLog.l(this, this.c + "VodPlay.start enter, isSubProcess:" + this.E.m);
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(" VodPlay.start enter. ");
            Log.i("transvod", sb.toString());
            synchronized (this) {
                if (this.f != null) {
                    this.f.i1(i, j);
                }
            }
        }
    }

    public final void m0(Context context, zcc zccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, zccVar) == null) {
            TLog.k(4);
            bec.a(context);
            ybc.c(context);
            dfc dfcVar = zccVar.j;
            if (dfcVar != null) {
                this.D = dfcVar;
            } else {
                cfc cfcVar = zccVar.k;
                if (cfcVar != null) {
                    this.D = cfcVar;
                } else if (zccVar.g) {
                    this.D = new SurfaceView(context);
                } else {
                    this.D = new TextureView(context);
                }
            }
            sdc sdcVar = new sdc(zccVar);
            this.f = sdcVar;
            sdcVar.c1(this.H);
            this.f.h1(context, this.D);
            this.c = this.f.m0();
            TLog.l(this, String.format(Locale.getDefault(), "VodPlayer create(%d)", Integer.valueOf(this.c)));
            this.e = new a(this, Looper.getMainLooper());
        }
    }

    public final void q0(int i, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i, cVar) == null) {
            TLog.g(this, String.format("mPlayerContextId = %d, MET_CALLBACK_PLAYER_STATE_CHANGE state = %d", Integer.valueOf(this.c), Integer.valueOf(i)));
            if (i != 1) {
                switch (i) {
                    case 4:
                        cVar.a = 4;
                        return;
                    case 5:
                        cVar.a = 5;
                        return;
                    case 6:
                        cVar.a = 6;
                        return;
                    case 7:
                        cVar.a = 7;
                        return;
                    case 8:
                        cVar.a = 8;
                        cVar.b = this.B.get();
                        cVar.c = this.w.get();
                        this.B.set(0);
                        this.x.set(0);
                        return;
                    default:
                        return;
                }
            }
            cVar.a = 1;
        }
    }

    @Override // com.baidu.tieba.cec
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Log.i("transvod", this.c + " VodPlay stop.");
            TLog.l(this, this.c + " VodPlay.stop enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.j1();
                }
                this.y.set(0);
                this.x.set(0);
                this.w.set(0);
                this.B.set(0);
                this.z.set(0);
                this.A.set(0);
            }
        }
    }

    public int K0(int i, fcc fccVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, fccVar)) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.k1(i, fccVar);
                    return 0;
                }
                return -1;
            }
        }
        return invokeIL.intValue;
    }

    @Override // com.baidu.tieba.cec
    public void q(Executor executor, adc.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, executor, dVar) == null) {
            synchronized (this) {
                if (this.f != null) {
                    this.f.S0(executor, dVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void w(Executor executor, hcc hccVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, executor, hccVar) == null) {
            this.p = new WeakReference<>(hccVar);
            this.F = executor;
        }
    }

    @Override // com.baidu.tieba.cec
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TLog.g(this, this.c + "appInBackground");
            synchronized (this) {
                if (this.f != null) {
                    this.f.H0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TLog.g(this, this.c + "appInFrontground");
            synchronized (this) {
                if (this.f != null) {
                    this.f.I0();
                }
            }
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            TLog.g(this, this.c + " disableJoyPkPipMode.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.j0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            TLog.g(this, this.c + "VodPlay.pausePlayWithAudio enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.L0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            TLog.g(this, this.c + "VodPlay.resumePlayWithAudio enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.Q0();
                }
            }
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            TLog.g(this, this.c + "VodPlay.pausePlayWithVideo enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.M0();
                }
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            TLog.g(this, this.c + "VodPlay.resumePlayWithVideo enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.R0();
                }
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.finalize();
        }
    }

    @Override // com.baidu.tieba.cec
    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.B.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.cec
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.w.get();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.cec
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TLog.g(this, this.c + "VodPlay.getPlayerView enter.");
            return this.D;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.cec
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.A.get();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cec
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.z.get();
        }
        return invokeV.intValue;
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            TLog.g(this, this.c + "VodPlay.getPlayerUID enter.");
            return this.c;
        }
        return invokeV.intValue;
    }

    public String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            sdc sdcVar = this.f;
            if (sdcVar != null) {
                return sdcVar.l0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cec
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Log.i("transvod", this.c + " VodPlay.pause. ");
            TLog.l(this, this.c + " VodPlay.pause enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.K0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Log.i("transvod", this.c + " VodPlay.resume. ");
            TLog.l(this, this.c + " VodPlay.resumeenter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.P0();
                }
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            Log.i("transvod", this.c + "VodPlay release.");
            TLog.l(this, this.c + "VodPlay release enter.");
            synchronized (this) {
                if (this.f != null) {
                    this.f.N0();
                    this.f = null;
                }
                if (this.e != null) {
                    this.e.removeCallbacksAndMessages(null);
                    this.e = null;
                }
            }
        }
    }

    public void n0(edc edcVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, edcVar) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(" enableJoyPkPipMode:");
            if (edcVar != null) {
                str = "(" + edcVar.b + "," + edcVar.c + "), (" + edcVar.d + StringUtil.ARRAY_ELEMENT_SEPARATOR + edcVar.e + "), force: " + edcVar.a;
            } else {
                str = StringUtil.NULL_STRING;
            }
            sb.append(str);
            TLog.g(this, sb.toString());
            synchronized (this) {
                if (this.f != null) {
                    this.f.k0(edcVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cec
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            TLog.l(this, this.c + " VodPlay.seekTo enter.  seekToTime: " + j);
            synchronized (this) {
                if (j > this.w.get()) {
                    j = this.w.get();
                }
                if (j < 0) {
                    j = 0;
                }
                if (this.f != null) {
                    this.f.T0(j);
                }
            }
        }
    }
}
