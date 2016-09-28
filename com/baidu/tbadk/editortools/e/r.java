package com.baidu.tbadk.editortools.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ae.a {
    final /* synthetic */ p awo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.awo = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.awo.avE = writeData.getContent();
            p pVar = this.awo;
            str = this.awo.avE;
            pVar.fP(str);
        }
    }
}
