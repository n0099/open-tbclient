package com.baidu.tieba.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.view.g;
/* loaded from: classes.dex */
public class a implements g {
    protected TbPageContext mF;
    protected int ceS = 1;
    protected int userType = 2;
    protected boolean bwa = false;

    public a(TbPageContext tbPageContext) {
        this.mF = tbPageContext;
    }

    @Override // com.baidu.tieba.view.g
    public void a(View view, b bVar) {
        if (bVar != null) {
            UserData userData = null;
            if (bVar.ceU != null && (userData = (UserData) bVar.ceU.getSerializable(UserData.TYPE_USER)) != null) {
                this.ceS = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
                this.bwa = this.ceS == 1;
            }
            switch (bVar.ceT) {
                case 2:
                    if (ax.aU(this.mF.getPageActivity()) && bVar.ceU != null) {
                        au.wd().c(this.mF, new String[]{bVar.ceU.getString("vip_user_jump")});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.a.a(this.mF.getPageActivity(), this.mF.getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (bVar instanceof com.baidu.tieba.personCenter.c.a) {
                            TiebaStatic.log(new ak("c11586"));
                        } else {
                            TiebaStatic.log(new ak("c11597").r("obj_locate", 2).r("obj_type", this.ceS).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mF.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.j.a.bij().b(2, false, this.bwa);
                    if (userData != null) {
                        TiebaStatic.log(new ak("c11597").r("obj_locate", 3).r("obj_type", this.ceS).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mF.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new ak("c11597").r("obj_locate", 1).r("obj_type", this.ceS).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mF.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new ak("c11597").r("obj_locate", 4).r("obj_type", this.ceS).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mF.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
