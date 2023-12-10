package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.fk7;
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class em7 extends rl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context t;
    public final List<List<sb7<?>>> u;
    public final NetMessageListener v;

    @Override // com.baidu.tieba.rl7
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SMART_FRS" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ em7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(em7 em7Var) {
            super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em7Var};
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
            this.a = em7Var;
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
    public em7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
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
        this.t = context;
        this.u = new ArrayList();
        a aVar = new a(this);
        this.v = aVar;
        aVar.setTag(bdUniqueId);
        this.v.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.v);
        L(3);
    }

    @Override // com.baidu.tieba.rl7
    public void H(ti7 responseData, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{responseData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(responseData, "responseData");
            if (z) {
                try {
                    b().a.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (GlobalBuildConfig.isDebug()) {
                        System.exit(0);
                        return;
                    }
                    return;
                }
            }
            List<sb7<?>> c = responseData.b().c(responseData.a(), b(), x(), z2);
            k(r(), s(), y(), c);
            if (z) {
                q67 b = b();
                if (!z2) {
                    i = c.size();
                } else {
                    i = 0;
                }
                b.b = i;
                if (this.u.size() > 0 && this.u.get(0).size() > 0 && Intrinsics.areEqual(this.u.get(0).get(0).a(), "feed_top_card")) {
                    this.u.get(0).remove(0);
                }
                if (this.u.size() > 1 && this.u.get(1).size() > 0 && Intrinsics.areEqual(this.u.get(1).get(0).a(), "browse_location")) {
                    this.u.get(1).remove(0);
                }
                if (this.u.size() > 0) {
                    List<sb7<?>> list = this.u.get(0);
                    fk7.a aVar = fk7.a;
                    Context context = this.t;
                    BdUniqueId o = o();
                    String string = p().getString("forum_id");
                    if (string == null) {
                        string = "";
                    }
                    list.add(0, aVar.a(context, o, string));
                }
                this.u.add(0, c);
            } else {
                this.u.add(c);
            }
            int i2 = 0;
            for (List<sb7<?>> list2 : this.u) {
                i2 += list2.size();
            }
            if (i2 > 300) {
                this.u.remove(this.u.size() / 2);
            }
            b().a.clear();
            for (List<sb7<?>> list3 : this.u) {
                b().a.addAll(list3);
            }
            int size = b().a.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb7<?> sb7Var = b().a.get(i3);
                if (sb7Var instanceof g77) {
                    ((g77) sb7Var).setPosition(i3);
                }
                if (sb7Var instanceof xb7) {
                    ((xb7) sb7Var).e(t());
                }
            }
            b().c = responseData.b().a(responseData.a());
        }
    }

    @Override // com.baidu.tieba.ec7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    @Override // com.baidu.tieba.ec7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || e()) {
            return;
        }
        G();
        i(true);
    }

    @Override // com.baidu.tieba.ec7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || e()) {
            return;
        }
        FrsPageRequestMessage a2 = zl7.a(p());
        a2.setTag(o());
        K(1);
        a2.setPn(w());
        a2.setSortType(z());
        a2.setLoadType(1);
        String g = c37.g(b().a, true);
        Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, true)");
        a2.setAdFloorInfo(g);
        MessageManager.getInstance().sendMessage(a2);
        i(true);
    }
}
