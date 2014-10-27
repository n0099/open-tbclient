package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes.dex */
public class ResponseOfficialBarMenuLocalMessage extends CustomResponsedMessage<Object> {
    private com.baidu.tieba.im.data.g officialBarMenuDatas;

    public ResponseOfficialBarMenuLocalMessage() {
        super(2001181);
    }

    public com.baidu.tieba.im.data.g getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    public void setOfficialBarMenuDatas(com.baidu.tieba.im.data.g gVar) {
        this.officialBarMenuDatas = gVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0099: IGET  (r3v0 java.lang.Integer A[REMOVE]) = (r1v18 tbclient.ForumMenu.Menu) tbclient.ForumMenu.Menu.forum_id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00ab: IGET  (r3v1 java.lang.Integer A[REMOVE]) = (r1v18 tbclient.ForumMenu.Menu) tbclient.ForumMenu.Menu.id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x010a: IGET  (r11v0 java.lang.Integer A[REMOVE]) = (r2v28 tbclient.ForumMenu.SubMenu) tbclient.ForumMenu.SubMenu.forum_id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x011c: IGET  (r11v1 java.lang.Integer A[REMOVE]) = (r2v28 tbclient.ForumMenu.SubMenu) tbclient.ForumMenu.SubMenu.id java.lang.Integer)] */
    public void decodeInBackGround(int i, byte[] bArr) {
        if (bArr != null) {
            ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
            setError(forumMenuResIdl.error.errorno.intValue());
            setErrorString(forumMenuResIdl.error.usermsg);
            if (getError() == 0) {
                setOfficialBarMenuDatas(new com.baidu.tieba.im.data.g());
                if (forumMenuResIdl.data != null) {
                    getOfficialBarMenuDatas().M(forumMenuResIdl.data.update_time.intValue());
                    getOfficialBarMenuDatas().fz(forumMenuResIdl.data.has_menu.intValue());
                    getOfficialBarMenuDatas().R(new ArrayList());
                    int size = forumMenuResIdl.data.parent_menu.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        com.baidu.tieba.im.data.f fVar = new com.baidu.tieba.im.data.f();
                        Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                        fVar.fy(menu.action_type.intValue());
                        fVar.setContent(menu.content);
                        fVar.setCreate_time(menu.create_time.intValue());
                        fVar.setForum_id(new StringBuilder().append(menu.forum_id).toString());
                        fVar.setId(new StringBuilder().append(menu.id).toString());
                        fVar.setLevel(menu.level.intValue());
                        fVar.setName(menu.name);
                        fVar.Q(new ArrayList());
                        if (menu.sub_menu != null) {
                            int size2 = menu.sub_menu.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                SubMenu subMenu = menu.sub_menu.get(i3);
                                com.baidu.tieba.im.data.f fVar2 = new com.baidu.tieba.im.data.f();
                                fVar2.fy(subMenu.action_type.intValue());
                                fVar2.setContent(subMenu.content);
                                fVar2.setForum_id(new StringBuilder().append(subMenu.forum_id).toString());
                                fVar2.setId(new StringBuilder().append(subMenu.id).toString());
                                fVar2.setLevel(subMenu.level.intValue());
                                fVar2.setName(subMenu.name);
                                fVar2.fx(subMenu.parent_id.intValue());
                                fVar2.M(subMenu.update_time.intValue());
                                fVar.Mp().add(fVar2);
                            }
                        }
                        getOfficialBarMenuDatas().Ms().add(fVar);
                    }
                }
            }
        }
    }
}
