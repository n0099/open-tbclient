package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aII = changeSystemPhotoActivity;
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
            if (this.aII.aIG == null) {
                this.aII.aIG = new com.baidu.tbadk.core.view.a(this.aII.getPageContext());
                this.aII.aIG.c(null);
            }
            this.aII.aIG.aK(true);
            z = this.aII.aIF;
            if (z) {
                this.aII.aID = aVar;
                aVar2 = this.aII.aIC;
                if (aVar2 != null) {
                    aVar4 = this.aII.aIC;
                    aVar4.cancel();
                }
                this.aII.aIC = new ChangeSystemPhotoActivity.a(this.aII, null);
                aVar3 = this.aII.aIC;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap kR = aVar.kR();
            if (kR != null) {
                c = this.aII.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, kR);
                if (!c) {
                    if (this.aII.aIG != null) {
                        this.aII.aIG.aK(false);
                        return;
                    }
                    return;
                }
                if (this.aII.aIG != null) {
                    this.aII.aIG.aK(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aII.setResult(-1, intent);
                this.aII.finish();
            } else if (this.aII.aIG != null) {
                this.aII.aIG.aK(false);
            }
        }
    }
}
