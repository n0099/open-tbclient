package com.baidu.tieba.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.t;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class a implements m {
    protected TbPageContext GM;
    protected int bJo = 1;
    protected int userType = 2;

    public a(TbPageContext tbPageContext) {
        this.GM = tbPageContext;
    }

    @Override // com.baidu.tieba.view.m
    public void a(View view, b bVar) {
        if (bVar != null) {
            UserData userData = null;
            if (bVar.bJq != null && (userData = (UserData) bVar.bJq.getSerializable(UserData.TYPE_USER)) != null) {
                this.bJo = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGodUser ? 1 : 2;
            }
            switch (bVar.bJp) {
                case 2:
                    if (bn.al(this.GM.getPageActivity()) && bVar.bJq != null) {
                        bi.vx().c(this.GM, new String[]{bVar.bJq.getString("vip_user_jump")});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.f.a(this.GM.getPageActivity(), this.GM.getString(t.j.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (bVar instanceof com.baidu.tieba.personCenter.d.a) {
                            TiebaStatic.log(new ay("c11586"));
                        } else {
                            TiebaStatic.log(new ay("c11597").s("obj_locate", 2).s("obj_type", this.bJo).s("obj_source", this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.GM.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.g.a.bbB().O(2, false);
                    if (userData != null) {
                        TiebaStatic.log(new ay("c11597").s("obj_locate", 3).s("obj_type", this.bJo).s("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.GM.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new ay("c11597").s("obj_locate", 1).s("obj_type", this.bJo).s("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.GM.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new ay("c11597").s("obj_locate", 4).s("obj_type", this.bJo).s("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.GM.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [126=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    public void hx(int i) {
        BdToast.b(this.GM.getPageActivity(), String.format(this.GM.getPageActivity().getString(t.j.person_privacy_toast), ba.cT(i)), t.f.icon_toast_game_error).tf();
    }
}
