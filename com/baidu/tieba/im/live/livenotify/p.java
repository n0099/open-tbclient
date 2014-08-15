package com.baidu.tieba.im.live.livenotify;

import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ UpdatesItemData a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(UpdatesItemData updatesItemData) {
        this.a = updatesItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.d.a().c(this.a.getNotice_id()));
    }
}
