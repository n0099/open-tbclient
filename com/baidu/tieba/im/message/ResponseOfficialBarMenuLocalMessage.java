package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.l;
import com.baidu.tieba.im.data.m;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes.dex */
public class ResponseOfficialBarMenuLocalMessage extends CustomResponsedMessage<Object> {
    private m officialBarMenuDatas;

    public ResponseOfficialBarMenuLocalMessage() {
        super(2001181);
    }

    public m getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    public void setOfficialBarMenuDatas(m mVar) {
        this.officialBarMenuDatas = mVar;
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
                setOfficialBarMenuDatas(new m());
                if (forumMenuResIdl.data != null) {
                    getOfficialBarMenuDatas().a(forumMenuResIdl.data.update_time.intValue());
                    getOfficialBarMenuDatas().a(forumMenuResIdl.data.has_menu.intValue());
                    getOfficialBarMenuDatas().a(new ArrayList());
                    int size = forumMenuResIdl.data.parent_menu.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        l lVar = new l();
                        Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                        lVar.c(menu.action_type.intValue());
                        lVar.d(menu.content);
                        lVar.a(menu.create_time.intValue());
                        lVar.b(new StringBuilder().append(menu.forum_id).toString());
                        lVar.a(new StringBuilder().append(menu.id).toString());
                        lVar.a(menu.level.intValue());
                        lVar.c(menu.name);
                        lVar.a(new ArrayList());
                        if (menu.sub_menu != null) {
                            int size2 = menu.sub_menu.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                SubMenu subMenu = menu.sub_menu.get(i3);
                                l lVar2 = new l();
                                lVar2.c(subMenu.action_type.intValue());
                                lVar2.d(subMenu.content);
                                lVar2.b(new StringBuilder().append(subMenu.forum_id).toString());
                                lVar2.a(new StringBuilder().append(subMenu.id).toString());
                                lVar2.a(subMenu.level.intValue());
                                lVar2.c(subMenu.name);
                                lVar2.b(subMenu.parent_id.intValue());
                                lVar2.b(subMenu.update_time.intValue());
                                lVar.e().add(lVar2);
                            }
                        }
                        getOfficialBarMenuDatas().c().add(lVar);
                    }
                }
            }
        }
    }
}
