package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wo7;
import com.baidu.tieba.xo7;
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
    public xo7 officialBarMenuDatas;

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

    public xo7 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.officialBarMenuDatas;
        }
        return (xo7) invokeV.objValue;
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
        setOfficialBarMenuDatas(new xo7());
        if (forumMenuResIdl.data != null) {
            getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
            getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
            getOfficialBarMenuDatas().e(new ArrayList());
            int size = forumMenuResIdl.data.parent_menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                wo7 wo7Var = new wo7();
                Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                wo7Var.f(menu.action_type.intValue());
                wo7Var.g(menu.content);
                wo7Var.h(menu.create_time.intValue());
                wo7Var.i(menu.forum_id + "");
                wo7Var.j(menu.id + "");
                wo7Var.k(menu.level.intValue());
                wo7Var.l(menu.name);
                wo7Var.n(new ArrayList());
                List<SubMenu> list = menu.sub_menu;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        SubMenu subMenu = menu.sub_menu.get(i3);
                        wo7 wo7Var2 = new wo7();
                        wo7Var2.f(subMenu.action_type.intValue());
                        wo7Var2.g(subMenu.content);
                        wo7Var2.i(subMenu.forum_id + "");
                        wo7Var2.j(subMenu.id + "");
                        wo7Var2.k(subMenu.level.intValue());
                        wo7Var2.l(subMenu.name);
                        wo7Var2.m(subMenu.parent_id.intValue());
                        wo7Var2.o(subMenu.update_time.intValue());
                        wo7Var.e().add(wo7Var2);
                    }
                }
                getOfficialBarMenuDatas().a().add(wo7Var);
            }
        }
    }

    public void setOfficialBarMenuDatas(xo7 xo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xo7Var) == null) {
            this.officialBarMenuDatas = xo7Var;
        }
    }
}
