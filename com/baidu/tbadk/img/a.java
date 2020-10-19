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
    private final f fdJ;
    private int fdK;
    private String mPath;
    public T progessObject;
    private WeakReference<InterfaceC0568a<T>> mUploadProgressCallback = null;
    private c fdH = null;
    private a<T>.b fdI = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0568a<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public void rf(int i) {
        this.fdK = i;
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.fdJ = new f(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.fdJ.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.fdI == null) {
            this.fdI = new b();
            this.fdI.setIsNeedAddWater(z);
            this.fdI.rf(this.fdK);
            this.fdI.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private int fdK;
        private boolean isNeedAddWater;

        private b() {
            this.isNeedAddWater = false;
        }

        public void rf(int i) {
            this.fdK = i;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public ImageUploadResult doInBackground(String... strArr) {
            return bwM();
        }

        private ImageUploadResult bwM() {
            a.this.fdJ.a(this, null);
            a.this.fdJ.rf(this.fdK);
            ImageUploadResult av = a.this.fdJ.av(a.this.mPath, this.isNeedAddWater);
            publishProgress(100);
            return av;
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
                ((InterfaceC0568a) a.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), a.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.fdH != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.fdH.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.fdI = null;
            a.this.fdJ.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.fdI = null;
            if (a.this.fdH != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(-1002, imageUploadResult.error_msg, "");
                }
                a.this.fdH.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0568a<T> interfaceC0568a) {
        this.mUploadProgressCallback = new WeakReference<>(interfaceC0568a);
    }

    public void a(c cVar) {
        this.fdH = cVar;
    }

    public void setGroupId(String str) {
        this.fdJ.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize bms = LocalViewSize.bmr().bms();
        LocalViewSize.ImageSize bmt = LocalViewSize.bmr().bmt();
        setServersideResize(bmt.width, bmt.height, bms.width, bms.height);
    }
}
