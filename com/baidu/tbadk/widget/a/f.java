package com.baidu.tbadk.widget.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.aGk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        String str3 = (String) view.getTag(t.g.tag_forum_name);
        String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
        if (ay.aS(str3)) {
            str = this.aGk.aGf;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aGk.aGf;
                TiebaStatic.log(new aw(str2).ac("fid", valueOf));
            }
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.aGk.mTbPageContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str3, this.aGk.getFrom())));
        }
    }
}
