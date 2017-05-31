package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements x.a {
    final /* synthetic */ n aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.aBg = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        String str;
        if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
            this.aBg.aAx = writeData.getContent();
            n nVar = this.aBg;
            str = this.aBg.aAx;
            nVar.fB(str);
        }
    }
}
