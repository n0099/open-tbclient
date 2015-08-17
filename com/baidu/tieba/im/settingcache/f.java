package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ c bDG;
    private final /* synthetic */ String tB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, String str) {
        this.bDG = cVar;
        this.tB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        this.bDG.Wu().remove(this.tB);
        return null;
    }
}
