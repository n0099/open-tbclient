package com.baidu.tieba.enterForum.model;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.ac6;
import com.baidu.tieba.cc6;
import com.baidu.tieba.df;
import com.baidu.tieba.ec6;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumRequestMessage;
import com.baidu.tieba.ik5;
import com.baidu.tieba.kv4;
import com.baidu.tieba.mk5;
import com.baidu.tieba.r9;
import com.baidu.tieba.rs8;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sb6;
import com.baidu.tieba.xi;
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
/* loaded from: classes4.dex */
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
    public ac6 a;
    public RecentlyVisitedForumData b;
    public f c;
    public rs8 d;
    public long e;
    public long f;
    public long g;
    public long h;
    public CustomMessageListener i;

    /* loaded from: classes4.dex */
    public interface f {
        void a(e eVar);
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                this.a.V((VisitedForumData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, ac6> {
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
        public ac6 doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                kv4.f();
                df<byte[]> e = kv4.e("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                ac6 ac6Var = new ac6();
                byte[] bArr = e.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                byte[] bArr2 = e.get(EnterForumModel.FORUMRGUIDE_CACHE_KEY);
                if (bArr2 != null) {
                    ac6Var.m(true);
                    try {
                        ForumGuideResIdl forumGuideResIdl = (ForumGuideResIdl) new Wire(new Class[0]).parseFrom(bArr2, ForumGuideResIdl.class);
                        if (forumGuideResIdl.data != null) {
                            ac6Var.i(forumGuideResIdl.data);
                        }
                    } catch (Exception unused) {
                        ac6Var.m(false);
                    }
                    if (ac6Var.h() && !ac6Var.a()) {
                        ac6Var.e().a();
                    }
                } else if (bArr != null) {
                    ac6Var.m(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            ac6Var.j(forumRecommendResIdl.data);
                        }
                    } catch (Exception unused2) {
                        ac6Var.m(false);
                    }
                    if (ac6Var.h() && !ac6Var.a()) {
                        ac6Var.e().a();
                    }
                }
                return ac6Var;
            }
            return (ac6) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ac6 ac6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac6Var) == null) {
                super.onPostExecute(ac6Var);
                e eVar = new e(this.a);
                eVar.c = 0;
                if (ac6Var != null && ac6Var.h()) {
                    eVar.b = true;
                    eVar.d = ac6Var;
                } else {
                    eVar.b = false;
                    eVar.d = ac6Var;
                }
                this.a.c.a(eVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ EnterForumModel b;

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
            this.b = enterForumModel;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                kv4.f();
                df<String> h = kv4.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h == null || StringUtils.isNull(h.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    return (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
                } catch (Exception e) {
                    e.printStackTrace();
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
                    this.b.b.setForumData(recentlyVisitedForumData.getForumData());
                    this.b.b.trimSize(200);
                }
                this.b.R(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ik5<Object> {
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

        @Override // com.baidu.tieba.ik5
        public Object doInBackground() {
            InterceptResult invokeV;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                kv4.f();
                df<String> h = kv4.h("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (h != null && (recentlyVisitedForumData = this.a.b) != null) {
                    h.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public ac6 d;

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
            this.b = false;
            this.c = -1;
            this.d = null;
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
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = new a(this, 2016564);
        setUniqueId(BdUniqueId.gen());
        this.b = new RecentlyVisitedForumData();
        MessageManager.getInstance().registerListener(this.i);
    }

    public void e0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
            SetLikeForumRequestMessage setLikeForumRequestMessage = new SetLikeForumRequestMessage();
            setLikeForumRequestMessage.setOriginalLikeList(str);
            setLikeForumRequestMessage.setMoveList(str2);
            sendMessage(setLikeForumRequestMessage);
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            new b(this).execute(new Void[0]);
            c cVar = new c(this, z);
            cVar.setPriority(3);
            cVar.execute(new Void[0]);
        }
    }

    public boolean Q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            J(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean R(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            return S(z, sb6.a(2));
        }
        return invokeZ.booleanValue;
    }

    public void d0(ac6 ac6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, ac6Var) == null) {
            this.a = ac6Var;
        }
    }

    public void f0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fVar) == null) {
            this.c = fVar;
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                return false;
            }
            ac6 ac6Var = this.a;
            if (ac6Var == null || ac6Var.b() == null) {
                return true;
            }
            return this.a.b().I();
        }
        return invokeV.booleanValue;
    }

    public ac6 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (ac6) invokeV.objValue;
    }

    public long L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public long M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public long N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public long O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public final void T() {
        rs8 rs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rs8Var = this.d) != null) {
            rs8Var.a();
            this.d = null;
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            i0();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            cancelMessage();
            T();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.unique_id;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        mk5.b(new d(this), null);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        ac6 ac6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || !ry4.l().i("enter_forum_create_forum", true) || (ac6Var = this.a) == null || ac6Var.b() == null) {
                return false;
            }
            return this.a.b().J();
        }
        return invokeV.booleanValue;
    }

    public boolean S(boolean z, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            cancelLoadData();
            ForumGuideRequestMessage forumGuideRequestMessage = new ForumGuideRequestMessage();
            forumGuideRequestMessage.setCallFrom(1);
            if (i == 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            forumGuideRequestMessage.setSortType(Integer.valueOf(i2));
            this.e = System.currentTimeMillis();
            if (this.d == null) {
                this.d = new rs8("forumrecommendStat");
            }
            sendMessage(forumGuideRequestMessage);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void U(cc6 cc6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, cc6Var) != null) || cc6Var == null) {
            return;
        }
        int size = this.b.getForumData().size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            VisitedForumData visitedForumData = this.b.getForumData().get(i2);
            if (!xi.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(cc6Var.getId())) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            this.b.getForumData().remove(i);
        }
    }

    public final void V(VisitedForumData visitedForumData) {
        ac6 ac6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, visitedForumData) == null) && visitedForumData != null && (ac6Var = this.a) != null) {
            int size = ac6Var.e().b().size();
            for (int i = 0; i < size; i++) {
                if (this.a.e().b().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.b.addForumItem(visitedForumData);
                    this.b.trimSize(200);
                }
            }
        }
    }

    public void X(ForumGuideHttpResponseMessage forumGuideHttpResponseMessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, forumGuideHttpResponseMessage) == null) {
            int downSize = forumGuideHttpResponseMessage.getDownSize();
            long costTime = forumGuideHttpResponseMessage.getCostTime();
            if (StringUtils.isNull(forumGuideHttpResponseMessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
            } else {
                errorString = forumGuideHttpResponseMessage.getErrorString();
            }
            Z(forumGuideHttpResponseMessage, forumGuideHttpResponseMessage.hasError(), forumGuideHttpResponseMessage.getError(), errorString, true, downSize, costTime, 0L);
        }
    }

    public void Y(ForumGuideSocketResponseMessage forumGuideSocketResponseMessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, forumGuideSocketResponseMessage) == null) {
            int downSize = forumGuideSocketResponseMessage.getDownSize();
            long costTime = forumGuideSocketResponseMessage.getCostTime();
            if (StringUtils.isNull(forumGuideSocketResponseMessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
            } else {
                errorString = forumGuideSocketResponseMessage.getErrorString();
            }
            Z(forumGuideSocketResponseMessage, forumGuideSocketResponseMessage.hasError(), forumGuideSocketResponseMessage.getError(), errorString, false, downSize, 0L, costTime);
        }
    }

    public void Z(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{responsedMessage, Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                this.a = null;
            }
            if (responsedMessage != null) {
                if (responsedMessage instanceof ForumGuideSocketResponseMessage) {
                    c0((ForumGuideSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                    b0((ForumGuideHttpResponseMessage) responsedMessage);
                }
            }
            a0(z, i, str, z2, i2, j, j2);
        }
    }

    public void a0(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e eVar = new e(this);
            boolean z3 = !z;
            rs8 rs8Var = this.d;
            if (rs8Var != null) {
                rs8Var.b(z2, z3, i, str, i2, j, j2);
                this.d = null;
            }
            if (!z && this.a.h()) {
                eVar.c = 1;
                eVar.b = true;
                eVar.d = this.a;
                this.c.a(eVar);
                return;
            }
            if (str != null && str.length() > 0) {
                setErrorString(str);
                eVar.a = str;
            }
            eVar.c = 1;
            eVar.b = false;
            eVar.d = this.a;
            this.c.a(eVar);
        }
    }

    public void b0(ForumGuideHttpResponseMessage forumGuideHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, forumGuideHttpResponseMessage) != null) || forumGuideHttpResponseMessage == null) {
            return;
        }
        try {
            this.a = new ac6();
            ec6 ec6Var = new ec6();
            ec6Var.c(forumGuideHttpResponseMessage.getLikeForum());
            this.a.n(ec6Var);
            this.a.m(true);
            if (!ListUtils.isEmpty(forumGuideHttpResponseMessage.getHotSearches())) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                hotSearchInfoData.I(((HotSearch) ListUtils.getItem(forumGuideHttpResponseMessage.getHotSearches(), 0)).search_title);
                this.a.l(hotSearchInfoData);
            }
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.K(forumGuideHttpResponseMessage.getForumCreateInfo());
            this.a.k(forumCreateInfoData);
            if (forumGuideHttpResponseMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                this.a.o(((ForumGuideRequestMessage) forumGuideHttpResponseMessage.getOrginalMessage().getExtra()).getSortType().intValue());
            }
        } catch (Exception e2) {
            this.a.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void c0(ForumGuideSocketResponseMessage forumGuideSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, forumGuideSocketResponseMessage) != null) || forumGuideSocketResponseMessage == null) {
            return;
        }
        try {
            this.a = new ac6();
            ec6 ec6Var = new ec6();
            ec6Var.c(forumGuideSocketResponseMessage.getLikeForum());
            this.a.n(ec6Var);
            this.a.m(true);
            if (!ListUtils.isEmpty(forumGuideSocketResponseMessage.getHotSearches())) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                hotSearchInfoData.I(((HotSearch) ListUtils.getItem(forumGuideSocketResponseMessage.getHotSearches(), 0)).search_title);
                this.a.l(hotSearchInfoData);
            }
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.K(forumGuideSocketResponseMessage.getForumCreateInfo());
            this.a.k(forumCreateInfoData);
            if (forumGuideSocketResponseMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                this.a.o(((ForumGuideRequestMessage) forumGuideSocketResponseMessage.getOrginalMessage().getExtra()).getSortType().intValue());
            }
        } catch (Exception e2) {
            this.a.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public List<cc6> h0(List<cc6> list, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, list, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                if (strArr != null && strArr.length != 0) {
                    for (String str : strArr) {
                        for (cc6 cc6Var : list) {
                            if (cc6Var != null && cc6Var.o() != null && cc6Var.o().equals(str)) {
                                arrayList.add(cc6Var);
                            }
                        }
                    }
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        cc6 cc6Var2 = list.get(i);
                        if (!arrayList.contains(cc6Var2)) {
                            arrayList.add(cc6Var2);
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
}
