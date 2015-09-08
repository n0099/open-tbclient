package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYA;
    final /* synthetic */ cn aYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cn cnVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYy = cnVar;
        this.aYA = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.r rVar = (com.baidu.tbadk.core.data.r) view.getTag(i.f.tag_first);
        int intValue = ((Integer) view.getTag(i.f.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.aYy.aSX;
        context = this.aYy.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.aYA.rZ(), intValue, this.aYA.rV(), "", "", true, rVar.rZ().get(this.aYA.rZ().size() - 1), true)));
    }
}
