package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class bj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        br brVar;
        br brVar2;
        Boolean bool2 = bool;
        if (bool2 == null || !bool2.equals(true)) {
            brVar = this.a.a;
            brVar.t().b();
            return;
        }
        brVar2 = this.a.a;
        brVar2.t().a();
    }
}
