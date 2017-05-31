package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aIA = changeSystemPhotoActivity;
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
            if (this.aIA.aIy == null) {
                this.aIA.aIy = new com.baidu.tbadk.core.view.a(this.aIA.getPageContext());
                this.aIA.aIy.c(null);
            }
            this.aIA.aIy.aH(true);
            z = this.aIA.aIx;
            if (z) {
                this.aIA.aIv = aVar;
                aVar2 = this.aIA.aIu;
                if (aVar2 != null) {
                    aVar4 = this.aIA.aIu;
                    aVar4.cancel();
                }
                this.aIA.aIu = new ChangeSystemPhotoActivity.a(this.aIA, null);
                aVar3 = this.aIA.aIu;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap kR = aVar.kR();
            if (kR != null) {
                c = this.aIA.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kR);
                if (!c) {
                    if (this.aIA.aIy != null) {
                        this.aIA.aIy.aH(false);
                        return;
                    }
                    return;
                }
                if (this.aIA.aIy != null) {
                    this.aIA.aIy.aH(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aIA.setResult(-1, intent);
                this.aIA.finish();
            } else if (this.aIA.aIy != null) {
                this.aIA.aIy.aH(false);
            }
        }
    }
}
