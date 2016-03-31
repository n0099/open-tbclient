package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDF = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean b;
        ChangeSystemPhotoActivity.a aVar2;
        ChangeSystemPhotoActivity.a aVar3;
        ChangeSystemPhotoActivity.a aVar4;
        super.a((a) aVar, str, i);
        if (aVar != null) {
            if (this.aDF.aDD == null) {
                this.aDF.aDD = new com.baidu.tbadk.core.view.b(this.aDF.getPageContext());
                this.aDF.aDD.c(null);
            }
            this.aDF.aDD.ay(true);
            z = this.aDF.aDC;
            if (z) {
                this.aDF.aDA = aVar;
                aVar2 = this.aDF.aDz;
                if (aVar2 != null) {
                    aVar4 = this.aDF.aDz;
                    aVar4.cancel();
                }
                this.aDF.aDz = new ChangeSystemPhotoActivity.a(this.aDF, null);
                aVar3 = this.aDF.aDz;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap mK = aVar.mK();
            if (mK != null) {
                b = this.aDF.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, mK);
                if (!b) {
                    if (this.aDF.aDD != null) {
                        this.aDF.aDD.ay(false);
                        return;
                    }
                    return;
                }
                if (this.aDF.aDD != null) {
                    this.aDF.aDD.ay(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aDF.setResult(-1, intent);
                this.aDF.finish();
            } else if (this.aDF.aDD != null) {
                this.aDF.aDD.ay(false);
            }
        }
    }
}
