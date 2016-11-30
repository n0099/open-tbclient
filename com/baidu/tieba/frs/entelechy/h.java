package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bYj = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        String str;
        String str2;
        FrsActivity frsActivity2;
        if (view != null && (view.getTag() instanceof z)) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bYj.bTA;
                com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                return;
            }
            z zVar = (z) view.getTag();
            if (zVar != null && !StringUtils.isNull(zVar.Qo)) {
                String str3 = zVar.Qo;
                frsActivity = this.bYj.bTA;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(frsActivity.getPageContext().getPageActivity(), str3)));
                str = this.bYj.fid;
                if (!StringUtils.isNull(str)) {
                    av avVar = new av("c11394");
                    str2 = this.bYj.fid;
                    TiebaStatic.log(avVar.ab("fid", str2));
                }
            }
        }
    }
}
