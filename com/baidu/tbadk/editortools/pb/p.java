package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements aa.a {
    final /* synthetic */ n avI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.avI = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.avI.ava = writeData.getContent();
            n nVar = this.avI;
            str = this.avI.ava;
            nVar.fL(str);
        }
    }
}
