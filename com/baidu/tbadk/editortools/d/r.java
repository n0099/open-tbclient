package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ad.a {
    final /* synthetic */ p awa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.awa = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.awa.avq = writeData.getContent();
            p pVar = this.awa;
            str = this.awa.avq;
            pVar.fH(str);
        }
    }
}
