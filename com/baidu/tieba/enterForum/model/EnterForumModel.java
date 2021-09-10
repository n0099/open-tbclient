package com.baidu.tieba.enterForum.model;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import c.a.e.e.p.k;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.s.q.r1;
import c.a.r0.n0.d.g;
import c.a.r0.n0.d.j;
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
/* loaded from: classes7.dex */
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
    public c.a.r0.n0.d.d f50256e;

    /* renamed from: f  reason: collision with root package name */
    public RecentlyVisitedForumData f50257f;

    /* renamed from: g  reason: collision with root package name */
    public f f50258g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j3.k0.b f50259h;

    /* renamed from: i  reason: collision with root package name */
    public long f50260i;

    /* renamed from: j  reason: collision with root package name */
    public long f50261j;
    public long k;
    public long l;
    public CustomMessageListener m;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f50262a;

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
            this.f50262a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.f50262a.L((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, c.a.r0.n0.d.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f50263a;

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
            this.f50263a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c.a.r0.n0.d.d doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                l<byte[]> e2 = c.a.q0.s.r.a.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c.a.r0.n0.d.d dVar = new c.a.r0.n0.d.d();
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
            return (c.a.r0.n0.d.d) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.r0.n0.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                super.onPostExecute(dVar);
                e eVar = new e(this.f50263a);
                eVar.f50269c = 0;
                if (dVar != null && dVar.i()) {
                    eVar.f50268b = true;
                    eVar.f50270d = dVar;
                } else {
                    eVar.f50268b = false;
                    eVar.f50270d = dVar;
                }
                this.f50263a.f50258g.a(eVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f50264a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f50265b;

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
            this.f50265b = enterForumModel;
            this.f50264a = z;
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
                    this.f50265b.f50257f.B(recentlyVisitedForumData.y());
                    this.f50265b.f50257f.C(200);
                }
                this.f50265b.H(this.f50264a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f50266a;

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
            this.f50266a = enterForumModel;
        }

        @Override // c.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.q0.s.r.a.f();
                l<String> h2 = c.a.q0.s.r.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h2 != null && (recentlyVisitedForumData = this.f50266a.f50257f) != null) {
                    h2.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50267a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f50268b;

        /* renamed from: c  reason: collision with root package name */
        public int f50269c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.r0.n0.d.d f50270d;

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
            this.f50267a = "";
            this.f50268b = false;
            this.f50269c = -1;
            this.f50270d = null;
        }
    }

    /* loaded from: classes7.dex */
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50256e = null;
        this.f50258g = null;
        this.f50259h = null;
        this.f50260i = 0L;
        this.f50261j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = new a(this, 2016564);
        setUniqueId(BdUniqueId.gen());
        this.f50257f = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.m);
    }

    public c.a.r0.n0.d.d A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50256e : (c.a.r0.n0.d.d) invokeV.objValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.longValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50260i : invokeV.longValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.longValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50261j : invokeV.longValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        c.a.r0.n0.d.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TbadkCoreApplication.isLogin() && c.a.q0.s.d0.b.j().g("enter_forum_create_forum", true) && (dVar = this.f50256e) != null && dVar.b() != null) {
                return this.f50256e.b().z();
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
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? I(z, c.a.q0.s.d0.b.j().k("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL)) : invokeZ.booleanValue;
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
            forumrecommendrequestmessage.setForumData(this.f50257f.y());
            this.f50260i = System.currentTimeMillis();
            if (this.f50259h == null) {
                this.f50259h = new c.a.r0.j3.k0.b("forumrecommendStat");
            }
            sendMessage(forumrecommendrequestmessage);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void J() {
        c.a.r0.j3.k0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f50259h) == null) {
            return;
        }
        bVar.a();
        this.f50259h = null;
    }

    public void K(c.a.r0.n0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) || fVar == null) {
            return;
        }
        int size = this.f50257f.y().size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.f50257f.y().get(i3);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.p())) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            this.f50257f.y().remove(i2);
        }
    }

    public final void L(VisitedForumData visitedForumData) {
        c.a.r0.n0.d.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, visitedForumData) == null) || visitedForumData == null || (dVar = this.f50256e) == null) {
            return;
        }
        int size = dVar.e().b().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f50256e.e().b().get(i2).p().equals(visitedForumData.getForumId())) {
                this.f50257f.w(visitedForumData);
                this.f50257f.C(200);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, forumrecommendhttpresponsemessage) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048590, this, forumrecommendsocketresponsemessage) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{responsedMessage, Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (z) {
                this.f50256e = null;
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
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            e eVar = new e(this);
            boolean z3 = !z;
            c.a.r0.j3.k0.b bVar = this.f50259h;
            if (bVar != null) {
                bVar.b(z2, z3, i2, str, i3, j2, j3);
                this.f50259h = null;
            }
            if (!z && this.f50256e.i()) {
                eVar.f50269c = 1;
                eVar.f50268b = true;
                eVar.f50270d = this.f50256e;
                this.f50258g.a(eVar);
                return;
            }
            if (str != null && str.length() > 0) {
                setErrorString(str);
                eVar.f50267a = str;
            }
            eVar.f50269c = 1;
            eVar.f50268b = false;
            eVar.f50270d = this.f50256e;
            this.f50258g.a(eVar);
        }
    }

    public void Q(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, forumrecommendhttpresponsemessage) == null) || forumrecommendhttpresponsemessage == null) {
            return;
        }
        try {
            this.f50256e = new c.a.r0.n0.d.d();
            c.a.r0.n0.f.a.a aVar = new c.a.r0.n0.f.a.a();
            aVar.f(forumrecommendhttpresponsemessage.getForumPopUpInfo());
            this.f50256e.t(aVar);
            this.f50256e.s(forumrecommendhttpresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendhttpresponsemessage.GetLikeForum());
            this.f50256e.n(gVar);
            r1 r1Var = new r1();
            r1Var.o(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
            this.f50256e.p(r1Var);
            this.f50256e.m(true);
            this.f50256e.l(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            this.f50256e.q(forumrecommendhttpresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendhttpresponsemessage.getForumCreateInfo());
            this.f50256e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendhttpresponsemessage.getPrivatePopInfo());
            this.f50256e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendhttpresponsemessage.getTabFeedList());
            this.f50256e.r(jVar);
        } catch (Exception e2) {
            this.f50256e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void R(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, forumrecommendsocketresponsemessage) == null) || forumrecommendsocketresponsemessage == null) {
            return;
        }
        try {
            this.f50256e = new c.a.r0.n0.d.d();
            c.a.r0.n0.f.a.a aVar = new c.a.r0.n0.f.a.a();
            aVar.f(forumrecommendsocketresponsemessage.getForumPopupInfo());
            this.f50256e.t(aVar);
            this.f50256e.s(forumrecommendsocketresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendsocketresponsemessage.GetLikeForum());
            this.f50256e.n(gVar);
            r1 r1Var = new r1();
            r1Var.o(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
            this.f50256e.p(r1Var);
            this.f50256e.m(true);
            this.f50256e.l(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            this.f50256e.q(forumrecommendsocketresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendsocketresponsemessage.getForumCreateInfo());
            this.f50256e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendsocketresponsemessage.getPrivatePopInfo());
            this.f50256e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendsocketresponsemessage.getTabFeedList());
            this.f50256e.r(jVar);
        } catch (Exception e2) {
            this.f50256e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void S(c.a.r0.n0.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.f50256e = dVar;
        }
    }

    public void T(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            this.f50258g = fVar;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
        }
    }

    public List<c.a.r0.n0.d.f> V(List<c.a.r0.n0.d.f> list, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, list, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                if (strArr != null && strArr.length != 0) {
                    for (String str : strArr) {
                        for (c.a.r0.n0.d.f fVar : list) {
                            if (fVar != null && fVar.w() != null && fVar.w().equals(str)) {
                                arrayList.add(fVar);
                            }
                        }
                    }
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.r0.n0.d.f fVar2 = list.get(i2);
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
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        l0.b(new d(this), null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.unique_id : (BdUniqueId) invokeV.objValue;
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
                c.a.r0.n0.d.d dVar = this.f50256e;
                if (dVar == null || dVar.b() == null) {
                    return true;
                }
                return this.f50256e.b().y();
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
