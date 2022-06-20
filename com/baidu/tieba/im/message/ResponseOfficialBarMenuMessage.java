package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mq4;
import com.repackage.y47;
import com.repackage.z47;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes3.dex */
public class ResponseOfficialBarMenuMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OFFICIAL_BAR_MENU_KEY_PRE = "official_bar_menu_";
    public transient /* synthetic */ FieldHolder $fh;
    public z47 officialBarMenuDatas;

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
            this.officialBarMenuDatas = new z47();
            if (forumMenuResIdl.data != null) {
                getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
                getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
                getOfficialBarMenuDatas().e(new ArrayList());
                int size = forumMenuResIdl.data.parent_menu.size();
                for (int i2 = 0; i2 < size; i2++) {
                    y47 y47Var = new y47();
                    Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                    y47Var.f(menu.action_type.intValue());
                    y47Var.g(menu.content);
                    y47Var.h(menu.create_time.intValue());
                    y47Var.i(menu.forum_id + "");
                    y47Var.j(menu.id + "");
                    y47Var.k(menu.level.intValue());
                    y47Var.l(menu.name);
                    y47Var.n(new ArrayList());
                    List<SubMenu> list = menu.sub_menu;
                    if (list != null) {
                        int size2 = list.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            SubMenu subMenu = menu.sub_menu.get(i3);
                            y47 y47Var2 = new y47();
                            y47Var2.f(subMenu.action_type.intValue());
                            y47Var2.g(subMenu.content);
                            y47Var2.i(subMenu.forum_id + "");
                            y47Var2.j(subMenu.id + "");
                            y47Var2.k(subMenu.level.intValue());
                            y47Var2.l(subMenu.name);
                            y47Var2.m(subMenu.parent_id.intValue());
                            y47Var2.o(subMenu.update_time.intValue());
                            y47Var.e().add(y47Var2);
                        }
                    }
                    getOfficialBarMenuDatas().a().add(y47Var);
                }
            }
            return forumMenuResIdl;
        }
        return invokeIL.objValue;
    }

    public z47 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.officialBarMenuDatas : (z47) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage;
        z47 officialBarMenuDatas;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (orginalMessage = getOrginalMessage()) == null || !(orginalMessage instanceof RequestOfficialBarMenuMessage) || getError() != 0 || (officialBarMenuDatas = getOfficialBarMenuDatas()) == null || !officialBarMenuDatas.c() || officialBarMenuDatas.a() == null || officialBarMenuDatas.a().size() <= 0) {
            return;
        }
        mq4.f();
        TbSocketReponsedMessage.saveProtocolBufferDataToCache(mq4.d("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id(), bArr);
    }
}
