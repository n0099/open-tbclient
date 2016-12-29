package com.baidu.tbadk.editortools.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ac.a {
    final /* synthetic */ p awE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.awE = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.awE.avV = writeData.getContent();
            p pVar = this.awE;
            str = this.awE.avV;
            pVar.fO(str);
        }
    }
}
