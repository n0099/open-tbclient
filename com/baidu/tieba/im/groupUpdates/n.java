package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.c<Boolean> {
    private final /* synthetic */ UpdatesItemData a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(UpdatesItemData updatesItemData) {
        this.a = updatesItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().c(this.a.getNotice_id()));
    }
}
