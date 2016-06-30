package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements af.a {
    final /* synthetic */ p asP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.asP = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.asP.asf = writeData.getContent();
            p pVar = this.asP;
            str = this.asP.asf;
            pVar.fK(str);
        }
    }
}
