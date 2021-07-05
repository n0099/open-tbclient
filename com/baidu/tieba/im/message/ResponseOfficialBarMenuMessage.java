package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.r0.r.r.a;
import d.a.s0.i1.g.b;
import d.a.s0.i1.g.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes5.dex */
public class ResponseOfficialBarMenuMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OFFICIAL_BAR_MENU_KEY_PRE = "official_bar_menu_";
    public transient /* synthetic */ FieldHolder $fh;
    public c officialBarMenuDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseOfficialBarMenuMessage() {
        super(303006);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.officialBarMenuDatas : (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        Message<?> orginalMessage;
        c officialBarMenuDatas;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (orginalMessage = getOrginalMessage()) == null || !(orginalMessage instanceof RequestOfficialBarMenuMessage) || getError() != 0 || (officialBarMenuDatas = getOfficialBarMenuDatas()) == null || !officialBarMenuDatas.c() || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() <= 0) {
            return;
        }
        String forum_id = ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id();
        TbSocketReponsedMessage.saveProtocolBufferDataToCache(a.f().d("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + forum_id, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
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
                for (int i3 = 0; i3 < size; i3++) {
                    b bVar = new b();
                    Menu menu = forumMenuResIdl.data.parent_menu.get(i3);
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
                        for (int i4 = 0; i4 < size2; i4++) {
                            SubMenu subMenu = menu.sub_menu.get(i4);
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
}
