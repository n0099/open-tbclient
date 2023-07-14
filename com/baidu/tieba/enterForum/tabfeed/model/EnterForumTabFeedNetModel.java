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
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.a27;
import com.baidu.tieba.da5;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.g45;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.kb;
import com.baidu.tieba.l9;
import com.baidu.tieba.o27;
import com.baidu.tieba.p27;
import com.baidu.tieba.q45;
import com.baidu.tieba.wg;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.z45;
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
    public int b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public a27 g;
    public int h;
    public HashMap<String, Integer> i;
    public p27 j;
    public o27 k;
    public ThreadData l;
    public kb m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final kb q;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends kb {
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

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            o27 o27Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage != null && this.a.j != null && this.a.j.b != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        o27Var = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                        o27Var = ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        o27Var = null;
                    }
                    this.a.k = o27Var;
                    this.a.mErrorCode = responsedMessage.getError();
                    this.a.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(this.a.mErrorCode);
                    errorData.setError_msg(this.a.mErrorString);
                    if (this.a.mErrorCode == 0 && o27Var != null) {
                        if (o27Var != null && this.a.l != null) {
                            o27Var.e().add(0, this.a.l);
                            if (this.a.i != null && this.a.i.containsKey(this.a.l.getTid())) {
                                this.a.i.remove(this.a.l.getTid());
                            }
                            this.a.l = null;
                        }
                        this.a.q0(o27Var, true);
                        return;
                    }
                    this.a.g.f(errorData);
                }
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
                this.a.m0(customResponsedMessage);
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
                this.a.m0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Comparator<q45> {
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
        public int compare(q45 q45Var, q45 q45Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, q45Var, q45Var2)) == null) {
                int i = q45Var.c;
                int i2 = q45Var2.c;
                if (i == i2) {
                    return 0;
                }
                if (i > i2) {
                    return 1;
                }
                return -1;
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
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g45)) {
                g45 g45Var = (g45) customResponsedMessage.getData();
                if (g45Var.a == 2 && (str = g45Var.b) != null && str.equals(this.a.c)) {
                    int l = yi.l(TbadkCoreApplication.getInst());
                    int j = yi.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(wg.g(g45Var.c, 0L), 0L, 0L, l, j, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends kb {
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

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl;
            DataRes dataRes;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                } else {
                    getMyPostResIdl = null;
                }
                if (getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                    this.a.l = threadData;
                    if (this.a.k != null) {
                        this.a.refresh();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, a27 a27Var, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, a27Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 1;
        this.f = true;
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
        this.j = new p27();
        this.g = a27Var;
        this.e = da5.p().q("home_page_max_thread_count", 300);
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

    public void t0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            this.d = str;
            this.c = str2;
        }
    }

    public final void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            TabFeedListRequestMessage tabFeedListRequestMessage = new TabFeedListRequestMessage();
            tabFeedListRequestMessage.loadType = i;
            tabFeedListRequestMessage.tabCode = this.d;
            tabFeedListRequestMessage.tabName = this.c;
            if (i == 2) {
                tabFeedListRequestMessage.pn = this.b + 1;
            } else if (i == 1) {
                tabFeedListRequestMessage.pn = 1;
            } else {
                return;
            }
            this.a = true;
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a) {
            return;
        }
        this.f = false;
        p0(2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cancelMessage();
            this.a = false;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            p27 p27Var = this.j;
            if (p27Var == null) {
                return false;
            }
            return !ListUtils.isEmpty(p27Var.b);
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            registerListener(this.p);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.a) {
            return;
        }
        this.f = true;
        p0(1);
    }

    public final int l0() {
        InterceptResult invokeV;
        int i;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            p27 p27Var = this.j;
            if (p27Var != null && p27Var.b != null) {
                int i2 = 30;
                if (this.f) {
                    i2 = this.h - 60;
                }
                int i3 = i2 + 30;
                if (i2 >= 0 && i2 <= (i = this.h) && i3 >= 0 && i3 <= i && i3 >= i2) {
                    int i4 = -1;
                    int i5 = 0;
                    int i6 = -1;
                    while (true) {
                        if (i5 >= this.j.b.size()) {
                            break;
                        }
                        yn ynVar = this.j.b.get(i5);
                        if (ynVar instanceof z45) {
                            if (i6 == -1 && ((z45) ynVar).position > i2) {
                                i6 = i5;
                            } else if (((z45) ynVar).position > i3) {
                                i4 = i5;
                                break;
                            }
                            if (i6 > 0 && (threadData = ((z45) ynVar).t) != null) {
                                this.i.remove(threadData.getTid());
                            }
                        }
                        i5++;
                    }
                    if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                        ArrayList<yn> arrayList = new ArrayList<>();
                        arrayList.addAll(this.j.b.subList(0, i6));
                        ArrayList<yn> arrayList2 = this.j.b;
                        arrayList.addAll(arrayList2.subList(i4, arrayList2.size()));
                        this.j.b = arrayList;
                        return i4 - i6;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void m0(CustomResponsedMessage<?> customResponsedMessage) {
        p27 p27Var;
        z45 z45Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.h > 0 && (p27Var = this.j) != null && !ListUtils.isEmpty(p27Var.b)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.i.containsKey(optString)) {
                Iterator<yn> it = this.j.b.iterator();
                int i = 0;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                while (it.hasNext()) {
                    yn next = it.next();
                    if ((next instanceof z45) && (threadData = (z45Var = (z45) next).t) != null) {
                        if (i2 >= 0) {
                            if (z45Var.position != i2) {
                                break;
                            }
                            it.remove();
                            i4 = i;
                        } else if (StringHelper.equals(optString, threadData.getTid())) {
                            i2 = z45Var.position;
                            it.remove();
                            i3 = i;
                        }
                    }
                    i++;
                }
                if (i3 < i4) {
                    this.g.H0(i3, i4);
                }
            }
        }
    }

    public final ArrayList<yn> n0(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<yn> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof q45)) {
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

    public final void o0(ArrayList<yn> arrayList, ArrayList<q45> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, arrayList, arrayList2) == null) {
            s0();
            if (!ListUtils.isEmpty(arrayList) && !ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new d(this));
                int i = 0;
                Iterator<q45> it = arrayList2.iterator();
                while (it.hasNext()) {
                    q45 next = it.next();
                    int i2 = next.c + i;
                    if (!TextUtils.isEmpty(next.a) && !TextUtils.isEmpty(next.b) && next.c != 0 && i2 <= arrayList.size()) {
                        arrayList.add(i2, next);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void q0(o27 o27Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, o27Var, z) == null) && o27Var != null && this.j != null) {
            ArrayList<yn> e2 = o27Var.e();
            p27 p27Var = this.j;
            boolean z2 = this.f;
            p27Var.h = z2;
            if (!z2) {
                this.b++;
            } else {
                if (z) {
                    i = ListUtils.getCount(e2);
                } else {
                    i = -1;
                }
                p27Var.f = i;
                o0(e2, o27Var.d());
            }
            if (this.h + ListUtils.getCount(e2) > this.e) {
                this.j.e = l0();
            }
            ArrayList<yn> u0 = u0(e2);
            n0(u0);
            if (this.f) {
                this.j.b.addAll(0, u0);
                this.j.e = 0;
            } else {
                this.j.b.addAll(u0);
                this.j.c = !ListUtils.isEmpty(e2);
            }
            this.j.d = o27Var.f();
            this.j.g = o27Var.b();
            this.j.a = o27Var.c();
            a27 a27Var = this.g;
            if (a27Var != null) {
                a27Var.q1(this.j);
            }
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && !ListUtils.isEmpty(this.j.b)) {
            int i = 0;
            Iterator<yn> it = this.j.b.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof q45) {
                    it.remove();
                }
                i++;
                if (i > 93) {
                    return;
                }
            }
        }
    }

    public final ArrayList<yn> u0(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, arrayList)) == null) {
            int i = this.h;
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof q45) {
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (!this.i.containsKey(threadData.getTid())) {
                        this.i.put(threadData.getTid(), 0);
                        threadData.isFromEnterFroumTabFeed = true;
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                            z45 z45Var = new z45();
                            z45Var.t = threadData;
                            z45Var.position = i;
                            z45Var.a = true;
                            arrayList2.add(z45Var);
                            z45 z45Var2 = new z45();
                            z45Var2.t = threadData;
                            z45Var2.position = i;
                            if (threadData.isBJHNormalThreadType()) {
                                z45Var2.f = true;
                            } else if (threadData.picCount() == 1) {
                                z45Var2.d = true;
                                z45Var2.u = imageWidthAndHeight[0];
                                z45Var2.v = imageWidthAndHeight[1];
                            } else if (threadData.picCount() >= 2) {
                                z45Var2.e = true;
                            } else {
                                z45Var2.b = true;
                            }
                            arrayList2.add(z45Var2);
                            if (threadData.getItem() != null) {
                                z45 z45Var3 = new z45();
                                z45Var3.n = true;
                                z45Var3.t = threadData;
                                z45Var3.position = i;
                                arrayList2.add(z45Var3);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                z45 z45Var4 = new z45();
                                z45Var4.t = threadData;
                                z45Var4.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    z45Var4.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    z45Var4.q = true;
                                }
                                arrayList2.add(z45Var4);
                            }
                            z45 z45Var5 = new z45();
                            z45Var5.m = true;
                            z45Var5.t = threadData;
                            z45Var5.position = i;
                            arrayList2.add(z45Var5);
                            z45 z45Var6 = new z45();
                            z45Var6.g = true;
                            z45Var6.t = threadData;
                            z45Var6.position = i;
                            arrayList2.add(z45Var6);
                        } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                            z45 z45Var7 = new z45();
                            z45Var7.t = threadData;
                            z45Var7.position = i;
                            z45Var7.a = true;
                            arrayList2.add(z45Var7);
                            z45 z45Var8 = new z45();
                            z45Var8.t = threadData;
                            z45Var8.position = i;
                            z45Var8.i = true;
                            arrayList2.add(z45Var8);
                            if (threadData.getItem() != null) {
                                z45 z45Var9 = new z45();
                                z45Var9.n = true;
                                z45Var9.t = threadData;
                                z45Var9.position = i;
                                arrayList2.add(z45Var9);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                z45 z45Var10 = new z45();
                                z45Var10.t = threadData;
                                z45Var10.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    z45Var10.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    z45Var10.q = true;
                                }
                                arrayList2.add(z45Var10);
                            }
                            z45 z45Var11 = new z45();
                            z45Var11.m = true;
                            z45Var11.t = threadData;
                            z45Var11.position = i;
                            arrayList2.add(z45Var11);
                            z45 z45Var12 = new z45();
                            z45Var12.g = true;
                            z45Var12.t = threadData;
                            z45Var12.position = i;
                            arrayList2.add(z45Var12);
                        } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                            threadData.position = i;
                            arrayList2.add(threadData);
                        } else {
                            z45 z45Var13 = new z45();
                            z45Var13.t = threadData;
                            z45Var13.position = i;
                            arrayList2.add(z45Var13);
                        }
                        i++;
                    }
                }
            }
            this.h = i;
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
