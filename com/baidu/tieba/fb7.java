package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fb7 implements m97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fb7() {
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

    @Override // com.baidu.tieba.m97
    public List<u97<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new sa7("title"));
            arrayList.add(new cb7("sideway_card"));
            arrayList.add(new ma7("card_multi_link"));
            arrayList.add(new la7("mount"));
            arrayList.add(new xa7("card_vote"));
            arrayList.add(new eb7("social_bar"));
            arrayList.add(new va7("virtual_head"));
            arrayList.add(new ya7("common_card"));
            arrayList.add(new qa7("reply"));
            arrayList.add(new ha7("mount_app"));
            arrayList.add(new fa7("browse_location"));
            arrayList.add(new ia7("feed_entrybar"));
            arrayList.add(new wa7("feed_voice"));
            arrayList.add(new ra7("card_single_link"));
            arrayList.add(new ga7("abstract"));
            arrayList.add(new bb7("live_card"));
            arrayList.add(new ab7("img_text"));
            arrayList.add(new ja7("feed_head"));
            arrayList.add(new ua7("video"));
            arrayList.add(new oa7("pic"));
            arrayList.add(new na7("origin_card"));
            arrayList.add(new db7("recommend_card_person_attention"));
            arrayList.add(new gb7("video_card"));
            arrayList.add(new pa7("recommend_info"));
            arrayList.add(new ta7("video_ad"));
            arrayList.add(new za7("delegate-layout"));
            arrayList.add(new ka7("live"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
