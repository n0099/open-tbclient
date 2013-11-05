package com.baidu.tieba.a;

import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ag;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f993a;
    private String b;
    private String c;
    private com.baidu.tieba.data.e d;
    private ag e;
    private boolean f = false;
    private String g;

    public b(a aVar, String str, com.baidu.tieba.data.e eVar, String str2, String str3) {
        this.f993a = aVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = null;
        this.b = str;
        this.d = eVar;
        this.c = str2;
        this.g = str3;
    }

    public com.baidu.tieba.data.f a() {
        com.baidu.tieba.data.f fVar = new com.baidu.tieba.data.f();
        long b = this.d.b();
        long j = b % 30720 == 0 ? b / 30720 : (b / 30720) + 1;
        int c = this.d.c();
        if (c < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.b), "r");
            if (randomAccessFile.skipBytes(c * 30720) >= c * 30720) {
                while (true) {
                    int i = c;
                    if (i < j) {
                        int i2 = 30720;
                        if (i == j - 1) {
                            i2 = (int) (b - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.e = new ag(this.c);
                            this.e.a("voice_chunk", bArr);
                            this.e.a("chunk_md5", this.d.a());
                            this.e.a("length", String.valueOf(read));
                            this.e.a("offset", String.valueOf(i * 30720));
                            this.e.a("total_length", String.valueOf(b));
                            this.e.a("chunk_no", String.valueOf(i + 1));
                            this.e.a("total_num", String.valueOf(j));
                            this.e.a("voice_md5", this.g);
                            boolean z = false;
                            if (this.f) {
                                z = true;
                            } else if (this.e.l() == null || !this.e.c()) {
                                this.d.a(i);
                                DatabaseService.a(this.d);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                fVar.a(this.e.e());
                                fVar.a(this.e.g());
                                fVar.a(this.d);
                                fVar.a(false);
                                return fVar;
                            }
                        }
                        c = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            } else {
                fVar.a(false);
                randomAccessFile.close();
                return fVar;
            }
        }
        fVar.a(true);
        return fVar;
    }
}
