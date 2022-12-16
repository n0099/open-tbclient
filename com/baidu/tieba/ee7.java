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
import com.baidu.tieba.y35;
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
/* loaded from: classes4.dex */
public class ee7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ee7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImMessageCenterPojo> a;
    public final CustomMessageListener b;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ee7 ee7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee7Var, Integer.valueOf(i)};
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
            this.a = ee7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
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
                n35.h0().g0(new y35());
                n35.h0().b0(0);
                n35.h0().a();
                n35.h0().k();
            } else if (customResponsedMessage.getCmd() == 2016010 && this.a.a != null) {
                this.a.u(false);
            }
        }
    }

    public ee7() {
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

    public final void g(ImMessageCenterPojo imMessageCenterPojo, y35 y35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo, y35Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && pe7.a().b()) {
            y35Var.Q(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, y35 y35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, y35Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && se7.a().b()) {
            y35Var.V(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, y35 y35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, y35Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            y35Var.N(imMessageCenterPojo.getUnread_count());
            y35Var.G(imMessageCenterPojo.getLast_content());
            y35Var.B(imMessageCenterPojo.getGroup_name());
        }
    }

    public final void o(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo, list) == null) && imMessageCenterPojo != null && list != null) {
            w(imMessageCenterPojo, list);
            list.add(imMessageCenterPojo);
        }
    }

    public final boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static ee7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (ee7.class) {
                    if (c == null) {
                        c = new ee7();
                    }
                }
            }
            return c;
        }
        return (ee7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, y35 y35Var) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, y35Var) != null) || imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 4 || !qe7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) || StringUtils.isNull(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getUnread_count() <= 0 || (userType = imMessageCenterPojo.getUserType()) == 3) {
            return;
        }
        y35.a aVar = new y35.a();
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
                    y35Var.g().add(aVar);
                    if (userType == 4) {
                    }
                    y35Var.R(y35Var.u() + imMessageCenterPojo.getUnread_count());
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
            String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
            aVar.c = str5;
            aVar.d = str5;
        }
        aVar.f = userType;
        aVar.g = imMessageCenterPojo.getUnread_count();
        y35Var.g().add(aVar);
        if (userType == 4) {
            y35Var.P(y35Var.s() + imMessageCenterPojo.getUnread_count());
        }
        y35Var.R(y35Var.u() + imMessageCenterPojo.getUnread_count());
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, y35 y35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, y35Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && re7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                y35Var.F(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> h = y35Var.h();
                if (h != null) {
                    h.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            y35Var.T(y35Var.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void m(List<y35.a> list, List<y35.a> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) && list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (y35.a aVar : list) {
                if (aVar != null) {
                    for (y35.a aVar2 : list2) {
                        if (aVar2 != null && StringHelper.equals(aVar.a, aVar2.a)) {
                            aVar.h = aVar2.g;
                        }
                    }
                }
            }
        }
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, y35 y35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, y35Var) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> a2 = y35Var.a();
            if (!oe7.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                y35Var.K(y35Var.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    y35Var.E(imMessageCenterPojo.getLast_content());
                } else {
                    y35Var.E(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                a2.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            y35Var.J(y35Var.j() + imMessageCenterPojo.getUnread_count());
        }
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
            if (imMessageCenterPojo.getCustomGroupType() != -7) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return re7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1 || imMessageCenterPojo.getCustomGroupType() != 4) {
                return false;
            }
            return qe7.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return invokeL.booleanValue;
    }

    public final void x(y35 y35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, y35Var) != null) || y35Var == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && p(imMessageCenterPojo)) {
                l(imMessageCenterPojo, y35Var);
                h(imMessageCenterPojo, y35Var);
                i(imMessageCenterPojo, y35Var);
                k(imMessageCenterPojo, y35Var);
                g(imMessageCenterPojo, y35Var);
                j(imMessageCenterPojo, y35Var);
            }
        }
    }

    public final void r(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
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

    public final void s(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
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

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            y35 y35Var = new y35();
            y35Var.I(z);
            x(y35Var);
            y35Var.C();
            y35Var.D();
            y35Var.U(n35.h0().E().w());
            y35Var.L(n35.h0().E().k());
            y35Var.S(n35.h0().E().u());
            y35Var.O(n35.h0().E().q());
            y35Var.M(n35.h0().E().n());
            m(y35Var.g(), n35.h0().E().g());
            if (!p35.d().t()) {
                y35Var.J(0);
            }
            if (!p35.d().v()) {
                y35Var.T(0);
            }
            if (!p35.d().o()) {
                y35Var.R(0);
                y35Var.Q(0);
                y35Var.P(0);
            }
            if (p35.d().f() <= 0) {
                y35Var.J(0);
                y35Var.T(0);
                y35Var.Q(0);
                y35Var.R(0);
                y35Var.P(0);
                y35Var.V(0);
                y35Var.I(false);
            }
            if ((((((y35Var.w() + y35Var.j()) + y35Var.n()) + y35Var.q()) + y35Var.t()) + y35Var.u()) - y35Var.l() <= 0) {
                y35Var.I(false);
            }
            n35.h0().V(y35Var);
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
        if ((interceptable == null || interceptable.invokeLL(1048592, this, imMessageCenterPojo, list) == null) && imMessageCenterPojo != null && list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImMessageCenterPojo imMessageCenterPojo2 = list.get(i);
                if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                    list.remove(i);
                    return;
                }
            }
        }
    }
}
