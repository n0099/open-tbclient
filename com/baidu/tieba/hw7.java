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
public class hw7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<eh6> a;
    public ly4 b;
    public long c;
    public int d;
    public List<hn> e;
    @Nullable
    public Map<String, Object> f;

    public hw7() {
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

    public hw7(int i) {
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

    public final void f(List<eh6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            eh6 eh6Var = list.get(list.size() - 1);
            if (eh6Var.getThreadData() != null) {
                this.c = gg.g(eh6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<hn> d(zy4 zy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zy4Var)) == null) {
            ArrayList<hn> arrayList = new ArrayList<>(this.e);
            h(arrayList, zy4Var);
            ArrayList<hn> arrayList2 = new ArrayList<>();
            Iterator<hn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                hn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
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
                        oz4 oz4Var4 = new oz4();
                        oz4Var4.m = true;
                        oz4Var4.t = threadData;
                        oz4Var4.position = i;
                        arrayList2.add(oz4Var4);
                        oz4 oz4Var5 = new oz4();
                        oz4Var5.g = true;
                        oz4Var5.t = threadData;
                        oz4Var5.position = i;
                        arrayList2.add(oz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        oz4 oz4Var6 = new oz4();
                        oz4Var6.t = threadData;
                        oz4Var6.position = i;
                        oz4Var6.a = true;
                        arrayList2.add(oz4Var6);
                        oz4 oz4Var7 = new oz4();
                        oz4Var7.t = threadData;
                        oz4Var7.position = i;
                        oz4Var7.i = true;
                        arrayList2.add(oz4Var7);
                        if (threadData.getItem() != null) {
                            oz4 oz4Var8 = new oz4();
                            oz4Var8.n = true;
                            oz4Var8.t = threadData;
                            oz4Var8.position = i;
                            arrayList2.add(oz4Var8);
                        }
                        oz4 oz4Var9 = new oz4();
                        oz4Var9.m = true;
                        oz4Var9.t = threadData;
                        oz4Var9.position = i;
                        arrayList2.add(oz4Var9);
                        oz4 oz4Var10 = new oz4();
                        oz4Var10.g = true;
                        oz4Var10.t = threadData;
                        oz4Var10.position = i;
                        arrayList2.add(oz4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (lh6.W(threadData)) {
                        lh6 lh6Var = new lh6(threadData);
                        lh6Var.g = threadData.getTid();
                        arrayList2.add(lh6Var);
                    } else {
                        oz4 oz4Var11 = new oz4();
                        oz4Var11.t = threadData;
                        oz4Var11.position = i;
                        arrayList2.add(oz4Var11);
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

    public final void h(ArrayList<hn> arrayList, zy4 zy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, zy4Var) == null) && zy4Var != null && !ListUtils.isEmpty(zy4Var.e())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (zy4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, zy4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, zy4Var);
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
                    eh6 eh6Var = null;
                    if (nh6.R(threadData)) {
                        eh6Var = new nh6(threadData);
                    } else if (mh6.W(threadData)) {
                        eh6Var = new mh6();
                        eh6Var.a = threadData;
                    }
                    if (eh6Var != null && eh6Var.isValid()) {
                        eh6Var.H("c10816");
                        this.a.add(eh6Var);
                    }
                }
            }
            f(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            ly4 ly4Var = new ly4();
            this.b = ly4Var;
            ly4Var.j(dataRes.page);
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
                    eh6 eh6Var = null;
                    if (threadData.isShareThread) {
                        eh6Var = new mh6();
                        eh6Var.a = threadData;
                    } else if (nh6.R(threadData)) {
                        eh6Var = new nh6(threadData);
                    } else if (mh6.W(threadData)) {
                        eh6Var = new mh6();
                        eh6Var.a = threadData;
                    }
                    if (eh6Var != null && eh6Var.isValid()) {
                        eh6Var.H("c10816");
                        this.a.add(eh6Var);
                    }
                }
            }
            f(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            ly4 ly4Var = new ly4();
            this.b = ly4Var;
            ly4Var.j(hotThread.page);
        }
    }
}
