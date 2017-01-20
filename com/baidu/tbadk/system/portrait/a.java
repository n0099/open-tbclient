package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCV = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean c;
        ChangeSystemPhotoActivity.a aVar2;
        ChangeSystemPhotoActivity.a aVar3;
        ChangeSystemPhotoActivity.a aVar4;
        super.onLoaded((a) aVar, str, i);
        if (aVar != null) {
            if (this.aCV.aCT == null) {
                this.aCV.aCT = new com.baidu.tbadk.core.view.a(this.aCV.getPageContext());
                this.aCV.aCT.c(null);
            }
            this.aCV.aCT.aJ(true);
            z = this.aCV.aCS;
            if (z) {
                this.aCV.aCQ = aVar;
                aVar2 = this.aCV.aCP;
                if (aVar2 != null) {
                    aVar4 = this.aCV.aCP;
                    aVar4.cancel();
                }
                this.aCV.aCP = new ChangeSystemPhotoActivity.a(this.aCV, null);
                aVar3 = this.aCV.aCP;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap jT = aVar.jT();
            if (jT != null) {
                c = this.aCV.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, jT);
                if (!c) {
                    if (this.aCV.aCT != null) {
                        this.aCV.aCT.aJ(false);
                        return;
                    }
                    return;
                }
                if (this.aCV.aCT != null) {
                    this.aCV.aCT.aJ(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aCV.setResult(-1, intent);
                this.aCV.finish();
            } else if (this.aCV.aCT != null) {
                this.aCV.aCT.aJ(false);
            }
        }
    }
}
