package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.Hottopic.HotThread;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class d77 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public bt4 b;
    public long c;
    public int d;
    public List e;
    public Map f;

    public d77() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = new ArrayList();
        this.d = 1;
    }

    public Map h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public d77(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = new ArrayList();
        this.d = i;
    }

    public final void j(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            w26 w26Var = (w26) list.get(list.size() - 1);
            if (w26Var.getThreadData() != null) {
                this.c = eh.g(w26Var.getThreadData().getTid(), 0L);
            }
        }
    }

    public final void c(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf((ThreadInfo) it.next());
                threadData.insertItemToTitleOrAbstractText();
                this.e.add(threadData);
            }
        }
    }

    public ArrayList f(qt4 qt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qt4Var)) == null) {
            ArrayList arrayList = new ArrayList(this.e);
            l(arrayList, qt4Var);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) eoVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        du4 du4Var = new du4();
                        du4Var.t = threadData;
                        du4Var.position = i;
                        du4Var.a = true;
                        arrayList2.add(du4Var);
                        du4 du4Var2 = new du4();
                        du4Var2.t = threadData;
                        du4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            du4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            du4Var2.d = true;
                            du4Var2.u = imageWidthAndHeight[0];
                            du4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            du4Var2.e = true;
                        } else {
                            du4Var2.b = true;
                        }
                        arrayList2.add(du4Var2);
                        if (threadData.getItem() != null) {
                            du4 du4Var3 = new du4();
                            du4Var3.n = true;
                            du4Var3.t = threadData;
                            du4Var3.position = i;
                            arrayList2.add(du4Var3);
                        }
                        du4 du4Var4 = new du4();
                        du4Var4.m = true;
                        du4Var4.t = threadData;
                        du4Var4.position = i;
                        arrayList2.add(du4Var4);
                        du4 du4Var5 = new du4();
                        du4Var5.g = true;
                        du4Var5.t = threadData;
                        du4Var5.position = i;
                        arrayList2.add(du4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        du4 du4Var6 = new du4();
                        du4Var6.t = threadData;
                        du4Var6.position = i;
                        du4Var6.a = true;
                        arrayList2.add(du4Var6);
                        du4 du4Var7 = new du4();
                        du4Var7.t = threadData;
                        du4Var7.position = i;
                        du4Var7.i = true;
                        arrayList2.add(du4Var7);
                        if (threadData.getItem() != null) {
                            du4 du4Var8 = new du4();
                            du4Var8.n = true;
                            du4Var8.t = threadData;
                            du4Var8.position = i;
                            arrayList2.add(du4Var8);
                        }
                        du4 du4Var9 = new du4();
                        du4Var9.m = true;
                        du4Var9.t = threadData;
                        du4Var9.position = i;
                        arrayList2.add(du4Var9);
                        du4 du4Var10 = new du4();
                        du4Var10.g = true;
                        du4Var10.t = threadData;
                        du4Var10.position = i;
                        arrayList2.add(du4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (d36.W(threadData)) {
                        d36 d36Var = new d36(threadData);
                        d36Var.g = threadData.getTid();
                        arrayList2.add(d36Var);
                    } else {
                        du4 du4Var11 = new du4();
                        du4Var11.t = threadData;
                        du4Var11.position = i;
                        arrayList2.add(du4Var11);
                    }
                } else if (eoVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) eoVar).position = i;
                    arrayList2.add(eoVar);
                } else {
                    arrayList2.add(eoVar);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void l(ArrayList arrayList, qt4 qt4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, qt4Var) == null) && qt4Var != null && !ListUtils.isEmpty(qt4Var.h())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (((eo) arrayList.get(i)) instanceof ThreadData) {
                    if (qt4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, qt4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, qt4Var);
            }
        }
    }

    public void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, dataRes) != null) || dataRes == null) {
            return;
        }
        this.f = DataExt.toMap(dataRes);
        if (dataRes.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    w26 w26Var = null;
                    if (f36.R(threadData)) {
                        w26Var = new f36(threadData);
                    } else if (e36.W(threadData)) {
                        w26Var = new e36();
                        w26Var.a = threadData;
                    }
                    if (w26Var != null && w26Var.isValid()) {
                        w26Var.L("c10816");
                        this.a.add(w26Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            bt4 bt4Var = new bt4();
            this.b = bt4Var;
            bt4Var.j(dataRes.page);
        }
    }

    public void r(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, hotThread) != null) || hotThread == null) {
            return;
        }
        String str = hotThread.hot_title;
        if (hotThread.thread_list != null) {
            this.a = new ArrayList();
            for (ThreadInfo threadInfo : hotThread.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.setResource(5);
                    w26 w26Var = null;
                    if (threadData.isShareThread) {
                        w26Var = new e36();
                        w26Var.a = threadData;
                    } else if (f36.R(threadData)) {
                        w26Var = new f36(threadData);
                    } else if (e36.W(threadData)) {
                        w26Var = new e36();
                        w26Var.a = threadData;
                    }
                    if (w26Var != null && w26Var.isValid()) {
                        w26Var.L("c10816");
                        this.a.add(w26Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            bt4 bt4Var = new bt4();
            this.b = bt4Var;
            bt4Var.j(hotThread.page);
        }
    }
}
