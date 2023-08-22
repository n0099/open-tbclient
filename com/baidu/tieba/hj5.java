package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.dfa;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fj5 a;

    /* loaded from: classes6.dex */
    public class a extends bx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj5 a;

        public a(hj5 hj5Var, fj5 fj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj5Var, fj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fj5Var;
        }

        @Override // com.baidu.tieba.bx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Long.valueOf(te8.w().j(this.a.a().a));
            }
            return invokeV.objValue;
        }
    }

    public hj5(fj5 fj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fj5Var;
    }

    public void d(dfa.i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, iVar) != null) || iVar == null) {
            return;
        }
        fj5 fj5Var = this.a;
        if (fj5Var != null && fj5Var.a() != null) {
            dfa.p(this.a.a().a, iVar);
        } else {
            iVar.a(null);
        }
    }

    public void e(String str) {
        fj5 fj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (fj5Var = this.a) != null && fj5Var.a() != null) {
            dfa.A(this.a.a().a, str);
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
            long b2 = ti8.b(j);
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
                j2 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
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
            fj5 fj5Var = this.a;
            if (fj5Var != null && fj5Var.a() != null) {
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
            eh8.k().t(a(str, ((Long) obj).longValue()));
            e("");
        }
    }

    public void f(fj5 fj5Var, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, fj5Var, str) == null) {
            this.a = fj5Var;
            fx5.c(new a(this, fj5Var), new gw5() { // from class: com.baidu.tieba.gj5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gw5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        hj5.this.c(str, obj);
                    }
                }
            });
        }
    }
}
