package com.baidu.tbadk.coreExtra.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.net.InetSocketAddress;
import java.net.Socket;
/* loaded from: classes.dex */
public class f {
    private boolean fBJ = false;
    private int fBK = 0;

    public void Dt(String str) {
        int lastIndexOf;
        String str2;
        String str3 = null;
        this.fBJ = false;
        this.fBK = 0;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                str2 = str.substring(5, lastIndexOf);
                try {
                    str3 = str.substring(lastIndexOf + 1);
                } catch (Exception e) {
                    e = e;
                    BdLog.e(e.getMessage());
                    if (TextUtils.isEmpty(str2)) {
                    }
                    return;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = null;
            }
            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < 3; i3++) {
                    Socket socket = new Socket();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            socket.connect(new InetSocketAddress(str2, com.baidu.adp.lib.f.b.toInt(String.valueOf(str3), 8000)), getTimeout());
                            if (socket.isConnected()) {
                                i++;
                                i2 = (int) ((System.currentTimeMillis() - currentTimeMillis) + i2);
                                this.fBJ = true;
                            }
                            try {
                                socket.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                        } catch (Throwable th) {
                            try {
                                socket.close();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        BdLog.e(e5.getMessage());
                        try {
                            socket.close();
                        } catch (Exception e6) {
                            BdLog.e(e6.getMessage());
                        }
                    }
                }
                if (this.fBJ && i > 0) {
                    this.fBK = i2 / i;
                }
            }
        }
    }

    public boolean isSucc() {
        return this.fBJ;
    }

    public int bDL() {
        return this.fBK;
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
