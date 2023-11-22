package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
/* loaded from: classes5.dex */
public final class d97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
        if (r1.equals("recommend_post") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r1.equals("frs_post") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
        r8 = r20.a().a().get("thread_id");
        r9 = r20.a().a().get("forum_id");
        r1 = r19.dislike;
        r11 = new android.util.SparseArray();
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ae, code lost:
        if (r1.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        r7 = r1.next();
        r12 = r7.id;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "reason.id");
        r11.put(r12.intValue(), r7.reason);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c5, code lost:
        r0 = r19.dislike;
        r12 = new android.util.SparseArray();
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d4, code lost:
        if (r0.hasNext() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d6, code lost:
        r1 = r0.next();
        r7 = r1.id;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "reason.id");
        r12.put(r7.intValue(), r1.extra);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00eb, code lost:
        r13 = r20.a().a().get("weight");
        r14 = r20.a().a().get("source");
        r0 = r20.a().a().get("threadType");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x011d, code lost:
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011f, code lost:
        r16 = java.lang.Integer.parseInt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0126, code lost:
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0129, code lost:
        r7 = new com.baidu.tieba.d67(r8, r9, null, r11, r12, r13, r14, r20.a().a().get("extra"), r16, 4, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final c67 a(FeedFeedback feedFeedback, a67 feedExtraData) {
        InterceptResult invokeLL;
        e67 e67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, feedFeedback, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(feedFeedback, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String type = feedFeedback.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            String str = feedFeedback.title;
            String str2 = feedFeedback.button_text;
            String str3 = feedFeedback.common_id;
            String str4 = feedFeedback.type;
            if (str4 != null) {
                int hashCode = str4.hashCode();
                if (hashCode != -1142233928) {
                    if (hashCode != -1030597053) {
                        if (hashCode == 951024288 && str4.equals(ImageViewerConfig.FROM_CONCERN)) {
                            e67Var = new e67(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
                            Object obj = e67Var;
                            return new c67(type, str, str2, str3, obj);
                        }
                    }
                }
            }
            e67Var = null;
            Object obj2 = e67Var;
            return new c67(type, str, str2, str3, obj2);
        }
        return (c67) invokeLL.objValue;
    }
}
