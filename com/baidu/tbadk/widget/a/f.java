package com.baidu.tbadk.widget.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.aDZ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        String str3 = (String) view.getTag(n.g.tag_forum_name);
        String valueOf = String.valueOf(view.getTag(n.g.tag_forum_id));
        if (ax.aR(str3)) {
            str = this.aDZ.aDU;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aDZ.aDU;
                TiebaStatic.log(new av(str2).aa(ImageViewerConfig.FORUM_ID, valueOf));
            }
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.aDZ.mTbPageContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str3, this.aDZ.getFrom())));
        }
    }
}
