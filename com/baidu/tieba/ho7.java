package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ho7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ArrayList<vn> arrayList, String str, CardHListViewData cardHListViewData, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65536, null, arrayList, str, cardHListViewData, i)) == null) {
            if (cardHListViewData != null && !ListUtils.isEmpty(arrayList) && !StringUtils.isNull(str) && i >= 0) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    vn vnVar = arrayList.get(i2);
                    if ((vnVar instanceof CardHListViewData) && str.equals(((CardHListViewData) vnVar).threadId)) {
                        return false;
                    }
                }
                int i3 = i + 1;
                if (i3 > 0) {
                    ListUtils.add(arrayList, i3, cardHListViewData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    public static boolean b(FrsRequestData frsRequestData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsRequestData)) == null) {
            if (frsRequestData == null || frsRequestData.Z() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
