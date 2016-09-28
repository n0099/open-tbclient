package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bVb = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        String str;
        String str2;
        FrsActivity frsActivity2;
        if (view != null && (view.getTag() instanceof com.baidu.tbadk.core.data.x)) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bVb.bRi;
                com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                return;
            }
            com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) view.getTag();
            if (xVar != null && !StringUtils.isNull(xVar.PW)) {
                String str3 = xVar.PW;
                frsActivity = this.bVb.bRi;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(frsActivity.getPageContext().getPageActivity(), str3)));
                str = this.bVb.fid;
                if (!StringUtils.isNull(str)) {
                    ax axVar = new ax("c11394");
                    str2 = this.bVb.fid;
                    TiebaStatic.log(axVar.ab("fid", str2));
                }
            }
        }
    }
}
