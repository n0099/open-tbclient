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
/* loaded from: classes3.dex */
public class a57 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<l06> a;
    public hq4 b;
    public long c;
    public int d;
    public List<pn> e;
    @Nullable
    public Map<String, Object> f;

    public a57() {
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

    public ArrayList<pn> f(wq4 wq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wq4Var)) == null) {
            ArrayList<pn> arrayList = new ArrayList<>(this.e);
            l(arrayList, wq4Var);
            ArrayList<pn> arrayList2 = new ArrayList<>();
            Iterator<pn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                pn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        jr4 jr4Var = new jr4();
                        jr4Var.t = threadData;
                        jr4Var.position = i;
                        jr4Var.a = true;
                        arrayList2.add(jr4Var);
                        jr4 jr4Var2 = new jr4();
                        jr4Var2.t = threadData;
                        jr4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            jr4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            jr4Var2.d = true;
                            jr4Var2.u = imageWidthAndHeight[0];
                            jr4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            jr4Var2.e = true;
                        } else {
                            jr4Var2.b = true;
                        }
                        arrayList2.add(jr4Var2);
                        if (threadData.getItem() != null) {
                            jr4 jr4Var3 = new jr4();
                            jr4Var3.n = true;
                            jr4Var3.t = threadData;
                            jr4Var3.position = i;
                            arrayList2.add(jr4Var3);
                        }
                        jr4 jr4Var4 = new jr4();
                        jr4Var4.m = true;
                        jr4Var4.t = threadData;
                        jr4Var4.position = i;
                        arrayList2.add(jr4Var4);
                        jr4 jr4Var5 = new jr4();
                        jr4Var5.g = true;
                        jr4Var5.t = threadData;
                        jr4Var5.position = i;
                        arrayList2.add(jr4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        jr4 jr4Var6 = new jr4();
                        jr4Var6.t = threadData;
                        jr4Var6.position = i;
                        jr4Var6.a = true;
                        arrayList2.add(jr4Var6);
                        jr4 jr4Var7 = new jr4();
                        jr4Var7.t = threadData;
                        jr4Var7.position = i;
                        jr4Var7.i = true;
                        arrayList2.add(jr4Var7);
                        if (threadData.getItem() != null) {
                            jr4 jr4Var8 = new jr4();
                            jr4Var8.n = true;
                            jr4Var8.t = threadData;
                            jr4Var8.position = i;
                            arrayList2.add(jr4Var8);
                        }
                        jr4 jr4Var9 = new jr4();
                        jr4Var9.m = true;
                        jr4Var9.t = threadData;
                        jr4Var9.position = i;
                        arrayList2.add(jr4Var9);
                        jr4 jr4Var10 = new jr4();
                        jr4Var10.g = true;
                        jr4Var10.t = threadData;
                        jr4Var10.position = i;
                        arrayList2.add(jr4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (s06.W(threadData)) {
                        s06 s06Var = new s06(threadData);
                        s06Var.g = threadData.getTid();
                        arrayList2.add(s06Var);
                    } else {
                        jr4 jr4Var11 = new jr4();
                        jr4Var11.t = threadData;
                        jr4Var11.position = i;
                        arrayList2.add(jr4Var11);
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

    @Nullable
    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (Map) invokeV.objValue;
    }

    public final void j(List<l06> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        l06 l06Var = list.get(list.size() - 1);
        if (l06Var.getThreadData() != null) {
            this.c = pg.g(l06Var.getThreadData().getTid(), 0L);
        }
    }

    public final void l(ArrayList<pn> arrayList, wq4 wq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, wq4Var) == null) || wq4Var == null || ListUtils.isEmpty(wq4Var.h())) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (arrayList.get(i) instanceof ThreadData) {
                if (wq4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, wq4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, wq4Var);
        }
    }

    public void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
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
                    l06 l06Var = null;
                    if (u06.R(threadData)) {
                        l06Var = new u06(threadData);
                    } else if (t06.W(threadData)) {
                        l06Var = new t06();
                        l06Var.a = threadData;
                    }
                    if (l06Var != null && l06Var.isValid()) {
                        l06Var.L("c10816");
                        this.a.add(l06Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            hq4 hq4Var = new hq4();
            this.b = hq4Var;
            hq4Var.j(dataRes.page);
        }
    }

    public void r(HotThread hotThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hotThread) == null) || hotThread == null) {
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
                    l06 l06Var = null;
                    if (threadData.isShareThread) {
                        l06Var = new t06();
                        l06Var.a = threadData;
                    } else if (u06.R(threadData)) {
                        l06Var = new u06(threadData);
                    } else if (t06.W(threadData)) {
                        l06Var = new t06();
                        l06Var.a = threadData;
                    }
                    if (l06Var != null && l06Var.isValid()) {
                        l06Var.L("c10816");
                        this.a.add(l06Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            hq4 hq4Var = new hq4();
            this.b = hq4Var;
            hq4Var.j(hotThread.page);
        }
    }

    public a57(int i) {
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
}
