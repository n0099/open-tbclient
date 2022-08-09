package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Loop.LiveRes;
import tbclient.Loop.YyLiveInfoSimple;
/* loaded from: classes3.dex */
public class LiveRemindData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3547090251629832025L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isPollingEnd;
    public List<LiveRemindRecommendData> liveRecommendList;
    public LiveRemindNormalConfigData normalConfig;

    public LiveRemindData() {
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

    public List<LiveRemindRecommendData> getLiveRecommendList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.liveRecommendList : (List) invokeV.objValue;
    }

    public LiveRemindNormalConfigData getNormalConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.normalConfig : (LiveRemindNormalConfigData) invokeV.objValue;
    }

    public boolean isPollingEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isPollingEnd : invokeV.booleanValue;
    }

    public void parserProtobuf(LiveRes liveRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, liveRes) == null) || liveRes == null) {
            return;
        }
        List<YyLiveInfoSimple> list = liveRes.live_list;
        if (list != null && !ListUtils.isEmpty(list)) {
            this.liveRecommendList = new ArrayList();
            for (YyLiveInfoSimple yyLiveInfoSimple : liveRes.live_list) {
                LiveRemindRecommendData liveRemindRecommendData = new LiveRemindRecommendData();
                liveRemindRecommendData.parserProtobuf(yyLiveInfoSimple);
                this.liveRecommendList.add(liveRemindRecommendData);
            }
        }
        if (liveRes.normal_config != null) {
            LiveRemindNormalConfigData liveRemindNormalConfigData = new LiveRemindNormalConfigData();
            this.normalConfig = liveRemindNormalConfigData;
            liveRemindNormalConfigData.parserProtobuf(liveRes.normal_config);
        }
        String str = liveRes.is_end;
        if (str != null) {
            this.isPollingEnd = "1".equals(str);
        }
    }

    public void setLiveRecommendList(List<LiveRemindRecommendData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.liveRecommendList = list;
        }
    }

    public void setNormalConfigData(LiveRemindNormalConfigData liveRemindNormalConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, liveRemindNormalConfigData) == null) {
            this.normalConfig = liveRemindNormalConfigData;
        }
    }
}
