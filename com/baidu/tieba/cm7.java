package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.forum.model.FrsGeneralTabListReqMsg;
import com.baidu.tieba.forum.model.FrsGeneralTabListResMsg;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.GeneralTabList.DataRes;
/* loaded from: classes5.dex */
public final class cm7 extends ql7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NetMessageListener q;

    /* loaded from: classes5.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cm7 cm7Var) {
            super(CmdConfigHttp.CMD_FRS_COMMON_TAB, 309622);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.C(responsedMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
        super(context, bdUniqueId, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bdUniqueId, "bdUniqueId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        a aVar = new a(this);
        this.q = aVar;
        aVar.setTag(bdUniqueId);
        this.q.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.q);
        J();
    }

    @Override // com.baidu.tieba.ql7
    public void B(si7 responseData, boolean z, boolean z2) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{responseData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            super.B(responseData, z, z2);
            Object a2 = responseData.a();
            if (a2 instanceof DataRes) {
                dataRes = (DataRes) a2;
            } else {
                dataRes = null;
            }
            if (dataRes != null && m().getInt("forum_tab_type") == 100) {
                List<VideoItemData> a3 = lj7.a(dataRes);
                if (!a3.isEmpty()) {
                    String str = a3.get(0).forum_id;
                    if (z) {
                        FrsVideoTabPlayActivityConfig.putVideoTabListByFid(str, a3);
                        return;
                    }
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).clear();
                    FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str).addAll(a3);
                }
            }
        }
    }

    public final String I() {
        InterceptResult invokeV;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 0;
            boolean z = true;
            if (q() != 1) {
                z = false;
            }
            if (!z) {
                i = c37.f(b().a);
            }
            if (z) {
                d = "";
            } else {
                jja f = jja.f();
                d = f.d("FRS_GENERAL_TAB" + v());
            }
            String g = c37.g(b().a, z);
            AdExtParam.a b = AdExtParam.a.b();
            b.g(i);
            b.e(g);
            b.c(d);
            b.f(n());
            String a2 = b.a();
            Intrinsics.checkNotNullExpressionValue(a2, "get().setPreAdThreadCoun…umName(fName).buildJson()");
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsGeneralTabListReqMsg frsGeneralTabListReqMsg = new FrsGeneralTabListReqMsg();
            frsGeneralTabListReqMsg.setTag(l());
            frsGeneralTabListReqMsg.setForumId(m().getLong("forum_id"));
            frsGeneralTabListReqMsg.setTabId(m().getInt("forum_tab_id"));
            frsGeneralTabListReqMsg.setTabType(m().getInt("forum_tab_type"));
            String string = m().getString("forum_tab_name");
            if (string == null) {
                string = "";
            }
            frsGeneralTabListReqMsg.setTabName(string);
            frsGeneralTabListReqMsg.setPn(r());
            frsGeneralTabListReqMsg.setSortType(t());
            frsGeneralTabListReqMsg.setLoadType(q());
            frsGeneralTabListReqMsg.setFrsCommonInfo(p());
            frsGeneralTabListReqMsg.setNewFrs(1);
            frsGeneralTabListReqMsg.set_video_doublerow(z() ? 1 : 0);
            frsGeneralTabListReqMsg.setAdExtParams(I());
            MessageManager.getInstance().sendMessage(frsGeneralTabListReqMsg);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_COMMON_TAB, vva.a(TbConfig.FRS_COMMON_TAB, 309622));
            tbHttpMessageTask.setResponsedClass(FrsGeneralTabListResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.dc7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tieba.dc7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || e()) {
            return;
        }
        E(1);
        D(1);
        K();
        i(true);
    }

    @Override // com.baidu.tieba.dc7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || e()) {
            return;
        }
        E(r() + 1);
        D(2);
        K();
        i(true);
    }
}
