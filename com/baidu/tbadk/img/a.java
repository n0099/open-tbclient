package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0251a<T>> cwi = null;
    private c cwj = null;
    private a<T>.b cwk = null;
    public T cwl;
    private final f cwm;
    private String wX;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0251a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.wX = null;
        this.wX = str;
        this.cwm = new f(str2);
    }

    public void m(int i, int i2, int i3, int i4) {
        this.cwm.m(i, i2, i3, i4);
    }

    public void fr(boolean z) {
        if (this.cwk == null) {
            this.cwk = new b();
            this.cwk.fs(z);
            this.cwk.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean cwn;

        private b() {
            this.cwn = false;
        }

        protected void fs(boolean z) {
            this.cwn = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return atE();
        }

        private ImageUploadResult atE() {
            a.this.cwm.a(this, null);
            ImageUploadResult T = a.this.cwm.T(a.this.wX, this.cwn);
            publishProgress(100);
            return T;
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
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.cwi != null && a.this.cwi.get() != null) {
                ((InterfaceC0251a) a.this.cwi.get()).d(numArr[0].intValue(), a.this.cwl);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.cwj != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.cwj.a(a.this.wX, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.cwk = null;
            a.this.cwm.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.cwk = null;
            if (a.this.cwj != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.cwj.a(a.this.wX, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0251a<T> interfaceC0251a) {
        this.cwi = new WeakReference<>(interfaceC0251a);
    }

    public void a(c cVar) {
        this.cwj = cVar;
    }

    public void setGroupId(String str) {
        this.cwm.setGroupId(str);
    }

    public T atC() {
        return this.cwl;
    }

    public void ac(T t) {
        this.cwl = t;
    }

    public void atD() {
        LocalViewSize.ImageSize aiz = LocalViewSize.aix().aiz();
        LocalViewSize.ImageSize aiA = LocalViewSize.aix().aiA();
        m(aiA.width, aiA.height, aiz.width, aiz.height);
    }
}
