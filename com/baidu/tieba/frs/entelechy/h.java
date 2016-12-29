package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bDX = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        String str;
        String str2;
        FrsActivity frsActivity2;
        if (view != null && (view.getTag() instanceof com.baidu.tbadk.core.data.y)) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bDX.bzH;
                com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                return;
            }
            com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) view.getTag();
            if (yVar != null && !StringUtils.isNull(yVar.Ql)) {
                String str3 = yVar.Ql;
                frsActivity = this.bDX.bzH;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(frsActivity.getPageContext().getPageActivity(), str3)));
                str = this.bDX.fid;
                if (!StringUtils.isNull(str)) {
                    at atVar = new at("c11394");
                    str2 = this.bDX.fid;
                    TiebaStatic.log(atVar.ab("fid", str2));
                }
            }
        }
    }
}
