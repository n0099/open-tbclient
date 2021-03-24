package com.baidu.tieba.frs.videomiddlepagelight;

import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageViewModel$model$2 extends Lambda implements Function0<VideoMiddleModel> {
    public final /* synthetic */ VideoMiddlePageViewModel this$0;

    /* loaded from: classes4.dex */
    public static final class a implements VideoMiddleModel.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            VideoMiddlePageViewModel$model$2.this.this$0.k().setValue(Boolean.FALSE);
            VideoMiddlePageViewModel$model$2.this.this$0.g().setValue(str);
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<? extends BaseCardInfo> list, boolean z) {
            VideoMiddlePageViewModel$model$2.this.this$0.k().setValue(Boolean.FALSE);
            VideoMiddlePageViewModel$model$2.this.this$0.f().setValue(Boolean.valueOf(z));
            VideoMiddlePageViewModel$model$2.this.this$0.a(CollectionsKt___CollectionsKt.toMutableList((Collection) list));
            VideoMiddlePageViewModel$model$2.this.this$0.g().setValue("");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageViewModel$model$2(VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(0);
        this.this$0 = videoMiddlePageViewModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final VideoMiddleModel invoke() {
        return new VideoMiddleModel(this.this$0.i(), new a());
    }
}
