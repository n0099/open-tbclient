package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.FileHelper;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class LocalPicModel extends BdBaseModel implements Serializable {
    public static final long serialVersionUID = -339604626740227228L;
    public String mDName;
    public String mDPath;
    public GetImageTask mImageTask;
    public String mSName;
    public String mSPath;

    /* loaded from: classes4.dex */
    public class GetImageTask extends BdAsyncTask<Object, Integer, ResponseData> {
        public GetImageTask() {
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            LocalPicModel.this.mImageTask = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public ResponseData doInBackground(Object... objArr) {
            String str = "im_" + String.valueOf(System.currentTimeMillis());
            String renameTo = FileHelper.renameTo(LocalPicModel.this.mSPath, LocalPicModel.this.mSName, TiebaIMConfig.POST_IMAGE_PATH, str + "_send");
            String str2 = str + "_display";
            String renameTo2 = FileHelper.renameTo(LocalPicModel.this.mDPath, LocalPicModel.this.mDName, TiebaIMConfig.POST_IMAGE_PATH, str2);
            Bitmap image = FileHelper.getImage(TiebaIMConfig.POST_IMAGE_PATH, str2);
            if (renameTo == null || renameTo2 == null || image == null) {
                return null;
            }
            return new ResponseData(image, renameTo, renameTo2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(ResponseData responseData) {
            super.onPostExecute((GetImageTask) responseData);
            LocalPicModel.this.mImageTask = null;
            if (LocalPicModel.this.mLoadDataCallBack != null) {
                LocalPicModel.this.mLoadDataCallBack.c(responseData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ResponseData implements Serializable {
        public static final long serialVersionUID = -9099542245580007084L;
        public Bitmap mBitmap;
        public String mDPathGen;
        public String mSPathGen;

        public ResponseData(Bitmap bitmap, String str, String str2) {
            this.mBitmap = null;
            this.mSPathGen = null;
            this.mDPathGen = null;
            this.mBitmap = bitmap;
            this.mSPathGen = str;
            this.mDPathGen = str2;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getDPathGen() {
            return this.mDPathGen;
        }

        public String getSPathGen() {
            return this.mSPathGen;
        }
    }

    public LocalPicModel(String str, String str2, String str3, String str4) {
        super(null);
        this.mImageTask = null;
        this.mSPath = null;
        this.mSName = null;
        this.mDPath = null;
        this.mDName = null;
        this.mSPath = str;
        this.mSName = str2;
        this.mDPath = str3;
        this.mDName = str4;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        GetImageTask getImageTask = this.mImageTask;
        if (getImageTask != null) {
            getImageTask.cancel();
            return true;
        }
        return true;
    }

    public boolean getData() {
        if (this.mImageTask != null) {
            return false;
        }
        GetImageTask getImageTask = new GetImageTask();
        this.mImageTask = getImageTask;
        getImageTask.setSelfExecute(true);
        this.mImageTask.execute(new Object[0]);
        return true;
    }
}
