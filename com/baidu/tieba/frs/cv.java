package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ cs aGO;
    private final /* synthetic */ com.baidu.tbadk.core.data.t aGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cs csVar, com.baidu.tbadk.core.data.t tVar) {
        this.aGO = csVar;
        this.aGP = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.t tVar = (com.baidu.tbadk.core.data.t) view.getTag(com.baidu.tieba.w.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.w.tag_second)).intValue();
        FrsActivity frsActivity = this.aGO.aEd;
        context = this.aGO.mContext;
        frsActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(this.aGP.nj(), intValue, this.aGP.nf(), "", "", true, tVar.nj().get(this.aGP.nj().size() - 1), true)));
    }
}
