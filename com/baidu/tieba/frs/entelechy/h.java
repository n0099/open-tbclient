package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bVi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bVi = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        String str;
        String str2;
        FrsActivity frsActivity2;
        if (view != null && (view.getTag() instanceof com.baidu.tbadk.core.data.v)) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                frsActivity2 = this.bVi.bRp;
                com.baidu.adp.lib.util.k.showToast(frsActivity2.getPageContext().getPageActivity(), t.j.book_plugin_not_install_tip);
                return;
            }
            com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) view.getTag();
            if (vVar != null && !StringUtils.isNull(vVar.PY)) {
                String str3 = vVar.PY;
                frsActivity = this.bVi.bRp;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(frsActivity.getPageContext().getPageActivity(), str3)));
                str = this.bVi.aRv;
                if (!StringUtils.isNull(str)) {
                    ay ayVar = new ay("c11394");
                    str2 = this.bVi.aRv;
                    TiebaStatic.log(ayVar.ab("fid", str2));
                }
            }
        }
    }
}
