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
import com.baidu.tieba.a9;
import com.baidu.tieba.ar6;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.fz4;
import com.baidu.tieba.gg;
import com.baidu.tieba.hn;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.ii;
import com.baidu.tieba.or6;
import com.baidu.tieba.oz4;
import com.baidu.tieba.p45;
import com.baidu.tieba.pr6;
import com.baidu.tieba.vy4;
import com.baidu.tieba.za;
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
/* loaded from: classes4.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public ar6 g;
    public int h;
    public HashMap<String, Integer> i;
    public pr6 j;
    public or6 k;
    public ThreadData l;
    public za m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final za q;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends za {
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

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            or6 or6Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage != null && this.a.j != null && this.a.j.b != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        or6Var = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                        or6Var = ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        or6Var = null;
                    }
                    this.a.k = or6Var;
                    this.a.mErrorCode = responsedMessage.getError();
                    this.a.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(this.a.mErrorCode);
                    errorData.setError_msg(this.a.mErrorString);
                    if (this.a.mErrorCode == 0 && or6Var != null) {
                        if (or6Var != null && this.a.l != null) {
                            or6Var.e().add(0, this.a.l);
                            if (this.a.i != null && this.a.i.containsKey(this.a.l.getTid())) {
                                this.a.i.remove(this.a.l.getTid());
                            }
                            this.a.l = null;
                        }
                        this.a.l0(or6Var, true);
                        return;
                    }
                    this.a.g.g(errorData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.h0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.h0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Comparator<fz4> {
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
        public int compare(fz4 fz4Var, fz4 fz4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fz4Var, fz4Var2)) == null) {
                int i = fz4Var.c;
                int i2 = fz4Var2.c;
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vy4)) {
                vy4 vy4Var = (vy4) customResponsedMessage.getData();
                if (vy4Var.a == 2 && (str = vy4Var.b) != null && str.equals(this.a.c)) {
                    int l = ii.l(TbadkCoreApplication.getInst());
                    int j = ii.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(gg.g(vy4Var.c, 0L), 0L, 0L, l, j, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends za {
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

        @Override // com.baidu.tieba.za
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
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, ar6 ar6Var, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ar6Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
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
        this.j = new pr6();
        this.g = ar6Var;
        this.e = p45.m().n("home_page_max_thread_count", 300);
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

    public void o0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.d = str;
            this.c = str2;
        }
    }

    public final void k0(int i) {
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
        k0(2);
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
            pr6 pr6Var = this.j;
            if (pr6Var == null) {
                return false;
            }
            return !ListUtils.isEmpty(pr6Var.b);
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            registerListener(this.p);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.a) {
            return;
        }
        this.f = true;
        k0(1);
    }

    public final int g0() {
        InterceptResult invokeV;
        int i;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            pr6 pr6Var = this.j;
            if (pr6Var != null && pr6Var.b != null) {
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
                        hn hnVar = this.j.b.get(i5);
                        if (hnVar instanceof oz4) {
                            if (i6 == -1 && ((oz4) hnVar).position > i2) {
                                i6 = i5;
                            } else if (((oz4) hnVar).position > i3) {
                                i4 = i5;
                                break;
                            }
                            if (i6 > 0 && (threadData = ((oz4) hnVar).t) != null) {
                                this.i.remove(threadData.getTid());
                            }
                        }
                        i5++;
                    }
                    if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                        ArrayList<hn> arrayList = new ArrayList<>();
                        arrayList.addAll(this.j.b.subList(0, i6));
                        ArrayList<hn> arrayList2 = this.j.b;
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

    public final void h0(CustomResponsedMessage<?> customResponsedMessage) {
        pr6 pr6Var;
        oz4 oz4Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.h > 0 && (pr6Var = this.j) != null && !ListUtils.isEmpty(pr6Var.b)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.i.containsKey(optString)) {
                Iterator<hn> it = this.j.b.iterator();
                int i = 0;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                while (it.hasNext()) {
                    hn next = it.next();
                    if ((next instanceof oz4) && (threadData = (oz4Var = (oz4) next).t) != null) {
                        if (i2 >= 0) {
                            if (oz4Var.position != i2) {
                                break;
                            }
                            it.remove();
                            i4 = i;
                        } else if (StringHelper.equals(optString, threadData.getTid())) {
                            i2 = oz4Var.position;
                            it.remove();
                            i3 = i;
                        }
                    }
                    i++;
                }
                if (i3 < i4) {
                    this.g.E0(i3, i4);
                }
            }
        }
    }

    public final ArrayList<hn> i0(ArrayList<hn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<hn> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof fz4)) {
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

    public final void j0(ArrayList<hn> arrayList, ArrayList<fz4> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, arrayList2) == null) {
            n0();
            if (!ListUtils.isEmpty(arrayList) && !ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new d(this));
                int i = 0;
                Iterator<fz4> it = arrayList2.iterator();
                while (it.hasNext()) {
                    fz4 next = it.next();
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

    public final void l0(or6 or6Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, or6Var, z) == null) && or6Var != null && this.j != null) {
            ArrayList<hn> e2 = or6Var.e();
            pr6 pr6Var = this.j;
            boolean z2 = this.f;
            pr6Var.h = z2;
            if (!z2) {
                this.b++;
            } else {
                if (z) {
                    i = ListUtils.getCount(e2);
                } else {
                    i = -1;
                }
                pr6Var.f = i;
                j0(e2, or6Var.d());
            }
            if (this.h + ListUtils.getCount(e2) > this.e) {
                this.j.e = g0();
            }
            ArrayList<hn> p0 = p0(e2);
            i0(p0);
            if (this.f) {
                this.j.b.addAll(0, p0);
                this.j.e = 0;
            } else {
                this.j.b.addAll(p0);
                this.j.c = !ListUtils.isEmpty(e2);
            }
            this.j.d = or6Var.f();
            this.j.g = or6Var.b();
            this.j.a = or6Var.c();
            ar6 ar6Var = this.g;
            if (ar6Var != null) {
                ar6Var.n1(this.j);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !ListUtils.isEmpty(this.j.b)) {
            int i = 0;
            Iterator<hn> it = this.j.b.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof fz4) {
                    it.remove();
                }
                i++;
                if (i > 93) {
                    return;
                }
            }
        }
    }

    public final ArrayList<hn> p0(ArrayList<hn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            int i = this.h;
            ArrayList<hn> arrayList2 = new ArrayList<>();
            Iterator<hn> it = arrayList.iterator();
            while (it.hasNext()) {
                hn next = it.next();
                if (next instanceof fz4) {
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (!this.i.containsKey(threadData.getTid())) {
                        this.i.put(threadData.getTid(), 0);
                        threadData.isFromEnterFroumTabFeed = true;
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                            oz4 oz4Var = new oz4();
                            oz4Var.t = threadData;
                            oz4Var.position = i;
                            oz4Var.a = true;
                            arrayList2.add(oz4Var);
                            oz4 oz4Var2 = new oz4();
                            oz4Var2.t = threadData;
                            oz4Var2.position = i;
                            if (threadData.isBJHNormalThreadType()) {
                                oz4Var2.f = true;
                            } else if (threadData.picCount() == 1) {
                                oz4Var2.d = true;
                                oz4Var2.u = imageWidthAndHeight[0];
                                oz4Var2.v = imageWidthAndHeight[1];
                            } else if (threadData.picCount() >= 2) {
                                oz4Var2.e = true;
                            } else {
                                oz4Var2.b = true;
                            }
                            arrayList2.add(oz4Var2);
                            if (threadData.getItem() != null) {
                                oz4 oz4Var3 = new oz4();
                                oz4Var3.n = true;
                                oz4Var3.t = threadData;
                                oz4Var3.position = i;
                                arrayList2.add(oz4Var3);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                oz4 oz4Var4 = new oz4();
                                oz4Var4.t = threadData;
                                oz4Var4.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    oz4Var4.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    oz4Var4.q = true;
                                }
                                arrayList2.add(oz4Var4);
                            }
                            oz4 oz4Var5 = new oz4();
                            oz4Var5.m = true;
                            oz4Var5.t = threadData;
                            oz4Var5.position = i;
                            arrayList2.add(oz4Var5);
                            oz4 oz4Var6 = new oz4();
                            oz4Var6.g = true;
                            oz4Var6.t = threadData;
                            oz4Var6.position = i;
                            arrayList2.add(oz4Var6);
                        } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                            oz4 oz4Var7 = new oz4();
                            oz4Var7.t = threadData;
                            oz4Var7.position = i;
                            oz4Var7.a = true;
                            arrayList2.add(oz4Var7);
                            oz4 oz4Var8 = new oz4();
                            oz4Var8.t = threadData;
                            oz4Var8.position = i;
                            oz4Var8.i = true;
                            arrayList2.add(oz4Var8);
                            if (threadData.getItem() != null) {
                                oz4 oz4Var9 = new oz4();
                                oz4Var9.n = true;
                                oz4Var9.t = threadData;
                                oz4Var9.position = i;
                                arrayList2.add(oz4Var9);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                oz4 oz4Var10 = new oz4();
                                oz4Var10.t = threadData;
                                oz4Var10.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    oz4Var10.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    oz4Var10.q = true;
                                }
                                arrayList2.add(oz4Var10);
                            }
                            oz4 oz4Var11 = new oz4();
                            oz4Var11.m = true;
                            oz4Var11.t = threadData;
                            oz4Var11.position = i;
                            arrayList2.add(oz4Var11);
                            oz4 oz4Var12 = new oz4();
                            oz4Var12.g = true;
                            oz4Var12.t = threadData;
                            oz4Var12.position = i;
                            arrayList2.add(oz4Var12);
                        } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                            threadData.position = i;
                            arrayList2.add(threadData);
                        } else {
                            oz4 oz4Var13 = new oz4();
                            oz4Var13.t = threadData;
                            oz4Var13.position = i;
                            arrayList2.add(oz4Var13);
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
