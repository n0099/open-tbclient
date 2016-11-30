package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEM = changeSystemPhotoActivity;
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
            if (this.aEM.aEK == null) {
                this.aEM.aEK = new com.baidu.tbadk.core.view.a(this.aEM.getPageContext());
                this.aEM.aEK.c(null);
            }
            this.aEM.aEK.aI(true);
            z = this.aEM.aEJ;
            if (z) {
                this.aEM.aEH = aVar;
                aVar2 = this.aEM.aEG;
                if (aVar2 != null) {
                    aVar4 = this.aEM.aEG;
                    aVar4.cancel();
                }
                this.aEM.aEG = new ChangeSystemPhotoActivity.a(this.aEM, null);
                aVar3 = this.aEM.aEG;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap jV = aVar.jV();
            if (jV != null) {
                c = this.aEM.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, jV);
                if (!c) {
                    if (this.aEM.aEK != null) {
                        this.aEM.aEK.aI(false);
                        return;
                    }
                    return;
                }
                if (this.aEM.aEK != null) {
                    this.aEM.aEK.aI(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aEM.setResult(-1, intent);
                this.aEM.finish();
            } else if (this.aEM.aEK != null) {
                this.aEM.aEK.aI(false);
            }
        }
    }
}
