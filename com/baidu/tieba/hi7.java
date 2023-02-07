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
public class hi7 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<sd6> a;
    public ty4 b;
    public long c;
    public int d;
    public List<Cdo> e;
    @Nullable
    public Map<String, Object> f;

    public hi7() {
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
    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public hi7(int i) {
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

    public final void i(List<sd6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && !ListUtils.isEmpty(list)) {
            sd6 sd6Var = list.get(list.size() - 1);
            if (sd6Var.getThreadData() != null) {
                this.c = dh.g(sd6Var.getThreadData().getTid(), 0L);
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

    public ArrayList<Cdo> f(hz4 hz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(this.e);
            k(arrayList, hz4Var);
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        wz4 wz4Var = new wz4();
                        wz4Var.t = threadData;
                        wz4Var.position = i;
                        wz4Var.a = true;
                        arrayList2.add(wz4Var);
                        wz4 wz4Var2 = new wz4();
                        wz4Var2.t = threadData;
                        wz4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            wz4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            wz4Var2.d = true;
                            wz4Var2.u = imageWidthAndHeight[0];
                            wz4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            wz4Var2.e = true;
                        } else {
                            wz4Var2.b = true;
                        }
                        arrayList2.add(wz4Var2);
                        if (threadData.getItem() != null) {
                            wz4 wz4Var3 = new wz4();
                            wz4Var3.n = true;
                            wz4Var3.t = threadData;
                            wz4Var3.position = i;
                            arrayList2.add(wz4Var3);
                        }
                        wz4 wz4Var4 = new wz4();
                        wz4Var4.m = true;
                        wz4Var4.t = threadData;
                        wz4Var4.position = i;
                        arrayList2.add(wz4Var4);
                        wz4 wz4Var5 = new wz4();
                        wz4Var5.g = true;
                        wz4Var5.t = threadData;
                        wz4Var5.position = i;
                        arrayList2.add(wz4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        wz4 wz4Var6 = new wz4();
                        wz4Var6.t = threadData;
                        wz4Var6.position = i;
                        wz4Var6.a = true;
                        arrayList2.add(wz4Var6);
                        wz4 wz4Var7 = new wz4();
                        wz4Var7.t = threadData;
                        wz4Var7.position = i;
                        wz4Var7.i = true;
                        arrayList2.add(wz4Var7);
                        if (threadData.getItem() != null) {
                            wz4 wz4Var8 = new wz4();
                            wz4Var8.n = true;
                            wz4Var8.t = threadData;
                            wz4Var8.position = i;
                            arrayList2.add(wz4Var8);
                        }
                        wz4 wz4Var9 = new wz4();
                        wz4Var9.m = true;
                        wz4Var9.t = threadData;
                        wz4Var9.position = i;
                        arrayList2.add(wz4Var9);
                        wz4 wz4Var10 = new wz4();
                        wz4Var10.g = true;
                        wz4Var10.t = threadData;
                        wz4Var10.position = i;
                        arrayList2.add(wz4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (zd6.W(threadData)) {
                        zd6 zd6Var = new zd6(threadData);
                        zd6Var.g = threadData.getTid();
                        arrayList2.add(zd6Var);
                    } else {
                        wz4 wz4Var11 = new wz4();
                        wz4Var11.t = threadData;
                        wz4Var11.position = i;
                        arrayList2.add(wz4Var11);
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

    public final void k(ArrayList<Cdo> arrayList, hz4 hz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, hz4Var) == null) && hz4Var != null && !ListUtils.isEmpty(hz4Var.h())) {
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (arrayList.get(i) instanceof ThreadData) {
                    if (hz4Var.floorPosition == i2) {
                        ListUtils.add(arrayList, i, hz4Var);
                        break;
                    }
                    i2++;
                }
                i++;
            }
            if (size == 2) {
                ListUtils.add(arrayList, hz4Var);
            }
        }
    }

    public void m(DataRes dataRes) {
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
                    sd6 sd6Var = null;
                    if (be6.R(threadData)) {
                        sd6Var = new be6(threadData);
                    } else if (ae6.W(threadData)) {
                        sd6Var = new ae6();
                        sd6Var.a = threadData;
                    }
                    if (sd6Var != null && sd6Var.isValid()) {
                        sd6Var.L("c10816");
                        this.a.add(sd6Var);
                    }
                }
            }
            i(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            ty4 ty4Var = new ty4();
            this.b = ty4Var;
            ty4Var.j(dataRes.page);
        }
    }

    public void o(HotThread hotThread) {
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
                    sd6 sd6Var = null;
                    if (threadData.isShareThread) {
                        sd6Var = new ae6();
                        sd6Var.a = threadData;
                    } else if (be6.R(threadData)) {
                        sd6Var = new be6(threadData);
                    } else if (ae6.W(threadData)) {
                        sd6Var = new ae6();
                        sd6Var.a = threadData;
                    }
                    if (sd6Var != null && sd6Var.isValid()) {
                        sd6Var.L("c10816");
                        this.a.add(sd6Var);
                    }
                }
            }
            i(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            ty4 ty4Var = new ty4();
            this.b = ty4Var;
            ty4Var.j(hotThread.page);
        }
    }
}
