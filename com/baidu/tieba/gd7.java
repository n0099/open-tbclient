package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gd7 implements ib7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gd7() {
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

    @Override // com.baidu.tieba.ib7
    public List<qb7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new lc7("mount"));
            arrayList.add(new wc7("virtual_head"));
            arrayList.add(new dd7("sideway_card"));
            arrayList.add(new tc7("title"));
            arrayList.add(new fd7("social_bar"));
            arrayList.add(new kc7("live"));
            arrayList.add(new vc7("video"));
            arrayList.add(new pc7("pic"));
            arrayList.add(new hc7("mount_app"));
            arrayList.add(new zc7("common_card"));
            arrayList.add(new gc7("abstract"));
            arrayList.add(new qc7("recommend_info"));
            arrayList.add(new oc7("pei_wan"));
            arrayList.add(new ed7("recommend_card_person_attention"));
            arrayList.add(new fc7("browse_location"));
            arrayList.add(new sc7("card_single_link"));
            arrayList.add(new ad7("delegate-layout"));
            arrayList.add(new nc7("origin_card"));
            arrayList.add(new mc7("card_multi_link"));
            arrayList.add(new yc7("card_vote"));
            arrayList.add(new jc7("feed_head"));
            arrayList.add(new cd7("live_card"));
            arrayList.add(new xc7("feed_voice"));
            arrayList.add(new rc7("reply"));
            arrayList.add(new ic7("feed_entrybar"));
            arrayList.add(new bd7("img_text"));
            arrayList.add(new uc7("video_ad"));
            arrayList.add(new hd7("video_card"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
