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
import com.baidu.tieba.q77;
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
public final class f2a extends q77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<h77<?>> e;
    public int f;
    public final Map<String, l77> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final e2a j;
    public boolean k;
    public BdUniqueId l;
    public final NetMessageListener m;
    public final d2a n;

    /* loaded from: classes5.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f2a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f2a f2aVar) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2aVar};
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
            this.a = f2aVar;
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
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.f(false);
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
                this.a.a().d = responsedMessage.getError();
                this.a.a().e = responsedMessage.getErrorString();
            } else {
                this.a.a().d = 0;
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                this.a.L(dataRes, z, false);
                this.a.S(dataRes, z);
            }
            q77.a c = this.a.c();
            if (c != null) {
                c.a(this.a.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements d2a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f2a a;

        public b(f2a f2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2aVar;
        }

        @Override // com.baidu.tieba.d2a
        public void a(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                Intrinsics.checkNotNullParameter(dataRes, "dataRes");
                this.a.k = true;
                PageData pageData = dataRes.page_data;
                if (pageData == null || ListUtils.isEmpty(pageData.feed_list)) {
                    this.a.J();
                    return;
                }
                this.a.f(false);
                this.a.a().d = 0;
                this.a.d = dataRes;
                this.a.L(dataRes, true, true);
                q77.a c = this.a.c();
                if (c != null) {
                    c.a(this.a.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2a(Context context) {
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
        this.j = new e2a();
        this.m = new a(this);
        N();
        MessageManager.getInstance().registerListener(this.m);
        O();
        q();
        this.n = new b(this);
    }

    public final void B(uf5 event) {
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
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
            for (Object obj2 : b()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                h77 h77Var = (h77) obj2;
                if (h77Var instanceof r27) {
                    r27 r27Var = (r27) h77Var;
                    if (Intrinsics.areEqual(event.a(), r27Var.c.g())) {
                        Map<String, Object> a2 = r27Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            pw7 pw7Var = new pw7();
                            pw7Var.Y((ClickBackCard) obj);
                            pw7Var.g = r27Var.c.g();
                            if (pw7.U0.c(pw7Var)) {
                                F(new i77(pw7Var, "recommend_topic_card"), i2);
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

    public final void n(List<? extends h77<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (h77<?> h77Var : list) {
                if (h77Var.b() instanceof AdvertAppInfo) {
                    Object b2 = h77Var.b();
                    if (b2 != null) {
                        arrayList.add((yh) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<yh> a2 = wy9.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                rca.g().c(this.l, oca.g("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (bannerList = this.d.banner_list) != null && !bannerList.app.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.d.banner_list.app);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(str, xy9.a((App) it.next()))) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    BannerList.Builder builder = new BannerList.Builder(this.d.banner_list);
                    builder.app = arrayList;
                    DataRes.Builder builder2 = new DataRes.Builder(this.d);
                    builder2.banner_list = builder.build(true);
                    this.j.g(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        w27<?> w27Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Iterator<h77<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                h77<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof r27) && (w27Var = ((r27) next).c) != null) {
                    if (Intrinsics.areEqual(str, w27Var.g())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof i77) {
                    i77 i77Var = (i77) next;
                    if (i77Var.b() instanceof pw7) {
                        Object b2 = i77Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((pw7) b2).g)) {
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

    public final void D(Object data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof ThreadInfo) {
                this.i = (ThreadInfo) data;
            }
        }
    }

    public final void Q(BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, uniqueId) == null) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            this.l = uniqueId;
        }
    }

    public final boolean R(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, dataRes)) == null) {
            Integer num = dataRes.show_adsense;
            if (num != null && num != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void T(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, obj) == null) && obj != null) {
            a().d(obj);
        }
    }

    public final void t(String tid) {
        q77.a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            boolean u = u(tid);
            v(tid);
            if (u && (c = c()) != null) {
                c.a(a());
            }
        }
    }

    public final void C(h77<?> h77Var, Map<String, ? extends ThreadData> map) {
        r27 r27Var;
        w27<?> w27Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, h77Var, map) == null) && (h77Var instanceof r27) && (w27Var = (r27Var = (r27) h77Var).c) != null) {
            String g = w27Var.g();
            if (!TextUtils.isEmpty(g)) {
                r27Var.c.j(map.get(g));
            }
        }
    }

    public final void A(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        q77.a c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<h77<?>> list = a().a;
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
                boolean r = r(str);
                s(str);
                if (r && (c = c()) != null) {
                    c.a(a());
                }
            }
        }
    }

    public final void M(boolean z) {
        m2a m2aVar;
        l2a l2aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            l77 l77Var = this.g.get("card_pei_wan_show");
            n2a n2aVar = null;
            if (l77Var instanceof m2a) {
                m2aVar = (m2a) l77Var;
            } else {
                m2aVar = null;
            }
            if (m2aVar != null) {
                m2aVar.d(!z);
            }
            l77 l77Var2 = this.g.get("card_pei_wan_click");
            if (l77Var2 instanceof l2a) {
                l2aVar = (l2a) l77Var2;
            } else {
                l2aVar = null;
            }
            if (l2aVar != null) {
                l2aVar.d(!z);
            }
            l77 l77Var3 = this.g.get("voice_pei_wan_click");
            if (l77Var3 instanceof n2a) {
                n2aVar = (n2a) l77Var3;
            }
            if (n2aVar != null) {
                n2aVar.d(!z);
            }
        }
    }

    public final Map<String, ThreadData> p(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ThreadInfo threadInfo : list) {
                    if (threadInfo != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.isFromHomPage = true;
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(threadInfo);
                        if (H(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            Iterator<h77<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                h77<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof h77) {
                    h77<?> h77Var = next;
                    if (h77Var.b() instanceof AdvertAppInfo) {
                        Object b2 = h77Var.b();
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

    public final void x(List<h77<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (h77<?> h77Var : list) {
                if (h77Var != null) {
                    String a2 = h77Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(h77Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void E(boolean z, List<h77<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, list) == null) {
            int f = w65.f();
            int e = w65.e();
            int i = 0;
            if (!z && !a().a.isEmpty()) {
                int size = a().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(jka.a(), a().a.get(size).a())) {
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
                e = w65.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<h77<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        nea neaVar = new nea();
                        neaVar.n(true);
                        listIterator.add(new i77(new an6(neaVar, null, 2, null), jka.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public final void G(DataRes dataRes, List<h77<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            int i = 0;
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                if (advertAppInfo.l == null) {
                    i1a.h(advertAppInfo, 1, 100);
                } else {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        i1a.h(advertAppInfo, 1, h);
                    } else {
                        if (advertAppInfo.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo.q)) {
                                    i1a.h(advertAppInfo, 1, 26);
                                } else if (tda.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && yx5.a().o()) {
                                    i1a.h(advertAppInfo, 1, 3);
                                }
                            } catch (Exception unused) {
                                i1a.h(advertAppInfo, 1, 100);
                            }
                        }
                        int i2 = advertAppInfo.position + i;
                        if (i2 >= 0 && list.size() >= i2) {
                            i++;
                            list.add(i2, new i77(advertAppInfo, gka.d(advertAppInfo.b, advertAppInfo.c)));
                        }
                    }
                }
            }
        }
    }

    public void F(h77<?> h77Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, h77Var, i) == null) && h77Var != null && i >= 0 && a().a.size() >= i) {
            a().a.add(i, h77Var);
            q77.a c = c();
            if (c != null) {
                c.a(a());
            }
        }
    }

    public final boolean H(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
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

    public final void P(JSONObject data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, data) == null) {
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

    public final void o(List<h77<?>> list) {
        v47 v47Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            c2a.a.b();
            u27 a2 = c2a.a.a();
            if (a2.d > 0 && (v47Var = y37.a().get("browse_location")) != null) {
                h77<?> templateData = v47Var.b(a2);
                Intrinsics.checkNotNullExpressionValue(templateData, "templateData");
                list.add(0, templateData);
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !d()) {
            f(true);
            if (this.k) {
                J();
            } else {
                this.j.c(this.n);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f = 1;
            MessageManager.getInstance().sendMessage(y(1, 0, null, 1, 0));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !d()) {
            f(true);
            int i = this.f + 1;
            this.f = i;
            MessageManager.getInstance().sendMessage(y(2, 0, null, i, 0));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h.put("page_from", "recommend");
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public final void L(Message message, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{message, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z && !z2) {
            this.e.clear();
            List<h77<?>> list = this.e;
            List<h77<?>> list2 = a().a;
            Intrinsics.checkNotNullExpressionValue(list2, "feedData.dataList");
            list.addAll(list2);
            x(this.e);
            o(this.e);
            a().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            M(z2);
            j37 a2 = a();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            a2.b = i;
            Map<String, ThreadData> p = p(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<h77<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        v47 v47Var = y37.a().get(layoutFactory.layout);
                        if (v47Var != null) {
                            if (v47Var instanceof k77) {
                                ((k77) v47Var).d(this.g);
                            }
                            if (v47Var instanceof l67) {
                                ((l67) v47Var).a(this.h);
                            }
                            if (v47Var instanceof w37) {
                                ((w37) v47Var).c(z2);
                            }
                            h77<?> b2 = v47Var.b(layoutFactory);
                            C(b2, p);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (nw7.l(new DataRes.Builder((DataRes) message))) {
                                nw7 nw7Var = new nw7();
                                nw7Var.i(((DataRes) message).hot_card);
                                arrayList.add(new i77<>(nw7Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.m(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new i77<>(new r07(new f47(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                nta ntaVar = new nta();
                                ntaVar.g(((DataRes) message).header_card);
                                if (tta.p(ntaVar, false)) {
                                    tta ttaVar = new tta();
                                    ttaVar.m(1);
                                    ttaVar.h(ntaVar);
                                    arrayList.add(new i77<>(ttaVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                z();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    fk6 fk6Var = new fk6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    f47 f47Var = new f47();
                    f47Var.a = fk6Var;
                    a().a.add(0, new i77(new r07(f47Var), "ala_live_attention"));
                }
                if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                    G((DataRes) message, arrayList);
                } else if (R((DataRes) message)) {
                    E(z, arrayList);
                }
                a().a.addAll(arrayList);
                n(arrayList);
                Integer num = ((DataRes) message).fresh_ctrl_num;
                Intrinsics.checkNotNullExpressionValue(num, "recommendDataRes.fresh_ctrl_num");
                if (num.intValue() > 0) {
                    int size = a().a.size();
                    Integer num2 = ((DataRes) message).fresh_ctrl_num;
                    Intrinsics.checkNotNullExpressionValue(num2, "recommendDataRes.fresh_ctrl_num");
                    if (size > num2.intValue()) {
                        a().a.addAll(this.e);
                        this.e.clear();
                    }
                }
                if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("key_maintab_banner_close_time", 0L))) {
                    TbSingleton.getInstance().isAddBanner = true;
                }
                if (z && ((DataRes) message).live_answer != null && TbSingleton.getInstance().isAddBanner) {
                    v47 v47Var2 = y37.a().get("recommend_banner");
                    Intrinsics.checkNotNull(v47Var2);
                    h77<?> b3 = v47Var2.b(((DataRes) message).live_answer);
                    if (b3 != null) {
                        a().a.add(0, b3);
                    }
                }
                int size2 = a().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    h77<?> h77Var = a().a.get(i2);
                    if (h77Var instanceof v37) {
                        ((v37) h77Var).setPosition(i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    System.exit(0);
                }
            }
            a().c = true;
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, xda.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.g.put(PageInfo.KEY, new t3a());
            this.g.put("head_click_selector1", new r2a());
            this.g.put("head_click_selector2", new s2a());
            this.g.put("head_click_selector3", new t2a());
            this.g.put("head_click_selector4", new u2a());
            this.g.put("head_click_selector5", new v2a());
            this.g.put("head_click_selector6", new w2a());
            Map<String, l77> map = this.g;
            z2a z2aVar = new z2a();
            z2aVar.d("2");
            map.put("common_click_for_user_head", z2aVar);
            Map<String, l77> map2 = this.g;
            z2a z2aVar2 = new z2a();
            z2aVar2.d("9");
            map2.put("common_click_for_forum_head", z2aVar2);
            Map<String, l77> map3 = this.g;
            z2a z2aVar3 = new z2a();
            z2aVar3.d("3");
            map3.put("image_click4", z2aVar3);
            Map<String, l77> map4 = this.g;
            z2a z2aVar4 = new z2a();
            z2aVar4.d("4");
            map4.put("video_click", z2aVar4);
            Map<String, l77> map5 = this.g;
            z2a z2aVar5 = new z2a();
            z2aVar5.d("1");
            map5.put("live_click2", z2aVar5);
            Map<String, l77> map6 = this.g;
            z2a z2aVar6 = new z2a();
            z2aVar6.d("1");
            map6.put("comment_btn_click", z2aVar6);
            Map<String, l77> map7 = this.g;
            q2a q2aVar = new q2a();
            q2aVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", q2aVar);
            Map<String, l77> map8 = this.g;
            q2a q2aVar2 = new q2a();
            q2aVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", q2aVar2);
            Map<String, l77> map9 = this.g;
            q2a q2aVar3 = new q2a();
            q2aVar3.b("3");
            map9.put("image_click5", q2aVar3);
            Map<String, l77> map10 = this.g;
            q2a q2aVar4 = new q2a();
            q2aVar4.b("4");
            map10.put("video_click2", q2aVar4);
            Map<String, l77> map11 = this.g;
            q2a q2aVar5 = new q2a();
            q2aVar5.b("1");
            map11.put("live_click3", q2aVar5);
            Map<String, l77> map12 = this.g;
            q2a q2aVar6 = new q2a();
            q2aVar6.b("1");
            map12.put("comment_btn_click2", q2aVar6);
            this.g.put("comment_btn_click3", new r3a());
            this.g.put("image_click", new e3a());
            Map<String, l77> map13 = this.g;
            u3a u3aVar = new u3a();
            u3aVar.f(true);
            map13.put("image_click2", u3aVar);
            Map<String, l77> map14 = this.g;
            o3a o3aVar = new o3a();
            o3aVar.f("1");
            map14.put("image_click3", o3aVar);
            this.g.put("image_click_selector1", new d3a());
            this.g.put("user_head_click", new bo6(1));
            this.g.put("video_user_head_click", new b4a());
            this.g.put("live_user_head_click", new h3a());
            this.g.put("forum_head_click", new p2a());
            this.g.put("forum_head_rec_forum_click", new p3a());
            this.g.put("enter_forum_btn_click", new qn6("1"));
            this.g.put("head_local_stat_info", new x2a());
            this.g.put("rich_text_topic_click", new zn6());
            Map<String, l77> map15 = this.g;
            yn6 yn6Var = new yn6();
            yn6Var.b("1");
            map15.put("rich_text_item_click", yn6Var);
            this.g.put("rich_text_video_topic_click", new ao6());
            this.g.put("live_click", new g3a());
            Map<String, l77> map16 = this.g;
            o3a o3aVar2 = new o3a();
            o3aVar2.f("2");
            map16.put("voice_btn_click", o3aVar2);
            this.g.put("reply_user_head_click1", new o2a());
            this.g.put("reply_user_name_click1", new o2a());
            this.g.put("reply_card_click1", new o2a());
            this.g.put("reply_user_head_click2", new u3a());
            this.g.put("reply_user_name_click2", new u3a());
            this.g.put("reply_card_click2", new u3a());
            this.g.put("head_user_follow", new w3a());
            this.g.put("head_user_unfollow", new y3a());
            this.g.put("card_pei_wan_show", new m2a());
            this.g.put("card_pei_wan_click", new l2a());
            this.g.put("voice_pei_wan_click", new n2a());
            this.g.put("bottom_comment_click_selector1", new j2a());
            this.g.put("bottom_share_click_selector1", new k2a());
            this.g.put("bottom_agree_click_selector1", new i2a());
            Map<String, l77> map17 = this.g;
            m3a m3aVar = new m3a();
            m3aVar.b("5");
            map17.put("live_mix_card_forum_head_click", m3aVar);
            Map<String, l77> map18 = this.g;
            m3a m3aVar2 = new m3a();
            m3aVar2.b("4");
            map18.put("live_mix_card_person_head_click", m3aVar2);
            Map<String, l77> map19 = this.g;
            m3a m3aVar3 = new m3a();
            m3aVar3.b("1");
            map19.put("live_mix_card_live_image_click", m3aVar3);
            Map<String, l77> map20 = this.g;
            m3a m3aVar4 = new m3a();
            m3aVar4.b("3");
            map20.put("live_mix_card_video_image_click", m3aVar4);
            Map<String, l77> map21 = this.g;
            m3a m3aVar5 = new m3a();
            m3aVar5.b("2");
            map21.put("live_mix_card_normal_image_click", m3aVar5);
            Map<String, l77> map22 = this.g;
            m3a m3aVar6 = new m3a();
            m3aVar6.b("6");
            map22.put("live_mix_card_share_click", m3aVar6);
            Map<String, l77> map23 = this.g;
            m3a m3aVar7 = new m3a();
            m3aVar7.b("7");
            map23.put("live_mix_card_comment_click", m3aVar7);
            Map<String, l77> map24 = this.g;
            m3a m3aVar8 = new m3a();
            m3aVar8.b("8");
            map24.put("live_mix_card_agree_click", m3aVar8);
        }
    }

    public final void S(DataRes dataRes, boolean z) {
        PageData pageData;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, dataRes, z) == null) {
            if (z) {
                this.j.e();
            }
            if (dataRes == null) {
                return;
            }
            if (z) {
                this.d = dataRes;
                this.j.g(new DataRes.Builder(dataRes));
                this.j.f();
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
                        xy9.c(builder4, i);
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
                this.j.g(builder);
            }
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        PageData pageData;
        FeedLayout feedLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (pageData = this.d.page_data) != null && pageData.feed_list != null) {
                ArrayList arrayList = new ArrayList();
                for (LayoutFactory layoutFactory : this.d.page_data.feed_list) {
                    v27 v27Var = new v27();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        v27Var.b(m67.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, v27Var.a().get("thread_id"))) {
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
                    this.j.g(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final RecPersonalizeRequest y(int i, int i2, sq5 sq5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), sq5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (sq5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(sq5Var.a);
                recPersonalizeRequest.setAdFloorInfo(sq5Var.b);
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

    public final void z() {
        ThreadInfo threadInfo;
        Long l;
        h77<?> h77Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (threadInfo = this.i) == null) {
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
        u(String.valueOf(l));
        v47 v47Var = y37.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (v47Var != null) {
            h77Var = v47Var.b(threadData);
        } else {
            h77Var = null;
        }
        if (h77Var != null) {
            a().a.add(0, h77Var);
        }
        this.i = null;
    }
}
