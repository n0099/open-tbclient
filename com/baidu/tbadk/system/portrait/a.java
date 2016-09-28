package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDW = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        boolean z;
        boolean c;
        ChangeSystemPhotoActivity.a aVar2;
        ChangeSystemPhotoActivity.a aVar3;
        ChangeSystemPhotoActivity.a aVar4;
        super.a((a) aVar, str, i);
        if (aVar != null) {
            if (this.aDW.aDU == null) {
                this.aDW.aDU = new com.baidu.tbadk.core.view.a(this.aDW.getPageContext());
                this.aDW.aDU.c(null);
            }
            this.aDW.aDU.aF(true);
            z = this.aDW.aDT;
            if (z) {
                this.aDW.aDR = aVar;
                aVar2 = this.aDW.aDQ;
                if (aVar2 != null) {
                    aVar4 = this.aDW.aDQ;
                    aVar4.cancel();
                }
                this.aDW.aDQ = new ChangeSystemPhotoActivity.a(this.aDW, null);
                aVar3 = this.aDW.aDQ;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap jV = aVar.jV();
            if (jV != null) {
                c = this.aDW.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, jV);
                if (!c) {
                    if (this.aDW.aDU != null) {
                        this.aDW.aDU.aF(false);
                        return;
                    }
                    return;
                }
                if (this.aDW.aDU != null) {
                    this.aDW.aDU.aF(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aDW.setResult(-1, intent);
                this.aDW.finish();
            } else if (this.aDW.aDU != null) {
                this.aDW.aDU.aF(false);
            }
        }
    }
}
