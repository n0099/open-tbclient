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
public class cm implements View.OnClickListener {
    final /* synthetic */ cj aYj;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cj cjVar, com.baidu.tbadk.core.data.q qVar) {
        this.aYj = cjVar;
        this.aYl = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) view.getTag(i.f.tag_first);
        int intValue = ((Integer) view.getTag(i.f.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.aYj.aSJ;
        context = this.aYj.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.aYl.sb(), intValue, this.aYl.rX(), "", "", true, qVar.sb().get(this.aYl.sb().size() - 1), true)));
    }
}
