package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aBr = changeSystemPhotoActivity;
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
            if (this.aBr.aBp == null) {
                this.aBr.aBp = new com.baidu.tbadk.core.view.b(this.aBr.getPageContext());
                this.aBr.aBp.c(null);
            }
            this.aBr.aBp.aE(true);
            z = this.aBr.aBo;
            if (z) {
                this.aBr.aBm = aVar;
                aVar2 = this.aBr.aBl;
                if (aVar2 != null) {
                    aVar4 = this.aBr.aBl;
                    aVar4.cancel();
                }
                this.aBr.aBl = new ChangeSystemPhotoActivity.a(this.aBr, null);
                aVar3 = this.aBr.aBl;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap ja = aVar.ja();
            if (ja != null) {
                c = this.aBr.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, ja);
                if (!c) {
                    if (this.aBr.aBp != null) {
                        this.aBr.aBp.aE(false);
                        return;
                    }
                    return;
                }
                if (this.aBr.aBp != null) {
                    this.aBr.aBp.aE(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aBr.setResult(-1, intent);
                this.aBr.finish();
            } else if (this.aBr.aBp != null) {
                this.aBr.aBp.aE(false);
            }
        }
    }
}
