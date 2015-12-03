package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAk = changeSystemPhotoActivity;
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
            if (this.aAk.aAi == null) {
                this.aAk.aAi = new com.baidu.tbadk.core.view.b(this.aAk.getPageContext());
                this.aAk.aAi.vW();
            } else {
                this.aAk.aAi.show();
            }
            z = this.aAk.aAh;
            if (z) {
                this.aAk.aAf = aVar;
                aVar2 = this.aAk.aAe;
                if (aVar2 != null) {
                    aVar4 = this.aAk.aAe;
                    aVar4.cancel();
                }
                this.aAk.aAe = new ChangeSystemPhotoActivity.a(this.aAk, null);
                aVar3 = this.aAk.aAe;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap ng = aVar.ng();
            if (ng != null) {
                b = this.aAk.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, ng);
                if (!b) {
                    if (this.aAk.aAi != null) {
                        this.aAk.aAi.ay(false);
                        return;
                    }
                    return;
                }
                if (this.aAk.aAi != null) {
                    this.aAk.aAi.ay(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aAk.setResult(-1, intent);
                this.aAk.finish();
            } else if (this.aAk.aAi != null) {
                this.aAk.aAi.ay(false);
            }
        }
    }
}
