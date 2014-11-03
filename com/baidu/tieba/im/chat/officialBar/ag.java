package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ OfficialBarInfoActivity aRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(OfficialBarInfoActivity officialBarInfoActivity) {
        this.aRJ = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        am amVar;
        if (bool != null) {
            this.aRJ.aRI = bool.booleanValue();
            amVar = this.aRJ.aRH;
            amVar.cH(bool.booleanValue());
        }
    }
}
