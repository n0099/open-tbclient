package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.m1;
import c.a.t0.s.r.x1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes12.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42932e;

    /* renamed from: f  reason: collision with root package name */
    public int f42933f;

    /* renamed from: g  reason: collision with root package name */
    public String f42934g;

    /* renamed from: h  reason: collision with root package name */
    public String f42935h;

    /* renamed from: i  reason: collision with root package name */
    public int f42936i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42937j;
    public c.a.u0.v0.l.b k;
    public int l;
    public HashMap<String, Integer> m;
    public c.a.u0.v0.l.d.b n;
    public c.a.u0.v0.l.d.a o;
    public e2 p;
    public c.a.d.c.g.a q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final c.a.d.c.g.a u;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumTabFeedNetModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.u0.v0.l.d.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f42932e = false;
                if (responsedMessage == null || this.a.n == null || this.a.n.f24620b == null) {
                    return;
                }
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                } else {
                    aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                }
                this.a.o = aVar;
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.mErrorCode != 0 || aVar == null) {
                    this.a.k.onServerError(errorData);
                    return;
                }
                if (aVar != null && this.a.p != null) {
                    aVar.e().add(0, this.a.p);
                    if (this.a.m != null && this.a.m.containsKey(this.a.p.w1())) {
                        this.a.m.remove(this.a.p.w1());
                    }
                    this.a.p = null;
                }
                this.a.R(aVar, true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i2)};
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
            this.a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.N(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i2)};
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
            this.a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.N(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Comparator<x1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(EnterForumTabFeedNetModel enterForumTabFeedNetModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(x1 x1Var, x1 x1Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, x1Var, x1Var2)) == null) {
                int i2 = x1Var.f14003g;
                int i3 = x1Var2.f14003g;
                if (i2 == i3) {
                    return 0;
                }
                return i2 > i3 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i2)};
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
            this.a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m1)) {
                m1 m1Var = (m1) customResponsedMessage.getData();
                if (m1Var.a == 2 && (str = m1Var.f13924b) != null && str.equals(this.a.f42934g)) {
                    int k = n.k(TbadkCoreApplication.getInst());
                    int i2 = n.i(TbadkCoreApplication.getInst());
                    float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(c.a.d.f.m.b.g(m1Var.f13925c, 0L), 0L, 0L, k, i2, f2, i3);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumTabFeedNetModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            DataRes dataRes;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responseData == null || (dataRes = responseData.data) == null || dataRes.thread_info == null) {
                    return;
                }
                e2 e2Var = new e2();
                e2Var.d3(responseData.data.thread_info);
                this.a.p = e2Var;
                if (this.a.o != null) {
                    this.a.refresh();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, c.a.u0.v0.l.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42932e = false;
        this.f42933f = 1;
        this.f42937j = true;
        this.q = new a(this, CmdConfigHttp.CMD_TAB_FEED_LIST, 309651);
        this.r = new b(this, 2016488);
        this.s = new c(this, 2016553);
        this.t = new e(this, 2921453);
        this.u = new f(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        setUniqueId(bdUniqueId);
        this.q.getHttpMessageListener().setSelfListener(true);
        this.q.getSocketMessageListener().setSelfListener(true);
        registerListener(this.q);
        this.m = new HashMap<>();
        this.n = new c.a.u0.v0.l.d.b();
        this.k = bVar;
        this.f42936i = c.a.t0.s.j0.b.k().l("home_page_max_thread_count", 300);
        registerListener(this.r);
        registerListener(this.s);
        this.u.setTag(getUniqueId());
        if (this.u.getHttpMessageListener() != null) {
            this.u.getHttpMessageListener().setSelfListener(true);
        }
        if (this.u.getSocketMessageListener() != null) {
            this.u.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.u);
    }

    public final int M() {
        InterceptResult invokeV;
        int i2;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.u0.v0.l.d.b bVar = this.n;
            if (bVar != null && bVar.f24620b != null) {
                int i3 = this.f42937j ? this.l - 60 : 30;
                int i4 = i3 + 30;
                if (i3 >= 0 && i3 <= (i2 = this.l) && i4 >= 0 && i4 <= i2 && i4 >= i3) {
                    int i5 = -1;
                    int i6 = 0;
                    int i7 = -1;
                    while (true) {
                        if (i6 >= this.n.f24620b.size()) {
                            break;
                        }
                        c.a.d.o.e.n nVar = this.n.f24620b.get(i6);
                        if (nVar instanceof d2) {
                            if (i7 == -1 && ((d2) nVar).position > i3) {
                                i7 = i6;
                            } else if (((d2) nVar).position > i4) {
                                i5 = i6;
                                break;
                            }
                            if (i7 > 0 && (e2Var = ((d2) nVar).w) != null) {
                                this.m.remove(e2Var.w1());
                            }
                        }
                        i6++;
                    }
                    if (i7 < i5 && i5 >= 0 && i7 >= 0) {
                        ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
                        arrayList.addAll(this.n.f24620b.subList(0, i7));
                        ArrayList<c.a.d.o.e.n> arrayList2 = this.n.f24620b;
                        arrayList.addAll(arrayList2.subList(i5, arrayList2.size()));
                        this.n.f24620b = arrayList;
                        return i5 - i7;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void N(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.u0.v0.l.d.b bVar;
        d2 d2Var;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.l <= 0 || (bVar = this.n) == null || ListUtils.isEmpty(bVar.f24620b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.m.containsKey(optString)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.n.f24620b.iterator();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if ((next instanceof d2) && (e2Var = (d2Var = (d2) next).w) != null) {
                if (i3 >= 0) {
                    if (d2Var.position != i3) {
                        break;
                    }
                    it.remove();
                    i5 = i2;
                } else if (StringHelper.equals(optString, e2Var.w1())) {
                    i3 = d2Var.position;
                    it.remove();
                    i4 = i2;
                }
            }
            i2++;
        }
        if (i4 < i5) {
            this.k.removeListItems(i4, i5);
        }
    }

    public final ArrayList<c.a.d.o.e.n> O(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<c.a.d.o.e.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof x1)) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.clear();
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void P(ArrayList<c.a.d.o.e.n> arrayList, ArrayList<x1> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, arrayList2) == null) {
            T();
            if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
                return;
            }
            Collections.sort(arrayList2, new d(this));
            int i2 = 0;
            Iterator<x1> it = arrayList2.iterator();
            while (it.hasNext()) {
                x1 next = it.next();
                int i3 = next.f14003g + i2;
                if (TextUtils.isEmpty(next.f14001e) || TextUtils.isEmpty(next.f14002f) || next.f14003g == 0 || i3 > arrayList.size()) {
                    return;
                }
                arrayList.add(i3, next);
                i2++;
            }
        }
    }

    public final void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
            tabFeedListRequestMessage.loadType = i2;
            tabFeedListRequestMessage.tabCode = this.f42935h;
            tabFeedListRequestMessage.tabName = this.f42934g;
            if (i2 == 2) {
                tabFeedListRequestMessage.pn = this.f42933f + 1;
            } else if (i2 != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.f42932e = true;
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void R(c.a.u0.v0.l.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, aVar, z) == null) || aVar == null || this.n == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> e2 = aVar.e();
        c.a.u0.v0.l.d.b bVar = this.n;
        boolean z2 = this.f42937j;
        bVar.f24626h = z2;
        if (!z2) {
            this.f42933f++;
        } else {
            bVar.f24624f = z ? ListUtils.getCount(e2) : -1;
            P(e2, aVar.d());
        }
        if (this.l + ListUtils.getCount(e2) > this.f42936i) {
            this.n.f24623e = M();
        }
        ArrayList<c.a.d.o.e.n> V = V(e2);
        O(V);
        if (this.f42937j) {
            this.n.f24620b.addAll(0, V);
            this.n.f24623e = 0;
        } else {
            this.n.f24620b.addAll(V);
            this.n.f24621c = !ListUtils.isEmpty(e2);
        }
        this.n.f24622d = aVar.f();
        this.n.f24625g = aVar.b();
        this.n.a = aVar.c();
        c.a.u0.v0.l.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.onNetCallback(this.n);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(this.t);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.n.f24620b)) {
            return;
        }
        int i2 = 0;
        Iterator<c.a.d.o.e.n> it = this.n.f24620b.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof x1) {
                it.remove();
            }
            i2++;
            if (i2 > 93) {
                return;
            }
        }
    }

    public void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f42935h = str;
            this.f42934g = str2;
        }
    }

    public final ArrayList<c.a.d.o.e.n> V(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            int i2 = this.l;
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next instanceof x1) {
                    arrayList2.add(next);
                } else if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    if (!this.m.containsKey(e2Var.w1())) {
                        this.m.put(e2Var.w1(), 0);
                        e2Var.f2 = true;
                        int[] i0 = e2Var.i0();
                        if (e2Var.getType() == e2.j3) {
                            d2 d2Var = new d2();
                            d2Var.w = e2Var;
                            d2Var.position = i2;
                            d2Var.f13813e = true;
                            arrayList2.add(d2Var);
                            d2 d2Var2 = new d2();
                            d2Var2.w = e2Var;
                            d2Var2.position = i2;
                            if (e2Var.R1()) {
                                d2Var2.f13818j = true;
                            } else if (e2Var.i3() == 1) {
                                d2Var2.f13816h = true;
                                d2Var2.x = i0[0];
                                d2Var2.y = i0[1];
                            } else if (e2Var.i3() >= 2) {
                                d2Var2.f13817i = true;
                            } else {
                                d2Var2.f13814f = true;
                            }
                            arrayList2.add(d2Var2);
                            if (e2Var.u0() != null) {
                                d2 d2Var3 = new d2();
                                d2Var3.r = true;
                                d2Var3.w = e2Var;
                                d2Var3.position = i2;
                                arrayList2.add(d2Var3);
                            }
                            if (!ListUtils.isEmpty(e2Var.C0()) || !ListUtils.isEmpty(e2Var.e0())) {
                                d2 d2Var4 = new d2();
                                d2Var4.w = e2Var;
                                d2Var4.position = i2;
                                if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) == 1) {
                                    d2Var4.t = true;
                                } else if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) > 1) {
                                    d2Var4.u = true;
                                }
                                arrayList2.add(d2Var4);
                            }
                            d2 d2Var5 = new d2();
                            d2Var5.q = true;
                            d2Var5.w = e2Var;
                            d2Var5.position = i2;
                            arrayList2.add(d2Var5);
                            d2 d2Var6 = new d2();
                            d2Var6.k = true;
                            d2Var6.w = e2Var;
                            d2Var6.position = i2;
                            arrayList2.add(d2Var6);
                        } else if (e2Var.getType() == e2.H3) {
                            d2 d2Var7 = new d2();
                            d2Var7.w = e2Var;
                            d2Var7.position = i2;
                            d2Var7.f13813e = true;
                            arrayList2.add(d2Var7);
                            d2 d2Var8 = new d2();
                            d2Var8.w = e2Var;
                            d2Var8.position = i2;
                            d2Var8.m = true;
                            arrayList2.add(d2Var8);
                            if (e2Var.u0() != null) {
                                d2 d2Var9 = new d2();
                                d2Var9.r = true;
                                d2Var9.w = e2Var;
                                d2Var9.position = i2;
                                arrayList2.add(d2Var9);
                            }
                            if (!ListUtils.isEmpty(e2Var.C0()) || !ListUtils.isEmpty(e2Var.e0())) {
                                d2 d2Var10 = new d2();
                                d2Var10.w = e2Var;
                                d2Var10.position = i2;
                                if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) == 1) {
                                    d2Var10.t = true;
                                } else if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) > 1) {
                                    d2Var10.u = true;
                                }
                                arrayList2.add(d2Var10);
                            }
                            d2 d2Var11 = new d2();
                            d2Var11.q = true;
                            d2Var11.w = e2Var;
                            d2Var11.position = i2;
                            arrayList2.add(d2Var11);
                            d2 d2Var12 = new d2();
                            d2Var12.k = true;
                            d2Var12.w = e2Var;
                            d2Var12.position = i2;
                            arrayList2.add(d2Var12);
                        } else if (e2Var.getType() == e2.z3 && e2Var.Q1()) {
                            e2Var.position = i2;
                            arrayList2.add(e2Var);
                        } else {
                            d2 d2Var13 = new d2();
                            d2Var13.w = e2Var;
                            d2Var13.position = i2;
                            arrayList2.add(d2Var13);
                        }
                        i2++;
                    }
                }
            }
            this.l = i2;
            c.a.t0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.u0.v0.l.d.b bVar = this.n;
            if (bVar == null) {
                return false;
            }
            return !ListUtils.isEmpty(bVar.f24620b);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.cancelMessage();
            this.f42932e = false;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f42932e) {
            return;
        }
        this.f42937j = false;
        Q(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f42932e) {
            return;
        }
        this.f42937j = true;
        Q(1);
    }
}
