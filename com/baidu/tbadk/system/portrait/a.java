package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayf = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        ChangeSystemPhotoActivity.a aVar2;
        ChangeSystemPhotoActivity.a aVar3;
        ChangeSystemPhotoActivity.a aVar4;
        super.a((a) aVar, str, i);
        if (aVar != null) {
            this.ayf.ayb = aVar;
            aVar2 = this.ayf.aya;
            if (aVar2 != null) {
                aVar4 = this.ayf.aya;
                aVar4.cancel();
            }
            this.ayf.aya = new ChangeSystemPhotoActivity.a(this.ayf, null);
            aVar3 = this.ayf.aya;
            aVar3.execute(new String[0]);
        }
    }
}
