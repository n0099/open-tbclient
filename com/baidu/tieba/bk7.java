package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.HotTopic;
import tbclient.RecomTopicList;
/* loaded from: classes3.dex */
public class bk7 extends lf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;

    public bk7() {
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
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1097);
    }

    public void g(HotTopic hotTopic) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, hotTopic) != null) || hotTopic == null) {
            return;
        }
        this.floorPosition = hotTopic.floor_position.intValue();
        parserProtobuf(hotTopic.topic_list);
    }

    public void parserProtobuf(List<RecomTopicList> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        int min = Math.min(list.size(), 6);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < min; i++) {
            arrayList.add(new kf7(list.get(i), i));
        }
        f(arrayList);
    }
}
