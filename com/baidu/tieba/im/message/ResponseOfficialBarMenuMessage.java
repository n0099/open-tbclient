package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.b.h0.r.r.a;
import d.b.i0.e1.g.b;
import d.b.i0.e1.g.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes4.dex */
public class ResponseOfficialBarMenuMessage extends TbSocketReponsedMessage {
    public static final String OFFICIAL_BAR_MENU_KEY_PRE = "official_bar_menu_";
    public c officialBarMenuDatas;

    public ResponseOfficialBarMenuMessage() {
        super(303006);
    }

    public c getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        c officialBarMenuDatas;
        Message<?> orginalMessage = getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestOfficialBarMenuMessage) || getError() != 0 || (officialBarMenuDatas = getOfficialBarMenuDatas()) == null || !officialBarMenuDatas.c() || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() <= 0) {
            return;
        }
        String forum_id = ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id();
        TbSocketReponsedMessage.saveProtocolBufferDataToCache(a.f().d("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + forum_id, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
        setError(forumMenuResIdl.error.errorno.intValue());
        setErrorString(forumMenuResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.officialBarMenuDatas = new c();
        if (forumMenuResIdl.data != null) {
            getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
            getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
            getOfficialBarMenuDatas().e(new ArrayList());
            int size = forumMenuResIdl.data.parent_menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = new b();
                Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                bVar.f(menu.action_type.intValue());
                bVar.g(menu.content);
                bVar.h(menu.create_time.intValue());
                bVar.i(menu.forum_id + "");
                bVar.j(menu.id + "");
                bVar.k(menu.level.intValue());
                bVar.l(menu.name);
                bVar.n(new ArrayList());
                List<SubMenu> list = menu.sub_menu;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        SubMenu subMenu = menu.sub_menu.get(i3);
                        b bVar2 = new b();
                        bVar2.f(subMenu.action_type.intValue());
                        bVar2.g(subMenu.content);
                        bVar2.i(subMenu.forum_id + "");
                        bVar2.j(subMenu.id + "");
                        bVar2.k(subMenu.level.intValue());
                        bVar2.l(subMenu.name);
                        bVar2.m(subMenu.parent_id.intValue());
                        bVar2.o(subMenu.update_time.intValue());
                        bVar.e().add(bVar2);
                    }
                }
                getOfficialBarMenuDatas().a().add(bVar);
            }
        }
    }
}
