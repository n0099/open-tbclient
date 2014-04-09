package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends BdAsyncTask<Object, Integer, LocalPicModel.ResponseData> {
    final /* synthetic */ LocalPicModel a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ LocalPicModel.ResponseData a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "im_" + String.valueOf(System.currentTimeMillis());
        str = this.a.mSPath;
        str2 = this.a.mSName;
        String a = com.baidu.tbadk.core.util.w.a(str, str2, com.baidu.tbadk.coreExtra.d.x.c, String.valueOf(str5) + "_send");
        String str6 = String.valueOf(str5) + "_display";
        str3 = this.a.mDPath;
        str4 = this.a.mDName;
        String a2 = com.baidu.tbadk.core.util.w.a(str3, str4, com.baidu.tbadk.coreExtra.d.x.c, str6);
        Bitmap c = com.baidu.tbadk.core.util.w.c(com.baidu.tbadk.coreExtra.d.x.c, str6);
        if (a == null || a2 == null || c == null) {
            return null;
        }
        return new LocalPicModel.ResponseData(c, a, a2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(LocalPicModel.ResponseData responseData) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        LocalPicModel.ResponseData responseData2 = responseData;
        super.a((x) responseData2);
        this.a.mImageTask = null;
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(responseData2);
        }
    }

    private x(LocalPicModel localPicModel) {
        this.a = localPicModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(LocalPicModel localPicModel, byte b) {
        this(localPicModel);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.a.mImageTask = null;
    }
}
