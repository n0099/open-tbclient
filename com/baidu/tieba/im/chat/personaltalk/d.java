package com.baidu.tieba.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ c aSA;
    private final /* synthetic */ PersonalSettingItemData aSB;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.aSA = cVar;
        this.aSB = personalSettingItemData;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        this.aSA.KG().b(this.fR, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.aSB));
        return null;
    }
}
