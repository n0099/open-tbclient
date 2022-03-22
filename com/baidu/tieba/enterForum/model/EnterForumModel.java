package com.baidu.tieba.enterForum.model;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.d.f.p.m;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.p0.w0.e.h;
import c.a.p0.w0.e.j;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumGuide.ForumGuideResIdl;
import tbclient.ForumGuide.HotSearch;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* loaded from: classes5.dex */
public class EnterForumModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CACHE_KEY = "recently_visited_enter_forum";
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final String FORUMRGUIDE_CACHE_KEY = "forumrguide_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.w0.e.f a;

    /* renamed from: b  reason: collision with root package name */
    public RecentlyVisitedForumData f31898b;

    /* renamed from: c  reason: collision with root package name */
    public f f31899c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a4.m0.b f31900d;

    /* renamed from: e  reason: collision with root package name */
    public long f31901e;

    /* renamed from: f  reason: collision with root package name */
    public long f31902f;

    /* renamed from: g  reason: collision with root package name */
    public long f31903g;

    /* renamed from: h  reason: collision with root package name */
    public long f31904h;
    public CustomMessageListener i;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnterForumModel enterForumModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel, Integer.valueOf(i)};
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
            this.a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.a.N((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, c.a.p0.w0.e.f> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public c.a.p0.w0.e.f doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.o0.r.s.a.f();
                l<byte[]> e2 = c.a.o0.r.s.a.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                c.a.p0.w0.e.f fVar = new c.a.p0.w0.e.f();
                byte[] bArr = e2.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (e2.get(EnterForumModel.FORUMRGUIDE_CACHE_KEY) != null) {
                    fVar.n(true);
                    try {
                        ForumGuideResIdl forumGuideResIdl = (ForumGuideResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumGuideResIdl.class);
                        if (forumGuideResIdl.data != null) {
                            fVar.j(forumGuideResIdl.data);
                        }
                    } catch (Exception unused) {
                        fVar.n(false);
                    }
                    if (fVar.i() && !fVar.a()) {
                        fVar.e().a();
                    }
                } else if (bArr != null) {
                    fVar.n(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            fVar.k(forumRecommendResIdl.data);
                        }
                    } catch (Exception unused2) {
                        fVar.n(false);
                    }
                    if (fVar.i() && !fVar.a()) {
                        fVar.e().a();
                    }
                }
                return fVar;
            }
            return (c.a.p0.w0.e.f) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.p0.w0.e.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                super.onPostExecute(fVar);
                e eVar = new e(this.a);
                eVar.f31907c = 0;
                if (fVar != null && fVar.i()) {
                    eVar.f31906b = true;
                    eVar.f31908d = fVar;
                } else {
                    eVar.f31906b = false;
                    eVar.f31908d = fVar;
                }
                this.a.f31899c.a(eVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f31905b;

        public c(EnterForumModel enterForumModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31905b = enterForumModel;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.o0.r.s.a.f();
                l<String> h2 = c.a.o0.r.s.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
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
                    this.f31905b.f31898b.D(recentlyVisitedForumData.A());
                    this.f31905b.f31898b.E(200);
                }
                this.f31905b.J(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends k0<Object> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        @Override // c.a.o0.c1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.o0.r.s.a.f();
                l<String> h2 = c.a.o0.r.s.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h2 != null && (recentlyVisitedForumData = this.a.f31898b) != null) {
                    h2.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31906b;

        /* renamed from: c  reason: collision with root package name */
        public int f31907c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.w0.e.f f31908d;

        public e(EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.f31906b = false;
            this.f31907c = -1;
            this.f31908d = null;
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(e eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f31899c = null;
        this.f31900d = null;
        this.f31901e = 0L;
        this.f31902f = 0L;
        this.f31903g = 0L;
        this.f31904h = 0L;
        this.i = new a(this, 2016564);
        setUniqueId(BdUniqueId.gen());
        this.f31898b = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.i);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                c.a.p0.w0.e.f fVar = this.a;
                if (fVar == null || fVar.b() == null) {
                    return true;
                }
                return this.a.b().A();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            new b(this).execute(new Void[0]);
            c cVar = new c(this, z);
            cVar.setPriority(3);
            cVar.execute(new Void[0]);
        }
    }

    public c.a.p0.w0.e.f C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.p0.w0.e.f) invokeV.objValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31904h : invokeV.longValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31901e : invokeV.longValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31903g : invokeV.longValue;
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31902f : invokeV.longValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        c.a.p0.w0.e.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TbadkCoreApplication.isLogin() && c.a.o0.r.j0.b.k().h("enter_forum_create_forum", true) && (fVar = this.a) != null && fVar.b() != null) {
                return this.a.b().B();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            B(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) ? K(z, c.a.p0.w0.b.a(2)) : invokeZ.booleanValue;
    }

    public boolean K(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            cancelLoadData();
            ForumGuideRequestMessage forumGuideRequestMessage = new ForumGuideRequestMessage();
            forumGuideRequestMessage.setCallFrom(1);
            forumGuideRequestMessage.setSortType(Integer.valueOf(i == 1 ? 1 : 2));
            this.f31901e = System.currentTimeMillis();
            if (this.f31900d == null) {
                this.f31900d = new c.a.p0.a4.m0.b("forumrecommendStat");
            }
            sendMessage(forumGuideRequestMessage);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void L() {
        c.a.p0.a4.m0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bVar = this.f31900d) == null) {
            return;
        }
        bVar.a();
        this.f31900d = null;
    }

    public void M(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) || hVar == null) {
            return;
        }
        int size = this.f31898b.A().size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.f31898b.A().get(i2);
            if (!m.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(hVar.getId())) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            this.f31898b.A().remove(i);
        }
    }

    public final void N(VisitedForumData visitedForumData) {
        c.a.p0.w0.e.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, visitedForumData) == null) || visitedForumData == null || (fVar = this.a) == null) {
            return;
        }
        int size = fVar.e().b().size();
        for (int i = 0; i < size; i++) {
            if (this.a.e().b().get(i).getId().equals(visitedForumData.getForumId())) {
                this.f31898b.y(visitedForumData);
                this.f31898b.E(200);
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            a0();
        }
    }

    public void P(ForumGuideHttpResponseMessage forumGuideHttpResponseMessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, forumGuideHttpResponseMessage) == null) {
            int downSize = forumGuideHttpResponseMessage.getDownSize();
            long costTime = forumGuideHttpResponseMessage.getCostTime();
            if (StringUtils.isNull(forumGuideHttpResponseMessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
            } else {
                errorString = forumGuideHttpResponseMessage.getErrorString();
            }
            R(forumGuideHttpResponseMessage, forumGuideHttpResponseMessage.hasError(), forumGuideHttpResponseMessage.getError(), errorString, true, downSize, costTime, 0L);
        }
    }

    public void Q(ForumGuideSocketResponseMessage forumGuideSocketResponseMessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, forumGuideSocketResponseMessage) == null) {
            int downSize = forumGuideSocketResponseMessage.getDownSize();
            long costTime = forumGuideSocketResponseMessage.getCostTime();
            if (StringUtils.isNull(forumGuideSocketResponseMessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0c15);
            } else {
                errorString = forumGuideSocketResponseMessage.getErrorString();
            }
            R(forumGuideSocketResponseMessage, forumGuideSocketResponseMessage.hasError(), forumGuideSocketResponseMessage.getError(), errorString, false, downSize, 0L, costTime);
        }
    }

    public void R(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{responsedMessage, Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                this.a = null;
            }
            if (responsedMessage != null) {
                if (responsedMessage instanceof ForumGuideSocketResponseMessage) {
                    U((ForumGuideSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                    T((ForumGuideHttpResponseMessage) responsedMessage);
                }
            }
            S(z, i, str, z2, i2, j, j2);
        }
    }

    public void S(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e eVar = new e(this);
            boolean z3 = !z;
            c.a.p0.a4.m0.b bVar = this.f31900d;
            if (bVar != null) {
                bVar.b(z2, z3, i, str, i2, j, j2);
                this.f31900d = null;
            }
            if (!z && this.a.i()) {
                eVar.f31907c = 1;
                eVar.f31906b = true;
                eVar.f31908d = this.a;
                this.f31899c.a(eVar);
                return;
            }
            if (str != null && str.length() > 0) {
                setErrorString(str);
                eVar.a = str;
            }
            eVar.f31907c = 1;
            eVar.f31906b = false;
            eVar.f31908d = this.a;
            this.f31899c.a(eVar);
        }
    }

    public void T(ForumGuideHttpResponseMessage forumGuideHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, forumGuideHttpResponseMessage) == null) || forumGuideHttpResponseMessage == null) {
            return;
        }
        try {
            this.a = new c.a.p0.w0.e.f();
            j jVar = new j();
            jVar.c(forumGuideHttpResponseMessage.getLikeForum());
            this.a.o(jVar);
            this.a.n(true);
            if (!ListUtils.isEmpty(forumGuideHttpResponseMessage.getHotSearches())) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                hotSearchInfoData.A(((HotSearch) ListUtils.getItem(forumGuideHttpResponseMessage.getHotSearches(), 0)).search_title);
                this.a.m(hotSearchInfoData);
            }
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.C(forumGuideHttpResponseMessage.getForumCreateInfo());
            this.a.l(forumCreateInfoData);
            if (forumGuideHttpResponseMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                this.a.p(((ForumGuideRequestMessage) forumGuideHttpResponseMessage.getOrginalMessage().getExtra()).getSortType().intValue());
            }
        } catch (Exception e2) {
            this.a.n(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void U(ForumGuideSocketResponseMessage forumGuideSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, forumGuideSocketResponseMessage) == null) || forumGuideSocketResponseMessage == null) {
            return;
        }
        try {
            this.a = new c.a.p0.w0.e.f();
            j jVar = new j();
            jVar.c(forumGuideSocketResponseMessage.getLikeForum());
            this.a.o(jVar);
            this.a.n(true);
            if (!ListUtils.isEmpty(forumGuideSocketResponseMessage.getHotSearches())) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                hotSearchInfoData.A(((HotSearch) ListUtils.getItem(forumGuideSocketResponseMessage.getHotSearches(), 0)).search_title);
                this.a.m(hotSearchInfoData);
            }
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.C(forumGuideSocketResponseMessage.getForumCreateInfo());
            this.a.l(forumCreateInfoData);
            if (forumGuideSocketResponseMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                this.a.p(((ForumGuideRequestMessage) forumGuideSocketResponseMessage.getOrginalMessage().getExtra()).getSortType().intValue());
            }
        } catch (Exception e2) {
            this.a.n(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void V(c.a.p0.w0.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.a = fVar;
        }
    }

    public void W(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            SetLikeForumRequestMessage setLikeForumRequestMessage = new SetLikeForumRequestMessage();
            setLikeForumRequestMessage.setOriginalLikeList(str);
            setLikeForumRequestMessage.setMoveList(str2);
            sendMessage(setLikeForumRequestMessage);
        }
    }

    public void X(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fVar) == null) {
            this.f31899c = fVar;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    public List<h> Z(List<h> list, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, list, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                if (strArr != null && strArr.length != 0) {
                    for (String str : strArr) {
                        for (h hVar : list) {
                            if (hVar != null && hVar.r() != null && hVar.r().equals(str)) {
                                arrayList.add(hVar);
                            }
                        }
                    }
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        h hVar2 = list.get(i);
                        if (!arrayList.contains(hVar2)) {
                            arrayList.add(hVar2);
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

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        n0.b(new d(this), null);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            cancelMessage();
            L();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.unique_id : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }
}
