package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class r implements ar {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bh bhVar) {
        String str;
        if (i != this.bGL.bFF.YH().ZW()) {
            if (i != this.bGL.bFF.YH().ZX()) {
                if (i != this.bGL.bFF.YH().ZZ()) {
                    if (i != this.bGL.bFF.YH().YZ()) {
                        if (i != this.bGL.bFF.YH().aaa()) {
                            if (i == this.bGL.bFF.YH().ZY() && this.bGL.bFG != null && this.bGL.bFG.getUserData() != null && this.bGL.bFG.getUserData().isBawu()) {
                                String bgf = this.bGL.bFG.bgf();
                                if (!com.baidu.tbadk.core.util.at.isEmpty(bgf) && this.bGL.bFG.aJY() != null) {
                                    a.a(this.bGL.getPageContext(), this.bGL.bFG.aJY().getId(), this.bGL.bFG.aJY().getName(), new s(this, bgf));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c10417");
                        this.bGL.bFG.bgM();
                        this.bGL.bFF.YB();
                        b.tQ().putLong("frs_storecard_closetime", System.currentTimeMillis());
                        return;
                    }
                    this.bGL.bFv = bhVar;
                    com.baidu.tieba.frs.utils.t.b(this.bGL, this.bGL.bFv);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10179").ab("fid", this.bGL.getForumId()));
                    return;
                }
                com.baidu.tieba.frs.utils.t.E(this.bGL);
                if (i == this.bGL.bFF.YH().ZZ()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).ab("fid", this.bGL.getForumId()));
            } else if (this.bGL.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bGL.bFG != null && this.bGL.bFG.aJY() != null) {
                    ForumData aJY = this.bGL.bFG.aJY();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bGL.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aJY.getId(), 0L), aJY.getName(), aJY.getImage_url(), 0)));
                }
            }
        } else if (this.bGL.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            com.baidu.tieba.frs.utils.t.b(this.bGL, this.bGL.bFG);
        }
    }
}
