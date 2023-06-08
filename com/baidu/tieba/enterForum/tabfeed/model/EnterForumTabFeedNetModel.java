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
import com.baidu.tieba.e45;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListHttpResponsedMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListRequestMessage;
import com.baidu.tieba.enterForum.tabfeed.message.TabFeedListSocketResponsedMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hz6;
import com.baidu.tieba.jb;
import com.baidu.tieba.k9;
import com.baidu.tieba.n45;
import com.baidu.tieba.n95;
import com.baidu.tieba.tg;
import com.baidu.tieba.u35;
import com.baidu.tieba.vi;
import com.baidu.tieba.vn;
import com.baidu.tieba.vz6;
import com.baidu.tieba.wz6;
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
    public hz6 g;
    public int h;
    public HashMap<String, Integer> i;
    public wz6 j;
    public vz6 k;
    public ThreadData l;
    public jb m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final jb q;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends jb {
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

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            vz6 vz6Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage != null && this.a.j != null && this.a.j.b != null) {
                    if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                        vz6Var = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else if (responsedMessage instanceof TabFeedListSocketResponsedMessage) {
                        vz6Var = ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData;
                    } else {
                        vz6Var = null;
                    }
                    this.a.k = vz6Var;
                    this.a.mErrorCode = responsedMessage.getError();
                    this.a.mErrorString = responsedMessage.getErrorString();
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(this.a.mErrorCode);
                    errorData.setError_msg(this.a.mErrorString);
                    if (this.a.mErrorCode == 0 && vz6Var != null) {
                        if (vz6Var != null && this.a.l != null) {
                            vz6Var.e().add(0, this.a.l);
                            if (this.a.i != null && this.a.i.containsKey(this.a.l.getTid())) {
                                this.a.i.remove(this.a.l.getTid());
                            }
                            this.a.l = null;
                        }
                        this.a.p0(vz6Var, true);
                        return;
                    }
                    this.a.g.g(errorData);
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
                this.a.l0(customResponsedMessage);
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
                this.a.l0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Comparator<e45> {
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
        public int compare(e45 e45Var, e45 e45Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, e45Var, e45Var2)) == null) {
                int i = e45Var.c;
                int i2 = e45Var2.c;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof u35)) {
                u35 u35Var = (u35) customResponsedMessage.getData();
                if (u35Var.a == 2 && (str = u35Var.b) != null && str.equals(this.a.c)) {
                    int l = vi.l(TbadkCoreApplication.getInst());
                    int j = vi.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(tg.g(u35Var.c, 0L), 0L, 0L, l, j, f, i);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends jb {
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

        @Override // com.baidu.tieba.jb
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
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, hz6 hz6Var, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hz6Var, bdUniqueId};
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
        this.j = new wz6();
        this.g = hz6Var;
        this.e = n95.m().n("home_page_max_thread_count", 300);
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

    public void s0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            this.d = str;
            this.c = str2;
        }
    }

    public final void o0(int i) {
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
        o0(2);
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
            wz6 wz6Var = this.j;
            if (wz6Var == null) {
                return false;
            }
            return !ListUtils.isEmpty(wz6Var.b);
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            registerListener(this.p);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a) {
            return;
        }
        this.f = true;
        o0(1);
    }

    public final int k0() {
        InterceptResult invokeV;
        int i;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            wz6 wz6Var = this.j;
            if (wz6Var != null && wz6Var.b != null) {
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
                        vn vnVar = this.j.b.get(i5);
                        if (vnVar instanceof n45) {
                            if (i6 == -1 && ((n45) vnVar).position > i2) {
                                i6 = i5;
                            } else if (((n45) vnVar).position > i3) {
                                i4 = i5;
                                break;
                            }
                            if (i6 > 0 && (threadData = ((n45) vnVar).t) != null) {
                                this.i.remove(threadData.getTid());
                            }
                        }
                        i5++;
                    }
                    if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                        ArrayList<vn> arrayList = new ArrayList<>();
                        arrayList.addAll(this.j.b.subList(0, i6));
                        ArrayList<vn> arrayList2 = this.j.b;
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

    public final void l0(CustomResponsedMessage<?> customResponsedMessage) {
        wz6 wz6Var;
        n45 n45Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.h > 0 && (wz6Var = this.j) != null && !ListUtils.isEmpty(wz6Var.b)) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.i.containsKey(optString)) {
                Iterator<vn> it = this.j.b.iterator();
                int i = 0;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                while (it.hasNext()) {
                    vn next = it.next();
                    if ((next instanceof n45) && (threadData = (n45Var = (n45) next).t) != null) {
                        if (i2 >= 0) {
                            if (n45Var.position != i2) {
                                break;
                            }
                            it.remove();
                            i4 = i;
                        } else if (StringHelper.equals(optString, threadData.getTid())) {
                            i2 = n45Var.position;
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

    public final ArrayList<vn> m0(ArrayList<vn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<vn> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof e45)) {
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

    public final void n0(ArrayList<vn> arrayList, ArrayList<e45> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, arrayList, arrayList2) == null) {
            r0();
            if (!ListUtils.isEmpty(arrayList) && !ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new d(this));
                int i = 0;
                Iterator<e45> it = arrayList2.iterator();
                while (it.hasNext()) {
                    e45 next = it.next();
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

    public final void p0(vz6 vz6Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, vz6Var, z) == null) && vz6Var != null && this.j != null) {
            ArrayList<vn> e2 = vz6Var.e();
            wz6 wz6Var = this.j;
            boolean z2 = this.f;
            wz6Var.h = z2;
            if (!z2) {
                this.b++;
            } else {
                if (z) {
                    i = ListUtils.getCount(e2);
                } else {
                    i = -1;
                }
                wz6Var.f = i;
                n0(e2, vz6Var.d());
            }
            if (this.h + ListUtils.getCount(e2) > this.e) {
                this.j.e = k0();
            }
            ArrayList<vn> t0 = t0(e2);
            m0(t0);
            if (this.f) {
                this.j.b.addAll(0, t0);
                this.j.e = 0;
            } else {
                this.j.b.addAll(t0);
                this.j.c = !ListUtils.isEmpty(e2);
            }
            this.j.d = vz6Var.f();
            this.j.g = vz6Var.b();
            this.j.a = vz6Var.c();
            hz6 hz6Var = this.g;
            if (hz6Var != null) {
                hz6Var.q1(this.j);
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !ListUtils.isEmpty(this.j.b)) {
            int i = 0;
            Iterator<vn> it = this.j.b.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof e45) {
                    it.remove();
                }
                i++;
                if (i > 93) {
                    return;
                }
            }
        }
    }

    public final ArrayList<vn> t0(ArrayList<vn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, arrayList)) == null) {
            int i = this.h;
            ArrayList<vn> arrayList2 = new ArrayList<>();
            Iterator<vn> it = arrayList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if (next instanceof e45) {
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (!this.i.containsKey(threadData.getTid())) {
                        this.i.put(threadData.getTid(), 0);
                        threadData.isFromEnterFroumTabFeed = true;
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                            n45 n45Var = new n45();
                            n45Var.t = threadData;
                            n45Var.position = i;
                            n45Var.a = true;
                            arrayList2.add(n45Var);
                            n45 n45Var2 = new n45();
                            n45Var2.t = threadData;
                            n45Var2.position = i;
                            if (threadData.isBJHNormalThreadType()) {
                                n45Var2.f = true;
                            } else if (threadData.picCount() == 1) {
                                n45Var2.d = true;
                                n45Var2.u = imageWidthAndHeight[0];
                                n45Var2.v = imageWidthAndHeight[1];
                            } else if (threadData.picCount() >= 2) {
                                n45Var2.e = true;
                            } else {
                                n45Var2.b = true;
                            }
                            arrayList2.add(n45Var2);
                            if (threadData.getItem() != null) {
                                n45 n45Var3 = new n45();
                                n45Var3.n = true;
                                n45Var3.t = threadData;
                                n45Var3.position = i;
                                arrayList2.add(n45Var3);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                n45 n45Var4 = new n45();
                                n45Var4.t = threadData;
                                n45Var4.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    n45Var4.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    n45Var4.q = true;
                                }
                                arrayList2.add(n45Var4);
                            }
                            n45 n45Var5 = new n45();
                            n45Var5.m = true;
                            n45Var5.t = threadData;
                            n45Var5.position = i;
                            arrayList2.add(n45Var5);
                            n45 n45Var6 = new n45();
                            n45Var6.g = true;
                            n45Var6.t = threadData;
                            n45Var6.position = i;
                            arrayList2.add(n45Var6);
                        } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                            n45 n45Var7 = new n45();
                            n45Var7.t = threadData;
                            n45Var7.position = i;
                            n45Var7.a = true;
                            arrayList2.add(n45Var7);
                            n45 n45Var8 = new n45();
                            n45Var8.t = threadData;
                            n45Var8.position = i;
                            n45Var8.i = true;
                            arrayList2.add(n45Var8);
                            if (threadData.getItem() != null) {
                                n45 n45Var9 = new n45();
                                n45Var9.n = true;
                                n45Var9.t = threadData;
                                n45Var9.position = i;
                                arrayList2.add(n45Var9);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                n45 n45Var10 = new n45();
                                n45Var10.t = threadData;
                                n45Var10.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    n45Var10.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    n45Var10.q = true;
                                }
                                arrayList2.add(n45Var10);
                            }
                            n45 n45Var11 = new n45();
                            n45Var11.m = true;
                            n45Var11.t = threadData;
                            n45Var11.position = i;
                            arrayList2.add(n45Var11);
                            n45 n45Var12 = new n45();
                            n45Var12.g = true;
                            n45Var12.t = threadData;
                            n45Var12.position = i;
                            arrayList2.add(n45Var12);
                        } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                            threadData.position = i;
                            arrayList2.add(threadData);
                        } else {
                            n45 n45Var13 = new n45();
                            n45Var13.t = threadData;
                            n45Var13.position = i;
                            arrayList2.add(n45Var13);
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
