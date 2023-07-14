package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.bca;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fk5 a;

    /* loaded from: classes6.dex */
    public class a extends wy5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk5 a;

        public a(hk5 hk5Var, fk5 fk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk5Var, fk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk5Var;
        }

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Long.valueOf(fe8.w().j(this.a.a().a));
            }
            return invokeV.objValue;
        }
    }

    public hk5(fk5 fk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fk5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fk5Var;
    }

    public void d(bca.h hVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, hVar) != null) || hVar == null) {
            return;
        }
        fk5 fk5Var = this.a;
        if (fk5Var != null && fk5Var.a() != null) {
            bca.n(this.a.a().a, hVar);
        } else {
            hVar.a(null);
        }
    }

    public void e(String str) {
        fk5 fk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (fk5Var = this.a) != null && fk5Var.a() != null) {
            bca.x(this.a.a().a, str);
        }
    }

    public final ChatMessage a(String str, long j) {
        InterceptResult invokeLJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            ChatMessage b = b();
            if (b == null) {
                return null;
            }
            b.setCustomGroupType(2);
            b.setMsgType(1);
            b.setContent(str);
            long b2 = bh8.b(j);
            b.setMsgId(b2);
            b.setRecordId(b2);
            b.setTime(System.currentTimeMillis() / 1000);
            UserData userData = new UserData();
            userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
            userData.setUserId(TbadkCoreApplication.getCurrentAccount());
            userData.setName_show(TbadkCoreApplication.getCurrentAccountNameShow());
            userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            b.setUserInfo(userData);
            try {
                j2 = wg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            } catch (Exception unused) {
                j2 = 0;
            }
            b.setUserId(j2);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            b.setLocalData(msgLocalData);
            return b;
        }
        return (ChatMessage) invokeLJ.objValue;
    }

    public ChatMessage b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            fk5 fk5Var = this.a;
            if (fk5Var != null && fk5Var.a() != null) {
                PersonalChatMessage personalChatMessage = new PersonalChatMessage();
                personalChatMessage.setBornTime(System.currentTimeMillis());
                personalChatMessage.setToUserId(Long.parseLong(this.a.a().a));
                UserData userData = new UserData();
                userData.setUserId(this.a.a().a);
                userData.setPortrait(this.a.a().c);
                userData.setName_show(this.a.a().b);
                personalChatMessage.setToUserInfo(userData);
                personalChatMessage.setIsFriend(this.a.a().j ? 1 : 0);
                return personalChatMessage;
            }
            return null;
        }
        return (ChatMessage) invokeV.objValue;
    }

    public /* synthetic */ void c(String str, Object obj) {
        if (obj instanceof Long) {
            lf8.k().t(a(str, ((Long) obj).longValue()));
            e("");
        }
    }

    public void f(fk5 fk5Var, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, fk5Var, str) == null) {
            this.a = fk5Var;
            az5.c(new a(this, fk5Var), new ay5() { // from class: com.baidu.tieba.gk5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ay5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        hk5.this.c(str, obj);
                    }
                }
            });
        }
    }
}
