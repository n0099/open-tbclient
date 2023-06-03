package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes6.dex */
public class h58 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<mo6> a;
    public i35 b;
    public long c;
    public int d;
    public List<vn> e;
    @Nullable
    public Map<String, Object> f;

    public h58() {
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

    @Nullable
    public Map<String, Object> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public h58(int i) {
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

    public final void f(List<mo6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            mo6 mo6Var = list.get(list.size() - 1);
            if (mo6Var.getThreadData() != null) {
                this.c = tg.g(mo6Var.getThreadData().getTid(), 0L);
            }
        }
    }

    public final void c(@NonNull List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                this.e.add(threadData);
            }
        }
    }

    public ArrayList<vn> d(w35 w35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w35Var)) == null) {
            ArrayList<vn> arrayList = new ArrayList<>(this.e);
            h(arrayList, w35Var);
            ArrayList<vn> arrayList2 = new ArrayList<>();
            Iterator<vn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                vn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        l45 l45Var = new l45();
                        l45Var.t = threadData;
                        l45Var.position = i;
                        l45Var.a = true;
                        arrayList2.add(l45Var);
                        l45 l45Var2 = new l45();
                        l45Var2.t = threadData;
                        l45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            l45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            l45Var2.d = true;
                            l45Var2.u = imageWidthAndHeight[0];
                            l45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            l45Var2.e = true;
                        } else {
                            l45Var2.b = true;
                        }
                        arrayList2.add(l45Var2);
                        if (threadData.getItem() != null) {
                            l45 l45Var3 = new l45();
                            l45Var3.n = true;
                            l45Var3.t = threadData;
                            l45Var3.position = i;
                            arrayList2.add(l45Var3);
                        }
                        l45 l45Var4 = new l45();
                        l45Var4.m = true;
                        l45Var4.t = threadData;
                        l45Var4.position = i;
                        arrayList2.add(l45Var4);
                        l45 l45Var5 = new l45();
                        l45Var5.g = true;
                        l45Var5.t = threadData;
                        l45Var5.position = i;
                        arrayList2.add(l45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        l45 l45Var6 = new l45();
                        l45Var6.t = threadData;
                        l45Var6.position = i;
                        l45Var6.a = true;
                        arrayList2.add(l45Var6);
                        l45 l45Var7 = new l45();
                        l45Var7.t = threadData;
                        l45Var7.position = i;
                        l45Var7.i = true;
                        arrayList2.add(l45Var7);
                        if (threadData.getItem() != null) {
                            l45 l45Var8 = new l45();
                            l45Var8.n = true;
                            l45Var8.t = threadData;
                            l45Var8.position = i;
                            arrayList2.add(l45Var8);
                        }
                        l45 l45Var9 = new l45();
                        l45Var9.m = true;
                        l45Var9.t = threadData;
                        l45Var9.position = i;
                        arrayList2.add(l45Var9);
                        l45 l45Var10 = new l45();
                        l45Var10.g = true;
                        l45Var10.t = threadData;
                        l45Var10.position = i;
                        arrayList2.add(l45Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (to6.X(threadData)) {
                        to6 to6Var = new to6(threadData);
                        to6Var.g = threadData.getTid();
                        arrayList2.add(to6Var);
                    } else {
                        l45 l45Var11 = new l45();
                        l45Var11.t = threadData;
                        l45Var11.position = i;
                        arrayList2.add(l45Var11);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void h(ArrayList<vn> arrayList, w35 w35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, w35Var) == null) && w35Var != null && !ListUtils.isEmpty(w35Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (w35Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, w35Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, w35Var);
            }
        }
    }

    public void i(DataRes dataRes) {
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
                    mo6 mo6Var = null;
                    if (vo6.P(threadData)) {
                        mo6Var = new vo6(threadData);
                    } else if (uo6.X(threadData)) {
                        mo6Var = new uo6();
                        mo6Var.a = threadData;
                    }
                    if (mo6Var != null && mo6Var.isValid()) {
                        mo6Var.F("c10816");
                        this.a.add(mo6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            i35 i35Var = new i35();
            this.b = i35Var;
            i35Var.j(dataRes.page);
        }
    }

    public void k(HotThread hotThread) {
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
                    mo6 mo6Var = null;
                    if (threadData.isShareThread) {
                        mo6Var = new uo6();
                        mo6Var.a = threadData;
                    } else if (vo6.P(threadData)) {
                        mo6Var = new vo6(threadData);
                    } else if (uo6.X(threadData)) {
                        mo6Var = new uo6();
                        mo6Var.a = threadData;
                    }
                    if (mo6Var != null && mo6Var.isValid()) {
                        mo6Var.F("c10816");
                        this.a.add(mo6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            i35 i35Var = new i35();
            this.b = i35Var;
            i35Var.j(hotThread.page);
        }
    }
}
