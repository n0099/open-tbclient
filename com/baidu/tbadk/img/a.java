package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a<T> {
    public T a;
    private String d;
    private final h f;
    private b<T> b = null;
    private d c = null;
    private a<T>.c e = null;

    public a(String str, String str2) {
        this.d = null;
        this.d = str;
        this.f = new h(str2);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    public void a() {
        if (this.e == null) {
            this.e = new c(this, null);
            this.e.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements i {
        private c() {
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public ImageUploadResult doInBackground(String... strArr) {
            return a();
        }

        private ImageUploadResult a() {
            a.this.f.a(this, null);
            ImageUploadResult a = a.this.f.a(a.this.d);
            publishProgress(100);
            return a;
        }

        @Override // com.baidu.tbadk.img.i
        public void a(String str, Object obj, long j, long j2) {
            int i;
            if (j2 == 0) {
                i = 0;
            } else {
                i = (int) ((((float) j) * 100.0f) / ((float) j2));
                if (i > 100) {
                    i = 90;
                }
            }
            publishProgress(Integer.valueOf(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.b != null) {
                a.this.b.a(numArr[0].intValue(), a.this.a);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.c != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkApplication.m252getInst().getApp().getString(u.send_error);
                a.this.c.a(a.this.d, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.e = null;
            a.this.f.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.e = null;
            if (a.this.c != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkApplication.m252getInst().getApp().getString(u.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.c.a(a.this.d, imageUploadResult);
            }
        }
    }

    public void b() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    public void a(b<T> bVar) {
        this.b = bVar;
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    public void a(String str) {
        this.f.b(str);
    }

    public T c() {
        return this.a;
    }

    public void a(T t) {
        this.a = t;
    }

    public void d() {
        LocalViewSize.ImageSize c2 = LocalViewSize.a().c();
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        a(d.width, d.height, c2.width, c2.height);
    }
}
