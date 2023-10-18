package com.baidu.tieba.enterForum.tabfeed.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.fx6;
import com.baidu.tieba.gx6;
import com.baidu.tieba.gy4;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.py4;
import com.baidu.tieba.rw6;
import com.baidu.tieba.wx4;
import com.baidu.tieba.yh;
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
    public rw6 g;
    public int h;
    public HashMap<String, Integer> i;
    public gx6 j;
    public fx6 k;
    public ThreadData l;
    public NetMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final HttpMessageListener q;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            fx6 fx6Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage != null && this.a.j != null && this.a.j.b != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        fx6Var = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        fx6Var = null;
                    }
                    this.a.k = fx6Var;
                    this.a.mErrorCode = responsedMessage.getError();
                    this.a.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(this.a.mErrorCode);
                    errorData.setError_msg(this.a.mErrorString);
                    if (this.a.mErrorCode == 0 && fx6Var != null) {
                        if (fx6Var != null && this.a.l != null) {
                            fx6Var.e().add(0, this.a.l);
                            if (this.a.i != null && this.a.i.containsKey(this.a.l.getTid())) {
                                this.a.i.remove(this.a.l.getTid());
                            }
                            this.a.l = null;
                        }
                        this.a.i0(fx6Var, true);
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
                this.a.e0(customResponsedMessage);
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
                this.a.e0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Comparator<gy4> {
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
        public int compare(gy4 gy4Var, gy4 gy4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gy4Var, gy4Var2)) == null) {
                int i = gy4Var.c;
                int i2 = gy4Var2.c;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wx4)) {
                wx4 wx4Var = (wx4) customResponsedMessage.getData();
                if (wx4Var.a == 2 && (str = wx4Var.b) != null && str.equals(this.a.c)) {
                    int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(JavaTypesHelper.toLong(wx4Var.c, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumTabFeedNetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(EnterForumTabFeedNetModel enterForumTabFeedNetModel, int i) {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GetMyPostResIdl getMyPostResIdl;
            DataRes dataRes;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) httpResponsedMessage).getResponseData();
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
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, rw6 rw6Var, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rw6Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
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
        this.q = new f(this, CmdConfigHttp.CMD_GET_MY_POST);
        setUniqueId(bdUniqueId);
        this.m.getHttpMessageListener().setSelfListener(true);
        this.m.getSocketMessageListener().setSelfListener(true);
        registerListener(this.m);
        this.i = new HashMap<>();
        this.j = new gx6();
        this.g = rw6Var;
        this.e = SharedPrefHelper.getInstance().getInt("home_page_max_thread_count", 300);
        registerListener(this.n);
        registerListener(this.o);
        this.q.setTag(getUniqueId());
        this.q.setSelfListener(true);
        registerListener(this.q);
    }

    public void l0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            this.d = str;
            this.c = str2;
        }
    }

    public final void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
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
        h0(2);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            gx6 gx6Var = this.j;
            if (gx6Var == null) {
                return false;
            }
            return !ListUtils.isEmpty(gx6Var.b);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.cancelMessage();
            this.a = false;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            registerListener(this.p);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.a) {
            return;
        }
        this.f = true;
        h0(1);
    }

    public final int d0() {
        InterceptResult invokeV;
        int i;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            gx6 gx6Var = this.j;
            if (gx6Var != null && gx6Var.b != null) {
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
                        yh yhVar = this.j.b.get(i5);
                        if (yhVar instanceof py4) {
                            if (i6 == -1 && ((py4) yhVar).position > i2) {
                                i6 = i5;
                            } else if (((py4) yhVar).position > i3) {
                                i4 = i5;
                                break;
                            }
                            if (i6 > 0 && (threadData = ((py4) yhVar).t) != null) {
                                this.i.remove(threadData.getTid());
                            }
                        }
                        i5++;
                    }
                    if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                        ArrayList<yh> arrayList = new ArrayList<>();
                        arrayList.addAll(this.j.b.subList(0, i6));
                        ArrayList<yh> arrayList2 = this.j.b;
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

    public final void e0(CustomResponsedMessage<?> customResponsedMessage) {
        gx6 gx6Var;
        py4 py4Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.h > 0 && (gx6Var = this.j) != null && !ListUtils.isEmpty(gx6Var.b)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.i.containsKey(optString)) {
                Iterator<yh> it = this.j.b.iterator();
                int i = 0;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                while (it.hasNext()) {
                    yh next = it.next();
                    if ((next instanceof py4) && (threadData = (py4Var = (py4) next).t) != null) {
                        if (i2 >= 0) {
                            if (py4Var.position != i2) {
                                break;
                            }
                            it.remove();
                            i4 = i;
                        } else if (StringHelper.equals(optString, threadData.getTid())) {
                            i2 = py4Var.position;
                            it.remove();
                            i3 = i;
                        }
                    }
                    i++;
                }
                if (i3 < i4) {
                    this.g.W0(i3, i4);
                }
            }
        }
    }

    public final ArrayList<yh> f0(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<yh> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof gy4)) {
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

    public final void g0(ArrayList<yh> arrayList, ArrayList<gy4> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, arrayList2) == null) {
            k0();
            if (!ListUtils.isEmpty(arrayList) && !ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new d(this));
                int i = 0;
                Iterator<gy4> it = arrayList2.iterator();
                while (it.hasNext()) {
                    gy4 next = it.next();
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

    public final void i0(fx6 fx6Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, fx6Var, z) == null) && fx6Var != null && this.j != null) {
            ArrayList<yh> e2 = fx6Var.e();
            gx6 gx6Var = this.j;
            boolean z2 = this.f;
            gx6Var.h = z2;
            if (!z2) {
                this.b++;
            } else {
                if (z) {
                    i = ListUtils.getCount(e2);
                } else {
                    i = -1;
                }
                gx6Var.f = i;
                g0(e2, fx6Var.d());
            }
            if (this.h + ListUtils.getCount(e2) > this.e) {
                this.j.e = d0();
            }
            ArrayList<yh> m0 = m0(e2);
            f0(m0);
            if (this.f) {
                this.j.b.addAll(0, m0);
                this.j.e = 0;
            } else {
                this.j.b.addAll(m0);
                this.j.c = !ListUtils.isEmpty(e2);
            }
            this.j.d = fx6Var.f();
            this.j.g = fx6Var.b();
            this.j.a = fx6Var.c();
            rw6 rw6Var = this.g;
            if (rw6Var != null) {
                rw6Var.H1(this.j);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !ListUtils.isEmpty(this.j.b)) {
            int i = 0;
            Iterator<yh> it = this.j.b.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof gy4) {
                    it.remove();
                }
                i++;
                if (i > 93) {
                    return;
                }
            }
        }
    }

    public final ArrayList<yh> m0(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            int i = this.h;
            ArrayList<yh> arrayList2 = new ArrayList<>();
            Iterator<yh> it = arrayList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if (next instanceof gy4) {
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (!this.i.containsKey(threadData.getTid())) {
                        this.i.put(threadData.getTid(), 0);
                        threadData.isFromEnterFroumTabFeed = true;
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                            py4 py4Var = new py4();
                            py4Var.t = threadData;
                            py4Var.position = i;
                            py4Var.a = true;
                            arrayList2.add(py4Var);
                            py4 py4Var2 = new py4();
                            py4Var2.t = threadData;
                            py4Var2.position = i;
                            if (threadData.isBJHNormalThreadType()) {
                                py4Var2.f = true;
                            } else if (threadData.picCount() == 1) {
                                py4Var2.d = true;
                                py4Var2.u = imageWidthAndHeight[0];
                                py4Var2.v = imageWidthAndHeight[1];
                            } else if (threadData.picCount() >= 2) {
                                py4Var2.e = true;
                            } else {
                                py4Var2.b = true;
                            }
                            arrayList2.add(py4Var2);
                            if (threadData.getItem() != null) {
                                py4 py4Var3 = new py4();
                                py4Var3.n = true;
                                py4Var3.t = threadData;
                                py4Var3.position = i;
                                arrayList2.add(py4Var3);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                py4 py4Var4 = new py4();
                                py4Var4.t = threadData;
                                py4Var4.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    py4Var4.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    py4Var4.q = true;
                                }
                                arrayList2.add(py4Var4);
                            }
                            py4 py4Var5 = new py4();
                            py4Var5.m = true;
                            py4Var5.t = threadData;
                            py4Var5.position = i;
                            arrayList2.add(py4Var5);
                            py4 py4Var6 = new py4();
                            py4Var6.g = true;
                            py4Var6.t = threadData;
                            py4Var6.position = i;
                            arrayList2.add(py4Var6);
                        } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                            py4 py4Var7 = new py4();
                            py4Var7.t = threadData;
                            py4Var7.position = i;
                            py4Var7.a = true;
                            arrayList2.add(py4Var7);
                            py4 py4Var8 = new py4();
                            py4Var8.t = threadData;
                            py4Var8.position = i;
                            py4Var8.i = true;
                            arrayList2.add(py4Var8);
                            if (threadData.getItem() != null) {
                                py4 py4Var9 = new py4();
                                py4Var9.n = true;
                                py4Var9.t = threadData;
                                py4Var9.position = i;
                                arrayList2.add(py4Var9);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                py4 py4Var10 = new py4();
                                py4Var10.t = threadData;
                                py4Var10.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    py4Var10.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    py4Var10.q = true;
                                }
                                arrayList2.add(py4Var10);
                            }
                            py4 py4Var11 = new py4();
                            py4Var11.m = true;
                            py4Var11.t = threadData;
                            py4Var11.position = i;
                            arrayList2.add(py4Var11);
                            py4 py4Var12 = new py4();
                            py4Var12.g = true;
                            py4Var12.t = threadData;
                            py4Var12.position = i;
                            arrayList2.add(py4Var12);
                        } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                            threadData.position = i;
                            arrayList2.add(threadData);
                        } else {
                            py4 py4Var13 = new py4();
                            py4Var13.t = threadData;
                            py4Var13.position = i;
                            arrayList2.add(py4Var13);
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
