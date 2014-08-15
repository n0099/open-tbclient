package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import java.net.InetSocketAddress;
import java.net.Socket;
/* loaded from: classes.dex */
public class p {
    private static /* synthetic */ int[] c;
    private boolean a = false;
    private int b = 0;

    static /* synthetic */ int[] c() {
        int[] iArr = c;
        if (iArr == null) {
            iArr = new int[UtilHelper.NetworkStateInfo.valuesCustom().length];
            try {
                iArr[UtilHelper.NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UtilHelper.NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            c = iArr;
        }
        return iArr;
    }

    public void a(String str) {
        int lastIndexOf;
        Exception e;
        String str2;
        int i;
        int i2;
        String str3 = null;
        int i3 = 0;
        this.a = false;
        this.b = 0;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                str2 = str.substring(5, lastIndexOf);
            } catch (Exception e2) {
                e = e2;
                str2 = null;
            }
            try {
                str3 = str.substring(lastIndexOf + 1);
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                if (TextUtils.isEmpty(str2)) {
                }
                return;
            }
            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < 3) {
                    Socket socket = new Socket();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            socket.connect(new InetSocketAddress(str2, com.baidu.adp.lib.e.b.a(String.valueOf(str3), (int) LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8)), d());
                            if (socket.isConnected()) {
                                int i6 = i3 + 1;
                                int currentTimeMillis2 = (int) ((System.currentTimeMillis() - currentTimeMillis) + i5);
                                this.a = true;
                                i = i6;
                                i2 = currentTimeMillis2;
                            } else {
                                i = i3;
                                i2 = i5;
                            }
                            try {
                                socket.close();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        } catch (Throwable th) {
                            try {
                                socket.close();
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        i = i3;
                        i2 = i5;
                        BdLog.e(e6.getMessage());
                        try {
                            socket.close();
                        } catch (Exception e7) {
                            BdLog.e(e7.getMessage());
                        }
                    }
                    i4++;
                    i5 = i2;
                    i3 = i;
                }
                if (this.a && i3 > 0) {
                    this.b = i5 / i3;
                }
            }
        }
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    private int d() {
        switch (c()[UtilHelper.getNetStatusInfo(TbadkApplication.m252getInst().getApp().getApplicationContext()).ordinal()]) {
            case 2:
                return 3000;
            case 3:
                return TbConfig.BIG_IMAGE_MIN_CAPACITY;
            case 4:
            default:
                return 5000;
        }
    }
}
