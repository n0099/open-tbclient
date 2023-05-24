package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.c25;
import com.baidu.tieba.g28;
import com.baidu.tieba.h28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes6.dex */
public class ResponseOfficialBarMenuMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OFFICIAL_BAR_MENU_KEY_PRE = "official_bar_menu_";
    public transient /* synthetic */ FieldHolder $fh;
    public h28 officialBarMenuDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseOfficialBarMenuMessage() {
        super(303006);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h28 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.officialBarMenuDatas;
        }
        return (h28) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage;
        h28 officialBarMenuDatas;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && (orginalMessage = getOrginalMessage()) != null && (orginalMessage instanceof RequestOfficialBarMenuMessage) && getError() == 0 && (officialBarMenuDatas = getOfficialBarMenuDatas()) != null && officialBarMenuDatas.c() && officialBarMenuDatas.a() != null && officialBarMenuDatas.a().size() > 0) {
            c25.d();
            TbSocketReponsedMessage.saveProtocolBufferDataToCache(c25.b("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id(), bArr);
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
            setError(forumMenuResIdl.error.errorno.intValue());
            setErrorString(forumMenuResIdl.error.usermsg);
            if (getError() != 0) {
                return forumMenuResIdl;
            }
            this.officialBarMenuDatas = new h28();
            if (forumMenuResIdl.data != null) {
                getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
                getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
                getOfficialBarMenuDatas().e(new ArrayList());
                int size = forumMenuResIdl.data.parent_menu.size();
                for (int i2 = 0; i2 < size; i2++) {
                    g28 g28Var = new g28();
                    Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                    g28Var.f(menu.action_type.intValue());
                    g28Var.g(menu.content);
                    g28Var.h(menu.create_time.intValue());
                    g28Var.i(menu.forum_id + "");
                    g28Var.j(menu.id + "");
                    g28Var.k(menu.level.intValue());
                    g28Var.l(menu.name);
                    g28Var.n(new ArrayList());
                    List<SubMenu> list = menu.sub_menu;
                    if (list != null) {
                        int size2 = list.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            SubMenu subMenu = menu.sub_menu.get(i3);
                            g28 g28Var2 = new g28();
                            g28Var2.f(subMenu.action_type.intValue());
                            g28Var2.g(subMenu.content);
                            g28Var2.i(subMenu.forum_id + "");
                            g28Var2.j(subMenu.id + "");
                            g28Var2.k(subMenu.level.intValue());
                            g28Var2.l(subMenu.name);
                            g28Var2.m(subMenu.parent_id.intValue());
                            g28Var2.o(subMenu.update_time.intValue());
                            g28Var.e().add(g28Var2);
                        }
                    }
                    getOfficialBarMenuDatas().a().add(g28Var);
                }
            }
            return forumMenuResIdl;
        }
        return invokeIL.objValue;
    }
}
