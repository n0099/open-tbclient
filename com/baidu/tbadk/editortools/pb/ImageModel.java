package com.baidu.tbadk.editortools.pb;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.m;
/* loaded from: classes.dex */
public class ImageModel extends BdBaseModel {
    private a dYm;
    private String filename;

    public ImageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dYm = null;
        this.filename = null;
    }

    public boolean wx(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (this.dYm != null) {
            this.dYm.cancel();
        }
        this.dYm = new a(this.filename);
        this.dYm.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.dYm != null) {
            this.dYm.cancel();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private String filename;

        public a(String str) {
            this.filename = null;
            this.filename = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            if (this.filename != null && !this.filename.equals(TbConfig.IMAGE_RESIZED_FILE)) {
                m.cH("photos/" + this.filename, TbConfig.IMAGE_RESIZED_FILE);
            }
            return BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getSquareBitmap(m.getImage(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageModel.this.dYm = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.callback(null);
            }
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            ImageModel.this.dYm = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.callback(bitmap);
            }
        }
    }
}
