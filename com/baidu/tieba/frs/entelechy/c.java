package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b bJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bJU = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        String str;
        String str2;
        FrsActivity frsActivity2;
        if (view != null && (view.getTag() instanceof u)) {
            if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bJU.bGh;
                com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), u.j.book_plugin_not_install_tip);
                return;
            }
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) view.getTag();
            if (uVar != null && !StringUtils.isNull(uVar.NA)) {
                String str3 = uVar.NA;
                frsActivity = this.bJU.bGh;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(frsActivity.getPageContext().getPageActivity(), str3)));
                str = this.bJU.aMb;
                if (!StringUtils.isNull(str)) {
                    ay ayVar = new ay("c11394");
                    str2 = this.bJU.aMb;
                    TiebaStatic.log(ayVar.ab("fid", str2));
                }
            }
        }
    }
}
