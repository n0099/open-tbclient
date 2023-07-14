package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskHTTPResMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hv4 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<c> a;
    public BdUniqueId b;
    public d05<au4> c;
    public fv4 d;
    public boolean e;
    public final Handler f;
    public kb g;
    public CustomMessageListener h;

    /* loaded from: classes6.dex */
    public class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hv4 hv4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv4Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.hv4$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ev4 ev4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.e = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.a.r(responsedMessage);
                    return;
                }
                e eVar = null;
                eVar = null;
                if (responsedMessage instanceof CompleteTaskHTTPResMsg) {
                    ev4Var = ((CompleteTaskHTTPResMsg) responsedMessage).getData();
                } else if (responsedMessage instanceof CompleteTaskSocketResMsg) {
                    ev4Var = ((CompleteTaskSocketResMsg) responsedMessage).getData();
                } else {
                    ev4Var = null;
                }
                if (ev4Var == null) {
                    return;
                }
                if (this.a.d == null) {
                    this.a.d = new fv4();
                }
                this.a.d.c(ev4Var);
                this.a.d.d();
                Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    au4 au4Var = fVar.a;
                    if (ev4Var != null && ev4Var.x == 1) {
                        au4Var.z = true;
                    }
                    this.a.t(au4Var);
                    eVar = fVar;
                } else if (obj instanceof e) {
                    e eVar2 = (e) obj;
                    this.a.s(eVar2.a);
                    eVar = eVar2;
                } else if (obj instanceof g) {
                    mu4.b().g();
                }
                if (eVar != null) {
                    this.a.a.remove(eVar);
                }
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hv4 hv4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv4Var, Integer.valueOf(i)};
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
            this.a = hv4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                this.a.k(dVar.a);
                this.a.l(dVar.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<gu4> a;
        public List<au4> b;
        public List<au4> c;

        public d() {
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

        public void a(au4 au4Var) {
            List<au4> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) && (list = this.b) != null) {
                list.add(au4Var);
            }
        }

        public void b(gu4 gu4Var) {
            List<gu4> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gu4Var) == null) && (list = this.a) != null) {
                list.add(gu4Var);
            }
        }

        public void c(au4 au4Var) {
            List<au4> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, au4Var) == null) && (list = this.c) != null) {
                list.add(au4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public au4 a;

        public f(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au4Var;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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
    }

    public hv4(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.e = false;
        this.f = new Handler(Looper.getMainLooper(), this);
        this.g = new a(this, CmdConfigHttp.CMD_COMPLETE_TASK, 309627);
        this.h = new b(this, 2921379);
        this.b = bdUniqueId;
        p();
        q();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message.what == 1) {
                x();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o(au4 au4Var) {
        d05<au4> d05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, au4Var) == null) && au4Var != null && (d05Var = this.c) != null) {
            d05Var.a(au4Var);
        }
    }

    public final void t(au4 au4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, au4Var) != null) || au4Var == null) {
            return;
        }
        o(au4Var);
    }

    public void w(d05<au4> d05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, d05Var) == null) {
            this.c = d05Var;
        }
    }

    public final void k(List<gu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList<au4> linkedList = new LinkedList();
        for (gu4 gu4Var : list) {
            if (gu4Var != null && gu4Var.c() != null) {
                au4 c2 = gu4Var.c();
                if (c2.N()) {
                    c2.f0(c2.F());
                    o(c2);
                } else if (c2.d() != 0 && c2.q() != 0) {
                    linkedList.add(c2);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (au4 au4Var : linkedList) {
            if (au4Var != null) {
                HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(au4Var.d()));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    hashMap.put(Integer.valueOf(au4Var.d()), hashSet);
                }
                hashSet.add(Integer.valueOf(au4Var.q()));
            }
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            Iterator it = ((HashSet) entry.getValue()).iterator();
            while (it.hasNext()) {
                sb.append(it.next() + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            try {
                jSONObject.put(String.valueOf(entry.getKey()), sb);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        for (au4 au4Var2 : linkedList) {
            if (au4Var2 != null) {
                gv4.a(jSONObject2, au4Var2.d(), au4Var2.q(), au4Var2.E());
            }
        }
        e eVar = new e(jSONObject.toString());
        eVar.b = jSONObject2.toString();
        this.a.add(eVar);
        u();
    }

    public final void l(List<au4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (au4 au4Var : list) {
            if (au4Var.N()) {
                au4Var.f0(au4Var.F());
                o(au4Var);
            } else {
                this.a.add(new f(au4Var));
            }
        }
        u();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.baidu.tieba.hv4$f */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        e eVar = null;
        Object obj = ((CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra()).extra;
        if (obj instanceof f) {
            f fVar = (f) obj;
            o(fVar.a);
            eVar = fVar;
        } else if (obj instanceof e) {
            eVar = (e) obj;
        }
        if (eVar != null) {
            this.a.remove(eVar);
        }
        u();
    }

    public void m() {
        fv4 fv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (fv4Var = this.d) != null) {
            fv4Var.a();
        }
    }

    public BdUniqueId n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f.sendMessage(obtain);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            gca.h(309627, CompleteTaskSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, gca.a(TbConfig.COMPLETE_TASK_URL, 309627));
            tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g.setTag(n());
            this.h.setTag(n());
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public final void s(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || str == null) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        LinkedList<au4> linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (string != null && (split = string.split(",")) != null) {
                    for (String str2 : split) {
                        au4 au4Var = new au4();
                        au4Var.T(wg.e(next, 0));
                        au4Var.c0(wg.e(str2, 0));
                        if (au4Var.d() != 0 && au4Var.q() != 0) {
                            linkedList.add(au4Var);
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        for (au4 au4Var2 : linkedList) {
            o(au4Var2);
        }
    }

    public void v(String str, int i, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(1048588, this, str, i, str2, obj) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        this.e = true;
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(i);
        completeTaskReqMsg.setTag(this.b);
        completeTaskReqMsg.completeId = str;
        completeTaskReqMsg.setToken(str2);
        completeTaskReqMsg.extra = obj;
        completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public final boolean x() {
        InterceptResult invokeV;
        c peek;
        e eVar;
        String str;
        au4 au4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            try {
                if (this.e || (peek = this.a.peek()) == null) {
                    return false;
                }
                if (peek instanceof f) {
                    f fVar = (f) peek;
                    if (fVar == null || (au4Var = fVar.a) == null) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(String.valueOf(au4Var.d()), String.valueOf(au4Var.q()));
                    v(jSONObject.toString(), 1, au4Var.E(), fVar);
                    return true;
                } else if (!(peek instanceof e) || (eVar = (e) peek) == null || (str = eVar.a) == null) {
                    return false;
                } else {
                    v(str, 1, eVar.b, eVar);
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            return invokeV.booleanValue;
        }
        return false;
    }
}
