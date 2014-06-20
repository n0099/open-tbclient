package com.baidu.tbadk.coreExtra.service;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.l;
import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {
    final /* synthetic */ b a;
    private String b;
    private String c;
    private com.baidu.tbadk.coreExtra.data.b d;
    private an e;
    private boolean f = false;
    private String g;

    public c(b bVar, String str, com.baidu.tbadk.coreExtra.data.b bVar2, String str2, String str3) {
        this.a = bVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = null;
        this.b = str;
        this.d = bVar2;
        this.c = str2;
        this.g = str3;
    }

    public com.baidu.tbadk.coreExtra.data.c a() {
        com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
        long b = this.d.b();
        long j = b % 30720 == 0 ? b / 30720 : (b / 30720) + 1;
        int c = this.d.c();
        if (c < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.b), "r");
            if (randomAccessFile.skipBytes(c * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < c * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                cVar.a(false);
                randomAccessFile.close();
                return cVar;
            }
            while (true) {
                int i = c;
                if (i < j) {
                    int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (i == j - 1) {
                        i2 = (int) (b - (30720 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.e = new an(this.c);
                        this.e.a("voice_chunk", bArr);
                        this.e.a("chunk_md5", this.d.a());
                        this.e.a("length", String.valueOf(read));
                        this.e.a("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                        this.e.a("total_length", String.valueOf(b));
                        this.e.a("chunk_no", String.valueOf(i + 1));
                        this.e.a("total_num", String.valueOf(j));
                        this.e.a("voice_md5", this.g);
                        boolean z = false;
                        if (this.f) {
                            z = true;
                        } else if (this.e.j() == null || !this.e.a().b().b()) {
                            this.d.a(i);
                            l.a(this.d);
                            randomAccessFile.close();
                            z = true;
                        }
                        if (z) {
                            cVar.a(this.e.d());
                            cVar.a(this.e.f());
                            cVar.a(this.d);
                            cVar.a(false);
                            return cVar;
                        }
                    }
                    c = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        cVar.a(true);
        return cVar;
    }
}
