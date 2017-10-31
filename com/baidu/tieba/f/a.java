package com.baidu.tieba.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.view.h;
/* loaded from: classes.dex */
public class a implements h {
    protected TbPageContext mPageContext;
    protected int cma = 1;
    protected int userType = 2;
    protected boolean isHost = false;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.view.h
    public void a(View view, b bVar) {
        if (bVar != null) {
            UserData userData = null;
            if (bVar.cmc != null && (userData = (UserData) bVar.cmc.getSerializable(UserData.TYPE_USER)) != null) {
                this.cma = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
                this.isHost = this.cma == 1;
            }
            switch (bVar.cmb) {
                case 2:
                    if (ax.aT(this.mPageContext.getPageActivity())) {
                        av.vI().c(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (bVar instanceof com.baidu.tieba.personCenter.c.a) {
                            TiebaStatic.log(new ak("c11586"));
                        } else {
                            TiebaStatic.log(new ak("c11597").r("obj_locate", 2).r("obj_type", this.cma).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.j.a.bjW().c(2, false, this.isHost);
                    if (userData != null) {
                        TiebaStatic.log(new ak("c11597").r("obj_locate", 3).r("obj_type", this.cma).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new ak("c11597").r("obj_locate", 1).r("obj_type", this.cma).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new ak("c11597").r("obj_locate", 4).r("obj_type", this.cma).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
