package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bh implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bp bpVar;
        bp bpVar2;
        if (bool == null || !bool.equals(true)) {
            bpVar = this.a.a;
            bpVar.r().d();
            this.a.f = false;
            return;
        }
        bpVar2 = this.a.a;
        bpVar2.r().c();
        this.a.f = true;
    }
}
