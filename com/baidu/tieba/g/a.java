package com.baidu.tieba.g;

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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class a implements m {
    protected TbPageContext FY;
    protected int bzX = 1;
    protected int userType = 2;

    public a(TbPageContext tbPageContext) {
        this.FY = tbPageContext;
    }

    @Override // com.baidu.tieba.view.m
    public void a(View view, b bVar) {
        if (bVar != null) {
            UserData userData = null;
            if (bVar.bzZ != null && (userData = (UserData) bVar.bzZ.getSerializable(UserData.TYPE_USER)) != null) {
                this.bzX = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
            }
            switch (bVar.bzY) {
                case 2:
                    if (bf.ak(this.FY.getPageActivity()) && bVar.bzZ != null) {
                        ba.vt().c(this.FY, new String[]{bVar.bzZ.getString("vip_user_jump")});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.f.a(this.FY.getPageActivity(), this.FY.getString(r.l.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (bVar instanceof com.baidu.tieba.personCenter.d.a) {
                            TiebaStatic.log(new ar("c11586"));
                        } else {
                            TiebaStatic.log(new ar("c11597").s("obj_locate", 2).s("obj_type", this.bzX).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.FY.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.h.a.bap().D(2, false);
                    if (userData != null) {
                        TiebaStatic.log(new ar("c11597").s("obj_locate", 3).s("obj_type", this.bzX).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.FY.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new ar("c11597").s("obj_locate", 1).s("obj_type", this.bzX).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.FY.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new ar("c11597").s("obj_locate", 4).s("obj_type", this.bzX).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.FY.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    public void hy(int i) {
        BdToast.b(this.FY.getPageActivity(), String.format(this.FY.getPageActivity().getString(r.l.person_privacy_toast), at.cW(i)), r.g.icon_toast_game_error).td();
    }
}
