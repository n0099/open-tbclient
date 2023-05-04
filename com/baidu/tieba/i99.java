package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i99 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808480, "Lcom/baidu/tieba/i99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808480, "Lcom/baidu/tieba/i99;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<in> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                ThreadData threadData = (ThreadData) ListUtils.getItem(list, i);
                if (threadData != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    qi6 d = d(threadData);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<in> b(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                r89 r89Var = new r89();
                r89Var.d = c;
                r89Var.c = b;
                r89Var.b = a;
                r89Var.a = R.string.obfuscated_res_0x7f0f0f2b;
                arrayList.add(r89Var);
                for (int i = 0; i < list.size(); i++) {
                    ThreadData threadData = list.get(i);
                    if (threadData != null) {
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        qi6 d = d(threadData);
                        if (d != null) {
                            arrayList.add(d);
                        }
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<in> c(List<in> list) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                in inVar = (in) ListUtils.getItem(list, i);
                if ((inVar instanceof CardPersonDynamicThreadData) && (threadData = ((CardPersonDynamicThreadData) inVar).p) != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    qi6 d = d(threadData);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static qi6 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
            qi6 qi6Var = null;
            if (threadData == null) {
                return null;
            }
            threadData.isFromPersonPolymeric = true;
            threadData.insertItemToTitleOrAbstractText();
            if (threadData.isShareThread) {
                qi6Var = new yi6();
                qi6Var.a = threadData;
            } else if (ti6.W(threadData)) {
                qi6Var = new ti6(threadData);
            } else if (ui6.Z(threadData)) {
                qi6Var = new ui6(threadData);
            } else if (!yi6.W(threadData) && !yi6.X(threadData)) {
                if (zi6.N(threadData)) {
                    qi6Var = new zi6(threadData);
                }
            } else {
                qi6Var = new yi6();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                qi6Var.a = threadData;
            }
            if (qi6Var != null) {
                AbsGroupUbsABTest.setCardInfoUbsABTest(qi6Var);
            }
            return qi6Var;
        }
        return (qi6) invokeL.objValue;
    }

    public static ThreadData e(in inVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, inVar)) == null) {
            if (inVar == null || !(inVar instanceof ax4)) {
                return null;
            }
            ThreadData threadData = ((ax4) inVar).getThreadData();
            threadData.isFromPersonPolymeric = true;
            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
            return threadData;
        }
        return (ThreadData) invokeL.objValue;
    }
}
