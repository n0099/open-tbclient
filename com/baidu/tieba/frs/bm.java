package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnClickListener {
    final /* synthetic */ bj bUR;
    private final /* synthetic */ com.baidu.tbadk.core.data.az bUT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar, com.baidu.tbadk.core.data.az azVar) {
        this.bUR = bjVar;
        this.bUT = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.az azVar = (com.baidu.tbadk.core.data.az) view.getTag(r.g.tag_first);
        int intValue = ((Integer) view.getTag(r.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bUR.aTb;
        context = this.bUR.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bUT.qT(), intValue, this.bUT.qP(), "", "", true, azVar.qT().get(this.bUT.qT().size() - 1), true)));
    }
}
