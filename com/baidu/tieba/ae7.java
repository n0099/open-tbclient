package com.baidu.tieba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes3.dex */
public class ae7 {
    public static /* synthetic */ Interceptable $ic;
    public static ae7 h;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public Handler b;
    public ConcurrentHashMap<Long, GroupMsgData> c;
    public ConcurrentHashMap<Long, NewpushGroupRepair> d;
    public ConcurrentHashMap<Long, Runnable> e;
    public Vector<Long> f;
    public final CustomMessageListener g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947612374, "Lcom/baidu/tieba/ae7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947612374, "Lcom/baidu/tieba/ae7;");
        }
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ae7 ae7Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae7Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae7Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(this.a.g);
                        return;
                    case 10003:
                        if (message.getData() != null && message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            this.a.f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ae7 e;

        public b(ae7 ae7Var, long j, long j2, int i, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae7Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ae7Var;
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupMsgData groupMsgData = (GroupMsgData) this.e.c.get(Long.valueOf(this.a));
                if (groupMsgData != null) {
                    LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                    long j = -1;
                    if (listMessage != null && listMessage.size() > 0) {
                        for (int i = 0; i < listMessage.size(); i++) {
                            if (j < listMessage.get(i).getSid()) {
                                j = listMessage.get(i).getSid();
                            }
                        }
                        listMessage.clear();
                    }
                    long j2 = j;
                    this.e.q(this.a);
                    if (j2 > this.b) {
                        this.e.d.put(Long.valueOf(this.a), MessageUtils.makeNewpushGroupRepair(this.a, this.c, this.b, j2, this.d));
                        wd7.n().v(this.a, 1L, 0L, true);
                        this.e.f.add(Long.valueOf(this.a));
                        this.e.o(this.a);
                        return;
                    }
                    return;
                }
                this.e.q(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ae7 ae7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae7Var, Integer.valueOf(i)};
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
            this.a = ae7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.h();
            }
        }
    }

    public ae7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new c(this, 2005016);
        this.a = new a(this, Looper.getMainLooper());
        this.b = new Handler(Looper.myLooper());
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
        this.f = new Vector<>();
        this.a.sendEmptyMessage(10002);
    }

    public NewpushGroupRepair j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (this.d.containsKey(Long.valueOf(j))) {
                return this.d.remove(Long.valueOf(j));
            }
            return null;
        }
        return (NewpushGroupRepair) invokeJ.objValue;
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            Message message = new Message();
            message.what = 10003;
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            message.setData(bundle);
            this.a.sendMessageDelayed(message, 3000L);
        }
    }

    public final void q(long j) {
        Runnable remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048585, this, j) == null) && (remove = this.e.remove(Long.valueOf(j))) != null) {
            this.b.removeCallbacks(remove);
        }
    }

    public static ae7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (h == null) {
                synchronized (ae7.class) {
                    if (h == null) {
                        h = new ae7();
                    }
                }
            }
            return h;
        }
        return (ae7) invokeV.objValue;
    }

    public final void g(long j, long j2, int i, long j3) {
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3)}) != null) || (groupMsgData = this.c.get(Long.valueOf(j2))) == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (!this.e.containsKey(Long.valueOf(j2))) {
                p(j, j2, i, j3);
                return;
            }
            return;
        }
        q(j2);
    }

    public final void p(long j, long j2, int i, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Long.valueOf(j3)}) == null) {
            b bVar = new b(this, j2, j, i, j3);
            this.b.postDelayed(bVar, be7.a().b().b());
            this.e.put(Long.valueOf(j2), bVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.b;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.e;
            if (concurrentHashMap != null) {
                for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                    q(entry.getKey().longValue());
                }
                this.e.clear();
            }
            ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.c;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
            Vector<Long> vector = this.f;
            if (vector != null) {
                vector.clear();
            }
        }
    }

    public final List<ChatMessage> k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            GroupMsgData groupMsgData = this.c.get(Long.valueOf(j));
            LinkedList linkedList = null;
            if (groupMsgData == null) {
                return null;
            }
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage != null && listMessage.size() != 0) {
                linkedList = new LinkedList();
                Iterator<ChatMessage> it = listMessage.iterator();
                long sid = listMessage.get(0).getSid() - 1;
                while (it.hasNext()) {
                    ChatMessage next = it.next();
                    sid++;
                    if (next.getSid() != sid) {
                        break;
                    }
                    it.remove();
                    linkedList.add(next);
                }
            }
            return linkedList;
        }
        return (List) invokeJ.objValue;
    }

    public final boolean l(ChatMessage chatMessage, GroupMsgData groupMsgData) {
        InterceptResult invokeLL;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, chatMessage, groupMsgData)) == null) {
            int i = 0;
            if (chatMessage == null || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
                return false;
            }
            if (listMessage.contains(chatMessage)) {
                return true;
            }
            int size = listMessage.size();
            while (i < size) {
                ChatMessage chatMessage2 = listMessage.get(i);
                if (chatMessage2 != null) {
                    if (chatMessage.getSid() == chatMessage2.getSid()) {
                        return true;
                    }
                    if (chatMessage.getSid() < chatMessage2.getSid()) {
                        break;
                    }
                }
                i++;
            }
            listMessage.add(i, chatMessage);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        boolean z2;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, groupMsgData, z) == null) && groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo g = zc7.f().g(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (g != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (!this.f.contains(Long.valueOf(groupId))) {
                    n(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = g.getSid();
            long c2 = dg7.c(g.getPulled_msgId());
            GroupMsgData groupMsgData2 = this.c.get(Long.valueOf(groupId));
            if (groupMsgData2 == null) {
                groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
                this.c.put(Long.valueOf(groupId), groupMsgData2);
            }
            Iterator<ChatMessage> it = listMessage.iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (next.getSid() > sid) {
                    l(next, groupMsgData2);
                }
            }
            listMessage.clear();
            List<ChatMessage> k = k(groupId);
            if (k != null && k.size() > 0) {
                if (!z && sid > 0 && k.get(0).getSid() != 1 + sid) {
                    groupMsgData2.getListMessage().addAll(k);
                } else {
                    listMessage.addAll(k);
                    long sid2 = listMessage.get(listMessage.size() - 1).getSid();
                    j2 = listMessage.get(listMessage.size() - 1).getMsgId();
                    j = sid2;
                    if (z) {
                        this.f.remove(Long.valueOf(groupId));
                    }
                    if (this.f.contains(Long.valueOf(groupId))) {
                        g(j, groupId, groupMsgData.getGroupInfo().getUserType(), j2);
                        return;
                    }
                    return;
                }
            }
            j = sid;
            j2 = c2;
            if (z) {
            }
            if (this.f.contains(Long.valueOf(groupId))) {
            }
        }
    }

    public final void n(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{groupMsgData, linkedList, Long.valueOf(j)}) == null) && groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.d.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.a.sendMessage(message);
            linkedList.clear();
            this.f.add(Long.valueOf(j));
            o(j);
        }
    }
}
