package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0053a<T>> axh = null;
    private c axi = null;
    private a<T>.b axj = null;
    public T axk;
    private final com.baidu.tbadk.img.c axl;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0053a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.axl = new com.baidu.tbadk.img.c(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.axl.h(i, i2, i3, i4);
    }

    public void bt(boolean z) {
        if (this.axj == null) {
            this.axj = new b(this, null);
            this.axj.bu(z);
            this.axj.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean axm;

        private b() {
            this.axm = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bu(boolean z) {
            this.axm = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(String... strArr) {
            return Eh();
        }

        private ImageUploadResult Eh() {
            a.this.axl.a(this, null);
            ImageUploadResult s = a.this.axl.s(a.this.mPath, this.axm);
            publishProgress(100);
            return s;
        }

        @Override // com.baidu.tbadk.img.c.a
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
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.axh != null && a.this.axh.get() != null) {
                ((InterfaceC0053a) a.this.axh.get()).b(numArr[0].intValue(), a.this.axk);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.axi != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.send_error);
                a.this.axi.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.axj = null;
            a.this.axl.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.axj = null;
            if (a.this.axi != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.axi.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0053a<T> interfaceC0053a) {
        this.axh = new WeakReference<>(interfaceC0053a);
    }

    public void a(c cVar) {
        this.axi = cVar;
    }

    public void setGroupId(String str) {
        this.axl.setGroupId(str);
    }

    public T Ef() {
        return this.axk;
    }

    public void y(T t) {
        this.axk = t;
    }

    public void Eg() {
        LocalViewSize.ImageSize vw = LocalViewSize.vu().vw();
        LocalViewSize.ImageSize vx = LocalViewSize.vu().vx();
        h(vx.width, vx.height, vw.width, vw.height);
    }
}
