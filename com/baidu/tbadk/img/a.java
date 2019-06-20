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
    private WeakReference<InterfaceC0254a<T>> cuU = null;
    private c cuV = null;
    private a<T>.b cuW = null;
    public T cuX;
    private final f cuY;
    private String wU;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0254a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.wU = null;
        this.wU = str;
        this.cuY = new f(str2);
    }

    public void l(int i, int i2, int i3, int i4) {
        this.cuY.l(i, i2, i3, i4);
    }

    public void fn(boolean z) {
        if (this.cuW == null) {
            this.cuW = new b();
            this.cuW.fo(z);
            this.cuW.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean cuZ;

        private b() {
            this.cuZ = false;
        }

        protected void fo(boolean z) {
            this.cuZ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return asx();
        }

        private ImageUploadResult asx() {
            a.this.cuY.a(this, null);
            ImageUploadResult R = a.this.cuY.R(a.this.wU, this.cuZ);
            publishProgress(100);
            return R;
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
            if (numArr != null && numArr.length != 0 && a.this.cuU != null && a.this.cuU.get() != null) {
                ((InterfaceC0254a) a.this.cuU.get()).d(numArr[0].intValue(), a.this.cuX);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.cuV != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.cuV.a(a.this.wU, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.cuW = null;
            a.this.cuY.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.cuW = null;
            if (a.this.cuV != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.cuV.a(a.this.wU, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0254a<T> interfaceC0254a) {
        this.cuU = new WeakReference<>(interfaceC0254a);
    }

    public void a(c cVar) {
        this.cuV = cVar;
    }

    public void setGroupId(String str) {
        this.cuY.setGroupId(str);
    }

    public T asv() {
        return this.cuX;
    }

    public void ac(T t) {
        this.cuX = t;
    }

    public void asw() {
        LocalViewSize.ImageSize ahx = LocalViewSize.ahv().ahx();
        LocalViewSize.ImageSize ahy = LocalViewSize.ahv().ahy();
        l(ahy.width, ahy.height, ahx.width, ahx.height);
    }
}
