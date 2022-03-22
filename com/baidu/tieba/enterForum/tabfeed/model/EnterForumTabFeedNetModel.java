package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.j1;
import c.a.o0.r.r.u1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f31970b;

    /* renamed from: c  reason: collision with root package name */
    public String f31971c;

    /* renamed from: d  reason: collision with root package name */
    public String f31972d;

    /* renamed from: e  reason: collision with root package name */
    public int f31973e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31974f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.w0.n.b f31975g;

    /* renamed from: h  reason: collision with root package name */
    public int f31976h;
    public HashMap<String, Integer> i;
    public c.a.p0.w0.n.d.b j;
    public c.a.p0.w0.n.d.a k;
    public ThreadData l;
    public c.a.d.c.g.a m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final c.a.d.c.g.a q;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            c.a.p0.w0.n.d.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage == null || this.a.j == null || this.a.j.f19543b == null) {
                    return;
                }
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    aVar = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                } else {
                    aVar = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                }
                this.a.k = aVar;
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.mErrorCode != 0 || aVar == null) {
                    this.a.f31975g.onServerError(errorData);
                    return;
                }
                if (aVar != null && this.a.l != null) {
                    aVar.e().add(0, this.a.l);
                    if (this.a.i != null && this.a.i.containsKey(this.a.l.getTid())) {
                        this.a.i.remove(this.a.l.getTid());
                    }
                    this.a.l = null;
                }
                this.a.T(aVar, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i)};
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
            this.a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.P(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i)};
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
            this.a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.P(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Comparator<u1> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(EnterForumTabFeedNetModel enterForumTabFeedNetModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(u1 u1Var, u1 u1Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, u1Var, u1Var2)) == null) {
                int i = u1Var.f10960c;
                int i2 = u1Var2.f10960c;
                if (i == i2) {
                    return 0;
                }
                return i > i2 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i)};
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
            this.a = enterForumTabFeedNetModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j1)) {
                j1 j1Var = (j1) customResponsedMessage.getData();
                if (j1Var.a == 2 && (str = j1Var.f10897b) != null && str.equals(this.a.f31971c)) {
                    int k = n.k(TbadkCoreApplication.getInst());
                    int i = n.i(TbadkCoreApplication.getInst());
                    float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(c.a.d.f.m.b.g(j1Var.f10898c, 0L), 0L, 0L, k, i, f2, i2);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterForumTabFeedNetModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(responseData.data.thread_info);
                this.a.l = threadData;
                if (this.a.k != null) {
                    this.a.refresh();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, c.a.p0.w0.n.b bVar, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, bdUniqueId};
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
        this.a = false;
        this.f31970b = 1;
        this.f31974f = true;
        this.m = new a(this, CmdConfigHttp.CMD_TAB_FEED_LIST, 309651);
        this.n = new b(this, 2016488);
        this.o = new c(this, 2016553);
        this.p = new e(this, 2921453);
        this.q = new f(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        setUniqueId(bdUniqueId);
        this.m.getHttpMessageListener().setSelfListener(true);
        this.m.getSocketMessageListener().setSelfListener(true);
        registerListener(this.m);
        this.i = new HashMap<>();
        this.j = new c.a.p0.w0.n.d.b();
        this.f31975g = bVar;
        this.f31973e = c.a.o0.r.j0.b.k().l("home_page_max_thread_count", 300);
        registerListener(this.n);
        registerListener(this.o);
        this.q.setTag(getUniqueId());
        if (this.q.getHttpMessageListener() != null) {
            this.q.getHttpMessageListener().setSelfListener(true);
        }
        if (this.q.getSocketMessageListener() != null) {
            this.q.getSocketMessageListener().setSelfListener(true);
        }
        registerListener(this.q);
    }

    public final int O() {
        InterceptResult invokeV;
        int i;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.w0.n.d.b bVar = this.j;
            if (bVar != null && bVar.f19543b != null) {
                int i2 = this.f31974f ? this.f31976h - 60 : 30;
                int i3 = i2 + 30;
                if (i2 >= 0 && i2 <= (i = this.f31976h) && i3 >= 0 && i3 <= i && i3 >= i2) {
                    int i4 = -1;
                    int i5 = 0;
                    int i6 = -1;
                    while (true) {
                        if (i5 >= this.j.f19543b.size()) {
                            break;
                        }
                        c.a.d.o.e.n nVar = this.j.f19543b.get(i5);
                        if (nVar instanceof a2) {
                            if (i6 == -1 && ((a2) nVar).position > i2) {
                                i6 = i5;
                            } else if (((a2) nVar).position > i3) {
                                i4 = i5;
                                break;
                            }
                            if (i6 > 0 && (threadData = ((a2) nVar).s) != null) {
                                this.i.remove(threadData.getTid());
                            }
                        }
                        i5++;
                    }
                    if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                        ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>();
                        arrayList.addAll(this.j.f19543b.subList(0, i6));
                        ArrayList<c.a.d.o.e.n> arrayList2 = this.j.f19543b;
                        arrayList.addAll(arrayList2.subList(i4, arrayList2.size()));
                        this.j.f19543b = arrayList;
                        return i4 - i6;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void P(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.w0.n.d.b bVar;
        a2 a2Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.f31976h <= 0 || (bVar = this.j) == null || ListUtils.isEmpty(bVar.f19543b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.i.containsKey(optString)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = this.j.f19543b.iterator();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if ((next instanceof a2) && (threadData = (a2Var = (a2) next).s) != null) {
                if (i2 >= 0) {
                    if (a2Var.position != i2) {
                        break;
                    }
                    it.remove();
                    i4 = i;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = a2Var.position;
                    it.remove();
                    i3 = i;
                }
            }
            i++;
        }
        if (i3 < i4) {
            this.f31975g.R(i3, i4);
        }
    }

    public final ArrayList<c.a.d.o.e.n> Q(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<c.a.d.o.e.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof u1)) {
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

    public final void R(ArrayList<c.a.d.o.e.n> arrayList, ArrayList<u1> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, arrayList2) == null) {
            V();
            if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
                return;
            }
            Collections.sort(arrayList2, new d(this));
            int i = 0;
            Iterator<u1> it = arrayList2.iterator();
            while (it.hasNext()) {
                u1 next = it.next();
                int i2 = next.f10960c + i;
                if (TextUtils.isEmpty(next.a) || TextUtils.isEmpty(next.f10959b) || next.f10960c == 0 || i2 > arrayList.size()) {
                    return;
                }
                arrayList.add(i2, next);
                i++;
            }
        }
    }

    public final void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
            tabFeedListRequestMessage.loadType = i;
            tabFeedListRequestMessage.tabCode = this.f31972d;
            tabFeedListRequestMessage.tabName = this.f31971c;
            if (i == 2) {
                tabFeedListRequestMessage.pn = this.f31970b + 1;
            } else if (i != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.a = true;
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void T(c.a.p0.w0.n.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, aVar, z) == null) || aVar == null || this.j == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> e2 = aVar.e();
        c.a.p0.w0.n.d.b bVar = this.j;
        boolean z2 = this.f31974f;
        bVar.f19549h = z2;
        if (!z2) {
            this.f31970b++;
        } else {
            bVar.f19547f = z ? ListUtils.getCount(e2) : -1;
            R(e2, aVar.d());
        }
        if (this.f31976h + ListUtils.getCount(e2) > this.f31973e) {
            this.j.f19546e = O();
        }
        ArrayList<c.a.d.o.e.n> X = X(e2);
        Q(X);
        if (this.f31974f) {
            this.j.f19543b.addAll(0, X);
            this.j.f19546e = 0;
        } else {
            this.j.f19543b.addAll(X);
            this.j.f19544c = !ListUtils.isEmpty(e2);
        }
        this.j.f19545d = aVar.f();
        this.j.f19548g = aVar.b();
        this.j.a = aVar.c();
        c.a.p0.w0.n.b bVar2 = this.f31975g;
        if (bVar2 != null) {
            bVar2.q0(this.j);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(this.p);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.j.f19543b)) {
            return;
        }
        int i = 0;
        Iterator<c.a.d.o.e.n> it = this.j.f19543b.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof u1) {
                it.remove();
            }
            i++;
            if (i > 93) {
                return;
            }
        }
    }

    public void W(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f31972d = str;
            this.f31971c = str2;
        }
    }

    public final ArrayList<c.a.d.o.e.n> X(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            int i = this.f31976h;
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next instanceof u1) {
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (!this.i.containsKey(threadData.getTid())) {
                        this.i.put(threadData.getTid(), 0);
                        threadData.isFromEnterFroumTabFeed = true;
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                            a2 a2Var = new a2();
                            a2Var.s = threadData;
                            a2Var.position = i;
                            a2Var.a = true;
                            arrayList2.add(a2Var);
                            a2 a2Var2 = new a2();
                            a2Var2.s = threadData;
                            a2Var2.position = i;
                            if (threadData.isBJHNormalThreadType()) {
                                a2Var2.f10786f = true;
                            } else if (threadData.picCount() == 1) {
                                a2Var2.f10784d = true;
                                a2Var2.t = imageWidthAndHeight[0];
                                a2Var2.u = imageWidthAndHeight[1];
                            } else if (threadData.picCount() >= 2) {
                                a2Var2.f10785e = true;
                            } else {
                                a2Var2.f10782b = true;
                            }
                            arrayList2.add(a2Var2);
                            if (threadData.getItem() != null) {
                                a2 a2Var3 = new a2();
                                a2Var3.n = true;
                                a2Var3.s = threadData;
                                a2Var3.position = i;
                                arrayList2.add(a2Var3);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                a2 a2Var4 = new a2();
                                a2Var4.s = threadData;
                                a2Var4.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    a2Var4.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    a2Var4.q = true;
                                }
                                arrayList2.add(a2Var4);
                            }
                            a2 a2Var5 = new a2();
                            a2Var5.m = true;
                            a2Var5.s = threadData;
                            a2Var5.position = i;
                            arrayList2.add(a2Var5);
                            a2 a2Var6 = new a2();
                            a2Var6.f10787g = true;
                            a2Var6.s = threadData;
                            a2Var6.position = i;
                            arrayList2.add(a2Var6);
                        } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                            a2 a2Var7 = new a2();
                            a2Var7.s = threadData;
                            a2Var7.position = i;
                            a2Var7.a = true;
                            arrayList2.add(a2Var7);
                            a2 a2Var8 = new a2();
                            a2Var8.s = threadData;
                            a2Var8.position = i;
                            a2Var8.i = true;
                            arrayList2.add(a2Var8);
                            if (threadData.getItem() != null) {
                                a2 a2Var9 = new a2();
                                a2Var9.n = true;
                                a2Var9.s = threadData;
                                a2Var9.position = i;
                                arrayList2.add(a2Var9);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                a2 a2Var10 = new a2();
                                a2Var10.s = threadData;
                                a2Var10.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    a2Var10.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    a2Var10.q = true;
                                }
                                arrayList2.add(a2Var10);
                            }
                            a2 a2Var11 = new a2();
                            a2Var11.m = true;
                            a2Var11.s = threadData;
                            a2Var11.position = i;
                            arrayList2.add(a2Var11);
                            a2 a2Var12 = new a2();
                            a2Var12.f10787g = true;
                            a2Var12.s = threadData;
                            a2Var12.position = i;
                            arrayList2.add(a2Var12);
                        } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                            threadData.position = i;
                            arrayList2.add(threadData);
                        } else {
                            a2 a2Var13 = new a2();
                            a2Var13.s = threadData;
                            a2Var13.position = i;
                            arrayList2.add(a2Var13);
                        }
                        i++;
                    }
                }
            }
            this.f31976h = i;
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.p0.w0.n.d.b bVar = this.j;
            if (bVar == null) {
                return false;
            }
            return !ListUtils.isEmpty(bVar.f19543b);
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
            this.a = false;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a) {
            return;
        }
        this.f31974f = false;
        S(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.a) {
            return;
        }
        this.f31974f = true;
        S(1);
    }
}
