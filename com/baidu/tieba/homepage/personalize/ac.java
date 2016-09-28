package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ l cGg;
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(m mVar, l lVar) {
        this.this$0 = mVar;
        this.cGg = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kU */
    public void onReturnDataInUI(String str) {
        if (this.cGg != null) {
            this.cGg.jU(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
