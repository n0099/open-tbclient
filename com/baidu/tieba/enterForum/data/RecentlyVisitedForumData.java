package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class RecentlyVisitedForumData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<VisitedForumData> mForumData;

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
        this.mForumData = new LinkedList<>();
    }

    private boolean isExist(LinkedList<VisitedForumData> linkedList, VisitedForumData visitedForumData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, linkedList, visitedForumData)) == null) {
            if (linkedList != null && visitedForumData != null) {
                Iterator<VisitedForumData> it = linkedList.iterator();
                while (it.hasNext()) {
                    VisitedForumData next = it.next();
                    if (!ki.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void addForumItem(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, visitedForumData) == null) || visitedForumData == null) {
            return;
        }
        VisitedForumData visitedForumData2 = null;
        Iterator<VisitedForumData> it = this.mForumData.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VisitedForumData next = it.next();
            if (!ki.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                visitedForumData2 = next;
                break;
            }
        }
        if (visitedForumData2 != null) {
            this.mForumData.remove(visitedForumData2);
        }
        this.mForumData.addFirst(visitedForumData);
    }

    public int deleteForumItem(VisitedForumData visitedForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, visitedForumData)) == null) {
            int i = -1;
            if (visitedForumData == null) {
                return -1;
            }
            int size = this.mForumData.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                VisitedForumData visitedForumData2 = this.mForumData.get(i2);
                if (!ki.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                this.mForumData.remove(i);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public LinkedList<VisitedForumData> getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mForumData : (LinkedList) invokeV.objValue;
    }

    public void mergeForumData(RecentlyVisitedForumData recentlyVisitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, recentlyVisitedForumData) == null) || recentlyVisitedForumData == null || recentlyVisitedForumData.getForumData() == null || recentlyVisitedForumData.getForumData().size() == 0) {
            return;
        }
        Iterator<VisitedForumData> it = recentlyVisitedForumData.getForumData().iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (!isExist(this.mForumData, next)) {
                this.mForumData.addLast(next);
            }
        }
        trimSize(20);
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, linkedList) == null) || linkedList == null || linkedList.size() == 0) {
            return;
        }
        this.mForumData.clear();
        this.mForumData.addAll(linkedList);
    }

    public void trimSize(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.mForumData == null) {
            return;
        }
        while (this.mForumData.size() > i) {
            this.mForumData.removeLast();
        }
    }
}
