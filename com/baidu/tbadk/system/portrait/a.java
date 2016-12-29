package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEf = changeSystemPhotoActivity;
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
            if (this.aEf.aEd == null) {
                this.aEf.aEd = new com.baidu.tbadk.core.view.a(this.aEf.getPageContext());
                this.aEf.aEd.c(null);
            }
            this.aEf.aEd.aJ(true);
            z = this.aEf.aEc;
            if (z) {
                this.aEf.aEa = aVar;
                aVar2 = this.aEf.aDZ;
                if (aVar2 != null) {
                    aVar4 = this.aEf.aDZ;
                    aVar4.cancel();
                }
                this.aEf.aDZ = new ChangeSystemPhotoActivity.a(this.aEf, null);
                aVar3 = this.aEf.aDZ;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap jV = aVar.jV();
            if (jV != null) {
                c = this.aEf.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, jV);
                if (!c) {
                    if (this.aEf.aEd != null) {
                        this.aEf.aEd.aJ(false);
                        return;
                    }
                    return;
                }
                if (this.aEf.aEd != null) {
                    this.aEf.aEd.aJ(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aEf.setResult(-1, intent);
                this.aEf.finish();
            } else if (this.aEf.aEd != null) {
                this.aEf.aEd.aJ(false);
            }
        }
    }
}
