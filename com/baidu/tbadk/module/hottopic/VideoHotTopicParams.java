package com.baidu.tbadk.module.hottopic;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes5.dex */
public class VideoHotTopicParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("page_no")
    public int currentPn;
    @SerializedName("data")
    public List<Map<String, Object>> dataList;
    @SerializedName("enter_type")
    public String enterType;
    @SerializedName(IntentConstants.XSearch.XSEARCH_EXTRA_PAGEID)
    public String flutterPageId;
    @SerializedName("from_comment")
    public String fromComment;
    @SerializedName("has_more")
    public boolean hasMore;
    @SerializedName("sort_type")
    public int sortType;
    @SerializedName("tid")
    public String threadId;
    @SerializedName("topic_id")
    public long topicId;
    @SerializedName("topic_name")
    public String topicName;

    public VideoHotTopicParams() {
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

    public int getCurrentPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.currentPn;
        }
        return invokeV.intValue;
    }

    public List<Map<String, Object>> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dataList;
        }
        return (List) invokeV.objValue;
    }

    public String getFlutterPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.flutterPageId;
        }
        return (String) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.sortType;
        }
        return invokeV.intValue;
    }

    @NonNull
    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.threadId;
        }
        return (String) invokeV.objValue;
    }

    public long getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.topicId;
        }
        return invokeV.longValue;
    }

    public String getTopicName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.topicName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isShowComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "1".equals(this.fromComment);
        }
        return invokeV.booleanValue;
    }

    public void setCurrentPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.currentPn = i;
        }
    }
}
