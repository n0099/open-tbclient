package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0117a<T>> aQv = null;
    private c aQw = null;
    private a<T>.b aQx = null;
    public T aQy;
    private final f aQz;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0117a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aQz = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aQz.h(i, i2, i3, i4);
    }

    public void bO(boolean z) {
        if (this.aQx == null) {
            this.aQx = new b();
            this.aQx.bP(z);
            this.aQx.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aQA;

        private b() {
            this.aQA = false;
        }

        protected void bP(boolean z) {
            this.aQA = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Jd();
        }

        private ImageUploadResult Jd() {
            a.this.aQz.a(this, null);
            ImageUploadResult m = a.this.aQz.m(a.this.mPath, this.aQA);
            publishProgress(100);
            return m;
        }

        @Override // com.baidu.tbadk.img.f.a
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
            if (numArr != null && numArr.length != 0 && a.this.aQv != null && a.this.aQv.get() != null) {
                ((InterfaceC0117a) a.this.aQv.get()).b(numArr[0].intValue(), a.this.aQy);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aQw != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                a.this.aQw.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aQx = null;
            a.this.aQz.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aQx = null;
            if (a.this.aQw != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aQw.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0117a<T> interfaceC0117a) {
        this.aQv = new WeakReference<>(interfaceC0117a);
    }

    public void a(c cVar) {
        this.aQw = cVar;
    }

    public void setGroupId(String str) {
        this.aQz.setGroupId(str);
    }

    public T Jb() {
        return this.aQy;
    }

    public void D(T t) {
        this.aQy = t;
    }

    public void Jc() {
        LocalViewSize.ImageSize yS = LocalViewSize.yQ().yS();
        LocalViewSize.ImageSize yT = LocalViewSize.yQ().yT();
        h(yT.width, yT.height, yS.width, yS.height);
    }
}
