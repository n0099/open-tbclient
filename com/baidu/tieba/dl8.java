package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public abstract class dl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gl8 a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    @Nullable
    public zi5 f;
    @Nullable
    public aj5 g;
    @Nullable
    public bj5 h;
    @Nullable
    public bj5 i;
    @NonNull
    public final si5 j;
    public cj5 k;
    public final CustomMessageListener l;

    public abstract int k();

    public abstract long l();

    /* loaded from: classes5.dex */
    public class a implements cj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl8 a;

        public a(dl8 dl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl8Var;
        }

        @Override // com.baidu.tieba.cj5
        public void a(int i, long j, @NonNull TreeSet<ChatMsg> treeSet) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), treeSet}) == null) && i == 0 && treeSet.size() > 0) {
                this.a.a.j(j, treeSet);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dl8 dl8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl8Var, Integer.valueOf(i)};
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
            this.a = dl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            dl8 dl8Var = this.a;
            dl8Var.e = dl8Var.d;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl8 a;

        public c(dl8 dl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl8Var;
        }

        @Override // com.baidu.tieba.zi5
        public void a(long j, int i, @NonNull String str, @Nullable IChatRoomEnterListener.ChatRoomInfo chatRoomInfo) {
            zi5 zi5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str, chatRoomInfo}) == null) && (zi5Var = this.a.f) != null) {
                zi5Var.a(j, i, str, chatRoomInfo);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements aj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl8 a;

        public d(dl8 dl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl8Var;
        }

        @Override // com.baidu.tieba.aj5
        public void a(long j, int i, @NonNull String str) {
            aj5 aj5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) && (aj5Var = this.a.g) != null) {
                aj5Var.a(j, i, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements bj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl8 a;

        public e(dl8 dl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl8Var;
        }

        @Override // com.baidu.tieba.bj5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                bj5 bj5Var = this.a.h;
                if (bj5Var != null) {
                    bj5Var.a(i, j, list, i2, str);
                }
                if (this.a.f != null) {
                    for (Long l : list) {
                        this.a.f.a(l.longValue(), i2, str, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements bj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl8 a;

        public f(dl8 dl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl8Var;
        }

        @Override // com.baidu.tieba.bj5
        public void a(int i, long j, @NonNull List<Long> list, int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), list, Integer.valueOf(i2), str}) == null) {
                bj5 bj5Var = this.a.i;
                if (bj5Var != null) {
                    bj5Var.a(i, j, list, i2, str);
                }
                if (this.a.g != null) {
                    for (Long l : list) {
                        this.a.g.a(l.longValue(), i2, str);
                    }
                }
            }
        }
    }

    public dl8(@NonNull Context context, @NonNull ChatGroupSource chatGroupSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatGroupSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.j = ri5.b();
        this.k = new a(this);
        this.l = new b(this, 2921781);
        this.b = context;
        this.a = new gl8(chatGroupSource);
        MessageManager.getInstance().registerListener(this.l);
    }

    @NonNull
    public final List<ChatRoomInfo> d(@NonNull List<GroupChatRoomPojo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                GroupChatRoomPojo groupChatRoomPojo = list.get(i);
                if (groupChatRoomPojo != null) {
                    arrayList.add(w(groupChatRoomPojo));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    @WorkerThread
    public List<ChatRoomInfo> m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            List<GroupChatRoomPojo> l = qd8.j().l(str);
            if (!ListUtils.isEmpty(l)) {
                return d(l);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void n(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.a.i(list);
            e();
            this.c = true;
        }
    }

    public void r(@Nullable bj5 bj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bj5Var) == null) {
            this.h = bj5Var;
        }
    }

    public void s(@Nullable zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zi5Var) == null) {
            this.f = zi5Var;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.d = z;
        }
    }

    public void u(@Nullable aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aj5Var) == null) {
            this.g = aj5Var;
        }
    }

    public void v(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.a.q(j, i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e) {
                this.e = false;
                return;
            }
            List<Long> g = this.a.g();
            if (!ListUtils.isEmpty(g)) {
                if (k() == -1) {
                    g(g);
                } else {
                    f(g);
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            List<Long> g = this.a.g();
            if (!ListUtils.isEmpty(g)) {
                if (k() == -1) {
                    j(g);
                } else {
                    i(g);
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.m();
            q();
            this.b = null;
            this.d = false;
            this.e = false;
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.c) {
            e();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h();
        }
    }

    public final void f(@NonNull List<Long> list) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (context = this.b) != null && this.k != null) {
            this.j.j(context, k(), l(), list, this.k);
            this.j.q(this.b, k(), l(), list, new e(this));
        }
    }

    public final void i(@NonNull List<Long> list) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && (context = this.b) != null && this.k != null) {
            this.j.f(context, k(), l(), list, this.k);
            this.j.m(this.b, k(), l(), list, new f(this));
        }
    }

    public final void g(@NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && this.b != null && this.k != null) {
            for (Long l : list) {
                this.j.d(this.b, l.longValue(), this.k);
                this.j.l(this.b, l.longValue(), new c(this));
            }
        }
    }

    public final void j(@NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && this.b != null && this.k != null) {
            for (Long l : list) {
                this.j.o(this.b, l.longValue(), this.k);
                this.j.r(this.b, l.longValue(), new d(this));
            }
        }
    }

    @NonNull
    public final ChatRoomInfo w(@NonNull GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, groupChatRoomPojo)) == null) {
            ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
            chatRoomInfo.setRoomId(groupChatRoomPojo.getRoomId());
            chatRoomInfo.setName(groupChatRoomPojo.getName());
            chatRoomInfo.setForumId(groupChatRoomPojo.getForumId());
            chatRoomInfo.setForumName(groupChatRoomPojo.getForumName());
            chatRoomInfo.setAvatar(groupChatRoomPojo.getAvatar());
            chatRoomInfo.setDeleteTime(groupChatRoomPojo.getDeleteTime());
            chatRoomInfo.setTopTime(groupChatRoomPojo.getTopTime());
            chatRoomInfo.setNoDisturb(groupChatRoomPojo.O());
            chatRoomInfo.setIsSubscribe(groupChatRoomPojo.N());
            ChatNewMessage chatNewMessage = new ChatNewMessage();
            chatNewMessage.setMsgId(String.valueOf(groupChatRoomPojo.getLatestMsgId()));
            chatNewMessage.setMsgTime(String.valueOf(groupChatRoomPojo.getTimestamp()));
            chatNewMessage.setLastExitChatRoomTime(groupChatRoomPojo.getLastExitChatRoomTime());
            chatRoomInfo.setNewMessage(chatNewMessage);
            return chatRoomInfo;
        }
        return (ChatRoomInfo) invokeL.objValue;
    }
}
