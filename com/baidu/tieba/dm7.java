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
public final class dm7 extends rl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NetMessageListener t;

    @Override // com.baidu.tieba.rl7
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "FRS_GENERAL_TAB" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dm7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dm7 dm7Var) {
            super(CmdConfigHttp.CMD_FRS_COMMON_TAB, 309622);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dm7Var};
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
            this.a = dm7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.I(responsedMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
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
        this.t = aVar;
        aVar.setTag(bdUniqueId);
        this.t.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.t);
        P();
    }

    @Override // com.baidu.tieba.rl7
    public void H(ti7 responseData, boolean z, boolean z2) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{responseData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            super.H(responseData, z, z2);
            Object a2 = responseData.a();
            if (a2 instanceof DataRes) {
                dataRes = (DataRes) a2;
            } else {
                dataRes = null;
            }
            if (dataRes != null && p().getInt("forum_tab_type") == 100) {
                List<VideoItemData> a3 = mj7.a(dataRes);
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

    public final String O() {
        InterceptResult invokeV;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 0;
            boolean z = true;
            if (v() != 1) {
                z = false;
            }
            if (!z) {
                i = c37.f(b().a);
            }
            if (z) {
                d = "";
            } else {
                kja f = kja.f();
                d = f.d("FRS_GENERAL_TAB" + B());
            }
            String g = c37.g(b().a, z);
            AdExtParam.a b = AdExtParam.a.b();
            b.g(i);
            b.e(g);
            b.c(d);
            b.f(q());
            String a2 = b.a();
            Intrinsics.checkNotNullExpressionValue(a2, "get().setPreAdThreadCoun…umName(fName).buildJson()");
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrsGeneralTabListReqMsg frsGeneralTabListReqMsg = new FrsGeneralTabListReqMsg();
            frsGeneralTabListReqMsg.setTag(o());
            frsGeneralTabListReqMsg.setForumId(p().getLong("forum_id"));
            frsGeneralTabListReqMsg.setTabId(p().getInt("forum_tab_id"));
            frsGeneralTabListReqMsg.setTabType(p().getInt("forum_tab_type"));
            String string = p().getString("forum_tab_name");
            if (string == null) {
                string = "";
            }
            frsGeneralTabListReqMsg.setTabName(string);
            frsGeneralTabListReqMsg.setPn(w());
            frsGeneralTabListReqMsg.setSortType(z());
            frsGeneralTabListReqMsg.setLoadType(v());
            frsGeneralTabListReqMsg.setFrsCommonInfo(u());
            frsGeneralTabListReqMsg.setNewFrs(1);
            frsGeneralTabListReqMsg.set_video_doublerow(F() ? 1 : 0);
            frsGeneralTabListReqMsg.setAdExtParams(O());
            MessageManager.getInstance().sendMessage(frsGeneralTabListReqMsg);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_COMMON_TAB, wva.a(TbConfig.FRS_COMMON_TAB, 309622));
            tbHttpMessageTask.setResponsedClass(FrsGeneralTabListResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tieba.ec7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    @Override // com.baidu.tieba.ec7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || e()) {
            return;
        }
        K(1);
        J(1);
        Q();
        i(true);
    }

    @Override // com.baidu.tieba.ec7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || e()) {
            return;
        }
        K(w() + 1);
        J(2);
        Q();
        i(true);
    }
}
