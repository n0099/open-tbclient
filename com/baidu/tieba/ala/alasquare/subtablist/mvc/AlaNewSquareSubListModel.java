package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import com.baidu.tieba.ey5;
import com.baidu.tieba.fy5;
import com.baidu.tieba.ov5;
import com.baidu.tieba.r9;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 0;
    public static final int LIVE_FEED_LOAD_MORE = 1;
    public static final int LIVE_FEED_REFRESH_NEW = 0;
    public static HashMap<Integer, Integer> u;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public List<String> l;
    public List<ThreadData> m;
    public List<xn> n;
    public boolean o;
    public b p;
    public BdUniqueId q;
    public long r;
    public int s;
    public HttpMessageListener t;

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void onLoadError(int i, String str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaNewSquareSubListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaNewSquareSubListModel alaNewSquareSubListModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaNewSquareSubListModel, Integer.valueOf(i)};
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
            this.a = alaNewSquareSubListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || !(httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                return;
            }
            AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
            if (!(httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage)) {
                return;
            }
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = (AlaNewSquareSubListRequestMessage) httpResponsedMessage.getOrginalMessage();
            if (httpResponsedMessage.hasError()) {
                if (this.a.p != null) {
                    this.a.p.onLoadError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    return;
                }
                return;
            }
            List<ThreadData> liveList = alaNewSquareSubListResponseMessage.getLiveList();
            this.a.j = alaNewSquareSubListResponseMessage.hasMore();
            this.a.a = alaNewSquareSubListRequestMessage.getPn();
            if (this.a.a != 0 && ListUtils.getCount(this.a.m) != 0) {
                if (ListUtils.getCount(liveList) > 0) {
                    this.a.T(liveList);
                }
            } else {
                AlaNewSquareSubListModel.L(alaNewSquareSubListRequestMessage.tabId);
                this.a.m.clear();
                this.a.n.clear();
                this.a.m = liveList;
                this.a.k = alaNewSquareSubListResponseMessage.getLiveCount();
                this.a.l = alaNewSquareSubListResponseMessage.getSortTypeList();
            }
            AlaNewSquareSubListModel.E(this.a);
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.a;
            alaNewSquareSubListModel.M(alaNewSquareSubListModel.m, this.a.j);
            if (this.a.p != null) {
                this.a.p.a(this.a.j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-222984901, "Lcom/baidu/tieba/ala/alasquare/subtablist/mvc/AlaNewSquareSubListModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-222984901, "Lcom/baidu/tieba/ala/alasquare/subtablist/mvc/AlaNewSquareSubListModel;");
                return;
            }
        }
        u = new HashMap<>();
    }

    public List<xn> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public List<ThreadData> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public List<String> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNewSquareSubListModel(r9 r9Var) {
        super(r9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 20;
        this.f = 0;
        this.g = "";
        this.h = "";
        this.i = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.q = BdUniqueId.gen();
        this.s = 60;
        this.t = new a(this, AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        setUniqueId(this.q);
        this.t.setTag(this.q);
        this.t.setSelfListener(true);
        registerListener(this.t);
    }

    public static /* synthetic */ int E(AlaNewSquareSubListModel alaNewSquareSubListModel) {
        int i = alaNewSquareSubListModel.a;
        alaNewSquareSubListModel.a = i + 1;
        return i;
    }

    public void W(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.o = z;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
        }
    }

    public void setEntryName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.e = str;
        }
    }

    public void setLabelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.d = str;
        }
    }

    public void setLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.h = str;
        }
    }

    public void setLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.g = str;
        }
    }

    public void setSortType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.c = str;
        }
    }

    public static void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            if (u.containsKey(Integer.valueOf(i))) {
                u.put(Integer.valueOf(i), Integer.valueOf(u.get(Integer.valueOf(i)).intValue() + 1));
            } else {
                u.put(Integer.valueOf(i), 2);
            }
        }
    }

    public final void T(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            for (ThreadData threadData : list) {
                String tid = threadData.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    boolean z = false;
                    Iterator<ThreadData> it = this.m.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (tid.equals(it.next().getTid())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.m.add(threadData);
                    }
                }
            }
        }
    }

    public static int Q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) {
            if (u.containsKey(Integer.valueOf(i))) {
                return u.get(Integer.valueOf(i)).intValue();
            }
            u.put(Integer.valueOf(i), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public void M(List<ThreadData> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) && !ListUtils.isEmpty(list)) {
            this.n = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (this.o) {
                    ey5 ey5Var = new ey5();
                    ov5 ov5Var = new ov5();
                    ov5Var.e = this.i;
                    ov5Var.b = this.e;
                    ov5Var.c = this.d;
                    ov5Var.d = list.get(i);
                    ey5Var.a = ov5Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        ov5 ov5Var2 = new ov5();
                        ov5Var2.e = this.i;
                        ov5Var2.b = this.e;
                        ov5Var2.c = this.d;
                        ov5Var2.d = list.get(i2);
                        ey5Var.b = ov5Var2;
                    }
                    this.n.add(ey5Var);
                } else {
                    fy5 fy5Var = new fy5();
                    ov5 ov5Var3 = new ov5();
                    ov5Var3.e = this.i;
                    ov5Var3.b = this.e;
                    ov5Var3.c = this.d;
                    ov5Var3.d = list.get(i);
                    fy5Var.a = ov5Var3;
                    int i3 = i + 1;
                    if (i3 < size) {
                        ov5 ov5Var4 = new ov5();
                        ov5Var4.e = this.i;
                        ov5Var4.b = this.e;
                        ov5Var4.c = this.d;
                        ov5Var4.d = list.get(i3);
                        fy5Var.b = ov5Var4;
                    }
                    this.n.add(fy5Var);
                }
            }
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.j) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.r >= this.s * 30 * 1000) {
                this.r = currentTimeMillis;
            }
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
            alaNewSquareSubListRequestMessage.setPn(this.a);
            alaNewSquareSubListRequestMessage.setPs(this.b);
            alaNewSquareSubListRequestMessage.setSortType(this.c);
            alaNewSquareSubListRequestMessage.setEntryName(this.e);
            alaNewSquareSubListRequestMessage.setLableName(this.d);
            alaNewSquareSubListRequestMessage.setLat(this.h);
            alaNewSquareSubListRequestMessage.setLng(this.g);
            int i = this.f;
            alaNewSquareSubListRequestMessage.tabId = i;
            alaNewSquareSubListRequestMessage.sessionId = this.r;
            alaNewSquareSubListRequestMessage.refreshType = 1;
            alaNewSquareSubListRequestMessage.refreshCount = Q(i) - 1;
            alaNewSquareSubListRequestMessage.setHttpParams();
            sendMessage(alaNewSquareSubListRequestMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a = 0;
            this.r = System.currentTimeMillis();
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
            alaNewSquareSubListRequestMessage.setPn(this.a);
            alaNewSquareSubListRequestMessage.setPs(this.b);
            alaNewSquareSubListRequestMessage.setSortType(this.c);
            alaNewSquareSubListRequestMessage.setEntryName(this.e);
            alaNewSquareSubListRequestMessage.setLableName(this.d);
            alaNewSquareSubListRequestMessage.setLat(this.h);
            alaNewSquareSubListRequestMessage.setLng(this.g);
            int i = this.f;
            alaNewSquareSubListRequestMessage.tabId = i;
            alaNewSquareSubListRequestMessage.sessionId = this.r;
            alaNewSquareSubListRequestMessage.refreshType = 0;
            alaNewSquareSubListRequestMessage.refreshCount = Q(i);
            alaNewSquareSubListRequestMessage.setHttpParams();
            sendMessage(alaNewSquareSubListRequestMessage);
        }
    }
}
