package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o37;
import com.repackage.p37;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumMenu.ForumMenuResIdl;
import tbclient.ForumMenu.Menu;
import tbclient.ForumMenu.SubMenu;
/* loaded from: classes3.dex */
public class ResponseOfficialBarMenuLocalMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p37 officialBarMenuDatas;

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
        setOfficialBarMenuDatas(new p37());
        if (forumMenuResIdl.data != null) {
            getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
            getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
            getOfficialBarMenuDatas().e(new ArrayList());
            int size = forumMenuResIdl.data.parent_menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                o37 o37Var = new o37();
                Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                o37Var.f(menu.action_type.intValue());
                o37Var.g(menu.content);
                o37Var.h(menu.create_time.intValue());
                o37Var.i(menu.forum_id + "");
                o37Var.j(menu.id + "");
                o37Var.k(menu.level.intValue());
                o37Var.l(menu.name);
                o37Var.n(new ArrayList());
                List<SubMenu> list = menu.sub_menu;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        SubMenu subMenu = menu.sub_menu.get(i3);
                        o37 o37Var2 = new o37();
                        o37Var2.f(subMenu.action_type.intValue());
                        o37Var2.g(subMenu.content);
                        o37Var2.i(subMenu.forum_id + "");
                        o37Var2.j(subMenu.id + "");
                        o37Var2.k(subMenu.level.intValue());
                        o37Var2.l(subMenu.name);
                        o37Var2.m(subMenu.parent_id.intValue());
                        o37Var2.o(subMenu.update_time.intValue());
                        o37Var.e().add(o37Var2);
                    }
                }
                getOfficialBarMenuDatas().a().add(o37Var);
            }
        }
    }

    public p37 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.officialBarMenuDatas : (p37) invokeV.objValue;
    }

    public void setOfficialBarMenuDatas(p37 p37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p37Var) == null) {
            this.officialBarMenuDatas = p37Var;
        }
    }
}
