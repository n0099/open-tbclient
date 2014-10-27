package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ GroupSettingItemData bbB;
    final /* synthetic */ z bby;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bby = zVar;
        this.bbB = groupSettingItemData;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        this.bby.KC().b(this.fR, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bbB));
        return null;
    }
}
