package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class il7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public List<ym> d;
    public boolean e;
    public int f;

    public il7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a(List<ym> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            if (ListUtils.isEmpty(this.d)) {
                LinkedList linkedList = new LinkedList();
                this.d = linkedList;
                linkedList.addAll(list);
                return list.size();
            }
            LinkedList linkedList2 = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                ym ymVar = list.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 < this.d.size()) {
                        ym ymVar2 = this.d.get(i2);
                        if (ymVar != null && (ymVar instanceof hl7) && ymVar2 != null && (ymVar2 instanceof hl7)) {
                            ThreadData threadData = ((hl7) ymVar).getThreadData();
                            ThreadData threadData2 = ((hl7) ymVar2).getThreadData();
                            if (threadData != null && threadData2 != null && threadData.getTid() != null && threadData2.getTid() != null && threadData.getTid().equals(threadData2.getTid())) {
                                z = true;
                                break;
                            }
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    ListUtils.add(linkedList2, ymVar);
                }
            }
            if (linkedList2.size() != 0) {
                ListUtils.addAll(this.d, 0, linkedList2);
            }
            return linkedList2.size();
        }
        return invokeL.intValue;
    }
}
