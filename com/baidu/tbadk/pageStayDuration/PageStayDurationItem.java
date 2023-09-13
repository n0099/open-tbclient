package com.baidu.tbadk.pageStayDuration;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ms5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class PageStayDurationItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String abTag;
    public int adSource;
    public String currentPageKey;
    public long fid;
    public String isDynamic;
    public boolean isRouteStat;
    public String isVertical;
    public ms5 mTbPageExtra;
    public String nid;
    public String objID;
    public String objLocation;
    public String objNAME;
    public String objParam1;
    public long pid;
    public String resourceId;
    public String resourceType;
    public List<String> sorceKeyList;
    public long stayDurationTime;
    public String task_id;
    public int threadType;
    public long tid;
    public String topicId;
    public String topicSubjectName;

    public PageStayDurationItem() {
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
        this.isRouteStat = false;
        this.adSource = 0;
    }

    public String getAbTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.abTag;
        }
        return (String) invokeV.objValue;
    }

    public int getAdSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.adSource;
        }
        return invokeV.intValue;
    }

    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.currentPageKey;
        }
        return (String) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fid;
        }
        return invokeV.longValue;
    }

    public String getNid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.nid;
        }
        return (String) invokeV.objValue;
    }

    public String getObjLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.objLocation;
        }
        return (String) invokeV.objValue;
    }

    public long getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.pid;
        }
        return invokeV.longValue;
    }

    public List<String> getSorceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.sorceKeyList;
        }
        return (List) invokeV.objValue;
    }

    public long getStayDurationTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.stayDurationTime;
        }
        return invokeV.longValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.task_id;
        }
        return (String) invokeV.objValue;
    }

    public ms5 getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mTbPageExtra;
        }
        return (ms5) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.threadType;
        }
        return invokeV.intValue;
    }

    public long getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.tid;
        }
        return invokeV.longValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.topicId;
        }
        return (String) invokeV.objValue;
    }

    public String getTopicSubjectName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.topicSubjectName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isDirtyData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (StringUtils.isNull(this.currentPageKey)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAbTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.abTag = str;
        }
    }

    public void setAdSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.adSource = i;
        }
    }

    public void setCurrentPageKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.currentPageKey = str;
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.fid = j;
        }
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.nid = str;
        }
    }

    public void setObjLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.objLocation = str;
        }
    }

    public void setPid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.pid = j;
        }
    }

    public void setSorceKeyList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.sorceKeyList = list;
        }
    }

    public void setStayDurationTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.stayDurationTime = j;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.task_id = str;
        }
    }

    public void setTbPageExtra(ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ms5Var) == null) {
            this.mTbPageExtra = ms5Var;
        }
    }

    public void setThreadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.threadType = i;
        }
    }

    public void setTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.tid = j;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.topicId = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.topicSubjectName = str;
        }
    }
}
