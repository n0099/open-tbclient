package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity azJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azJ = changeSystemPhotoActivity;
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
            if (this.azJ.azH == null) {
                this.azJ.azH = new com.baidu.tbadk.core.view.b(this.azJ.getPageContext());
                this.azJ.azH.c(null);
            }
            this.azJ.azH.aD(true);
            z = this.azJ.azG;
            if (z) {
                this.azJ.azE = aVar;
                aVar2 = this.azJ.azD;
                if (aVar2 != null) {
                    aVar4 = this.azJ.azD;
                    aVar4.cancel();
                }
                this.azJ.azD = new ChangeSystemPhotoActivity.a(this.azJ, null);
                aVar3 = this.azJ.azD;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap iY = aVar.iY();
            if (iY != null) {
                b = this.azJ.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, iY);
                if (!b) {
                    if (this.azJ.azH != null) {
                        this.azJ.azH.aD(false);
                        return;
                    }
                    return;
                }
                if (this.azJ.azH != null) {
                    this.azJ.azH.aD(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.azJ.setResult(-1, intent);
                this.azJ.finish();
            } else if (this.azJ.azH != null) {
                this.azJ.azH.aD(false);
            }
        }
    }
}
