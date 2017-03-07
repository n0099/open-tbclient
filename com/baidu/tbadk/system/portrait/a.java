package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIs = changeSystemPhotoActivity;
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
            if (this.aIs.aIq == null) {
                this.aIs.aIq = new com.baidu.tbadk.core.view.a(this.aIs.getPageContext());
                this.aIs.aIq.c(null);
            }
            this.aIs.aIq.aI(true);
            z = this.aIs.aIp;
            if (z) {
                this.aIs.aIn = aVar;
                aVar2 = this.aIs.aIm;
                if (aVar2 != null) {
                    aVar4 = this.aIs.aIm;
                    aVar4.cancel();
                }
                this.aIs.aIm = new ChangeSystemPhotoActivity.a(this.aIs, null);
                aVar3 = this.aIs.aIm;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap kN = aVar.kN();
            if (kN != null) {
                c = this.aIs.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kN);
                if (!c) {
                    if (this.aIs.aIq != null) {
                        this.aIs.aIq.aI(false);
                        return;
                    }
                    return;
                }
                if (this.aIs.aIq != null) {
                    this.aIs.aIq.aI(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aIs.setResult(-1, intent);
                this.aIs.finish();
            } else if (this.aIs.aIq != null) {
                this.aIs.aIq.aI(false);
            }
        }
    }
}
