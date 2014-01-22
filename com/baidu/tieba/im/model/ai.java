package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.util.ax;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, UploadPicData2> {
    final /* synthetic */ ag a;
    private ax b;
    private boolean c;

    private ai(ag agVar) {
        this.a = agVar;
        this.b = null;
        this.c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public UploadPicData2 a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [242=5, 243=4] */
    private UploadPicData2 d() {
        RandomAccessFile randomAccessFile;
        Exception e;
        UploadPicData2 uploadPicData2;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        StringBuilder sb = new StringBuilder();
        try {
            str = this.a.h;
            File file = new File(str);
            long length = file.length();
            String a = bu.a(com.baidu.tieba.util.ad.a(file));
            sb.append("path=");
            str2 = this.a.h;
            sb.append(str2);
            sb.append("|length=");
            sb.append(length);
            sb.append("|md5=");
            sb.append(a);
            if (length == 0 || a == null) {
                uploadPicData2 = new UploadPicData2();
                uploadPicData2.error_code = ag.a;
                uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.file_not_exist);
                by.a("", -1007, "file error: " + uploadPicData2.error_msg, sb.toString());
                com.baidu.adp.lib.f.a.a((Closeable) null);
                a(100);
            } else {
                String str4 = a + 10240;
                long j = length % 10240 == 0 ? length / 10240 : (length / 10240) + 1;
                sb.append("|chunkNo=");
                sb.append(j);
                str3 = this.a.h;
                randomAccessFile = new RandomAccessFile(str3, "r");
                try {
                    try {
                        sb.append("|width=");
                        i = this.a.l;
                        sb.append(i);
                        sb.append("|height=");
                        i2 = this.a.m;
                        sb.append(i2);
                        sb.append("|smallWidth=");
                        i3 = this.a.j;
                        sb.append(i3);
                        sb.append("|smallHeight=");
                        i4 = this.a.k;
                        sb.append(i4);
                        sb.append("|groupId=");
                        sb.append(1);
                        int i10 = 0;
                        byte[] bArr = null;
                        int i11 = 1;
                        uploadPicData2 = null;
                        while (i11 <= j) {
                            try {
                                if (!this.c) {
                                    int i12 = 0;
                                    if (i11 > j) {
                                        bArr = null;
                                    } else {
                                        if (i11 < j) {
                                            i12 = 10240;
                                        } else if (i11 == j) {
                                            i12 = (int) (length - (10240 * (j - 1)));
                                        }
                                        if (bArr == null || bArr.length != i12) {
                                            bArr = new byte[i12];
                                        }
                                        randomAccessFile.seek((i11 - 1) * 10240);
                                        randomAccessFile.read(bArr, 0, i12);
                                    }
                                    this.b = new ax(com.baidu.tieba.im.j.g);
                                    this.b.a("resourceId", str4);
                                    this.b.a("chunkNo", String.valueOf(i11));
                                    if (i11 >= j) {
                                        this.b.a("isFinish", String.valueOf(1));
                                    } else {
                                        this.b.a("isFinish", String.valueOf(0));
                                    }
                                    ax axVar = this.b;
                                    i5 = this.a.l;
                                    axVar.a("width", String.valueOf(i5));
                                    ax axVar2 = this.b;
                                    i6 = this.a.m;
                                    axVar2.a("height", String.valueOf(i6));
                                    ax axVar3 = this.b;
                                    i7 = this.a.j;
                                    axVar3.a("smallWidth", String.valueOf(i7));
                                    ax axVar4 = this.b;
                                    i8 = this.a.k;
                                    axVar4.a("smallHeight", String.valueOf(i8));
                                    this.b.a("groupId", String.valueOf(1));
                                    this.b.a("alt", "json");
                                    if (bArr != null) {
                                        this.b.a("chunk", bArr);
                                    }
                                    uploadPicData2 = UploadPicData2.parser(this.b.o());
                                    if (uploadPicData2 != null && (uploadPicData2.error_code == 0 || uploadPicData2.error_code == ag.d)) {
                                        if (uploadPicData2.error_code != ag.d) {
                                            i9 = i11 + 1;
                                        } else if (i11 == uploadPicData2.chunkNo || uploadPicData2.chunkNo <= 0) {
                                            uploadPicData2 = null;
                                            sb.append("|startChunk=");
                                            sb.append(i11);
                                            break;
                                        } else {
                                            i9 = uploadPicData2.chunkNo;
                                        }
                                        int i13 = i10 + 1;
                                        int i14 = (int) ((i13 / (j * 1.0d)) * 100.0d);
                                        if (i14 > 100) {
                                            i14 = 90;
                                        }
                                        a(i14);
                                        if (i13 > 2 * j) {
                                            break;
                                        }
                                        i10 = i13;
                                        i11 = i9;
                                    } else {
                                        sb.append("|startChunk=");
                                        sb.append(i11);
                                        sb.append("|picNull=");
                                        sb.append(uploadPicData2 == null);
                                        sb.append("|picErrNo=");
                                        if (uploadPicData2 != null) {
                                            sb.append(uploadPicData2.error_code);
                                        }
                                    }
                                } else {
                                    break;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.adp.lib.g.e.a(e.getMessage());
                                by.a("", -1002, "SendPicAyncTask.uploadChunkFile ex: " + e.getMessage(), sb.toString());
                                com.baidu.adp.lib.f.a.a(randomAccessFile);
                                a(100);
                                return uploadPicData2;
                            }
                        }
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        a(100);
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        a(100);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    uploadPicData2 = null;
                }
            }
        } catch (Exception e4) {
            randomAccessFile = null;
            e = e4;
            uploadPicData2 = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        return uploadPicData2;
    }

    private void a(int i) {
        ak akVar;
        ak akVar2;
        akVar = this.a.f;
        if (akVar != null) {
            akVar2 = this.a.f;
            akVar2.a(i, this.a.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a() {
        aj ajVar;
        aj ajVar2;
        String str;
        super.a();
        ajVar = this.a.g;
        if (ajVar != null) {
            UploadPicData2 uploadPicData2 = new UploadPicData2();
            uploadPicData2.error_code = ag.c;
            uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.send_error);
            ajVar2 = this.a.g;
            str = this.a.h;
            ajVar2.a(str, uploadPicData2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.a.n = null;
        if (this.b != null) {
            this.b.k();
        }
        this.c = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UploadPicData2 uploadPicData2) {
        aj ajVar;
        aj ajVar2;
        String str;
        super.a((ai) uploadPicData2);
        this.a.n = null;
        ajVar = this.a.g;
        if (ajVar != null) {
            if (uploadPicData2 == null) {
                uploadPicData2 = new UploadPicData2();
                uploadPicData2.error_code = ag.b;
                uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.send_error);
                by.a("", -1002, uploadPicData2.error_msg, "");
            }
            ajVar2 = this.a.g;
            str = this.a.h;
            ajVar2.a(str, uploadPicData2);
        }
    }
}
