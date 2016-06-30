package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAB = changeSystemPhotoActivity;
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
            if (this.aAB.aAz == null) {
                this.aAB.aAz = new com.baidu.tbadk.core.view.b(this.aAB.getPageContext());
                this.aAB.aAz.c(null);
            }
            this.aAB.aAz.aB(true);
            z = this.aAB.aAy;
            if (z) {
                this.aAB.aAw = aVar;
                aVar2 = this.aAB.aAv;
                if (aVar2 != null) {
                    aVar4 = this.aAB.aAv;
                    aVar4.cancel();
                }
                this.aAB.aAv = new ChangeSystemPhotoActivity.a(this.aAB, null);
                aVar3 = this.aAB.aAv;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap jb = aVar.jb();
            if (jb != null) {
                b = this.aAB.b(TbConfig.PERSON_USER_PIC_TEMP_FILE, jb);
                if (!b) {
                    if (this.aAB.aAz != null) {
                        this.aAB.aAz.aB(false);
                        return;
                    }
                    return;
                }
                if (this.aAB.aAz != null) {
                    this.aAB.aAz.aB(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aAB.setResult(-1, intent);
                this.aAB.finish();
            } else if (this.aAB.aAz != null) {
                this.aAB.aAz.aB(false);
            }
        }
    }
}
