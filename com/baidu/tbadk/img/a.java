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
    private WeakReference<InterfaceC0058a<T>> aGu = null;
    private c aGv = null;
    private a<T>.b aGw = null;
    public T aGx;
    private final d aGy;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aGy = new d(str2);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aGy.j(i, i2, i3, i4);
    }

    public void bP(boolean z) {
        if (this.aGw == null) {
            this.aGw = new b();
            this.aGw.bQ(z);
            this.aGw.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements d.a {
        private boolean aGz;

        private b() {
            this.aGz = false;
        }

        protected void bQ(boolean z) {
            this.aGz = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EF();
        }

        private ImageUploadResult EF() {
            a.this.aGy.a(this, null);
            ImageUploadResult s = a.this.aGy.s(a.this.mPath, this.aGz);
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
            if (numArr != null && numArr.length != 0 && a.this.aGu != null && a.this.aGu.get() != null) {
                ((InterfaceC0058a) a.this.aGu.get()).b(numArr[0].intValue(), a.this.aGx);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aGv != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                a.this.aGv.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aGw = null;
            a.this.aGy.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aGw = null;
            if (a.this.aGv != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aGv.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0058a<T> interfaceC0058a) {
        this.aGu = new WeakReference<>(interfaceC0058a);
    }

    public void a(c cVar) {
        this.aGv = cVar;
    }

    public void setGroupId(String str) {
        this.aGy.setGroupId(str);
    }

    public T ED() {
        return this.aGx;
    }

    public void B(T t) {
        this.aGx = t;
    }

    public void EE() {
        LocalViewSize.ImageSize vg = LocalViewSize.ve().vg();
        LocalViewSize.ImageSize vh = LocalViewSize.ve().vh();
        j(vh.width, vh.height, vg.width, vg.height);
    }
}
