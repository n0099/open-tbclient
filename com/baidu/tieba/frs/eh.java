package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eh implements View.OnClickListener {
    final /* synthetic */ ee bqs;
    private final /* synthetic */ com.baidu.tbadk.core.data.ai bqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(ee eeVar, com.baidu.tbadk.core.data.ai aiVar) {
        this.bqs = eeVar;
        this.bqu = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ai aiVar = (com.baidu.tbadk.core.data.ai) view.getTag(t.g.tag_first);
        int intValue = ((Integer) view.getTag(t.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bqs.bix;
        context = this.bqs.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bqu.sB(), intValue, this.bqu.sx(), "", "", true, aiVar.sB().get(this.bqu.sB().size() - 1), true)));
    }
}
