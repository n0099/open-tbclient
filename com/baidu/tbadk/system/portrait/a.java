package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aBR = changeSystemPhotoActivity;
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
            if (this.aBR.aBP == null) {
                this.aBR.aBP = new com.baidu.tbadk.core.view.b(this.aBR.getPageContext());
                this.aBR.aBP.vG();
            } else {
                this.aBR.aBP.show();
            }
            z = this.aBR.aBO;
            if (z) {
                this.aBR.aBM = aVar;
                aVar2 = this.aBR.aBL;
                if (aVar2 != null) {
                    aVar4 = this.aBR.aBL;
                    aVar4.cancel();
                }
                this.aBR.aBL = new ChangeSystemPhotoActivity.a(this.aBR, null);
                aVar3 = this.aBR.aBL;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap mE = aVar.mE();
            if (mE != null) {
                b = this.aBR.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, mE);
                if (!b) {
                    if (this.aBR.aBP != null) {
                        this.aBR.aBP.av(false);
                        return;
                    }
                    return;
                }
                if (this.aBR.aBP != null) {
                    this.aBR.aBP.av(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aBR.setResult(-1, intent);
                this.aBR.finish();
            } else if (this.aBR.aBP != null) {
                this.aBR.aBP.av(false);
            }
        }
    }
}
