package com.baidu.tieba.dnsproxy.a;

import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    private static c cMR = null;
    private Wire wire = new Wire(new Class[0]);
    private Map<String, a> cMS = null;
    private Runnable cMT = new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.c.1
        @Override // java.lang.Runnable
        public void run() {
            final Map map;
            synchronized (c.class) {
                map = c.this.cMS;
            }
            if (map != null) {
                w.a(new v<Void>() { // from class: com.baidu.tieba.dnsproxy.a.c.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tbadk.util.v
                    /* renamed from: Rl */
                    public Void doInBackground() {
                        WriteHistroyDataReqIdl.Builder builder = new WriteHistroyDataReqIdl.Builder();
                        builder.connect_point_list = new ArrayList();
                        for (Map.Entry entry : map.entrySet()) {
                            ConnectPointData a = a.a((a) entry.getValue());
                            if (a != null) {
                                builder.connect_point_list.add(a);
                            }
                        }
                        c.this.C(builder.build(true).toByteArray());
                        synchronized (c.class) {
                            c.this.cMS = null;
                        }
                        return null;
                    }
                }, null);
            }
        }
    };

    public static final c anh() {
        if (cMR == null) {
            synchronized (c.class) {
                if (cMR == null) {
                    cMR = new c();
                }
            }
        }
        return cMR;
    }

    private c() {
    }

    public void a(final h<WriteHistroyDataReqIdl> hVar) {
        w.a(new v<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: ank */
            public WriteHistroyDataReqIdl doInBackground() {
                byte[] ani = c.this.ani();
                if (ani != null) {
                    try {
                        return (WriteHistroyDataReqIdl) c.this.wire.parseFrom(ani, WriteHistroyDataReqIdl.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }, new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: a */
            public void onReturnDataInUI(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                if (hVar != null) {
                    hVar.onReturnDataInUI(writeHistroyDataReqIdl);
                }
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [144=6, 145=5] */
    /* JADX INFO: Access modifiers changed from: private */
    public byte[] ani() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        OutputStream outputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            try {
                fileInputStream = BdBaseApplication.getInst().getContext().openFileInput("dnsproxydata");
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.tieba.dnsproxy.d.amX().aS("read_dnsproxydata", e.getMessage());
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    return bArr;
                } catch (IOException e2) {
                    e = e2;
                    BdLog.detailException(e);
                    com.baidu.tieba.dnsproxy.d.amX().aS("read_dnsproxydata", e.getMessage());
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th3) {
                    th = th3;
                    BdLog.detailException(th);
                    com.baidu.tieba.dnsproxy.d.amX().aS("read_dnsproxydata", th.getMessage());
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    return bArr;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (IOException e4) {
                e = e4;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                outputStream = null;
                th = th4;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b(outputStream);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (IOException e6) {
            e = e6;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return bArr;
    }

    public void anj() {
        e.im().removeMessages(0, this);
        e.im().post(this.cMT);
    }

    public void m(Map<String, a> map) {
        if (TbadkCoreApplication.getInst().isMainProcess(false) && map != null) {
            synchronized (c.class) {
                this.cMS = map;
            }
            if (!e.im().hasMessages(0, this)) {
                Message obtain = Message.obtain(e.im(), this.cMT);
                obtain.what = 0;
                obtain.obj = this;
                e.im().sendMessageDelayed(obtain, StatisticConfig.MIN_UPLOAD_INTERVAL);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [195=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void C(byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = BdBaseApplication.getInst().getContext().openFileOutput("dnsproxydata", 0);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                } catch (FileNotFoundException e) {
                    BdLog.detailException(e);
                    com.baidu.tieba.dnsproxy.d.amX().aS("save_dnsproxydata", e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                com.baidu.tieba.dnsproxy.d.amX().aS("save_dnsproxydata", e2.getMessage());
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
            } catch (Throwable th) {
                BdLog.detailException(th);
                com.baidu.tieba.dnsproxy.d.amX().aS("save_dnsproxydata", th.getMessage());
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
            }
        } catch (Throwable th2) {
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
            throw th2;
        }
    }
}
