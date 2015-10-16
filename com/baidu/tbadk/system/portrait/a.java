package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity azr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.azr = changeSystemPhotoActivity;
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
            this.azr.azn = aVar;
            aVar2 = this.azr.azm;
            if (aVar2 != null) {
                aVar4 = this.azr.azm;
                aVar4.cancel();
            }
            this.azr.azm = new ChangeSystemPhotoActivity.a(this.azr, null);
            aVar3 = this.azr.azm;
            aVar3.execute(new String[0]);
        }
    }
}
