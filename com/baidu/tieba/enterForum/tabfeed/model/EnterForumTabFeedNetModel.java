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
import com.repackage.a56;
import com.repackage.b56;
import com.repackage.b9;
import com.repackage.jg;
import com.repackage.jn;
import com.repackage.kp4;
import com.repackage.li;
import com.repackage.m46;
import com.repackage.rp4;
import com.repackage.wa;
import com.repackage.ys4;
import com.repackage.zo4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes3.dex */
public class EnterForumTabFeedNetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public m46 g;
    public int h;
    public HashMap<String, Integer> i;
    public b56 j;
    public a56 k;
    public ThreadData l;
    public wa m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public final wa q;

    /* loaded from: classes3.dex */
    public class a extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a56 a56Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage == null || this.a.j == null || this.a.j.b == null) {
                    return;
                }
                if (responsedMessage instanceof TabFeedListHttpResponsedMessage) {
                    a56Var = ((TabFeedListHttpResponsedMessage) responsedMessage).enterForumTabFeedData;
                } else {
                    a56Var = responsedMessage instanceof TabFeedListSocketResponsedMessage ? ((TabFeedListSocketResponsedMessage) responsedMessage).enterForumTabFeedData : null;
                }
                this.a.k = a56Var;
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(this.a.mErrorString);
                if (this.a.mErrorCode != 0 || a56Var == null) {
                    this.a.g.onServerError(errorData);
                    return;
                }
                if (a56Var != null && this.a.l != null) {
                    a56Var.e().add(0, this.a.l);
                    if (this.a.i != null && this.a.i.containsKey(this.a.l.getTid())) {
                        this.a.i.remove(this.a.l.getTid());
                    }
                    this.a.l = null;
                }
                this.a.T(a56Var, true);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements Comparator<kp4> {
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
        public int compare(kp4 kp4Var, kp4 kp4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kp4Var, kp4Var2)) == null) {
                int i = kp4Var.c;
                int i2 = kp4Var2.c;
                if (i == i2) {
                    return 0;
                }
                return i > i2 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zo4)) {
                zo4 zo4Var = (zo4) customResponsedMessage.getData();
                if (zo4Var.a == 2 && (str = zo4Var.b) != null && str.equals(this.a.c)) {
                    int k = li.k(TbadkCoreApplication.getInst());
                    int i = li.i(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setTag(this.a.getUniqueId());
                    requestGetMyPostNetMessage.setParams(jg.g(zo4Var.c, 0L), 0L, 0L, k, i, f, i2);
                    requestGetMyPostNetMessage.setBFrom("push");
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends wa {
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

        @Override // com.repackage.wa
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
    public EnterForumTabFeedNetModel(TbPageContext tbPageContext, m46 m46Var, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, m46Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
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
        this.j = new b56();
        this.g = m46Var;
        this.e = ys4.k().l("home_page_max_thread_count", 300);
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
            b56 b56Var = this.j;
            if (b56Var != null && b56Var.b != null) {
                int i2 = this.f ? this.h - 60 : 30;
                int i3 = i2 + 30;
                if (i2 >= 0 && i2 <= (i = this.h) && i3 >= 0 && i3 <= i && i3 >= i2) {
                    int i4 = -1;
                    int i5 = 0;
                    int i6 = -1;
                    while (true) {
                        if (i5 >= this.j.b.size()) {
                            break;
                        }
                        jn jnVar = this.j.b.get(i5);
                        if (jnVar instanceof rp4) {
                            if (i6 == -1 && ((rp4) jnVar).position > i2) {
                                i6 = i5;
                            } else if (((rp4) jnVar).position > i3) {
                                i4 = i5;
                                break;
                            }
                            if (i6 > 0 && (threadData = ((rp4) jnVar).s) != null) {
                                this.i.remove(threadData.getTid());
                            }
                        }
                        i5++;
                    }
                    if (i6 < i4 && i4 >= 0 && i6 >= 0) {
                        ArrayList<jn> arrayList = new ArrayList<>();
                        arrayList.addAll(this.j.b.subList(0, i6));
                        ArrayList<jn> arrayList2 = this.j.b;
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

    public final void P(CustomResponsedMessage<?> customResponsedMessage) {
        b56 b56Var;
        rp4 rp4Var;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.h <= 0 || (b56Var = this.j) == null || ListUtils.isEmpty(b56Var.b)) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString) || !this.i.containsKey(optString)) {
            return;
        }
        Iterator<jn> it = this.j.b.iterator();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        while (it.hasNext()) {
            jn next = it.next();
            if ((next instanceof rp4) && (threadData = (rp4Var = (rp4) next).s) != null) {
                if (i2 >= 0) {
                    if (rp4Var.position != i2) {
                        break;
                    }
                    it.remove();
                    i4 = i;
                } else if (StringHelper.equals(optString, threadData.getTid())) {
                    i2 = rp4Var.position;
                    it.remove();
                    i3 = i;
                }
            }
            i++;
        }
        if (i3 < i4) {
            this.g.S(i3, i4);
        }
    }

    public final ArrayList<jn> Q(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                boolean z = true;
                Iterator<jn> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof kp4)) {
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

    public final void R(ArrayList<jn> arrayList, ArrayList<kp4> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, arrayList, arrayList2) == null) {
            V();
            if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(arrayList2)) {
                return;
            }
            Collections.sort(arrayList2, new d(this));
            int i = 0;
            Iterator<kp4> it = arrayList2.iterator();
            while (it.hasNext()) {
                kp4 next = it.next();
                int i2 = next.c + i;
                if (TextUtils.isEmpty(next.a) || TextUtils.isEmpty(next.b) || next.c == 0 || i2 > arrayList.size()) {
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
            tabFeedListRequestMessage.tabCode = this.d;
            tabFeedListRequestMessage.tabName = this.c;
            if (i == 2) {
                tabFeedListRequestMessage.pn = this.b + 1;
            } else if (i != 1) {
                return;
            } else {
                tabFeedListRequestMessage.pn = 1;
            }
            this.a = true;
            sendMessage(tabFeedListRequestMessage);
        }
    }

    public final void T(a56 a56Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, a56Var, z) == null) || a56Var == null || this.j == null) {
            return;
        }
        ArrayList<jn> e2 = a56Var.e();
        b56 b56Var = this.j;
        boolean z2 = this.f;
        b56Var.h = z2;
        if (!z2) {
            this.b++;
        } else {
            b56Var.f = z ? ListUtils.getCount(e2) : -1;
            R(e2, a56Var.d());
        }
        if (this.h + ListUtils.getCount(e2) > this.e) {
            this.j.e = O();
        }
        ArrayList<jn> X = X(e2);
        Q(X);
        if (this.f) {
            this.j.b.addAll(0, X);
            this.j.e = 0;
        } else {
            this.j.b.addAll(X);
            this.j.c = !ListUtils.isEmpty(e2);
        }
        this.j.d = a56Var.f();
        this.j.g = a56Var.b();
        this.j.a = a56Var.c();
        m46 m46Var = this.g;
        if (m46Var != null) {
            m46Var.r0(this.j);
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.j.b)) {
            return;
        }
        int i = 0;
        Iterator<jn> it = this.j.b.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof kp4) {
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
            this.d = str;
            this.c = str2;
        }
    }

    public final ArrayList<jn> X(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            int i = this.h;
            ArrayList<jn> arrayList2 = new ArrayList<>();
            Iterator<jn> it = arrayList.iterator();
            while (it.hasNext()) {
                jn next = it.next();
                if (next instanceof kp4) {
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (!this.i.containsKey(threadData.getTid())) {
                        this.i.put(threadData.getTid(), 0);
                        threadData.isFromEnterFroumTabFeed = true;
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                            rp4 rp4Var = new rp4();
                            rp4Var.s = threadData;
                            rp4Var.position = i;
                            rp4Var.a = true;
                            arrayList2.add(rp4Var);
                            rp4 rp4Var2 = new rp4();
                            rp4Var2.s = threadData;
                            rp4Var2.position = i;
                            if (threadData.isBJHNormalThreadType()) {
                                rp4Var2.f = true;
                            } else if (threadData.picCount() == 1) {
                                rp4Var2.d = true;
                                rp4Var2.t = imageWidthAndHeight[0];
                                rp4Var2.u = imageWidthAndHeight[1];
                            } else if (threadData.picCount() >= 2) {
                                rp4Var2.e = true;
                            } else {
                                rp4Var2.b = true;
                            }
                            arrayList2.add(rp4Var2);
                            if (threadData.getItem() != null) {
                                rp4 rp4Var3 = new rp4();
                                rp4Var3.n = true;
                                rp4Var3.s = threadData;
                                rp4Var3.position = i;
                                arrayList2.add(rp4Var3);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                rp4 rp4Var4 = new rp4();
                                rp4Var4.s = threadData;
                                rp4Var4.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    rp4Var4.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    rp4Var4.q = true;
                                }
                                arrayList2.add(rp4Var4);
                            }
                            rp4 rp4Var5 = new rp4();
                            rp4Var5.m = true;
                            rp4Var5.s = threadData;
                            rp4Var5.position = i;
                            arrayList2.add(rp4Var5);
                            rp4 rp4Var6 = new rp4();
                            rp4Var6.g = true;
                            rp4Var6.s = threadData;
                            rp4Var6.position = i;
                            arrayList2.add(rp4Var6);
                        } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                            rp4 rp4Var7 = new rp4();
                            rp4Var7.s = threadData;
                            rp4Var7.position = i;
                            rp4Var7.a = true;
                            arrayList2.add(rp4Var7);
                            rp4 rp4Var8 = new rp4();
                            rp4Var8.s = threadData;
                            rp4Var8.position = i;
                            rp4Var8.i = true;
                            arrayList2.add(rp4Var8);
                            if (threadData.getItem() != null) {
                                rp4 rp4Var9 = new rp4();
                                rp4Var9.n = true;
                                rp4Var9.s = threadData;
                                rp4Var9.position = i;
                                arrayList2.add(rp4Var9);
                            }
                            if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                                rp4 rp4Var10 = new rp4();
                                rp4Var10.s = threadData;
                                rp4Var10.position = i;
                                if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                    rp4Var10.p = true;
                                } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                    rp4Var10.q = true;
                                }
                                arrayList2.add(rp4Var10);
                            }
                            rp4 rp4Var11 = new rp4();
                            rp4Var11.m = true;
                            rp4Var11.s = threadData;
                            rp4Var11.position = i;
                            arrayList2.add(rp4Var11);
                            rp4 rp4Var12 = new rp4();
                            rp4Var12.g = true;
                            rp4Var12.s = threadData;
                            rp4Var12.position = i;
                            arrayList2.add(rp4Var12);
                        } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                            threadData.position = i;
                            arrayList2.add(threadData);
                        } else {
                            rp4 rp4Var13 = new rp4();
                            rp4Var13.s = threadData;
                            rp4Var13.position = i;
                            arrayList2.add(rp4Var13);
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b56 b56Var = this.j;
            if (b56Var == null) {
                return false;
            }
            return !ListUtils.isEmpty(b56Var.b);
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
        this.f = false;
        S(2);
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.a) {
            return;
        }
        this.f = true;
        S(1);
    }
}
