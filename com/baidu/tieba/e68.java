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
/* loaded from: classes5.dex */
public class e68 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yo6> a;
    public o35 b;
    public long c;
    public int d;
    public List<xn> e;
    @Nullable
    public Map<String, Object> f;

    public e68() {
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

    public e68(int i) {
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

    public final void f(List<yo6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            yo6 yo6Var = list.get(list.size() - 1);
            if (yo6Var.getThreadData() != null) {
                this.c = vg.g(yo6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<xn> d(c45 c45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c45Var)) == null) {
            ArrayList<xn> arrayList = new ArrayList<>(this.e);
            h(arrayList, c45Var);
            ArrayList<xn> arrayList2 = new ArrayList<>();
            Iterator<xn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        r45 r45Var = new r45();
                        r45Var.t = threadData;
                        r45Var.position = i;
                        r45Var.a = true;
                        arrayList2.add(r45Var);
                        r45 r45Var2 = new r45();
                        r45Var2.t = threadData;
                        r45Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            r45Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            r45Var2.d = true;
                            r45Var2.u = imageWidthAndHeight[0];
                            r45Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            r45Var2.e = true;
                        } else {
                            r45Var2.b = true;
                        }
                        arrayList2.add(r45Var2);
                        if (threadData.getItem() != null) {
                            r45 r45Var3 = new r45();
                            r45Var3.n = true;
                            r45Var3.t = threadData;
                            r45Var3.position = i;
                            arrayList2.add(r45Var3);
                        }
                        r45 r45Var4 = new r45();
                        r45Var4.m = true;
                        r45Var4.t = threadData;
                        r45Var4.position = i;
                        arrayList2.add(r45Var4);
                        r45 r45Var5 = new r45();
                        r45Var5.g = true;
                        r45Var5.t = threadData;
                        r45Var5.position = i;
                        arrayList2.add(r45Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        r45 r45Var6 = new r45();
                        r45Var6.t = threadData;
                        r45Var6.position = i;
                        r45Var6.a = true;
                        arrayList2.add(r45Var6);
                        r45 r45Var7 = new r45();
                        r45Var7.t = threadData;
                        r45Var7.position = i;
                        r45Var7.i = true;
                        arrayList2.add(r45Var7);
                        if (threadData.getItem() != null) {
                            r45 r45Var8 = new r45();
                            r45Var8.n = true;
                            r45Var8.t = threadData;
                            r45Var8.position = i;
                            arrayList2.add(r45Var8);
                        }
                        r45 r45Var9 = new r45();
                        r45Var9.m = true;
                        r45Var9.t = threadData;
                        r45Var9.position = i;
                        arrayList2.add(r45Var9);
                        r45 r45Var10 = new r45();
                        r45Var10.g = true;
                        r45Var10.t = threadData;
                        r45Var10.position = i;
                        arrayList2.add(r45Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (fp6.X(threadData)) {
                        fp6 fp6Var = new fp6(threadData);
                        fp6Var.g = threadData.getTid();
                        arrayList2.add(fp6Var);
                    } else {
                        r45 r45Var11 = new r45();
                        r45Var11.t = threadData;
                        r45Var11.position = i;
                        arrayList2.add(r45Var11);
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

    public final void h(ArrayList<xn> arrayList, c45 c45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, c45Var) == null) && c45Var != null && !ListUtils.isEmpty(c45Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (c45Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, c45Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, c45Var);
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
                    yo6 yo6Var = null;
                    if (hp6.P(threadData)) {
                        yo6Var = new hp6(threadData);
                    } else if (gp6.X(threadData)) {
                        yo6Var = new gp6();
                        yo6Var.a = threadData;
                    }
                    if (yo6Var != null && yo6Var.isValid()) {
                        yo6Var.F("c10816");
                        this.a.add(yo6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            o35 o35Var = new o35();
            this.b = o35Var;
            o35Var.j(dataRes.page);
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
                    yo6 yo6Var = null;
                    if (threadData.isShareThread) {
                        yo6Var = new gp6();
                        yo6Var.a = threadData;
                    } else if (hp6.P(threadData)) {
                        yo6Var = new hp6(threadData);
                    } else if (gp6.X(threadData)) {
                        yo6Var = new gp6();
                        yo6Var.a = threadData;
                    }
                    if (yo6Var != null && yo6Var.isValid()) {
                        yo6Var.F("c10816");
                        this.a.add(yo6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            o35 o35Var = new o35();
            this.b = o35Var;
            o35Var.j(hotThread.page);
        }
    }
}
