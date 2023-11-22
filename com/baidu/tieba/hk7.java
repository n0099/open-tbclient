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
import com.baidu.tieba.forum.model.FrsPageRequestMessage;
import com.baidu.tieba.ji7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hk7 extends uj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context p;
    public final List<List<ab7<?>>> q;
    public final NetMessageListener r;

    /* loaded from: classes6.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hk7 hk7Var) {
            super(CmdConfigHttp.FRS_HTTP_CMD, 301001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk7Var};
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
            this.a = hk7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.B(responsedMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk7(Context context, BdUniqueId bdUniqueId, Bundle bundle) {
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
        this.p = context;
        this.q = new ArrayList();
        a aVar = new a(this);
        this.r = aVar;
        aVar.setTag(bdUniqueId);
        this.r.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.r);
        E(3);
    }

    @Override // com.baidu.tieba.uj7
    public void A(ih7 responseData, boolean z, boolean z2) {
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
            List<ab7<?>> c = responseData.b().c(responseData.a(), b(), s(), z2);
            if (z) {
                z57 b = b();
                if (!z2) {
                    i = c.size();
                } else {
                    i = 0;
                }
                b.b = i;
                if (this.q.size() > 0 && this.q.get(0).size() > 0 && Intrinsics.areEqual(this.q.get(0).get(0).a(), "feed_top_card")) {
                    this.q.get(0).remove(0);
                }
                if (this.q.size() > 1 && this.q.get(1).size() > 0 && Intrinsics.areEqual(this.q.get(1).get(0).a(), "browse_location")) {
                    this.q.get(1).remove(0);
                }
                if (this.q.size() > 0) {
                    List<ab7<?>> list = this.q.get(0);
                    ji7.a aVar = ji7.a;
                    Context context = this.p;
                    BdUniqueId l = l();
                    String string = m().getString("forum_id");
                    if (string == null) {
                        string = "";
                    }
                    list.add(0, aVar.a(context, l, string));
                }
                this.q.add(0, c);
            } else {
                this.q.add(c);
            }
            int i2 = 0;
            for (List<ab7<?>> list2 : this.q) {
                i2 += list2.size();
            }
            if (i2 > 300) {
                this.q.remove(this.q.size() / 2);
            }
            b().a.clear();
            for (List<ab7<?>> list3 : this.q) {
                b().a.addAll(list3);
            }
            int size = b().a.size();
            for (int i3 = 0; i3 < size; i3++) {
                ab7<?> ab7Var = b().a.get(i3);
                if (ab7Var instanceof p67) {
                    ((p67) ab7Var).setPosition(i3);
                }
                if (ab7Var instanceof fb7) {
                    ((fb7) ab7Var).e(o());
                }
            }
            b().c = responseData.b().a(responseData.a());
        }
    }

    @Override // com.baidu.tieba.mb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    @Override // com.baidu.tieba.mb7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || e()) {
            return;
        }
        z();
        i(true);
    }

    @Override // com.baidu.tieba.mb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || e()) {
            return;
        }
        FrsPageRequestMessage a2 = ck7.a(m());
        a2.setTag(l());
        D(1);
        a2.setPn(r());
        a2.setSortType(t());
        a2.setLoadType(1);
        String g = n27.g(b().a, true);
        Intrinsics.checkNotNullExpressionValue(g, "getAdFloorInfo(feedData.dataList, true)");
        a2.setAdFloorInfo(g);
        MessageManager.getInstance().sendMessage(a2);
        i(true);
    }
}
