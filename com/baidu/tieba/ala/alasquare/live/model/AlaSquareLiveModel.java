package com.baidu.tieba.ala.alasquare.live.model;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveHttpResponseMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveRequestMessage;
import com.baidu.tieba.ala.alasquare.live.message.AlaSquareLiveSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab;
import com.repackage.d9;
import com.repackage.hq5;
import com.repackage.iq5;
import com.repackage.jk8;
import com.repackage.lq5;
import com.repackage.on;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
/* loaded from: classes3.dex */
public class AlaSquareLiveModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9 a;
    public b b;
    public LinkedList<FunctionListInfo> c;
    public HeadLiveInfo d;
    public List<lq5> e;
    public List<on> f;
    public List<on> g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public List<Long> n;
    public ab o;

    /* loaded from: classes3.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaSquareLiveModel alaSquareLiveModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = alaSquareLiveModel;
        }

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            LinkedList<lq5> linkedList;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.l = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.hasError()) {
                    if (this.a.k) {
                        this.a.k = false;
                    }
                    if (this.a.b != null) {
                        this.a.b.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof AlaSquareLiveSocketResponseMessage) {
                    AlaSquareLiveSocketResponseMessage alaSquareLiveSocketResponseMessage = (AlaSquareLiveSocketResponseMessage) responsedMessage;
                    alaSquareLiveSocketResponseMessage.setPn(this.a.h);
                    z = alaSquareLiveSocketResponseMessage.hasMore();
                    if (this.a.h == 1) {
                        this.a.c.clear();
                        this.a.c.addAll(alaSquareLiveSocketResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveSocketResponseMessage.getCategoryList();
                    this.a.d = alaSquareLiveSocketResponseMessage.getHeadLiveInfo();
                    this.a.m = alaSquareLiveSocketResponseMessage.getIsSmallFollow();
                } else if (responsedMessage instanceof AlaSquareLiveHttpResponseMessage) {
                    AlaSquareLiveHttpResponseMessage alaSquareLiveHttpResponseMessage = (AlaSquareLiveHttpResponseMessage) responsedMessage;
                    alaSquareLiveHttpResponseMessage.setPn(this.a.h);
                    z = alaSquareLiveHttpResponseMessage.hasMore();
                    if (this.a.h == 1) {
                        this.a.c.clear();
                        this.a.c.addAll(alaSquareLiveHttpResponseMessage.getFunctionList());
                    }
                    linkedList = alaSquareLiveHttpResponseMessage.getCategoryList();
                    this.a.d = alaSquareLiveHttpResponseMessage.getHeadLiveInfo();
                    this.a.m = alaSquareLiveHttpResponseMessage.getIsSmallFollow();
                } else {
                    linkedList = null;
                    z = false;
                }
                boolean z2 = this.a.k;
                if (this.a.k) {
                    this.a.k = false;
                    hq5.c(this.a.e, linkedList, this.a.n);
                } else {
                    AlaSquareLiveModel alaSquareLiveModel = this.a;
                    alaSquareLiveModel.e = hq5.g(alaSquareLiveModel.e, linkedList, this.a.i);
                    this.a.j = z;
                }
                this.a.M();
                if (this.a.b != null) {
                    this.a.b.a(z, false, z2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, boolean z2, boolean z3);

        void onLoadError(int i, String str);
    }

    public AlaSquareLiveModel(d9 d9Var, BdUniqueId bdUniqueId, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 1;
        this.j = false;
        this.k = false;
        a aVar = new a(this, AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE);
        this.o = aVar;
        this.a = d9Var;
        this.unique_id = bdUniqueId;
        this.b = bVar;
        registerListener(aVar);
        V();
        this.e = new ArrayList();
        this.c = new LinkedList<>();
    }

    public static void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            jk8.h(AlaCmdConfigSocket.CMD_SQUARE_LIVE, AlaSquareLiveSocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_SQUARE_LIVE, jk8.a(AlaConfig.SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(AlaSquareLiveHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void M() {
        Pair<List<on>, List<on>> d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (d = hq5.d(this.a.getString(R.string.obfuscated_res_0x7f0f11d0), this.e)) == null) {
            return;
        }
        this.f = (List) d.first;
        this.g = (List) d.second;
    }

    public List<Long> N() {
        InterceptResult invokeV;
        iq5 iq5Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.g)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (on onVar : this.g) {
                if ((onVar instanceof iq5) && (threadData = (iq5Var = (iq5) onVar).d) != null && threadData.getThreadAlaInfo() != null) {
                    linkedList.add(Long.valueOf(iq5Var.d.getThreadAlaInfo().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public List<on> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public LinkedList<FunctionListInfo> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (LinkedList) invokeV.objValue;
    }

    public HeadLiveInfo Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (HeadLiveInfo) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public void S(List<Long> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list) || this.k) {
            return;
        }
        this.n = list;
        U();
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            sendMessage(new AlaSquareLiveRequestMessage(1, false));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && hasMore()) {
            this.k = false;
            this.i = true;
            int i = this.h + 1;
            this.h = i;
            sendMessage(new AlaSquareLiveRequestMessage(i, false));
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LinkedList<FunctionListInfo> linkedList = this.c;
            if (linkedList != null) {
                linkedList.clear();
                this.c = null;
            }
            if (this.d != null) {
                this.d = null;
            }
            List<lq5> list = this.e;
            if (list != null) {
                list.clear();
                this.e = null;
            }
            List<on> list2 = this.f;
            if (list2 != null) {
                list2.clear();
                this.f = null;
            }
            List<on> list3 = this.g;
            if (list3 != null) {
                list3.clear();
                this.g = null;
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<lq5> list = this.e;
            if (list != null) {
                list.clear();
            }
            List<on> list2 = this.f;
            if (list2 != null) {
                list2.clear();
            }
            List<on> list3 = this.g;
            if (list3 != null) {
                list3.clear();
            }
            this.l = true;
            this.k = false;
            this.i = false;
            this.h = 1;
            sendMessage(new AlaSquareLiveRequestMessage(1, false));
        }
    }
}
