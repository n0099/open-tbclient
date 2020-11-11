package com.baidu.tbadk.coreExtra.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import java.net.InetSocketAddress;
import java.net.Socket;
/* loaded from: classes.dex */
public class f {
    private boolean flw = false;
    private int flx = 0;

    public void Dp(String str) {
        int lastIndexOf;
        String str2;
        Exception e;
        int i;
        int i2;
        this.flw = false;
        this.flx = 0;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            String str3 = null;
            try {
                str2 = str.substring(5, lastIndexOf);
                try {
                    str3 = str.substring(lastIndexOf + 1);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    if (TextUtils.isEmpty(str2)) {
                    }
                    return;
                }
            } catch (Exception e3) {
                str2 = null;
                e = e3;
            }
            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < 3) {
                    Socket socket = new Socket();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            socket.connect(new InetSocketAddress(str2, com.baidu.adp.lib.f.b.toInt(String.valueOf(str3), CoolPraiseGuideLottieView.ANIM_DURATION)), getTimeout());
                            if (socket.isConnected()) {
                                i4++;
                                i3 = (int) ((System.currentTimeMillis() - currentTimeMillis) + i3);
                                this.flw = true;
                            }
                            i = i4;
                            i2 = i3;
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
                        i = i4;
                        i2 = i3;
                        BdLog.e(e6.getMessage());
                        try {
                            socket.close();
                        } catch (Exception e7) {
                            BdLog.e(e7.getMessage());
                        }
                    }
                    i5++;
                    i3 = i2;
                    i4 = i;
                }
                if (this.flw && i4 > 0) {
                    this.flx = i3 / i4;
                }
            }
        }
    }

    public boolean isSucc() {
        return this.flw;
    }

    public int byz() {
        return this.flx;
    }

    private int getTimeout() {
        switch (j.netType()) {
            case 1:
                return 3000;
            case 2:
                return 10000;
            case 3:
            default:
                return 5000;
        }
    }
}
