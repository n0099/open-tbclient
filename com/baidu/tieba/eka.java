package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.zb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.ClickBackCard;
import tbclient.FeedLayout;
import tbclient.LayoutFactory;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PageData;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public final class eka extends zb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<nb7<?>> e;
    public int f;
    public final Map<String, ub7> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final dka j;
    public boolean k;
    public BdUniqueId l;
    public a m;
    public final NetMessageListener n;
    public final cka o;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static final class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(eka ekaVar) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ekaVar};
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
            this.a = ekaVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (((com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest) r0).getLoadType() == 1) goto L13;
         */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.i(false);
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RecPersonalizeRequest) {
                        z = true;
                    }
                }
                z = false;
                if (responsedMessage.getError() != 0) {
                    this.a.b().d = responsedMessage.getError();
                    this.a.b().e = responsedMessage.getErrorString();
                } else {
                    this.a.b().d = 0;
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    this.a.M(dataRes, z, false);
                    this.a.V(dataRes, z);
                }
                zb7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements cka {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eka a;

        public c(eka ekaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ekaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ekaVar;
        }

        @Override // com.baidu.tieba.cka
        public void a(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                Intrinsics.checkNotNullParameter(dataRes, "dataRes");
                this.a.k = true;
                PageData pageData = dataRes.page_data;
                if (pageData == null || ListUtils.isEmpty(pageData.feed_list)) {
                    this.a.L();
                    return;
                }
                this.a.i(false);
                this.a.b().d = 0;
                this.a.d = dataRes;
                this.a.M(dataRes, true, true);
                zb7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
                a A = this.a.A();
                if (A != null) {
                    A.a(this.a.j.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eka(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        DataRes build = new DataRes.Builder().build(true);
        Intrinsics.checkNotNullExpressionValue(build, "Builder().build(true)");
        this.d = build;
        this.e = new ArrayList();
        this.f = 1;
        this.g = new HashMap();
        this.h = new HashMap();
        this.j = new dka();
        this.n = new b(this);
        P();
        MessageManager.getInstance().registerListener(this.n);
        Q();
        t();
        O();
        this.o = new c(this);
    }

    public final void E(ph5 event) {
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            int i = 0;
            if (event.a().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            for (Object obj2 : c()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                nb7 nb7Var = (nb7) obj2;
                if (nb7Var instanceof j57) {
                    j57 j57Var = (j57) nb7Var;
                    if (Intrinsics.areEqual(event.a(), j57Var.c.m())) {
                        Map<String, Object> a2 = j57Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            gc8 gc8Var = new gc8();
                            gc8Var.Y((ClickBackCard) obj);
                            gc8Var.g = j57Var.c.m();
                            if (gc8.U0.c(gc8Var)) {
                                I(new ob7(gc8Var, "recommend_topic_card"), i2);
                                return;
                            }
                            return;
                        }
                    } else {
                        continue;
                    }
                }
                i = i2;
            }
        }
    }

    public final void q(List<? extends nb7<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (nb7<?> nb7Var : list) {
                if (nb7Var.b() instanceof AdvertAppInfo) {
                    Object b2 = nb7Var.b();
                    if (b2 != null) {
                        arrayList.add((pi) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<pi> a2 = uga.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                qua.g().c(this.l, nua.g("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (bannerList = this.d.banner_list) != null && !bannerList.app.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.d.banner_list.app);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(str, vga.a((App) it.next()))) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    BannerList.Builder builder = new BannerList.Builder(this.d.banner_list);
                    builder.app = arrayList;
                    DataRes.Builder builder2 = new DataRes.Builder(this.d);
                    builder2.banner_list = builder.build(true);
                    this.j.f(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        s57<?> s57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            Iterator<nb7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                nb7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof j57) && (s57Var = ((j57) next).c) != null) {
                    if (Intrinsics.areEqual(str, s57Var.m())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof ob7) {
                    ob7 ob7Var = (ob7) next;
                    if (ob7Var.b() instanceof gc8) {
                        Object b2 = ob7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((gc8) b2).g)) {
                                it.remove();
                                z = true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.homepage.concern.data.RecommendTopicCardData");
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final void G(Object data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof ThreadInfo) {
                this.i = (ThreadInfo) data;
            }
        }
    }

    public final void S(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public final void T(BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, uniqueId) == null) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            this.l = uniqueId;
        }
    }

    public final boolean U(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, dataRes)) == null) {
            Integer num = dataRes.show_adsense;
            if (num != null && num != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void W(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, obj) == null) && obj != null) {
            b().d(obj);
        }
    }

    public final void w(String tid) {
        zb7.a d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            boolean x = x(tid);
            y(tid);
            if (x && (d = d()) != null) {
                d.a(b());
            }
        }
    }

    public final void F(nb7<?> nb7Var, Map<String, ? extends ThreadData> map) {
        j57 j57Var;
        s57<?> s57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, nb7Var, map) == null) && (nb7Var instanceof j57) && (s57Var = (j57Var = (j57) nb7Var).c) != null) {
            String m = s57Var.m();
            if (!TextUtils.isEmpty(m)) {
                j57Var.c.s(map.get(m));
            }
        }
    }

    public final a A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return (a) invokeV.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f = 1;
            MessageManager.getInstance().sendMessage(B(1, 0, null, 1, 0));
        }
    }

    @Override // com.baidu.tieba.zb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // com.baidu.tieba.zb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && !e()) {
            i(true);
            if (this.k) {
                L();
            } else {
                this.j.b(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.zb7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && !e()) {
            i(true);
            int i = this.f + 1;
            this.f = i;
            MessageManager.getInstance().sendMessage(B(2, 0, null, i, 0));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.h.put("page_from", "recommend");
        }
    }

    public final RecPersonalizeRequest B(int i, int i2, vs5 vs5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), vs5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (vs5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(vs5Var.a);
                recPersonalizeRequest.setAdFloorInfo(vs5Var.b);
            }
            recPersonalizeRequest.setPn(i3);
            recPersonalizeRequest.setSuggestCount(i4);
            recPersonalizeRequest.setNeedForumlist(0);
            recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getPushTid())) {
                String pushTid = TbSingleton.getInstance().getPushTid();
                TbSingleton.getInstance().setPushTid(null);
                long j = JavaTypesHelper.toLong(pushTid, -1L);
                if (j != -1) {
                    recPersonalizeRequest.setPushTid(j);
                }
            }
            return recPersonalizeRequest;
        }
        return (RecPersonalizeRequest) invokeCommon.objValue;
    }

    public final void C() {
        ThreadInfo threadInfo;
        Long l;
        nb7<?> nb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (threadInfo = this.i) == null) {
            return;
        }
        if (threadInfo != null) {
            try {
                l = threadInfo.tid;
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    throw e;
                }
            }
        } else {
            l = null;
        }
        x(String.valueOf(l));
        w87 w87Var = f77.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (w87Var != null) {
            nb7Var = w87Var.b(threadData);
        } else {
            nb7Var = null;
        }
        if (nb7Var != null) {
            b().a.add(0, nb7Var);
        }
        this.i = null;
    }

    public final void D(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        zb7.a d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<nb7<?>> list = b().a;
            boolean z2 = false;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String str = (String) customResponsedMessage.getData();
                if ((str == null || str.length() == 0) ? true : true) {
                    return;
                }
                boolean u = u(str);
                v(str);
                if (u && (d = d()) != null) {
                    d.a(b());
                }
            }
        }
    }

    public final void N(boolean z) {
        lka lkaVar;
        kka kkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            ub7 ub7Var = this.g.get("card_pei_wan_show");
            mka mkaVar = null;
            if (ub7Var instanceof lka) {
                lkaVar = (lka) ub7Var;
            } else {
                lkaVar = null;
            }
            if (lkaVar != null) {
                lkaVar.d(!z);
            }
            ub7 ub7Var2 = this.g.get("card_pei_wan_click");
            if (ub7Var2 instanceof kka) {
                kkaVar = (kka) ub7Var2;
            } else {
                kkaVar = null;
            }
            if (kkaVar != null) {
                kkaVar.d(!z);
            }
            ub7 ub7Var3 = this.g.get("voice_pei_wan_click");
            if (ub7Var3 instanceof mka) {
                mkaVar = (mka) ub7Var3;
            }
            if (mkaVar != null) {
                mkaVar.d(!z);
            }
        }
    }

    public final Map<String, ThreadData> s(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ThreadInfo threadInfo : list) {
                    if (threadInfo != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.isFromHomPage = true;
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(threadInfo);
                        if (K(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            Iterator<nb7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                nb7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof nb7) {
                    nb7<?> nb7Var = next;
                    if (nb7Var.b() instanceof AdvertAppInfo) {
                        Object b2 = nb7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((AdvertAppInfo) b2).a)) {
                                it.remove();
                                z = true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.AdvertAppInfo");
                        }
                    } else {
                        continue;
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final void z(List<nb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (nb7<?> nb7Var : list) {
                if (nb7Var != null) {
                    String a2 = nb7Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(nb7Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void H(boolean z, List<nb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, list) == null) {
            int f = y75.f();
            int e = y75.e();
            int i = 0;
            if (!z && !b().a.isEmpty()) {
                int size = b().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(c37.a(), b().a.get(size).a())) {
                            break;
                        }
                        i2++;
                        if (i3 < 0) {
                            break;
                        }
                        size = i3;
                    }
                }
                if (i2 <= f) {
                    e = f - i2;
                }
            } else {
                e = y75.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<nb7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        lwa lwaVar = new lwa();
                        lwaVar.n(true);
                        listIterator.add(new w27(new u27(lwaVar, v27.d(), false, 4, null), c37.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public final void J(DataRes dataRes, List<nb7<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            int i = 0;
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                if (advertAppInfo.l == null) {
                    gja.h(advertAppInfo, 1, 100);
                } else {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        gja.h(advertAppInfo, 1, h);
                    } else {
                        if (advertAppInfo.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo.q)) {
                                    gja.h(advertAppInfo, 1, 26);
                                } else if (sva.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && a06.a().o()) {
                                    gja.h(advertAppInfo, 1, 3);
                                }
                            } catch (Exception unused) {
                                gja.h(advertAppInfo, 1, 100);
                            }
                        }
                        int i2 = advertAppInfo.position + i;
                        if (i2 >= 0 && list.size() >= i2) {
                            i++;
                            list.add(i2, new w27(advertAppInfo, y27.e(advertAppInfo.b, advertAppInfo.c)));
                        }
                    }
                }
            }
        }
    }

    public void I(nb7<?> nb7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, nb7Var, i) == null) && nb7Var != null && i >= 0 && b().a.size() >= i) {
            b().a.add(i, nb7Var);
            zb7.a d = d();
            if (d != null) {
                d.a(b());
            }
        }
    }

    public final boolean K(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            if (threadData == null || threadData.isShareThread || threadData.itemData != null || threadData.itemStarData != null) {
                return false;
            }
            int i = threadData.threadType;
            if (i != 0 && i != 11 && i != 40) {
                return threadData.isUgcThreadType();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void R(JSONObject data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(data);
            httpMessage.addParam("dislike", jSONArray.toString());
            httpMessage.addParam("dislike_from", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
            httpMessage.setTag(this.l);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void r(List<nb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            bka.a.b();
            q57 a2 = bka.a.a();
            w87 w87Var = f77.a().get("browse_location");
            if (w87Var != null) {
                nb7<?> templateData = w87Var.b(a2);
                Intrinsics.checkNotNullExpressionValue(templateData, "templateData");
                list.add(0, templateData);
            }
        }
    }

    public final void M(Message message, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{message, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z && !z2) {
            this.e.clear();
            List<nb7<?>> list = this.e;
            List<nb7<?>> list2 = b().a;
            Intrinsics.checkNotNullExpressionValue(list2, "feedData.dataList");
            list.addAll(list2);
            z(this.e);
            r(this.e);
            b().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            N(z2);
            m67 b2 = b();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            b2.b = i;
            Map<String, ThreadData> s = s(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<nb7<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        w87 w87Var = f77.a().get(layoutFactory.layout);
                        if (w87Var instanceof q87) {
                            ((q87) w87Var).j();
                        }
                        if (w87Var != null) {
                            if (w87Var instanceof tb7) {
                                ((tb7) w87Var).d(this.g);
                            }
                            if (w87Var instanceof qa7) {
                                ((qa7) w87Var).a(this.h);
                            }
                            if (w87Var instanceof d77) {
                                ((d77) w87Var).c(z2);
                            }
                            nb7<?> b3 = w87Var.b(layoutFactory);
                            F(b3, s);
                            if (b3 != null) {
                                arrayList.add(b3);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (ec8.l(new DataRes.Builder((DataRes) message))) {
                                ec8 ec8Var = new ec8();
                                ec8Var.k(((DataRes) message).hot_card);
                                arrayList.add(new ob7<>(ec8Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.n(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new ob7<>(new e37(new q77(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                lbb lbbVar = new lbb();
                                lbbVar.g(((DataRes) message).header_card);
                                if (rbb.p(lbbVar, false)) {
                                    rbb rbbVar = new rbb();
                                    rbbVar.n(1);
                                    rbbVar.h(lbbVar);
                                    arrayList.add(new ob7<>(rbbVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                C();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    mm6 mm6Var = new mm6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    q77 q77Var = new q77();
                    q77Var.a = mm6Var;
                    b().a.add(0, new ob7(new e37(q77Var), "ala_live_attention"));
                }
                if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                    J((DataRes) message, arrayList);
                } else if (U((DataRes) message)) {
                    H(z, arrayList);
                }
                b().a.addAll(arrayList);
                q(arrayList);
                Integer num = ((DataRes) message).fresh_ctrl_num;
                Intrinsics.checkNotNullExpressionValue(num, "recommendDataRes.fresh_ctrl_num");
                if (num.intValue() > 0) {
                    int size = b().a.size();
                    Integer num2 = ((DataRes) message).fresh_ctrl_num;
                    Intrinsics.checkNotNullExpressionValue(num2, "recommendDataRes.fresh_ctrl_num");
                    if (size > num2.intValue()) {
                        b().a.addAll(this.e);
                        this.e.clear();
                    }
                }
                if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("key_maintab_banner_close_time", 0L))) {
                    TbSingleton.getInstance().isAddBanner = true;
                }
                if (z && ((DataRes) message).live_answer != null && TbSingleton.getInstance().isAddBanner) {
                    w87 w87Var2 = f77.a().get("recommend_banner");
                    Intrinsics.checkNotNull(w87Var2);
                    nb7<?> b4 = w87Var2.b(((DataRes) message).live_answer);
                    if (b4 != null) {
                        b().a.add(0, b4);
                    }
                }
                int size2 = b().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    nb7<?> nb7Var = b().a.get(i2);
                    if (nb7Var instanceof c77) {
                        ((c77) nb7Var).setPosition(i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    System.exit(0);
                }
            }
            b().c = true;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HashMap<String, w87> a2 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("ala_live_attention", new gp6());
            HashMap<String, w87> a3 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("fake_wall", new hp6());
            HashMap<String, w87> a4 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a4, "getItemDataMap()");
            a4.put("recommend_banner", new ip6());
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, wva.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.g.put(PageInfo.KEY, new sla());
            this.g.put("head_click_selector1", new qka());
            this.g.put("head_click_selector2", new rka());
            this.g.put("head_click_selector3", new ska());
            this.g.put("head_click_selector4", new tka());
            this.g.put("head_click_selector5", new uka());
            this.g.put("head_click_selector6", new vka());
            Map<String, ub7> map = this.g;
            yka ykaVar = new yka();
            ykaVar.d("2");
            map.put("common_click_for_user_head", ykaVar);
            Map<String, ub7> map2 = this.g;
            yka ykaVar2 = new yka();
            ykaVar2.d("9");
            map2.put("common_click_for_forum_head", ykaVar2);
            Map<String, ub7> map3 = this.g;
            yka ykaVar3 = new yka();
            ykaVar3.d("3");
            map3.put("image_click4", ykaVar3);
            Map<String, ub7> map4 = this.g;
            yka ykaVar4 = new yka();
            ykaVar4.d("4");
            map4.put("video_click", ykaVar4);
            Map<String, ub7> map5 = this.g;
            yka ykaVar5 = new yka();
            ykaVar5.d("1");
            map5.put("live_click2", ykaVar5);
            Map<String, ub7> map6 = this.g;
            yka ykaVar6 = new yka();
            ykaVar6.d("1");
            map6.put("comment_btn_click", ykaVar6);
            Map<String, ub7> map7 = this.g;
            pka pkaVar = new pka();
            pkaVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", pkaVar);
            Map<String, ub7> map8 = this.g;
            pka pkaVar2 = new pka();
            pkaVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", pkaVar2);
            Map<String, ub7> map9 = this.g;
            pka pkaVar3 = new pka();
            pkaVar3.b("3");
            map9.put("image_click5", pkaVar3);
            Map<String, ub7> map10 = this.g;
            pka pkaVar4 = new pka();
            pkaVar4.b("4");
            map10.put("video_click2", pkaVar4);
            Map<String, ub7> map11 = this.g;
            pka pkaVar5 = new pka();
            pkaVar5.b("1");
            map11.put("live_click3", pkaVar5);
            Map<String, ub7> map12 = this.g;
            pka pkaVar6 = new pka();
            pkaVar6.b("1");
            map12.put("comment_btn_click2", pkaVar6);
            this.g.put("comment_btn_click3", new qla());
            this.g.put("image_click", new dla());
            Map<String, ub7> map13 = this.g;
            tla tlaVar = new tla();
            tlaVar.f(true);
            map13.put("image_click2", tlaVar);
            Map<String, ub7> map14 = this.g;
            nla nlaVar = new nla();
            nlaVar.f("1");
            map14.put("image_click3", nlaVar);
            this.g.put("image_click_selector1", new cla());
            this.g.put("user_head_click", new cq6(1));
            this.g.put("video_user_head_click", new ama());
            this.g.put("live_user_head_click", new gla());
            this.g.put("forum_head_click", new oka());
            this.g.put("forum_head_rec_forum_click", new ola());
            this.g.put("enter_forum_btn_click", new rp6("1"));
            this.g.put("head_local_stat_info", new wka());
            this.g.put("rich_text_topic_click", new aq6());
            Map<String, ub7> map15 = this.g;
            zp6 zp6Var = new zp6();
            zp6Var.b("1");
            map15.put("rich_text_item_click", zp6Var);
            this.g.put("rich_text_video_topic_click", new bq6());
            this.g.put("live_click", new fla());
            Map<String, ub7> map16 = this.g;
            nla nlaVar2 = new nla();
            nlaVar2.f("2");
            map16.put("voice_btn_click", nlaVar2);
            this.g.put("reply_user_head_click1", new nka());
            this.g.put("reply_user_name_click1", new nka());
            this.g.put("reply_card_click1", new nka());
            this.g.put("reply_user_head_click2", new tla());
            this.g.put("reply_user_name_click2", new tla());
            this.g.put("reply_card_click2", new tla());
            this.g.put("head_user_follow", new vla());
            this.g.put("head_user_unfollow", new xla());
            this.g.put("card_pei_wan_show", new lka());
            this.g.put("card_pei_wan_click", new kka());
            this.g.put("voice_pei_wan_click", new mka());
            this.g.put("bottom_comment_click_selector1", new ika());
            this.g.put("bottom_share_click_selector1", new jka());
            this.g.put("bottom_agree_click_selector1", new hka());
            Map<String, ub7> map17 = this.g;
            lla llaVar = new lla();
            llaVar.b("5");
            map17.put("live_mix_card_forum_head_click", llaVar);
            Map<String, ub7> map18 = this.g;
            lla llaVar2 = new lla();
            llaVar2.b("4");
            map18.put("live_mix_card_person_head_click", llaVar2);
            Map<String, ub7> map19 = this.g;
            lla llaVar3 = new lla();
            llaVar3.b("1");
            map19.put("live_mix_card_live_image_click", llaVar3);
            Map<String, ub7> map20 = this.g;
            lla llaVar4 = new lla();
            llaVar4.b("3");
            map20.put("live_mix_card_video_image_click", llaVar4);
            Map<String, ub7> map21 = this.g;
            lla llaVar5 = new lla();
            llaVar5.b("2");
            map21.put("live_mix_card_normal_image_click", llaVar5);
            Map<String, ub7> map22 = this.g;
            lla llaVar6 = new lla();
            llaVar6.b("6");
            map22.put("live_mix_card_share_click", llaVar6);
            Map<String, ub7> map23 = this.g;
            lla llaVar7 = new lla();
            llaVar7.b("7");
            map23.put("live_mix_card_comment_click", llaVar7);
            Map<String, ub7> map24 = this.g;
            lla llaVar8 = new lla();
            llaVar8.b("8");
            map24.put("live_mix_card_agree_click", llaVar8);
        }
    }

    public final void V(DataRes dataRes, boolean z) {
        PageData pageData;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, dataRes, z) == null) {
            if (z) {
                this.j.d();
            }
            if (dataRes == null) {
                return;
            }
            if (z) {
                this.d = dataRes;
                this.j.f(new DataRes.Builder(dataRes));
                this.j.e();
                return;
            }
            DataRes.Builder builder = new DataRes.Builder(this.d);
            PageData.Builder builder2 = new PageData.Builder(this.d.page_data);
            if (builder2.feed_list != null && (pageData = dataRes.page_data) != null && !ListUtils.isEmpty(pageData.feed_list) && builder2.feed_list.size() + dataRes.page_data.feed_list.size() < 30) {
                List<LayoutFactory> list2 = builder2.feed_list;
                List<LayoutFactory> list3 = dataRes.page_data.feed_list;
                Intrinsics.checkNotNullExpressionValue(list3, "dataRes.page_data.feed_list");
                list2.addAll(list3);
                builder.page_data = builder2.build(true);
                BannerList bannerList = dataRes.banner_list;
                if (bannerList != null && !ListUtils.isEmpty(bannerList.app)) {
                    int i = 0;
                    PageData pageData2 = this.d.page_data;
                    if (pageData2 != null && (list = pageData2.feed_list) != null) {
                        i = 0 + list.size();
                    }
                    BannerList.Builder builder3 = new BannerList.Builder(this.d.banner_list);
                    ArrayList arrayList = new ArrayList();
                    for (App app : dataRes.banner_list.app) {
                        App.Builder builder4 = new App.Builder(app);
                        vga.c(builder4, i);
                        App build = builder4.build(true);
                        Intrinsics.checkNotNullExpressionValue(build, "appBuilder.build(true)");
                        arrayList.add(build);
                    }
                    List<App> list4 = builder3.app;
                    if (list4 == null) {
                        builder3.app = arrayList;
                    } else {
                        list4.addAll(arrayList);
                    }
                    builder.banner_list = builder3.build(true);
                }
                DataRes build2 = builder.build(true);
                Intrinsics.checkNotNullExpressionValue(build2, "builder.build(true)");
                this.d = build2;
                this.j.f(builder);
            }
        }
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        PageData pageData;
        FeedLayout feedLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (pageData = this.d.page_data) != null && pageData.feed_list != null) {
                ArrayList arrayList = new ArrayList();
                for (LayoutFactory layoutFactory : this.d.page_data.feed_list) {
                    r57 r57Var = new r57();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        r57Var.b(ra7.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, r57Var.a().get("thread_id"))) {
                            z = true;
                        } else {
                            arrayList.add(layoutFactory);
                        }
                    } else {
                        arrayList.add(layoutFactory);
                    }
                }
                if (z) {
                    PageData.Builder builder = new PageData.Builder(this.d.page_data);
                    builder.feed_list = arrayList;
                    DataRes.Builder builder2 = new DataRes.Builder(this.d);
                    builder2.page_data = builder.build(true);
                    this.j.f(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
