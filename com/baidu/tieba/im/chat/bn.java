package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class bn implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        bv bvVar;
        bv bvVar2;
        Boolean bool2 = bool;
        if (bool2 == null || !bool2.equals(true)) {
            bvVar = this.a.a;
            bvVar.t().b();
            return;
        }
        bvVar2 = this.a.a;
        bvVar2.t().a();
    }
}
