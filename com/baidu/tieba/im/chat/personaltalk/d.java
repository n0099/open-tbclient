package com.baidu.tieba.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ c aSm;
    private final /* synthetic */ PersonalSettingItemData aSn;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.aSm = cVar;
        this.aSn = personalSettingItemData;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        this.aSm.KC().b(this.fR, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.aSn));
        return null;
    }
}
