package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i97;
import com.baidu.tieba.j97;
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
    public j97 officialBarMenuDatas;

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

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) || bArr == null) {
            return;
        }
        ForumMenuResIdl forumMenuResIdl = (ForumMenuResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumMenuResIdl.class);
        setError(forumMenuResIdl.error.errorno.intValue());
        setErrorString(forumMenuResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        setOfficialBarMenuDatas(new j97());
        if (forumMenuResIdl.data != null) {
            getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
            getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
            getOfficialBarMenuDatas().e(new ArrayList());
            int size = forumMenuResIdl.data.parent_menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                i97 i97Var = new i97();
                Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                i97Var.f(menu.action_type.intValue());
                i97Var.g(menu.content);
                i97Var.h(menu.create_time.intValue());
                i97Var.i(menu.forum_id + "");
                i97Var.j(menu.id + "");
                i97Var.k(menu.level.intValue());
                i97Var.l(menu.name);
                i97Var.n(new ArrayList());
                List<SubMenu> list = menu.sub_menu;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        SubMenu subMenu = menu.sub_menu.get(i3);
                        i97 i97Var2 = new i97();
                        i97Var2.f(subMenu.action_type.intValue());
                        i97Var2.g(subMenu.content);
                        i97Var2.i(subMenu.forum_id + "");
                        i97Var2.j(subMenu.id + "");
                        i97Var2.k(subMenu.level.intValue());
                        i97Var2.l(subMenu.name);
                        i97Var2.m(subMenu.parent_id.intValue());
                        i97Var2.o(subMenu.update_time.intValue());
                        i97Var.e().add(i97Var2);
                    }
                }
                getOfficialBarMenuDatas().a().add(i97Var);
            }
        }
    }

    public j97 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.officialBarMenuDatas : (j97) invokeV.objValue;
    }

    public void setOfficialBarMenuDatas(j97 j97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j97Var) == null) {
            this.officialBarMenuDatas = j97Var;
        }
    }
}
