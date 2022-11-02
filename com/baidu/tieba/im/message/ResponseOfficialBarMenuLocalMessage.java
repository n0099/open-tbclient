package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ab7;
import com.baidu.tieba.bb7;
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
/* loaded from: classes4.dex */
public class ResponseOfficialBarMenuLocalMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bb7 officialBarMenuDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseOfficialBarMenuLocalMessage() {
        super(2001177);
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

    public bb7 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.officialBarMenuDatas;
        }
        return (bb7) invokeV.objValue;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, bArr) != null) || bArr == null) {
            return;
        }
        ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
        setError(forumMenuResIdl.error.errorno.intValue());
        setErrorString(forumMenuResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        setOfficialBarMenuDatas(new bb7());
        if (forumMenuResIdl.data != null) {
            getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
            getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
            getOfficialBarMenuDatas().e(new ArrayList());
            int size = forumMenuResIdl.data.parent_menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                ab7 ab7Var = new ab7();
                Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                ab7Var.f(menu.action_type.intValue());
                ab7Var.g(menu.content);
                ab7Var.h(menu.create_time.intValue());
                ab7Var.i(menu.forum_id + "");
                ab7Var.j(menu.id + "");
                ab7Var.k(menu.level.intValue());
                ab7Var.l(menu.name);
                ab7Var.n(new ArrayList());
                List<SubMenu> list = menu.sub_menu;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        SubMenu subMenu = menu.sub_menu.get(i3);
                        ab7 ab7Var2 = new ab7();
                        ab7Var2.f(subMenu.action_type.intValue());
                        ab7Var2.g(subMenu.content);
                        ab7Var2.i(subMenu.forum_id + "");
                        ab7Var2.j(subMenu.id + "");
                        ab7Var2.k(subMenu.level.intValue());
                        ab7Var2.l(subMenu.name);
                        ab7Var2.m(subMenu.parent_id.intValue());
                        ab7Var2.o(subMenu.update_time.intValue());
                        ab7Var.e().add(ab7Var2);
                    }
                }
                getOfficialBarMenuDatas().a().add(ab7Var);
            }
        }
    }

    public void setOfficialBarMenuDatas(bb7 bb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bb7Var) == null) {
            this.officialBarMenuDatas = bb7Var;
        }
    }
}
