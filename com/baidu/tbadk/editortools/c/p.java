package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ac.a {
    final /* synthetic */ n aso;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.aso = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.aso.arJ = writeData.getContent();
            n nVar = this.aso;
            str = this.aso.arJ;
            nVar.eT(str);
        }
    }
}
