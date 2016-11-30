package com.baidu.tieba.e;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
/* loaded from: classes.dex */
public class a implements m {
    protected TbPageContext GO;
    protected int bMi = 1;
    protected int userType = 2;

    public a(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
    }

    @Override // com.baidu.tieba.view.m
    public void a(View view, b bVar) {
        if (bVar != null) {
            UserData userData = null;
            if (bVar.bMk != null && (userData = (UserData) bVar.bMk.getSerializable(UserData.TYPE_USER)) != null) {
                this.bMi = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
            }
            switch (bVar.bMj) {
                case 2:
                    if (bk.ak(this.GO.getPageActivity()) && bVar.bMk != null) {
                        bf.vP().c(this.GO, new String[]{bVar.bMk.getString("vip_user_jump")});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.f.a(this.GO.getPageActivity(), this.GO.getString(r.j.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (bVar instanceof com.baidu.tieba.personCenter.d.a) {
                            TiebaStatic.log(new av("c11586"));
                        } else {
                            TiebaStatic.log(new av("c11597").s("obj_locate", 2).s("obj_type", this.bMi).s("obj_source", this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.GO.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.f.a.beM().R(2, false);
                    if (userData != null) {
                        TiebaStatic.log(new av("c11597").s("obj_locate", 3).s("obj_type", this.bMi).s("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.GO.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new av("c11597").s("obj_locate", 1).s("obj_type", this.bMi).s("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.GO.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new av("c11597").s("obj_locate", 4).s("obj_type", this.bMi).s("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.GO.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
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
    public void hC(int i) {
        BdToast.b(this.GO.getPageActivity(), String.format(this.GO.getPageActivity().getString(r.j.person_privacy_toast), ax.cU(i)), r.f.icon_toast_game_error).ty();
    }
}
