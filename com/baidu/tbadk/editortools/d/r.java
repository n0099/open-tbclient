package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements af.a {
    final /* synthetic */ p atE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.atE = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.atE.asU = writeData.getContent();
            p pVar = this.atE;
            str = this.atE.asU;
            pVar.fI(str);
        }
    }
}
