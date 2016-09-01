package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ a cFh;
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(b bVar, a aVar) {
        this.this$0 = bVar;
        this.cFh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kN */
    public void onReturnDataInUI(String str) {
        if (this.cFh != null) {
            this.cFh.jO(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
