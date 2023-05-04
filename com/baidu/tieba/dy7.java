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
/* loaded from: classes4.dex */
public class dy7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qi6> a;
    public cz4 b;
    public long c;
    public int d;
    public List<in> e;
    @Nullable
    public Map<String, Object> f;

    public dy7() {
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

    public dy7(int i) {
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

    public final void f(List<qi6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            qi6 qi6Var = list.get(list.size() - 1);
            if (qi6Var.getThreadData() != null) {
                this.c = gg.g(qi6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<in> d(qz4 qz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qz4Var)) == null) {
            ArrayList<in> arrayList = new ArrayList<>(this.e);
            g(arrayList, qz4Var);
            ArrayList<in> arrayList2 = new ArrayList<>();
            Iterator<in> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                in next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        f05 f05Var = new f05();
                        f05Var.t = threadData;
                        f05Var.position = i;
                        f05Var.a = true;
                        arrayList2.add(f05Var);
                        f05 f05Var2 = new f05();
                        f05Var2.t = threadData;
                        f05Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            f05Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            f05Var2.d = true;
                            f05Var2.u = imageWidthAndHeight[0];
                            f05Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            f05Var2.e = true;
                        } else {
                            f05Var2.b = true;
                        }
                        arrayList2.add(f05Var2);
                        if (threadData.getItem() != null) {
                            f05 f05Var3 = new f05();
                            f05Var3.n = true;
                            f05Var3.t = threadData;
                            f05Var3.position = i;
                            arrayList2.add(f05Var3);
                        }
                        f05 f05Var4 = new f05();
                        f05Var4.m = true;
                        f05Var4.t = threadData;
                        f05Var4.position = i;
                        arrayList2.add(f05Var4);
                        f05 f05Var5 = new f05();
                        f05Var5.g = true;
                        f05Var5.t = threadData;
                        f05Var5.position = i;
                        arrayList2.add(f05Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        f05 f05Var6 = new f05();
                        f05Var6.t = threadData;
                        f05Var6.position = i;
                        f05Var6.a = true;
                        arrayList2.add(f05Var6);
                        f05 f05Var7 = new f05();
                        f05Var7.t = threadData;
                        f05Var7.position = i;
                        f05Var7.i = true;
                        arrayList2.add(f05Var7);
                        if (threadData.getItem() != null) {
                            f05 f05Var8 = new f05();
                            f05Var8.n = true;
                            f05Var8.t = threadData;
                            f05Var8.position = i;
                            arrayList2.add(f05Var8);
                        }
                        f05 f05Var9 = new f05();
                        f05Var9.m = true;
                        f05Var9.t = threadData;
                        f05Var9.position = i;
                        arrayList2.add(f05Var9);
                        f05 f05Var10 = new f05();
                        f05Var10.g = true;
                        f05Var10.t = threadData;
                        f05Var10.position = i;
                        arrayList2.add(f05Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (xi6.W(threadData)) {
                        xi6 xi6Var = new xi6(threadData);
                        xi6Var.g = threadData.getTid();
                        arrayList2.add(xi6Var);
                    } else {
                        f05 f05Var11 = new f05();
                        f05Var11.t = threadData;
                        f05Var11.position = i;
                        arrayList2.add(f05Var11);
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

    public final void g(ArrayList<in> arrayList, qz4 qz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, qz4Var) == null) && qz4Var != null && !ListUtils.isEmpty(qz4Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (qz4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, qz4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, qz4Var);
            }
        }
    }

    public void h(DataRes dataRes) {
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
                    qi6 qi6Var = null;
                    if (zi6.N(threadData)) {
                        qi6Var = new zi6(threadData);
                    } else if (yi6.W(threadData)) {
                        qi6Var = new yi6();
                        qi6Var.a = threadData;
                    }
                    if (qi6Var != null && qi6Var.isValid()) {
                        qi6Var.E("c10816");
                        this.a.add(qi6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            cz4 cz4Var = new cz4();
            this.b = cz4Var;
            cz4Var.j(dataRes.page);
        }
    }

    public void j(HotThread hotThread) {
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
                    qi6 qi6Var = null;
                    if (threadData.isShareThread) {
                        qi6Var = new yi6();
                        qi6Var.a = threadData;
                    } else if (zi6.N(threadData)) {
                        qi6Var = new zi6(threadData);
                    } else if (yi6.W(threadData)) {
                        qi6Var = new yi6();
                        qi6Var.a = threadData;
                    }
                    if (qi6Var != null && qi6Var.isValid()) {
                        qi6Var.E("c10816");
                        this.a.add(qi6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            cz4 cz4Var = new cz4();
            this.b = cz4Var;
            cz4Var.j(hotThread.page);
        }
    }
}
