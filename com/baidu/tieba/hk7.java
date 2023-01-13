package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class hk7 implements mk7, ok7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    public CustomMessageListener b;
    public boolean c;
    public long d;
    public boolean e;
    public qk7 f;
    public List<kk7> g;
    public List<kk7> h;
    public ok7 i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hk7 hk7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var, Integer.valueOf(i)};
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
            this.a = hk7Var;
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            uk7 uk7Var;
            ChatRoomInfo a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921766 && (customResponsedMessage.getData() instanceof Map)) {
                Map map = (Map) customResponsedMessage.getData();
                for (kk7 kk7Var : this.a.g) {
                    if ((kk7Var instanceof uk7) && (a = (uk7Var = (uk7) kk7Var).a()) != null && map.containsKey(Long.valueOf(a.getRoomId()))) {
                        uk7Var.c((ChatRoomInfo) map.get(Long.valueOf(a.getRoomId())));
                    }
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hk7(@NonNull TbPageContext tbPageContext, long j, boolean z) {
        this(tbPageContext, j, false, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {tbPageContext, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], ((Long) objArr2[1]).longValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hk7(@NonNull TbPageContext tbPageContext, long j, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.a = tbPageContext;
        this.c = z;
        this.d = j;
        this.e = z2;
    }

    @Override // com.baidu.tieba.mk7
    public void d(@NonNull ok7 ok7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ok7Var) == null) {
            this.i = ok7Var;
        }
    }

    public void i(List<kk7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.g.clear();
        this.g.addAll(list);
        this.i.g(0, e());
    }

    public void q(qk7 qk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, qk7Var) == null) {
            this.f = qk7Var;
        }
    }

    @Override // com.baidu.tieba.mk7
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mk7
    public void detach() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null) {
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    @Override // com.baidu.tieba.mk7
    @NonNull
    public List<kk7> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Collections.unmodifiableList(this.g);
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mk7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.c) {
            if (this.b == null) {
                this.b = new a(this, 2921766);
            }
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.g)) {
            return;
        }
        c(0, e());
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || ListUtils.isEmpty(this.g)) {
            return;
        }
        this.h.clear();
        this.h.addAll(new ArrayList(this.g));
        this.g.clear();
    }

    @Override // com.baidu.tieba.ok7
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && i >= 0 && i2 > 0) {
            a();
            int i3 = (i2 + i) - 1;
            int i4 = 0;
            while (i3 >= i && i3 < a()) {
                this.g.remove(i3);
                i3--;
                i4++;
            }
            ok7 ok7Var = this.i;
            if (ok7Var != null) {
                ok7Var.b(i, i4);
            }
        }
    }

    public void k(List<?> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) && !ListUtils.isEmpty(list) && this.i != null) {
            this.e = z;
            List<kk7> n = n(list);
            if (n == null) {
                return;
            }
            this.g.clear();
            this.g.addAll(n);
            this.i.g(0, e());
        }
    }

    public void l(List<?> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) && !ListUtils.isEmpty(list) && this.i != null) {
            this.e = z;
            List<kk7> n = n(list);
            if (ListUtils.isEmpty(n)) {
                return;
            }
            int a2 = a();
            this.g.clear();
            this.i.b(0, a2);
            this.g.addAll(n);
            this.i.c(0, e());
        }
    }

    @Override // com.baidu.tieba.ok7
    public void c(int i, @NonNull List<kk7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) && this.i != null && !ListUtils.isEmpty(list)) {
            this.i.c(i, list);
        }
    }

    @Override // com.baidu.tieba.ok7
    public void g(int i, @NonNull List<kk7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048583, this, i, list) != null) || list.isEmpty()) {
            return;
        }
        this.g.addAll(i, list);
        ok7 ok7Var = this.i;
        if (ok7Var != null) {
            ok7Var.g(i, list);
        }
    }

    @Nullable
    public final tk7 j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (ListUtils.isEmpty(this.h)) {
                return null;
            }
            for (kk7 kk7Var : this.h) {
                if ((kk7Var instanceof tk7) && str != null) {
                    tk7 tk7Var = (tk7) kk7Var;
                    if (str.equals(tk7Var.a())) {
                        return tk7Var;
                    }
                }
            }
            return null;
        }
        return (tk7) invokeL.objValue;
    }

    @Nullable
    public final List<uk7> o(@Nullable List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof ChatRoomInfo) {
                    arrayList.add(new uk7((ChatRoomInfo) obj, this.e));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final List<kk7> n(@Nullable List list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof ChatGroupInfo) {
                    ChatGroupInfo chatGroupInfo = (ChatGroupInfo) obj;
                    List<uk7> o = o(chatGroupInfo.getRoomInfoList());
                    if (o != null) {
                        if (TextUtils.isEmpty(chatGroupInfo.getName())) {
                            arrayList.add(0, new tk7(o, "", "", false, true, this.e, this.a, this.f));
                        } else {
                            tk7 j = j(chatGroupInfo.getGroupId());
                            String name = chatGroupInfo.getName();
                            String groupId = chatGroupInfo.getGroupId();
                            if (j != null && j.d()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList.add(new tk7(o, name, groupId, z, this.e, this.a, this.f));
                        }
                    }
                } else if (obj instanceof vk7) {
                    vk7 vk7Var = (vk7) obj;
                    arrayList.add(new sk7(vk7Var.a(), vk7Var.b(), this.d));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
