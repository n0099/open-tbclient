package com.baidu.tieba.homepage.personalize;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.util.g<String> {
    private final /* synthetic */ a ctC;
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(b bVar, a aVar) {
        this.ctz = bVar;
        this.ctC = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: kf */
    public void onReturnDataInUI(String str) {
        if (this.ctC != null) {
            this.ctC.jm(com.baidu.adp.lib.h.b.g(str, 0));
        }
    }
}
