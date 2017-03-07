package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements z.a {
    final /* synthetic */ n aBd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.aBd = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.aBd.aAv = writeData.getContent();
            n nVar = this.aBd;
            str = this.aBd.aAv;
            nVar.fA(str);
        }
    }
}
