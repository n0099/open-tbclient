package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f17 implements sz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f17() {
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

    @Override // com.baidu.tieba.sz6
    public List<a07<?, ?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d17("recommend_card_person_attention"));
            arrayList.add(new p07("mount"));
            arrayList.add(new a17("img_text"));
            arrayList.add(new c17("sideway_card"));
            arrayList.add(new y07("common_card"));
            arrayList.add(new b17("live_card"));
            arrayList.add(new q07("card_multi_link"));
            arrayList.add(new l07("mount_app"));
            arrayList.add(new x07("feed_voice"));
            arrayList.add(new e17("social_bar"));
            arrayList.add(new o07("live"));
            arrayList.add(new v07("video"));
            arrayList.add(new t07("card_single_link"));
            arrayList.add(new u07("title"));
            arrayList.add(new n07("feed_head"));
            arrayList.add(new z07("delegate-layout"));
            arrayList.add(new g17("video_card"));
            arrayList.add(new m07("feed_entrybar"));
            arrayList.add(new w07("virtual_head"));
            arrayList.add(new r07("origin_card"));
            arrayList.add(new s07("pic"));
            arrayList.add(new k07("abstract"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
