package com.baidu.tieba.enterForum.data;

import b.a.e.e.p.k;
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
/* loaded from: classes9.dex */
public class RecentlyVisitedForumData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<VisitedForumData> f47592e;

    public RecentlyVisitedForumData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47592e = new LinkedList<>();
    }

    public void A(RecentlyVisitedForumData recentlyVisitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, recentlyVisitedForumData) == null) || recentlyVisitedForumData == null || recentlyVisitedForumData.y() == null || recentlyVisitedForumData.y().size() == 0) {
            return;
        }
        Iterator<VisitedForumData> it = recentlyVisitedForumData.y().iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (!z(this.f47592e, next)) {
                this.f47592e.addLast(next);
            }
        }
        C(20);
    }

    public void B(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) || linkedList == null || linkedList.size() == 0) {
            return;
        }
        this.f47592e.clear();
        this.f47592e.addAll(linkedList);
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f47592e == null) {
            return;
        }
        while (this.f47592e.size() > i2) {
            this.f47592e.removeLast();
        }
    }

    public void w(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, visitedForumData) == null) || visitedForumData == null) {
            return;
        }
        VisitedForumData visitedForumData2 = null;
        Iterator<VisitedForumData> it = this.f47592e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VisitedForumData next = it.next();
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                visitedForumData2 = next;
                break;
            }
        }
        if (visitedForumData2 != null) {
            this.f47592e.remove(visitedForumData2);
        }
        this.f47592e.addFirst(visitedForumData);
    }

    public int x(VisitedForumData visitedForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, visitedForumData)) == null) {
            int i2 = -1;
            if (visitedForumData == null) {
                return -1;
            }
            int size = this.f47592e.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                VisitedForumData visitedForumData2 = this.f47592e.get(i3);
                if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 >= 0) {
                this.f47592e.remove(i2);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public LinkedList<VisitedForumData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47592e : (LinkedList) invokeV.objValue;
    }

    public final boolean z(LinkedList<VisitedForumData> linkedList, VisitedForumData visitedForumData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, linkedList, visitedForumData)) == null) {
            if (linkedList != null && visitedForumData != null) {
                Iterator<VisitedForumData> it = linkedList.iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
