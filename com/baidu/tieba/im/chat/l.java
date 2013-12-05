package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupSettingActivity groupSettingActivity) {
        this.f1598a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        x xVar;
        x xVar2;
        if (bool == null || !bool.equals(true)) {
            xVar = this.f1598a.f1531a;
            xVar.u().b();
            return;
        }
        xVar2 = this.f1598a.f1531a;
        xVar2.u().a();
    }
}
