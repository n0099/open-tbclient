package com.baidu.tieba.hottopic.controller;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.b {
    final /* synthetic */ o bKu;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.r bKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar, com.baidu.tieba.hottopic.view.r rVar) {
        this.bKu = oVar;
        this.bKv = rVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        tbPageContext = this.bKu.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bKv.getChatMsgView().getWindowToken(), 2);
        aVar.dismiss();
    }
}
