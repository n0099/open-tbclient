package com.baidu.tieba.enterForum.home;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements t.b {
    final /* synthetic */ k aXF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.aXF = kVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        com.baidu.tieba.enterForum.c.c cVar;
        String str;
        cVar = this.aXF.aXl;
        str = this.aXF.aXn;
        cVar.cu(!StringUtils.isNull(str));
    }
}
