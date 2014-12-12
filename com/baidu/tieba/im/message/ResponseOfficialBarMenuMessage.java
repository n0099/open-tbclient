package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes.dex */
public class ResponseOfficialBarMenuMessage extends TbSocketReponsedMessage {
    public static final String OFFICIAL_BAR_MENU_KEY_PRE = "official_bar_menu_";
    private com.baidu.tieba.im.data.d officialBarMenuDatas;

    public ResponseOfficialBarMenuMessage() {
        super(303006);
    }

    public com.baidu.tieba.im.data.d getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0096: IGET  (r3v0 java.lang.Integer A[REMOVE]) = (r1v18 tbclient.ForumMenu.Menu) tbclient.ForumMenu.Menu.forum_id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00a8: IGET  (r3v1 java.lang.Integer A[REMOVE]) = (r1v18 tbclient.ForumMenu.Menu) tbclient.ForumMenu.Menu.id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0107: IGET  (r11v0 java.lang.Integer A[REMOVE]) = (r2v28 tbclient.ForumMenu.SubMenu) tbclient.ForumMenu.SubMenu.forum_id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0119: IGET  (r11v1 java.lang.Integer A[REMOVE]) = (r2v28 tbclient.ForumMenu.SubMenu) tbclient.ForumMenu.SubMenu.id java.lang.Integer)] */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
        setError(forumMenuResIdl.error.errorno.intValue());
        setErrorString(forumMenuResIdl.error.usermsg);
        if (getError() == 0) {
            this.officialBarMenuDatas = new com.baidu.tieba.im.data.d();
            if (forumMenuResIdl.data != null) {
                getOfficialBarMenuDatas().T(forumMenuResIdl.data.update_time.intValue());
                getOfficialBarMenuDatas().fC(forumMenuResIdl.data.has_menu.intValue());
                getOfficialBarMenuDatas().am(new ArrayList());
                int size = forumMenuResIdl.data.parent_menu.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.im.data.c cVar = new com.baidu.tieba.im.data.c();
                    Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                    cVar.fB(menu.action_type.intValue());
                    cVar.setContent(menu.content);
                    cVar.setCreate_time(menu.create_time.intValue());
                    cVar.setForum_id(new StringBuilder().append(menu.forum_id).toString());
                    cVar.setId(new StringBuilder().append(menu.id).toString());
                    cVar.setLevel(menu.level.intValue());
                    cVar.setName(menu.name);
                    cVar.al(new ArrayList());
                    if (menu.sub_menu != null) {
                        int size2 = menu.sub_menu.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            SubMenu subMenu = menu.sub_menu.get(i3);
                            com.baidu.tieba.im.data.c cVar2 = new com.baidu.tieba.im.data.c();
                            cVar2.fB(subMenu.action_type.intValue());
                            cVar2.setContent(subMenu.content);
                            cVar2.setForum_id(new StringBuilder().append(subMenu.forum_id).toString());
                            cVar2.setId(new StringBuilder().append(subMenu.id).toString());
                            cVar2.setLevel(subMenu.level.intValue());
                            cVar2.setName(subMenu.name);
                            cVar2.fA(subMenu.parent_id.intValue());
                            cVar2.T(subMenu.update_time.intValue());
                            cVar.Mm().add(cVar2);
                        }
                    }
                    getOfficialBarMenuDatas().Mp().add(cVar);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.tieba.im.data.d officialBarMenuDatas;
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestOfficialBarMenuMessage) && getError() == 0 && (officialBarMenuDatas = getOfficialBarMenuDatas()) != null && officialBarMenuDatas.Mn() && officialBarMenuDatas.Mp() != null && officialBarMenuDatas.Mp().size() > 0) {
            saveProtocolBufferDataToCache(com.baidu.tbadk.core.a.a.nS().bU("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id(), bArr);
        }
    }
}
