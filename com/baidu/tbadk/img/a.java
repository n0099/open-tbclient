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
    private WeakReference<InterfaceC0256a<T>> cwp = null;
    private c cwq = null;
    private a<T>.b cwr = null;
    public T cws;
    private final f cwt;
    private String wX;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0256a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.wX = null;
        this.wX = str;
        this.cwt = new f(str2);
    }

    public void m(int i, int i2, int i3, int i4) {
        this.cwt.m(i, i2, i3, i4);
    }

    public void fr(boolean z) {
        if (this.cwr == null) {
            this.cwr = new b();
            this.cwr.fs(z);
            this.cwr.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean cwu;

        private b() {
            this.cwu = false;
        }

        protected void fs(boolean z) {
            this.cwu = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return atG();
        }

        private ImageUploadResult atG() {
            a.this.cwt.a(this, null);
            ImageUploadResult T = a.this.cwt.T(a.this.wX, this.cwu);
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
            if (numArr != null && numArr.length != 0 && a.this.cwp != null && a.this.cwp.get() != null) {
                ((InterfaceC0256a) a.this.cwp.get()).d(numArr[0].intValue(), a.this.cws);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.cwq != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.cwq.a(a.this.wX, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.cwr = null;
            a.this.cwt.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.cwr = null;
            if (a.this.cwq != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.cwq.a(a.this.wX, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0256a<T> interfaceC0256a) {
        this.cwp = new WeakReference<>(interfaceC0256a);
    }

    public void a(c cVar) {
        this.cwq = cVar;
    }

    public void setGroupId(String str) {
        this.cwt.setGroupId(str);
    }

    public T atE() {
        return this.cws;
    }

    public void ac(T t) {
        this.cws = t;
    }

    public void atF() {
        LocalViewSize.ImageSize aiB = LocalViewSize.aiz().aiB();
        LocalViewSize.ImageSize aiC = LocalViewSize.aiz().aiC();
        m(aiC.width, aiC.height, aiB.width, aiB.height);
    }
}
