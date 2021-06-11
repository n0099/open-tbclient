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
    public a f12852e;

    /* renamed from: f  reason: collision with root package name */
    public String f12853f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public String f12854a;

        public a(String str) {
            this.f12854a = null;
            this.f12854a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            String str = this.f12854a;
            if (str != null && !str.equals(TbConfig.IMAGE_RESIZED_FILE)) {
                FileHelper.CopyFile("photos/" + this.f12854a, TbConfig.IMAGE_RESIZED_FILE);
            }
            return BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getSquareBitmap(FileHelper.getImage(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageModel.this.f12852e = null;
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
            ImageModel.this.f12852e = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.c(bitmap);
            }
        }
    }

    public ImageModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f12852e = null;
        this.f12853f = null;
    }

    public boolean B(String str) {
        this.f12853f = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        a aVar = this.f12852e;
        if (aVar != null) {
            aVar.cancel();
        }
        a aVar2 = new a(this.f12853f);
        this.f12852e = aVar2;
        aVar2.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        a aVar = this.f12852e;
        if (aVar != null) {
            aVar.cancel();
            return true;
        }
        return true;
    }
}
