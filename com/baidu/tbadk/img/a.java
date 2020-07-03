package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private final f exN;
    private int exO;
    private String mPath;
    public T progessObject;
    private WeakReference<InterfaceC0497a<T>> mUploadProgressCallback = null;
    private c exL = null;
    private a<T>.b exM = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0497a<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public void nN(int i) {
        this.exO = i;
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.exN = new f(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.exN.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.exM == null) {
            this.exM = new b();
            this.exM.setIsNeedAddWater(z);
            this.exM.nN(this.exO);
            this.exM.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private int exO;
        private boolean isNeedAddWater;

        private b() {
            this.isNeedAddWater = false;
        }

        public void nN(int i) {
            this.exO = i;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ImageUploadResult doInBackground(String... strArr) {
            return bgA();
        }

        private ImageUploadResult bgA() {
            a.this.exN.a(this, null);
            a.this.exN.nN(this.exO);
            ImageUploadResult ao = a.this.exN.ao(a.this.mPath, this.isNeedAddWater);
            publishProgress(100);
            return ao;
        }

        @Override // com.baidu.tbadk.img.f.a
        public void onImageDataSentInBackground(String str, Object obj, long j, long j2) {
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
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.mUploadProgressCallback != null && a.this.mUploadProgressCallback.get() != null) {
                ((InterfaceC0497a) a.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), a.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.exL != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.exL.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.exM = null;
            a.this.exN.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.exM = null;
            if (a.this.exL != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(-1002, imageUploadResult.error_msg, "");
                }
                a.this.exL.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0497a<T> interfaceC0497a) {
        this.mUploadProgressCallback = new WeakReference<>(interfaceC0497a);
    }

    public void a(c cVar) {
        this.exL = cVar;
    }

    public void setGroupId(String str) {
        this.exN.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize aWs = LocalViewSize.aWr().aWs();
        LocalViewSize.ImageSize aWt = LocalViewSize.aWr().aWt();
        setServersideResize(aWt.width, aWt.height, aWs.width, aWs.height);
    }
}
