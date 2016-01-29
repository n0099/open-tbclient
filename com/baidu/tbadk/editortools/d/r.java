package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ad.a {
    final /* synthetic */ p avz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.avz = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.avz.auQ = writeData.getContent();
            p pVar = this.avz;
            str = this.avz.auQ;
            pVar.fz(str);
        }
    }
}
