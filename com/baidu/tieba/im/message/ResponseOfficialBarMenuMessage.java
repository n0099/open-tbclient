package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.df8;
import com.baidu.tieba.ef8;
import com.baidu.tieba.x45;
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
    public ef8 officialBarMenuDatas;

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

    public ef8 getOfficialBarMenuDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.officialBarMenuDatas;
        }
        return (ef8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        Message<?> orginalMessage;
        ef8 officialBarMenuDatas;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && (orginalMessage = getOrginalMessage()) != null && (orginalMessage instanceof RequestOfficialBarMenuMessage) && getError() == 0 && (officialBarMenuDatas = getOfficialBarMenuDatas()) != null && officialBarMenuDatas.c() && officialBarMenuDatas.a() != null && officialBarMenuDatas.a().size() > 0) {
            x45.k();
            TbSocketReponsedMessage.saveProtocolBufferDataToCache(x45.i("tb.official_bar_menu"), OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuMessage) orginalMessage).getForum_id(), bArr);
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
            this.officialBarMenuDatas = new ef8();
            if (forumMenuResIdl.data != null) {
                getOfficialBarMenuDatas().f(forumMenuResIdl.data.update_time.intValue());
                getOfficialBarMenuDatas().d(forumMenuResIdl.data.has_menu.intValue());
                getOfficialBarMenuDatas().e(new ArrayList());
                int size = forumMenuResIdl.data.parent_menu.size();
                for (int i2 = 0; i2 < size; i2++) {
                    df8 df8Var = new df8();
                    Menu menu = forumMenuResIdl.data.parent_menu.get(i2);
                    df8Var.f(menu.action_type.intValue());
                    df8Var.g(menu.content);
                    df8Var.h(menu.id + "");
                    df8Var.i(menu.name);
                    df8Var.j(new ArrayList());
                    List<SubMenu> list = menu.sub_menu;
                    if (list != null) {
                        int size2 = list.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            SubMenu subMenu = menu.sub_menu.get(i3);
                            df8 df8Var2 = new df8();
                            df8Var2.f(subMenu.action_type.intValue());
                            df8Var2.g(subMenu.content);
                            df8Var2.h(subMenu.id + "");
                            df8Var2.i(subMenu.name);
                            df8Var.e().add(df8Var2);
                        }
                    }
                    getOfficialBarMenuDatas().a().add(df8Var);
                }
            }
            return forumMenuResIdl;
        }
        return invokeIL.objValue;
    }
}
