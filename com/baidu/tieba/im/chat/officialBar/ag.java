package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(OfficialBarInfoActivity officialBarInfoActivity) {
        this.a = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        am amVar;
        if (bool != null) {
            this.a.f = bool.booleanValue();
            amVar = this.a.e;
            amVar.a(bool.booleanValue());
        }
    }
}
