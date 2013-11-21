package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, UploadPicData2> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f1752a;
    private ap b;
    private boolean c;

    private t(r rVar) {
        this.f1752a = rVar;
        this.b = null;
        this.c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public UploadPicData2 a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=5] */
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
            str = this.f1752a.g;
            File file = new File(str);
            long length = file.length();
            String a2 = be.a(af.a(file));
            if (length == 0 || a2 == null) {
                uploadPicData2 = new UploadPicData2();
                i = r.b;
                uploadPicData2.error_code = i;
                uploadPicData2.error_msg = TiebaApplication.g().getString(R.string.file_not_exist);
                com.baidu.adp.lib.f.a.a((Closeable) null);
            } else {
                String str3 = a2 + 102400;
                long j = length % 102400 == 0 ? length / 102400 : (length / 102400) + 1;
                str2 = this.f1752a.g;
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
                                        i11 = 102400;
                                    } else if (i10 == j) {
                                        i11 = (int) (length - (102400 * (j - 1)));
                                    }
                                    if (bArr == null || bArr.length != i11) {
                                        bArr = new byte[i11];
                                    }
                                    randomAccessFile.seek(102400 * (i10 - 1));
                                    randomAccessFile.read(bArr, 0, i11);
                                }
                                this.b = new ap(com.baidu.tieba.im.j.i);
                                this.b.a("resourceId", str3);
                                this.b.a("chunkNo", String.valueOf(i10));
                                if (i10 >= j) {
                                    this.b.a("isFinish", String.valueOf(1));
                                } else {
                                    this.b.a("isFinish", String.valueOf(0));
                                }
                                ap apVar = this.b;
                                i2 = this.f1752a.k;
                                apVar.a("width", String.valueOf(i2));
                                ap apVar2 = this.b;
                                i3 = this.f1752a.l;
                                apVar2.a("height", String.valueOf(i3));
                                ap apVar3 = this.b;
                                i4 = this.f1752a.i;
                                apVar3.a("smallWidth", String.valueOf(i4));
                                ap apVar4 = this.b;
                                i5 = this.f1752a.j;
                                apVar4.a("smallHeight", String.valueOf(i5));
                                this.b.a("groupId", String.valueOf(1));
                                this.b.a("alt", "json");
                                if (bArr != null) {
                                    this.b.a("chunk", bArr);
                                }
                                uploadPicData2 = UploadPicData2.parser(this.b.l());
                                if (uploadPicData2 != null) {
                                    if (uploadPicData2.error_code != 0) {
                                        int i12 = uploadPicData2.error_code;
                                        i8 = r.e;
                                        if (i12 != i8) {
                                            break;
                                        }
                                    }
                                    int i13 = uploadPicData2.error_code;
                                    i6 = r.e;
                                    if (i13 != i6) {
                                        i7 = i10 + 1;
                                    } else if (i10 == uploadPicData2.chunkNo || uploadPicData2.chunkNo <= 0) {
                                        uploadPicData2 = null;
                                        break;
                                    } else {
                                        i7 = uploadPicData2.chunkNo;
                                    }
                                    int i14 = i9 + 1;
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
                            com.baidu.adp.lib.h.d.a(e.getMessage());
                            com.baidu.adp.lib.f.a.a(randomAccessFile);
                            return uploadPicData2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.f.a.a(randomAccessFile);
                        throw th;
                    }
                }
                com.baidu.adp.lib.f.a.a(randomAccessFile);
            }
        } catch (Exception e3) {
            randomAccessFile = null;
            e = e3;
            uploadPicData2 = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            com.baidu.adp.lib.f.a.a(randomAccessFile);
            throw th;
        }
        return uploadPicData2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a() {
        u uVar;
        int i;
        u uVar2;
        String str;
        super.a();
        uVar = this.f1752a.f;
        if (uVar != null) {
            UploadPicData2 uploadPicData2 = new UploadPicData2();
            i = r.d;
            uploadPicData2.error_code = i;
            uploadPicData2.error_msg = TiebaApplication.g().getString(R.string.send_error);
            uVar2 = this.f1752a.f;
            str = this.f1752a.g;
            uVar2.a(str, uploadPicData2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f1752a.m = null;
        if (this.b != null) {
            this.b.h();
        }
        this.c = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(UploadPicData2 uploadPicData2) {
        u uVar;
        u uVar2;
        String str;
        int i;
        super.a((t) uploadPicData2);
        this.f1752a.m = null;
        uVar = this.f1752a.f;
        if (uVar != null) {
            if (uploadPicData2 == null) {
                uploadPicData2 = new UploadPicData2();
                i = r.c;
                uploadPicData2.error_code = i;
                uploadPicData2.error_msg = TiebaApplication.g().getString(R.string.send_error);
            }
            uVar2 = this.f1752a.f;
            str = this.f1752a.g;
            uVar2.a(str, uploadPicData2);
        }
    }
}
