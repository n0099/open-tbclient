package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedAuthorSocial;
import tbclient.FeedContentResource;
import tbclient.FeedHeadImg;
import tbclient.FeedPicAbstract;
import tbclient.FrsTopThreadComponent;
import tbclient.PicInfo;
/* loaded from: classes5.dex */
public final class e97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final r77 a(FrsTopThreadComponent frsTopThreadComponent) {
        InterceptResult invokeL;
        boolean z;
        long j;
        String valueOf;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsTopThreadComponent)) == null) {
            Intrinsics.checkNotNullParameter(frsTopThreadComponent, "<this>");
            r77 r77Var = new r77();
            HashMap<String, String> a = ea7.a.a(frsTopThreadComponent.business_info);
            String str = a.get("top_time");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = a.get("top_max_time");
            if (str3 == null) {
                str3 = "";
            }
            boolean z5 = false;
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            long j2 = 0;
            if (z) {
                if (str3.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if ((System.currentTimeMillis() / 1000) - bsb.c(str, 0L) > bsb.c(str3, 432001L)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    r77Var.k(z4);
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            List<FeedContentResource> list = frsTopThreadComponent.title;
            if (list != null) {
                y87.a(list, spannableStringBuilder, new a67(), new s47(null, null, 3, null));
            }
            r77Var.r(spannableStringBuilder);
            FeedPicAbstract feedPicAbstract = frsTopThreadComponent.pic_abstract;
            if (feedPicAbstract != null) {
                List<PicInfo> pics = feedPicAbstract.pics;
                if (pics != null) {
                    Intrinsics.checkNotNullExpressionValue(pics, "pics");
                    ArrayList arrayList = new ArrayList();
                    for (PicInfo picInfo : pics) {
                        f77 f77Var = new f77();
                        f77Var.a = picInfo.small_pic_url;
                        Integer num = picInfo.width;
                        Intrinsics.checkNotNullExpressionValue(num, "component.width");
                        f77Var.b = num.intValue();
                        Integer num2 = picInfo.height;
                        Intrinsics.checkNotNullExpressionValue(num2, "component.height");
                        f77Var.c = num2.intValue();
                        Double d = picInfo.crop_point_width_ratio;
                        Intrinsics.checkNotNullExpressionValue(d, "component.crop_point_width_ratio");
                        f77Var.e = d.doubleValue();
                        Double d2 = picInfo.crop_point_height_ratio;
                        Intrinsics.checkNotNullExpressionValue(d2, "component.crop_point_height_ratio");
                        f77Var.f = d2.doubleValue();
                        Integer num3 = picInfo.is_long_pic;
                        if (num3 != null && num3.intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        f77Var.d = z2;
                        arrayList.add(f77Var);
                    }
                    r77Var.o(arrayList);
                }
                List<FeedContentResource> _abstract = feedPicAbstract._abstract;
                if (_abstract != null) {
                    Intrinsics.checkNotNullExpressionValue(_abstract, "_abstract");
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    y87.a(_abstract, spannableStringBuilder2, new a67(), new s47(null, null, 3, null));
                    r77Var.j(spannableStringBuilder2);
                }
            }
            FeedAuthorSocial feedAuthorSocial = frsTopThreadComponent.author_social;
            if (feedAuthorSocial != null) {
                FeedHeadImg image_data = feedAuthorSocial.image_data;
                if (image_data != null) {
                    Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                    String str4 = image_data.img_url;
                    Intrinsics.checkNotNullExpressionValue(str4, "image.img_url");
                    Integer num4 = image_data.shape_type;
                    Intrinsics.checkNotNullExpressionValue(num4, "image.shape_type");
                    r77Var.m(new i57(str4, num4.intValue(), image_data.schema, image_data.pendant_url, image_data.corner_url, false, image_data.masks, 32, null));
                }
                r77Var.n(FeedHeadExtensionKt.p(feedAuthorSocial.main_data, "", new HashMap()));
                Agree agree = feedAuthorSocial.agree;
                if (agree != null) {
                    Intrinsics.checkNotNullExpressionValue(agree, "agree");
                    l77 l77Var = new l77();
                    Integer num5 = agree.agree_type;
                    Intrinsics.checkNotNullExpressionValue(num5, "agree.agree_type");
                    l77Var.e = num5.intValue();
                    Integer num6 = agree.has_agree;
                    Intrinsics.checkNotNullExpressionValue(num6, "agree.has_agree");
                    if (num6.intValue() > 0) {
                        z5 = true;
                    }
                    l77Var.f = z5;
                    l77Var.g = agree.agree_num.longValue();
                    Long l = agree.diff_agree_num;
                    Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                    l77Var.h = l.longValue();
                    Long l2 = agree.disagree_num;
                    Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                    l77Var.i = l2.longValue();
                    Integer num7 = feedAuthorSocial.share_num;
                    if (num7 != null) {
                        j = num7.intValue();
                    } else {
                        j = 0;
                    }
                    l77Var.a = j;
                    Integer num8 = feedAuthorSocial.comment_num;
                    if (num8 != null) {
                        j2 = num8.intValue();
                    }
                    l77Var.b = j2;
                    Long l3 = feedAuthorSocial.tid;
                    if (l3 != null && (valueOf = String.valueOf(l3)) != null) {
                        str2 = valueOf;
                    }
                    l77Var.c = str2;
                    Long l4 = feedAuthorSocial.fid;
                    Intrinsics.checkNotNullExpressionValue(l4, "it.fid");
                    l77Var.d = l4.longValue();
                    r77Var.q(l77Var);
                }
                String scheme = frsTopThreadComponent.scheme;
                Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
                r77Var.p(scheme);
            }
            return r77Var;
        }
        return (r77) invokeL.objValue;
    }
}
