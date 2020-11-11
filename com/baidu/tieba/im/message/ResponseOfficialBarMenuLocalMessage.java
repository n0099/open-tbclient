package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.data.c;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes26.dex */
public class ResponseOfficialBarMenuLocalMessage extends CustomResponsedMessage<Object> {
    private c officialBarMenuDatas;

    public ResponseOfficialBarMenuLocalMessage() {
        super(CmdConfigCustom.CMD_OFFICIAL_BAR_MENU_LOCAL);
    }

    public c getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    public void setOfficialBarMenuDatas(c cVar) {
        this.officialBarMenuDatas = cVar;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        if (bArr != null) {
            ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
            setError(forumMenuResIdl.error.errorno.intValue());
            setErrorString(forumMenuResIdl.error.usermsg);
            if (getError() == 0) {
                setOfficialBarMenuDatas(new c());
                if (forumMenuResIdl.data != null) {
                    getOfficialBarMenuDatas().setUpdate_time(forumMenuResIdl.data.update_time.intValue());
                    getOfficialBarMenuDatas().CL(forumMenuResIdl.data.has_menu.intValue());
                    getOfficialBarMenuDatas().ec(new ArrayList());
                    int size = forumMenuResIdl.data.parent_menu.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                        Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                        bVar.CK(menu.action_type.intValue());
                        bVar.setContent(menu.content);
                        bVar.setCreate_time(menu.create_time.intValue());
                        bVar.setForum_id(menu.forum_id + "");
                        bVar.setId(menu.id + "");
                        bVar.setLevel(menu.level.intValue());
                        bVar.setName(menu.name);
                        bVar.eb(new ArrayList());
                        if (menu.sub_menu != null) {
                            int size2 = menu.sub_menu.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                SubMenu subMenu = menu.sub_menu.get(i3);
                                com.baidu.tieba.im.data.b bVar2 = new com.baidu.tieba.im.data.b();
                                bVar2.CK(subMenu.action_type.intValue());
                                bVar2.setContent(subMenu.content);
                                bVar2.setForum_id(subMenu.forum_id + "");
                                bVar2.setId(subMenu.id + "");
                                bVar2.setLevel(subMenu.level.intValue());
                                bVar2.setName(subMenu.name);
                                bVar2.CJ(subMenu.parent_id.intValue());
                                bVar2.setUpdate_time(subMenu.update_time.intValue());
                                bVar.cQN().add(bVar2);
                            }
                        }
                        getOfficialBarMenuDatas().cQP().add(bVar);
                    }
                }
            }
        }
    }
}
