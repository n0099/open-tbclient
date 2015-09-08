package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity aAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAF = changeSystemPhotoActivity;
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
            this.aAF.aAB = aVar;
            aVar2 = this.aAF.aAA;
            if (aVar2 != null) {
                aVar4 = this.aAF.aAA;
                aVar4.cancel();
            }
            this.aAF.aAA = new ChangeSystemPhotoActivity.a(this.aAF, null);
            aVar3 = this.aAF.aAA;
            aVar3.execute(new String[0]);
        }
    }
}
