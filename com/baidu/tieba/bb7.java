package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.t25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bb7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bb7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImMessageCenterPojo> a;
    public final CustomMessageListener b;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bb7 bb7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb7Var, Integer.valueOf(i)};
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
            this.a = bb7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.s(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.r(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.t(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                if (this.a.a != null) {
                    this.a.a.clear();
                }
                i25.h0().g0(new t25());
                i25.h0().b0(0);
                i25.h0().a();
                i25.h0().k();
            } else if (customResponsedMessage.getCmd() != 2016010 || this.a.a == null) {
            } else {
                this.a.u(false);
            }
        }
    }

    public bb7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.b = new a(this, 0);
        v();
    }

    public static bb7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (bb7.class) {
                    if (c == null) {
                        c = new bb7();
                    }
                }
            }
            return c;
        }
        return (bb7) invokeV.objValue;
    }

    public final boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void g(ImMessageCenterPojo imMessageCenterPojo, t25 t25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo, t25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && lb7.a().b()) {
            t25Var.Q(imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, t25 t25Var) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, t25Var) == null) || imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 4 || !mb7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) || StringUtils.isNull(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getUnread_count() <= 0 || (userType = imMessageCenterPojo.getUserType()) == 3) {
            return;
        }
        t25.a aVar = new t25.a();
        aVar.a = imMessageCenterPojo.getGid();
        aVar.e = imMessageCenterPojo.getGroup_name();
        if (userType == 4) {
            String str4 = null;
            try {
                jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
            } catch (Exception e) {
                e = e;
                str = null;
                str2 = null;
            }
            if (jSONArray.length() == 1) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                str = jSONObject.optString("title", null);
                try {
                    str2 = jSONObject.optString("text", null);
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
                try {
                    str3 = jSONObject.optString(UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, null);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e, true);
                    str3 = null;
                    str4 = str;
                    if (str2 == null) {
                    }
                    if (str4 == null) {
                    }
                    aVar.b = str4;
                    aVar.c = str2;
                    aVar.i = str3;
                    aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                    aVar.f = userType;
                    aVar.g = imMessageCenterPojo.getUnread_count();
                    t25Var.g().add(aVar);
                    if (userType == 4) {
                    }
                    t25Var.R(t25Var.u() + imMessageCenterPojo.getUnread_count());
                }
                str4 = str;
                if (str2 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                    str2 = imMessageCenterPojo.getLast_content();
                }
                if (str4 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                }
                aVar.b = str4;
                aVar.c = str2;
                aVar.i = str3;
                aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                str3 = null;
                str2 = null;
                if (str2 == null) {
                }
                if (str4 == null) {
                }
                aVar.b = str4;
                aVar.c = str2;
                aVar.i = str3;
                aVar.d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            }
        } else {
            String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f03d7, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
            aVar.c = str5;
            aVar.d = str5;
        }
        aVar.f = userType;
        aVar.g = imMessageCenterPojo.getUnread_count();
        t25Var.g().add(aVar);
        if (userType == 4) {
            t25Var.P(t25Var.s() + imMessageCenterPojo.getUnread_count());
        }
        t25Var.R(t25Var.u() + imMessageCenterPojo.getUnread_count());
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, t25 t25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, t25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && nb7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                t25Var.F(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> h = t25Var.h();
                if (h != null) {
                    h.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            t25Var.T(t25Var.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, t25 t25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, t25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && ob7.a().b()) {
            t25Var.V(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, t25 t25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, t25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            t25Var.N(imMessageCenterPojo.getUnread_count());
            t25Var.G(imMessageCenterPojo.getLast_content());
            t25Var.B(imMessageCenterPojo.getGroup_name());
        }
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, t25 t25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, t25Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> a2 = t25Var.a();
            if (!kb7.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                t25Var.K(t25Var.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    t25Var.E(imMessageCenterPojo.getLast_content());
                } else {
                    t25Var.E(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                a2.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            t25Var.J(t25Var.j() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void m(List<t25.a> list, List<t25.a> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) || list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return;
        }
        for (t25.a aVar : list) {
            if (aVar != null) {
                for (t25.a aVar2 : list2) {
                    if (aVar2 != null && StringHelper.equals(aVar.a, aVar2.a)) {
                        aVar.h = aVar2.g;
                    }
                }
            }
        }
    }

    public final void o(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        w(imMessageCenterPojo, list);
        list.add(imMessageCenterPojo);
    }

    public final boolean p(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -4) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return f(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return nb7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() != 1 && imMessageCenterPojo.getCustomGroupType() == 4) {
                return mb7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void r(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean q = q(data);
            if (memoryChangedMessage.getType() == 1) {
                o(data, this.a);
            } else if (memoryChangedMessage.getType() == 2) {
                w(data, this.a);
            }
            u(q);
        }
    }

    public final void s(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.a.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (p(imMessageCenterPojo)) {
                        this.a.add(imMessageCenterPojo);
                    }
                }
            }
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            t25 t25Var = new t25();
            t25Var.I(z);
            x(t25Var);
            t25Var.C();
            t25Var.D();
            t25Var.U(i25.h0().E().w());
            t25Var.L(i25.h0().E().k());
            t25Var.S(i25.h0().E().u());
            t25Var.O(i25.h0().E().q());
            t25Var.M(i25.h0().E().n());
            m(t25Var.g(), i25.h0().E().g());
            if (!k25.d().s()) {
                t25Var.J(0);
            }
            if (!k25.d().u()) {
                t25Var.T(0);
            }
            if (!k25.d().n()) {
                t25Var.R(0);
                t25Var.Q(0);
                t25Var.P(0);
            }
            if (k25.d().f() <= 0) {
                t25Var.J(0);
                t25Var.T(0);
                t25Var.Q(0);
                t25Var.R(0);
                t25Var.P(0);
                t25Var.V(0);
                t25Var.I(false);
            }
            if ((((((t25Var.w() + t25Var.j()) + t25Var.n()) + t25Var.q()) + t25Var.t()) + t25Var.u()) - t25Var.l() <= 0) {
                t25Var.I(false);
            }
            i25.h0().V(t25Var);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.b);
            MessageManager.getInstance().registerListener(2016007, this.b);
            MessageManager.getInstance().registerListener(2016001, this.b);
            MessageManager.getInstance().registerListener(2016010, this.b);
            MessageManager.getInstance().registerListener(2016002, this.b);
        }
    }

    public final void w(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo2 = list.get(i);
            if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                list.remove(i);
                return;
            }
        }
    }

    public final void x(t25 t25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, t25Var) == null) || t25Var == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && p(imMessageCenterPojo)) {
                l(imMessageCenterPojo, t25Var);
                h(imMessageCenterPojo, t25Var);
                i(imMessageCenterPojo, t25Var);
                k(imMessageCenterPojo, t25Var);
                g(imMessageCenterPojo, t25Var);
                j(imMessageCenterPojo, t25Var);
            }
        }
    }
}
