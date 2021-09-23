package com.baidu.tieba.ala.alasquare.subtablist.mvc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.l.e.n;
import c.a.q0.s.q.d2;
import c.a.r0.v.f.a.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListRequestMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class AlaNewSquareSubListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static final int FIRST_PN = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49699e;

    /* renamed from: f  reason: collision with root package name */
    public int f49700f;

    /* renamed from: g  reason: collision with root package name */
    public String f49701g;

    /* renamed from: h  reason: collision with root package name */
    public String f49702h;

    /* renamed from: i  reason: collision with root package name */
    public String f49703i;

    /* renamed from: j  reason: collision with root package name */
    public int f49704j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public List<String> p;
    public List<d2> q;
    public List<n> r;
    public boolean s;
    public b t;
    public BdUniqueId u;
    public long v;
    public int w;
    public HttpMessageListener x;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaNewSquareSubListModel f49705a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaNewSquareSubListModel alaNewSquareSubListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaNewSquareSubListModel, Integer.valueOf(i2)};
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
            this.f49705a = alaNewSquareSubListModel;
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
                        if (this.f49705a.t != null) {
                            this.f49705a.t.onLoadError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    List<d2> liveList = alaNewSquareSubListResponseMessage.getLiveList();
                    this.f49705a.n = alaNewSquareSubListResponseMessage.hasMore();
                    this.f49705a.f49699e = alaNewSquareSubListRequestMessage.getPn();
                    if (this.f49705a.f49699e != 0 && ListUtils.getCount(this.f49705a.q) != 0) {
                        if (ListUtils.getCount(liveList) > 0) {
                            this.f49705a.O(liveList);
                        }
                    } else {
                        SpecialLiveFragment.addRefreshNewCountYYTab(alaNewSquareSubListRequestMessage.tabId);
                        this.f49705a.q.clear();
                        this.f49705a.r.clear();
                        this.f49705a.q = liveList;
                        this.f49705a.o = alaNewSquareSubListResponseMessage.getLiveCount();
                        this.f49705a.p = alaNewSquareSubListResponseMessage.getSortTypeList();
                    }
                    AlaNewSquareSubListModel.B(this.f49705a);
                    AlaNewSquareSubListModel alaNewSquareSubListModel = this.f49705a;
                    alaNewSquareSubListModel.I(alaNewSquareSubListModel.q, this.f49705a.n);
                    if (this.f49705a.t != null) {
                        this.f49705a.t.a(this.f49705a.n);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);

        void onLoadError(int i2, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNewSquareSubListModel(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49699e = 0;
        this.f49700f = 20;
        this.f49704j = 0;
        this.k = "";
        this.l = "";
        this.m = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.u = BdUniqueId.gen();
        this.w = 60;
        this.x = new a(this, AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        setUniqueId(this.u);
        this.x.setTag(this.u);
        this.x.setSelfListener(true);
        registerListener(this.x);
    }

    public static /* synthetic */ int B(AlaNewSquareSubListModel alaNewSquareSubListModel) {
        int i2 = alaNewSquareSubListModel.f49699e;
        alaNewSquareSubListModel.f49699e = i2 + 1;
        return i2;
    }

    public void I(List<d2> list, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.r = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (this.s) {
                c.a.r0.v.f.h.b.a aVar = new c.a.r0.v.f.h.b.a();
                c cVar = new c();
                cVar.f25493i = this.m;
                cVar.f25490f = this.f49703i;
                cVar.f25491g = this.f49702h;
                cVar.f25492h = list.get(i2);
                aVar.f25881e = cVar;
                int i3 = i2 + 1;
                if (i3 < size) {
                    c cVar2 = new c();
                    cVar2.f25493i = this.m;
                    cVar2.f25490f = this.f49703i;
                    cVar2.f25491g = this.f49702h;
                    cVar2.f25492h = list.get(i3);
                    aVar.f25882f = cVar2;
                }
                this.r.add(aVar);
            } else {
                c.a.r0.v.f.h.b.b bVar = new c.a.r0.v.f.h.b.b();
                c cVar3 = new c();
                cVar3.f25493i = this.m;
                cVar3.f25490f = this.f49703i;
                cVar3.f25491g = this.f49702h;
                cVar3.f25492h = list.get(i2);
                bVar.f25884e = cVar3;
                int i4 = i2 + 1;
                if (i4 < size) {
                    c cVar4 = new c();
                    cVar4.f25493i = this.m;
                    cVar4.f25490f = this.f49703i;
                    cVar4.f25491g = this.f49702h;
                    cVar4.f25492h = list.get(i4);
                    bVar.f25885f = cVar4;
                }
                this.r.add(bVar);
            }
        }
    }

    public List<n> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.r : (List) invokeV.objValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.intValue;
    }

    public List<d2> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<String> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (List) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void O(List<d2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            for (d2 d2Var : list) {
                String s1 = d2Var.s1();
                if (!TextUtils.isEmpty(s1)) {
                    boolean z = false;
                    Iterator<d2> it = this.q.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (s1.equals(it.next().s1())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        this.q.add(d2Var);
                    }
                }
            }
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.n) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.v >= this.w * 30 * 1000) {
                    this.v = currentTimeMillis;
                }
                AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
                alaNewSquareSubListRequestMessage.setPn(this.f49699e);
                alaNewSquareSubListRequestMessage.setPs(this.f49700f);
                alaNewSquareSubListRequestMessage.setSortType(this.f49701g);
                alaNewSquareSubListRequestMessage.setEntryName(this.f49703i);
                alaNewSquareSubListRequestMessage.setLableName(this.f49702h);
                alaNewSquareSubListRequestMessage.setLat(this.l);
                alaNewSquareSubListRequestMessage.setLng(this.k);
                int i2 = this.f49704j;
                alaNewSquareSubListRequestMessage.tabId = i2;
                alaNewSquareSubListRequestMessage.sessionId = this.v;
                alaNewSquareSubListRequestMessage.refreshType = 1;
                alaNewSquareSubListRequestMessage.refreshCount = SpecialLiveFragment.getRefreshNewCountYYTab(i2) - 1;
                alaNewSquareSubListRequestMessage.setHttpParams();
                sendMessage(alaNewSquareSubListRequestMessage);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f49699e = 0;
            this.v = System.currentTimeMillis();
            AlaNewSquareSubListRequestMessage alaNewSquareSubListRequestMessage = new AlaNewSquareSubListRequestMessage();
            alaNewSquareSubListRequestMessage.setPn(this.f49699e);
            alaNewSquareSubListRequestMessage.setPs(this.f49700f);
            alaNewSquareSubListRequestMessage.setSortType(this.f49701g);
            alaNewSquareSubListRequestMessage.setEntryName(this.f49703i);
            alaNewSquareSubListRequestMessage.setLableName(this.f49702h);
            alaNewSquareSubListRequestMessage.setLat(this.l);
            alaNewSquareSubListRequestMessage.setLng(this.k);
            int i2 = this.f49704j;
            alaNewSquareSubListRequestMessage.tabId = i2;
            alaNewSquareSubListRequestMessage.sessionId = this.v;
            alaNewSquareSubListRequestMessage.refreshType = 0;
            alaNewSquareSubListRequestMessage.refreshCount = SpecialLiveFragment.getRefreshNewCountYYTab(i2);
            alaNewSquareSubListRequestMessage.setHttpParams();
            sendMessage(alaNewSquareSubListRequestMessage);
        }
    }

    public void R(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.t = bVar;
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s = z;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f49699e : invokeV.intValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    public void setEntryName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f49703i = str;
        }
    }

    public void setLabelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f49702h = str;
        }
    }

    public void setLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.l = str;
        }
    }

    public void setLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.k = str;
        }
    }

    public void setSortType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f49701g = str;
        }
    }

    public void setTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f49704j = i2;
        }
    }
}
