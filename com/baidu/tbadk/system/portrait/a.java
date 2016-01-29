package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aCH = changeSystemPhotoActivity;
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
            if (this.aCH.aCF == null) {
                this.aCH.aCF = new com.baidu.tbadk.core.view.b(this.aCH.getPageContext());
                this.aCH.aCF.wN();
            } else {
                this.aCH.aCF.show();
            }
            z = this.aCH.aCE;
            if (z) {
                this.aCH.aCC = aVar;
                aVar2 = this.aCH.aCB;
                if (aVar2 != null) {
                    aVar4 = this.aCH.aCB;
                    aVar4.cancel();
                }
                this.aCH.aCB = new ChangeSystemPhotoActivity.a(this.aCH, null);
                aVar3 = this.aCH.aCB;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap mS = aVar.mS();
            if (mS != null) {
                b = this.aCH.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, mS);
                if (!b) {
                    if (this.aCH.aCF != null) {
                        this.aCH.aCF.aw(false);
                        return;
                    }
                    return;
                }
                if (this.aCH.aCF != null) {
                    this.aCH.aCF.aw(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aCH.setResult(-1, intent);
                this.aCH.finish();
            } else if (this.aCH.aCF != null) {
                this.aCH.aCF.aw(false);
            }
        }
    }
}
