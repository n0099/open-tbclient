package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class aq implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        az azVar;
        az azVar2;
        Boolean bool2 = bool;
        if (bool2 == null || !bool2.equals(true)) {
            azVar = this.a.a;
            azVar.t().b();
            return;
        }
        azVar2 = this.a.a;
        azVar2.t().a();
    }
}
