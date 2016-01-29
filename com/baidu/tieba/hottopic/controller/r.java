package com.baidu.tieba.hottopic.controller;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o bKu;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bKu = oVar;
        this.bgG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.adp.lib.util.a.aB(this.bgG.linkUrl);
        tbPageContext = this.bKu.context;
        com.baidu.adp.lib.util.k.showToast(((HotTopicActivity) tbPageContext.getOrignalPage()).getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
