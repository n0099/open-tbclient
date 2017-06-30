package com.baidu.tieba.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.view.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a implements r {
    protected TbPageContext ajP;
    protected int bVc = 1;
    protected int userType = 2;

    public a(TbPageContext tbPageContext) {
        this.ajP = tbPageContext;
    }

    @Override // com.baidu.tieba.view.r
    public void a(View view, b bVar) {
        if (bVar != null) {
            UserData userData = null;
            if (bVar.bVe != null && (userData = (UserData) bVar.bVe.getSerializable(UserData.TYPE_USER)) != null) {
                this.bVc = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
            }
            switch (bVar.bVd) {
                case 2:
                    if (bl.aN(this.ajP.getPageActivity()) && bVar.bVe != null) {
                        be.vP().c(this.ajP, new String[]{bVar.bVe.getString("vip_user_jump")});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        g.a(this.ajP.getPageActivity(), this.ajP.getString(w.l.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (bVar instanceof com.baidu.tieba.personCenter.c.a) {
                            TiebaStatic.log(new au("c11586"));
                        } else {
                            TiebaStatic.log(new au("c11597").r("obj_locate", 2).r("obj_type", this.bVc).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.ajP.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.j.a.beN().C(2, false);
                    if (userData != null) {
                        TiebaStatic.log(new au("c11597").r("obj_locate", 3).r("obj_type", this.bVc).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.ajP.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new au("c11597").r("obj_locate", 1).r("obj_type", this.bVc).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.ajP.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new au("c11597").r("obj_locate", 4).r("obj_type", this.bVc).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.ajP.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
