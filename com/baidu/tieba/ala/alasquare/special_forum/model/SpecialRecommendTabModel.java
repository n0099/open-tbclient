package com.baidu.tieba.ala.alasquare.special_forum.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.SpecialLiveFragment;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ds5;
import com.repackage.kr5;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.pi;
import com.repackage.qo5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class SpecialRecommendTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public b c;
    public List<nn> d;
    public List<ThreadData> e;
    public long f;
    public int g;
    public HttpMessageListener h;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialRecommendTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialRecommendTabModel specialRecommendTabModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialRecommendTabModel, Integer.valueOf(i)};
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
            this.a = specialRecommendTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            kr5 kr5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021095 && (httpResponsedMessage instanceof AlaSpecialRecommendResponse)) {
                AlaSpecialRecommendResponse alaSpecialRecommendResponse = (AlaSpecialRecommendResponse) httpResponsedMessage;
                if (alaSpecialRecommendResponse.isSuccess()) {
                    if (this.a.a == 0) {
                        SpecialLiveFragment.U++;
                        this.a.d.clear();
                        this.a.e.clear();
                    }
                    boolean z = alaSpecialRecommendResponse.hasMore;
                    if (ListUtils.getCount(alaSpecialRecommendResponse.livesList) > 0) {
                        this.a.K(alaSpecialRecommendResponse.livesList);
                    }
                    SpecialRecommendTabModel specialRecommendTabModel = this.a;
                    specialRecommendTabModel.H(specialRecommendTabModel.e);
                    if (this.a.a == 0 && (kr5Var = alaSpecialRecommendResponse.mSpecialActivityListData) != null) {
                        this.a.I(kr5Var);
                    }
                    SpecialRecommendTabModel.B(this.a);
                    if (this.a.c != null) {
                        this.a.c.b(this.a.d, z);
                    }
                } else if (this.a.c != null) {
                    this.a.c.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str);

        void b(List<nn> list, boolean z);
    }

    public SpecialRecommendTabModel(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.g = 60;
        this.h = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.b = tbPageContext;
        this.d = new LinkedList();
        this.e = new ArrayList();
        MessageManager.getInstance().registerListener(this.h);
    }

    public static /* synthetic */ int B(SpecialRecommendTabModel specialRecommendTabModel) {
        int i = specialRecommendTabModel.a;
        specialRecommendTabModel.a = i + 1;
        return i;
    }

    public void H(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.d = new LinkedList();
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            ds5 ds5Var = new ds5();
            qo5 qo5Var = new qo5();
            qo5Var.d = list.get(i);
            ds5Var.a = qo5Var;
            int i2 = i + 1;
            if (i2 < size) {
                qo5 qo5Var2 = new qo5();
                qo5Var2.d = list.get(i2);
                ds5Var.b = qo5Var2;
            }
            this.d.add(ds5Var);
        }
    }

    public final void I(kr5 kr5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kr5Var) == null) || kr5Var == null || ListUtils.isEmpty(kr5Var.a)) {
            return;
        }
        if (ListUtils.getCount(this.d) > 2) {
            this.d.add(2, kr5Var);
        } else {
            this.d.add(kr5Var);
        }
    }

    public final void J(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
            httpMessage.addParam(Config.PACKAGE_NAME, i);
            httpMessage.addParam("tab_id", 1);
            String str = "N";
            if (ni.z()) {
                if (ni.H()) {
                    str = "1_0";
                } else if (ni.v()) {
                    str = "0_13";
                } else if (ni.u()) {
                    str = "0_3";
                } else if (ni.t()) {
                    str = "0_2";
                }
            }
            httpMessage.addParam("network", str);
            httpMessage.addParam("ua_str", pi.k(this.b.getPageActivity()) + "_" + pi.i(this.b.getPageActivity()) + "_android_" + TbConfig.getVersion());
            httpMessage.addParam("refresh_type", i2);
            httpMessage.addParam("session_id", this.f);
            httpMessage.addParam("big_refresh_count", i3);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void K(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (ThreadData threadData : list) {
                String tid = threadData.getTid();
                if (!TextUtils.isEmpty(tid)) {
                    boolean z = false;
                    Iterator<ThreadData> it = this.e.iterator();
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
                        this.e.add(threadData);
                    }
                }
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f >= this.g * 30 * 1000) {
                this.f = currentTimeMillis;
            }
            J(this.a, 1, SpecialLiveFragment.U - 1);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = 0;
            this.f = System.currentTimeMillis();
            J(0, 0, SpecialLiveFragment.U);
        }
    }

    public void N(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }
}
