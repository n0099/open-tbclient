package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarInfoActivity aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(OfficialBarInfoActivity officialBarInfoActivity) {
        this.aRv = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        am amVar;
        if (bool != null) {
            this.aRv.aRu = bool.booleanValue();
            amVar = this.aRv.aRt;
            amVar.cH(bool.booleanValue());
        }
    }
}
