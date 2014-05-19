package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        BdLog.d("img load finish");
        if (aVar != null) {
            BdLog.d("img load suceess");
            headImageView = this.a.d;
            aVar.a(headImageView);
        }
    }
}
