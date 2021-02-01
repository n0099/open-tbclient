package com.baidu.tieba.frs.videomiddlepagelight;

import com.baidu.tbadk.core.data.AbstractData;
import kotlin.e;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes2.dex */
final class VideoMiddlePageLightCardView$getPostContent$1 extends Lambda implements kotlin.jvm.a.b<AbstractData, String> {
    public static final VideoMiddlePageLightCardView$getPostContent$1 INSTANCE = new VideoMiddlePageLightCardView$getPostContent$1();

    VideoMiddlePageLightCardView$getPostContent$1() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(AbstractData abstractData) {
        p.o(abstractData, "abstractData");
        switch (com.baidu.tbadk.widget.richText.e.sl(abstractData.type)) {
            case 4:
            case 17:
            case 20:
                return "[表情]";
            case 8:
                return "[图片]";
            default:
                String str = abstractData.text;
                if (str == null) {
                    str = "";
                }
                return String.valueOf(str);
        }
    }
}
