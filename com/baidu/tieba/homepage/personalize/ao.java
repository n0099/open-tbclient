package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.util.h<String> {
    private final /* synthetic */ w cJz;
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(x xVar, w wVar) {
        this.this$0 = xVar;
        this.cJz = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    /* renamed from: kT */
    public void onReturnDataInUI(String str) {
        if (this.cJz != null) {
            this.cJz.ko(com.baidu.adp.lib.g.b.g(str, 0));
        }
    }
}
