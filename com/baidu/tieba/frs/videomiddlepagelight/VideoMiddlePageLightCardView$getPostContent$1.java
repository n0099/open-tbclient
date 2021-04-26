package com.baidu.tieba.frs.videomiddlepagelight;

import com.baidu.tbadk.core.data.AbstractData;
import d.a.i0.b1.m.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getAbstractContent", "", "abstractData", "Lcom/baidu/tbadk/core/data/AbstractData;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageLightCardView$getPostContent$1 extends Lambda implements Function1<AbstractData, String> {
    public static final VideoMiddlePageLightCardView$getPostContent$1 INSTANCE = new VideoMiddlePageLightCardView$getPostContent$1();

    public VideoMiddlePageLightCardView$getPostContent$1() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final String invoke(AbstractData abstractData) {
        int g2 = e.g(abstractData.type);
        if (g2 != 4) {
            if (g2 == 8) {
                return "[图片]";
            }
            if (g2 != 17 && g2 != 20) {
                String str = abstractData.text;
                if (str == null) {
                    str = "";
                }
                return String.valueOf(str);
            }
        }
        return "[表情]";
    }
}
