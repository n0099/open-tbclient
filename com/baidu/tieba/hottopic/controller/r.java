package com.baidu.tieba.hottopic.controller;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ k bDq;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.j bDr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar, com.baidu.tieba.hottopic.view.j jVar) {
        this.bDq = kVar;
        this.bDr = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        tbPageContext = this.bDq.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bDr.getChatMsgView().getWindowToken(), 2);
        aVar.dismiss();
    }
}
