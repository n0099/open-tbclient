package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aJP = changeSystemPhotoActivity;
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
            if (this.aJP.aJN == null) {
                this.aJP.aJN = new com.baidu.tbadk.core.view.a(this.aJP.getPageContext());
                this.aJP.aJN.c(null);
            }
            this.aJP.aJN.aI(true);
            z = this.aJP.aJM;
            if (z) {
                this.aJP.aJK = aVar;
                aVar2 = this.aJP.aJJ;
                if (aVar2 != null) {
                    aVar4 = this.aJP.aJJ;
                    aVar4.cancel();
                }
                this.aJP.aJJ = new ChangeSystemPhotoActivity.a(this.aJP, null);
                aVar3 = this.aJP.aJJ;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap kP = aVar.kP();
            if (kP != null) {
                c = this.aJP.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kP);
                if (!c) {
                    if (this.aJP.aJN != null) {
                        this.aJP.aJN.aI(false);
                        return;
                    }
                    return;
                }
                if (this.aJP.aJN != null) {
                    this.aJP.aJN.aI(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aJP.setResult(-1, intent);
                this.aJP.finish();
            } else if (this.aJP.aJN != null) {
                this.aJP.aJN.aI(false);
            }
        }
    }
}
