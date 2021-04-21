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
    public a f13551e;

    /* renamed from: f  reason: collision with root package name */
    public String f13552f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f13553a;

        public a(String str) {
            this.f13553a = null;
            this.f13553a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            String str = this.f13553a;
            if (str != null && !str.equals(TbConfig.IMAGE_RESIZED_FILE)) {
                FileHelper.CopyFile("photos/" + this.f13553a, TbConfig.IMAGE_RESIZED_FILE);
            }
            return BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getSquareBitmap(FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageModel.this.f13551e = null;
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
            ImageModel.this.f13551e = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.c(bitmap);
            }
        }
    }

    public ImageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f13551e = null;
        this.f13552f = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        a aVar = this.f13551e;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(this.f13552f);
        this.f13551e = aVar2;
        aVar2.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f13551e;
        if (aVar != null) {
            aVar.cancel();
            return true;
        }
        return true;
    }

    public boolean x(String str) {
        this.f13552f = str;
        return LoadData();
    }
}
