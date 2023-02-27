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
public class dl7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<eg6> a;
    public a05 b;
    public long c;
    public int d;
    public List<Cdo> e;
    @Nullable
    public Map<String, Object> f;

    public dl7() {
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
    public Map<String, Object> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public dl7(int i) {
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

    public final void h(List<eg6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            eg6 eg6Var = list.get(list.size() - 1);
            if (eg6Var.getThreadData() != null) {
                this.c = dh.g(eg6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<Cdo> f(o05 o05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o05Var)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(this.e);
            j(arrayList, o05Var);
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        d15 d15Var = new d15();
                        d15Var.t = threadData;
                        d15Var.position = i;
                        d15Var.a = true;
                        arrayList2.add(d15Var);
                        d15 d15Var2 = new d15();
                        d15Var2.t = threadData;
                        d15Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            d15Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            d15Var2.d = true;
                            d15Var2.u = imageWidthAndHeight[0];
                            d15Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            d15Var2.e = true;
                        } else {
                            d15Var2.b = true;
                        }
                        arrayList2.add(d15Var2);
                        if (threadData.getItem() != null) {
                            d15 d15Var3 = new d15();
                            d15Var3.n = true;
                            d15Var3.t = threadData;
                            d15Var3.position = i;
                            arrayList2.add(d15Var3);
                        }
                        d15 d15Var4 = new d15();
                        d15Var4.m = true;
                        d15Var4.t = threadData;
                        d15Var4.position = i;
                        arrayList2.add(d15Var4);
                        d15 d15Var5 = new d15();
                        d15Var5.g = true;
                        d15Var5.t = threadData;
                        d15Var5.position = i;
                        arrayList2.add(d15Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        d15 d15Var6 = new d15();
                        d15Var6.t = threadData;
                        d15Var6.position = i;
                        d15Var6.a = true;
                        arrayList2.add(d15Var6);
                        d15 d15Var7 = new d15();
                        d15Var7.t = threadData;
                        d15Var7.position = i;
                        d15Var7.i = true;
                        arrayList2.add(d15Var7);
                        if (threadData.getItem() != null) {
                            d15 d15Var8 = new d15();
                            d15Var8.n = true;
                            d15Var8.t = threadData;
                            d15Var8.position = i;
                            arrayList2.add(d15Var8);
                        }
                        d15 d15Var9 = new d15();
                        d15Var9.m = true;
                        d15Var9.t = threadData;
                        d15Var9.position = i;
                        arrayList2.add(d15Var9);
                        d15 d15Var10 = new d15();
                        d15Var10.g = true;
                        d15Var10.t = threadData;
                        d15Var10.position = i;
                        arrayList2.add(d15Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (lg6.W(threadData)) {
                        lg6 lg6Var = new lg6(threadData);
                        lg6Var.g = threadData.getTid();
                        arrayList2.add(lg6Var);
                    } else {
                        d15 d15Var11 = new d15();
                        d15Var11.t = threadData;
                        d15Var11.position = i;
                        arrayList2.add(d15Var11);
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

    public final void j(ArrayList<Cdo> arrayList, o05 o05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, o05Var) == null) && o05Var != null && !ListUtils.isEmpty(o05Var.g())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (o05Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, o05Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, o05Var);
            }
        }
    }

    public void l(DataRes dataRes) {
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
                    eg6 eg6Var = null;
                    if (ng6.R(threadData)) {
                        eg6Var = new ng6(threadData);
                    } else if (mg6.W(threadData)) {
                        eg6Var = new mg6();
                        eg6Var.a = threadData;
                    }
                    if (eg6Var != null && eg6Var.isValid()) {
                        eg6Var.J("c10816");
                        this.a.add(eg6Var);
                    }
                }
            }
            h(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            a05 a05Var = new a05();
            this.b = a05Var;
            a05Var.j(dataRes.page);
        }
    }

    public void n(HotThread hotThread) {
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
                    eg6 eg6Var = null;
                    if (threadData.isShareThread) {
                        eg6Var = new mg6();
                        eg6Var.a = threadData;
                    } else if (ng6.R(threadData)) {
                        eg6Var = new ng6(threadData);
                    } else if (mg6.W(threadData)) {
                        eg6Var = new mg6();
                        eg6Var.a = threadData;
                    }
                    if (eg6Var != null && eg6Var.isValid()) {
                        eg6Var.J("c10816");
                        this.a.add(eg6Var);
                    }
                }
            }
            h(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            a05 a05Var = new a05();
            this.b = a05Var;
            a05Var.j(hotThread.page);
        }
    }
}
