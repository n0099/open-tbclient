package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.k1;
import d.a.o0.r.q.v1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes4.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14818e;

    /* renamed from: f  reason: collision with root package name */
    public int f14819f;

    /* renamed from: g  reason: collision with root package name */
    public String f14820g;

    /* renamed from: h  reason: collision with root package name */
    public String f14821h;

    /* renamed from: i  reason: collision with root package name */
    public int f14822i;
    public boolean j;
    public d.a.p0.l0.l.b k;
    public int l;
    public HashMap<String, Integer> m;
    public d.a.p0.l0.l.d.b n;
    public d.a.p0.l0.l.d.a o;
    public b2 p;
    public d.a.c.c.g.a q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final d.a.c.c.g.a u;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f14823a;

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
            this.f14823a = enterForumTabFeedNetModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.p0.l0.l.d.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f14823a.f14818e = false;
                if (responsedMessage == null || this.f14823a.n == null || this.f14823a.n.f59783b == null) {
                    return;
                }
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                } else {
                    aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                }
                this.f14823a.o = aVar;
                this.f14823a.mErrorCode = responsedMessage.getError();
                this.f14823a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f14823a.mErrorCode);
                errorData.setError_msg(this.f14823a.mErrorString);
                if (this.f14823a.mErrorCode != 0 || aVar == null) {
                    this.f14823a.k.onServerError(errorData);
                    return;
                }
                if (aVar != null && this.f14823a.p != null) {
                    aVar.e().add(0, this.f14823a.p);
                    if (this.f14823a.m != null && this.f14823a.m.containsKey(this.f14823a.p.n1())) {
                        this.f14823a.m.remove(this.f14823a.p.n1());
                    }
                    this.f14823a.p = null;
                }
                this.f14823a.R(aVar, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f14824a;

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
            this.f14824a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14824a.N(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f14825a;

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
            this.f14825a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14825a.N(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Comparator<v1> {
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
        public int compare(v1 v1Var, v1 v1Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v1Var, v1Var2)) == null) {
                int i2 = v1Var.f52792g;
                int i3 = v1Var2.f52792g;
                if (i2 == i3) {
                    return 0;
                }
                return i2 > i3 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f14826a;

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
            this.f14826a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k1)) {
                k1 k1Var = (k1) customResponsedMessage.getData();
                if (k1Var.f52712a == 2 && (str = k1Var.f52713b) != null && str.equals(this.f14826a.f14820g)) {
                    int k = l.k(TbadkCoreApplication.getInst());
                    int i2 = l.i(TbadkCoreApplication.getInst());
                    float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.f14826a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(d.a.c.e.m.b.f(k1Var.f52714c, 0L), 0L, 0L, k, i2, f2, i3);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f14827a;

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
            this.f14827a = enterForumTabFeedNetModel;
        }

        @Override // d.a.c.c.g.a
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
                b2 b2Var = new b2();
                b2Var.I2(responseData.data.thread_info);
                this.f14827a.p = b2Var;
                if (this.f14827a.o != null) {
                    this.f14827a.refresh();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, d.a.p0.l0.l.b bVar, BdUniqueId bdUniqueId) {
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14818e = false;
        this.f14819f = 1;
        this.j = true;
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
        this.n = new d.a.p0.l0.l.d.b();
        this.k = bVar;
        this.f14822i = d.a.o0.r.d0.b.j().k("home_page_max_thread_count", 300);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int M() {
        InterceptResult invokeV;
        int i2;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.p0.l0.l.d.b bVar = this.n;
            if (bVar != null && bVar.f59783b != null) {
                int i3 = this.j ? this.l - 60 : 30;
                int i4 = i3 + 30;
                if (i3 >= 0 && i3 <= (i2 = this.l) && i4 >= 0 && i4 <= i2 && i4 >= i3) {
                    int i5 = -1;
                    int i6 = 0;
                    int i7 = -1;
                    while (true) {
                        if (i6 >= this.n.f59783b.size()) {
                            break;
                        }
                        n nVar = this.n.f59783b.get(i6);
                        if (nVar instanceof a2) {
                            if (i7 == -1 && ((a2) nVar).position > i3) {
                                i7 = i6;
                            } else if (((a2) nVar).position > i4) {
                                i5 = i6;
                                break;
                            }
                            if (i7 > 0 && (b2Var = ((a2) nVar).w) != null) {
                                this.m.remove(b2Var.n1());
                            }
                        }
                        i6++;
                    }
                    if (i7 < i5 && i5 >= 0 && i7 >= 0) {
                        ArrayList<n> arrayList = new ArrayList<>();
                        arrayList.addAll(this.n.f59783b.subList(0, i7));
                        ArrayList<n> arrayList2 = this.n.f59783b;
                        arrayList.addAll(arrayList2.subList(i5, arrayList2.size()));
                        this.n.f59783b = arrayList;
                        return i5 - i7;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void N(CustomResponsedMessage<?> customResponsedMessage) {
        d.a.p0.l0.l.d.b bVar;
        a2 a2Var;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.l <= 0 || (bVar = this.n) == null || ListUtils.isEmpty(bVar.f59783b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.m.containsKey(optString)) {
            return;
        }
        Iterator<n> it = this.n.f59783b.iterator();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof a2) && (b2Var = (a2Var = (a2) next).w) != null) {
                if (i3 >= 0) {
                    if (a2Var.position != i3) {
                        break;
                    }
                    it.remove();
                    i5 = i2;
                } else if (StringHelper.equals(optString, b2Var.n1())) {
                    i3 = a2Var.position;
                    it.remove();
                    i4 = i2;
                }
            }
            i2++;
        }
        if (i4 < i5) {
            this.k.W(i4, i5);
        }
    }

    public final ArrayList<n> O(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof v1)) {
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

    public final void P(ArrayList<n> arrayList, ArrayList<v1> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, arrayList, arrayList2) == null) {
            T();
            if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
                return;
            }
            Collections.sort(arrayList2, new d(this));
            int i2 = 0;
            Iterator<v1> it = arrayList2.iterator();
            while (it.hasNext()) {
                v1 next = it.next();
                int i3 = next.f52792g + i2;
                if (TextUtils.isEmpty(next.f52790e) || TextUtils.isEmpty(next.f52791f) || next.f52792g == 0 || i3 > arrayList.size()) {
                    return;
                }
                arrayList.add(i3, next);
                i2++;
            }
        }
    }

    public final void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
            tabFeedListRequestMessage.loadType = i2;
            tabFeedListRequestMessage.tabCode = this.f14821h;
            tabFeedListRequestMessage.tabName = this.f14820g;
            if (i2 == 2) {
                tabFeedListRequestMessage.pn = this.f14819f + 1;
            } else if (i2 != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.f14818e = true;
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void R(d.a.p0.l0.l.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) || aVar == null || this.n == null) {
            return;
        }
        ArrayList<n> e2 = aVar.e();
        d.a.p0.l0.l.d.b bVar = this.n;
        boolean z2 = this.j;
        bVar.f59789h = z2;
        if (!z2) {
            this.f14819f++;
        } else {
            bVar.f59787f = z ? ListUtils.getCount(e2) : -1;
            P(e2, aVar.d());
        }
        if (this.l + ListUtils.getCount(e2) > this.f14822i) {
            this.n.f59786e = M();
        }
        ArrayList<n> V = V(e2);
        O(V);
        if (this.j) {
            this.n.f59783b.addAll(0, V);
            this.n.f59786e = 0;
        } else {
            this.n.f59783b.addAll(V);
            this.n.f59784c = !ListUtils.isEmpty(e2);
        }
        this.n.f59785d = aVar.f();
        this.n.f59788g = aVar.b();
        this.n.f59782a = aVar.c();
        d.a.p0.l0.l.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.v0(this.n);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            registerListener(this.t);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || ListUtils.isEmpty(this.n.f59783b)) {
            return;
        }
        int i2 = 0;
        Iterator<n> it = this.n.f59783b.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof v1) {
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
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            this.f14821h = str;
            this.f14820g = str2;
        }
    }

    public final ArrayList<n> V(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) {
            int i2 = this.l;
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof v1) {
                    arrayList2.add(next);
                } else if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    if (!this.m.containsKey(b2Var.n1())) {
                        this.m.put(b2Var.n1(), 0);
                        b2Var.b2 = true;
                        int[] d0 = b2Var.d0();
                        if (b2Var.getType() == b2.O2) {
                            a2 a2Var = new a2();
                            a2Var.w = b2Var;
                            a2Var.position = i2;
                            a2Var.f52563e = true;
                            arrayList2.add(a2Var);
                            a2 a2Var2 = new a2();
                            a2Var2.w = b2Var;
                            a2Var2.position = i2;
                            if (b2Var.F1()) {
                                a2Var2.j = true;
                            } else if (b2Var.N2() == 1) {
                                a2Var2.f52566h = true;
                                a2Var2.x = d0[0];
                                a2Var2.y = d0[1];
                            } else if (b2Var.N2() >= 2) {
                                a2Var2.f52567i = true;
                            } else {
                                a2Var2.f52564f = true;
                            }
                            arrayList2.add(a2Var2);
                            if (b2Var.n0() != null) {
                                a2 a2Var3 = new a2();
                                a2Var3.r = true;
                                a2Var3.w = b2Var;
                                a2Var3.position = i2;
                                arrayList2.add(a2Var3);
                            }
                            if (!ListUtils.isEmpty(b2Var.v0()) || !ListUtils.isEmpty(b2Var.Z())) {
                                a2 a2Var4 = new a2();
                                a2Var4.w = b2Var;
                                a2Var4.position = i2;
                                if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) == 1) {
                                    a2Var4.t = true;
                                } else if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) > 1) {
                                    a2Var4.u = true;
                                }
                                arrayList2.add(a2Var4);
                            }
                            a2 a2Var5 = new a2();
                            a2Var5.q = true;
                            a2Var5.w = b2Var;
                            a2Var5.position = i2;
                            arrayList2.add(a2Var5);
                            a2 a2Var6 = new a2();
                            a2Var6.k = true;
                            a2Var6.w = b2Var;
                            a2Var6.position = i2;
                            arrayList2.add(a2Var6);
                        } else if (b2Var.getType() == b2.l3) {
                            a2 a2Var7 = new a2();
                            a2Var7.w = b2Var;
                            a2Var7.position = i2;
                            a2Var7.f52563e = true;
                            arrayList2.add(a2Var7);
                            a2 a2Var8 = new a2();
                            a2Var8.w = b2Var;
                            a2Var8.position = i2;
                            a2Var8.m = true;
                            arrayList2.add(a2Var8);
                            if (b2Var.n0() != null) {
                                a2 a2Var9 = new a2();
                                a2Var9.r = true;
                                a2Var9.w = b2Var;
                                a2Var9.position = i2;
                                arrayList2.add(a2Var9);
                            }
                            if (!ListUtils.isEmpty(b2Var.v0()) || !ListUtils.isEmpty(b2Var.Z())) {
                                a2 a2Var10 = new a2();
                                a2Var10.w = b2Var;
                                a2Var10.position = i2;
                                if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) == 1) {
                                    a2Var10.t = true;
                                } else if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) > 1) {
                                    a2Var10.u = true;
                                }
                                arrayList2.add(a2Var10);
                            }
                            a2 a2Var11 = new a2();
                            a2Var11.q = true;
                            a2Var11.w = b2Var;
                            a2Var11.position = i2;
                            arrayList2.add(a2Var11);
                            a2 a2Var12 = new a2();
                            a2Var12.k = true;
                            a2Var12.w = b2Var;
                            a2Var12.position = i2;
                            arrayList2.add(a2Var12);
                        } else if (b2Var.getType() == b2.d3 && b2Var.E1()) {
                            b2Var.position = i2;
                            arrayList2.add(b2Var);
                        } else {
                            a2 a2Var13 = new a2();
                            a2Var13.w = b2Var;
                            a2Var13.position = i2;
                            arrayList2.add(a2Var13);
                        }
                        i2++;
                    }
                }
            }
            this.l = i2;
            d.a.o0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
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
            this.f14818e = false;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.p0.l0.l.d.b bVar = this.n;
            if (bVar == null) {
                return false;
            }
            return !ListUtils.isEmpty(bVar.f59783b);
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f14818e) {
            return;
        }
        this.j = false;
        Q(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f14818e) {
            return;
        }
        this.j = true;
        Q(1);
    }
}
