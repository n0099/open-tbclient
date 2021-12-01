package com.baidu.tieba.enterForum.model;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.d.f.p.k;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.s.q.r1;
import c.a.r0.u0.d.g;
import c.a.r0.u0.d.j;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* loaded from: classes10.dex */
public class EnterForumModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static int SORT_TYPE_LEVEL = 1;
    public static int SORT_TYPE_UPTATE = 2;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u0.d.d f43558e;

    /* renamed from: f  reason: collision with root package name */
    public RecentlyVisitedForumData f43559f;

    /* renamed from: g  reason: collision with root package name */
    public f f43560g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.t3.l0.b f43561h;

    /* renamed from: i  reason: collision with root package name */
    public long f43562i;

    /* renamed from: j  reason: collision with root package name */
    public long f43563j;

    /* renamed from: k  reason: collision with root package name */
    public long f43564k;
    public long l;
    public CustomMessageListener m;

    /* loaded from: classes10.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnterForumModel enterForumModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel, Integer.valueOf(i2)};
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
            this.a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.a.L((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes10.dex */
    public class b extends BdAsyncTask<Void, Void, c.a.r0.u0.d.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public b(EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c.a.r0.u0.d.d doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                l<byte[]> e2 = c.a.q0.s.r.a.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c.a.r0.u0.d.d dVar = new c.a.r0.u0.d.d();
                byte[] bArr = e2.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    dVar.m(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            dVar.j(forumRecommendResIdl.data);
                        }
                    } catch (Exception unused) {
                        dVar.m(false);
                    }
                    if (dVar.i() && !dVar.a()) {
                        dVar.e().a();
                    }
                }
                return dVar;
            }
            return (c.a.r0.u0.d.d) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.r0.u0.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                super.onPostExecute(dVar);
                e eVar = new e(this.a);
                eVar.f43567c = 0;
                if (dVar != null && dVar.i()) {
                    eVar.f43566b = true;
                    eVar.f43568d = dVar;
                } else {
                    eVar.f43566b = false;
                    eVar.f43568d = dVar;
                }
                this.a.f43560g.a(eVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f43565b;

        public c(EnterForumModel enterForumModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43565b = enterForumModel;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                l<String> h2 = c.a.q0.s.r.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h2 == null || StringUtils.isNull(h2.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    return (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h2.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (RecentlyVisitedForumData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recentlyVisitedForumData) == null) {
                if (recentlyVisitedForumData != null) {
                    this.f43565b.f43559f.B(recentlyVisitedForumData.y());
                    this.f43565b.f43559f.C(200);
                }
                this.f43565b.H(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public d(EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        @Override // c.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.r.a.f();
                l<String> h2 = c.a.q0.s.r.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h2 != null && (recentlyVisitedForumData = this.a.f43559f) != null) {
                    h2.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f43566b;

        /* renamed from: c  reason: collision with root package name */
        public int f43567c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.r0.u0.d.d f43568d;

        public e(EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.f43566b = false;
            this.f43567c = -1;
            this.f43568d = null;
        }
    }

    /* loaded from: classes10.dex */
    public interface f {
        void a(e eVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(487250585, "Lcom/baidu/tieba/enterForum/model/EnterForumModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(487250585, "Lcom/baidu/tieba/enterForum/model/EnterForumModel;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43558e = null;
        this.f43560g = null;
        this.f43561h = null;
        this.f43562i = 0L;
        this.f43563j = 0L;
        this.f43564k = 0L;
        this.l = 0L;
        this.m = new a(this, 2016564);
        setUniqueId(BdUniqueId.gen());
        this.f43559f = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.m);
    }

    public c.a.r0.u0.d.d A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43558e : (c.a.r0.u0.d.d) invokeV.objValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.longValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43562i : invokeV.longValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43564k : invokeV.longValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43563j : invokeV.longValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        c.a.r0.u0.d.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TbadkCoreApplication.isLogin() && c.a.q0.s.e0.b.j().g("enter_forum_create_forum", true) && (dVar = this.f43558e) != null && dVar.b() != null) {
                return this.f43558e.b().z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean G(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            z(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean H(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? I(z, c.a.q0.s.e0.b.j().k("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL)) : invokeZ.booleanValue;
    }

    public boolean I(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            cancelLoadData();
            forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
            forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
            forumrecommendrequestmessage.set_topic(0);
            forumrecommendrequestmessage.set_recommend(1);
            forumrecommendrequestmessage.set_sortType(Integer.valueOf(i2));
            forumrecommendrequestmessage.setForumData(this.f43559f.y());
            this.f43562i = System.currentTimeMillis();
            if (this.f43561h == null) {
                this.f43561h = new c.a.r0.t3.l0.b("forumrecommendStat");
            }
            sendMessage(forumrecommendrequestmessage);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void J() {
        c.a.r0.t3.l0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f43561h) == null) {
            return;
        }
        bVar.a();
        this.f43561h = null;
    }

    public void K(c.a.r0.u0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) || fVar == null) {
            return;
        }
        int size = this.f43559f.y().size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.f43559f.y().get(i3);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.p())) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            this.f43559f.y().remove(i2);
        }
    }

    public final void L(VisitedForumData visitedForumData) {
        c.a.r0.u0.d.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, visitedForumData) == null) || visitedForumData == null || (dVar = this.f43558e) == null) {
            return;
        }
        int size = dVar.e().b().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f43558e.e().b().get(i2).p().equals(visitedForumData.getForumId())) {
                this.f43559f.w(visitedForumData);
                this.f43559f.C(200);
            }
        }
    }

    public void M(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, forumrecommendhttpresponsemessage) == null) {
            int downSize = forumrecommendhttpresponsemessage.getDownSize();
            long costTime = forumrecommendhttpresponsemessage.getCostTime();
            if (StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
            } else {
                errorString = forumrecommendhttpresponsemessage.getErrorString();
            }
            O(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
        }
    }

    public void N(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, forumrecommendsocketresponsemessage) == null) {
            int downSize = forumrecommendsocketresponsemessage.getDownSize();
            long costTime = forumrecommendsocketresponsemessage.getCostTime();
            if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.neterror);
            } else {
                errorString = forumrecommendsocketresponsemessage.getErrorString();
            }
            O(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), errorString, false, downSize, 0L, costTime);
        }
    }

    public void O(ResponsedMessage<?> responsedMessage, boolean z, int i2, String str, boolean z2, int i3, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{responsedMessage, Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (z) {
                this.f43558e = null;
            }
            if (responsedMessage != null) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    R((forumRecommendSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    Q((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
            P(z, i2, str, z2, i3, j2, j3);
        }
    }

    public void P(boolean z, int i2, String str, boolean z2, int i3, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            e eVar = new e(this);
            boolean z3 = !z;
            c.a.r0.t3.l0.b bVar = this.f43561h;
            if (bVar != null) {
                bVar.b(z2, z3, i2, str, i3, j2, j3);
                this.f43561h = null;
            }
            if (!z && this.f43558e.i()) {
                eVar.f43567c = 1;
                eVar.f43566b = true;
                eVar.f43568d = this.f43558e;
                this.f43560g.a(eVar);
                return;
            }
            if (str != null && str.length() > 0) {
                setErrorString(str);
                eVar.a = str;
            }
            eVar.f43567c = 1;
            eVar.f43566b = false;
            eVar.f43568d = this.f43558e;
            this.f43560g.a(eVar);
        }
    }

    public void Q(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, forumrecommendhttpresponsemessage) == null) || forumrecommendhttpresponsemessage == null) {
            return;
        }
        try {
            this.f43558e = new c.a.r0.u0.d.d();
            c.a.r0.u0.f.a.a aVar = new c.a.r0.u0.f.a.a();
            aVar.f(forumrecommendhttpresponsemessage.getForumPopUpInfo());
            this.f43558e.t(aVar);
            this.f43558e.s(forumrecommendhttpresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendhttpresponsemessage.GetLikeForum());
            this.f43558e.n(gVar);
            r1 r1Var = new r1();
            r1Var.o(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
            this.f43558e.p(r1Var);
            this.f43558e.m(true);
            this.f43558e.l(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            this.f43558e.q(forumrecommendhttpresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendhttpresponsemessage.getForumCreateInfo());
            this.f43558e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendhttpresponsemessage.getPrivatePopInfo());
            this.f43558e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendhttpresponsemessage.getTabFeedList());
            this.f43558e.r(jVar);
        } catch (Exception e2) {
            this.f43558e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void R(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, forumrecommendsocketresponsemessage) == null) || forumrecommendsocketresponsemessage == null) {
            return;
        }
        try {
            this.f43558e = new c.a.r0.u0.d.d();
            c.a.r0.u0.f.a.a aVar = new c.a.r0.u0.f.a.a();
            aVar.f(forumrecommendsocketresponsemessage.getForumPopupInfo());
            this.f43558e.t(aVar);
            this.f43558e.s(forumrecommendsocketresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendsocketresponsemessage.GetLikeForum());
            this.f43558e.n(gVar);
            r1 r1Var = new r1();
            r1Var.o(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
            this.f43558e.p(r1Var);
            this.f43558e.m(true);
            this.f43558e.l(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            this.f43558e.q(forumrecommendsocketresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendsocketresponsemessage.getForumCreateInfo());
            this.f43558e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendsocketresponsemessage.getPrivatePopInfo());
            this.f43558e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendsocketresponsemessage.getTabFeedList());
            this.f43558e.r(jVar);
        } catch (Exception e2) {
            this.f43558e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void S(c.a.r0.u0.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.f43558e = dVar;
        }
    }

    public void T(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.f43560g = fVar;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public List<c.a.r0.u0.d.f> V(List<c.a.r0.u0.d.f> list, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, list, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                if (strArr != null && strArr.length != 0) {
                    for (String str : strArr) {
                        for (c.a.r0.u0.d.f fVar : list) {
                            if (fVar != null && fVar.w() != null && fVar.w().equals(str)) {
                                arrayList.add(fVar);
                            }
                        }
                    }
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.r0.u0.d.f fVar2 = list.get(i2);
                        if (!arrayList.contains(fVar2)) {
                            arrayList.add(fVar2);
                        }
                    }
                } else {
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        l0.b(new d(this), null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            cancelMessage();
            J();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.unique_id : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            W();
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                c.a.r0.u0.d.d dVar = this.f43558e;
                if (dVar == null || dVar.b() == null) {
                    return true;
                }
                return this.f43558e.b().y();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            new b(this).execute(new Void[0]);
            c cVar = new c(this, z);
            cVar.setPriority(3);
            cVar.execute(new Void[0]);
        }
    }
}
