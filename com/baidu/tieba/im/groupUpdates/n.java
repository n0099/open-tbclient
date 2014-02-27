package com.baidu.tieba.im.groupUpdates;
/* loaded from: classes.dex */
final class n extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ UpdatesItemData a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(UpdatesItemData updatesItemData) {
        this.a = updatesItemData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().c(this.a.getNotice_id()));
    }
}
