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
public class h67 extends ThreadData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c26> a;
    public ms4 b;
    public long c;
    public int d;
    public List<Cdo> e;
    @Nullable
    public Map<String, Object> f;

    public h67() {
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

    public ArrayList<Cdo> f(bt4 bt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bt4Var)) == null) {
            ArrayList<Cdo> arrayList = new ArrayList<>(this.e);
            l(arrayList, bt4Var);
            ArrayList<Cdo> arrayList2 = new ArrayList<>();
            Iterator<Cdo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Cdo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        ot4 ot4Var = new ot4();
                        ot4Var.t = threadData;
                        ot4Var.position = i;
                        ot4Var.a = true;
                        arrayList2.add(ot4Var);
                        ot4 ot4Var2 = new ot4();
                        ot4Var2.t = threadData;
                        ot4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ot4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            ot4Var2.d = true;
                            ot4Var2.u = imageWidthAndHeight[0];
                            ot4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ot4Var2.e = true;
                        } else {
                            ot4Var2.b = true;
                        }
                        arrayList2.add(ot4Var2);
                        if (threadData.getItem() != null) {
                            ot4 ot4Var3 = new ot4();
                            ot4Var3.n = true;
                            ot4Var3.t = threadData;
                            ot4Var3.position = i;
                            arrayList2.add(ot4Var3);
                        }
                        ot4 ot4Var4 = new ot4();
                        ot4Var4.m = true;
                        ot4Var4.t = threadData;
                        ot4Var4.position = i;
                        arrayList2.add(ot4Var4);
                        ot4 ot4Var5 = new ot4();
                        ot4Var5.g = true;
                        ot4Var5.t = threadData;
                        ot4Var5.position = i;
                        arrayList2.add(ot4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        ot4 ot4Var6 = new ot4();
                        ot4Var6.t = threadData;
                        ot4Var6.position = i;
                        ot4Var6.a = true;
                        arrayList2.add(ot4Var6);
                        ot4 ot4Var7 = new ot4();
                        ot4Var7.t = threadData;
                        ot4Var7.position = i;
                        ot4Var7.i = true;
                        arrayList2.add(ot4Var7);
                        if (threadData.getItem() != null) {
                            ot4 ot4Var8 = new ot4();
                            ot4Var8.n = true;
                            ot4Var8.t = threadData;
                            ot4Var8.position = i;
                            arrayList2.add(ot4Var8);
                        }
                        ot4 ot4Var9 = new ot4();
                        ot4Var9.m = true;
                        ot4Var9.t = threadData;
                        ot4Var9.position = i;
                        arrayList2.add(ot4Var9);
                        ot4 ot4Var10 = new ot4();
                        ot4Var10.g = true;
                        ot4Var10.t = threadData;
                        ot4Var10.position = i;
                        arrayList2.add(ot4Var10);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else if (j26.W(threadData)) {
                        j26 j26Var = new j26(threadData);
                        j26Var.g = threadData.getTid();
                        arrayList2.add(j26Var);
                    } else {
                        ot4 ot4Var11 = new ot4();
                        ot4Var11.t = threadData;
                        ot4Var11.position = i;
                        arrayList2.add(ot4Var11);
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

    public final void j(List<c26> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        c26 c26Var = list.get(list.size() - 1);
        if (c26Var.getThreadData() != null) {
            this.c = dh.g(c26Var.getThreadData().getTid(), 0L);
        }
    }

    public final void l(ArrayList<Cdo> arrayList, bt4 bt4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, bt4Var) == null) || bt4Var == null || ListUtils.isEmpty(bt4Var.h())) {
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
                if (bt4Var.floorPosition == i2) {
                    ListUtils.add(arrayList, i, bt4Var);
                    break;
                }
                i2++;
            }
            i++;
        }
        if (size == 2) {
            ListUtils.add(arrayList, bt4Var);
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
                    c26 c26Var = null;
                    if (l26.R(threadData)) {
                        c26Var = new l26(threadData);
                    } else if (k26.W(threadData)) {
                        c26Var = new k26();
                        c26Var.a = threadData;
                    }
                    if (c26Var != null && c26Var.isValid()) {
                        c26Var.L("c10816");
                        this.a.add(c26Var);
                    }
                }
            }
            j(this.a);
            c(dataRes.thread_list);
        }
        if (dataRes.page != null) {
            ms4 ms4Var = new ms4();
            this.b = ms4Var;
            ms4Var.j(dataRes.page);
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
                    c26 c26Var = null;
                    if (threadData.isShareThread) {
                        c26Var = new k26();
                        c26Var.a = threadData;
                    } else if (l26.R(threadData)) {
                        c26Var = new l26(threadData);
                    } else if (k26.W(threadData)) {
                        c26Var = new k26();
                        c26Var.a = threadData;
                    }
                    if (c26Var != null && c26Var.isValid()) {
                        c26Var.L("c10816");
                        this.a.add(c26Var);
                    }
                }
            }
            j(this.a);
            c(hotThread.thread_list);
        }
        if (hotThread.page != null) {
            ms4 ms4Var = new ms4();
            this.b = ms4Var;
            ms4Var.j(hotThread.page);
        }
    }

    public h67(int i) {
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
