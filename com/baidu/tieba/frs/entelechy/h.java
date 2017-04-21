package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bTI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bTI = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        String str;
        String str2;
        FrsActivity frsActivity2;
        if (view != null && (view.getTag() instanceof aa)) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bTI.bQw;
                com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), w.l.book_plugin_not_install_tip);
                return;
            }
            aa aaVar = (aa) view.getTag();
            if (aaVar != null && !StringUtils.isNull(aaVar.UT)) {
                String str3 = aaVar.UT;
                frsActivity = this.bTI.bQw;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(frsActivity.getPageContext().getPageActivity(), str3)));
                str = this.bTI.fid;
                if (!StringUtils.isNull(str)) {
                    as asVar = new as("c11394");
                    str2 = this.bTI.fid;
                    TiebaStatic.log(asVar.aa("fid", str2));
                }
            }
        }
    }
}
