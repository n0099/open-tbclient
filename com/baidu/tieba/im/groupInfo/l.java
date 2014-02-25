package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ca;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ k a;
    private final /* synthetic */ ca b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, ca caVar) {
        this.a = kVar;
        this.b = caVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        GroupInfoActivity groupInfoActivity;
        m mVar;
        GroupInfoActivity groupInfoActivity2;
        com.baidu.tieba.im.model.e eVar;
        if (bool == null) {
            bool = false;
        }
        groupInfoActivity = this.a.a;
        mVar = groupInfoActivity.f;
        mVar.a(this.b, bool.booleanValue());
        groupInfoActivity2 = this.a.a;
        eVar = groupInfoActivity2.g;
        eVar.a(bool.booleanValue() ? false : true);
    }
}
