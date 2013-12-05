package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.explorer.share.BdSharer;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<String, Integer, UploadPicData2> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1829a;
    private am b;
    private boolean c;

    private v(t tVar) {
        this.f1829a = tVar;
        this.b = null;
        this.c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public UploadPicData2 a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [184=5, 185=4] */
    private UploadPicData2 d() {
        RandomAccessFile randomAccessFile;
        Exception e;
        UploadPicData2 uploadPicData2;
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        try {
            str = this.f1829a.h;
            File file = new File(str);
            long length = file.length();
            String a2 = bb.a(com.baidu.tieba.util.x.a(file));
            if (length == 0 || a2 == null) {
                uploadPicData2 = new UploadPicData2();
                i = t.b;
                uploadPicData2.error_code = i;
                uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.file_not_exist);
                com.baidu.adp.lib.f.a.a((Closeable) null);
                a(100);
            } else {
                String str3 = a2 + 10240;
                long j = length % BdSharer.IMAGE_MIN_SIZE_TO_SHARE == 0 ? length / BdSharer.IMAGE_MIN_SIZE_TO_SHARE : (length / BdSharer.IMAGE_MIN_SIZE_TO_SHARE) + 1;
                str2 = this.f1829a.h;
                randomAccessFile = new RandomAccessFile(str2, "r");
                int i9 = 0;
                byte[] bArr = null;
                int i10 = 1;
                uploadPicData2 = null;
                while (i10 <= j) {
                    try {
                        try {
                            if (!this.c) {
                                int i11 = 0;
                                if (i10 > j) {
                                    bArr = null;
                                } else {
                                    if (i10 < j) {
                                        i11 = 10240;
                                    } else if (i10 == j) {
                                        i11 = (int) (length - (BdSharer.IMAGE_MIN_SIZE_TO_SHARE * (j - 1)));
                                    }
                                    if (bArr == null || bArr.length != i11) {
                                        bArr = new byte[i11];
                                    }
                                    randomAccessFile.seek((i10 - 1) * 10240);
                                    randomAccessFile.read(bArr, 0, i11);
                                }
                                this.b = new am(com.baidu.tieba.im.j.h);
                                this.b.a("resourceId", str3);
                                this.b.a("chunkNo", String.valueOf(i10));
                                if (i10 >= j) {
                                    this.b.a("isFinish", String.valueOf(1));
                                } else {
                                    this.b.a("isFinish", String.valueOf(0));
                                }
                                am amVar = this.b;
                                i2 = this.f1829a.l;
                                amVar.a("width", String.valueOf(i2));
                                am amVar2 = this.b;
                                i3 = this.f1829a.m;
                                amVar2.a("height", String.valueOf(i3));
                                am amVar3 = this.b;
                                i4 = this.f1829a.j;
                                amVar3.a("smallWidth", String.valueOf(i4));
                                am amVar4 = this.b;
                                i5 = this.f1829a.k;
                                amVar4.a("smallHeight", String.valueOf(i5));
                                this.b.a("groupId", String.valueOf(1));
                                this.b.a("alt", "json");
                                if (bArr != null) {
                                    this.b.a("chunk", bArr);
                                }
                                uploadPicData2 = UploadPicData2.parser(this.b.n());
                                if (uploadPicData2 != null) {
                                    if (uploadPicData2.error_code != 0) {
                                        int i12 = uploadPicData2.error_code;
                                        i8 = t.e;
                                        if (i12 != i8) {
                                            break;
                                        }
                                    }
                                    int i13 = uploadPicData2.error_code;
                                    i6 = t.e;
                                    if (i13 != i6) {
                                        i7 = i10 + 1;
                                    } else if (i10 == uploadPicData2.chunkNo || uploadPicData2.chunkNo <= 0) {
                                        uploadPicData2 = null;
                                        break;
                                    } else {
                                        i7 = uploadPicData2.chunkNo;
                                    }
                                    int i14 = i9 + 1;
                                    int i15 = (int) ((i14 / (j * 1.0d)) * 100.0d);
                                    if (i15 > 100) {
                                        i15 = 90;
                                    }
                                    a(i15);
                                    if (i14 > 2 * j) {
                                        break;
                                    }
                                    i9 = i14;
                                    i10 = i7;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.h.e.a(e.getMessage());
                            com.baidu.adp.lib.f.a.a(randomAccessFile);
                            a(100);
                            return uploadPicData2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        a(100);
                        throw th;
                    }
                }
                com.baidu.adp.lib.f.a.a(randomAccessFile);
                a(100);
            }
        } catch (Exception e3) {
            randomAccessFile = null;
            e = e3;
            uploadPicData2 = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            com.baidu.adp.lib.f.a.a(randomAccessFile);
            a(100);
            throw th;
        }
        return uploadPicData2;
    }

    private void a(int i) {
        x xVar;
        x xVar2;
        xVar = this.f1829a.f;
        if (xVar != null) {
            xVar2 = this.f1829a.f;
            xVar2.a(i, this.f1829a.f1828a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a() {
        w wVar;
        int i;
        w wVar2;
        String str;
        super.a();
        wVar = this.f1829a.g;
        if (wVar != null) {
            UploadPicData2 uploadPicData2 = new UploadPicData2();
            i = t.d;
            uploadPicData2.error_code = i;
            uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.send_error);
            wVar2 = this.f1829a.g;
            str = this.f1829a.h;
            wVar2.a(str, uploadPicData2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1829a.n = null;
        if (this.b != null) {
            this.b.j();
        }
        this.c = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UploadPicData2 uploadPicData2) {
        w wVar;
        w wVar2;
        String str;
        int i;
        super.a((v) uploadPicData2);
        this.f1829a.n = null;
        wVar = this.f1829a.g;
        if (wVar != null) {
            if (uploadPicData2 == null) {
                uploadPicData2 = new UploadPicData2();
                i = t.c;
                uploadPicData2.error_code = i;
                uploadPicData2.error_msg = TiebaApplication.h().getString(R.string.send_error);
            }
            wVar2 = this.f1829a.g;
            str = this.f1829a.h;
            wVar2.a(str, uploadPicData2);
        }
    }
}
