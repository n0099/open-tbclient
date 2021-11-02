package com.baidu.tieba.enterForum.model;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.d.l;
import b.a.e.e.p.k;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.s.q.r1;
import b.a.r0.o0.d.g;
import b.a.r0.o0.d.j;
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
/* loaded from: classes9.dex */
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
    public b.a.r0.o0.d.d f47692e;

    /* renamed from: f  reason: collision with root package name */
    public RecentlyVisitedForumData f47693f;

    /* renamed from: g  reason: collision with root package name */
    public f f47694g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.l3.l0.b f47695h;

    /* renamed from: i  reason: collision with root package name */
    public long f47696i;
    public long j;
    public long k;
    public long l;
    public CustomMessageListener m;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f47697a;

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
            this.f47697a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.f47697a.L((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, b.a.r0.o0.d.d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f47698a;

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
            this.f47698a = enterForumModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public b.a.r0.o0.d.d doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                l<byte[]> e2 = b.a.q0.s.r.a.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                b.a.r0.o0.d.d dVar = new b.a.r0.o0.d.d();
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
            return (b.a.r0.o0.d.d) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(b.a.r0.o0.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                super.onPostExecute(dVar);
                e eVar = new e(this.f47698a);
                eVar.f47704c = 0;
                if (dVar != null && dVar.i()) {
                    eVar.f47703b = true;
                    eVar.f47705d = dVar;
                } else {
                    eVar.f47703b = false;
                    eVar.f47705d = dVar;
                }
                this.f47698a.f47694g.a(eVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f47699a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f47700b;

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
            this.f47700b = enterForumModel;
            this.f47699a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                l<String> h2 = b.a.q0.s.r.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
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
                    this.f47700b.f47693f.B(recentlyVisitedForumData.y());
                    this.f47700b.f47693f.C(200);
                }
                this.f47700b.H(this.f47699a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumModel f47701a;

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
            this.f47701a = enterForumModel;
        }

        @Override // b.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.r.a.f();
                l<String> h2 = b.a.q0.s.r.a.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h2 != null && (recentlyVisitedForumData = this.f47701a.f47693f) != null) {
                    h2.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f47702a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f47703b;

        /* renamed from: c  reason: collision with root package name */
        public int f47704c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.r0.o0.d.d f47705d;

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
            this.f47702a = "";
            this.f47703b = false;
            this.f47704c = -1;
            this.f47705d = null;
        }
    }

    /* loaded from: classes9.dex */
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47692e = null;
        this.f47694g = null;
        this.f47695h = null;
        this.f47696i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = new a(this, 2016564);
        setUniqueId(BdUniqueId.gen());
        this.f47693f = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.m);
    }

    public b.a.r0.o0.d.d A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47692e : (b.a.r0.o0.d.d) invokeV.objValue;
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.longValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47696i : invokeV.longValue;
    }

    public long D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.longValue;
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.longValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        b.a.r0.o0.d.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TbadkCoreApplication.isLogin() && b.a.q0.s.e0.b.j().g("enter_forum_create_forum", true) && (dVar = this.f47692e) != null && dVar.b() != null) {
                return this.f47692e.b().z();
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
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? I(z, b.a.q0.s.e0.b.j().k("key_LIKE_forum_sort_state", SORT_TYPE_LEVEL)) : invokeZ.booleanValue;
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
            forumrecommendrequestmessage.setForumData(this.f47693f.y());
            this.f47696i = System.currentTimeMillis();
            if (this.f47695h == null) {
                this.f47695h = new b.a.r0.l3.l0.b("forumrecommendStat");
            }
            sendMessage(forumrecommendrequestmessage);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void J() {
        b.a.r0.l3.l0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f47695h) == null) {
            return;
        }
        bVar.a();
        this.f47695h = null;
    }

    public void K(b.a.r0.o0.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) || fVar == null) {
            return;
        }
        int size = this.f47693f.y().size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.f47693f.y().get(i3);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(fVar.p())) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            this.f47693f.y().remove(i2);
        }
    }

    public final void L(VisitedForumData visitedForumData) {
        b.a.r0.o0.d.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, visitedForumData) == null) || visitedForumData == null || (dVar = this.f47692e) == null) {
            return;
        }
        int size = dVar.e().b().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f47692e.e().b().get(i2).p().equals(visitedForumData.getForumId())) {
                this.f47693f.w(visitedForumData);
                this.f47693f.C(200);
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

    public void O(ResponsedMessage<?> responsedMessage, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{responsedMessage, Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                this.f47692e = null;
            }
            if (responsedMessage != null) {
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    R((forumRecommendSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    Q((forumRecommendHttpResponseMessage) responsedMessage);
                }
            }
            P(z, i2, str, z2, i3, j, j2);
        }
    }

    public void P(boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e eVar = new e(this);
            boolean z3 = !z;
            b.a.r0.l3.l0.b bVar = this.f47695h;
            if (bVar != null) {
                bVar.b(z2, z3, i2, str, i3, j, j2);
                this.f47695h = null;
            }
            if (!z && this.f47692e.i()) {
                eVar.f47704c = 1;
                eVar.f47703b = true;
                eVar.f47705d = this.f47692e;
                this.f47694g.a(eVar);
                return;
            }
            if (str != null && str.length() > 0) {
                setErrorString(str);
                eVar.f47702a = str;
            }
            eVar.f47704c = 1;
            eVar.f47703b = false;
            eVar.f47705d = this.f47692e;
            this.f47694g.a(eVar);
        }
    }

    public void Q(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, forumrecommendhttpresponsemessage) == null) || forumrecommendhttpresponsemessage == null) {
            return;
        }
        try {
            this.f47692e = new b.a.r0.o0.d.d();
            b.a.r0.o0.f.a.a aVar = new b.a.r0.o0.f.a.a();
            aVar.f(forumrecommendhttpresponsemessage.getForumPopUpInfo());
            this.f47692e.t(aVar);
            this.f47692e.s(forumrecommendhttpresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendhttpresponsemessage.GetLikeForum());
            this.f47692e.n(gVar);
            r1 r1Var = new r1();
            r1Var.o(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
            this.f47692e.p(r1Var);
            this.f47692e.m(true);
            this.f47692e.l(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            this.f47692e.q(forumrecommendhttpresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendhttpresponsemessage.getForumCreateInfo());
            this.f47692e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendhttpresponsemessage.getPrivatePopInfo());
            this.f47692e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendhttpresponsemessage.getTabFeedList());
            this.f47692e.r(jVar);
        } catch (Exception e2) {
            this.f47692e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void R(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, forumrecommendsocketresponsemessage) == null) || forumrecommendsocketresponsemessage == null) {
            return;
        }
        try {
            this.f47692e = new b.a.r0.o0.d.d();
            b.a.r0.o0.f.a.a aVar = new b.a.r0.o0.f.a.a();
            aVar.f(forumrecommendsocketresponsemessage.getForumPopupInfo());
            this.f47692e.t(aVar);
            this.f47692e.s(forumrecommendsocketresponsemessage.GetTime().intValue());
            g gVar = new g();
            gVar.c(forumrecommendsocketresponsemessage.GetLikeForum());
            this.f47692e.n(gVar);
            r1 r1Var = new r1();
            r1Var.o(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
            this.f47692e.p(r1Var);
            this.f47692e.m(true);
            this.f47692e.l(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            this.f47692e.q(forumrecommendsocketresponsemessage.getSortType().intValue());
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.A(forumrecommendsocketresponsemessage.getForumCreateInfo());
            this.f47692e.k(forumCreateInfoData);
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.A(forumrecommendsocketresponsemessage.getPrivatePopInfo());
            this.f47692e.o(privateForumPopInfoData);
            j jVar = new j();
            jVar.a(forumrecommendsocketresponsemessage.getTabFeedList());
            this.f47692e.r(jVar);
        } catch (Exception e2) {
            this.f47692e.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void S(b.a.r0.o0.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.f47692e = dVar;
        }
    }

    public void T(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.f47694g = fVar;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public List<b.a.r0.o0.d.f> V(List<b.a.r0.o0.d.f> list, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, list, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                if (strArr != null && strArr.length != 0) {
                    for (String str : strArr) {
                        for (b.a.r0.o0.d.f fVar : list) {
                            if (fVar != null && fVar.w() != null && fVar.w().equals(str)) {
                                arrayList.add(fVar);
                            }
                        }
                    }
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        b.a.r0.o0.d.f fVar2 = list.get(i2);
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
                b.a.r0.o0.d.d dVar = this.f47692e;
                if (dVar == null || dVar.b() == null) {
                    return true;
                }
                return this.f47692e.b().y();
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
