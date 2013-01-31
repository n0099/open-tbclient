package com.baidu.tieba.c;

import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class f {
    private String a;
    private String b;
    private com.baidu.tieba.a.f c;
    private t d;
    private boolean e = false;

    public f(String str, com.baidu.tieba.a.f fVar, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.c = fVar;
        this.b = str2;
    }

    public void a() {
        if (this.d != null) {
            this.d.g();
        }
        this.e = true;
    }

    public com.baidu.tieba.a.g b() {
        com.baidu.tieba.a.g gVar = new com.baidu.tieba.a.g();
        long b = this.c.b();
        long j = b % 102400 == 0 ? b / 102400 : (b / 102400) + 1;
        int c = this.c.c();
        if (c < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(o.c(this.a), "r");
            af.e("ChunkUploadHelper", "uploadChunkFile", String.format("start chunk : %d", Integer.valueOf(c)));
            if (randomAccessFile.skipBytes(102400 * c) < 102400 * c) {
                gVar.a(false);
                randomAccessFile.close();
                return gVar;
            }
            while (true) {
                int i = c;
                if (i < j) {
                    int i2 = 102400;
                    if (i == j - 1) {
                        i2 = (int) (b - (102400 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.d = new t(this.b);
                        this.d.a("md5", this.c.a());
                        this.d.a("total_length", String.valueOf(b));
                        this.d.a("total_num", String.valueOf(j));
                        af.e("ChunkUploadHelper", "uploadChunkFile", String.format("total length : %d, chunk_no : %d", Long.valueOf(b), Integer.valueOf(i)));
                        this.d.a("pic_chunk", bArr);
                        this.d.a("offset", String.valueOf(102400 * i));
                        this.d.a("chunk_no", String.valueOf(i + 1));
                        this.d.a("length", String.valueOf(read));
                        boolean z = false;
                        if (this.e) {
                            z = true;
                        } else {
                            String j2 = this.d.j();
                            af.e("ChunkUploadHelper", "uploadChunkFile", "ret " + j2);
                            if (j2 == null || !this.d.b()) {
                                this.c.a(i);
                                k.a(this.c);
                                randomAccessFile.close();
                                z = true;
                            }
                        }
                        if (z) {
                            gVar.a(this.d.d());
                            gVar.a(this.d.f());
                            gVar.a(this.c);
                            gVar.a(false);
                            return gVar;
                        }
                    }
                    c = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        gVar.a(true);
        return gVar;
    }
}
