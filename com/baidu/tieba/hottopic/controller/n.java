package com.baidu.tieba.hottopic.controller;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ k bDq;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bDq = kVar;
        this.bam = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.adp.lib.util.a.aC(this.bam.linkUrl);
        tbPageContext = this.bDq.context;
        com.baidu.adp.lib.util.k.showToast(((HotTopicActivity) tbPageContext.getOrignalPage()).getPageContext().getPageActivity(), view.getResources().getString(n.i.copy_pb_url_success));
    }
}
