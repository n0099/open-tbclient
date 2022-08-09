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
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.iq5;
import com.repackage.on;
import com.repackage.ut5;
import com.repackage.vt5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static final int FIRST_PN = 0;
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
    public List<on> n;
    public boolean o;
    public b p;
    public BdUniqueId q;
    public long r;
    public int s;
    public HttpMessageListener t;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNewSquareSubListResponseMessage)) {
                AlaNewSquareSubListResponseMessage alaNewSquareSubListResponseMessage = (AlaNewSquareSubListResponseMessage) httpResponsedMessage;
                if (httpResponsedMessage.getOrginalMessage() instanceof AlaNewSquareSubListRequestMessage) {
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
                            this.a.R(liveList);
                        }
                    } else {
                        SpecialLiveFragment.a2(alaNewSquareSubListRequestMessage.tabId);
                        this.a.m.clear();
                        this.a.n.clear();
                        this.a.m = liveList;
                        this.a.k = alaNewSquareSubListResponseMessage.getLiveCount();
                        this.a.l = alaNewSquareSubListResponseMessage.getSortTypeList();
                    }
                    AlaNewSquareSubListModel.E(this.a);
                    AlaNewSquareSubListModel alaNewSquareSubListModel = this.a;
                    alaNewSquareSubListModel.L(alaNewSquareSubListModel.m, this.a.j);
                    if (this.a.p != null) {
                        this.a.p.a(this.a.j);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void onLoadError(int i, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNewSquareSubListModel(d9 d9Var) {
        super(d9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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

    public void L(List<ThreadData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.n = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (this.o) {
                ut5 ut5Var = new ut5();
                iq5 iq5Var = new iq5();
                iq5Var.e = this.i;
                iq5Var.b = this.e;
                iq5Var.c = this.d;
                iq5Var.d = list.get(i);
                ut5Var.a = iq5Var;
                int i2 = i + 1;
                if (i2 < size) {
                    iq5 iq5Var2 = new iq5();
                    iq5Var2.e = this.i;
                    iq5Var2.b = this.e;
                    iq5Var2.c = this.d;
                    iq5Var2.d = list.get(i2);
                    ut5Var.b = iq5Var2;
                }
                this.n.add(ut5Var);
            } else {
                vt5 vt5Var = new vt5();
                iq5 iq5Var3 = new iq5();
                iq5Var3.e = this.i;
                iq5Var3.b = this.e;
                iq5Var3.c = this.d;
                iq5Var3.d = list.get(i);
                vt5Var.a = iq5Var3;
                int i3 = i + 1;
                if (i3 < size) {
                    iq5 iq5Var4 = new iq5();
                    iq5Var4.e = this.i;
                    iq5Var4.b = this.e;
                    iq5Var4.c = this.d;
                    iq5Var4.d = list.get(i3);
                    vt5Var.b = iq5Var4;
                }
                this.n.add(vt5Var);
            }
        }
    }

    public List<on> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.intValue;
    }

    public List<ThreadData> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    public List<String> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void R(List<ThreadData> list) {
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

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.j) {
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
                alaNewSquareSubListRequestMessage.refreshCount = SpecialLiveFragment.m2(i) - 1;
                alaNewSquareSubListRequestMessage.setHttpParams();
                sendMessage(alaNewSquareSubListRequestMessage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T() {
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
            alaNewSquareSubListRequestMessage.refreshCount = SpecialLiveFragment.m2(i);
            alaNewSquareSubListRequestMessage.setHttpParams();
            sendMessage(alaNewSquareSubListRequestMessage);
        }
    }

    public void U(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.o = z;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
        }
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

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : invokeV.intValue;
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
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

    public void setTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.f = i;
        }
    }
}
