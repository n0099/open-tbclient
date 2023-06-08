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
import com.baidu.tieba.ay6;
import com.baidu.tieba.b55;
import com.baidu.tieba.cy6;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumRequestMessage;
import com.baidu.tieba.ey6;
import com.baidu.tieba.ix5;
import com.baidu.tieba.k9;
import com.baidu.tieba.mx5;
import com.baidu.tieba.n95;
import com.baidu.tieba.qy9;
import com.baidu.tieba.sx6;
import com.baidu.tieba.ui;
import com.baidu.tieba.we;
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
    public ay6 a;
    public RecentlyVisitedForumData b;
    public f c;
    public qy9 d;
    public long e;
    public long f;
    public long g;
    public long h;
    public CustomMessageListener i;

    /* loaded from: classes5.dex */
    public interface f {
        void a(e eVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
        }
    }

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                this.a.j0((VisitedForumData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ay6> {
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
        public ay6 doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                b55.d();
                we<byte[]> c = b55.c("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                ay6 ay6Var = new ay6();
                byte[] bArr = c.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                byte[] bArr2 = c.get(EnterForumModel.FORUMRGUIDE_CACHE_KEY);
                if (bArr2 != null) {
                    ay6Var.m(true);
                    try {
                        ForumGuideResIdl forumGuideResIdl = (ForumGuideResIdl) new Wire(new Class[0]).parseFrom(bArr2, ForumGuideResIdl.class);
                        if (forumGuideResIdl.data != null) {
                            ay6Var.i(forumGuideResIdl.data);
                        }
                    } catch (Exception unused) {
                        ay6Var.m(false);
                    }
                    if (ay6Var.h() && !ay6Var.a()) {
                        ay6Var.e().a();
                    }
                } else if (bArr != null) {
                    ay6Var.m(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            ay6Var.j(forumRecommendResIdl.data);
                        }
                    } catch (Exception unused2) {
                        ay6Var.m(false);
                    }
                    if (ay6Var.h() && !ay6Var.a()) {
                        ay6Var.e().a();
                    }
                }
                return ay6Var;
            }
            return (ay6) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ay6Var) == null) {
                super.onPostExecute(ay6Var);
                e eVar = new e(this.a);
                eVar.c = 0;
                if (ay6Var != null && ay6Var.h()) {
                    eVar.b = true;
                    eVar.d = ay6Var;
                } else {
                    eVar.b = false;
                    eVar.d = ay6Var;
                }
                this.a.c.a(eVar);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                b55.d();
                we<String> f = b55.f("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (f == null || StringUtils.isNull(f.get(EnterForumModel.CACHE_KEY))) {
                    return null;
                }
                try {
                    return (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(f.get(EnterForumModel.CACHE_KEY), RecentlyVisitedForumData.class);
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
                this.b.f0(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends ix5<Object> {
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

        @Override // com.baidu.tieba.ix5
        public Object doInBackground() {
            InterceptResult invokeV;
            RecentlyVisitedForumData recentlyVisitedForumData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b55.d();
                we<String> f = b55.f("tb.recently_visited_like_forum", TbadkCoreApplication.getCurrentAccount());
                if (f != null && (recentlyVisitedForumData = this.a.b) != null) {
                    f.g(EnterForumModel.CACHE_KEY, OrmObject.jsonStrWithObject(recentlyVisitedForumData));
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
        public boolean b;
        public int c;
        public ay6 d;

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
                super((k9) newInitContext.callArgs[0]);
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

    public void r0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            SetLikeForumRequestMessage setLikeForumRequestMessage = new SetLikeForumRequestMessage();
            setLikeForumRequestMessage.setOriginalLikeList(str);
            setLikeForumRequestMessage.setMoveList(str2);
            sendMessage(setLikeForumRequestMessage);
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            new b(this).execute(new Void[0]);
            c cVar = new c(this, z);
            cVar.setPriority(3);
            cVar.execute(new Void[0]);
        }
    }

    public boolean e0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            X(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean f0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            return g0(z, sx6.a(2));
        }
        return invokeZ.booleanValue;
    }

    public void q0(ay6 ay6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ay6Var) == null) {
            this.a = ay6Var;
        }
    }

    public void s0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, fVar) == null) {
            this.c = fVar;
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                return false;
            }
            ay6 ay6Var = this.a;
            if (ay6Var == null || ay6Var.b() == null) {
                return true;
            }
            return this.a.b().W();
        }
        return invokeV.booleanValue;
    }

    public ay6 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (ay6) invokeV.objValue;
    }

    public long Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public long a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public long b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public long c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            cancelMessage();
            h0();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.unique_id;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void h0() {
        qy9 qy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (qy9Var = this.d) != null) {
            qy9Var.a();
            this.d = null;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            v0();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        mx5.b(new d(this), null);
    }

    public boolean d0() {
        InterceptResult invokeV;
        ay6 ay6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || !n95.m().i("enter_forum_create_forum", true) || (ay6Var = this.a) == null || ay6Var.b() == null) {
                return false;
            }
            return this.a.b().X();
        }
        return invokeV.booleanValue;
    }

    public boolean g0(boolean z, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
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
                this.d = new qy9("forumrecommendStat");
            }
            sendMessage(forumGuideRequestMessage);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void i0(cy6 cy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, cy6Var) != null) || cy6Var == null) {
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
            if (!ui.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(cy6Var.getId())) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            this.b.getForumData().remove(i);
        }
    }

    public final void j0(VisitedForumData visitedForumData) {
        ay6 ay6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, visitedForumData) == null) && visitedForumData != null && (ay6Var = this.a) != null) {
            int size = ay6Var.e().b().size();
            for (int i = 0; i < size; i++) {
                if (this.a.e().b().get(i).getId().equals(visitedForumData.getForumId())) {
                    this.b.addForumItem(visitedForumData);
                    this.b.trimSize(200);
                }
            }
        }
    }

    public void k0(ForumGuideHttpResponseMessage forumGuideHttpResponseMessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, forumGuideHttpResponseMessage) == null) {
            int downSize = forumGuideHttpResponseMessage.getDownSize();
            long costTime = forumGuideHttpResponseMessage.getCostTime();
            if (StringUtils.isNull(forumGuideHttpResponseMessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
            } else {
                errorString = forumGuideHttpResponseMessage.getErrorString();
            }
            m0(forumGuideHttpResponseMessage, forumGuideHttpResponseMessage.hasError(), forumGuideHttpResponseMessage.getError(), errorString, true, downSize, costTime, 0L);
        }
    }

    public void l0(ForumGuideSocketResponseMessage forumGuideSocketResponseMessage) {
        String errorString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumGuideSocketResponseMessage) == null) {
            int downSize = forumGuideSocketResponseMessage.getDownSize();
            long costTime = forumGuideSocketResponseMessage.getCostTime();
            if (StringUtils.isNull(forumGuideSocketResponseMessage.getErrorString())) {
                errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
            } else {
                errorString = forumGuideSocketResponseMessage.getErrorString();
            }
            m0(forumGuideSocketResponseMessage, forumGuideSocketResponseMessage.hasError(), forumGuideSocketResponseMessage.getError(), errorString, false, downSize, 0L, costTime);
        }
    }

    public void m0(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{responsedMessage, Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                this.a = null;
            }
            if (responsedMessage != null) {
                if (responsedMessage instanceof ForumGuideSocketResponseMessage) {
                    p0((ForumGuideSocketResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                    o0((ForumGuideHttpResponseMessage) responsedMessage);
                }
            }
            n0(z, i, str, z2, i2, j, j2);
        }
    }

    public void n0(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, Boolean.valueOf(z2), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            e eVar = new e(this);
            boolean z3 = !z;
            qy9 qy9Var = this.d;
            if (qy9Var != null) {
                qy9Var.b(z2, z3, i, str, i2, j, j2);
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

    public void o0(ForumGuideHttpResponseMessage forumGuideHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, forumGuideHttpResponseMessage) != null) || forumGuideHttpResponseMessage == null) {
            return;
        }
        try {
            this.a = new ay6();
            ey6 ey6Var = new ey6();
            ey6Var.c(forumGuideHttpResponseMessage.getLikeForum());
            this.a.n(ey6Var);
            this.a.m(true);
            if (!ListUtils.isEmpty(forumGuideHttpResponseMessage.getHotSearches())) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                hotSearchInfoData.W(((HotSearch) ListUtils.getItem(forumGuideHttpResponseMessage.getHotSearches(), 0)).search_title);
                this.a.l(hotSearchInfoData);
            }
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.Y(forumGuideHttpResponseMessage.getForumCreateInfo());
            this.a.k(forumCreateInfoData);
            if (forumGuideHttpResponseMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                this.a.o(((ForumGuideRequestMessage) forumGuideHttpResponseMessage.getOrginalMessage().getExtra()).getSortType().intValue());
            }
        } catch (Exception e2) {
            this.a.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public void p0(ForumGuideSocketResponseMessage forumGuideSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, forumGuideSocketResponseMessage) != null) || forumGuideSocketResponseMessage == null) {
            return;
        }
        try {
            this.a = new ay6();
            ey6 ey6Var = new ey6();
            ey6Var.c(forumGuideSocketResponseMessage.getLikeForum());
            this.a.n(ey6Var);
            this.a.m(true);
            if (!ListUtils.isEmpty(forumGuideSocketResponseMessage.getHotSearches())) {
                HotSearchInfoData hotSearchInfoData = new HotSearchInfoData();
                hotSearchInfoData.W(((HotSearch) ListUtils.getItem(forumGuideSocketResponseMessage.getHotSearches(), 0)).search_title);
                this.a.l(hotSearchInfoData);
            }
            ForumCreateInfoData forumCreateInfoData = new ForumCreateInfoData();
            forumCreateInfoData.Y(forumGuideSocketResponseMessage.getForumCreateInfo());
            this.a.k(forumCreateInfoData);
            if (forumGuideSocketResponseMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                this.a.o(((ForumGuideRequestMessage) forumGuideSocketResponseMessage.getOrginalMessage().getExtra()).getSortType().intValue());
            }
        } catch (Exception e2) {
            this.a.m(false);
            BdLog.e(e2.getMessage());
        }
    }

    public List<cy6> u0(List<cy6> list, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, list, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                if (strArr != null && strArr.length != 0) {
                    for (String str : strArr) {
                        for (cy6 cy6Var : list) {
                            if (cy6Var != null && cy6Var.k() != null && cy6Var.k().equals(str)) {
                                arrayList.add(cy6Var);
                            }
                        }
                    }
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        cy6 cy6Var2 = list.get(i);
                        if (!arrayList.contains(cy6Var2)) {
                            arrayList.add(cy6Var2);
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
