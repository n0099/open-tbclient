package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0114a<T>> aTK = null;
    private c aTL = null;
    private a<T>.b aTM = null;
    public T aTN;
    private final f aTO;
    private String yz;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0114a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.yz = null;
        this.yz = str;
        this.aTO = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aTO.h(i, i2, i3, i4);
    }

    public void bZ(boolean z) {
        if (this.aTM == null) {
            this.aTM = new b();
            this.aTM.ca(z);
            this.aTM.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aTP;

        private b() {
            this.aTP = false;
        }

        protected void ca(boolean z) {
            this.aTP = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ko();
        }

        private ImageUploadResult Ko() {
            a.this.aTO.a(this, null);
            ImageUploadResult n = a.this.aTO.n(a.this.yz, this.aTP);
            publishProgress(100);
            return n;
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
            if (numArr != null && numArr.length != 0 && a.this.aTK != null && a.this.aTK.get() != null) {
                ((InterfaceC0114a) a.this.aTK.get()).b(numArr[0].intValue(), a.this.aTN);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aTL != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                a.this.aTL.a(a.this.yz, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aTM = null;
            a.this.aTO.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aTM = null;
            if (a.this.aTL != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aTL.a(a.this.yz, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0114a<T> interfaceC0114a) {
        this.aTK = new WeakReference<>(interfaceC0114a);
    }

    public void a(c cVar) {
        this.aTL = cVar;
    }

    public void setGroupId(String str) {
        this.aTO.setGroupId(str);
    }

    public T Km() {
        return this.aTN;
    }

    public void E(T t) {
        this.aTN = t;
    }

    public void Kn() {
        LocalViewSize.ImageSize zM = LocalViewSize.zK().zM();
        LocalViewSize.ImageSize zN = LocalViewSize.zK().zN();
        h(zN.width, zN.height, zM.width, zM.height);
    }
}
