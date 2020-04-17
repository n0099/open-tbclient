package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.im.data.c;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes13.dex */
public class ResponseOfficialBarMenuMessage extends TbSocketReponsedMessage {
    public static final String OFFICIAL_BAR_MENU_KEY_PRE = "official_bar_menu_";
    private c officialBarMenuDatas;

    public ResponseOfficialBarMenuMessage() {
        super(CmdConfigSocket.CMD_OFFICIAL_BAR_MENU);
    }

    public c getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
        setError(forumMenuResIdl.error.errorno.intValue());
        setErrorString(forumMenuResIdl.error.usermsg);
        if (getError() == 0) {
            this.officialBarMenuDatas = new c();
            if (forumMenuResIdl.data != null) {
                getOfficialBarMenuDatas().setUpdate_time(forumMenuResIdl.data.update_time.intValue());
                getOfficialBarMenuDatas().wR(forumMenuResIdl.data.has_menu.intValue());
                getOfficialBarMenuDatas().da(new ArrayList());
                int size = forumMenuResIdl.data.parent_menu.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                    Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                    bVar.wQ(menu.action_type.intValue());
                    bVar.setContent(menu.content);
                    bVar.setCreate_time(menu.create_time.intValue());
                    bVar.setForum_id(menu.forum_id + "");
                    bVar.setId(menu.id + "");
                    bVar.setLevel(menu.level.intValue());
                    bVar.setName(menu.name);
                    bVar.cZ(new ArrayList());
                    if (menu.sub_menu != null) {
                        int size2 = menu.sub_menu.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            SubMenu subMenu = menu.sub_menu.get(i3);
                            com.baidu.tieba.im.data.b bVar2 = new com.baidu.tieba.im.data.b();
                            bVar2.wQ(subMenu.action_type.intValue());
                            bVar2.setContent(subMenu.content);
                            bVar2.setForum_id(subMenu.forum_id + "");
                            bVar2.setId(subMenu.id + "");
                            bVar2.setLevel(subMenu.level.intValue());
                            bVar2.setName(subMenu.name);
                            bVar2.wP(subMenu.parent_id.intValue());
                            bVar2.setUpdate_time(subMenu.update_time.intValue());
                            bVar.ceY().add(bVar2);
                        }
                    }
                    getOfficialBarMenuDatas().cfa().add(bVar);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        c officialBarMenuDatas;
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestOfficialBarMenuMessage) && getError() == 0 && (officialBarMenuDatas = getOfficialBarMenuDatas()) != null && officialBarMenuDatas.ceZ() && officialBarMenuDatas.cfa() != null && officialBarMenuDatas.cfa().size() > 0) {
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.c.a.aMT().uc("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id(), bArr);
        }
    }
}
