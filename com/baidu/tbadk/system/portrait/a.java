package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIK = changeSystemPhotoActivity;
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
            if (this.aIK.aII == null) {
                this.aIK.aII = new com.baidu.tbadk.core.view.a(this.aIK.getPageContext());
                this.aIK.aII.c(null);
            }
            this.aIK.aII.aK(true);
            z = this.aIK.aIH;
            if (z) {
                this.aIK.aIF = aVar;
                aVar2 = this.aIK.aIE;
                if (aVar2 != null) {
                    aVar4 = this.aIK.aIE;
                    aVar4.cancel();
                }
                this.aIK.aIE = new ChangeSystemPhotoActivity.a(this.aIK, null);
                aVar3 = this.aIK.aIE;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap kS = aVar.kS();
            if (kS != null) {
                c = this.aIK.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kS);
                if (!c) {
                    if (this.aIK.aII != null) {
                        this.aIK.aII.aK(false);
                        return;
                    }
                    return;
                }
                if (this.aIK.aII != null) {
                    this.aIK.aII.aK(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aIK.setResult(-1, intent);
                this.aIK.finish();
            } else if (this.aIK.aII != null) {
                this.aIK.aII.aK(false);
            }
        }
    }
}
