package com.baidu.tieba.enterForum.data;

import c.a.d.f.p.m;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class RecentlyVisitedForumData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<VisitedForumData> a;

    public RecentlyVisitedForumData() {
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
        this.a = new LinkedList<>();
    }

    public LinkedList<VisitedForumData> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (LinkedList) invokeV.objValue;
    }

    public final boolean B(LinkedList<VisitedForumData> linkedList, VisitedForumData visitedForumData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList, visitedForumData)) == null) {
            if (linkedList != null && visitedForumData != null) {
                Iterator<VisitedForumData> it = linkedList.iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    if (!m.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void C(RecentlyVisitedForumData recentlyVisitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recentlyVisitedForumData) == null) || recentlyVisitedForumData == null || recentlyVisitedForumData.A() == null || recentlyVisitedForumData.A().size() == 0) {
            return;
        }
        Iterator<VisitedForumData> it = recentlyVisitedForumData.A().iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (!B(this.a, next)) {
                this.a.addLast(next);
            }
        }
        E(20);
    }

    public void D(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, linkedList) == null) || linkedList == null || linkedList.size() == 0) {
            return;
        }
        this.a.clear();
        this.a.addAll(linkedList);
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || this.a == null) {
            return;
        }
        while (this.a.size() > i) {
            this.a.removeLast();
        }
    }

    public void y(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, visitedForumData) == null) || visitedForumData == null) {
            return;
        }
        VisitedForumData visitedForumData2 = null;
        Iterator<VisitedForumData> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VisitedForumData next = it.next();
            if (!m.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                visitedForumData2 = next;
                break;
            }
        }
        if (visitedForumData2 != null) {
            this.a.remove(visitedForumData2);
        }
        this.a.addFirst(visitedForumData);
    }

    public int z(VisitedForumData visitedForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, visitedForumData)) == null) {
            int i = -1;
            if (visitedForumData == null) {
                return -1;
            }
            int size = this.a.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                VisitedForumData visitedForumData2 = this.a.get(i2);
                if (!m.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.a.remove(i);
            }
            return i;
        }
        return invokeL.intValue;
    }
}
