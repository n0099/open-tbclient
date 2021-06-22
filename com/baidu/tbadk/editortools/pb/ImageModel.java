package com.baidu.tbadk.editortools.pb;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
/* loaded from: classes3.dex */
public class ImageModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f12934e;

    /* renamed from: f  reason: collision with root package name */
    public String f12935f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f12936a;

        public a(String str) {
            this.f12936a = null;
            this.f12936a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            String str = this.f12936a;
            if (str != null && !str.equals(TbConfig.IMAGE_RESIZED_FILE)) {
                FileHelper.CopyFile("photos/" + this.f12936a, TbConfig.IMAGE_RESIZED_FILE);
            }
            return BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getSquareBitmap(FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageModel.this.f12934e = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.c(null);
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            ImageModel.this.f12934e = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.c(bitmap);
            }
        }
    }

    public ImageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f12934e = null;
        this.f12935f = null;
    }

    public boolean B(String str) {
        this.f12935f = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        a aVar = this.f12934e;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(this.f12935f);
        this.f12934e = aVar2;
        aVar2.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f12934e;
        if (aVar != null) {
            aVar.cancel();
            return true;
        }
        return true;
    }
}
