package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends p<Void> {
    final /* synthetic */ j cqo;
    private final /* synthetic */ PersonalSettingItemData cqp;
    private final /* synthetic */ String tU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.cqo = jVar;
        this.cqp = personalSettingItemData;
        this.tU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        this.cqo.aij().e(this.tU, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cqp));
        return null;
    }
}
