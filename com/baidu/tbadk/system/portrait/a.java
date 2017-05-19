package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIN = changeSystemPhotoActivity;
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
            if (this.aIN.aIL == null) {
                this.aIN.aIL = new com.baidu.tbadk.core.view.a(this.aIN.getPageContext());
                this.aIN.aIL.c(null);
            }
            this.aIN.aIL.aI(true);
            z = this.aIN.aIK;
            if (z) {
                this.aIN.aII = aVar;
                aVar2 = this.aIN.aIH;
                if (aVar2 != null) {
                    aVar4 = this.aIN.aIH;
                    aVar4.cancel();
                }
                this.aIN.aIH = new ChangeSystemPhotoActivity.a(this.aIN, null);
                aVar3 = this.aIN.aIH;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap kR = aVar.kR();
            if (kR != null) {
                c = this.aIN.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kR);
                if (!c) {
                    if (this.aIN.aIL != null) {
                        this.aIN.aIL.aI(false);
                        return;
                    }
                    return;
                }
                if (this.aIN.aIL != null) {
                    this.aIN.aIL.aI(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aIN.setResult(-1, intent);
                this.aIN.finish();
            } else if (this.aIN.aIL != null) {
                this.aIN.aIL.aI(false);
            }
        }
    }
}
