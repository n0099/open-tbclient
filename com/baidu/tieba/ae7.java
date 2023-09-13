package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ae7 implements gc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ae7() {
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

    @Override // com.baidu.tieba.gc7
    public List<oc7<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new pd7("video"));
            arrayList.add(new ud7("delegate-layout"));
            arrayList.add(new fd7("mount"));
            arrayList.add(new jd7("pic"));
            arrayList.add(new yd7("recommend_card_person_attention"));
            arrayList.add(new od7("video_ad"));
            arrayList.add(new gd7("card_multi_link"));
            arrayList.add(new ed7("live"));
            arrayList.add(new md7("card_single_link"));
            arrayList.add(new nd7("title"));
            arrayList.add(new cd7("feed_entrybar"));
            arrayList.add(new wd7("live_card"));
            arrayList.add(new td7("common_card"));
            arrayList.add(new ld7("reply"));
            arrayList.add(new vd7("img_text"));
            arrayList.add(new kd7("recommend_info"));
            arrayList.add(new be7("video_card"));
            arrayList.add(new id7("pei_wan"));
            arrayList.add(new zd7("social_bar"));
            arrayList.add(new hd7("origin_card"));
            arrayList.add(new xd7("sideway_card"));
            arrayList.add(new sd7("card_vote"));
            arrayList.add(new bd7("mount_app"));
            arrayList.add(new zc7("browse_location"));
            arrayList.add(new ad7("abstract"));
            arrayList.add(new qd7("virtual_head"));
            arrayList.add(new dd7("feed_head"));
            arrayList.add(new rd7("feed_voice"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
