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
    private final f eEf;
    private int eEg;
    private String mPath;
    public T progessObject;
    private WeakReference<InterfaceC0509a<T>> mUploadProgressCallback = null;
    private c eEd = null;
    private a<T>.b eEe = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0509a<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public void of(int i) {
        this.eEg = i;
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.eEf = new f(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.eEf.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.eEe == null) {
            this.eEe = new b();
            this.eEe.setIsNeedAddWater(z);
            this.eEe.of(this.eEg);
            this.eEe.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private int eEg;
        private boolean isNeedAddWater;

        private b() {
            this.isNeedAddWater = false;
        }

        public void of(int i) {
            this.eEg = i;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public ImageUploadResult doInBackground(String... strArr) {
            return bkl();
        }

        private ImageUploadResult bkl() {
            a.this.eEf.a(this, null);
            a.this.eEf.of(this.eEg);
            ImageUploadResult an = a.this.eEf.an(a.this.mPath, this.isNeedAddWater);
            publishProgress(100);
            return an;
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
                ((InterfaceC0509a) a.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), a.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.eEd != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.eEd.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.eEe = null;
            a.this.eEf.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.eEe = null;
            if (a.this.eEd != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(-1002, imageUploadResult.error_msg, "");
                }
                a.this.eEd.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0509a<T> interfaceC0509a) {
        this.mUploadProgressCallback = new WeakReference<>(interfaceC0509a);
    }

    public void a(c cVar) {
        this.eEd = cVar;
    }

    public void setGroupId(String str) {
        this.eEf.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize bat = LocalViewSize.bas().bat();
        LocalViewSize.ImageSize bau = LocalViewSize.bas().bau();
        setServersideResize(bau.width, bau.height, bat.width, bat.height);
    }
}
