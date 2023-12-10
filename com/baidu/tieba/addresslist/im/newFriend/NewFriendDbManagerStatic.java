package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.lu8;
import com.baidu.tieba.nu5;
import com.baidu.tieba.ru5;
import com.baidu.tieba.st5;
import com.baidu.tieba.st8;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NewFriendDbManagerStatic {
    public static /* synthetic */ Interceptable $ic;
    public static NewFriendDbManagerStatic a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ st8 b;

            public a(l lVar, long j, st8 st8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Long.valueOf(j), st8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = st8Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (!z36.f().n(this.a)) {
                        z36.f().l(this.b);
                        return null;
                    }
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001169) {
                RequestNewFriendActionLocalMessage requestNewFriendActionLocalMessage = (RequestNewFriendActionLocalMessage) customResponsedMessage;
                long id = requestNewFriendActionLocalMessage.getId();
                String name = requestNewFriendActionLocalMessage.getName();
                String portrait = requestNewFriendActionLocalMessage.getPortrait();
                String content = requestNewFriendActionLocalMessage.getContent();
                String st_type = requestNewFriendActionLocalMessage.getSt_type();
                RequestAddFriendMessage requestAddFriendMessage = new RequestAddFriendMessage();
                requestAddFriendMessage.setFriendId(id);
                requestAddFriendMessage.setMessage(content);
                requestAddFriendMessage.setSt_type(st_type);
                MessageManager.getInstance().sendMessage(requestAddFriendMessage);
                st8 st8Var = new st8();
                st8Var.h(id);
                st8Var.j(name);
                st8Var.l(0);
                st8Var.k(portrait);
                st8Var.g(content);
                st8Var.i(0);
                ru5.c(new a(this, id, st8Var), null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ st8 b;

            public a(o oVar, long j, st8 st8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j), st8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = st8Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    st8 e = z36.f().e(this.a);
                    if (e == null) {
                        return null;
                    }
                    this.b.j(e.d());
                    this.b.k(e.e());
                    z36.f().l(this.b);
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements st5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ RequestAddFriendMessage b;

            public b(o oVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j), requestAddFriendMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = requestAddFriendMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.a, "", "", "", "");
                    responseNewFriendUpdateUiMsg.setContent(this.b.getMessage());
                    MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public c(o oVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 != this.a && z36.f().n(this.a)) {
                        st8 st8Var = new st8();
                        st8Var.h(this.a);
                        st8Var.l(3);
                        st8Var.i(0);
                        z36.f().q(st8Var);
                    }
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class d implements st5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public d(o oVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.a, "", "", "", ""));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                RequestAddFriendMessage requestAddFriendMessage = (RequestAddFriendMessage) responseAddFriendMessage.getOrginalMessage();
                int error = responseAddFriendMessage.getError();
                long friendId = responseAddFriendMessage.getFriendId();
                st8 st8Var = new st8();
                st8Var.h(friendId);
                st8Var.i(0);
                st8Var.g(requestAddFriendMessage.getMessage());
                if (error == 0) {
                    st8Var.l(3);
                    ru5.c(new a(this, friendId, st8Var), new b(this, friendId, requestAddFriendMessage));
                } else if (error == 3100097) {
                    Message<?> orginalMessage = responseAddFriendMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestAddFriendMessage) {
                        long friendId2 = ((RequestAddFriendMessage) orginalMessage).getFriendId();
                        ru5.c(new c(this, friendId2), new d(this, friendId2));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public a(p pVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 == this.a) {
                        return null;
                    }
                    z36.f().b(this.a);
                    lu8.w().p(String.valueOf(this.a));
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements st5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public b(p pVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.a, "", "", "", ""));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                long friendId = responseDeleteFriendMessage.getFriendId();
                if (error == 0) {
                    ru5.c(new a(this, friendId), new b(this, friendId));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ st8 b;

            public a(q qVar, long j, st8 st8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j), st8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = st8Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                st8 e;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 == this.a || (e = z36.f().e(this.a)) == null) {
                        return null;
                    }
                    this.b.g(e.a());
                    this.b.j(e.d());
                    this.b.k(e.e());
                    z36.f().l(this.b);
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements st5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;

            public b(q qVar, long j, String str, String str2, String str3, String str4) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j), str, str2, str3, str4};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = str;
                this.c = str2;
                this.d = str3;
                this.e = str4;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.a, this.b, this.c, this.d, this.e));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public c(q qVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 != this.a && z36.f().n(this.a)) {
                        st8 st8Var = new st8();
                        st8Var.h(this.a);
                        st8Var.l(2);
                        st8Var.i(0);
                        z36.f().q(st8Var);
                    }
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class d implements st5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            public d(q qVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.a, "", "", "", ""));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePassFriendMessage)) {
                ResponsePassFriendMessage responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage;
                int error = responsePassFriendMessage.getError();
                long friendId = responsePassFriendMessage.getFriendId();
                String name = responsePassFriendMessage.getName();
                String portrait = responsePassFriendMessage.getPortrait();
                String key = responsePassFriendMessage.getKey();
                String quanpin = responsePassFriendMessage.getQuanpin();
                st8 st8Var = new st8();
                st8Var.h(friendId);
                st8Var.l(2);
                st8Var.i(0);
                if (error == 0) {
                    ru5.c(new a(this, friendId, st8Var), new b(this, friendId, portrait, name, key, quanpin));
                } else if (error == 3100098) {
                    Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestPassFriendMessage) {
                        long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                        ru5.c(new c(this, friendId2), new d(this, friendId2));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* loaded from: classes5.dex */
        public class a extends nu5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r a;

            public a(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = rVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nu5
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.a.a = z36.f().h();
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements st5<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r a;

            public b(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = rVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.st5
            /* renamed from: a */
            public void onReturnDataInUI(Void r5) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(this.a.a, false));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
            this.a = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001175) {
                ru5.c(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st8 a;

        public a(NewFriendDbManagerStatic newFriendDbManagerStatic, st8 st8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, st8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z36.f().l(this.a);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(z36.f().h(), true));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements st5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(NewFriendDbManagerStatic newFriendDbManagerStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st8 a;

        public c(NewFriendDbManagerStatic newFriendDbManagerStatic, st8 st8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, st8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z36.f().l(this.a);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(z36.f().h(), true));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements st5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st8 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(NewFriendDbManagerStatic newFriendDbManagerStatic, st8 st8Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, st8Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st8Var;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.a.b(), this.a.e(), this.a.d(), this.b, this.c));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z36.f().b(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements st5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
            }
        }

        public f(NewFriendDbManagerStatic newFriendDbManagerStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st8 a;

        public g(NewFriendDbManagerStatic newFriendDbManagerStatic, st8 st8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, st8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z36.f().l(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements st5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public h(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.a, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st8 a;

        public i(NewFriendDbManagerStatic newFriendDbManagerStatic, st8 st8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, st8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z36.f().l(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements st5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public j(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.a, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof RequestApplyLocalMessage)) {
                return;
            }
            RequestApplyLocalMessage requestApplyLocalMessage = (RequestApplyLocalMessage) customResponsedMessage;
            long uid = requestApplyLocalMessage.getUid();
            long friendId = requestApplyLocalMessage.getFriendId();
            String message = requestApplyLocalMessage.getMessage();
            RequestApplyMessage requestApplyMessage = new RequestApplyMessage();
            requestApplyMessage.setFriendId(friendId);
            requestApplyMessage.setMessage(message);
            requestApplyMessage.setUid(uid);
            MessageManager.getInstance().sendMessage(requestApplyMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends nu5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st8 a;

        public m(NewFriendDbManagerStatic newFriendDbManagerStatic, st8 st8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, st8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z36.f().l(this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements st5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public n(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.a, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.remove("get_addresslist_switch" + ((String) customResponsedMessage.getData()));
        }
    }

    /* loaded from: classes5.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (TextUtils.isEmpty(cmd)) {
                    return;
                }
                String content = p.getContent();
                if (TextUtils.isEmpty(content)) {
                    return;
                }
                if (cmd.equals("apply_new_friend")) {
                    NewFriendDbManagerStatic.d().b(content);
                } else if (cmd.equals("passed_new_friend")) {
                    NewFriendDbManagerStatic.d().f(content);
                } else if (cmd.equals("delete_new_friend")) {
                    NewFriendDbManagerStatic.d().c(content);
                } else if (cmd.equals("apply_reply_message")) {
                    NewFriendDbManagerStatic.d().g(content);
                } else if (cmd.equals("apply_add_friend")) {
                    NewFriendDbManagerStatic.d().a(content);
                } else if (cmd.equals("apply_pass_friend")) {
                    NewFriendDbManagerStatic.d().e(content);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements CustomMessageTask.CustomRunnable<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<st8> run(CustomMessage<Long> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                return new ResponseNewFriendDataMessage(z36.f().e(customMessage.getData().longValue()));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1953126955, "Lcom/baidu/tieba/addresslist/im/newFriend/NewFriendDbManagerStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1953126955, "Lcom/baidu/tieba/addresslist/im/newFriend/NewFriendDbManagerStatic;");
                return;
            }
        }
        a = new NewFriendDbManagerStatic();
        MessageManager.getInstance().registerListener(new k(2001216));
        MessageManager.getInstance().registerListener(new l(2001169));
        MessageManager.getInstance().registerListener(new o(304100));
        MessageManager.getInstance().registerListener(new p(304102));
        MessageManager.getInstance().registerListener(new q(304101));
        MessageManager.getInstance().registerListener(new r(2001175));
        MessageManager.getInstance().registerListener(new s(2001189));
        t tVar = new t(0);
        MessageManager.getInstance().registerListener(2001209, tVar);
        MessageManager.getInstance().registerListener(2001172, tVar);
        MessageManager.getInstance().registerListener(2001173, tVar);
        MessageManager.getInstance().registerListener(2001219, tVar);
        MessageManager.getInstance().registerListener(2001220, tVar);
        MessageManager.getInstance().registerListener(2001221, tVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001305, new u());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public NewFriendDbManagerStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static NewFriendDbManagerStatic d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (NewFriendDbManagerStatic) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                st8 st8Var = new st8();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                st8Var.l(3);
                st8Var.g(optString3);
                st8Var.h(optLong);
                st8Var.i(1);
                st8Var.j(optString);
                st8Var.k(optString2);
                ru5.c(new i(this, st8Var), new j(this, optLong));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                st8 st8Var = new st8();
                st8Var.h(optJSONObject.optLong("user_id"));
                st8Var.j(optJSONObject.optString("user_name"));
                st8Var.k(optJSONObject.optString("portrait"));
                st8Var.g(optJSONObject.optString("message"));
                st8Var.i(0);
                st8Var.l(1);
                ru5.c(new a(this, st8Var), new b(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                st8 st8Var = new st8();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                st8Var.l(2);
                st8Var.g(optString3);
                st8Var.h(optLong);
                st8Var.i(1);
                st8Var.j(optString);
                st8Var.k(optString2);
                ru5.c(new m(this, st8Var), new n(this, optLong));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                ru5.c(new e(this, optJSONObject.optLong("user_id")), new f(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                st8 st8Var = new st8();
                st8Var.h(optJSONObject.optLong("user_id"));
                st8Var.j(optJSONObject.optString("user_name"));
                st8Var.k(optJSONObject.optString("portrait"));
                st8Var.g(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                st8Var.i(0);
                st8Var.l(4);
                ru5.c(new c(this, st8Var), new d(this, st8Var, optString, optString2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                st8 st8Var = new st8();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                int optInt = optJSONObject.optInt("type");
                if (optInt == 1) {
                    st8Var.l(3);
                } else if (optInt == 2) {
                    st8Var.l(1);
                }
                st8Var.g(optString3);
                st8Var.h(optLong);
                st8Var.i(1);
                st8Var.j(optString);
                st8Var.k(optString2);
                ru5.c(new g(this, st8Var), new h(this, optLong));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
