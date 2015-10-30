package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import java.net.InetSocketAddress;
import java.net.Socket;
/* loaded from: classes.dex */
public class h {
    private boolean amS = false;
    private int amT = 0;

    public void eC(String str) {
        int lastIndexOf;
        Exception e;
        String str2;
        int i;
        int i2;
        String str3 = null;
        int i3 = 0;
        this.amS = false;
        this.amT = 0;
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
                            socket.connect(new InetSocketAddress(str2, com.baidu.adp.lib.g.b.g(String.valueOf(str3), 8000)), zF());
                            if (socket.isConnected()) {
                                int i6 = i3 + 1;
                                int currentTimeMillis2 = (int) ((System.currentTimeMillis() - currentTimeMillis) + i5);
                                this.amS = true;
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
                        } catch (Exception e5) {
                            i = i3;
                            i2 = i5;
                            BdLog.e(e5.getMessage());
                            try {
                                socket.close();
                            } catch (Exception e6) {
                                BdLog.e(e6.getMessage());
                            }
                        }
                        i4++;
                        i5 = i2;
                        i3 = i;
                    } catch (Throwable th) {
                        try {
                            socket.close();
                        } catch (Exception e7) {
                            BdLog.e(e7.getMessage());
                        }
                        throw th;
                    }
                }
                if (this.amS && i3 > 0) {
                    this.amT = i5 / i3;
                }
            }
        }
    }

    public boolean isSucc() {
        return this.amS;
    }

    public int zE() {
        return this.amT;
    }

    private int zF() {
        switch (com.baidu.adp.lib.util.i.iS()) {
            case 1:
                return LocationClientOption.MIN_SCAN_SPAN_NETWORK;
            case 2:
                return 10000;
            case 3:
            default:
                return 5000;
        }
    }
}
