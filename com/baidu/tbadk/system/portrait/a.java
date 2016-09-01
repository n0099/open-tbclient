package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aEy = changeSystemPhotoActivity;
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
            if (this.aEy.aEw == null) {
                this.aEy.aEw = new com.baidu.tbadk.core.view.a(this.aEy.getPageContext());
                this.aEy.aEw.c(null);
            }
            this.aEy.aEw.aF(true);
            z = this.aEy.aEv;
            if (z) {
                this.aEy.aEt = aVar;
                aVar2 = this.aEy.aEs;
                if (aVar2 != null) {
                    aVar4 = this.aEy.aEs;
                    aVar4.cancel();
                }
                this.aEy.aEs = new ChangeSystemPhotoActivity.a(this.aEy, null);
                aVar3 = this.aEy.aEs;
                aVar3.execute(new String[0]);
                return;
            }
            Bitmap jV = aVar.jV();
            if (jV != null) {
                c = this.aEy.c(TbConfig.PERSON_USER_PIC_TEMP_FILE, jV);
                if (!c) {
                    if (this.aEy.aEw != null) {
                        this.aEy.aEw.aF(false);
                        return;
                    }
                    return;
                }
                if (this.aEy.aEw != null) {
                    this.aEy.aEw.aF(false);
                }
                Intent intent = new Intent();
                intent.putExtra("upload_image_type", 2);
                this.aEy.setResult(-1, intent);
                this.aEy.finish();
            } else if (this.aEy.aEw != null) {
                this.aEy.aEw.aF(false);
            }
        }
    }
}
