package com.baidu.tieba;

import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.MapsKt__MapsKt;
import tbclient.FeedAuthorSocial;
import tbclient.FeedHeadImg;
import tbclient.LayoutManageInfo;
/* loaded from: classes6.dex */
public final class go7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final bj7 b(FeedAuthorSocial feedAuthorSocial, m87 m87Var) {
        InterceptResult invokeLL;
        String str;
        String str2;
        long j;
        List<h87> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, feedAuthorSocial, m87Var)) == null) {
            FeedHeadImg feedHeadImg = feedAuthorSocial.image_data;
            if (feedHeadImg != null) {
                str = feedHeadImg.img_url;
            } else {
                str = null;
            }
            FeedHeadImg feedHeadImg2 = feedAuthorSocial.image_data;
            if (feedHeadImg2 != null) {
                str2 = feedHeadImg2.schema;
            } else {
                str2 = null;
            }
            List<l67> p = FeedHeadExtensionKt.p(feedAuthorSocial.main_data, null, MapsKt__MapsKt.emptyMap());
            Integer num = feedAuthorSocial.comment_num;
            if (num != null) {
                j = num.intValue();
            } else {
                j = 0;
            }
            List<LayoutManageInfo> list2 = feedAuthorSocial.manage_list;
            if (list2 != null) {
                list = w97.b(list2);
            } else {
                list = null;
            }
            return new bj7(str, str2, p, j, m87Var, list);
        }
        return (bj7) invokeLL.objValue;
    }
}
