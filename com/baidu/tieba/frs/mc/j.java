package com.baidu.tieba.frs.mc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.util.v<Object> {
    final /* synthetic */ FrsModelController cey;
    private final /* synthetic */ String cez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsModelController frsModelController, String str) {
        this.cey = frsModelController;
        this.cez = str;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String str;
        com.baidu.tieba.tbadkCore.c bgf = com.baidu.tieba.tbadkCore.c.bgf();
        str = this.cey.cev;
        bgf.bW(str, this.cez);
        return null;
    }
}
