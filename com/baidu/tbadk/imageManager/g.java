package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class g extends com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> {
    final /* synthetic */ e UQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.UQ = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    /* renamed from: d */
    public int sizeOf(String str, com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            return aVar.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.e.a
    /* renamed from: a */
    public void entryRemoved(boolean z, String str, com.baidu.adp.widget.a.a aVar, com.baidu.adp.widget.a.a aVar2) {
        if (aVar != null) {
            BdLog.isDebugMode();
            aVar.hk();
        }
    }
}
