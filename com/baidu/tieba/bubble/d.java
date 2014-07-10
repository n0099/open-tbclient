package com.baidu.tieba.bubble;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d implements s {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.bubble.s
    public void a(int i) {
        com.baidu.tieba.model.d dVar;
        dVar = this.a.c;
        dVar.b(i);
        TbWebViewActivity.startActivityForResult(this.a, TbadkApplication.m252getInst().getString(y.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeantshow?_client_version=" + TbConfig.getVersion(), true, false, true, true, null, 23004);
    }

    @Override // com.baidu.tieba.bubble.s
    public void a() {
    }
}
