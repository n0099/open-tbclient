package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.d;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0061a<T>> aFN = null;
    private c aFO = null;
    private a<T>.b aFP = null;
    public T aFQ;
    private final d aFR;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061a<T> {
        void a(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aFR = new d(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aFR.h(i, i2, i3, i4);
    }

    public void bO(boolean z) {
        if (this.aFP == null) {
            this.aFP = new b();
            this.aFP.bP(z);
            this.aFP.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements d.a {
        private boolean aFS;

        private b() {
            this.aFS = false;
        }

        protected void bP(boolean z) {
            this.aFS = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return ED();
        }

        private ImageUploadResult ED() {
            a.this.aFR.a(this, null);
            ImageUploadResult s = a.this.aFR.s(a.this.mPath, this.aFS);
            publishProgress(100);
            return s;
        }

        @Override // com.baidu.tbadk.img.d.a
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
            if (numArr != null && numArr.length != 0 && a.this.aFN != null && a.this.aFN.get() != null) {
                ((InterfaceC0061a) a.this.aFN.get()).a(numArr[0].intValue(), a.this.aFQ);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aFO != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                a.this.aFO.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aFP = null;
            a.this.aFR.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aFP = null;
            if (a.this.aFO != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aFO.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0061a<T> interfaceC0061a) {
        this.aFN = new WeakReference<>(interfaceC0061a);
    }

    public void a(c cVar) {
        this.aFO = cVar;
    }

    public void setGroupId(String str) {
        this.aFR.setGroupId(str);
    }

    public T EB() {
        return this.aFQ;
    }

    public void A(T t) {
        this.aFQ = t;
    }

    public void EC() {
        LocalViewSize.ImageSize ve = LocalViewSize.vc().ve();
        LocalViewSize.ImageSize vf = LocalViewSize.vc().vf();
        h(vf.width, vf.height, ve.width, ve.height);
    }
}
