package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0050a<T>> asJ = null;
    private c asK = null;
    private a<T>.b asL = null;
    public T asM;
    private final com.baidu.tbadk.img.c asN;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.asN = new com.baidu.tbadk.img.c(str2);
    }

    public void i(int i, int i2, int i3, int i4) {
        this.asN.i(i, i2, i3, i4);
    }

    public void BX() {
        if (this.asL == null) {
            this.asL = new b(this, null);
            this.asL.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ca();
        }

        private ImageUploadResult Ca() {
            a.this.asN.a(this, null);
            ImageUploadResult fr = a.this.asN.fr(a.this.mPath);
            publishProgress(100);
            return fr;
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
            if (numArr != null && numArr.length != 0 && a.this.asJ != null && a.this.asJ.get() != null) {
                ((InterfaceC0050a) a.this.asJ.get()).b(numArr[0].intValue(), a.this.asM);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.asK != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.send_error);
                a.this.asK.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.asL = null;
            a.this.asN.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.asL = null;
            if (a.this.asK != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.h.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.asK.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0050a<T> interfaceC0050a) {
        this.asJ = new WeakReference<>(interfaceC0050a);
    }

    public void a(c cVar) {
        this.asK = cVar;
    }

    public void setGroupId(String str) {
        this.asN.setGroupId(str);
    }

    public T BY() {
        return this.asM;
    }

    public void y(T t) {
        this.asM = t;
    }

    public void BZ() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.ub().getMsgSPicMaxSize();
        LocalViewSize.ImageSize ud = LocalViewSize.ub().ud();
        i(ud.width, ud.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
