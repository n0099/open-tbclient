package com.baidu.tieba.hottopic.controller;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ k bGU;
    private final /* synthetic */ com.baidu.tieba.hottopic.view.j bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar, com.baidu.tieba.hottopic.view.j jVar) {
        this.bGU = kVar;
        this.bGV = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TbPageContext tbPageContext;
        tbPageContext = this.bGU.context;
        ((InputMethodManager) ((HotTopicActivity) tbPageContext.getOrignalPage()).getSystemService("input_method")).hideSoftInputFromWindow(this.bGV.getChatMsgView().getWindowToken(), 2);
        aVar.dismiss();
    }
}
