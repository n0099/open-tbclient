package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ce8 extends yd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ChatRoomInfo> m;
    public ArrayList<ChatRoomInfo> n;
    public final Map<String, xe<String>> o;
    public TbPageContext p;
    @Nullable
    public FastRequest q;
    public boolean r;
    public String s;
    public boolean t;
    public ArrayList<Long> u;
    public h v;
    public CustomMessageListener w;

    /* loaded from: classes5.dex */
    public interface h {
        void a(@Nullable List<ImMessageCenterPojo> list, boolean z);

        void b(@Nullable List<ImMessageCenterPojo> list);
    }

    @Override // com.baidu.tieba.yd8
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ce8 ce8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var, Integer.valueOf(i)};
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
            this.a = ce8Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map) && (map = (Map) customResponsedMessage.getData()) != null && !map.isEmpty() && map.entrySet() != null && map.entrySet().iterator() != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue() != null && !ListUtils.isEmpty(this.a.u) && this.a.u.contains(Long.valueOf(((ChatRoomInfo) entry.getValue()).getRoomId()))) {
                        arrayList.add(entry.getValue());
                    }
                }
                this.a.W(arrayList);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends sx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce8 a;

        public b(ce8 ce8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ce8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sx5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.J().get("group_chat_http_key");
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ww5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce8 a;

        public c(ce8 ce8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ce8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ww5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || !this.a.t) {
                return;
            }
            ChatGroupInfo N = this.a.N(str, false);
            if (N != null && !ListUtils.isEmpty(N.getRoomInfoList())) {
                List<ImMessageCenterPojo> G = this.a.G(N.getRoomInfoList());
                if (!ListUtils.isEmpty(G) && this.a.v != null) {
                    this.a.v.a(G, true);
                }
            } else if (this.a.v != null) {
                this.a.v.a(null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ ce8 b;

        public d(ce8 ce8Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce8Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qj8.a().c(this.b.m(TbadkCoreApplication.getCurrentAccount()), this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements FastRequest.e<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce8 a;

        public e(ce8 ce8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ce8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.e
        @Nullable
        /* renamed from: b */
        public ChatGroupInfo a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
                return (ChatGroupInfo) invokeL.objValue;
            }
            return this.a.N(str, true);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends FastRequest.b<ChatGroupInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce8 b;

        public f(ce8 ce8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, chatGroupInfo) == null) {
                super.b(i, str, chatGroupInfo);
                if (this.b.v != null) {
                    this.b.v.a(null, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull ChatGroupInfo chatGroupInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, chatGroupInfo) == null) {
                super.e(chatGroupInfo);
                this.b.t = false;
                if (this.b.v == null) {
                    return;
                }
                ce8 ce8Var = this.b;
                ce8Var.U(ce8Var.s);
                if (chatGroupInfo == null || ListUtils.isEmpty(chatGroupInfo.getRoomInfoList())) {
                    this.b.H(new ArrayList());
                    if (this.b.v != null) {
                        this.b.v.a(null, false);
                        return;
                    }
                    return;
                }
                this.b.H(chatGroupInfo.getRoomInfoList());
                List<ImMessageCenterPojo> G = this.b.G(chatGroupInfo.getRoomInfoList());
                if (!ListUtils.isEmpty(G) && this.b.v != null) {
                    this.b.v.a(G, true);
                }
                this.b.O(chatGroupInfo.getRoomInfoList());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ce8 b;

        public g(ce8 ce8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ce8Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.J().g("group_chat_http_key", this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce8(TbPageContext tbPageContext, h hVar) {
        super(tbPageContext.getPageActivity(), ChatGroupSource.GROUP_CHAT_TAB);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ChatGroupSource) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = new HashMap();
        this.r = false;
        this.s = null;
        this.t = true;
        this.u = new ArrayList<>();
        this.w = new a(this, 2921766);
        this.p = tbPageContext;
        this.v = hVar;
        MessageManager.getInstance().registerListener(this.w);
    }

    public final ChatGroupInfo N(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.s = null;
                return null;
            }
            if (z) {
                this.s = str;
            }
            ChatGroupInfo chatGroupInfo = new ChatGroupInfo();
            try {
                chatGroupInfo.parse(new JSONObject(str));
                return chatGroupInfo;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (ChatGroupInfo) invokeLZ.objValue;
    }

    public final void H(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ch.e(new d(this, list));
        }
    }

    public String K(List<Map<String, Long>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            String json = DataExt.toJson(list);
            if (TextUtils.isEmpty(json)) {
                return "";
            }
            return json;
        }
        return (String) invokeL.objValue;
    }

    public void T(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            v(j, 0);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            ch.e(new g(this, str));
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            M();
        }
    }

    public final void W(List<ChatRoomInfo> list) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, list) == null) && !ListUtils.isEmpty(list) && this.v != null) {
            List<ImMessageCenterPojo> G = G(list);
            if (!ListUtils.isEmpty(G) && (hVar = this.v) != null) {
                hVar.b(G);
            }
        }
    }

    public void X(ChatRoomInfo chatRoomInfo) {
        ArrayList<ChatRoomInfo> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, chatRoomInfo) == null) && chatRoomInfo != null && (arrayList = this.m) != null) {
            arrayList.clear();
            this.m.add(chatRoomInfo);
            W(this.m);
        }
    }

    public final List<ImMessageCenterPojo> G(List<ChatRoomInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (ChatRoomInfo chatRoomInfo : list) {
                ImMessageCenterPojo P = P(chatRoomInfo);
                if (P != null) {
                    arrayList.add(P);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !this.r) {
            return;
        }
        h();
        this.r = false;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            M();
            p();
            this.r = true;
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.v != null) {
            this.t = true;
            wx5.b(new b(this), new c(this));
        }
    }

    @Override // com.baidu.tieba.yd8
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ng8.a();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.yd8
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.o();
            FastRequest fastRequest = this.q;
            if (fastRequest != null) {
                fastRequest.onDestroy();
            }
            this.v = null;
            I();
            MessageManager.getInstance().unRegisterListener(this.w);
        }
    }

    public xe<String> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.o.containsKey(currentAccount)) {
                return this.o.get(currentAccount);
            }
            f55.d();
            xe<String> f2 = f55.f("tb.im_group_chat_http", TbadkCoreApplication.getCurrentAccount());
            this.o.put(currentAccount, f2);
            return f2;
        }
        return (xe) invokeV.objValue;
    }

    public List<Map<String, Long>> L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ChatRoomInfo> m = m(TbadkCoreApplication.getCurrentAccount());
            if (ListUtils.isEmpty(m)) {
                return null;
            }
            if (i != 0) {
                if (i == 1) {
                    for (ChatRoomInfo chatRoomInfo : m) {
                        if (!chatRoomInfo.isNoDisturb()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("room_id", Long.valueOf(chatRoomInfo.getRoomId()));
                            if (chatRoomInfo.getNewMessage() != null) {
                                hashMap.put("msg_id", Long.valueOf(chatRoomInfo.getNewMessage().getMsgId()));
                            } else {
                                hashMap.put("msg_id", 0L);
                            }
                            arrayList.add(hashMap);
                        }
                    }
                }
            } else {
                for (ChatRoomInfo chatRoomInfo2 : m) {
                    HashMap hashMap2 = new HashMap();
                    if (chatRoomInfo2 != null && chatRoomInfo2.getLatestMsgId() != 0) {
                        hashMap2.put("room_id", Long.valueOf(chatRoomInfo2.getRoomId()));
                        if (chatRoomInfo2.getNewMessage() != null) {
                            hashMap2.put("msg_id", Long.valueOf(chatRoomInfo2.getNewMessage().getMsgId()));
                        } else {
                            hashMap2.put("msg_id", 0L);
                        }
                        arrayList.add(hashMap2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.u == null) {
                this.u = new ArrayList<>();
            }
            this.u.clear();
            List<ChatRoomInfo> m = m(TbadkCoreApplication.getCurrentAccount());
            if (!ListUtils.isEmpty(m)) {
                for (ChatRoomInfo chatRoomInfo : m) {
                    if (chatRoomInfo != null && chatRoomInfo.isSubscribe()) {
                        this.u.add(Long.valueOf(chatRoomInfo.getRoomId()));
                    }
                }
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !TbSingleton.getInstance().isNeedJoinChatRoom()) {
            return;
        }
        String K = K(L(0));
        if (this.q == null) {
            this.q = new FastRequest(this.p, CmdConfigHttp.CMD_GET_SUBSCRIBE_GROUP_CHAT_LIST, TbConfig.GET_SUBSCRIBE_GROUP_CHAT_LIST);
        }
        FastRequest fastRequest = this.q;
        fastRequest.V("chatroom_new_msg", K);
        fastRequest.a0(HttpMessageTask.HTTP_METHOD.POST);
        fastRequest.X(new f(this));
        fastRequest.c0(new e(this));
        fastRequest.W();
    }

    public void O(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && TbSingleton.getInstance().isNeedJoinChatRoom() && this.n != null) {
            M();
            this.n.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                if (chatRoomInfo != null && chatRoomInfo.getIsShow() == 1) {
                    this.n.add(chatRoomInfo);
                }
            }
            n(this.n);
            this.r = true;
        }
    }

    public final ImMessageCenterPojo P(ChatRoomInfo chatRoomInfo) {
        InterceptResult invokeL;
        long msgTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, chatRoomInfo)) == null) {
            if (chatRoomInfo == null) {
                return null;
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(String.valueOf(chatRoomInfo.getRoomId()));
            imMessageCenterPojo.setGroup_head(chatRoomInfo.getAvatar());
            imMessageCenterPojo.setGroup_name(chatRoomInfo.getName());
            imMessageCenterPojo.setCustomGroupType(9);
            imMessageCenterPojo.setUnread_count(chatRoomInfo.getUnreadNum());
            imMessageCenterPojo.setGroupJumpUrl(chatRoomInfo.getJumpUrl());
            if (chatRoomInfo.getAtInfo() != null) {
                b35 b35Var = new b35();
                b35Var.b(chatRoomInfo.getAtInfo().getAllMsgCount());
                b35Var.c(chatRoomInfo.getAtInfo().getCountAll());
                b35Var.d(chatRoomInfo.getAtInfo().getSingleMsgCount());
                imMessageCenterPojo.setAtInfoData(b35Var);
            }
            imMessageCenterPojo.setForumName(chatRoomInfo.getForumName());
            imMessageCenterPojo.setForumId(chatRoomInfo.getForumId());
            imMessageCenterPojo.setRoomId(chatRoomInfo.getRoomId());
            if (chatRoomInfo.getIsShow() == 0) {
                return null;
            }
            if (chatRoomInfo.getNewMessage() == null) {
                imMessageCenterPojo.setLast_user_name("");
                imMessageCenterPojo.setLast_content("");
                imMessageCenterPojo.setIs_hidden(0);
                imMessageCenterPojo.setLast_content_time(System.currentTimeMillis());
                return imMessageCenterPojo;
            }
            if (!TextUtils.isEmpty(chatRoomInfo.getNewMessage().getFromUid()) && chatRoomInfo.getUnreadNum() == 1 && chatRoomInfo.getNewMessage().getFromUid().equals(TbadkCoreApplication.getCurrentAccount())) {
                imMessageCenterPojo.setUnread_count(0);
            }
            imMessageCenterPojo.setLast_user_name(chatRoomInfo.getNewMessage().getFromName());
            imMessageCenterPojo.setLast_content(chatRoomInfo.getNewMessage().getContent());
            if (String.valueOf(chatRoomInfo.getNewMessage().getMsgTime()).length() <= 10 && chatRoomInfo.getNewMessage().getMsgTime() != 0) {
                msgTime = chatRoomInfo.getNewMessage().getMsgTime() * 1000;
            } else {
                msgTime = chatRoomInfo.getNewMessage().getMsgTime();
            }
            if (ua8.b().c(Long.valueOf(chatRoomInfo.getRoomId()), msgTime)) {
                imMessageCenterPojo.setIs_hidden(1);
            } else {
                imMessageCenterPojo.setIs_hidden(0);
            }
            imMessageCenterPojo.setLast_content_time(msgTime);
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }
}
