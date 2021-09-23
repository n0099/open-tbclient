package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.m1;
import c.a.q0.s.q.x1;
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
/* loaded from: classes7.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50441e;

    /* renamed from: f  reason: collision with root package name */
    public int f50442f;

    /* renamed from: g  reason: collision with root package name */
    public String f50443g;

    /* renamed from: h  reason: collision with root package name */
    public String f50444h;

    /* renamed from: i  reason: collision with root package name */
    public int f50445i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50446j;
    public c.a.r0.n0.l.b k;
    public int l;
    public HashMap<String, Integer> m;
    public c.a.r0.n0.l.d.b n;
    public c.a.r0.n0.l.d.a o;
    public d2 p;
    public c.a.e.c.g.a q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public final c.a.e.c.g.a u;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f50447a;

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
            this.f50447a = enterForumTabFeedNetModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.r0.n0.l.d.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f50447a.f50441e = false;
                if (responsedMessage == null || this.f50447a.n == null || this.f50447a.n.f22748b == null) {
                    return;
                }
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                } else {
                    aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                }
                this.f50447a.o = aVar;
                this.f50447a.mErrorCode = responsedMessage.getError();
                this.f50447a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.f50447a.mErrorCode);
                errorData.setError_msg(this.f50447a.mErrorString);
                if (this.f50447a.mErrorCode != 0 || aVar == null) {
                    this.f50447a.k.onServerError(errorData);
                    return;
                }
                if (aVar != null && this.f50447a.p != null) {
                    aVar.e().add(0, this.f50447a.p);
                    if (this.f50447a.m != null && this.f50447a.m.containsKey(this.f50447a.p.s1())) {
                        this.f50447a.m.remove(this.f50447a.p.s1());
                    }
                    this.f50447a.p = null;
                }
                this.f50447a.R(aVar, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f50448a;

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
            this.f50448a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f50448a.N(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f50449a;

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
            this.f50449a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f50449a.N(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = x1Var.f14358g;
                int i3 = x1Var2.f14358g;
                if (i2 == i3) {
                    return 0;
                }
                return i2 > i3 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f50450a;

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
            this.f50450a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m1)) {
                m1 m1Var = (m1) customResponsedMessage.getData();
                if (m1Var.f14262a == 2 && (str = m1Var.f14263b) != null && str.equals(this.f50450a.f50443g)) {
                    int k = l.k(TbadkCoreApplication.getInst());
                    int i2 = l.i(TbadkCoreApplication.getInst());
                    float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.f50450a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(c.a.e.e.m.b.g(m1Var.f14264c, 0L), 0L, 0L, k, i2, f2, i3);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EnterForumTabFeedNetModel f50451a;

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
            this.f50451a = enterForumTabFeedNetModel;
        }

        @Override // c.a.e.c.g.a
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
                d2 d2Var = new d2();
                d2Var.Y2(responseData.data.thread_info);
                this.f50451a.p = d2Var;
                if (this.f50451a.o != null) {
                    this.f50451a.refresh();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, c.a.r0.n0.l.b bVar, BdUniqueId bdUniqueId) {
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50441e = false;
        this.f50442f = 1;
        this.f50446j = true;
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
        this.n = new c.a.r0.n0.l.d.b();
        this.k = bVar;
        this.f50445i = c.a.q0.s.d0.b.j().k("home_page_max_thread_count", 300);
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
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.n0.l.d.b bVar = this.n;
            if (bVar != null && bVar.f22748b != null) {
                int i3 = this.f50446j ? this.l - 60 : 30;
                int i4 = i3 + 30;
                if (i3 >= 0 && i3 <= (i2 = this.l) && i4 >= 0 && i4 <= i2 && i4 >= i3) {
                    int i5 = -1;
                    int i6 = 0;
                    int i7 = -1;
                    while (true) {
                        if (i6 >= this.n.f22748b.size()) {
                            break;
                        }
                        n nVar = this.n.f22748b.get(i6);
                        if (nVar instanceof c2) {
                            if (i7 == -1 && ((c2) nVar).position > i3) {
                                i7 = i6;
                            } else if (((c2) nVar).position > i4) {
                                i5 = i6;
                                break;
                            }
                            if (i7 > 0 && (d2Var = ((c2) nVar).w) != null) {
                                this.m.remove(d2Var.s1());
                            }
                        }
                        i6++;
                    }
                    if (i7 < i5 && i5 >= 0 && i7 >= 0) {
                        ArrayList<n> arrayList = new ArrayList<>();
                        arrayList.addAll(this.n.f22748b.subList(0, i7));
                        ArrayList<n> arrayList2 = this.n.f22748b;
                        arrayList.addAll(arrayList2.subList(i5, arrayList2.size()));
                        this.n.f22748b = arrayList;
                        return i5 - i7;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void N(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.r0.n0.l.d.b bVar;
        c2 c2Var;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.l <= 0 || (bVar = this.n) == null || ListUtils.isEmpty(bVar.f22748b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.m.containsKey(optString)) {
            return;
        }
        Iterator<n> it = this.n.f22748b.iterator();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof c2) && (d2Var = (c2Var = (c2) next).w) != null) {
                if (i3 >= 0) {
                    if (c2Var.position != i3) {
                        break;
                    }
                    it.remove();
                    i5 = i2;
                } else if (StringHelper.equals(optString, d2Var.s1())) {
                    i3 = c2Var.position;
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

    public final ArrayList<n> O(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<n> it = arrayList.iterator();
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

    public final void P(ArrayList<n> arrayList, ArrayList<x1> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, arrayList, arrayList2) == null) {
            T();
            if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
                return;
            }
            Collections.sort(arrayList2, new d(this));
            int i2 = 0;
            Iterator<x1> it = arrayList2.iterator();
            while (it.hasNext()) {
                x1 next = it.next();
                int i3 = next.f14358g + i2;
                if (TextUtils.isEmpty(next.f14356e) || TextUtils.isEmpty(next.f14357f) || next.f14358g == 0 || i3 > arrayList.size()) {
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
            tabFeedListRequestMessage.tabCode = this.f50444h;
            tabFeedListRequestMessage.tabName = this.f50443g;
            if (i2 == 2) {
                tabFeedListRequestMessage.pn = this.f50442f + 1;
            } else if (i2 != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.f50441e = true;
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void R(c.a.r0.n0.l.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) || aVar == null || this.n == null) {
            return;
        }
        ArrayList<n> e2 = aVar.e();
        c.a.r0.n0.l.d.b bVar = this.n;
        boolean z2 = this.f50446j;
        bVar.f22754h = z2;
        if (!z2) {
            this.f50442f++;
        } else {
            bVar.f22752f = z ? ListUtils.getCount(e2) : -1;
            P(e2, aVar.d());
        }
        if (this.l + ListUtils.getCount(e2) > this.f50445i) {
            this.n.f22751e = M();
        }
        ArrayList<n> V = V(e2);
        O(V);
        if (this.f50446j) {
            this.n.f22748b.addAll(0, V);
            this.n.f22751e = 0;
        } else {
            this.n.f22748b.addAll(V);
            this.n.f22749c = !ListUtils.isEmpty(e2);
        }
        this.n.f22750d = aVar.f();
        this.n.f22753g = aVar.b();
        this.n.f22747a = aVar.c();
        c.a.r0.n0.l.b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.onNetCallback(this.n);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || ListUtils.isEmpty(this.n.f22748b)) {
            return;
        }
        int i2 = 0;
        Iterator<n> it = this.n.f22748b.iterator();
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
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            this.f50444h = str;
            this.f50443g = str2;
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
                if (next instanceof x1) {
                    arrayList2.add(next);
                } else if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    if (!this.m.containsKey(d2Var.s1())) {
                        this.m.put(d2Var.s1(), 0);
                        d2Var.f2 = true;
                        int[] g0 = d2Var.g0();
                        if (d2Var.getType() == d2.a3) {
                            c2 c2Var = new c2();
                            c2Var.w = d2Var;
                            c2Var.position = i2;
                            c2Var.f14119e = true;
                            arrayList2.add(c2Var);
                            c2 c2Var2 = new c2();
                            c2Var2.w = d2Var;
                            c2Var2.position = i2;
                            if (d2Var.N1()) {
                                c2Var2.f14124j = true;
                            } else if (d2Var.d3() == 1) {
                                c2Var2.f14122h = true;
                                c2Var2.x = g0[0];
                                c2Var2.y = g0[1];
                            } else if (d2Var.d3() >= 2) {
                                c2Var2.f14123i = true;
                            } else {
                                c2Var2.f14120f = true;
                            }
                            arrayList2.add(c2Var2);
                            if (d2Var.s0() != null) {
                                c2 c2Var3 = new c2();
                                c2Var3.r = true;
                                c2Var3.w = d2Var;
                                c2Var3.position = i2;
                                arrayList2.add(c2Var3);
                            }
                            if (!ListUtils.isEmpty(d2Var.A0()) || !ListUtils.isEmpty(d2Var.c0())) {
                                c2 c2Var4 = new c2();
                                c2Var4.w = d2Var;
                                c2Var4.position = i2;
                                if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) == 1) {
                                    c2Var4.t = true;
                                } else if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) > 1) {
                                    c2Var4.u = true;
                                }
                                arrayList2.add(c2Var4);
                            }
                            c2 c2Var5 = new c2();
                            c2Var5.q = true;
                            c2Var5.w = d2Var;
                            c2Var5.position = i2;
                            arrayList2.add(c2Var5);
                            c2 c2Var6 = new c2();
                            c2Var6.k = true;
                            c2Var6.w = d2Var;
                            c2Var6.position = i2;
                            arrayList2.add(c2Var6);
                        } else if (d2Var.getType() == d2.x3) {
                            c2 c2Var7 = new c2();
                            c2Var7.w = d2Var;
                            c2Var7.position = i2;
                            c2Var7.f14119e = true;
                            arrayList2.add(c2Var7);
                            c2 c2Var8 = new c2();
                            c2Var8.w = d2Var;
                            c2Var8.position = i2;
                            c2Var8.m = true;
                            arrayList2.add(c2Var8);
                            if (d2Var.s0() != null) {
                                c2 c2Var9 = new c2();
                                c2Var9.r = true;
                                c2Var9.w = d2Var;
                                c2Var9.position = i2;
                                arrayList2.add(c2Var9);
                            }
                            if (!ListUtils.isEmpty(d2Var.A0()) || !ListUtils.isEmpty(d2Var.c0())) {
                                c2 c2Var10 = new c2();
                                c2Var10.w = d2Var;
                                c2Var10.position = i2;
                                if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) == 1) {
                                    c2Var10.t = true;
                                } else if (ListUtils.getCount(d2Var.A0()) + ListUtils.getCount(d2Var.c0()) > 1) {
                                    c2Var10.u = true;
                                }
                                arrayList2.add(c2Var10);
                            }
                            c2 c2Var11 = new c2();
                            c2Var11.q = true;
                            c2Var11.w = d2Var;
                            c2Var11.position = i2;
                            arrayList2.add(c2Var11);
                            c2 c2Var12 = new c2();
                            c2Var12.k = true;
                            c2Var12.w = d2Var;
                            c2Var12.position = i2;
                            arrayList2.add(c2Var12);
                        } else if (d2Var.getType() == d2.p3 && d2Var.M1()) {
                            d2Var.position = i2;
                            arrayList2.add(d2Var);
                        } else {
                            c2 c2Var13 = new c2();
                            c2Var13.w = d2Var;
                            c2Var13.position = i2;
                            arrayList2.add(c2Var13);
                        }
                        i2++;
                    }
                }
            }
            this.l = i2;
            c.a.q0.b.f.a.d(arrayList2);
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
            this.f50441e = false;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.r0.n0.l.d.b bVar = this.n;
            if (bVar == null) {
                return false;
            }
            return !ListUtils.isEmpty(bVar.f22748b);
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f50441e) {
            return;
        }
        this.f50446j = false;
        Q(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f50441e) {
            return;
        }
        this.f50446j = true;
        Q(1);
    }
}
