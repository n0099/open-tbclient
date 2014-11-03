package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.img.d {
    final /* synthetic */ d Ka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.Ka = dVar;
    }

    @Override // com.baidu.tbadk.img.d
    public void a(String str, ImageUploadResult imageUploadResult) {
        EditHeadActivity editHeadActivity;
        EditHeadActivity editHeadActivity2;
        EditHeadActivity editHeadActivity3;
        EditHeadActivity editHeadActivity4;
        EditHeadActivity editHeadActivity5;
        editHeadActivity = this.Ka.this$0;
        editHeadActivity.closeLoadingDialog();
        editHeadActivity2 = this.Ka.this$0;
        Intent intent = editHeadActivity2.getIntent();
        if (imageUploadResult != null) {
            if (imageUploadResult.error_code != 0) {
                editHeadActivity5 = this.Ka.this$0;
                editHeadActivity5.showToast(com.baidu.tieba.y.upload_pic_error, false);
            } else {
                PhotoUrlData photoUrlData = new PhotoUrlData();
                photoUrlData.setPicId(String.valueOf(imageUploadResult.picId));
                if (imageUploadResult.picInfo != null) {
                    if (imageUploadResult.picInfo.bigPic != null) {
                        photoUrlData.setBigurl(imageUploadResult.picInfo.bigPic.picUrl);
                    }
                    if (imageUploadResult.picInfo.smallPic != null) {
                        photoUrlData.setSmallurl(imageUploadResult.picInfo.smallPic.picUrl);
                    }
                }
                intent.putExtra(EditHeadActivity.Jw, String.valueOf(imageUploadResult.picId));
                intent.putExtra(EditHeadActivity.Jx, photoUrlData);
            }
        }
        editHeadActivity3 = this.Ka.this$0;
        editHeadActivity3.setResult(-1, intent);
        editHeadActivity4 = this.Ka.this$0;
        editHeadActivity4.finish();
    }
}
