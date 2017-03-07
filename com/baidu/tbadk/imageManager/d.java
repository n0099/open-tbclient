package com.baidu.tbadk.imageManager;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> {
    final /* synthetic */ c aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.aCI = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    /* renamed from: a */
    public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
        if (aVar != null) {
            aVar.kM();
        }
    }
}
