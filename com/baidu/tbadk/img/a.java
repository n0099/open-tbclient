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
    private WeakReference<InterfaceC0044a<T>> atP = null;
    private c atQ = null;
    private a<T>.b atR = null;
    public T atS;
    private final com.baidu.tbadk.img.c atT;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.atT = new com.baidu.tbadk.img.c(str2);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.atT.f(i, i2, i3, i4);
    }

    public void bE(boolean z) {
        if (this.atR == null) {
            this.atR = new b(this, null);
            this.atR.bF(z);
            this.atR.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean atU;

        private b() {
            this.atU = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bF(boolean z) {
            this.atU = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return CL();
        }

        private ImageUploadResult CL() {
            a.this.atT.a(this, null);
            ImageUploadResult s = a.this.atT.s(a.this.mPath, this.atU);
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.atP != null && a.this.atP.get() != null) {
                ((InterfaceC0044a) a.this.atP.get()).b(numArr[0].intValue(), a.this.atS);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.atQ != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m11getInst().getApp().getString(t.j.send_error);
                a.this.atQ.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.atR = null;
            a.this.atT.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.atR = null;
            if (a.this.atQ != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m11getInst().getApp().getString(t.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.atQ.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0044a<T> interfaceC0044a) {
        this.atP = new WeakReference<>(interfaceC0044a);
    }

    public void a(c cVar) {
        this.atQ = cVar;
    }

    public void setGroupId(String str) {
        this.atT.setGroupId(str);
    }

    public T CJ() {
        return this.atS;
    }

    public void y(T t) {
        this.atS = t;
    }

    public void CK() {
        LocalViewSize.ImageSize tv = LocalViewSize.tt().tv();
        LocalViewSize.ImageSize tw = LocalViewSize.tt().tw();
        f(tw.width, tw.height, tv.width, tv.height);
    }
}
