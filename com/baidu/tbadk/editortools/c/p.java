package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ad.a {
    final /* synthetic */ n asv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.asv = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.asv.arQ = writeData.getContent();
            n nVar = this.asv;
            str = this.asv.arQ;
            nVar.fg(str);
        }
    }
}
