package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NewFriendDbManagerStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static NewFriendDbManagerStatic f49281a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.l1.g.a f49282a;

        public a(NewFriendDbManagerStatic newFriendDbManagerStatic, c.a.r0.l1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49282a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.t.e.a.b.f().l(this.f49282a);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(c.a.r0.t.e.a.b.f().h(), true));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.q0.d1.q<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(NewFriendDbManagerStatic newFriendDbManagerStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.l1.g.a f49283a;

        public c(NewFriendDbManagerStatic newFriendDbManagerStatic, c.a.r0.l1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49283a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.t.e.a.b.f().l(this.f49283a);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(c.a.r0.t.e.a.b.f().h(), true));
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.q0.d1.q<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.l1.g.a f49284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49286c;

        public d(NewFriendDbManagerStatic newFriendDbManagerStatic, c.a.r0.l1.g.a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49284a = aVar;
            this.f49285b = str;
            this.f49286c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f49284a.b(), this.f49284a.e(), this.f49284a.d(), this.f49285b, this.f49286c));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f49287a;

        public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49287a = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.t.e.a.b.f().b(this.f49287a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.q0.d1.q<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(NewFriendDbManagerStatic newFriendDbManagerStatic) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.l1.g.a f49288a;

        public g(NewFriendDbManagerStatic newFriendDbManagerStatic, c.a.r0.l1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49288a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.t.e.a.b.f().l(this.f49288a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements c.a.q0.d1.q<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f49289a;

        public h(NewFriendDbManagerStatic newFriendDbManagerStatic, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49289a = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f49289a, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.l1.g.a f49290a;

        public i(NewFriendDbManagerStatic newFriendDbManagerStatic, c.a.r0.l1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49290a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.t.e.a.b.f().l(this.f49290a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements c.a.q0.d1.q<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f49291a;

        public j(NewFriendDbManagerStatic newFriendDbManagerStatic, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49291a = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f49291a, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof RequestApplyLocalMessage)) {
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
    }

    /* loaded from: classes7.dex */
    public static class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49292a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.l1.g.a f49293b;

            public a(l lVar, long j2, c.a.r0.l1.g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Long.valueOf(j2), aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49292a = j2;
                this.f49293b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (c.a.r0.t.e.a.b.f().n(this.f49292a)) {
                        return null;
                    }
                    c.a.r0.t.e.a.b.f().l(this.f49293b);
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                aVar.h(id);
                aVar.j(name);
                aVar.l(0);
                aVar.k(portrait);
                aVar.g(content);
                aVar.i(0);
                l0.c(new a(this, id, aVar), null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.l1.g.a f49294a;

        public m(NewFriendDbManagerStatic newFriendDbManagerStatic, c.a.r0.l1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49294a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.t.e.a.b.f().l(this.f49294a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements c.a.q0.d1.q<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f49295a;

        public n(NewFriendDbManagerStatic newFriendDbManagerStatic, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendDbManagerStatic, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49295a = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f49295a, "", "", "", ""));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class o extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49296a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.l1.g.a f49297b;

            public a(o oVar, long j2, c.a.r0.l1.g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j2), aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49296a = j2;
                this.f49297b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    c.a.r0.l1.g.a e2 = c.a.r0.t.e.a.b.f().e(this.f49296a);
                    if (e2 == null) {
                        return null;
                    }
                    this.f49297b.j(e2.d());
                    this.f49297b.k(e2.e());
                    c.a.r0.t.e.a.b.f().l(this.f49297b);
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49298a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RequestAddFriendMessage f49299b;

            public b(o oVar, long j2, RequestAddFriendMessage requestAddFriendMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j2), requestAddFriendMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49298a = j2;
                this.f49299b = requestAddFriendMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.f49298a, "", "", "", "");
                    responseNewFriendUpdateUiMsg.setContent(this.f49299b.getMessage());
                    MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49300a;

            public c(o oVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49300a = j2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 != this.f49300a && c.a.r0.t.e.a.b.f().n(this.f49300a)) {
                        c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                        aVar.h(this.f49300a);
                        aVar.l(3);
                        aVar.i(0);
                        c.a.r0.t.e.a.b.f().q(aVar);
                    }
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class d implements c.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49301a;

            public d(o oVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49301a = j2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f49301a, "", "", "", ""));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                RequestAddFriendMessage requestAddFriendMessage = (RequestAddFriendMessage) responseAddFriendMessage.getOrginalMessage();
                int error = responseAddFriendMessage.getError();
                long friendId = responseAddFriendMessage.getFriendId();
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                aVar.h(friendId);
                aVar.i(0);
                aVar.g(requestAddFriendMessage.getMessage());
                if (error == 0) {
                    aVar.l(3);
                    l0.c(new a(this, friendId, aVar), new b(this, friendId, requestAddFriendMessage));
                } else if (error == 3100097) {
                    Message<?> orginalMessage = responseAddFriendMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestAddFriendMessage) {
                        long friendId2 = ((RequestAddFriendMessage) orginalMessage).getFriendId();
                        l0.c(new c(this, friendId2), new d(this, friendId2));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class p extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49302a;

            public a(p pVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49302a = j2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 == this.f49302a) {
                        return null;
                    }
                    c.a.r0.t.e.a.b.f().b(this.f49302a);
                    c.a.r0.l1.h.m.t().o(String.valueOf(this.f49302a));
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49303a;

            public b(p pVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49303a = j2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.f49303a, "", "", "", ""));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                long friendId = responseDeleteFriendMessage.getFriendId();
                if (error == 0) {
                    l0.c(new a(this, friendId), new b(this, friendId));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class q extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49304a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.l1.g.a f49305b;

            public a(q qVar, long j2, c.a.r0.l1.g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j2), aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49304a = j2;
                this.f49305b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                c.a.r0.l1.g.a e2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 == this.f49304a || (e2 = c.a.r0.t.e.a.b.f().e(this.f49304a)) == null) {
                        return null;
                    }
                    this.f49305b.g(e2.a());
                    this.f49305b.j(e2.d());
                    this.f49305b.k(e2.e());
                    c.a.r0.t.e.a.b.f().l(this.f49305b);
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49306a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f49307b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f49308c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f49309d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49310e;

            public b(q qVar, long j2, String str, String str2, String str3, String str4) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j2), str, str2, str3, str4};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49306a = j2;
                this.f49307b = str;
                this.f49308c = str2;
                this.f49309d = str3;
                this.f49310e = str4;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f49306a, this.f49307b, this.f49308c, this.f49309d, this.f49310e));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49311a;

            public c(q qVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49311a = j2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (0 != this.f49311a && c.a.r0.t.e.a.b.f().n(this.f49311a)) {
                        c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                        aVar.h(this.f49311a);
                        aVar.l(2);
                        aVar.i(0);
                        c.a.r0.t.e.a.b.f().q(aVar);
                    }
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class d implements c.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f49312a;

            public d(q qVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49312a = j2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r9) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f49312a, "", "", "", ""));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePassFriendMessage)) {
                ResponsePassFriendMessage responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage;
                int error = responsePassFriendMessage.getError();
                long friendId = responsePassFriendMessage.getFriendId();
                String name = responsePassFriendMessage.getName();
                String portrait = responsePassFriendMessage.getPortrait();
                String key = responsePassFriendMessage.getKey();
                String quanpin = responsePassFriendMessage.getQuanpin();
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                aVar.h(friendId);
                aVar.l(2);
                aVar.i(0);
                if (error == 0) {
                    l0.c(new a(this, friendId, aVar), new b(this, friendId, portrait, name, key, quanpin));
                } else if (error == 3100098) {
                    Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestPassFriendMessage) {
                        long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                        l0.c(new c(this, friendId2), new d(this, friendId2));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f49313a;

        /* loaded from: classes7.dex */
        public class a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ r f49314a;

            public a(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49314a = rVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f49314a.f49313a = c.a.r0.t.e.a.b.f().h();
                    return null;
                }
                return (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ r f49315a;

            public b(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49315a = rVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r5) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(this.f49315a.f49313a, false));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49313a = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001175) {
                l0.c(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            j2.C("get_addresslist_switch" + ((String) customResponsedMessage.getData()));
        }
    }

    /* loaded from: classes7.dex */
    public static class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
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

    /* loaded from: classes7.dex */
    public static class u implements CustomMessageTask.CustomRunnable<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a.r0.l1.g.a> run(CustomMessage<Long> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                return new ResponseNewFriendDataMessage(c.a.r0.t.e.a.b.f().e(customMessage.getData().longValue()));
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
        f49281a = new NewFriendDbManagerStatic();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f49281a : (NewFriendDbManagerStatic) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject == null) {
                    return;
                }
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                aVar.l(3);
                aVar.g(optString3);
                aVar.h(optLong);
                aVar.i(1);
                aVar.j(optString);
                aVar.k(optString2);
                l0.c(new i(this, aVar), new j(this, optLong));
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
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                aVar.h(optJSONObject.optLong("user_id"));
                aVar.j(optJSONObject.optString("user_name"));
                aVar.k(optJSONObject.optString("portrait"));
                aVar.g(optJSONObject.optString("message"));
                aVar.i(0);
                aVar.l(1);
                l0.c(new a(this, aVar), new b(this));
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
                l0.c(new e(this, optJSONObject.optLong("user_id")), new f(this));
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
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                aVar.l(2);
                aVar.g(optString3);
                aVar.h(optLong);
                aVar.i(1);
                aVar.j(optString);
                aVar.k(optString2);
                l0.c(new m(this, aVar), new n(this, optLong));
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
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                aVar.h(optJSONObject.optLong("user_id"));
                aVar.j(optJSONObject.optString("user_name"));
                aVar.k(optJSONObject.optString("portrait"));
                aVar.g(optJSONObject.optString("message"));
                String optString = optJSONObject.optString("key");
                String optString2 = optJSONObject.optString("pinyin");
                aVar.i(0);
                aVar.l(4);
                l0.c(new c(this, aVar), new d(this, aVar, optString, optString2));
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
                c.a.r0.l1.g.a aVar = new c.a.r0.l1.g.a();
                long optLong = optJSONObject.optLong("user_id");
                String optString = optJSONObject.optString("user_name");
                String optString2 = optJSONObject.optString("portrait");
                String optString3 = optJSONObject.optString("message");
                int optInt = optJSONObject.optInt("type");
                if (optInt == 1) {
                    aVar.l(3);
                } else if (optInt == 2) {
                    aVar.l(1);
                }
                aVar.g(optString3);
                aVar.h(optLong);
                aVar.i(1);
                aVar.j(optString);
                aVar.k(optString2);
                l0.c(new g(this, aVar), new h(this, optLong));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
